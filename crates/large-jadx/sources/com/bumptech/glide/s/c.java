package com.bumptech.glide.s;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c implements f {

    private static final com.bumptech.glide.s.c b;
    static {
        c cVar = new c();
        c.b = cVar;
    }

    public static com.bumptech.glide.s.c c() {
        return c.b;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
    }

    @Override // com.bumptech.glide.load.f
    public String toString() {
        return "EmptySignature";
    }
}
