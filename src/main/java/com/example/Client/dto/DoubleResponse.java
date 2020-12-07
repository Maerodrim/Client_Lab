package com.example.Client.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DoubleResponse")
public class DoubleResponse {
    public DoubleResponse(Double value) {
        this.value = value;
    }

    Double value;

    public DoubleResponse() {

    }
    @XmlElement(name = "value")
    public Double getValue() {
        return value;
    }
}
