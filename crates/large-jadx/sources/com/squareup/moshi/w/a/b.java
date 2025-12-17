package com.squareup.moshi.w.a;

import com.squareup.moshi.e;
import com.squareup.moshi.f;
import com.squareup.moshi.f.d;
import com.squareup.moshi.i.a;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
import com.squareup.moshi.v.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.a;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.i0.b;
import kotlin.i0.c;
import kotlin.i0.d;
import kotlin.i0.k;
import kotlin.i0.z.a;
import kotlin.i0.z.c;
import kotlin.reflect.full.a;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes2.dex */
public final class b implements f.d {
    public f<?> a(Type type, Set<? extends Annotation> set2, r r3) {
        f fVar;
        int size;
        Object next4;
        int annotations;
        int name2;
        Map map;
        Throwable th;
        int i5;
        int next2;
        boolean next;
        String aVar;
        boolean transient;
        int modifiers;
        int i2;
        Object name;
        int index;
        String returnType;
        Iterator iterator;
        Object obj;
        f next3;
        String str;
        Object obj2;
        Object obj3;
        int i4;
        int i3;
        int i;
        Object obj4 = type;
        next4 = r3;
        n.f(obj4, "type");
        n.f(set2, "annotations");
        n.f(next4, "moshi");
        annotations = 1;
        name2 = 0;
        if (empty ^= annotations != 0) {
            return name2;
        }
        final Class cls2 = u.a(type);
        if (cls2.isInterface()) {
            return name2;
        }
        if (cls2.isEnum()) {
            return name2;
        }
        if (!cls2.isAnnotationPresent(c.b())) {
            return name2;
        }
        if (b.i(cls2)) {
            return name2;
        }
        fVar = b.d(next4, obj4, cls2);
        if (fVar != null) {
            return fVar;
        }
        if (localClass ^= annotations == 0) {
        } else {
            d dVar = a.e(cls2);
            if (abstract ^= annotations == 0) {
            } else {
                if (z3 ^= annotations == 0) {
                } else {
                    final int i15 = 0;
                    i5 = dVar.p() == null ? annotations : i15;
                    if (i5 == 0) {
                    } else {
                        if (z4 ^= annotations == 0) {
                        } else {
                            kotlin.i0.g gVar = a.b(dVar);
                            if (gVar != null) {
                                List parameters2 = gVar.getParameters();
                                final int i16 = 10;
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap(g.b(j0.d(p.r(parameters2, i16)), 16));
                                Iterator iterator6 = parameters2.iterator();
                                for (Object next2 : iterator6) {
                                    linkedHashMap2.put((k)next2.getName(), next2);
                                }
                                a.a(gVar, annotations);
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                Iterator iterator2 = a.a(dVar).iterator();
                                aVar = "null cannot be cast to non-null type kotlin.Array<T>";
                                while (iterator2.hasNext()) {
                                    next = iterator2.next();
                                    obj = obj8;
                                    Field field = c.b(next);
                                    if (field != null) {
                                    } else {
                                    }
                                    modifiers = i15;
                                    if ((k)obj != null) {
                                    } else {
                                    }
                                    i2 = annotations;
                                    if (!next instanceof j && (k)obj == null) {
                                    } else {
                                    }
                                    a.a(next, annotations);
                                    name = p.N0(next.getAnnotations());
                                    iterator = next.getAnnotations().iterator();
                                    for (Object next3 : iterator) {
                                        annotations = 1;
                                    }
                                    next3 = name2;
                                    p.y(name, (k)obj.getAnnotations());
                                    if (obj != null && (e)next3 == null) {
                                    }
                                    if (next3 != null && next3.name() != null) {
                                    } else {
                                    }
                                    annotations = next.getName();
                                    returnType = annotations;
                                    Object[] array2 = name.toArray(new Annotation[i15]);
                                    Objects.requireNonNull(array2, aVar);
                                    annotations = next4.f(b.n(obj4, cls2, c.f(next.getReturnType())), b.k((Annotation[])array2), next.getName());
                                    name = next3.name();
                                    if (next3 != null && name != null) {
                                    } else {
                                    }
                                    str = returnType;
                                    n.e(annotations, "adapter");
                                    Objects.requireNonNull(next, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>");
                                    if (obj != null) {
                                    } else {
                                    }
                                    index = -1;
                                    super(returnType, str, annotations, next, obj, index);
                                    linkedHashMap.put(next.getName(), aVar);
                                    annotations = 1;
                                    name2 = 0;
                                    aVar = "null cannot be cast to non-null type kotlin.Array<T>";
                                    index = obj.getIndex();
                                    name = next3.name();
                                    if (name != null) {
                                    } else {
                                    }
                                    str = name;
                                    if (next3.name() != null) {
                                    } else {
                                    }
                                    p.y(name, obj.getAnnotations());
                                    if ((e)next3 == null) {
                                    }
                                    annotations = obj.getAnnotations().iterator();
                                    for (Object iterator : annotations) {
                                        name2 = 0;
                                    }
                                    iterator = 0;
                                    next3 = iterator;
                                    if (it instanceof e) {
                                    } else {
                                    }
                                    name2 = 0;
                                    if (obj6 instanceof e) {
                                    } else {
                                    }
                                    annotations = 1;
                                    if (obj == null) {
                                    } else {
                                    }
                                    if (n.b(obj.getType(), next.getReturnType())) {
                                    } else {
                                    }
                                    i2 = i15;
                                    if (obj != null) {
                                    } else {
                                    }
                                    next = annotations;
                                    if (obj.h()) {
                                    } else {
                                    }
                                    next = i15;
                                    modifiers = field.getModifiers();
                                }
                                ArrayList arrayList = new ArrayList();
                                Iterator iterator3 = gVar.getParameters().iterator();
                                while (iterator3.hasNext()) {
                                    next4 = iterator3.next();
                                    annotations = g0.c(linkedHashMap).remove((k)next4.getName());
                                    if ((a.a)annotations == 0) {
                                    } else {
                                    }
                                    name2 = 1;
                                    arrayList.add((a.a)annotations);
                                    if (next4.h()) {
                                    } else {
                                    }
                                    name2 = i15;
                                }
                                size = arrayList.size();
                                Iterator iterator4 = linkedHashMap.entrySet().iterator();
                                i4 = size;
                                for (Map.Entry next6 : iterator4) {
                                    size = i4 + 1;
                                    arrayList.add(a.a.b((a.a)next6.getValue(), 0, 0, null, null, null, i4, 31, 0));
                                    i4 = size;
                                }
                                List list = p.U(arrayList);
                                ArrayList arrayList2 = new ArrayList(p.r(list, i16));
                                Iterator iterator5 = list.iterator();
                                for (a.a next9 : iterator5) {
                                    arrayList2.add(next9.f());
                                }
                                Object[] array = arrayList2.toArray(new String[i15]);
                                Objects.requireNonNull(array, aVar);
                                i.a aVar2 = i.a.a((String[])Arrays.copyOf((String[])array, array.length));
                                n.e(aVar2, "options");
                                a aVar3 = new a(gVar, arrayList, list, aVar2);
                                return aVar3.f();
                            }
                            return name2;
                        }
                        StringBuilder stringBuilder7 = new StringBuilder();
                        stringBuilder7.append("Cannot reflectively serialize sealed class ");
                        stringBuilder7.append(cls2.getName());
                        stringBuilder7.append(". Please register an adapter.");
                        IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(stringBuilder7.toString().toString());
                        throw illegalArgumentException7;
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Cannot serialize object declaration ");
                    stringBuilder3.append(cls2.getName());
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString().toString());
                    throw illegalArgumentException3;
                }
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append("Cannot serialize inner class ");
                stringBuilder8.append(cls2.getName());
                IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(stringBuilder8.toString().toString());
                throw illegalArgumentException8;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot serialize abstract class ");
            stringBuilder2.append(cls2.getName());
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString().toString());
            throw illegalArgumentException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot serialize local class or object expression ");
        stringBuilder.append(cls2.getName());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
        throw illegalArgumentException;
    }
}
