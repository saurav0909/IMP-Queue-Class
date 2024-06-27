package delayqueueprogram;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedPacket implements Delayed {
	
	private final String packet;
    private final long startTime;
    
    
    public DelayedPacket(String packet, long delay) {
        this.packet = packet;
        this.startTime = System.currentTimeMillis() + delay;
    }


	@Override
	public int compareTo(Delayed o) {
		if(this.startTime < ((DelayedPacket)o).startTime)
		{
			return -1;
		}
		if(this.startTime > ((DelayedPacket )o).startTime)
		{
			return 1;
		}
		return 0;
	}


	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(startTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
	 @Override
	    public String toString() {
	        return packet;
	    }


}
