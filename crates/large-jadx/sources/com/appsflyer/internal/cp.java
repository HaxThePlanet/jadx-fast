package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class cp extends com.appsflyer.internal.cl {
    public cp(Runnable runnable) {
        super("huawei", runnable);
    }

    @Override // com.appsflyer.internal.cl
    public final void values(Context context) {
        cp.1 anon = new cp.1(this, context, "com.huawei.appmarket.commondata", /* result */);
        AFKeystoreWrapper(context, anon);
    }
}
