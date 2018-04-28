package com.example.m.zadatak02;

/**
 * Created by M on 4/24/2018.
 */

public class ParnostService implements ICheckParnostService {
    @Override
    public boolean checkParnost(String s) {
        if (Integer.parseInt(s) % 2 == 0)
        return true;
        else return false;
    }
}
