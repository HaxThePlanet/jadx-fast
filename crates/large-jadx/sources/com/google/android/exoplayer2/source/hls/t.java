package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q.b;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.text.u.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class t implements i {

    private static final Pattern g;
    private static final Pattern h;
    private final String a;
    private final m0 b;
    private final d0 c;
    private k d;
    private byte[] e;
    private int f;
    static {
        t.g = Pattern.compile("LOCAL:([^,]+)");
        t.h = Pattern.compile("MPEGTS:(-?\\d+)");
    }

    public t(String string, m0 m02) {
        super();
        this.a = string;
        this.b = m02;
        d0 obj1 = new d0();
        this.c = obj1;
        this.e = new byte[1024];
    }

    @RequiresNonNull("output")
    private s e(long l) {
        s sVar = this.d.t(0, 3);
        i1.b bVar = new i1.b();
        bVar.e0("text/vtt");
        bVar.V(this.a);
        bVar.i0(l);
        sVar.e(bVar.E());
        this.d.n();
        return sVar;
    }

    @RequiresNonNull("output")
    private void f() {
        String concat;
        String concat2;
        String group;
        String valueOf;
        String valueOf2;
        int i;
        long matcher;
        int i3;
        int find;
        boolean startsWith;
        int i2;
        d0 d0Var = new d0(this.e);
        j.e(d0Var);
        group = d0Var.o();
        int i6 = 0;
        i3 = i;
        i2 = 1;
        while (!TextUtils.isEmpty(group)) {
            group = d0Var.o();
            i2 = 1;
            Matcher matcher3 = t.g.matcher(group);
            int i10 = 0;
            matcher = t.h.matcher(group);
            String group3 = matcher3.group(i2);
            g.e(group3);
            i3 = j.d((String)group3);
            group = matcher.group(i2);
            g.e(group);
            i = m0.f(Long.parseLong((String)group));
        }
        Matcher matcher2 = j.a(d0Var);
        if (matcher2 == null) {
            e(i6);
        }
        String group2 = matcher2.group(i2);
        g.e(group2);
        long l = j.d((String)group2);
        i8 -= i3;
        long l3 = this.b.b(m0.j(i9));
        s sVar = e(l3 - l);
        this.c.G(this.e, this.f);
        sVar.c(this.c, this.f);
        sVar.d(l3, find, 1, this.f, 0);
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void a(k k) {
        this.d = k;
        q.b bVar = new q.b(-9223372036854775807L, obj2);
        k.d(bVar);
    }

    @Override // com.google.android.exoplayer2.l2.i
    public boolean b(j j) {
        int i = 0;
        final int i3 = 6;
        j.e(this.e, i, i3, i);
        this.c.G(this.e, i3);
        if (j.b(this.c)) {
            return 1;
        }
        j.e(this.e, i3, 3, i);
        this.c.G(this.e, 9);
        return j.b(this.c);
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        int copyOf;
        byte[] bArr;
        int length;
        g.e(this.d);
        int obj6 = (int)length2;
        byte[] bArr2 = this.e;
        final int i6 = -1;
        if (this.f == bArr2.length) {
            length = obj6 != i6 ? obj6 : bArr2.length;
            this.e = Arrays.copyOf(bArr2, i2 /= 2);
        }
        bArr = this.e;
        int i4 = this.f;
        int obj5 = j.read(bArr, i4, length4 -= i4);
        i += obj5;
        this.f = bArr;
        if (obj5 != i6 && obj6 != i6 && bArr != obj6) {
            i += obj5;
            this.f = bArr;
            if (obj6 != i6) {
                if (bArr != obj6) {
                }
            }
            return 0;
        }
        f();
        return i6;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void d(long l, long l2) {
        IllegalStateException obj1 = new IllegalStateException();
        throw obj1;
    }
}
