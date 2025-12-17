package com.airbnb.lottie.t.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.j.e;
import com.airbnb.lottie.v.j.g;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import com.airbnb.lottie.z.d;
import java.util.Collections;

/* loaded from: classes.dex */
public class o {

    private final Matrix a;
    private final Matrix b = null;
    private final Matrix c = null;
    private final Matrix d = null;
    private final float[] e = null;
    private com.airbnb.lottie.t.c.a<PointF, PointF> f;
    private com.airbnb.lottie.t.c.a<?, PointF> g;
    private com.airbnb.lottie.t.c.a<d, d> h;
    private com.airbnb.lottie.t.c.a<Float, Float> i;
    private com.airbnb.lottie.t.c.a<Integer, Integer> j;
    private com.airbnb.lottie.t.c.c k;
    private com.airbnb.lottie.t.c.c l;
    private com.airbnb.lottie.t.c.a<?, Float> m = null;
    private com.airbnb.lottie.t.c.a<?, Float> n = null;
    public o(l l) {
        int i;
        int i3;
        int i4;
        com.airbnb.lottie.t.c.a aVar2;
        com.airbnb.lottie.t.c.a aVar;
        int i2;
        Object dVar;
        super();
        Matrix matrix = new Matrix();
        this.a = matrix;
        final int i6 = 0;
        if (l.c() == null) {
            i = i6;
        } else {
            i = l.c().j();
        }
        this.f = i;
        if (l.f() == null) {
            i3 = i6;
        } else {
            i3 = l.f().j();
        }
        this.g = i3;
        if (l.h() == null) {
            i4 = i6;
        } else {
            i4 = l.h().j();
        }
        this.h = i4;
        if (l.g() == null) {
            aVar2 = i6;
        } else {
            aVar2 = l.g().j();
        }
        this.i = aVar2;
        if (l.i() == null) {
            aVar = i6;
        } else {
            aVar = l.i().j();
        }
        this.k = aVar;
        Matrix matrix2 = new Matrix();
        this.b = matrix2;
        Matrix matrix3 = new Matrix();
        this.c = matrix3;
        Matrix matrix4 = new Matrix();
        this.d = matrix4;
        this.e = new float[9];
        if (l.j() == null) {
            i2 = i6;
        } else {
            i2 = l.j().j();
        }
        this.l = i2;
        if (l.e() != null) {
            this.j = l.e().j();
        }
        this.m = l.k().j();
        this.n = l.d().j();
    }

    private void d() {
        int i;
        float[] fArr;
        int i2;
        i = 0;
        while (i < 9) {
            this.e[i] = 0;
            i++;
        }
    }

    public void a(a a) {
        a.i(this.j);
        a.i(this.m);
        a.i(this.n);
        a.i(this.f);
        a.i(this.g);
        a.i(this.h);
        a.i(this.i);
        a.i(this.k);
        a.i(this.l);
    }

