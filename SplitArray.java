import java.util.*;

public class SplitArray {
    public int splitArray(int[] arr) {
    
        int i=0;
        int j=1;
        int nb_splits=0;
        int occ = 0;
        while(j>0 && i<arr.length - 1){
            int sum_left=0;
            int sum_right=0;
            for(int a=0; a<=i;a++)
                sum_left+=arr[a];
            for (int b=arr.length-1;b>=j;b--){
                sum_right+=arr[b];
            }
            
            if(sum_left>=sum_right){
                occ++;
            }
            i++;
            j++;
        }
        return occ;
    }
    public static void main(String[] args){
        int[] arr={2,3,1,0};
        SplitArray split = new SplitArray();
        System.out.println(split.splitArray(arr));
    }
}