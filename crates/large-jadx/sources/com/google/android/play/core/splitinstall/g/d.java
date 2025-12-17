package com.google.android.play.core.splitinstall.g;

import java.util.Map;

/* loaded from: classes2.dex */
final class d extends com.google.android.play.core.splitinstall.g.r {

    private final Integer b;
    private final Map<String, Integer> c;
    d(Integer integer, Map map2, com.google.android.play.core.splitinstall.g.c c3) {
        super();
        this.b = integer;
        this.c = map2;
    }

    @Override // com.google.android.play.core.splitinstall.g.r
    public final Integer a() {
        return this.b;
    }

    public final Map<String, Integer> b() {
        return this.c;
    }

    @Override // com.google.android.play.core.splitinstall.g.r
    public final boolean equals(Object object) {
        boolean equals;
        Integer num;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof r) {
            Integer num2 = this.b;
            if (num2 == null) {
                if ((r)object.a() == null) {
                    if (this.c.equals(object.b())) {
                        return i;
                    }
                }
            } else {
                if (num2.equals(object.a()) && this.c.equals(object.b())) {
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.splitinstall.g.r
    public final int hashCode() {
        int i;
        Integer num = this.b;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.android.play.core.splitinstall.g.r
    public final String toString() {
        String valueOf = String.valueOf(this.b);
        String valueOf2 = String.valueOf(this.c);
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append("LocalTestingConfig{defaultSplitInstallErrorCode=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", splitInstallErrorCodeByModule=");
        stringBuilder.append(valueOf2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