    public void b(com.airbnb.lottie.t.c.a.b a$b) {
        com.airbnb.lottie.t.c.a aVar = this.j;
        if (aVar != null) {
            aVar.a(b);
        }
        com.airbnb.lottie.t.c.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(b);
        }
        com.airbnb.lottie.t.c.a aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(b);
        }
        com.airbnb.lottie.t.c.a aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.a(b);
        }
        com.airbnb.lottie.t.c.a aVar5 = this.g;
        if (aVar5 != null) {
            aVar5.a(b);
        }
        com.airbnb.lottie.t.c.a aVar6 = this.h;
        if (aVar6 != null) {
            aVar6.a(b);
        }
        com.airbnb.lottie.t.c.a aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.a(b);
        }
        com.airbnb.lottie.t.c.c cVar = this.k;
        if (cVar != null) {
            cVar.a(b);
        }
        com.airbnb.lottie.t.c.c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(b);
        }
    }

    public <T> boolean c(T t, c<T> c2) {
        Object singletonList;
        boolean valueOf;
        int i;
        Object obj4;
        if (t == k.e) {
            obj4 = this.f;
            if (obj4 == null) {
                singletonList = new PointF();
                obj4 = new p(c2, singletonList);
                this.f = obj4;
            } else {
                obj4.n(c2);
            }
            return 1;
        } else {
            if (t == k.f) {
                obj4 = this.g;
                if (obj4 == null) {
                    singletonList = new PointF();
                    obj4 = new p(c2, singletonList);
                    this.g = obj4;
                } else {
                    obj4.n(c2);
                }
            } else {
                singletonList = this.g;
                if (t == k.g && singletonList instanceof m) {
                    singletonList = this.g;
                    if (singletonList instanceof m) {
                        (m)singletonList.r(c2);
                    } else {
                        singletonList = this.g;
                        if (t == k.h && singletonList instanceof m) {
                            singletonList = this.g;
                            if (singletonList instanceof m) {
                                (m)singletonList.s(c2);
                            } else {
                                if (t == k.m) {
                                    obj4 = this.h;
                                    if (obj4 == null) {
                                        singletonList = new d();
                                        obj4 = new p(c2, singletonList);
                                        this.h = obj4;
                                    } else {
                                        obj4.n(c2);
                                    }
                                } else {
                                    valueOf = 0;
                                    if (t == k.n) {
                                        obj4 = this.i;
                                        if (obj4 == null) {
                                            obj4 = new p(c2, Float.valueOf(valueOf));
                                            this.i = obj4;
                                        } else {
                                            obj4.n(c2);
                                        }
                                    } else {
                                        i = 100;
                                        if (t == k.c) {
                                            obj4 = this.j;
                                            if (obj4 == null) {
                                                obj4 = new p(c2, Integer.valueOf(i));
                                                this.j = obj4;
                                            } else {
                                                obj4.n(c2);
                                            }
                                        } else {
                                            singletonList = this.m;
                                            if (t == k.A && singletonList != null) {
                                                singletonList = this.m;
                                                if (singletonList != null) {
                                                    if (singletonList == null) {
                                                        obj4 = new p(c2, Integer.valueOf(i));
                                                        this.m = obj4;
                                                    } else {
                                                        singletonList.n(c2);
                                                    }
                                                } else {
                                                    singletonList = this.n;
                                                    if (t == k.B && singletonList != null) {
                                                        singletonList = this.n;
                                                        if (singletonList != null) {
                                                            if (singletonList == null) {
                                                                obj4 = new p(c2, Integer.valueOf(i));
                                                                this.n = obj4;
                                                            } else {
                                                                singletonList.n(c2);
                                                            }
                                                        } else {
                                                            singletonList = this.k;
                                                            if (t == k.o && singletonList != null) {
                                                                singletonList = this.k;
                                                                if (singletonList != null) {
                                                                    if (singletonList == null) {
                                                                        a aVar = new a(Float.valueOf(valueOf));
                                                                        obj4 = new c(Collections.singletonList(aVar));
                                                                        this.k = obj4;
                                                                    }
                                                                    this.k.n(c2);
                                                                } else {
                                                                    obj4 = this.l;
                                                                    if (t == k.p && obj4 != null && obj4 == null) {
                                                                        obj4 = this.l;
                                                                        if (obj4 != null) {
                                                                            if (obj4 == null) {
                                                                                a aVar2 = new a(Float.valueOf(valueOf));
                                                                                obj4 = new c(Collections.singletonList(aVar2));
                                                                                this.l = obj4;
                                                                            }
                                                                            this.l.n(c2);
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                            }
                                                        }
                                                    } else {
                                                    }
                                                }
                                            } else {
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
        return 0;
    }

    public com.airbnb.lottie.t.c.a<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        com.airbnb.lottie.t.c.a aVar2;
        com.airbnb.lottie.t.c.a floatValue;
        int i7;
        Object cVar2;
        com.airbnb.lottie.t.c.a aVar3;
        com.airbnb.lottie.t.c.a aVar;
        int cmp4;
        float cmp;
        int cmp2;
        int cmp3;
        int i6;
        double d;
        com.airbnb.lottie.t.c.c cVar;
        double fArr;
        int i5;
        int i;
        int i2;
        int i8;
        int i4;
        int i3;
        Matrix matrix;
        this.a.reset();
        aVar2 = this.g;
        cmp4 = 0;
        if (aVar2 != null) {
            aVar2 = aVar2.h();
            cmp = aVar2.x;
            if (Float.compare(cmp, cmp4) == 0) {
                if (Float.compare(f3, cmp4) != 0) {
                    this.a.preTranslate(cmp, aVar2.y);
                }
            } else {
            }
        }
        floatValue = this.i;
        if (floatValue != null) {
            if (floatValue instanceof p) {
                floatValue = (Float)floatValue.h().floatValue();
            } else {
                floatValue = (c)floatValue.p();
            }
            if (Float.compare(floatValue, cmp4) != 0) {
                this.a.preRotate(floatValue);
            }
        }
        cmp2 = 1065353216;
        if (this.k != null) {
            com.airbnb.lottie.t.c.c cVar3 = this.l;
            int i11 = 1119092736;
            if (cVar3 == null) {
                i7 = cmp4;
            } else {
                i7 = (float)d;
            }
            cVar = this.l;
            if (cVar == null) {
                i6 = cmp2;
            } else {
                i12 += i11;
                i6 = (float)d3;
            }
            d();
            float[] fArr2 = this.e;
            i5 = 0;
            fArr2[i5] = i7;
            i = 1;
            fArr2[i] = i6;
            i2 = -i6;
            i8 = 3;
            fArr2[i8] = i2;
            i4 = 4;
            fArr2[i4] = i7;
            i3 = 8;
            fArr2[i3] = cmp2;
            this.b.setValues(fArr2);
            d();
            fArr = this.e;
            fArr[i5] = cmp2;
            fArr[i8] = (float)d5;
            fArr[i4] = cmp2;
            fArr[i3] = cmp2;
            this.c.setValues(fArr);
            d();
            d = this.e;
            d[i5] = i7;
            d[i] = i2;
            d[i8] = i6;
            d[i4] = i7;
            d[i3] = cmp2;
            this.d.setValues(d);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        aVar3 = this.h;
        if (aVar3 != null) {
            aVar3 = aVar3.h();
            if (Float.compare(f4, cmp2) == 0) {
                if (Float.compare(cmp3, cmp2) != 0) {
                    this.a.preScale(aVar3.b(), aVar3.c());
                }
            } else {
            }
        }
        aVar = this.f;
        if (aVar != null) {
            aVar = aVar.h();
            cmp2 = aVar.x;
            if (Float.compare(cmp2, cmp4) == 0) {
                if (Float.compare(cmp3, cmp4) != 0) {
                    this.a.preTranslate(-cmp2, -f2);
                }
            } else {
            }
        }
        return this.a;
    }

    public Matrix g(float f) {
        int i3;
        com.airbnb.lottie.t.c.a aVar;
        int i2;
        int i4;
        Matrix matrix;
        int i;
        double d;
        double d2;
        int obj10;
        com.airbnb.lottie.t.c.a aVar2 = this.g;
        i2 = 0;
        if (aVar2 == null) {
            i3 = i2;
        } else {
            i3 = aVar2.h();
        }
        com.airbnb.lottie.t.c.a aVar3 = this.h;
        if (aVar3 == null) {
            i4 = i2;
        } else {
            i4 = aVar3.h();
        }
        this.a.reset();
        if (i3 != 0) {
            this.a.preTranslate(f5 *= f, f2 *= f);
        }
        if (i4 != 0) {
            d = (double)f;
            this.a.preScale((float)d4, (float)i);
        }
        aVar = this.i;
        if (aVar != null) {
            com.airbnb.lottie.t.c.a aVar4 = this.f;
            if (aVar4 == null) {
            } else {
                i2 = aVar4.h();
            }
            matrix = i2 == 0 ? obj10 : i2.x;
            if (i2 == 0) {
            } else {
                obj10 = i2.y;
            }
            this.a.preRotate(floatValue *= f, matrix, obj10);
        }
        return this.a;
    }

    public com.airbnb.lottie.t.c.a<?, Integer> h() {
        return this.j;
    }

    public com.airbnb.lottie.t.c.a<?, Float> i() {
        return this.m;
    }

    public void j(float f) {
        com.airbnb.lottie.t.c.a aVar = this.j;
        if (aVar != null) {
            aVar.m(f);
        }
        com.airbnb.lottie.t.c.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.m(f);
        }
        com.airbnb.lottie.t.c.a aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.m(f);
        }
        com.airbnb.lottie.t.c.a aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.m(f);
        }
        com.airbnb.lottie.t.c.a aVar5 = this.g;
        if (aVar5 != null) {
            aVar5.m(f);
        }
        com.airbnb.lottie.t.c.a aVar6 = this.h;
        if (aVar6 != null) {
            aVar6.m(f);
        }
        com.airbnb.lottie.t.c.a aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.m(f);
        }
        com.airbnb.lottie.t.c.c cVar = this.k;
        if (cVar != null) {
            cVar.m(f);
        }
        com.airbnb.lottie.t.c.c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.m(f);
        }
    }
}
