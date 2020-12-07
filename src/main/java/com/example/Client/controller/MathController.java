package com.example.Client.controller;

import com.example.Client.Service.MathService;
import com.example.Client.dto.DoubleResponse;
import com.example.Client.dto.FormMath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MathController {

    MathService mathService = new MathService();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String matrixForm(Model model) {
        model.addAttribute("FormMath", new FormMath());
        model.addAttribute("DoubleResponse", new DoubleResponse());
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String matrixSubmit(@ModelAttribute FormMath formMath, Model model) {
            model.addAttribute("DoubleResponse",  mathService.addition(formMath));
            return "resultMath";
    }
    @RequestMapping(value = "/doubleResponse", method = RequestMethod.GET)
    public DoubleResponse matrixSubmit( Model model) {
        return (DoubleResponse) model.getAttribute("DoubleResponse");
    }
}
