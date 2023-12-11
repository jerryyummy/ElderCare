package com.hwadee.eldercare.controller;

import com.alibaba.fastjson.JSON;
import com.hwadee.eldercare.entity.DailyCheckForm;
import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.service.PatientInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DoctorController {

    @Resource
    PatientInfoService patientInfoService;

    @RequestMapping("/checkList")
    public String checkList(Model model){
        List<Patient> patientList = patientInfoService.getPatientList();
        model.addAttribute("checkList",patientList);
        return "doctor/checkList";
    }

    @RequestMapping("/patientDailyInfo/{id}")
    public String getDailyInfo(Model model,@PathVariable int id){
        List<DailyCheckForm> dataList = patientInfoService.getDailyCheckFromById(id);
        System.out.println(dataList);
        model.addAttribute("data",JSON.toJSONString(dataList));
        model.addAttribute("dataList", dataList);
        return "doctor/doctorDaily";
    }


}
