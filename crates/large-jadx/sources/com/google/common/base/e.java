package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class e<T>  {

    static final class a extends com.google.common.base.e<Object> implements Serializable {

        static final com.google.common.base.e.a a = null;
        private static final long serialVersionUID = 1L;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        private Object readResolve() {
            return e.a.a;
        }

        @Override // com.google.common.base.e
        protected boolean a(Object object, Object object2) {
            return object.equals(object2);
        }

        @Override // com.google.common.base.e
        protected int b(Object object) {
            return object.hashCode();
        }
    }

    static final class b extends com.google.common.base.e<Object> implements Serializable {

        static final com.google.common.base.e.b a = null;
        private static final long serialVersionUID = 1L;
        static {
            e.b bVar = new e.b();
            e.b.a = bVar;
        }

        private Object readResolve() {
            return e.b.a;
        }

        @Override // com.google.common.base.e
        protected boolean a(Object object, Object object2) {
            return 0;
        }

        @Override // com.google.common.base.e
        protected int b(Object object) {
            return System.identityHashCode(object);
        }
    }
    public static com.google.common.base.e<Object> c() {
        return e.a.a;
    }

    public static com.google.common.base.e<Object> f() {
        return e.b.a;
    }

    protected abstract boolean a(T t, T t2);

    protected abstract int b(T t);

    public final boolean d(T t, T t2) {
        if (t == t2) {
            return 1;
        }
        if (t != null && t2 == null) {
            if (t2 == null) {
            }
            return a(t, t2);
        }
        return 0;
    }

    public final int e(T t) {
        if (t == null) {
            return 0;
        }
        return b(t);
    }
}
