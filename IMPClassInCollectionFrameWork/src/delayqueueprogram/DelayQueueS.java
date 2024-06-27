package delayqueueprogram;

import java.util.concurrent.DelayQueue;

public class DelayQueueS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DelayQueue<DelayedPacket> packetQueue = new DelayQueue<>();
		
		packetQueue.add(new DelayedPacket("Packet 1", 4000));
		packetQueue.add(new DelayedPacket("Packet 2", 7000));
		packetQueue.add(new DelayedPacket("Packet 3", 2000));
		
		while(! packetQueue.isEmpty())
		{
			try
			{
				DelayedPacket packet = packetQueue.take();
				System.out.println("Sending " + packet);
				
			}catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
				
			}
		}
		

	}

}
