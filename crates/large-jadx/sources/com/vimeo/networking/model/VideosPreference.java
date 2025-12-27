package com.vimeo.networking.model;

import java.io.Serializable;

/* compiled from: VideosPreference.java */
/* loaded from: classes2.dex */
public class VideosPreference implements Serializable {

    private static final long serialVersionUID = 1956447486226253433L;
    public String password;
    public String privacy;
    public String getPassword() {
        return this.password;
    }

    public String getPrivacy() {
        return this.privacy;
    }
}
