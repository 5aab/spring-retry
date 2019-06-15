package com.aab.retry.rest;

import com.aab.retry.exception.UnhealthyResourceException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RetryServiceImpl implements RetryService {


    @Override
    public void testUnhealthyResourceException(){
        log.info("in testUnhealthyResourceException");
       throw new UnhealthyResourceException();
    }

    @Override
    public void testRunTimeException(){
        log.info("in testRunTimeException");
        throw new RuntimeException();
    }

    @Override
    public void testException() throws Exception{
        log.info("in testException");
        throw new Exception();
    }

}
