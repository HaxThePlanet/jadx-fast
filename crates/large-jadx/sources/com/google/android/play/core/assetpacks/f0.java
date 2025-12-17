package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class f0 {

    private static final h c;
    private final Context a;
    private final com.google.android.play.core.assetpacks.w2 b;
    static {
        h hVar = new h("AssetPackStorage");
        f0.c = hVar;
        TimeUnit dAYS = TimeUnit.DAYS;
        dAYS.toMillis(14);
        dAYS.toMillis(28);
    }

    f0(Context context, com.google.android.play.core.assetpacks.w2 w22) {
        super();
        this.a = context;
        this.b = w22;
    }

    private static long g(File file, boolean z2) {
        int i;
        int str;
        int i2;
        String valueOf;
        boolean equals;
        String str2;
        File[] obj8;
        int obj9;
        final int i3 = -1;
        if (file.exists() == null) {
            return i3;
        }
        ArrayList arrayList = new ArrayList();
        i = 0;
        if (z2 != null && obj9.length > 1) {
            if (obj9.length > 1) {
                f0.c.e("Multiple pack versions found, using highest version code.", new Object[i]);
            }
        }
        obj8 = file.listFiles();
        i2 = i;
        while (i2 < obj8.length) {
            valueOf = obj8[i2];
            if (!valueOf.getName().equals("stale.tmp")) {
            }
            i2++;
            arrayList.add(Long.valueOf(valueOf.getName()));
        }
        if (arrayList.isEmpty()) {
            return i3;
        }
        Collections.sort(arrayList);
        return (Long)arrayList.get(obj8--).longValue();
    }

    private final File h(String string) {
        File file = new File(k(), string);
        return file;
    }

    private final File i(String string, int i2, long l3) {
        File file = new File(w(string, i2, l3), "merge.tmp");
        return file;
    }

    private final File j(String string, int i2, long l3) {
        File file3 = new File(l(), string);
        File file2 = new File(file3, String.valueOf(i2));
        File file = new File(file2, String.valueOf(l3));
        return file;
    }

    private final File k() {
        File file = new File(this.a.getFilesDir(), "assetpacks");
        return file;
    }

    private final File l() {
        File file = new File(k(), "_tmp");
        return file;
    }

    private final List<File> m() {
        int i2;
        File[] listFiles2;
        boolean listFiles;
        int length;
        int i;
        File file;
        boolean equals;
        String canonicalPath;
        ArrayList arrayList = new ArrayList();
        if (k().exists() && k().listFiles() == null) {
            if (k().listFiles() == null) {
            }
            listFiles2 = k().listFiles();
            i = i2;
            while (i < listFiles2.length) {
                file = listFiles2[i];
                if (file.getCanonicalPath().equals(l().getCanonicalPath()) == null) {
                }
                i++;
                arrayList.add(file);
            }
            return arrayList;
        }
        return arrayList;
    }

    private static void n(File file) {
        File[] listFiles;
        long l;
        int length;
        File file2;
        boolean equals;
        String valueOf;
        File obj7;
        if (file.listFiles() != null) {
            if (listFiles2.length <= 1) {
            } else {
                obj7 = file.listFiles();
                while (listFiles < obj7.length) {
                    file2 = obj7[listFiles];
                    if (file2.getName().equals(String.valueOf(f0.g(file, false))) == null && file2.getName().equals("stale.tmp") == null) {
                    }
                    listFiles++;
                    if (file2.getName().equals("stale.tmp") == null) {
                    }
                    f0.o(file2);
                }
            }
        }
    }

    private static boolean o(File file) {
        int i;
        int length;
        int i2;
        boolean z;
        final File[] listFiles = file.listFiles();
        final int i3 = 0;
        i = 1;
        if (listFiles != null) {
            i2 = i3;
            while (i2 < listFiles.length) {
                i &= z;
                i2++;
            }
        }
        if (file.delete() == null) {
            return i3;
        }
        return i;
    }

    final File A(String string, int i2, long l3, String string4) {
        File file = new File(B(string, i2, l3, string4), "checkpoint.dat");
        return file;
    }

    final File B(String string, int i2, long l3, String string4) {
        File file = new File(y(string, i2, l3), obj6);
        return file;
    }

    final File C(String string, int i2, long l3, String string4) {
        File file3 = new File(j(string, i2, l3), "_slices");
        File file2 = new File(file3, "_unverified");
        File file = new File(file2, obj8);
        return file;
    }

    final File D(String string, int i2, long l3, String string4) {
        File file3 = new File(j(string, i2, l3), "_slices");
        File file2 = new File(file3, "_verified");
        File file = new File(file2, obj8);
        return file;
    }

    final String E(String string) {
        File length;
        File file = new File(k(), string);
        final int i = 0;
        final int i2 = 0;
        final int i3 = 1;
        if (file.exists() == null) {
            Object[] arr4 = new Object[i3];
            arr4[i2] = string;
            f0.c.a("Pack not found with pack name: %s", arr4);
            return i;
        }
        length = new File(file, String.valueOf(this.b.a()));
        int i5 = 2;
        if (!length.exists()) {
            Object[] arr = new Object[i5];
            arr[i2] = string;
            arr[i3] = Integer.valueOf(this.b.a());
            f0.c.a("Pack not found with pack name: %s app version: %s", arr);
            return i;
        }
        File[] listFiles = length.listFiles();
        if (listFiles != null) {
            length = listFiles.length;
            if (length == 0) {
            } else {
                if (length > i3) {
                    Object[] arr3 = new Object[i5];
                    arr3[i2] = string;
                    arr3[i3] = Integer.valueOf(this.b.a());
                    f0.c.b("Multiple pack versions found for pack name: %s app version: %s", arr3);
                    return i;
                }
            }
            return listFiles[i2].getCanonicalPath();
        }
        Object[] arr2 = new Object[i5];
        arr2[i2] = string;
        arr2[i3] = Integer.valueOf(this.b.a());
        f0.c.a("No pack version found for pack name: %s app version: %s", arr2);
        return i;
    }

    final Map<String, Long> F() {
        String name;
        boolean valueOf;
        long l;
        File file;
        HashMap hashMap = new HashMap();
        Iterator iterator = m().iterator();
        while (iterator.hasNext()) {
            name = (File)iterator.next().getName();
            int i2 = 1;
            int i = (int)l2;
            file = t(name, i);
            l = f0.g(file, i2);
            if (u(name, i, l).exists()) {
            }
            hashMap.put(name, Long.valueOf(l));
        }
        return hashMap;
    }

    final Map<String, Long> G() {
        Object next;
        Long valueOf;
        HashMap hashMap = new HashMap();
        Iterator iterator = H().keySet().iterator();
        for (String next : iterator) {
            hashMap.put(next, Long.valueOf(r(next)));
        }
        return hashMap;
    }

    final Map<String, com.google.android.play.core.assetpacks.a> H() {
        Iterator iterator;
        Object next;
        boolean next2;
        int arr;
        int i;
        HashMap hashMap = new HashMap();
        iterator = m().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            arr = s((File)next.getName());
            if (arr != null) {
            }
            hashMap.put(next.getName(), arr);
        }
        try {
            return hashMap;
        }
    }

    final void I() {
        Object listFiles;
        int listFiles2;
        h length;
        long str;
        long arr;
        String file;
        File file2;
        Iterator iterator = m().iterator();
        while (iterator.hasNext()) {
            listFiles = iterator.next();
            f0.n(listFiles);
            str = f0.g(listFiles, false);
            if ((File)listFiles.listFiles() != null && Long.compare(l, str) != 0) {
            }
            f0.n(listFiles);
            str = f0.g(listFiles, false);
            if (Long.compare(l, str) != 0) {
            }
            listFiles = listFiles.listFiles();
            while (listFiles2 < listFiles.length) {
                f0.n(listFiles[listFiles2]);
                listFiles2++;
            }
            f0.n(listFiles[listFiles2]);
            listFiles2++;
            file2 = new File(listFiles, String.valueOf(str));
            file = new File(file2, "stale.tmp");
            file.createNewFile();
            f0.c.b("Could not write staleness marker.", new Object[obj2]);
        }
    }

    final void J() {
        f0.o(k());
    }

    final void a(String string, int i2, long l3, int i4) {
        File obj1 = i(string, i2, l3);
        Properties obj2 = new Properties();
        obj2.put("numberOfMerges", String.valueOf(obj5));
        obj1.getParentFile().mkdirs();
        obj1.createNewFile();
        FileOutputStream obj3 = new FileOutputStream(obj1);
        obj2.store(obj3, 0);
        obj3.close();
    }

    final void b(String string, int i2, long l3) {
        int i;
        File listFiles;
        boolean equals2;
        String valueOf;
        File file;
        boolean equals;
        String valueOf2;
        File obj10 = h(string);
        if (!obj10.exists()) {
        }
        obj10 = obj10.listFiles();
        final int i3 = 0;
        i = i3;
        while (i < obj10.length) {
            listFiles = obj10[i];
            if (listFiles.getName().equals(String.valueOf(i2)) == null && listFiles.getName().equals("stale.tmp") == null) {
            } else {
            }
            if (listFiles.getName().equals(String.valueOf(i2)) != null) {
            }
            i++;
            listFiles = listFiles.listFiles();
            valueOf = i3;
            while (valueOf < listFiles.length) {
                file = listFiles[valueOf];
                if (file.getName().equals(String.valueOf(l3)) == null) {
                }
                valueOf++;
                f0.o(file);
            }
            file = listFiles[valueOf];
            if (file.getName().equals(String.valueOf(l3)) == null) {
            }
            valueOf++;
            f0.o(file);
            if (listFiles.getName().equals("stale.tmp") == null) {
            } else {
            }
            f0.o(listFiles);
        }
    }

    final void c(List<String> list) {
        Object next;
        boolean contains;
        long l;
        Iterator iterator = m().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (list.contains((File)next.getName()) == null && Long.compare(l2, l) != 0) {
            }
            if (Long.compare(l2, l) != 0) {
            }
            f0.o(next);
        }
    }

    final boolean d(String string, int i2, long l3) {
        if (!j(string, i2, l3).exists()) {
            return 1;
        }
        return f0.o(j(string, i2, l3));
    }

    final boolean e(String string, int i2, long l3) {
        if (!u(string, i2, l3).exists()) {
            return 1;
        }
        return f0.o(u(string, i2, l3));
    }

    final boolean f(String string) {
        if (E(string) != null) {
            try {
                return 1;
                return 0;
            }
        }
    }

    final int p(String string) {
        return (int)l;
    }

    final int q(String string, int i2, long l3) {
        File obj1 = i(string, i2, l3);
        if (!obj1.exists()) {
            return 0;
        }
        Properties obj2 = new Properties();
        FileInputStream obj3 = new FileInputStream(obj1);
        obj2.load(obj3);
        obj3.close();
        obj1 = "numberOfMerges";
        if (obj2.getProperty(obj1) == null) {
        } else {
            return Integer.parseInt(obj2.getProperty(obj1));
        }
        obj1 = new g1("Merge checkpoint file corrupt.");
        throw obj1;
    }

    final long r(String string) {
        final int i2 = 1;
        return f0.g(t(string, (int)l2), i2);
    }

    final com.google.android.play.core.assetpacks.a s(String string) {
        String obj5 = E(string);
        int i = 0;
        if (obj5 == null) {
            return i;
        }
        File file = new File(obj5, "assets");
        if (file.isDirectory() == null) {
            Object[] arr = new Object[1];
            f0.c.b("Failed to find assets directory: %s", file);
            return i;
        }
        return a.d(obj5, file.getCanonicalPath());
    }

    final File t(String string, int i2) {
        File file = new File(h(string), String.valueOf(i2));
        return file;
    }

    final File u(String string, int i2, long l3) {
        File file = new File(t(string, i2), String.valueOf(l3));
        return file;
    }

    final File v(String string, int i2, long l3) {
        File file = new File(u(string, i2, l3), "_metadata");
        return file;
    }

    final File w(String string, int i2, long l3) {
        File file = new File(j(string, i2, l3), "_packs");
        return file;
    }

    final File x(String string, int i2, long l3) {
        File file = new File(v(string, i2, l3), "properties.dat");
        return file;
    }

    final File y(String string, int i2, long l3) {
        File file2 = new File(j(string, i2, l3), "_slices");
        File file = new File(file2, "_metadata");
        return file;
    }

    final File z(String string, int i2, long l3, String string4) {
        File file = new File(B(string, i2, l3, string4), "checkpoint_ext.dat");
        return file;
    }
}
