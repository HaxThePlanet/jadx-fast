package com.google.android.exoplayer2.m2.i;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.d;
import com.google.android.exoplayer2.m2.g;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b extends g {
    @Override // com.google.android.exoplayer2.m2.g
    protected a b(d d, ByteBuffer byteBuffer2) {
        com.google.android.exoplayer2.m2.a.b[] arr = new a.b[1];
        d0 d0Var = new d0(byteBuffer2.array(), byteBuffer2.limit());
        a obj4 = new a(arr);
        return obj4;
    }

    @Override // com.google.android.exoplayer2.m2.g
    public com.google.android.exoplayer2.m2.i.a c(d0 d0) {
        String str = d0.s();
        g.e(str);
        String str2 = d0.s();
        g.e(str2);
        super((String)str, (String)str2, d0.r(), obj5, d0.r(), obj7, Arrays.copyOfRange(d0.d(), d0.e(), d0.f()));
        return obj10;
    }
}
