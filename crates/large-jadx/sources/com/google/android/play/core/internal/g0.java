package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
final class g0 implements com.google.android.play.core.internal.z {
    static Object c(java.lang.ClassLoader classLoader) {
        return w0.b(classLoader, "pathList", Object.class).a();
    }

    static void d(java.lang.ClassLoader classLoader, Set<File> set2) {
        File parentFile;
        String string;
        String str;
        int length;
        if (set2.isEmpty()) {
        }
        HashSet hashSet = new HashSet();
        Iterator obj6 = set2.iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            String valueOf = String.valueOf((File)next2.getParentFile().getAbsolutePath());
            String str4 = "Adding native library parent directory: ";
            if (valueOf.length() != 0) {
            } else {
            }
            string = new String(str4);
            Log.d("Splitcompat", string);
            hashSet.add(next2.getParentFile());
            string = str4.concat(valueOf);
        }
        com.google.android.play.core.internal.u0 obj5 = w0.a(g0.c(classLoader), "nativeLibraryDirectories", File.class);
        hashSet.removeAll(Arrays.asList((File[])obj5.a()));
        obj6 = n0.class;
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append("Adding directories ");
        stringBuilder.append(hashSet.size());
        Log.d("Splitcompat", stringBuilder.toString());
        obj5.e(hashSet);
        return;
        synchronized (obj6) {
            obj5 = w0.a(g0.c(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[])obj5.a()));
            obj6 = n0.class;
            stringBuilder = new StringBuilder(30);
            stringBuilder.append("Adding directories ");
            stringBuilder.append(hashSet.size());
            Log.d("Splitcompat", stringBuilder.toString());
            obj5.e(hashSet);
        }
    }

    static boolean e(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4, com.google.android.play.core.internal.f0 f05, String string6, com.google.android.play.core.internal.e0 e07) {
        int i;
        Object obj;
        Class<File> obj2;
        String obj6;
        boolean obj9;
        Object obj10;
        ArrayList arrayList = new ArrayList();
        obj6 = g0.c(classLoader);
        com.google.android.play.core.internal.u0 u0Var = w0.a(obj6, "dexElements", Object.class);
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = Arrays.asList((Object[])u0Var.a()).iterator();
        for (Object next2 : iterator) {
            arrayList2.add((File)w0.b(next2, string6, File.class).a());
        }
        int i2 = 1;
        if (arrayList2.contains(file3) != null) {
            return i2;
        }
        String obj11 = "SplitCompat";
        if (!z4 && e07.a(obj6, file3, file2) == null) {
            if (e07.a(obj6, file3, file2) == null) {
                obj6 = String.valueOf(file3.getPath());
                String obj7 = "Should be optimized ";
                if (obj6.length() != 0) {
                    obj6 = obj7.concat(obj6);
                } else {
                    obj6 = new String(obj7);
                }
                Log.w(obj11, obj6);
                return 0;
            }
        }
        obj9 = new ArrayList(Collections.singleton(file3));
        u0Var.d(Arrays.asList(f05.a(obj6, obj9, file2, arrayList)));
        if (!arrayList.isEmpty()) {
            String obj8 = "DexPathList.makeDexElement failed";
            obj7 = new zzbt(obj8);
            while (i < arrayList.size()) {
                Log.e(obj11, obj8, (IOException)arrayList.get(i));
                i++;
            }
            w0.a(obj6, "dexElementsSuppressedExceptions", IOException.class).d(arrayList);
            throw obj7;
        }
        return i2;
    }

    @Override // com.google.android.play.core.internal.z
    public final boolean a(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        c0 c0Var = new c0();
        d0 d0Var = new d0();
        return g0.e(classLoader, file2, file3, z4, c0Var, "zip", d0Var);
    }

    public final void b(java.lang.ClassLoader classLoader, Set<File> set2) {
        g0.d(classLoader, set2);
    }
}
