package bhz.base;

//http://ifeve.com/disruptor-getting-started/
//真正的生产对象
public class LongEvent { 
    private long value;
    public long getValue() { 
        return value; 
    } 
 
    public void setValue(long value) { 
        this.value = value; 
    } 
} 