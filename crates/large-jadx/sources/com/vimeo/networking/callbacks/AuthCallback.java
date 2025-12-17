package com.vimeo.networking.callbacks;

import com.vimeo.networking.model.error.VimeoError;

/* loaded from: classes2.dex */
public interface AuthCallback {
    public abstract void failure(VimeoError vimeoError);

    public abstract void success();
}
