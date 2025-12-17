package com.google.android.exoplayer2.m2.k;

import com.google.android.exoplayer2.m2.a.b;

/* loaded from: classes2.dex */
public abstract class i implements a.b {

    public final String a;
    public i(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public String toString() {
        return this.a;
    }
}
