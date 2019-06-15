package com.aab.retry.config;

import com.aab.retry.exception.UnhealthyResourceException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;

@Configuration
@AllArgsConstructor
public class RetryTemplateConfig {

    private DefaultRetryListener retryListener;

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(2000l);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        final ExceptionClassifierRetryPolicy exRetryPolicy = new ExceptionClassifierRetryPolicy();
        exRetryPolicy.setPolicyMap(new HashMap<Class<? extends Throwable>, RetryPolicy>() {{
            put(UnhealthyResourceException.class, new SimpleRetryPolicy(3));
            //put(Exception.class, new NeverRetryPolicy());
        }});

        SimpleRetryPolicy simpleRetryPolicy=new SimpleRetryPolicy();


        retryTemplate.setRetryPolicy(exRetryPolicy);

        retryTemplate.registerListener(retryListener);
        return retryTemplate;
    }
}
