package com.hwadee.eldercare.controller;

import com.hwadee.eldercare.entity.Emergency;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.service.PatientInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
public class EmergencyController {

    @Resource
    PatientInfoService patientInfoService;

    @GetMapping("/doctorEmergency")
    public String getDoctorEmergency(Model model,HttpSession session){
        List<Emergency> emergencyList = patientInfoService.getEmergencyList();
        model.addAttribute("notices",emergencyList);
        return "doctor/doctorEmergency";
    }


    @PostMapping("/saveEmergencyForm")
    public  String saveEmergencyForm(Model model, HttpSession session, String emergencyDescription, MultipartFile file)  {
        User user = (User) session.getAttribute("user");
        Emergency emergency = new Emergency();
        try{
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/";
            File dataFile = new File(path);
            System.out.println(path);
            if (!dataFile.exists()) {
                dataFile.mkdirs();
            }
            file.transferTo(new File(dataFile, file.getOriginalFilename()));
        }catch (Exception e){
            e.printStackTrace();
        }
        emergency.setUid(user.getId());
        emergency.setDescription(emergencyDescription);
        emergency.setPath("/upload/" + file.getOriginalFilename());
        patientInfoService.insertEmergency(emergency);
        return "patientIndex";
    }

    @PostMapping("/emergencyCheck")
    @ResponseBody
    public void Check(int id){ patientInfoService.checkEmergency(id); }
}
