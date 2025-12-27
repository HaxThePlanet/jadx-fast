package com.bumptech.glide.load.n;

import android.content.Context;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: UnitTransformation.java */
/* loaded from: classes.dex */
public final class c<T> implements l<T> {

    private static final l<?> b = new c<>();

    private c() {
        super();
    }

    public static <T> c<T> c() {
        return (c)c.b;
    }

    public void a(MessageDigest messageDigest) {
    }

    public u<T> b(Context context, u<T> uVar, int i, int i2) {
        return uVar;
    }
}
