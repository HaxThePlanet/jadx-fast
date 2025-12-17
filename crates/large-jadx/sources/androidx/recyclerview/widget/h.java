package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h {

    private static final Comparator<androidx.recyclerview.widget.h.d> a;

    class a implements Comparator<androidx.recyclerview.widget.h.d> {
        @Override // java.util.Comparator
        public int a(androidx.recyclerview.widget.h.d h$d, androidx.recyclerview.widget.h.d h$d2) {
            return obj1 -= obj2;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((h.d)object, (h.d)object2);
        }
    }

    public static abstract class b {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    static class c {

        private final int[] a;
        private final int b;
        c(int i) {
            super();
            int[] obj1 = new int[i];
            this.a = obj1;
            this.b = obj1 /= 2;
        }

        int[] a() {
            return this.a;
        }

        int b(int i) {
            return this.a[i += i2];
        }

        void c(int i, int i2) {
            this.a[i += i3] = i2;
        }
    }

    static class d {

        public final int a;
        public final int b;
        public final int c;
        d(int i, int i2, int i3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        int a() {
            return i += i3;
        }

        int b() {
            return i += i3;
        }
    }

    public static class e {

        private final List<androidx.recyclerview.widget.h.d> a;
        private final int[] b;
        private final int[] c;
        private final androidx.recyclerview.widget.h.b d;
        private final int e;
        private final int f;
        private final boolean g;
        e(androidx.recyclerview.widget.h.b h$b, List<androidx.recyclerview.widget.h.d> list2, int[] i3Arr3, int[] i4Arr4, boolean z5) {
            super();
            this.a = list2;
            this.b = i3Arr3;
            this.c = i4Arr4;
            int obj2 = 0;
            Arrays.fill(i3Arr3, obj2);
            Arrays.fill(i4Arr4, obj2);
            this.d = b;
            this.e = b.getOldListSize();
            this.f = b.getNewListSize();
            this.g = z5;
            a();
            e();
        }

        private void a() {
            Object obj;
            androidx.recyclerview.widget.h.d dVar;
            final int i = 0;
            if (this.a.isEmpty()) {
                obj = 0;
            } else {
                obj = this.a.get(i);
            }
            if (obj != null && obj.a == 0) {
                if (obj.a == 0) {
                    if (obj.b != 0) {
                        dVar = new h.d(i, i, i);
                        this.a.add(i, dVar);
                    }
                } else {
                }
            } else {
            }
            h.d dVar2 = new h.d(this.e, this.f, i);
            this.a.add(dVar2);
        }

        private void d(int i) {
            int i2;
            int i4;
            int i3;
            Object obj;
            int itemsTheSame;
            i3 = i4;
            while (i4 < this.a.size()) {
                obj = this.a.get(i4);
                while (i3 < obj.b) {
                    i3++;
                }
                i3 = (h.d)obj.b();
                i4++;
                i3++;
            }
        }

        private void e() {
            Object next;
            int i2;
            int i4;
            int i3;
            int i;
            int[] iArr;
            int i5;
            Iterator iterator = this.a.iterator();
            for (h.d next : iterator) {
                i2 = 0;
                while (i2 < next.c) {
                    i6 += i2;
                    i9 += i2;
                    if (this.d.areContentsTheSame(i7, i3)) {
                    } else {
                    }
                    i = 2;
                    this.b[i7] = i10 |= i;
                    this.c[i3] = i8 |= i;
                    i2++;
                    i = 1;
                }
                i6 += i2;
                i9 += i2;
                if (this.d.areContentsTheSame(i7, i3)) {
                } else {
                }
                i = 2;
                this.b[i7] = i10 |= i;
                this.c[i3] = i8 |= i;
                i2++;
                i = 1;
            }
            if (this.g) {
                f();
            }
        }

        private void f() {
            int i2;
            Object next;
            int i;
            Iterator iterator = this.a.iterator();
            i2 = 0;
            for (h.d next : iterator) {
                while (i2 < next.a) {
                    if (this.b[i2] == 0) {
                    }
                    i2++;
                    d(i2);
                }
                i2 = next.a();
                if (this.b[i2] == 0) {
                }
                i2++;
                d(i2);
            }
        }

        private static androidx.recyclerview.widget.h.g g(Collection<androidx.recyclerview.widget.h.g> collection, int i2, boolean z3) {
            Object next;
            boolean z;
            int obj3;
            final Iterator obj2 = collection.iterator();
            for (h.g next : obj2) {
            }
            next = 0;
            while (obj2.hasNext()) {
                obj3 = obj2.next();
                if (z3) {
                } else {
                }
                obj3.b = i++;
                obj3.b = i3--;
            }
            return next;
        }

        public void b(androidx.recyclerview.widget.r r) {
            boolean eVar;
            int i7;
            int i;
            int i9;
            int i2;
            int i6;
            int i8;
            Object obj;
            int i5;
            int changePayload;
            int i3;
            int gVar;
            int changePayload2;
            int i4;
            Object obj13;
            if (r instanceof e) {
            } else {
                eVar = new e((e)r);
                obj13 = eVar;
            }
            i7 = this.e;
            ArrayDeque arrayDeque = new ArrayDeque();
            i = this.e;
            i2 = this.f;
            final int i10 = 1;
            size -= i10;
            while (i8 >= 0) {
                obj = this.a.get(i8);
                gVar = 0;
                while (i > (h.d)obj.a()) {
                    i--;
                    changePayload2 = this.b[i];
                    if (changePayload2 & 12 != 0) {
                    } else {
                    }
                    obj13.onRemoved(i, i10);
                    i7--;
                    gVar = 0;
                    i4 = changePayload2 >> 4;
                    androidx.recyclerview.widget.h.g gVar2 = h.e.g(arrayDeque, i4, gVar);
                    if (gVar2 != null) {
                    } else {
                    }
                    gVar = new h.g(i, i14 -= i10, i10);
                    arrayDeque.add(gVar);
                    i13 -= i10;
                    obj13.onMoved(i, gVar);
                    if (changePayload2 &= 4 != 0) {
                    }
                    obj13.onChanged(gVar, i10, this.d.getChangePayload(i, i4));
                }
                while (i2 > obj.b()) {
                    i2--;
                    changePayload = this.c[i2];
                    if (changePayload & 12 != 0) {
                    } else {
                    }
                    obj13.onInserted(i, i10);
                    i7++;
                    changePayload2 = changePayload >> 4;
                    i4 = h.e.g(arrayDeque, changePayload2, i10);
                    if (i4 == null) {
                    } else {
                    }
                    obj13.onMoved(i16 -= i10, i);
                    if (changePayload &= 4 != 0) {
                    }
                    obj13.onChanged(i, i10, this.d.getChangePayload(changePayload2, i2));
                    changePayload = new h.g(i2, i7 - i, gVar);
                    arrayDeque.add(changePayload);
                }
                i9 = obj.a;
                i6 = obj.b;
                while (gVar < obj.c) {
                    if (i11 &= 15 == 2) {
                    }
                    i9++;
                    i6++;
                    gVar++;
                    obj13.onChanged(i9, i10, this.d.getChangePayload(i9, i6));
                }
                i = obj.a;
                i2 = obj.b;
                i8--;
                if (i11 &= 15 == 2) {
                }
                i9++;
                i6++;
                gVar++;
                obj13.onChanged(i9, i10, this.d.getChangePayload(i9, i6));
                i2--;
                changePayload = this.c[i2];
                if (changePayload & 12 != 0) {
                } else {
                }
                obj13.onInserted(i, i10);
                i7++;
                changePayload2 = changePayload >> 4;
                i4 = h.e.g(arrayDeque, changePayload2, i10);
                if (i4 == null) {
                } else {
                }
                obj13.onMoved(i16 -= i10, i);
                if (changePayload &= 4 != 0) {
                }
                obj13.onChanged(i, i10, this.d.getChangePayload(changePayload2, i2));
                changePayload = new h.g(i2, i7 - i, gVar);
                arrayDeque.add(changePayload);
                i--;
                changePayload2 = this.b[i];
                if (changePayload2 & 12 != 0) {
                } else {
                }
                obj13.onRemoved(i, i10);
                i7--;
                i4 = changePayload2 >> 4;
                gVar2 = h.e.g(arrayDeque, i4, gVar);
                if (gVar2 != null) {
                } else {
                }
                gVar = new h.g(i, i14 -= i10, i10);
                arrayDeque.add(gVar);
                i13 -= i10;
                obj13.onMoved(i, gVar);
                if (changePayload2 &= 4 != 0) {
                }
                obj13.onChanged(gVar, i10, this.d.getChangePayload(i, i4));
            }
            obj13.a();
        }

        public void c(androidx.recyclerview.widget.RecyclerView.h recyclerView$h) {
            b bVar = new b(h);
            b(bVar);
        }
    }

    public static abstract class f {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    private static class g {

        int a;
        int b;
        boolean c;
        g(int i, int i2, boolean z3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = z3;
        }
    }

    static class h {

        int a;
        int b;
        int c;
        int d;
        public h(int i, int i2, int i3, int i4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        int a() {
            return i -= i3;
        }

        int b() {
            return i -= i3;
        }
    }

    static class i {

        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        int a() {
            return Math.min(i -= i4, i5 -= i7);
        }

        boolean b() {
            int i;
            i = i2 -= i4 != i5 -= i7 ? 1 : 0;
            return i;
        }

        boolean c() {
            int i;
            i = i2 -= i4 > i5 -= i7 ? 1 : 0;
            return i;
        }

        androidx.recyclerview.widget.h.d d() {
            if (b() && this.e) {
                if (this.e) {
                    h.d dVar3 = new h.d(this.a, this.b, a());
                    return dVar3;
                }
                if (c()) {
                    h.d dVar2 = new h.d(this.a, i7++, a());
                    return dVar2;
                }
                h.d dVar = new h.d(i++, this.b, a());
                return dVar;
            }
            int i5 = this.a;
            h.d dVar4 = new h.d(i5, this.b, i14 -= i5);
            return dVar4;
        }
    }
    static {
        h.a aVar = new h.a();
        h.a = aVar;
    }

    private static androidx.recyclerview.widget.h.i a(androidx.recyclerview.widget.h.h h$h, androidx.recyclerview.widget.h.b h$b2, androidx.recyclerview.widget.h.c h$c3, androidx.recyclerview.widget.h.c h$c4, int i5) {
        int i6;
        int i;
        int i8;
        int i2;
        int i3;
        int i4;
        int itemsTheSame;
        int i7;
        int i13 = 1;
        i6 = i10 %= 2 == 0 ? i13 : 0;
        int i17 = -i5;
        i = i17;
        while (i <= i5) {
            if (i != i17) {
            } else {
            }
            i2 = i8;
            i22 -= i25;
            if (i5 != 0) {
            } else {
            }
            i4 = i3;
            while (i2 > h.a) {
                if (i3 > h.c) {
                }
                if (b2.areItemsTheSame(i2 + -1, i3 + -1)) {
                }
                i2--;
                i3--;
            }
            c4.c(i, i2);
            i += 2;
            itemsTheSame = i15 - i;
            if (i3 > h.c) {
            }
            if (b2.areItemsTheSame(i2 + -1, i3 + -1)) {
            }
            i2--;
            i3--;
            if (i2 != i8) {
            } else {
            }
            i4 = i3 + 1;
            if (i != i5 && c4.b(i + 1) < c4.b(i + -1)) {
            } else {
            }
            i2 = i8 + -1;
            if (c4.b(i + 1) < c4.b(i + -1)) {
            } else {
            }
        }
        return null;
    }

    public static androidx.recyclerview.widget.h.e b(androidx.recyclerview.widget.h.b h$b) {
        return h.c(b, true);
    }

    public static androidx.recyclerview.widget.h.e c(androidx.recyclerview.widget.h.b h$b, boolean z2) {
        int remove;
        int i3;
        int i4;
        int i;
        Object hVar;
        int i2;
        int oldListSize = b.getOldListSize();
        int newListSize = b.getNewListSize();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        remove = 0;
        h.h hVar2 = new h.h(remove, oldListSize, remove, newListSize);
        arrayList2.add(hVar2);
        i8++;
        h.c cVar = new h.c(i9);
        h.c cVar2 = new h.c(i9);
        ArrayList arrayList = new ArrayList();
        while (!arrayList2.isEmpty()) {
            remove = arrayList2.remove(size--);
            i3 = h.e((h.h)remove, b, cVar, cVar2);
            if (i3 != null) {
            } else {
            }
            arrayList.add(remove);
            if (i3.a() > 0) {
            }
            if (arrayList.isEmpty()) {
            } else {
            }
            hVar = arrayList.remove(size2--);
            hVar.a = remove.a;
            hVar.c = remove.c;
            hVar.b = i3.a;
            hVar.d = i3.b;
            arrayList2.add(hVar);
            remove.b = remove.b;
            remove.d = remove.d;
            remove.a = i3.c;
            remove.c = i3.d;
            arrayList2.add(remove);
            hVar = new h.h();
            arrayList3.add(i3.d());
        }
        Collections.sort(arrayList3, h.a);
        super(b, arrayList3, cVar.a(), cVar2.a(), z2);
        return eVar;
    }

    private static androidx.recyclerview.widget.h.i d(androidx.recyclerview.widget.h.h h$h, androidx.recyclerview.widget.h.b h$b2, androidx.recyclerview.widget.h.c h$c3, androidx.recyclerview.widget.h.c h$c4, int i5) {
        int i3;
        int i2;
        int i7;
        int i4;
        int i;
        int i6;
        int itemsTheSame;
        int i8;
        int i16 = 0;
        if (i11 %= 2 == 1) {
        } else {
            i3 = i16;
        }
        int i18 = -i5;
        i2 = i18;
        while (i2 <= i5) {
            if (i2 != i18) {
            } else {
            }
            i4 = i7;
            i24 -= i2;
            if (i5 != 0) {
            } else {
            }
            i6 = i;
            while (i4 < h.b) {
                if (i < h.d) {
                }
                if (b2.areItemsTheSame(i4, i)) {
                }
                i4++;
                i++;
            }
            c3.c(i2, i4);
            i2 += 2;
            itemsTheSame = i14 - i2;
            if (i < h.d) {
            }
            if (b2.areItemsTheSame(i4, i)) {
            }
            i4++;
            i++;
            if (i4 != i7) {
            } else {
            }
            i6 = i + -1;
            if (i2 != i5 && c3.b(i2 + 1) > c3.b(i2 + -1)) {
            } else {
            }
            i4 = i7 + 1;
            if (c3.b(i2 + 1) > c3.b(i2 + -1)) {
            } else {
            }
        }
        return null;
    }

    private static androidx.recyclerview.widget.h.i e(androidx.recyclerview.widget.h.h h$h, androidx.recyclerview.widget.h.b h$b2, androidx.recyclerview.widget.h.c h$c3, androidx.recyclerview.widget.h.c h$c4) {
        int i;
        int i2;
        int i3;
        i2 = 1;
        if (h.b() >= i2) {
            if (h.a() < i2) {
            } else {
                c3.c(i2, h.a);
                c4.c(i2, h.b);
                i2 = 0;
                while (i2 < i6 /= 2) {
                    androidx.recyclerview.widget.h.i iVar = h.d(h, b2, c3, c4, i2);
                    i3 = h.a(h, b2, c3, c4, i2);
                    i2++;
                }
            }
        }
        return null;
    }
}
