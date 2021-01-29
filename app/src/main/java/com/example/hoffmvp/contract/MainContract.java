package com.example.hoffmvp.contract;

import com.example.hoffmvp.model.ModelProduct;

import java.util.List;

public interface MainContract {

    interface presenter{
        void onDestroy();
        void onRefreshBtnPull();
        void requestDataFromServer();
    }

    interface mainView{
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView( List<ModelProduct> modelProducts );
        void onResponseFailure(Throwable throwable);
    }

}
