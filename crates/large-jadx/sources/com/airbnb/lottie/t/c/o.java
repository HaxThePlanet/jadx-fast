package com.airbnb.lottie.t.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.e;
import com.airbnb.lottie.v.j.g;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.z.c;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class o {

    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e = null;
    private a<PointF, PointF> f;
    private a<?, PointF> g;
    private a<com.airbnb.lottie.z.d, com.airbnb.lottie.z.d> h;
    private a<Float, Float> i;
    private a<Integer, Integer> j;
    private c k;
    private c l;
    private a<?, Float> m = null;
    private a<?, Float> n = null;
    public o(l lVar) {
        int i;
        int i2;
        int i3;
        com.airbnb.lottie.t.c.a aVar;
        com.airbnb.lottie.t.c.a aVar2;
        com.airbnb.lottie.t.c.a aVar3;
        super();
        Matrix matrix2 = new Matrix();
        final Matrix matrix = null;
        if (lVar.c() == null) {
            i = matrix;
        } else {
            com.airbnb.lottie.t.c.a aVar8 = lVar.c().j();
        }
        this.f = i;
        if (lVar.f() == null) {
            i2 = matrix;
        } else {
            com.airbnb.lottie.t.c.a aVar7 = lVar.f().j();
        }
        this.g = i2;
        if (lVar.h() == null) {
            i3 = matrix;
        } else {
            com.airbnb.lottie.t.c.a aVar6 = lVar.h().j();
        }
        this.h = i3;
        if (lVar.g() == null) {
            int i6 = matrix;
        } else {
            aVar = lVar.g().j();
        }
        this.i = aVar;
        if (lVar.i() == null) {
            int i5 = matrix;
        } else {
            aVar2 = lVar.i().j();
        }
        this.k = aVar2;
        if (aVar2 != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = matrix;
            this.c = matrix;
            this.d = matrix;
        }
        if (lVar.j() == null) {
        } else {
            aVar3 = lVar.j().j();
        }
        this.l = aVar3;
        if (lVar.e() != null) {
            this.j = lVar.e().j();
        }
        this.m = lVar.k().j();
        this.n = lVar.d().j();
    }

    private void d() {
        int i = 0;
        i = 0;
        while (i < 9) {
            float f = 0.0f;
            this.e[i] = f;
            i = i + 1;
        }
    }

    public void a(com.airbnb.lottie.v.l.a aVar) {
        aVar.i(this.j);
        aVar.i(this.m);
        aVar.i(this.n);
        aVar.i(this.f);
        aVar.i(this.g);
        aVar.i(this.h);
        aVar.i(this.i);
        aVar.i(this.k);
        aVar.i(this.l);
    }

    public void b(a.b bVar) {
        if (this.j != null) {
            this.j.a(bVar);
        }
        if (this.m != null) {
            this.m.a(bVar);
        }
        if (this.n != null) {
            this.n.a(bVar);
        }
        if (this.f != null) {
            this.f.a(bVar);
        }
        if (this.g != null) {
            this.g.a(bVar);
        }
        if (this.h != null) {
            this.h.a(bVar);
        }
        if (this.i != null) {
            this.i.a(bVar);
        }
        if (this.k != null) {
            this.k.a(bVar);
        }
        if (this.l != null) {
            this.l.a(bVar);
        }
    }

    public <T> boolean c(T t, c<T> cVar) {
        Float f6;
        boolean z;
        float f7 = 0;
        if (t == k.e) {
            if (this.f == null) {
                this.f = new p(cVar, new PointF());
            } else {
                this.f.n(cVar);
            }
            return true;
        } else {
            if (this.f == k.f) {
                if (this.g == null) {
                    this.g = new p(cVar, new PointF());
                } else {
                    this.g.n(cVar);
                }
            } else {
                if (this.f == k.g) {
                    z = aVar2 instanceof m;
                    if (aVar2 instanceof m) {
                        aVar2.r(cVar);
                    } else {
                        if (this.f == k.h) {
                            z = aVar3 instanceof m;
                            if (aVar3 instanceof m) {
                                aVar3.s(cVar);
                            } else {
                                if (this.f == k.m) {
                                    if (this.h == null) {
                                        this.h = new p(cVar, new d());
                                    } else {
                                        this.h.n(cVar);
                                    }
                                } else {
                                    f7 = 0.0f;
                                    if (this.h == k.n) {
                                        if (this.i == null) {
                                            this.i = new p(cVar, Float.valueOf(0.0f));
                                        } else {
                                            this.i.n(cVar);
                                        }
                                    } else {
                                        int i = 100;
                                        if (this.f == k.c) {
                                            if (this.j == null) {
                                                this.j = new p(cVar, 100);
                                            } else {
                                                this.j.n(cVar);
                                            }
                                        } else {
                                            if (this.j != k.A || this.m == null) {
                                                if (this.j != k.B || this.n == null) {
                                                    if (this.j != k.o || this.k == null) {
                                                        if (this.j == k.p && this.l != null && this.l == null) {
                                                            this.l = new c(Collections.singletonList(new a(Float.valueOf(0.0f))));
                                                            this.l.n(cVar);
                                                        }
                                                    } else {
                                                        if (this.k == null) {
                                                            this.k = new c(Collections.singletonList(new a(Float.valueOf(0.0f))));
                                                        }
                                                        this.k.n(cVar);
                                                    }
                                                } else {
                                                    if (this.n == null) {
                                                        this.n = new p(cVar, Integer.valueOf(i));
                                                    } else {
                                                        this.n.n(cVar);
                                                    }
                                                }
                                            } else {
                                                if (this.m == null) {
                                                    this.m = new p(cVar, Integer.valueOf(i));
                                                } else {
                                                    this.m.n(cVar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public a<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        float f;
        float value;
        float f2;
        float f3 = 1065353216;
        Matrix matrix;
        int i;
        int cmp2;
        this.a.reset();
        f = 0.0f;
        if (this.g != null) {
            Object obj = this.g.h();
            if (obj.x == 0.0f) {
                if (obj.y != 0.0f) {
                    this.a.preTranslate(obj.x, obj.y);
                }
            }
        }
        if (this.i != null) {
            if (aVar2 instanceof p) {
                value = (Float)this.i.h().floatValue();
            } else {
                value = aVar2.p();
            }
            if (this.a != 0.0f) {
                this.a.preRotate(value);
            }
        }
        f3 = 1f;
        if (this.k != null) {
            float f10 = 90f;
            if (this.l == null) {
            } else {
                f = (float)(Math.cos(Math.toRadians((double)(-this.l.p() + f10))));
            }
            if (this.l == null) {
                i = f3;
            } else {
                float f19 = -this.l.p() + f10;
                float f11 = (float)Math.sin(Math.toRadians((double)f19));
            }
            d();
            int i2 = 0;
            this.e[i2] = f;
            int i3 = 1;
            this.e[i3] = i;
            i4 = -i;
            int i5 = 3;
            this.e[i5] = i4;
            int i6 = 4;
            this.e[i6] = f;
            int i7 = 8;
            this.e[i7] = f3;
            this.b.setValues(this.e);
            d();
            this.e[i2] = f3;
            this.e[i5] = (float)Math.tan(Math.toRadians((double)this.k.p()));
            this.e[i6] = f3;
            this.e[i7] = f3;
            this.c.setValues(this.e);
            d();
            this.e[i2] = f;
            this.e[i3] = i4;
            this.e[i5] = i;
            this.e[i6] = f;
            this.e[i7] = f3;
            this.d.setValues(this.e);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        if (this.h != null) {
            Object obj3 = this.h.h();
            float f13 = obj3.b();
            if (f13 == f3) {
                float f14 = obj3.c();
                if (f14 != f3) {
                    this.a.preScale(obj3.b(), obj3.c());
                }
            }
        }
        if (this.f != null) {
            Object obj2 = this.f.h();
            if (obj2.x == 0.0f) {
                if (obj2.y != 0.0f) {
                    this.a.preTranslate(-f3, -obj2.y);
                }
            }
        }
        return this.a;
    }

    public Matrix g(float f) {
        int i;
        Matrix matrix;
        int f2;
        float f3;
        i = 0;
        i = this.g == null ? i : (PointF)obj2;
        i = this.h == null ? i : (d)obj4;
        this.a.reset();
        if (this.g != 0) {
            f3 = i.x * f;
            this.a.preTranslate(f3, i.y * f);
        }
        if (this.h != 0) {
            d = (double)f;
            d2 = (double)i.c();
            this.a.preScale((float)(Math.pow((double)i.b(), d)), (float)(Math.pow(d2, d)));
        }
        if (this.i != null) {
            if (this.f != null) {
                Object obj3 = this.f.h();
            }
            f2 = 0;
            int r3 = i == 0 ? 0 : i.x;
            if (i != 0) {
            }
            this.a.preRotate((Float)this.i.h().floatValue() * f, f2, f2);
        }
        return this.a;
    }

    public a<?, Integer> h() {
        return this.j;
    }

    public a<?, Float> i() {
        return this.m;
    }

    public void j(float f) {
        if (this.j != null) {
            this.j.m(f);
        }
        if (this.m != null) {
            this.m.m(f);
        }
        if (this.n != null) {
            this.n.m(f);
        }
        if (this.f != null) {
            this.f.m(f);
        }
        if (this.g != null) {
            this.g.m(f);
        }
        if (this.h != null) {
            this.h.m(f);
        }
        if (this.i != null) {
            this.i.m(f);
        }
        if (this.k != null) {
            this.k.m(f);
        }
        if (this.l != null) {
            this.l.m(f);
        }
    }
}
