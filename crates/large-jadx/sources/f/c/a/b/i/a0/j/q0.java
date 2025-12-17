package f.c.a.b.i.a0.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import com.google.android.datatransport.runtime.synchronization.a.a;
import f.c.a.b.b;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.c0.a;
import f.c.a.b.i.i;
import f.c.a.b.i.j;
import f.c.a.b.i.j.a;
import f.c.a.b.i.p;
import f.c.a.b.i.p.a;
import f.c.a.b.i.w.a;
import f.c.a.b.i.x.a.a;
import f.c.a.b.i.x.a.a.a;
import f.c.a.b.i.x.a.b;
import f.c.a.b.i.x.a.b.a;
import f.c.a.b.i.x.a.c;
import f.c.a.b.i.x.a.c.a;
import f.c.a.b.i.x.a.c.b;
import f.c.a.b.i.x.a.d;
import f.c.a.b.i.x.a.d.a;
import f.c.a.b.i.x.a.e;
import f.c.a.b.i.x.a.e.a;
import f.c.a.b.i.x.a.f;
import f.c.a.b.i.x.a.f.a;
import f.c.a.b.i.y.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class q0 implements f.c.a.b.i.a0.j.i0, a, f.c.a.b.i.a0.j.h0 {

    private static final b x;
    private final f.c.a.b.i.a0.j.s0 a;
    private final a b;
    private final a c;
    private final f.c.a.b.i.a0.j.j0 v;
    private final a<String> w;

    static class a {
    }

    interface b {
        public abstract U apply(T t);
    }

    private static class c {

        final String a;
        final String b;
        private c(String string, String string2) {
            super();
            this.a = string;
            this.b = string2;
        }

        c(String string, String string2, f.c.a.b.i.a0.j.q0.a q0$a3) {
            super(string, string2);
        }
    }

    interface d {
        public abstract T a();
    }
    static {
        q0.x = b.b("proto");
    }

    q0(a a, a a2, f.c.a.b.i.a0.j.j0 j03, f.c.a.b.i.a0.j.s0 s04, a<String> a5) {
        super();
        this.a = s04;
        this.b = a;
        this.c = a2;
        this.v = j03;
        this.w = a5;
    }

    private a A0(Map map, a.a a$a2, Cursor cursor3) {
        boolean arrayList;
        while (cursor3.moveToNext()) {
            String string = cursor3.getString(0);
            if (!map.containsKey(string)) {
            }
            c.a aVar = c.c();
            aVar.c(f(cursor3.getInt(1)));
            aVar.b(cursor3.getLong(2));
            (List)map.get(string).add(aVar.a());
            arrayList = new ArrayList();
            map.put(string, arrayList);
        }
        x1(a2, map);
        a2.e(r());
        a2.d(n());
        a2.c((String)this.w.get());
        return a2.b();
    }

    private <T> T A1(f.c.a.b.i.a0.j.q0.d<T> q0$d, f.c.a.b.i.a0.j.q0.b<Throwable, T> q0$b2) {
        Throwable th;
        long time = this.c.getTime();
        return d.a();
    }

    private static b B1(String string) {
        if (string == null) {
            return q0.x;
        }
        return b.b(string);
    }

    private boolean E() {
        int i;
        i = Long.compare(i2, l3) >= 0 ? 1 : 0;
        return i;
    }

    private static String E1(Iterable<f.c.a.b.i.a0.j.p0> iterable) {
        String next;
        StringBuilder stringBuilder = new StringBuilder("(");
        Iterator obj3 = iterable.iterator();
        while (obj3.hasNext()) {
            stringBuilder.append((p0)obj3.next().c());
            if (obj3.hasNext() != null) {
            }
            stringBuilder.append(',');
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    private List<f.c.a.b.i.a0.j.p0> F(List<f.c.a.b.i.a0.j.p0> list, Map<Long, Set<f.c.a.b.i.a0.j.q0.c>> map2) {
        Object next;
        boolean key;
        long l;
        long next2;
        String str;
        final ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            next = listIterator.next();
            if (!map2.containsKey(Long.valueOf((p0)next.c()))) {
            } else {
            }
            j.a aVar = next.b().l();
            Iterator iterator = (Set)map2.get(Long.valueOf(next.c())).iterator();
            next2 = iterator.hasNext();
            for (q0.c next4 : iterator) {
                aVar.c(next4.a, next4.b);
                next2 = iterator.hasNext();
            }
            listIterator.set(p0.a(next.c(), next2, next.d()));
            Object next4 = iterator.next();
            aVar.c(next4.a, next4.b);
        }
        return list;
    }

    private a G0(String string, Map map2, a.a a$a3, SQLiteDatabase sQLiteDatabase4) {
        t obj5 = new t(this, map2, a3);
        return (a)q0.G1(sQLiteDatabase4.rawQuery(string, new String[0]), obj5);
    }

    static <T> T G1(Cursor cursor, f.c.a.b.i.a0.j.q0.b<Cursor, T> q0$b2) {
        try {
            cursor.close();
            return b2.apply(cursor);
            cursor.close();
            throw b2;
        }
    }

    private Object H(Cursor cursor) {
        while (cursor.moveToNext()) {
            e((long)int, obj3, c.b.MESSAGE_TOO_OLD);
        }
        return null;
    }

    private Object J0(List list, p p2, Cursor cursor3) {
        int i;
        i iVar;
        int valueOf;
        b bVar;
        byte[] blob;
        while (cursor3.moveToNext()) {
            final long long = cursor3.getLong(0);
            int i3 = 1;
            if (cursor3.getInt(7) != 0) {
            }
            j.a aVar = j.a();
            aVar.j(cursor3.getString(i3));
            aVar.i(cursor3.getLong(2));
            aVar.k(cursor3.getLong(3));
            int i6 = 4;
            if (i != 0) {
            } else {
            }
            iVar = new i(q0.B1(cursor3.getString(i6)), z1(long));
            aVar.h(iVar);
            valueOf = 6;
            if (!cursor3.isNull(valueOf)) {
            }
            list.add(p0.a(long, obj2, p2));
            aVar.g(Integer.valueOf(cursor3.getInt(valueOf)));
            iVar = new i(q0.B1(cursor3.getString(i6)), cursor3.getBlob(5));
            aVar.h(iVar);
            i = i3;
        }
        return null;
    }

    private Integer K(long l, SQLiteDatabase sQLiteDatabase2) {
        String[] strArr = new String[1];
        j obj3 = new j(this);
        q0.G1(obj4.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", String.valueOf(l)), obj3);
        return Integer.valueOf(obj4.delete("events", "timestamp_ms < ?", strArr));
    }

    static Object M(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    static Object N0(Map map, Cursor cursor2) {
        Object hashSet;
        long valueOf;
        final int i2 = 0;
        while (cursor2.moveToNext()) {
            valueOf = cursor2.getLong(0);
            if ((Set)map.get(Long.valueOf(valueOf)) == null) {
            }
            q0.c cVar = new q0.c(cursor2.getString(1), cursor2.getString(2), i2);
            hashSet.add(cVar);
            i2 = 0;
            hashSet = new HashSet();
            map.put(Long.valueOf(valueOf), hashSet);
        }
        return i2;
    }

    private Long Q0(j j, p p2, SQLiteDatabase sQLiteDatabase3) {
        byte[] bArr;
        byte[] contentValues;
        int str3;
        int str;
        int i;
        double contentValues2;
        String str2;
        String str4;
        int obj13;
        if (E()) {
            obj13 = 1;
            e(obj13, sQLiteDatabase3, c.b.CACHE_FULL);
            return Long.valueOf(-1);
        }
        obj13 = this.v.e();
        contentValues = j.e().a();
        str = 0;
        str3 = contentValues.length <= obj13 ? i : str;
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("context_id", Long.valueOf(j(sQLiteDatabase3, p2)));
        String str10 = "transport_name";
        contentValues3.put(str10, j.j());
        String str11 = "timestamp_ms";
        contentValues3.put(str11, Long.valueOf(j.f()));
        contentValues3.put("uptime_ms", Long.valueOf(j.k()));
        contentValues3.put("payload_encoding", j.e().b().a());
        contentValues3.put("code", j.d());
        contentValues3.put("num_attempts", Integer.valueOf(str));
        contentValues3.put("inline", Boolean.valueOf(str3));
        bArr = str3 != null ? contentValues : new byte[str];
        contentValues3.put("payload", bArr);
        int i2 = 0;
        long insert = sQLiteDatabase3.insert("events", i2, contentValues3);
        String str8 = "event_id";
        if (str3 == null) {
            while (i <= (int)ceil) {
                contentValues2 = new ContentValues();
                contentValues2.put(str8, Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", Arrays.copyOfRange(contentValues, i4 *= obj13, Math.min(i * obj13, contentValues.length)));
                sQLiteDatabase3.insert("event_payloads", i2, contentValues2);
                i++;
            }
        }
        Iterator obj12 = j.i().entrySet().iterator();
        for (Map.Entry obj13 : obj12) {
            contentValues = new ContentValues();
            contentValues.put(str8, Long.valueOf(insert));
            contentValues.put("name", (String)obj13.getKey());
            contentValues.put("value", (String)obj13.getValue());
            sQLiteDatabase3.insert("event_metadata", i2, contentValues);
        }
        return Long.valueOf(insert);
    }

    static Object T(Throwable throwable) {
        SynchronizationException synchronizationException = new SynchronizationException("Timed out while trying to acquire the lock.", throwable);
        throw synchronizationException;
    }

    static SQLiteDatabase U(Throwable throwable) {
        SynchronizationException synchronizationException = new SynchronizationException("Timed out while trying to open db.", throwable);
        throw synchronizationException;
    }

    static Long V(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return Long.valueOf(0);
    }

    static f Y(long l, Cursor cursor2) {
        obj4.moveToNext();
        final f.a obj4 = f.c();
        obj4.c(obj4.getLong(0));
        obj4.b(l);
        return obj4.a();
    }

    static byte[] a1(Cursor cursor) {
        int i2;
        int i;
        int length;
        int i3;
        int length3;
        int length2;
        ArrayList arrayList = new ArrayList();
        final int i4 = 0;
        i2 = i4;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(i4);
            arrayList.add(blob);
            i2 += length;
        }
        final byte[] obj6 = new byte[i2];
        i3 = i;
        while (i < arrayList.size()) {
            Object obj = arrayList.get(i);
            System.arraycopy((byte[])obj, i4, obj6, i3, obj.length);
            i3 += length3;
            i++;
        }
        return obj6;
    }

    private Object b1(Cursor cursor) {
        while (cursor.moveToNext()) {
            e((long)int, obj3, c.b.MAX_RETRIES_REACHED);
        }
        return null;
    }

    static f e0(long l, SQLiteDatabase sQLiteDatabase2) {
        c cVar = new c(l, sQLiteDatabase2);
        return (f)q0.G1(obj4.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), cVar);
    }

    private c.b f(int i) {
        final c.b rEASON_UNKNOWN = c.b.REASON_UNKNOWN;
        if (i == rEASON_UNKNOWN.getNumber()) {
            return rEASON_UNKNOWN;
        }
        c.b mESSAGE_TOO_OLD = c.b.MESSAGE_TOO_OLD;
        if (i == mESSAGE_TOO_OLD.getNumber()) {
            return mESSAGE_TOO_OLD;
        }
        c.b cACHE_FULL = c.b.CACHE_FULL;
        if (i == cACHE_FULL.getNumber()) {
            return cACHE_FULL;
        }
        c.b pAYLOAD_TOO_BIG = c.b.PAYLOAD_TOO_BIG;
        if (i == pAYLOAD_TOO_BIG.getNumber()) {
            return pAYLOAD_TOO_BIG;
        }
        c.b mAX_RETRIES_REACHED = c.b.MAX_RETRIES_REACHED;
        if (i == mAX_RETRIES_REACHED.getNumber()) {
            return mAX_RETRIES_REACHED;
        }
        c.b iNVALID_PAYLOD = c.b.INVALID_PAYLOD;
        if (i == iNVALID_PAYLOD.getNumber()) {
            return iNVALID_PAYLOD;
        }
        c.b sERVER_ERROR = c.b.SERVER_ERROR;
        if (i == sERVER_ERROR.getNumber()) {
            return sERVER_ERROR;
        }
        a.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i));
        return rEASON_UNKNOWN;
    }

    static Long g0(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    private Object g1(String string, String string2, SQLiteDatabase sQLiteDatabase3) {
        sQLiteDatabase3.compileStatement(string).execute();
        int obj2 = 0;
        u uVar = new u(this);
        q0.G1(sQLiteDatabase3.rawQuery(string2, obj2), uVar);
        sQLiteDatabase3.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return obj2;
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        e eVar = new e(sQLiteDatabase);
        A1(eVar, b.a);
    }

    private long j(SQLiteDatabase sQLiteDatabase, p p2) {
        int str;
        Object obj6;
        Long num = w(sQLiteDatabase, p2);
        if (num != null) {
            return num.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", p2.b());
        contentValues.put("priority", Integer.valueOf(a.a(p2.d())));
        str = 0;
        contentValues.put("next_request_ms", Integer.valueOf(str));
        if (p2.c() != null) {
            contentValues.put("extras", Base64.encodeToString(p2.c(), str));
        }
        return sQLiteDatabase.insert("transport_contexts", 0, contentValues);
    }

    private Boolean j0(p p, SQLiteDatabase sQLiteDatabase2) {
        Long obj3 = w(sQLiteDatabase2, p);
        if (obj3 == null) {
            return Boolean.FALSE;
        }
        String[] strArr = new String[1];
        return (Boolean)q0.G1(m().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", obj3.toString()), d0.a);
    }

    static Boolean l1(Cursor cursor) {
        int obj0;
        obj0 = cursor.getCount() > 0 ? 1 : 0;
        return Boolean.valueOf(obj0);
    }

    static List m0(SQLiteDatabase sQLiteDatabase) {
        return (List)q0.G1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), h.a);
    }

    private b n() {
        b.a aVar = b.b();
        e.a aVar2 = e.c();
        aVar2.b(k());
        aVar2.c(j0.a.f());
        aVar.b(aVar2.a());
        return aVar.a();
    }

    static Object n1(String string, c.b c$b2, long l3, SQLiteDatabase sQLiteDatabase4) {
        ContentValues contentValues;
        Object stringBuilder;
        String str;
        String obj6;
        String obj7;
        long obj8;
        long obj9;
        contentValues = 2;
        String[] strArr = new String[contentValues];
        final int i = 0;
        strArr[i] = string;
        final int i3 = 1;
        strArr[i3] = Integer.toString(b2.getNumber());
        int i2 = 0;
        if (!((Boolean)q0.G1(obj10.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", strArr), x.a).booleanValue())) {
            contentValues = new ContentValues();
            contentValues.put("log_source", string);
            contentValues.put("reason", Integer.valueOf(b2.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(l3));
            obj10.insert("log_event_dropped", i2, contentValues);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + ");
            stringBuilder.append(l3);
            stringBuilder.append(" WHERE log_source = ? AND reason = ?");
            obj9 = new String[contentValues];
            obj9[i] = string;
            obj9[i3] = Integer.toString(b2.getNumber());
            obj10.execSQL(stringBuilder.toString(), obj9);
        }
        return i2;
    }

    private long o() {
        return m().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    static Object o1(long l, p p2, SQLiteDatabase sQLiteDatabase3) {
        int str;
        int obj3;
        String obj5;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(l));
        obj3 = new String[2];
        str = 1;
        obj3[str] = String.valueOf(a.a(sQLiteDatabase3.d()));
        String obj4 = "transport_contexts";
        int i2 = 0;
        if (obj6.update(obj4, contentValues, "backend_name = ? and priority = ?", obj3) < str) {
            contentValues.put("backend_name", sQLiteDatabase3.b());
            contentValues.put("priority", Integer.valueOf(a.a(sQLiteDatabase3.d())));
            obj6.insert(obj4, i2, contentValues);
        }
        return i2;
    }

    private long q() {
        return m().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private f r() {
        l lVar = new l(this.b.getTime(), obj1);
        return (f)x(lVar);
    }

    private List<f.c.a.b.i.a0.j.p0> s1(SQLiteDatabase sQLiteDatabase, p p2) {
        final Object obj = this;
        ArrayList arrayList = new ArrayList();
        Long num = w(sQLiteDatabase, p2);
        if (num == null) {
            return arrayList;
        }
        final String[] strArr2 = new String[1];
        o oVar = new o(obj, arrayList, p2);
        q0.G1(sQLiteDatabase.query("events", /* result */, "context_id = ?", strArr2, 0, 0, 0, String.valueOf(obj.v.d())), oVar);
        return arrayList;
    }

    static List t0(Cursor cursor) {
        p pVar;
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            p.a aVar = p.a();
            aVar.b(cursor.getString(1));
            aVar.d(a.b(cursor.getInt(2)));
            aVar.c(q0.u1(cursor.getString(3)));
            arrayList.add(aVar.a());
        }
        return arrayList;
    }

    private Map<Long, Set<f.c.a.b.i.a0.j.q0.c>> t1(SQLiteDatabase sQLiteDatabase, List<f.c.a.b.i.a0.j.p0> list2) {
        int i;
        int i2;
        HashMap hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder("event_id IN (");
        i = 0;
        while (i < list2.size()) {
            stringBuilder.append((p0)list2.get(i).c());
            if (i < size2--) {
            }
            i++;
            stringBuilder.append(',');
        }
        stringBuilder.append(')');
        s obj14 = new s(hashMap);
        q0.G1(sQLiteDatabase.query("event_metadata", /* result */, stringBuilder.toString(), 0, 0, 0, 0), obj14);
        return hashMap;
    }

    private static byte[] u1(String string) {
        if (string == null) {
            return null;
        }
        return Base64.decode(string, 0);
    }

    private List v0(p p, SQLiteDatabase sQLiteDatabase2) {
        final List obj1 = s1(sQLiteDatabase2, p);
        F(obj1, t1(sQLiteDatabase2, obj1));
        return obj1;
    }

    private Long w(SQLiteDatabase sQLiteDatabase, p p2) {
        String str;
        String obj15;
        StringBuilder stringBuilder = new StringBuilder("backend_name = ? and priority = ?");
        String[] strArr = new String[2];
        final int i3 = 0;
        strArr[i3] = p2.b();
        strArr[1] = String.valueOf(a.a(p2.d()));
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (p2.c() != null) {
            stringBuilder.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(p2.c(), i3));
        } else {
            stringBuilder.append(" and extras is null");
        }
        return (Long)q0.G1(sQLiteDatabase.query("transport_contexts", /* result */, stringBuilder.toString(), (String[])arrayList.toArray(new String[i3]), 0, 0, 0), p.a);
    }

    private void x1(a.a a$a, Map<String, List<c>> map2) {
        d dVar;
        d.a aVar;
        Object key;
        Iterator obj5 = map2.entrySet().iterator();
        for (Map.Entry next2 : obj5) {
            aVar = d.c();
            aVar.c((String)next2.getKey());
            aVar.b((List)next2.getValue());
            a.a(aVar.a());
        }
    }

    private byte[] z1(long l) {
        final String[] strArr2 = new String[1];
        return (byte[])q0.G1(m().query("event_payloads", /* result */, "event_id = ?", strArr2, 0, 0, "sequence_num"), g.a);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public a C0(Map map, a.a a$a2, Cursor cursor3) {
        return A0(map, a2, cursor3);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public long C1(p p) {
        String[] strArr = new String[2];
        return (Long)q0.G1(m().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", p.b(), String.valueOf(a.a(p.d()))), m.a).longValue();
    }

    @Override // f.c.a.b.i.a0.j.i0
    public a I0(String string, Map map2, a.a a$a3, SQLiteDatabase sQLiteDatabase4) {
        return G0(string, map2, a3, sQLiteDatabase4);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Object J(Cursor cursor) {
        return H(cursor);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Integer L(long l, SQLiteDatabase sQLiteDatabase2) {
        return K(l, sQLiteDatabase2);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Object L0(List list, p p2, Cursor cursor3) {
        return J0(list, p2, cursor3);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public boolean L1(p p) {
        k kVar = new k(this, p);
        return (Boolean)x(kVar).booleanValue();
    }

    public Iterable<f.c.a.b.i.a0.j.p0> R(p p) {
        d dVar = new d(this, p);
        return (Iterable)x(dVar);
    }

    public void R1(Iterable<f.c.a.b.i.a0.j.p0> iterable) {
        if (!iterable.iterator().hasNext()) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
        stringBuilder.append(q0.E1(iterable));
        q qVar = new q(this, stringBuilder.toString(), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name");
        x(qVar);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Long V0(j j, p p2, SQLiteDatabase sQLiteDatabase3) {
        return Q0(j, p2, sQLiteDatabase3);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public void Z(p p, long l2) {
        f fVar = new f(l2, obj4, p);
        x(fVar);
    }

    public <T> T a(a.a<T> a$a) {
        final SQLiteDatabase sQLiteDatabase = m();
        i(sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        return a.execute();
    }

    @Override // f.c.a.b.i.a0.j.i0
    public a c() {
        HashMap hashMap = new HashMap();
        n nVar = new n(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", hashMap, a.e());
        return (a)x(nVar);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public void close() {
        this.a.close();
    }

    @Override // f.c.a.b.i.a0.j.i0
    public void e(long l, c.b c$b2, String string3) {
        i iVar = new i(obj5, string3, l, b2);
        x(iVar);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Object e1(Cursor cursor) {
        return b1(cursor);
    }

    public Iterable<p> i0() {
        return (Iterable)x(w.a);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Object i1(String string, String string2, SQLiteDatabase sQLiteDatabase3) {
        return g1(string, string2, sQLiteDatabase3);
    }

    @Override // f.c.a.b.i.a0.j.i0
    long k() {
        return l *= l2;
    }

    @Override // f.c.a.b.i.a0.j.i0
    public Boolean l0(p p, SQLiteDatabase sQLiteDatabase2) {
        return j0(p, sQLiteDatabase2);
    }

    @Override // f.c.a.b.i.a0.j.i0
    SQLiteDatabase m() {
        f.c.a.b.i.a0.j.s0 s0Var = this.a;
        Objects.requireNonNull(s0Var);
        e0 e0Var = new e0(s0Var);
        return (SQLiteDatabase)A1(e0Var, a.a);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public int s() {
        v vVar = new v(this, time -= l, obj1);
        return (Integer)x(vVar).intValue();
    }

    public void v(Iterable<f.c.a.b.i.a0.j.p0> iterable) {
        if (!iterable.iterator().hasNext()) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM events WHERE _id in ");
        stringBuilder.append(q0.E1(iterable));
        m().compileStatement(stringBuilder.toString()).execute();
    }

    @Override // f.c.a.b.i.a0.j.i0
    public f.c.a.b.i.a0.j.p0 v1(p p, j j2) {
        Object[] arr = new Object[3];
        String str3 = "SQLiteEventStore";
        a.b(str3, "Storing event with priority=%s, name=%s for destination %s", p.d(), j2.j(), p.b());
        r rVar = new r(this, j2, p);
        long longValue = (Long)x(rVar).longValue();
        if (Long.compare(longValue, i5) < 0) {
            return null;
        }
        return p0.a(longValue, str3, p);
    }

    <T> T x(f.c.a.b.i.a0.j.q0.b<SQLiteDatabase, T> q0$b) {
        final SQLiteDatabase sQLiteDatabase = m();
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        return b.apply(sQLiteDatabase);
    }

    @Override // f.c.a.b.i.a0.j.i0
    public List z0(p p, SQLiteDatabase sQLiteDatabase2) {
        return v0(p, sQLiteDatabase2);
    }
}
