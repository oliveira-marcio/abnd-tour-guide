package com.basics.android.udacity.guiadeturismo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    // Elementos da interface
    private ScrollView mAttractionContainer;
    private ImageView mImageView;
    private CardView mImageCardView;
    private TextView mDescriptionTextView;
    private TextView mNameTextView;
    private ImageView mHoursImageView;
    private TextView mHoursTextView;
    private TextView mAddressTextView;
    private ImageView mPhoneImageView;
    private TextView mPhoneTextView;
    private ImageView mWebImageView;
    private TextView mWebTextView;

    // Argumentos passados via intent da MainActivity, de acordo com a atração clicada.
    private String mName;
    private String mHours;
    private String mPhone;
    private String mAddress;
    private String mWeb;
    private String mDescription;
    private int mImageResourceId;
    private int mColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIntentArgs(getIntent().getExtras());
        initializeUIElements();

        setTitle(mName);
        mAttractionContainer.setBackgroundColor(mColor);

        // Checa se uma imagem foi fornecida para esta atração ou não para exibí-la (ou não) junto
        // com o seu CardView
        if (mImageResourceId != Attraction.NO_IMAGE_PROVIDED) {
            mImageView.setImageResource(mImageResourceId);
            mImageView.setVisibility(View.VISIBLE);
            mImageCardView.setVisibility(View.VISIBLE);
        } else {
            mImageView.setVisibility(View.GONE);
            mImageCardView.setVisibility(View.GONE);
        }

        // Detalhes da atração que sempre serão exibidos
        mDescriptionTextView.setText(mDescription);
        mNameTextView.setText(mName);
        mAddressTextView.setText(mAddress);

        // Exibe um horário de funcionamento (e seu ícone) caso fornecido.
        if (mHours != null) {
            mHoursTextView.setText(mHours);
            mHoursImageView.setVisibility(View.VISIBLE);
            mHoursTextView.setVisibility(View.VISIBLE);
        } else {
            mHoursImageView.setVisibility(View.GONE);
            mHoursTextView.setVisibility(View.GONE);
        }

        // Exibe um telefone (e seu ícone) caso fornecido.
        if (mPhone != null) {
            mPhoneTextView.setText(mPhone);
            mPhoneImageView.setVisibility(View.VISIBLE);
            mPhoneTextView.setVisibility(View.VISIBLE);
        } else {
            mPhoneImageView.setVisibility(View.GONE);
            mPhoneTextView.setVisibility(View.GONE);
        }

        // Exibe um endereço Web (e seu ícone), caso fornecido, e cria um link para que o usuário
        // possa abrí-lo no navegador
        if (mWeb != null) {
            mWebTextView.setText(mWeb);
            mWebTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(mWeb));
                    startActivity(i);
                }
            });
            mWebImageView.setVisibility(View.VISIBLE);
            mWebTextView.setVisibility(View.VISIBLE);
        } else {
            mWebImageView.setVisibility(View.GONE);
            mWebTextView.setVisibility(View.GONE);
        }
    }

    /**
     * Recupera todos os parâmetros passados no intent da MainActivity quando o usuário clica
     * numa atração:
     * cor de fundo para a tela, de acordo com a categoria da atração, e o nome, horário de
     * funcionamento, telefones, imagem, endereço, endereço web e descrição da atração.
     *
     * @param args são os Extras do Intent
     */
    private void getIntentArgs(Bundle args) {
        // ToDo: Acertar args nos fragments, tipos da classe e chamada do construtor
        // ToDo: Reduzir mais comentários
        // ToDo: Trocar imagens por jpgs
        // ToDo: ajustar versões no gradle
        mName = args.getString("name");
        mHours = args.getString("hours");
        mPhone = args.getString("phone");
        mAddress = args.getString("address");
        mWeb = args.getString("web");
        mDescription = args.getString("description");
        mImageResourceId = args.getInt("imageResourceId");
        mColor = args.getInt("color");
    }

    /**
     * Método para inicializar os elementos de interface
     */
    private void initializeUIElements() {
        mAttractionContainer = (ScrollView) findViewById(R.id.attraction_container);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mImageCardView = (CardView) findViewById(R.id.image_card_view);
        mDescriptionTextView = (TextView) findViewById(R.id.description_text_view);
        mNameTextView = (TextView) findViewById(R.id.name_text_view);
        mHoursImageView = (ImageView) findViewById(R.id.hours_image_view);
        mHoursTextView = (TextView) findViewById(R.id.hours_text_view);
        mAddressTextView = (TextView) findViewById(R.id.address_text_view);
        mPhoneImageView = (ImageView) findViewById(R.id.phone_image_view);
        mPhoneTextView = (TextView) findViewById(R.id.phone_text_view);
        mWebImageView = (ImageView) findViewById(R.id.web_image_view);
        mWebTextView = (TextView) findViewById(R.id.web_text_view);
    }

    /**
     * Sobreescreve o comportamento padrão do botão de navegação adicionado no topo da tela para
     * que funcione como o botão de voltar padrão do Android.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
