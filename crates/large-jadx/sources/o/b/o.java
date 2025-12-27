package o.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: State.java */
/* loaded from: classes3.dex */
public class o implements Serializable {

    private final Map<String, Object> state = new HashMap<>();
    o(Map<String, Object> map) {
        super();
        final HashMap hashMap = new HashMap(map);
    }

    private Collection<String> d() {
        return this.state.keySet();
    }

    static String e(Class cls) {
        return cls.getSimpleName();
    }

    static o f(o oVar, o oVar2) {
        Object obj;
        o.b.o oVar22;
        if (oVar2 != null) {
            oVar22 = oVar2.a();
            Iterator it = oVar.d().iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        }
        return oVar22;
    }

    o a() {
        return new o(new HashMap(this.state));
    }

    public <E> E b(Class<E> cls) {
        Object value = this.state.get(o.e(cls));
        if (cls.isInstance(value)) {
            return value;
        }
        return null;
    }

    public Object c(String str) {
        return this.state.get(str);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            return this.state.equals(object.state);
        }
        return false;
    }

    public void g(String str, Object object) {
        this.state.put(str, object);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.state.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.state.toString();
    }

    public o() {
        super();
        final HashMap hashMap = new HashMap();
    }
}
