package com.example.Client.Service;

import com.example.Client.dto.DoubleResponse;
import com.example.Client.dto.FormMath;
import com.example.Client.dto.enums.Operation;
import com.example.Client.repository.DoubleResponceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


@Service
public class MathService {
    private File file = new File("doubleResponse.xml");

    @Autowired
    public MathService(DoubleResponceRepository doubleResponceRepository) {
        this.doubleResponceRepository = doubleResponceRepository;
    }

    DoubleResponceRepository doubleResponceRepository;

    public DoubleResponse doOperation(FormMath formMath) {
        DoubleResponse doubleResponse = formMath.getOperation().operation(formMath);
        doubleResponceRepository.save(doubleResponse);
        objectToXml(doubleResponse);
        return doubleResponse;
    }

    public File objectToXml(DoubleResponse doubleResponse) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DoubleResponse.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(doubleResponse, file);
            marshaller.marshal(doubleResponse, System.out);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public File loadFile() {
        return file;
    }

    public void objectToXmlJsp(DoubleResponse doubleResponse) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DoubleResponse.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(doubleResponse, file);
            marshaller.marshal(doubleResponse, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
