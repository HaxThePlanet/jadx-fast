package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class j extends i {

    final int b;
    final String c;
    final String v;
    final int w;
    final o x;
    final com.google.android.play.core.assetpacks.t y;
    j(com.google.android.play.core.assetpacks.t t, o o2, int i3, String string4, String string5, int i6, o o7) {
        this.y = t;
        this.b = i3;
        this.c = string4;
        this.v = string5;
        this.w = i6;
        this.x = o7;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            n nVar = new n(this.y, this.x);
            (i2)t.r(this.y).e().C0(t.t(this.y), t.l(this.b, this.c, this.v, this.w), t.n(), nVar);
            h hVar = t.q();
            int runtimeException = 4;
            runtimeException = new Object[runtimeException];
            int str2 = 0;
            String valueOf = this.c;
            runtimeException[str2] = valueOf;
            str2 = 1;
            valueOf = this.v;
            runtimeException[str2] = valueOf;
            str2 = 2;
            valueOf = this.w;
            valueOf = Integer.valueOf(valueOf);
            runtimeException[str2] = valueOf;
            str2 = 3;
            valueOf = this.b;
            valueOf = Integer.valueOf(valueOf);
            runtimeException[str2] = valueOf;
            str2 = "getChunkFileDescriptor(%s, %s, %d, session=%d)";
            hVar.b(str2, runtimeException);
            hVar = this.x;
            runtimeException = new RuntimeException(th);
            hVar.d(runtimeException);
        }
    }
}
