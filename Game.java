import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args){
        System.out.println("-------------------");
        System.out.println("-Welcome To Wordle-");
        System.out.println("-------------------");

        CSVReader reader = new CSVReader();
        FileReader input = null;
        try {
            input = new FileReader("poll_data/TestWord.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String[]> myEntries = reader.read(input);
        ArrayList<Word> answers = new ArrayList<Word>();
        for(String[] j: myEntries){
            Word w = new Word(j[0]);
            answers.add(w);
        }
        int wordVal = (int) (answers.size()*Math.random());
        Word answer = answers.get(wordVal);
        //System.out.println(answer.toString());
        int count = 0;
        ArrayList<Word> list = new ArrayList<Word>();
        while(count < 6){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Enter guess: ");
            String guess = myObj.nextLine();  // Read user input
            Word guessVal = new Word(guess);
            answer.checkPosition(guessVal);
            display(guessVal, list);
            if(guessVal.getWord().toLowerCase().equals(answer.getWord().toLowerCase())){
                System.out.println("Congratulations you have won!!!!");
                break;
            }
            count ++;
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
}
