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

/* loaded from: classes.dex */
public final class z implements e.a.a.a.b.b.y {

    private final u0 a;
    private final h0<RecommendedListOrderEntity> b;
    private final a c;

    class b implements Callable<RecommendedListOrderEntity> {

        final x0 a;
        final e.a.a.a.b.b.z b;
        b(e.a.a.a.b.b.z z, x0 x02) {
            this.b = z;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public RecommendedListOrderEntity a() {
            String string;
            int i;
            String recommendedListOrderEntity;
            boolean moveToFirst;
            recommendedListOrderEntity = 0;
            Cursor cursor = c.c(z.e(this.b), this.a, false, recommendedListOrderEntity);
            string = b.e(cursor, "dogId");
            i = b.e(cursor, "recommendedProgramIds");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string)) {
                    string = recommendedListOrderEntity;
                } else {
                    string = cursor.getString(string);
                }
                if (cursor.isNull(i)) {
                } else {
                    recommendedListOrderEntity = cursor.getString(i);
                }
                recommendedListOrderEntity = new RecommendedListOrderEntity(string, z.d(this.b).i(recommendedListOrderEntity));
            }
            cursor.close();
            this.a.j();
            return recommendedListOrderEntity;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a extends h0<RecommendedListOrderEntity> {

        final e.a.a.a.b.b.z d;
        a(e.a.a.a.b.b.z z, u0 u02) {
            this.d = z;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `RecommendedListOrderEntity` (`dogId`,`recommendedProgramIds`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (RecommendedListOrderEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, RecommendedListOrderEntity recommendedListOrderEntity2) {
            String dogId;
            final int i2 = 1;
            if (recommendedListOrderEntity2.getDogId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, recommendedListOrderEntity2.getDogId());
            }
            String obj4 = z.d(this.d).c(recommendedListOrderEntity2.getRecommendedProgramIds());
            int i = 2;
            if (obj4 == null) {
                k.k1(i);
            } else {
                k.D(i, obj4);
            }
        }
    }
    public z(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        z.a aVar2 = new z.a(this, u0);
        this.b = aVar2;
    }

    static a d(e.a.a.a.b.b.z z) {
        return z.c;
    }

    static u0 e(e.a.a.a.b.b.z z) {
        return z.a;
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // e.a.a.a.b.b.y
    public void a(RecommendedListOrderEntity... recommendedListOrderEntityArr) {
        this.a.b();
        this.a.c();
        this.b.i(recommendedListOrderEntityArr);
        this.a.C();
        this.a.g();
    }

    public Object b(String string, d<? super RecommendedListOrderEntity> d2) {
        return y.a.a(this, string, d2);
    }

    public Object c(String string, d<? super RecommendedListOrderEntity> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM RecommendedListOrderEntity WHERE dogId = ? ", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        z.b bVar = new z.b(this, x0Var);
        return c0.a(this.a, false, c.a(), bVar, d2);
    }
}
