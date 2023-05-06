import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Have fun with the Binary Search Trees Lab! ");
        BinarySearchTree<Candidate> candidates = new LinkedBinarySearchTree<Candidate>();
        //Checking if commandline argument is empty
        if(args.length==0){
            throw new IllegalArgumentException("No filename inputted");
        }
        //Checking if all the arguments are valid filenames
        else {
            for (int i =0; i<args.length;i++){
                if(!args[i].contains(".csv")){
                    throw new IllegalArgumentException("Incorrect filename inputted");
                }
            }
        }
        //Reading in files
        for (int i =0; i<args.length;i++){
            String file = args[i];
            CSVReader reader = new CSVReader();
            FileReader input = new FileReader(file);
            ArrayList<String[]> myEntries = reader.read(input);
            for(String[] entry: myEntries){
                Candidate temp = new Candidate(entry[0],entry[1],Double.parseDouble(entry[2]));
                candidates.insert(temp);
            }
        }
        //Outputting file
        System.out.println(candidates);

    }
}
