package com.google.android.exoplayer2.upstream;

import android.content.Context;

/* loaded from: classes2.dex */
public final class r implements com.google.android.exoplayer2.upstream.l.a {

    private final Context a;
    private final com.google.android.exoplayer2.upstream.b0 b;
    private final com.google.android.exoplayer2.upstream.l.a c;
    public r(Context context) {
        final int i = 0;
        super(context, i, i);
    }

    public r(Context context, com.google.android.exoplayer2.upstream.b0 b02, com.google.android.exoplayer2.upstream.l.a l$a3) {
        super();
        this.a = context.getApplicationContext();
        this.b = b02;
        this.c = a3;
    }

    public r(Context context, String string2, com.google.android.exoplayer2.upstream.b0 b03) {
        s.b bVar = new s.b();
        bVar.d(string2);
        super(context, b03, bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.l$a
    public com.google.android.exoplayer2.upstream.l a() {
        return b();
    }

    @Override // com.google.android.exoplayer2.upstream.l$a
    public com.google.android.exoplayer2.upstream.q b() {
        q qVar = new q(this.a, this.c.a());
        com.google.android.exoplayer2.upstream.b0 b0Var = this.b;
        if (b0Var != null) {
            qVar.d(b0Var);
        }
        return qVar;
    }
}
