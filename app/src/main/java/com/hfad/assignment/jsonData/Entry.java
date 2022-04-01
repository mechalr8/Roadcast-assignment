package com.hfad.assignment.jsonData;

import android.util.Log;

public class Entry {
    private String API;
    private String Description;
    private String Auth;
    private Boolean HTTPS;
    private String Cors;
    private String Link;
    private String Category;

    public void setAPI(String API) {
        this.API = API;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }

    public void setHTTPS(Boolean HTTPS) {
        this.HTTPS = HTTPS;
    }

    public void setCors(String cors) {
        Cors = cors;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAPI() {
//        Log.e("API: ", API);
        return API;
    }

    public String getDescription() {
        return Description;
    }

    public String getAuth() {
        return Auth;
    }

    public Boolean getHTTPS() {
        return HTTPS;
    }

//    public String getHTTPS(){
//        return HTTPS.toString();
//    }

    public String getCors() {
        return Cors;
    }

    public String getLink() {
        return Link;
    }

    public String getCategory() {
        return Category;
    }
}
