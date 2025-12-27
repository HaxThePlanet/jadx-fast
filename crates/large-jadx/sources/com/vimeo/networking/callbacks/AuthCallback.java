package com.vimeo.networking.callbacks;

import com.vimeo.networking.model.error.VimeoError;

/* compiled from: AuthCallback.java */
/* loaded from: classes2.dex */
public interface AuthCallback {
    void failure(VimeoError th);

    void success();
}
