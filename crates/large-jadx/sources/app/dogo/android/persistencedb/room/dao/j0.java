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

/* compiled from: TaskEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class j0 implements i0 {

    private final u0 a;
    private final h0<TaskEntity> b = new j0$a<>();

    class c implements Callable<w> {

        final /* synthetic */ TaskEntity[] a;
        final /* synthetic */ j0 b;
        c(TaskEntity[] taskEntityArr) {
            this.b = j0Var;
            this.a = taskEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.j0 j0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class d implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ j0 b;
        d(x0 x0Var) {
            this.b = j0Var;
            this.a = x0Var;
            super();
        }

        public Long a() {
            android.os.CancellationSignal cancellationSignal = null;
            final boolean z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, z, cancellationSignal);
            try {
                if (!(cursor.isNull(z))) {
                    Long num = Long.valueOf(cursor.getLong(z));
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

    class a extends h0<TaskEntity> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, TaskEntity taskEntity) {
            int i2 = 1;
            if (taskEntity.getTaskId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, taskEntity.getTaskId());
            }
            int i3 = 2;
            if (taskEntity.getText() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, taskEntity.getText());
            }
            int i4 = 3;
            if (taskEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, taskEntity.getLocale());
            }
            kVar.u0(4, taskEntity.getUpdatedAt());
            int i5 = 5;
            if (taskEntity.getLocale_taskId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, taskEntity.getLocale_taskId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TaskEntity` (`taskId`,`text`,`locale`,`updatedAt`,`locale_taskId`) VALUES (?,?,?,?,?)";
        }
    }

    class b extends g0<TaskEntity> {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, TaskEntity taskEntity) {
            final int i = 1;
            if (taskEntity.getLocale_taskId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, taskEntity.getLocale_taskId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TaskEntity` WHERE `locale_taskId` = ?";
        }
    }
    public j0(u0 u0Var) {
        super();
        this.a = u0Var;
        e.a.a.a.b.b.j0.a aVar = new app.dogo.android.persistencedb.room.dao.j0.a(this, u0Var);
        e.a.a.a.b.b.j0.b bVar = new app.dogo.android.persistencedb.room.dao.j0.b(this, u0Var);
    }

    static /* synthetic */ u0 c(j0 j0Var) {
        return j0Var.a;
    }

    static /* synthetic */ h0 d(j0 j0Var) {
        return j0Var.b;
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    public Object a(TaskEntity[] taskEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.j0.c(this, taskEntityArr), dVar);
    }

    public Object b(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.j0.d(this, x0.e("SELECT updatedAt FROM TaskEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }
}
