package com.example.tictactoemobileapp;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog{
    private final String message;
    private final MainActivity mainActivity;
    public WinDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;
        this.message      = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog);
        final TextView messageText = (TextView) findViewById(R.id.messageText);
        final Button startAgainBtn = (Button) findViewById(R.id.startAgainBtn);
        messageText.setText(message);
        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
