package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class p {

    public static final com.google.android.exoplayer2.audio.p f;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    private AudioAttributes e;

    static class a {
    }

    public static final class b {

        private int a = 0;
        private int b = 0;
        private int c = 1;
        private int d = 1;
        public b() {
            super();
            int i = 0;
            int i2 = 1;
        }

        public com.google.android.exoplayer2.audio.p a() {
            super(this.a, this.b, this.c, this.d, 0);
            return pVar2;
        }
    }
    static {
        p.b bVar = new p.b();
        p.f = bVar.a();
        com.google.android.exoplayer2.audio.a aVar = a.a;
    }

    private p(int i, int i2, int i3, int i4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    p(int i, int i2, int i3, int i4, com.google.android.exoplayer2.audio.p.a p$a5) {
        super(i, i2, i3, i4);
    }

    public AudioAttributes a() {
        AudioAttributes build;
        int i;
        int i2;
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        AudioAttributes.Builder usage = builder.setContentType(this.a).setFlags(this.b).setUsage(this.c);
        if (this.e == null && p0.a >= 29) {
            builder = new AudioAttributes.Builder();
            usage = builder.setContentType(this.a).setFlags(this.b).setUsage(this.c);
            if (p0.a >= 29) {
                usage.setAllowedCapturePolicy(this.d);
            }
            this.e = usage.build();
        }
        return this.e;
    }

    public boolean equals(Object object) {
        int i;
        int i3;
        Class<com.google.android.exoplayer2.audio.p> obj;
        int i2;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (object != null) {
            if (p.class != object.getClass()) {
            } else {
                if (this.a == object.a && this.b == object.b && this.c == object.c && this.d == object.d) {
                    if (this.b == object.b) {
                        if (this.c == object.c) {
                            if (this.d == object.d) {
                            } else {
                                i = i4;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i4;
    }

    public int hashCode() {
        return i11 += i4;
    }
}
