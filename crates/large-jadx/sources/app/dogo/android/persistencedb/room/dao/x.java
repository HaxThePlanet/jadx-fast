package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b1;
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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: DogLocalEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class x implements w {

    private final u0 a;
    private final h0<DogLocalEntity> b = new x$b<>();
    private final g0<DogLocalStreakInfoUpdate> c = new x$c<>();
    private final b1 d = new x$d();
    private final b1 e = new x$e();

    class a implements Callable<Boolean> {

        final /* synthetic */ x0 a;
        final /* synthetic */ x b;
        a(x0 x0Var) {
            this.b = xVar;
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
                obj.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Query returned empty result set: ";
                    String str3 = this.a.a();
                    r2 = str2 + str3;
                    throw new EmptyResultSetException(r2);
                } finally {
                    obj.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class f implements Callable<Void> {

        final /* synthetic */ DogLocalEntity[] a;
        final /* synthetic */ x b;
        f(DogLocalEntity[] dogLocalEntityArr) {
            this.b = xVar;
            this.a = dogLocalEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.x xVar4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class g implements Callable<Void> {

        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ x v;
        g(boolean z, String str, String str2) {
            this.v = xVar;
            this.a = z;
            this.b = str;
            this.c = str2;
            super();
        }

        public Void a() {
            k kVar2 = this.v.d.a();
            kVar2.u0(1, this.a != 0 ? 1 : 0);
            int i = 2;
            if (this.b == null) {
                kVar2.k1(i);
            } else {
                kVar2.D(i, this.b);
            }
            int i2 = 3;
            if (this.c == null) {
                kVar2.k1(i2);
            } else {
                kVar2.D(i2, this.c);
            }
            this.v.a.c();
            try {
                kVar2.N();
                this.v.a.C();
            } finally {
                e.a.a.a.b.b.x xVar4 = this.v.a;
                this.v.g();
                xVar4 = this.v.d;
                this.v.f(kVar);
                throw th;
            }
            this.v.a.g();
            this.v.d.f(kVar2);
            return null;
        }
    }

    class h implements Callable<Void> {

        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ x c;
        h(boolean z, String str) {
            this.c = xVar;
            this.a = z;
            this.b = str;
            super();
        }

        public Void a() {
            k kVar2 = this.c.e.a();
            kVar2.u0(1, this.a != 0 ? 1 : 0);
            int i = 2;
            if (this.b == null) {
                kVar2.k1(i);
            } else {
                kVar2.D(i, this.b);
            }
            this.c.a.c();
            try {
                kVar2.N();
                this.c.a.C();
            } finally {
                e.a.a.a.b.b.x xVar4 = this.c.a;
                this.c.g();
                xVar4 = this.c.e;
                this.c.f(kVar);
                throw th;
            }
            this.c.a.g();
            this.c.e.f(kVar2);
            return null;
        }
    }

    class i implements Callable<DogLocalEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ x b;
        i(x0 x0Var) {
            this.b = xVar;
            this.a = x0Var;
            super();
        }

        public DogLocalEntity a() {
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            boolean z;
            final Object obj3 = this;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(obj3.b.a, obj3.a, z, cancellationSignal);
            try {
                int _int = b.e(cursor, "dogId");
                int i2 = b.e(cursor, "workoutUnlockSource");
                if (cursor.moveToFirst()) {
                    cancellationSignal = cursor.isNull(_int) ? cancellationSignal : string;
                    int i = 1;
                    int r13 = cursor.getInt(b.e(cursor, "workoutUnlocked")) != 0 ? i : z;
                    if (!obj3.a.isNull(i2)) {
                        Object string2 = cursor.getString(i2);
                    }
                    int r15 = cursor.getInt(b.e(cursor, "workoutUnlockScreenShown")) != 0 ? i : z;
                    DogLocalEntity dogLocalEntity = new DogLocalEntity(obj, z, cancellationSignal, (cursor.getInt(b.e(cursor, "workoutUnlockScreenShown")) != 0 ? i : z), obj3.a.getInt(b.e(cursor, "longestStreak")), obj3.a.getInt(b.e(cursor, "currentStreak")), obj3.a.getLong(b.e(cursor, "lastAchievedStreakTimestampMs")), obj5);
                }
            } finally {
                obj4.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Query returned empty result set: ";
                    String str3 = obj3.a.a();
                    r3 = str2 + str3;
                    throw new EmptyResultSetException(r3);
                } finally {
                    obj4.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class j implements Callable<String> {

        final /* synthetic */ x0 a;
        final /* synthetic */ x b;
        j(x0 x0Var) {
            this.b = xVar;
            this.a = x0Var;
            super();
        }

        public String a() {
            android.os.CancellationSignal cancellationSignal = null;
            boolean z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, z, cancellationSignal);
            try {
                if (cursor.moveToFirst()) {
                    if (!(cursor.isNull(z))) {
                        String string = cursor.getString(z);
                    }
                }
            } finally {
                obj.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Query returned empty result set: ";
                    String str2 = this.a.a();
                    r2 = str + str2;
                    throw new EmptyResultSetException(r2);
                } finally {
                    obj.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class d extends b1 {
        d(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "Update DogLocalEntity SET workoutUnlocked = ?, workoutUnlockSource = ?  WHERE dogId = ? ";
        }
    }

    class e extends b1 {
        e(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "Update DogLocalEntity SET workoutUnlockScreenShown = ? WHERE dogId = ? ";
        }
    }

    class b extends h0<DogLocalEntity> {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, DogLocalEntity dogLocalEntity) {
            int i4 = 1;
            if (dogLocalEntity.getDogId() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, dogLocalEntity.getDogId());
            }
            kVar.u0(2, dogLocalEntity.getWorkoutUnlocked() != 0 ? 1 : 0);
            int i6 = 3;
            if (dogLocalEntity.getWorkoutUnlockSource() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, dogLocalEntity.getWorkoutUnlockSource());
            }
            kVar.u0(4, l4);
            kVar.u0(5, (long)dogLocalEntity.getLongestStreak());
            kVar.u0(6, (long)dogLocalEntity.getCurrentStreak());
            kVar.u0(7, dogLocalEntity.getLastAchievedStreakTimestampMs());
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `DogLocalEntity` (`dogId`,`workoutUnlocked`,`workoutUnlockSource`,`workoutUnlockScreenShown`,`longestStreak`,`currentStreak`,`lastAchievedStreakTimestampMs`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    class c extends g0<DogLocalStreakInfoUpdate> {
        c(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate) {
            int i4 = 1;
            if (dogLocalStreakInfoUpdate.getDogId() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, dogLocalStreakInfoUpdate.getDogId());
            }
            kVar.u0(2, (long)dogLocalStreakInfoUpdate.getLongestStreak());
            kVar.u0(3, (long)dogLocalStreakInfoUpdate.getCurrentStreak());
            kVar.u0(4, dogLocalStreakInfoUpdate.getLastAchievedStreakTimestampMs());
            int i5 = 5;
            if (dogLocalStreakInfoUpdate.getDogId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, dogLocalStreakInfoUpdate.getDogId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `DogLocalEntity` SET `dogId` = ?,`longestStreak` = ?,`currentStreak` = ?,`lastAchievedStreakTimestampMs` = ? WHERE `dogId` = ?";
        }
    }
    public x(u0 u0Var) {
        super();
        this.a = u0Var;
        e.a.a.a.b.b.x.b bVar = new app.dogo.android.persistencedb.room.dao.x.b(this, u0Var);
        e.a.a.a.b.b.x.c cVar = new app.dogo.android.persistencedb.room.dao.x.c(this, u0Var);
        e.a.a.a.b.b.x.d dVar = new app.dogo.android.persistencedb.room.dao.x.d(this, u0Var);
        e.a.a.a.b.b.x.e eVar = new app.dogo.android.persistencedb.room.dao.x.e(this, u0Var);
    }

    static /* synthetic */ u0 n(x xVar) {
        return xVar.a;
    }

    static /* synthetic */ h0 o(x xVar) {
        return xVar.b;
    }

    static /* synthetic */ b1 p(x xVar) {
        return xVar.d;
    }

    static /* synthetic */ b1 q(x xVar) {
        return xVar.e;
    }

    public static List<Class<?>> r() {
        return Collections.emptyList();
    }

    public i.b.b a(String str, String str2) {
        return app.dogo.android.persistencedb.room.dao.w.a.j(this, str, str2);
    }

    public void b(DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate) {
        this.a.b();
        this.a.c();
        try {
            this.c.h(dogLocalStreakInfoUpdate);
            this.a.C();
        } finally {
            this.a.g();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) dogLocalStreakInfoUpdate;
        }
        this.a.g();
    }

    public i.b.b c(String str) {
        return app.dogo.android.persistencedb.room.dao.w.a.i(this, str);
    }

    public i.b.b d(String str, boolean z, String str2) {
        return b.o(new app.dogo.android.persistencedb.room.dao.x.g(this, z, str2, str));
    }

    public a0<String> e(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT workoutUnlockSource FROM DogLocalEntity WHERE dogId = ? ", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.x.j(this, x0Var));
    }

    public void f(String str, int i, int i2, long j) {
        app.dogo.android.persistencedb.room.dao.w.a.k(this, str, i, i2, j);
    }

    public a0<String> g(String str) {
        return app.dogo.android.persistencedb.room.dao.w.a.e(this, str);
    }

    public a0<Boolean> h(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM DogLocalEntity WHERE dogId = ?)", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.x.a(this, x0Var));
    }

    public a0<DogLocalEntity> i(String str) {
        return app.dogo.android.persistencedb.room.dao.w.a.c(this, str);
    }

    public void j(String str, int i) {
        app.dogo.android.persistencedb.room.dao.w.a.h(this, str, i);
    }

    public a0<DogLocalEntity> k(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM DogLocalEntity WHERE dogId = ? ", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.x.i(this, x0Var));
    }

    public i.b.b l(DogLocalEntity... dogLocalEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.x.f(this, dogLocalEntityArr));
    }

    public i.b.b m(String str, boolean z) {
        return b.o(new app.dogo.android.persistencedb.room.dao.x.h(this, z, str));
    }
}
