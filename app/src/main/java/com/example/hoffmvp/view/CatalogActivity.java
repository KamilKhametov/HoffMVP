package com.example.hoffmvp.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hoffmvp.R;
import com.example.hoffmvp.adapter.AdapterCatalog;
import com.example.hoffmvp.contract.MainViewInterface;
import com.example.hoffmvp.model.ProductResponse;
import com.example.hoffmvp.presenter.MainPresenter;

public class CatalogActivity extends AppCompatActivity implements MainViewInterface {

    private RecyclerView recyclerView;
    private AdapterCatalog adapterCatalog;
    private MainPresenter mainPresenter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_catalog );

        // Установка actionBar
        setActionBarTitleCatalog ();
        // Нахождение полей
        recyclerView = findViewById ( R.id.recyclerView );
        progressBar = findViewById ( R.id.progressBar );

        // Установка MVP
        setupMVP();
        // Установка layout менеджера
        setupViews();
        // получение и установка данныз
        getProductList();
    }

    private void setupMVP() {
        mainPresenter = new MainPresenter ( this );
    }

    private void setupViews() {
        recyclerView.setLayoutManager(new GridLayoutManager ( this, 2 ));
    }

    private void getProductList() {
        mainPresenter.getProductsDesc ();
    }

    @Override
    public void showToast( String s ) {
        Toast.makeText ( this, "Hello", Toast.LENGTH_SHORT ).show ();
    }

    // Показать данные
    @Override
    public void displayProduct( ProductResponse productResponse ) {
        if(productResponse != null){
            adapterCatalog = new AdapterCatalog ( productResponse.items );
            recyclerView.setAdapter ( adapterCatalog );
        }
    }

    @Override
    public void displayError( String s ) {
        showToast ( s );
    }

    // Спрятать progressBar
    @Override
    public void hideProgressBar() {
        progressBar.setVisibility ( View.INVISIBLE );
    }

    // ActionBar
    private void setActionBarTitleCatalog() {
        getSupportActionBar ().setDisplayOptions ( ActionBar.DISPLAY_SHOW_CUSTOM );
        getSupportActionBar ().setCustomView ( R.layout.action_bar_catalog );
        getSupportActionBar ().setHomeAsUpIndicator ( R.drawable.ic_line_back );
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
    }
}