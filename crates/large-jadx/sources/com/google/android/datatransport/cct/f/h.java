package com.google.android.datatransport.cct.f;

/* loaded from: classes.dex */
final class h extends com.google.android.datatransport.cct.f.n {

    private final long a;
    h(long l) {
        super();
        this.a = l;
    }

    @Override // com.google.android.datatransport.cct.f.n
    public long c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.n
    public boolean equals(Object object) {
        int i;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof n) {
            if (Long.compare(l, l2) == 0) {
            } else {
                i = i2;
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.cct.f.n
    public int hashCode() {
        long l = this.a;
        return i2 ^= i4;
    }

    @Override // com.google.android.datatransport.cct.f.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogResponse{nextRequestWaitMillis=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
