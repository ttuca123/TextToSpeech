package com.mobile.zenus.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private Button btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpeak = (Button) findViewById(R.id.button);
        tts = new TextToSpeech(this, this);

    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            btnSpeak.setEnabled(true);
        }
    }

    public void falarMeuTexto(View view){

        EditText editar = (EditText) findViewById(R.id.editText);

        int codigo = tts.isLanguageAvailable(new Locale("pt", "BR"));
        if(codigo == TextToSpeech.LANG_NOT_SUPPORTED){

            tts.setLanguage(new Locale("pt", "BR"));
        }else{
            Toast.makeText(this, "Código", Toast.LENGTH_SHORT).show();
        }

        tts.speak("Ensaio de hoje!", tts.QUEUE_ADD, null);

        tts.speak("David, bora ensaiar", tts.QUEUE_ADD, null);

        tts.speak("My Sacrifice, Under the bridge", tts.QUEUE_ADD, null);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        tts.shutdown();
    }
}
