package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.c.b;

/* loaded from: classes2.dex */
public abstract class AssetPackState {
    public static com.google.android.play.core.assetpacks.AssetPackState h(String string, int i2, int i3, long l4, long l5, double d6, int i7, String string8, String string9) {
        super(string, i2, i3, l4, obj5, d6, obj7, (int)rint, obj22, obj23, obj24);
        return k0Var2;
    }

    static com.google.android.play.core.assetpacks.AssetPackState i(Bundle bundle, String string2, com.google.android.play.core.assetpacks.k1 k13, com.google.android.play.core.assetpacks.u2 u24, com.google.android.play.core.assetpacks.c0 c05) {
        int cmp;
        int i2;
        int i;
        int i3;
        Object obj = bundle;
        String str2 = string2;
        cmp = c05.a(obj.getInt(b.a("status", str2)), str2);
        long long = obj.getLong(b.a("bytes_downloaded", str2));
        long long2 = obj.getLong(b.a("total_bytes_to_download", str2));
        double d2 = k13.a(str2);
        long long4 = obj.getLong(b.a("pack_base_version", str2));
        i2 = 1;
        if (cmp == 4) {
            if (Long.compare(long4, i3) != 0 && Long.compare(long4, long3) != 0) {
                if (Long.compare(long4, long3) != 0) {
                    i2 = cmp;
                }
            }
        } else {
            i = cmp;
        }
        return AssetPackState.h(string2, i, obj.getInt(b.a("error_code", str2)), long, long, long2, long2, d2, d2);
    }

    public abstract long a();

    public abstract int b();

    public abstract String c();

    public abstract int d();

    public abstract long e();

    public abstract int f();

    public abstract int g();

    public abstract String j();

    public abstract String k();
}
