package com.greenfoxacademy.rest.Services;

import com.greenfoxacademy.rest.DTOs.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {

    public Object arrayHandler(ArrDTO arrDTO) {

        if (arrDTO.getWhat().equals(null) || arrDTO.getNumbers() == null) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setError("Please provide what to do with the numbers!");

            return errorDTO;

        } else if (arrDTO.getWhat().equals("sum")) {
            List<Integer> list = Arrays.asList(arrDTO.getNumbers());

            Integer result = list.stream().reduce(0,(a,b) -> a+b);

            ResultDTOInteger resultDTOInteger = new ResultDTOInteger();
            resultDTOInteger.setResult(result);

            return resultDTOInteger;

        } else if (arrDTO.getWhat().equals("multiply")) {
            List<Integer> list = Arrays.asList(arrDTO.getNumbers());

            Integer result = list.stream().reduce(1,(a,b) -> a*b);

            ResultDTOInteger resultDTOInteger = new ResultDTOInteger();
            resultDTOInteger.setResult(result);

            return resultDTOInteger;

        } else if (arrDTO.getWhat().equals("double")) {
            List<Integer> list = Arrays.asList(arrDTO.getNumbers());

            List<Integer> result = list.stream().map(num -> num*2).collect(Collectors.toList());

            Integer[] array = new Integer[] {result.get(0),result.get(1),result.get(2),result.get(3)};

            ResultDTOArray resultDTOArray = new ResultDTOArray();
            resultDTOArray.setResult(array);

            return resultDTOArray;

        } else {
            return null;
        }
    }

    public Object yodaReply(SithDTO sithDTO) {

        List<String> list = new ArrayList<>(List.of(sithDTO.getText().split(" ")));
        String reply = list.stream().reduce((a,b) -> b+a).toString();

        yodaReply yodaReply = new yodaReply();
        yodaReply.setSith_text(reply+ "Errhm eee.");

        return yodaReply;
    }

}
