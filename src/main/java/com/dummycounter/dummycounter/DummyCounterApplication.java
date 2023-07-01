package com.dummycounter.dummycounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

@SpringBootApplication
public class DummyCounterApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DummyCounterApplication.class, args);
    }
}
