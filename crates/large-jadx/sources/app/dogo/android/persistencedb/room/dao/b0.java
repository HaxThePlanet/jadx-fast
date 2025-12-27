package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: DogoPremiumStatusDao_Impl.java */
/* loaded from: classes.dex */
public final class b0 implements a0 {

    private final u0 a;
    private final h0<DogoPremiumStatusEntity> b = new b0$a<>();

    class b implements Callable<Void> {

        final /* synthetic */ DogoPremiumStatusEntity a;
        final /* synthetic */ b0 b;
        b(DogoPremiumStatusEntity dogoPremiumStatusEntity) {
            this.b = b0Var;
            this.a = dogoPremiumStatusEntity;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.h(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.b0 b0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class c implements Callable<Void> {

        final /* synthetic */ DogoPremiumStatusEntity[] a;
        final /* synthetic */ b0 b;
        c(DogoPremiumStatusEntity[] dogoPremiumStatusEntityArr) {
            this.b = b0Var;
            this.a = dogoPremiumStatusEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.b0 b0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class d implements Callable<DogoPremiumStatusEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ b0 b;
        d(x0 x0Var) {
            this.b = b0Var;
            this.a = x0Var;
            super();
        }

        public DogoPremiumStatusEntity a() {
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            Object obj2;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "id");
                int i3 = b.e(cursor, "ownerType");
                int i5 = b.e(cursor, "expirationDate");
                if (cursor.moveToFirst()) {
                    cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                    cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string2;
                    if (!cursor.isNull(i5)) {
                        Object string3 = cursor.getString(i5);
                    }
                    DogoPremiumStatusEntity dogoPremiumStatusEntity = new DogoPremiumStatusEntity(obj, obj2, cursor.getLong(b.e(cursor, "expirationTimeMs")), str8, cancellationSignal, cursor.getLong(b.e(cursor, "updatedAt")), obj4);
                }
            } finally {
                obj3.close();
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
                    obj3.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class a extends h0<DogoPremiumStatusEntity> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, DogoPremiumStatusEntity dogoPremiumStatusEntity) {
            int i3 = 1;
            if (dogoPremiumStatusEntity.getId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, dogoPremiumStatusEntity.getId());
            }
            int i4 = 2;
            if (dogoPremiumStatusEntity.getOwnerType() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, dogoPremiumStatusEntity.getOwnerType());
            }
            kVar.u0(3, dogoPremiumStatusEntity.getExpirationTimeMs());
            int i5 = 4;
            if (dogoPremiumStatusEntity.getExpirationDate() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, dogoPremiumStatusEntity.getExpirationDate());
            }
            kVar.u0(5, dogoPremiumStatusEntity.getUpdatedAt());
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `DogoPremiumStatusEntity` (`id`,`ownerType`,`expirationTimeMs`,`expirationDate`,`updatedAt`) VALUES (?,?,?,?,?)";
        }
    }
    public b0(u0 u0Var) {
        super();
        this.a = u0Var;
        final e.a.a.a.b.b.b0.a aVar = new app.dogo.android.persistencedb.room.dao.b0.a(this, u0Var);
    }

    static /* synthetic */ u0 e(b0 b0Var) {
        return b0Var.a;
    }

    static /* synthetic */ h0 f(b0 b0Var) {
        return b0Var.b;
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    public i.b.b a(DogoPremiumStatusEntity... dogoPremiumStatusEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.b0.c(this, dogoPremiumStatusEntityArr));
    }

    public i.b.b b(DogoPremiumStatusEntity dogoPremiumStatusEntity) {
        return b.o(new app.dogo.android.persistencedb.room.dao.b0.b(this, dogoPremiumStatusEntity));
    }

    public a0<DogoPremiumStatusEntity> c(String str) {
        return app.dogo.android.persistencedb.room.dao.a0.a.a(this, str);
    }

    public a0<DogoPremiumStatusEntity> d(String str, String str2) {
        final int i = 2;
        x0 x0Var = x0.e("SELECT * FROM DogoPremiumStatusEntity WHERE id = ? AND ownerType = ?", i);
        final int i2 = 1;
        if (str == null) {
            x0Var.k1(i2);
        } else {
            x0Var.D(i2, str);
        }
        if (str2 == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str2);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.b0.d(this, x0Var));
    }
}
