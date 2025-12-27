package com.squareup.moshi.w.a;

import com.squareup.moshi.e;
import com.squareup.moshi.f;
import com.squareup.moshi.f.d;
import com.squareup.moshi.i.a;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
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
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.i0.d;
import kotlin.i0.k;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: KotlinJsonAdapter.kt */
/* loaded from: classes2.dex */
public final class b implements f.d {
    public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
        int index;
        boolean hasNext = true;
        String name;
        int modifiers = 0;
        String name3;
        com.squareup.moshi.w.a.a.a aVar;
        List list;
        kotlin.i0.o returnType;
        f fVar2;
        kotlin.i0.n nVar;
        Object obj;
        Type type2 = type;
        rVar32 = rVar;
        n.f(type2, "type");
        n.f(set, "annotations");
        n.f(rVar32, "moshi");
        hasNext = true;
        modifiers = 0;
        if (set.isEmpty() ^ hasNext) {
            return null;
        }
        final Class cls2 = u.a(type);
        if (cls2.isInterface()) {
            return modifiers;
        }
        if (cls2.isEnum()) {
            return modifiers;
        }
        if (!cls2.isAnnotationPresent(c.a)) {
            return modifiers;
        }
        if (b.i(cls2)) {
            return modifiers;
        }
        try {
            f fVar = b.d(rVar32, type2, cls2);
        } catch (RuntimeException e) {
            Throwable th = e;
            Throwable e2 = th.getCause();
            e2 = e2 instanceof ClassNotFoundException;
        }
        if (c.a != null) {
            return fVar;
        }
        if (!cls2.isLocalClass() ^ hasNext) {
            StringBuilder stringBuilder = new StringBuilder();
            String str12 = "Cannot serialize local class or object expression ";
            String name4 = cls2.getName();
            str4 = str12 + name4;
            throw new IllegalArgumentException(str4.toString());
        } else {
            d dVar = a.e(cls2);
            if (!dVar.isAbstract() ^ hasNext) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str13 = "Cannot serialize abstract class ";
                String name5 = cls2.getName();
                str5 = str13 + name5;
                throw new IllegalArgumentException(str5.toString());
            } else {
                if (dVar.k() ^ hasNext == 0) {
                    StringBuilder stringBuilder8 = new StringBuilder();
                    String str21 = "Cannot serialize inner class ";
                    String name9 = cls2.getName();
                    str11 = str21 + name9;
                    throw new IllegalArgumentException(str11.toString());
                } else {
                    modifiers = 0;
                    th = dVar.p() == null ? hasNext : modifiers;
                    if (modifiers == 0) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String str14 = "Cannot serialize object declaration ";
                        String name6 = cls2.getName();
                        str6 = str14 + name6;
                        throw new IllegalArgumentException(str6.toString());
                    } else {
                        if (dVar.m() ^ hasNext == 0) {
                            StringBuilder stringBuilder7 = new StringBuilder();
                            String str19 = "Cannot reflectively serialize sealed class ";
                            String name8 = cls2.getName();
                            String str20 = ". Please register an adapter.";
                            str10 = str19 + name8 + str20;
                            throw new IllegalArgumentException(str10.toString());
                        } else {
                            kotlin.i0.g gVar = a.b(dVar);
                            if (gVar != null) {
                                List parameters2 = gVar.getParameters();
                                final int i11 = 10;
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap(g.b(j0.d(p.r(parameters2, i11)), 16));
                                Iterator it6 = parameters2.iterator();
                                while (it6.hasNext()) {
                                    Object item3 = it6.next();
                                    linkedHashMap2.put((KParameter)item3.getName(), item3);
                                }
                                a.a(gVar, hasNext);
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                Iterator it = a.a(dVar).iterator();
                                name3 = "null cannot be cast to non-null type kotlin.Array<T>";
                                while (it.hasNext()) {
                                    Object item4 = it.next();
                                    name = linkedHashMap2.get(item4.getName());
                                    Field field = c.b(item4);
                                    if (Modifier.isTransient(modifiers)) {
                                    }
                                }
                                ArrayList arrayList = new ArrayList();
                                Iterator it2 = gVar.getParameters().iterator();
                                while (it2.hasNext()) {
                                    Object rVar32 = it2.next();
                                    Object remove = g0.c(linkedHashMap).remove(rVar32.getName());
                                    if (modifiers == 0) {
                                        StringBuilder stringBuilder6 = new StringBuilder();
                                        String str18 = "No property for required constructor ";
                                        str9 = str18 + rVar32;
                                        throw new IllegalArgumentException(str9.toString());
                                    }
                                }
                                index = arrayList.size();
                                Iterator it3 = linkedHashMap.entrySet().iterator();
                                while (it3.hasNext()) {
                                    name = null;
                                    name = null;
                                    fVar2 = null;
                                    nVar = null;
                                    index = index + 1;
                                    int i2 = 31;
                                    Object obj2 = null;
                                    arrayList.add(a.a.b((a.a)(Map.Entry)it3.next().getValue(), name, name, fVar2, nVar, null, index, i2, obj2));
                                }
                                List list2 = p.U(arrayList);
                                ArrayList arrayList2 = new ArrayList(p.r(list2, i11));
                                Iterator it5 = list2.iterator();
                                while (it5.hasNext()) {
                                    arrayList2.add((a.a)it5.next().f());
                                }
                                Object[] array = arrayList2.toArray(new String[modifiers]);
                                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                                i.a aVar2 = i.a.a((String[])Arrays.copyOf(array, array.length));
                                n.e(aVar2, "options");
                                return new a(gVar, arrayList, list2, aVar2).f();
                            }
                            return modifiers;
                        }
                    }
                }
            }
        }
    }
}
