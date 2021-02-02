package com.example.hoffmvp.presenter;

import com.example.hoffmvp.contract.MainPresenterInterface;
import com.example.hoffmvp.contract.MainViewInterface;
import com.example.hoffmvp.model.ProductResponse;
import com.example.hoffmvp.my_interface.ApiConfig;
import com.example.hoffmvp.my_interface.ApiService;
import com.example.hoffmvp.network.DataManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mainViewInterface;
    DataManager dataManager;

    public MainPresenter( MainViewInterface mainViewInterface, DataManager dataManager ) {
        this.mainViewInterface=mainViewInterface;
        this.dataManager=dataManager;
    }

    // Сортировка
    // Сначала дешевые
    public Observable<ProductResponse> getObservableDesc(){
        return dataManager.getDataDesc ()
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


    // Сначала дорогие
    public Observable<ProductResponse> getObservableAsc(){
        return dataManager.getDataAsc ()
                .subscribeOn( Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ProductResponse> getObserverAsc(){
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

    // Дорогие товары
    @Override
    public void getProductsAsc() {
        getObservableAsc ().subscribeWith ( getObserverAsc () );
    }


    // Сначала популярные
    public Observable<ProductResponse> getObservablePopular(){
        return dataManager.getDataPopular ()
                .subscribeOn( Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ProductResponse> getObserverPopular(){
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


    // Популярные товары
    @Override
    public void getProductsPopular() {
        getObservablePopular ().subscribeWith ( getObserverPopular () );
    }


    // Сначала товары со скидкой
    public Observable<ProductResponse> getObservableDiscount(){
        return dataManager.getDataDiscount ()
                .subscribeOn( Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ProductResponse> getObserverDiscount(){
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

    // Товары со скидкой
    @Override
    public void getProductsDiscount() {
        getObservableDiscount ().subscribeWith ( getObserverDiscount () );
    }
}
