import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //Instance variables for displaying colour
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    //private LinkedBinarySearchTree sortedBST = new LinkedBinarySearchTree();


    /**
     * Main function used to run the program, prompt the user, and initialize various data structures
     * @param args takes the users guesses
     */
    public static void main(String[] args){
        //Intro message
        System.out.println("-------------------");
        System.out.println("-Welcome To Wordle-");
        System.out.println("-------------------");
        //Reading in the file
        CSVReader reader = new CSVReader();
        FileReader input = null;
        try {
            input = new FileReader("src/5_letter_words.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String[]> myEntries = reader.read(input);
        System.out.println(myEntries.size());
        ArrayList<Word> answers = new ArrayList<Word>();
        for(String[] j: myEntries){
            Word w = new Word(j[0]);
            answers.add(w);//adding words to the list
        }
        sort(answers);//sorting the list

        int wordVal = (int) (answers.size()*Math.random());//random word to guess
        Word answer = answers.get(wordVal);
        //System.out.println(answer.toString());
        int count = 0;//counter to check 6 guesses
        //System.out.println(answers);
        ArrayList <Word> list = new ArrayList<Word>();//list for display

        LinkedBinarySearchTree searchTree = new LinkedBinarySearchTree();
        searchTree.arraylistToBST(answers);
        //Creating an arraylist of characters to display characters left
        ArrayList<Characters> remainChar = new ArrayList<>();
        for(char c = 'a'; c<='z';c++){
            Characters ch = new Characters(c);
            remainChar.add(ch);
        }


        while(count < 6){//Game loop
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Enter guess: ");
            String guess = myObj.nextLine();// Read user input
            if(isWord(guess)){//checking if it is a word
                Word guessVal = new Word(guess);
                if(!searchTree.contains(guessVal)){
                    System.out.println("Invalid word, guess again");
                    continue;
                }
            }
            else {
                System.out.println("Invalid word, guess again");
                continue;
            }
            Word guessVal = new Word(guess);
            answer.checkPosition(guessVal);//updating guess words characters type
            display(guessVal, list);//display
            //Updating remaining characters
            for (Characters ch1: guessVal.getWordArray()){
                for (Characters ch2: remainChar){
                    if(ch1.isEqual(ch2)){
                        if(ch1.getType()==0){
                            ch2.setType(0);
                        }
                        else if(ch1.getType()==1){
                            if(ch2.getType()!=2) {//if its green, we do not want it to go back to yellow
                                ch2.setType(1);
                            }
                        }
                        else{
                            ch2.setType(2);
                        }
                    }
                }
            }

            if(guessVal.getWord().toLowerCase().equals(answer.getWord().toLowerCase())){//win case
                System.out.println("Congratulations you have won!!!!");
                break;
            }
            //Printing remaining characters
            System.out.print("Remaining characters are: ");
            for(Characters ch: remainChar){
                if(ch.getType() == -1){
                    System.out.print(ch + ",");
                }
                else if(ch.getType() == 1){
                    System.out.print(ANSI_YELLOW  + ch + ANSI_RESET + ",");
                }else if(ch.getType() == 2){
                    System.out.print(ANSI_GREEN + ch + ANSI_RESET + ",");
                }
            }
            System.out.println("");
            count ++;
        }

        if(count==6){//lose case
            System.out.println("Oh no! You reached 6 guesses. You lose!");
            System.out.println("The answer was: " + answer);
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Would you like to play again (type 'y' if you do)");//checking if player wants to play again
        String guess = myObj.nextLine();
        if(guess.compareToIgnoreCase(('y'+""))==0){
            String[] s = null;
            main(s);
        }
        else{
            System.out.println("Goodbye! :)");
        }
    }

    /**
     * Display prints each letter of the word in the correct color, gray, yellow, or green
     * @param guess takes the users guess as input
     * @param list  all the guesses previously made by the user
     */
    public static void display(Word guess, ArrayList<Word> list){
        list.add(guess);
        for(Word w: list){
            Characters[] cList = w.getWordArray();
            for(int i = 0; i < 5; i ++){ //loops through the users guess
                if(cList[i].getType() == 0){ //if the given letter is of type 0, it is printed in gray
                    System.out.print(cList[i]);
                }
                else if(cList[i].getType() == 1){
                    System.out.print(ANSI_YELLOW  + cList[i] + ANSI_RESET); //if the given letter is of type 1, it is printed in yellow
                }else{
                    System.out.print(ANSI_GREEN + cList[i] + ANSI_RESET); //if the given letter is not type 0 or 1, it is printed in red
                }
            }
            System.out.println();
        }
    }

    /**
     * Used to check if the users guess is a five-letter word
     * @param word the word that the user guessed
     * @return a boolean, true if the passed word is a 5-letter word, false if not
     */
    public static boolean isWord(String word){
        word = word.toLowerCase();
        if(word.length()!=5){ //returns false if the word is not of length 5
            return false;
        }
        else{
            for(int i =0; i < 5; i++){ //loops through the word and check if each letter is between or equal to a and z
                char c = word.charAt(i);
                if(!('a'<=c && c<='z'))  {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Used to sort all possible 5-letter words that the user could guess
     * @param list the unsorted list of all possible 5-letter words
     */
    public static void sort(ArrayList<Word> list){

        int n = list.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (list.get(j).compareTo(list.get(j+1))>0) {
                    // swap arr[j+1] and arr[j]
                    Word temp = (Word) list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
    }

}
