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
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class w<T>  implements net.time4j.engine.t<T> {

    private static final List<net.time4j.engine.w.b> x;
    private static final ReferenceQueue<net.time4j.engine.w<?>> y;
    private final Class<T> a;
    private final net.time4j.engine.t<T> b;
    private final Map<net.time4j.engine.p<?>, net.time4j.engine.y<T, ?>> c;
    private final List<net.time4j.engine.r> v;
    private final Map<net.time4j.engine.p<?>, net.time4j.engine.b0<T>> w;

    public static class a {

        final Class<T> a;
        final boolean b;
        final net.time4j.engine.t<T> c;
        final Map<net.time4j.engine.p<?>, net.time4j.engine.y<T, ?>> d;
        final List<net.time4j.engine.r> e;
        a(Class<T> class, net.time4j.engine.t<T> t2) {
            super();
            Objects.requireNonNull(t2, "Missing chronological merger.");
            this.a = class;
            this.b = class.getName().startsWith("net.time4j.");
            this.c = t2;
            HashMap obj2 = new HashMap();
            this.d = obj2;
            obj2 = new ArrayList();
            this.e = obj2;
        }

        private void c(net.time4j.engine.p<?> p) {
            boolean equals;
            boolean equals2;
            if (this.b) {
            }
            Objects.requireNonNull(p, "Static initialization problem: Check if given element statically refer to any chronology causing premature class loading.");
            String name = p.name();
            Iterator iterator = this.d.keySet().iterator();
            for (p equals : iterator) {
            }
        }

        public <V> net.time4j.engine.w.a<T> a(net.time4j.engine.p<V> p, net.time4j.engine.y<T, V> y2) {
            c(p);
            this.d.put(p, y2);
            return this;
        }

        public net.time4j.engine.w.a<T> b(net.time4j.engine.r r) {
            boolean contains;
            Objects.requireNonNull(r, "Missing chronological extension.");
            if (!this.e.contains(r)) {
                this.e.add(r);
            }
            return this;
        }
    }

    private static class b extends WeakReference<net.time4j.engine.w<?>> {

        private final String a;
        b(net.time4j.engine.w<?> w, ReferenceQueue<net.time4j.engine.w<?>> referenceQueue2) {
            super(w, referenceQueue2);
            this.a = w.g(w).getName();
        }

        static String a(net.time4j.engine.w.b w$b) {
            return b.a;
        }
    }
    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        w.x = copyOnWriteArrayList;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        w.y = referenceQueue;
    }

    w(Class<T> class, net.time4j.engine.t<T> t2, Map<net.time4j.engine.p<?>, net.time4j.engine.y<T, ?>> map3, List<net.time4j.engine.r> list4) {
        String str;
        Map obj4;
        List obj5;
        super();
        Objects.requireNonNull(class, "Missing chronological type.");
        Objects.requireNonNull(t2, "Missing chronological merger.");
        this.a = class;
        this.b = t2;
        Map obj2 = Collections.unmodifiableMap(map3);
        this.c = obj2;
        this.v = Collections.unmodifiableList(list4);
        HashMap obj3 = new HashMap();
        obj2 = obj2.keySet().iterator();
        while (obj2.hasNext()) {
            obj4 = obj2.next();
            obj5 = this.c.get(obj4);
            if ((p)obj4.getType() == Integer.class && obj5 instanceof b0 != null) {
            }
            obj5 = this.c.get(obj4);
            if (obj5 instanceof b0 != null) {
            }
            obj3.put(obj4, (b0)obj5);
        }
        this.w = Collections.unmodifiableMap(obj3);
    }

    static void A(net.time4j.engine.w<?> w) {
        w.b bVar = new w.b(w, w.y);
        w.x.add(bVar);
    }

    static Class g(net.time4j.engine.w w) {
        return w.a;
    }

    private static <T> T h(Object object) {
        return object;
    }

    private net.time4j.engine.y<T, ?> n(net.time4j.engine.p<?> p, boolean z2) {
        boolean assignableFrom;
        int i;
        Class cls;
        Object obj4 = e.class.cast(p);
        if (p instanceof e && q.class.isAssignableFrom(l()) && z2) {
            if (q.class.isAssignableFrom(l())) {
                obj4 = e.class.cast(p);
                if (z2) {
                    i = (e)(e)obj4.g(this);
                }
                if (i != 0) {
                } else {
                    w.h(this);
                    obj4 = obj4.d((w)this);
                    w.h(obj4);
                    return (y)obj4;
                }
                obj4 = new RuleNotFoundException(i);
                throw obj4;
            }
        }
        return 0;
    }

    public static <T> net.time4j.engine.w<T> y(Class<T> class) {
        int i;
        int i2;
        Object next;
        Class cls;
        try {
            final int i3 = 1;
            Class.forName(class.getName(), i3, class.getClassLoader());
            i = 0;
            i2 = 0;
            Iterator iterator = w.x.iterator();
            while (iterator.hasNext()) {
                next = (w.b)iterator.next().get();
                if ((w)next != null) {
                    break;
                } else {
                }
                if ((w)next.l() == class) {
                    break;
                } else {
                }
                i2 = i3;
            }
            next = (w.b)iterator.next().get();
            if ((w)next == null) {
            } else {
            }
            i2 = i3;
            if ((w)next.l() == class) {
            } else {
            }
            i = next;
            if (i2 != 0) {
            }
            w.z();
            w.h(i);
            return (w)i;
            IllegalStateException illegalStateException = new IllegalStateException(class);
            throw illegalStateException;
        }
    }

    private static void z() {
        Object poll;
        Iterator iterator;
        boolean next;
        boolean equals;
        String str;
        poll = w.y.poll();
        while ((w.b)poll != null) {
            iterator = w.x.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (w.b.a((w.b)next).equals(w.b.a((w.b)poll))) {
                    break loop_2;
                } else {
                }
            }
            poll = w.y.poll();
            next = iterator.next();
            if (w.b.a((w.b)next).equals(w.b.a((w.b)poll))) {
            } else {
            }
            w.x.remove(next);
        }
    }

    @Override // net.time4j.engine.t
    public net.time4j.engine.d0 a() {
        return this.b.a();
    }

    public net.time4j.engine.w<?> b() {
        return this.b.b();
    }

    public T c(net.time4j.engine.q<?> q, net.time4j.engine.d d2, boolean z3, boolean z4) {
        return this.b.c(q, d2, z3, z4);
    }

    @Override // net.time4j.engine.t
    public int d() {
        return this.b.d();
    }

    public net.time4j.engine.o e(T t, net.time4j.engine.d d2) {
        return this.b.e(t, d2);
    }

    @Override // net.time4j.engine.t
    public String f(net.time4j.engine.x x, Locale locale2) {
        return this.b.f(x, locale2);
    }

    public net.time4j.engine.k<T> j() {
        ChronoException chronoException = new ChronoException("Calendar system is not available.");
        throw chronoException;
    }

    public net.time4j.engine.k<T> k(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calendar variant is not available: ");
        stringBuilder.append(string);
        ChronoException chronoException = new ChronoException(stringBuilder.toString());
        throw chronoException;
    }

    public Class<T> l() {
        return this.a;
    }

    public List<net.time4j.engine.r> o() {
        return this.v;
    }

    net.time4j.engine.b0<T> r(net.time4j.engine.p<Integer> p) {
        return (b0)this.w.get(p);
    }

    public Set<net.time4j.engine.p<?>> u() {
        return this.c.keySet();
    }

    <V> net.time4j.engine.y<T, V> v(net.time4j.engine.p<V> p) {
        Object obj;
        Objects.requireNonNull(p, "Missing chronological element.");
        if ((y)this.c.get(p) == null) {
            if (n(p, true) == null) {
            } else {
            }
            RuleNotFoundException ruleNotFoundException = new RuleNotFoundException(this, p);
            throw ruleNotFoundException;
        }
        w.h(obj);
        return (y)obj;
    }

    public boolean w(net.time4j.engine.p<?> p) {
        Map map;
        Object obj2;
        if (p != null && this.c.containsKey(p)) {
            obj2 = this.c.containsKey(p) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public boolean x(net.time4j.engine.p<?> p) {
        int i;
        Object obj3;
        i = 0;
        if (p == null) {
            return i;
        }
        if (!w(p)) {
            if (n(p, i) != null) {
                i = 1;
            }
        } else {
        }
        return i;
    }
}
