import java.util.*;

public class Heap<ValueType extends Comparable<? super ValueType>> implements Iterable<ValueType> {

        public ArrayList<ValueType> elements;
        private final boolean isMax;

        public int size(){
            return elements.size() - 1;
        }

        @Override
        public Iterator<ValueType> iterator() {
            return elements.listIterator(1);
        }

        public Heap(boolean isMax, Collection<ValueType> elements){
            // Ne pas modifier ces lignes
            this.isMax = isMax;
            this.elements = new ArrayList<>(elements);
            this.elements.add(null);
            this.elements.addAll(elements);
            // Ne pas modifier ces lignes

            /* TODO Ajouter une ligne de code pour construire le heap */
            buildHeap();
        }

        /* TODO Implementer le compare pour un MaxHeap et MinHeap */
        protected boolean compare(ValueType first, ValueType second){
            return first.compareTo(second) > 0  ? true : false;
        }

        /* TODO Retourner l'index du parent */
        public int parentIndex(int index){
            return index/2;
        }

        /* TODO Retourner l'enfant gauche du noeud */
        public int leftChildIndex(int index){
            return 2 * index;
        }

        /* TODO Retourner l'enfant droit du noeud */
        public int rightChildIndex(int index){
            return (2 * index) + 1;
        }

        /* TODO Retourner si l'index present est une feuille */
        public boolean isLeaf(int pos){
            return leftChildIndex(pos) > size();
        }

        /* TODO Constuire le monceau avec les noeuds dans "elements" */
        public void buildHeap(){
            
        }

        /* TODO Echanger les elements qui se retrouve aux indexes currentIndex et parentIndex */
        private void swap(int currentIndex, int parentIndex)
        {   ArrayList[currentIndex] = parentIndex;
            ArrayList[parentIndex] = currentIndex;
        }

        /* TODO Ajouter un element dans le monceaux. */
        public void insert(ValueType value){
            //Prit des ndc il faut ajouter plus car ne suit pas la logique
            //int currentSize = array.size();
            //if (currentSize == array.lenth -1){enlargeArray(array.lenth * 2 + 1)};
        }

        /* TODO Completer l'implementation des conditions de percolateDown pour un heap */
        private void percolateDown(int index){
            int child;
            ValueType temp = elements.get(index);
            for(; index * 2 < size() / 2; index = child){

                child = index * 2;

                if(child != size() && array[child + 1 ].compareTo(array[child]) < 0){/* TODO Ajouter une condition pour evaluer les deux noeuds */) {
                    child++;
                }

                if(true && array[child].compareTo(temp) < 0){/*TODO Ajouter une condition pour evaluer les deux noeuds */){
                    elements.set(index, elements.get(child));
                }
                else
                    break;
            }
            elements.set(index, temp);
        }

        /* TODO En utilisant leftChildIndex, ajouter les elements gauche du Heap dans une liste et les retourner. */
        public List<ValueType> getLeftElements(){
            return new ArrayList<Integer>(heap.add(leftChildIndex));
        }

        /* TODO En utilisant rightChildIndex, ajouter les droites du Heap dans une liste et les retourner. */
        public List<ValueType> getRightElements(){
            return new ArrayList<Integer>(heap.add(rightChildIndex));
        }

        /* TODO En utilisant parentIndex, ajouter les noeuds  parents du Heap dans une liste et les retourner. */
        public List<ValueType> getParentElements(){
            return  new ArrayList<Integer>(heap.add(parentIndex));
        }

        /* TODO Ajouter les noeuds feuilles du monceau en utilisant isLeaf */
        public List<ValueType> getLeaves(){
            return new ArrayList<>(heap.isLeaf()); //comprend pas comment get le/les derniers elements dans les branches de l'arbre
        }

}

