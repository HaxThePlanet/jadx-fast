package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.v.k.h;
import com.airbnb.lottie.v.k.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
/* loaded from: classes.dex */
public class l implements m, j {

    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final List<m> d = new ArrayList<>();
    private final h e;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[h.a.values().length];
            l.a.a = iArr;
            try {
                iArr[h.a.MERGE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[h.a.ADD.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[h.a.INTERSECT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public l(h hVar) {
        super();
        Path path = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        } else {
            hVar.c();
            this.e = hVar;
            return;
        }
    }

    private void a() {
        int i = 0;
        i = 0;
        while (i < this.d.size()) {
            this.c.addPath((m)this.d.get(i).getPath());
            i = i + 1;
        }
    }

    private void c(Path.Op opVar) {
        int i;
        int i2 = 0;
        Object item2;
        int size;
        List list2;
        int i3;
        Path path2;
        Path path3;
        this.b.reset();
        this.a.reset();
        int i4 = 1;
        i = this.d.size() - i4;
        while (this.b >= i4) {
            item2 = this.d.get(i);
            i = i - 1;
        }
        i2 = 0;
        Object item = this.d.get(i2);
        if (item instanceof d) {
            List list = item.i();
            while (i2 < list.size()) {
                Path path = (m)list.get(i2).getPath();
                path.transform(item.j());
                this.a.addPath(path);
                i2 = i2 + 1;
            }
        } else {
            this.a.set(item.getPath());
        }
        this.c.op(this.a, this.b, opVar);
    }

    public void b(List<c> list, List<c> list2) {
        int i = 0;
        i = 0;
        while (i < this.d.size()) {
            (m)this.d.get(i).b(list, list2);
            i = i + 1;
        }
    }

    public void e(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious()) {
        }
        while (listIterator.hasPrevious()) {
            Object prev = listIterator.previous();
        }
    }

    public Path getPath() {
        this.c.reset();
        if (this.e.d()) {
            return this.c;
        }
        int i2 = l.a.a[this.e.b().ordinal()];
        int i = 1;
        if (l.a.a == 1) {
            a();
        } else {
            i = 2;
            if (l.a.a == 2) {
                c(Path.Op.UNION);
            } else {
                i = 3;
                if (l.a.a == 3) {
                    c(Path.Op.REVERSE_DIFFERENCE);
                } else {
                    i = 4;
                    if (Path.Op.REVERSE_DIFFERENCE == 4) {
                        c(Path.Op.INTERSECT);
                    } else {
                        i = 5;
                        if (Path.Op.REVERSE_DIFFERENCE == 5) {
                            c(Path.Op.XOR);
                        }
                    }
                }
            }
        }
        return this.c;
    }
}
