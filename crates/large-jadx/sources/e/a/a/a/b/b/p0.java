package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData;
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import i.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.b0.d;

/* loaded from: classes.dex */
public final class p0 implements e.a.a.a.b.b.o0 {

    private final u0 a;
    private final h0<TrickProgressEntity> b;
    private final g0<TrickProgressEntity.TrickKnowledgeRateData> c;
    private final g0<TrickProgressEntity.TrickKnowledgeViewData> d;

    class a implements Callable<List<TrickProgressEntity>> {

        final x0 a;
        final e.a.a.a.b.b.p0 b;
        a(e.a.a.a.b.b.p0 p0, x0 x02) {
            this.b = p0;
            this.a = x02;
            super();
        }

        public List<TrickProgressEntity> a() {
            int trickProgressEntity;
            boolean string2;
            boolean string;
            boolean valueOf;
            boolean valueOf2;
            long l;
            int i;
            int i2;
            long long;
            int i4;
            int i3;
            int int;
            final Object obj = this;
            final int i8 = 0;
            Cursor cursor = c.c(p0.k(obj.b), obj.a, false, i8);
            int i5 = b.e(cursor, "trickId");
            int i7 = b.e(cursor, "dogId");
            int i10 = b.e(cursor, "lastViewedAt");
            int i11 = b.e(cursor, "lastRatedAt");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i5)) {
                } else {
                }
                i = string2;
                if (cursor.isNull(i7)) {
                } else {
                }
                i2 = string;
                if (cursor.isNull(i10)) {
                } else {
                }
                i4 = valueOf;
                if (cursor.isNull(i11)) {
                } else {
                }
                i3 = valueOf2;
                super(i, i2, cursor.getLong(b.e(cursor, "updatedAt")), obj15, i4, i3, cursor.getInt(b.e(cursor, "knowledge")));
                arrayList.add(trickProgressEntity);
                i3 = i8;
                i4 = i8;
                i2 = i8;
                i = i8;
            }
            cursor.close();
            obj.a.j();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class b implements Callable<Boolean> {

        final x0 a;
        final e.a.a.a.b.b.p0 b;
        b(e.a.a.a.b.b.p0 p0, x0 x02) {
            this.b = p0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Boolean a() {
            boolean moveToFirst;
            int i2;
            int i;
            i2 = 0;
            i = 0;
            Cursor cursor = c.c(p0.k(this.b), this.a, i2, i);
            if (cursor.moveToFirst()) {
                if (cursor.isNull(i2)) {
                    moveToFirst = i;
                } else {
                    moveToFirst = Integer.valueOf(cursor.getInt(i2));
                }
                if (moveToFirst == null) {
                } else {
                    if (moveToFirst.intValue() != 0) {
                        i2 = 1;
                    }
                    i = moveToFirst;
                }
            }
            if (i == 0) {
            } else {
                cursor.close();
                return i;
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

    class f implements Callable<Void> {

        final TrickProgressEntity[] a;
        final e.a.a.a.b.b.p0 b;
        f(e.a.a.a.b.b.p0 p0, TrickProgressEntity[] trickProgressEntity2Arr2) {
            this.b = p0;
            this.a = trickProgressEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            p0.k(this.b).c();
            p0.l(this.b).i(this.a);
            p0.k(this.b).C();
            p0.k(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g implements Callable<Void> {

        final TrickProgressEntity.TrickKnowledgeRateData a;
        final e.a.a.a.b.b.p0 b;
        g(e.a.a.a.b.b.p0 p0, TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData2) {
            this.b = p0;
            this.a = trickKnowledgeRateData2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            p0.k(this.b).c();
            p0.m(this.b).h(this.a);
            p0.k(this.b).C();
            p0.k(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class h implements Callable<Void> {

        final TrickProgressEntity.TrickKnowledgeViewData a;
        final e.a.a.a.b.b.p0 b;
        h(e.a.a.a.b.b.p0 p0, TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData2) {
            this.b = p0;
            this.a = trickKnowledgeViewData2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            p0.k(this.b).c();
            p0.n(this.b).h(this.a);
            p0.k(this.b).C();
            p0.k(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class i implements Callable<List<TrickProgressEntity>> {

        final x0 a;
        final e.a.a.a.b.b.p0 b;
        i(e.a.a.a.b.b.p0 p0, x0 x02) {
            this.b = p0;
            this.a = x02;
            super();
        }

        public List<TrickProgressEntity> a() {
            int trickProgressEntity;
            boolean string2;
            boolean string;
            boolean valueOf;
            boolean valueOf2;
            long l;
            int i4;
            int i;
            long long;
            int i2;
            int i3;
            int int;
            final Object obj = this;
            final int i8 = 0;
            Cursor cursor = c.c(p0.k(obj.b), obj.a, false, i8);
            int i5 = b.e(cursor, "trickId");
            int i7 = b.e(cursor, "dogId");
            int i10 = b.e(cursor, "lastViewedAt");
            int i11 = b.e(cursor, "lastRatedAt");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i5)) {
                } else {
                }
                i4 = string2;
                if (cursor.isNull(i7)) {
                } else {
                }
                i = string;
                if (cursor.isNull(i10)) {
                } else {
                }
                i2 = valueOf;
                if (cursor.isNull(i11)) {
                } else {
                }
                i3 = valueOf2;
                super(i4, i, cursor.getLong(b.e(cursor, "updatedAt")), obj15, i2, i3, cursor.getInt(b.e(cursor, "knowledge")));
                arrayList.add(trickProgressEntity);
                i3 = i8;
                i2 = i8;
                i = i8;
                i4 = i8;
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

    class j implements Callable<List<TrickProgressEntity>> {

        final x0 a;
        final e.a.a.a.b.b.p0 b;
        j(e.a.a.a.b.b.p0 p0, x0 x02) {
            this.b = p0;
            this.a = x02;
            super();
        }

        public List<TrickProgressEntity> a() {
            int trickProgressEntity;
            boolean string2;
            boolean string;
            boolean valueOf2;
            boolean valueOf;
            long l;
            int i4;
            int i2;
            long long;
            int i3;
            int i;
            int int;
            final Object obj = this;
            final int i8 = 0;
            Cursor cursor = c.c(p0.k(obj.b), obj.a, false, i8);
            int i5 = b.e(cursor, "trickId");
            int i7 = b.e(cursor, "dogId");
            int i10 = b.e(cursor, "lastViewedAt");
            int i11 = b.e(cursor, "lastRatedAt");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i5)) {
                } else {
                }
                i4 = string2;
                if (cursor.isNull(i7)) {
                } else {
                }
                i2 = string;
                if (cursor.isNull(i10)) {
                } else {
                }
                i3 = valueOf2;
                if (cursor.isNull(i11)) {
                } else {
                }
                i = valueOf;
                super(i4, i2, cursor.getLong(b.e(cursor, "updatedAt")), obj15, i3, i, cursor.getInt(b.e(cursor, "knowledge")));
                arrayList.add(trickProgressEntity);
                i = i8;
                i3 = i8;
                i2 = i8;
                i4 = i8;
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

    class c extends h0<TrickProgressEntity> {
        c(e.a.a.a.b.b.p0 p0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickProgressEntity` (`trickId`,`dogId`,`updatedAt`,`lastViewedAt`,`lastRatedAt`,`knowledge`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (TrickProgressEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, TrickProgressEntity trickProgressEntity2) {
            String trickId;
            String dogId;
            Long lastViewedAt;
            Long lastRatedAt;
            long longValue;
            int i3 = 1;
            if (trickProgressEntity2.getTrickId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickProgressEntity2.getTrickId());
            }
            int i4 = 2;
            if (trickProgressEntity2.getDogId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickProgressEntity2.getDogId());
            }
            k.u0(3, trickProgressEntity2.getUpdatedAt());
            int i5 = 4;
            if (trickProgressEntity2.getLastViewedAt() == null) {
                k.k1(i5);
            } else {
                k.u0(i5, trickProgressEntity2.getLastViewedAt().longValue());
            }
            int i6 = 5;
            if (trickProgressEntity2.getLastRatedAt() == null) {
                k.k1(i6);
            } else {
                k.u0(i6, trickProgressEntity2.getLastRatedAt().longValue());
            }
            k.u0(6, (long)obj6);
        }
    }

    class d extends g0<TrickProgressEntity.TrickKnowledgeRateData> {
        d(e.a.a.a.b.b.p0 p0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `TrickProgressEntity` SET `trickId` = ?,`dogId` = ?,`updatedAt` = ?,`lastRatedAt` = ?,`knowledge` = ? WHERE `trickId` = ? AND `dogId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickProgressEntity.TrickKnowledgeRateData)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData2) {
            String trickId2;
            String dogId;
            String trickId;
            String obj5;
            int i4 = 1;
            if (trickKnowledgeRateData2.getTrickId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickKnowledgeRateData2.getTrickId());
            }
            int i5 = 2;
            if (trickKnowledgeRateData2.getDogId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickKnowledgeRateData2.getDogId());
            }
            k.u0(3, trickKnowledgeRateData2.getUpdatedAt());
            k.u0(4, trickKnowledgeRateData2.getLastRatedAt());
            k.u0(5, (long)knowledge);
            int i6 = 6;
            if (trickKnowledgeRateData2.getTrickId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, trickKnowledgeRateData2.getTrickId());
            }
            int i7 = 7;
            if (trickKnowledgeRateData2.getDogId() == null) {
                k.k1(i7);
            } else {
                k.D(i7, trickKnowledgeRateData2.getDogId());
            }
        }
    }

    class e extends g0<TrickProgressEntity.TrickKnowledgeViewData> {
        e(e.a.a.a.b.b.p0 p0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `TrickProgressEntity` SET `trickId` = ?,`dogId` = ?,`updatedAt` = ?,`lastViewedAt` = ? WHERE `trickId` = ? AND `dogId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (TrickProgressEntity.TrickKnowledgeViewData)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData2) {
            String trickId;
            String dogId;
            String trickId2;
            String obj5;
            int i3 = 1;
            if (trickKnowledgeViewData2.getTrickId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, trickKnowledgeViewData2.getTrickId());
            }
            int i4 = 2;
            if (trickKnowledgeViewData2.getDogId() == null) {
                k.k1(i4);
            } else {
                k.D(i4, trickKnowledgeViewData2.getDogId());
            }
            k.u0(3, trickKnowledgeViewData2.getUpdatedAt());
            k.u0(4, trickKnowledgeViewData2.getLastViewedAt());
            int i5 = 5;
            if (trickKnowledgeViewData2.getTrickId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, trickKnowledgeViewData2.getTrickId());
            }
            int i6 = 6;
            if (trickKnowledgeViewData2.getDogId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, trickKnowledgeViewData2.getDogId());
            }
        }
    }
    public p0(u0 u0) {
        super();
        this.a = u0;
        p0.c cVar = new p0.c(this, u0);
        this.b = cVar;
        p0.d dVar = new p0.d(this, u0);
        this.c = dVar;
        p0.e eVar = new p0.e(this, u0);
        this.d = eVar;
    }

    static u0 k(e.a.a.a.b.b.p0 p0) {
        return p0.a;
    }

    static h0 l(e.a.a.a.b.b.p0 p0) {
        return p0.b;
    }

    static g0 m(e.a.a.a.b.b.p0 p0) {
        return p0.c;
    }

    static g0 n(e.a.a.a.b.b.p0 p0) {
        return p0.d;
    }

    public static List<Class<?>> o() {
        return Collections.emptyList();
    }

    @Override // e.a.a.a.b.b.o0
    public b a(TrickProgressEntity.TrickKnowledgeRateData... trickProgressEntity$TrickKnowledgeRateDataArr) {
        return o0.a.a(this, trickKnowledgeRateDataArr);
    }

    public b b(List<TrickProgressEntity.TrickKnowledgeRateData> list) {
        return o0.a.h(this, list);
    }

    public Object c(String string, int i2, d<? super List<TrickProgressEntity>> d3) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM TrickProgressEntity WHERE dogId LIKE ? ORDER BY lastViewedAt DESC LIMIT ?", i);
        int i4 = 1;
        if (string == null) {
            x0Var.k1(i4);
        } else {
            x0Var.D(i4, string);
        }
        x0Var.u0(i, (long)i2);
        p0.a aVar = new p0.a(this, x0Var);
        return c0.a(this.a, false, c.a(), aVar, d3);
    }

    public a0<List<TrickProgressEntity>> d(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickProgressEntity WHERE dogId LIKE ? AND knowledge > 0", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        p0.j obj3 = new p0.j(this, x0Var);
        return y0.a(obj3);
    }

    @Override // e.a.a.a.b.b.o0
    public b e(TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData) {
        p0.h hVar = new p0.h(this, trickKnowledgeViewData);
        return b.o(hVar);
    }

    public a0<Boolean> f(String string, String string2) {
        final int i = 2;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM TrickProgressEntity WHERE dogId LIKE ? AND trickId LIKE ?)", i);
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
        p0.b obj4 = new p0.b(this, x0Var);
        return y0.a(obj4);
    }

    public a0<List<TrickProgressEntity>> g() {
        p0.i iVar = new p0.i(this, x0.e("SELECT * FROM TrickProgressEntity", 0));
        return y0.a(iVar);
    }

    @Override // e.a.a.a.b.b.o0
    public b h(TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData) {
        p0.g gVar = new p0.g(this, trickKnowledgeRateData);
        return b.o(gVar);
    }

    @Override // e.a.a.a.b.b.o0
    public b i(TrickProgressEntity.TrickKnowledgeViewData... trickProgressEntity$TrickKnowledgeViewDataArr) {
        return o0.a.c(this, trickKnowledgeViewDataArr);
    }

    @Override // e.a.a.a.b.b.o0
    public b j(TrickProgressEntity... trickProgressEntityArr) {
        p0.f fVar = new p0.f(this, trickProgressEntityArr);
        return b.o(fVar);
    }
}
