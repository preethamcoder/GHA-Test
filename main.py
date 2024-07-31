# print("Hi")
# print("Hi "*10)
def edit_distance(w1, w2):
    cols = len(w1)
    rows = len(w2)
    cache = [[0 for ind in range(cols+1)] for _ in range(rows+1)]
    cache[0] = [each for each in range(cols+1)]
    for ind in range(1, rows+1):
        cache[ind][0] = 1+cache[ind-1][0]
    for ind in range(1, cols+1):
        for oth in range(1, rows+1):
            if w1[ind-1] != w2[oth-1]:
                cache[oth][ind] = 1 + min(cache[oth-1][ind-1], cache[oth-1][ind], cache[oth][ind-1])
            else:
                cache[oth][ind] = cache[oth-1][ind-1]
    print(cache)
    return cache[-1][-1]

if __name__ == '__main__':
    res = edit_distance("eman", "seman")
    print(res)