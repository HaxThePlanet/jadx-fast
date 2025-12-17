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

/* loaded from: classes.dex */
public final class r implements e.a.a.a.b.b.q {

    private final u0 a;
    private final h0<BreedEntity> b;

    class b implements Callable<w> {

        final BreedEntity[] a;
        final e.a.a.a.b.b.r b;
        b(e.a.a.a.b.b.r r, BreedEntity[] breedEntity2Arr2) {
            this.b = r;
            this.a = breedEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            r.f(this.b).c();
            r.g(this.b).i(this.a);
            r.f(this.b).C();
            r.f(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c implements Callable<BreedEntity> {

        final x0 a;
        final e.a.a.a.b.b.r b;
        c(e.a.a.a.b.b.r r, x0 x02) {
            this.b = r;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public BreedEntity a() {
            int string2;
            String string3;
            String string;
            int breedEntity;
            boolean moveToFirst;
            String str2;
            String str3;
            String str;
            long long;
            int i;
            breedEntity = 0;
            Cursor cursor = c.c(r.f(this.b), this.a, false, breedEntity);
            string2 = b.e(cursor, "breedId");
            int i3 = b.e(cursor, "title");
            int i4 = b.e(cursor, "locale");
            int i6 = b.e(cursor, "locale_breedId");
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string2)) {
                    str2 = breedEntity;
                } else {
                    str2 = string2;
                }
                if (cursor.isNull(i3)) {
                    str3 = breedEntity;
                } else {
                    str3 = string3;
                }
                if (cursor.isNull(i4)) {
                    str = breedEntity;
                } else {
                    str = string;
                }
                if (!cursor.isNull(i6)) {
                    breedEntity = cursor.getString(i6);
                }
                super(str2, str3, str, cursor.getLong(b.e(cursor, "updatedAt")), obj12, breedEntity);
            }
            try {
                if (breedEntity == 0) {
                } else {
                }
                cursor.close();
                return breedEntity;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Query returned empty result set: ");
                stringBuilder.append(this.a.a());
                EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
                throw emptyResultSetException;
                obj0.close();
                throw th;
            }
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

    class d implements Callable<List<BreedEntity>> {

        final x0 a;
        final e.a.a.a.b.b.r b;
        d(e.a.a.a.b.b.r r, x0 x02) {
            this.b = r;
            this.a = x02;
            super();
        }

        public List<BreedEntity> a() {
            int breedEntity;
            boolean string2;
            boolean string3;
            boolean string;
            boolean string4;
            int i2;
            int i3;
            int i4;
            int i5;
            long long;
            int i;
            final Object obj = this;
            final int i9 = 0;
            Cursor cursor = c.c(r.f(obj.b), obj.a, false, i9);
            int i6 = b.e(cursor, "breedId");
            int i8 = b.e(cursor, "title");
            int i10 = b.e(cursor, "locale");
            int i12 = b.e(cursor, "locale_breedId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i6)) {
                } else {
                }
                i3 = string2;
                if (cursor.isNull(i8)) {
                } else {
                }
                i4 = string3;
                if (cursor.isNull(i10)) {
                } else {
                }
                i5 = string;
                if (cursor.isNull(i12)) {
                } else {
                }
                i = string4;
                super(i3, i4, i5, cursor.getLong(b.e(cursor, "updatedAt")), obj15, i);
                arrayList.add(breedEntity);
                i = i9;
                i5 = i9;
                i4 = i9;
                i3 = i9;
            }
            cursor.close();
            return arrayList;
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

    class e implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.r b;
        e(e.a.a.a.b.b.r r, x0 x02) {
            this.b = r;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(r.f(this.b), this.a, i, 0);
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

    class a extends h0<BreedEntity> {
        a(e.a.a.a.b.b.r r, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `BreedEntity` (`breedId`,`title`,`locale`,`updatedAt`,`locale_breedId`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (BreedEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, BreedEntity breedEntity2) {
            String breedId;
            String title;
            String locale;
            String obj5;
            int i2 = 1;
            if (breedEntity2.getBreedId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, breedEntity2.getBreedId());
            }
            int i3 = 2;
            if (breedEntity2.getTitle() == null) {
                k.k1(i3);
            } else {
                k.D(i3, breedEntity2.getTitle());
            }
            int i4 = 3;
            if (breedEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, breedEntity2.getLocale());
            }
            k.u0(4, breedEntity2.getUpdatedAt());
            int i5 = 5;
            if (breedEntity2.getLocale_breedId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, breedEntity2.getLocale_breedId());
            }
        }
    }
    public r(u0 u0) {
        super();
        this.a = u0;
        r.a aVar = new r.a(this, u0);
        this.b = aVar;
    }

    static u0 f(e.a.a.a.b.b.r r) {
        return r.a;
    }

    static h0 g(e.a.a.a.b.b.r r) {
        return r.b;
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    public a0<BreedEntity> a(String string, String string2) {
        final int i = 2;
        x0 x0Var = x0.e("SELECT * FROM BreedEntity WHERE breedId = ? AND locale = ?", i);
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
        r.c obj4 = new r.c(this, x0Var);
        return y0.a(obj4);
    }

    public Object b(BreedEntity[] breedEntityArr, d<? super w> d2) {
        r.b bVar = new r.b(this, breedEntityArr);
        return c0.b(this.a, true, bVar, d2);
    }

    public a0<BreedEntity> c(String string, String string2) {
        return q.a.a(this, string, string2);
    }

    public a0<List<BreedEntity>> d(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM BreedEntity WHERE locale = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        r.d obj3 = new r.d(this, x0Var);
        return y0.a(obj3);
    }

    public Object e(d<? super Long> d) {
        final int i = 0;
        r.e eVar = new r.e(this, x0.e("SELECT updatedAt FROM BreedEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), eVar, d);
    }
}
