package com.kfit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @author ：youq
 * @date ：Created in 2019/2/17 17:54
 * @modified By：
 */
@Component
public class ThreadPoolTask {

    private ThreadPoolTaskScheduler taskScheduler;

    //创建任务池，运行线程等待处理redis的消息
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if (taskScheduler != null){
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }
    @Autowired
    private RedisConnectionFactory conn;
    @Autowired
    private MessageListener messageListener;

    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
       //redis连接池
        container.setConnectionFactory(conn);
        //线程池
        container.setTaskExecutor(initTaskScheduler());
        //渠道
        Topic topic = new ChannelTopic("topic");
        //添加消息监听器和渠道
        container.addMessageListener(messageListener,topic);
        return container;
    }
}
