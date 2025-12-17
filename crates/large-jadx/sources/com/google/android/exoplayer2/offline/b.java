package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.x.a;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
public final class b<T extends com.google.android.exoplayer2.offline.a<T>>  implements x.a<T> {

    private final x.a<? extends T> a;
    private final List<com.google.android.exoplayer2.offline.c> b;
    public b(x.a<? extends T> x$a, List<com.google.android.exoplayer2.offline.c> list2) {
        super();
        this.a = a;
        this.b = list2;
    }

    @Override // com.google.android.exoplayer2.upstream.x$a
    public Object a(Uri uri, InputStream inputStream2) {
        return b(uri, inputStream2);
    }

    public T b(Uri uri, InputStream inputStream2) {
        Object obj2;
        List obj3;
        obj3 = this.b;
        if (obj3 != null) {
            if (obj3.isEmpty()) {
            } else {
                obj2 = (a)this.a.a(uri, inputStream2).a(this.b);
            }
        }
        return obj2;
    }
}
