package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.tasks.f;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class p0 {

    private final n1<com.google.android.play.core.assetpacks.d4> a;
    p0(n1<com.google.android.play.core.assetpacks.d4> n1) {
        super();
        this.a = n1;
    }

    final InputStream a(int i, String string2, String string3, int i4) {
        Object fileDescriptor;
        Object obj2 = f.a((d4)this.a.zza().b(i, string2, string3, i4));
        if ((ParcelFileDescriptor)obj2 == null) {
        } else {
            if ((ParcelFileDescriptor)obj2.getFileDescriptor() == null) {
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(obj2);
                return autoCloseInputStream;
            }
        }
        Object[] arr2 = new Object[4];
        g1 g1Var = new g1(String.format("Corrupted ParcelFileDescriptor, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i), string2, string3, Integer.valueOf(i4)), i);
        throw g1Var;
    }
}
