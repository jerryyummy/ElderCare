package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.DailyCheckForm;
import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.entity.RatingForm;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.mapper.RatingFormMapper;
import com.hwadee.eldercare.mapper.UserMapper;
import com.hwadee.eldercare.service.PatientInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RatingController {

    @Resource
    PatientInfoService patientInfoService;

    @GetMapping("/ratingCheck")
    public String ratingCheckHtml(Model model){
        List<RatingForm> ratingFormList = patientInfoService.getRatingFormList();
        model.addAttribute("checkList",ratingFormList);
        return "doctor/ratingCheck";
    }

    @PostMapping("/setRating")
    @ResponseBody
    public boolean setRating(int id, int level){
        patientInfoService.setRating(id,level);
        return true;
    }

    @PostMapping("/saveRatingForm")
    private String saveRatingForm(RatingForm form, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Patient patient = (Patient) session.getAttribute("patient");
        form.setUserId(user.getId());
        form.setAge(patient.getAge());
        form.setName(patient.getName());
        form.setChecked(0);
        patientInfoService.addRatingForm(form);
        return "patientIndex";
    }

    @GetMapping("/patientRating")
    private String patientRating(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        RatingForm ratingForm = (RatingForm) patientInfoService.getSingleRatingFormById(user.getId());
        System.out.println(ratingForm);
        model.addAttribute("ratingform", ratingForm);
        return "patient/ratingState";
    }

}
