package LeetCode;

public class AdvanceCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AdvanceCP ad = new AdvanceCP();
         ProduceBuf pb = ad.new ProduceBuf();
         ConsumeBuf cb = ad.new ConsumeBuf();
         Producer p = ad.new Producer(pb);
         Transmitter t = ad.new Transmitter(pb,cb);
         Consumer c = ad.new Consumer(cb);
         Thread tp = new Thread(p);
         Thread tt = new Thread(t);
         Thread tc = new Thread(c);

            tc.start();
            tt.start();
            tp.start();
     
         
	}
	
	class ProduceBuf {
		int index = 0;
		Integer[] buffer = new Integer[12];
		
		public synchronized void produce(){
		         while(index==buffer.length){
		        	 //buffer is full
		        	try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         }
		         int newInt = (int) (Math.random()*100);
		         buffer[index] = newInt;
		         System.out.println("Producing a new object."+newInt);
		         index++;
		         this.notify();
		}
		
		public synchronized Integer pop(){
			while(index==0) {
				try{
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			index--;
			System.out.println("Transmitting a new object."+buffer[index]);
			return buffer[index];
		}
	}
	
	
	class ConsumeBuf {
		int index = 0;
		Integer[] buffer = new Integer[6];
		
		public synchronized void push(Integer newint){
		         while(index==buffer.length){
		        	 //buffer is full
		        	try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         }
		         buffer[index] = 0-newint;
		         System.out.println("Transmitted a new object."+buffer[index]);
		         index++;

		         this.notify();
		}
		
		public synchronized Integer pop(){
			while(index==0) {
				try{
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			index--;
			System.out.println("Consuming a new object."+buffer[index]);
			return buffer[index];
		}
	}
	
	class Producer extends Thread{
		ProduceBuf pb =null;
		Producer(ProduceBuf p){
			pb = p;
		}
		public void run(){
			while(true){
			pb.produce();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	
	class Transmitter extends Thread{
		ProduceBuf pb = null;
		ConsumeBuf cb = null;
		Transmitter(ProduceBuf p,ConsumeBuf c){
			pb = p;
			cb  =c;
		}
		public void run(){
			while(true){
			cb.push(pb.pop());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	
	class Consumer extends Thread{
		ConsumeBuf cb = null;
		Consumer(ConsumeBuf c){
			cb=c;
		}
		public void run(){
			while(true){
		    cb.pop();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}

}
