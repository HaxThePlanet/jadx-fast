package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key.java */
/* loaded from: classes.dex */
public interface f {

    public static final Charset a;
    static {
        f.a = Charset.forName("UTF-8");
    }

    void a(MessageDigest messageDigest);

    boolean equals(Object object);

    int hashCode();
}
