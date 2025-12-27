package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s;
import com.airbnb.lottie.t.c.n;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.b.a;
import com.airbnb.lottie.v.j.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class h extends a {

    private final RectF A = new RectF();
    private final Matrix B = new Matrix();
    private final Paint C = new h$a();
    private final Paint D = new h$b();
    private final Map<com.airbnb.lottie.v.d, List<com.airbnb.lottie.t.b.d>> E = new HashMap<>();
    private final d.e.d<String> F = new d<>();
    private final n G;
    private final f H;
    private final com.airbnb.lottie.d I;
    private com.airbnb.lottie.t.c.a<Integer, Integer> J;
    private com.airbnb.lottie.t.c.a<Integer, Integer> K;
    private com.airbnb.lottie.t.c.a<Integer, Integer> L;
    private com.airbnb.lottie.t.c.a<Integer, Integer> M;
    private com.airbnb.lottie.t.c.a<Float, Float> N;
    private com.airbnb.lottie.t.c.a<Float, Float> O;
    private com.airbnb.lottie.t.c.a<Float, Float> P;
    private com.airbnb.lottie.t.c.a<Float, Float> Q;
    private com.airbnb.lottie.t.c.a<Float, Float> R;
    private com.airbnb.lottie.t.c.a<Float, Float> S;
    private final StringBuilder z = new StringBuilder(2);

    class a extends Paint {
        a(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    static class c {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[b.a.values().length];
            h.c.a = iArr;
            try {
                iArr[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.c.a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h.c.a[b.a.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    h(f fVar, d dVar) {
        com.airbnb.lottie.v.j.a aVar;
        super(fVar, dVar);
        StringBuilder stringBuilder = new StringBuilder(2);
        RectF rectF = new RectF();
        Matrix matrix = new Matrix();
        int i2 = 1;
        com.airbnb.lottie.v.l.h.a aVar2 = new h.a(this, i2);
        com.airbnb.lottie.v.l.h.b bVar = new h.b(this, i2);
        HashMap hashMap = new HashMap();
        dVar = new d();
        this.H = fVar;
        this.I = dVar.a();
        n nVar = dVar.q().a();
        this.G = nVar;
        nVar.a(this);
        i(nVar);
        com.airbnb.lottie.v.j.k kVar = dVar.r();
        if (kVar != null && kVar.a != null) {
            com.airbnb.lottie.t.c.a aVar9 = kVar.a.j();
            this.J = aVar9;
            aVar9.a(this);
            i(this.J);
        }
        if (kVar != null && kVar.b != null) {
            com.airbnb.lottie.t.c.a aVar7 = kVar.b.j();
            this.L = aVar7;
            aVar7.a(this);
            i(this.L);
        }
        if (kVar != null && kVar.c != null) {
            com.airbnb.lottie.t.c.a aVar5 = kVar.c.j();
            this.N = aVar5;
            aVar5.a(this);
            i(this.N);
        }
        if (kVar != null && kVar.d != null) {
            com.airbnb.lottie.t.c.a aVar3 = kVar.d.j();
            this.P = aVar3;
            aVar3.a(this);
            i(this.P);
        }
    }

    private void K(b.a aVar, Canvas canvas, float f) {
        int i2 = h.c.a[aVar.ordinal()];
        int i = 2;
        final float f4 = 0.0f;
        if (i2 == 2) {
            canvas.translate(-f, 0.0f);
        } else {
            i = 3;
            if (i2 == 3) {
                float f2 = 2f;
                f = -f / f2;
                canvas.translate(f, 0.0f);
            }
        }
    }

    private String L(String str, int i) {
        int codePointAt;
        int charCount;
        int i4;
        i = Character.charCount(str.codePointAt(i)) + i;
        while (i < str.length()) {
            int codePointAt2 = str.codePointAt(i);
            if (!X(codePointAt2)) {
                break;
            }
        }
        long l = (long)codePointAt;
        if (this.F.d(l)) {
            return (String)this.F.f(l);
        }
        int i3 = 0;
        this.z.setLength(i3);
        while (i4 < i) {
            int codePointAt3 = str.codePointAt(i4);
            this.z.appendCodePoint(codePointAt3);
            i4 = i4 + Character.charCount(codePointAt3);
        }
        String str2 = this.z.toString();
        this.F.k(l, str2);
        return str2;
    }

    private void M(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE) {
            float strokeWidth = paint.getStrokeWidth();
            float f = 0.0f;
            if (strokeWidth == 0.0f) {
                return;
            }
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void N(com.airbnb.lottie.v.d dVar, Matrix matrix, float f, com.airbnb.lottie.v.b bVar, Canvas canvas) {
        int i;
        Paint paint;
        final List list = U(dVar);
        final boolean z = false;
        i = z;
        while (i < list.size()) {
            Path path = (d)list.get(i).getPath();
            path.computeBounds(this.A, z);
            this.B.set(matrix);
            f = 0.0f;
            f2 = -bVar.g * h.e();
            this.B.preTranslate(f, f2);
            this.B.preScale(f, f);
            path.transform(this.B);
            i = i + 1;
        }
    }

    private void O(String str, com.airbnb.lottie.v.b bVar, Canvas canvas) {
        if (bVar.k) {
            M(str, this.C, canvas);
            M(str, this.D, canvas);
        } else {
            M(str, this.D, canvas);
            M(str, this.C, canvas);
        }
    }

    private void P(String str, com.airbnb.lottie.v.b bVar, Canvas canvas, float f) {
        int i = 0;
        i = 0;
        while (i < str.length()) {
            String str2 = L(str, i);
            i = i + str2.length();
            O(str2, bVar, canvas);
            f = this.C.measureText(str2) + f;
            float f2 = 0.0f;
            canvas.translate(f, f2);
        }
    }

    private void Q(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE) {
            float strokeWidth = paint.getStrokeWidth();
            float f = 0.0f;
            if (strokeWidth == 0.0f) {
                return;
            }
        }
        canvas.drawPath(path, paint);
    }

    private void R(String str, com.airbnb.lottie.v.b bVar, Matrix matrix, com.airbnb.lottie.v.c cVar, Canvas canvas, float f, float f2) {
        int i = 0;
        Object obj;
        d.e.h hVar = null;
        String str2;
        float value;
        com.airbnb.lottie.t.c.a aVar;
        Matrix matrix32;
        float f72;
        com.airbnb.lottie.v.b bVar22;
        Canvas canvas52;
        i = 0;
        while (i < str.length()) {
            obj = this.I.c().e(d.c(str.charAt(i), cVar.a(), cVar.c()));
            i = i + 1;
        }
    }

    private void S(com.airbnb.lottie.v.b bVar, Matrix matrix, com.airbnb.lottie.v.c cVar, Canvas canvas) {
        float value;
        int i;
        final Object bVar3 = this;
        final Object matrix23 = bVar;
        final Canvas canvas42 = canvas;
        if (bVar3.S != null) {
            value = (Float)bVar3.S.h().floatValue();
        } else {
            if (bVar3.R != null) {
                value = (Float)bVar3.R.h().floatValue();
            } else {
            }
        }
        final float f4 = value / 100f;
        final float f3 = h.g(matrix);
        final float f12 = matrix23.f * h.e();
        final List list = bVar3.W(matrix23.a);
        final int size = list.size();
        i = 0;
        while (i < size) {
            String str2 = list.get(i);
            canvas.save();
            bVar3.K(matrix23.d, canvas42, bVar3.V(str2, cVar, f4, f3));
            canvas42.translate(0.0f, (float)i * f12 - (float)(size - 1) * f12 / 2f);
            this.R(str2, bVar, matrix, cVar, canvas, f3, f4);
            canvas.restore();
            i = i + 1;
        }
    }

    private void T(com.airbnb.lottie.v.b bVar, com.airbnb.lottie.v.c cVar, Matrix matrix, Canvas canvas) {
        float f;
        float value;
        int i = 0;
        float value2;
        h.g(matrix);
        android.graphics.Typeface typeface2 = this.H.F(cVar.a(), cVar.c());
        if (typeface2 == null) {
            return;
        }
        s sVar = this.H.E();
        if (sVar != null) {
            sVar.a(bVar.a);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            this.C.setTypeface(typeface2);
            if (this.S != null) {
                value2 = (Float)this.S.h().floatValue();
            } else {
                if (this.R != null) {
                    value2 = (Float)this.R.h().floatValue();
                } else {
                }
            }
            this.C.setTextSize(h.e() * value2);
            this.D.setTypeface(this.C.getTypeface());
            this.D.setTextSize(this.C.getTextSize());
            float f5 = bVar.f * h.e();
            f = (float)bVar.e / 10f;
            if (this.Q != null) {
                value = (Float)this.Q.h().floatValue();
                f = (float)bVar.e / 1092616192 + value;
            }
            float f12 = (f * h.e()) * value2 / 100f;
            List list = W(bVar.a);
            int size = list.size();
            i = 0;
            while (this.Q < bVar.a) {
                Object item = list.get(i);
                canvas.save();
                K(bVar.d, canvas, this.D.measureText(item) + (float)(item.length() - 1) * f12);
                f3 = (float)i * f5 - (float)(size - 1) * f5 / 2f;
                float f2 = 0.0f;
                canvas.translate(f2, f3);
                P(item, bVar, canvas, f12);
                canvas.restore();
                i = i + 1;
            }
            return;
        }
    }

    private List<com.airbnb.lottie.t.b.d> U(com.airbnb.lottie.v.d dVar) {
        int i = 0;
        if (this.E.containsKey(dVar)) {
            return (List)this.E.get(dVar);
        }
        List list = dVar.a();
        final int size = list.size();
        final ArrayList arrayList = new ArrayList(size);
        i = 0;
        while (i < size) {
            arrayList.add(new d(this.H, this, (n)list.get(i)));
            i = i + 1;
        }
        this.E.put(dVar, arrayList);
        return arrayList;
    }

    private float V(String str, com.airbnb.lottie.v.c cVar, float f, float f2) {
        int i = 0;
        int i2 = 0;
        d.e.h hVar;
        double d;
        double d2;
        i = 0;
        i2 = 0;
        while (i2 < str.length()) {
            Object obj = this.I.c().e(d.c(str.charAt(i2), cVar.a(), cVar.c()));
            i2 = i2 + 1;
        }
        return i;
    }

    private List<String> W(String str) {
        final String str4 = "\r";
        return Arrays.asList(str.replaceAll("\r\n", str4).replaceAll("\n", str4).split(str4));
    }

    private boolean X(int i) {
        int type = 19;
        int i2 = 16;
        boolean z = true;
        i2 = 16;
        if (Character.getType(i) != 16) {
            i2 = 27;
            if (Character.getType(i) != 27) {
                i2 = 6;
                if (Character.getType(i) != 6) {
                    i2 = 28;
                    if (Character.getType(i) != 28) {
                        type = 19;
                        if (Character.getType(i) == 19) {
                            int i3 = 1;
                        } else {
                            int i4 = 0;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        final float f = 0.0f;
        rectF.set(f, f, (float)this.I.b().width(), (float)this.I.b().height());
    }

    @Override // com.airbnb.lottie.v.l.a
    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        super.g(t, cVar);
        final com.airbnb.lottie.t.c.a aVar2 = null;
        if (t == k.a) {
            if (this.K != null) {
                C(this.K);
            }
            if (cVar == null) {
                this.K = aVar2;
            } else {
                p pVar5 = new p(cVar);
                this.K = pVar5;
                pVar5.a(this);
                i(this.K);
            }
        } else {
            if (this.K == k.b) {
                if (this.M != null) {
                    C(this.M);
                }
                if (cVar == null) {
                    this.M = aVar2;
                } else {
                    p pVar4 = new p(cVar);
                    this.M = pVar4;
                    pVar4.a(this);
                    i(this.M);
                }
            } else {
                if (this.K == k.q) {
                    if (this.O != null) {
                        C(this.O);
                    }
                    if (cVar == null) {
                        this.O = aVar2;
                    } else {
                        p pVar3 = new p(cVar);
                        this.O = pVar3;
                        pVar3.a(this);
                        i(this.O);
                    }
                } else {
                    if (this.K == k.r) {
                        if (this.Q != null) {
                            C(this.Q);
                        }
                        if (cVar == null) {
                            this.Q = aVar2;
                        } else {
                            p pVar2 = new p(cVar);
                            this.Q = pVar2;
                            pVar2.a(this);
                            i(this.Q);
                        }
                    } else {
                        if (this.S == k.D && this.S != null) {
                            C(this.S);
                            if (cVar == null) {
                                this.S = aVar2;
                            } else {
                                p pVar = new p(cVar);
                                this.S = pVar;
                                pVar.a(this);
                                i(this.S);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    void t(Canvas canvas, Matrix matrix, int i) {
        int value3;
        canvas.save();
        if (!this.H.k0()) {
            canvas.concat(matrix);
        }
        Object obj8 = this.G.h();
        Object value5 = this.I.g().get(obj8.b);
        if (value5 == null) {
            canvas.restore();
            return;
        }
        if (this.K != null) {
            this.C.setColor((Integer)this.K.h().intValue());
        } else {
            if (this.J != null) {
                this.C.setColor((Integer)this.J.h().intValue());
            } else {
                this.C.setColor(obj8.h);
            }
        }
        if (this.M != null) {
            this.D.setColor((Integer)this.M.h().intValue());
        } else {
            if (this.L != null) {
                this.D.setColor((Integer)this.L.h().intValue());
            } else {
                this.D.setColor(obj8.i);
            }
        }
        value3 = 100;
        if (this.v.h() == null) {
        } else {
            value3 = (Integer)this.v.h().h().intValue();
        }
        i /= value3;
        this.C.setAlpha(i2);
        this.D.setAlpha(i2);
        if (this.O != null) {
            this.D.setStrokeWidth((Float)this.O.h().floatValue());
        } else {
            if (this.N != null) {
                this.D.setStrokeWidth((Float)this.N.h().floatValue());
            } else {
                f = (obj8.j * h.e()) * h.g(matrix);
                this.D.setStrokeWidth(f);
            }
        }
        if (this.H.k0()) {
            S(obj8, matrix, value5, canvas);
        } else {
            T(obj8, value5, matrix, canvas);
        }
        canvas.restore();
    }
}
