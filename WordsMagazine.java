class WordMagazine {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
        HashMap<String, Integer> word_counts = new HashMap<>();
        for (String word : magazine){
            word_counts.put(word, word_counts.getOrDefault(word, 0)+1);
        }
        for(String word : note){
            if(word_counts.getOrDefault(word, 0)>0){
                word_counts.put(word, word_counts.getOrDefault(word, 0)-1);
            }
            else{
                System.out.println("No");
                return;
            }
        }
              System.out.println("Yes");
    }}