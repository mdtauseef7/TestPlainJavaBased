package com.practic.exception;

public interface ExceptionTest {
    void make() throws Exception;
}


class ConcreateClass implements ExceptionTest{

    @Override
    public void make() throws NullPointerException{

    }
}
