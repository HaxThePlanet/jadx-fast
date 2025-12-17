package app.dogo.android.persistencedb.room.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.room.e1.b;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import d.s.a.g;
import e.a.a.a.b.b.k0;
import e.a.a.a.b.b.q0;
import e.a.a.a.b.b.u;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&J\u0008\u0010\u0007\u001a\u00020\u0008H&¨\u0006\n", d2 = {"Lapp/dogo/android/persistencedb/room/database/UserDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dogDoa", "Lapp/dogo/android/persistencedb/room/dao/DogEntityDao;", "trainingStreakDao", "Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;", "userDoa", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class UserDatabase extends u0 {

    public static final app.dogo.android.persistencedb.room.database.UserDatabase.c n;
    private static volatile app.dogo.android.persistencedb.room.database.UserDatabase o;
    private static final Object p;
    private static final b q;
    private static final b r;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0011\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/database/UserDatabase$Companion;", "", "()V", "LOCK", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_3_4", "getMIGRATION_3_4", "instance", "Lapp/dogo/android/persistencedb/room/database/UserDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        public c(g g) {
            super();
        }

        private final app.dogo.android.persistencedb.room.database.UserDatabase a(Context context) {
            u0.a obj4 = t0.a(context, UserDatabase.class, "userDatabase.db");
            b[] arr = new b[2];
            obj4.a(b(), c());
            obj4.b();
            obj4.f();
            obj4 = obj4.c();
            n.e(obj4, "databaseBuilder(context, UserDatabase::class.java, \"userDatabase.db\")\n            .addMigrations(MIGRATION_1_2, MIGRATION_3_4)\n            .allowMainThreadQueries()\n            .fallbackToDestructiveMigrationOnDowngrade()\n            .build()");
            return (UserDatabase)obj4;
        }

        public final b b() {
            return UserDatabase.G();
        }

        public final b c() {
            return UserDatabase.H();
        }

        public final app.dogo.android.persistencedb.room.database.UserDatabase d(Context context) {
            app.dogo.android.persistencedb.room.database.UserDatabase userDatabase;
            Object userDatabase2;
            app.dogo.android.persistencedb.room.database.UserDatabase obj3;
            n.f(context, "context");
            if (UserDatabase.E() == null) {
                Object obj = UserDatabase.F();
                userDatabase2 = UserDatabase.E();
                synchronized (obj) {
                    UserDatabase.I(UserDatabase.n.a(context));
                    userDatabase = obj3;
                }
            }
            return userDatabase;
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/UserDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b {
        a() {
            super(1, 2);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            n.f(g, "database");
            g.C("CREATE TABLE `PottyReminderEntity` (`id` INT NOT NULL DEFAULT '', `dogId` TEXT NOT NULL DEFAULT '', `ownerId` TEXT NOT NULL DEFAULT '', `days` TEXT NOT NULL DEFAULT '', `startTime` TEXT NOT NULL DEFAULT '', `endTime` TEXT NOT NULL DEFAULT '', `repeatIntervalMs` BIGINT DEFAULT NULL, `isActive` INTEGER NOT NULL DEFAULT '', PRIMARY KEY(`id`))");
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/android/persistencedb/room/database/UserDatabase$Companion$MIGRATION_3_4$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends b {
        b() {
            super(3, 4);
        }

        @Override // androidx.room.e1.b
        public void a(g g) {
            Object obj2;
            Cursor cursor;
            int closed;
            Object obj;
            String str6;
            String string3;
            String str7;
            String string;
            String str4;
            String string4;
            String str5;
            String string2;
            String str2;
            int int;
            String str3;
            int int2;
            Cursor cursor2;
            String str;
            obj2 = g;
            n.f(obj2, "database");
            obj2.C("CREATE TABLE `new_potty_reminder_entity` (`reminderId` TEXT NOT NULL DEFAULT '', `dogId` TEXT NOT NULL DEFAULT '', `ownerId` TEXT NOT NULL DEFAULT '', `days` TEXT NOT NULL DEFAULT '', `startTime` TEXT NOT NULL DEFAULT '', `endTime` TEXT NOT NULL DEFAULT '', `repeatIntervalMs` BIGINT DEFAULT NULL, `isActive` INTEGER NOT NULL DEFAULT '', PRIMARY KEY(`reminderId`))");
            cursor = obj2.H0("SELECT * FROM PottyReminderEntity");
            n.e(cursor, "database.query(\"SELECT * FROM PottyReminderEntity\")");
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                while (!cursor.isClosed()) {
                    String str14 = "dogId";
                    str6 = "ownerId";
                    str7 = "days";
                    str4 = "startTime";
                    str5 = "endTime";
                    str2 = "repeatIntervalMs";
                    String str16 = "isActive";
                    cursor2 = cursor;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("reminderId", UUID.randomUUID().toString());
                    contentValues.put(str14, cursor.getString(cursor.getColumnIndex(str14)));
                    contentValues.put(str6, cursor.getString(cursor.getColumnIndex(str6)));
                    contentValues.put(str7, cursor.getString(cursor.getColumnIndex(str7)));
                    contentValues.put(str4, cursor.getString(cursor.getColumnIndex(str4)));
                    contentValues.put(str5, cursor.getString(cursor.getColumnIndex(str5)));
                    contentValues.put(str2, Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str2))));
                    contentValues.put(str16, Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str16))));
                    obj = g;
                    obj.P0("new_potty_reminder_entity", 5, contentValues);
                    if (!cursor2.isLast()) {
                    } else {
                    }
                    cursor2.close();
                    obj2 = obj;
                    cursor = cursor2;
                    cursor2.moveToNext();
                }
            }
            Object obj3 = obj2;
            obj3.C("DROP TABLE PottyReminderEntity");
            obj3.C("ALTER TABLE new_potty_reminder_entity RENAME TO PottyReminderEntity");
        }
    }
    static {
        UserDatabase.c cVar = new UserDatabase.c(0);
        UserDatabase.n = cVar;
        Object object = new Object();
        UserDatabase.p = object;
        UserDatabase.a aVar = new UserDatabase.a();
        UserDatabase.q = aVar;
        UserDatabase.b bVar = new UserDatabase.b();
        UserDatabase.r = bVar;
    }

    public static final app.dogo.android.persistencedb.room.database.UserDatabase E() {
        return UserDatabase.o;
    }

    public static final Object F() {
        return UserDatabase.p;
    }

    public static final b G() {
        return UserDatabase.q;
    }

    public static final b H() {
        return UserDatabase.r;
    }

    public static final void I(app.dogo.android.persistencedb.room.database.UserDatabase userDatabase) {
        UserDatabase.o = userDatabase;
    }

    @Override // androidx.room.u0
    public abstract u J();

    @Override // androidx.room.u0
    public abstract k0 K();

    @Override // androidx.room.u0
    public abstract q0 L();
}
