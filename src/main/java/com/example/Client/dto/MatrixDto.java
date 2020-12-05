package com.example.Client.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatrixDto {
    public MatrixDto() {
    }
    public MatrixDto(int rows, int columns, Double[][] elements) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new Double[rows * columns];
        for (int i = 0; i < rows; i++) {
            if (columns >= 0) System.arraycopy(elements[i], 0, this.elements, i * columns, columns);
        }
    }
    private String filename;
    @JsonProperty("rows")
    private int rows;
    @JsonProperty("columns")
    private int columns;
    @JsonProperty("elements")
    private Double[] elements;

    public void set(Object obj, int i, int j) {
        this.elements[i*columns + j] = (Double) obj;
    }
}
