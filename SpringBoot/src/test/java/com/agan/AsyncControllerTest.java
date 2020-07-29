package com.agan;

import com.agan.async.controller.AsyncController;
import com.agan.book.pojo.Book;
import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
//@WebAppConfiguration    //开启Web上下文测试

public class AsyncControllerTest {

    @Autowired
    WebApplicationContext context;  //注入WebApplicationContext

    private MockMvc mockMvc;

    /**
     * @Before 注解，表明它应该在测试方法之前执行
     * 它将WebApplicationContext注入webAppContextSetup()方法，
     * 然后调用build()产生了一个MockMvc实例
     */
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();  //设置MockMvc
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/async"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostBook() throws Exception {
        Book expectedBook = new Book();
        expectedBook.setName("name2");

        mockMvc.perform(post("/book")   //执行POST请求
            .contentType(MediaType.APPLICATION_JSON_UTF8)     //设置内容类型:JSON
            .content(JSON.toJSONString(expectedBook)))   //设置Body体
            .andExpect(status().isOk())        //期待状态码
            .andExpect(content().string("success")) //期待Content
            .andDo(MockMvcResultHandlers.print());  //打印

        System.out.println("=========");

        mockMvc.perform(get("/book"))
            .andExpect(status().isOk())
            .andExpect(content().string(JSON.toJSONString(expectedBook)))
            .andDo(MockMvcResultHandlers.print());  //打印
    }
}
