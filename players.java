
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ahmad
 */
public class players {
    ArrayList<String> names = new ArrayList<String>();
    
    public void setPlayer(final ArrayList<String> names){
        this.names=names;
    }
    
     public ArrayList<String> getPlayer(ArrayList<String> names){
        return names;
    }
}
