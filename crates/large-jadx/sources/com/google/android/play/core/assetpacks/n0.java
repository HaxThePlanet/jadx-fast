package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class n0 extends com.google.android.play.core.assetpacks.m3 {

    private final String a;
    private final long b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final byte[] f;
    n0(String string, long l2, int i3, boolean z4, boolean z5, byte[] b6Arr6) {
        super();
        this.a = string;
        this.b = l2;
        this.c = z4;
        this.d = z5;
        this.e = b6Arr6;
        this.f = obj7;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    final int a() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    final long b() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    final String c() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    final boolean d() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    final boolean e() {
        return this.d;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    public final boolean equals(Object object) {
        boolean equals;
        String str;
        long l;
        byte[] obj8;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof m3) {
            String str2 = this.a;
            if (str2 == null) {
                if ((m3)object.c() == null) {
                    if (Long.compare(str, l) == 0) {
                        if (this.c == object.a()) {
                            if (this.d == object.e()) {
                                if (this.e == object.d()) {
                                    if (object instanceof n0) {
                                        obj8 = object.f;
                                    } else {
                                        obj8 = (n0)object.f();
                                    }
                                    if (Arrays.equals(this.f, obj8)) {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (str2.equals(object.c()) && Long.compare(str, l) == 0 && this.c == object.a() && this.d == object.e() && this.e == object.d()) {
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    final byte[] f() {
        return this.f;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    public final int hashCode() {
        int i3;
        int i2;
        int i;
        String str = this.a;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.hashCode();
        }
        long l = this.b;
        final int i19 = 1000003;
        int i22 = 1231;
        final int i23 = 1;
        i2 = i23 != this.d ? i : i22;
        if (i23 != this.e) {
        } else {
            i = i22;
        }
        return i13 ^= i18;
    }

    @Override // com.google.android.play.core.assetpacks.m3
    public final String toString() {
        String str = this.a;
        String string2 = Arrays.toString(this.f);
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append("ZipEntry{name=");
        stringBuilder.append(str);
        stringBuilder.append(", size=");
        stringBuilder.append(this.b);
        stringBuilder.append(", compressionMethod=");
        stringBuilder.append(this.c);
        stringBuilder.append(", isPartial=");
        stringBuilder.append(this.d);
        stringBuilder.append(", isEndOfArchive=");
        stringBuilder.append(this.e);
        stringBuilder.append(", headerBytes=");
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
