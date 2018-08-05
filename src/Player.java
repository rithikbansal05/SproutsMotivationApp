
/**
 *
 * @author margaretconnor
 */
public class Player implements java.io.Serializable{

    private String name;
    private int ID;
    private int seed;
    private int yield;
    private Garden myGarden = new Garden();
    
    private int cycles; //the number of cycles this player has participated in;
    private int totalGiven;
    private int totalReceived;

    /**
     * When the player is constructed, they will not be able to participate
     * in the current cycle
     * 
     * @param name
     * @param ID 
     */
    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.seed = 5;
        this.yield = 0;
        this.myGarden = new Garden();
        
        this.cycles = 0;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }

    public int getID() {
        return this.ID;
    }

    public void setId(int newID) {
        this.ID = newID;
    }

    public int getSeed(){
        return this.seed; 
    }
    
    public int getYeild(){
        return this.yield; 
    }

    /*public void addSeeds(int addSeeds) {
        this.totalRecived += addSeeds;
        this.seed += addSeeds;
    }*/

    public void removeSeeds(int removeSeeds) {
        this.totalGiven += removeSeeds;
        this.seed -= removeSeeds;
    }

    /**
     * Harvests all the plants and adds the number to yield.
     */
    public void harvest() {
        this.yield += this.myGarden.harvest();
    }

    /**
     * Plants seeds in the garden when a player is gifted seeds
     * 
     * @param seedsPlanting the number of seeds to be planted
     */
    public void plantNewSeed(int seedsPlanting) {
        this.totalReceived += seedsPlanting;
        this.myGarden.plant(seedsPlanting);
    }

    /**
     * Resets the player at the end of a cycle
     *
     * @param seeds the number of seeds to give at the beginning of each cycle
     */
    public void reset(int seeds) {
        this.yield = 0;
        this.myGarden = new Garden();
        this.seed = 0;
        this.cycles ++;
    }
    
    public int avgGiven(){
        return this.totalGiven/this.cycles;
    }
    
    public int avgReceived(){
        return this.totalReceived/this.cycles;
    }

}
