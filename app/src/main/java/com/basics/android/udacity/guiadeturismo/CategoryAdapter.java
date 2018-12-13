package com.basics.android.udacity.guiadeturismo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * PagerAdapter para gerenciar o layout dos diversos fragmentos que correspondem a uma lista
 * de atrações cada.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    final int PAGE_COUNT = 4;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Retorna o fragmento que deve ser exibido para o número da página fornecido.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            // Lista de passeios
            return new ToursFragment();
        } else if (position == 1) {
            // Lista de atrações culturais
            return new CulturesFragment();
        } else if (position == 2) {
            // Lista de restaurantes
            return new RestaurantsFragment();
        } else {
            // Lista de hotéis
            return new HotelsFragment();
        }
    }

    /**
     * Retorna a quantidade total de páginas.
     */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /**
     * Retorna o título da página selecionada.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_tours);
        } else if (position == 1) {
            return mContext.getString(R.string.category_cultures);
        } else if (position == 2) {
            return mContext.getString(R.string.category_restaurants);
        } else {
            return mContext.getString(R.string.category_hotels);
        }
    }
}