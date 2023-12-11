package com.hwadee.eldercare;

import com.hwadee.eldercare.entity.Article;
import com.hwadee.eldercare.service.ArticleService;
import com.hwadee.eldercare.util.SpeechClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.net.URL;

@SpringBootTest
class ElderCareApplicationTests {

    private static String APP_ID = "25680480";
    private static String API_KEY = "pHyG3sdgGnrb7k8IDn5SlW7a";
    private static String SECRET_KEY = "hgRihp0wTAEGCVdl8MKsQilvMyXwQquq";

    @Resource
    ArticleService articleService;

    @Test
    void speechTest() throws FileNotFoundException {

        String path = articleService.generateAudio("测试内容");
        System.out.println(path);
//        String text = "测试内容";
//        String path = ResourceUtils.getURL("classpath:").getPath()+"static/audio";
//        String realPath = path.replace('/', '\\').substring(1,path.length());
//
//        SpeechClient speechClient = SpeechClient.getInstance(APP_ID,API_KEY,SECRET_KEY);
//        String file = speechClient.generateMp3(text,realPath);
//        System.out.println(file);
    }

}
