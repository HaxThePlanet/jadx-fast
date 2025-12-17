package app.dogo.android.persistencedb.room.database;

import android.content.Context;
import androidx.room.t0;
import androidx.room.u0;
import androidx.room.u0.a;
import e.a.a.a.b.b.c0;
import e.a.a.a.b.b.e0;
import e.a.a.a.b.b.g0;
import e.a.a.a.b.b.i0;
import e.a.a.a.b.b.m0;
import e.a.a.a.b.b.q;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&J\u0008\u0010\u0007\u001a\u00020\u0008H&J\u0008\u0010\t\u001a\u00020\nH&J\u0008\u0010\u000b\u001a\u00020\u000cH&J\u0008\u0010\r\u001a\u00020\u000eH&¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/database/ContentDatabase;", "Landroidx/room/RoomDatabase;", "()V", "breedEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "onboardingSurveyDoa", "Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "programEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "questionEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "taskEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "trickEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ContentDatabase extends u0 {

    public static final app.dogo.android.persistencedb.room.database.ContentDatabase.a n;
    private static volatile app.dogo.android.persistencedb.room.database.ContentDatabase o;
    private static final Object p;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/android/persistencedb/room/database/ContentDatabase$Companion;", "", "()V", "LOCK", "instance", "Lapp/dogo/android/persistencedb/room/database/ContentDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        private final app.dogo.android.persistencedb.room.database.ContentDatabase a(Context context) {
            final String str2 = "content.db";
            u0.a obj3 = t0.a(context, ContentDatabase.class, str2);
            obj3.b();
            obj3.e();
            obj3.d(str2);
            obj3 = obj3.c();
            n.e(obj3, "databaseBuilder(context,\n            ContentDatabase::class.java, \"content.db\")\n            .allowMainThreadQueries()\n            .fallbackToDestructiveMigration()\n            .createFromAsset(\"content.db\")\n            .build()");
            return (ContentDatabase)obj3;
        }

        public final app.dogo.android.persistencedb.room.database.ContentDatabase b(Context context) {
            app.dogo.android.persistencedb.room.database.ContentDatabase contentDatabase;
            Object contentDatabase2;
            app.dogo.android.persistencedb.room.database.ContentDatabase obj3;
            n.f(context, "context");
            if (ContentDatabase.E() == null) {
                Object obj = ContentDatabase.F();
                contentDatabase2 = ContentDatabase.E();
                synchronized (obj) {
                    ContentDatabase.G(ContentDatabase.n.a(context));
                    contentDatabase = obj3;
                }
            }
            return contentDatabase;
        }
    }
    static {
        ContentDatabase.a aVar = new ContentDatabase.a(0);
        ContentDatabase.n = aVar;
        Object object = new Object();
        ContentDatabase.p = object;
    }

    public static final app.dogo.android.persistencedb.room.database.ContentDatabase E() {
        return ContentDatabase.o;
    }

    public static final Object F() {
        return ContentDatabase.p;
    }

    public static final void G(app.dogo.android.persistencedb.room.database.ContentDatabase contentDatabase) {
        ContentDatabase.o = contentDatabase;
    }

    @Override // androidx.room.u0
    public abstract q H();

    @Override // androidx.room.u0
    public abstract c0 I();

    @Override // androidx.room.u0
    public abstract e0 J();

    @Override // androidx.room.u0
    public abstract g0 K();

    @Override // androidx.room.u0
    public abstract i0 L();

    @Override // androidx.room.u0
    public abstract m0 M();
}
