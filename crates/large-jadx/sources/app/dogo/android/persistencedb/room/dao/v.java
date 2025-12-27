package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b1;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.DogEntity;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: DogEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class v implements u {

    private final u0 a;
    private final h0<DogEntity> b = new v$a<>();
    private final b1 c = new v$b();
    private final b1 d = new v$c();

    class d implements Callable<Void> {

        final /* synthetic */ DogEntity[] a;
        final /* synthetic */ v b;
        d(DogEntity[] dogEntityArr) {
            this.b = vVar;
            this.a = dogEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.v vVar4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class e implements Callable<Void> {

        final /* synthetic */ String a;
        final /* synthetic */ v b;
        e(String str) {
            this.b = vVar;
            this.a = str;
            super();
        }

        public Void a() {
            k kVar2 = this.b.c.a();
            int i2 = 1;
            if (this.a == null) {
                kVar2.k1(i2);
            } else {
                kVar2.D(i2, this.a);
            }
            this.b.a.c();
            try {
                kVar2.N();
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.v vVar4 = this.b.a;
                this.b.g();
                vVar4 = this.b.c;
                this.b.f(kVar);
                throw th;
            }
            this.b.a.g();
            this.b.c.f(kVar2);
            return null;
        }
    }

    class f implements Callable<Void> {

        final /* synthetic */ v a;
        f() {
            this.a = vVar;
            super();
        }

        public Void a() {
            k kVar2 = this.a.d.a();
            this.a.a.c();
            try {
                kVar2.N();
                this.a.a.C();
            } finally {
                e.a.a.a.b.b.v vVar4 = this.a.a;
                this.a.g();
                vVar4 = this.a.d;
                this.a.f(kVar);
                throw th;
            }
            this.a.a.g();
            this.a.d.f(kVar2);
            return null;
        }
    }

    class g implements Callable<DogEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ v b;
        g(x0 x0Var) {
            this.b = vVar;
            this.a = x0Var;
            super();
        }

        public DogEntity a() {
            Integer num;
            boolean z = false;
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Boolean str;
            String string;
            String string2;
            String string3;
            final Object obj8 = this;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(obj8.b.a, obj8.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "id");
                int i3 = b.e(cursor, "creatorId");
                int i4 = b.e(cursor, "name");
                int i5 = b.e(cursor, "breedId");
                int i6 = b.e(cursor, "customBreed");
                int i7 = b.e(cursor, "birthday");
                int i8 = b.e(cursor, "birthdayExact");
                int i9 = b.e(cursor, "gender");
                int i10 = b.e(cursor, "avatarUrl");
                int i11 = b.e(cursor, "parentId");
                int i12 = b.e(cursor, "createTimeMs");
                if (cursor.moveToFirst()) {
                    cancellationSignal = cursor.isNull(i) ? cancellationSignal : string9;
                    cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string8;
                    cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string7;
                    cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string6;
                    cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string5;
                    cancellationSignal = cursor.isNull(i7) ? cancellationSignal : string4;
                    if (cursor.isNull(i8)) {
                    } else {
                        num = Integer.valueOf(cursor.getInt(i8));
                    }
                    if (obj8.b == null) {
                    } else {
                        if (num.intValue() != 0) {
                            int i2 = 1;
                        }
                    }
                    cancellationSignal = cursor.isNull(i9) ? cancellationSignal : string;
                    cancellationSignal = cursor.isNull(i10) ? cancellationSignal : string2;
                    cancellationSignal = cursor.isNull(i11) ? cancellationSignal : string3;
                    if (!cursor.isNull(i12)) {
                        Object num2 = Long.valueOf(cursor.getLong(i12));
                    }
                    DogEntity dogEntity = new DogEntity(obj, obj2, obj3, obj4, obj5, obj6, str, string, string2, string3, cancellationSignal);
                }
            } finally {
                obj9.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str3 = "Query returned empty result set: ";
                    String str4 = obj8.a.a();
                    r3 = str3 + str4;
                    throw new EmptyResultSetException(r3);
                } finally {
                    obj9.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class h implements Callable<List<DogEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ v b;
        h(x0 x0Var) {
            this.b = vVar;
            this.a = x0Var;
            super();
        }

        public List<DogEntity> a() {
            android.os.CancellationSignal cancellationSignal;
            boolean z = false;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            final Object obj = this;
            cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "id");
                int i5 = b.e(cursor, "creatorId");
                int i6 = b.e(cursor, "name");
                int i7 = b.e(cursor, "breedId");
                int i8 = b.e(cursor, "customBreed");
                int i9 = b.e(cursor, "birthday");
                int i10 = b.e(cursor, "birthdayExact");
                int i11 = b.e(cursor, "gender");
                int i12 = b.e(cursor, "avatarUrl");
                int i13 = b.e(cursor, "parentId");
                int i14 = b.e(cursor, "createTimeMs");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string3;
                cancellationSignal = cursor.isNull(i7) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i8) ? cancellationSignal : string5;
                cancellationSignal = cursor.isNull(i9) ? cancellationSignal : string6;
                if (cursor.isNull(i10)) {
                } else {
                    Integer num2 = Integer.valueOf(cursor.getInt(i10));
                }
                if (cancellationSignal == null) {
                } else {
                    int r3 = cancellationSignal.intValue() != 0 ? 1 : 0;
                    Boolean str = (cancellationSignal.intValue() != 0 ? 1 : 0);
                }
                cancellationSignal = cursor.isNull(i11) ? cancellationSignal : string9;
                cancellationSignal = cursor.isNull(i12) ? cancellationSignal : string8;
                cancellationSignal = cursor.isNull(i13) ? cancellationSignal : string7;
                if (cursor.isNull(i14)) {
                } else {
                }
                DogEntity dogEntity = new DogEntity(string, string2, string3, string4, string5, string6, obj3, obj4, obj5, obj6, obj7);
                arrayList.add(dogEntity);
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

    class b extends b1 {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM DogEntity WHERE id = ?";
        }
    }

    class c extends b1 {
        c(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM DogEntity";
        }
    }

    class a extends h0<DogEntity> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, DogEntity dogEntity) {
            Integer num = null;
            long value;
            int i2 = 1;
            if (dogEntity.getId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, dogEntity.getId());
            }
            int i3 = 2;
            if (dogEntity.getCreatorId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, dogEntity.getCreatorId());
            }
            int i4 = 3;
            if (dogEntity.getName() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, dogEntity.getName());
            }
            int i5 = 4;
            if (dogEntity.getBreedId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, dogEntity.getBreedId());
            }
            int i6 = 5;
            if (dogEntity.getCustomBreed() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, dogEntity.getCustomBreed());
            }
            int i7 = 6;
            if (dogEntity.getBirthday() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, dogEntity.getBirthday());
            }
            if (dogEntity.getBirthdayExact() == null) {
                int i = 0;
            } else {
                num = Integer.valueOf(dogEntity.getBirthdayExact().booleanValue());
            }
            int i8 = 7;
            if (num == null) {
                kVar.k1(i8);
            } else {
                value = (long)num.intValue();
                kVar.u0(i8, value);
            }
            int i9 = 8;
            if (dogEntity.getGender() == null) {
                kVar.k1(i9);
            } else {
                kVar.D(i9, dogEntity.getGender());
            }
            int i10 = 9;
            if (dogEntity.getAvatarUrl() == null) {
                kVar.k1(i10);
            } else {
                kVar.D(i10, dogEntity.getAvatarUrl());
            }
            int i11 = 10;
            if (dogEntity.getParentId() == null) {
                kVar.k1(i11);
            } else {
                kVar.D(i11, dogEntity.getParentId());
            }
            int i12 = 11;
            if (dogEntity.getCreateTimeMs() == null) {
                kVar.k1(i12);
            } else {
                kVar.u0(i12, dogEntity.getCreateTimeMs().longValue());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `DogEntity` (`id`,`creatorId`,`name`,`breedId`,`customBreed`,`birthday`,`birthdayExact`,`gender`,`avatarUrl`,`parentId`,`createTimeMs`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }
    }
    public v(u0 u0Var) {
        super();
        this.a = u0Var;
        e.a.a.a.b.b.v.a aVar = new app.dogo.android.persistencedb.room.dao.v.a(this, u0Var);
        e.a.a.a.b.b.v.b bVar = new app.dogo.android.persistencedb.room.dao.v.b(this, u0Var);
        e.a.a.a.b.b.v.c cVar = new app.dogo.android.persistencedb.room.dao.v.c(this, u0Var);
    }

    static /* synthetic */ u0 f(v vVar) {
        return vVar.a;
    }

    static /* synthetic */ h0 g(v vVar) {
        return vVar.b;
    }

    static /* synthetic */ b1 h(v vVar) {
        return vVar.c;
    }

    static /* synthetic */ b1 i(v vVar) {
        return vVar.d;
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    public a0<List<DogEntity>> a() {
        return y0.a(new app.dogo.android.persistencedb.room.dao.v.h(this, x0.e("SELECT * FROM DogEntity", 0)));
    }

    public a0<DogEntity> b(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM DogEntity WHERE id = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.v.g(this, x0Var));
    }

    public i.b.b c(DogEntity... dogEntityArr) {
        return app.dogo.android.persistencedb.room.dao.u.a.a(this, dogEntityArr);
    }

    public i.b.b d(DogEntity... dogEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.v.d(this, dogEntityArr));
    }

    public i.b.b deleteDog(String str) {
        return b.o(new app.dogo.android.persistencedb.room.dao.v.e(this, str));
    }

    public i.b.b e() {
        return b.o(new app.dogo.android.persistencedb.room.dao.v.f(this));
    }
}
