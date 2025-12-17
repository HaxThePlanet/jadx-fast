package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.f;

/* loaded from: classes2.dex */
public final class j0 {

    private final SparseIntArray a;
    private f b;
    public j0(f f) {
        super();
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.a = sparseIntArray;
        r.j(f);
        this.b = f;
    }

    public final int a(Context context, a.f a$f2) {
        int i3;
        int i2;
        int i;
        int keyAt;
        SparseIntArray sparseIntArray;
        int obj6;
        r.j(context);
        r.j(f2);
        i = 0;
        if (!f2.requiresGooglePlayServices()) {
            return i;
        }
        final int obj7 = f2.getMinApkVersion();
        final int i4 = -1;
        if (b(context, obj7) != i4) {
        } else {
            i3 = i;
            while (i3 < this.a.size()) {
                keyAt = this.a.keyAt(i3);
                i3++;
            }
            i = i4;
            if (i == i4) {
                i2 = obj6;
            } else {
                i2 = i;
            }
            this.a.put(obj7, i2);
        }
        return i2;
    }

    public final int b(Context context, int i2) {
        return this.a.get(i2, -1);
    }

    public final void c() {
        this.a.clear();
    }
}
