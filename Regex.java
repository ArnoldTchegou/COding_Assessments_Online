import java.util.*;
public class Regex{
    public static String replaceLastOccurrence(String original, String target, String replacement) {
        int lastIndex = original.lastIndexOf(target);
        if (lastIndex == -1) {
            return original;
        }
        String before = original.substring(0, lastIndex);
        String after = original.substring(lastIndex + target.length());
        return before + replacement + after;
    }
    public String Test_regex(String regex, String word){
        String[] rex;
        if(regex.equals(".*")){
            return "YES";
        }
        else if(regex.equals(".")){
            return word.length()==1?"YES":"NO";
        }
        else if(regex.contains(".*")||regex.contains(".")){
            rex = regex.contains(".*")? regex.split("\\.*"):regex.split("\\.");
            if(word.startsWith(rex[0])&&word.endsWith(rex[1])){
                word = word.replaceFirst(rex[0], "");
                word = replaceLastOccurrence(word, rex[1], "");
                if(regex.contains(".*")){
                    return "YES";
                }
                else if(word.length()<=1){
                    return "YES";
                }
                else{
                    return "NO";
                }
            }
            else{
                return "NO";
            }
        }
        else if(regex.contains("*")&&regex.contains("(")&&regex.contains(")")){
            String[] new_rex;
            rex = regex.split("\\*");
            new_rex = rex[0].split("\\(");
            new_rex[1] = new_rex[1].replace(")","");
            if(!new_rex[0].equals("")&&!word.startsWith(new_rex[0])){
                return "NO";
            }
            else if(!new_rex[0].equals("")&&word.startsWith(new_rex[0])){
                word = word.replaceFirst(new_rex[0], "");
            }
            while(word.length()>new_rex[1].length()){
                String part = word.substring(0, new_rex[1].length());
                if(!part.equals(new_rex[1])){
                    return "NO";
                }
                else{
                    word = word.replaceFirst(new_rex[1], "");
                }
            }
            if(rex.length>1 && word.equals(rex[1])){
                return "YES";
            }
            else if(rex.length==1 && word.equals("")){
                return "YES";
            }
            else{
                return "NO";
            }
        }
        return " ";

    }
    public static String[] solution(String regex, String[] words){
        String[] results = new String[words.length];
        Regex r = new Regex();
        for(int i=0; i<words.length;i++){
            results[i] = r.Test_regex(regex, words[i]);
        }
        return results;
    }

    public static void main(String[] args){
        String[] s = {"aa", "bababa","aaaa", "ba"};
        System.out.println(Arrays.toString(solution(".*", s)));
    }
}