package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.DailyCheckForm;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.service.PatientInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DailyController {

    @Resource
    PatientInfoService patientInfoService;

    @RequestMapping("/saveDailyCheckForm")
    public String saveDailyCheckForm(HttpSession session, DailyCheckForm dailyCheckForm){
        User user = (User)session.getAttribute("user");
        dailyCheckForm.setUid(user.getId());
        patientInfoService.addDailyCheckForm(dailyCheckForm);
        return "patient/patientDaily";
    }

    @PostMapping("/getDailyInfo")
    @ResponseBody
    public List<DailyCheckForm> getDailyInfo(int id){
        System.out.println(patientInfoService.getDailyCheckFromById(id));
        return patientInfoService.getDailyCheckFromById(id);
    }


}
