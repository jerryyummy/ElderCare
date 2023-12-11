package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.Doctor;
import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 账号密码登陆
     * @param model 存放登陆后的用户信息
     * @param session 存放登陆后的用户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回相应的主页
     */
    @PostMapping("/login")
    public  String login(Model model, HttpSession session, String username, String password){
        int res = loginService.accountCheck(username,password);
        String nextPath;
        System.out.println(res);
        if(res==0){
            System.out.println("账号不存在");
            model.addAttribute("error","账号不存在");
            nextPath = "login";
        }else if(res==-1){
            System.out.println("密码错误");
            model.addAttribute("error","密码错误");
            nextPath = "login";
        }else{
            User user = loginService.getUserById(res);
            nextPath = setCache(model, session, user);
        }
        return nextPath;
    }

    /**
     * 注销登陆
     * @param session 清除session中的信息
     * @return 返回登录页
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    /**
     * 人脸登陆页
     * @return 返回人脸登陆界面
     */
    @GetMapping("/login/faceCheck")
    public String faceCheck(){return "faceCheck";}

    /**
     * 脸部检测
     * @param data 需要检测的图片
     * @return 返回图中是否有人脸
     */
    @RequestMapping("/login/faceDetect")
    @ResponseBody
    public boolean faceDetect(@RequestParam("data") String data){
        return loginService.faceDetect(data);
    }

    /**
     * 脸部比对登陆
     * @param model 存放登陆后的用户信息
     * @param session 存放登陆后的用户信息
     * @param face 需要进行比对的图片
     * @return 返回相应的主页
     */
    @PostMapping("/login/faceContrast")
    @ResponseBody
    public String faceContrast(Model model, HttpSession session, String face){
        User res = loginService.faceContrast(face);
        if(res==null){
            return "\"false\"";
        }else {
            return "\""+setCache(model,session,res)+"\"";
        }
    }

    /**
     * 绑定登陆成功的用户 返回不同角色对应的页面
     * @param user 登陆成功的用户对象
     * @return 返回对应的页面
     */
    private String setCache(Model model, HttpSession session, User user) {
        String nextPath = null;

        if(user.getRole().equals("patient")){
            System.out.println("患者登陆");
            Patient patient = loginService.getPatientById(user.getId());
            model.addAttribute("patient",patient);
            session.setAttribute("patient",patient);
            nextPath = "patientIndex";
        }else if(user.getRole().equals("doctor")){
            System.out.println("医生登陆");
            Doctor doctor = loginService.getDoctorById(user.getId());
            model.addAttribute("doctor",doctor);
            session.setAttribute("doctor",doctor);
            nextPath = "doctorIndex";
        }

        model.addAttribute("user",user);
        System.out.println(user);
        session.setAttribute("user",user);

        return nextPath;
    }
}
