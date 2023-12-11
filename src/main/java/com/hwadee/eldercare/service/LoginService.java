package com.hwadee.eldercare.service;

import com.hwadee.eldercare.entity.Doctor;
import com.hwadee.eldercare.entity.Patient;
import com.hwadee.eldercare.entity.User;

public interface LoginService {

    /**
     * 检测图片中是否包含人脸
     * @param image 待检测的图片
     * @return 布尔值
     */
    boolean faceDetect(String image);

    /**
     * 检测已注册用户中是否有相似的人脸
     * @param face 人脸图片
     * @return 人脸对应的User或NULL(没找到)
     */
    User faceContrast(String face);

    /**
     * 对账号密码登陆进行检测
     * @param username 用户名
     * @param password 密码
     * @return 0 账号不存在；-1 密码错误；其他数字 用户的Id号
     */
    int accountCheck(String username, String password);

    /**
     * 通过id号查询用户对象
     * @param id id号
     * @return 用户对象
     */
    User getUserById(int id);

    /**
     * 通过id号查询患者对象
     * @param id id号
     * @return 患者对象
     */
    Patient getPatientById(int id);

    /**
     * 通过id号查询医生对象
     * @param id id号
     * @return 医生对象
     */
    Doctor getDoctorById(int id);
}
