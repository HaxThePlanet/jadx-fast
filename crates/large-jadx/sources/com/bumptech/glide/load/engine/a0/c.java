package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.t.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {

    private final Map<String, c.a> a = new HashMap<>();
    private final c.b b = new c$b();

    private static class a {

        final Lock a = new ReentrantLock();
        int b;
        a() {
            super();
            final ReentrantLock reentrantLock = new ReentrantLock();
        }
    }

    private static class b {

        private final Queue<c.a> a = new ArrayDeque<>();
        b() {
            super();
            final ArrayDeque arrayDeque = new ArrayDeque();
        }

        c.a a() {
            Object poll;
            synchronized (queue) {
                try {
                } catch (Throwable th) {
                }
            }
            if ((c.a)this.a.poll() == null) {
                com.bumptech.glide.load.engine.a0.c.a aVar = new c.a();
            }
            return poll;
        }

        void b(c.a aVar) {
            synchronized (queue) {
                try {
                    if (this.a.size() < 10) {
                        this.a.offer(aVar);
                    }
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }
    }
    c() {
        super();
        HashMap hashMap = new HashMap();
        com.bumptech.glide.load.engine.a0.c.b bVar = new c.b();
    }

    void a(String str) {
        Object value;
        synchronized (this) {
            try {
                if ((c.a)this.a.get(str) == null) {
                    this.a.put(str, this.b.a());
                }
                value.b++;
            } catch (Throwable th) {
            }
        }
        value.a.lock();
    }

    void b(String str) {
        synchronized (this) {
            try {
                Object value = this.a.get(str);
                k.d(value);
                int i2 = 1;
                value.b -= i2;
                if (value.b == 0) {
                    Object remove = this.a.remove(str);
                    if (!remove.equals(value)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        final String str5 = "Removed the wrong lock, expected to remove: ";
                        String str2 = ", but actually removed: ";
                        String str3 = ", safeKey: ";
                        str = str5 + value + str2 + remove + str3 + str;
                        throw new IllegalStateException(str);
                    } else {
                        this.b.b(remove);
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Cannot release a lock that is not held, safeKey: ";
                String str6 = ", interestedThreads: ";
                str = str4 + str + str6 + value.b;
                throw new IllegalStateException(str);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
        value.a.unlock();
    }
}
