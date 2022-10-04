package com.greenfoxacademy.rest.DTOs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrDTO {

    private String what;

    private Integer[] numbers;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }
}
