
import java.util.ArrayList;
import java.util.Random;
// Jared Kamp - Sec 3
public class MergeLists {

    private static Random rand;

    public static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> aList = new ArrayList();
        int length = l1.size() + l2.size();
        int i1 = 0;
        boolean maxL1 = false;
        boolean maxL2 = false;
        int i2 = 0;
        for (int i = 0; i < length; i++) {
            //Still more values in both lists?                     
            if (!maxL1 && !maxL2) {
                if (l1.get(i1) < l2.get(i2)) {
                    aList.add(l1.get(i1));
                    i1++;
                    if (i1 == l1.size()) {
                        maxL1 = true;
                    }
                } else if (l1.get(i1) > l2.get(i2)) {
                    aList.add(l2.get(i2));
                    i2++;
                    if (i2 == l2.size()) {
                        maxL2 = true;
                    }
                } else {
                    //equal
                    aList.add(l1.get(i1));
                    i1++;
                    if (i1 == l1.size()) {
                        maxL1 = true;
                    }
                    aList.add(l2.get(i2));
                    i2++;
                    if (i2 == l2.size()) {
                        maxL2 = true;
                    }
                            
                }
            } else if (!maxL1) {
                aList.add(l1.get(i1));
                i1++;
                if (i1 == l1.size()) {
                    maxL1 = true;
                }
            } else if (!maxL2) {
                aList.add(l2.get(i2));
                i2++;
                if (i2 == l2.size()) {
                    maxL2 = true;
                }
            }
        }
        return aList;
    }

    public static ArrayList<Integer> makeRandomIncreasingList(int length) {
        ArrayList<Integer> aList = new ArrayList();
        rand = new Random();
        int lastIntAdded = 1;
        for (int i = 0; i < length; i++) {
            lastIntAdded += (rand.nextInt(9) + 1);
            aList.add(lastIntAdded);
        }
        return aList;
    }

    public static void doMergeTest() {
        ArrayList<Integer> list1 = makeRandomIncreasingList(10);
        ArrayList<Integer> list2 = makeRandomIncreasingList(20);
        ArrayList<Integer> mergedList = merge(list1, list2);
        System.out.println("List 1:" + list1);
        System.out.println("List 2:" + list2);
        System.out.println("Merged list:" + mergedList);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Performing merge test #" + (i + 1) + ":");
            doMergeTest();
        }
    }
}
