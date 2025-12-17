package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.room.e1.a;
import androidx.room.e1.b;
import d.b.a.a.a;
import d.s.a.c;
import d.s.a.g;
import d.s.a.h;
import d.s.a.h.c;
import d.s.a.j;
import d.s.a.k;
import d.s.a.l.c;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class u0 {

    @Deprecated
    protected volatile g a;
    private Executor b;
    private Executor c;
    private h d;
    private final androidx.room.m0 e;
    private boolean f;
    @Deprecated
    protected List<androidx.room.u0.b> g;
    protected Map<Class<? extends a>, a> h;
    private final ReentrantReadWriteLock i;
    private androidx.room.z j;
    private final java.lang.ThreadLocal<Integer> k;
    private final Map<String, Object> l;
    private final Map<Class<?>, Object> m;

    public static class a {

        private final Class<T> a;
        private final String b;
        private final Context c;
        private ArrayList<androidx.room.u0.b> d;
        private androidx.room.u0.e e;
        private androidx.room.u0.f f;
        private Executor g;
        private List<Object> h;
        private List<a> i;
        private Executor j;
        private Executor k;
        private h.c l;
        private boolean m;
        private androidx.room.u0.c n;
        private Intent o;
        private boolean p = true;
        private boolean q;
        private long r = -1;
        private TimeUnit s;
        private final androidx.room.u0.d t;
        private Set<Integer> u;
        private Set<Integer> v;
        private String w;
        private File x;
        private Callable<InputStream> y;
        a(Context context, Class<T> class2, String string3) {
            super();
            final int i = -1;
            this.c = context;
            this.a = class2;
            this.b = string3;
            this.n = u0.c.AUTOMATIC;
            int obj3 = 1;
            obj3 = new u0.d();
            this.t = obj3;
        }

        public androidx.room.u0.a<T> a(b... bArr) {
            Object hashSet;
            int i;
            Integer valueOf2;
            Set set;
            Integer valueOf;
            if (this.v == null) {
                hashSet = new HashSet();
                this.v = hashSet;
            }
            i = 0;
            while (i < bArr.length) {
                Object obj = bArr[i];
                this.v.add(Integer.valueOf(obj.a));
                this.v.add(Integer.valueOf(obj.b));
                i++;
            }
            this.t.b(bArr);
            return this;
        }

        public androidx.room.u0.a<T> b() {
            this.m = true;
            return this;
        }

        public T c() {
            Executor executor;
            Object iterator;
            h.c cVar;
            Executor next;
            long b0Var;
            boolean a1Var;
            int i;
            int zVar;
            TimeUnit time;
            int i3;
            Executor executor2;
            int i2;
            Callable callable;
            h.c q0Var;
            final Object obj = this;
            if (obj.c == null) {
            } else {
                if (obj.a == null) {
                } else {
                    executor = obj.j;
                    if (executor == null && obj.k == null) {
                        if (obj.k == null) {
                            executor = a.d();
                            obj.k = executor;
                            obj.j = executor;
                        } else {
                            if (executor != null && obj.k == null) {
                                if (obj.k == null) {
                                    obj.k = executor;
                                } else {
                                    executor = obj.k;
                                    if (executor == null && executor != null) {
                                        executor = obj.k;
                                        if (executor != null) {
                                            obj.j = executor;
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    iterator = obj.v;
                    if (iterator != null && obj.u != null) {
                        if (obj.u != null) {
                            iterator = iterator.iterator();
                            for (Integer next : iterator) {
                            }
                        }
                    }
                    if (obj.l == null) {
                        cVar = new c();
                    }
                    b0Var = obj.r;
                    if (Long.compare(b0Var, i4) > 0) {
                        if (obj.b == null) {
                        } else {
                            zVar = new z(b0Var, a1Var, obj.s, obj.k);
                            b0Var = new b0(cVar, zVar);
                            cVar = b0Var;
                        }
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                        throw illegalArgumentException3;
                    }
                    String str3 = obj.w;
                    if (str3 == null && obj.x == null) {
                        if (obj.x == null) {
                            if (obj.y != null) {
                                if (obj.b == null) {
                                } else {
                                    i = 0;
                                    zVar = 1;
                                    i3 = str3 == null ? i : zVar;
                                    executor2 = obj.x;
                                    i2 = executor2 == null ? i : zVar;
                                    callable = obj.y;
                                    if (callable == null) {
                                    } else {
                                        i = zVar;
                                    }
                                    if (i5 += i != zVar) {
                                    } else {
                                        a1Var = new a1(str3, executor2, callable, cVar);
                                        cVar = a1Var;
                                        androidx.room.u0.f fVar = obj.f;
                                        if (fVar != null) {
                                            a1Var = new q0(cVar, fVar, obj.g);
                                            q0Var = a1Var;
                                        } else {
                                            q0Var = cVar;
                                        }
                                    }
                                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                                    throw illegalArgumentException5;
                                }
                            } else {
                            }
                            Context context2 = obj.c;
                            super(context2, obj.b, q0Var, obj.t, obj.d, obj.m, obj.n.resolve(context2), obj.j, obj.k, obj.o, obj.p, obj.q, obj.u, obj.w, obj.x, obj.y, obj.e, obj.h, obj.i);
                            Object obj2 = t0.b(obj.a, "_Impl");
                            (u0)obj2.q(e0Var);
                            return obj2;
                        } else {
                        }
                    } else {
                    }
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    throw illegalArgumentException4;
                }
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
                throw illegalArgumentException6;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot provide null context for the database.");
            throw illegalArgumentException;
        }

        public androidx.room.u0.a<T> d(String string) {
            this.w = string;
            return this;
        }

        public androidx.room.u0.a<T> e() {
            this.p = false;
            this.q = true;
            return this;
        }

        public androidx.room.u0.a<T> f() {
            final int i = 1;
            this.p = i;
            this.q = i;
            return this;
        }
    }

    public static abstract class b {
        public void a(g g) {
        }

        public void b(g g) {
        }

        public void c(g g) {
        }
    }

    public static enum c {

        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;
        private static boolean isLowRamDevice(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return c.b(activityManager);
            }
            return 0;
        }

        @Override // java.lang.Enum
        androidx.room.u0.c resolve(Context context) {
            int sDK_INT;
            Object obj3;
            if (this != u0.c.AUTOMATIC) {
                return this;
            }
            obj3 = context.getSystemService("activity");
            if (Build.VERSION.SDK_INT >= 16 && obj3 != null && !u0.c.isLowRamDevice((ActivityManager)obj3)) {
                obj3 = context.getSystemService("activity");
                if ((ActivityManager)obj3 != null) {
                    if (!u0.c.isLowRamDevice((ActivityManager)obj3)) {
                        return u0.c.WRITE_AHEAD_LOGGING;
                    }
                }
            }
            return u0.c.TRUNCATE;
        }
    }

    public static class d {

        private HashMap<Integer, TreeMap<Integer, b>> a;
        public d() {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
        }

        private void a(b b) {
            int valueOf;
            Object string;
            Object treeMap;
            Object valueOf2;
            String str;
            valueOf = b.a;
            final int i = b.b;
            if ((TreeMap)this.a.get(Integer.valueOf(valueOf)) == null) {
                treeMap = new TreeMap();
                this.a.put(Integer.valueOf(valueOf), treeMap);
            }
            string = treeMap.get(Integer.valueOf(i));
            if ((b)string != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Overriding migration ");
                stringBuilder.append((b)string);
                stringBuilder.append(" with ");
                stringBuilder.append(b);
                Log.w("ROOM", stringBuilder.toString());
            }
            treeMap.put(Integer.valueOf(i), b);
        }

        private List<b> d(List<b> list, boolean z2, int i3, int i4) {
            Object descendingKeySet;
            int intValue;
            int i2;
            int i;
            int obj9;
            while (z2) {
                Object obj = this.a.get(Integer.valueOf(i3));
                int i5 = 0;
                if (z2) {
                } else {
                }
                descendingKeySet = (TreeMap)obj.keySet();
                Iterator iterator = descendingKeySet.iterator();
                while (iterator.hasNext()) {
                    intValue = (Integer)iterator.next().intValue();
                    if (z2) {
                    } else {
                    }
                    if (intValue >= i4) {
                    }
                    if (intValue < i3) {
                    }
                    i = i2;
                    if (intValue <= i4 && intValue > i3) {
                    }
                    if (intValue > i3) {
                    }
                }
                i2 = i;
                intValue = (Integer)iterator.next().intValue();
                if (z2) {
                } else {
                }
                if (intValue >= i4) {
                }
                if (i != 0) {
                } else {
                }
                list.add((b)obj.get(Integer.valueOf(intValue)));
                obj9 = intValue;
                if (intValue < i3) {
                }
                i = i2;
                if (intValue <= i4 && intValue > i3) {
                }
                if (intValue > i3) {
                }
                descendingKeySet = obj.descendingKeySet();
            }
            return list;
        }

        public void b(b... bArr) {
            int i;
            Object obj;
            i = 0;
            while (i < bArr.length) {
                a(bArr[i]);
                i++;
            }
        }

        public List<b> c(int i, int i2) {
            int i3;
            if (i == i2) {
                return Collections.emptyList();
            }
            i3 = i2 > i ? 1 : 0;
            ArrayList arrayList = new ArrayList();
            return d(arrayList, i3, i, i2);
        }

        public Map<Integer, Map<Integer, b>> e() {
            return Collections.unmodifiableMap(this.a);
        }
    }

    public static abstract class e {
        public abstract void a(g g);
    }

    public interface f {
        public abstract void a(String string, List<Object> list2);
    }
    public u0() {
        super();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.i = reentrantReadWriteLock;
        ThreadLocal threadLocal = new ThreadLocal();
        this.k = threadLocal;
        HashMap hashMap = new HashMap();
        this.l = Collections.synchronizedMap(hashMap);
        this.e = e();
        HashMap hashMap2 = new HashMap();
        this.m = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.h = hashMap3;
    }

    private <T> T D(Class<T> class, h h2) {
        if (class.isInstance(h2)) {
            return h2;
        }
        if (h2 instanceof f0) {
            return D(class, (f0)h2.getDelegate());
        }
        return 0;
    }

    private void r() {
        int sDK_INT;
        a();
        g writableDatabase = this.d.getWritableDatabase();
        this.e.p(writableDatabase);
        if (Build.VERSION.SDK_INT >= 16 && writableDatabase.F1()) {
            if (writableDatabase.F1()) {
                writableDatabase.x0();
            } else {
                writableDatabase.beginTransaction();
            }
        } else {
        }
    }

    private void s() {
        boolean z;
        this.d.getWritableDatabase().endTransaction();
        if (!p()) {
            this.e.h();
        }
    }

    private static boolean u() {
        int i;
        i = Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0;
        return i;
    }

    private Object w(g g) {
        r();
        return null;
    }

    private Object y(g g) {
        s();
        return null;
    }

    public Cursor A(j j) {
        return B(j, 0);
    }

    public Cursor B(j j, CancellationSignal cancellationSignal2) {
        int sDK_INT;
        int i;
        a();
        b();
        if (cancellationSignal2 != null && Build.VERSION.SDK_INT >= 16) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.d.getWritableDatabase().f0(j, cancellationSignal2);
            }
        }
        return this.d.getWritableDatabase().j1(j);
    }

    @Deprecated
    public void C() {
        this.d.getWritableDatabase().setTransactionSuccessful();
    }

    public void a() {
        if (this.f) {
        }
        if (u0.u()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        throw illegalStateException;
    }

    public void b() {
        boolean z;
        if (!p()) {
            if (this.k.get() != null) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
            throw illegalStateException;
        }
    }

    @Deprecated
    public void c() {
        androidx.room.t tVar;
        a();
        final androidx.room.z zVar = this.j;
        if (zVar == null) {
            r();
        } else {
            tVar = new t(this);
            zVar.c(tVar);
        }
    }

    public k d(String string) {
        a();
        b();
        return this.d.getWritableDatabase().O(string);
    }

    protected abstract androidx.room.m0 e();

    protected abstract h f(androidx.room.e0 e0);

    @Deprecated
    public void g() {
        androidx.room.u uVar;
        final androidx.room.z zVar = this.j;
        if (zVar == null) {
            s();
        } else {
            uVar = new u(this);
            zVar.c(uVar);
        }
    }

    public List<b> h(Map<Class<? extends a>, a> map) {
        return Collections.emptyList();
    }

    Map<String, Object> i() {
        return this.l;
    }

    Lock j() {
        return this.i.readLock();
    }

    public h k() {
        return this.d;
    }

    public Executor l() {
        return this.b;
    }

    public Set<Class<? extends a>> m() {
        return Collections.emptySet();
    }

    protected Map<Class<?>, List<Class<?>>> n() {
        return Collections.emptyMap();
    }

    public Executor o() {
        return this.c;
    }

    public boolean p() {
        return this.d.getWritableDatabase().q1();
    }

    public void q(androidx.room.e0 e0) {
        int i2;
        Object obj2;
        int sDK_INT;
        int i3;
        BitSet bitSet;
        Object hVar;
        int wRITE_AHEAD_LOGGING;
        Object executor;
        Object next2;
        boolean iterator;
        boolean next;
        Object obj;
        int i;
        Map map;
        int assignableFrom;
        List key;
        int i5;
        Integer valueOf;
        Object obj3;
        int i4;
        Map assignableFrom2;
        List list;
        this.d = f(e0);
        bitSet = new BitSet();
        Iterator iterator2 = m().iterator();
        assignableFrom = 1;
        for (Class next2 : iterator2) {
            size3 -= assignableFrom;
            while (i5 >= 0) {
                if (next2.isAssignableFrom(e0.h.get(i5).getClass()) != 0) {
                    break loop_3;
                } else {
                }
                i5--;
            }
            this.h.put(next2, (a)e0.h.get(i));
            assignableFrom = 1;
            if (next2.isAssignableFrom(e0.h.get(i5).getClass()) != 0) {
            } else {
            }
            i5--;
            bitSet.set(i5);
            i = i5;
        }
        size -= assignableFrom;
        while (i2 >= 0) {
            i2--;
        }
        Iterator iterator3 = h(this.h).iterator();
        while (iterator3.hasNext()) {
            bitSet = iterator3.next();
            if (!e0.d.e().containsKey(Integer.valueOf(bitSet.a))) {
            }
            valueOf = new b[assignableFrom];
            valueOf[false] = (b)bitSet;
            e0.d.b(valueOf);
        }
        Object obj5 = D(z0.class, this.d);
        if ((z0)obj5 != null) {
            (z0)obj5.f(e0);
        }
        obj2 = D(a0.class, this.d);
        if ((a0)obj2 != null) {
            obj2 = (a0)obj2.a();
            this.j = obj2;
            this.e.k(obj2);
        }
        if (Build.VERSION.SDK_INT >= 16 && e0.j == u0.c.WRITE_AHEAD_LOGGING) {
            if (e0.j == u0.c.WRITE_AHEAD_LOGGING) {
                iterator = assignableFrom;
            }
            this.d.setWriteAheadLoggingEnabled(iterator);
        }
        this.g = e0.e;
        this.b = e0.k;
        d1 d1Var = new d1(e0.l);
        this.c = d1Var;
        this.f = e0.i;
        Intent intent = e0.n;
        if (intent != null) {
            this.e.l(e0.b, e0.c, intent);
        }
        BitSet bitSet2 = new BitSet();
        Iterator iterator4 = n().entrySet().iterator();
        for (Map.Entry next4 : iterator4) {
            iterator = (List)next4.getValue().iterator();
            for (Class valueOf : iterator) {
                size4 -= assignableFrom;
                while (i4 >= 0) {
                    i4--;
                }
                i4 = i;
                this.m.put(valueOf, e0.g.get(i4));
                if (valueOf.isAssignableFrom(e0.g.get(i4).getClass())) {
                } else {
                }
                i4--;
                bitSet2.set(i4);
            }
            valueOf = iterator.next();
            size4 -= assignableFrom;
            while (i4 >= 0) {
                i4--;
            }
            i4 = i;
            this.m.put(valueOf, e0.g.get(i4));
            if (valueOf.isAssignableFrom(e0.g.get(i4).getClass())) {
            } else {
            }
            i4--;
            bitSet2.set(i4);
        }
        size2 -= assignableFrom;
        while (i3 >= 0) {
            i3--;
        }
    }

    protected void t(g g) {
        this.e.e(g);
    }

    public boolean v() {
        g open;
        int i;
        androidx.room.z zVar = this.j;
        if (zVar != null) {
            return zVar.g();
        }
        open = this.a;
        if (open != null && open.isOpen()) {
            i = open.isOpen() ? 1 : 0;
        } else {
        }
        return i;
    }

    public Object x(g g) {
        return w(g);
    }

    public Object z(g g) {
        return y(g);
    }
}
