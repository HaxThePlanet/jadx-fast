package com.google.android.exoplayer2.video.b0;

import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class e extends u0 {

    private final DecoderInputBuffer D;
    private final d0 E;
    private long F;
    private com.google.android.exoplayer2.video.b0.d G;
    private long H;
    public e() {
        super(6);
        DecoderInputBuffer decoderInputBuffer = new DecoderInputBuffer(1);
        this.D = decoderInputBuffer;
        d0 d0Var = new d0();
        this.E = d0Var;
    }

    private float[] S(ByteBuffer byteBuffer) {
        int i;
        int intBitsToFloat;
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.E.G(byteBuffer.array(), byteBuffer.limit());
        this.E.I(obj4 += 4);
        int obj4 = 3;
        float[] fArr = new float[obj4];
        i = 0;
        while (i < obj4) {
            fArr[i] = Float.intBitsToFloat(this.E.p());
            i++;
        }
        return fArr;
    }

    private void T() {
        final com.google.android.exoplayer2.video.b0.d dVar = this.G;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void J() {
        T();
    }

    @Override // com.google.android.exoplayer2.u0
    protected void L(long l, boolean z2) {
        this.H = Long.MIN_VALUE;
        T();
    }

    @Override // com.google.android.exoplayer2.u0
    protected void P(i1[] i1Arr, long l2, long l3) {
        this.F = obj4;
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean a() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.u0
    public int b(i1 i1) {
        int obj2;
        if ("application/x-camera-motion".equals(i1.D)) {
            obj2 = a2.r(4);
        } else {
            obj2 = a2.r(0);
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean c() {
        return j();
    }

    @Override // com.google.android.exoplayer2.u0
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.u0
    public void u(long l, long l2) {
        long l4;
        long l3;
        DecoderInputBuffer obj7;
        com.google.android.exoplayer2.video.b0.d obj8;
        while (!j()) {
            if (Long.compare(obj7, l4) < 0) {
                break;
            }
            this.D.j();
            if (Q(F(), this.D, 0) == -4) {
                break;
            }
            if (this.D.p()) {
                break;
            } else {
            }
            obj7 = this.D;
            this.H = obj7.w;
            if (this.G != null) {
            }
            if (obj7.o()) {
            } else {
            }
            this.D.u();
            obj7 = obj7.c;
            p0.i(obj7);
            obj7 = S((ByteBuffer)obj7);
            if (obj7 == null) {
            } else {
            }
            obj8 = this.G;
            p0.i(obj8);
            (d)obj8.b(l5 -= l3, obj1);
        }
    }

    @Override // com.google.android.exoplayer2.u0
    public void v(int i, Object object2) {
        if (i == 7) {
            this.G = (d)object2;
        } else {
            super.v(i, object2);
        }
    }
}
