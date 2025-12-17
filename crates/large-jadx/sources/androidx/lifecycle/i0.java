package androidx.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class i0 {

    private final HashMap<String, androidx.lifecycle.e0> a;
    public i0() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public final void a() {
        Object next;
        Iterator iterator = this.a.values().iterator();
        for (e0 next : iterator) {
            next.clear();
        }
        this.a.clear();
    }

    final androidx.lifecycle.e0 b(String string) {
        return (e0)this.a.get(string);
    }

    Set<String> c() {
        HashSet hashSet = new HashSet(this.a.keySet());
        return hashSet;
    }

    final void d(String string, androidx.lifecycle.e0 e02) {
        final Object obj2 = this.a.put(string, e02);
        if ((e0)obj2 != null) {
            (e0)obj2.onCleared();
        }
    }
}
