package com.vimeo.networking.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class VimeoAccount implements Serializable {

    private static final long serialVersionUID = -8341071767843490585L;
    public String accessToken;
    public String scope;
    public String tokenType;
    public com.vimeo.networking.model.User user;
    private String userJSON;
    public VimeoAccount(String string) {
        super();
        this.accessToken = string;
    }

    public VimeoAccount(String string, String string2, String string3, String string4) {
        boolean empty;
        super();
        if (string == null) {
        } else {
            if (string.isEmpty()) {
            } else {
                if (string2 == null) {
                } else {
                    if (string2.isEmpty()) {
                    } else {
                        if (string3 == null) {
                        } else {
                            if (string3.isEmpty()) {
                            } else {
                                this.accessToken = string;
                                this.tokenType = string2;
                                this.scope = string3;
                                GsonBuilder obj2 = new GsonBuilder();
                                this.user = (User)obj2.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create().fromJson(string4, User.class);
                            }
                        }
                    }
                }
            }
        }
        obj2 = new AssertionError("Account can only be created with token, tokenType, scope");
        throw obj2;
    }

    @Override // java.io.Serializable
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // java.io.Serializable
    public String getScope() {
        return this.scope;
    }

    @Override // java.io.Serializable
    public String getTokenType() {
        return this.tokenType;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.User getUser() {
        return this.user;
    }

    @Override // java.io.Serializable
    public String getUserJSON() {
        if (this.user == null) {
            return null;
        }
        String userJSON = this.userJSON;
        if (userJSON != null) {
            return userJSON;
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        String json = gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create().toJson(this.user);
        this.userJSON = json;
        return json;
    }

    @Override // java.io.Serializable
    public boolean isAuthenticated() {
        String accessToken;
        int i;
        accessToken = this.accessToken;
        if (accessToken != null && !accessToken.isEmpty()) {
            i = !accessToken.isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public void setUser(com.vimeo.networking.model.User user) {
        this.user = user;
    }
}
