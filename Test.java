import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args){
        CSVReader reader = new CSVReader();
        FileReader input = null;
        try {
            input = new FileReader("poll_data/5_letter_words.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String[]> myEntries = reader.read(input);
        ArrayList<Word> answers = new ArrayList<Word>();
        for(String[] j: myEntries){
            Word w = new Word(j[0]);
            answers.add(w);
        }
        sort(answers);
        LinkedBinarySearchTree searchTree = new LinkedBinarySearchTree();
        searchTree.arraylistToBST(answers);
        ArrayList<Double> BST = new ArrayList<>();
        ArrayList<Double> contains = new ArrayList<>();
        System.out.println(answers.size());
        for(int i =0; i < 10000; i++) {
            int wordVal = (int) (answers.size() * Math.random());
            Word answer = answers.get(wordVal);
            double n1 = System.nanoTime();
            linearContains(answers,answer);
            double n2 = System.nanoTime();
            contains.add(n2-n1);
            double m1 = System.nanoTime();
            searchTree.contains(answer);
            double m2 = System.nanoTime();
            BST.add(m2-m1);
        }
        double sum1 = 0;
        double sum2 = 0;
        for(double d: contains){
            sum1+=d;
        }
        for(double d: BST){
            sum2+=d;
        }
        double avg1 = sum1/1000000;
        double avg2 = sum2/1000000;
        System.out.println("Average time in nano seconds for contains is: " + avg1);
        System.out.println("Average time in nano seconds for BST is: " + avg2);
        System.out.println(searchTree.depth());

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
    public static boolean linearContains(ArrayList<Word> list, Word w){
        for(Word check: list){
            if(w.compareTo(check) == 0){
                return true;
            }
        }
        return false;
    }


}
