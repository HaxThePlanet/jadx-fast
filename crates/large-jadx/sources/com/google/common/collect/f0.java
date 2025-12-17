package com.google.common.collect;

import com.google.common.base.e;
import com.google.common.base.n;
import f.c.c.b.b;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
class f0<K, V, E extends com.google.common.collect.f0.i<K, V, E>, S extends com.google.common.collect.f0.n<K, V, E, S>>  extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    private static final long serialVersionUID = 5L;
    static final com.google.common.collect.f0.b0<Object, Object, com.google.common.collect.f0.e> z;
    final transient int a = 0;
    final transient int b = 0;
    final transient com.google.common.collect.f0.n<K, V, E, S>[] c;
    final int concurrencyLevel;
    final e<Object> keyEquivalence;
    final transient com.google.common.collect.f0.j<K, V, E, S> v;
    transient Set<K> w;
    transient Collection<V> x;
    transient Set<Map.Entry<K, V>> y;

    interface b0 {
        public abstract E a();

        public abstract com.google.common.collect.f0.b0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        public abstract void clear();

        public abstract V get();
    }

    abstract class h implements Iterator<T> {

        int a;
        int b = -1;
        com.google.common.collect.f0.n<K, V, E, S> c;
        AtomicReferenceArray<E> v;
        E w;
        com.google.common.collect.f0.d0<K, V, E, S> x;
        com.google.common.collect.f0.d0<K, V, E, S> y;
        final com.google.common.collect.f0 z;
        h(com.google.common.collect.f0 f0) {
            this.z = f0;
            super();
            this.a = obj1--;
            int obj1 = -1;
            b();
        }

        @Override // java.util.Iterator
        final void b() {
            boolean count;
            com.google.common.collect.f0.n[] objArr;
            int i;
            this.x = 0;
            if (e()) {
            }
            if (f()) {
            }
            count = this.a;
            while (count >= 0) {
                this.a = count + -1;
                com.google.common.collect.f0.n nVar = f0Var.c[count];
                this.c = nVar;
                if (nVar.count) {
                } else {
                }
                count = this.a;
                AtomicReferenceArray table = nVar2.table;
                this.v = table;
                this.b = length--;
                if (!f()) {
                }
            }
        }

        boolean c(E e) {
            Object d0Var;
            com.google.common.collect.f0 f0Var;
            int obj4;
            try {
                obj4 = this.z.e(e);
                if (obj4 != null) {
                } else {
                }
                d0Var = new f0.d0(this.z, e.getKey(), obj4);
                this.x = d0Var;
                obj4 = 1;
                this.c.r();
                return obj4;
                obj4 = 0;
                this.c.r();
                throw e;
            }
        }

        com.google.common.collect.f0.d0<K, V, E, S> d() {
            com.google.common.collect.f0.d0 d0Var = this.x;
            if (d0Var == null) {
            } else {
                this.y = d0Var;
                b();
                return this.y;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        boolean e() {
            com.google.common.collect.f0.i iVar;
            if (this.w != null) {
            }
            return 0;
        }

        @Override // java.util.Iterator
        boolean f() {
            Object obj;
            AtomicReferenceArray atomicReferenceArray;
            int i;
            int i2 = this.b;
            while (i2 >= 0) {
                this.b = i2 + -1;
                obj = this.v.get(i2);
                this.w = (f0.i)obj;
                i2 = this.b;
            }
            return 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.x != null ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i;
            i = this.y != null ? 1 : 0;
            i.c(i);
            this.z.remove(this.y.getKey());
            this.y = 0;
        }
    }

    interface i {
        public abstract E a();

        public abstract int getHash();

        public abstract K getKey();

        public abstract V getValue();
    }

    interface j {
        public abstract E a(S s, E e2, E e3);

        public abstract com.google.common.collect.f0.p b();

        public abstract com.google.common.collect.f0.p c();

        public abstract void d(S s, E e2, V v3);

        public abstract S e(com.google.common.collect.f0<K, V, E, S> f0, int i2, int i3);

        public abstract E f(S s, K k2, int i3, E e4);
    }

    private static abstract class m extends AbstractSet<E> {
        m(com.google.common.collect.f0.a f0$a) {
            super();
        }

        @Override // java.util.AbstractSet
        public Object[] toArray() {
            return f0.a(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return f0.a(this).toArray(tArr);
        }
    }

    static abstract class n extends ReentrantLock {

        volatile int count;
        final com.google.common.collect.f0<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount;
        volatile AtomicReferenceArray<E> table;
        int threshold;
        n(com.google.common.collect.f0<K, V, E, S> f0, int i2, int i3) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger();
            this.readCount = atomicInteger;
            this.map = f0;
            this.maxSegmentSize = i3;
            m(q(i2));
        }

        static <K, V, E extends com.google.common.collect.f0.i<K, V, E>> boolean n(E e) {
            int obj0;
            obj0 = e.getValue() == null ? 1 : 0;
            return obj0;
        }

        boolean A(K k, int i2, V v3, V v4) {
            Object obj;
            int i;
            Object key;
            int keyEquivalence;
            boolean obj9;
            int obj10;
            lock();
            s();
            final AtomicReferenceArray table = this.table;
            final int i5 = 1;
            i3 &= i2;
            final Object obj2 = table.get(i4);
            obj = obj2;
            i = 0;
            while (obj != null) {
                key = obj.getKey();
                obj = obj.a();
                i = 0;
            }
            unlock();
            return i;
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void B() {
            C();
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void C() {
            boolean readCount;
            int i;
            if (tryLock()) {
                p();
                this.readCount.set(0);
                unlock();
            }
        }

        abstract S D();

        void E(E e, V v2) {
            map.v.d(D(), e, v2);
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void F() {
            if (tryLock()) {
                p();
                unlock();
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void a() {
            int count;
            int i2;
            int i;
            int length;
            if (this.count != 0) {
                lock();
                AtomicReferenceArray table = this.table;
                i2 = 0;
                i = i2;
                while (i < table.length()) {
                    table.set(i, 0);
                    i++;
                }
                o();
                this.readCount.set(i2);
                this.modCount = modCount++;
                this.count = i2;
                unlock();
            }
        }

        <T> void b(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        boolean c(Object object, int i2) {
            int i;
            Object obj3;
            try {
                obj3 = k(object, i2);
                if (this.count != 0 && obj3 != null && obj3.getValue() != null) {
                }
                obj3 = k(object, i2);
                if (obj3 != null) {
                }
                if (obj3.getValue() != null) {
                }
                i = 1;
                r();
                return i;
                r();
                return 0;
                r();
                throw object;
            }
        }

        E d(E e, E e2) {
            return map.v.a(D(), e, e2);
        }

        void e(ReferenceQueue<K> referenceQueue) {
            int i;
            int poll;
            com.google.common.collect.f0 map;
            i = 0;
            poll = referenceQueue.poll();
            while (poll != null) {
                this.map.h((f0.i)poll);
                if (i++ != 16) {
                }
                poll = referenceQueue.poll();
            }
        }

        void f(ReferenceQueue<V> referenceQueue) {
            int i;
            int poll;
            com.google.common.collect.f0 map;
            i = 0;
            poll = referenceQueue.poll();
            while (poll != null) {
                this.map.i((f0.b0)poll);
                if (i++ != 16) {
                }
                poll = referenceQueue.poll();
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void g() {
            int count;
            int i2;
            Object obj2;
            com.google.common.collect.f0.i iVar;
            int i;
            Object obj;
            int i3;
            final AtomicReferenceArray table = this.table;
            final int length = table.length();
            if (length >= 1073741824) {
            }
            count = this.count;
            AtomicReferenceArray atomicReferenceArray = q(length << 1);
            this.threshold = i6 /= 4;
            length3--;
            i2 = 0;
            while (i2 < length) {
                obj2 = table.get(i2);
                if ((f0.i)obj2 != null) {
                }
                i2++;
                if ((f0.i)obj2.a() == null) {
                } else {
                }
                obj = obj2;
                while (iVar != null) {
                    hash3 &= i8;
                    if (i3 != i) {
                    }
                    iVar = iVar.a();
                    obj = iVar;
                    i = i3;
                }
                atomicReferenceArray.set(i, obj);
                while (obj2 != obj) {
                    hash &= i8;
                    i = d(obj2, (f0.i)atomicReferenceArray.get(iVar));
                    if (i != 0) {
                    } else {
                    }
                    count--;
                    obj2 = obj2.a();
                    atomicReferenceArray.set(iVar, i);
                }
                hash &= i8;
                i = d(obj2, (f0.i)atomicReferenceArray.get(iVar));
                if (i != 0) {
                } else {
                }
                count--;
                obj2 = obj2.a();
                atomicReferenceArray.set(iVar, i);
                hash3 &= i8;
                if (i3 != i) {
                }
                iVar = iVar.a();
                obj = iVar;
                i = i3;
                atomicReferenceArray.set(hash2 &= i8, obj2);
            }
            this.table = atomicReferenceArray;
            this.count = count;
        }

        V h(Object object, int i2) {
            try {
                com.google.common.collect.f0.i obj1 = k(object, i2);
                if (obj1 == null) {
                }
                r();
                return 0;
                obj1 = obj1.getValue();
                if (obj1 == null) {
                }
                F();
            }
            r();
            return obj1;
        }

        E i(Object object, int i2) {
            int count;
            boolean hash;
            e keyEquivalence;
            if (this.count != 0) {
                count = j(i2);
                while (count != null) {
                    hash = count.getKey();
                    count = count.a();
                    F();
                }
            }
            return 0;
        }

        E j(int i) {
            final AtomicReferenceArray table = this.table;
            return (f0.i)table.get(i &= i2);
        }

        E k(Object object, int i2) {
            return i(object, i2);
        }

        V l(E e) {
            final int i = 0;
            if (e.getKey() == null) {
                F();
                return i;
            }
            final Object obj3 = e.getValue();
            if (obj3 == null) {
                F();
                return i;
            }
            return obj3;
        }

        void m(AtomicReferenceArray<E> atomicReferenceArray) {
            int i;
            i2 /= 4;
            this.threshold = i;
            if (i == this.maxSegmentSize) {
                this.threshold = i++;
            }
            this.table = atomicReferenceArray;
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void o() {
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void p() {
        }

        AtomicReferenceArray<E> q(int i) {
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
            return atomicReferenceArray;
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void r() {
            if (incrementAndGet &= 63 == 0) {
                B();
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        void s() {
            C();
        }

        V t(K k, int i2, V v3, boolean z4) {
            int i3;
            Object obj;
            int i;
            Object key;
            int keyEquivalence;
            lock();
            s();
            if (count++ > this.threshold) {
                g();
                count2++;
            }
            AtomicReferenceArray table = this.table;
            i4 &= i2;
            final Object obj2 = table.get(i5);
            obj = obj2;
            try {
                i = 0;
                while (obj != null) {
                    key = obj.getKey();
                    obj = obj.a();
                    i = 0;
                }
                key = obj.getKey();
                if (obj.getHash() == i2) {
                } else {
                }
                if (key != null) {
                } else {
                }
                if (map.keyEquivalence.d(k, key)) {
                } else {
                }
                Object obj9 = obj.getValue();
                if (obj9 == null) {
                }
                this.modCount = obj9++;
                E(obj, v3);
                this.count = this.count;
                unlock();
                return i;
                if (z4) {
                }
                unlock();
                return obj9;
                this.modCount = obj10++;
                E(obj, v3);
                unlock();
                return obj9;
                obj = obj.a();
                this.modCount = obj12++;
                obj9 = obj12.v.f(D(), k, i2, (f0.i)obj2);
                E(obj9, v3);
                table.set(i5, obj9);
                this.count = i3;
                unlock();
                return i;
                unlock();
                throw k;
            }
        }

        boolean u(E e, int i2) {
            Object obj;
            lock();
            final AtomicReferenceArray table = this.table;
            final int i4 = 1;
            i2 &= i;
            Object obj2 = table.get(obj6);
            obj = obj2;
            while (obj != null) {
                obj = obj.a();
            }
            unlock();
            return 0;
        }

        boolean v(K k, int i2, com.google.common.collect.f0.b0<K, V, E> f0$b03) {
            Object obj;
            int i;
            Object key;
            int keyEquivalence;
            lock();
            final AtomicReferenceArray table = this.table;
            final int i5 = 1;
            i3 &= i2;
            final Object obj2 = table.get(i4);
            obj = obj2;
            i = 0;
            while (obj != null) {
                key = obj.getKey();
                obj = obj.a();
                i = 0;
            }
            unlock();
            return i;
        }

        V w(Object object, int i2) {
            Object obj;
            int i;
            Object key;
            int keyEquivalence;
            boolean obj9;
            lock();
            s();
            final AtomicReferenceArray table = this.table;
            i3 &= i2;
            Object obj2 = table.get(i4);
            obj = obj2;
            i = 0;
            while (obj != null) {
                key = obj.getKey();
                obj = obj.a();
                i = 0;
            }
            unlock();
            return i;
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        boolean x(Object object, int i2, Object object3) {
            Object obj;
            int i;
            Object key;
            int keyEquivalence;
            boolean obj9;
            lock();
            s();
            final AtomicReferenceArray table = this.table;
            final int i5 = 1;
            i3 &= i2;
            final Object obj2 = table.get(i4);
            obj = obj2;
            i = 0;
            while (obj != null) {
                key = obj.getKey();
                obj = obj.a();
                i = 0;
            }
            unlock();
            return i;
        }

        E y(E e, E e2) {
            int count;
            com.google.common.collect.f0.i iVar;
            com.google.common.collect.f0.i iVar2;
            com.google.common.collect.f0.i obj4;
            count = this.count;
            iVar = e2.a();
            while (obj4 != e2) {
                iVar2 = d(obj4, iVar);
                if (iVar2 != null) {
                } else {
                }
                count--;
                obj4 = obj4.a();
                iVar = iVar2;
            }
            this.count = count;
            return iVar;
        }

        V z(K k, int i2, V v3) {
            Object obj;
            int i;
            Object key;
            int keyEquivalence;
            boolean obj8;
            int obj9;
            lock();
            s();
            final AtomicReferenceArray table = this.table;
            i3 &= i2;
            final Object obj2 = table.get(i4);
            obj = obj2;
            i = 0;
            while (obj != null) {
                key = obj.getKey();
                obj = obj.a();
                i = 0;
            }
            unlock();
            return i;
        }
    }

    static enum p {

        STRONG,
        WEAK;
        private static com.google.common.collect.f0.p[] $values() {
            com.google.common.collect.f0.p[] arr = new f0.p[2];
            return arr;
        }

        abstract e<Object> defaultEquivalence();
    }

    final class v extends AbstractCollection<V> {

        final com.google.common.collect.f0 a;
        v(com.google.common.collect.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // java.util.AbstractCollection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection
        public boolean contains(Object object) {
            return this.a.containsValue(object);
        }

        @Override // java.util.AbstractCollection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public Iterator<V> iterator() {
            f0.u uVar = new f0.u(this.a);
            return uVar;
        }

        @Override // java.util.AbstractCollection
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection
        public Object[] toArray() {
            return f0.a(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return f0.a(this).toArray(tArr);
        }
    }

    interface a0 extends com.google.common.collect.f0.i<K, V, E> {
        public abstract com.google.common.collect.f0.b0<K, V, E> b();
    }

    class a implements com.google.common.collect.f0.b0<Object, Object, com.google.common.collect.f0.e> {
        @Override // com.google.common.collect.f0$b0
        public com.google.common.collect.f0.i a() {
            return d();
        }

        @Override // com.google.common.collect.f0$b0
        public com.google.common.collect.f0.b0 b(ReferenceQueue referenceQueue, com.google.common.collect.f0.i f0$i2) {
            c(referenceQueue, (f0.e)i2);
            return this;
        }

        public com.google.common.collect.f0.b0<Object, Object, com.google.common.collect.f0.e> c(ReferenceQueue<Object> referenceQueue, com.google.common.collect.f0.e f0$e2) {
            return this;
        }

        @Override // com.google.common.collect.f0$b0
        public void clear() {
        }

        @Override // com.google.common.collect.f0$b0
        public com.google.common.collect.f0.e d() {
            return null;
        }

        @Override // com.google.common.collect.f0$b0
        public Object get() {
            return null;
        }
    }

    static final class c0 extends WeakReference<V> implements com.google.common.collect.f0.b0<K, V, E> {

        final E a;
        c0(ReferenceQueue<V> referenceQueue, V v2, E e3) {
            super(v2, referenceQueue);
            this.a = e3;
        }

        public E a() {
            return this.a;
        }

        public com.google.common.collect.f0.b0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            f0.c0 c0Var = new f0.c0(referenceQueue, get(), e2);
            return c0Var;
        }
    }

    static abstract class c implements com.google.common.collect.f0.i<K, V, E> {

        final K a;
        final int b;
        final E c;
        c(K k, int i2, E e3) {
            super();
            this.a = k;
            this.b = i2;
            this.c = e3;
        }

        public E a() {
            return this.c;
        }

        @Override // com.google.common.collect.f0$i
        public int getHash() {
            return this.b;
        }

        public K getKey() {
            return this.a;
        }
    }

    final class d0 extends com.google.common.collect.e<K, V> {

        final K a;
        V b;
        final com.google.common.collect.f0 c;
        d0(com.google.common.collect.f0 f0, Object object2, Object object3) {
            this.c = f0;
            super();
            this.a = object2;
            this.b = object3;
        }

        @Override // com.google.common.collect.e
        public boolean equals(Object object) {
            boolean equals;
            int i;
            Object key;
            Object obj4;
            i = 0;
            if (object instanceof Map.Entry && this.a.equals((Map.Entry)object.getKey()) && this.b.equals(object.getValue())) {
                if (this.a.equals((Map.Entry)object.getKey())) {
                    if (this.b.equals(object.getValue())) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        public K getKey() {
            return this.a;
        }

        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.e
        public int hashCode() {
            return i ^= i3;
        }

        public V setValue(V v) {
            this.b = v;
            return this.c.put(this.a, v);
        }
    }

    static abstract class d extends WeakReference<K> implements com.google.common.collect.f0.i<K, V, E> {

        final int a;
        final E b;
        d(ReferenceQueue<K> referenceQueue, K k2, int i3, E e4) {
            super(k2, referenceQueue);
            this.a = i3;
            this.b = e4;
        }

        public E a() {
            return this.b;
        }

        @Override // java.lang.ref.WeakReference
        public int getHash() {
            return this.a;
        }

        public K getKey() {
            return get();
        }
    }

    static final class e implements com.google.common.collect.f0.i<Object, Object, com.google.common.collect.f0.e> {
        private e() {
            super();
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }

        @Override // com.google.common.collect.f0$i
        public com.google.common.collect.f0.i a() {
            c();
            throw 0;
        }

        @Override // com.google.common.collect.f0$i
        public com.google.common.collect.f0.e c() {
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }

        @Override // com.google.common.collect.f0$i
        public int getHash() {
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }

        @Override // com.google.common.collect.f0$i
        public Object getKey() {
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }

        @Override // com.google.common.collect.f0$i
        public Object getValue() {
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
    }

    final class f extends com.google.common.collect.f0.h<K, V, E, S, Map.Entry<K, V>> {
        f(com.google.common.collect.f0 f0) {
            super(f0);
        }

        public Map.Entry<K, V> g() {
            return d();
        }

        @Override // com.google.common.collect.f0$h
        public Object next() {
            return g();
        }
    }

    final class g extends com.google.common.collect.f0.m<Map.Entry<K, V>> {

        final com.google.common.collect.f0 a;
        g(com.google.common.collect.f0 f0) {
            this.a = f0;
            super(0);
        }

        @Override // com.google.common.collect.f0$m
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.f0$m
        public boolean contains(Object object) {
            int i;
            Object f0Var;
            Object obj4;
            i = 0;
            if (!object instanceof Map.Entry) {
                return i;
            }
            Object key = (Map.Entry)object.getKey();
            if (key == null) {
                return i;
            }
            Object obj = this.a.get(key);
            if (obj != null && this.a.n().d(object.getValue(), obj)) {
                if (this.a.n().d(object.getValue(), obj)) {
                    i = 1;
                }
            }
            return i;
        }

        @Override // com.google.common.collect.f0$m
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            f0.f fVar = new f0.f(this.a);
            return fVar;
        }

        @Override // com.google.common.collect.f0$m
        public boolean remove(Object object) {
            int i;
            com.google.common.collect.f0 f0Var;
            Object obj4;
            if (!object instanceof Map.Entry) {
                return 0;
            }
            Object key = (Map.Entry)object.getKey();
            if (key != null && this.a.remove(key, object.getValue())) {
                if (this.a.remove(key, object.getValue())) {
                    i = 1;
                }
            }
            return i;
        }

        @Override // com.google.common.collect.f0$m
        public int size() {
            return this.a.size();
        }
    }

    final class k extends com.google.common.collect.f0.h<K, V, E, S, K> {
        k(com.google.common.collect.f0 f0) {
            super(f0);
        }

        public K next() {
            return d().getKey();
        }
    }

    final class l extends com.google.common.collect.f0.m<K> {

        final com.google.common.collect.f0 a;
        l(com.google.common.collect.f0 f0) {
            this.a = f0;
            super(0);
        }

        @Override // com.google.common.collect.f0$m
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.f0$m
        public boolean contains(Object object) {
            return this.a.containsKey(object);
        }

        @Override // com.google.common.collect.f0$m
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public Iterator<K> iterator() {
            f0.k kVar = new f0.k(this.a);
            return kVar;
        }

        @Override // com.google.common.collect.f0$m
        public boolean remove(Object object) {
            int obj2;
            obj2 = this.a.remove(object) != null ? 1 : 0;
            return obj2;
        }

        @Override // com.google.common.collect.f0$m
        public int size() {
            return this.a.size();
        }
    }

    static final class r extends com.google.common.collect.f0.n<K, V, com.google.common.collect.f0.q<K, V>, com.google.common.collect.f0.r<K, V>> {
        r(com.google.common.collect.f0<K, V, com.google.common.collect.f0.q<K, V>, com.google.common.collect.f0.r<K, V>> f0, int i2, int i3) {
            super(f0, i2, i3);
        }

        @Override // com.google.common.collect.f0$n
        com.google.common.collect.f0.n D() {
            G();
            return this;
        }

        com.google.common.collect.f0.r<K, V> G() {
            return this;
        }
    }

    static final class t extends com.google.common.collect.f0.n<K, V, com.google.common.collect.f0.s<K, V>, com.google.common.collect.f0.t<K, V>> {

        private final ReferenceQueue<V> queueForValues;
        t(com.google.common.collect.f0<K, V, com.google.common.collect.f0.s<K, V>, com.google.common.collect.f0.t<K, V>> f0, int i2, int i3) {
            super(f0, i2, i3);
            ReferenceQueue obj1 = new ReferenceQueue();
            this.queueForValues = obj1;
        }

        static ReferenceQueue G(com.google.common.collect.f0.t f0$t) {
            return t.queueForValues;
        }

        @Override // com.google.common.collect.f0$n
        com.google.common.collect.f0.n D() {
            H();
            return this;
        }

        com.google.common.collect.f0.t<K, V> H() {
            return this;
        }

        @Override // com.google.common.collect.f0$n
        void o() {
            b(this.queueForValues);
        }

        @Override // com.google.common.collect.f0$n
        void p() {
            f(this.queueForValues);
        }
    }

    final class u extends com.google.common.collect.f0.h<K, V, E, S, V> {
        u(com.google.common.collect.f0 f0) {
            super(f0);
        }

        public V next() {
            return d().getValue();
        }
    }

    static final class x extends com.google.common.collect.f0.n<K, V, com.google.common.collect.f0.w<K, V>, com.google.common.collect.f0.x<K, V>> {

        private final ReferenceQueue<K> queueForKeys;
        x(com.google.common.collect.f0<K, V, com.google.common.collect.f0.w<K, V>, com.google.common.collect.f0.x<K, V>> f0, int i2, int i3) {
            super(f0, i2, i3);
            ReferenceQueue obj1 = new ReferenceQueue();
            this.queueForKeys = obj1;
        }

        static ReferenceQueue G(com.google.common.collect.f0.x f0$x) {
            return x.queueForKeys;
        }

        @Override // com.google.common.collect.f0$n
        com.google.common.collect.f0.n D() {
            H();
            return this;
        }

        com.google.common.collect.f0.x<K, V> H() {
            return this;
        }

        @Override // com.google.common.collect.f0$n
        void o() {
            b(this.queueForKeys);
        }

        @Override // com.google.common.collect.f0$n
        void p() {
            e(this.queueForKeys);
        }
    }

    static final class z extends com.google.common.collect.f0.n<K, V, com.google.common.collect.f0.y<K, V>, com.google.common.collect.f0.z<K, V>> {

        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;
        z(com.google.common.collect.f0<K, V, com.google.common.collect.f0.y<K, V>, com.google.common.collect.f0.z<K, V>> f0, int i2, int i3) {
            super(f0, i2, i3);
            ReferenceQueue obj1 = new ReferenceQueue();
            this.queueForKeys = obj1;
            obj1 = new ReferenceQueue();
            this.queueForValues = obj1;
        }

        static ReferenceQueue G(com.google.common.collect.f0.z f0$z) {
            return z.queueForKeys;
        }

        static ReferenceQueue H(com.google.common.collect.f0.z f0$z) {
            return z.queueForValues;
        }

        @Override // com.google.common.collect.f0$n
        com.google.common.collect.f0.n D() {
            I();
            return this;
        }

        com.google.common.collect.f0.z<K, V> I() {
            return this;
        }

        @Override // com.google.common.collect.f0$n
        void o() {
            b(this.queueForKeys);
        }

        @Override // com.google.common.collect.f0$n
        void p() {
            e(this.queueForKeys);
            f(this.queueForValues);
        }
    }

    static final class q extends com.google.common.collect.f0.c<K, V, com.google.common.collect.f0.q<K, V>> implements com.google.common.collect.f0.i {

        private volatile V d = 0;
        q(K k, int i2, com.google.common.collect.f0.q<K, V> f0$q3) {
            super(k, i2, q3);
            final int obj1 = 0;
        }

        com.google.common.collect.f0.q<K, V> c(com.google.common.collect.f0.q<K, V> f0$q) {
            f0.q qVar = new f0.q(this.a, this.b, q);
            qVar.d = this.d;
            return qVar;
        }

        void d(V v) {
            this.d = v;
        }

        public V getValue() {
            return this.d;
        }
    }

    static final class s extends com.google.common.collect.f0.c<K, V, com.google.common.collect.f0.s<K, V>> implements com.google.common.collect.f0.a0<K, V, com.google.common.collect.f0.s<K, V>> {

        private volatile com.google.common.collect.f0.b0<K, V, com.google.common.collect.f0.s<K, V>> d;
        s(K k, int i2, com.google.common.collect.f0.s<K, V> f0$s3) {
            super(k, i2, s3);
            this.d = f0.m();
        }

        public com.google.common.collect.f0.b0<K, V, com.google.common.collect.f0.s<K, V>> b() {
            return this.d;
        }

        com.google.common.collect.f0.s<K, V> c(ReferenceQueue<V> referenceQueue, com.google.common.collect.f0.s<K, V> f0$s2) {
            f0.s sVar = new f0.s(this.a, this.b, s2);
            sVar.d = this.d.b(referenceQueue, sVar);
            return sVar;
        }

        void d(V v, ReferenceQueue<V> referenceQueue2) {
            f0.c0 c0Var = new f0.c0(referenceQueue2, v, this);
            this.d = c0Var;
            this.d.clear();
        }

        public V getValue() {
            return this.d.get();
        }
    }

    static final class w extends com.google.common.collect.f0.d<K, V, com.google.common.collect.f0.w<K, V>> implements com.google.common.collect.f0.i {

        private volatile V c = 0;
        w(ReferenceQueue<K> referenceQueue, K k2, int i3, com.google.common.collect.f0.w<K, V> f0$w4) {
            super(referenceQueue, k2, i3, w4);
            final int obj1 = 0;
        }

        com.google.common.collect.f0.w<K, V> c(ReferenceQueue<K> referenceQueue, com.google.common.collect.f0.w<K, V> f0$w2) {
            f0.w wVar = new f0.w(referenceQueue, getKey(), this.a, w2);
            wVar.d(this.c);
            return wVar;
        }

        void d(V v) {
            this.c = v;
        }

        public V getValue() {
            return this.c;
        }
    }

    static final class y extends com.google.common.collect.f0.d<K, V, com.google.common.collect.f0.y<K, V>> implements com.google.common.collect.f0.a0<K, V, com.google.common.collect.f0.y<K, V>> {

        private volatile com.google.common.collect.f0.b0<K, V, com.google.common.collect.f0.y<K, V>> c;
        y(ReferenceQueue<K> referenceQueue, K k2, int i3, com.google.common.collect.f0.y<K, V> f0$y4) {
            super(referenceQueue, k2, i3, y4);
            this.c = f0.m();
        }

        public com.google.common.collect.f0.b0<K, V, com.google.common.collect.f0.y<K, V>> b() {
            return this.c;
        }

        com.google.common.collect.f0.y<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, com.google.common.collect.f0.y<K, V> f0$y3) {
            f0.y yVar = new f0.y(referenceQueue, getKey(), this.a, y3);
            yVar.c = this.c.b(referenceQueue2, yVar);
            return yVar;
        }

        void d(V v, ReferenceQueue<V> referenceQueue2) {
            f0.c0 c0Var = new f0.c0(referenceQueue2, v, this);
            this.c = c0Var;
            this.c.clear();
        }

        public V getValue() {
            return this.c.get();
        }
    }

    static abstract class b extends com.google.common.collect.p<K, V> implements Serializable {

        private static final long serialVersionUID = 3L;
        transient ConcurrentMap<K, V> a;
        final int concurrencyLevel;
        final e<Object> keyEquivalence;
        final com.google.common.collect.f0.p keyStrength;
        final e<Object> valueEquivalence;
        final com.google.common.collect.f0.p valueStrength;
        b(com.google.common.collect.f0.p f0$p, com.google.common.collect.f0.p f0$p2, e<Object> e3, e<Object> e4, int i5, ConcurrentMap<K, V> concurrentMap6) {
            super();
            this.keyStrength = p;
            this.valueStrength = p2;
            this.keyEquivalence = e3;
            this.valueEquivalence = e4;
            this.concurrencyLevel = i5;
            this.a = concurrentMap6;
        }

        protected ConcurrentMap<K, V> d() {
            return this.a;
        }

        @Override // com.google.common.collect.p
        void e(ObjectInputStream objectInputStream) {
            final Object object = objectInputStream.readObject();
            while (object == null) {
                this.a.put(object, objectInputStream.readObject());
                object = objectInputStream.readObject();
            }
        }

        @Override // com.google.common.collect.p
        com.google.common.collect.e0 f(ObjectInputStream objectInputStream) {
            e0 e0Var = new e0();
            e0Var.g(objectInputStream.readInt());
            e0Var.j(this.keyStrength);
            e0Var.k(this.valueStrength);
            e0Var.h(this.keyEquivalence);
            e0Var.a(this.concurrencyLevel);
            return e0Var;
        }

        @Override // com.google.common.collect.p
        void g(ObjectOutputStream objectOutputStream) {
            Object value;
            Object key;
            objectOutputStream.writeInt(this.a.size());
            Iterator iterator = this.a.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                objectOutputStream.writeObject(next2.getKey());
                objectOutputStream.writeObject(next2.getValue());
            }
            objectOutputStream.writeObject(0);
        }
    }

    private static final class o extends com.google.common.collect.f0.b<K, V> {

        private static final long serialVersionUID = 3L;
        o(com.google.common.collect.f0.p f0$p, com.google.common.collect.f0.p f0$p2, e<Object> e3, e<Object> e4, int i5, ConcurrentMap<K, V> concurrentMap6) {
            super(p, p2, e3, e4, i5, concurrentMap6);
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.a = f(objectInputStream).i();
            e(objectInputStream);
        }

        private Object readResolve() {
            return this.a;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            g(objectOutputStream);
        }
    }
    static {
        f0.a aVar = new f0.a();
        f0.z = aVar;
    }

    private f0(com.google.common.collect.e0 e0, com.google.common.collect.f0.j<K, V, E, S> f0$j2) {
        int i4;
        int i3;
        int i2;
        int i;
        int i5;
        int concurrencyLevel;
        int obj5;
        int obj6;
        super();
        this.concurrencyLevel = Math.min(e0.b(), 65536);
        this.keyEquivalence = e0.d();
        this.v = j2;
        obj5 = Math.min(e0.c(), 1073741824);
        i = obj6;
        i3 = i4;
        while (i3 < this.concurrencyLevel) {
            i++;
            i3 <<= 1;
        }
        int i10 = i - 32;
        int i11 = i3 + -1;
        this.c = g(i3);
        i5 = obj5 / i3;
        i5 = i3 *= i5 < obj5 ? i5 + 1 : i5;
        while (i4 < i5) {
            i4 <<= 1;
        }
        obj5 = this.c;
        while (obj6 < obj5.length) {
            obj5[obj6] = d(i4, -1);
            obj6++;
            obj5 = this.c;
        }
    }

    static ArrayList a(Collection collection) {
        return f0.l(collection);
    }

    static <K, V> com.google.common.collect.f0<K, V, ? extends com.google.common.collect.f0.i<K, V, ?>, ?> c(com.google.common.collect.e0 e0) {
        com.google.common.collect.f0.p pVar3;
        com.google.common.collect.f0.p pVar2;
        com.google.common.collect.f0.p pVar;
        com.google.common.collect.f0.p pVar4;
        com.google.common.collect.f0.p wEAK;
        com.google.common.collect.f0.p sTRONG = f0.p.STRONG;
        if (e0.e() == sTRONG && e0.f() == sTRONG) {
            if (e0.f() == sTRONG) {
                f0 f0Var4 = new f0(e0, f0.q.a.h());
                return f0Var4;
            }
        }
        if (e0.e() == sTRONG && e0.f() == f0.p.WEAK) {
            if (e0.f() == f0.p.WEAK) {
                f0 f0Var3 = new f0(e0, f0.s.a.h());
                return f0Var3;
            }
        }
        com.google.common.collect.f0.p wEAK2 = f0.p.WEAK;
        if (e0.e() == wEAK2 && e0.f() == sTRONG) {
            if (e0.f() == sTRONG) {
                f0 f0Var = new f0(e0, f0.w.a.h());
                return f0Var;
            }
        }
        if (e0.e() != wEAK2) {
        } else {
            if (e0.f() != wEAK2) {
            } else {
                f0 f0Var2 = new f0(e0, f0.y.a.h());
                return f0Var2;
            }
        }
        AssertionError obj3 = new AssertionError();
        throw obj3;
    }

    static int j(int i) {
        i += i3;
        obj2 ^= i4;
        obj2 += i5;
        obj2 ^= i6;
        obj2 += i8;
        return obj2 ^= i9;
    }

    private static <E> ArrayList<E> l(Collection<E> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        b0.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends com.google.common.collect.f0.i<K, V, E>> com.google.common.collect.f0.b0<K, V, E> m() {
        return f0.z;
    }

    @Override // java.util.AbstractMap
    public void clear() {
        int i;
        com.google.common.collect.f0.n nVar;
        final com.google.common.collect.f0.n[] objArr = this.c;
        i = 0;
        while (i < objArr.length) {
            objArr[i].a();
            i++;
        }
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        if (object == null) {
            return 0;
        }
        final int i = f(object);
        return k(i).c(object, i);
    }

    @Override // java.util.AbstractMap
    public boolean containsValue(Object object) {
        int i2;
        int cmp;
        int i;
        int i3;
        int i4;
        int length;
        int i6;
        long l;
        AtomicReferenceArray table;
        int i5;
        int length2;
        Object obj;
        Object obj2 = object;
        cmp = 0;
        if (obj2 == null) {
            return cmp;
        }
        final com.google.common.collect.f0.n[] objArr = obj3.c;
        i = -1;
        i3 = cmp;
        while (i3 < 3) {
            i4 = 0;
            i6 = cmp;
            while (i6 < objArr.length) {
                com.google.common.collect.f0.n nVar = objArr[i6];
                int count = nVar.count;
                table = nVar.table;
                i5 = cmp;
                while (i5 < table.length()) {
                    length2 = table.get(i5);
                    while (length2 != null) {
                        obj = nVar.l(length2);
                        length2 = length2.a();
                        cmp = 0;
                    }
                    i5++;
                    cmp = 0;
                    obj = nVar.l(length2);
                    length2 = length2.a();
                    cmp = 0;
                }
                i4 += l;
                i6++;
                cmp = 0;
                length2 = table.get(i5);
                while (length2 != null) {
                    obj = nVar.l(length2);
                    length2 = length2.a();
                    cmp = 0;
                }
                i5++;
                cmp = 0;
                obj = nVar.l(length2);
                length2 = length2.a();
                cmp = 0;
            }
            i3++;
            i = i4;
            cmp = 0;
            nVar = objArr[i6];
            count = nVar.count;
            table = nVar.table;
            i5 = cmp;
            while (i5 < table.length()) {
                length2 = table.get(i5);
                while (length2 != null) {
                    obj = nVar.l(length2);
                    length2 = length2.a();
                    cmp = 0;
                }
                i5++;
                cmp = 0;
                obj = nVar.l(length2);
                length2 = length2.a();
                cmp = 0;
            }
            i4 += l;
            i6++;
            cmp = 0;
            length2 = table.get(i5);
            while (length2 != null) {
                obj = nVar.l(length2);
                length2 = length2.a();
                cmp = 0;
            }
            i5++;
            cmp = 0;
            obj = nVar.l(length2);
            length2 = length2.a();
            cmp = 0;
        }
        i2 = cmp;
        return i2;
    }

    com.google.common.collect.f0.n<K, V, E, S> d(int i, int i2) {
        return this.v.e(this, i, i2);
    }

    V e(E e) {
        if (e.getKey() == null) {
            return 0;
        }
        return e.getValue();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Object gVar;
        if (this.y != null) {
        } else {
            gVar = new f0.g(this);
            this.y = gVar;
        }
        return gVar;
    }

    @Override // java.util.AbstractMap
    int f(Object object) {
        return f0.j(this.keyEquivalence.e(object));
    }

    final com.google.common.collect.f0.n<K, V, E, S>[] g(int i) {
        return new f0.n[i];
    }

    public V get(Object object) {
        if (object == null) {
            return 0;
        }
        final int i = f(object);
        return k(i).h(object, i);
    }

    void h(E e) {
        final int hash = e.getHash();
        k(hash).u(e, hash);
    }

    void i(com.google.common.collect.f0.b0<K, V, E> f0$b0) {
        com.google.common.collect.f0.i iVar = b0.a();
        final int hash = iVar.getHash();
        k(hash).v(iVar.getKey(), hash, b0);
    }

    @Override // java.util.AbstractMap
    public boolean isEmpty() {
        int i3;
        int i4;
        int i2;
        int i;
        long l2;
        long l;
        com.google.common.collect.f0.n[] objArr = this.c;
        final int i5 = 0;
        i3 = 0;
        i = i5;
        i4 = i3;
        for (Object nVar2 : obj0) {
            i += l2;
        }
        int i6 = 1;
        if (Long.compare(i, i5) != 0) {
            i2 = i3;
            for (Object nVar4 : obj0) {
                i -= l;
            }
            if (Long.compare(i, i5) == 0) {
                i3 = i6;
            }
            return i3;
        }
        return i6;
    }

    com.google.common.collect.f0.n<K, V, E, S> k(int i) {
        return this.c[obj3 &= i3];
    }

    public Set<K> keySet() {
        Object lVar;
        if (this.w != null) {
        } else {
            lVar = new f0.l(this);
            this.w = lVar;
        }
        return lVar;
    }

    e<Object> n() {
        return this.v.c().defaultEquivalence();
    }

    public V put(K k, V v2) {
        n.o(k);
        n.o(v2);
        final int i = f(k);
        return k(i).t(k, i, v2, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        Object value;
        Object key;
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            put(next2.getKey(), next2.getValue());
        }
    }

    public V putIfAbsent(K k, V v2) {
        n.o(k);
        n.o(v2);
        final int i = f(k);
        return k(i).t(k, i, v2, true);
    }

    public V remove(Object object) {
        if (object == null) {
            return 0;
        }
        final int i = f(object);
        return k(i).w(object, i);
    }

    @Override // java.util.AbstractMap
    public boolean remove(Object object, Object object2) {
        if (object != null && object2 == null) {
            if (object2 == null) {
            }
            final int i = f(object);
            return k(i).x(object, i, object2);
        }
        return 0;
    }

    public V replace(K k, V v2) {
        n.o(k);
        n.o(v2);
        final int i = f(k);
        return k(i).z(k, i, v2);
    }

    public boolean replace(K k, V v2, V v3) {
        n.o(k);
        n.o(v3);
        if (v2 == null) {
            return 0;
        }
        final int i = f(k);
        return k(i).A(k, i, v2, v3);
    }

    @Override // java.util.AbstractMap
    public int size() {
        int i2;
        int i;
        long l;
        com.google.common.collect.f0.n[] objArr = this.c;
        i2 = 0;
        i = 0;
        for (Object nVar : obj0) {
            i2 += l;
        }
        return b.j(i2);
    }

    public Collection<V> values() {
        Object vVar;
        if (this.x != null) {
        } else {
            vVar = new f0.v(this);
            this.x = vVar;
        }
        return vVar;
    }

    @Override // java.util.AbstractMap
    Object writeReplace() {
        super(this.v.b(), this.v.c(), this.keyEquivalence, this.v.c().defaultEquivalence(), this.concurrencyLevel, this);
        return oVar2;
    }
}
