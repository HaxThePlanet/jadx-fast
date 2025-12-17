package com.vimeo.networking.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Preferences implements Serializable {

    private static final long serialVersionUID = -251634859829805204L;
    public com.vimeo.networking.model.VideosPreference videos;
    @Override // java.io.Serializable
    public com.vimeo.networking.model.VideosPreference getVideos() {
        return this.videos;
    }
}
