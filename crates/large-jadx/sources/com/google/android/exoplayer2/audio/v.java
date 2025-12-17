package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class v {

    public final int a;
    public final float b;
    public v(int i, float f2) {
        super();
        this.a = i;
        this.b = f2;
    }

    public boolean equals(Object object) {
        int i;
        float i2;
        Class<com.google.android.exoplayer2.audio.v> obj;
        Class class;
        int obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (v.class != object.getClass()) {
            } else {
                if (this.a == object.a && Float.compare(object.b, this.b) == 0) {
                    if (Float.compare(object.b, this.b) == 0) {
                    } else {
                        i = i3;
                    }
                } else {
                }
            }
            return i;
        }
        return i3;
    }

    public int hashCode() {
        return i4 += floatToIntBits;
    }
}
