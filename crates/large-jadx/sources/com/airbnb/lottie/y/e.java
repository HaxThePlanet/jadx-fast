package com.airbnb.lottie.y;

import android.animation.ValueAnimator;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;

/* loaded from: classes.dex */
public class e extends com.airbnb.lottie.y.a implements Choreographer.FrameCallback {

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
        int i = 1065353216;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -822083584;
        int i6 = 1325400064;
    }

    private void D() {
        float cmp2;
        int cmp;
        if (this.B == null) {
        }
        cmp2 = this.x;
        if (Float.compare(cmp2, f) < 0) {
        } else {
            if (Float.compare(cmp2, cmp) > 0) {
            } else {
            }
        }
        Object[] arr = new Object[3];
        IllegalStateException illegalStateException = new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.z), Float.valueOf(this.A), Float.valueOf(this.x)));
        throw illegalStateException;
    }

    private float k() {
        d dVar = this.B;
        if (dVar == null) {
            return 2139095039;
        }
        return i3 /= f3;
    }

    private boolean o() {
        int i;
        i = Float.compare(f, i2) < 0 ? 1 : 0;
        return i;
    }

    @Override // com.airbnb.lottie.y.a
    public void A(float f, float f2) {
        float f3;
        float f4;
        if (Float.compare(f, f2) > 0) {
        } else {
            d dVar = this.B;
            if (dVar == null) {
                f3 = -8388609;
            } else {
                f3 = dVar.o();
            }
            d dVar2 = this.B;
            if (dVar2 == null) {
                f4 = 2139095039;
            } else {
                f4 = dVar2.f();
            }
            this.z = g.c(f, f3, f4);
            this.A = g.c(f2, f3, f4);
            y((float)obj4);
        }
        Object[] arr = new Object[2];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        throw illegalArgumentException;
    }

    @Override // com.airbnb.lottie.y.a
    public void B(int i) {
        A((float)i, (float)i2);
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
    public void doFrame(long l) {
        d running;
        int repeatCount2;
        int i;
        float repeatCount;
        int i2;
        float f;
        float f2;
        int cmp;
        int obj7;
        int obj8;
        s();
        if (this.B != null) {
            if (!isRunning()) {
            } else {
                running = "LottieValueAnimator#doFrame";
                c.a(running);
                long l2 = this.w;
                if (Long.compare(l2, i2) == 0) {
                } else {
                    i2 = l - l2;
                }
                if (o()) {
                    i = -i;
                }
                f4 += i;
                this.x = i3;
                this.x = g.c(this.x, m(), l());
                this.w = l;
                e();
                if (z ^= 1 != 0) {
                    if (getRepeatCount() != -1 && this.y >= getRepeatCount()) {
                        if (this.y >= getRepeatCount()) {
                            if (Float.compare(obj7, obj8) < 0) {
                                obj7 = m();
                            } else {
                                obj7 = l();
                            }
                            this.x = obj7;
                            t();
                            b(o());
                        } else {
                            c();
                            this.y = i4++;
                            if (getRepeatMode() == 2) {
                                this.v = z3 ^= 1;
                                w();
                            } else {
                                if (o()) {
                                    repeatCount2 = l();
                                } else {
                                    repeatCount2 = m();
                                }
                                this.x = repeatCount2;
                            }
                            this.w = l;
                        }
                    } else {
                    }
                }
                D();
                c.b(running);
            }
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void f() {
        this.B = 0;
        this.z = -822083584;
        this.A = 1325400064;
    }

    @Override // com.airbnb.lottie.y.a
    public void g() {
        t();
        b(o());
    }

    @Override // com.airbnb.lottie.y.a
    public float getAnimatedFraction() {
        int i;
        float f2;
        float f;
        if (this.B == null) {
            return 0;
        }
        if (o()) {
            f4 -= f6;
            f2 = l();
            f = m();
        } else {
            f3 -= f5;
            f2 = l();
            f = m();
        }
        return i /= i4;
    }

    @Override // com.airbnb.lottie.y.a
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // com.airbnb.lottie.y.a
    public long getDuration() {
        int i;
        d dVar = this.B;
        if (dVar == null) {
            i = 0;
        } else {
            i = (long)f;
        }
        return i;
    }

    @Override // com.airbnb.lottie.y.a
    public float h() {
        d dVar = this.B;
        if (dVar == null) {
            return 0;
        }
        return i3 /= i2;
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
        d dVar = this.B;
        if (dVar == null) {
            return 0;
        }
        if (Float.compare(f, i2) == 0) {
            f = dVar.f();
        }
        return f;
    }

    @Override // com.airbnb.lottie.y.a
    public float m() {
        float f;
        d dVar = this.B;
        if (dVar == null) {
            return 0;
        }
        if (Float.compare(f, i2) == 0) {
            f = dVar.o();
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
        y((float)i2);
        this.w = 0;
        this.y = 0;
        s();
    }

    @Override // com.airbnb.lottie.y.a
    protected void s() {
        boolean instance;
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void setRepeatMode(int i) {
        int obj2;
        super.setRepeatMode(i);
        if (i != 2 && this.v) {
            if (this.v) {
                this.v = false;
                w();
            }
        }
    }

    @Override // com.airbnb.lottie.y.a
    protected void t() {
        u(true);
    }

    @Override // com.airbnb.lottie.y.a
    protected void u(boolean z) {
        int obj2;
        Choreographer.getInstance().removeFrameCallback(this);
        if (z != 0) {
            this.C = false;
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void v() {
        boolean cmp;
        boolean cmp2;
        float f;
        this.C = true;
        s();
        this.w = 0;
        if (o() && Float.compare(f3, f) == 0) {
            if (Float.compare(f3, f) == 0) {
                this.x = l();
            } else {
                if (!o() && Float.compare(f2, f) == 0) {
                    if (Float.compare(f2, f) == 0) {
                        this.x = m();
                    }
                }
            }
        } else {
        }
    }

    @Override // com.airbnb.lottie.y.a
    public void w() {
        C(-f);
    }

    @Override // com.airbnb.lottie.y.a
    public void x(d d) {
        int i;
        float f2;
        float f;
        float obj3;
        i = this.B == null ? 1 : 0;
        this.B = d;
        if (i != 0) {
            A((float)i4, (float)obj3);
        } else {
            A((float)i2, (float)obj3);
        }
        this.x = 0;
        y((float)obj3);
        e();
    }

    @Override // com.airbnb.lottie.y.a
    public void y(float f) {
        if (Float.compare(f2, f) == 0) {
        }
        this.x = g.c(f, m(), l());
        this.w = 0;
        e();
    }

    @Override // com.airbnb.lottie.y.a
    public void z(float f) {
        A(this.z, f);
    }
}
