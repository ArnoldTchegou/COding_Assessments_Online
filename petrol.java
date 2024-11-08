// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentBalance = 0;
        int startIndex = 0;
	    for(int i=0; i<petrol.length; i++){
	        totalPetrol +=petrol[i];
	        totalDistance+=distance[i];
	        currentBalance += petrol[i] - distance[i];
	        if(currentBalance<0 && i<petrol.length){
	            currentBalance = 0;
	            startIndex = i+1;
	        }
	        if(totalPetrol<totalDistance){
	            return -1;
	        }
	    }
	    return startIndex;
    }
}