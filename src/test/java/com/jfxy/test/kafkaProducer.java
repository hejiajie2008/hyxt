package com.jfxy.test;
import java.util.Properties;  
import java.util.concurrent.TimeUnit;  
  
import kafka.javaapi.producer.Producer;  
import kafka.producer.KeyedMessage;  
import kafka.producer.ProducerConfig;  
import kafka.serializer.StringEncoder;  
public class kafkaProducer implements Runnable{
	private String topic;  
    
    public kafkaProducer(String topic){  
        super();  
        this.topic = topic;  
    }  
      
      
  
    public void run() {  
        Producer<Integer, String> producer = createProducer();  
        int i=0;  
        while(true){  
        	String message="message: " + i++;
            producer.send(new KeyedMessage<Integer, String>(topic, message)); 
            System.out.println("發送："+message);
            try {  
                TimeUnit.SECONDS.sleep(1);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    private Producer<Integer, String> createProducer() {  
        Properties properties = new Properties();  
        properties.put("zookeeper.connect", "192.168.1.168:2181");//声明zk  
        properties.put("serializer.class", StringEncoder.class.getName());  
        properties.put("metadata.broker.list", "192.168.1.168:9092");// 声明kafka broker  
        return new Producer<Integer, String>(new ProducerConfig(properties));  
     }  
      
      
    public static void main(String[] args) {  
       new Thread( new kafkaProducer("test")).start();// 使用kafka集群中创建好的主题 test   
          
    }  

}
