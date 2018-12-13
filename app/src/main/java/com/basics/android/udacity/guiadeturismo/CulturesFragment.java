package com.basics.android.udacity.guiadeturismo;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CulturesFragment extends Fragment {

    public CulturesFragment() {
        // Contrutor público vazio requerido.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        Resources r = getActivity().getResources();

        // Cria um array de atrações referente a passeios. Nome e endereço são obrigatórios.
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(r.getString(R.string.cultures_name1), r.getString(R.string.cultures_hours1),
                null, r.getString(R.string.cultures_address1), r.getString(R.string.cultures_web1),
                r.getString(R.string.cultures_description1), R.drawable.img_culture1));
        attractions.add(new Attraction(r.getString(R.string.cultures_name2), r.getString(R.string.cultures_hours2),
                r.getString(R.string.cultures_phone2), r.getString(R.string.cultures_address2),
                r.getString(R.string.cultures_web2), r.getString(R.string.cultures_description2), R.drawable.img_culture2));
        attractions.add(new Attraction(r.getString(R.string.cultures_name3), r.getString(R.string.cultures_hours3),
                r.getString(R.string.cultures_phone3), r.getString(R.string.cultures_address3),
                r.getString(R.string.cultures_web3), r.getString(R.string.cultures_description3), R.drawable.img_culture3));
        attractions.add(new Attraction(r.getString(R.string.cultures_name4), r.getString(R.string.cultures_hours4),
                r.getString(R.string.cultures_phone4), r.getString(R.string.cultures_address4),
                r.getString(R.string.cultures_web4), r.getString(R.string.cultures_description4), R.drawable.img_culture4));
        attractions.add(new Attraction(r.getString(R.string.cultures_name5), null, null,
                r.getString(R.string.cultures_address5), r.getString(R.string.cultures_web5),
                r.getString(R.string.cultures_description5), R.drawable.img_culture5));
        attractions.add(new Attraction(r.getString(R.string.cultures_name6), null,
                r.getString(R.string.cultures_phone6), r.getString(R.string.cultures_address6),
                r.getString(R.string.cultures_web6), r.getString(R.string.cultures_description6),
                R.drawable.img_culture6));
        attractions.add(new Attraction(r.getString(R.string.cultures_name7), r.getString(R.string.cultures_hours7),
                r.getString(R.string.cultures_phone7), r.getString(R.string.cultures_address7),
                r.getString(R.string.cultures_web7), r.getString(R.string.cultures_description7), R.drawable.img_culture7));

        // Cor de fundo para os cards da lista de atrações desta categoria a ser exibida.
        final int color = ContextCompat.getColor(getContext(), R.color.category_cultures);

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Listener para exibir detalhes da atração quando um item da lista é clicado.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                // Adiciona todos os dados da atração clicada para serem exibidos em DetailsActivity.
                intent.putExtra("name", attractions.get(position).getName());
                intent.putExtra("hours", attractions.get(position).getHours());
                intent.putExtra("phone", attractions.get(position).getPhone());
                intent.putExtra("imageResourceId", attractions.get(position).getImageResourceId());
                intent.putExtra("address", attractions.get(position).getAddress());
                intent.putExtra("web", attractions.get(position).getWeb());
                intent.putExtra("description", attractions.get(position).getDescription());
                // Adiciona a mesma cor de fundo do card clicado para ser usado como fundo da tela
                // de detalhes
                intent.putExtra("color", color);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
