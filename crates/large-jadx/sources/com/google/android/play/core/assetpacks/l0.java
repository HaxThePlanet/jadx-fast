package com.google.android.play.core.assetpacks;

import java.util.Map;

/* loaded from: classes2.dex */
final class l0 extends com.google.android.play.core.assetpacks.b {

    private final long a;
    private final Map<String, com.google.android.play.core.assetpacks.AssetPackState> b;
    l0(long l, Map<String, com.google.android.play.core.assetpacks.AssetPackState> map2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    public final Map<String, com.google.android.play.core.assetpacks.AssetPackState> a() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final long b() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final boolean equals(Object object) {
        boolean cmp;
        long l;
        long l2;
        Object obj8;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof b && Long.compare(l, l2) == 0 && this.b.equals(object.a())) {
            if (Long.compare(l, l2) == 0) {
                if (this.b.equals(object.a())) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final int hashCode() {
        long l = this.a;
        int i6 = 1000003;
        return i4 ^= i7;
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final String toString() {
        String valueOf = String.valueOf(this.b);
        StringBuilder stringBuilder = new StringBuilder(length += 61);
        stringBuilder.append("AssetPackStates{totalBytes=");
        stringBuilder.append(this.a);
        stringBuilder.append(", packStates=");
        stringBuilder.append(valueOf);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
