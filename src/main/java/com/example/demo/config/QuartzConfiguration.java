package com.example.demo.config;

import com.example.demo.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    // 同步天气频率
    private static final int TIME = 30*24*60*60;

    // JobDetail
    @Bean
    public JobDetail weatherDataDyncJobJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataDyncJob").storeDurably().build();
    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataDyncJobJobDetail()).withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }

}
