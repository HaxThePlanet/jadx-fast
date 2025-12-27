package d.f.b.b;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import d.f.b.a.b.a;
import d.f.b.a.c.a;
import d.f.b.a.d;
import d.f.b.a.d.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: MotionController.java */
/* loaded from: classes.dex */
public class g {

    private k a;
    private k b;
    private f c;
    private f d;
    private d.f.a.k.a.a[] e;
    private d.f.a.k.a.a f;
    float g;
    float h;
    private int[] i;
    private double[] j;
    private double[] k;
    private String[] l;
    private float[] m;
    private ArrayList<k> n;
    private HashMap<String, d> o;
    private HashMap<String, d.f.b.a.c> p;
    private HashMap<String, d.f.b.a.b> q;
    private e[] r;
    private int s;
    private View t;
    private int u;
    private float v;
    private Interpolator w;
    private boolean x;
    private float a(float f, float[] fArr) {
        int i = 0;
        int i2 = 1065353216;
        d.f.a.k.a.b bVar;
        double d = 4607182418800017408L;
        double d2;
        int cmp3;
        i = 0;
        final int i3 = 0;
        i2 = 1065353216;
        if (fArr != null) {
            fArr[i3] = i2;
        } else {
            double d4 = (double)f2;
            d = 1d;
            if (d4 != d) {
                if (f < this.g) {
                }
                if (i > this.g) {
                    d2 = (double)i;
                    if (d2 < d) {
                        float min = Math.min((i - f5) * f2, i2);
                    }
                }
            }
        }
        i2 = 2143289344;
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        if (this.h != null && naN) {
            i2 -= i;
            double d5 = (double)(i - i) / f4;
            float f13 = (float)bVar.a(d5) * f4 + i;
            if (fArr != null) {
                fArr[i3] = (float)bVar.b(d5);
            }
        }
        return i;
    }

    public void b(double d, float[] fArr, float[] fArr2) {
        int i = 4;
        final double[] dArr = new double[i];
        final double[] dArr2 = new double[i];
        int i3 = 0;
        this.e[i3].b(d, dArr);
        this.e[i3].d(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.a.c(d, this.i, dArr, fArr, dArr2, fArr2);
    }

    boolean c(View view, float f, long j, d.f.a.k.a.c cVar) {
        HashMap value;
        int i2;
        int measureSpec;
        float f3;
        int cmp;
        double[] dArr;
        int i3;
        Collection values3;
        float f4;
        float interpolation = 0;
        int measureSpec2;
        int j32;
        d.f.a.k.a.c cVar2;
        double d;
        double d2;
        double d3;
        double d4;
        double[] dArr3;
        float[] item;
        int i4;
        double[] dArr2;
        boolean z4;
        double d5;
        double d6;
        final Object view3 = this;
        final View view2 = view;
        item = null;
        f3 = view3.a(f, item);
        interpolation = 1f;
        if (view3.u != d.a) {
            float f25 = interpolation / (float)measureSpec2;
            f4 = (f3 % f25) / f25;
            if (!Float.isNaN(view3.v)) {
                f4 = (f3 % f25 / f25) + view3.v % interpolation;
            }
            if (view3.w != null) {
                interpolation = view3.w.getInterpolation(f4);
            } else {
                d2 = (double)f4;
                d4 = 0.5d;
                float r2 = view3.v > 0.5d ? interpolation : 0;
            }
            f3 = (view3.v > 0.5d ? interpolation : 0) + (float)(Math.floor((double)(f3 / f25))) * f25;
        }
        if (view3.p != null) {
            Iterator it = view3.p.values().iterator();
            while (it.hasNext()) {
                (c)it.next().b(view2, f3);
            }
        }
        i2 = 0;
        if (view3.o != null) {
            Iterator it2 = view3.o.values().iterator();
            while (it2.hasNext()) {
                item = it2.next();
                values3 = item instanceof d.a;
            }
        } else {
        }
        i4 = 1;
        if (view3.e != null) {
            d3 = (double)f3;
            objArr2[i2].b(d3, view3.j);
            view3.e[i2].d(d3, view3.k);
            if (view3.f != null && dArr.length > 0) {
                view3.f.b(d3, view3.j);
                view3.f.d(d3, view3.k);
            }
            if (!view3.x) {
                int i5 = 0;
                view3.a.e(f3, view, view3.i, view3.j, dArr2, i5);
            } else {
            }
            if (view3.s != d.a && view3.t == null) {
                view3.t = (View)view.getParent().findViewById(view3.s);
                if (view3.t != null && view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                    view2.setPivotX((float)view3.t.getLeft() + view3.t.getRight() / f8 - (float)view.getLeft());
                    view2.setPivotY((float)view3.t.getTop() + view3.t.getBottom() / f8 - (float)view.getTop());
                }
            }
            if (view3.p != null) {
                Iterator it4 = view3.p.values().iterator();
                while (it4.hasNext()) {
                    Collection values2 = it4.next();
                    i3 = values2 instanceof c.a;
                }
            }
            if (item != null) {
            } else {
            }
            while (i4 < objArr4.length) {
                objArr4[i4].c(d3, view3.m);
                measureSpec2 = i4 - 1;
                (a)view3.a.E.get(view3.l[measureSpec2]).e(view2, view3.m);
                i4 = i4 + 1;
            }
            if (fVar.a == 0) {
                if (f3 <= 0) {
                    view2.setVisibility(fVar.b);
                } else {
                    if (f3 >= 1065353216) {
                        view2.setVisibility(view3.d.b);
                    } else {
                        if (view3.d.b != fVar.b) {
                            view2.setVisibility(i2);
                        }
                    }
                }
            }
            if (view3.r != null) {
                measureSpec2 = objArr5.length;
                for (int cmp : objArr5) {
                    cmp.a(f3, view2);
                    measureSpec2 = objArr5.length;
                }
            }
        } else {
            float f49 = 0.5f;
            float f13 = (f11 + (kVar4.w - f11) * f3) + f49;
            int i17 = (int)f13;
            float f31 = (f29 + (kVar4.x - f29) * f3) + f49;
            i4 = (int)f31;
            cmp = (int)(f13 + (f42 - f39) * f3 + f39);
            j32 = (int)(f31 + (f21 - f) * f3 + f);
            if (kVar4.y == kVar3.y) {
                if (kVar4.z != kVar3.z) {
                    int i10 = 1073741824;
                    view2.measure(View.MeasureSpec.makeMeasureSpec(cmp - i17, i10), View.MeasureSpec.makeMeasureSpec(j32 - i4, i10));
                }
            }
            view2.layout(i17, i4, cmp, j32);
        }
        if (view3.q != null) {
            Iterator it3 = view3.q.values().iterator();
            while (it3.hasNext()) {
                Collection values = it3.next();
                cmp = values instanceof b.a;
            }
        }
        return z4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = " start: x: ";
        String str3 = " y: ";
        String str4 = " end: x: ";
        str = str2 + this.a.w + str3 + this.a.x + str4 + this.b.w + str3 + this.b.x;
        return str;
    }
}
