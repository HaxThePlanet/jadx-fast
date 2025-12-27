package f.c.a.b.i.c0;

import android.util.SparseArray;
import f.c.a.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: PriorityMapping.java */
/* loaded from: classes.dex */
public final class a {

    private static SparseArray<d> a;
    private static HashMap<d, Integer> b;
    static {
        a.a = new SparseArray();
        HashMap hashMap = new HashMap();
        a.b = hashMap;
        hashMap.put(d.DEFAULT, null);
        a.b.put(d.VERY_LOW, 1);
        a.b.put(d.HIGHEST, 2);
        Iterator it = a.b.keySet().iterator();
        while (it.hasNext()) {
            d item = it.next();
            a.a.append((Integer)a.b.get(item).intValue(), item);
        }
    }

    public static int a(d dVar) {
        Object value = a.b.get(dVar);
        if (value == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "PriorityMapping is missing known Priority value ";
            dVar = str + dVar;
            throw new IllegalStateException(dVar);
        } else {
            return value.intValue();
        }
    }

    public static d b(int i) {
        Object obj = a.a.get(i);
        if (obj == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Unknown Priority for value ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            return obj;
        }
    }
}
