package androidx.room;

import d.s.a.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h0<T>  extends androidx.room.b1 {
    public h0(androidx.room.u0 u0) {
        super(u0);
    }

    protected abstract void g(k k, T t2);

    public final void h(T t) {
        final k kVar = a();
        g(kVar, t);
        kVar.a2();
        f(kVar);
    }

    public final void i(T[] tArr) {
        int i;
        Object obj;
        final k kVar = a();
        i = 0;
        while (i < tArr.length) {
            g(kVar, tArr[i]);
            kVar.a2();
            i++;
        }
        f(kVar);
    }

    public final List<Long> j(T[] tArr) {
        int i;
        int i2;
        Long valueOf;
        final k kVar = a();
        ArrayList arrayList = new ArrayList(tArr.length);
        i2 = i;
        while (i < tArr.length) {
            g(kVar, tArr[i]);
            arrayList.add(i2, Long.valueOf(kVar.a2()));
            i2++;
            i++;
        }
        f(kVar);
        return arrayList;
    }
}
