package f.c.a.b.i.a0.j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class s0 extends SQLiteOpenHelper {

    private static final f.c.a.b.i.a0.j.s0.a A;
    private static final List<f.c.a.b.i.a0.j.s0.a> B;
    private static final String c;
    static int v;
    private static final f.c.a.b.i.a0.j.s0.a w;
    private static final f.c.a.b.i.a0.j.s0.a x;
    private static final f.c.a.b.i.a0.j.s0.a y;
    private static final f.c.a.b.i.a0.j.s0.a z;
    private final int a;
    private boolean b = false;

    public interface a {
        public abstract void a(SQLiteDatabase sQLiteDatabase);
    }
    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO global_log_event_state VALUES (");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(")");
        s0.c = stringBuilder.toString();
        int i = 5;
        s0.v = i;
        f.c.a.b.i.a0.j.b0 b0Var = b0.a;
        s0.w = b0Var;
        final f.c.a.b.i.a0.j.y yVar = y.a;
        s0.x = yVar;
        final f.c.a.b.i.a0.j.z zVar = z.a;
        s0.y = zVar;
        final f.c.a.b.i.a0.j.a0 a0Var = a0.a;
        s0.z = a0Var;
        final f.c.a.b.i.a0.j.c0 c0Var = c0.a;
        s0.A = c0Var;
        f.c.a.b.i.a0.j.s0.a[] arr = new s0.a[i];
        arr[0] = b0Var;
        arr[1] = yVar;
        arr[2] = zVar;
        arr[3] = a0Var;
        arr[4] = c0Var;
        s0.B = Arrays.asList(arr);
    }

    s0(Context context, String string2, int i3) {
        super(context, string2, 0, i3);
        final int obj2 = 0;
        this.a = i3;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (!this.b) {
            onConfigure(sQLiteDatabase);
        }
    }

    static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    static void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    static void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }

    static void i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    static void j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(s0.c);
    }

    private void k(SQLiteDatabase sQLiteDatabase, int i2) {
        a(sQLiteDatabase);
        m(sQLiteDatabase, 0, i2);
    }

    private void m(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        List list;
        int obj5;
        list = s0.B;
        if (i3 > list.size()) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Migration from ");
        stringBuilder.append(i2);
        stringBuilder.append(" to ");
        stringBuilder.append(i3);
        stringBuilder.append(" was requested, but cannot be performed. Only ");
        stringBuilder.append(list.size());
        stringBuilder.append(" migrations are provided");
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        final int i = 1;
        this.b = i;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(i);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        k(sQLiteDatabase, this.a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        k(sQLiteDatabase, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        a(sQLiteDatabase);
        m(sQLiteDatabase, i2, i3);
    }
}
