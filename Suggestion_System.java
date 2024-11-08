class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       Arrays.sort(products);
       List<List<String>> res = new ArrayList<>(); 
        for(int i = 1; i<=searchWord.length(); i++){
             List<String> l = new ArrayList<String>();
            String prefix = searchWord.substring(0, i);
            for(String prod : products){
                if(prod.startsWith(prefix)){
                    l.add(prod);
                }
                if (l.size() == 3) {
                    break;
                }
            }
            res.add(l);
        }
        return res;
    }
}