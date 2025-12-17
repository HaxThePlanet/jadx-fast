package com.vimeo.networking.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class VideosPreference implements Serializable {

    private static final long serialVersionUID = 1956447486226253433L;
    public String password;
    public String privacy;
    @Override // java.io.Serializable
    public String getPassword() {
        return this.password;
    }

    @Override // java.io.Serializable
    public String getPrivacy() {
        return this.privacy;
    }
}
