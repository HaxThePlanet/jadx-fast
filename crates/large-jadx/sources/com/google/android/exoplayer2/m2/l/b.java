package com.google.android.exoplayer2.m2.l;

import com.google.android.exoplayer2.m2.a.b;

/* loaded from: classes2.dex */
public abstract class b implements a.b {
    @Override // com.google.android.exoplayer2.m2.a$b
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public String toString() {
        String concat;
        String valueOf = String.valueOf(getClass().getSimpleName());
        final String str = "SCTE-35 splice command: type=";
        if (valueOf.length() != 0) {
            concat = str.concat(valueOf);
        } else {
            concat = new String(str);
        }
        return concat;
    }
}
