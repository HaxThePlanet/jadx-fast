package com.vimeo.networking.model.playback;

import com.vimeo.networking.model.VideoFile;
import java.io.Serializable;

/* compiled from: Drm.java */
/* loaded from: classes2.dex */
public class Drm implements Serializable {

    private static final long serialVersionUID = 3048847922257143776L;
    public VideoFile mPlayReady;
    public VideoFile mWidevine;
    public VideoFile getPlayReady() {
        return this.mPlayReady;
    }

    public VideoFile getWidevine() {
        return this.mWidevine;
    }
}
