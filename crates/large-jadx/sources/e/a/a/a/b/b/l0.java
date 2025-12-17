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

/* loaded from: classes.dex */
public final class l0 implements e.a.a.a.b.b.k0 {

    private final u0 a;
    private final h0<TrainingStreakEntity> b;
    private final a c;

    class c implements Callable<w> {

        final TrainingStreakEntity[] a;
        final e.a.a.a.b.b.l0 b;
        c(e.a.a.a.b.b.l0 l0, TrainingStreakEntity[] trainingStreakEntity2Arr2) {
            this.b = l0;
            this.a = trainingStreakEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            l0.f(this.b).c();
            l0.g(this.b).i(this.a);
            l0.f(this.b).C();
            l0.f(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<TrainingStreakEntity> {

        final x0 a;
        final e.a.a.a.b.b.l0 b;
        d(e.a.a.a.b.b.l0 l0, x0 x02) {
            this.b = l0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public TrainingStreakEntity a() {
            String string;
            String trainingStreakEntity;
            boolean moveToFirst;
            String str;
            int int;
            int int2;
            java.util.Map map;
            long long;
            long long2;
            final Object obj = this;
            trainingStreakEntity = 0;
            Cursor cursor = c.c(l0.f(obj.b), obj.a, false, trainingStreakEntity);
            string = b.e(cursor, "userId");
            int i4 = b.e(cursor, "trainingTimesSec");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string)) {
                    str = trainingStreakEntity;
                } else {
                    str = string;
                }
                if (cursor.isNull(i4)) {
                } else {
                    trainingStreakEntity = cursor.getString(i4);
                }
                super(str, cursor.getInt(b.e(cursor, "currentStreak")), cursor.getInt(b.e(cursor, "longestStreak")), l0.e(obj.b).k(trainingStreakEntity), cursor.getLong(b.e(cursor, "totalTrainingTimeSec")), obj15, cursor.getLong(b.e(cursor, "remoteUpdateTimeMs")), obj17);
            }
            cursor.close();
            obj.a.j();
            return trainingStreakEntity;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<Boolean> {

        final x0 a;
        final e.a.a.a.b.b.l0 b;
        e(e.a.a.a.b.b.l0 l0, x0 x02) {
            this.b = l0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Boolean a() {
            boolean moveToFirst;
            int i;
            int i2;
            i = 0;
            i2 = 0;
            Cursor cursor = c.c(l0.f(this.b), this.a, i, i2);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i)) {
                    moveToFirst = i2;
                } else {
                    moveToFirst = Integer.valueOf(cursor.getInt(i));
                }
                if (moveToFirst == null) {
                } else {
                    if (moveToFirst.intValue() != 0) {
                        i = 1;
                    }
                    i2 = moveToFirst;
                }
            }
            cursor.close();
            this.a.j();
            return i2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a extends h0<TrainingStreakEntity> {

        final e.a.a.a.b.b.l0 d;
        a(e.a.a.a.b.b.l0 l0, u0 u02) {
            this.d = l0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrainingStreakEntity` (`userId`,`currentStreak`,`longestStreak`,`trainingTimesSec`,`totalTrainingTimeSec`,`remoteUpdateTimeMs`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrainingStreakEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrainingStreakEntity trainingStreakEntity2) {
            String userId;
            int i5 = 1;
            if (trainingStreakEntity2.getUserId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trainingStreakEntity2.getUserId());
            }
            k.u0(2, (long)currentStreak);
            k.u0(3, (long)longestStreak);
            String str = l0.e(this.d).e(trainingStreakEntity2.getTrainingTimesSec());
            int i6 = 4;
            if (str == null) {
                k.k1(i6);
            } else {
                k.D(i6, str);
            }
            k.u0(5, trainingStreakEntity2.getTotalTrainingTimeSec());
            k.u0(6, trainingStreakEntity2.getRemoteUpdateTimeMs());
        }
    }

    class b extends g0<TrainingStreakEntity> {
        b(e.a.a.a.b.b.l0 l0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrainingStreakEntity` WHERE `userId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrainingStreakEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrainingStreakEntity trainingStreakEntity2) {
            String obj4;
            final int i = 1;
            if (trainingStreakEntity2.getUserId() == null) {
                k.k1(i);
            } else {
                k.D(i, trainingStreakEntity2.getUserId());
            }
        }
    }
    public l0(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        l0.a aVar2 = new l0.a(this, u0);
        this.b = aVar2;
        l0.b bVar = new l0.b(this, u0);
    }

    static a e(e.a.a.a.b.b.l0 l0) {
        return l0.c;
    }

    static u0 f(e.a.a.a.b.b.l0 l0) {
        return l0.a;
    }

    static h0 g(e.a.a.a.b.b.l0 l0) {
        return l0.b;
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    public Object a(String string, d<? super Boolean> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM TrainingStreakEntity WHERE userId = ?)", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        l0.e eVar = new l0.e(this, x0Var);
        return c0.a(this.a, false, c.a(), eVar, d2);
    }

    public Object b(TrainingStreakEntity[] trainingStreakEntityArr, d<? super w> d2) {
        l0.c cVar = new l0.c(this, trainingStreakEntityArr);
        return c0.b(this.a, true, cVar, d2);
    }

    public Object c(String string, d<? super TrainingStreakEntity> d2) {
        return k0.a.a(this, string, d2);
    }

    public Object d(String string, d<? super TrainingStreakEntity> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrainingStreakEntity WHERE userId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        l0.d dVar = new l0.d(this, x0Var);
        return c0.a(this.a, false, c.a(), dVar, d2);
    }
}
