package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.f1.c;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import d.s.a.i;
import d.s.a.k;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* loaded from: classes.dex */
public final class j0 implements e.a.a.a.b.b.i0 {

    private final u0 a;
    private final h0<TaskEntity> b;

    class c implements Callable<w> {

        final TaskEntity[] a;
        final e.a.a.a.b.b.j0 b;
        c(e.a.a.a.b.b.j0 j0, TaskEntity[] taskEntity2Arr2) {
            this.b = j0;
            this.a = taskEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            j0.c(this.b).c();
            j0.d(this.b).i(this.a);
            j0.c(this.b).C();
            j0.c(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.j0 b;
        d(e.a.a.a.b.b.j0 j0, x0 x02) {
            this.b = j0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(j0.c(this.b), this.a, i, 0);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i)) {
                } else {
                    valueOf = Long.valueOf(cursor.getLong(i));
                }
            }
            cursor.close();
            this.a.j();
            return valueOf;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a extends h0<TaskEntity> {
        a(e.a.a.a.b.b.j0 j0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TaskEntity` (`taskId`,`text`,`locale`,`updatedAt`,`locale_taskId`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TaskEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TaskEntity taskEntity2) {
            String taskId;
            String text;
            String locale;
            String obj5;
            int i2 = 1;
            if (taskEntity2.getTaskId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, taskEntity2.getTaskId());
            }
            int i3 = 2;
            if (taskEntity2.getText() == null) {
                k.k1(i3);
            } else {
                k.D(i3, taskEntity2.getText());
            }
            int i4 = 3;
            if (taskEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, taskEntity2.getLocale());
            }
            k.u0(4, taskEntity2.getUpdatedAt());
            int i5 = 5;
            if (taskEntity2.getLocale_taskId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, taskEntity2.getLocale_taskId());
            }
        }
    }

    class b extends g0<TaskEntity> {
        b(e.a.a.a.b.b.j0 j0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TaskEntity` WHERE `locale_taskId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TaskEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TaskEntity taskEntity2) {
            String obj4;
            final int i = 1;
            if (taskEntity2.getLocale_taskId() == null) {
                k.k1(i);
            } else {
                k.D(i, taskEntity2.getLocale_taskId());
            }
        }
    }
    public j0(u0 u0) {
        super();
        this.a = u0;
        j0.a aVar = new j0.a(this, u0);
        this.b = aVar;
        j0.b bVar = new j0.b(this, u0);
    }

    static u0 c(e.a.a.a.b.b.j0 j0) {
        return j0.a;
    }

    static h0 d(e.a.a.a.b.b.j0 j0) {
        return j0.b;
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    public Object a(TaskEntity[] taskEntityArr, d<? super w> d2) {
        j0.c cVar = new j0.c(this, taskEntityArr);
        return c0.b(this.a, true, cVar, d2);
    }

    public Object b(d<? super Long> d) {
        final int i = 0;
        j0.d dVar = new j0.d(this, x0.e("SELECT updatedAt FROM TaskEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), dVar, d);
    }
}
