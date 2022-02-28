package com.codingmore;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codingmore.mapper.UsersMapper;
import com.codingmore.service.IOssService;
import com.codingmore.service.IUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.core.io.file.FileReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
//     http://cdn.tobebetterjavaer.com/
// https://cdn.tobebetterjavaer.com/
//https://cdn.tobebetterjavaer.com/codingmore/images/20220226/0fb602cc-13dd-4380-a08b-f80a6bf1ac37.jpg

    @Autowired
    private UsersMapper userMapper;
    @Autowired
    private IUsersService iUsersService;
    private static Logger LOGGER = LoggerFactory.getLogger(SampleTest.class);
    @Autowired
    private IOssService iOssService;
    
    @Test
    public void testSelect() {
       String path =  iOssService.upload("https://pic1.zhimg.com/80/v2-5a6681d8b77b8f17a517f2858ea0bcd8_400x224.jpg?234324");
       System.out.print(path);
    }
    @Test
    public void testInsert() {
        FileReader fileReader = FileReader.create(new File("D://能耗软件规划.md"),
        Charset.forName("utf-8"));
        List<String> list = fileReader.readLines();
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(item->{
            stringBuilder.append(item);
        });


        String content = stringBuilder.toString();
        // System.out.println(content);
        String pattern="!\\[[^\\]]+\\]\\([^)]+\\)";

        // StringBuffer operatorStr=new StringBuffer(content);
        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);
        while(m.find()) {
            //使用分组进行替换
            LOGGER.info("{}", m.group());
            // operatorStr.replace(m.start(2),m.end(2),"/");
            // m = p.matcher(operatorStr);
        }
        // return operatorStr.toString();
    }
}
