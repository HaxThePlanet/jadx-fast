package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class cm extends com.appsflyer.internal.cl {
    public cm(Runnable runnable) {
        super("samsung", runnable);
    }

    @Override // com.appsflyer.internal.cl
    public final void values(Context context) {
        cm.1 anon = new cm.1(this, context, "com.sec.android.app.samsungapps.referrer", /* result */);
        AFKeystoreWrapper(context, anon);
    }
}
