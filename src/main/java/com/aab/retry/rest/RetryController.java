package com.aab.retry.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@AllArgsConstructor
public class RetryController {

    private RetryServiceImpl integrationService;
    private RetryTemplate retryTemplate;

    @GetMapping("/test/unhealthy")
    @ResponseBody
    public String testUnhealthyResourceException(){

        retryTemplate.execute(arg0 -> {
            integrationService.testUnhealthyResourceException();
            return null;
        });

        return "unhealthy invoked";
    }

    @GetMapping("/test/runtime-exception")
    @ResponseBody
    public String testRuntimeException(){

        retryTemplate.execute(arg0 -> {
            integrationService.testRunTimeException();
            return null;
        });

        return "runtime invoked";
    }

    @GetMapping("/test/exception")
    @ResponseBody
    public String testException() throws Exception {

        retryTemplate.execute(arg0 -> {
            integrationService.testException();
            return null;
        });

        return "exception invoked";
    }

}
