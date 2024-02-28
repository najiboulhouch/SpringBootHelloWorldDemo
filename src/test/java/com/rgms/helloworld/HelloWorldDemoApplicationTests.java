package com.rgms.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
 
import com.rgms.helloworld.controller.HelloWorldController;
 
@ExtendWith(MockitoExtension.class)
class ControllerTest {
 
    @InjectMocks
    private HelloWorldController controller;
 
    @Test
    void testApi() {
        String result = controller.getData();
        assertEquals("hello world", result);
    }
}