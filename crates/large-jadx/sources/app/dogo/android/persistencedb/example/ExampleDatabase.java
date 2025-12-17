package app.dogo.android.persistencedb.example;

import androidx.room.e1.b;
import androidx.room.u0;
import d.s.a.g;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006", d2 = {"Lapp/dogo/android/persistencedb/example/ExampleDatabase;", "Landroidx/room/RoomDatabase;", "()V", "exampleDao", "Lapp/dogo/android/persistencedb/example/ExampleDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ExampleDatabase extends u0 {

    private static final app.dogo.android.persistencedb.example.ExampleDatabase.a n;
    private static final app.dogo.android.persistencedb.example.ExampleDatabase.b o;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/example/ExampleDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(1, 2);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("ALTER TABLE `ExampleEntity` ADD COLUMN `badField` TEXT DEFAULT '' NOT NULL");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/example/ExampleDatabase$Companion$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends b {
        b() {
            super(2, 3);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("CREATE TABLE ExampleEntity_new (id TEXT DEFAULT '' NOT NULL, PRIMARY KEY(id))");
            g.C("INSERT INTO ExampleEntity_new (id) SELECT id FROM ExampleEntity");
            g.C("DROP TABLE ExampleEntity");
            g.C("ALTER TABLE ExampleEntity_new RENAME TO ExampleEntity");
            g.C("ALTER TABLE ExampleEntity ADD COLUMN `goodField` TEXT DEFAULT 'good' NOT NULL");
        }
    }
    static {
        ExampleDatabase.a aVar = new ExampleDatabase.a();
        ExampleDatabase.n = aVar;
        ExampleDatabase.b bVar = new ExampleDatabase.b();
        ExampleDatabase.o = bVar;
    }
}
