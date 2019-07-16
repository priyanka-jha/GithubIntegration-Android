package com.android.priyanka.restapigithubintegration.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.priyanka.restapigithubintegration.R;
import com.android.priyanka.restapigithubintegration.model.GitHubRepo;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    private List<GitHubRepo> repos;
    private int rowLayout;
    private Context context;

    public ReposAdapter(List<GitHubRepo> repos, int rowLayout, Context context) {
        this.setRepos(repos);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup,false);
        return new ReposViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder reposViewHolder, int i) {
        reposViewHolder.repoName.setText(repos.get(i).getRepoName());
        reposViewHolder.repoDescription.setText(repos.get(i).getRepoDescription());
        reposViewHolder.repoLanguage.setText(repos.get(i).getRepoLanguage());

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public static class ReposViewHolder extends RecyclerView.ViewHolder{
        LinearLayout reposLayout;
        TextView repoName;
        TextView repoDescription;
        TextView repoLanguage;

        public ReposViewHolder(@NonNull View itemView) {
            super(itemView);

            reposLayout = itemView.findViewById(R.id.repos_item_layout);
            repoName = itemView.findViewById(R.id.repoName);
            repoDescription = itemView.findViewById(R.id.repoDescription);
            repoLanguage = itemView.findViewById(R.id.repoLanguage);
        }
    }
}
