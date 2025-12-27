package com.vimeo.networking.model;

import java.io.Serializable;

/* compiled from: UploadQuota.java */
/* loaded from: classes2.dex */
public class UploadQuota implements Serializable {

    private static final long serialVersionUID = 4050488085481972886L;
    public Quota quota;
    public Space space;
    public long getFreeUploadSpace() {
        if (this.space != null) {
            return space2.free;
        }
        return -1;
    }
}
