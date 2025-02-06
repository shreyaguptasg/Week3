package Day2.ProblemForHashMapAndFunctions.ProblemForStackAndQueues;
class CircularTourProblem{
public static int startStation(int [] gas, int [] cost){
    int startIndex = -1;
    int currgas=0;
    int totalgas=0;
    int n = gas.length;
    for(int i=0; i<n; i++) {
        currgas += gas[i] - cost[i];
        totalgas += gas[i] - cost[i];

        if(currgas<0){
            currgas=0;
            startIndex = i+1;
        }
    }
    if(totalgas<0){
        return -1;
    }
    return startIndex;
}

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(startStation(gas, cost));
    }
}
