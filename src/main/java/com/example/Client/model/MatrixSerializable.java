package com.example.Client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatrixSerializable implements Serializable {

    private int rows;
    private int columns;
    private Double[][] elements;

    public MatrixSerializable(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new Double[rows][columns];
    }

    public MatrixSerializable(int rows, int columns, Double[] elements) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (columns >= 0) System.arraycopy(elements, i * columns, this.elements[i], 0, columns);
        }
    }

    public void set(Object obj, int i, int j) {
        this.elements[i][j] = (Double) obj;
    }
}
