package com.example.hoffmvp.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hoffmvp.R;
import com.example.hoffmvp.adapter.AdapterCatalog;
import com.example.hoffmvp.contract.MainViewInterface;
import com.example.hoffmvp.model.ProductResponse;
import com.example.hoffmvp.presenter.MainPresenter;

public class CatalogActivity extends AppCompatActivity implements MainViewInterface, AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private AdapterCatalog adapterCatalog;
    private MainPresenter mainPresenter;
    private ProgressBar progressBar;
    private Spinner spinnerProducts;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_catalog );

        // Установка actionBar
        setActionBarTitleCatalog ();
        // Нахождение полей
        recyclerView = findViewById ( R.id.recyclerView );
        progressBar = findViewById ( R.id.progressBar );
        spinnerProducts = findViewById ( R.id.spinnerProducts );

        // Установка MVP
        setupMVP();
        // Установка layout менеджера
        setupViews();
        // получение и установка данныз
        getProductList();
        // Спиннер
        initSpinner ();
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

    // Показать progressBar
    @Override
    public void showProgressBar() {
        progressBar.setVisibility (View.VISIBLE);
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

    // Инициализация спиннера
    private void initSpinner(){
        ArrayAdapter<CharSequence> spinnerAdapter=ArrayAdapter.createFromResource ( this, R.array.products, android.R.layout.simple_spinner_item );
        spinnerAdapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinnerProducts.setAdapter ( spinnerAdapter );
        spinnerProducts.setOnItemSelectedListener ( this );
    }

    // Клик на item`ы спиннера
    @Override
    public void onItemSelected( AdapterView<?> parent, View view, int position, long id ) {
        String itemPosition=parent.getItemAtPosition ( position ).toString ();
        if (itemPosition.equals ( "Сначала дешевые" )) {
            mainPresenter.getProductsDesc ();
        } else if (itemPosition.equals ( "Сначала дорогие" )) {
            mainPresenter.getProductsAsc ();
        } else if (itemPosition.equals ( "Популярные товары" )) {
            mainPresenter.getProductsPopular ();
        } else if (itemPosition.equals ( "По скидкам" )) {
            mainPresenter.getProductsDiscount ();
        }
    }

    @Override
    public void onNothingSelected( AdapterView<?> parent ) {

    }
}