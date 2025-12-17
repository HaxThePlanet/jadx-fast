package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* loaded from: classes2.dex */
public interface i {
    public abstract <T extends com.google.android.gms.common.api.internal.LifecycleCallback> T i0(String string, Class<T> class2);

    public abstract Activity j0();

    public abstract void q(String string, com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback2);

    public abstract void startActivityForResult(Intent intent, int i2);
}
