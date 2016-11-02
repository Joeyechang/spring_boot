package com.tts.mockito;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by : phoenix
 * Create Date: 2016/11/2
 */
public class SampleTest {

    @Test
    public void firstSampleTest(){
        // build a mock object, param can be Class or Interface
        List<String> list = mock(List.class);

        // expected value
        when(list.get(0)).thenReturn("helloworld");
        String result = list.get(0);

        // verify the get method was used
        verify(list).get(0);

        // junit test
        assertEquals("helloworld", result);

        // 返回异常
        when(list.get(1)).thenThrow(new RuntimeException("out of index"));
       // list.get(1);

        // 没有返回值的方法
        doNothing().doThrow(new RuntimeException("void exception")).when(list).clear();
        list.clear();
    }


    @Test
    public void argumentMatcherTest(){
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenReturn("hello", "world");
        String str = list.get(0) + list.get(1);
        verify(list, times(2)).get(anyInt());
        assertEquals("helloworld", str);
    }

    /**
     * 如果使用参数匹配器，那么所有的参数都要使用参数匹配器，不管是stubbing还是verify的时候都一样。
     */
    @Test
    public void argumentMatcherTest2(){
        Map<Integer, String> map = mock(Map.class);
        when(map.put(anyInt(), anyString())).thenReturn("hello"); // anyString() 替换成 hello 就会报错
        String rslt = map.put(1, "world");
        verify(map).put(eq(1), eq("world")); //eq("world") 使用 "world" 也会报错
    }

    @Test
    public void verifyInvocate(){
        List<String> mockedList = mock(List.class);
        //using mock
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        /**
         * 基本的验证方法
         * verify方法验证mock对象是否有没有调用mockedList.add("once")方法
         * 不关心其是否有返回值，如果没有调用测试失败。
         */
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");//默认调用一次,times(1)可以省略
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //never()等同于time(0),一次也没有调用
        verify(mockedList, times(0)).add("never happened");

        //atLeastOnece/atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

}
