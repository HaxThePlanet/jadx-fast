package app.dogo.android.persistencedb.room.database;

import android.content.Context;
import androidx.room.e1.b;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import e.a.a.a.b.b.w;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LocalOnlyDatabase.kt */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006", d2 = {"Lapp/dogo/android/persistencedb/room/database/LocalOnlyDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dogLocalDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class LocalOnlyDatabase extends u0 {

    public static final LocalOnlyDatabase.b n = new LocalOnlyDatabase$b(0);
    private static volatile LocalOnlyDatabase o;
    private static final Object p = new Object();
    private static final b q = new LocalOnlyDatabase$a();
    private static final b[] r;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0011\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002R\u0019\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/database/LocalOnlyDatabase$Companion;", "", "()V", "ALL_MIGRATIONS", "", "Landroidx/room/migration/Migration;", "getALL_MIGRATIONS", "()[Landroidx/room/migration/Migration;", "[Landroidx/room/migration/Migration;", "LOCK", "MIGRATION_1_2", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "instance", "Lapp/dogo/android/persistencedb/room/database/LocalOnlyDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        private final LocalOnlyDatabase buildDatabase(Context context) {
            u0.a aVar = t0.a(context, LocalOnlyDatabase.class, "localOnly.db");
            aVar.b();
            b[] objArr = b();
            aVar.a((b[])Arrays.copyOf(objArr, objArr.length));
            aVar.f();
            u0 u0Var = aVar.c();
            n.e(u0Var, "databaseBuilder(context, LocalOnlyDatabase::class.java, \"localOnly.db\")\n            .allowMainThreadQueries()\n            .addMigrations(*ALL_MIGRATIONS)\n            .fallbackToDestructiveMigrationOnDowngrade()\n            .build()");
            return u0Var;
        }

        public final b[] b() {
            return LocalOnlyDatabase.r;
        }

        /* renamed from: c, reason: from kotlin metadata */
        /* operator */ public final LocalOnlyDatabase invoke(Context context) {
            app.dogo.android.persistencedb.room.database.LocalOnlyDatabase context2;
            app.dogo.android.persistencedb.room.database.LocalOnlyDatabase.b bVar;
            n.f(context, "context");
            if (LocalOnlyDatabase.o == null) {
                Object obj2 = LocalOnlyDatabase.p;
                synchronized (obj2) {
                    context2 = LocalOnlyDatabase.o;
                    LocalOnlyDatabase.o = LocalOnlyDatabase.n.buildDatabase(context);
                }
            }
            return context2;
        }

        public /* synthetic */ b(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/LocalOnlyDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(1, 2);
        }

        @Override // androidx.room.e1.b
        /* renamed from: a, reason: from kotlin metadata */
        public void migrate(d.s.a.g database) {
            n.f(database, "database");
            database.C("ALTER TABLE `DogLocalEntity` ADD COLUMN `longestStreak` INTEGER DEFAULT 0 NOT NULL");
            database.C("ALTER TABLE `DogLocalEntity` ADD COLUMN `currentStreak` INTEGER DEFAULT 0 NOT NULL");
            database.C("ALTER TABLE `DogLocalEntity` ADD COLUMN `lastAchievedStreakTimestampMs` BIGINT DEFAULT 0 NOT NULL");
        }
    }
    static {
        b[] arr = new b[1];
        LocalOnlyDatabase.r = new b[] { bVar };
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final /* synthetic */ b[] dogLocalDao() {
        return LocalOnlyDatabase.r;
    }

    public static final /* synthetic */ LocalOnlyDatabase F() {
        return LocalOnlyDatabase.o;
    }

    public static final /* synthetic */ Object G() {
        return LocalOnlyDatabase.p;
    }

    public static final /* synthetic */ void H(LocalOnlyDatabase localOnlyDatabase) {
        LocalOnlyDatabase.o = localOnlyDatabase;
    }

    @Override // androidx.room.u0
    public abstract w I();
}
