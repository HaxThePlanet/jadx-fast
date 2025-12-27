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

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public final class n {

    private static final Pattern b;
    private final f a;
    private static void e(t tVar, k kVar) throws java.util.zip.ZipException, HashMap {
        int i;
        int i2;
        boolean found;
        Object[] arr;
        boolean hasNext;
        Object[] arr2;
        try {
            final ZipFile zipFile = new ZipFile(tVar.a());
        } catch (java.io.IOException ioException) {
        }
        try {
            HashMap hashMap = new HashMap();
            Enumeration entries = zipFile.entries();
        } catch (java.io.IOException ioException) {
        }
        i = 2;
        str = "SplitCompat";
        i2 = 0;
        int i3 = 1;
        if (entries.hasMoreElements()) {
            try {
                Object nextElement = entries.nextElement();
                Matcher matcher = n.b.matcher(nextElement.getName());
                if (matcher.matches()) {
                    String group2 = matcher.group(i3);
                    Object group = matcher.group(i);
                    arr = new Object[3];
                    Log.d(str, String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", new Object[] { ioException.b(), group, group2 }));
                    if ((Set)hashMap.get(group2) == null) {
                        hashMap.put(group2, new HashSet());
                    }
                    i.add(new m(nextElement, group));
                }
                HashMap hashMap2 = new HashMap();
                String[] sUPPORTED_ABIS2 = Build.SUPPORTED_ABIS;
                for (String str3 : sUPPORTED_ABIS2) {
                    if (hashMap.containsKey(str3)) {
                        Object[] arr3 = new Object[i3];
                        formatted = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI";
                        Log.d(str, String.format(formatted, new Object[] { str3 }));
                        Iterator it = (Set)hashMap.get(str3).iterator();
                        while (it.hasNext()) {
                            Object item = it.next();
                        }
                    } else {
                        arr = new Object[i3];
                        Log.d(str, String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", new Object[] { str3 }));
                    }
                }
                kVar.a(zipFile, new HashSet(hashMap2.values()));
                zipFile.close();
            } catch (java.io.IOException ioException) {
            }
        }
    }

    private final void f(t tVar, Set<m> set, l lVar) {
        boolean exists;
        boolean z = false;
        long length;
        long size;
        final Iterator it = set.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            File file = this.a.c(tVar.b(), item.a);
            int i = 0;
            lVar.a(item, file, z);
        }
    }

    final Set<File> b(t tVar) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        n.e(tVar, new h(this, tVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }

    final Set<File> c() {
        Iterator it;
        boolean hasNext2;
        boolean contains;
        String str;
        String absolutePath;
        final String str2 = "SplitCompat";
        Log.d(str2, "NativeLibraryExtractor: synchronizing native libraries");
        Set set = this.a.j();
        Iterator it3 = this.a.h().iterator();
        f.c.a.f.a.d.f fVar = null;
        Object[] arr = 1;
        while (it3.hasNext()) {
            Object item = it3.next();
            it = set.iterator();
            while (it.hasNext()) {
                if ((t)it.next().b().equals(item)) {
                    break loop_3;
                }
            }
            arr = new Object[arr];
            arr[fVar] = item;
            Log.i(str2, String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", arr));
            this.a.n(item);
            fVar = null;
            arr = 1;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            Object item3 = it2.next();
            Object hashSet2 = new HashSet();
            n.e(item3, new i(this, hashSet2, item3));
            Iterator it4 = this.a.i(item3.b()).iterator();
            while (it4.hasNext()) {
                String item2 = it4.next();
            }
            hashSet.addAll(hashSet2);
            item2 = it4.next();
        }
        return hashSet;
    }

    static {
        n.b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    }

    n(f fVar) {
        super();
        this.a = fVar;
    }
}
