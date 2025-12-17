package o.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class o implements Serializable {

    private final Map<String, Object> state;
    public o() {
        super();
        HashMap hashMap = new HashMap();
        this.state = hashMap;
    }

    o(Map<String, Object> map) {
        super();
        HashMap hashMap = new HashMap(map);
        this.state = hashMap;
    }

    private Collection<String> d() {
        return this.state.keySet();
    }

    static String e(Class class) {
        return class.getSimpleName();
    }

    static o.b.o f(o.b.o o, o.b.o o2) {
        Iterator iterator;
        Object next;
        Object obj;
        o.b.o obj3;
        o.b.o obj4;
        if (o2 != null) {
            obj4 = o2.a();
            iterator = o.d().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj4.c((String)next) == null) {
                }
                obj4.g(next, o.c(next));
            }
            obj3 = obj4;
        }
        return obj3;
    }

    @Override // java.io.Serializable
    o.b.o a() {
        HashMap hashMap = new HashMap(this.state);
        o oVar = new o(hashMap);
        return oVar;
    }

    public <E> E b(Class<E> class) {
        Object obj = this.state.get(o.e(class));
        if (class.isInstance(obj)) {
            return obj;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public Object c(String string) {
        return this.state.get(string);
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        Class class2;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && getClass() != object.getClass()) {
            if (getClass() != object.getClass()) {
            }
            return this.state.equals(object.state);
        }
        return 0;
    }

    @Override // java.io.Serializable
    public void g(String string, Object object2) {
        this.state.put(string, object2);
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return this.state.hashCode();
    }

    @Override // java.io.Serializable
    public String toString() {
        return this.state.toString();
    }
}
