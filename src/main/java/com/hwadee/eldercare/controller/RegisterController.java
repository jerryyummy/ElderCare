package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.Doctor;
import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.mapper.DoctorMapper;
import com.hwadee.eldercare.mapper.UserMapper;
import com.hwadee.eldercare.mapper.PatientMapper;
import com.hwadee.eldercare.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 测试用 用于用户的注册 生成测试数据
 */
@Controller
public class RegisterController {

    @Resource
    DoctorMapper doctorMapper;
    @Resource
    PatientMapper patientMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    LoginService loginService;

    @GetMapping("/register")
    public String register(){return "register";}

    /**
     * 注册一个医生账号
     * @param username 用户名
     * @param password 密码
     * @param faceUrl 脸部信息
     * @return 返回登陆页
     */
    @PostMapping("/register/doctor")
    public String doctorRegister(String username, String password,String faceUrl){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFaceUrl(faceUrl);
        user.setRole("doctor");
        userMapper.insert(user);
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_name",username);
        User newUser = userMapper.selectByMap(map).get(0);
        Doctor doctor = new Doctor();
        doctor.setId(newUser.getId());
        doctor.setPhoneNum("13562778163");
        doctorMapper.insert(doctor);
        return "login";
    }

    /**
     * 注册一个患者账号
     * @param username 用户名
     * @param password 密码
     * @param faceUrl 脸部信息
     * @return 返回登录页
     */
    @PostMapping("/register/patient")
    public String patientRegister(String username, String password, String faceUrl){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFaceUrl(faceUrl);
        user.setRole("patient");
        userMapper.insert(user);
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_name",username);
        User newUser = userMapper.selectByMap(map).get(0);
        Patient patient = new Patient();
        patient.setId(newUser.getId());
        patient.setAddress("四川大学江安校区");
        patient.setAge(70);
        patient.setGender(1);
        patient.setPhoneNum("14212223451");
        patientMapper.insert(patient);
        return "login";
    }

}
