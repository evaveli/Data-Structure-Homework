package HomeWork;

import java.util.ArrayDeque;

public class EvaVeliSolution3 {
	
	public static void main(String[] args) {
		
	        StreamSTD streamSTD = new StreamSTD(3);
	        
	        int[] stream = {3, 10, 20, 3, 5, 6};
	       
	        for (int number : stream)
	            System.out.println(streamSTD.next(number));
	    }
	}

	class StreamSTD {
	    private final ArrayDeque<Integer> queue;
	    private final int window;

	    public StreamSTD(int window) {
	        this.queue = new ArrayDeque<>(window);
	        this.window = window;
	    }

	    public double next(int value) {

	        if (queue.size() == window) {
	        	
	            queue.removeFirst();
	        }

	        queue.add(value);

	        return standartDeviation();
	    }

	    private double standartDeviation() {
	        double arithmeticM = 0;
	        int sz = queue.size();
	        double sum = 0.0;
	        
	        
	        for(int i=0; i<queue.size(); i++){
	            int data = queue.removeFirst();
	            arithmeticM += data;
	            queue.addLast(data);	
	        }
	       
	        arithmeticM /= sz;     
	        
	        		

	        for (int i = 0; i < sz ; i++) {
	        	
	            int v = queue.removeFirst();
	            
	            sum += Math.pow((v - arithmeticM), 2);
	            
	            queue.addLast(v);
	        }

	        return Math.sqrt(sum / sz);
	    }


}
