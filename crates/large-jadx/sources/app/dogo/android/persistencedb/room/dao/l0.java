package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* compiled from: TrainingStreakEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class l0 implements k0 {

    private final u0 a;
    private final h0<TrainingStreakEntity> b = new l0$a<>();
    private final a c = new a();

    class c implements Callable<w> {

        final /* synthetic */ TrainingStreakEntity[] a;
        final /* synthetic */ l0 b;
        c(TrainingStreakEntity[] trainingStreakEntityArr) {
            this.b = l0Var;
            this.a = trainingStreakEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.l0 l0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class d implements Callable<TrainingStreakEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ l0 b;
        d(x0 x0Var) {
            this.b = l0Var;
            this.a = x0Var;
            super();
        }

        public TrainingStreakEntity a() {
            String string2 = null;
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            final Object obj3 = this;
            cancellationSignal = null;
            Cursor cursor = c.c(obj3.b.a, obj3.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "userId");
                int i5 = b.e(cursor, "trainingTimesSec");
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                if (!(cursor.isNull(i5))) {
                    string2 = cursor.getString(i5);
                }
                TrainingStreakEntity trainingStreakEntity = new TrainingStreakEntity(obj, cursor.getInt(b.e(cursor, "currentStreak")), cursor.getInt(b.e(cursor, "longestStreak")), obj3.b.c.toStringLongMap(string2), cursor.getLong(b.e(cursor, "totalTrainingTimeSec")), l, cursor.getLong(b.e(cursor, "remoteUpdateTimeMs")), obj4);
            } finally {
                x0Var2.close();
                obj2.a.j();
                throw th;
            }
            cursor.close();
            obj3.a.j();
            return cancellationSignal;
        }
    }

    class e implements Callable<Boolean> {

        final /* synthetic */ x0 a;
        final /* synthetic */ l0 b;
        e(x0 x0Var) {
            this.b = l0Var;
            this.a = x0Var;
            super();
        }

        public Boolean a() {
            android.os.CancellationSignal cancellationSignal;
            boolean z = false;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, z, cancellationSignal);
            try {
                if (cursor.isNull(z)) {
                } else {
                    Integer num = Integer.valueOf(cursor.getInt(z));
                }
                if (cancellationSignal.intValue() != 0) {
                    int i = 1;
                }
            } finally {
                x0Var.close();
                this.a.j();
                throw th;
            }
            cursor.close();
            this.a.j();
            return cancellationSignal;
        }
    }

    class a extends h0<TrainingStreakEntity> {

        final /* synthetic */ l0 d;
        a(u0 u0Var) {
            this.d = l0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, TrainingStreakEntity trainingStreakEntity) {
            int i5 = 1;
            if (trainingStreakEntity.getUserId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trainingStreakEntity.getUserId());
            }
            kVar.u0(2, (long)trainingStreakEntity.getCurrentStreak());
            kVar.u0(3, (long)trainingStreakEntity.getLongestStreak());
            String stringLongMap = this.d.c.fromStringLongMap(trainingStreakEntity.getTrainingTimesSec());
            int i6 = 4;
            if (stringLongMap == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, stringLongMap);
            }
            kVar.u0(5, trainingStreakEntity.getTotalTrainingTimeSec());
            kVar.u0(6, trainingStreakEntity.getRemoteUpdateTimeMs());
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrainingStreakEntity` (`userId`,`currentStreak`,`longestStreak`,`trainingTimesSec`,`totalTrainingTimeSec`,`remoteUpdateTimeMs`) VALUES (?,?,?,?,?,?)";
        }
    }

    class b extends g0<TrainingStreakEntity> {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, TrainingStreakEntity trainingStreakEntity) {
            final int i = 1;
            if (trainingStreakEntity.getUserId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, trainingStreakEntity.getUserId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrainingStreakEntity` WHERE `userId` = ?";
        }
    }
    public l0(u0 u0Var) {
        super();
        a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.l0.a aVar = new app.dogo.android.persistencedb.room.dao.l0.a(this, u0Var);
        e.a.a.a.b.b.l0.b bVar = new app.dogo.android.persistencedb.room.dao.l0.b(this, u0Var);
    }

    static /* synthetic */ a e(l0 l0Var) {
        return l0Var.c;
    }

    static /* synthetic */ u0 f(l0 l0Var) {
        return l0Var.a;
    }

    static /* synthetic */ h0 g(l0 l0Var) {
        return l0Var.b;
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    public Object a(String str, d<? super Boolean> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM TrainingStreakEntity WHERE userId = ?)", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.l0.e(this, x0Var), dVar);
    }

    public Object b(TrainingStreakEntity[] trainingStreakEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.l0.c(this, trainingStreakEntityArr), dVar);
    }

    public Object c(String str, d<? super TrainingStreakEntity> dVar) {
        return app.dogo.android.persistencedb.room.dao.k0.a.a(this, str, dVar);
    }

    public Object d(String str, d<? super TrainingStreakEntity> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrainingStreakEntity WHERE userId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.l0.d(this, x0Var), dVar);
    }
}
