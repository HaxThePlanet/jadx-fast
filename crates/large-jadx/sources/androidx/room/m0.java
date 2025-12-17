package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.util.Log;
import d.b.a.b.b;
import d.s.a.a;
import d.s.a.g;
import d.s.a.h;
import d.s.a.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class m0 {

    private static final String[] l;
    final HashMap<String, Integer> a;
    final String[] b;
    private Map<String, Set<String>> c;
    androidx.room.z d = null;
    final androidx.room.u0 e;
    AtomicBoolean f;
    private volatile boolean g = false;
    volatile k h;
    private androidx.room.m0.b i;
    final b<androidx.room.m0.c, androidx.room.m0.d> j;
    Runnable k;

    class a implements Runnable {

        final androidx.room.m0 a;
        a(androidx.room.m0 m0) {
            this.a = m0;
            super();
        }

        private Set<Integer> a() {
            boolean empty;
            a valueOf;
            HashSet hashSet = new HashSet();
            valueOf = new a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;");
            Cursor cursor = m0Var.e.A(valueOf);
            while (cursor.moveToNext()) {
                hashSet.add(Integer.valueOf(cursor.getInt(0)));
            }
            cursor.close();
            if (!hashSet.isEmpty()) {
                m0Var2.h.N();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.room.z empty;
            Throwable th;
            g writableDatabase;
            int value;
            int i;
            Lock lock = m0Var2.e.j();
            lock.lock();
            int i2 = 0;
            lock.unlock();
            androidx.room.z zVar = m0Var3.d;
            if (!this.a.d() && zVar != null) {
                lock.unlock();
                zVar = m0Var3.d;
                if (zVar != null) {
                    zVar.b();
                }
            }
            lock.unlock();
            androidx.room.z zVar2 = m0Var4.d;
            if (!m0Var9.f.compareAndSet(true, false) && zVar2 != null) {
                lock.unlock();
                zVar2 = m0Var4.d;
                if (zVar2 != null) {
                    zVar2.b();
                }
            }
            lock.unlock();
            androidx.room.z zVar3 = m0Var5.d;
            if (m0Var10.e.p() && zVar3 != null) {
                lock.unlock();
                zVar3 = m0Var5.d;
                if (zVar3 != null) {
                    zVar3.b();
                }
            }
            try {
                writableDatabase = m0Var11.e.k().getWritableDatabase();
                writableDatabase.x0();
                Set set = a();
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                lock.unlock();
                empty = m0Var6.d;
                if (empty != null) {
                }
                empty.b();
                th.endTransaction();
                throw str;
            } catch (Throwable th) {
            }
            if (set != null && !set.isEmpty()) {
                if (!set.isEmpty()) {
                    empty = m0Var7.j;
                    writableDatabase = m0Var12.j.iterator();
                    synchronized (empty) {
                        for (Map.Entry next : writableDatabase) {
                            (m0.d)next.getValue().a(set);
                        }
                    }
                }
            }
        }
    }

    static class b {

        final long[] a;
        final boolean[] b;
        final int[] c;
        boolean d;
        boolean e;
        b(int i) {
            super();
            final long[] lArr = new long[i];
            this.a = lArr;
            final boolean[] zArr = new boolean[i];
            this.b = zArr;
            this.c = new int[i];
            Arrays.fill(lArr, 0);
            Arrays.fill(zArr, false);
        }

        int[] a() {
            boolean z;
            int i3;
            int i2;
            int i4;
            boolean[] zArr;
            int[] iArr;
            int i;
            synchronized (this) {
                try {
                    if (this.e) {
                    } else {
                    }
                    final int i6 = 0;
                    i3 = i6;
                    i2 = 1;
                    while (i3 < lArr.length) {
                        if (Long.compare(l, i) > 0) {
                        } else {
                        }
                        i4 = i6;
                        zArr = this.b;
                        if (i4 != zArr[i3]) {
                        } else {
                        }
                        this.c[i3] = i6;
                        zArr[i3] = i4;
                        i3++;
                        i2 = 1;
                        if (i4 != 0) {
                        } else {
                        }
                        i2 = 2;
                        this.c[i3] = i2;
                        i4 = i2;
                    }
                    if (Long.compare(l, i) > 0) {
                    } else {
                    }
                    i4 = i2;
                    i4 = i6;
                    zArr = this.b;
                    if (i4 != zArr[i3]) {
                    } else {
                    }
                    if (i4 != 0) {
                    } else {
                    }
                    i2 = 2;
                    this.c[i3] = i2;
                    this.c[i3] = i6;
                    zArr[i3] = i4;
                    i3++;
                    this.e = i2;
                    this.d = i6;
                    return this.c;
                    return null;
                    throw th;
                }
            }
        }

        boolean b(int... iArr) {
            int i;
            int i2;
            int cmp;
            int i3;
            long l;
            int i4;
            i2 = i;
            synchronized (this) {
                try {
                    while (i < iArr.length) {
                        int i5 = iArr[i];
                        long[] lArr = this.a;
                        l = lArr[i5];
                        lArr[i5] = i7 += l;
                        i3 = 1;
                        if (Long.compare(l, i6) == 0) {
                        }
                        i++;
                        this.d = i3;
                        i2 = i3;
                    }
                    i5 = iArr[i];
                    lArr = this.a;
                    l = lArr[i5];
                    lArr[i5] = i7 += l;
                    i3 = 1;
                    if (Long.compare(l, i6) == 0) {
                    }
                    this.d = i3;
                    i2 = i3;
                    i++;
                    return i2;
                    throw iArr;
                }
            }
        }

        boolean c(int... iArr) {
            int i;
            int i2;
            int cmp;
            int i3;
            long l;
            int i4;
            int i5;
            i2 = i;
            synchronized (this) {
                try {
                    while (i < iArr.length) {
                        int i6 = iArr[i];
                        long[] lArr = this.a;
                        l = lArr[i6];
                        i4 = 1;
                        lArr[i6] = l - i4;
                        i3 = 1;
                        if (Long.compare(l, i4) == 0) {
                        }
                        i++;
                        this.d = i3;
                        i2 = i3;
                    }
                    i6 = iArr[i];
                    lArr = this.a;
                    l = lArr[i6];
                    i4 = 1;
                    lArr[i6] = l - i4;
                    i3 = 1;
                    if (Long.compare(l, i4) == 0) {
                    }
                    this.d = i3;
                    i2 = i3;
                    i++;
                    return i2;
                    throw iArr;
                }
            }
        }

        void d() {
            this.e = false;
            return;
            synchronized (this) {
                this.e = false;
            }
        }

        void e() {
            Arrays.fill(this.b, false);
            this.d = true;
            return;
            synchronized (this) {
                Arrays.fill(this.b, false);
                this.d = true;
            }
        }
    }

    public static abstract class c {

        final String[] a;
        public c(String[] stringArr) {
            super();
            this.a = (String[])Arrays.copyOf(stringArr, stringArr.length);
        }

        boolean a() {
            return 0;
        }

        public abstract void b(Set<String> set);
    }

    static class d {

        final int[] a;
        private final String[] b;
        final androidx.room.m0.c c;
        private final Set<String> d = null;
        d(androidx.room.m0.c m0$c, int[] i2Arr2, String[] string3Arr3) {
            Set obj1;
            String obj2;
            super();
            this.c = c;
            this.a = i2Arr2;
            this.b = string3Arr3;
            if (i2Arr2.length == 1) {
                obj1 = new HashSet();
                obj1.add(string3Arr3[0]);
                this.d = Collections.unmodifiableSet(obj1);
            } else {
                obj1 = 0;
            }
        }

        void a(Set<Integer> set) {
            int hashSet;
            int i;
            boolean contains;
            androidx.room.m0.c obj5;
            int length = iArr.length;
            hashSet = 0;
            i = 0;
            while (i < length) {
                if (set.contains(Integer.valueOf(this.a[i]))) {
                }
                i++;
                if (length == 1) {
                } else {
                }
                if (hashSet == null) {
                }
                hashSet.add(this.b[i]);
                hashSet = new HashSet(length);
                hashSet = this.d;
            }
            if (hashSet != null) {
                this.c.b(hashSet);
            }
        }

        void b(String[] stringArr) {
            HashSet hashSet;
            int length;
            int i2;
            int equalsIgnoreCase2;
            Object obj;
            String[] strArr;
            int length2;
            int i;
            String str;
            boolean equalsIgnoreCase;
            int obj12;
            final int i3 = 0;
            i2 = 0;
            if (strArr2.length == 1) {
                length = i3;
                while (length < stringArr.length) {
                    if (stringArr[length].equalsIgnoreCase(this.b[i3])) {
                        break;
                    } else {
                    }
                    length++;
                }
            } else {
                hashSet = new HashSet();
                equalsIgnoreCase2 = i3;
                while (equalsIgnoreCase2 < stringArr.length) {
                    strArr = this.b;
                    i = i3;
                    while (i < strArr.length) {
                        str = strArr[i];
                        if (str.equalsIgnoreCase(stringArr[equalsIgnoreCase2])) {
                            break loop_9;
                        } else {
                        }
                        i++;
                    }
                    equalsIgnoreCase2++;
                    str = strArr[i];
                    if (str.equalsIgnoreCase(obj)) {
                    } else {
                    }
                    i++;
                    hashSet.add(str);
                }
                if (hashSet.size() > 0) {
                    i2 = hashSet;
                }
            }
            if (i2 != 0) {
                this.c.b(i2);
            }
        }
    }
    static {
        m0.l = /* result */;
    }

    public m0(androidx.room.u0 u0, Map<String, String> map2, Map<String, Set<String>> map3, String... string4Arr4) {
        HashMap lowerCase;
        int i;
        int length;
        Integer valueOf;
        Object obj6;
        String[] obj7;
        Object obj8;
        super();
        int i2 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.f = atomicBoolean;
        b bVar = new b();
        this.j = bVar;
        m0.a aVar = new m0.a(this);
        this.k = aVar;
        this.e = u0;
        m0.b bVar2 = new m0.b(string4Arr4.length);
        this.i = bVar2;
        lowerCase = new HashMap();
        this.a = lowerCase;
        this.c = map3;
        obj7 = new l0(u0);
        int obj5 = string4Arr4.length;
        this.b = new String[obj5];
        while (i < obj5) {
            Locale uS = Locale.US;
            obj7 = string4Arr4[i].toLowerCase(uS);
            this.a.put(obj7, Integer.valueOf(i));
            length = map2.get(string4Arr4[i]);
            if ((String)length != 0) {
            } else {
            }
            this.b[i] = obj7;
            i++;
            this.b[i] = (String)length.toLowerCase(uS);
        }
        obj5 = map2.entrySet().iterator();
        while (obj5.hasNext()) {
            obj6 = obj5.next();
            obj8 = Locale.US;
            obj7 = (String)(Map.Entry)obj6.getValue().toLowerCase(obj8);
            if (this.a.containsKey(obj7) != null) {
            }
            obj8 = this.a;
            obj8.put((String)obj6.getKey().toLowerCase(obj8), (Integer)obj8.get(obj7));
        }
    }

    private static void b(StringBuilder stringBuilder, String string2, String string3) {
        final String str = "`";
        stringBuilder.append(str);
        stringBuilder.append("room_table_modification_trigger_");
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(string3);
        stringBuilder.append(str);
    }

    private static void c(g g) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 16 && g.F1()) {
            if (g.F1()) {
                g.x0();
            } else {
                g.beginTransaction();
            }
        } else {
        }
    }

    private String[] j(String[] stringArr) {
        int i;
        Object obj;
        String lowerCase;
        boolean key;
        HashSet hashSet = new HashSet();
        i = 0;
        while (i < stringArr.length) {
            obj = stringArr[i];
            lowerCase = obj.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
            } else {
            }
            hashSet.add(obj);
            i++;
            hashSet.addAll((Collection)this.c.get(lowerCase));
        }
        return (String[])hashSet.toArray(new String[hashSet.size()]);
    }

    private void m(g g, int i2) {
        int i;
        String string;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
        stringBuilder.append(i2);
        stringBuilder.append(", 0)");
        g.C(stringBuilder.toString());
        String str2 = this.b[i2];
        StringBuilder stringBuilder2 = new StringBuilder();
        final String[] strArr2 = m0.l;
        final int i3 = 0;
        i = i3;
        while (i < strArr2.length) {
            String str5 = strArr2[i];
            stringBuilder2.setLength(i3);
            stringBuilder2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            m0.b(stringBuilder2, str2, str5);
            stringBuilder2.append(" AFTER ");
            stringBuilder2.append(str5);
            stringBuilder2.append(" ON `");
            stringBuilder2.append(str2);
            stringBuilder2.append("` BEGIN UPDATE ");
            stringBuilder2.append("room_table_modification_log");
            stringBuilder2.append(" SET ");
            String str10 = "invalidated";
            stringBuilder2.append(str10);
            stringBuilder2.append(" = 1");
            stringBuilder2.append(" WHERE ");
            stringBuilder2.append("table_id");
            stringBuilder2.append(" = ");
            stringBuilder2.append(i2);
            stringBuilder2.append(" AND ");
            stringBuilder2.append(str10);
            stringBuilder2.append(" = 0");
            stringBuilder2.append("; END");
            g.C(stringBuilder2.toString());
            i++;
        }
    }

    private void n(g g, int i2) {
        int i;
        String string;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        final String[] strArr2 = m0.l;
        final int i3 = 0;
        i = i3;
        while (i < strArr2.length) {
            stringBuilder.setLength(i3);
            stringBuilder.append("DROP TRIGGER IF EXISTS ");
            m0.b(stringBuilder, this.b[i2], strArr2[i]);
            g.C(stringBuilder.toString());
            i++;
        }
    }

    public void a(androidx.room.m0.c m0$c) {
        int i;
        int intValue;
        String lowerCase;
        Locale locale;
        Object obj8;
        String[] strArr2 = j(c.a);
        int[] iArr = new int[strArr2.length];
        i = 0;
        while (i < strArr2.length) {
            Object obj = this.a.get(strArr2[i].toLowerCase(Locale.US));
            iArr[i] = (Integer)obj.intValue();
            i++;
        }
        m0.d dVar = new m0.d(c, iArr, strArr2);
        b bVar = this.j;
        synchronized (bVar) {
            dVar = new m0.d(c, iArr, strArr2);
            bVar = this.j;
        }
        if (this.i.b(iArr)) {
            o();
        }
    }

    boolean d() {
        boolean z;
        final int i2 = 0;
        if (!this.e.v()) {
            return i2;
        }
        if (!this.g) {
            this.e.k().getWritableDatabase();
        }
        if (!this.g) {
            Log.e("ROOM", "database is not initialized even though it is open");
            return i2;
        }
        return 1;
    }

    void e(g g) {
        synchronized (this) {
            try {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                g.C("PRAGMA temp_store = MEMORY;");
                g.C("PRAGMA recursive_triggers='ON';");
                g.C("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                p(g);
                this.h = g.O("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                this.g = true;
                throw g;
            }
        }
    }

    public void f(String... stringArr) {
        Object value;
        boolean z;
        final b bVar = this.j;
        Iterator iterator = this.j.iterator();
        synchronized (bVar) {
            while (iterator.hasNext()) {
                value = iterator.next();
                if (!(m0.c)(Map.Entry)value.getKey().a()) {
                }
                (m0.d)value.getValue().b(stringArr);
            }
        }
    }

    void g() {
        this.g = false;
        this.i.e();
        return;
        synchronized (this) {
            this.g = false;
            this.i.e();
        }
    }

    public void h() {
        boolean compareAndSet;
        int i;
        androidx.room.z zVar = this.d;
        if (this.f.compareAndSet(false, true) && zVar != null) {
            zVar = this.d;
            if (zVar != null) {
                zVar.e();
            }
            this.e.l().execute(this.k);
        }
    }

    public void i(androidx.room.m0.c m0$c) {
        Object bVar;
        Object obj3;
        bVar = this.j;
        obj3 = this.j.m(c);
        synchronized (bVar) {
            bVar = this.j;
            obj3 = this.j.m(c);
        }
        if (this.i.c(obj3.a)) {
            o();
        }
        try {
            throw c;
        }
    }

    void k(androidx.room.z z) {
        this.d = z;
        x xVar = new x(this);
        z.h(xVar);
    }

    void l(Context context, String string2, Intent intent3) {
        n0 n0Var = new n0(context, string2, intent3, this, this.e.l());
    }

    void o() {
        if (!this.e.v()) {
        }
        p(this.e.k().getWritableDatabase());
    }

    void p(g g) {
        boolean z;
        Object str;
        int length;
        int i2;
        int i;
        int i3;
        if (g.q1()) {
        }
        z = this.e.j();
        z.lock();
        int[] iArr = this.i.a();
        while (iArr == null) {
            m0.c(g);
            i2 = 0;
            while (i2 < iArr.length) {
                i = iArr[i2];
                if (i != 1) {
                } else {
                }
                m(g, i2);
                i2++;
                if (i != 2) {
                } else {
                }
                n(g, i2);
            }
            g.setTransactionSuccessful();
            g.endTransaction();
            this.i.d();
            z.unlock();
            z = this.e.j();
            z.lock();
            iArr = this.i.a();
            i = iArr[i2];
            if (i != 1) {
            } else {
            }
            m(g, i2);
            i2++;
            if (i != 2) {
            } else {
            }
            n(g, i2);
        }
        z.unlock();
    }
}
