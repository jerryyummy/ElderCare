package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.DailyCheckForm;
import com.hwadee.eldercare.entity.Emergency;
import com.hwadee.eldercare.entity.RatingForm;
import com.hwadee.eldercare.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String defaultPage(){
        return "login";
    }

    @RequestMapping("/patientIndex")
    public String patientMainPage(){ return "patientIndex"; }

    @RequestMapping("/doctorIndex")
    public String doctorMainPage(){ return "doctorIndex"; }

    @RequestMapping("/dailyCheck")
    public String dailyCheckHtml(){ return "patient/patientDaily"; }

    @RequestMapping("/dailyCheckForm")
    public String dailyCheckFormHtml(Model model){
        model.addAttribute("dailyCheckForm",new DailyCheckForm());
        return "patient/dailyForm";
    }

    @RequestMapping("/emergency")
    public String emergencyHtml(Model model){ return "patient/patientEmergency"; }

    @RequestMapping("/rating")
    public String ratingHtml(Model model){
        model.addAttribute("ratingForm",new RatingForm());
        return "patient/ratingForm";
    }

    @GetMapping("/doctorDaily")
    public String Daily(){return "doctor/doctorDaily";}


}
