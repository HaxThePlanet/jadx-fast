package com.google.android.exoplayer2.j2;

import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.util.u.a;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class l implements u.a {

    public final com.google.android.exoplayer2.j2.i1.a a;
    public final s b;
    public final v c;
    public final IOException d;
    public final boolean e;
    public l(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3, IOException iOException4, boolean z5) {
        super();
        this.a = a;
        this.b = s2;
        this.c = v3;
        this.d = iOException4;
        this.e = z5;
    }

    @Override // com.google.android.exoplayer2.util.u$a
    public final void invoke(Object object) {
        h1.U0(this.a, this.b, this.c, this.d, this.e, (i1)object);
    }
}
