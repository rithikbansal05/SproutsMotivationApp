/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author margaretconnor
 */
public class Garden implements java.io.Serializable{
    private int growingSeeds;
    
    public Garden(){ 
        this.growingSeeds = 0;
    }
    
    public void plant(int plantingSeeds){
        growingSeeds += plantingSeeds;
    }
    
    public int harvest(){
        int harvestable = this.growingSeeds;
        this.growingSeeds = 0; 
        return harvestable; 
    }
    
    public int getGrowingSeeds(){
        return this.growingSeeds; 
    }
}
