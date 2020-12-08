package com.example.Client.dto;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DoubleResponse")
@Data
@Entity
@Table(name = "DoubleResponse")
public class DoubleResponse {
    public DoubleResponse() {

    }

    public DoubleResponse(Double value) {
        this.value = value;
    }

    public DoubleResponse(Double value, Double val1, Double val2) {
        this.value = value;
        this.val1 = val1;
        this.val2 = val2;
    }

    public DoubleResponse(Double value, Double val1, Double val2, String descr) {
        this.value = value;
        this.val1 = val1;
        this.val2 = val2;
        this.descr = descr;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCard;
    @Column(name = "value", unique = false, nullable = true)
    private Double value;
    @Column(name = "val1", unique = false, nullable = true)
    private Double val1;
    @Column(name = "val2", unique = false, nullable = true)
    private Double val2;
    @Column(name = "descr", unique = false, nullable = true)
    private String descr;

    @XmlElement(name = "val1")
    public Double getVal1() {
        return val1;
    }
    @XmlElement(name = "val1")
    public Double getVal2() {
        return val2;
    }
    @XmlElement(name = "value")
    public Double getValue() {
        return value;
    }
    @XmlElement(name = "descrip")
    public String getDescr() {
        return descr;
    }
}
