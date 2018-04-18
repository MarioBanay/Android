package com.example.tm.zadatak02;

/**
 * Created by M on 4/18/2018.
 */

public class IncrementDecrementService implements ICalculateService {

    private int result;

    @Override
    public String increment(String s) {
        result = (Integer.parseInt(s)) + 1;

        return String.valueOf(result);
    }

    @Override
    public String decrement(String s) {
        result = (Integer.parseInt(s)) - 1;

        return String.valueOf(result);    }
}
