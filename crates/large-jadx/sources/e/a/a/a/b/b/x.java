package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b1;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import app.dogo.android.persistencedb.room.entity.DogLocalStreakInfoUpdate;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import i.b.b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class x implements e.a.a.a.b.b.w {

    private final u0 a;
    private final h0<DogLocalEntity> b;
    private final g0<DogLocalStreakInfoUpdate> c;
    private final b1 d;
    private final b1 e;

    class a implements Callable<Boolean> {

        final x0 a;
        final e.a.a.a.b.b.x b;
        a(e.a.a.a.b.b.x x, x0 x02) {
            this.b = x;
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
            Cursor cursor = c.c(x.n(this.b), this.a, i, i2);
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
            if (i2 == 0) {
            } else {
                cursor.close();
                return i2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Query returned empty result set: ");
            stringBuilder.append(this.a.a());
            EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
            throw emptyResultSetException;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class f implements Callable<Void> {

        final DogLocalEntity[] a;
        final e.a.a.a.b.b.x b;
        f(e.a.a.a.b.b.x x, DogLocalEntity[] dogLocalEntity2Arr2) {
            this.b = x;
            this.a = dogLocalEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            x.n(this.b).c();
            x.o(this.b).i(this.a);
            x.n(this.b).C();
            x.n(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g implements Callable<Void> {

        final boolean a;
        final String b;
        final String c;
        final e.a.a.a.b.b.x v;
        g(e.a.a.a.b.b.x x, boolean z2, String string3, String string4) {
            this.v = x;
            this.a = z2;
            this.b = string3;
            this.c = string4;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            k kVar = x.p(this.v).a();
            kVar.u0(1, (long)z);
            int i = 2;
            String str = this.b;
            if (str == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, str);
            }
            int i2 = 3;
            String str2 = this.c;
            if (str2 == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, str2);
            }
            x.n(this.v).c();
            kVar.N();
            x.n(this.v).C();
            x.n(this.v).g();
            x.p(this.v).f(kVar);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class h implements Callable<Void> {

        final boolean a;
        final String b;
        final e.a.a.a.b.b.x c;
        h(e.a.a.a.b.b.x x, boolean z2, String string3) {
            this.c = x;
            this.a = z2;
            this.b = string3;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            k kVar = x.q(this.c).a();
            kVar.u0(1, (long)z);
            int i = 2;
            String str = this.b;
            if (str == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, str);
            }
            x.n(this.c).c();
            kVar.N();
            x.n(this.c).C();
            x.n(this.c).g();
            x.q(this.c).f(kVar);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class i implements Callable<DogLocalEntity> {

        final x0 a;
        final e.a.a.a.b.b.x b;
        i(e.a.a.a.b.b.x x, x0 x02) {
            this.b = x;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public DogLocalEntity a() {
            int string;
            int dogLocalEntity;
            int i4;
            boolean moveToFirst;
            String str;
            int i;
            int i2;
            int i3;
            int int2;
            int int;
            long long;
            final Object obj = this;
            int i5 = 0;
            dogLocalEntity = 0;
            Cursor cursor = c.c(x.n(obj.b), obj.a, i5, dogLocalEntity);
            string = b.e(cursor, "dogId");
            int i6 = b.e(cursor, "workoutUnlockSource");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string)) {
                    str = dogLocalEntity;
                } else {
                    str = string;
                }
                i4 = 1;
                i = cursor.getInt(b.e(cursor, "workoutUnlocked")) != 0 ? i4 : i5;
                if (!cursor.isNull(i6)) {
                    dogLocalEntity = cursor.getString(i6);
                }
                i3 = cursor.getInt(b.e(cursor, "workoutUnlockScreenShown")) != 0 ? i4 : i5;
                super(str, i, dogLocalEntity, i3, cursor.getInt(b.e(cursor, "longestStreak")), cursor.getInt(b.e(cursor, "currentStreak")), cursor.getLong(b.e(cursor, "lastAchievedStreakTimestampMs")), obj19);
            }
            if (dogLocalEntity == 0) {
            } else {
                cursor.close();
                return dogLocalEntity;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Query returned empty result set: ");
                stringBuilder.append(obj.a.a());
                EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
                throw emptyResultSetException;
                obj2.close();
                throw th;
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class j implements Callable<String> {

        final x0 a;
        final e.a.a.a.b.b.x b;
        j(e.a.a.a.b.b.x x, x0 x02) {
            this.b = x;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public String a() {
            boolean moveToFirst;
            int string;
            int i = 0;
            Cursor cursor = c.c(x.n(this.b), this.a, i, 0);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
            }
            if (string == null) {
            } else {
                cursor.close();
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Query returned empty result set: ");
            stringBuilder.append(this.a.a());
            EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
            throw emptyResultSetException;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class d extends b1 {
        d(e.a.a.a.b.b.x x, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "Update DogLocalEntity SET workoutUnlocked = ?, workoutUnlockSource = ?  WHERE dogId = ? ";
        }
    }

    class e extends b1 {
        e(e.a.a.a.b.b.x x, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "Update DogLocalEntity SET workoutUnlockScreenShown = ? WHERE dogId = ? ";
        }
    }

    class b extends h0<DogLocalEntity> {
        b(e.a.a.a.b.b.x x, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `DogLocalEntity` (`dogId`,`workoutUnlocked`,`workoutUnlockSource`,`workoutUnlockScreenShown`,`longestStreak`,`currentStreak`,`lastAchievedStreakTimestampMs`) VALUES (?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (DogLocalEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, DogLocalEntity dogLocalEntity2) {
            String dogId;
            String workoutUnlockSource;
            int i4 = 1;
            if (dogLocalEntity2.getDogId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, dogLocalEntity2.getDogId());
            }
            k.u0(2, (long)workoutUnlocked);
            int i6 = 3;
            if (dogLocalEntity2.getWorkoutUnlockSource() == null) {
                k.k1(i6);
            } else {
                k.D(i6, dogLocalEntity2.getWorkoutUnlockSource());
            }
            long l4 = (long)workoutUnlockScreenShown;
            k.u0(4, l4);
            k.u0(5, (long)longestStreak);
            k.u0(6, (long)currentStreak);
            k.u0(7, dogLocalEntity2.getLastAchievedStreakTimestampMs());
        }
    }

    class c extends g0<DogLocalStreakInfoUpdate> {
        c(e.a.a.a.b.b.x x, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `DogLocalEntity` SET `dogId` = ?,`longestStreak` = ?,`currentStreak` = ?,`lastAchievedStreakTimestampMs` = ? WHERE `dogId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (DogLocalStreakInfoUpdate)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate2) {
            String dogId;
            String obj5;
            int i4 = 1;
            if (dogLocalStreakInfoUpdate2.getDogId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, dogLocalStreakInfoUpdate2.getDogId());
            }
            k.u0(2, (long)longestStreak);
            k.u0(3, (long)currentStreak);
            k.u0(4, dogLocalStreakInfoUpdate2.getLastAchievedStreakTimestampMs());
            int i5 = 5;
            if (dogLocalStreakInfoUpdate2.getDogId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, dogLocalStreakInfoUpdate2.getDogId());
            }
        }
    }
    public x(u0 u0) {
        super();
        this.a = u0;
        x.b bVar = new x.b(this, u0);
        this.b = bVar;
        x.c cVar = new x.c(this, u0);
        this.c = cVar;
        x.d dVar = new x.d(this, u0);
        this.d = dVar;
        x.e eVar = new x.e(this, u0);
        this.e = eVar;
    }

    static u0 n(e.a.a.a.b.b.x x) {
        return x.a;
    }

    static h0 o(e.a.a.a.b.b.x x) {
        return x.b;
    }

    static b1 p(e.a.a.a.b.b.x x) {
        return x.d;
    }

    static b1 q(e.a.a.a.b.b.x x) {
        return x.e;
    }

    public static List<Class<?>> r() {
        return Collections.emptyList();
    }

    @Override // e.a.a.a.b.b.w
    public b a(String string, String string2) {
        return w.a.j(this, string, string2);
    }

    @Override // e.a.a.a.b.b.w
    public void b(DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate) {
        this.a.b();
        this.a.c();
        this.c.h(dogLocalStreakInfoUpdate);
        this.a.C();
        this.a.g();
    }

    @Override // e.a.a.a.b.b.w
    public b c(String string) {
        return w.a.i(this, string);
    }

    @Override // e.a.a.a.b.b.w
    public b d(String string, boolean z2, String string3) {
        x.g gVar = new x.g(this, z2, string3, string);
        return b.o(gVar);
    }

    public a0<String> e(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT workoutUnlockSource FROM DogLocalEntity WHERE dogId = ? ", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        x.j obj3 = new x.j(this, x0Var);
        return y0.a(obj3);
    }

    @Override // e.a.a.a.b.b.w
    public void f(String string, int i2, int i3, long l4) {
        w.a.k(this, string, i2, i3, l4);
    }

    public a0<String> g(String string) {
        return w.a.e(this, string);
    }

    public a0<Boolean> h(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM DogLocalEntity WHERE dogId = ?)", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        x.a obj3 = new x.a(this, x0Var);
        return y0.a(obj3);
    }

    public a0<DogLocalEntity> i(String string) {
        return w.a.c(this, string);
    }

    @Override // e.a.a.a.b.b.w
    public void j(String string, int i2) {
        w.a.h(this, string, i2);
    }

    public a0<DogLocalEntity> k(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM DogLocalEntity WHERE dogId = ? ", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        x.i obj3 = new x.i(this, x0Var);
        return y0.a(obj3);
    }

    @Override // e.a.a.a.b.b.w
    public b l(DogLocalEntity... dogLocalEntityArr) {
        x.f fVar = new x.f(this, dogLocalEntityArr);
        return b.o(fVar);
    }

    @Override // e.a.a.a.b.b.w
    public b m(String string, boolean z2) {
        x.h hVar = new x.h(this, z2, string);
        return b.o(hVar);
    }
}
