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

            /* TODO Ajouter une ligne de code pour construire le heap */
            buildHeap();
        }

        /* TODO Implementer le compare pour un MaxHeap et MinHeap */
        protected boolean compare(ValueType first, ValueType second){
            if(isMax){return first.compareTo(second) > 0;}
            return first.compareTo(second) < 0;
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
            for(int i = 1; i < this.size(); i++){
                percolateDown(i);
            }
        }

        /* TODO Echanger les elements qui se retrouve aux indexes currentIndex et parentIndex */
        private void swap(int currentIndex, int parentIndex)
        {   ValueType tampon = this.elements.get(currentIndex);
            this.elements.set(currentIndex, this.elements.get(parentIndex));
            this.elements.set(parentIndex, tampon);
        }

        /* TODO Ajouter un element dans le monceaux. */
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

        /* TODO Completer l'implementation des conditions de percolateDown pour un heap */
        private void percolateDown(int index){
            int child;
            ValueType temp = elements.get(index);
            for(; index * 2 < size() ; index = child){

                child = index * 2;

                if(child != size() && this.compare( this.elements.get(child + 1), this.elements.get(child) )){/* TODO Ajouter une condition pour evaluer les deux noeuds */
                    child++;
                }

                if(this.compare(this.elements.get(child), temp)){ /*TODO Ajouter une condition pour evaluer les deux noeuds */
                    elements.set(index, elements.get(child));
                }
                else{
                    break;
                }
            }
            elements.set(index, temp);
        }

        /* TODO En utilisant leftChildIndex, ajouter les elements gauche du Heap dans une liste et les retourner. */
        public List<ValueType> getLeftElements(){
            List<ValueType> leftList = new ArrayList<ValueType>();
            int exposant = 1;
            while(Math.pow(2, exposant) < this.size()){
                for(int i = (int) Math.pow(2, exposant); i < Math.pow(2, exposant) + Math.pow(2, exposant -1); i++){
                    if(i < this.size()){
                        leftList.add(this.elements.get(i));
                    }
                }
                exposant++;
            }
            return leftList;
        }

        /* TODO En utilisant rightChildIndex, ajouter les droites du Heap dans une liste et les retourner. */
        public List<ValueType> getRightElements(){
            List<ValueType> rightList = new ArrayList<ValueType>();
            int exposant = 1;
            while(Math.pow(2, exposant) + Math.pow(2, exposant -1) < this.size()){
                for(int i = (int) (Math.pow(2, exposant) + Math.pow(2, exposant -1)); i < Math.pow(2, exposant +1); i++){
                    if(i < this.size()){
                        rightList.add(this.elements.get(i));
                    }
                }
                exposant++;
            }
            return rightList;
        }

        /* TODO En utilisant parentIndex, ajouter les noeuds  parents du Heap dans une liste et les retourner. */
        public List<ValueType> getParentElements(){
            List<ValueType> parentList = new ArrayList<ValueType>();
            int index = 1;
            while(2 * index < this.size()){
                parentList.add(this.elements.get(index));
                index++;
            }
            return parentList;
        }

        /* TODO Ajouter les noeuds feuilles du monceau en utilisant isLeaf */
        public List<ValueType> getLeaves(){
            List<ValueType> leafList = new ArrayList<ValueType>();
            int index = this.size() -1;
            while(isLeaf(index)){
                leafList.add(this.elements.get(index));
                index--;
            }
            return leafList;
        }

}

