package com.google.firebase.appcheck.interop;

import com.google.android.gms.tasks.j;
import com.google.firebase.appcheck.AppCheckTokenResult;

/* loaded from: classes2.dex */
public interface InternalAppCheckTokenProvider {
    public abstract void addAppCheckTokenListener(com.google.firebase.appcheck.interop.AppCheckTokenListener appCheckTokenListener);

    public abstract j<AppCheckTokenResult> getToken(boolean z);

    public abstract void removeAppCheckTokenListener(com.google.firebase.appcheck.interop.AppCheckTokenListener appCheckTokenListener);
}
