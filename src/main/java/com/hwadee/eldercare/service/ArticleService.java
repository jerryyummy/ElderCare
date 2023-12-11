package com.hwadee.eldercare.service;

import com.hwadee.eldercare.entity.Article;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ArticleService {

    /**
     * 发表文章
     * @param session 用于获取当前登陆用户
     * @param title 文章标题
     * @param context 文章内容
     * @param abstraction 文章摘要
     * @return 返回发表的文章本身
     * @throws FileNotFoundException 音频生成中产生的异常
     */
    Article addArticle(HttpSession session, String title, String context, String abstraction, MultipartFile img) throws IOException;

    /**
     * 获取全部文章的列表
     * @return 文章列表
     */
    List<Article> getArticleList();

    /**
     * 获取指定的文章对象
     * @param id 文章id
     * @return 指定的文章对象
     */
    Article getArticle(int id);

    /**
     * 根据内容生成音频
     * @param context 内容字符串
     * @return 音频的地址
     */
    String generateAudio(String context) throws FileNotFoundException;

    /**
     * 根据id获取文章对象
     * @param id 文章id
     * @return 文章对象
     */
    Article getArticleById(int id);

}
