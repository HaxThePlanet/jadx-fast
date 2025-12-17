package f.c.a.f.a.d;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public final class n {

    private static final Pattern b;
    private final f.c.a.f.a.d.f a;
    static {
        n.b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    }

    n(f.c.a.f.a.d.f f) {
        super();
        this.a = f;
    }

    static Set a(f.c.a.f.a.d.n n, Set set2, f.c.a.f.a.d.t t3, ZipFile zipFile4) {
        HashSet hashSet = new HashSet();
        j jVar = new j(n, hashSet, t3, zipFile4);
        n.f(t3, set2, jVar);
        return hashSet;
    }

    static void d(f.c.a.f.a.d.n n, f.c.a.f.a.d.t t2, Set set3, f.c.a.f.a.d.l l4) {
        n.f(t2, set3, l4);
    }

    private static void e(f.c.a.f.a.d.t t, f.c.a.f.a.d.k k2) {
        Object nextElement;
        int hashSet;
        Object mVar;
        int i2;
        int i3;
        Object matcher;
        int i4;
        boolean matches;
        Object[] iterator;
        boolean next;
        String format;
        Object[] arr;
        try {
            ZipFile zipFile = new ZipFile(t.a());
            HashMap hashMap = new HashMap();
            Enumeration entries = zipFile.entries();
            hashSet = 2;
            mVar = "SplitCompat";
            i2 = 0;
            i3 = 1;
            while (entries.hasMoreElements()) {
                nextElement = entries.nextElement();
                matcher = n.b.matcher((ZipEntry)nextElement.getName());
                matches = matcher.group(i3);
                matcher = matcher.group(hashSet);
                iterator = new Object[3];
                iterator[i2] = t.b();
                iterator[i3] = matcher;
                iterator[hashSet] = matches;
                Log.d(mVar, String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", iterator));
                if (matcher.matches() && (Set)hashMap.get(matches) == null) {
                }
                hashSet = 2;
                mVar = "SplitCompat";
                i2 = 0;
                i3 = 1;
                matches = matcher.group(i3);
                matcher = matcher.group(hashSet);
                iterator = new Object[3];
                iterator[i2] = obj13;
                iterator[i3] = matcher;
                iterator[hashSet] = matches;
                Log.d(mVar, String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", iterator));
                if ((Set)hashMap.get(matches) == null) {
                }
                mVar = new m(nextElement, matcher);
                hashSet.add(mVar);
                hashSet = new HashSet();
                hashMap.put(matches, hashSet);
            }
            nextElement = entries.nextElement();
            matcher = n.b.matcher((ZipEntry)nextElement.getName());
            matches = matcher.group(i3);
            matcher = matcher.group(hashSet);
            iterator = new Object[3];
            iterator[i2] = obj13;
            iterator[i3] = matcher;
            iterator[hashSet] = matches;
            Log.d(mVar, String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", iterator));
            if (matcher.matches() && (Set)hashMap.get(matches) == null) {
            }
            matches = matcher.group(i3);
            matcher = matcher.group(hashSet);
            iterator = new Object[3];
            iterator[i2] = obj13;
            iterator[i3] = matcher;
            iterator[hashSet] = matches;
            Log.d(mVar, String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", iterator));
            if ((Set)hashMap.get(matches) == null) {
            }
            hashSet = new HashSet();
            hashMap.put(matches, hashSet);
            mVar = new m(nextElement, matcher);
            hashSet.add(mVar);
            HashMap obj13 = new HashMap();
            String[] sUPPORTED_ABIS = Build.SUPPORTED_ABIS;
            i4 = i2;
            matches = sUPPORTED_ABIS[i4];
        } catch (java.io.IOException ioException) {
        }
        HashSet hashSet2 = new HashSet(obj13.values());
        k2.a(zipFile, hashSet2);
        zipFile.close();
    }

    private final void f(f.c.a.f.a.d.t t, Set<f.c.a.f.a.d.m> set2, f.c.a.f.a.d.l l3) {
        Object next;
        File file;
        boolean exists;
        int i;
        long length;
        long size;
        final Iterator obj10 = set2.iterator();
        while (obj10.hasNext()) {
            next = obj10.next();
            file = this.a.c(t.b(), next.a);
            i = 0;
            if (file.exists() != null && Long.compare(length, size) == 0 && f.p(file) != null) {
            }
            l3.a((m)next, file, i);
            if (Long.compare(length, size) == 0) {
            }
            if (f.p(file) != null) {
            }
            i = 1;
        }
    }

    final Set<File> b(f.c.a.f.a.d.t t) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(1);
        HashSet hashSet = new HashSet();
        h hVar = new h(this, t, hashSet, atomicBoolean);
        n.e(t, hVar);
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return 0;
    }

    final Set<File> c() {
        Object next2;
        boolean next;
        f.c.a.f.a.d.f fVar;
        Object[] arr;
        Iterator hashSet;
        boolean iterator;
        boolean next3;
        String next4;
        boolean contains;
        String str;
        String absolutePath;
        final String str2 = "SplitCompat";
        Log.d(str2, "NativeLibraryExtractor: synchronizing native libraries");
        Set set = this.a.j();
        Iterator iterator3 = this.a.h().iterator();
        fVar = 0;
        arr = 1;
        for (String next2 : iterator3) {
            hashSet = set.iterator();
            for (t next6 : hashSet) {
            }
            arr = new Object[arr];
            arr[fVar] = next2;
            Log.i(str2, String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", arr));
            this.a.n(next2);
            fVar = 0;
            arr = 1;
            if ((t)hashSet.next().b().equals(next2)) {
            } else {
            }
        }
        HashSet hashSet2 = new HashSet();
        Iterator iterator2 = set.iterator();
        for (t next : iterator2) {
            hashSet = new HashSet();
            i iVar = new i(this, hashSet, next);
            n.e(next, iVar);
            iterator = this.a.i(next.b()).iterator();
            while (iterator.hasNext()) {
                next4 = iterator.next();
                if (hashSet.contains((File)next4) == null) {
                }
                Object[] arr2 = new Object[3];
                arr2[fVar] = next4.getAbsolutePath();
                arr2[arr] = next.b();
                arr2[2] = next.a().getAbsolutePath();
                Log.i(str2, String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", arr2));
                this.a.o(next4);
            }
            hashSet2.addAll(hashSet);
            next4 = iterator.next();
            if (hashSet.contains((File)next4) == null) {
            }
            arr2 = new Object[3];
            arr2[fVar] = next4.getAbsolutePath();
            arr2[arr] = next.b();
            arr2[2] = next.a().getAbsolutePath();
            Log.i(str2, String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", arr2));
            this.a.o(next4);
        }
        return hashSet2;
    }
}
