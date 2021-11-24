import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {

    //Total O(n log n) + O(n log n) Donc O(n log n)
    public int lastBox(int[] boxes){
        // Ne pas modifier la ligne suivante
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        //Cette boucle est en O(n log n)
        for (int box : boxes){                                              //O(n)
            heap.add(box);                                                  //O(log(n))
        }

        //Cette boucle est en O(n log n)
        while(heap.size()!=0){//Pire cas: O(n), Meilleur cas: O(n/2) Donc     O(n)
            if(heap.size()==1)                                              //O(1)
                return heap.poll();                                         //O(log n)
            else{
                int first = heap.poll();                                    //O(log(n))
                int second = heap.poll();                                   //O(log(n))
                if(first != second) heap.add(first - second);               //O(1) + O(log n) Donc O(log n)
            }
        }
        return 0;
    }
}


