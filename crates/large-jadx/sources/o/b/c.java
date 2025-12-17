package o.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
class c {

    private final Collection<o.b.n> a;
    private final Collection<String> b;

    static class a {

        private final Collection<String> a;
        private final o.b.o b;
        a(Collection<String> collection, o.b.o o2) {
            super();
            this.a = collection;
            this.b = o2;
        }

        o.b.o a() {
            return this.b;
        }

        Collection<String> b() {
            return this.a;
        }
    }
    c(Collection<o.b.n> collection) {
        super();
        a(collection);
        this.a = collection;
        this.b = d(collection);
    }

    private void a(Collection<o.b.n> collection) {
        int size;
        String stateKey;
        if (collection == null) {
        } else {
            if (collection.size() == 0) {
            } else {
                HashSet hashSet = new HashSet();
                final Iterator iterator = collection.iterator();
                for (n next2 : iterator) {
                    hashSet.add(next2.getStateKey());
                }
                if (hashSet.size() != collection.size()) {
                } else {
                }
                IllegalArgumentException obj4 = new IllegalArgumentException("Two or more reducers are tied to the same key");
                throw obj4;
            }
        }
        obj4 = new IllegalArgumentException("No reducers provided");
        throw obj4;
    }

    private Collection<String> d(Collection<o.b.n> collection) {
        String stateKey;
        HashSet hashSet = new HashSet();
        final Iterator obj3 = collection.iterator();
        for (n next2 : obj3) {
            hashSet.add(next2.getStateKey());
        }
        return hashSet;
    }

    Collection<String> b() {
        return this.b;
    }

    public o.b.o c() {
        String stateKey;
        Object initialState;
        HashMap hashMap = new HashMap(this.a.size());
        Iterator iterator = this.a.iterator();
        for (n next2 : iterator) {
            hashMap.put(next2.getStateKey(), next2.getInitialState());
        }
        o oVar = new o(hashMap);
        return oVar;
    }

    public o.b.c.a e(o.b.o o, o.b.a<?> a2) {
        String stateKey;
        Object stateKey2;
        Object reduce;
        o oVar = new o();
        HashSet hashSet = new HashSet();
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            stateKey2 = o.c((n)next2.getStateKey());
            reduce = next2.reduce(stateKey2, a2);
            if (reduce != null) {
            } else {
            }
            oVar.g(next2.getStateKey(), stateKey2);
            oVar.g(next2.getStateKey(), reduce);
            hashSet.add(next2.getStateKey());
        }
        c.a obj7 = new c.a(hashSet, oVar);
        return obj7;
    }
}
