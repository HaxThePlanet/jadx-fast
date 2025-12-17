package app.dogo.android.persistencedb.room.database;

import android.content.Context;
import androidx.room.e1.b;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import d.s.a.g;
import e.a.a.a.b.b.a0;
import e.a.a.a.b.b.s;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0008", d2 = {"Lapp/dogo/android/persistencedb/room/database/PremiumDatabase;", "Landroidx/room/RoomDatabase;", "()V", "couponDoa", "Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "dogPremiumDao", "Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class PremiumDatabase extends u0 {

    public static final app.dogo.android.persistencedb.room.database.PremiumDatabase.c n;
    private static volatile app.dogo.android.persistencedb.room.database.PremiumDatabase o;
    private static final Object p;
    private static final b q;
    private static final b r;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0011\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/database/PremiumDatabase$Companion;", "", "()V", "LOCK", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "instance", "Lapp/dogo/android/persistencedb/room/database/PremiumDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        public c(g g) {
            super();
        }

        private final app.dogo.android.persistencedb.room.database.PremiumDatabase a(Context context) {
            u0.a obj4 = t0.a(context, PremiumDatabase.class, "premium.db");
            b[] arr = new b[2];
            obj4.a(b(), c());
            obj4.b();
            obj4.f();
            obj4 = obj4.c();
            n.e(obj4, "databaseBuilder(context,\n            PremiumDatabase::class.java, \"premium.db\")\n            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)\n            .allowMainThreadQueries()\n            .fallbackToDestructiveMigrationOnDowngrade()\n            .build()");
            return (PremiumDatabase)obj4;
        }

        public final b b() {
            return PremiumDatabase.G();
        }

        public final b c() {
            return PremiumDatabase.H();
        }

        public final app.dogo.android.persistencedb.room.database.PremiumDatabase d(Context context) {
            app.dogo.android.persistencedb.room.database.PremiumDatabase premiumDatabase;
            Object premiumDatabase2;
            app.dogo.android.persistencedb.room.database.PremiumDatabase obj3;
            n.f(context, "context");
            if (PremiumDatabase.E() == null) {
                Object obj = PremiumDatabase.F();
                premiumDatabase2 = PremiumDatabase.E();
                synchronized (obj) {
                    PremiumDatabase.I(PremiumDatabase.n.a(context));
                    premiumDatabase = obj3;
                }
            }
            return premiumDatabase;
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/PremiumDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(1, 2);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("CREATE TABLE `CouponEntity` (`couponId` TEXT NOT NULL DEFAULT '', `discount` BIGINT NOT NULL DEFAULT 0, `offeringId` TEXT NOT NULL DEFAULT '',  `offerDurationMs` BIGINT NOT NULL DEFAULT 0,  `activationTimeMs` BIGINT NOT NULL DEFAULT 0, PRIMARY KEY(`couponId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/PremiumDatabase$Companion$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends b {
        b() {
            super(2, 3);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("ALTER TABLE `CouponEntity` ADD COLUMN `welcomeOffer` INTEGER DEFAULT 0 NOT NULL");
            g.C("ALTER TABLE `CouponEntity` ADD COLUMN `style` TEXT DEFAULT '' NOT NULL");
            g.C("ALTER TABLE `CouponEntity` ADD COLUMN `discountText` TEXT DEFAULT NULL");
            g.C("ALTER TABLE `CouponEntity` ADD COLUMN `offerText` TEXT DEFAULT NULL");
        }
    }
    static {
        PremiumDatabase.c cVar = new PremiumDatabase.c(0);
        PremiumDatabase.n = cVar;
        Object object = new Object();
        PremiumDatabase.p = object;
        PremiumDatabase.a aVar = new PremiumDatabase.a();
        PremiumDatabase.q = aVar;
        PremiumDatabase.b bVar = new PremiumDatabase.b();
        PremiumDatabase.r = bVar;
    }

    public static final app.dogo.android.persistencedb.room.database.PremiumDatabase E() {
        return PremiumDatabase.o;
    }

    public static final Object F() {
        return PremiumDatabase.p;
    }

    public static final b G() {
        return PremiumDatabase.q;
    }

    public static final b H() {
        return PremiumDatabase.r;
    }

    public static final void I(app.dogo.android.persistencedb.room.database.PremiumDatabase premiumDatabase) {
        PremiumDatabase.o = premiumDatabase;
    }

    @Override // androidx.room.u0
    public abstract s J();

    @Override // androidx.room.u0
    public abstract a0 K();
}
