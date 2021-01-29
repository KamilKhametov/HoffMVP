package com.example.hoffmvp.contract;

import com.example.hoffmvp.model.ProductResponse;

public interface MainViewInterface {

    void showToast(String s);
    void displayProduct( ProductResponse productResponse);
    void displayError(String s);
    void hideProgressBar();

}
