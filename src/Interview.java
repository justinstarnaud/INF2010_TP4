import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {

    //O(n^2) car on a n passage d'une fonction de complexite O(n)
    public int lastBox(int[] boxes){                        //chaque passage de la fonction est O(n)
        // Ne pas modifier la ligne suivante
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        if (boxes.length == 1){
            return boxes[0];                                //O(1) arrive une seule fois
        } else if(boxes.length == 0) {
            return 0;                                       //O(1) arrive une seule fois
        } else {
            for (int box : boxes){                          //O(n)
                heap.add(box);
            }
            int first = heap.poll();                        //O(log(n))
            int second = heap.poll();                       //O(log(n))
            if(first != second) heap.add(first - second);   //O(1)
            int[] array = new int [heap.size()];            //O(1)
            int i = 0;                                      //O(1)
            for(Integer element : heap){                    //O(n)
                array[i++] = element;
            }
            return lastBox(array);                          //O(1)
        }
    }

}


