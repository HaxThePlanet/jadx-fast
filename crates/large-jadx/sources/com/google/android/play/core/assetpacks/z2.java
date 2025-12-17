package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.k1;
import com.google.android.play.core.internal.n1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
final class z2 {

    private static final h c;
    private final com.google.android.play.core.assetpacks.f0 a;
    private final n1<com.google.android.play.core.assetpacks.d4> b;
    static {
        h hVar = new h("PatchSliceTaskHandler");
        z2.c = hVar;
    }

    z2(com.google.android.play.core.assetpacks.f0 f0, n1<com.google.android.play.core.assetpacks.d4> n12) {
        super();
        this.a = f0;
        this.b = n12;
    }

    public final void a(com.google.android.play.core.assetpacks.y2 y2) {
        Object inputStream;
        int gZIPInputStream;
        String str;
        File file4 = new File(this.a.v(y2.b, y2.c, y2.d), y2.h);
        int i = 2;
        int i6 = 0;
        if (y2.g != i) {
        } else {
            gZIPInputStream = new GZIPInputStream(y2.j, 8192);
            inputStream = gZIPInputStream;
        }
        i0 i0Var = new i0(this.a.u(y2.b, y2.c, y2.d), file4);
        final long l5 = y2.f;
        File file2 = this.a.C(y2.b, y2.e, l5, obj12);
        if (file2.exists() == null) {
            file2.mkdirs();
        }
        String str11 = y2.b;
        super(this.a, str11, y2.e, y2.f, l5, y2.h);
        j1 j1Var = new j1(file2, g3Var2);
        k1.a(i0Var, inputStream, j1Var, y2.i);
        g3Var2.i(i6);
        inputStream.close();
        Object[] arr = new Object[i];
        arr[i6] = y2.h;
        arr[1] = y2.b;
        z2.c.d("Patching and extraction finished for slice %s of pack %s.", arr);
        (d4)this.b.zza().d(y2.a, y2.b, y2.h, i6);
        y2.j.close();
    }
}
