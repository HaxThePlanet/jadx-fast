package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes2.dex */
public final class g0 implements com.google.android.exoplayer2.audio.AudioProcessor {

    private int b = -1;
    private float c = 1f;
    private float d = 1f;
    private com.google.android.exoplayer2.audio.AudioProcessor.a e = 1065353216;
    private com.google.android.exoplayer2.audio.AudioProcessor.a f = 1065353216;
    private com.google.android.exoplayer2.audio.AudioProcessor.a g = 1065353216;
    private com.google.android.exoplayer2.audio.AudioProcessor.a h = 1065353216;
    private boolean i;
    private com.google.android.exoplayer2.audio.f0 j;
    private ByteBuffer k = 1065353216;
    private ShortBuffer l;
    private ByteBuffer m = 1065353216;
    private long n;
    private long o;
    private boolean p;
    public g0() {
        super();
        int i = 1065353216;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar = AudioProcessor.a.e;
        this.l = AudioProcessor.a.asShortBuffer();
        int i2 = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean a() {
        int cmp;
        int i2;
        int i3;
        int i;
        if (aVar.a != -1) {
            i3 = 1065353216;
            i = 953267991;
            if (Float.compare(f2, i) < 0 && Float.compare(f4, i) < 0) {
                if (Float.compare(f4, i) < 0) {
                    i2 = aVar2.a != aVar3.a ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer b() {
        Object f0Var;
        int i;
        ShortBuffer shortBuffer;
        int i2;
        ByteOrder nativeOrder;
        long l;
        f0Var = this.j;
        i = f0Var.k();
        if (f0Var != null && i > 0) {
            i = f0Var.k();
            if (i > 0) {
                if (this.k.capacity() < i) {
                    ByteBuffer order = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                    this.k = order;
                    this.l = order.asShortBuffer();
                } else {
                    this.k.clear();
                    this.l.clear();
                }
                f0Var.j(this.l);
                this.o = l2 += l;
                this.k.limit(i);
                this.m = this.k;
            }
        }
        this.m = AudioProcessor.a;
        return this.m;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean c() {
        com.google.android.exoplayer2.audio.f0 z;
        int i;
        if (this.p) {
            z = this.j;
            if (z != null) {
                i = z.k() == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
        }
        com.google.android.exoplayer2.audio.f0 f0Var = this.j;
        g.e(f0Var);
        final int remaining2 = byteBuffer.remaining();
        this.n = l += l2;
        (f0)f0Var.t(byteBuffer.asShortBuffer());
        byteBuffer.position(position += remaining2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.a e(com.google.android.exoplayer2.audio.AudioProcessor.a audioProcessor$a) {
        int i;
        final int i3 = 2;
        if (a.c != i3) {
        } else {
            if (this.b == -1) {
                i = a.a;
            }
            this.e = a;
            AudioProcessor.a aVar = new AudioProcessor.a(i, a.b, i3);
            this.f = aVar;
            this.i = true;
            return aVar;
        }
        AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException = new AudioProcessor.UnhandledAudioFormatException(a);
        throw unhandledAudioFormatException;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void f() {
        com.google.android.exoplayer2.audio.f0 f0Var = this.j;
        if (f0Var != null) {
            f0Var.s();
        }
        this.p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        boolean z;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar;
        boolean f0Var2;
        com.google.android.exoplayer2.audio.f0 f0Var;
        int i2;
        int i;
        float f;
        float f2;
        int i3;
        if (a()) {
            z = this.e;
            this.g = z;
            aVar = this.f;
            this.h = aVar;
            if (this.i) {
                super(z.a, z.b, this.c, this.d, aVar.a);
                this.j = f0Var2;
            } else {
                z = this.j;
                if (z != null) {
                    z.i();
                }
            }
        }
        this.m = AudioProcessor.a;
        int i4 = 0;
        this.n = i4;
        this.o = i4;
        this.p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public long g(long l) {
        long l5;
        long l3;
        long l4;
        long l2;
        int i;
        int i2;
        final Object obj = this;
        if (Long.compare(l6, i6) >= 0) {
            com.google.android.exoplayer2.audio.f0 f0Var = obj.j;
            g.e(f0Var);
            final int i8 = l8 - l3;
            int i4 = aVar.a;
            int i5 = aVar2.a;
            if (i4 == i5) {
                l5 = p0.y0(l, obj6, i8);
            } else {
                l5 = p0.y0(l, obj10, i8 * l11);
            }
            return l5;
        }
        return (long)i3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void h(float f) {
        float obj2;
        if (Float.compare(f2, f) != 0) {
            this.d = f;
            this.i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(float f) {
        float obj2;
        if (Float.compare(f2, f) != 0) {
            this.c = f;
            this.i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        int i = 1065353216;
        this.c = i;
        this.d = i;
        com.google.android.exoplayer2.audio.AudioProcessor.a aVar = AudioProcessor.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
        int i3 = 0;
        this.i = i3;
        this.j = 0;
        int i5 = 0;
        this.n = i5;
        this.o = i5;
        this.p = i3;
    }
}
