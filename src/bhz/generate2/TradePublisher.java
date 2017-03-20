package bhz.generate2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import bhz.generate1.Trade;

//生产端
public class TradePublisher implements Runnable{

	Disruptor<Trade> disruptor;
	private CountDownLatch latch;
	
	private static int LOOP = 10;//模拟百万次交易的发生  
	
	public TradePublisher(Disruptor<Trade> disruptor, CountDownLatch latch) {
		this.disruptor = disruptor;
		this.latch = latch;
	}

	@Override
	public void run() {
		TradeEventTranslator tradeEventTranslator = new TradeEventTranslator();
		for (int i = 0; i < LOOP; i++) {
			disruptor.publishEvent(tradeEventTranslator);
		}
		latch.countDown();
	}

}

class TradeEventTranslator implements EventTranslator<Trade>{
	
	private Random random = new Random();
	
	@Override
	public void translateTo(Trade event, long sequence) {
		this.generateTrade(event);
	}
	
	private Trade generateTrade(Trade trade){
		trade.setPrice(random.nextDouble()*9999);
		return trade;
		
	}
}
