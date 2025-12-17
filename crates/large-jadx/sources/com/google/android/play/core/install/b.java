package com.google.android.play.core.install;

import java.util.Objects;

/* loaded from: classes2.dex */
final class b extends com.google.android.play.core.install.InstallState {

    private final int a;
    private final long b;
    private final long c;
    private final int d;
    private final String e;
    b(int i, long l2, long l3, int i4, String string5) {
        super();
        this.a = i;
        this.b = l2;
        this.c = i4;
        this.d = obj6;
        Objects.requireNonNull(obj7, "Null packageName");
        this.e = obj7;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.c;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final boolean equals(Object object) {
        boolean cmp;
        int i;
        long l;
        Object obj8;
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (object instanceof InstallState && this.a == (InstallState)object.c() && Long.compare(i, l) == 0 && Long.compare(i, l) == 0 && this.d == object.b() && this.e.equals(object.d())) {
            if (this.a == (InstallState)object.c()) {
                if (Long.compare(i, l) == 0) {
                    if (Long.compare(i, l) == 0) {
                        if (this.d == object.b()) {
                            if (this.e.equals(object.d())) {
                                return i2;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int hashCode() {
        long l = this.b;
        final long l2 = this.c;
        final int i18 = 1000003;
        final int i19 = 32;
        return i9 ^= i17;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String toString() {
        final String str6 = this.e;
        StringBuilder stringBuilder = new StringBuilder(length += 164);
        stringBuilder.append("InstallState{installStatus=");
        stringBuilder.append(this.a);
        stringBuilder.append(", bytesDownloaded=");
        stringBuilder.append(this.b);
        stringBuilder.append(", totalBytesToDownload=");
        stringBuilder.append(this.c);
        stringBuilder.append(", installErrorCode=");
        stringBuilder.append(this.d);
        stringBuilder.append(", packageName=");
        stringBuilder.append(str6);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
