package com.tts.mockito;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created by : phoenix
 * Create Date: 2016/11/3
 *
 * spy的意思是你可以修改某个真实对象的某些方法的行为特征，而不改变他的基本行为特征，这种策略的使用跟AOP有点类似。
 * spy 保留了list在大多数特性，只是将它的size方法改写了，不过spy在使用的时候有很多地方需要注意，一不小心就会导致问题，
 * 所以不到万不得已还是不要用spy。
 */
public class SpySampleTest {
    @Test
    public void spyTest(){
        List list = new LinkedList<>();
        List spy = spy(list);
        when(spy.size()).thenReturn(100);
        assertEquals(100, spy.size());
        verify(spy).size();

        spy.add("a");
        spy.add("b");
        System.out.println(spy.get(0));

        verify(spy).add("a");
    }

    @Test
    public void spyTrapTest(){
        List list = new LinkedList<>();
        List spy = spy(list);
        // IndexOutOfBoundsException：
//        when(spy.get(0)).thenReturn("a");
        // 可以
        doReturn("a").when(spy).get(0);
    }
}
