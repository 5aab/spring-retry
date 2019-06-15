package com.aab.retry.rest;

public interface RetryService {
    void testUnhealthyResourceException();

    void testRunTimeException();

    void testException() throws Exception;
}
