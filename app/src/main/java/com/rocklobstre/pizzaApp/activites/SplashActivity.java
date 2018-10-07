package com.rocklobstre.pizzaApp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.model.Order;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pizzas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        Order order = new Order();
        order.setName(item.getOrder());
        intent.putExtra("order", order);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

}
