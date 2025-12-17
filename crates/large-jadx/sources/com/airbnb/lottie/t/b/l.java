package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.v.k.h;
import com.airbnb.lottie.v.k.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class l implements com.airbnb.lottie.t.b.m, com.airbnb.lottie.t.b.j {

    private final Path a;
    private final Path b;
    private final Path c;
    private final List<com.airbnb.lottie.t.b.m> d;
    private final h e;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l.a.a = iArr;
            iArr[h.a.MERGE.ordinal()] = 1;
            l.a.a[h.a.ADD.ordinal()] = 2;
            l.a.a[h.a.SUBTRACT.ordinal()] = 3;
            l.a.a[h.a.INTERSECT.ordinal()] = 4;
            l.a.a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
        }
    }
    public l(h h) {
        super();
        Path path = new Path();
        this.a = path;
        Path path2 = new Path();
        this.b = path2;
        Path path3 = new Path();
        this.c = path3;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        if (Build.VERSION.SDK_INT < 19) {
        } else {
            h.c();
            this.e = h;
        }
        IllegalStateException obj3 = new IllegalStateException("Merge paths are not supported pre-KitKat.");
        throw obj3;
    }

    private void a() {
        int i;
        Path path;
        Path path2;
        i = 0;
        while (i < this.d.size()) {
            this.c.addPath((m)this.d.get(i).getPath());
            i++;
        }
    }

    private void c(Path.Op path$Op) {
        int i;
        Object path4;
        int i3;
        Object path;
        List list;
        int size;
        int i2;
        Path path2;
        Path path3;
        this.b.reset();
        this.a.reset();
        int i4 = 1;
        size2 -= i4;
        while (i >= i4) {
            path = this.d.get(i);
            if (path instanceof d) {
            } else {
            }
            this.b.addPath((m)path.getPath());
            i--;
            size = (d)path.i();
            size3 -= i4;
            while (i2 >= 0) {
                path2 = (m)size.get(i2).getPath();
                path2.transform(path.j());
                this.b.addPath(path2);
                i2--;
            }
            path2 = (m)size.get(i2).getPath();
            path2.transform(path.j());
            this.b.addPath(path2);
            i2--;
        }
        path4 = this.d.get(0);
        if (path4 instanceof d) {
            list = (d)(m)path4.i();
            while (i3 < list.size()) {
                size = (m)list.get(i3).getPath();
                size.transform(path4.j());
                this.a.addPath(size);
                i3++;
            }
        } else {
            this.a.set(path4.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        int i;
        Object obj;
        i = 0;
        while (i < this.d.size()) {
            (m)this.d.get(i).b(list, list2);
            i++;
        }
    }

    public void e(ListIterator<com.airbnb.lottie.t.b.c> listIterator) {
        boolean previous;
        boolean z;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() != this) {
            }
        }
        while (listIterator.hasPrevious()) {
            previous = listIterator.previous();
            if (previous instanceof m) {
            }
            this.d.add((m)(c)previous);
            listIterator.remove();
        }
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        Path.Op rEVERSE_DIFFERENCE;
        int i;
        this.c.reset();
        if (this.e.d()) {
            return this.c;
        }
        rEVERSE_DIFFERENCE = l.a.a[this.e.b().ordinal()];
        if (rEVERSE_DIFFERENCE != 1) {
            if (rEVERSE_DIFFERENCE != 2) {
                if (rEVERSE_DIFFERENCE != 3) {
                    if (rEVERSE_DIFFERENCE != 4) {
                        if (rEVERSE_DIFFERENCE != 5) {
                        } else {
                            c(Path.Op.XOR);
                        }
                    } else {
                        c(Path.Op.INTERSECT);
                    }
                } else {
                    c(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                c(Path.Op.UNION);
            }
        } else {
            a();
        }
        return this.c;
    }
}
