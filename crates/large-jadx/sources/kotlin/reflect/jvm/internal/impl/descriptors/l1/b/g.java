package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.a;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public final class g {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c a(Annotation[] annotationArr, b b2) {
        int i;
        int cVar;
        Object obj;
        boolean z;
        n.f(annotationArr, "<this>");
        n.f(b2, "fqName");
        i = 0;
        while (i < annotationArr.length) {
            i++;
        }
        obj = cVar;
        if (obj == null) {
        } else {
            cVar = new c(obj);
        }
        return cVar;
    }

    public static final List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c> b(Annotation[] annotationArr) {
        int i;
        Object obj;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c cVar;
        n.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        i = 0;
        while (i < annotationArr.length) {
            cVar = new c(annotationArr[i]);
            arrayList.add(cVar);
            i++;
        }
        return arrayList;
    }
}
