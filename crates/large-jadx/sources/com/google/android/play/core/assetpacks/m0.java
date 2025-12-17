package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
final class m0 extends com.google.android.play.core.assetpacks.f3 {

    private final int a;
    private final String b;
    private final long c;
    private final long d;
    private final int e;
    m0(int i, String string2, long l3, long l4, int i5) {
        super();
        this.a = i;
        this.b = string2;
        this.c = l3;
        this.d = i5;
        this.e = obj7;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    final int a() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    final int b() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    final long c() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    final long d() {
        return this.d;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    final String e() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    public final boolean equals(Object object) {
        boolean equals;
        String i;
        long l;
        Object obj8;
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (object instanceof f3 && this.a == (f3)object.a()) {
            if (this.a == (f3)object.a()) {
                String str = this.b;
                if (str == null) {
                    if (object.e() == null) {
                        if (Long.compare(i, l) == 0 && Long.compare(i, l) == 0 && this.e == object.b()) {
                            if (Long.compare(i, l) == 0) {
                                if (this.e == object.b()) {
                                    return i2;
                                }
                            }
                        }
                    }
                } else {
                    if (!str.equals(object.e())) {
                    } else {
                    }
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    public final int hashCode() {
        int i;
        int i12 = 1000003;
        String str = this.b;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        long l = this.c;
        final long l2 = this.d;
        int i14 = 32;
        return i10 ^= i13;
    }

    @Override // com.google.android.play.core.assetpacks.f3
    public final String toString() {
        final String str6 = this.b;
        StringBuilder stringBuilder = new StringBuilder(length += 157);
        stringBuilder.append("SliceCheckpoint{fileExtractionStatus=");
        stringBuilder.append(this.a);
        stringBuilder.append(", filePath=");
        stringBuilder.append(str6);
        stringBuilder.append(", fileOffset=");
        stringBuilder.append(this.c);
        stringBuilder.append(", remainingBytes=");
        stringBuilder.append(this.d);
        stringBuilder.append(", previousChunk=");
        stringBuilder.append(this.e);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
