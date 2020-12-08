package com.example.Client.dto.enums;

import com.example.Client.dto.DoubleResponse;
import com.example.Client.dto.FormMath;
import org.springframework.context.annotation.Bean;

public enum Operation {
    ADDITION {
        public DoubleResponse operation(FormMath formMath) {
            return new DoubleResponse(formMath.getVal1() + formMath.getVal2(), formMath.getVal1(), formMath.getVal2(), toString());
        }

        public String toString() {
            return "ADDITION";
        }
    },
    SUBTRACT {
        public DoubleResponse operation(FormMath formMath) {
            return new DoubleResponse(formMath.getVal1() - formMath.getVal2(), formMath.getVal1(), formMath.getVal2(), toString());
        }
        public String toString(){
            return "SUBTRACT";
        }
    },
    MULTIPLICATION {
        public DoubleResponse operation(FormMath formMath) {
            return new DoubleResponse(formMath.getVal1() * formMath.getVal2(), formMath.getVal1(), formMath.getVal2(), toString());
        }
        public String toString(){
            return "MULTIPLICATION";
        }
    },
    DIVISION {
        public DoubleResponse operation(FormMath formMath) {
            return new DoubleResponse(formMath.getVal1() / formMath.getVal2(), formMath.getVal1(), formMath.getVal2(), toString());
        }
        public String toString(){
            return "DIVISION";
        }
    };

    public abstract DoubleResponse operation(FormMath formMath);
    public abstract String toString();
}
