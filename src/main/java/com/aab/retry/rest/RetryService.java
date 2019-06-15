package com.aab.retry.rest;

public interface RetryService {
    void testUnhealthyResourceException();

    void testUnhealthyChildResourceException();

    void testRunTimeException();

    void testException() throws Exception;
}
