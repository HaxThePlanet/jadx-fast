package app.dogo.android.persistencedb.room.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.room.e1.b;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility;
import d.s.a.g;
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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&J\u0008\u0010\u0007\u001a\u00020\u0008H&¨\u0006\n", d2 = {"Lapp/dogo/android/persistencedb/room/database/ProgressDatabase;", "Landroidx/room/RoomDatabase;", "()V", "recommendedProgramListDab", "Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "workoutInfoDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ProgressDatabase extends u0 {

    public static final app.dogo.android.persistencedb.room.database.ProgressDatabase.f n;
    private static volatile app.dogo.android.persistencedb.room.database.ProgressDatabase o;
    private static final Object p;
    private static final b q;
    private static final b r;
    private static final b s;
    private static final b t;
    private static final b u;
    private static final b[] v;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0011\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0002R\u0019\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000cR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/android/persistencedb/room/database/ProgressDatabase$Companion;", "", "()V", "ALL_MIGRATIONS", "", "Landroidx/room/migration/Migration;", "getALL_MIGRATIONS", "()[Landroidx/room/migration/Migration;", "[Landroidx/room/migration/Migration;", "LOCK", "MIGRATION_2_3", "getMIGRATION_2_3", "()Landroidx/room/migration/Migration;", "MIGRATION_3_5", "getMIGRATION_3_5", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "instance", "Lapp/dogo/android/persistencedb/room/database/ProgressDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f {
        public f(g g) {
            super();
        }

        private final app.dogo.android.persistencedb.room.database.ProgressDatabase a(Context context) {
            u0.a obj3 = t0.a(context, ProgressDatabase.class, "progress.db");
            obj3.b();
            b[] objArr = b();
            obj3.a((b[])Arrays.copyOf(objArr, objArr.length));
            obj3.f();
            obj3 = obj3.c();
            n.e(obj3, "databaseBuilder(context,\n            ProgressDatabase::class.java, \"progress.db\")\n            .allowMainThreadQueries()\n            .addMigrations(*ALL_MIGRATIONS)\n            .fallbackToDestructiveMigrationOnDowngrade()\n            .build()");
            return (ProgressDatabase)obj3;
        }

        public final b[] b() {
            return ProgressDatabase.E();
        }

        public final app.dogo.android.persistencedb.room.database.ProgressDatabase c(Context context) {
            app.dogo.android.persistencedb.room.database.ProgressDatabase progressDatabase2;
            Object progressDatabase;
            app.dogo.android.persistencedb.room.database.ProgressDatabase obj3;
            n.f(context, "context");
            if (ProgressDatabase.F() == null) {
                Object obj = ProgressDatabase.G();
                progressDatabase = ProgressDatabase.F();
                synchronized (obj) {
                    ProgressDatabase.H(ProgressDatabase.n.a(context));
                    progressDatabase2 = obj3;
                }
            }
            return progressDatabase2;
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(2, 3);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("CREATE TABLE `RecommendedListOrderEntity` (`dogId` TEXT NOT NULL DEFAULT '', `recommendedProgramIds` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`dogId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_3_5$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends b {
        b() {
            super(3, 5);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("CREATE TABLE `WorkoutInfoEntity` (`dogId` TEXT NOT NULL DEFAULT '', `cachedWorkoutTrickIdList` TEXT NOT NULL DEFAULT '[]', PRIMARY KEY(`dogId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_4_5$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends b {
        c() {
            super(4, 5);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("DROP TABLE WorkoutInfoEntity");
            g.C("CREATE TABLE `WorkoutInfoEntity` (`dogId` TEXT NOT NULL DEFAULT '', `cachedWorkoutTrickIdList` TEXT NOT NULL DEFAULT '[]', PRIMARY KEY(`dogId`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_5_6$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends b {
        d() {
            super(5, 6);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            int closed;
            String[] strArr;
            String string;
            int i;
            Object obj;
            String str2;
            int i2;
            ContentValues contentValues;
            String str;
            Object[] array;
            n.f(g, "database");
            g.C("ALTER TABLE `TrickKnowledgeEntity` ADD COLUMN `lastViewedAt` BIGINT DEFAULT 0");
            g.C("ALTER TABLE `TrickKnowledgeEntity` ADD COLUMN `lastRatedAt` BIGINT DEFAULT 0");
            Cursor cursor = g.H0("SELECT * FROM TrickKnowledgeEntity");
            n.e(cursor, "database.query(\"SELECT * FROM TrickKnowledgeEntity\")");
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                while (!cursor.isClosed()) {
                    long long = cursor.getLong(cursor.getColumnIndex("updatedAt"));
                    contentValues = new ContentValues();
                    contentValues.put("lastViewedAt", Long.valueOf(long));
                    contentValues.put("lastRatedAt", Long.valueOf(long));
                    String[] strArr2 = new String[2];
                    i = 0;
                    strArr2[i] = cursor.getString(cursor.getColumnIndex("dogId"));
                    strArr2[1] = cursor.getString(cursor.getColumnIndex("trickId"));
                    array = p.j(strArr2).toArray(new String[i]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    g.y0("TrickKnowledgeEntity", 5, contentValues, "dogId LIKE ? AND trickId LIKE ?", array);
                    if (cursor.isLast() == 0) {
                    } else {
                    }
                    cursor.close();
                    cursor.moveToNext();
                }
            }
            g.C("ALTER TABLE `TrickKnowledgeEntity` RENAME TO `TrickProgressEntity`");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/ProgressDatabase$Companion$MIGRATION_6_7$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends b {
        e() {
            super(6, 7);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            int closed;
            String str2;
            String str;
            String string;
            ContentValues contentValues;
            ArrayList arrayList;
            boolean next;
            int next2;
            RecommendedListOrderEntity.ProgramCompatibility programCompatibility;
            int i;
            int i2;
            n.f(g, "database");
            g.C("CREATE TABLE new_recommended (dogId TEXT NOT NULL, recommendedProgramIds TEXT NOT NULL, PRIMARY KEY(dogId))");
            a aVar = new a();
            Cursor cursor = g.H0("SELECT * FROM RecommendedListOrderEntity");
            n.e(cursor, "database.query(\"SELECT * FROM RecommendedListOrderEntity\")");
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                while (!cursor.isClosed()) {
                    String str9 = "recommendedProgramIds";
                    str = "dogId";
                    String string2 = cursor.getString(cursor.getColumnIndex(str9));
                    contentValues = new ContentValues();
                    n.e(string2, "recommendedList");
                    java.util.List list = aVar.j(string2);
                    arrayList = new ArrayList(p.r(list, 10));
                    Iterator iterator = list.iterator();
                    for (String next2 : iterator) {
                        i2 = 0;
                        programCompatibility = new RecommendedListOrderEntity.ProgramCompatibility(next2, i2, 2, i2);
                        arrayList.add(programCompatibility);
                    }
                    contentValues.put(str, cursor.getString(cursor.getColumnIndex(str)));
                    contentValues.put(str9, aVar.c(arrayList));
                    g.P0("new_recommended", 5, contentValues);
                    if (cursor.isLast() == 0) {
                    } else {
                    }
                    cursor.close();
                    cursor.moveToNext();
                    i2 = 0;
                    programCompatibility = new RecommendedListOrderEntity.ProgramCompatibility((String)iterator.next(), i2, 2, i2);
                    arrayList.add(programCompatibility);
                }
            }
            g.C("DROP TABLE RecommendedListOrderEntity");
            g.C("ALTER TABLE new_recommended RENAME TO RecommendedListOrderEntity");
        }
    }
    static {
        ProgressDatabase.f fVar = new ProgressDatabase.f(0);
        ProgressDatabase.n = fVar;
        Object object = new Object();
        ProgressDatabase.p = object;
        ProgressDatabase.a aVar = new ProgressDatabase.a();
        ProgressDatabase.q = aVar;
        ProgressDatabase.c cVar = new ProgressDatabase.c();
        ProgressDatabase.r = cVar;
        ProgressDatabase.b bVar = new ProgressDatabase.b();
        ProgressDatabase.s = bVar;
        ProgressDatabase.d dVar = new ProgressDatabase.d();
        ProgressDatabase.t = dVar;
        ProgressDatabase.e eVar = new ProgressDatabase.e();
        ProgressDatabase.u = eVar;
        b[] arr = new b[5];
        ProgressDatabase.v = arr;
    }

    public static final b[] E() {
        return ProgressDatabase.v;
    }

    public static final app.dogo.android.persistencedb.room.database.ProgressDatabase F() {
        return ProgressDatabase.o;
    }

    public static final Object G() {
        return ProgressDatabase.p;
    }

    public static final void H(app.dogo.android.persistencedb.room.database.ProgressDatabase progressDatabase) {
        ProgressDatabase.o = progressDatabase;
    }

    @Override // androidx.room.u0
    public abstract y I();

    @Override // androidx.room.u0
    public abstract o0 J();

    @Override // androidx.room.u0
    public abstract s0 K();
}
