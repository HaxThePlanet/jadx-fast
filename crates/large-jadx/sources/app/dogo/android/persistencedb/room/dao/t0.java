package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.f1.c;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.WorkoutInfoCacheUpdate;
import app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import i.b.a0;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: WorkoutEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class t0 implements s0 {

    private final u0 a;
    private final h0<WorkoutInfoEntity> b = new t0$a<>();
    private final a c = new a();
    private final g0<WorkoutInfoCacheUpdate> d = new t0$c<>();

    class d implements Callable<Void> {

        final /* synthetic */ WorkoutInfoEntity[] a;
        final /* synthetic */ t0 b;
        d(WorkoutInfoEntity[] workoutInfoEntityArr) {
            this.b = t0Var;
            this.a = workoutInfoEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.t0 t0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class e implements Callable<Void> {

        final /* synthetic */ WorkoutInfoCacheUpdate a;
        final /* synthetic */ t0 b;
        e(WorkoutInfoCacheUpdate workoutInfoCacheUpdate) {
            this.b = t0Var;
            this.a = workoutInfoCacheUpdate;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.d.h(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.t0 t0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class f implements Callable<WorkoutInfoEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ t0 b;
        f(x0 x0Var) {
            this.b = t0Var;
            this.a = x0Var;
            super();
        }

        public WorkoutInfoEntity a() {
            Object obj2;
            String string = null;
            android.os.CancellationSignal cancellationSignal = null;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "dogId");
                int i2 = b.e(cursor, "cachedWorkoutTrickIdList");
                if (cursor.moveToFirst()) {
                    if (cursor.isNull(i)) {
                    } else {
                        String string2 = cursor.getString(i);
                    }
                    if (!(cursor.isNull(i2))) {
                        string = cursor.getString(i2);
                    }
                    WorkoutInfoEntity workoutInfoEntity = new WorkoutInfoEntity(obj2, this.b.c.toStringList(string));
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
                    String str3 = "Query returned empty result set: ";
                    String str4 = this.a.a();
                    r2 = str3 + str4;
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

    class g implements Callable<Boolean> {

        final /* synthetic */ x0 a;
        final /* synthetic */ t0 b;
        g(x0 x0Var) {
            this.b = t0Var;
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

    class a extends h0<WorkoutInfoEntity> {

        final /* synthetic */ t0 d;
        a(u0 u0Var) {
            this.d = t0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, WorkoutInfoEntity workoutInfoEntity) {
            final int i2 = 1;
            if (workoutInfoEntity.getDogId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, workoutInfoEntity.getDogId());
            }
            String stringList = this.d.c.fromStringList(workoutInfoEntity.getCachedWorkoutTrickIdList());
            int i = 2;
            if (stringList == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, stringList);
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `WorkoutInfoEntity` (`dogId`,`cachedWorkoutTrickIdList`) VALUES (?,?)";
        }
    }

    class b extends g0<WorkoutInfoEntity> {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, WorkoutInfoEntity workoutInfoEntity) {
            final int i = 1;
            if (workoutInfoEntity.getDogId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, workoutInfoEntity.getDogId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `WorkoutInfoEntity` WHERE `dogId` = ?";
        }
    }

    class c extends g0<WorkoutInfoCacheUpdate> {

        final /* synthetic */ t0 d;
        c(u0 u0Var) {
            this.d = t0Var;
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, WorkoutInfoCacheUpdate workoutInfoCacheUpdate) {
            int i = 1;
            if (workoutInfoCacheUpdate.getDogId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, workoutInfoCacheUpdate.getDogId());
            }
            String stringList = this.d.c.fromStringList(workoutInfoCacheUpdate.getCachedWorkoutTrickIdList());
            int i2 = 2;
            if (stringList == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, stringList);
            }
            int i3 = 3;
            if (workoutInfoCacheUpdate.getDogId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, workoutInfoCacheUpdate.getDogId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `WorkoutInfoEntity` SET `dogId` = ?,`cachedWorkoutTrickIdList` = ? WHERE `dogId` = ?";
        }
    }
    public t0(u0 u0Var) {
        super();
        a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.t0.a aVar = new app.dogo.android.persistencedb.room.dao.t0.a(this, u0Var);
        e.a.a.a.b.b.t0.b bVar = new app.dogo.android.persistencedb.room.dao.t0.b(this, u0Var);
        e.a.a.a.b.b.t0.c cVar = new app.dogo.android.persistencedb.room.dao.t0.c(this, u0Var);
    }

    static /* synthetic */ a i(t0 t0Var) {
        return t0Var.c;
    }

    static /* synthetic */ u0 j(t0 t0Var) {
        return t0Var.a;
    }

    static /* synthetic */ h0 k(t0 t0Var) {
        return t0Var.b;
    }

    static /* synthetic */ g0 l(t0 t0Var) {
        return t0Var.d;
    }

    public static List<Class<?>> m() {
        return Collections.emptyList();
    }

    public i.b.b a(WorkoutInfoCacheUpdate workoutInfoCacheUpdate) {
        return b.o(new app.dogo.android.persistencedb.room.dao.t0.e(this, workoutInfoCacheUpdate));
    }

    public i.b.b b(String str, List<String> list) {
        return app.dogo.android.persistencedb.room.dao.s0.a.k(this, str, list);
    }

    public i.b.b c(WorkoutInfoEntity... workoutInfoEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.t0.d(this, workoutInfoEntityArr));
    }

    public a0<WorkoutInfoEntity> d(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM WorkoutInfoEntity WHERE dogId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.t0.f(this, x0Var));
    }

    public a0<WorkoutInfoEntity> e(String str) {
        return app.dogo.android.persistencedb.room.dao.s0.a.f(this, str);
    }

    public a0<List<String>> f(String str) {
        return app.dogo.android.persistencedb.room.dao.s0.a.d(this, str);
    }

    public i.b.b g(String str) {
        return app.dogo.android.persistencedb.room.dao.s0.a.a(this, str);
    }

    public a0<Boolean> h(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM WorkoutInfoEntity WHERE dogId = ?)", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.t0.g(this, x0Var));
    }
}
