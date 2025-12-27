package net.time4j.engine;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: Chronology.java */
/* loaded from: classes3.dex */
public class w<T> implements t<T> {

    private static final List<w.b> x = new CopyOnWriteArrayList<>();
    private static final ReferenceQueue<w<?>> y = new ReferenceQueue<>();
    private final Class<T> a;
    private final t<T> b;
    private final Map<p<?>, y<T, ?>> c;
    private final List<r> v;
    private final Map<p<?>, b0<T>> w;

    public static class a<T extends q<T>> {

        final Class<T> a;
        final boolean b;
        final t<T> c;
        final Map<p<?>, y<T, ?>> d = new HashMap<>();
        final List<r> e = new ArrayList<>();
        a(Class<T> cls, t<T> tVar) {
            super();
            Objects.requireNonNull(tVar, "Missing chronological merger.");
            this.a = cls;
            this.b = cls.getName().startsWith("net.time4j.");
            this.c = tVar;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
        }

        private void c(p<?> pVar) {
            if (this.b) {
                return;
            }
            Objects.requireNonNull(pVar, "Static initialization problem: Check if given element statically refer to any chronology causing premature class loading.");
            String name = pVar.name();
            Iterator it = this.d.keySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (item.equals(pVar)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Element duplicate found: ";
                    r0 = str2 + name;
                    throw new IllegalArgumentException(r0);
                }
            }
        }

        public <V> w.a<T> a(p<V> pVar, y<T, V> yVar) {
            c(pVar);
            this.d.put(pVar, yVar);
            return this;
        }

        public w.a<T> b(r rVar) {
            Objects.requireNonNull(rVar, "Missing chronological extension.");
            if (!this.e.contains(rVar)) {
                this.e.add(rVar);
            }
            return this;
        }
    }

    private static class b extends WeakReference<w<?>> {

        private final String a;
        b(w<?> wVar, ReferenceQueue<w<?>> referenceQueue) {
            super(wVar, referenceQueue);
            this.a = wVar.a.getName();
        }

        static /* synthetic */ String a(w.b bVar) {
            return bVar.a;
        }
    }

    w(Class<T> cls, t<T> tVar, Map<p<?>, y<T, ?>> map, List<r> list) {
        super();
        Objects.requireNonNull(cls, "Missing chronological type.");
        str = "Missing chronological merger.";
        Objects.requireNonNull(tVar, str);
        this.a = cls;
        this.b = tVar;
        Map unmodifiable = Collections.unmodifiableMap(map);
        this.c = unmodifiable;
        this.v = Collections.unmodifiableList(list);
        HashMap hashMap = new HashMap();
        Iterator it = unmodifiable.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            str = Integer.class;
        }
        this.w = Collections.unmodifiableMap(hashMap);
    }

    static void A(w<?> wVar) {
        w.x.add(new w.b(wVar, w.y));
    }

    static /* synthetic */ Class g(w wVar) {
        return wVar.a;
    }

    private y<T, ?> n(p<?> pVar, boolean z) throws RuleNotFoundException {
        String str = null;
        assignableFrom = pVar instanceof e;
        if (pVar instanceof e) {
            if (q.class.isAssignableFrom(l())) {
                Object cast = e.class.cast(pVar);
                if (z) {
                    str = cast.g(this);
                }
                if (str != null) {
                    throw new RuleNotFoundException(str);
                } else {
                    w.h(this);
                    net.time4j.engine.y yVar = cast.d((w)this);
                    w.h(yVar);
                    return yVar;
                }
            }
        }
        return null;
    }

    public static <T> w<T> y(Class<T> cls) {
        Object obj = null;
        int i = 0;
        Class cls2;
        try {
            final boolean z = true;
            Class.forName(cls.getName(), z, cls.getClassLoader());
        } catch (java.lang.ClassNotFoundException classNotFound) {
            throw new IllegalStateException(classNotFound);
        }
        int i2 = 0;
        i = 0;
        Iterator it = w.x.iterator();
        while (it.hasNext()) {
            obj = (w.b)it.next().get();
            if (obj != null) {
                break;
            }
        }
        if (i != 0) {
            w.z();
        }
        w.h(obj);
        return obj;
    }

    private static void z() {
        boolean hasNext;
        boolean equals;
        String str;
        java.lang.ref.Reference poll = w.y.poll();
        while (poll != null) {
            Iterator it = w.x.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (item.a.equals(poll.a)) {
                    break loop_2;
                }
            }
            poll = w.y.poll();
            item = it.next();
        }
    }

    public d0 a() {
        return this.b.a();
    }

    public w<?> b() {
        return this.b.b();
    }

    public T c(q<?> qVar, d dVar, boolean z, boolean z2) {
        return this.b.c(qVar, dVar, z, z2);
    }

    public int d() {
        return this.b.d();
    }

    public o e(T t, d dVar) {
        return this.b.e(t, dVar);
    }

    public String f(x xVar, Locale locale) {
        return this.b.f(xVar, locale);
    }

    public k<T> j() throws ChronoException {
        throw new ChronoException("Calendar system is not available.");
    }

    public k<T> k(String str) throws ChronoException {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str2 = "Calendar variant is not available: ";
        str = str2 + str;
        throw new ChronoException(str);
    }

    public Class<T> l() {
        return this.a;
    }

    public List<r> o() {
        return this.v;
    }

    b0<T> r(p<Integer> pVar) {
        return (b0)this.w.get(pVar);
    }

    public Set<p<?>> u() {
        return this.c.keySet();
    }

    <V> y<T, V> v(p<V> pVar) throws RuleNotFoundException {
        Object value;
        Objects.requireNonNull(pVar, "Missing chronological element.");
        if ((y)this.c.get(pVar) == null) {
            if (n(pVar, true) == null) {
                throw new RuleNotFoundException(this, pVar);
            }
        }
        w.h(value);
        return value;
    }

    public boolean w(p<?> pVar) {
        Map map;
        boolean z = false;
        if (pVar != null) {
            pVar = this.c.containsKey(pVar) ? 1 : 0;
        }
        return (this.c.containsKey(pVar) ? 1 : 0);
    }

    public boolean x(p<?> pVar) {
        boolean z = false;
        net.time4j.engine.y yVar;
        z = false;
        if (pVar == null) {
            return false;
        }
        int r0 = 1;
        return true;
    }

    private static <T> T h(Object object) {
        return object;
    }
}
