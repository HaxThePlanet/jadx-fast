package i.b.m0.j;

import i.b.l0.o;
import i.b.y;
import m.c.b;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes3.dex */
public class a<T> {

    final int a;
    final Object[] b;
    Object[] c;
    int d;

    public interface a<T> extends o<T> {
        boolean test(T t);
    }
    public a(int i) {
        super();
        this.a = i;
        Object[] arr = new Object[i + 1];
        this.b = arr;
        this.c = arr;
    }

    public <U> boolean a(y<? super U> yVar) {
        Object[] objArr;
        int i = 0;
        boolean acceptFull;
        i = 0;
        while (this.b != null) {
            while (i < this.a) {
                Object obj = objArr[i];
                if (n.acceptFull(obj, yVar)) {
                    return true;
                }
            }
            objArr = objArr[i2];
            i = 0;
            obj = objArr[i];
            if (obj != null) {
            }
        }
        return false;
    }

    public <U> boolean b(b<? super U> bVar) {
        Object[] objArr;
        int i = 0;
        boolean acceptFull;
        i = 0;
        while (this.b != null) {
            while (i < this.a) {
                Object obj = objArr[i];
                if (n.acceptFull(obj, bVar)) {
                    return true;
                }
            }
            objArr = objArr[i2];
            i = 0;
            obj = objArr[i];
            if (obj != null) {
            }
        }
        return false;
    }

    public void c(T t) {
        int i = 0;
        if (this.d == this.a) {
            Object[] arr = new Object[i2 + 1];
            this.c[this.a] = arr;
            this.c = arr;
            i = 0;
        }
        this.c[i] = t;
        this.d = i + 1;
    }

    public void d(a.a<? super T> aVar) {
        Object[] objArr;
        int i = 0;
        boolean test;
        while (this.b != null) {
            i = 0;
            while (i < this.a) {
                Object obj = objArr[i];
                if (aVar.test(obj)) {
                    return;
                }
            }
            objArr = objArr[i2];
            obj = objArr[i];
            if (obj != null) {
            }
        }
    }

    public void e(T t) {
        this.b[0] = t;
    }
}
