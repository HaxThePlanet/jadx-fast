package f.c.a.b.i.c0;

import android.util.SparseArray;
import f.c.a.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    private static SparseArray<d> a;
    private static HashMap<d, Integer> b;
    static {
        d hIGHEST;
        Integer valueOf;
        int intValue;
        SparseArray sparseArray = new SparseArray();
        a.a = sparseArray;
        HashMap hashMap = new HashMap();
        a.b = hashMap;
        hashMap.put(d.DEFAULT, 0);
        a.b.put(d.VERY_LOW, 1);
        a.b.put(d.HIGHEST, 2);
        Iterator iterator = a.b.keySet().iterator();
        for (d hIGHEST : iterator) {
            a.a.append((Integer)a.b.get(hIGHEST).intValue(), hIGHEST);
        }
    }

    public static int a(d d) {
        Object obj = a.b.get(d);
        if ((Integer)obj == null) {
        } else {
            return (Integer)obj.intValue();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PriorityMapping is missing known Priority value ");
        stringBuilder.append(d);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public static d b(int i) {
        Object obj = a.a.get(i);
        if ((d)obj == null) {
        } else {
            return (d)obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown Priority for value ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
