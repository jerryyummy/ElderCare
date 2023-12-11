package com.hwadee.eldercare.service.Impl;

import com.hwadee.eldercare.entity.Article;
import com.hwadee.eldercare.entity.Doctor;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.mapper.ArticleMapper;
import com.hwadee.eldercare.service.ArticleService;
import com.hwadee.eldercare.util.SpeechClient;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    String APP_ID = "25680480";
    String API_KEY = "pHyG3sdgGnrb7k8IDn5SlW7a";
    String SECRET_KEY = "hgRihp0wTAEGCVdl8MKsQilvMyXwQquq";

    @Resource
    ArticleMapper articleMapper;

    @Override
    public Article addArticle(HttpSession session, String title, String context, String abstraction, MultipartFile img) throws IOException {
        Doctor user =(Doctor)session.getAttribute("doctor");
        Article article = new Article();
        article.setTitle(title);
        article.setContext(context);
        article.setAuthorId(user.getId());
        article.setAbstraction(abstraction);
        article.setTime(new Timestamp(System.currentTimeMillis()));
        article.setAudioUrl(generateAudio(context));
        article.setImg(saveImg(img));

        articleMapper.insert(article);

        return article;
    }

    @Override
    public List<Article> getArticleList() {
        return articleMapper.selectList(null);
    }

    @Override
    public Article getArticle(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return articleMapper.selectById(id);
    }

    @Override
    public String generateAudio(String context) throws FileNotFoundException {

        SpeechClient speechClient = SpeechClient.getInstance(APP_ID,API_KEY,SECRET_KEY);

        String path = ResourceUtils.getURL("classpath:").getPath()+"static/audio";
        String realPath = path.replace('/', '\\').substring(1,path.length());



        return "/audio/" + speechClient.generateMp3(context,realPath);
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.selectById(id);
    }

    private String saveImg(MultipartFile img) throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/img/";
        String localPath = path.replace('/', '\\').substring(1,path.length());

        String name = UUID.randomUUID() + ".png";
        localPath = localPath + name;
        System.out.println(localPath);
        img.transferTo(new File(localPath));
        return "/img/"+name;
    }
}
