package com.example.m.zadatak02;

/**
 * Created by M on 4/24/2018.
 */

public class Presenter implements IPresenter {

    private IView view;
    private ICheckParnostService checkParnostService;

    public Presenter(IView view) {
        this.view = view;
        this.checkParnostService = new ParnostService();
    }

    @Override
    public void provjeri(String s) {
        if (!isNumber(s)){
            view.showError("Broj nije ispravan");
        } else {
            if (checkParnostService.checkParnost(s)){
                view.showResult("paran");
            } else {
                view.showResult("neparan");
            }
        }
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
