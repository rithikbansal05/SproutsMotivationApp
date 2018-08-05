import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class MainDriver {
    static HashMap< Integer, Player> PlayerCollections = new HashMap< Integer, Player>();
    static Player currentuser; 
    //ArrayList<Player> PlayerCollections = new ArrayList<>();
    static Collection<Player> values = PlayerCollections.values();
         
    //Creating an ArrayList of values         
    static ArrayList<Player> listOfPlayer = new ArrayList<Player>(values);

    public static void main(String[] args) {

         try {
            FileInputStream fileIn = new FileInputStream("hashmap.ser");
            ObjectInputStream oin = new ObjectInputStream(fileIn);
            PlayerCollections = (HashMap) oin.readObject();

            fileIn = new FileInputStream("currentuser.ser");
            oin = new ObjectInputStream(fileIn);
            currentuser = (Player) oin.readObject();

            oin.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Welcome New User");
            currentuser = new Player("Margaret", 123456);
            addPlayer("Margaret", 123456);
            addPlayer("John", 45689);
            addPlayer("Pranav", 123457);
            addPlayer("Conrad", 98876);
            addPlayer("Rithik", 986946);
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        for (Map.Entry<Integer, Player> entry : PlayerCollections.entrySet()) {
            System.out.println(entry.getValue().getName() + " has " + entry.getValue().getSeed() + ": " + entry.getValue().getYeild());
        }
        
        /*
        Player giver = PlayerCollections.get(123456);
        Player taker = PlayerCollections.get(98876);
        giftSeeds(giver, taker, 1);
         */

        try {
            FileOutputStream fos = new FileOutputStream("hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(PlayerCollections);

            fos = new FileOutputStream("currentuser.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(currentuser);

            oos.close();
            fos.close();
            System.out.println("Serialized HashMap data is saved in hashmap.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
    
    public static void addPlayer(String name, int id){
        Player newPlayer = new Player(name, id);
        PlayerCollections.put(id, newPlayer);     
    }
    
    private static void giftSeeds(Player giver, Player taker, int seeds){
        giver.removeSeeds(seeds);
        taker.plantNewSeed(seeds);        
        
    }
    
    public static void sortBySeed(){
        int l = listOfPlayer.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(listOfPlayer.get(j).getSeed() < listOfPlayer.get(j+1).getSeed())
                    Collections.swap(listOfPlayer, j, j+1);

            }
        }
    }
    
    public static void sortByYield(){
        int l = listOfPlayer.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(listOfPlayer.get(j).getYeild() < listOfPlayer.get(j+1).getYeild())
                    Collections.swap(listOfPlayer, j, j+1);

            }
        }
    }
    
    public static void sortByAvgReceived(){
        int l = PlayerCollections.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(listOfPlayer.get(j).avgReceived() < listOfPlayer.get(j+1).avgReceived())
                    Collections.swap(listOfPlayer, j, j+1);
            }
        }
    }
    
    public static void sortByAvgGiven(){
        int l = PlayerCollections.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(listOfPlayer.get(j).avgGiven() < listOfPlayer.get(j+1).avgGiven())
                    Collections.swap(listOfPlayer, j, j+1);
            }
        }
    }
    
    // Function to sort map by Key
    public static void sortbyPlayerID()
    {
        // TreeMap to store values of HashMap
        TreeMap<Integer, Player> sorted = new TreeMap<>(PlayerCollections);
 
        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Integer, Player> entry : sorted.entrySet()) 
            System.out.println("Key = " + entry.getKey() + 
                         ", Value = " + entry.getValue());        
    }
   
    public void resetCycle() {
        for (Map.Entry<Integer, Player> entry : PlayerCollections.entrySet()) {
            entry.getValue().reset(15);
        }
    }
}
