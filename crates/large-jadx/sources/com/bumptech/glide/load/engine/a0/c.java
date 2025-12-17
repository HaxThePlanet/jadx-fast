package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.t.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class c {

    private final Map<String, com.bumptech.glide.load.engine.a0.c.a> a;
    private final com.bumptech.glide.load.engine.a0.c.b b;

    private static class a {

        final Lock a;
        int b;
        a() {
            super();
            ReentrantLock reentrantLock = new ReentrantLock();
            this.a = reentrantLock;
        }
    }

    private static class b {

        private final Queue<com.bumptech.glide.load.engine.a0.c.a> a;
        b() {
            super();
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
        }

        com.bumptech.glide.load.engine.a0.c.a a() {
            Object aVar;
            final Queue queue = this.a;
            synchronized (queue) {
                queue = this.a;
            }
            aVar = new c.a();
            return aVar;
        }

        void b(com.bumptech.glide.load.engine.a0.c.a c$a) {
            int size;
            final Queue queue = this.a;
            synchronized (queue) {
                this.a.offer(a);
            }
        }
    }
    c() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        c.b bVar = new c.b();
        this.b = bVar;
    }

    void a(String string) {
        Object obj;
        Map map;
        synchronized (this) {
            try {
                this.a.put(string, this.b.a());
                obj.b = obj3++;
                obj.a.lock();
                throw string;
            }
        }
    }

    void b(String string) {
        int remove;
        int equals;
        Object obj6;
        Object obj = this.a.get(string);
        k.d(obj);
        int i = obj.b;
        equals = 1;
        synchronized (this) {
            try {
                i -= equals;
                obj.b = remove;
                if (remove == 0) {
                }
                remove = this.a.remove(string);
                if (!(c.a)remove.equals((c.a)obj)) {
                } else {
                }
                this.b.b(remove);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Removed the wrong lock, expected to remove: ");
                stringBuilder2.append(obj);
                stringBuilder2.append(", but actually removed: ");
                stringBuilder2.append(remove);
                stringBuilder2.append(", safeKey: ");
                stringBuilder2.append(string);
                IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder2.toString());
                throw illegalStateException2;
                obj.a.unlock();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot release a lock that is not held, safeKey: ");
                stringBuilder.append(string);
                stringBuilder.append(", interestedThreads: ");
                stringBuilder.append(obj.b);
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
                throw string;
            }
        }
    }
}
