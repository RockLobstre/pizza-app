package com.rocklobstre.pizzaApp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.model.Order;

public class AddressActivity extends AppCompatActivity {
    private EditText fullName;
    private EditText address;
    private EditText postalCode;
    private EditText telephoneNumber;
    private EditText paymentInformation;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            order = (Order) bundle.getSerializable("order");
        else
            order = new Order();

        fullName = findViewById(R.id.edt1);
        address = findViewById(R.id.edt2);
        postalCode = findViewById(R.id.edt3);
        telephoneNumber = findViewById(R.id.edt4);
        paymentInformation = findViewById(R.id.edt5);

    }

    public void onSendClick(View view) {
        fullName.setError(null);
        address.setError(null);
        postalCode.setError(null);
        telephoneNumber.setError(null);
        paymentInformation.setError(null);
        boolean cancel = false;
        if (TextUtils.isEmpty(fullName.getText().toString())){
            cancel = true;
            fullName.setError(getResources().getString(R.string.error_edittext));
        } else if (TextUtils.isEmpty(address.getText().toString())){
            cancel = true;
            address.setError(getResources().getString(R.string.error_edittext));
        } else if (TextUtils.isEmpty(postalCode.getText().toString())){
            cancel = true;
            postalCode.setError(getResources().getString(R.string.error_edittext));
        } else if (TextUtils.isEmpty(telephoneNumber.getText().toString())){
            cancel = true;
            telephoneNumber.setError(getResources().getString(R.string.error_edittext));
        } else if (TextUtils.isEmpty(paymentInformation.getText().toString())){
            cancel = true;
            paymentInformation.setError(getResources().getString(R.string.error_edittext));
        }
        if (!cancel){
            Intent intent = new Intent(AddressActivity.this, SuccessActivity.class);
            order.setFullName(fullName.getText().toString());
            order.setAddress(address.getText().toString());
            order.setPostalCode(postalCode.getText().toString());
            order.setTelephoneNumber(telephoneNumber.getText().toString());
            order.setPaymentInformation(paymentInformation.getText().toString());
            intent.putExtra("order", order);
            startActivity(intent);
        }

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

    public void onBackPressed(View view) {
        finish();
    }
}
