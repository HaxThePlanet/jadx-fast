package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.l1;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
final class i0 extends l1 {

    private final File a;
    private final File b;
    private final NavigableMap<Long, File> c;
    i0(File file, File file2) {
        int i;
        long length;
        Long valueOf;
        File obj6;
        super();
        this.a = file;
        this.b = file2;
        TreeMap treeMap = new TreeMap();
        this.c = treeMap;
        List list = i3.a(file, file2);
        boolean empty = list.isEmpty();
        if (empty) {
        } else {
            Iterator obj5 = list.iterator();
            i = 0;
            for (File obj6 : obj5) {
                this.c.put(Long.valueOf(i), obj6);
                i += length;
            }
        }
        Object[] arr = new Object[2];
        g1 g1Var = new g1(String.format("Virtualized slice archive empty for %s, %s", file, file2));
        throw g1Var;
    }

    private final InputStream f(long l, Long long2) {
        FileInputStream fileInputStream = new FileInputStream((File)this.c.get(obj8));
        if (Long.compare(skip, obj6) != 0) {
        } else {
            return fileInputStream;
        }
        Object[] obj7 = new Object[1];
        g1 obj6 = new g1(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", obj8));
        throw obj6;
    }

    @Override // com.google.android.play.core.internal.l1
    public final long a() {
        Map.Entry lastEntry = this.c.lastEntry();
        return longValue += length;
    }

    @Override // com.google.android.play.core.internal.l1
    protected final InputStream c(long l, long l2) {
        int cmp;
        Object enumeration;
        boolean k2Var;
        cmp = 0;
        int i2 = 1;
        int i3 = 2;
        final int i5 = 0;
        if (Long.compare(l, cmp) < 0) {
        } else {
            if (Long.compare(obj11, cmp) < 0) {
            } else {
                int i = l + obj11;
                if (Long.compare(i, l3) > 0) {
                } else {
                    Object floorKey2 = this.c.floorKey(Long.valueOf(l));
                    Object floorKey = this.c.floorKey(Long.valueOf(i));
                    if ((Long)floorKey2.equals((Long)floorKey)) {
                        h0 h0Var = new h0(f(l, l2), obj11, obj12);
                        return h0Var;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(f(l, l2));
                    enumeration = this.c.subMap(floorKey2, i5, floorKey, i5).values();
                    if (!enumeration.isEmpty()) {
                        k2Var = new k2(Collections.enumeration(enumeration));
                        arrayList.add(k2Var);
                    }
                    FileInputStream fileInputStream = new FileInputStream((File)this.c.get(floorKey));
                    h0 h0Var2 = new h0(fileInputStream, obj11 -= i4, obj12);
                    arrayList.add(h0Var2);
                    SequenceInputStream obj9 = new SequenceInputStream(Collections.enumeration(arrayList));
                    return obj9;
                }
                Object[] obj10 = new Object[i3];
                obj10[i5] = Long.valueOf(a());
                obj10[i2] = Long.valueOf(i);
                obj9 = new g1(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", obj10));
                throw obj9;
            }
        }
        Object[] arr = new Object[i3];
        arr[i5] = Long.valueOf(l);
        arr[i2] = Long.valueOf(obj11);
        g1 g1Var = new g1(String.format("Invalid input parameters %s, %s", arr));
        throw g1Var;
    }

    @Override // com.google.android.play.core.internal.l1
    public final void close() {
    }
}
