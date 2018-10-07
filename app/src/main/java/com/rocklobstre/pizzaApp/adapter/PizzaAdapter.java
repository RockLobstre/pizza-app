package com.rocklobstre.pizzaApp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.rocklobstre.pizzaApp.model.Order;
import com.rocklobstre.pizzaApp.R;


public class PizzaAdapter extends ArrayAdapter<Order> {


    private Context context;
    private List<Order> commands;

    public PizzaAdapter(Context context, int resource, ArrayList<Order> objects) {
        super(context, resource, objects);

        this.context = context;
        this.commands = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Order commande = commands.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_pizza, null);

        TextView size = (TextView) view.findViewById(R.id.size);
        TextView ing = (TextView) view.findViewById(R.id.ingridens);

        String[] types = context.getResources().getStringArray(R.array.types);
        String[] sizes = context.getResources().getStringArray(R.array.sizes);
        String[] ingredients = context.getResources().getStringArray(R.array.ingreds);

        size.setText(types[commande.getName()] + " (" + sizes[commande.getSize()] + ")");
        String tmp = "";

        if(commande.getIng1() > 0){
            tmp += ingredients[0] + (commande.getIng1() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng2() > 0){
            tmp += ingredients[1] + (commande.getIng2() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng3() > 0){
            tmp += ingredients[2] + (commande.getIng3() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng4() > 0){
            tmp += ingredients[3] + (commande.getIng4() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng5() > 0){
            tmp += ingredients[4] + (commande.getIng5() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng6() > 0){
            tmp += ingredients[5] + (commande.getIng6() == 1 ? "" : "(Extra)") +", ";
        }


        ing.setText(tmp);



        return view;


    }
}
