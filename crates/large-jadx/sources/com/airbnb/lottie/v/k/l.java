package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.v.a;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    private final List<a> a;
    private PointF b;
    private boolean c;
    public l() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public l(PointF pointF, boolean z2, List<a> list3) {
        super();
        this.b = pointF;
        this.c = z2;
        ArrayList obj1 = new ArrayList(list3);
        this.a = obj1;
    }

    private void e(float f, float f2) {
        PointF pointF;
        if (this.b == null) {
            pointF = new PointF();
            this.b = pointF;
        }
        this.b.set(f, f2);
    }

    public List<a> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(com.airbnb.lottie.v.k.l l, com.airbnb.lottie.v.k.l l2, float f3) {
        PointF pointF;
        boolean z;
        int i3;
        int string;
        int i;
        int i2;
        int size2;
        int size;
        float f;
        List list;
        float f9;
        a aVar;
        float f7;
        float f5;
        float f6;
        float f8;
        float f4;
        float f2;
        if (this.b == null) {
            pointF = new PointF();
            this.b = pointF;
        }
        i2 = 1;
        if (!l.d()) {
            if (l2.d()) {
                i3 = i2;
            } else {
                i3 = 0;
            }
        } else {
        }
        this.c = i3;
        if (l.a().size() != l2.a().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Curves must have the same number of control points. Shape 1: ");
            stringBuilder.append(l.a().size());
            stringBuilder.append("\tShape 2: ");
            stringBuilder.append(l2.a().size());
            d.c(stringBuilder.toString());
        }
        int i4 = Math.min(l.a().size(), l2.a().size());
        if (this.a.size() < i4) {
            size = this.a.size();
            while (size < i4) {
                aVar = new a();
                this.a.add(aVar);
                size++;
            }
        } else {
            if (this.a.size() > i4) {
                size7 -= i2;
                while (size >= i4) {
                    list = this.a;
                    list.remove(size9 -= i2);
                    size--;
                }
            }
        }
        PointF pointF2 = l.b();
        PointF pointF4 = l2.b();
        e(g.k(pointF2.x, pointF4.x, f3), g.k(pointF2.y, pointF4.y, f3));
        size4 -= i2;
        while (i >= 0) {
            Object obj = l.a().get(i);
            Object obj2 = l2.a().get(i);
            PointF pointF6 = (a)obj.a();
            PointF pointF7 = obj.b();
            PointF pointF3 = obj.c();
            PointF pointF8 = (a)obj2.a();
            PointF pointF9 = obj2.b();
            PointF pointF5 = obj2.c();
            (a)this.a.get(i).d(g.k(pointF6.x, pointF8.x, f3), g.k(pointF6.y, pointF8.y, f3));
            (a)this.a.get(i).e(g.k(pointF7.x, pointF9.x, f3), g.k(pointF7.y, pointF9.y, f3));
            (a)this.a.get(i).f(g.k(pointF3.x, pointF5.x, f3), g.k(pointF3.y, pointF5.y, f3));
            i--;
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeData{numCurves=");
        stringBuilder.append(this.a.size());
        stringBuilder.append("closed=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
