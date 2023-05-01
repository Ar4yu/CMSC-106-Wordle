import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    //private LinkedBinarySearchTree sortedBST = new LinkedBinarySearchTree();

    public static void main(String[] args){
        System.out.println("-------------------");
        System.out.println("-Welcome To Wordle-");
        System.out.println("-------------------");

        CSVReader reader = new CSVReader();
        FileReader input = null;
        try {
            input = new FileReader("poll_data/5_letter_words.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String[]> myEntries = reader.read(input);
        System.out.println(myEntries.size());
        ArrayList<Word> answers = new ArrayList<Word>();
        for(String[] j: myEntries){
            Word w = new Word(j[0]);
            answers.add(w);
        }
        sort(answers);

        int wordVal = (int) (answers.size()*Math.random());
        Word answer = answers.get(wordVal);
        //System.out.println(answer.toString());
        int count = 0;
        //System.out.println(answers);
        ArrayList <Word> list = new ArrayList<Word>();

        LinkedBinarySearchTree searchTree = new LinkedBinarySearchTree();
        searchTree.arraylistToBST(answers);


        while(count < 6){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Enter guess: ");
            String guess = myObj.nextLine();// Read user input
            if(isWord(guess)){
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
            answer.checkPosition(guessVal);
            display(guessVal, list);
            if(guessVal.getWord().toLowerCase().equals(answer.getWord().toLowerCase())){
                System.out.println("Congratulations you have won!!!!");
                break;
            }
            count ++;
        }

        if(count==6){
            System.out.println("Oh no! You reached 6 guesses. You lose!");
            System.out.println("The answer was: " + answer);
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Would you like to play again (type 'y' if you do)");
        String guess = myObj.nextLine();
        if(guess.compareToIgnoreCase(('y'+""))==0){
            String[] s = null;
            main(s);
        }
        else{
            System.out.println("Goodbye! :)");
        }
    }
    public static void display(Word guess, ArrayList<Word> list){
        list.add(guess);
        for(Word w: list){
            Characters[] cList = w.getWordArray();
            for(int i = 0; i < 5; i ++){
                if(cList[i].getType() == 0){
                    System.out.print(cList[i]);
                }
                else if(cList[i].getType() == 1){
                    System.out.print(ANSI_YELLOW  + cList[i] + ANSI_RESET);
                }else{
                    System.out.print(ANSI_GREEN + cList[i] + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public static boolean isWord(String word){
        word = word.toLowerCase();
        if(word.length()!=5){
            return false;
        }
        else{
            for(int i =0; i < 5; i++){
                char c = word.charAt(i);
              if(!('a'<=c && c<='z'))  {
                  return false;
              }
            }
            return true;
        }
    }

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
