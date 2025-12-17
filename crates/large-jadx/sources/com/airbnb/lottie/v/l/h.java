package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s;
import com.airbnb.lottie.t.b.d;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.n;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.b;
import com.airbnb.lottie.v.b.a;
import com.airbnb.lottie.v.c;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.j.a;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.j;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import d.e.d;
import d.e.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.v.l.a {

    private final RectF A;
    private final Matrix B;
    private final Paint C;
    private final Paint D;
    private final Map<d, List<d>> E;
    private final d<String> F;
    private final n G;
    private final f H;
    private final d I;
    private a<Integer, Integer> J;
    private a<Integer, Integer> K;
    private a<Integer, Integer> L;
    private a<Integer, Integer> M;
    private a<Float, Float> N;
    private a<Float, Float> O;
    private a<Float, Float> P;
    private a<Float, Float> Q;
    private a<Float, Float> R;
    private a<Float, Float> S;
    private final StringBuilder z;

    class a extends Paint {
        a(com.airbnb.lottie.v.l.h h, int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(com.airbnb.lottie.v.l.h h, int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    static class c {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            h.c.a = iArr;
            iArr[b.a.LEFT_ALIGN.ordinal()] = 1;
            h.c.a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            h.c.a[b.a.CENTER.ordinal()] = 3;
        }
    }
    h(f f, com.airbnb.lottie.v.l.d d2) {
        Object obj3;
        Object obj4;
        super(f, d2);
        StringBuilder stringBuilder = new StringBuilder(2);
        this.z = stringBuilder;
        RectF rectF = new RectF();
        this.A = rectF;
        Matrix matrix = new Matrix();
        this.B = matrix;
        int i2 = 1;
        h.a aVar = new h.a(this, i2);
        this.C = aVar;
        h.b bVar = new h.b(this, i2);
        this.D = bVar;
        HashMap hashMap = new HashMap();
        this.E = hashMap;
        d dVar = new d();
        this.F = dVar;
        this.H = f;
        this.I = d2.a();
        obj3 = d2.q().a();
        this.G = obj3;
        obj3.a(this);
        i(obj3);
        obj3 = d2.r();
        obj4 = obj3.a;
        if (obj3 != null && obj4 != null) {
            obj4 = obj3.a;
            if (obj4 != null) {
                obj4 = obj4.j();
                this.J = obj4;
                obj4.a(this);
                i(this.J);
            }
        }
        obj4 = obj3.b;
        if (obj3 != null && obj4 != null) {
            obj4 = obj3.b;
            if (obj4 != null) {
                obj4 = obj4.j();
                this.L = obj4;
                obj4.a(this);
                i(this.L);
            }
        }
        obj4 = obj3.c;
        if (obj3 != null && obj4 != null) {
            obj4 = obj3.c;
            if (obj4 != null) {
                obj4 = obj4.j();
                this.N = obj4;
                obj4.a(this);
                i(this.N);
            }
        }
        obj3 = obj3.d;
        if (obj3 != null && obj3 != null) {
            obj3 = obj3.d;
            if (obj3 != null) {
                obj3 = obj3.j();
                this.P = obj3;
                obj3.a(this);
                i(this.P);
            }
        }
    }

    private void K(b.a b$a, Canvas canvas2, float f3) {
        int i;
        int obj3;
        int obj5;
        obj3 = h.c.a[a.ordinal()];
        final int i2 = 0;
        if (obj3 != 2) {
            if (obj3 != 3) {
            } else {
                canvas2.translate(obj3 /= obj5, i2);
            }
        } else {
            canvas2.translate(-f3, i2);
        }
    }

    private String L(String string, int i2) {
        int codePointAt;
        StringBuilder charCount;
        int i3;
        int codePointAt2;
        int i;
        int charCount2;
        int obj7;
        charCount3 += i2;
        while (i3 < string.length()) {
            codePointAt2 = string.codePointAt(i3);
            if (!X(codePointAt2)) {
                break;
            } else {
            }
            i3 += charCount2;
            i4 += codePointAt2;
        }
        long l = (long)codePointAt;
        if (this.F.d(l)) {
            return (String)this.F.f(l);
        }
        this.z.setLength(0);
        while (obj7 < i3) {
            int codePointAt3 = string.codePointAt(obj7);
            this.z.appendCodePoint(codePointAt3);
            obj7 += charCount;
        }
        String obj6 = this.z.toString();
        this.F.k(l, obj4);
        return obj6;
    }

    private void M(String string, Paint paint2, Canvas canvas3) {
        Paint.Style style;
        Paint.Style sTROKE;
        if (paint2.getColor() == 0) {
        }
        if (paint2.getStyle() == Paint.Style.STROKE && Float.compare(strokeWidth, sTROKE) == 0) {
            if (Float.compare(strokeWidth, sTROKE) == 0) {
            }
        }
        canvas3.drawText(string, 0, string.length(), 0, 0, paint2);
    }

    private void N(d d, Matrix matrix2, float f3, b b4, Canvas canvas5) {
        int i;
        Path path;
        Paint paint;
        int i3;
        int i2;
        float f;
        final List obj8 = U(d);
        final int i4 = 0;
        i = i4;
        while (i < obj8.size()) {
            path = (d)obj8.get(i).getPath();
            path.computeBounds(this.A, i4);
            this.B.set(matrix2);
            this.B.preTranslate(0, i5 *= f);
            this.B.preScale(f3, f3);
            path.transform(this.B);
            if (b4.k) {
            } else {
            }
            Q(path, this.D, canvas5);
            Q(path, this.C, canvas5);
            i++;
            Q(path, this.C, canvas5);
            Q(path, this.D, canvas5);
        }
    }

    private void O(String string, b b2, Canvas canvas3) {
        Paint obj2;
        if (b2.k) {
            M(string, this.C, canvas3);
            M(string, this.D, canvas3);
        } else {
            M(string, this.D, canvas3);
            M(string, this.C, canvas3);
        }
    }

    private void P(String string, b b2, Canvas canvas3, float f4) {
        int i;
        int i2;
        int i3;
        i = 0;
        while (i < string.length()) {
            String str = L(string, i);
            i += length2;
            O(str, b2, canvas3);
            canvas3.translate(measureText += f4, 0);
        }
    }

    private void Q(Path path, Paint paint2, Canvas canvas3) {
        Paint.Style style;
        Paint.Style sTROKE;
        if (paint2.getColor() == 0) {
        }
        if (paint2.getStyle() == Paint.Style.STROKE && Float.compare(strokeWidth, sTROKE) == 0) {
            if (Float.compare(strokeWidth, sTROKE) == 0) {
            }
        }
        canvas3.drawPath(path, paint2);
    }

    private void R(String string, b b2, Matrix matrix3, c c4, Canvas canvas5, float f6, float f7) {
        int i;
        Object obj;
        h hVar;
        int i2;
        String floatValue;
        Matrix matrix;
        float f;
        b bVar;
        Canvas canvas;
        i = 0;
        while (i < string.length()) {
            obj = this.I.c().e(d.c(string.charAt(i), c4.a(), c4.c()));
            if ((d)obj == null) {
            } else {
            }
            this.N((d)obj, matrix3, f7, b2, canvas5);
            a aVar = this.Q;
            if (aVar != null) {
            } else {
            }
            floatValue = this.P;
            if (floatValue != null) {
            }
            canvas5.translate(i6 += i8, 0);
            i++;
            floatValue = (Float)floatValue.h().floatValue();
            i2 += floatValue;
            floatValue = (Float)aVar.h().floatValue();
        }
    }

    private void S(b b, Matrix matrix2, c c3, Canvas canvas4) {
        float floatValue;
        int i3;
        float f;
        float f2;
        Matrix matrix;
        c cVar;
        Canvas canvas;
        float f3;
        int i2;
        int i;
        final Object obj4 = this;
        final Object obj5 = b;
        final Canvas canvas2 = canvas4;
        a aVar = obj4.S;
        if (aVar != null) {
            floatValue = (Float)aVar.h().floatValue();
        } else {
            a aVar2 = obj4.R;
            if (aVar2 != null) {
                floatValue = (Float)aVar2.h().floatValue();
            } else {
                floatValue = obj5.c;
            }
        }
        final int i13 = floatValue / i8;
        final float f7 = h.g(matrix2);
        final int i14 = f * f2;
        final List list = obj4.W(obj5.a);
        final int size = list.size();
        i2 = i3;
        while (i2 < size) {
            f = obj2;
            canvas4.save();
            obj4.K(obj5.d, canvas2, obj4.V((String)f, c3, i13, f7));
            canvas2.translate(0, i10 -= i6);
            this.R(f, b, matrix2, c3, canvas4, f7, i13);
            canvas4.restore();
            i2 = i + 1;
        }
    }

    private void T(b b, c c2, Matrix matrix3, Canvas canvas4) {
        int i4;
        float floatValue;
        int i2;
        Object obj;
        int i3;
        int i;
        float obj8;
        h.g(matrix3);
        obj8 = this.H.F(c2.a(), c2.c());
        if (obj8 == null) {
        }
        String obj9 = b.a;
        s sVar = this.H.E();
        if (sVar != null) {
        } else {
            this.C.setTypeface(obj8);
            obj8 = this.S;
            if (obj8 != null) {
                obj8 = (Float)obj8.h().floatValue();
            } else {
                obj8 = this.R;
                if (obj8 != null) {
                    obj8 = (Float)obj8.h().floatValue();
                } else {
                    obj8 = b.c;
                }
            }
            this.C.setTextSize(f2 *= obj8);
            this.D.setTypeface(this.C.getTypeface());
            this.D.setTextSize(this.C.getTextSize());
            f *= f3;
            a aVar = this.Q;
            if (aVar != null) {
                floatValue = (Float)aVar.h().floatValue();
                i4 += floatValue;
            } else {
            }
            i9 /= obj8;
            obj8 = W(obj9);
            obj9 = obj8.size();
            i2 = 0;
            while (i2 < obj9) {
                obj = obj8.get(i2);
                canvas4.save();
                K(b.d, canvas4, measureText += i17);
                canvas4.translate(0, i19 -= i15);
                P(obj, b, canvas4, i10);
                canvas4.restore();
                i2++;
            }
        }
        sVar.a(obj9);
        throw 0;
    }

    private List<d> U(d d) {
        int i;
        Object obj;
        d dVar;
        f fVar;
        if (this.E.containsKey(d)) {
            return (List)this.E.get(d);
        }
        List list = d.a();
        final int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        i = 0;
        while (i < size) {
            dVar = new d(this.H, this, (n)list.get(i));
            arrayList.add(dVar);
            i++;
        }
        this.E.put(d, arrayList);
        return arrayList;
    }

    private float V(String string, c c2, float f3, float f4) {
        int i3;
        int i;
        Object obj;
        h hVar;
        String str;
        int i2;
        double d;
        i3 = 0;
        i = 0;
        while (i < string.length()) {
            obj = this.I.c().e(d.c(string.charAt(i), c2.a(), c2.c()));
            if ((d)obj == null) {
            } else {
            }
            i3 = (float)hVar;
            i++;
        }
        return i3;
    }

    private List<String> W(String string) {
        final String str3 = "\r";
        return Arrays.asList(string.replaceAll("\r\n", str3).replaceAll("\n", str3).split(str3));
    }

    private boolean X(int i) {
        int type;
        int i2;
        int obj3;
        if (Character.getType(i) != 16 && Character.getType(i) != 27 && Character.getType(i) != 6 && Character.getType(i) != 28) {
            if (Character.getType(i) != 27) {
                if (Character.getType(i) != 6) {
                    if (Character.getType(i) != 28) {
                        if (Character.getType(i) == 19) {
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
        } else {
        }
        return obj3;
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        super.d(rectF, matrix2, z3);
        final int i = 0;
        rectF.set(i, i, (float)obj3, (float)obj4);
    }

    public <T> void g(T t, c<T> c2) {
        Number num;
        Object obj3;
        super.g(t, c2);
        final int i = 0;
        if (t == k.a) {
            obj3 = this.K;
            if (obj3 != null) {
                C(obj3);
            }
            if (c2 == null) {
                this.K = i;
            } else {
                obj3 = new p(c2);
                this.K = obj3;
                obj3.a(this);
                i(this.K);
            }
        } else {
            if (t == k.b) {
                obj3 = this.M;
                if (obj3 != null) {
                    C(obj3);
                }
                if (c2 == null) {
                    this.M = i;
                } else {
                    obj3 = new p(c2);
                    this.M = obj3;
                    obj3.a(this);
                    i(this.M);
                }
            } else {
                if (t == k.q) {
                    obj3 = this.O;
                    if (obj3 != null) {
                        C(obj3);
                    }
                    if (c2 == null) {
                        this.O = i;
                    } else {
                        obj3 = new p(c2);
                        this.O = obj3;
                        obj3.a(this);
                        i(this.O);
                    }
                } else {
                    if (t == k.r) {
                        obj3 = this.Q;
                        if (obj3 != null) {
                            C(obj3);
                        }
                        if (c2 == null) {
                            this.Q = i;
                        } else {
                            obj3 = new p(c2);
                            this.Q = obj3;
                            obj3.a(this);
                            i(this.Q);
                        }
                    } else {
                        obj3 = this.S;
                        if (t == k.D && obj3 != null) {
                            obj3 = this.S;
                            if (obj3 != null) {
                                C(obj3);
                            }
                            if (c2 == null) {
                                this.S = i;
                            } else {
                                obj3 = new p(c2);
                                this.S = obj3;
                                obj3.a(this);
                                i(this.S);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    void t(Canvas canvas, Matrix matrix2, int i3) {
        int intValue3;
        int intValue;
        int intValue2;
        float floatValue;
        Paint paint;
        Paint paint3;
        Paint paint2;
        int i;
        float f;
        canvas.save();
        if (!this.H.k0()) {
            canvas.concat(matrix2);
        }
        Object obj8 = this.G.h();
        Object obj = this.I.g().get(obj8.b);
        if ((c)obj == null) {
            canvas.restore();
        }
        a aVar = this.K;
        if (aVar != null) {
            this.C.setColor((Integer)aVar.h().intValue());
        } else {
            a aVar2 = this.J;
            if (aVar2 != null) {
                this.C.setColor((Integer)aVar2.h().intValue());
            } else {
                this.C.setColor(obj8.h);
            }
        }
        a aVar3 = this.M;
        if (aVar3 != null) {
            this.D.setColor((Integer)aVar3.h().intValue());
        } else {
            a aVar4 = this.L;
            if (aVar4 != null) {
                this.D.setColor((Integer)aVar4.h().intValue());
            } else {
                this.D.setColor(obj8.i);
            }
        }
        int i5 = 100;
        if (this.v.h() == null) {
            intValue2 = i5;
        } else {
            intValue2 = (Integer)this.v.h().h().intValue();
        }
        i2 /= i5;
        this.C.setAlpha(i4);
        this.D.setAlpha(i4);
        a aVar6 = this.O;
        if (aVar6 != null) {
            this.D.setStrokeWidth((Float)aVar6.h().floatValue());
        } else {
            a aVar7 = this.N;
            if (aVar7 != null) {
                this.D.setStrokeWidth((Float)aVar7.h().floatValue());
            } else {
                this.D.setStrokeWidth(i6 *= floatValue);
            }
        }
        if (this.H.k0()) {
            S((b)obj8, matrix2, (c)obj, canvas);
        } else {
            T(obj8, obj, matrix2, canvas);
        }
        canvas.restore();
    }
}
