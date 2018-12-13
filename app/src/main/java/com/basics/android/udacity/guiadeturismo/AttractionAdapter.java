package com.basics.android.udacity.guiadeturismo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    /**
     * Valor inteiro que representa a cor de fundo para os cards da lista de atrações de acordo
     * com a categoria das mesmas.
     */
    private int mColor;

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions, int color) {
        super(context, 0, attractions);
        mColor = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Pega a atração associada à posição atual na lista
        final Attraction currentAttraction = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentAttraction.getName());

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        // Pega no endereço apenas a string correspondente ao bairro
        String local = currentAttraction.getAddress();
        local = local.substring(local.indexOf("-") + 1, local.length());
        locationTextView.setText(local);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Checa se uma imagem foi fornecida para esta atração e a exibe
        if (currentAttraction.getImageResourceId() > Attraction.NO_IMAGE_PROVIDED) {
            imageView.setImageResource(currentAttraction.getImageResourceId());
        } else {
            // Caso contrário, exibe uma imagem padrão
            imageView.setImageResource(R.drawable.list_placeholder);
        }

        CardView attractionContainer = (CardView) listItemView.findViewById(R.id.attraction_container);
        attractionContainer.setCardBackgroundColor(mColor);

        return listItemView;
    }
}
