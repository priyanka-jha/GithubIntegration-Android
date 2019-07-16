package com.android.priyanka.restapigithubintegration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.priyanka.restapigithubintegration.R;
import com.android.priyanka.restapigithubintegration.adapter.ReposAdapter;
import com.android.priyanka.restapigithubintegration.model.GitHubRepo;
import com.android.priyanka.restapigithubintegration.rest.APIClient;
import com.android.priyanka.restapigithubintegration.rest.GitHubRepoEndPoint;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryActivity extends AppCompatActivity {
    @BindView(R.id.username)
    TextView tvUsername;
    @BindView(R.id.repos_recyclerview)
    RecyclerView reposRecyclerview;
    List<GitHubRepo> gitHubRepoList = new ArrayList<>();
    RecyclerView.Adapter recyclerAdapter;
    String strUsername;

    private static final String TAG = RepositoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
        ButterKnife.bind(this);

        strUsername = getIntent().getStringExtra("username");

        tvUsername.setText("User: "+strUsername);

        reposRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new ReposAdapter(gitHubRepoList, R.layout.repos_items, getApplicationContext());

       // reposRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        reposRecyclerview.setAdapter(recyclerAdapter);

        loadRepositories();

    }

    public void loadRepositories() {
        GitHubRepoEndPoint apiService = APIClient.getClient().create(GitHubRepoEndPoint.class);

        Call<List<GitHubRepo>> call = apiService.getRepo(strUsername);

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                gitHubRepoList.clear();
                gitHubRepoList.addAll(response.body());
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });



    }
}
