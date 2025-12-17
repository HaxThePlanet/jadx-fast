package i.b.m0.j;

import i.b.l0.o;
import i.b.y;
import m.c.b;

/* loaded from: classes3.dex */
public class a<T>  {

    final int a;
    final Object[] b;
    Object[] c;
    int d;

    public interface a extends o<T> {
        public abstract boolean test(T t);
    }
    public a(int i) {
        super();
        this.a = i;
        Object[] obj1 = new Object[i++];
        this.b = obj1;
        this.c = obj1;
    }

    public <U> boolean a(y<? super U> y) {
        Object[] objArr;
        int i;
        Object acceptFull;
        objArr = this.b;
        final int i2 = this.a;
        while (objArr != null) {
            while (i < i2) {
                acceptFull = objArr[i];
                i++;
            }
            objArr = objArr[i2];
            acceptFull = objArr[i];
            i++;
        }
        return 0;
    }

    public <U> boolean b(b<? super U> b) {
        Object[] objArr;
        int i;
        Object acceptFull;
        objArr = this.b;
        final int i2 = this.a;
        while (objArr != null) {
            while (i < i2) {
                acceptFull = objArr[i];
                i++;
            }
            objArr = objArr[i2];
            acceptFull = objArr[i];
            i++;
        }
        return 0;
    }

    public void c(T t) {
        int i;
        Object[] objArr;
        int i2 = this.a;
        if (this.d == i2) {
            Object[] arr = new Object[i2 + 1];
            this.c[i2] = arr;
            this.c = arr;
            i = 0;
        }
        this.c[i] = t;
        this.d = i++;
    }

    public void d(i.b.m0.j.a.a<? super T> a$a) {
        Object[] objArr;
        int i;
        Object test;
        objArr = this.b;
        final int i2 = this.a;
        while (objArr != null) {
            i = 0;
            while (i < i2) {
                test = objArr[i];
                i++;
            }
            objArr = objArr[i2];
            test = objArr[i];
            i++;
        }
    }

    public void e(T t) {
        this.b[0] = t;
    }
}
