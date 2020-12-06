package com.example.Client.controller;

import com.example.Client.Service.HelperService;
import com.example.Client.dto.Form;
import com.example.Client.dto.MatrixDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;

@Controller
public class ClientController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final HelperService helperService = new HelperService();

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String matrixForm(Model model) {
        model.addAttribute("Form", new Form());
        model.addAttribute("matrixDto", new MatrixDto());
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String matrixSubmit(@ModelAttribute Form form, Model model) {
        MatrixDto[] dtos = {helperService.loadMatrix(form.getFile1()), helperService.loadMatrix(form.getFile2())};
        if(dtos[0].getColumns()==dtos[1].getColumns()&&dtos[0].getRows()==dtos[1].getRows()) {
            System.out.println(Arrays.toString(dtos));
            MatrixDto matrixDto = restTemplate.postForObject("http://localhost:8081/MatrixController/addition", dtos, MatrixDto.class);
            model.addAttribute("matrixDto", matrixDto);
            return "result";
        }
        return this.matrixForm(model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMatrix(@ModelAttribute MatrixDto matrixDto, Model model) {
        helperService.saveMatrix((MatrixDto) model.getAttribute("matrixDto"));
        return this.matrixForm(model);
    }
}
