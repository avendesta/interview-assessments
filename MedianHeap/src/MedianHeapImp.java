package MedianHeap.src;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianHeapImp implements MedianHeap {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianHeapImp(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    public void add(Integer a){
        minHeap.add(a);

        if(minHeap.size()>0 && maxHeap.size()>0 && minHeap.peek()>maxHeap.peek())
            maxHeap.add(minHeap.poll());
        if(minHeap.size()>maxHeap.size()+1)
            maxHeap.add(minHeap.poll());
        if(maxHeap.size()>minHeap.size()+1)
            minHeap.add(maxHeap.poll());
    }
    public Double median(){
        if(minHeap.size() == 0 && maxHeap.size()==0) return 0.0;
        if(minHeap.size()>maxHeap.size()) return 1.0*minHeap.peek();
        if(maxHeap.size()>minHeap.size()) return 1.0*maxHeap.peek();
        return 0.5*(minHeap.peek()+maxHeap.peek());
    }

    public static void main(String[] args) {
        MedianHeap mh = new MedianHeapImp();
        mh.add(1);
        System.out.println(mh.median());
        mh.add(2);
        System.out.println(mh.median());
        mh.add(5);
        System.out.println(mh.median());
        mh.add(9);
        System.out.println(mh.median());
        mh.add(2);
        System.out.println(mh.median());
        mh.add(21);
        System.out.println(mh.median());
    }
}
