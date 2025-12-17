package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.e;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class h extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d implements e {

    private final Object[] c;
    public h(e e, Object[] object2Arr2) {
        n.f(object2Arr2, "values");
        super(e);
        this.c = object2Arr2;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d> e() {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d dVar;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d.a aVar;
        int i2;
        final Object[] objArr = this.c;
        ArrayList arrayList = new ArrayList(objArr.length);
        i = 0;
        while (i < objArr.length) {
            Object obj = objArr[i];
            n.d(obj);
            arrayList.add(d.b.a(obj, 0));
            i++;
        }
        return arrayList;
    }
}
