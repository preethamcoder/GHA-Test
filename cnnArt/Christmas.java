import java.util.Scanner;

public class Christmas{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height of tree: ");
        int n = sc.nextInt();
        for(int s = 1; s <= n; s++){
            for(int s2 = n-s; s2 > 0; s2--){
                System.out.print(" ");
            }
            for(int k = 1; k <= s; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}