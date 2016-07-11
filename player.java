/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ahmad
 */
public class player {
    String Name;
    scores Scoresheet;
    int Number;
    public player (int number, String name, scores scoresheet){
        
        Number = number;
        Name = name;
        Scoresheet = scoresheet;
    
    }
    
    public String getName(){
        return Name;
    }
    public scores getScores(){
        return Scoresheet;
    }
     public int getNumber(){
        return Number;
    }
    
}
