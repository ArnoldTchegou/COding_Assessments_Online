import java.util.*;
import java.util.Map.Entry;
public class maximuncarinstring{
    public HashMap<Character, Integer> setOfCharacters(String str){
        HashMap<Character, Integer> Characterset = new HashMap<Character, Integer>();
         for(int i = 0; i<str.length(); i++){
            Characterset.put(str.charAt(i), 0);
        }
        return Characterset;
    }
    public Character maxoccurrence(String str){
        HashMap<Character, Integer> s =  setOfCharacters(str);
        int max = 0;
        Character maxCharacter = ' ';
        for(int i = 0; i<str.length(); i++){
            for(Entry<Character, Integer> e : s.entrySet()){
                if(e.getKey() == str.charAt(i)){
                    s.put(e.getKey(), s.getOrDefault(e.getKey(), 0) + 1);
                }
            }
        }

        for(Entry<Character, Integer> e : s.entrySet()){
            if(e.getValue() >= max){
                maxCharacter = e.getKey();
                max = e.getValue();
                System.out.println("key : "+e.getKey()+"\n");
            }
        }
        return maxCharacter;
    }

    public static void main(String[] args){
        maximuncarinstring test = new maximuncarinstring();
        System.out.println(test.maxoccurrence("geeksforgeeks"));
    }
}