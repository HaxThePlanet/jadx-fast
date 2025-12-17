package com.google.android.play.core.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
final class l0 implements com.google.android.play.core.internal.z {
    public static void c(java.lang.ClassLoader classLoader, Set<File> set2, com.google.android.play.core.internal.k0 k03) {
        int i;
        boolean empty;
        File parentFile;
        Class<com.google.android.play.core.splitinstall.n0> obj = n0.class;
        if (set2.isEmpty()) {
        }
        HashSet hashSet = new HashSet();
        Iterator obj5 = set2.iterator();
        for (File next2 : obj5) {
            hashSet.add(next2.getParentFile());
        }
        Object obj4 = g0.c(classLoader);
        obj5 = w0.b(obj4, "nativeLibraryDirectories", List.class);
        ArrayList arrayList = new ArrayList((Collection)obj5.a());
        hashSet.removeAll(arrayList);
        arrayList.addAll(hashSet);
        obj5.c(arrayList);
        obj5 = new ArrayList();
        ArrayList arrayList2 = new ArrayList(hashSet);
        synchronized (obj) {
            obj4 = g0.c(classLoader);
            obj5 = w0.b(obj4, "nativeLibraryDirectories", List.class);
            arrayList = new ArrayList((Collection)obj5.a());
            hashSet.removeAll(arrayList);
            arrayList.addAll(hashSet);
            obj5.c(arrayList);
            obj5 = new ArrayList();
            arrayList2 = new ArrayList(hashSet);
        }
        obj4 = new zzbt("Error in makePathElements");
        i = 0;
        while (i < obj5.size()) {
            empty = obj5.get(i);
            i++;
        }
        throw obj4;
    }

    public static boolean d(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4, String string5) {
        i0 i0Var = new i0();
        d0 d0Var = new d0();
        return g0.e(classLoader, file2, file3, z4, i0Var, "zip", d0Var);
    }

    @Override // com.google.android.play.core.internal.z
    public final boolean a(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        return l0.d(classLoader, file2, file3, z4, "zip");
    }

    public final void b(java.lang.ClassLoader classLoader, Set<File> set2) {
        j0 j0Var = new j0();
        l0.c(classLoader, set2, j0Var);
    }
}
