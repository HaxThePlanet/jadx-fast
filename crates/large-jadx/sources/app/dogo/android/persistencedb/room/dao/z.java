package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.b0.d;

/* compiled from: DogRecommendedProgramOrderDao_Impl.java */
/* loaded from: classes.dex */
public final class z implements y {

    private final u0 a;
    private final h0<RecommendedListOrderEntity> b = new z$a<>();
    private final a c = new a();

    class b implements Callable<RecommendedListOrderEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ z b;
        b(x0 x0Var) {
            this.b = zVar;
            this.a = x0Var;
            super();
        }

        public RecommendedListOrderEntity a() {
            Object obj;
            String string = null;
            android.os.CancellationSignal cancellationSignal = null;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "dogId");
                int i2 = b.e(cursor, "recommendedProgramIds");
                if (cursor.isNull(i)) {
                } else {
                    String string2 = cursor.getString(i);
                }
                if (!(cursor.isNull(i2))) {
                    string = cursor.getString(i2);
                }
                RecommendedListOrderEntity recommendedListOrderEntity = new RecommendedListOrderEntity(obj, this.b.c.toProgramCompatibilityList(string));
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

    class a extends h0<RecommendedListOrderEntity> {

        final /* synthetic */ z d;
        a(u0 u0Var) {
            this.d = zVar;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, RecommendedListOrderEntity list) {
            final int i2 = 1;
            if (list.getDogId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, list.getDogId());
            }
            String programCompatibilityList = this.d.c.fromProgramCompatibilityList(list.getRecommendedProgramIds());
            int i = 2;
            if (programCompatibilityList == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, programCompatibilityList);
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `RecommendedListOrderEntity` (`dogId`,`recommendedProgramIds`) VALUES (?,?)";
        }
    }
    public z(u0 u0Var) {
        super();
        a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.z.a aVar = new app.dogo.android.persistencedb.room.dao.z.a(this, u0Var);
    }

    static /* synthetic */ a d(z zVar) {
        return zVar.c;
    }

    static /* synthetic */ u0 e(z zVar) {
        return zVar.a;
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    public void a(RecommendedListOrderEntity... listArr) {
        this.a.b();
        this.a.c();
        try {
            this.b.i(listArr);
            this.a.C();
        } finally {
            this.a.g();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) listArr;
        }
        this.a.g();
    }

    public Object b(String str, d<? super RecommendedListOrderEntity> dVar) {
        return app.dogo.android.persistencedb.room.dao.y.a.a(this, str, dVar);
    }

    public Object c(String str, d<? super RecommendedListOrderEntity> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM RecommendedListOrderEntity WHERE dogId = ? ", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.z.b(this, x0Var), dVar);
    }
}
