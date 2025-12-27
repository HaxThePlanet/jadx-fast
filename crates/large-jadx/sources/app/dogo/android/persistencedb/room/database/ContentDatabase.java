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

/* compiled from: ContentDatabase.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&J\u0008\u0010\u0007\u001a\u00020\u0008H&J\u0008\u0010\t\u001a\u00020\nH&J\u0008\u0010\u000b\u001a\u00020\u000cH&J\u0008\u0010\r\u001a\u00020\u000eH&¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/database/ContentDatabase;", "Landroidx/room/RoomDatabase;", "()V", "breedEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "onboardingSurveyDoa", "Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "programEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "questionEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "taskEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "trickEntityDoa", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class ContentDatabase extends u0 {

    public static final ContentDatabase.a n = new ContentDatabase$a(0);
    private static volatile ContentDatabase o;
    private static final Object p = new Object();

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/android/persistencedb/room/database/ContentDatabase$Companion;", "", "()V", "LOCK", "instance", "Lapp/dogo/android/persistencedb/room/database/ContentDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        private final ContentDatabase buildDatabase(Context context) {
            final String str2 = "content.db";
            u0.a aVar = t0.a(context, ContentDatabase.class, str2);
            aVar.b();
            aVar.e();
            aVar.d(str2);
            u0 u0Var = aVar.c();
            n.e(u0Var, "databaseBuilder(context,\n            ContentDatabase::class.java, \"content.db\")\n            .allowMainThreadQueries()\n            .fallbackToDestructiveMigration()\n            .createFromAsset(\"content.db\")\n            .build()");
            return u0Var;
        }

        /* renamed from: b, reason: from kotlin metadata */
        /* operator */ public final ContentDatabase invoke(Context context) {
            app.dogo.android.persistencedb.room.database.ContentDatabase context2;
            app.dogo.android.persistencedb.room.database.ContentDatabase.a aVar;
            n.f(context, "context");
            if (ContentDatabase.o == null) {
                Object obj2 = ContentDatabase.p;
                synchronized (obj2) {
                    context2 = ContentDatabase.o;
                    ContentDatabase.o = ContentDatabase.n.buildDatabase(context);
                }
            }
            return context2;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final /* synthetic */ ContentDatabase breedEntityDoa() {
        return ContentDatabase.o;
    }

    public static final /* synthetic */ Object F() {
        return ContentDatabase.p;
    }

    public static final /* synthetic */ void G(ContentDatabase contentDatabase) {
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
