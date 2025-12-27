package f.c.a.b.i.a0.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import f.c.a.b.i.i;
import f.c.a.b.i.j;
import f.c.a.b.i.j.a;
import f.c.a.b.i.p;
import f.c.a.b.i.p.a;
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

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes.dex */
public class q0 implements i0, com.google.android.datatransport.runtime.synchronization.a, h0 {

    private static final f.c.a.b.b x;
    private final s0 a;
    private final f.c.a.b.i.b0.a b;
    private final f.c.a.b.i.b0.a c;
    private final j0 v;
    private final f.c.a.b.i.w.a<String> w;

    static class a {
    }

    interface b<T, U> {
        U apply(T t);
    }

    private static class c {

        final String a;
        final String b;
        /* synthetic */ c(String str, String str2, q0.a aVar) {
            this(str, str2);
        }

        private c(String str, String str2) {
            super();
            this.a = str;
            this.b = str2;
        }
    }

    interface d<T> {
        T a();
    }
    static {
        q0.x = b.b("proto");
    }

    q0(f.c.a.b.i.b0.a aVar, f.c.a.b.i.b0.a aVar2, j0 j0Var, s0 s0Var, f.c.a.b.i.w.a<String> aVar3) {
        super();
        this.a = s0Var;
        this.b = aVar;
        this.c = aVar2;
        this.v = j0Var;
        this.w = aVar3;
    }

