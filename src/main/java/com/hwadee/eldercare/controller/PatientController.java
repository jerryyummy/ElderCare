package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.service.PatientInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PatientController {

    @Resource
    PatientInfoService patientInfoService;

    @RequestMapping("/patientInfo")
    public String patientInfo(Model model){
        List<Patient> patientList = patientInfoService.getPatientList();
        model.addAttribute("patientList",patientList);
        return "patient/patientInfo";
    }


}
