package bhz.generate2;



import com.lmax.disruptor.EventHandler;

import bhz.generate1.Trade;

public class Handler2 implements EventHandler<Trade>{

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("handler2 : set price");
		event.setPrice(Math.random()*10);
		Thread.sleep(1000);
	}
	
}
