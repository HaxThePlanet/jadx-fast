package com.google.android.exoplayer2.text.n;

import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends d {

    private final com.google.android.exoplayer2.text.n.b n;
    public a(List<byte[]> list) {
        super("DvbDecoder");
        d0 d0Var = new d0((byte[])list.get(0));
        b bVar = new b(d0Var.D(), d0Var.D());
        this.n = bVar;
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        com.google.android.exoplayer2.text.n.b obj4;
        if (z3 != null) {
            this.n.r();
        }
        obj4 = new c(this.n.b(bArr, i2));
        return obj4;
    }
}
