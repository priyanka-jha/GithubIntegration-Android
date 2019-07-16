package com.android.priyanka.restapigithubintegration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.android.priyanka.restapigithubintegration.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText edUsername;
    @BindView(R.id.login)
    Button btnLogin;

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onViewClicked() {

        String username = edUsername.getText().toString();

        Intent i = new Intent(this, UserScreenActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
}
