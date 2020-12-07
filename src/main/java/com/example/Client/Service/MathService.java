package com.example.Client.Service;

import com.example.Client.dto.DoubleResponse;
import com.example.Client.dto.FormMath;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;


@Service
public class MathService {
    public DoubleResponse addition(FormMath formMath){
        DoubleResponse doubleResponse = new DoubleResponse(formMath.getVal1()+formMath.getVal2());
        objectToXml(doubleResponse);
        return doubleResponse;
    }
    public void objectToXml(DoubleResponse doubleResponse){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DoubleResponse.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(doubleResponse, new File("I:\\Client\\src\\main\\resources\\templates\\out\\doubleResponse.xml"));
            marshaller.marshal(doubleResponse, System.out);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
