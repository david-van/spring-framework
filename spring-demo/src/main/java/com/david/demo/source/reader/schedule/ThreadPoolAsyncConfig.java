//package com.david.demo.source.reader.schedule;
//
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurer;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * 线程池的配置
// *
// * @author fanzunying
// * @date 2019/10/16 17:07
// */
//@Configuration
//@EnableAsync
//public class ThreadPoolAsyncConfig implements AsyncConfigurer {
//    /**
//     * 核心线程数（默认线程数）
//     */
//    private static final int CORE_POOL_SIZE = 20;
//    /**
//     * 最大线程数
//     */
//    private static final int MAX_POOL_SIZE = 20;
//    /**
//     * 允许线程空闲时间（单位：默认为秒）
//     */
//    private static final int KEEP_ALIVE_TIME = 10;
//    /**
//     * 缓冲队列数
//     */
//    private static final int QUEUE_CAPACITY = 20000;
//    /**
//     * 线程池名前缀
//     */
//    private static final String THREAD_NAME_PREFIX = "my-async-";
//
//    @Override
////    @Bean("getAsyncExecutor")
//    public ThreadPoolTaskExecutor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(CORE_POOL_SIZE);
//        executor.setMaxPoolSize(MAX_POOL_SIZE);
//        executor.setQueueCapacity(QUEUE_CAPACITY);
//        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
//        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
//
//        // 线程池对拒绝任务的处理策略
//        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        // 初始化 注入bean之后不需要初始化
//        executor.initialize();
//        return executor;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return null;
//    }
//}
