package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b1;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.DogEntity;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import i.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class v implements e.a.a.a.b.b.u {

    private final u0 a;
    private final h0<DogEntity> b;
    private final b1 c;
    private final b1 d;

    class d implements Callable<Void> {

        final DogEntity[] a;
        final e.a.a.a.b.b.v b;
        d(e.a.a.a.b.b.v v, DogEntity[] dogEntity2Arr2) {
            this.b = v;
            this.a = dogEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            v.f(this.b).c();
            v.g(this.b).i(this.a);
            v.f(this.b).C();
            v.f(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<Void> {

        final String a;
        final e.a.a.a.b.b.v b;
        e(e.a.a.a.b.b.v v, String string2) {
            this.b = v;
            this.a = string2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            k kVar = v.h(this.b).a();
            String str = this.a;
            int i2 = 1;
            if (str == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, str);
            }
            v.f(this.b).c();
            kVar.N();
            v.f(this.b).C();
            v.f(this.b).g();
            v.h(this.b).f(kVar);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class f implements Callable<Void> {

        final e.a.a.a.b.b.v a;
        f(e.a.a.a.b.b.v v) {
            this.a = v;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            k kVar = v.i(this.a).a();
            v.f(this.a).c();
            kVar.N();
            v.f(this.a).C();
            v.f(this.a).g();
            v.i(this.a).f(kVar);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g implements Callable<DogEntity> {

        final x0 a;
        final e.a.a.a.b.b.v b;
        g(e.a.a.a.b.b.v v, x0 x02) {
            this.b = v;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public DogEntity a() {
            int string3;
            String string4;
            String string;
            String string5;
            String string8;
            String string7;
            Integer valueOf;
            boolean string2;
            boolean string9;
            boolean string6;
            int long;
            int dogEntity;
            boolean moveToFirst;
            String str;
            String str4;
            String str2;
            String str5;
            String str6;
            String str3;
            Boolean bool;
            int i2;
            int i3;
            int i;
            int i4;
            final Object obj = this;
            dogEntity = 0;
            Cursor cursor = c.c(v.f(obj.b), obj.a, false, dogEntity);
            string3 = b.e(cursor, "id");
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
            if (cursor.moveToFirst()) {
                if (cursor.isNull(string3)) {
                    str = dogEntity;
                } else {
                    str = string3;
                }
                if (cursor.isNull(i5)) {
                    str4 = dogEntity;
                } else {
                    str4 = string4;
                }
                if (cursor.isNull(i6)) {
                    str2 = dogEntity;
                } else {
                    str2 = string;
                }
                if (cursor.isNull(i7)) {
                    str5 = dogEntity;
                } else {
                    str5 = string5;
                }
                if (cursor.isNull(i8)) {
                    str6 = dogEntity;
                } else {
                    str6 = string8;
                }
                try {
                    if (cursor.isNull(i9)) {
                    } else {
                    }
                    str3 = dogEntity;
                    str3 = string7;
                    if (cursor.isNull(i10)) {
                    } else {
                    }
                    valueOf = dogEntity;
                    valueOf = Integer.valueOf(cursor.getInt(i10));
                    if (valueOf == null) {
                    } else {
                    }
                    bool = dogEntity;
                    if (valueOf.intValue() != 0) {
                    }
                    long = 1;
                    bool = valueOf;
                    if (cursor.isNull(i11)) {
                    } else {
                    }
                    i2 = dogEntity;
                    i2 = string2;
                    if (cursor.isNull(i12)) {
                    } else {
                    }
                    i3 = dogEntity;
                    i3 = string9;
                    if (cursor.isNull(i13)) {
                    } else {
                    }
                    i = dogEntity;
                    i = string6;
                    if (!cursor.isNull(i14)) {
                    }
                    dogEntity = Long.valueOf(cursor.getLong(i14));
                    super(str, str4, str2, str5, str6, str3, bool, i2, i3, i, dogEntity);
                    if (dogEntity == 0) {
                    } else {
                    }
                    cursor.close();
                    return dogEntity;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Query returned empty result set: ");
                    stringBuilder.append(obj.a.a());
                    EmptyResultSetException emptyResultSetException = new EmptyResultSetException(stringBuilder.toString());
                    throw emptyResultSetException;
                    obj2.close();
                    throw th;
                }
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

    class h implements Callable<List<DogEntity>> {

        final x0 a;
        final e.a.a.a.b.b.v b;
        h(e.a.a.a.b.b.v v, x0 x02) {
            this.b = v;
            this.a = x02;
            super();
        }

        public List<DogEntity> a() {
            int dogEntity;
            boolean string7;
            boolean string;
            boolean string8;
            boolean string3;
            boolean string9;
            boolean string6;
            Integer valueOf;
            int i8;
            String string2;
            String string4;
            String string5;
            Long valueOf2;
            int i7;
            int i2;
            int i3;
            int i4;
            int i6;
            int i5;
            int i;
            Boolean bool;
            String str2;
            String str;
            String str3;
            Long num;
            final Object obj = this;
            final int i11 = 0;
            Cursor cursor = c.c(v.f(obj.b), obj.a, false, i11);
            int i9 = b.e(cursor, "id");
            int i12 = b.e(cursor, "creatorId");
            int i13 = b.e(cursor, "name");
            int i14 = b.e(cursor, "breedId");
            int i15 = b.e(cursor, "customBreed");
            int i16 = b.e(cursor, "birthday");
            int i17 = b.e(cursor, "birthdayExact");
            int i18 = b.e(cursor, "gender");
            int i19 = b.e(cursor, "avatarUrl");
            int i20 = b.e(cursor, "parentId");
            int i21 = b.e(cursor, "createTimeMs");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i9)) {
                } else {
                }
                i2 = string7;
                if (cursor.isNull(i12)) {
                } else {
                }
                i3 = string;
                if (cursor.isNull(i13)) {
                } else {
                }
                i4 = string8;
                if (cursor.isNull(i14)) {
                } else {
                }
                i6 = string3;
                if (cursor.isNull(i15)) {
                } else {
                }
                i5 = string9;
                if (cursor.isNull(i16)) {
                } else {
                }
                i = string6;
                if (cursor.isNull(i17)) {
                } else {
                }
                valueOf = Integer.valueOf(cursor.getInt(i17));
                if (valueOf == null) {
                } else {
                }
                if (valueOf.intValue() != 0) {
                } else {
                }
                i8 = 0;
                bool = valueOf;
                if (cursor.isNull(i18)) {
                } else {
                }
                str2 = string2;
                if (cursor.isNull(i19)) {
                } else {
                }
                str = string4;
                if (cursor.isNull(i20)) {
                } else {
                }
                str3 = string5;
                if (cursor.isNull(i21)) {
                } else {
                }
                num = valueOf2;
                super(i2, i3, i4, i6, i5, i, bool, str2, str, str3, num);
                arrayList.add(dogEntity);
                num = i11;
                str3 = i11;
                str = i11;
                str2 = i11;
                i8 = 1;
                bool = i11;
                valueOf = i11;
                i = i11;
                i5 = i11;
                i6 = i11;
                i4 = i11;
                i3 = i11;
                i2 = i11;
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

    class b extends b1 {
        b(e.a.a.a.b.b.v v, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM DogEntity WHERE id = ?";
        }
    }

    class c extends b1 {
        c(e.a.a.a.b.b.v v, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM DogEntity";
        }
    }

    class a extends h0<DogEntity> {
        a(e.a.a.a.b.b.v v, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `DogEntity` (`id`,`creatorId`,`name`,`breedId`,`customBreed`,`birthday`,`birthdayExact`,`gender`,`avatarUrl`,`parentId`,`createTimeMs`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (DogEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, DogEntity dogEntity2) {
            String str;
            String creatorId;
            String name;
            String breedId;
            String customBreed;
            String birthday;
            Integer intValue;
            String gender;
            String avatarUrl;
            String parentId;
            long longValue;
            Long obj6;
            int i = 1;
            if (dogEntity2.getId() == null) {
                k.k1(i);
            } else {
                k.D(i, dogEntity2.getId());
            }
            int i2 = 2;
            if (dogEntity2.getCreatorId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, dogEntity2.getCreatorId());
            }
            int i3 = 3;
            if (dogEntity2.getName() == null) {
                k.k1(i3);
            } else {
                k.D(i3, dogEntity2.getName());
            }
            int i4 = 4;
            if (dogEntity2.getBreedId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, dogEntity2.getBreedId());
            }
            int i5 = 5;
            if (dogEntity2.getCustomBreed() == null) {
                k.k1(i5);
            } else {
                k.D(i5, dogEntity2.getCustomBreed());
            }
            int i6 = 6;
            if (dogEntity2.getBirthday() == null) {
                k.k1(i6);
            } else {
                k.D(i6, dogEntity2.getBirthday());
            }
            if (dogEntity2.getBirthdayExact() == null) {
                intValue = 0;
            } else {
                intValue = Integer.valueOf(dogEntity2.getBirthdayExact().booleanValue());
            }
            int i7 = 7;
            if (intValue == null) {
                k.k1(i7);
            } else {
                k.u0(i7, (long)intValue);
            }
            int i8 = 8;
            if (dogEntity2.getGender() == null) {
                k.k1(i8);
            } else {
                k.D(i8, dogEntity2.getGender());
            }
            int i9 = 9;
            if (dogEntity2.getAvatarUrl() == null) {
                k.k1(i9);
            } else {
                k.D(i9, dogEntity2.getAvatarUrl());
            }
            int i10 = 10;
            if (dogEntity2.getParentId() == null) {
                k.k1(i10);
            } else {
                k.D(i10, dogEntity2.getParentId());
            }
            int i11 = 11;
            if (dogEntity2.getCreateTimeMs() == null) {
                k.k1(i11);
            } else {
                k.u0(i11, dogEntity2.getCreateTimeMs().longValue());
            }
        }
    }
    public v(u0 u0) {
        super();
        this.a = u0;
        v.a aVar = new v.a(this, u0);
        this.b = aVar;
        v.b bVar = new v.b(this, u0);
        this.c = bVar;
        v.c cVar = new v.c(this, u0);
        this.d = cVar;
    }

    static u0 f(e.a.a.a.b.b.v v) {
        return v.a;
    }

    static h0 g(e.a.a.a.b.b.v v) {
        return v.b;
    }

    static b1 h(e.a.a.a.b.b.v v) {
        return v.c;
    }

    static b1 i(e.a.a.a.b.b.v v) {
        return v.d;
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    public a0<List<DogEntity>> a() {
        v.h hVar = new v.h(this, x0.e("SELECT * FROM DogEntity", 0));
        return y0.a(hVar);
    }

    public a0<DogEntity> b(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM DogEntity WHERE id = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        v.g obj3 = new v.g(this, x0Var);
        return y0.a(obj3);
    }

    @Override // e.a.a.a.b.b.u
    public b c(DogEntity... dogEntityArr) {
        return u.a.a(this, dogEntityArr);
    }

    @Override // e.a.a.a.b.b.u
    public b d(DogEntity... dogEntityArr) {
        v.d dVar = new v.d(this, dogEntityArr);
        return b.o(dVar);
    }

    @Override // e.a.a.a.b.b.u
    public b deleteDog(String string) {
        v.e eVar = new v.e(this, string);
        return b.o(eVar);
    }

    @Override // e.a.a.a.b.b.u
    public b e() {
        v.f fVar = new v.f(this);
        return b.o(fVar);
    }
}
