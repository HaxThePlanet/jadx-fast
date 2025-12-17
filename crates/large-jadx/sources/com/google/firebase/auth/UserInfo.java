package com.google.firebase.auth;

import android.net.Uri;

/* loaded from: classes2.dex */
public interface UserInfo {
    public abstract String getDisplayName();

    public abstract String getEmail();

    public abstract String getPhoneNumber();

    public abstract Uri getPhotoUrl();

    public abstract String getProviderId();

    public abstract String getUid();

    public abstract boolean isEmailVerified();
}
