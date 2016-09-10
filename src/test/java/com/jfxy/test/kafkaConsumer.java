package com.jfxy.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;



import kafka.consumer.Consumer;  
import kafka.consumer.ConsumerConfig;  
import kafka.consumer.ConsumerIterator;  
import kafka.consumer.KafkaStream;  
import kafka.javaapi.consumer.ConsumerConnector;  
import kafka.serializer.StringEncoder;

public class kafkaConsumer implements Runnable{
	
	private String topic;  
    
    public kafkaConsumer(String topic){  
        super();  
        this.topic = topic;  
    }  
	private ConsumerConnector createConsumer() {  
        Properties properties = new Properties();  
        //序列化类
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("zookeeper.connect", "192.168.1.168:2181");//声明zk  
        properties.put("group.id", "group1");// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
        //zk连接超时
        properties.put("zookeeper.session.timeout.ms", "4000");
        properties.put("zookeeper.sync.time.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "smallest");
        return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));  
        
     }  
	
	
    public void run() {  
        ConsumerConnector consumer = createConsumer();  
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();  
        topicCountMap.put(topic, 1); // 一次从主题中获取一个数据  
         Map<String, List<KafkaStream<byte[], byte[]>>>  messageStreams = consumer.createMessageStreams(topicCountMap);  
         KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据  
         ConsumerIterator<byte[], byte[]> iterator =  stream.iterator();  
         while(iterator.hasNext()){  
             String message = new String(iterator.next().message());  
             System.out.println("接收到: " + message);  
         }  
    }  
  
	
	 public static void main(String[] args) {  
	        new Thread(new kafkaConsumer("test")).start();// 使用kafka集群中创建好的主题 test   
	          
	    }  

}
