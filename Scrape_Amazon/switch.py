#import requests
import re
from bs4 import BeautifulSoup

# #url = "https://www.amazon.com/s?k=cisco+switch&s=exact-aware-popularity-rank&crid=20ULLQELDJASC&qid=1702591792&sprefix=cisco+switch%2Caps%2C144&ref=sr_st_exact-aware-popularity-rank&ds=v1%3A%2FCeZL8GwmP3HcIhYfhZD0wl0EgwSTOJr1Mon1I2nOdM"
# #yeader = ({'User-Agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36', Accept-Language': 'en-US, en;q=0.5'})
#response = requests.get(url, headers=yeader)
#print(response)
html_content = open("switch_web.html", 'r').read()
soup = BeautifulSoup(html_content, "html.parser")
#print(soup)
output = open("routerinfo.csv", "w")
router_titles = soup.find_all("span", class_="a-text-normal")
companies = soup.find_all("span", class_="a-size-medium a-color-base")
#router_titles = soup.find_all("img")
router_prices_whole = soup.find_all("span", class_="a-price-whole")
router_prices_partial = soup.find_all("span", class_="a-price-fraction")
print("First page information: ")
length = len(router_titles)
print(len(companies), len(router_titles))
#print(companies)
#print(router_titles)
output.write("Title,SKU,Ports,Brand,Price,"+'\n')
#print(length, len(companies))
seen = set()
for p in range(length):
    title = router_titles[p].get_text(strip=False)
    seen.add(title[:2])
    price = "$"+router_prices_whole[p].get_text(strip=True)+router_prices_partial[p].get_text(strip=True)
    if "AI" in seen:
        if title[:2] == "AI":
            company = ''
        else:
            company = companies[p-1].get_text(strip=True)
    else:
        company = companies[p].get_text(strip=True)
    # title = router_titles[p]["alt"]
    pattern = r'\b\([A-Z\-a-z\-0-9-]+\)|\b[A-Za-z0-9-]+\b'
    matches = re.findall(pattern, title)
    #matches = title.split()
    # print(company)
    l = 0
    p_cache = []
    for ind in matches:
        l += 1
        if "Port" in ind or 'POE' in ind:
            p_cache.append(ind)
            break
        p_cache.append(ind)
    if l == 1:
        ports = p_cache[0].split("-")[0]
    else:
        ports = p_cache[-2].replace("(", '')
    # print(title, company)
    skes = []
    for match in matches:
        if match == match.upper():
            skes.append(match)
    skes = [each for each in skes if len(each) >= 5]
    print(title, ports)
    if not skes:
        ske = ''
    else:
        ske = skes[-1]
    output.write("'"+title+"'"+","+ske+","+ports+","+company+","+price+","+'\n')
    # if title:
    #     print("Title:", title)
    # print(price)
    #print(company)
output.close()
    # print("Price:", "$"+router_prices_whole[p].get_text(strip=True)+router_prices_partial[p].get_text(strip=True))
    # print("----------------------------------------")
    # stuff = dummy.split(">")
    # print(stuff[1][:-6])
# # Print the information
# # for title, price in zip(router_titles, router_prices):
# #     print("Title:", title.get_text(strip=True))
# #     print("Price:", price.get_text(strip=True))
# #     print("---")

# #best_sellers = soup.select(".a-badge-text:-soup-contains('Best Seller')")
# # best_sellers = soup.select(".a-badge-text:-soup-contains('Best Seller')")

# # print(best_sellers)
# # for seller in best_sellers:
# #     product_title = seller.find_previous("span", class_="a-text-normal")
# #     if product_title:
# #         print("Best Seller:", product_title.get_text(strip=True))

# # router_titles = soup.find_all("span", class_="a-text-normal")
# # router_prices = soup.find_all("span", class_="a-offscreen")
# # for title, price in zip(router_titles, router_prices):
# #     print("Title:", title.get_text(strip=True))
# #     print("Price:", price.get_text(strip=True))
# #     print("---")
# import requests

# # URL of the webpage to save
# url_to_save = 'https://www.amazon.com'

# # Send an HTTP GET request to the URL
# response = requests.get(url_to_save)

# # Check if the request was successful (status code 200)
# if response.status_code == 200:
#     # Save the HTML content to a file
#     with open('saved_page.html', 'w', encoding='utf-8') as file:
#         file.write(response.text)
#     print(f"Webpage saved successfully as 'saved_page.html'")
# else:
#     print(f"Failed to fetch the webpage. Status code: {response.status_code}")
