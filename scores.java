/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ahmad
 */
import java.util.ArrayList;

 

public class scores {

    ArrayList<ArrayList<Integer>> rollArray = new ArrayList<ArrayList<Integer>>();

    int turns = 0;

    int max = 0;
    
    ArrayList<Integer> current_turn;

    ArrayList<Integer> last_turn;

 

    public void newFrame() throws Exception {

        if (turns >= 10) {

            throw new Exception("Too many turns!");

        } else if (turns == 0) {

            ArrayList<Integer> turn = new ArrayList<Integer>();

            rollArray.add(turn);

            current_turn = turn;

            turns++;

        } else {

            ArrayList<Integer> turn = new ArrayList<Integer>();

            rollArray.add(turn);

            current_turn = turn;

            last_turn = rollArray.get(turns - 1);

            turns++;

        }

    }

 
 public int TurnNumber() {

        if (turns == 10 && strikeCondition(9)) {

            max = turns - 1;

            return turns - 1;

        } else if (strikeCondition(turns) && strikeCondition(turns - 1)) {

            max = turns - 2;

            return turns - 2;

        } else if (strikeCondition(turns) || spareCondition(turns)) {

            max = turns - 1;

            return turns - 1;

        } else {

            max = turns;

            return turns;

        }

 

    }
    public void setScore(int score) {

        current_turn.add(score);

    }

     public int frameScore(int turn_num) {

        int frame_score = 0;

        for (int r : rollArray.get(turn_num - 1)) {

            frame_score += r;

        }

        return frame_score;

    }

    public int totalScore(int turn_num) {

        int totalScore = 0;

        for (int i = 0; i < turn_num; i++) {

            totalScore += this.frameScore(i + 1);

        }

        return totalScore;

    }
 

    public boolean spareCondition(int turn_num) {

        if (rollArray.get(turn_num - 1).get(0) + rollArray.get(turn_num - 1).get(1) == 10) {

            return true;

        } else {

            return false;

        }

 

    }
    
    public boolean strikeCondition(int turn_num) {

        if (rollArray.get(turn_num -1).get(0) == 10) {
            
            return true;

        } else {

            return false;

        }

 

        }
 

    public void scoreSum(int turn_num, int score) {

        rollArray.get(turn_num - 1).add(score);

    }

 

    

    public int getScore(int turn_num, int roll) {

        return rollArray.get(turn_num - 1).get(roll - 1);

    }

 

    public int enableScore() {

        return 10 - current_turn.get(0);
    }

 

    public void math() {

        for (int i = 1; i < TurnNumber() + 1; i++) {

             

             if (rollArray.get(i - 1).size() >= 3) {

                   

            } else if (i == 9) {

                if (strikeCondition(i)) {

                    scoreSum(i, getScore(i + 1, 1));

                    scoreSum(i, getScore(i + 1, 2));

                } else if (spareCondition(i)) {

                    scoreSum(i, getScore(i + 1, 1));

                } else {

 

                }

            } else {

                if (strikeCondition(i) && strikeCondition(i + 1)) {

                    scoreSum(i, 10);

                    scoreSum(i, getScore(i + 2, 1));
                    

                } else if (strikeCondition(i)) {
                    

                    scoreSum(i, frameScore(i + 1));

                } else if (spareCondition(i)) {

                    scoreSum(i, getScore(i + 1, 1));
                    

                } else {

 

                }

            }

        }

    } 


 
 public String Scores(){
     
     String scores = "";
     
 if (strikeCondition(1) && turns == 0) {

          

        } else if (turns == 10) {

            for (int i = 0; i < 10; i++) {

                if (this.totalScore(i + 1) >= 100) {

                    

                    scores += this.totalScore(i + 1);
                    scores += "          ";
                    

                } else if (this.totalScore(i + 1) >= 10) {

                    

                    scores += this.totalScore(i + 1);
                    scores += "          ";
                    

                } else {

                    

                    scores += this.totalScore(i + 1);
                    scores += "          ";
                    

                }

            }

        } else {

            for (int i = 0; i < this.TurnNumber(); i++) {

                if (this.totalScore(i + 1) >= 100) {

                    

                    scores += this.totalScore(i + 1);
                    scores += "          ";
                    

 

                } else if (this.totalScore(i + 1) >= 10) {

                    

                    scores += this.totalScore(i + 1);

                    scores += "          ";

                } else {

                    

                    scores += this.totalScore(i + 1);
                    scores += "          ";
                    

                }

            }

            

        }
        return scores;
 }
 
 
    public String Result() {

        String result = "  ";
 

        

        

        
 

        

        if (turns < 10) {

            for (int i = 1; i < turns + 1; i++) {
                
                if (strikeCondition(i )) {

                    result += "     X      ";
                    

                } else if (spareCondition(i)) {

                    

                    result += getScore(i, 1);

                    result += " ";

                    result += "/";
                    result += "         ";

                } else {

                    

                    result += getScore(i, 1);

                    result += "-";

                    result += getScore(i, 2);
 
                    result += "         ";

                }
                
            }

        } else {

           

            for (int i = 1; i < turns; i++) {
                
                if (strikeCondition(i)) {
                    System.out.println("Strike");
                    result += "      X     ";
                }
                
                else if (spareCondition(i)) {

                    

                    result += getScore(i, 1);

                    result += " ";

                    result += "/";
                    result += "         ";

                } else {

                    

                    result += getScore(i, 1);

                    result += "-";

                    result += getScore(i, 2);

                    result += "         ";

                }

            }

             

            if (strikeCondition(10) && getScore(10, 2) == 10 && getScore(10, 3) == 10) {                                                                                                                                   // x

                result += "X X X"; 

            } else if (strikeCondition(10) && getScore(10, 2) == 10) {

                result += "X X ";

                result += getScore(10, 3);

                

            } else if (strikeCondition(10) && getScore(10, 2) + getScore(10, 3) == 10) {                                                                                                                                           // /

                result += "X ";

                result += getScore(10, 2);

                result += " /"; 

 

            } else if (strikeCondition(10)) { 

                result += "X ";

                result += getScore(10, 2);

                result += " ";

                result += getScore(10, 3);

               

            } else if (spareCondition(10) && getScore(10, 3) == 10) {

                result += getScore(10, 1);

                result += " ";

                result += "/ X";

                ;

                result += "";

            } else if (spareCondition(10)) {

                result += getScore(10, 1);

                result += " ";

                result += "/ ";

                result += getScore(10, 3);

                result += ""; 

            } else { 

                result += " ";

                result += getScore(10, 1);

                result += " ";

                result += getScore(10, 2);

                result += " ";

            }

        }


        return result;

    }

}