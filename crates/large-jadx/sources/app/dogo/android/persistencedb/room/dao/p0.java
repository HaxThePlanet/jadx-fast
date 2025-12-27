package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c0;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.b0.d;

/* compiled from: TrickKnowledgeDao_Impl.java */
/* loaded from: classes.dex */
public final class p0 implements o0 {

    private final u0 a;
    private final h0<TrickProgressEntity> b = new p0$c<>();
    private final g0<TrickProgressEntity.TrickKnowledgeRateData> c = new p0$d<>();
    private final g0<TrickProgressEntity.TrickKnowledgeViewData> d = new p0$e<>();

    class a implements Callable<List<TrickProgressEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ p0 b;
        a(x0 x0Var) {
            this.b = p0Var;
            this.a = x0Var;
            super();
        }

        public List<TrickProgressEntity> a() {
            long l;
            Object obj3;
            Object obj4;
            Long num;
            int i;
            final Object obj2 = this;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj2.b.a, obj2.a, false, cancellationSignal);
            try {
                int i2 = b.e(cursor, "trickId");
                int i4 = b.e(cursor, "dogId");
                int i6 = b.e(cursor, "lastViewedAt");
                int i7 = b.e(cursor, "lastRatedAt");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i2) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string;
                if (cursor.isNull(i6)) {
                } else {
                }
                if (cursor.isNull(i7)) {
                } else {
                }
                l = new TrickProgressEntity(obj3, obj4, cursor.getLong(b.e(cursor, "updatedAt")), l2, num, i, cursor.getInt(b.e(cursor, "knowledge")));
                arrayList.add(trickProgressEntity);
            } finally {
                x0Var2.close();
                obj.a.j();
                throw th;
            }
            cursor.close();
            obj2.a.j();
            return arrayList;
        }
    }

    class b implements Callable<Boolean> {

        final /* synthetic */ x0 a;
        final /* synthetic */ p0 b;
        b(x0 x0Var) {
            this.b = p0Var;
            this.a = x0Var;
            super();
        }

        public Boolean a() {
            android.os.CancellationSignal cancellationSignal;
            boolean z = false;
            z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, z, cancellationSignal);
            try {
                if (cursor.isNull(z)) {
                } else {
                    Integer num = Integer.valueOf(cursor.getInt(z));
                }
                if (cancellationSignal.intValue() != 0) {
                    int i = 1;
                }
            } finally {
                obj.close();
                throw th;
            }
            if (cancellationSignal != null) {
                cursor.close();
                return cancellationSignal;
            } else {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Query returned empty result set: ";
                    String str3 = this.a.a();
                    r2 = str2 + str3;
                    throw new EmptyResultSetException(r2);
                } finally {
                    obj.close();
                    throw th;
                }
            }
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class f implements Callable<Void> {

        final /* synthetic */ TrickProgressEntity[] a;
        final /* synthetic */ p0 b;
        f(TrickProgressEntity[] trickProgressEntityArr) {
            this.b = p0Var;
            this.a = trickProgressEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.p0 p0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class g implements Callable<Void> {

        final /* synthetic */ TrickProgressEntity.TrickKnowledgeRateData a;
        final /* synthetic */ p0 b;
        g(TrickProgressEntity.TrickKnowledgeRateData trickKnowledgeRateData) {
            this.b = p0Var;
            this.a = trickKnowledgeRateData;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.c.h(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.p0 p0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class h implements Callable<Void> {

        final /* synthetic */ TrickProgressEntity.TrickKnowledgeViewData a;
        final /* synthetic */ p0 b;
        h(TrickProgressEntity.TrickKnowledgeViewData trickKnowledgeViewData) {
            this.b = p0Var;
            this.a = trickKnowledgeViewData;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.d.h(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.p0 p0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class i implements Callable<List<TrickProgressEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ p0 b;
        i(x0 x0Var) {
            this.b = p0Var;
            this.a = x0Var;
            super();
        }

        public List<TrickProgressEntity> a() {
            long l;
            Object obj3;
            Object obj4;
            Long num;
            int i;
            final Object obj = this;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, false, cancellationSignal);
            try {
                int i2 = b.e(cursor, "trickId");
                int i4 = b.e(cursor, "dogId");
                int i6 = b.e(cursor, "lastViewedAt");
                int i7 = b.e(cursor, "lastRatedAt");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i2) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string;
                if (cursor.isNull(i6)) {
                } else {
                }
                if (cursor.isNull(i7)) {
                } else {
                }
                l = new TrickProgressEntity(obj3, obj4, cursor.getLong(b.e(cursor, "updatedAt")), l2, num, i, cursor.getInt(b.e(cursor, "knowledge")));
                arrayList.add(trickProgressEntity);
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

    class j implements Callable<List<TrickProgressEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ p0 b;
        j(x0 x0Var) {
            this.b = p0Var;
            this.a = x0Var;
            super();
        }

        public List<TrickProgressEntity> a() {
            long l;
            Object obj3;
            Object obj4;
            Long num;
            int i;
            final Object obj = this;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, false, cancellationSignal);
            try {
                int i2 = b.e(cursor, "trickId");
                int i4 = b.e(cursor, "dogId");
                int i6 = b.e(cursor, "lastViewedAt");
                int i7 = b.e(cursor, "lastRatedAt");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i2) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string;
                if (cursor.isNull(i6)) {
                } else {
                }
                if (cursor.isNull(i7)) {
                } else {
                }
                l = new TrickProgressEntity(obj3, obj4, cursor.getLong(b.e(cursor, "updatedAt")), l2, num, i, cursor.getInt(b.e(cursor, "knowledge")));
                arrayList.add(trickProgressEntity);
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

    class c extends h0<TrickProgressEntity> {
        c(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, TrickProgressEntity trickProgressEntity) {
            long value;
            int i3 = 1;
            if (trickProgressEntity.getTrickId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickProgressEntity.getTrickId());
            }
            int i4 = 2;
            if (trickProgressEntity.getDogId() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickProgressEntity.getDogId());
            }
            kVar.u0(3, trickProgressEntity.getUpdatedAt());
            int i5 = 4;
            if (trickProgressEntity.getLastViewedAt() == null) {
                kVar.k1(i5);
            } else {
                kVar.u0(i5, trickProgressEntity.getLastViewedAt().longValue());
            }
            int i6 = 5;
            if (trickProgressEntity.getLastRatedAt() == null) {
                kVar.k1(i6);
            } else {
                kVar.u0(i6, trickProgressEntity.getLastRatedAt().longValue());
            }
            kVar.u0(6, (long)trickProgressEntity.getKnowledge());
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickProgressEntity` (`trickId`,`dogId`,`updatedAt`,`lastViewedAt`,`lastRatedAt`,`knowledge`) VALUES (?,?,?,?,?,?)";
        }
    }

    class d extends g0<TrickProgressEntity.TrickKnowledgeRateData> {
        d(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, TrickProgressEntity.TrickKnowledgeRateData trickKnowledgeRateData) {
            int i4 = 1;
            if (trickKnowledgeRateData.getTrickId() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickKnowledgeRateData.getTrickId());
            }
            int i5 = 2;
            if (trickKnowledgeRateData.getDogId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickKnowledgeRateData.getDogId());
            }
            kVar.u0(3, trickKnowledgeRateData.getUpdatedAt());
            kVar.u0(4, trickKnowledgeRateData.getLastRatedAt());
            kVar.u0(5, (long)trickKnowledgeRateData.getKnowledge());
            int i6 = 6;
            if (trickKnowledgeRateData.getTrickId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, trickKnowledgeRateData.getTrickId());
            }
            int i7 = 7;
            if (trickKnowledgeRateData.getDogId() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, trickKnowledgeRateData.getDogId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `TrickProgressEntity` SET `trickId` = ?,`dogId` = ?,`updatedAt` = ?,`lastRatedAt` = ?,`knowledge` = ? WHERE `trickId` = ? AND `dogId` = ?";
        }
    }

    class e extends g0<TrickProgressEntity.TrickKnowledgeViewData> {
        e(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, TrickProgressEntity.TrickKnowledgeViewData trickKnowledgeViewData) {
            int i3 = 1;
            if (trickKnowledgeViewData.getTrickId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickKnowledgeViewData.getTrickId());
            }
            int i4 = 2;
            if (trickKnowledgeViewData.getDogId() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickKnowledgeViewData.getDogId());
            }
            kVar.u0(3, trickKnowledgeViewData.getUpdatedAt());
            kVar.u0(4, trickKnowledgeViewData.getLastViewedAt());
            int i5 = 5;
            if (trickKnowledgeViewData.getTrickId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickKnowledgeViewData.getTrickId());
            }
            int i6 = 6;
            if (trickKnowledgeViewData.getDogId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, trickKnowledgeViewData.getDogId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "UPDATE OR ABORT `TrickProgressEntity` SET `trickId` = ?,`dogId` = ?,`updatedAt` = ?,`lastViewedAt` = ? WHERE `trickId` = ? AND `dogId` = ?";
        }
    }
    public p0(u0 u0Var) {
        super();
        this.a = u0Var;
        e.a.a.a.b.b.p0.c cVar = new app.dogo.android.persistencedb.room.dao.p0.c(this, u0Var);
        e.a.a.a.b.b.p0.d dVar = new app.dogo.android.persistencedb.room.dao.p0.d(this, u0Var);
        e.a.a.a.b.b.p0.e eVar = new app.dogo.android.persistencedb.room.dao.p0.e(this, u0Var);
    }

    static /* synthetic */ u0 k(p0 p0Var) {
        return p0Var.a;
    }

    static /* synthetic */ h0 l(p0 p0Var) {
        return p0Var.b;
    }

    static /* synthetic */ g0 m(p0 p0Var) {
        return p0Var.c;
    }

    static /* synthetic */ g0 n(p0 p0Var) {
        return p0Var.d;
    }

    public static List<Class<?>> o() {
        return Collections.emptyList();
    }

    public i.b.b a(TrickProgressEntity.TrickKnowledgeRateData... trickKnowledgeRateDataArr) {
        return app.dogo.android.persistencedb.room.dao.o0.a.a(this, trickKnowledgeRateDataArr);
    }

    public i.b.b b(List<TrickProgressEntity.TrickKnowledgeRateData> list) {
        return app.dogo.android.persistencedb.room.dao.o0.a.h(this, list);
    }

    public Object c(String str, int i, d<? super List<TrickProgressEntity>> dVar) {
        i = 2;
        x0 x0Var = x0.e("SELECT * FROM TrickProgressEntity WHERE dogId LIKE ? ORDER BY lastViewedAt DESC LIMIT ?", i);
        int i4 = 1;
        if (str == null) {
            x0Var.k1(i4);
        } else {
            x0Var.D(i4, str);
        }
        x0Var.u0(i, (long)i);
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.p0.a(this, x0Var), dVar);
    }

    public a0<List<TrickProgressEntity>> d(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickProgressEntity WHERE dogId LIKE ? AND knowledge > 0", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.p0.j(this, x0Var));
    }

    public i.b.b e(TrickProgressEntity.TrickKnowledgeViewData trickKnowledgeViewData) {
        return b.o(new app.dogo.android.persistencedb.room.dao.p0.h(this, trickKnowledgeViewData));
    }

    public a0<Boolean> f(String str, String str2) {
        final int i = 2;
        x0 x0Var = x0.e("SELECT EXISTS(SELECT * FROM TrickProgressEntity WHERE dogId LIKE ? AND trickId LIKE ?)", i);
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
        return y0.a(new app.dogo.android.persistencedb.room.dao.p0.b(this, x0Var));
    }

    public a0<List<TrickProgressEntity>> g() {
        return y0.a(new app.dogo.android.persistencedb.room.dao.p0.i(this, x0.e("SELECT * FROM TrickProgressEntity", 0)));
    }

    public i.b.b h(TrickProgressEntity.TrickKnowledgeRateData trickKnowledgeRateData) {
        return b.o(new app.dogo.android.persistencedb.room.dao.p0.g(this, trickKnowledgeRateData));
    }

    public i.b.b i(TrickProgressEntity.TrickKnowledgeViewData... trickKnowledgeViewDataArr) {
        return app.dogo.android.persistencedb.room.dao.o0.a.c(this, trickKnowledgeViewDataArr);
    }

    public i.b.b j(TrickProgressEntity... trickProgressEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.p0.f(this, trickProgressEntityArr));
    }
}
