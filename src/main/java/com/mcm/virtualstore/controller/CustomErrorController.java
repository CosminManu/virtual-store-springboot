package com.mcm.virtualstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String errMessage = (String) request.getAttribute("jakarta.servlet.error.message");
        String reqUrl = (String) request.getAttribute("jakarta.servlet.error.request_url");

        model.addAttribute("status", statusCode);
        model.addAttribute("error", errMessage != null ? errMessage : "Unknown error");
        model.addAttribute("path", reqUrl);

        return "error";
    }
}
