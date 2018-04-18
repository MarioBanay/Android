package com.example.tm.zadatak02;

/**
 * Created by T&M on 14.4.2018..
 */

import android.text.TextUtils;

public class Presenter implements IPresenter {

    private IView view;
    private ICalculateService calculateService;

    public Presenter(IView view) {
        this.view = view;
        this.calculateService = new IncrementDecrementService();
    }

    @Override
    public void increment(String value) {
        if (!isNumber(value)) {
            view.showError("Neispravan unos");
        } else {
            String result = this.calculateService.increment(value);
            if (Integer.parseInt(result) < 0){
                view.showError("Nedozvoljen unos");
            } else {
            view.showResult(result);
            }
        }
    }

    @Override
    public void decrement(String value) {
        if (!isNumber(value)) {
            view.showError("Neispravan unos");
        } else {
            String result = this.calculateService.decrement(value);
            if (Integer.parseInt(result) < 0) {
                view.showError("Nedozvoljen unos");
            } else {
                view.showResult(result);
            }
        }
    }

    private boolean isNumber(String value) {
        boolean flag;
        try {
            Integer.parseInt(value);
            flag = true;
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }


}
