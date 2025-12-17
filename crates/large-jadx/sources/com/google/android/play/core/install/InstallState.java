package com.google.android.play.core.install;

import android.content.Intent;
import com.google.android.play.core.internal.h;

/* loaded from: classes2.dex */
public abstract class InstallState {
    public static com.google.android.play.core.install.InstallState f(Intent intent, h h2) {
        Object obj = intent;
        Object obj2 = h2;
        final int i = 0;
        obj2.a("List of extras in received intent needed by fromUpdateIntent:", new Object[i]);
        int i2 = 2;
        Object[] arr3 = new Object[i2];
        String str6 = "install.status";
        arr3[i] = str6;
        final int i4 = 1;
        arr3[i4] = Integer.valueOf(obj.getIntExtra(str6, i));
        String str7 = "Key: %s; value: %s";
        obj2.a(str7, arr3);
        Object[] arr2 = new Object[i2];
        String str5 = "error.code";
        arr2[i] = str5;
        arr2[i4] = Integer.valueOf(obj.getIntExtra(str5, i));
        obj2.a(str7, arr2);
        int i3 = 0;
        super(obj.getIntExtra(str6, i), obj.getLongExtra("bytes.downloaded", i3), obj12, obj.getLongExtra("total.bytes.to.download", i3), obj14, obj.getIntExtra(str5, i), obj.getStringExtra("package.name"));
        return bVar;
    }

    public abstract long a();

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract long e();
}
