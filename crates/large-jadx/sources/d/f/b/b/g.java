package d.f.b.b;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.a;
import d.f.a.k.a.a;
import d.f.a.k.a.b;
import d.f.a.k.a.c;
import d.f.b.a.b;
import d.f.b.a.b.a;
import d.f.b.a.c;
import d.f.b.a.c.a;
import d.f.b.a.d;
import d.f.b.a.d.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class g {

    private d.f.b.b.k a;
    private d.f.b.b.k b;
    private d.f.b.b.f c;
    private d.f.b.b.f d;
    private a[] e;
    private a f;
    float g;
    float h;
    private int[] i;
    private double[] j;
    private double[] k;
    private String[] l;
    private float[] m;
    private ArrayList<d.f.b.b.k> n;
    private HashMap<String, d> o;
    private HashMap<String, c> p;
    private HashMap<String, b> q;
    private d.f.b.b.e[] r;
    private int s;
    private View t;
    private int u;
    private float v;
    private Interpolator w;
    private boolean x;
    private float a(float f, float[] f2Arr2) {
        int i3;
        int i;
        float f2;
        b bVar;
        int cmp2;
        int i2;
        int cmp3;
        Iterator iterator;
        long next2;
        boolean next;
        b naN;
        double d;
        int cmp;
        float obj11;
        final int i4 = 0;
        i = 1065353216;
        if (f2Arr2 != null) {
            f2Arr2[i4] = i;
        } else {
            f2 = this.h;
            next2 = 4607182418800017408L;
            cmp2 = this.g;
            if (Double.compare(d2, next2) != 0 && Float.compare(f, cmp2) < 0) {
                cmp2 = this.g;
                if (Float.compare(f, cmp2) < 0) {
                    obj11 = i3;
                }
                if (Float.compare(obj11, cmp2) > 0 && Double.compare(d, next2) < 0) {
                    if (Double.compare(d, next2) < 0) {
                        obj11 = Math.min(obj11 *= f2, i);
                    }
                }
            }
        }
        bVar = kVar.a;
        i2 = 2143289344;
        iterator = this.n.iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            naN = next2.a;
            if (naN != null) {
            }
            d = next2.c;
            if (Float.compare(d, obj11) < 0) {
            } else {
            }
            if (Float.isNaN(i2)) {
            }
            i2 = next2.c;
            bVar = naN;
            i3 = d;
        }
        if (bVar != null) {
            iterator = Float.isNaN(i2);
            if (iterator != null) {
            } else {
                i = i2;
            }
            i -= i3;
            i2 = (double)obj11;
            obj11 += i3;
            if (f2Arr2 != null) {
                f2Arr2[i4] = (float)i;
            }
        }
        return obj11;
    }

    public void b(double d, float[] f2Arr2, float[] f3Arr3) {
        int i = 4;
        final double[] dArr = new double[i];
        final double[] dArr3 = new double[i];
        int i3 = 0;
        this.e[i3].b(d, f2Arr2);
        this.e[i3].d(d, f2Arr2);
        Arrays.fill(obj13, 0);
        this.a.c(d, obj3, this.i, dArr, f3Arr3, dArr3);
    }

    boolean c(View view, float f2, long l3, c c4) {
        boolean next2;
        d.f.b.b.e[] measureSpec2;
        HashMap next;
        Collection values2;
        a aVar;
        boolean z;
        View viewById;
        int i6;
        Collection values3;
        HashMap next3;
        d.f.b.b.f fVar;
        float f;
        Object iterator2;
        Object values;
        int cmp;
        double[] dArr;
        int i;
        int i9;
        int interpolation;
        int measureSpec;
        int left;
        double cmp2;
        boolean naN;
        c cVar;
        double d;
        long iterator3;
        int iterator4;
        int i7;
        int i8;
        int i2;
        double[] iterator;
        double d3;
        int i5;
        int i4;
        int i3;
        double d2;
        double d4;
        final Object obj = this;
        final View view5 = view;
        next2 = 0;
        f = obj.a(f2, next2);
        measureSpec = obj.u;
        final int i38 = 1065353216;
        measureSpec = i38 / f8;
        if (measureSpec != d.a && !Float.isNaN(obj.v)) {
            measureSpec = i38 / f8;
            if (!Float.isNaN(obj.v)) {
                i21 %= i38;
            }
            cmp2 = obj.w;
            if (cmp2 != null) {
                interpolation = cmp2.getInterpolation(i9);
            } else {
                interpolation = Double.compare(cmp2, iterator3) > 0 ? i38 : 0;
            }
            i20 += left;
        }
        final float f15 = f;
        iterator2 = obj.p;
        if (iterator2 != null) {
            iterator2 = iterator2.values().iterator();
            for (c measureSpec : iterator2) {
                measureSpec.b(view5, f15);
            }
        }
        values = obj.o;
        final int i39 = 0;
        if (values != null) {
            iterator3 = values.values().iterator();
            iterator4 = next2;
            i7 = i39;
            while (iterator3.hasNext()) {
                next2 = iterator3.next();
                if (next2 instanceof d.a != null) {
                } else {
                }
                i7 |= next2;
                iterator4 = next2;
            }
            i5 = i7;
        } else {
            iterator4 = next2;
            i5 = i39;
        }
        a[] objArr = obj.e;
        i2 = 1;
        if (objArr != null) {
            d = (double)f15;
            objArr[i39].b(d, iterator3);
            obj.e[i39].d(d, iterator3);
            aVar = obj.f;
            dArr = obj.j;
            if (aVar != null && dArr.length > 0) {
                dArr = obj.j;
                if (dArr.length > 0) {
                    aVar.b(d, iterator3);
                    obj.f.d(d, iterator3);
                }
            }
            if (!obj.x) {
                d3 = d;
                obj.a.e(f15, view, obj.i, obj.j, obj.k, 0);
            } else {
                d3 = d;
            }
            if (obj.s != d.a && obj.t == null) {
                if (obj.t == null) {
                    obj.t = (View)view.getParent().findViewById(obj.s);
                }
                i6 = obj.t;
                int i13 = 1073741824;
                if (i6 != null && right -= left > 0 && bottom2 -= left > 0) {
                    i13 = 1073741824;
                    if (right -= left > 0) {
                        if (bottom2 -= left > 0) {
                            view5.setPivotX(measureSpec -= f5);
                            view5.setPivotY(i6 -= i);
                        }
                    }
                }
            }
            next3 = obj.p;
            if (next3 != null) {
                iterator = next3.values().iterator();
                while (iterator.hasNext()) {
                    values3 = iterator.next();
                    i = obj.k;
                    if (values3 instanceof c.a != 0 && i.length > i2) {
                    }
                    i = obj.k;
                    if (i.length > i2) {
                    }
                    (c.a)(e)values3.c(view, f15, i[i39], cmp2);
                }
            }
            if (iterator4 != null) {
                double[] dArr2 = obj.k;
                i4 = i2;
                i5 = next3;
            } else {
                i4 = i2;
            }
            i8 = i4;
            a[] objArr3 = obj.e;
            for (Object aVar4 : obj1) {
                aVar4.c(d3, i38);
                (a)kVar.E.get(obj.l[i8 + -1]).e(view5, obj.m);
                objArr3 = obj.e;
            }
            fVar = obj.c;
            if (fVar.a == 0) {
                if (Float.compare(f15, i14) <= 0) {
                    view5.setVisibility(fVar.b);
                } else {
                    if (Float.compare(f15, i15) >= 0) {
                        view5.setVisibility(fVar2.b);
                    } else {
                        if (fVar3.b != fVar.b) {
                            view5.setVisibility(i39);
                        }
                    }
                }
            }
            if (obj.r != null) {
                measureSpec2 = i39;
                cmp = obj.r;
                for (Object cmp : obj2) {
                    cmp.a(f15, view5);
                    cmp = obj.r;
                }
            }
        } else {
            i4 = i2;
            d.f.b.b.k kVar2 = obj.a;
            float f6 = kVar2.w;
            d.f.b.b.k kVar3 = obj.b;
            float f10 = kVar2.x;
            float f13 = kVar2.y;
            d = kVar3.y;
            measureSpec2 = kVar2.z;
            measureSpec = kVar3.z;
            int i37 = 1056964608;
            i16 += i37;
            iterator = (int)i17;
            i25 += i37;
            i8 = (int)i26;
            cmp = (int)i18;
            left = (int)i27;
            if (Float.compare(d, f13) == 0) {
                if (Float.compare(measureSpec, measureSpec2) != 0) {
                    int i12 = 1073741824;
                    view5.measure(View.MeasureSpec.makeMeasureSpec(cmp - iterator, i12), View.MeasureSpec.makeMeasureSpec(left - i8, i12));
                }
            } else {
            }
            view5.layout(iterator, i8, cmp, left);
        }
        next = obj.q;
        if (next != null) {
            iterator4 = next.values().iterator();
            while (iterator4.hasNext()) {
                values2 = iterator4.next();
                if (values2 instanceof b.a != 0) {
                } else {
                }
                (b)values2.b(view5, f15);
                double[] dArr3 = obj.k;
                (b.a)values2.c(view, f15, dArr3[i39], cmp2);
            }
        }
        return i5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" start: x: ");
        stringBuilder.append(kVar.w);
        String str2 = " y: ";
        stringBuilder.append(str2);
        stringBuilder.append(kVar3.x);
        stringBuilder.append(" end: x: ");
        stringBuilder.append(kVar4.w);
        stringBuilder.append(str2);
        stringBuilder.append(kVar2.x);
        return stringBuilder.toString();
    }
}
