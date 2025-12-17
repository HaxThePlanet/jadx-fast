package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public interface f {

    public static final Charset a;
    static {
        f.a = Charset.forName("UTF-8");
    }

    public abstract void a(MessageDigest messageDigest);

    public abstract boolean equals(Object object);

    public abstract int hashCode();
}
