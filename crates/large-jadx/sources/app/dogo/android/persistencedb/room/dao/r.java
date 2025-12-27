package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.BreedEntity;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* compiled from: BreedEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class r implements q {

    private final u0 a;
    private final h0<BreedEntity> b = new r$a<>();

    class b implements Callable<w> {

        final /* synthetic */ BreedEntity[] a;
        final /* synthetic */ r b;
        b(BreedEntity[] breedEntityArr) {
            this.b = rVar;
            this.a = breedEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.r rVar4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class c implements Callable<BreedEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r b;
        c(x0 x0Var) {
            this.b = rVar;
            this.a = x0Var;
            super();
        }

        public BreedEntity a() {
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            Object obj2;
            Object obj3;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "breedId");
                int i3 = b.e(cursor, "title");
                int i4 = b.e(cursor, "locale");
                int i6 = b.e(cursor, "locale_breedId");
                if (cursor.moveToFirst()) {
                    cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                    cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string2;
                    cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string3;
                    if (!cursor.isNull(i6)) {
                        Object string4 = cursor.getString(i6);
                    }
                    BreedEntity breedEntity = new BreedEntity(obj, obj2, obj3, cursor.getLong(b.e(cursor, "updatedAt")), str8, cancellationSignal);
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
                    String str3 = "Query returned empty result set: ";
                    String str4 = this.a.a();
                    r2 = str3 + str4;
                    throw new EmptyResultSetException(r2);
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

    class d implements Callable<List<BreedEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r b;
        d(x0 x0Var) {
            this.b = rVar;
            this.a = x0Var;
            super();
        }

        public List<BreedEntity> a() {
            Object obj3;
            Object obj4;
            String string;
            String string2;
            final Object obj = this;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "breedId");
                int i3 = b.e(cursor, "title");
                int i4 = b.e(cursor, "locale");
                int i6 = b.e(cursor, "locale_breedId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string3;
                cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string2;
                BreedEntity breedEntity = new BreedEntity(obj3, obj4, string, cursor.getLong(b.e(cursor, "updatedAt")), str8, string2);
                arrayList.add(breedEntity);
            } finally {
                obj2.close();
                throw th;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class e implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ r b;
        e(x0 x0Var) {
            this.b = rVar;
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

    class a extends h0<BreedEntity> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, BreedEntity breedEntity) {
            int i2 = 1;
            if (breedEntity.getBreedId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, breedEntity.getBreedId());
            }
            int i3 = 2;
            if (breedEntity.getTitle() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, breedEntity.getTitle());
            }
            int i4 = 3;
            if (breedEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, breedEntity.getLocale());
            }
            kVar.u0(4, breedEntity.getUpdatedAt());
            int i5 = 5;
            if (breedEntity.getLocale_breedId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, breedEntity.getLocale_breedId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `BreedEntity` (`breedId`,`title`,`locale`,`updatedAt`,`locale_breedId`) VALUES (?,?,?,?,?)";
        }
    }
    public r(u0 u0Var) {
        super();
        this.a = u0Var;
        final e.a.a.a.b.b.r.a aVar = new app.dogo.android.persistencedb.room.dao.r.a(this, u0Var);
    }

    static /* synthetic */ u0 f(r rVar) {
        return rVar.a;
    }

    static /* synthetic */ h0 g(r rVar) {
        return rVar.b;
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    public a0<BreedEntity> a(String str, String str2) {
        final int i = 2;
        x0 x0Var = x0.e("SELECT * FROM BreedEntity WHERE breedId = ? AND locale = ?", i);
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
        return y0.a(new app.dogo.android.persistencedb.room.dao.r.c(this, x0Var));
    }

    public Object b(BreedEntity[] breedEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.r.b(this, breedEntityArr), dVar);
    }

    public a0<BreedEntity> c(String str, String str2) {
        return app.dogo.android.persistencedb.room.dao.q.a.a(this, str, str2);
    }

    public a0<List<BreedEntity>> d(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM BreedEntity WHERE locale = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.r.d(this, x0Var));
    }

    public Object e(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.r.e(this, x0.e("SELECT updatedAt FROM BreedEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }
}
