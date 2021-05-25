package com.example.spdmit.petlist;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DisplayPet extends AppCompatActivity {
    TextView tv;
    ImageView img;
    ImageButton ttsImageButton;
    private TextToSpeech ttsEnglish ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pet);

        tv = (TextView) findViewById(R.id.textView);
        img = (ImageView) findViewById(R.id.imageView);
        ttsImageButton = findViewById(R.id.ttsImageButton);

        Intent intent = getIntent();
        int pic = intent.getIntExtra("pic",0);
        String pet = intent.getStringExtra("pet");

        if (ttsEnglish == null) {
            ttsEnglish = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        int ttsLang = ttsEnglish.setLanguage(Locale.UK);

                        if (ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS ", "UK English Language is not supported!");
                        } else {
                            Log.i("TTS ", "UK English Language supported.");
                        }
                        Log.i("TTS ", "UK English initialization success.");
                    } else {
                        Toast.makeText(getApplicationContext(), "UK English TTS initialization failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        tv.setText(pet);
        img.setImageResource(pic);
        ttsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int speechStatus = ttsEnglish.speak(tv.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);

                if (speechStatus == TextToSpeech.ERROR) {
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (ttsEnglish != null) {
            ttsEnglish.stop();
            ttsEnglish.shutdown();
        }
    }

}
