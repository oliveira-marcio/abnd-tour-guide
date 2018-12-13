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

public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Contrutor público vazio requerido.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        Resources r = getActivity().getResources();

        // Cria um array de atrações referente a hotéis. Nome e endereço são obrigatórios.
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(r.getString(R.string.hotels_name1), null,
                r.getString(R.string.hotels_phone1), r.getString(R.string.hotels_address1),
                r.getString(R.string.hotels_web1), r.getString(R.string.hotels_description1),
                R.drawable.img_hotel1));
        attractions.add(new Attraction(r.getString(R.string.hotels_name2), null,
                r.getString(R.string.hotels_phone2), r.getString(R.string.hotels_address2),
                r.getString(R.string.hotels_web2), r.getString(R.string.hotels_description2),
                R.drawable.img_hotel2));
        attractions.add(new Attraction(r.getString(R.string.hotels_name3), null,
                r.getString(R.string.hotels_phone3), r.getString(R.string.hotels_address3),
                r.getString(R.string.hotels_web3), r.getString(R.string.hotels_description3),
                R.drawable.img_hotel3));
        attractions.add(new Attraction(r.getString(R.string.hotels_name4), null,
                r.getString(R.string.hotels_phone4), r.getString(R.string.hotels_address4),
                r.getString(R.string.hotels_web4), r.getString(R.string.hotels_description4),
                R.drawable.img_hotel4));
        attractions.add(new Attraction(r.getString(R.string.hotels_name5), null,
                r.getString(R.string.hotels_phone5), r.getString(R.string.hotels_address5),
                r.getString(R.string.hotels_web5), r.getString(R.string.hotels_description5),
                R.drawable.img_hotel5));
        attractions.add(new Attraction(r.getString(R.string.hotels_name6), null,
                r.getString(R.string.hotels_phone6), r.getString(R.string.hotels_address6),
                r.getString(R.string.hotels_web6), r.getString(R.string.hotels_description6),
                R.drawable.img_hotel6));
        attractions.add(new Attraction(r.getString(R.string.hotels_name7), null,
                r.getString(R.string.hotels_phone7), r.getString(R.string.hotels_address7),
                r.getString(R.string.hotels_web7), r.getString(R.string.hotels_description7),
                R.drawable.img_hotel7));
        attractions.add(new Attraction(r.getString(R.string.hotels_name8), null,
                r.getString(R.string.hotels_phone8), r.getString(R.string.hotels_address8),
                r.getString(R.string.hotels_web8), r.getString(R.string.hotels_description8),
                R.drawable.img_hotel8));
        attractions.add(new Attraction(r.getString(R.string.hotels_name9), null,
                r.getString(R.string.hotels_phone9), r.getString(R.string.hotels_address9), null,
                r.getString(R.string.hotels_description9), R.drawable.img_hotel9));
        attractions.add(new Attraction(r.getString(R.string.hotels_name10), null,
                r.getString(R.string.hotels_phone10), r.getString(R.string.hotels_address10),
                r.getString(R.string.hotels_web10), r.getString(R.string.hotels_description10),
                R.drawable.img_hotel10));

        // Cor de fundo para os cards da lista de atrações desta categoria a ser exibida.
        final int color = ContextCompat.getColor(getContext(), R.color.category_hotels);

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
