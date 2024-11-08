import java.util.*;

public class SplitArrayMax {
    public int[] splitArray(int[] arr) {
        Arrays.sort(arr);
        int j = arr.length-1;
        int sum_left = 0;
        int sum_right = 0;
        int[] subarr1 = new int[2];
        while(sum_right>=sum_left){
            for(int a = 0, b = arr.length - 1; a < j - 1; b--, a++){
                sum_left +=arr[a];
                sum_right +=arr[b];
            }
            j --;
        }
        subarr1[0] = j;
        subarr1[1] = j-1;

        return subarr1;
    }
        public static void main(String[] args){
        int[] arr={3,2,1,4,0,6,5};
        SplitArrayMax split = new SplitArrayMax();
        System.out.println(split.splitArray(arr));
    }
}