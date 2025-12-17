package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.d.b;
import kotlin.d0.d.g;
import kotlin.d0.d.g0;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.i;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class j<T>  extends AbstractSet<T> {

    public static final kotlin.reflect.jvm.internal.impl.utils.j.b c;
    private Object a;
    private int b;

    public static final class b {
        public b(g g) {
            super();
        }

        public final <T> kotlin.reflect.jvm.internal.impl.utils.j<T> a() {
            j jVar = new j(0);
            return jVar;
        }

        public final <T> kotlin.reflect.jvm.internal.impl.utils.j<T> b(Collection<? extends T> collection) {
            n.f(collection, "set");
            j jVar = new j(0);
            jVar.addAll(collection);
            return jVar;
        }
    }

    private static final class a implements Iterator<T>, a {

        private final Iterator<T> a;
        public a(T[] tArr) {
            n.f(tArr, "array");
            super();
            this.a = b.a(tArr);
        }

        @Override // java.util.Iterator
        public Void c() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        public T next() {
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            c();
            throw 0;
        }
    }

    private static final class c implements Iterator<T>, a {

        private final T a;
        private boolean b = true;
        public c(T t) {
            super();
            this.a = t;
            final int obj1 = 1;
        }

        @Override // java.util.Iterator
        public Void c() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b;
        }

        public T next() {
            if (!this.b) {
            } else {
                this.b = false;
                return this.a;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            c();
            throw 0;
        }
    }
    static {
        j.b bVar = new j.b(0);
        j.c = bVar;
    }

    public j(g g) {
        super();
    }

    public static final <T> kotlin.reflect.jvm.internal.impl.utils.j<T> b() {
        return j.c.a();
    }

    public boolean add(T t) {
        int copyOf;
        int i;
        Object size;
        int length;
        Object obj6;
        final int i3 = 1;
        if (size() == 0) {
            this.a = t;
        } else {
            i = 0;
            if (size() == i3) {
                if (n.b(this.a, t)) {
                    return i;
                }
                copyOf = new Object[2];
                copyOf[i] = this.a;
                copyOf[i3] = t;
                this.a = copyOf;
            } else {
                if (size() < 5) {
                    Object obj2 = this.a;
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
                    if (i.t((Object[])obj2, t)) {
                        return i;
                    }
                    if (size() == 4) {
                        size = new Object[obj2.length];
                        System.arraycopy(obj2, i, size, i, obj2.length);
                        q0.d(size).add(t);
                        obj6 = w.a;
                    } else {
                        copyOf = Arrays.copyOf(obj2, size4 += i3);
                        n.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        copyOf[length2 -= i3] = t;
                        obj6 = w.a;
                    }
                    this.a = copyOf;
                } else {
                    Object obj3 = this.a;
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
                    if (!g0.d(obj3).add(t)) {
                        return i;
                    }
                }
            }
        }
        g(obj6 += i3);
        return i3;
    }

    @Override // java.util.AbstractSet
    public void clear() {
        this.a = 0;
        g(0);
    }

    @Override // java.util.AbstractSet
    public boolean contains(Object object) {
        Object size;
        int str;
        boolean obj3;
        if (size() == 0) {
            obj3 = 0;
        } else {
            if (size() == 1) {
                obj3 = n.b(this.a, object);
            } else {
                if (size() < 5) {
                    size = this.a;
                    Objects.requireNonNull(size, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
                    obj3 = i.t((Object[])size, object);
                } else {
                    size = this.a;
                    Objects.requireNonNull(size, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
                    obj3 = (Set)size.contains(object);
                }
            }
        }
        return obj3;
    }

    @Override // java.util.AbstractSet
    public int d() {
        return this.b;
    }

    @Override // java.util.AbstractSet
    public void g(int i) {
        this.b = i;
    }

    public Iterator<T> iterator() {
        Iterator cVar;
        Object str;
        String str2;
        if (size() == 0) {
            cVar = Collections.emptySet().iterator();
        } else {
            if (size() == 1) {
                cVar = new j.c(this.a);
            } else {
                if (size() < 5) {
                    str = this.a;
                    Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
                    cVar = new j.a((Object[])str);
                } else {
                    Object obj = this.a;
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
                    cVar = g0.d(obj).iterator();
                }
            }
        }
        return cVar;
    }

    @Override // java.util.AbstractSet
    public final int size() {
        return d();
    }
}
