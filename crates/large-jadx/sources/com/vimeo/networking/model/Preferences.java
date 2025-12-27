package com.vimeo.networking.model;

import java.io.Serializable;

/* compiled from: Preferences.java */
/* loaded from: classes2.dex */
public class Preferences implements Serializable {

    private static final long serialVersionUID = -251634859829805204L;
    public VideosPreference videos;
    public VideosPreference getVideos() {
        return this.videos;
    }
}
