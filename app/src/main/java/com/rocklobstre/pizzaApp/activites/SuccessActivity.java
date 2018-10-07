package com.rocklobstre.pizzaApp.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.model.Order;


public class SuccessActivity extends AppCompatActivity {

    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        TextView success = findViewById(R.id.title);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            order = (Order) bundle.getSerializable("order");
        else
            order = new Order();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
