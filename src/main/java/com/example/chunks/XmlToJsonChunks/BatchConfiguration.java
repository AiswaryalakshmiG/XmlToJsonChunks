package com.example.chunks.XmlToJsonChunks;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public Job xmlToJsonJob(JobBuilderFactory jobBuilderFactory, Step xmlToJsonStep) {
        return jobBuilderFactory.get("xmlToJsonJob")
                .start(xmlToJsonStep)
                .build();
    }
    
    @Bean
    public Step xmlToJsonStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("xmlToJsonStep")
                .<String, String>chunk(1)
                .reader(new XmlToJsonReader())
                .processor(new XmlToJsonProcessor())
                .writer(new XmlToJsonWriter())
                .build();
                
    }
}
