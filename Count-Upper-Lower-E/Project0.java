import javax.swing.*;

public class Project0 {
    
    public static void main(String[] args){
        
        String inputWord;

        // keeps track of the number of lowercase e's
        int lowerCase = 0;

        //keep track of the number of uppercase e's
        int upperCase = 0;

        while (true) {
            //This line asks the user for input by popping out a single window
            //with text input
            inputWord=JOptionPane.showInputDialog(null,"Please enter a sentence.");

            //End or exit program if user types "stop" case insensitive
            if (inputWord.equalsIgnoreCase("stop"))
                System.exit(0);

            // Reset counters for new input so each new sentence counter starts from 0
            lowerCase = 0;
            upperCase = 0;

            //Main Function to determine how many upper and lower case Es (using charAt)
            //Iterate through the string inputWord one character at time using charAt() memberfunction
            //if the character at location i is either an E or an e, update the appropriate counter by one.
            for(int i = 0; i < inputWord.length(); i++){
                char c = inputWord.charAt(i);
                if (c == 'e') {
                    lowerCase++;
                } else if (c == 'E') {
                    upperCase++;
                }
            }
            //Output to a JoptionPane window whether how many upper and lower case Es are typed in the sentence.
            JOptionPane.showMessageDialog(null,"The number of lowercase e's:" + lowerCase + "\n" + "The number of uppercase e's:" + upperCase);
        }
    } //main 
    
} // class Project0
