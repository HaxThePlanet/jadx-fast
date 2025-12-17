package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
final class j0 extends com.google.android.play.core.assetpacks.a {

    private final int a;
    private final String b;
    private final String c;
    j0(int i, String string2, String string3) {
        super();
        this.a = i;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final String a() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final String c() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final boolean equals(Object object) {
        boolean equals;
        String i;
        boolean obj5;
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (object instanceof a && this.a == (a)object.b()) {
            if (this.a == (a)object.b()) {
                String str = this.b;
                if (str == null) {
                    if (object.c() == null) {
                        equals = this.c;
                        if (equals == null) {
                            if (object.a() == null) {
                            }
                        } else {
                            if (!equals.equals(object.a())) {
                            }
                        }
                        return i2;
                    }
                } else {
                    if (str.equals(object.c())) {
                    }
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final int hashCode() {
        int i;
        int i2;
        int i9 = 1000003;
        String str2 = this.b;
        if (str2 == null) {
            i = i2;
        } else {
            i = str2.hashCode();
        }
        String str = this.c;
        if (str == null) {
        } else {
            i2 = str.hashCode();
        }
        return i7 ^= i2;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final String toString() {
        final String str4 = this.b;
        final String str5 = this.c;
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append("AssetPackLocation{packStorageMethod=");
        stringBuilder.append(this.a);
        stringBuilder.append(", path=");
        stringBuilder.append(str4);
        stringBuilder.append(", assetsPath=");
        stringBuilder.append(str5);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
