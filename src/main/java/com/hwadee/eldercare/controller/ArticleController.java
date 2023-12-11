package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.Article;
import com.hwadee.eldercare.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ArticleController {

    @Resource
    ArticleService articleService;


    /**
     * 获取文章列表信息
     * @return 返回文章列表页面
     */
    @GetMapping("/article")
    public String Article(Model model){
        List<Article> articleList = articleService.getArticleList();
        model.addAttribute("articleList",articleList);
        return "article/articleList";
    }


    /**
     * 查看文章的指定界面
     * @param model 用于存放具体文章对象
     * @param id 查询文章的文章id
     * @return 返回文章详情界面
     */
    @GetMapping("/articleDetail/{id}")
    public String getArticle(Model model, @PathVariable int id){
        Article article = articleService.getArticle(id);
        model.addAttribute("article",article);
        return "article/articleDetail";
    }

    /**
     * 进入文章发表界面
     * @return 界面
     */
    @GetMapping("/addArticle")
    public String publish(){return "article/articlePublish";}

    /**
     * 界面提交 发表文章
     * @param title 文章标题
     * @param context 文章正文
     * @param abstraction 摘要
     * @param img 文章图片
     * @return 文章界面
     * @throws IOException
     */
    @PostMapping("/addArticle")
    public String addArticle(Model model, HttpSession session, String title, String context, String abstraction, MultipartFile img) throws IOException {
        Article newArticle = articleService.addArticle(session,title,context,abstraction, img);
        model.addAttribute("article",newArticle);
        return "article/articleDetail";
    }

    /**
     * 测试用
     */
    @RequestMapping("/textAudio")
    public String text(Model model){
        Article article = articleService.getArticleById(5);
        model.addAttribute("article",article);
        return "articleDetailTest";
    }
}
