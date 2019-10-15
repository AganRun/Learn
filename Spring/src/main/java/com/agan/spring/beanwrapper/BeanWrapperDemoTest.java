package com.agan.spring.beanwrapper;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.annotation.Bean;

import java.beans.PropertyDescriptor;

/**
 * @author AganRun
 * @date 2019/10/13
 */
public class BeanWrapperDemoTest {

    @Test
    public void testGetAndSet(){
        BeanWrapper company = new BeanWrapperImpl(new Company());
        company.setPropertyValue("name", "Some Company Inc.");

        BeanWrapper employee = new BeanWrapperImpl(new Employee());
        employee.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", employee.getWrappedInstance());

        String name = (String) company.getPropertyValue("managingDirector.name");
        System.out.println(name);
    }

    @Test
    public void testClassMethods(){
        BeanWrapper company = new BeanWrapperImpl(new Company());
        //获取属性的class类：class java.lang.String
        System.out.println(company.getPropertyType("name"));
        //是否可读：true
        System.out.println(company.isReadableProperty("name"));
        //是否可读：false
        System.out.println(company.isReadableProperty("nameSelf"));
        //new一个实例：com.agan.spring.beanwrapper.Company@4cc0edeb
        System.out.println(company.getWrappedInstance());
    }

}
