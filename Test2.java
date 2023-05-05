import java.util.ArrayList;
public class Test2 {
    public static void main(String[] args){
        for(int i =1; i<=1000000; i*=10){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j =0; j<i;j++){
                list.add(j);
            }
            System.out.println("Sample size is: " + list.size());
            sortArrayList(list);
            LinkedBinarySearchTree searchTree = new LinkedBinarySearchTree();
            searchTree.arraylistToBST(list);
            ArrayList<Double> BST = new ArrayList<>();
            ArrayList<Double> contains = new ArrayList<>();
            for(int k =0; k < 10000; k++) {
                int random = list.get((int) ((int) (list.size() - 1) * Math.random()));
                double n1 = System.nanoTime();
                list.contains(random);
                double n2 = System.nanoTime();
                contains.add(n2 - n1);
                double m1 = System.nanoTime();
                searchTree.contains(random);
                double m2 = System.nanoTime();
                BST.add(m2 - m1);
            }

            double sum1 = 0;
            double sum2 = 0;
            for(double d: contains){
                sum1+=d;
            }
            for(double d: BST){
                sum2+=d;
            }
            double avg1 = 1.0*sum1/1000;
            double avg2 = 1.0*sum2/1000;
            System.out.println("Average time in nano seconds for contains is: " + avg1);
            System.out.println("Average time in nano seconds for BST is: " + avg2);
            System.out.println("Depth of the tree: " + searchTree.depth());
            list.clear();
        }
    }
    public static void sortArrayList(ArrayList<Integer> list){
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            int key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

}
