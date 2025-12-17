package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import i.b.b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class b0 implements e.a.a.a.b.b.a0 {

    private final u0 a;
    private final h0<DogoPremiumStatusEntity> b;

    class b implements Callable<Void> {

        final DogoPremiumStatusEntity a;
        final e.a.a.a.b.b.b0 b;
        b(e.a.a.a.b.b.b0 b0, DogoPremiumStatusEntity dogoPremiumStatusEntity2) {
            this.b = b0;
            this.a = dogoPremiumStatusEntity2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            b0.e(this.b).c();
            b0.f(this.b).h(this.a);
            b0.e(this.b).C();
            b0.e(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c implements Callable<Void> {

        final DogoPremiumStatusEntity[] a;
        final e.a.a.a.b.b.b0 b;
        c(e.a.a.a.b.b.b0 b0, DogoPremiumStatusEntity[] dogoPremiumStatusEntity2Arr2) {
            this.b = b0;
            this.a = dogoPremiumStatusEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            b0.e(this.b).c();
            b0.f(this.b).i(this.a);
            b0.e(this.b).C();
            b0.e(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<DogoPremiumStatusEntity> {

        final x0 a;
        final e.a.a.a.b.b.b0 b;
        d(e.a.a.a.b.b.b0 b0, x0 x02) {
            this.b = b0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public DogoPremiumStatusEntity a() {
            int string;
            String string2;
            int dogoPremiumStatusEntity;
            boolean moveToFirst;
            String str;
            String str2;
            long long;
            int i;
            long long2;
            dogoPremiumStatusEntity = 0;
            Cursor cursor = c.c(b0.e(this.b), this.a, false, dogoPremiumStatusEntity);
            string = b.e(cursor, "id");
            int i3 = b.e(cursor, "ownerType");
            int i5 = b.e(cursor, "expirationDate");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string)) {
                    str = dogoPremiumStatusEntity;
                } else {
                    str = string;
                }
                if (cursor.isNull(i3)) {
                    str2 = dogoPremiumStatusEntity;
                } else {
                    str2 = string2;
                }
                if (!cursor.isNull(i5)) {
                    dogoPremiumStatusEntity = cursor.getString(i5);
                }
                super(str, str2, cursor.getLong(b.e(cursor, "expirationTimeMs")), obj11, dogoPremiumStatusEntity, cursor.getLong(b.e(cursor, "updatedAt")), obj14);
            }
            if (dogoPremiumStatusEntity == 0) {
            } else {
                cursor.close();
                return dogoPremiumStatusEntity;
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

    class a extends h0<DogoPremiumStatusEntity> {
        a(e.a.a.a.b.b.b0 b0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `DogoPremiumStatusEntity` (`id`,`ownerType`,`expirationTimeMs`,`expirationDate`,`updatedAt`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (DogoPremiumStatusEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, DogoPremiumStatusEntity dogoPremiumStatusEntity2) {
            String str;
            String ownerType;
            String expirationDate;
            int i3 = 1;
            if (dogoPremiumStatusEntity2.getId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, dogoPremiumStatusEntity2.getId());
            }
            int i4 = 2;
            if (dogoPremiumStatusEntity2.getOwnerType() == null) {
                k.k1(i4);
            } else {
                k.D(i4, dogoPremiumStatusEntity2.getOwnerType());
            }
            k.u0(3, dogoPremiumStatusEntity2.getExpirationTimeMs());
            int i5 = 4;
            if (dogoPremiumStatusEntity2.getExpirationDate() == null) {
                k.k1(i5);
            } else {
                k.D(i5, dogoPremiumStatusEntity2.getExpirationDate());
            }
            k.u0(5, dogoPremiumStatusEntity2.getUpdatedAt());
        }
    }
    public b0(u0 u0) {
        super();
        this.a = u0;
        b0.a aVar = new b0.a(this, u0);
        this.b = aVar;
    }

    static u0 e(e.a.a.a.b.b.b0 b0) {
        return b0.a;
    }

    static h0 f(e.a.a.a.b.b.b0 b0) {
        return b0.b;
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // e.a.a.a.b.b.a0
    public b a(DogoPremiumStatusEntity... dogoPremiumStatusEntityArr) {
        b0.c cVar = new b0.c(this, dogoPremiumStatusEntityArr);
        return b.o(cVar);
    }

    @Override // e.a.a.a.b.b.a0
    public b b(DogoPremiumStatusEntity dogoPremiumStatusEntity) {
        b0.b bVar = new b0.b(this, dogoPremiumStatusEntity);
        return b.o(bVar);
    }

    public a0<DogoPremiumStatusEntity> c(String string) {
        return a0.a.a(this, string);
    }

    public a0<DogoPremiumStatusEntity> d(String string, String string2) {
        final int i = 2;
        x0 x0Var = x0.e("SELECT * FROM DogoPremiumStatusEntity WHERE id = ? AND ownerType = ?", i);
        final int i2 = 1;
        if (string == null) {
            x0Var.k1(i2);
        } else {
            x0Var.D(i2, string);
        }
        if (string2 == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string2);
        }
        b0.d obj4 = new b0.d(this, x0Var);
        return y0.a(obj4);
    }
}
