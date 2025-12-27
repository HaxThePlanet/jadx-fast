package o.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: CombinedReducer.java */
/* loaded from: classes3.dex */
class c {

    private final Collection<n> a;
    private final Collection<String> b;

    static class a {

        private final Collection<String> a;
        private final o b;
        a(Collection<String> collection, o oVar) {
            super();
            this.a = collection;
            this.b = oVar;
        }

        o a() {
            return this.b;
        }

        Collection<String> b() {
            return this.a;
        }
    }
    c(Collection<n> collection) {
        super();
        a(collection);
        this.a = collection;
        this.b = d(collection);
    }

    private void a(Collection<n> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("No reducers provided");
        } else {
            if (collection.size() != 0) {
                HashSet hashSet = new HashSet();
                final Iterator it = collection.iterator();
                while (it.hasNext()) {
                    hashSet.add((n)it.next().getStateKey());
                }
                if (hashSet.size() != collection.size()) {
                    throw new IllegalArgumentException("Two or more reducers are tied to the same key");
                }
            }
        }
    }

    private Collection<String> d(Collection<n> collection) {
        final HashSet hashSet = new HashSet();
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            hashSet.add((n)it.next().getStateKey());
        }
        return hashSet;
    }

    Collection<String> b() {
        return this.b;
    }

    public o c() {
        final HashMap hashMap = new HashMap(this.a.size());
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            hashMap.put(item.getStateKey(), item.getInitialState());
        }
        return new o(hashMap);
    }

    public c.a e(o oVar, a<?> aVar) {
        final o.b.o oVar2 = new o();
        final HashSet hashSet = new HashSet();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String stateKey2 = oVar.c(item.getStateKey());
            Object reduced = item.reduce(stateKey2, aVar);
        }
        return new c.a(hashSet, oVar2);
    }
}
