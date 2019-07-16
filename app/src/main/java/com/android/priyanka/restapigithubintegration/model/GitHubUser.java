package com.android.priyanka.restapigithubintegration.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {
    @SerializedName("login")
    private String login;
    @SerializedName("email")
    private String email;
    @SerializedName("avatar_url")
    private String avatar;
    @SerializedName("following")
    private String following;
    @SerializedName("followers")
    private String followers;
    @SerializedName("name")
    private String name;


    public GitHubUser(String email, String avatar, String following, String followers, String name, String login) {
        this.email = email;
        this.avatar = avatar;
        this.following = following;
        this.followers = followers;
        this.name = name;
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
