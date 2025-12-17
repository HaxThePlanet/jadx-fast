package com.vimeo.networking.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UploadQuota implements Serializable {

    private static final long serialVersionUID = 4050488085481972886L;
    public com.vimeo.networking.model.Quota quota;
    public com.vimeo.networking.model.Space space;
    @Override // java.io.Serializable
    public long getFreeUploadSpace() {
        com.vimeo.networking.model.Space space = this.space;
        if (space != null) {
            return space.free;
        }
        return -1;
    }
}
