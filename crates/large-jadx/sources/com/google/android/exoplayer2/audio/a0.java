package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.mediacodec.q.a;
import com.google.android.exoplayer2.mediacodec.q.b;
import com.google.android.exoplayer2.mediacodec.r;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.x;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.z1.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class a0 extends MediaCodecRenderer implements x {

    private final Context Z0;
    private final com.google.android.exoplayer2.audio.s.a a1;
    private final com.google.android.exoplayer2.audio.AudioSink b1;
    private int c1;
    private boolean d1;
    private i1 e1;
    private long f1;
    private boolean g1;
    private boolean h1;
    private boolean i1;
    private boolean j1;
    private z1.a k1;

    static class a {
    }

    private final class b implements com.google.android.exoplayer2.audio.AudioSink.a {

        final com.google.android.exoplayer2.audio.a0 a;
        private b(com.google.android.exoplayer2.audio.a0 a0) {
            this.a = a0;
            super();
        }

        b(com.google.android.exoplayer2.audio.a0 a0, com.google.android.exoplayer2.audio.a0.a a0$a2) {
            super(a0);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void a(boolean z) {
            a0.t1(this.a).C(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void b(long l) {
            a0.t1(this.a).B(l);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void c(int i, long l2, long l3) {
            a0.t1(this.a).D(i, l2, obj4);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void d(long l) {
            z1.a aVar;
            if (a0.u1(this.a) != null) {
                a0.u1(this.a).b(l);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void e() {
            this.a.A1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void f() {
            z1.a aVar;
            if (a0.u1(this.a) != null) {
                a0.u1(this.a).a();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink$a
        public void t(Exception exception) {
            v.d("MediaCodecAudioRenderer", "Audio sink error", exception);
            a0.t1(this.a).b(exception);
        }
    }
    public a0(Context context, q.b q$b2, s s3, boolean z4, Handler handler5, com.google.android.exoplayer2.audio.s s6, com.google.android.exoplayer2.audio.AudioSink audioSink7) {
        super(1, b2, s3, z4, 1194083328);
        this.Z0 = context.getApplicationContext();
        this.b1 = audioSink7;
        s.a obj7 = new s.a(handler5, s6);
        this.a1 = obj7;
        obj7 = new a0.b(this, 0);
        audioSink7.s(obj7);
    }

    public a0(Context context, s s2, boolean z3, Handler handler4, com.google.android.exoplayer2.audio.s s5, com.google.android.exoplayer2.audio.AudioSink audioSink6) {
        super(context, q.b.a, s2, z3, handler4, s5, audioSink6);
    }

    private void B1() {
        long l;
        long cmp;
        final boolean z = c();
        l = this.b1.l(z);
        if (Long.compare(l, l2) != 0) {
            if (this.h1) {
            } else {
                l = Math.max(this.f1, obj3);
            }
            this.f1 = l;
            this.h1 = false;
        }
    }

    static com.google.android.exoplayer2.audio.s.a t1(com.google.android.exoplayer2.audio.a0 a0) {
        return a0.a1;
    }

    static z1.a u1(com.google.android.exoplayer2.audio.a0 a0) {
        return a0.k1;
    }

    private static boolean v1(String string) {
        int startsWith;
        Object obj2;
        if (p0.a < 24 && "OMX.SEC.aac.dec".equals(string) && "samsung".equals(p0.c)) {
            if ("OMX.SEC.aac.dec".equals(string)) {
                if ("samsung".equals(p0.c)) {
                    obj2 = p0.b;
                    if (!obj2.startsWith("zeroflte") && !obj2.startsWith("herolte")) {
                        if (!obj2.startsWith("herolte")) {
                            obj2 = obj2.startsWith("heroqlte") ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static boolean w1() {
        String equals2;
        int i;
        boolean equals;
        if (p0.a == 23) {
            equals2 = p0.d;
            if (!"ZTE B2017G".equals(equals2)) {
                i = "AXON 7 mini".equals(equals2) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private int x1(r r, i1 i12) {
        String str;
        int obj2;
        obj2 = p0.a;
        if ("OMX.google.raw.decoder".equals(r.a) && obj2 < 24 && obj2 == 23 && !p0.j0(this.Z0)) {
            obj2 = p0.a;
            if (obj2 < 24) {
                if (obj2 == 23) {
                    if (!p0.j0(this.Z0)) {
                    }
                }
                return -1;
            }
        }
        return i12.E;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public x A() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected q.a A0(r r, i1 i12, MediaCrypto mediaCrypto3, float f4) {
        boolean obj13;
        this.c1 = y1(r, i12, H());
        this.d1 = a0.v1(r.a);
        String str3 = "audio/raw";
        if (str3.equals(r.b) && !str3.equals(i12.D)) {
            obj13 = !str3.equals(i12.D) ? 1 : 0;
        } else {
        }
        obj13 = obj13 != null ? i12 : 0;
        this.e1 = obj13;
        super(r, z1(i12, r.c, this.c1, f4), i12, 0, mediaCrypto3, 0);
        return obj13;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void A1() {
        this.h1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void J() {
        this.i1 = true;
        this.b1.flush();
        super.J();
        this.a1.e(this.U0);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void K(boolean z, boolean z2) {
        com.google.android.exoplayer2.audio.AudioSink obj1;
        super.K(z, z2);
        this.a1.f(this.U0);
        if (obj1.a) {
            this.b1.p();
        } else {
            this.b1.m();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void L(long l, boolean z2) {
        com.google.android.exoplayer2.audio.AudioSink obj3;
        super.L(l, z2);
        if (this.j1) {
            this.b1.v();
        } else {
            this.b1.flush();
        }
        this.f1 = l;
        final int obj1 = 1;
        this.g1 = obj1;
        this.h1 = obj1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void M() {
        int i;
        Throwable th;
        boolean z;
        super.M();
        if (this.i1) {
            try {
                this.i1 = false;
                this.b1.reset();
            }
            this.i1 = z2;
            boolean z2 = this.b1;
            z2.reset();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void N() {
        super.N();
        this.b1.q();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void O() {
        B1();
        this.b1.d();
        super.O();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void O0(Exception exception) {
        v.d("MediaCodecAudioRenderer", "Audio codec error", exception);
        this.a1.a(exception);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void P0(String string, long l2, long l3) {
        this.a1.c(string, l2, obj3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Q0(String string) {
        this.a1.d(string);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected e R0(j1 j1) {
        final e eVar = super.R0(j1);
        this.a1.g(j1.b, eVar);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void S0(i1 i1, MediaFormat mediaFormat2) {
        i1 i1Var;
        int integer;
        int str;
        int iArr;
        String str2;
        boolean bVar;
        Object obj6;
        i1 obj7;
        i1Var = this.e1;
        final int i4 = 0;
        iArr = 0;
        if (i1Var != null) {
            obj6 = i1Var;
        } else {
            if (t0() == null) {
            } else {
                str2 = "audio/raw";
                if (str2.equals(i1.D)) {
                    integer = i1.S;
                } else {
                    str = "pcm-encoding";
                    if (p0.a >= 24 && mediaFormat2.containsKey(str)) {
                        str = "pcm-encoding";
                        if (mediaFormat2.containsKey(str)) {
                            integer = mediaFormat2.getInteger(str);
                        } else {
                            String str6 = "v-bits-per-sample";
                            if (mediaFormat2.containsKey(str6)) {
                                integer = p0.S(mediaFormat2.getInteger(str6));
                            } else {
                                integer = str2.equals(i1.D) ? i1.S : 2;
                            }
                        }
                    } else {
                    }
                }
                bVar = new i1.b();
                bVar.e0(str2);
                bVar.Y(integer);
                bVar.M(i1.T);
                bVar.N(i1.U);
                bVar.H(mediaFormat2.getInteger("channel-count"));
                bVar.f0(mediaFormat2.getInteger("sample-rate"));
                obj7 = bVar.E();
                str2 = 6;
                i1Var = i1.Q;
                if (this.d1 && obj7.Q == str2 && i1Var < str2) {
                    str2 = 6;
                    if (obj7.Q == str2) {
                        i1Var = i1.Q;
                        if (i1Var < str2) {
                            i1Var = i4;
                            while (i1Var < i1.Q) {
                                new int[i1Var][i1Var] = i1Var;
                                i1Var++;
                            }
                        }
                    }
                }
                obj6 = obj7;
            }
        }
        this.b1.u(obj6, i4, iArr);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected e U(r r, i1 i12, i1 i13) {
        int i;
        int obj9;
        final e eVar = r.e(i12, i13);
        if (x1(r, i13) > this.c1) {
            i |= 64;
        }
        final int i5 = i;
        obj9 = i5 != 0 ? 0 : eVar.d;
        super(r.a, i12, i13, obj9, i5);
        return eVar2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void U0() {
        super.U0();
        this.b1.o();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void V0(DecoderInputBuffer decoderInputBuffer) {
        int cmp;
        int i;
        Object obj5;
        if (this.g1 && !decoderInputBuffer.o() && Long.compare(l2, i) > 0) {
            if (!decoderInputBuffer.o()) {
                if (Long.compare(l2, i) > 0) {
                    this.f1 = decoderInputBuffer.w;
                }
                this.g1 = false;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean X0(long l, long l2, q q3, ByteBuffer byteBuffer4, int i5, int i6, int i7, long l8, boolean z9, boolean z10, i1 i111) {
        i1 obj1;
        g.e(i6);
        final int obj2 = 1;
        int obj3 = 0;
        if (this.e1 != null && l8 & 2 != 0) {
            if (l8 & 2 != 0) {
                g.e(i5);
                (q)i5.j(i7, obj3);
                return obj2;
            }
        }
        if (obj12 != null && i5 != null) {
            if (i5 != null) {
                i5.j(i7, obj3);
            }
            obj1 = this.U0;
            obj1.f = obj3 += z9;
            this.b1.o();
            return obj2;
        }
        if (this.b1.r(i6, z10, i111) && i5 != null) {
            if (i5 != null) {
                i5.j(i7, obj3);
            }
            obj1 = this.U0;
            obj1.e = obj3 += z9;
            return obj2;
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean a() {
        int i;
        boolean z;
        if (!this.b1.j()) {
            if (super.a()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean c() {
        boolean z;
        int i;
        if (super.c() && this.b1.c()) {
            i = this.b1.c() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void c1() {
        try {
            this.b1.i();
            Throwable th = D(th, th.format, th.isRecoverable, 5002);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public u1 e() {
        return this.b1.e();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void h(u1 u1) {
        this.b1.h(u1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean n1(i1 i1) {
        return this.b1.b(i1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public long o() {
        if (getState() == 2) {
            B1();
        }
        return this.f1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int o1(s s, i1 i12) {
        int i;
        int i3;
        boolean equals;
        int i4;
        int i2;
        boolean z;
        Object obj11;
        int i6 = 0;
        if (!z.o(i12.D)) {
            return a2.r(i6);
        }
        i = p0.a >= 21 ? 32 : i6;
        final int i8 = 1;
        i3 = i12.W != null ? i8 : i6;
        final boolean z5 = MediaCodecRenderer.p1(i12);
        if (z5 && this.b1.b(i12) && i3 != 0 && MediaCodecUtil.q() != null) {
            if (this.b1.b(i12)) {
                if (i3 != 0) {
                    if (MediaCodecUtil.q() != null) {
                    }
                }
                return a2.n(4, 8, i);
            }
        }
        if ("audio/raw".equals(i12.D) && !this.b1.b(i12)) {
            if (!this.b1.b(i12)) {
                return a2.r(i8);
            }
        }
        final int i11 = 2;
        if (!this.b1.b(p0.T(i11, i12.Q, i12.R))) {
            return a2.r(i8);
        }
        obj11 = y0(s, i12, i6);
        if (obj11.isEmpty()) {
            return a2.r(i8);
        }
        if (!z5) {
            return a2.r(i11);
        }
        obj11 = obj11.get(i6);
        boolean z3 = (r)obj11.m(i12);
        if (z3 && obj11.o(i12)) {
            if (obj11.o(i12)) {
                i4 = 16;
            }
        }
        if (z3) {
        } else {
            i2 = 3;
        }
        return a2.n(i2, i4, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void v(int i, Object object2) {
        int i2;
        com.google.android.exoplayer2.audio.AudioSink obj2;
        float obj3;
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    switch (i) {
                        case 101:
                            this.b1.w((Boolean)object2.booleanValue());
                            break;
                        case 102:
                            this.b1.k((Integer)object2.intValue());
                            break;
                        case 103:
                            this.k1 = (z1.a)object2;
                            break;
                        default:
                            super.v(i, object2);
                    }
                } else {
                    this.b1.x((v)object2);
                }
            } else {
                this.b1.n((p)object2);
            }
        } else {
            this.b1.g((Float)object2.floatValue());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float w0(float f, i1 i12, i1[] i13Arr3) {
        int i;
        int i2;
        int i3;
        int obj5;
        float obj6;
        final int i4 = -1;
        i = 0;
        i2 = i4;
        while (i < i13Arr3.length) {
            i3 = obj.R;
            if (i3 != i4) {
            }
            i++;
            i2 = Math.max(i2, i3);
        }
        obj5 = i2 == i4 ? -1082130432 : f * obj6;
        return obj5;
    }

    protected List<r> y0(s s, i1 i12, boolean z3) {
        boolean arrayList;
        boolean z;
        List obj4;
        Object obj5;
        String str = i12.D;
        if (str == null) {
            return Collections.emptyList();
        }
        z = MediaCodecUtil.q();
        if (this.b1.b(i12) && z != null) {
            z = MediaCodecUtil.q();
            if (z != null) {
                return Collections.singletonList(z);
            }
        }
        int i = 0;
        if ("audio/eac3-joc".equals(str)) {
            arrayList = new ArrayList(MediaCodecUtil.p(s.a(str, z3, i), i12));
            arrayList.addAll(s.a("audio/eac3", z3, i));
            obj5 = arrayList;
        }
        return Collections.unmodifiableList(obj5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int y1(r r, i1 i12, i1[] i13Arr3) {
        int i3;
        int i;
        Object obj;
        int i2;
        if (i13Arr3.length == 1) {
            return x1(r, i12);
        }
        i = 0;
        while (i < i13Arr3.length) {
            obj = i13Arr3[i];
            if (eVar.d != 0) {
            }
            i++;
            i3 = Math.max(i3, x1(r, obj));
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaFormat z1(i1 i1, String string2, int i3, float f4) {
        String str;
        Object obj3;
        int obj4;
        int obj5;
        int obj6;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", string2);
        mediaFormat.setInteger("channel-count", i1.Q);
        mediaFormat.setInteger("sample-rate", i1.R);
        y.e(mediaFormat, i1.F);
        y.d(mediaFormat, "max-input-size", i3);
        obj4 = p0.a;
        mediaFormat.setInteger("priority", 0);
        if (obj4 >= 23 && Float.compare(f4, obj5) != 0 && !a0.w1()) {
            mediaFormat.setInteger("priority", 0);
            if (Float.compare(f4, obj5) != 0) {
                if (!a0.w1()) {
                    mediaFormat.setFloat("operating-rate", f4);
                }
            }
        }
        if (obj4 <= 28 && "audio/ac4".equals(i1.D)) {
            if ("audio/ac4".equals(i1.D)) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        obj6 = 4;
        if (obj4 >= 24 && this.b1.t(p0.T(obj6, i1.Q, i1.R)) == 2) {
            obj6 = 4;
            if (this.b1.t(p0.T(obj6, i1.Q, i1.R)) == 2) {
                mediaFormat.setInteger("pcm-encoding", obj6);
            }
        }
        return mediaFormat;
    }
}
