package com.rocklobstre.pizzaApp.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.adapter.PizzaAdapter;
import com.rocklobstre.pizzaApp.model.Order;

import java.util.ArrayList;


public class SuccessActivity extends AppCompatActivity {

    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        ListView lv = findViewById(R.id.listview);
        TextView tvSuccess = findViewById(R.id.title);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            order = (Order) bundle.getSerializable("order");
        else
            order = new Order();

        ArrayList<Order> shoppingBasket = new ArrayList<Order>();
        shoppingBasket.add(order);
        PizzaAdapter adapter = new PizzaAdapter(this, 0, shoppingBasket);

        lv.setAdapter(adapter);

        String[] types = getResources().getStringArray(R.array.types);

        tvSuccess.setText(String.format(getResources().getString(R.string.success_text),
                order.getFullName(), types[order.getName()],
                order.getPostalCode(), order.getAddress(), order.getTelephoneNumber()));
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
