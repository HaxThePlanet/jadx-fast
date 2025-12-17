package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.p0;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class c0 implements com.google.android.exoplayer2.drm.a0 {

    public static final boolean d = false;
    public final UUID a;
    public final byte[] b;
    public final boolean c;
    static {
        String equals2;
        boolean equals;
        equals2 = p0.d;
        if ("Amazon".equals(p0.c) && !"AFTM".equals(equals2)) {
            equals2 = p0.d;
            if ("AFTM".equals(equals2)) {
                int i = 1;
            }
            if ("AFTB".equals(equals2)) {
            }
        }
        int i2 = 0;
    }

    public c0(UUID uUID, byte[] b2Arr2, boolean z3) {
        super();
        this.a = uUID;
        this.b = b2Arr2;
        this.c = z3;
    }
}
