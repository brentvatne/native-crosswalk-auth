package com.xwalk.androidstudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.identitytoolkit.GitkitClient;
import com.google.identitytoolkit.GitkitUser;
import com.google.identitytoolkit.IdToken;

public class LoginActivity extends Activity implements View.OnClickListener {
    public final static String TOKEN_MESSAGE = "com.xwalk.androidstudio.TOKEN_MESSAGE";
    private GitkitClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.sign_in);
        button.setOnClickListener(this);

        client = GitkitClient.newBuilder(this, new GitkitClient.SignInCallbacks() {
            @Override
            public void onSignIn(IdToken idToken, GitkitUser user) {
                System.out.println("Got to onSignIn");
                Toast.makeText(LoginActivity.this, "Hello there!", Toast.LENGTH_LONG).show();
                startCrosswalkActivity(idToken, user);
            }

            @Override
            public void onSignInFailed() {
                System.out.println("Got to onSignInFailed");
                Toast.makeText(LoginActivity.this, "Sign in failed", Toast.LENGTH_LONG).show();
            }
        }).build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        System.out.println("onActivityResult");
        if (!client.handleActivityResult(requestCode, resultCode, intent)) {
            super.onActivityResult(requestCode, resultCode, intent);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        System.out.println("onNewIntent");
        if (!client.handleIntent(intent)) {
            super.onNewIntent(intent);
        }
    }

    private void startCrosswalkActivity(IdToken idToken, GitkitUser user) {
        System.out.println("Start activity");
        Intent intent = new Intent(this, XWalkCordova.class);
        String token = idToken.getTokenString();
        intent.putExtra(TOKEN_MESSAGE, token);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_in) {
            System.out.println("Clicked sign_in");
            client.startSignIn();
        }
    }
}
