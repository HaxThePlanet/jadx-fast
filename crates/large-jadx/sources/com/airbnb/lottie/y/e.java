package com.airbnb.lottie.y;

import android.animation.ValueAnimator;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {

    private float A = 2147483600f;
    private d B;
    protected boolean C = false;
    private float c = 1f;
    private boolean v = false;
    private long w = 0;
    private float x = 0f;
    private int y = 0;
    private float z = -2147483600f;
    public e() {
        super();
    }

    private void D() {
        if (this.B == null) {
            return;
        }
        if (this.x < this.z) {
            Object[] arr = new Object[3];
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[] { Float.valueOf(this.z), Float.valueOf(this.A), Float.valueOf(this.x) }));
        } else {
            if (this.x <= this.A) {
                return;
            }
        }
    }

    private float k() {
        if (this.B == null) {
            return 0x7f7fffff /* Unknown resource */;
        }
        return (1000000000f / this.B.h()) / Math.abs(this.c);
    }

    private boolean o() {
        boolean z = true;
        float f = n();
        int r0 = f < 0 ? 1 : 0;
        return (f < 0 ? 1 : 0);
    }

    @Override // com.airbnb.lottie.y.a
    public void A(float f, float f2) {
        float f3 = -8388609;
        float f4 = 2139095039;
        if (f > f2) {
            Object[] arr = new Object[2];
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[] { Float.valueOf(f), Float.valueOf(f2) }));
        } else {
            if (this.B == null) {
                int i = -8388609;
            } else {
                f3 = this.B.o();
            }
            if (this.B == null) {
                int i2 = 2139095039;
            } else {
                f4 = this.B.f();
            }
            this.z = g.c(f, f3, f4);
            this.A = g.c(f2, f3, f4);
            float f5 = g.c(this.x, f, f2);
            y(f5);
            return;
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void B(int i) {
        A((float)i, f);
    }

    @Override // com.airbnb.lottie.y.a
    public void C(float f) {
        this.c = f;
    }

    @Override // com.airbnb.lottie.y.a
    public void cancel() {
        a();
        t();
    }

    @Override // com.airbnb.lottie.y.a
    public void doFrame(long j) {
        int repeatCount;
        float f;
        float f2;
        float f3 = 2;
        long l = 0;
        boolean z;
        float f6;
        float f7 = 0;
        s();
    }

    @Override // com.airbnb.lottie.y.a
    public void f() {
        this.B = null;
        this.z = -2147483600f;
        this.A = 2147483600f;
    }

    @Override // com.airbnb.lottie.y.a
    public void g() {
        t();
        b(o());
    }

    @Override // com.airbnb.lottie.y.a
    public float getAnimatedFraction() {
        float f;
        float f2;
        float f3;
        if (this.B == null) {
            return 0;
        }
        if (o()) {
            f = l() - this.x;
            f2 = l();
            f3 = m();
        } else {
            f = this.x - m();
            f2 = l();
            f3 = m();
        }
        return f / (f2 - f3);
    }

    @Override // com.airbnb.lottie.y.a
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // com.airbnb.lottie.y.a
    public long getDuration() {
        int i = 0;
        i = this.B == null ? 0 : (long)f;
        return i;
    }

    @Override // com.airbnb.lottie.y.a
    public float h() {
        if (this.B == null) {
            return 0;
        }
        return (this.x - this.B.o()) / (this.B.f() - this.B.o());
    }

    @Override // com.airbnb.lottie.y.a
    public boolean isRunning() {
        return this.C;
    }

    @Override // com.airbnb.lottie.y.a
    public float j() {
        return this.x;
    }

    @Override // com.airbnb.lottie.y.a
    public float l() {
        float f;
        if (this.B == null) {
            return 0;
        }
        if (this.A == 1325400064) {
            f = this.B.f();
        }
        return f;
    }

    @Override // com.airbnb.lottie.y.a
    public float m() {
        float f;
        if (this.B == null) {
            return 0;
        }
        if (this.z == -822083584) {
            f = this.B.o();
        }
        return f;
    }

    @Override // com.airbnb.lottie.y.a
    public float n() {
        return this.c;
    }

    @Override // com.airbnb.lottie.y.a
    public void p() {
        t();
    }

    @Override // com.airbnb.lottie.y.a
    public void r() {
        float f;
        this.C = true;
        d(o());
        if (o()) {
            f = l();
        } else {
            f = m();
        }
        y(f);
        this.w = 0L;
        this.y = 0;
        s();
    }

    @Override // com.airbnb.lottie.y.a
    protected void s() {
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (this.v != 2 && this.v) {
            boolean z = false;
            this.v = z;
            w();
        }
    }

    @Override // com.airbnb.lottie.y.a
    protected void t() {
        u(true);
    }

    @Override // com.airbnb.lottie.y.a
    protected void u(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            boolean z2 = false;
            this.C = z2;
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void v() {
        float f;
        this.C = true;
        s();
        this.w = 0L;
        if (o()) {
            float f4 = j();
            f = m();
            if (f4 == f) {
                this.x = l();
            } else {
                if (!o()) {
                    float f2 = j();
                    f = l();
                    if (f2 == f) {
                        this.x = m();
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void w() {
        C(-n());
    }

    @Override // com.airbnb.lottie.y.a
    public void x(d dVar) {
        int i = 1;
        int r0 = this.B == null ? 1 : 0;
        this.B = dVar;
        if (this.B != 0) {
            float max = Math.max(this.z, dVar.o());
            float dVar2 = Math.min(this.A, dVar.f());
            A(max, dVar2);
        } else {
            max = dVar.o();
            dVar2 = dVar.f();
            A(max, dVar2);
        }
        this.x = 0.0f;
        y(dVar3);
        e();
    }

    @Override // com.airbnb.lottie.y.a
    public void y(float f) {
        if (this.x == f) {
            return;
        }
        this.x = g.c(f, m(), l());
        this.w = 0L;
        e();
    }

    @Override // com.airbnb.lottie.y.a
    public void z(float f) {
        A(this.z, f);
    }
}
