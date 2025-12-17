package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class c2 {

    private static final h e;
    private final com.google.android.play.core.assetpacks.z1 a;
    private final com.google.android.play.core.assetpacks.f0 b;
    private final com.google.android.play.core.assetpacks.p0 c;
    private final c d;
    static {
        h hVar = new h("ExtractorTaskFinder");
        c2.e = hVar;
    }

    c2(com.google.android.play.core.assetpacks.z1 z1, com.google.android.play.core.assetpacks.f0 f02, com.google.android.play.core.assetpacks.p0 p03, c c4) {
        super();
        this.a = z1;
        this.b = f02;
        this.c = p03;
        this.d = c4;
    }

    private final boolean b(com.google.android.play.core.assetpacks.w1 w1, com.google.android.play.core.assetpacks.x1 x12) {
        com.google.android.play.core.assetpacks.v1 v1Var = w1.c;
        super(this.b, v1Var.a, w1.b, v1Var.b, obj5, x12.a);
        return g3Var2.m();
    }

    private static boolean c(com.google.android.play.core.assetpacks.x1 x1) {
        int i;
        int obj2 = x1.f;
        final int i2 = 1;
        if (obj2 != i2 && obj2 == 2) {
            if (obj2 == 2) {
            }
            return 0;
        }
        return i2;
    }

    final com.google.android.play.core.assetpacks.b2 a() {
        com.google.android.play.core.assetpacks.z1 z1Var2;
        boolean y2Var;
        List next4;
        ArrayList arrayList;
        boolean next2;
        com.google.android.play.core.assetpacks.z1 z1Var;
        Object[] format;
        int a1Var;
        int iterator;
        int i7;
        int i2;
        Object iterator2;
        Throwable next;
        long l2;
        int i10;
        Object[] iterator3;
        Object next3;
        int i3;
        int longValue;
        int i6;
        int i4;
        long l;
        int i;
        com.google.android.play.core.assetpacks.y2 y2Var2;
        com.google.android.play.core.assetpacks.b2 b2Var;
        int i9;
        String str;
        int i8;
        long l5;
        String str3;
        String str4;
        String str2;
        long l3;
        List list;
        int size;
        long l4;
        java.io.InputStream inputStream2;
        int i5;
        java.io.InputStream inputStream;
        final Object obj = this;
        obj.a.h();
        arrayList = new ArrayList();
        Iterator iterator4 = obj.a.f().values().iterator();
        while (iterator4.hasNext()) {
            format = iterator4.next();
            if (e0.b(v1Var10.d)) {
            }
            arrayList.add((w1)format);
        }
        a1Var = 0;
        if (arrayList.isEmpty()) {
            z1Var2 = obj.a;
            z1Var2.j();
            return a1Var;
        } else {
            iterator = 2;
            i7 = 1;
            i2 = 0;
            if (obj.d.a("assetOnlyUpdates")) {
                iterator2 = arrayList.iterator();
                for (w1 next : iterator2) {
                    iterator3 = obj.b.F().get(v1Var29.a);
                }
                y2Var = a1Var;
                if (y2Var == null) {
                    Iterator iterator5 = arrayList.iterator();
                    for (w1 iterator2 : iterator5) {
                        com.google.android.play.core.assetpacks.v1 v1Var26 = iterator2.c;
                    }
                    y2Var = a1Var;
                    if (y2Var == 0) {
                        Iterator iterator6 = arrayList.iterator();
                        next = 3;
                        while (iterator6.hasNext()) {
                            iterator2 = iterator6.next();
                            if (e0.b(v1Var24.d) == null) {
                                break;
                            } else {
                            }
                            next = 3;
                            iterator3 = v1Var25.f.iterator();
                            for (x1 next3 : iterator3) {
                                com.google.android.play.core.assetpacks.v1 v1Var33 = iterator2.c;
                                l = next3.a;
                                a1Var = 0;
                                iterator = 2;
                            }
                            next3 = iterator3.next();
                            v1Var33 = iterator2.c;
                            l = next3.a;
                            a1Var = 0;
                            iterator = 2;
                        }
                        y2Var = 0;
                        if (y2Var == null) {
                            Iterator iterator7 = arrayList.iterator();
                            while (iterator7.hasNext()) {
                                a1Var = iterator7.next();
                                if (e0.b(v1Var6.d) == 0) {
                                    break;
                                } else {
                                }
                                iterator = v1Var7.f.iterator();
                                for (x1 iterator2 : iterator) {
                                    com.google.android.play.core.assetpacks.v1 v1Var21 = a1Var.c;
                                }
                                iterator2 = iterator.next();
                                v1Var21 = a1Var.c;
                            }
                            y2Var = 0;
                            if (y2Var == null) {
                                Iterator iterator9 = arrayList.iterator();
                                while (iterator9.hasNext()) {
                                    iterator2 = next5;
                                    if (e0.b(v1Var.d) == null) {
                                        break;
                                    } else {
                                    }
                                    iterator3 = v1Var2.f.iterator();
                                    for (Object next6 : iterator3) {
                                        next3 = next6;
                                        com.google.android.play.core.assetpacks.v1 v1Var32 = iterator2.c;
                                        super(obj.b, v1Var32.a, iterator2.b, v1Var32.b, obj23, next3.a);
                                        next4 = g3Var.a();
                                        iterator3 = i;
                                        next = 3;
                                        next = th;
                                        Throwable th = c2.e;
                                        iterator3 = new Object[obj5];
                                        iterator3[obj6] = next;
                                        next = "Slice checkpoint corrupt, restarting extraction. %s";
                                        th.b(next, iterator3);
                                        th = obj6;
                                    }
                                    next3 = next6;
                                    v1Var32 = iterator2.c;
                                    super(obj.b, v1Var32.a, iterator2.b, v1Var32.b, obj23, next3.a);
                                    next4 = g3Var.a();
                                    iterator3 = i;
                                    next = 3;
                                    next = th;
                                    th = c2.e;
                                    iterator3 = new Object[obj5];
                                    iterator3[obj6] = next;
                                    next = "Slice checkpoint corrupt, restarting extraction. %s";
                                    th.b(next, iterator3);
                                    th = obj6;
                                }
                                a1Var = 0;
                                if (a1Var == 0) {
                                    Iterator iterator8 = arrayList.iterator();
                                    while (iterator8.hasNext()) {
                                        arrayList = iterator8.next();
                                        if (e0.b(v1Var4.d) == 0) {
                                            break;
                                        } else {
                                        }
                                        a1Var = v1Var5.f.iterator();
                                        for (x1 iterator : a1Var) {
                                        }
                                        iterator = a1Var.next();
                                    }
                                    y2Var = 0;
                                    if (y2Var != 0) {
                                        z1Var.j();
                                        return y2Var;
                                    }
                                    obj.a.j();
                                    return null;
                                } else {
                                    z1Var2 = obj.a;
                                }
                            }
                        }
                    }
                }
            } else {
            }
        }
        z1Var = obj.a;
    }
}
