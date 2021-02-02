package com.example.hoffmvp.network;

import com.example.hoffmvp.model.ProductResponse;
import com.example.hoffmvp.my_interface.ApiConfig;
import com.example.hoffmvp.my_interface.ApiService;

import io.reactivex.Observable;

public class DataManager {

    private ApiService apiService;

    public DataManager( ApiService apiService ) {
        this.apiService=apiService;
    }

    // Дешевые товары
    public Observable<ProductResponse> getDataDesc(){
        return apiService.getProducts ( ApiConfig.category_id,
                                        "price",
                                        "asc",
                                        ApiConfig.limit,
                                        ApiConfig.offset,
                                        ApiConfig.device_id,
                                        ApiConfig.isAndroid,
                                        ApiConfig.app_version,
                                        ApiConfig.location );
    }


    // Дорогие товары
    public Observable<ProductResponse> getDataAsc(){
        return apiService.getProducts ( ApiConfig.category_id,
                                        "price",
                                        "desc",
                                        ApiConfig.limit,
                                        ApiConfig.offset,
                                        ApiConfig.device_id,
                                        ApiConfig.isAndroid,
                                        ApiConfig.app_version,
                                        ApiConfig.location);
    }


    // Популярные товары
    public Observable<ProductResponse> getDataPopular(){
        return apiService.getProducts ( ApiConfig.category_id,
                                        ApiConfig.sort_by,
                                        ApiConfig.sort_type,
                                        ApiConfig.limit,
                                        ApiConfig.offset,
                                        ApiConfig.device_id,
                                        ApiConfig.isAndroid,
                                        ApiConfig.app_version,
                                        ApiConfig.location);
    }


    // Товары со скидкой
    public Observable<ProductResponse> getDataDiscount(){
        return apiService.getProducts ( ApiConfig.category_id,
                                        "discount",
                                        ApiConfig.sort_type,
                                        ApiConfig.limit,
                                        ApiConfig.offset,
                                        ApiConfig.device_id,
                                        ApiConfig.isAndroid,
                                        ApiConfig.app_version,
                                        ApiConfig.location);
    }

}
