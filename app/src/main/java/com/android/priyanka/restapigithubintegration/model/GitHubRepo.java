package com.android.priyanka.restapigithubintegration.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    @SerializedName("name")
    private String repoName;
    @SerializedName("language")
    private String repoLanguage;
    @SerializedName("description")
    private String repoDescription;

    public GitHubRepo(String repoName, String repoLanguage, String repoDescription) {
        this.setRepoName(repoName);
        this.setRepoLanguage(repoLanguage);
        this.setRepoDescription(repoDescription);
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoLanguage() {
        return repoLanguage;
    }

    public void setRepoLanguage(String repoLanguage) {
        this.repoLanguage = repoLanguage;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public void setRepoDescription(String repoDescription) {
        this.repoDescription = repoDescription;
    }
}
