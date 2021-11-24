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
            this.elements = new ArrayList<>();
            this.elements.add(null);
            this.elements.addAll(elements);
            // Ne pas modifier ces lignes

            buildHeap();
        }

        protected boolean compare(ValueType first, ValueType second){
            if(isMax){return first.compareTo(second) > 0;}
            return first.compareTo(second) < 0;
        }

        public int parentIndex(int index){
            return index/2;
        }

        public int leftChildIndex(int index){
            return 2 * index;
        }

        public int rightChildIndex(int index){
            return (2 * index) + 1;
        }

        public boolean isLeaf(int pos){
            return leftChildIndex(pos) > size();
        }

        public int lastParent(){
            return this.size()/2;
        }

        public void buildHeap(){
            for(int i = this.lastParent(); i > 0; i--){
                percolateDown(i);
            }
        }

        private void swap(int currentIndex, int parentIndex)
        {   ValueType tampon = this.elements.get(currentIndex);
            this.elements.set(currentIndex, this.elements.get(parentIndex));
            this.elements.set(parentIndex, tampon);
        }

        public void insert(ValueType value){
            this.elements.add(value);
            int index = this.size()-1;
            boolean faireComparaison = true;
            while(index != 1 && faireComparaison){
                faireComparaison = this.compare(value, this.elements.get(this.parentIndex(index)));
                if(faireComparaison){
                    this.swap(index, this.parentIndex(index));
                }
                index = this.parentIndex(index);
            }
        }

        private void percolateDown(int index){
            int child;
            ValueType temp = elements.get(index);
            for(; index * 2 < size() ; index = child){

                child = index * 2;

                if(child != size() && this.compare( this.elements.get(child + 1), this.elements.get(child) )){
                    child++;
                }

                if(this.compare(this.elements.get(child), temp)){
                    elements.set(index, elements.get(child));
                }
                else{
                    break;
                }
            }
            elements.set(index, temp);
        }

        public List<ValueType> getLeftElements(){
            List<ValueType> leftList = new ArrayList<ValueType>();
            for(int i = 1; i <= this.lastParent(); i++){
                leftList.add(this.elements.get(leftChildIndex(i)));
            }
            return leftList;
        }

        public List<ValueType> getRightElements(){
            List<ValueType> rightList = new ArrayList<ValueType>();
            for(int i = 1; i <= this.lastParent(); i++){
                rightList.add(this.elements.get(rightChildIndex(i)));
            }
            return rightList;
        }

        public List<ValueType> getParentElements(){
            List<ValueType> parentList = new ArrayList<ValueType>();
            for(int i = 1; !isLeaf(i); i++){
                parentList.add(this.elements.get(i));
            }
            return parentList;
        }

        public List<ValueType> getLeaves(){
            List<ValueType> leafList = new ArrayList<ValueType>();
            for(int i = this.size(); isLeaf(i); i--){
                leafList.add(this.elements.get(i));
            }
            return leafList;
        }

}

