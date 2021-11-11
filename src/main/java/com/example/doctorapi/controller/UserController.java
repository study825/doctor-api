package com.example.doctorapi.controller;

import com.example.doctorapi.common.util.ControllerResponseT;
import com.example.doctorapi.common.util.JwtUtil;
import com.example.doctorapi.repository.UserRepository;
import com.example.doctorapi.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public ControllerResponseT<Object> login(@RequestParam Integer phone, @RequestParam String password) {
        User userData = userRepository.findByPasswordAndPhone(password, phone);
        if (userData != null) {
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.createToken(userData.getId());

            Map<String, Object> data = new HashMap<>();
            data.put("access_token", token);

            return ControllerResponseT.ofSuccess("登录成功", data);
        }

        return ControllerResponseT.ofFail(500, "登录失败");
    }

    @PostMapping("reg")
    public ControllerResponseT<Object> reg(@RequestParam Integer phone, @RequestParam String password, @RequestParam Integer code) {
        Date date = new Date();
        Long createdTime = date.getTime();

        User user = userRepository.save(new User(phone, password, createdTime));

        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.createToken(user.getId());

        Map<String, Object> data = new HashMap<>();
        data.put("access_token", token);

        return ControllerResponseT.ofSuccess("注册成功", data);
    }
}
