package com.example.Client.controller;

import com.example.Client.Service.BluerService;
import com.example.Client.dto.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;


@Controller
@RequestMapping("BluerController")
public class BluerController {
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("bluerPicture")
    public String bluerPicture(@ModelAttribute Form form, Model model) {
        File[] files = BluerService.bluer(form);
        System.out.println(files[0].getAbsolutePath());
        form.setFile1(files[0].getAbsolutePath());
        form.setFile2(files[1].getAbsolutePath());
        model.addAttribute("Form", form);
        return "resultBluer";
    }

    @GetMapping("initPicture")
    public String initBluer(Model model) {
        model.addAttribute("Form", new Form());
        return "init";
    }
}
