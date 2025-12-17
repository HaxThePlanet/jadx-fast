package com.google.android.play.core.assetpacks;

import java.util.Objects;

/* loaded from: classes2.dex */
final class k0 extends com.google.android.play.core.assetpacks.AssetPackState {

    private final String a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final int f;
    private final int g;
    private final String h;
    private final String i;
    k0(String string, int i2, int i3, long l4, long l5, int i6, int i7, String string8, String string9) {
        super();
        Objects.requireNonNull(string, "Null name");
        this.a = string;
        this.b = i2;
        this.c = i3;
        this.d = l4;
        this.e = i6;
        this.f = string8;
        this.g = string9;
        Objects.requireNonNull(obj11, "Null availableVersionTag");
        this.h = obj11;
        Objects.requireNonNull(obj12, "Null installedVersionTag");
        this.i = obj12;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long a() {
        return this.d;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String c() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int d() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long e() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final boolean equals(Object object) {
        boolean equals;
        String str;
        long l;
        Object obj8;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof AssetPackState && this.a.equals((AssetPackState)object.c()) && this.b == object.d() && this.c == object.b() && Long.compare(str, l) == 0 && Long.compare(str, l) == 0 && this.f == object.f() && this.g == object.g() && this.h.equals(object.j()) && this.i.equals(object.k())) {
            if (this.a.equals((AssetPackState)object.c())) {
                if (this.b == object.d()) {
                    if (this.c == object.b()) {
                        if (Long.compare(str, l) == 0) {
                            if (Long.compare(str, l) == 0) {
                                if (this.f == object.f()) {
                                    if (this.g == object.g()) {
                                        if (this.h.equals(object.j())) {
                                            if (this.i.equals(object.k())) {
                                                return i;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int f() {
        return this.f;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int g() {
        return this.g;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int hashCode() {
        final long l = this.d;
        final long l2 = this.e;
        final int i31 = 1000003;
        int i20 = 32;
        return i17 ^= i27;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String j() {
        return this.h;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String k() {
        return this.i;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String toString() {
        String str = this.a;
        final String str11 = this.h;
        final String str12 = this.i;
        StringBuilder stringBuilder = new StringBuilder(i6 += length3);
        stringBuilder.append("AssetPackState{name=");
        stringBuilder.append(str);
        stringBuilder.append(", status=");
        stringBuilder.append(this.b);
        stringBuilder.append(", errorCode=");
        stringBuilder.append(this.c);
        stringBuilder.append(", bytesDownloaded=");
        stringBuilder.append(this.d);
        stringBuilder.append(", totalBytesToDownload=");
        stringBuilder.append(this.e);
        stringBuilder.append(", transferProgressPercentage=");
        stringBuilder.append(this.f);
        stringBuilder.append(", updateAvailability=");
        stringBuilder.append(this.g);
        stringBuilder.append(", availableVersionTag=");
        stringBuilder.append(str11);
        stringBuilder.append(", installedVersionTag=");
        stringBuilder.append(str12);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