    private /* synthetic */ f.c.a.b.i.x.a.a A0(Map map, f.c.a.b.i.x.a.a.a aVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            c.a aVar2 = c.c();
            aVar2.c(f(cursor.getInt(1)));
            aVar2.b(cursor.getLong(2));
            (List)map.get(string).add(aVar2.a());
        }
        x1(aVar, map);
        aVar.e(r());
        aVar.d(n());
        aVar.c((String)this.w.get());
        return aVar.b();
    }

    private <T> T A1(q0.d<T> dVar, q0.b<Throwable, T> bVar) {
        try {
        } catch (android.database.sqlite.SQLiteDatabaseLockedException sQLiteDatabaseLocked) {
            f.c.a.b.i.b0.a cmp = this.c.getTime();
            f.c.a.b.i.a0.j.j0 j0Var = this.v.b();
            j0Var = (long)j0Var;
            j0Var += l;
            cmp = (cmp > j0Var ? 1 : (cmp == j0Var ? 0 : -1));
        }
        return dVar.a();
    }

    private static f.c.a.b.b B1(String str) {
        if (str == null) {
            return q0.x;
        }
        return b.b(str);
    }

    private boolean E() {
        boolean z = true;
        long l2 = o() * q();
        long l4 = this.v.f();
        int r0 = l2 >= l4 ? 1 : 0;
        return (l2 >= l4 ? 1 : 0);
    }

    private static String E1(Iterable<p0> iterable) {
        str = "(";
        final StringBuilder stringBuilder = new StringBuilder(str);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            stringBuilder.append((p0)it.next().c());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    private List<p0> F(List<p0> list, Map<Long, Set<q0.c>> map) {
        long l;
        long l2;
        String str;
        final ListIterator it = list.listIterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return list;
    }

    private /* synthetic */ f.c.a.b.i.x.a.a G0(String str, Map map, f.c.a.b.i.x.a.a.a aVar, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        return (a)q0.G1(sQLiteDatabase.rawQuery(str, new String[0]), new t(this, map, aVar));
    }

    static <T> T G1(Cursor cursor, q0.b<Cursor, T> bVar) {
        try {
        } finally {
            cursor.close();
            throw bVar;
        }
        cursor.close();
        return bVar.apply(cursor);
    }

    private /* synthetic */ Object H(Cursor cursor) {
        while (cursor.moveToNext()) {
            e((long)cursor.getInt(0), c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    private /* synthetic */ Object J0(List list, p pVar, Cursor cursor) {
        int i = 0;
        while (cursor.moveToNext()) {
            i = 0;
            final long _long = cursor.getLong(i);
            i = 1;
            aVar.h(new i(q0.B1(cursor.getString(i6)), cursor.getBlob(5)));
            aVar.h(new i(q0.B1(cursor.getString(i6)), z1(_long)));
            int i2 = 6;
            list.add(p0.a(_long, pVar, aVar.d()));
        }
        return null;
    }

    private /* synthetic */ Integer K(long j, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        String[] strArr = new String[1];
        q0.G1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", new String[] { String.valueOf(j) }), new j(this));
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    static /* synthetic */ Object M(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    static /* synthetic */ Object N0(Map map, Cursor cursor) {
        Object value;
        final f.c.a.b.i.a0.j.q0.a aVar = null;
        while (cursor.moveToNext()) {
            long _long = cursor.getLong(0);
        }
        return aVar;
    }

    private /* synthetic */ Long Q0(j jVar, p pVar, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        byte[] bArr;
        boolean z;
        int i2 = 0;
        int i = 1;
        double d;
        String str;
        String str2;
        if (E()) {
            long l6 = 1L;
            e(l6, c.b.CACHE_FULL, jVar.j());
            return Long.valueOf(-1L);
        }
        int i3 = this.v.e();
        bArr = jVar.e().a();
        i2 = 0;
        i = 1;
        int r3 = bArr.length <= i3 ? 1 : i2;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j(sQLiteDatabase, pVar), l4));
        String str9 = "transport_name";
        contentValues2.put(str9, jVar.j());
        String str10 = "timestamp_ms";
        contentValues2.put(str10, Long.valueOf(jVar.f(), str9));
        contentValues2.put("uptime_ms", Long.valueOf(jVar.k(), str10));
        contentValues2.put("payload_encoding", jVar.e().b().a());
        contentValues2.put("code", jVar.d());
        contentValues2.put("num_attempts", Integer.valueOf(i2));
        contentValues2.put("inline", Boolean.valueOf(r3));
        byte[] r0 = r3 ? bArr : new byte[i2];
        contentValues2.put("payload", (r3 ? bArr : new byte[i2]));
        String str17 = null;
        long insert = sQLiteDatabase.insert((r3 ? bArr : new byte[i2]), str17, contentValues2);
        String str7 = "event_id";
        if (!r3) {
            d = (double)i3;
            while (i <= (int)(Math.ceil((double)bArr.length / d))) {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put(str7, Long.valueOf(insert));
                str2 = "sequence_num";
                contentValues3.put(str2, Integer.valueOf(i));
                str = "bytes";
                contentValues3.put(str, Arrays.copyOfRange(bArr, (i - 1) * i3, Math.min(i * i3, bArr.length)));
                sQLiteDatabase.insert("event_payloads", str17, contentValues3);
                i = i + 1;
            }
        }
        Iterator it = jVar.i().entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put(str7, Long.valueOf(insert));
            contentValues.put("name", (String)item.getKey());
            contentValues.put("value", (String)item.getValue());
            sQLiteDatabase.insert("event_metadata", str17, contentValues);
        }
        return Long.valueOf(insert);
    }

    static /* synthetic */ Object T(Throwable th) throws SynchronizationException {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    static /* synthetic */ SQLiteDatabase U(Throwable th) throws SynchronizationException {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    static /* synthetic */ Long V(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return Long.valueOf(0L);
    }

    static /* synthetic */ f Y(long j, Cursor cursor) {
        cursor.moveToNext();
        final f.a aVar = f.c();
        aVar.c(cursor.getLong(0));
        aVar.b(j);
        return aVar.a();
    }

    static /* synthetic */ byte[] a1(Cursor cursor) {
        int i;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(i);
            arrayList.add(blob);
            length = blob.length;
            i = i + length;
        }
        final byte[] bArr = new byte[i];
        while (i < arrayList.size()) {
            Object item = arrayList.get(i);
            length3 = item.length;
            System.arraycopy(item, i, bArr, i, length3);
            length2 = item.length;
            i = i + length2;
            i = i + 1;
        }
        return bArr;
    }

    private /* synthetic */ Object b1(Cursor cursor) {
        while (cursor.moveToNext()) {
            e((long)cursor.getInt(0), c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    static /* synthetic */ f e0(long j, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        return (f)q0.G1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new c(j, r3));
    }

    private c.b f(int i) {
        final c.b rEASON_UNKNOWN2 = c.b.REASON_UNKNOWN;
        if (i == rEASON_UNKNOWN2.getNumber()) {
            return c.b.REASON_UNKNOWN;
        }
        c.b mESSAGE_TOO_OLD2 = c.b.MESSAGE_TOO_OLD;
        if (i == mESSAGE_TOO_OLD2.getNumber()) {
            return c.b.MESSAGE_TOO_OLD;
        }
        c.b cACHE_FULL2 = c.b.CACHE_FULL;
        if (i == cACHE_FULL2.getNumber()) {
            return c.b.CACHE_FULL;
        }
        c.b pAYLOAD_TOO_BIG2 = c.b.PAYLOAD_TOO_BIG;
        if (i == pAYLOAD_TOO_BIG2.getNumber()) {
            return c.b.PAYLOAD_TOO_BIG;
        }
        c.b mAX_RETRIES_REACHED2 = c.b.MAX_RETRIES_REACHED;
        if (i == mAX_RETRIES_REACHED2.getNumber()) {
            return c.b.MAX_RETRIES_REACHED;
        }
        c.b iNVALID_PAYLOD2 = c.b.INVALID_PAYLOD;
        if (i == iNVALID_PAYLOD2.getNumber()) {
            return c.b.INVALID_PAYLOD;
        }
        c.b sERVER_ERROR2 = c.b.SERVER_ERROR;
        if (i == sERVER_ERROR2.getNumber()) {
            return c.b.SERVER_ERROR;
        }
        a.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i));
        return c.b.REASON_UNKNOWN;
    }

    static /* synthetic */ Long g0(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    private /* synthetic */ Object g1(String str, String str2, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.compileStatement(str).execute();
        String[] strArr = null;
        q0.G1(sQLiteDatabase.rawQuery(str2, strArr), new u(this));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return strArr;
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        A1(new e(sQLiteDatabase), b.a);
    }

    private long j(SQLiteDatabase sQLiteDatabase, p pVar) throws android.database.SQLException {
        Long l = w(sQLiteDatabase, pVar);
        if (l != null) {
            return l.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(a.a(pVar.d())));
        int i = 0;
        contentValues.put("next_request_ms", Integer.valueOf(i));
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), i));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private /* synthetic */ Boolean j0(p pVar, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        Long l = w(sQLiteDatabase, pVar);
        if (l == null) {
            return Boolean.FALSE;
        }
        String[] strArr = new String[1];
        return (Boolean)q0.G1(m().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[] { l.toString() }), d0.a);
    }

    static /* synthetic */ Boolean l1(Cursor cursor) {
        boolean z = true;
        cursor = cursor.getCount() > 0 ? 1 : 0;
        return (cursor.getCount() > 0 ? 1 : 0);
    }

    static /* synthetic */ List m0(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        return (List)q0.G1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), h.a);
    }

    private f.c.a.b.i.x.a.b n() {
        b.a aVar = b.b();
        e.a aVar2 = e.c();
        aVar2.b(k());
        aVar2.c(j0.a.f());
        aVar.b(aVar2.a());
        return aVar.a();
    }

    static /* synthetic */ Object n1(String str, c.b bVar, long j, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        int i = 2;
        String[] strArr2 = new String[i];
        final int i2 = 0;
        strArr2[i2] = str;
        final int i3 = 1;
        strArr2[i3] = Integer.toString(bVar.getNumber());
        String str7 = null;
        if (!((Boolean)q0.G1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", strArr2), x.a).booleanValue())) {
            ContentValues contentValues = new ContentValues();
            str2 = "log_source";
            contentValues.put(str2, str);
            contentValues.put("reason", Integer.valueOf(bVar.getNumber()));
            str4 = "events_dropped_count";
            contentValues.put(str4, Long.valueOf(j));
            integer = "log_event_dropped";
            sQLiteDatabase.insert(integer, str7, contentValues);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = "UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + ";
            String str9 = " WHERE log_source = ? AND reason = ?";
            str5 = str3 + j + str9;
            String[] strArr = new String[i];
            sQLiteDatabase.execSQL(str5, new String[] { str, Integer.toString(bVar.getNumber()) });
        }
        return str7;
    }

    private long o() throws android.database.SQLException {
        return m().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    static /* synthetic */ Object o1(long j, p pVar, SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        String[] strArr = new String[2];
        int i = 1;
        strArr[i] = String.valueOf(a.a(pVar.d()));
        String str9 = "transport_contexts";
        String str4 = null;
        if (sQLiteDatabase.update(str9, contentValues, "backend_name = ? and priority = ?", strArr) < i) {
            contentValues.put("backend_name", pVar.b());
            str = "priority";
            contentValues.put(str, Integer.valueOf(a.a(pVar.d())));
            sQLiteDatabase.insert(str9, str4, contentValues);
        }
        return str4;
    }

    private long q() throws android.database.SQLException {
        return m().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private f r() {
        return (f)x(new l(this.b.getTime(), r1));
    }

    private List<p0> s1(SQLiteDatabase sQLiteDatabase, p pVar) throws android.database.SQLException {
        final Object sQLiteDatabase3 = this;
        final ArrayList arrayList = new ArrayList();
        Long l = w(sQLiteDatabase, pVar);
        if (l == null) {
            return arrayList;
        }
        final String[] strArr2 = new String[1];
        q0.G1(sQLiteDatabase.query("events", new String[] { "_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline" }, "context_id = ?", new String[] { l.toString() }, null, null, null, String.valueOf(sQLiteDatabase3.v.d())), new o(sQLiteDatabase3, arrayList, pVar));
        return arrayList;
    }

    static /* synthetic */ List t0(Cursor cursor) {
        final ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            p.a aVar = p.a();
            aVar.b(cursor.getString(1));
            aVar.d(a.b(cursor.getInt(2)));
            aVar.c(q0.u1(cursor.getString(3)));
            arrayList.add(aVar.a());
        }
        return arrayList;
    }

    private Map<Long, Set<q0.c>> t1(SQLiteDatabase sQLiteDatabase, List<p0> list) throws android.database.SQLException {
        int i = 0;
        int i2 = 44;
        final HashMap hashMap = new HashMap();
        final StringBuilder stringBuilder = new StringBuilder("event_id IN (");
        i = 0;
        while (i < list.size()) {
            stringBuilder.append((p0)list.get(i).c());
            i2 = list.size() - 1;
            i = i + 1;
        }
        stringBuilder.append(')');
        q0.G1(sQLiteDatabase.query("event_metadata", new String[] { "event_id", "name", "value" }, stringBuilder.toString(), null, null, null, null), new s(hashMap));
        return hashMap;
    }

    private static byte[] u1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private /* synthetic */ List v0(p pVar, SQLiteDatabase sQLiteDatabase) {
        final List list = s1(sQLiteDatabase, pVar);
        F(list, t1(sQLiteDatabase, list));
        return list;
    }

    private Long w(SQLiteDatabase sQLiteDatabase, p pVar) throws android.database.SQLException {
        final StringBuilder stringBuilder = new StringBuilder("backend_name = ? and priority = ?");
        String[] strArr = new String[2];
        final int i3 = 0;
        strArr[i3] = pVar.b();
        strArr[1] = String.valueOf(a.a(pVar.d()));
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (pVar.c() != null) {
            str = " and extras = ?";
            stringBuilder.append(str);
            arrayList.add(Base64.encodeToString(pVar.c(), i3));
        } else {
            encodeToString = " and extras is null";
            stringBuilder.append(encodeToString);
        }
        return (Long)q0.G1(sQLiteDatabase.query("transport_contexts", new String[] { "_id" }, stringBuilder.toString(), (String[])arrayList.toArray(new String[i3]), null, null, null), p.a);
    }

    private void x1(f.c.a.b.i.x.a.a.a aVar, Map<String, List<c>> map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            d.a aVar2 = d.c();
            aVar2.c((String)item.getKey());
            aVar2.b((List)item.getValue());
            aVar.a(aVar2.a());
        }
    }

    private byte[] z1(long j) throws android.database.SQLException {
        final String[] strArr2 = new String[1];
        return (byte[])q0.G1(m().query("event_payloads", new String[] { "bytes" }, "event_id = ?", new String[] { String.valueOf(j) }, null, null, "sequence_num"), g.a);
    }

    public long C1(p pVar) throws android.database.SQLException {
        String[] strArr = new String[2];
        return (Long)q0.G1(m().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[] { pVar.b(), String.valueOf(a.a(pVar.d())) }), m.a).longValue();
    }

    public boolean L1(p pVar) {
        return (Boolean)x(new k(this, pVar)).booleanValue();
    }

    public Iterable<p0> R(p pVar) {
        return (Iterable)x(new d(this, pVar));
    }

    public void R1(Iterable<p0> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ";
        String str3 = q0.E1(iterable);
        iterable = str + str3;
        x(new q(this, iterable, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
    }

    public void Z(p pVar, long j) {
        x(new f(j, r4, pVar));
    }

    public <T> T a(com.google.android.datatransport.runtime.synchronization.a.a<T> aVar) {
        final SQLiteDatabase sQLiteDatabase = m();
        i(sQLiteDatabase);
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            obj.endTransaction();
            throw aVar;
        }
        sQLiteDatabase.endTransaction();
        return aVar.execute();
    }

    public f.c.a.b.i.x.a.a c() {
        return (a)x(new n(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), a.e()));
    }

    public void close() {
        this.a.close();
    }

    public void e(long j, c.b bVar, String str) {
        x(new i(str, bVar, j, r3));
    }

    public Iterable<p> i0() {
        return (Iterable)x(w.a);
    }

    long k() {
        return o() * q();
    }

    SQLiteDatabase m() {
        Objects.requireNonNull(this.a);
        return (SQLiteDatabase)A1(new e0(s0Var), a.a);
    }

    public int s() {
        return (Integer)x(new v(this, this.b.getTime() - this.v.c(), r1)).intValue();
    }

    public void v(Iterable<p0> iterable) throws android.database.SQLException {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "DELETE FROM events WHERE _id in ";
        String str2 = q0.E1(iterable);
        str3 = str + str2;
        m().compileStatement(str3).execute();
    }

    public p0 v1(p pVar, j jVar) {
        Object[] arr = new Object[3];
        String str3 = "SQLiteEventStore";
        a.b(str3, "Storing event with priority=%s, name=%s for destination %s", pVar.d(), jVar.j(), pVar.b());
        long value = (Long)x(new r(this, jVar, pVar)).longValue();
        if (value < 1) {
            return null;
        }
        return p0.a(value, pVar, jVar);
    }

    <T> T x(q0.b<SQLiteDatabase, T> bVar) {
        final SQLiteDatabase sQLiteDatabase = m();
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            obj.endTransaction();
            throw bVar;
        }
        sQLiteDatabase.endTransaction();
        return bVar.apply(sQLiteDatabase);
    }

    public /* synthetic */ f.c.a.b.i.x.a.a C0(Map map, f.c.a.b.i.x.a.a.a aVar, Cursor cursor) {
        return A0(map, aVar, cursor);
    }

    public /* synthetic */ f.c.a.b.i.x.a.a I0(String str, Map map, f.c.a.b.i.x.a.a.a aVar, SQLiteDatabase sQLiteDatabase) {
        return G0(str, map, aVar, sQLiteDatabase);
    }

    public /* synthetic */ Object J(Cursor cursor) {
        return H(cursor);
    }

    public /* synthetic */ Integer L(long j, SQLiteDatabase sQLiteDatabase) {
        return K(j, sQLiteDatabase);
    }

    public /* synthetic */ Object L0(List list, p pVar, Cursor cursor) {
        return J0(list, pVar, cursor);
    }

    public /* synthetic */ Long V0(j jVar, p pVar, SQLiteDatabase sQLiteDatabase) {
        return Q0(jVar, pVar, sQLiteDatabase);
    }

    public /* synthetic */ Object e1(Cursor cursor) {
        return b1(cursor);
    }

    public /* synthetic */ Object i1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        return g1(str, str2, sQLiteDatabase);
    }

    public /* synthetic */ Boolean l0(p pVar, SQLiteDatabase sQLiteDatabase) {
        return j0(pVar, sQLiteDatabase);
    }

    public /* synthetic */ List z0(p pVar, SQLiteDatabase sQLiteDatabase) {
        return v0(pVar, sQLiteDatabase);
    }
}
