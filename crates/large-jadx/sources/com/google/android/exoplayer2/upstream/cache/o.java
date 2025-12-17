package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.database.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public final class o implements com.google.android.exoplayer2.upstream.cache.Cache {

    private static final HashSet<File> l;
    private final File a;
    private final com.google.android.exoplayer2.upstream.cache.d b;
    private final com.google.android.exoplayer2.upstream.cache.j c;
    private final com.google.android.exoplayer2.upstream.cache.f d;
    private final HashMap<String, ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.a>> e;
    private final Random f;
    private final boolean g;
    private long h;
    private long i;
    private boolean j;
    private com.google.android.exoplayer2.upstream.cache.Cache.CacheException k;

    class a extends Thread {

        final ConditionVariable a;
        final com.google.android.exoplayer2.upstream.cache.o b;
        a(com.google.android.exoplayer2.upstream.cache.o o, String string2, ConditionVariable conditionVariable3) {
            this.b = o;
            this.a = conditionVariable3;
            super(string2);
        }

        @Override // java.lang.Thread
        public void run() {
            final com.google.android.exoplayer2.upstream.cache.o oVar = this.b;
            this.a.open();
            o.j(this.b);
            o.k(this.b).e();
            return;
            synchronized (oVar) {
                oVar = this.b;
                this.a.open();
                o.j(this.b);
                o.k(this.b).e();
            }
        }
    }
    static {
        HashSet hashSet = new HashSet();
        o.l = hashSet;
    }

    public o(File file, com.google.android.exoplayer2.upstream.cache.d d2, a a3) {
        super(file, d2, a3, 0, 0, 0);
    }

    public o(File file, com.google.android.exoplayer2.upstream.cache.d d2, a a3, byte[] b4Arr4, boolean z5, boolean z6) {
        int obj11;
        super(a3, file, b4Arr4, z5, z6);
        if (a3 != null && !z6) {
            if (!z6) {
                obj11 = new f(a3);
            } else {
                obj11 = 0;
            }
        } else {
        }
        super(file, d2, jVar2, obj11);
    }

    o(File file, com.google.android.exoplayer2.upstream.cache.d d2, com.google.android.exoplayer2.upstream.cache.j j3, com.google.android.exoplayer2.upstream.cache.f f4) {
        super();
        if (o.t(file) == null) {
        } else {
            this.a = file;
            this.b = d2;
            this.c = j3;
            this.d = f4;
            HashMap obj2 = new HashMap();
            this.e = obj2;
            obj2 = new Random();
            this.f = obj2;
            this.g = d2.f();
            this.h = -1;
            obj2 = new ConditionVariable();
            o.a obj3 = new o.a(this, "ExoPlayer:SimpleCacheInit", obj2);
            obj3.start();
            obj2.block();
        }
        obj2 = String.valueOf(file);
        StringBuilder obj5 = new StringBuilder(obj4 += 46);
        obj5.append("Another SimpleCache instance uses the folder: ");
        obj5.append(obj2);
        obj3 = new IllegalStateException(obj5.toString());
        throw obj3;
    }

    private com.google.android.exoplayer2.upstream.cache.p A(String string, com.google.android.exoplayer2.upstream.cache.p p2) {
        int i;
        com.google.android.exoplayer2.upstream.cache.f fVar;
        String name;
        long l;
        if (!this.g) {
            return p2;
        }
        File file = p2.w;
        g.e(file);
        final long currentTimeMillis = System.currentTimeMillis();
        i = 0;
        fVar = this.d;
        if (fVar != null) {
            fVar.h((File)file.getName(), p2.c, obj4);
        } else {
            i = 1;
        }
        com.google.android.exoplayer2.upstream.cache.p obj10 = this.c.g(string).k(p2, currentTimeMillis, obj8);
        w(p2, obj10);
        return obj10;
    }

    static void j(com.google.android.exoplayer2.upstream.cache.o o) {
        o.q();
    }

    static com.google.android.exoplayer2.upstream.cache.d k(com.google.android.exoplayer2.upstream.cache.o o) {
        return o.b;
    }

    private void l(com.google.android.exoplayer2.upstream.cache.p p) {
        this.c.m(p.a).a(p);
        this.i = l += l2;
        u(p);
    }

    private static void n(File file) {
        boolean directory;
        if (file.mkdirs() == null) {
            if (file.isDirectory() == null) {
            } else {
            }
            String obj2 = String.valueOf(file);
            StringBuilder stringBuilder = new StringBuilder(length += 34);
            stringBuilder.append("Failed to create cache directory: ");
            stringBuilder.append(obj2);
            obj2 = stringBuilder.toString();
            v.c("SimpleCache", obj2);
            Cache.CacheException cacheException = new Cache.CacheException(obj2);
            throw cacheException;
        }
    }

    private static long o(File file) {
        long l;
        String concat;
        String string;
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (Long.compare(nextLong, l2) == 0) {
            l = 0;
        } else {
            l = Math.abs(nextLong);
        }
        String valueOf3 = String.valueOf(Long.toString(l, obj1));
        string = ".uid";
        if (string.length() != 0) {
            concat = valueOf3.concat(string);
        } else {
            string = new String(valueOf3);
            concat = string;
        }
        File file2 = new File(file, concat);
        if (file2.createNewFile() == null) {
        } else {
            return l;
        }
        String valueOf = String.valueOf(file2);
        StringBuilder stringBuilder = new StringBuilder(length += 27);
        stringBuilder.append("Failed to create UID file: ");
        stringBuilder.append(valueOf);
        IOException obj6 = new IOException(stringBuilder.toString());
        throw obj6;
    }

    private com.google.android.exoplayer2.upstream.cache.p p(String string, long l2, long l3) {
        int cmp;
        long l;
        String obj6;
        com.google.android.exoplayer2.upstream.cache.i iVar = this.c.g(string);
        if (iVar == null) {
            return p.k(string, l2, l3);
        }
        obj6 = iVar.d(l2, l3);
        while (obj6.v) {
            if (Long.compare(length, l) != 0) {
            }
            z();
            obj6 = iVar.d(l2, l3);
        }
        return obj6;
    }

    private void q() {
        boolean exists;
        File[] listFiles;
        com.google.android.exoplayer2.upstream.cache.j jVar;
        int cmp;
        Object keySet;
        int i;
        if (!this.a.exists()) {
            o.n(this.a);
        }
        listFiles = this.a.listFiles();
        if (listFiles == null) {
            String valueOf = String.valueOf(this.a);
            StringBuilder stringBuilder = new StringBuilder(length += 38);
            stringBuilder.append("Failed to list cache directory files: ");
            stringBuilder.append(valueOf);
            String string = stringBuilder.toString();
            v.c("SimpleCache", string);
            Cache.CacheException cacheException2 = new Cache.CacheException(string);
            this.k = cacheException2;
        }
        long l = o.s(listFiles);
        this.h = l;
        int i4 = -1;
        if (Long.compare(l, i4) == 0) {
            this.h = o.o(this.a);
        }
        try {
            this.c.n(this.h);
            com.google.android.exoplayer2.upstream.cache.f fVar = this.d;
            int i3 = 1;
            if (fVar != null) {
            } else {
            }
            fVar.e(this.h);
            Map map = this.d.b();
            r(this.a, i3, listFiles, map);
            this.d.g(map.keySet());
            r(this.a, i3, listFiles, 0);
            this.c.r();
            this.c.s();
            File string2 = "Storing index file failed";
            v.d(cacheException, string2, th);
        } catch (java.io.IOException ioException) {
        }
    }

    private void r(File file, boolean z2, File[] file3Arr3, Map<String, com.google.android.exoplayer2.upstream.cache.e> map4) {
        int length;
        int i2;
        File[] listFiles;
        int remove;
        int endsWith;
        int i;
        long l;
        com.google.android.exoplayer2.upstream.cache.j jVar;
        Object obj;
        if (file3Arr3 != null) {
            if (file3Arr3.length == null) {
            } else {
                int i3 = 0;
                i2 = i3;
                while (i2 < file3Arr3.length) {
                    obj = file3Arr3[i2];
                    listFiles = obj.getName();
                    if (z2 && listFiles.indexOf(46) == -1) {
                    } else {
                    }
                    if (z2) {
                    } else {
                    }
                    endsWith = -1;
                    l = -9223372036854775807L;
                    if (map4 != null) {
                    } else {
                    }
                    remove = 0;
                    if (remove != 0) {
                    }
                    listFiles = p.i(obj, endsWith, i, l);
                    if (listFiles != null) {
                    } else {
                    }
                    obj.delete();
                    i2++;
                    l(listFiles);
                    endsWith = remove.a;
                    l = remove.b;
                    remove = map4.remove(listFiles);
                    if (j.o(listFiles) == null) {
                    }
                    if (listFiles.endsWith(".uid") != null) {
                    } else {
                    }
                    if (listFiles.indexOf(46) == -1) {
                    } else {
                    }
                    r(obj, i3, obj.listFiles(), map4);
                }
            }
        }
        if (!z2) {
            file.delete();
        }
    }

    private static long s(File[] fileArr) {
        int i;
        Object obj;
        String string;
        String endsWith;
        StringBuilder stringBuilder;
        i = 0;
        while (i < fileArr.length) {
            string = fileArr[i].getName();
            i++;
            string = String.valueOf(obj2);
            endsWith = String.valueOf(string);
            endsWith = endsWith.length();
            endsWith += 20;
            stringBuilder = new StringBuilder(endsWith);
            endsWith = "Malformed UID file: ";
            stringBuilder.append(endsWith);
            stringBuilder.append(string);
            string = stringBuilder.toString();
            endsWith = "SimpleCache";
            v.c(endsWith, string);
            obj2.delete();
        }
        return -1;
    }

    private static boolean t(File file) {
        final Class<com.google.android.exoplayer2.upstream.cache.o> obj = o.class;
        return o.l.add(file.getAbsoluteFile());
        synchronized (obj) {
            obj = o.class;
            return o.l.add(file.getAbsoluteFile());
        }
    }

    private void u(com.google.android.exoplayer2.upstream.cache.p p) {
        int str;
        Object obj;
        Object obj2 = this.e.get(p.a);
        if ((ArrayList)obj2 != null) {
            size--;
            while (str >= 0) {
                (Cache.a)obj2.get(str).d(this, p);
                str--;
            }
        }
        this.b.d(this, p);
    }

    private void v(com.google.android.exoplayer2.upstream.cache.h h) {
        int str;
        Object obj;
        Object obj2 = this.e.get(h.a);
        if ((ArrayList)obj2 != null) {
            size--;
            while (str >= 0) {
                (Cache.a)obj2.get(str).b(this, h);
                str--;
            }
        }
        this.b.b(this, h);
    }

    private void w(com.google.android.exoplayer2.upstream.cache.p p, com.google.android.exoplayer2.upstream.cache.h h2) {
        int str;
        Object obj;
        Object obj2 = this.e.get(p.a);
        if ((ArrayList)obj2 != null) {
            size--;
            while (str >= 0) {
                (Cache.a)obj2.get(str).c(this, p, h2);
                str--;
            }
        }
        this.b.c(this, p, h2);
    }

    private static long x(String string) {
        return Long.parseLong(string.substring(0, string.indexOf(46)), 16);
    }

    private void y(com.google.android.exoplayer2.upstream.cache.h h) {
        Object iVar;
        Object string;
        Object name;
        String str;
        Object str2;
        int length;
        iVar = this.c.g(h.a);
        if (iVar != null) {
            if (!iVar.j(h)) {
            } else {
                this.i = l -= length;
                if (this.d != null) {
                    this.d.f(h.w.getName());
                }
                this.c.p(iVar.b);
                v(h);
            }
        }
    }

    private void z() {
        int i;
        Iterator iterator;
        boolean next;
        boolean next2;
        int cmp;
        long l;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.c.h().iterator();
        for (i next3 : iterator2) {
            iterator = next3.e().iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                if (Long.compare(length, l) != 0) {
                }
                arrayList.add((h)next2);
            }
            next2 = iterator.next();
            if (Long.compare(length, l) != 0) {
            }
            arrayList.add((h)next2);
        }
        i = 0;
        while (i < arrayList.size()) {
            y((h)arrayList.get(i));
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public File a(String string, long l2, long l3) {
        int i;
        boolean exists;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                m();
                com.google.android.exoplayer2.upstream.cache.i iVar = this.c.g(string);
                g.e(iVar);
                g.f(iVar.g(l2, l3));
                if (!this.a.exists()) {
                }
                o.n(this.a);
                z();
                this.b.a(this, string, l2, obj5);
                File file2 = new File(this.a, Integer.toString(this.f.nextInt(10)));
                if (file2.exists() == null) {
                }
                o.n(file2);
                return p.n(file2, iVar.a, l2, obj5);
                throw string;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public com.google.android.exoplayer2.upstream.cache.k b(String string) {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                return this.c.j(string);
                throw string;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void c(String string, com.google.android.exoplayer2.upstream.cache.l l2) {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                m();
                this.c.e(string, l2);
                this.c.s();
                l2 = new Cache.CacheException(string);
                throw l2;
                throw string;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void d(com.google.android.exoplayer2.upstream.cache.h h) {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                y(h);
                throw h;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public com.google.android.exoplayer2.upstream.cache.h e(String string, long l2, long l3) {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                m();
                final com.google.android.exoplayer2.upstream.cache.p obj6 = p(string, l2, l3);
                if (obj6.v) {
                }
                return A(string, obj6);
                if (this.c.m(string).i(l2, l3)) {
                }
                return obj6;
                return null;
                throw string;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public com.google.android.exoplayer2.upstream.cache.h f(String string, long l2, long l3) {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                m();
                i = e(string, l2, l3);
                while (i != 0) {
                    wait();
                    i = e(string, l2, l3);
                }
                return i;
                wait();
                throw string;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void g(File file, long l2) {
        int i3;
        boolean z;
        int name;
        int i2;
        long l3;
        int i;
        long l;
        int obj12;
        i2 = 0;
        synchronized (this) {
            try {
                i3 = name;
                i3 = i2;
                g.f(i3);
                if (file.exists() == null) {
                }
                if (Long.compare(l2, i4) == 0) {
                }
                file.delete();
                final com.google.android.exoplayer2.upstream.cache.p obj11 = p.j(file, l2, obj12);
                g.e(obj11);
                obj12 = this.c.g(obj11.a);
                g.e(obj12);
                g.f((i)obj12.g(obj11.b, obj4));
                long l5 = k.d(obj12.c());
                if (Long.compare(l5, i) != 0) {
                }
                if (Long.compare(i, l5) <= 0) {
                } else {
                }
                name = i2;
                g.f(name);
                if (this.d != null) {
                }
                this.d.h(file.getName(), obj11.c, l5);
                l2 = new Cache.CacheException(file);
                throw l2;
                l((p)obj11);
                this.c.s();
                notifyAll();
                l2 = new Cache.CacheException(file);
                throw l2;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public long h() {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                return this.i;
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void i(com.google.android.exoplayer2.upstream.cache.h h) {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                com.google.android.exoplayer2.upstream.cache.i iVar = this.c.g(h.a);
                g.e(iVar);
                (i)iVar.l(h.b);
                this.c.p(iVar.b);
                notifyAll();
                throw h;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public void m() {
        final com.google.android.exoplayer2.upstream.cache.Cache.CacheException exc = this.k;
        synchronized (this) {
            try {
                throw exc;
            }
        }
    }
}
