package com.example.chunks.XmlToJsonChunks;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import java.util.Date;

public class JobRunner {

    private JobLauncher jobLauncher;
    private Job job;

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void runJob() throws Exception {
        System.out.println("Scheduled job triggered at: " + new Date());
        JobParameters params = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(job, params);
    }
}

