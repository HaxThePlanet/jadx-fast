package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.f1.b;
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
import i.b.b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class t0 implements e.a.a.a.b.b.s0 {

    private final u0 a;
    private final h0<WorkoutInfoEntity> b;
    private final a c;
    private final g0<WorkoutInfoCacheUpdate> d;

    class d implements Callable<Void> {

        final WorkoutInfoEntity[] a;
        final e.a.a.a.b.b.t0 b;
        d(e.a.a.a.b.b.t0 t0, WorkoutInfoEntity[] workoutInfoEntity2Arr2) {
            this.b = t0;
            this.a = workoutInfoEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            t0.j(this.b).c();
            t0.k(this.b).i(this.a);
            t0.j(this.b).C();
            t0.j(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<Void> {

        final WorkoutInfoCacheUpdate a;
        final e.a.a.a.b.b.t0 b;
        e(e.a.a.a.b.b.t0 t0, WorkoutInfoCacheUpdate workoutInfoCacheUpdate2) {
            this.b = t0;
            this.a = workoutInfoCacheUpdate2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            t0.j(this.b).c();
            t0.l(this.b).h(this.a);
            t0.j(this.b).C();
            t0.j(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class f implements Callable<WorkoutInfoEntity> {

        final x0 a;
        final e.a.a.a.b.b.t0 b;
        f(e.a.a.a.b.b.t0 t0, x0 x02) {
            this.b = t0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public WorkoutInfoEntity a() {
            String string;
            int i;
            String workoutInfoEntity;
            boolean moveToFirst;
            workoutInfoEntity = 0;
            Cursor cursor = c.c(t0.j(this.b), this.a, false, workoutInfoEntity);
            string = b.e(cursor, "dogId");
            i = b.e(cursor, "cachedWorkoutTrickIdList");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string)) {
                    string = workoutInfoEntity;
                } else {
                    string = cursor.getString(string);
                }
                if (cursor.isNull(i)) {
                } else {
                    workoutInfoEntity = cursor.getString(i);
                }
                workoutInfoEntity = new WorkoutInfoEntity(string, t0.i(this.b).j(workoutInfoEntity));
            }
            if (workoutInfoEntity == 0) {
            } else {
                cursor.close();
                return workoutInfoEntity;
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

    class g implements Callable<Boolean> {

        final x0 a;
        final e.a.a.a.b.b.t0 b;
        g(e.a.a.a.b.b.t0 t0, x0 x02) {
            this.b = t0;
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
            Cursor cursor = c.c(t0.j(this.b), this.a, i, i2);
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

    class a extends h0<WorkoutInfoEntity> {

        final e.a.a.a.b.b.t0 d;
        a(e.a.a.a.b.b.t0 t0, u0 u02) {
            this.d = t0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `WorkoutInfoEntity` (`dogId`,`cachedWorkoutTrickIdList`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (WorkoutInfoEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, WorkoutInfoEntity workoutInfoEntity2) {
            String dogId;
            final int i2 = 1;
            if (workoutInfoEntity2.getDogId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, workoutInfoEntity2.getDogId());
            }
            String obj4 = t0.i(this.d).d(workoutInfoEntity2.getCachedWorkoutTrickIdList());
            int i = 2;
            if (obj4 == null) {
                k.k1(i);
            } else {
                k.D(i, obj4);
            }
        }
    }

    class b extends g0<WorkoutInfoEntity> {
        b(e.a.a.a.b.b.t0 t0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `WorkoutInfoEntity` WHERE `dogId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (WorkoutInfoEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, WorkoutInfoEntity workoutInfoEntity2) {
            String obj4;
            final int i = 1;
            if (workoutInfoEntity2.getDogId() == null) {
                k.k1(i);
            } else {
                k.D(i, workoutInfoEntity2.getDogId());
            }
        }
    }

    class c extends g0<WorkoutInfoCacheUpdate> {

        final e.a.a.a.b.b.t0 d;
        c(e.a.a.a.b.b.t0 t0, u0 u02) {
            this.d = t0;
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `WorkoutInfoEntity` SET `dogId` = ?,`cachedWorkoutTrickIdList` = ? WHERE `dogId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (WorkoutInfoCacheUpdate)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, WorkoutInfoCacheUpdate workoutInfoCacheUpdate2) {
            String dogId;
            String obj4;
            int i = 1;
            if (workoutInfoCacheUpdate2.getDogId() == null) {
                k.k1(i);
            } else {
                k.D(i, workoutInfoCacheUpdate2.getDogId());
            }
            String str = t0.i(this.d).d(workoutInfoCacheUpdate2.getCachedWorkoutTrickIdList());
            int i2 = 2;
            if (str == null) {
                k.k1(i2);
            } else {
                k.D(i2, str);
            }
            int i3 = 3;
            if (workoutInfoCacheUpdate2.getDogId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, workoutInfoCacheUpdate2.getDogId());
            }
        }
    }
    public t0(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        t0.a aVar2 = new t0.a(this, u0);
        this.b = aVar2;
        t0.b bVar = new t0.b(this, u0);
        t0.c cVar = new t0.c(this, u0);
        this.d = cVar;
    }

    static a i(e.a.a.a.b.b.t0 t0) {
        return t0.c;
    }

    static u0 j(e.a.a.a.b.b.t0 t0) {
        return t0.a;
    }

    static h0 k(e.a.a.a.b.b.t0 t0) {
        return t0.b;
    }

    static g0 l(e.a.a.a.b.b.t0 t0) {
        return t0.d;
    }

    public static List<Class<?>> m() {
        return Collections.emptyList();
    }

    @Override // e.a.a.a.b.b.s0
    public b a(WorkoutInfoCacheUpdate workoutInfoCacheUpdate) {
        t0.e eVar = new t0.e(this, workoutInfoCacheUpdate);
        return b.o(eVar);
    }

    public b b(String string, List<String> list2) {
        return s0.a.k(this, string, list2);
    }

    @Override // e.a.a.a.b.b.s0
    public b c(WorkoutInfoEntity... workoutInfoEntityArr) {
        t0.d dVar = new t0.d(this, workoutInfoEntityArr);
        return b.o(dVar);
    }

    public a0<WorkoutInfoEntity> d(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM WorkoutInfoEntity WHERE dogId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        t0.f obj3 = new t0.f(this, x0Var);
        return y0.a(obj3);
    }

    public a0<WorkoutInfoEntity> e(String string) {
        return s0.a.f(this, string);
    }

    public a0<List<String>> f(String string) {
        return s0.a.d(this, string);
    }

    @Override // e.a.a.a.b.b.s0
    public b g(String string) {
        return s0.a.a(this, string);
    }

    public a0<Boolean> h(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM WorkoutInfoEntity WHERE dogId = ?)", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        t0.g obj3 = new t0.g(this, x0Var);
        return y0.a(obj3);
    }
}
