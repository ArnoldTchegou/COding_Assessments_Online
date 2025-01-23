import java.util.*;
public class Closestdelivery{
    public ArrayList<Integer[]> solution(ArrayList<Integer[]>allocations, int numDeliveries){
        //array to store result
        ArrayList<Integer[]> result = new ArrayList<>();
        //Array to store sorted points wrt distance
        ArrayList<Integer[]> sortedMap = new ArrayList<>();
        //map of distances and points
        Map<Integer[], Double> distance = new HashMap<>();
        //list containning sorted distances
        ArrayList<Double> list = new ArrayList<>();

        //calculating map
        for(int i = 0; i<allocations.size(); i++){
            Integer[] ele = allocations.get(i);
            distance.put(allocations.get(i), Math.sqrt(Math.pow(ele[0], 2) + Math.pow(ele[1], 2)));
        }

        //sorting distances
        for (Map.Entry<Integer[], Double> entry : distance.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list); 

        //sorting map
        for (Double num : list) {
            for (Map.Entry<Integer[], Double> entry : distance.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.add(entry.getKey());
                }
            }
        }

        //fetching X closest distances
        for(int j = 0; j<numDeliveries; j++){
            result.add(sortedMap.get(j));
        }
        return result;
    }
    public static void main(String[] args){
        Closestdelivery c = new Closestdelivery();
        ArrayList<Integer[]>allocations = new ArrayList<>();
        allocations.add(new Integer[] {1, 2});
        allocations.add(new Integer[] {3, 4});
        allocations.add(new Integer[] {1, -1});
        int numDeliveries = 1;
        ArrayList<Integer[]> closestDeliveries = c.solution(allocations, numDeliveries);
        for (Integer[] delivery : closestDeliveries) {
            System.out.println(Arrays.toString(delivery));
        }
    }
}