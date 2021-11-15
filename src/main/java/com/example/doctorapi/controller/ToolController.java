package com.example.doctorapi.controller;

import com.example.doctorapi.common.util.ControllerResponseT;
import com.example.doctorapi.dao.PhoneLog;
import com.example.doctorapi.repository.PhoneLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("tool")
public class ToolController {
    @Autowired
    private PhoneLogRepository phoneLogRepository;

    @GetMapping("phone")
    public ControllerResponseT<Object> phone(@RequestParam Long phone) {
        Date date = new Date();
        Long nowTime = date.getTime();

        PhoneLog phoneLog = new PhoneLog();
        phoneLog.setPhone(phone);
        phoneLog.setCode(6666);
        phoneLog.setStatus(1);
        phoneLog.setCreatedTime(nowTime);
        phoneLogRepository.save(phoneLog);

        return ControllerResponseT.ofSuccess("success");
    }
}
