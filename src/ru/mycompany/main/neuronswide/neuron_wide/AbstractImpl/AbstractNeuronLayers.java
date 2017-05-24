package ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;
import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layersExceprions.*;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.*;


public abstract class AbstractNeuronLayers implements Layers {

    private NeuronsLayer first;
    private NeuronsLayer last;
    private int size = 0;

    @Override
    public void addLayer(NeuronsLayer neuronsLayer) throws Exception {

        if (size != 0) {
            neuronsLayer.setPreviousLayer(last);
            last.setNextLayer(neuronsLayer);
            last = neuronsLayer;
        }else {
            first = neuronsLayer;
            last = neuronsLayer;
        }

        size++;

    }

    /**
     * При добавлении уровля счетчик уровней должен увеличивться на 1
     */
    @Override
    public abstract void addLayer(int position, NeuronsLayer layer) throws IllegalAddLayerArgumentException;

    @Override
    public void deleteLevel(int index) throws Exception{

        /*при выходу индекса за границы списка уровней выбрасывается исключение  */
        if (index<0 || index > size - 1){
            throw new IllegalDeleteLayerArgumentException();
        }else {

            if(index == size){
                removeLast();
            }else if (index == 0){
                removeFirst();
            }else {
                removeCenter(index);
            }

        }
    }

    @Override
    public abstract void deleteLevel(NeuronsLayer neuronsLayer) throws DeleteLayerException ;

    @Override
    public void learningLevels(LearningSample learningSample) {
        LearningSample[] samples = {learningSample} ;
        last.learnLevel(samples);
    }

    @Override
    public Object doRecognize(Object sample ) throws HaveNotPreviousLayerException {

        return last.doRecognize(sample);
    }


    @Override
    public abstract Adapter doRecognize(Adapter adapter, Sample sample);

    private boolean removeFirst() throws Exception {

        if (size == 1 ) {
            first = null ;
            last = null ;
            size -- ;
            return true ;

        }else {
            first.getNextLayer().setPreviousLayer(null) ;
            first = first.getNextLayer() ;
            size-- ;
            return true ;
        }

    }

    private void removeLast() throws HaveNotPreviousLayerException {

        if (size == 1 ){
            first = null ;
            last = null ;
            size --;

        }else {
            last.getPreviousLayer().setNextLayer(null);
            last = first;
            size-- ;
        }

    }

    /*удаление либого элемента , кроме первого и последнего */
    private boolean removeCenter(int index) throws Exception {

        NeuronsLayer next;
        NeuronsLayer previous;

        if (size/2 >index) {
            NeuronsLayer currentElement = first;
            for (int i = 0; i < index; i++){
                currentElement  = currentElement.getNextLayer();
            }
            next = currentElement.getNextLayer();
            previous = currentElement.getPreviousLayer();
            next.setPreviousLayer(previous);
            previous.setNextLayer(next);


        }else {
            NeuronsLayer currentElement  = last ;
            for ( int i = 0; i < size-index; i++ ) {
                currentElement = currentElement.getPreviousLayer();
            }

            next = currentElement.getNextLayer();
            previous = currentElement.getPreviousLayer();
            next.setPreviousLayer(previous);
            previous.setNextLayer(next);


        }

        size-- ;
        return true;
    }

    ////////////////////геттеры и сеттеры ///////////////////////

    protected int getSize(){
        return size;
    }

    protected void setSize(int size){
        this.size = size;
    }

    public NeuronsLayer getFirst() {
        return first;
    }

    public void setFirst(NeuronsLayer first) {
        this.first = first;
    }

    public NeuronsLayer getLast() {
        return last;
    }

    public void setLast(NeuronsLayer last) {
        this.last = last;
    }
}
