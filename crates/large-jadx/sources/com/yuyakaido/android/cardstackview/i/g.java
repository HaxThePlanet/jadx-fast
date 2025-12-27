package com.yuyakaido.android.cardstackview.i;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: DisplayUtil.java */
/* loaded from: classes2.dex */
public final class g {
    public static int a(Context context, float f) {
        return (int)(f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }
}
