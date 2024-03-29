package com.arcade.batchserviceinmemory;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

// tag::setup[]
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    // end::setup[]

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<EmployeeModel> reader() {
        return new FlatFileItemReaderBuilder<EmployeeModel>()
                .name("personItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names(new String[] { "firstname", "place", "team" })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<EmployeeModel>() {
                    {
                        setTargetType(EmployeeModel.class);
                    }
                })
                .build();
    }

    @Bean
    public EmployeeItemProcessor processor() {
        return new EmployeeItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<EmployeeModel> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<EmployeeModel>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EmployeeModel>())
                .sql("INSERT INTO employee (firstname, place, team) VALUES (:firstname, :place, :team)")
                .dataSource(dataSource)
                .build();
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<EmployeeModel> writer) {
        return stepBuilderFactory.get("step1")
                .<EmployeeModel, EmployeeModel>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
    // end::jobstep[]
}