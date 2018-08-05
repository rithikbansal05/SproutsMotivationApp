
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rithik05
 */
public class AllPlayers {
    private ArrayList<Player> LeaderBoard = new ArrayList<>();
    
    private void addPlayers(){
        Player newPlayer = new Player("A",1);
        LeaderBoard.add(newPlayer);
        
    }

    public void sortBySeed(){
        int l = LeaderBoard.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(LeaderBoard.get(j).getSeed() < LeaderBoard.get(j+1).getSeed())
                    Collections.swap(LeaderBoard, j, j+1);

            }
        }
    }
    
    public void sortByYield(){
        int l = LeaderBoard.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(LeaderBoard.get(j).getYeild() < LeaderBoard.get(j+1).getYeild())
                    Collections.swap(LeaderBoard, j, j+1);

            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * pre-condition: the helper method has been decalred
     *  and works
     * 
     * post-condition: returns the index at which the target pizza
     *  is found. 
     * 
     * @return: int
     * @param: int
     */
    private int SortByYield() {
        //sortByCalories();
        int start = 0;
        int end = LeaderBoard.size()-1;
        if(LeaderBoard.get(start).getSeed() == seed) return start;
        else if (pizzaHolder.get(end).getCalories() == cals) return end;
        else
            return binSrchByCalHelper(cals,start,end);

    }
    
    /**
     * pre-condition: nothing specific. 
     * 
     * post-condition: uses recursion to find the target value
     *  using binary search
     * 
     * @return: int
     * @param: int, int , int
     */
    private int binSrchBySeed(int seed,int start, int end){
        if(start == end && pizzaHolder.get(start).getCalories() == cals) return start;
        else if(start>end) return -1;
        else{
            int mid = (start + end) /2;
            if(cals == pizzaHolder.get(mid).getCalories()) return mid;
            else if(cals > pizzaHolder.get(mid).getCalories())  
                return binSrchByCalHelper(cals,start,mid-1);
            else if(cals < pizzaHolder.get(mid).getCalories() )    
                return binSrchByCalHelper(cals,mid+1,end);

        }

        return -1;
    }
    
    
    
}
