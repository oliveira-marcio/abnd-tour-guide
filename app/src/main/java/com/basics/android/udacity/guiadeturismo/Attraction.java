package com.basics.android.udacity.guiadeturismo;

/**
 * Representa uma atração da cidade.
 *
 * Contêm o nome, telefones, horários de funcionamento, endereço, endereço web, descrição e
 * o Resource ID da imagem da atração.
 */
public class Attraction {
    /**
     * Constante que representa quando um recurso id de uma imagem não é fornecido para a atração
     * porque não é aplicável
     */
    public static final int NO_IMAGE_PROVIDED = -1;

    private String mName;
    private String mPhone;
    private String mHours;
    private String mAddress;
    private String mWeb;
    private String mDescription;
    private int mImageResourceId;

    public Attraction(String name, String hours, String phone, String address,
                      String web, String description, int imageResourceId) {
        mName = name;
        mPhone = phone;
        mHours = hours;
        mAddress = address;
        mWeb = web;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getHours() {
        return mHours;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getWeb() {
        return mWeb;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
