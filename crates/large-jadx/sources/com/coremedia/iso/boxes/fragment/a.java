package com.coremedia.iso.boxes.fragment;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* compiled from: SampleFlags.java */
/* loaded from: classes.dex */
public class a {

    private byte a;
    private byte b;
    private byte c;
    private byte d;
    private byte e;
    private byte f;
    private boolean g;
    private int h;
    public void a(ByteBuffer byteBuffer) {
        g.g(byteBuffer, (l | (long)(this.b << 26)) | (long)(this.c << 24) | (long)(this.d << 22) | (long)(this.e << 20) | (long)(this.f << 17) | (long)(this.g << 16) | (long)this.h);
    }

    public boolean b() {
        return this.g;
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = a.class;
            if (obj == object.getClass()) {
                if (this.b != object.b) {
                    return false;
                }
                if (this.a != object.a) {
                    return false;
                }
                if (this.h != object.h) {
                    return false;
                }
                if (this.c != object.c) {
                    return false;
                }
                if (this.e != object.e) {
                    return false;
                }
                if (this.d != object.d) {
                    return false;
                }
                if (this.g != object.g) {
                    return false;
                }
                return this.f != object.f ? z2 : z;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b * 31 + this.c * 31 + this.d * 31 + this.e * 31 + this.f * 31 + this.g * 31 + this.h;
    }

    public String toString() {
        String str2 = "SampleFlags{reserved=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", isLeading=";
        String str4 = ", depOn=";
        String str5 = ", isDepOn=";
        String str6 = ", hasRedundancy=";
        String str7 = ", padValue=";
        String str8 = ", isDiffSample=";
        String str9 = ", degradPrio=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7 + this.f + str8 + this.g + str9 + this.h + 125;
        return str;
    }

    public a(ByteBuffer byteBuffer) {
        int i = 1;
        super();
        long l = e.k(byteBuffer);
        this.a = (byte)(int)(-268435456L & l) >> 28L;
        this.b = (byte)(int)(201326592L & l) >> 26L;
        this.c = (byte)(int)(50331648L & l) >> 24L;
        this.d = (byte)(int)(12582912L & l) >> 22L;
        this.e = (byte)(int)(3145728L & l) >> 20L;
        this.f = (byte)(int)(917504L & l) >> 17L;
        long l16 = (65536L & l) >> 16L;
        byteBuffer = l16 > 0 ? 1 : 0;
        this.g = (l16 > 0 ? 1 : 0);
        this.h = (l16 > 0 ? 1 : 0);
    }
}
