import java.util.Arrays;
public class Insertion_Sort{
    public static void main(String[] args){
        int[] arr = new int[] {3, 5, 15, 6, 2, 4, 62, 3, 7};
        // Dsplay elements in array
        int length = arr.length;
        for (int ind = 0; ind < length; ind++){
            System.out.println(arr[ind]);
        }
        int[] res = ins_sort(arr);
        System.out.println(Arrays.toString(res));
    }
    public static void ins_sort(int[] array){
            int len = array.length;
            for (int ind = 1; ind < len; ind++){
                int curr = array[ind];
                int mv = ind;
                while (mv > 0 && array[mv] >= curr){
                    array[mv] = array[mv-1];
                    mv--;
                }
                array[mv] = curr;
            }
            for (int tmp = 0; tmp < array.length; tmp++){
                System.out.println(array[tmp]);
            }
            return arr;
        }
}