package com.vimeo.networking.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;

/* compiled from: VimeoAccount.java */
/* loaded from: classes2.dex */
public class VimeoAccount implements Serializable {

    private static final long serialVersionUID = -8341071767843490585L;
    public String accessToken;
    public String scope;
    public String tokenType;
    public User user;
    private String userJSON;
    public String getAccessToken() {
        return this.accessToken;
    }

    public String getScope() {
        return this.scope;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public User getUser() {
        return this.user;
    }

    public String getUserJSON() {
        if (this.user == null) {
            return null;
        }
        if (this.userJSON != null) {
            return this.userJSON;
        }
        String json = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create().toJson(this.user);
        this.userJSON = json;
        return json;
    }

    public boolean isAuthenticated() {
        boolean z = false;
        int r0 = this.accessToken != null && !this.accessToken.isEmpty() ? 1 : 0;
        return (this.accessToken != null && !this.accessToken.isEmpty() ? 1 : 0);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VimeoAccount(String str) {
        super();
        this.accessToken = str;
    }

    public VimeoAccount(String str, String str2, String str3, String str4) {
        super();
        if (str == null) {
            throw new AssertionError("Account can only be created with token, tokenType, scope");
        } else {
            if (!str.isEmpty()) {
                if (str2 != null) {
                    if (!str2.isEmpty()) {
                        if (str3 != null) {
                            if (!str3.isEmpty()) {
                                this.accessToken = str;
                                this.tokenType = str2;
                                this.scope = str3;
                                this.user = (User)new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create().fromJson(str4, User.class);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
