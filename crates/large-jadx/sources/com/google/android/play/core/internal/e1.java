package com.google.android.play.core.internal;

import android.content.Context;

/* loaded from: classes2.dex */
public final class e1 {
    public static Context a(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        return context;
    }
}
