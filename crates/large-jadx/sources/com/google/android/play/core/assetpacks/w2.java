package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.play.core.internal.h;

/* loaded from: classes2.dex */
final class w2 {

    private static final h c;
    private final Context a;
    private int b = -1;
    static {
        h hVar = new h("PackageStateCache");
        w2.c = hVar;
    }

    w2(Context context) {
        super();
        final int i = -1;
        this.a = context;
    }

    public final int a() {
        int i;
        int versionCode;
        Object packageManager;
        synchronized (this) {
            try {
                this.b = packageInfo.versionCode;
                int i2 = new Object[i2];
                w2.c.b("The current version of the app could not be retrieved", i2);
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            } catch (Throwable th1) {
            }
            return this.b;
        }
    }
}
