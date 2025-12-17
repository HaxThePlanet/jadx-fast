package app.dogo.android.persistencedb.room.database;

import android.content.Context;
import androidx.room.e1.b;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import d.s.a.g;
import e.a.a.a.b.b.w;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006", d2 = {"Lapp/dogo/android/persistencedb/room/database/LocalOnlyDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dogLocalDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class LocalOnlyDatabase extends u0 {

    public static final app.dogo.android.persistencedb.room.database.LocalOnlyDatabase.b n;
    private static volatile app.dogo.android.persistencedb.room.database.LocalOnlyDatabase o;
    private static final Object p;
    private static final b q;
    private static final b[] r;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0011\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002R\u0019\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/database/LocalOnlyDatabase$Companion;", "", "()V", "ALL_MIGRATIONS", "", "Landroidx/room/migration/Migration;", "getALL_MIGRATIONS", "()[Landroidx/room/migration/Migration;", "[Landroidx/room/migration/Migration;", "LOCK", "MIGRATION_1_2", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "instance", "Lapp/dogo/android/persistencedb/room/database/LocalOnlyDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }

        private final app.dogo.android.persistencedb.room.database.LocalOnlyDatabase a(Context context) {
            u0.a obj3 = t0.a(context, LocalOnlyDatabase.class, "localOnly.db");
            obj3.b();
            b[] objArr = b();
            obj3.a((b[])Arrays.copyOf(objArr, objArr.length));
            obj3.f();
            obj3 = obj3.c();
            n.e(obj3, "databaseBuilder(context, LocalOnlyDatabase::class.java, \"localOnly.db\")\n            .allowMainThreadQueries()\n            .addMigrations(*ALL_MIGRATIONS)\n            .fallbackToDestructiveMigrationOnDowngrade()\n            .build()");
            return (LocalOnlyDatabase)obj3;
        }

        public final b[] b() {
            return LocalOnlyDatabase.E();
        }

        public final app.dogo.android.persistencedb.room.database.LocalOnlyDatabase c(Context context) {
            app.dogo.android.persistencedb.room.database.LocalOnlyDatabase localOnlyDatabase;
            Object localOnlyDatabase2;
            app.dogo.android.persistencedb.room.database.LocalOnlyDatabase obj3;
            n.f(context, "context");
            if (LocalOnlyDatabase.F() == null) {
                Object obj = LocalOnlyDatabase.G();
                localOnlyDatabase2 = LocalOnlyDatabase.F();
                synchronized (obj) {
                    LocalOnlyDatabase.H(LocalOnlyDatabase.n.a(context));
                    localOnlyDatabase = obj3;
                }
            }
            return localOnlyDatabase;
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/LocalOnlyDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(1, 2);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("ALTER TABLE `DogLocalEntity` ADD COLUMN `longestStreak` INTEGER DEFAULT 0 NOT NULL");
            g.C("ALTER TABLE `DogLocalEntity` ADD COLUMN `currentStreak` INTEGER DEFAULT 0 NOT NULL");
            g.C("ALTER TABLE `DogLocalEntity` ADD COLUMN `lastAchievedStreakTimestampMs` BIGINT DEFAULT 0 NOT NULL");
        }
    }
    static {
        LocalOnlyDatabase.b bVar = new LocalOnlyDatabase.b(0);
        LocalOnlyDatabase.n = bVar;
        Object object = new Object();
        LocalOnlyDatabase.p = object;
        LocalOnlyDatabase.a aVar = new LocalOnlyDatabase.a();
        LocalOnlyDatabase.q = aVar;
        b[] arr = new b[1];
        LocalOnlyDatabase.r = arr;
    }

    public static final b[] E() {
        return LocalOnlyDatabase.r;
    }

    public static final app.dogo.android.persistencedb.room.database.LocalOnlyDatabase F() {
        return LocalOnlyDatabase.o;
    }

    public static final Object G() {
        return LocalOnlyDatabase.p;
    }

    public static final void H(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase localOnlyDatabase) {
        LocalOnlyDatabase.o = localOnlyDatabase;
    }

    @Override // androidx.room.u0
    public abstract w I();
}
