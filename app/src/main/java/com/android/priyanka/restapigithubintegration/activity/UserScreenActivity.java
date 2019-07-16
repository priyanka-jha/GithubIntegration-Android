package com.android.priyanka.restapigithubintegration.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.priyanka.restapigithubintegration.R;
import com.android.priyanka.restapigithubintegration.model.GitHubUser;
import com.android.priyanka.restapigithubintegration.rest.APIClient;
import com.android.priyanka.restapigithubintegration.rest.GitHubUserEndPoints;
import com.android.priyanka.restapigithubintegration.util.ImageDownloader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserScreenActivity extends AppCompatActivity {

    @BindView(R.id.avatar)
    ImageView imgAvatar;
    @BindView(R.id.username)
    TextView tvUsername;
    @BindView(R.id.followers)
    TextView tvFollowers;
    @BindView(R.id.following)
    TextView tvFollowing;
    @BindView(R.id.login)
    TextView tvLogin;
    @BindView(R.id.email)
    TextView tvEmail;
    @BindView(R.id.btnrepositories)
    Button btnRepositories;

    Bitmap bitmap;
    String strUsername ="";
    private static final String TAG = UserScreenActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        strUsername = bundle.getString("username");
        Log.i(TAG, strUsername);

        loadData();

    }

    @OnClick(R.id.btnrepositories)
    public void onViewClicked() {
        Intent i = new Intent(UserScreenActivity.this,RepositoryActivity.class);
        i.putExtra("username",strUsername);
        startActivity(i);
    }

    public void loadData(){
        final GitHubUserEndPoints apiService = APIClient.getClient().create(GitHubUserEndPoints.class);

        Call<GitHubUser> call = apiService.getUser(strUsername);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {

                if(response.body().getName() == null){
                    tvUsername.setText("No name provided");
                }
                else {
                    tvUsername.setText("Username: " + response.body().getName());
                }
                if(response.body().getEmail() == null){
                    tvEmail.setText("No email provided");
                }
                else {
                    tvEmail.setText("Email: " + response.body().getEmail());
                }
                tvFollowers.setText("Followers: "+response.body().getFollowers());
                tvFollowing.setText("Following: "+response.body().getFollowing());
                tvLogin.setText("LogIn: "+response.body().getLogin());

                ImageDownloader imageDownloader = new ImageDownloader();

                try {
                  bitmap = imageDownloader.execute(response.body().getAvatar()).get();
                  imgAvatar.setImageBitmap(bitmap);
                  imgAvatar.getLayoutParams().height = 220;
                  imgAvatar.getLayoutParams().width = 220;
                }catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i(TAG,response.body().getName()+response.body().getEmail()+response.body().getFollowers()+response.body().getFollowing()+response.body().getLogin());
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {

            }
        });



    }
}
