package bhz.generate1;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class TradeHandler implements EventHandler<Trade>,WorkHandler<Trade>{

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		this.onEvent(event);
	}
	
	@Override
	public void onEvent(Trade event) throws Exception {
		//这里做集体的消费逻辑
		event.setId(UUID.randomUUID().toString());//简单生成ID
		System.out.println(event.getId());
	}

	

}
