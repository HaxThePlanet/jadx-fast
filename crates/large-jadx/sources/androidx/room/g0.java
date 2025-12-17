package androidx.room;

import d.s.a.k;

/* loaded from: classes.dex */
public abstract class g0<T>  extends androidx.room.b1 {
    public g0(androidx.room.u0 u0) {
        super(u0);
    }

    protected abstract void g(k k, T t2);

    public final int h(T t) {
        final k kVar = a();
        g(kVar, t);
        f(kVar);
        return kVar.N();
    }

    public final int i(T[] tArr) {
        int i;
        int i3;
        int i2;
        final k kVar = a();
        i3 = i;
        while (i < tArr.length) {
            g(kVar, tArr[i]);
            i3 += i2;
            i++;
        }
        f(kVar);
        return i3;
    }
}
