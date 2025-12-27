package app.dogo.android.persistencedb.room.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.room.e1.b;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility;
import e.a.a.a.b.a.a;
import e.a.a.a.b.b.o0;
import e.a.a.a.b.b.s0;
import e.a.a.a.b.b.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ProgressDatabase.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&J\u0008\u0010\u0007\u001a\u00020\u0008H&¨\u0006\n", d2 = {"Lapp/dogo/android/persistencedb/room/database/ProgressDatabase;", "Landroidx/room/RoomDatabase;", "()V", "recommendedProgramListDab", "Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "workoutInfoDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProgressDatabase extends u0 {

    public static final ProgressDatabase.f n = new ProgressDatabase$f(0);
    private static volatile ProgressDatabase o;
    private static final Object p = new Object();
    private static final b q = new ProgressDatabase$a();
    private static final b r = new ProgressDatabase$c();
    private static final b s = new ProgressDatabase$b();
    private static final b t = new ProgressDatabase$d();
    private static final b u = new ProgressDatabase$e();
    private static final b[] v;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0011\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0002R\u0019\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000cR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/android/persistencedb/room/database/ProgressDatabase$Companion;", "", "()V", "ALL_MIGRATIONS", "", "Landroidx/room/migration/Migration;", "getALL_MIGRATIONS", "()[Landroidx/room/migration/Migration;", "[Landroidx/room/migration/Migration;", "LOCK", "MIGRATION_2_3", "getMIGRATION_2_3", "()Landroidx/room/migration/Migration;", "MIGRATION_3_5", "getMIGRATION_3_5", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "instance", "Lapp/dogo/android/persistencedb/room/database/ProgressDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f {
        private f() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        private final ProgressDatabase buildDatabase(Context context) {
            u0.a aVar = t0.a(context, ProgressDatabase.class, "progress.db");
            aVar.b();
            b[] objArr = b();
            aVar.a((b[])Arrays.copyOf(objArr, objArr.length));
            aVar.f();
            u0 u0Var = aVar.c();
            n.e(u0Var, "databaseBuilder(context,\n            ProgressDatabase::class.java, \"progress.db\")\n            .allowMainThreadQueries()\n            .addMigrations(*ALL_MIGRATIONS)\n            .fallbackToDestructiveMigrationOnDowngrade()\n            .build()");
            return u0Var;
        }

        public final b[] b() {
            return ProgressDatabase.v;
        }

        /* renamed from: c, reason: from kotlin metadata */
        /* operator */ public final ProgressDatabase invoke(Context context) {
            app.dogo.android.persistencedb.room.database.ProgressDatabase context2;
            app.dogo.android.persistencedb.room.database.ProgressDatabase.f fVar;
            n.f(context, "context");
            if (ProgressDatabase.o == null) {
                Object obj2 = ProgressDatabase.p;
                synchronized (obj2) {
                    context2 = ProgressDatabase.o;
                    ProgressDatabase.o = ProgressDatabase.n.buildDatabase(context);
                }
            }
            return context2;
        }

        public /* synthetic */ f(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(2, 3);
        }

        @Override // androidx.room.e1.b
        /* renamed from: a, reason: from kotlin metadata */
        public void migrate(d.s.a.g database) {
            n.f(database, "database");
            database.C("CREATE TABLE `RecommendedListOrderEntity` (`dogId` TEXT NOT NULL DEFAULT '', `recommendedProgramIds` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`dogId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_3_5$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends b {
        b() {
            super(3, 5);
        }

        @Override // androidx.room.e1.b
        /* renamed from: a, reason: from kotlin metadata */
        public void migrate(d.s.a.g database) {
            n.f(database, "database");
            database.C("CREATE TABLE `WorkoutInfoEntity` (`dogId` TEXT NOT NULL DEFAULT '', `cachedWorkoutTrickIdList` TEXT NOT NULL DEFAULT '[]', PRIMARY KEY(`dogId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_4_5$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends b {
        c() {
            super(4, 5);
        }

        @Override // androidx.room.e1.b
        /* renamed from: a, reason: from kotlin metadata */
        public void migrate(d.s.a.g database) {
            n.f(database, "database");
            database.C("DROP TABLE WorkoutInfoEntity");
            database.C("CREATE TABLE `WorkoutInfoEntity` (`dogId` TEXT NOT NULL DEFAULT '', `cachedWorkoutTrickIdList` TEXT NOT NULL DEFAULT '[]', PRIMARY KEY(`dogId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_5_6$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends b {
        d() {
            super(5, 6);
        }

        @Override // androidx.room.e1.b
        /* renamed from: a, reason: from kotlin metadata */
        public void migrate(d.s.a.g database) {
            Object[] strArr;
            String string;
            int i = 0;
            Object database2;
            String str;
            int i2 = 5;
            ContentValues contentValues;
            String str2;
            Object[] array;
            n.f(database, "database");
            database.C("ALTER TABLE `TrickKnowledgeEntity` ADD COLUMN `lastViewedAt` BIGINT DEFAULT 0");
            database.C("ALTER TABLE `TrickKnowledgeEntity` ADD COLUMN `lastRatedAt` BIGINT DEFAULT 0");
            Cursor cursor = database.H0("SELECT * FROM TrickKnowledgeEntity");
            n.e(cursor, "database.query(\"SELECT * FROM TrickKnowledgeEntity\")");
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                while (!cursor.isClosed()) {
                    long _long = cursor.getLong(cursor.getColumnIndex("updatedAt"));
                    contentValues = new ContentValues();
                    contentValues.put("lastViewedAt", Long.valueOf(_long));
                    contentValues.put("lastRatedAt", Long.valueOf(_long));
                    String[] strArr2 = new String[2];
                    i = 0;
                    strArr2[i] = cursor.getString(cursor.getColumnIndex("dogId"));
                    strArr2[1] = cursor.getString(cursor.getColumnIndex("trickId"));
                    i2 = 5;
                    array = p.j(strArr2).toArray(new String[i]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    str = "TrickKnowledgeEntity";
                    str2 = "dogId LIKE ? AND trickId LIKE ?";
                    database.y0(str, i2, contentValues, str2, array);
                }
            }
            database.C("ALTER TABLE `TrickKnowledgeEntity` RENAME TO `TrickProgressEntity`");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_6_7$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends b {
        e() {
            super(6, 7);
        }

        @Override // androidx.room.e1.b
        /* renamed from: a, reason: from kotlin metadata */
        public void migrate(d.s.a.g database) {
            String str;
            String str2;
            String string;
            ContentValues contentValues;
            ArrayList arrayList;
            boolean hasNext;
            RecommendedListOrderEntity.ProgramCompatibility recommendedListOrderEntity_ProgramCompatibility;
            int i2;
            Integer num;
            n.f(database, "database");
            database.C("CREATE TABLE new_recommended (dogId TEXT NOT NULL, recommendedProgramIds TEXT NOT NULL, PRIMARY KEY(dogId))");
            a dataConverter = new DataConverter();
            Cursor cursor = database.H0("SELECT * FROM RecommendedListOrderEntity");
            n.e(cursor, "database.query(\"SELECT * FROM RecommendedListOrderEntity\")");
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                while (!cursor.isClosed()) {
                    String str9 = "recommendedProgramIds";
                    str2 = "dogId";
                    String string2 = cursor.getString(cursor.getColumnIndex(str9));
                    contentValues = new ContentValues();
                    n.e(string2, "recommendedList");
                    java.util.List stringList = dataConverter.toStringList(string2);
                    arrayList = new ArrayList(p.r(stringList, 10));
                    Iterator it = stringList.iterator();
                    while (it.hasNext()) {
                        i2 = 2;
                        num = null;
                        arrayList.add(new RecommendedListOrderEntity_ProgramCompatibility((String)it.next(), num, i2, num));
                    }
                    contentValues.put(str2, cursor.getString(cursor.getColumnIndex(str2)));
                    contentValues.put(str9, dataConverter.fromProgramCompatibilityList(arrayList));
                    str = "new_recommended";
                    database.P0(str, 5, contentValues);
                    i2 = 2;
                    num = null;
                    arrayList.add(new RecommendedListOrderEntity_ProgramCompatibility((String)it.next(), num, i2, num));
                }
            }
            database.C("DROP TABLE RecommendedListOrderEntity");
            database.C("ALTER TABLE new_recommended RENAME TO RecommendedListOrderEntity");
        }
    }
    static {
        b[] arr = new b[5];
        ProgressDatabase.v = new b[] { bVar, bVar2, 0, bVar3, bVar4 };
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final /* synthetic */ b[] recommendedProgramListDab() {
        return ProgressDatabase.v;
    }

    public static final /* synthetic */ ProgressDatabase F() {
        return ProgressDatabase.o;
    }

    public static final /* synthetic */ Object G() {
        return ProgressDatabase.p;
    }

    public static final /* synthetic */ void H(ProgressDatabase progressDatabase) {
        ProgressDatabase.o = progressDatabase;
    }

    @Override // androidx.room.u0
    public abstract y I();

    @Override // androidx.room.u0
    public abstract o0 J();

    @Override // androidx.room.u0
    public abstract s0 K();
}
