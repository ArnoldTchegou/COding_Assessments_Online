import java.util.*;
public class Maximumgreynes{
    public static int maximumgreypixels(Vector<String> pixels){
        int sum_zeros = 0;
        int sum_ones = 0;
        int max_greyness = 0;
        for(int i=0; i<pixels.size(); i++){
            for(int k = 0; k<pixels.get(i).length(); k++){
                for(char c: pixels.get(i).toCharArray()){
                    sum_zeros += c == '0'? 1: 0;
                    sum_ones += c == '1'? 1: 0;
                }
                for(int j=0; j<pixels.size(); j++){
                    sum_zeros += pixels.get(j).charAt(k) == '0'? 1: 0;
                    sum_ones += pixels.get(j).charAt(k) == '1'? 1: 0;
                }
                max_greyness = (sum_ones - sum_zeros)>max_greyness?(sum_ones - sum_zeros): max_greyness;
                System.out.println(max_greyness);
                sum_zeros = 0;
                sum_ones = 0;
            }
        }
        return max_greyness;
    }
    public static void main(String[] args){
        Vector<String> vect = new Vector<>();
        vect.add("111");
        vect.add("001");
        vect.add("110");
        System.out.println(maximumgreypixels(vect));
    }
}