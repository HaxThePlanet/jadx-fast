package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class a0 {

    public static final com.google.android.exoplayer2.video.a0 e;
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    static {
        final int i = 0;
        a0 a0Var = new a0(i, i);
        a0.e = a0Var;
        com.google.android.exoplayer2.video.l lVar = l.a;
    }

    public a0(int i, int i2) {
        super(i, i2, 0, 1065353216);
    }

    public a0(int i, int i2, int i3, float f4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f4;
    }

    public boolean equals(Object object) {
        int i2;
        int i3;
        int i;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (object instanceof a0) {
            if (this.a == object.a && this.b == object.b && this.c == object.c && Float.compare(i3, obj5) == 0) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (Float.compare(i3, obj5) == 0) {
                        } else {
                            i2 = i4;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i2;
        }
        return i4;
    }

    public int hashCode() {
        return i10 += floatToRawIntBits;
    }
}
