package com.example.Client.dto;

import com.example.Client.dto.enums.Operation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormMath
{
    Double val1;
    Double val2;
    String desc;
    Operation operation;
}
