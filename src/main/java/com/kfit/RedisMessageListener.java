package com.kfit;

//import com.mysql.cj.protocol.MessageListener;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author ：youq
 * @date ：Created in 2019/2/17 18:06
 * @modified By：
 */
@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern){
        byte[] body = message.getBody();
        String strMsg = new String(body);
        String topic = new String(pattern);
        System.out.println(strMsg);
    }
}
