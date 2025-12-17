package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.k.i;
import com.airbnb.lottie.v.k.i.a;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class n implements com.airbnb.lottie.t.b.m, a.b, com.airbnb.lottie.t.b.k {

    private final Path a;
    private final String b;
    private final f c;
    private final i.a d;
    private final boolean e;
    private final a<?, Float> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private final a<?, Float> i = null;
    private final a<?, Float> j;
    private final a<?, Float> k = null;
    private final a<?, Float> l;
    private com.airbnb.lottie.t.b.b m;
    private boolean n;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n.a.a = iArr;
            iArr[i.a.STAR.ordinal()] = 1;
            n.a.a[i.a.POLYGON.ordinal()] = 2;
        }
    }
    public n(f f, a a2, i i3) {
        a aVar;
        Object obj8;
        int obj10;
        super();
        Path path = new Path();
        this.a = path;
        b bVar = new b();
        this.m = bVar;
        this.c = f;
        this.b = i3.d();
        obj8 = i3.j();
        this.d = obj8;
        this.e = i3.k();
        a aVar2 = i3.g().j();
        this.f = aVar2;
        a aVar3 = i3.h().j();
        this.g = aVar3;
        a aVar4 = i3.i().j();
        this.h = aVar4;
        a aVar5 = i3.e().j();
        this.j = aVar5;
        a aVar6 = i3.f().j();
        this.l = aVar6;
        final i.a sTAR = i.a.STAR;
        if (obj8 == sTAR) {
            this.i = i3.b().j();
            this.k = i3.c().j();
        } else {
            obj10 = 0;
        }
        a2.i(aVar2);
        a2.i(aVar3);
        a2.i(aVar4);
        a2.i(aVar5);
        a2.i(aVar6);
        if (obj8 == sTAR) {
            a2.i(this.i);
            a2.i(this.k);
        }
        aVar2.a(this);
        aVar3.a(this);
        aVar4.a(this);
        aVar5.a(this);
        aVar6.a(this);
        if (obj8 == sTAR) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void e() {
        int i7;
        Path path;
        double d2;
        int i;
        double d3;
        double ceil;
        double cmp;
        double d;
        int i4;
        float f3;
        float f;
        double d4;
        float f4;
        double d5;
        Path path2;
        int i8;
        int i3;
        int i6;
        int i5;
        float f5;
        float f2;
        double d7;
        double d6;
        int i2;
        double d8;
        final Object obj = this;
        a aVar3 = obj.h;
        if (aVar3 == null) {
            d2 = 0;
        } else {
            d2 = (double)floatValue2;
        }
        double radians = Math.toRadians(d2 -= l);
        double d13 = (double)i9;
        floatValue3 /= i14;
        float floatValue4 = (Float)obj.j.h().floatValue();
        d = (double)floatValue4;
        obj.a.moveTo((float)i20, (float)i21);
        radians += d4;
        ceil = Math.ceil(d13);
        i7 = 0;
        while (Double.compare(d23, ceil) < 0) {
            f4 = (float)i22;
            float f14 = (float)i15;
            if (Float.compare(i13, i16) != 0) {
            } else {
            }
            i2 = i;
            d6 = d;
            d8 = d4;
            i4 = i7;
            obj.a.lineTo(f4, f14);
            i = i2 + d8;
            i7 = i4 + 1;
            f = f14;
            f3 = f4;
            ceil = d7;
            d = d6;
            d4 = d8;
            d6 = d;
            i4 = i7;
            i2 = i;
            double d11 = (double)f8;
            d8 = d4;
            double d17 = (double)f10;
            i18 *= d4;
            obj.a.cubicTo(f3 - d3, f - path, f4 + i, f14 + d, f4, f14);
        }
        Object obj3 = obj.g.h();
        obj.a.offset(obj3.x, obj3.y);
        obj.a.close();
    }

    private void h() {
        double d2;
        double radians;
        int i19;
        float f;
        int i9;
        float f5;
        float f4;
        int i16;
        int i;
        int i17;
        int i18;
        double d6;
        int i5;
        int cmp3;
        float cmp2;
        double d;
        float floatValue;
        int i10;
        float floatValue2;
        int i15;
        int i6;
        int i7;
        int i13;
        int i8;
        double d7;
        double d5;
        int i2;
        int i20;
        int i23;
        float f2;
        int i11;
        int cmp;
        float cmp4;
        long l;
        double d4;
        double d3;
        float f6;
        int i14;
        float f7;
        int i4;
        Path path;
        int i12;
        int i21;
        int i3;
        int i24;
        int i22;
        float f8;
        float f3;
        int i25;
        final Object obj = this;
        float floatValue3 = (Float)obj.f.h().floatValue();
        a aVar3 = obj.h;
        if (aVar3 == null) {
            d2 = 0;
        } else {
            d2 = (double)floatValue4;
        }
        double d11 = (double)floatValue3;
        f = (float)i28;
        i17 = f / i29;
        floatValue3 -= f13;
        int i34 = 0;
        cmp3 = Float.compare(i26, i34);
        if (cmp3 != 0) {
            radians += d;
        }
        floatValue = (Float)obj.j.h().floatValue();
        floatValue2 = (Float)obj.i.h().floatValue();
        a aVar6 = obj.k;
        int i46 = 1120403456;
        if (aVar6 != null) {
            floatValue5 /= i46;
        } else {
            i15 = i34;
        }
        a aVar7 = obj.l;
        if (aVar7 != null) {
            floatValue6 /= i46;
        } else {
            i7 = i34;
        }
        if (cmp3 != 0) {
            i8 = cmp3;
            double d12 = (double)i6;
            d5 = d11;
            obj.a.moveTo((float)i30, (float)i35);
            radians += d6;
        } else {
            d5 = d11;
            i8 = cmp3;
            double d9 = (double)floatValue;
            d6 = (float)i38;
            float f11 = (float)i31;
            obj.a.moveTo(d6, f11);
            radians += d10;
            f5 = d6;
            f4 = cmp3;
            i6 = 0;
        }
        long l6 = 4611686018427387904L;
        ceil *= l6;
        final float f20 = floatValue;
        final float f21 = floatValue2;
        i20 = i;
        double d18 = (double)i;
        while (Double.compare(d18, i5) < 0) {
            if (i20 != 0) {
            } else {
            }
            f2 = f21;
            cmp = Float.compare(i6, i49);
            if (cmp != 0 && Double.compare(d18, i50) == 0) {
            } else {
            }
            i2 = 1073741824;
            cmp4 = f;
            i9 = i17;
            l = 4607182418800017408L;
            if (cmp != 0 && Double.compare(d18, d4) == 0) {
            } else {
            }
            i11 = i17;
            d4 = d18;
            i18 = f2;
            double d19 = (double)i18;
            i4 = i5;
            float f12 = (float)i32;
            float f14 = (float)i41;
            cmp3 = 0;
            if (Float.compare(i15, cmp3) == 0 && Float.compare(i7, cmp3) == 0) {
            } else {
            }
            i13 = i15;
            i23 = i6;
            double d21 = (double)f16;
            float f19 = (float)d26;
            float f17 = (float)d22;
            double d16 = (double)f15;
            if (i20 != 0) {
            } else {
            }
            i10 = i7;
            if (i20 != 0) {
            } else {
            }
            i15 = i13;
            if (i20 != 0) {
            } else {
            }
            f6 = f20;
            if (i20 != 0) {
            } else {
            }
            f7 = f21;
            floatValue = 1056236141;
            i53 *= floatValue;
            i55 *= floatValue;
            if (i8 != 0) {
            }
            obj.a.cubicTo(f5 - i12, f4 - d3, f12 + floatValue2, f14 + i14, f12, f14);
            i19 += d8;
            i20 ^= 1;
            i++;
            f5 = f12;
            f4 = f14;
            i15 = i13;
            i6 = i23;
            i17 = i11;
            f = cmp4;
            i5 = i4;
            d18 = (double)i;
            if (i == 0) {
            } else {
            }
            if (Double.compare(d4, i40) == 0) {
            }
            floatValue2 *= i26;
            i14 *= i26;
            i12 *= i26;
            d3 *= i26;
            f7 = f20;
            f6 = f21;
            i15 = i7;
            i10 = i13;
            if (Float.compare(i7, cmp3) == 0) {
            } else {
            }
            obj.a.lineTo(f12, f14);
            i13 = i15;
            i23 = i6;
            if (Double.compare(d18, d4) == 0) {
            } else {
            }
            i11 = i17;
            d4 = d18;
            i18 = i6;
            if (Double.compare(d18, i50) == 0) {
            } else {
            }
            cmp4 = f;
            i9 = i25;
            f2 = f20;
        }
        Object obj3 = obj.g.h();
        obj.a.offset(obj3.x, obj3.y);
        obj.a.close();
    }

    private void i() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.m
    public void a() {
        i();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        Object obj;
        boolean z;
        q.a sIMULTANEOUSLY;
        int obj5;
        obj5 = 0;
        while (obj5 < list.size()) {
            obj = list.get(obj5);
            if (obj instanceof s && (s)(c)obj.i() == q.a.SIMULTANEOUSLY) {
            }
            obj5++;
            if ((s)obj.i() == q.a.SIMULTANEOUSLY) {
            }
            this.m.a(obj);
            obj.c(this);
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    public <T> void g(T t, c<T> c2) {
        Object num;
        Object obj2;
        if (t == k.u) {
            this.f.n(c2);
        } else {
            if (t == k.v) {
                this.h.n(c2);
            } else {
                if (t == k.l) {
                    this.g.n(c2);
                } else {
                    num = this.i;
                    if (t == k.w && num != null) {
                        num = this.i;
                        if (num != null) {
                            num.n(c2);
                        } else {
                            if (t == k.x) {
                                this.j.n(c2);
                            } else {
                                num = this.k;
                                if (t == k.y && num != null) {
                                    num = this.k;
                                    if (num != null) {
                                        num.n(c2);
                                    } else {
                                        if (t == k.z) {
                                            this.l.n(c2);
                                        }
                                    }
                                } else {
                                }
                            }
                        }
                    } else {
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.m
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        int ordinal;
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        final int i2 = 1;
        if (this.e) {
            this.n = i2;
            return this.a;
        }
        int i = n.a.a[this.d.ordinal()];
        if (i != i2) {
            if (i != 2) {
            } else {
                e();
            }
        } else {
            h();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = i2;
        return this.a;
    }
}
