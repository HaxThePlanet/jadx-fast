package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.f1.f;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.TrickCategoryEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import d.s.a.i;
import e.a.a.a.b.c.j;
import e.a.a.a.b.c.l;
import e.a.a.a.b.c.m;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* compiled from: TrickEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class n0 implements m0 {

    private final u0 a;
    private final h0<TrickEntity> b = new n0$k<>();
    private final e.a.a.a.b.a.a c = new a();
    private final h0<TrickStepEntity> d = new n0$v<>();
    private final h0<VideoStepEntity> e = new n0$a0<>();
    private final h0<TrickTagEntity> f = new n0$d0<>();
    private final h0<TrickVariationEntity> g = new n0$h0<>();
    private final h0<TrickCategoryEntity> h = new n0$o0<>();
    private final h0<e.a.a.a.b.c.k> i = new n0$p0<>();
    private final h0<m> j = new n0$q0<>();
    private final h0<j> k = new n0$r0<>();
    private final h0<l> l = new n0$a<>();
    private final g0<e.a.a.a.b.c.k> m = new n0$h<>();
    private final g0<m> n = new n0$i<>();
    private final g0<j> o = new n0$j<>();
    private final g0<l> p = new n0$l<>();

    class b0 implements Callable<w> {

        final /* synthetic */ l[] a;
        final /* synthetic */ n0 b;
        b0(l[] lVarArr) {
            this.b = n0Var;
            this.a = lVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.p.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class c0 implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        c0(x0 x0Var) {
            this.b = n0Var;
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

    class e0 implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        e0(x0 x0Var) {
            this.b = n0Var;
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

    class f0 implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        f0(x0 x0Var) {
            this.b = n0Var;
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

    class g0 implements Callable<TrickCategoryEntity> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        g0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public TrickCategoryEntity a() {
            android.os.CancellationSignal cancellationSignal = null;
            Object obj;
            Object obj2;
            Object obj3;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "categoryId");
                int i3 = b.e(cursor, "locale");
                int i4 = b.e(cursor, "name");
                int i6 = b.e(cursor, "locale_categoryId");
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string;
                cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i4) ? cancellationSignal : string3;
                if (!cursor.isNull(i6)) {
                    Object string4 = cursor.getString(i6);
                }
                TrickCategoryEntity trickCategoryEntity = new TrickCategoryEntity(obj, obj2, obj3, cursor.getLong(b.e(cursor, "updatedAt")), str6, cancellationSignal);
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

    class i0 implements Callable<List<e.a.a.a.b.d.g>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        i0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.d.g> a() {
            int i;
            int i2;
            Object obj;
            int i3;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            String string = null;
            String string2 = null;
            e.a.a.a.b.b.n0 n0Var;
            d.e.a aVar2;
            int i4;
            int i5;
            int i6;
            int count;
            ArrayList arrayList;
            int i7;
            d.e.a aVar;
            int i8;
            d.e.a aVar4;
            int i9;
            d.e.a aVar3;
            int i10;
            boolean _null3;
            TrickEntity trickEntity;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            Integer num;
            Integer num2;
            boolean z;
            boolean z2;
            long _long;
            String string9;
            String string10;
            String string11;
            String string12;
            Object obj9;
            List stringList;
            List stringList2;
            obj = this;
            obj.b.a.c();
            try {
                Cursor cursor = c.c(obj.b.a, obj.a, true, null);
            } catch (Throwable th) {
            }
            try {
                i = b.e(cursor, "trickId");
                i6 = b.e(cursor, "name");
                int i16 = b.e(cursor, "image");
                int i17 = b.e(cursor, "categoryName");
                int i18 = b.e(cursor, "categoryId");
                int i19 = b.e(cursor, "examInstructions");
                int i20 = b.e(cursor, "examTimeLimit");
                count = b.e(cursor, "sortOrder");
                i7 = b.e(cursor, "isExam");
                i2 = b.e(cursor, "locale_trickId");
                aVar2 = new a();
                aVar3 = new a();
                aVar4 = new a();
                aVar = new a();
                while (cursor.moveToNext()) {
                    String string21 = cursor.getString(i2);
                    if ((ArrayList)aVar2.get(string21) == null) {
                        aVar2.put(string21, new ArrayList());
                    } else {
                    }
                    String string18 = cursor.getString(i2);
                    if ((ArrayList)aVar3.get(string18) == null) {
                        aVar3.put(string18, new ArrayList());
                    }
                    String string19 = cursor.getString(i2);
                    if ((ArrayList)aVar4.get(string19) == null) {
                        aVar4.put(string19, new ArrayList());
                    }
                    String string20 = cursor.getString(i2);
                    if ((ArrayList)aVar.get(string20) == null) {
                        aVar.put(string20, new ArrayList());
                    }
                }
                cursor.moveToPosition(-1);
                obj.b.C(aVar2);
                obj.b.z(aVar3);
                obj.b.A(aVar4);
                obj.b.B(aVar);
                arrayList = new ArrayList(cursor.getCount());
            } catch (Throwable th) {
            }
            obj.b.a.C();
            try {
                cursor.close();
            } catch (Throwable th) {
            }
            obj.b.a.g();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class j0 implements Callable<List<e.a.a.a.b.d.g>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        j0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.d.g> a() {
            int i;
            int i2;
            Object obj;
            int i3;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            String string = null;
            String string2 = null;
            x0 x0Var;
            d.e.a aVar2;
            int i4;
            int i5;
            int i6;
            int count;
            ArrayList arrayList;
            int i7;
            d.e.a aVar;
            int i8;
            d.e.a aVar4;
            int i9;
            d.e.a aVar3;
            int i10;
            boolean _null3;
            TrickEntity trickEntity;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            Integer num;
            Integer num2;
            boolean z;
            boolean z2;
            long _long;
            String string9;
            String string10;
            String string11;
            String string12;
            Object obj9;
            List stringList;
            List stringList2;
            obj = this;
            obj.b.a.c();
            try {
                Cursor cursor = c.c(obj.b.a, obj.a, true, null);
            } catch (Throwable th) {
            }
            try {
                i = b.e(cursor, "trickId");
                i6 = b.e(cursor, "name");
                int i16 = b.e(cursor, "image");
                int i17 = b.e(cursor, "categoryName");
                int i18 = b.e(cursor, "categoryId");
                int i19 = b.e(cursor, "examInstructions");
                int i20 = b.e(cursor, "examTimeLimit");
                count = b.e(cursor, "sortOrder");
                i7 = b.e(cursor, "isExam");
                i2 = b.e(cursor, "locale_trickId");
                aVar2 = new a();
                aVar3 = new a();
                aVar4 = new a();
                aVar = new a();
                while (cursor.moveToNext()) {
                    String string21 = cursor.getString(i2);
                    if ((ArrayList)aVar2.get(string21) == null) {
                        aVar2.put(string21, new ArrayList());
                    } else {
                    }
                    String string18 = cursor.getString(i2);
                    if ((ArrayList)aVar3.get(string18) == null) {
                        aVar3.put(string18, new ArrayList());
                    }
                    String string19 = cursor.getString(i2);
                    if ((ArrayList)aVar4.get(string19) == null) {
                        aVar4.put(string19, new ArrayList());
                    }
                    String string20 = cursor.getString(i2);
                    if ((ArrayList)aVar.get(string20) == null) {
                        aVar.put(string20, new ArrayList());
                    }
                }
                cursor.moveToPosition(-1);
                obj.b.C(aVar2);
                obj.b.z(aVar3);
                obj.b.A(aVar4);
                obj.b.B(aVar);
                arrayList = new ArrayList(cursor.getCount());
            } catch (Throwable th) {
            }
            obj.b.a.C();
            try {
                cursor.close();
                obj.a.j();
            } catch (Throwable th) {
            }
            obj.b.a.g();
            return arrayList;
        }
    }

    class k0 implements Callable<List<e.a.a.a.b.c.k>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        k0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.k> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_tagId");
                int i3 = b.e(cursor, "locale_trickId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new TrickWithTags(string, obj));
            } finally {
                x0Var.close();
                this.a.j();
                throw th;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }
    }

    class l0 implements Callable<List<m>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        l0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public List<m> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_stepId");
                int i3 = b.e(cursor, "locale_trickId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new TrickWithVideoSteps(string, obj));
            } finally {
                x0Var.close();
                this.a.j();
                throw th;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }
    }

    class m0 implements Callable<List<j>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        m0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public List<j> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_stepId");
                int i3 = b.e(cursor, "locale_trickId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new TrickWithSteps(string, obj));
            } finally {
                x0Var.close();
                this.a.j();
                throw th;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }
    }

    class m implements Callable<w> {

        final /* synthetic */ TrickEntity[] a;
        final /* synthetic */ n0 b;
        m(TrickEntity[] trickEntityArr) {
            this.b = n0Var;
            this.a = trickEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class n0 implements Callable<List<l>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ n0 b;
        n0(x0 x0Var) {
            this.b = n0Var;
            this.a = x0Var;
            super();
        }

        public List<l> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_variationId");
                int i3 = b.e(cursor, "locale_trickId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new TrickWithVariations(string, obj));
            } finally {
                x0Var.close();
                this.a.j();
                throw th;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }
    }

    class n implements Callable<w> {

        final /* synthetic */ TrickStepEntity[] a;
        final /* synthetic */ n0 b;
        n(TrickStepEntity[] trickStepEntityArr) {
            this.b = n0Var;
            this.a = trickStepEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.d.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class o implements Callable<w> {

        final /* synthetic */ VideoStepEntity[] a;
        final /* synthetic */ n0 b;
        o(VideoStepEntity[] videoStepEntityArr) {
            this.b = n0Var;
            this.a = videoStepEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.e.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class p implements Callable<w> {

        final /* synthetic */ TrickTagEntity[] a;
        final /* synthetic */ n0 b;
        p(TrickTagEntity[] trickTagEntityArr) {
            this.b = n0Var;
            this.a = trickTagEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.f.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class q implements Callable<w> {

        final /* synthetic */ TrickVariationEntity[] a;
        final /* synthetic */ n0 b;
        q(TrickVariationEntity[] trickVariationEntityArr) {
            this.b = n0Var;
            this.a = trickVariationEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.g.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class r implements Callable<w> {

        final /* synthetic */ TrickCategoryEntity[] a;
        final /* synthetic */ n0 b;
        r(TrickCategoryEntity[] trickCategoryEntityArr) {
            this.b = n0Var;
            this.a = trickCategoryEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.h.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class s implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.k[] a;
        final /* synthetic */ n0 b;
        s(e.a.a.a.b.c.k[] kVarArr) {
            this.b = n0Var;
            this.a = kVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.i.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class t implements Callable<w> {

        final /* synthetic */ m[] a;
        final /* synthetic */ n0 b;
        t(m[] mVarArr) {
            this.b = n0Var;
            this.a = mVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.j.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class u implements Callable<w> {

        final /* synthetic */ j[] a;
        final /* synthetic */ n0 b;
        u(j[] jVarArr) {
            this.b = n0Var;
            this.a = jVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.k.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class w implements Callable<w> {

        final /* synthetic */ l[] a;
        final /* synthetic */ n0 b;
        w(l[] lVarArr) {
            this.b = n0Var;
            this.a = lVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.l.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class x implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.k[] a;
        final /* synthetic */ n0 b;
        x(e.a.a.a.b.c.k[] kVarArr) {
            this.b = n0Var;
            this.a = kVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.m.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class y implements Callable<w> {

        final /* synthetic */ m[] a;
        final /* synthetic */ n0 b;
        y(m[] mVarArr) {
            this.b = n0Var;
            this.a = mVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.n.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class z implements Callable<w> {

        final /* synthetic */ j[] a;
        final /* synthetic */ n0 b;
        z(j[] jVarArr) {
            this.b = n0Var;
            this.a = jVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.o.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.n0 n0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class a0 extends h0<VideoStepEntity> {
        a0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, VideoStepEntity videoStepEntity) {
            int i3 = 1;
            if (videoStepEntity.getStepId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, videoStepEntity.getStepId());
            }
            int i4 = 2;
            if (videoStepEntity.getText() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, videoStepEntity.getText());
            }
            int i5 = 3;
            if (videoStepEntity.getLocale() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, videoStepEntity.getLocale());
            }
            kVar.u0(4, (long)videoStepEntity.getStartTime());
            kVar.u0(5, videoStepEntity.getUpdatedAt());
            int i6 = 6;
            if (videoStepEntity.getLocale_stepId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, videoStepEntity.getLocale_stepId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `VideoStepEntity` (`stepId`,`text`,`locale`,`startTime`,`updatedAt`,`locale_stepId`) VALUES (?,?,?,?,?,?)";
        }
    }

    class a extends h0<l> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, l lVar) {
            int i = 1;
            if (lVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, lVar.b());
            }
            int i2 = 2;
            if (lVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, lVar.component1());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithVariations` (`locale_variationId`,`locale_trickId`) VALUES (?,?)";
        }
    }

    class b extends g0<TrickEntity> {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, TrickEntity trickEntity) {
            final int i = 1;
            if (trickEntity.getLocale_trickId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, trickEntity.getLocale_trickId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickEntity` WHERE `locale_trickId` = ?";
        }
    }

    class c extends g0<TrickStepEntity> {
        c(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, TrickStepEntity trickStepEntity) {
            final int i = 1;
            if (trickStepEntity.getLocale_stepId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, trickStepEntity.getLocale_stepId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickStepEntity` WHERE `locale_stepId` = ?";
        }
    }

    class d0 extends h0<TrickTagEntity> {
        d0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, TrickTagEntity trickTagEntity) {
            int i2 = 1;
            if (trickTagEntity.getTagId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, trickTagEntity.getTagId());
            }
            int i3 = 2;
            if (trickTagEntity.getLocale() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickTagEntity.getLocale());
            }
            int i4 = 3;
            if (trickTagEntity.getName() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickTagEntity.getName());
            }
            kVar.u0(4, trickTagEntity.getUpdatedAt());
            int i5 = 5;
            if (trickTagEntity.getLocale_tagId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickTagEntity.getLocale_tagId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickTagEntity` (`tagId`,`locale`,`name`,`updatedAt`,`locale_tagId`) VALUES (?,?,?,?,?)";
        }
    }

    class d extends g0<VideoStepEntity> {
        d(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, VideoStepEntity videoStepEntity) {
            final int i = 1;
            if (videoStepEntity.getLocale_stepId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, videoStepEntity.getLocale_stepId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `VideoStepEntity` WHERE `locale_stepId` = ?";
        }
    }

    class e extends g0<TrickTagEntity> {
        e(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, TrickTagEntity trickTagEntity) {
            final int i = 1;
            if (trickTagEntity.getLocale_tagId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, trickTagEntity.getLocale_tagId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickTagEntity` WHERE `locale_tagId` = ?";
        }
    }

    class f extends g0<TrickVariationEntity> {
        f(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, TrickVariationEntity trickVariationEntity) {
            final int i = 1;
            if (trickVariationEntity.getLocale_variationId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, trickVariationEntity.getLocale_variationId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickVariationEntity` WHERE `locale_variationId` = ?";
        }
    }

    class g extends g0<TrickCategoryEntity> {
        g(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, TrickCategoryEntity trickCategoryEntity) {
            final int i = 1;
            if (trickCategoryEntity.getLocale_categoryId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, trickCategoryEntity.getLocale_categoryId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickCategoryEntity` WHERE `locale_categoryId` = ?";
        }
    }

    class h0 extends h0<TrickVariationEntity> {

        final /* synthetic */ n0 d;
        h0(u0 u0Var) {
            this.d = n0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, TrickVariationEntity trickVariationEntity) {
            String stringList = this.d.c.fromStringList(trickVariationEntity.getTips());
            int i2 = 1;
            if (stringList == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, stringList);
            }
            int i3 = 2;
            if (trickVariationEntity.getVariationId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickVariationEntity.getVariationId());
            }
            int i4 = 3;
            if (trickVariationEntity.getTitle() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickVariationEntity.getTitle());
            }
            int i5 = 4;
            if (trickVariationEntity.getDescription() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickVariationEntity.getDescription());
            }
            int i6 = 5;
            if (trickVariationEntity.getLocale() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, trickVariationEntity.getLocale());
            }
            int i7 = 6;
            if (trickVariationEntity.getContentfulId() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, trickVariationEntity.getContentfulId());
            }
            kVar.u0(7, trickVariationEntity.getUpdatedAt());
            int i8 = 8;
            if (trickVariationEntity.getLocale_variationId() == null) {
                kVar.k1(i8);
            } else {
                kVar.D(i8, trickVariationEntity.getLocale_variationId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickVariationEntity` (`tips`,`variationId`,`title`,`description`,`locale`,`contentfulId`,`updatedAt`,`locale_variationId`) VALUES (?,?,?,?,?,?,?,?)";
        }
    }

    class h extends g0<e.a.a.a.b.c.k> {
        h(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, e.a.a.a.b.c.k kVar2) {
            int i = 1;
            if (kVar2.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, kVar2.component1());
            }
            int i2 = 2;
            if (kVar2.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, kVar2.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithTags` WHERE `locale_tagId` = ? AND `locale_trickId` = ?";
        }
    }

    class i extends g0<m> {
        i(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, m mVar) {
            int i = 1;
            if (mVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, mVar.component1());
            }
            int i2 = 2;
            if (mVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, mVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithVideoSteps` WHERE `locale_stepId` = ? AND `locale_trickId` = ?";
        }
    }

    class j extends g0<j> {
        j(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, j jVar) {
            int i = 1;
            if (jVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, jVar.component1());
            }
            int i2 = 2;
            if (jVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, jVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithSteps` WHERE `locale_stepId` = ? AND `locale_trickId` = ?";
        }
    }

    class k extends h0<TrickEntity> {

        final /* synthetic */ n0 d;
        k(u0 u0Var) {
            this.d = n0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, TrickEntity trickEntity) {
            long l;
            int i3 = 1;
            if (trickEntity.getTrickId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickEntity.getTrickId());
            }
            int i4 = 2;
            if (trickEntity.getName() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickEntity.getName());
            }
            int i5 = 3;
            if (trickEntity.getImage() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickEntity.getImage());
            }
            int i6 = 4;
            if (trickEntity.getCategoryName() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, trickEntity.getCategoryName());
            }
            int i7 = 5;
            if (trickEntity.getCategoryId() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, trickEntity.getCategoryId());
            }
            int i8 = 6;
            if (trickEntity.getExamInstructions() == null) {
                kVar.k1(i8);
            } else {
                kVar.D(i8, trickEntity.getExamInstructions());
            }
            int i9 = 7;
            if (trickEntity.getExamTimeLimit() == null) {
                kVar.k1(i9);
            } else {
                l = (long)trickEntity.getExamTimeLimit().intValue();
                kVar.u0(i9, l);
            }
            int i10 = 8;
            if (trickEntity.getSortOrder() == null) {
                kVar.k1(i10);
            } else {
                l = (long)trickEntity.getSortOrder().intValue();
                kVar.u0(i10, l);
            }
            kVar.u0(9, trickEntity.isExam() != 0 ? 1 : 0);
            kVar.u0(10, l3);
            kVar.u0(11, trickEntity.getUpdatedAt());
            int i13 = 12;
            if (trickEntity.getVideoId() == null) {
                kVar.k1(i13);
            } else {
                kVar.D(i13, trickEntity.getVideoId());
            }
            int i14 = 13;
            if (trickEntity.getVideoThumbnail() == null) {
                kVar.k1(i14);
            } else {
                kVar.D(i14, trickEntity.getVideoThumbnail());
            }
            int i15 = 14;
            if (trickEntity.getDescription() == null) {
                kVar.k1(i15);
            } else {
                kVar.D(i15, trickEntity.getDescription());
            }
            int i16 = 15;
            if (trickEntity.getLocale() == null) {
                kVar.k1(i16);
            } else {
                kVar.D(i16, trickEntity.getLocale());
            }
            int i17 = 16;
            if (trickEntity.getLocale_trickId() == null) {
                kVar.k1(i17);
            } else {
                kVar.D(i17, trickEntity.getLocale_trickId());
            }
            String stringList = this.d.c.fromStringList(trickEntity.getImageStepOrder());
            int i18 = 17;
            if (stringList == null) {
                kVar.k1(i18);
            } else {
                kVar.D(i18, stringList);
            }
            String stringList2 = this.d.c.fromStringList(trickEntity.getVideoStepOder());
            int i2 = 18;
            if (stringList2 == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, stringList2);
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickEntity` (`trickId`,`name`,`image`,`categoryName`,`categoryId`,`examInstructions`,`examTimeLimit`,`sortOrder`,`isExam`,`hasProgress`,`updatedAt`,`videoId`,`videoThumbnail`,`description`,`locale`,`locale_trickId`,`imageStepOrder`,`videoStepOder`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class l extends g0<l> {
        l(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(d.s.a.k kVar, l lVar) {
            int i = 1;
            if (lVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, lVar.b());
            }
            int i2 = 2;
            if (lVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, lVar.component1());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `TrickWithVariations` WHERE `locale_variationId` = ? AND `locale_trickId` = ?";
        }
    }

    class o0 extends h0<TrickCategoryEntity> {
        o0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, TrickCategoryEntity trickCategoryEntity) {
            int i2 = 1;
            if (trickCategoryEntity.getCategoryId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, trickCategoryEntity.getCategoryId());
            }
            int i3 = 2;
            if (trickCategoryEntity.getLocale() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickCategoryEntity.getLocale());
            }
            int i4 = 3;
            if (trickCategoryEntity.getName() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickCategoryEntity.getName());
            }
            kVar.u0(4, trickCategoryEntity.getUpdatedAt());
            int i5 = 5;
            if (trickCategoryEntity.getLocale_categoryId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickCategoryEntity.getLocale_categoryId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickCategoryEntity` (`categoryId`,`locale`,`name`,`updatedAt`,`locale_categoryId`) VALUES (?,?,?,?,?)";
        }
    }

    class p0 extends h0<e.a.a.a.b.c.k> {
        p0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, e.a.a.a.b.c.k kVar2) {
            int i = 1;
            if (kVar2.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, kVar2.component1());
            }
            int i2 = 2;
            if (kVar2.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, kVar2.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithTags` (`locale_tagId`,`locale_trickId`) VALUES (?,?)";
        }
    }

    class q0 extends h0<m> {
        q0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, m mVar) {
            int i = 1;
            if (mVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, mVar.component1());
            }
            int i2 = 2;
            if (mVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, mVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithVideoSteps` (`locale_stepId`,`locale_trickId`) VALUES (?,?)";
        }
    }

    class r0 extends h0<j> {
        r0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, j jVar) {
            int i = 1;
            if (jVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, jVar.component1());
            }
            int i2 = 2;
            if (jVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, jVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickWithSteps` (`locale_stepId`,`locale_trickId`) VALUES (?,?)";
        }
    }

    class v extends h0<TrickStepEntity> {
        v(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(d.s.a.k kVar, TrickStepEntity trickStepEntity) {
            int i2 = 1;
            if (trickStepEntity.getStepId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, trickStepEntity.getStepId());
            }
            int i3 = 2;
            if (trickStepEntity.getDescription() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, trickStepEntity.getDescription());
            }
            int i4 = 3;
            if (trickStepEntity.getImage() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, trickStepEntity.getImage());
            }
            int i5 = 4;
            if (trickStepEntity.getLocale() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, trickStepEntity.getLocale());
            }
            kVar.u0(5, trickStepEntity.getUpdatedAt());
            int i6 = 6;
            if (trickStepEntity.getLocale_stepId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, trickStepEntity.getLocale_stepId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `TrickStepEntity` (`stepId`,`description`,`image`,`locale`,`updatedAt`,`locale_stepId`) VALUES (?,?,?,?,?,?)";
        }
    }
    public n0(u0 u0Var) {
        super();
        e.a.a.a.b.a.a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.n0.k kVar = new app.dogo.android.persistencedb.room.dao.n0.k(this, u0Var);
        e.a.a.a.b.b.n0.v vVar = new app.dogo.android.persistencedb.room.dao.n0.v(this, u0Var);
        e.a.a.a.b.b.n0.a0 a0Var = new app.dogo.android.persistencedb.room.dao.n0.a0(this, u0Var);
        e.a.a.a.b.b.n0.d0 d0Var = new app.dogo.android.persistencedb.room.dao.n0.d0(this, u0Var);
        e.a.a.a.b.b.n0.h0 h0Var = new app.dogo.android.persistencedb.room.dao.n0.h0(this, u0Var);
        e.a.a.a.b.b.n0.o0 o0Var = new app.dogo.android.persistencedb.room.dao.n0.o0(this, u0Var);
        e.a.a.a.b.b.n0.p0 p0Var = new app.dogo.android.persistencedb.room.dao.n0.p0(this, u0Var);
        e.a.a.a.b.b.n0.q0 q0Var = new app.dogo.android.persistencedb.room.dao.n0.q0(this, u0Var);
        e.a.a.a.b.b.n0.r0 r0Var = new app.dogo.android.persistencedb.room.dao.n0.r0(this, u0Var);
        e.a.a.a.b.b.n0.a aVar = new app.dogo.android.persistencedb.room.dao.n0.a(this, u0Var);
        e.a.a.a.b.b.n0.b bVar = new app.dogo.android.persistencedb.room.dao.n0.b(this, u0Var);
        e.a.a.a.b.b.n0.c cVar = new app.dogo.android.persistencedb.room.dao.n0.c(this, u0Var);
        e.a.a.a.b.b.n0.d dVar = new app.dogo.android.persistencedb.room.dao.n0.d(this, u0Var);
        e.a.a.a.b.b.n0.e eVar = new app.dogo.android.persistencedb.room.dao.n0.e(this, u0Var);
        e.a.a.a.b.b.n0.f fVar = new app.dogo.android.persistencedb.room.dao.n0.f(this, u0Var);
        e.a.a.a.b.b.n0.g gVar = new app.dogo.android.persistencedb.room.dao.n0.g(this, u0Var);
        e.a.a.a.b.b.n0.h hVar = new app.dogo.android.persistencedb.room.dao.n0.h(this, u0Var);
        e.a.a.a.b.b.n0.i iVar = new app.dogo.android.persistencedb.room.dao.n0.i(this, u0Var);
        e.a.a.a.b.b.n0.j jVar = new app.dogo.android.persistencedb.room.dao.n0.j(this, u0Var);
        e.a.a.a.b.b.n0.l lVar = new app.dogo.android.persistencedb.room.dao.n0.l(this, u0Var);
    }

    private void A(d.e.a<String, ArrayList<TrickTagEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        TrickTagEntity trickTagEntity;
        String string;
        String string2;
        String string3;
        long _long;
        String string4;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i4 = 999;
        i2 = 0;
        if (aVar.size() > i4) {
            aVar2 = new a(i4);
            while (i2 < aVar.size()) {
                aVar2.put((String)aVar.j(i2), (ArrayList)aVar.n(i2));
                i2 = i2 + 1;
                i2 = i2 + 1;
            }
            if (i2 > 0) {
                A(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `TrickTagEntity`.`tagId` AS `tagId`,`TrickTagEntity`.`locale` AS `locale`,`TrickTagEntity`.`name` AS `name`,`TrickTagEntity`.`updatedAt` AS `updatedAt`,`TrickTagEntity`.`locale_tagId` AS `locale_tagId`,_junction.`locale_trickId` FROM `TrickWithTags` AS _junction INNER JOIN `TrickTagEntity` ON (_junction.`locale_tagId` = `TrickTagEntity`.`locale_tagId`) WHERE _junction.`locale_trickId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i2);
        Iterator it = keys.iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            i = i + 1;
        }
        android.os.CancellationSignal cancellationSignal = null;
        Cursor cursor = c.c(this.a, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(5));
            try {
                x0Var = aVar.get(this.a.getString(5));
                int i6 = 2;
                int i8 = 4;
                trickTagEntity = new TrickTagEntity(string, string2, string3, cursor.getLong(3), str4, string4);
                x0Var.add(trickTagEntity);
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    private void B(d.e.a<String, ArrayList<TrickVariationEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        String string;
        boolean _null;
        TrickVariationEntity trickVariationEntity;
        List stringList;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        long _long;
        String string7;
        final Object aVar3 = this;
        final Throwable obj3 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i4 = 999;
        i2 = 0;
        if (aVar.size() > i4) {
            aVar2 = new a(i4);
            while (i2 < aVar.size()) {
                aVar2.put((String)obj3.j(i2), (ArrayList)obj3.n(i2));
                i2 = i2 + 1;
                i2 = i2 + 1;
            }
            if (i2 > 0) {
                aVar3.B(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `TrickVariationEntity`.`tips` AS `tips`,`TrickVariationEntity`.`variationId` AS `variationId`,`TrickVariationEntity`.`title` AS `title`,`TrickVariationEntity`.`description` AS `description`,`TrickVariationEntity`.`locale` AS `locale`,`TrickVariationEntity`.`contentfulId` AS `contentfulId`,`TrickVariationEntity`.`updatedAt` AS `updatedAt`,`TrickVariationEntity`.`locale_variationId` AS `locale_variationId`,_junction.`locale_trickId` FROM `TrickWithVariations` AS _junction INNER JOIN `TrickVariationEntity` ON (_junction.`locale_variationId` = `TrickVariationEntity`.`locale_variationId`) WHERE _junction.`locale_trickId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i2);
        Iterator it = keys.iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            i = i + 1;
        }
        android.os.CancellationSignal cancellationSignal = null;
        Cursor cursor = c.c(aVar3.a, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = obj3.get(cursor.getString(8));
            try {
                x0Var = obj3.get(aVar3.a.getString(8));
                int i6 = 2;
                int i7 = 3;
                int i8 = 4;
                int i9 = 5;
                int i11 = 7;
                trickVariationEntity = new TrickVariationEntity(aVar3.c.toStringList(string), string2, string3, string4, string5, string6, cursor.getLong(6), str4, string7);
                x0Var.add(trickVariationEntity);
            } finally {
                obj4.close();
                throw th;
            }
        }
        cursor.close();
    }

    private void C(d.e.a<String, ArrayList<VideoStepEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        VideoStepEntity videoStepEntity;
        String string;
        String string2;
        String string3;
        int _int;
        long _long;
        String string4;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i4 = 999;
        i2 = 0;
        if (aVar.size() > i4) {
            aVar2 = new a(i4);
            while (i2 < aVar.size()) {
                aVar2.put((String)aVar.j(i2), (ArrayList)aVar.n(i2));
                i2 = i2 + 1;
                i2 = i2 + 1;
            }
            if (i2 > 0) {
                C(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `VideoStepEntity`.`stepId` AS `stepId`,`VideoStepEntity`.`text` AS `text`,`VideoStepEntity`.`locale` AS `locale`,`VideoStepEntity`.`startTime` AS `startTime`,`VideoStepEntity`.`updatedAt` AS `updatedAt`,`VideoStepEntity`.`locale_stepId` AS `locale_stepId`,_junction.`locale_trickId` FROM `TrickWithVideoSteps` AS _junction INNER JOIN `VideoStepEntity` ON (_junction.`locale_stepId` = `VideoStepEntity`.`locale_stepId`) WHERE _junction.`locale_trickId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i2);
        Iterator it = keys.iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            i = i + 1;
        }
        android.os.CancellationSignal cancellationSignal = null;
        Cursor cursor = c.c(this.a, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(6));
            try {
                x0Var = aVar.get(this.a.getString(6));
                int i6 = 2;
                int i9 = 5;
                videoStepEntity = new VideoStepEntity(string, string2, string3, cursor.getInt(3), cursor.getLong(4), str4, string4);
                x0Var.add(videoStepEntity);
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    static /* synthetic */ e.a.a.a.b.a.a D(n0 n0Var) {
        return n0Var.c;
    }

    static /* synthetic */ u0 E(n0 n0Var) {
        return n0Var.a;
    }

    static /* synthetic */ h0 F(n0 n0Var) {
        return n0Var.k;
    }

    static /* synthetic */ h0 G(n0 n0Var) {
        return n0Var.l;
    }

    static /* synthetic */ g0 H(n0 n0Var) {
        return n0Var.m;
    }

    static /* synthetic */ g0 I(n0 n0Var) {
        return n0Var.n;
    }

    static /* synthetic */ h0 J(n0 n0Var) {
        return n0Var.b;
    }

    static /* synthetic */ g0 K(n0 n0Var) {
        return n0Var.o;
    }

    static /* synthetic */ g0 L(n0 n0Var) {
        return n0Var.p;
    }

    static /* synthetic */ void M(n0 n0Var, d.e.a aVar) {
        n0Var.C(aVar);
    }

    static /* synthetic */ void N(n0 n0Var, d.e.a aVar) {
        n0Var.z(aVar);
    }

    static /* synthetic */ void O(n0 n0Var, d.e.a aVar) {
        n0Var.A(aVar);
    }

    static /* synthetic */ void P(n0 n0Var, d.e.a aVar) {
        n0Var.B(aVar);
    }

    static /* synthetic */ h0 Q(n0 n0Var) {
        return n0Var.d;
    }

    static /* synthetic */ h0 R(n0 n0Var) {
        return n0Var.e;
    }

    static /* synthetic */ h0 S(n0 n0Var) {
        return n0Var.f;
    }

    static /* synthetic */ h0 T(n0 n0Var) {
        return n0Var.g;
    }

    static /* synthetic */ h0 U(n0 n0Var) {
        return n0Var.h;
    }

    static /* synthetic */ h0 V(n0 n0Var) {
        return n0Var.i;
    }

    static /* synthetic */ h0 W(n0 n0Var) {
        return n0Var.j;
    }

    public static List<Class<?>> X() {
        return Collections.emptyList();
    }

    private void z(d.e.a<String, ArrayList<TrickStepEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        TrickStepEntity trickStepEntity;
        String string;
        String string2;
        String string3;
        String string4;
        long _long;
        String string5;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i4 = 999;
        i2 = 0;
        if (aVar.size() > i4) {
            aVar2 = new a(i4);
            while (i2 < aVar.size()) {
                aVar2.put((String)aVar.j(i2), (ArrayList)aVar.n(i2));
                i2 = i2 + 1;
                i2 = i2 + 1;
            }
            if (i2 > 0) {
                z(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `TrickStepEntity`.`stepId` AS `stepId`,`TrickStepEntity`.`description` AS `description`,`TrickStepEntity`.`image` AS `image`,`TrickStepEntity`.`locale` AS `locale`,`TrickStepEntity`.`updatedAt` AS `updatedAt`,`TrickStepEntity`.`locale_stepId` AS `locale_stepId`,_junction.`locale_trickId` FROM `TrickWithSteps` AS _junction INNER JOIN `TrickStepEntity` ON (_junction.`locale_stepId` = `TrickStepEntity`.`locale_stepId`) WHERE _junction.`locale_trickId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i2);
        Iterator it = keys.iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            i = i + 1;
        }
        android.os.CancellationSignal cancellationSignal = null;
        Cursor cursor = c.c(this.a, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(6));
            try {
                x0Var = aVar.get(this.a.getString(6));
                int i6 = 2;
                int i7 = 3;
                int i9 = 5;
                trickStepEntity = new TrickStepEntity(string, string2, string3, string4, cursor.getLong(4), str4, string5);
                x0Var.add(trickStepEntity);
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    public Object a(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.e0(this, x0.e("SELECT updatedAt FROM TrickTagEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public Object b(String str, d<? super List<l>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithVariations WHERE locale_trickId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.n0(this, x0Var), dVar);
    }

    public Object c(TrickEntity[] trickEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.m(this, trickEntityArr), dVar);
    }

    public Object d(m[] mVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.t(this, mVarArr), dVar);
    }

    public Object e(String str, d<? super List<j>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithSteps WHERE locale_trickId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.m0(this, x0Var), dVar);
    }

    public Object f(m[] mVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.y(this, mVarArr), dVar);
    }

    public Object g(e.a.a.a.b.c.k[] kVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.s(this, kVarArr), dVar);
    }

    public Object h(TrickVariationEntity[] trickVariationEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.q(this, trickVariationEntityArr), dVar);
    }

    public Object i(e.a.a.a.b.d.g gVar, d<? super w> dVar) {
        return app.dogo.android.persistencedb.room.dao.m0.a.b(this, gVar, dVar);
    }

    public Object j(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.c0(this, x0.e("SELECT updatedAt FROM TrickEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public Object k(l[] lVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.b0(this, lVarArr), dVar);
    }

    public Object l(TrickCategoryEntity[] trickCategoryEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.r(this, trickCategoryEntityArr), dVar);
    }

    public Object m(j[] jVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.z(this, jVarArr), dVar);
    }

    public Object n(String str, d<? super List<e.a.a.a.b.c.k>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithTags WHERE locale_trickId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.k0(this, x0Var), dVar);
    }

    public Object o(String str, String str2, d<? super TrickCategoryEntity> dVar) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM TrickCategoryEntity WHERE categoryId = ? AND locale = ?", i);
        int i3 = 1;
        if (str == null) {
            x0Var.k1(i3);
        } else {
            x0Var.D(i3, str);
        }
        if (str2 == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str2);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.g0(this, x0Var), dVar);
    }

    public Object p(TrickTagEntity[] trickTagEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.p(this, trickTagEntityArr), dVar);
    }

    public Object q(j[] jVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.u(this, jVarArr), dVar);
    }

    public Object r(TrickStepEntity[] trickStepEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.n(this, trickStepEntityArr), dVar);
    }

    public Object s(l[] lVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.w(this, lVarArr), dVar);
    }

    public Object t(String str, String str2, d<? super List<e.a.a.a.b.d.g>> dVar) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM TrickEntity WHERE locale = ? AND trickId = ?", i);
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
        return CoroutinesRoom.a(this.a, true, c.a(), new app.dogo.android.persistencedb.room.dao.n0.j0(this, x0Var), dVar);
    }

    public Object u(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.f0(this, x0.e("SELECT updatedAt FROM TrickCategoryEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public Object v(VideoStepEntity[] videoStepEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.o(this, videoStepEntityArr), dVar);
    }

    public Object w(e.a.a.a.b.c.k[] kVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.n0.x(this, kVarArr), dVar);
    }

    public Object x(String str, d<? super List<m>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickWithVideoSteps WHERE locale_trickId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.n0.l0(this, x0Var), dVar);
    }

    public a0<List<e.a.a.a.b.d.g>> y(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM TrickEntity WHERE locale = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.n0.i0(this, x0Var));
    }
}
