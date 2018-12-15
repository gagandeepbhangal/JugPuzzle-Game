package ca.utoronto.utm.assignment1.q1;
import java.io.*;
import java.util.*;
/**
 * @author Gagandeep Bhangal
 * This class allows a console user to play an instance of JugPuzzle.
 */
public class JugPuzzleController {
		
		/**
		 * Create a reference to JugPuzzle, a scanner, as we all as a String error message for
		 * an invalid value for jug
		 */
        private static final String INVALID_INPUT_MESSAGE="Invalid number, please enter 0,1 or 2";

        private Scanner scanner;
        private JugPuzzle jugPuzzle;

        /**
         * Constructs a new JugPuzzleController with a new JugPuzzle, 
         * ready to play with a user at the console.
         */
        public JugPuzzleController(){
                jugPuzzle=new JugPuzzle();
                scanner=new Scanner(System.in);
        }

        /**
         * Create a getMove method which outputs the given message (which describes an action) 
         * and checks if the move entered by the user is valid. It is valid when the integer 
         * value of the string entered is between the lower and upper bound inclusive. If the 
         * move value is valid, return it, otherwise output an error message and have the user 
         * enter another move.
         * @param message is the String message you will print out to the user
         * @param lower is the Smallest integer number representing the jug you are pouring from
         * @param upper is the Largest integer number representing the jug you are pouring from
         * @return the valid move number the user entered that is between (inclusive) lower and upper
         */
        private int getMove(String message, int lower, int upper){
                int move;
                while(true){
                        try {
                                System.out.print(message);
                                String line=scanner.nextLine();
                                move=Integer.parseInt(line);
                                if(lower<=move && move<=upper){
                                        return move;
                                } else {
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                }
                        }
                        catch(NumberFormatException e){
                                System.out.println(INVALID_INPUT_MESSAGE);
                        }
                }
        }
        /**
         * Create a method which outputs the current state of the JugPuzzle, carries out the
         * users entered move and loops until the winning condition is met. After it is met,
         * output the correct Victory message.
         */
        public void play(){
                while(!jugPuzzle.isPuzzleSolved()){
                        System.out.println(jugPuzzle); // called the toString() method of jugPuzzle
                        int from, to;
                        from = getMove("spill from jug: ", 0,2);
                        to   = getMove("into jug: ",0,2);
                        jugPuzzle.move(from,to);
                }
                if(jugPuzzle.getMoves()==1) {
                    System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" move!!");
                } else {
                	System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" moves!!");
                }
        }

        public static void main(String [] args){
                JugPuzzleController jpcc=new JugPuzzleController();
                jpcc.play();
        }
}
