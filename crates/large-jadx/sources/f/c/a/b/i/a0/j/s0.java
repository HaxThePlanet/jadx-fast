package f.c.a.b.i.a0.j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

/* compiled from: SchemaManager.java */
/* loaded from: classes.dex */
final class s0 extends SQLiteOpenHelper {

    private static final s0.a A;
    private static final List<s0.a> B;
    private static final String c;
    static int v;
    private static final s0.a w;
    private static final s0.a x;
    private static final s0.a y;
    private static final s0.a z;
    private final int a;
    private boolean b = false;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }
    static {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "INSERT INTO global_log_event_state VALUES (";
        long time = System.currentTimeMillis();
        String str3 = ")";
        str = str2 + time + str3;
        s0.c = str;
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

    s0(Context context, String str, int i) {
        super(context, str, null, i);
        this.a = i;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (!this.b) {
            onConfigure(sQLiteDatabase);
        }
    }

    static /* synthetic */ void c(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }

    static /* synthetic */ void i(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    static /* synthetic */ void j(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(s0.c);
    }

    private void k(SQLiteDatabase sQLiteDatabase, int i) {
        a(sQLiteDatabase);
        m(sQLiteDatabase, 0, i);
    }

    private void m(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        item = s0.B;
        if (i2 > item.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Migration from ";
            String str2 = " to ";
            String str3 = " was requested, but cannot be performed. Only ";
            int size2 = s0.B.size();
            String str4 = " migrations are provided";
            i = str + i + str2 + i2 + str3 + size2 + str4;
            throw new IllegalArgumentException(i);
        } else {
            while (i < i2) {
                (s0.a)s0.B.get(i).a(sQLiteDatabase);
                i = i + 1;
            }
            return;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        final boolean z = true;
        this.b = z;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        k(sQLiteDatabase, this.a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws android.database.SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        k(sQLiteDatabase, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
        m(sQLiteDatabase, i, i2);
    }
}
