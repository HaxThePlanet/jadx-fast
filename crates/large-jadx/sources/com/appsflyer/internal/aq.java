package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;

/* loaded from: classes.dex */
public final class aq {
    public static Uri values(Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return activity.getReferrer();
        }
        Intent obj2 = activity.getIntent();
        android.os.Parcelable parcelableExtra = obj2.getParcelableExtra("android.intent.extra.REFERRER");
        if ((Uri)parcelableExtra != null) {
            return (Uri)parcelableExtra;
        }
        obj2 = obj2.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (obj2 != null) {
            return Uri.parse(obj2);
        }
        return null;
    }
}
