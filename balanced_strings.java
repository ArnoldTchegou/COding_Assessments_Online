public class balanced_strings{
    public static Boolean is_Balanced(String s){
        while(true){
            int oglength = s.length();
            s = s.replace("[]", "");
            s = s.replace("()", "");
            s = s.replace("{}", "");

            int modlength = s.length();

            if(modlength==oglength){
                break;
            }

            if(s.length() == 0){
                return true;
            }
        }
        return s.length()==0?true:false;
    }

    public static Boolean compare(String[] a, String[] b){
        Boolean result =  false;
        if(a.length!=b.length){
            result = false;
        }
        else{
            
            for(int i=0; i<=a.length-1;i++){
                if(!(a[i].equals(b[i]))){
                    result = false;
                    break;
                }
                result = true;
            }
        }
        return result;
    }
    public static void main(String args[]){
        //System.out.println(is_Balanced("{}()"));
        String[] a = {"a", "b"};
        String[] b = {"b", "a"};
        System.out.println(compare(a, b));
    }
}