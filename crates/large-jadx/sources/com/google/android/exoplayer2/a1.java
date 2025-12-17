package com.google.android.exoplayer2;

import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
public class a1 implements com.google.android.exoplayer2.l1 {

    private final o a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final long h;
    private final boolean i;
    private int j;
    private boolean k;
    public a1() {
        o oVar = new o(1, 65536);
        super(oVar, 50000, 50000, 2500, 5000, -1, 0, 0, 0);
    }

    protected a1(o o, int i2, int i3, int i4, int i5, int i6, boolean z7, int i8, boolean z9) {
        int obj11;
        super();
        final int i = 0;
        String str = "bufferForPlaybackMs";
        final String str4 = "0";
        a1.a(i4, i, str, str4);
        final String str5 = "bufferForPlaybackAfterRebufferMs";
        a1.a(i5, i, str5, str4);
        final String str6 = "minBufferMs";
        a1.a(i2, i4, str6, str);
        a1.a(i2, i5, str6, str5);
        a1.a(i3, i2, "maxBufferMs", str6);
        a1.a(i8, i, "backBufferDurationMs", str4);
        this.a = o;
        this.b = w0.d((long)i2);
        this.c = w0.d((long)i3);
        this.d = w0.d((long)i4);
        this.e = w0.d((long)i5);
        this.f = i6;
        if (i6 != -1) {
        } else {
            obj11 = 13107200;
        }
        this.j = obj11;
        this.g = z7;
        this.h = w0.d((long)i8);
        this.i = z9;
    }

    private static void a(int i, int i2, String string3, String string4) {
        int obj1;
        obj1 = i >= i2 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(obj2 += length);
        stringBuilder.append(string3);
        stringBuilder.append(" cannot be less than ");
        stringBuilder.append(string4);
        g.b(obj1, stringBuilder.toString());
    }

    private static int c(int i) {
        int i2;
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 5 && i != 6) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                } else {
                                    return 0;
                                }
                                IllegalArgumentException obj2 = new IllegalArgumentException();
                                throw obj2;
                            }
                        }
                    }
                    return 131072;
                }
                return 131072000;
            }
            return 13107200;
        }
        return 144310272;
    }

    private void m(boolean z) {
        int i;
        o obj3;
        if (this.f == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z != null) {
            this.a.g();
        }
    }

    @Override // com.google.android.exoplayer2.l1
    protected int b(com.google.android.exoplayer2.z1[] z1Arr, g[] g2Arr2) {
        int i2;
        int i;
        Object obj;
        i = i2;
        for (Object obj2 : z1Arr) {
            if (g2Arr2[i2] != null) {
            }
            i += obj;
        }
        return Math.max(13107200, i);
    }

    @Override // com.google.android.exoplayer2.l1
    public void d() {
        m(false);
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean e() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.l1
    public long f() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.l1
    public void g(com.google.android.exoplayer2.z1[] z1Arr, l0 l02, g[] g3Arr3) {
        int obj3;
        if (this.f == -1) {
            obj3 = b(z1Arr, g3Arr3);
        }
        this.j = obj3;
        this.a.h(obj3);
    }

    @Override // com.google.android.exoplayer2.l1
    public void h() {
        m(true);
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean i(long l, float f2, boolean z3, long l4) {
        int cmp;
        long obj3;
        long obj4;
        long obj5;
        long obj7;
        obj5 = l4 != 0 ? this.e : this.d;
        if (Long.compare(obj7, l2) != 0) {
            obj5 = Math.min(obj7 /= cmp, obj8);
        }
        if (Long.compare(obj5, obj7) > 0 && Long.compare(obj3, obj5) < 0) {
            if (Long.compare(obj3, obj5) < 0) {
                if (!this.g && this.a.f() >= this.j) {
                    if (this.a.f() >= this.j) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean j(long l, long l2, float f3) {
        int i;
        long l3;
        long l4;
        long l5;
        int obj7;
        boolean obj8;
        final int i2 = 0;
        obj7 = this.a.f() >= this.j ? i : i2;
        if (Float.compare(obj11, obj8) > 0) {
            l3 = Math.min(p0.Q(this.b, obj3), obj3);
        }
        int i3 = 500000;
        if (Long.compare(f3, l4) < 0) {
            if (!this.g) {
                if (obj7 == null) {
                } else {
                    i = i2;
                }
            }
            this.k = i;
            if (i == 0 && Long.compare(f3, i3) < 0) {
                if (Long.compare(f3, i3) < 0) {
                    v.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
                }
            }
        } else {
            if (Long.compare(f3, l4) < 0) {
                if (obj7 != null) {
                    this.k = i2;
                }
            } else {
            }
        }
        return this.k;
    }

    @Override // com.google.android.exoplayer2.l1
    public f k() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.l1
    public void l() {
        m(true);
    }
}
