package com.bumptech.glide.load.n;

import android.content.Context;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c<T>  implements l<T> {

    private static final l<?> b;
    static {
        c cVar = new c();
        c.b = cVar;
    }

    public static <T> com.bumptech.glide.load.n.c<T> c() {
        return (c)c.b;
    }

    @Override // com.bumptech.glide.load.l
    public void a(MessageDigest messageDigest) {
    }

    public u<T> b(Context context, u<T> u2, int i3, int i4) {
        return u2;
    }
}
