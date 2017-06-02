package com.inonitylab.workwithandroidmvp.ui.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ruhul on 6/2/17.
 */

public class Repo {
    public int id;
    public String name;
    public boolean fork;
    @SerializedName("stargazers_count")
    public int stars;
}
