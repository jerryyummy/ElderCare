package com.hwadee.eldercare.service.Impl;

import com.hwadee.eldercare.entity.Doctor;
import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.entity.User;
import com.hwadee.eldercare.mapper.DoctorMapper;
import com.hwadee.eldercare.mapper.UserMapper;
import com.hwadee.eldercare.mapper.PatientMapper;
import com.hwadee.eldercare.service.LoginService;
import com.hwadee.eldercare.util.FaceClient;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String APP_ID = "24589475";
    private static final String API_KEY = "bDMsSh3KFR3qpXv12LSbWKbv";
    private static final String SECRET_KEY = "nzV9bcdiZAha32WYwjmlS3UptOtAXuPO";

    @Resource
    UserMapper userMapper;

    @Resource
    PatientMapper patientMapper;

    @Resource
    DoctorMapper doctorMapper;

    @Override
    public boolean faceDetect(String image) {
        FaceClient faceClient = FaceClient.getInstance(APP_ID, API_KEY, SECRET_KEY);
        return faceClient.faceDetect(image);
    }

    @Override
    public User faceContrast(String face) {
        FaceClient faceClient = FaceClient.getInstance(APP_ID, API_KEY, SECRET_KEY);
        List<User> users = userMapper.selectList(null);
        for(User user:users){
            String faceUrl = user.getFaceUrl();
            if(faceClient.faceContrast(face,faceUrl)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int accountCheck(String username, String password) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_name",username);
        List<User> ps = userMapper.selectByMap(map);

        if(ps.size()==0){
            return 0;
        }
        else{
            if(password.equals(ps.get(0).getPassword())){
                return ps.get(0).getId();
            }else{
                return -1;
            }
        }
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientMapper.selectById(id);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorMapper.selectById(id);
    }
}
