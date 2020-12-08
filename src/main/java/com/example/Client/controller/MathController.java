package com.example.Client.controller;

import com.example.Client.Service.MathService;
import com.example.Client.dto.DoubleResponse;
import com.example.Client.dto.FormMath;
import com.example.Client.dto.enums.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;


@Controller
public class MathController {

    private MathService mathService;
    private Operation operation;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String matrixForm(Model model) {
        model.addAttribute("FormMath", new FormMath());
        model.addAttribute("DoubleResponse", new DoubleResponse());
        model.addAttribute("Operation", operation);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String matrixSubmit(@ModelAttribute FormMath formMath, Model model) {
        model.addAttribute("DoubleResponse", mathService.doOperation(formMath));
        return "resultMath";
    }

    @RequestMapping(value = "/doubleResponse", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource doubleResponse(Model model) {
        return new FileSystemResource(mathService.loadFile());
    }
}

