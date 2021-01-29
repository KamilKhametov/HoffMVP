package com.example.hoffmvp.presenter;

import com.example.hoffmvp.contract.MainPresenterInterface;
import com.example.hoffmvp.contract.MainViewInterface;
import com.example.hoffmvp.model.ProductResponse;
import com.example.hoffmvp.my_interface.ApiConfig;
import com.example.hoffmvp.my_interface.ApiService;
import com.example.hoffmvp.network.RetrofitInstance;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mainViewInterface;

    public MainPresenter( MainViewInterface mainViewInterface ) {
        this.mainViewInterface=mainViewInterface;
    }

    // Сортировка
    // Сначала дешевые
    public Observable<ProductResponse> getObservableDesc(){
        return RetrofitInstance.getRetrofitInstance ().create ( ApiService.class )
                .getProducts ( ApiConfig.category_id,
                               "price",
                               "asc",
                               ApiConfig.limit,
                               ApiConfig.offset,
                               ApiConfig.device_id,
                               ApiConfig.isAndroid,
                               ApiConfig.app_version,
                               ApiConfig.location )
                .subscribeOn( Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ProductResponse> getObserverDesc(){
        return new DisposableObserver<ProductResponse> () {
            @Override
            public void onNext( @NonNull ProductResponse productResponse ) {
                mainViewInterface.displayProduct ( productResponse );
            }

            @Override
            public void onError( @NonNull Throwable e ) {
                e.printStackTrace ();
                mainViewInterface.displayError ( "Error..." );
            }

            @Override
            public void onComplete() {
                mainViewInterface.hideProgressBar ();
            }
        };
    }

    // метод получения дешевых товаров
    @Override
    public void getProductsDesc() {
        getObservableDesc ().subscribeWith ( getObserverDesc () );
    }

//    // Дорогие товары
//    @Override
//    public void getProductsAsc() {
//
//    }
//
//    // Популярные товары
//    @Override
//    public void getProductsPopular() {
//
//    }
//
//    // Товары со скидкой
//    @Override
//    public void getProductsDiscount() {
//
//    }
}
