package com.example.Client.Service;

import com.example.Client.dto.MatrixDto;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class HelperService
{
    public HelperService() {
    }

    public MatrixDto loadMatrix(String name) {
        try (ObjectInputStream matrixReader = new ObjectInputStream(new FileInputStream(name)))
        {
            return Matrices.matrixToMatrix(Matrices.deserialize(matrixReader));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new MatrixDto();
    }

    public void saveMatrix(MatrixDto matrixDto) {
        try (
                ObjectOutputStream MatrixWriter = new ObjectOutputStream(new FileOutputStream(matrixDto.getFilename()))) {
            Matrices.serialize(MatrixWriter, Matrices.matrixToMatrix(matrixDto));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
