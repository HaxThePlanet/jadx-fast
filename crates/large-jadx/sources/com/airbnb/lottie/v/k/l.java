package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.v.a;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class l {

    private final List<a> a = new ArrayList<>();
    private PointF b;
    private boolean c;
    public l(PointF pointF, boolean z, List<a> list) {
        super();
        this.b = pointF;
        this.c = z;
        final ArrayList arrayList = new ArrayList(list);
    }

    private void e(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public List<a> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(l lVar, l lVar2, float f) {
        int i = 0;
        int i2;
        int size3;
        List list;
        a aVar;
        int i3;
        if (this.b == null) {
            this.b = new PointF();
        }
        i = 1;
        if (lVar.d() || lVar2.d()) {
        }
        this.c = i;
        if (lVar.a().size() != lVar2.a().size()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Curves must have the same number of control points. Shape 1: ";
            int size9 = lVar.a().size();
            String str3 = "\tShape 2: ";
            int size2 = lVar2.a().size();
            str = str2 + size9 + str3 + size2;
            d.c(str);
        }
        int min = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.a.size() < min) {
            size3 = this.a.size();
            while (this.a < min) {
                this.a.add(new a());
                size3 = size3 + 1;
            }
        } else {
            if (this.a.size() > min) {
                size3 = this.a.size() - i;
                while (this.a >= min) {
                    i3 = this.a.size() - i;
                    this.a.remove(i3);
                    size3 = size3 - 1;
                }
            }
        }
        PointF pointF2 = lVar.b();
        PointF pointF4 = lVar2.b();
        e(g.k(pointF2.x, pointF4.x, f), g.k(pointF2.y, pointF4.y, f));
        i2 = this.a.size() - i;
        while (pointF2.y >= 0) {
            Object item = lVar.a().get(i2);
            Object item2 = lVar2.a().get(i2);
            PointF pointF6 = item.a();
            PointF pointF7 = item.b();
            PointF pointF3 = item.c();
            PointF pointF8 = item2.a();
            PointF pointF9 = item2.b();
            PointF pointF5 = item2.c();
            (a)this.a.get(i2).d(g.k(pointF6.x, pointF8.x, f), g.k(pointF6.y, pointF8.y, f));
            (a)this.a.get(i2).e(g.k(pointF7.x, pointF9.x, f), g.k(pointF7.y, pointF9.y, f));
            (a)this.a.get(i2).f(g.k(pointF3.x, pointF5.x, f), g.k(pointF3.y, pointF5.y, f));
            i2 = i2 - 1;
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ShapeData{numCurves=";
        int size = this.a.size();
        String str3 = "closed=";
        str = str2 + size + str3 + this.c + 125;
        return str;
    }

    public l() {
        super();
        final ArrayList arrayList = new ArrayList();
    }
}
