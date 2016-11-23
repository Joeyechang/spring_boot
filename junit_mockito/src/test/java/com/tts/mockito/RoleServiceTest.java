package com.tts.mockito;

import com.tts.entiy.Role;
import com.tts.service.RoleService;
import com.tts.service.dao.RoleDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created by mike on 2016/11/2.
 */
public class RoleServiceTest {

    @Mock
    RoleDAO roleDAO; // 模拟对象
    RoleService roleService; // 被测试类

    @Before
    public void setUp(){
        // 初始化测试用例类中由 Mockito 的注解标注所有模拟对象
        MockitoAnnotations.initMocks(this);
        // 用模拟对象创建被测类对象
//        roleService = new RoleService(roleDAO);
    }
    @Test
    public void shouldUpdateRoleTest(){
        Role role = new Role(1, "ROLE_USER");
        //设置模拟对象的返回预期值
        when(roleDAO.fetchRole(1)).thenReturn(role);
        // 执行update
//        boolean updated = roleService.update(1, "ROLE_USER_UPDATE");
//        assertTrue(updated);
        // 验证 fetchRole(1) 是否被调用
        verify(roleDAO).fetchRole(1);
        // 一个抓取器
        ArgumentCaptor<Role> captor = ArgumentCaptor.forClass(Role.class);
        // 验证模拟对象的update()是否被调用一次，并抓取调用时传入的参数值
        verify(roleDAO).update(captor.capture());
        // 获取抓取的参数
        Role updateRole = captor.getValue();
        // 验证调用update()的参数
        assertEquals("ROLE_USER_UPDATE", updateRole.getName());
        // 检查模拟对象是否还有未验证的交互
        verifyNoMoreInteractions(roleDAO);
    }

}
