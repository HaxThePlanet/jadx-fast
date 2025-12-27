package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import app.dogo.android.persistencedb.room.database.ContentDatabase;
import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.ModuleEntity;
import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.c.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.w;

/* compiled from: ProgramEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class f0 extends e0 {

    private final u0 d;
    private final h0<LessonEntity> e = new f0$k<>();
    private final h0<ModuleEntity> f = new f0$t<>();
    private final h0<ProgramEntity> g = new f0$b0<>();
    private final e.a.a.a.b.a.a h = new a();
    private final h0<e.a.a.a.b.c.b> i = new f0$k0<>();
    private final h0<e.a.a.a.b.c.d> j = new f0$l0<>();
    private final h0<e.a.a.a.b.c.c> k = new f0$m0<>();
    private final h0<e.a.a.a.b.c.e> l = new f0$n0<>();
    private final h0<e.a.a.a.b.c.f> m = new f0$o0<>();
    private final h0<h> n = new f0$p0<>();
    private final g0<e.a.a.a.b.c.b> o = new f0$d<>();
    private final g0<e.a.a.a.b.c.d> p = new f0$e<>();
    private final g0<e.a.a.a.b.c.c> q = new f0$f<>();
    private final g0<e.a.a.a.b.c.e> r = new f0$g<>();
    private final g0<e.a.a.a.b.c.f> s = new f0$h<>();
    private final g0<h> t = new f0$i<>();

    class a0 implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        a0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public Long a() {
            android.os.CancellationSignal cancellationSignal = null;
            final boolean z = false;
            cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, z, cancellationSignal);
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

    class c0 implements Callable<List<e.a.a.a.b.d.e>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        c0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.d.e> a() {
            int i;
            ProgramEntity programEntity = null;
            String string = null;
            Object obj;
            int i7;
            List list2;
            x0 x0Var;
            int i9;
            int i10;
            ArrayList arrayList;
            int i11;
            int i8;
            String string2 = null;
            String string3 = null;
            int count;
            d.e.a aVar;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            String string5;
            String string17;
            String string6;
            String string16;
            String string7;
            String string15;
            String string8;
            String string9;
            String string10;
            String string11;
            String string12;
            String string13;
            long _long;
            String string14;
            List list;
            List stringList;
            List stringList2;
            List stringList3;
            int _int;
            int _int2;
            String string4;
            obj = this;
            obj.b.d.c();
            try {
                Cursor cursor = c.c(obj.b.d, obj.a, true, null);
            } catch (Throwable th) {
            }
            try {
                i = b.e(cursor, "type");
                i9 = b.e(cursor, "programId");
                int i19 = b.e(cursor, "name");
                int i20 = b.e(cursor, "image");
                int i21 = b.e(cursor, "centeredImage");
                int i22 = b.e(cursor, "description");
                int i23 = b.e(cursor, "cardBackgroundColor");
                int i24 = b.e(cursor, "certificateLaurelsImage");
                int i25 = b.e(cursor, "certificatePaperImage");
                int i26 = b.e(cursor, "certificatePlaceholderUrl");
                int i27 = b.e(cursor, "certificateRequirements");
                count = b.e(cursor, "locale");
                i10 = b.e(cursor, "locale_programId");
                aVar = new a();
                while (cursor.moveToNext()) {
                    String string19 = cursor.getString(i10);
                    if ((ArrayList)aVar.get(string19) == null) {
                        aVar.put(string19, new ArrayList());
                    } else {
                    }
                }
                cursor.moveToPosition(-1);
                obj.b.L(aVar);
                arrayList = new ArrayList(cursor.getCount());
            } catch (Throwable th) {
            }
            obj.b.d.C();
            try {
                cursor.close();
                obj.a.j();
            } catch (Throwable th) {
            }
            obj.b.d.g();
            return arrayList;
        }
    }

    class d0 implements Callable<List<e.a.a.a.b.d.e>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        d0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.d.e> a() {
            int i;
            ProgramEntity programEntity = null;
            String string = null;
            Object obj;
            int i7;
            List list2;
            x0 x0Var;
            int i9;
            int i10;
            ArrayList arrayList;
            int i11;
            int i8;
            String string2 = null;
            String string3 = null;
            int count;
            d.e.a aVar;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            String string5;
            String string17;
            String string6;
            String string16;
            String string7;
            String string15;
            String string8;
            String string9;
            String string10;
            String string11;
            String string12;
            String string13;
            long _long;
            String string14;
            List list;
            List stringList;
            List stringList2;
            List stringList3;
            int _int;
            int _int2;
            String string4;
            obj = this;
            obj.b.d.c();
            try {
                Cursor cursor = c.c(obj.b.d, obj.a, true, null);
            } catch (Throwable th) {
            }
            try {
                i = b.e(cursor, "type");
                i9 = b.e(cursor, "programId");
                int i19 = b.e(cursor, "name");
                int i20 = b.e(cursor, "image");
                int i21 = b.e(cursor, "centeredImage");
                int i22 = b.e(cursor, "description");
                int i23 = b.e(cursor, "cardBackgroundColor");
                int i24 = b.e(cursor, "certificateLaurelsImage");
                int i25 = b.e(cursor, "certificatePaperImage");
                int i26 = b.e(cursor, "certificatePlaceholderUrl");
                int i27 = b.e(cursor, "certificateRequirements");
                count = b.e(cursor, "locale");
                i10 = b.e(cursor, "locale_programId");
                aVar = new a();
                while (cursor.moveToNext()) {
                    String string19 = cursor.getString(i10);
                    if ((ArrayList)aVar.get(string19) == null) {
                        aVar.put(string19, new ArrayList());
                    } else {
                    }
                }
                cursor.moveToPosition(-1);
                obj.b.L(aVar);
                arrayList = new ArrayList(cursor.getCount());
            } catch (Throwable th) {
            }
            obj.b.d.C();
            try {
                cursor.close();
                obj.a.j();
            } catch (Throwable th) {
            }
            obj.b.d.g();
            return arrayList;
        }
    }

    class e0 implements Callable<List<e.a.a.a.b.c.d>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        e0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.d> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_lessonId");
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
                arrayList.add(new LessonWithTrick(string, obj));
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

    class f0 implements Callable<List<e.a.a.a.b.c.b>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        f0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.b> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_lessonId");
                int i3 = b.e(cursor, "locale_questionId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new LessonWithQuestion(string, obj));
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

    class g0 implements Callable<List<e.a.a.a.b.c.c>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        g0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.c> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_lessonId");
                int i3 = b.e(cursor, "locale_taskId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new LessonWithTask(string, obj));
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

    class h0 implements Callable<List<e.a.a.a.b.c.e>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        h0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.e> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_moduleId");
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
                arrayList.add(new ModuleWithExams(string, obj));
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

    class i0 implements Callable<List<e.a.a.a.b.c.f>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        i0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.f> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_moduleId");
                int i3 = b.e(cursor, "locale_lessonId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new ModuleWithLessons(string, obj));
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

    class j0 implements Callable<List<h>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ f0 b;
        j0(x0 x0Var) {
            this.b = f0Var;
            this.a = x0Var;
            super();
        }

        public List<h> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.d, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_programId");
                int i3 = b.e(cursor, "locale_moduleId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new ProgramWithModules(string, obj));
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

    class j implements Callable<w> {

        final /* synthetic */ LessonEntity[] a;
        final /* synthetic */ f0 b;
        j(LessonEntity[] lessonEntityArr) {
            this.b = f0Var;
            this.a = lessonEntityArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.e.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class l implements Callable<w> {

        final /* synthetic */ ModuleEntity[] a;
        final /* synthetic */ f0 b;
        l(ModuleEntity[] moduleEntityArr) {
            this.b = f0Var;
            this.a = moduleEntityArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.f.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class m implements Callable<w> {

        final /* synthetic */ ProgramEntity[] a;
        final /* synthetic */ f0 b;
        m(ProgramEntity[] programEntityArr) {
            this.b = f0Var;
            this.a = programEntityArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.g.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class n implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.b[] a;
        final /* synthetic */ f0 b;
        n(e.a.a.a.b.c.b[] bVarArr) {
            this.b = f0Var;
            this.a = bVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.i.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class o implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.d[] a;
        final /* synthetic */ f0 b;
        o(e.a.a.a.b.c.d[] dVarArr) {
            this.b = f0Var;
            this.a = dVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.j.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class p implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.c[] a;
        final /* synthetic */ f0 b;
        p(e.a.a.a.b.c.c[] cVarArr) {
            this.b = f0Var;
            this.a = cVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.k.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class q implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.e[] a;
        final /* synthetic */ f0 b;
        q(e.a.a.a.b.c.e[] eVarArr) {
            this.b = f0Var;
            this.a = eVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.l.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class r implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.f[] a;
        final /* synthetic */ f0 b;
        r(e.a.a.a.b.c.f[] fVarArr) {
            this.b = f0Var;
            this.a = fVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.m.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class s implements Callable<w> {

        final /* synthetic */ h[] a;
        final /* synthetic */ f0 b;
        s(h[] hVarArr) {
            this.b = f0Var;
            this.a = hVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.n.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class u implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.b[] a;
        final /* synthetic */ f0 b;
        u(e.a.a.a.b.c.b[] bVarArr) {
            this.b = f0Var;
            this.a = bVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.o.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class v implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.d[] a;
        final /* synthetic */ f0 b;
        v(e.a.a.a.b.c.d[] dVarArr) {
            this.b = f0Var;
            this.a = dVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.p.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class w implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.c[] a;
        final /* synthetic */ f0 b;
        w(e.a.a.a.b.c.c[] cVarArr) {
            this.b = f0Var;
            this.a = cVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.q.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class x implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.e[] a;
        final /* synthetic */ f0 b;
        x(e.a.a.a.b.c.e[] eVarArr) {
            this.b = f0Var;
            this.a = eVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.r.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class y implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.f[] a;
        final /* synthetic */ f0 b;
        y(e.a.a.a.b.c.f[] fVarArr) {
            this.b = f0Var;
            this.a = fVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.s.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class z implements Callable<w> {

        final /* synthetic */ h[] a;
        final /* synthetic */ f0 b;
        z(h[] hVarArr) {
            this.b = f0Var;
            this.a = hVarArr;
            super();
        }

        public w a() {
            this.b.d.c();
            try {
                this.b.t.i(this.a);
                this.b.d.C();
            } finally {
                e.a.a.a.b.b.f0 f0Var4 = this.b.d;
                this.b.g();
                throw th;
            }
            this.b.d.g();
            return w.a;
        }
    }

    class a extends g0<LessonEntity> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, LessonEntity lessonEntity) {
            final int i = 1;
            if (lessonEntity.getLocale_lessonId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, lessonEntity.getLocale_lessonId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonEntity` WHERE `locale_lessonId` = ?";
        }
    }

    class b0 extends h0<ProgramEntity> {

        final /* synthetic */ f0 d;
        b0(u0 u0Var) {
            this.d = f0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, ProgramEntity programEntity) {
            int i4 = 1;
            if (programEntity.getType() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, programEntity.getType());
            }
            int i5 = 2;
            if (programEntity.getProgramId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, programEntity.getProgramId());
            }
            int i6 = 3;
            if (programEntity.getName() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, programEntity.getName());
            }
            int i7 = 4;
            if (programEntity.getImage() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, programEntity.getImage());
            }
            int i8 = 5;
            if (programEntity.getCenteredImage() == null) {
                kVar.k1(i8);
            } else {
                kVar.D(i8, programEntity.getCenteredImage());
            }
            int i9 = 6;
            if (programEntity.getDescription() == null) {
                kVar.k1(i9);
            } else {
                kVar.D(i9, programEntity.getDescription());
            }
            int i10 = 7;
            if (programEntity.getCardBackgroundColor() == null) {
                kVar.k1(i10);
            } else {
                kVar.D(i10, programEntity.getCardBackgroundColor());
            }
            int i11 = 8;
            if (programEntity.getCertificateLaurelsImage() == null) {
                kVar.k1(i11);
            } else {
                kVar.D(i11, programEntity.getCertificateLaurelsImage());
            }
            int i12 = 9;
            if (programEntity.getCertificatePaperImage() == null) {
                kVar.k1(i12);
            } else {
                kVar.D(i12, programEntity.getCertificatePaperImage());
            }
            int i13 = 10;
            if (programEntity.getCertificatePlaceholderUrl() == null) {
                kVar.k1(i13);
            } else {
                kVar.D(i13, programEntity.getCertificatePlaceholderUrl());
            }
            int i14 = 11;
            if (programEntity.getCertificateRequirements() == null) {
                kVar.k1(i14);
            } else {
                kVar.D(i14, programEntity.getCertificateRequirements());
            }
            int i15 = 12;
            if (programEntity.getLocale() == null) {
                kVar.k1(i15);
            } else {
                kVar.D(i15, programEntity.getLocale());
            }
            kVar.u0(13, programEntity.getUpdatedAt());
            int i16 = 14;
            if (programEntity.getLocale_programId() == null) {
                kVar.k1(i16);
            } else {
                kVar.D(i16, programEntity.getLocale_programId());
            }
            int i17 = 15;
            if (programEntity.getProgramOverviewImage() == null) {
                kVar.k1(i17);
            } else {
                kVar.D(i17, programEntity.getProgramOverviewImage());
            }
            String stringList = this.d.h.fromStringList(programEntity.getDogSkillsHighlights());
            int i18 = 16;
            if (stringList == null) {
                kVar.k1(i18);
            } else {
                kVar.D(i18, stringList);
            }
            String stringList2 = this.d.h.fromStringList(programEntity.getDogSkillsOverview());
            int i19 = 17;
            if (stringList2 == null) {
                kVar.k1(i19);
            } else {
                kVar.D(i19, stringList2);
            }
            String stringList3 = this.d.h.fromStringList(programEntity.getUserSkillsOverview());
            int i20 = 18;
            if (stringList3 == null) {
                kVar.k1(i20);
            } else {
                kVar.D(i20, stringList3);
            }
            kVar.u0(19, (long)programEntity.getAverageCompletionTimeWeeks());
            kVar.u0(20, (long)programEntity.getNumberOfEnrolledUsers());
            int i21 = 21;
            if (programEntity.getCertificatePreviewImage() == null) {
                kVar.k1(i21);
            } else {
                kVar.D(i21, programEntity.getCertificatePreviewImage());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ProgramEntity` (`type`,`programId`,`name`,`image`,`centeredImage`,`description`,`cardBackgroundColor`,`certificateLaurelsImage`,`certificatePaperImage`,`certificatePlaceholderUrl`,`certificateRequirements`,`locale`,`updatedAt`,`locale_programId`,`programOverviewImage`,`dogSkillsHighlights`,`dogSkillsOverview`,`userSkillsOverview`,`averageCompletionTimeWeeks`,`numberOfEnrolledUsers`,`certificatePreviewImage`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends g0<ModuleEntity> {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, ModuleEntity moduleEntity) {
            final int i = 1;
            if (moduleEntity.getLocale_moduleId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, moduleEntity.getLocale_moduleId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ModuleEntity` WHERE `locale_moduleId` = ?";
        }
    }

    class c extends g0<ProgramEntity> {
        c(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, ProgramEntity programEntity) {
            final int i = 1;
            if (programEntity.getLocale_programId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, programEntity.getLocale_programId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ProgramEntity` WHERE `locale_programId` = ?";
        }
    }

    class d extends g0<e.a.a.a.b.c.b> {
        d(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.b bVar) {
            int i = 1;
            if (bVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, bVar.component1());
            }
            int i2 = 2;
            if (bVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, bVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonWithQuestion` WHERE `locale_lessonId` = ? AND `locale_questionId` = ?";
        }
    }

    class e extends g0<e.a.a.a.b.c.d> {
        e(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.d dVar) {
            int i = 1;
            if (dVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, dVar.component1());
            }
            int i2 = 2;
            if (dVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, dVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonWithTrick` WHERE `locale_lessonId` = ? AND `locale_trickId` = ?";
        }
    }

    class f extends g0<e.a.a.a.b.c.c> {
        f(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.c cVar) {
            int i = 1;
            if (cVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, cVar.component1());
            }
            int i2 = 2;
            if (cVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, cVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `LessonWithTask` WHERE `locale_lessonId` = ? AND `locale_taskId` = ?";
        }
    }

    class g extends g0<e.a.a.a.b.c.e> {
        g(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.e eVar) {
            int i = 1;
            if (eVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, eVar.component1());
            }
            int i2 = 2;
            if (eVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, eVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ModuleWithExams` WHERE `locale_moduleId` = ? AND `locale_trickId` = ?";
        }
    }

    class h extends g0<e.a.a.a.b.c.f> {
        h(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.f fVar) {
            int i = 1;
            if (fVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, fVar.b());
            }
            int i2 = 2;
            if (fVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, fVar.component1());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ModuleWithLessons` WHERE `locale_moduleId` = ? AND `locale_lessonId` = ?";
        }
    }

    class i extends g0<h> {
        i(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, h hVar) {
            int i = 1;
            if (hVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, hVar.b());
            }
            int i2 = 2;
            if (hVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, hVar.component1());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ProgramWithModules` WHERE `locale_programId` = ? AND `locale_moduleId` = ?";
        }
    }

    class k0 extends h0<e.a.a.a.b.c.b> {
        k0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.b bVar) {
            int i = 1;
            if (bVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, bVar.component1());
            }
            int i2 = 2;
            if (bVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, bVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonWithQuestion` (`locale_lessonId`,`locale_questionId`) VALUES (?,?)";
        }
    }

    class k extends h0<LessonEntity> {
        k(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, LessonEntity lessonEntity) {
            int i3 = 1;
            if (lessonEntity.getLessonId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, lessonEntity.getLessonId());
            }
            kVar.u0(2, (long)lessonEntity.getIndex());
            int i4 = 3;
            if (lessonEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, lessonEntity.getLocale());
            }
            int i5 = 4;
            if (lessonEntity.getProgramId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, lessonEntity.getProgramId());
            }
            kVar.u0(5, lessonEntity.getUpdatedAt());
            int i6 = 6;
            if (lessonEntity.getLocale_lessonId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, lessonEntity.getLocale_lessonId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonEntity` (`lessonId`,`index`,`locale`,`programId`,`updatedAt`,`locale_lessonId`) VALUES (?,?,?,?,?,?)";
        }
    }

    class l0 extends h0<e.a.a.a.b.c.d> {
        l0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.d dVar) {
            int i = 1;
            if (dVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, dVar.component1());
            }
            int i2 = 2;
            if (dVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, dVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonWithTrick` (`locale_lessonId`,`locale_trickId`) VALUES (?,?)";
        }
    }

    class m0 extends h0<e.a.a.a.b.c.c> {
        m0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.c cVar) {
            int i = 1;
            if (cVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, cVar.component1());
            }
            int i2 = 2;
            if (cVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, cVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `LessonWithTask` (`locale_lessonId`,`locale_taskId`) VALUES (?,?)";
        }
    }

    class n0 extends h0<e.a.a.a.b.c.e> {
        n0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.e eVar) {
            int i = 1;
            if (eVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, eVar.component1());
            }
            int i2 = 2;
            if (eVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, eVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ModuleWithExams` (`locale_moduleId`,`locale_trickId`) VALUES (?,?)";
        }
    }

    class o0 extends h0<e.a.a.a.b.c.f> {
        o0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.f fVar) {
            int i = 1;
            if (fVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, fVar.b());
            }
            int i2 = 2;
            if (fVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, fVar.component1());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ModuleWithLessons` (`locale_moduleId`,`locale_lessonId`) VALUES (?,?)";
        }
    }

    class p0 extends h0<h> {
        p0(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, h hVar) {
            int i = 1;
            if (hVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, hVar.b());
            }
            int i2 = 2;
            if (hVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, hVar.component1());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ProgramWithModules` (`locale_programId`,`locale_moduleId`) VALUES (?,?)";
        }
    }

    class t extends h0<ModuleEntity> {
        t(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, ModuleEntity moduleEntity) {
            int i3 = 1;
            if (moduleEntity.getModuleId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, moduleEntity.getModuleId());
            }
            kVar.u0(2, (long)moduleEntity.getIndex());
            int i4 = 3;
            if (moduleEntity.getName() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, moduleEntity.getName());
            }
            int i5 = 4;
            if (moduleEntity.getLocale() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, moduleEntity.getLocale());
            }
            kVar.u0(5, moduleEntity.getUpdatedAt());
            int i6 = 6;
            if (moduleEntity.getLocale_moduleId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, moduleEntity.getLocale_moduleId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ModuleEntity` (`moduleId`,`index`,`name`,`locale`,`updatedAt`,`locale_moduleId`) VALUES (?,?,?,?,?,?)";
        }
    }
    public f0(ContentDatabase contentDatabase) {
        super(contentDatabase);
        e.a.a.a.b.a.a dataConverter = new DataConverter();
        this.d = contentDatabase;
        e.a.a.a.b.b.f0.k kVar = new app.dogo.android.persistencedb.room.dao.f0.k(this, contentDatabase);
        e.a.a.a.b.b.f0.t tVar = new app.dogo.android.persistencedb.room.dao.f0.t(this, contentDatabase);
        e.a.a.a.b.b.f0.b0 b0Var = new app.dogo.android.persistencedb.room.dao.f0.b0(this, contentDatabase);
        e.a.a.a.b.b.f0.k0 k0Var = new app.dogo.android.persistencedb.room.dao.f0.k0(this, contentDatabase);
        e.a.a.a.b.b.f0.l0 l0Var = new app.dogo.android.persistencedb.room.dao.f0.l0(this, contentDatabase);
        e.a.a.a.b.b.f0.m0 m0Var = new app.dogo.android.persistencedb.room.dao.f0.m0(this, contentDatabase);
        e.a.a.a.b.b.f0.n0 n0Var = new app.dogo.android.persistencedb.room.dao.f0.n0(this, contentDatabase);
        e.a.a.a.b.b.f0.o0 o0Var = new app.dogo.android.persistencedb.room.dao.f0.o0(this, contentDatabase);
        e.a.a.a.b.b.f0.p0 p0Var = new app.dogo.android.persistencedb.room.dao.f0.p0(this, contentDatabase);
        e.a.a.a.b.b.f0.a aVar = new app.dogo.android.persistencedb.room.dao.f0.a(this, contentDatabase);
        e.a.a.a.b.b.f0.b bVar = new app.dogo.android.persistencedb.room.dao.f0.b(this, contentDatabase);
        e.a.a.a.b.b.f0.c cVar = new app.dogo.android.persistencedb.room.dao.f0.c(this, contentDatabase);
        e.a.a.a.b.b.f0.d dVar = new app.dogo.android.persistencedb.room.dao.f0.d(this, contentDatabase);
        e.a.a.a.b.b.f0.e eVar = new app.dogo.android.persistencedb.room.dao.f0.e(this, contentDatabase);
        e.a.a.a.b.b.f0.f fVar = new app.dogo.android.persistencedb.room.dao.f0.f(this, contentDatabase);
        e.a.a.a.b.b.f0.g gVar = new app.dogo.android.persistencedb.room.dao.f0.g(this, contentDatabase);
        e.a.a.a.b.b.f0.h hVar = new app.dogo.android.persistencedb.room.dao.f0.h(this, contentDatabase);
        e.a.a.a.b.b.f0.i iVar = new app.dogo.android.persistencedb.room.dao.f0.i(this, contentDatabase);
    }

    private void I(d.e.a<String, e.a.a.a.b.d.a> aVar) {
        d.e.a aVar2;
        int i = 0;
        ArticleEntity articleEntity = null;
        Object obj = null;
        List list;
        int i3;
        e.a.a.a.b.d.a articleFullEntity;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean _null5;
        String string7;
        String string8;
        String string6;
        int _int;
        Integer num;
        String string5;
        String string;
        String string4;
        long _long;
        String string2;
        int i10;
        final Object aVar3 = this;
        final Throwable obj3 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i11 = 999;
        i = 0;
        obj = null;
        if (aVar.size() > i11) {
            aVar2 = new a(i11);
            while (i < aVar.size()) {
                aVar2.put((String)obj3.j(i), obj);
                i = i + 1;
                i = i + 1;
            }
            if (i > 0) {
                aVar3.I(aVar2);
                obj3.putAll(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `ArticleEntity`.`articleId` AS `articleId`,`ArticleEntity`.`title` AS `title`,`ArticleEntity`.`text` AS `text`,`ArticleEntity`.`readingTime` AS `readingTime`,`ArticleEntity`.`sortOrder` AS `sortOrder`,`ArticleEntity`.`categoryId` AS `categoryId`,`ArticleEntity`.`image` AS `image`,`ArticleEntity`.`locale` AS `locale`,`ArticleEntity`.`updatedAt` AS `updatedAt`,`ArticleEntity`.`locale_articleId` AS `locale_articleId`,`ArticleEntity`.`textHtml` AS `textHtml`,_junction.`locale_questionId` FROM `QuestionWithArticle` AS _junction INNER JOIN `ArticleEntity` ON (_junction.`locale_articleId` = `ArticleEntity`.`locale_articleId`) WHERE _junction.`locale_questionId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i);
        Iterator it = keys.iterator();
        boolean z = true;
        i3 = z;
        while (it.hasNext()) {
            Object item = it.next();
            i3 = i3 + 1;
        }
        Cursor cursor = c.c(aVar3.d, x0Var, z, obj);
        try {
            d.e.a aVar4 = new a();
            int i16 = 9;
            while (cursor.moveToNext()) {
                String string11 = cursor.getString(i16);
                if ((ArrayList)aVar4.get(string11) == null) {
                    aVar4.put(string11, new ArrayList());
                }
            }
            int i4 = -1;
            cursor.moveToPosition(i4);
            aVar3.J(aVar4);
            String string10 = cursor.getString(11);
            int i17 = 8;
            i5 = 3;
            i6 = 10;
            i7 = 7;
            i8 = 6;
            i9 = 5;
            int i14 = 4;
            int i2 = 2;
            if (!cursor.isNull(i) || !(!aVar3.d.isNull(z) && !aVar3.d.isNull(i2) && !aVar3.d.isNull(i5) && !aVar3.d.isNull(i14) && !aVar3.d.isNull(i9) && !aVar3.d.isNull(i8) && !aVar3.d.isNull(i7) && !aVar3.d.isNull(i17) && !aVar3.d.isNull(i16) && aVar3.d.isNull(i6))) {
                i = 0;
                int i18 = cursor.isNull(i) ? 0 : string7;
                int i19 = cursor.isNull(z) ? 0 : string8;
                int i20 = cursor.isNull(i2) ? 0 : string6;
                if (cursor.isNull(i14)) {
                    int i21 = 0;
                } else {
                }
                int i22 = cursor.isNull(i9) ? 0 : string5;
                int i23 = cursor.isNull(i8) ? 0 : string;
                int i24 = cursor.isNull(i7) ? 0 : string4;
                int i25 = cursor.isNull(i16) ? 0 : string2;
                i10 = cursor.isNull(i6) ? 0 : string3;
                articleEntity = new ArticleEntity(string7, string8, string6, cursor.getInt(i5), num, string5, string, string4, cursor.getLong(i17), str4, string2, i10);
            }
            if ((ArrayList)aVar4.get(cursor.getString(i16)) == null) {
                ArrayList arrayList = new ArrayList();
            }
            obj3.put(string10, new ArticleFullEntity(articleEntity, list));
        } finally {
            obj4.close();
            throw th;
        }
        cursor.close();
    }

    private void J(d.e.a<String, ArrayList<ArticleTagEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        ArticleTagEntity articleTagEntity;
        boolean z;
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
                J(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `ArticleTagEntity`.`hidden` AS `hidden`,`ArticleTagEntity`.`tagId` AS `tagId`,`ArticleTagEntity`.`locale` AS `locale`,`ArticleTagEntity`.`name` AS `name`,`ArticleTagEntity`.`updatedAt` AS `updatedAt`,`ArticleTagEntity`.`locale_tagId` AS `locale_tagId`,_junction.`locale_articleId` FROM `ArticleWithTags` AS _junction INNER JOIN `ArticleTagEntity` ON (_junction.`locale_tagId` = `ArticleTagEntity`.`locale_tagId`) WHERE _junction.`locale_articleId` IN (";
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
        Cursor cursor = c.c(this.d, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(6));
            try {
                x0Var = aVar.get(this.d.getString(6));
                int r7 = cursor.getInt(i2) != 0 ? i : i2;
                int i6 = 2;
                int i7 = 3;
                int i9 = 5;
                articleTagEntity = new ArticleTagEntity(z, string, string2, string3, cursor.getLong(4), str4, string4);
                x0Var.add(articleTagEntity);
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    private void K(d.e.a<String, ArrayList<e.a.a.a.b.d.b>> aVar) {
        d.e.a aVar2;
        int i;
        int i2;
        Object obj4;
        LessonEntity lessonEntity;
        List list;
        Object obj5;
        List list2;
        e.a.a.a.b.d.b lessonFullEntity;
        String string2;
        int _int;
        String string3;
        String string4;
        long _long;
        android.os.CancellationSignal cancellationSignal;
        final Object aVar3 = this;
        final Throwable obj6 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i4 = 999;
        i = 0;
        if (aVar.size() > i4) {
            aVar2 = new a(i4);
            while (i < aVar.size()) {
                aVar2.put((String)obj6.j(i), (ArrayList)obj6.n(i));
                i = i + 1;
                i = i + 1;
            }
            if (i > 0) {
                aVar3.K(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `LessonEntity`.`lessonId` AS `lessonId`,`LessonEntity`.`index` AS `index`,`LessonEntity`.`locale` AS `locale`,`LessonEntity`.`programId` AS `programId`,`LessonEntity`.`updatedAt` AS `updatedAt`,`LessonEntity`.`locale_lessonId` AS `locale_lessonId`,_junction.`locale_moduleId` FROM `ModuleWithLessons` AS _junction INNER JOIN `LessonEntity` ON (_junction.`locale_lessonId` = `LessonEntity`.`locale_lessonId`) WHERE _junction.`locale_moduleId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i);
        Iterator it = keys.iterator();
        boolean z = true;
        i2 = z;
        while (it.hasNext()) {
            Object item = it.next();
            i2 = i2 + 1;
        }
        cancellationSignal = null;
        Cursor cursor = c.c(aVar3.d, x0Var, z, cancellationSignal);
        try {
            d.e.a aVar4 = new a();
            d.e.a aVar5 = new a();
            d.e.a aVar6 = new a();
            int i7 = 5;
            while (cursor.moveToNext()) {
                String string7 = cursor.getString(i7);
                if ((ArrayList)aVar4.get(string7) == null) {
                    aVar4.put(string7, new ArrayList());
                }
                aVar5.put(cursor.getString(i7), cancellationSignal);
                String string = cursor.getString(i7);
                if ((ArrayList)aVar6.get(string) == null) {
                    aVar6.put(string, new ArrayList());
                }
            }
            int i3 = -1;
            cursor.moveToPosition(i3);
            aVar3.N(aVar4);
            aVar3.M(aVar5);
            aVar3.O(aVar6);
            Object obj8 = obj6.get(cursor.getString(6));
            int i8 = 4;
            int i9 = 3;
            int i10 = 2;
            if (!cursor.isNull(i) || !(!aVar3.d.isNull(z) && !aVar3.d.isNull(i10) && !aVar3.d.isNull(i9) && !aVar3.d.isNull(i8) && aVar3.d.isNull(i7))) {
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i10) ? cancellationSignal : string3;
                cancellationSignal = cursor.isNull(i9) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i7) ? cancellationSignal : string5;
                lessonEntity = new LessonEntity(string2, cursor.getInt(z), string3, string4, cursor.getLong(i8), str4, cancellationSignal);
            }
            if ((ArrayList)aVar4.get(cursor.getString(i7)) == null) {
                ArrayList arrayList3 = new ArrayList();
            }
            if ((ArrayList)aVar6.get(cursor.getString(i7)) == null) {
                ArrayList arrayList4 = new ArrayList();
            }
            obj8.add(new LessonFullEntity(lessonEntity, list, (QuestionFullEntity)aVar5.get(cursor.getString(i7)), list2));
        } finally {
            obj7.close();
            throw th;
        }
        cursor.close();
    }

    private void L(d.e.a<String, ArrayList<e.a.a.a.b.d.c>> aVar) {
        d.e.a aVar2;
        int i;
        int i2;
        Object obj4;
        ModuleEntity moduleEntity;
        List list;
        List list2;
        e.a.a.a.b.d.c moduleFullEntity;
        String string2;
        int _int;
        String string3;
        String string4;
        long _long;
        android.os.CancellationSignal cancellationSignal;
        final Object aVar3 = this;
        final Throwable obj5 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i4 = 999;
        i = 0;
        if (aVar.size() > i4) {
            aVar2 = new a(i4);
            while (i < aVar.size()) {
                aVar2.put((String)obj5.j(i), (ArrayList)obj5.n(i));
                i = i + 1;
                i = i + 1;
            }
            if (i > 0) {
                aVar3.L(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `ModuleEntity`.`moduleId` AS `moduleId`,`ModuleEntity`.`index` AS `index`,`ModuleEntity`.`name` AS `name`,`ModuleEntity`.`locale` AS `locale`,`ModuleEntity`.`updatedAt` AS `updatedAt`,`ModuleEntity`.`locale_moduleId` AS `locale_moduleId`,_junction.`locale_programId` FROM `ProgramWithModules` AS _junction INNER JOIN `ModuleEntity` ON (_junction.`locale_moduleId` = `ModuleEntity`.`locale_moduleId`) WHERE _junction.`locale_programId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i);
        Iterator it = keys.iterator();
        boolean z = true;
        i2 = z;
        while (it.hasNext()) {
            Object item = it.next();
            i2 = i2 + 1;
        }
        cancellationSignal = null;
        Cursor cursor = c.c(aVar3.d, x0Var, z, cancellationSignal);
        try {
            d.e.a aVar4 = new a();
            d.e.a aVar5 = new a();
            int i7 = 5;
            while (cursor.moveToNext()) {
                String string7 = cursor.getString(i7);
                if ((ArrayList)aVar4.get(string7) == null) {
                    aVar4.put(string7, new ArrayList());
                }
                String string = cursor.getString(i7);
                if ((ArrayList)aVar5.get(string) == null) {
                    aVar5.put(string, new ArrayList());
                }
            }
            int i3 = -1;
            cursor.moveToPosition(i3);
            aVar3.K(aVar4);
            aVar3.P(aVar5);
            Object obj7 = obj5.get(cursor.getString(6));
            int i8 = 4;
            int i9 = 3;
            int i10 = 2;
            if (!cursor.isNull(i) || !(!aVar3.d.isNull(z) && !aVar3.d.isNull(i10) && !aVar3.d.isNull(i9) && !aVar3.d.isNull(i8) && aVar3.d.isNull(i7))) {
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string2;
                cancellationSignal = cursor.isNull(i10) ? cancellationSignal : string3;
                cancellationSignal = cursor.isNull(i9) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i7) ? cancellationSignal : string5;
                moduleEntity = new ModuleEntity(string2, cursor.getInt(z), string3, string4, cursor.getLong(i8), str4, cancellationSignal);
            }
            if ((ArrayList)aVar4.get(cursor.getString(i7)) == null) {
                ArrayList arrayList3 = new ArrayList();
            }
            if ((ArrayList)aVar5.get(cursor.getString(i7)) == null) {
                ArrayList arrayList4 = new ArrayList();
            }
            obj7.add(new ModuleFullEntity(moduleEntity, list, list2));
        } finally {
            obj6.close();
            throw th;
        }
        cursor.close();
    }

    private void M(d.e.a<String, e.a.a.a.b.d.f> aVar) {
        d.e.a aVar2;
        int i;
        int i2;
        QuestionEntity questionEntity;
        String string4;
        Object obj3;
        e.a.a.a.b.d.f questionFullEntity;
        int i4;
        int i5 = 2;
        String string;
        String string2;
        String string3;
        List stringList;
        int _int;
        long _long;
        String string5;
        final Object aVar3 = this;
        final Throwable obj4 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i6 = 999;
        i = 0;
        final Object obj = null;
        if (aVar.size() > i6) {
            aVar2 = new a(i6);
            while (i < aVar.size()) {
                aVar2.put((String)obj4.j(i), obj);
                i = i + 1;
                i = i + 1;
            }
            if (i > 0) {
                aVar3.M(aVar2);
                obj4.putAll(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `QuestionEntity`.`questionId` AS `questionId`,`QuestionEntity`.`locale` AS `locale`,`QuestionEntity`.`question` AS `question`,`QuestionEntity`.`answers` AS `answers`,`QuestionEntity`.`correctAnswer` AS `correctAnswer`,`QuestionEntity`.`updatedAt` AS `updatedAt`,`QuestionEntity`.`locale_questionId` AS `locale_questionId`,_junction.`locale_lessonId` FROM `LessonWithQuestion` AS _junction INNER JOIN `QuestionEntity` ON (_junction.`locale_questionId` = `QuestionEntity`.`locale_questionId`) WHERE _junction.`locale_lessonId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i);
        Iterator it = keys.iterator();
        boolean z = true;
        i2 = z;
        while (it.hasNext()) {
            Object item = it.next();
            i2 = i2 + 1;
        }
        Cursor cursor = c.c(aVar3.d, x0Var, z, obj);
        try {
            d.e.a aVar4 = new a();
            int i9 = 6;
            while (cursor.moveToNext()) {
                aVar4.put(cursor.getString(i9), obj);
                i9 = 6;
            }
            int i3 = -1;
            cursor.moveToPosition(i3);
            aVar3.I(aVar4);
            String string6 = cursor.getString(7);
            int i10 = 5;
            int i11 = 4;
            i4 = 3;
            i5 = 2;
            if (!cursor.isNull(i) || !(!aVar3.d.isNull(z) && !aVar3.d.isNull(i5) && !aVar3.d.isNull(i4) && !aVar3.d.isNull(i11) && !aVar3.d.isNull(i10) && aVar3.d.isNull(i9))) {
                obj = cursor.isNull(i) ? obj : string;
                obj = cursor.isNull(z) ? obj : string2;
                obj = cursor.isNull(i5) ? obj : string3;
                if (cursor.isNull(i4)) {
                } else {
                    string4 = cursor.getString(i4);
                }
                obj = cursor.isNull(i9) ? obj : string5;
                questionEntity = new QuestionEntity(string, string2, string3, aVar3.h.toStringList(string4), cursor.getInt(i11), cursor.getLong(i10), str4, string5);
            }
            obj4.put(string6, new QuestionFullEntity(questionEntity, (ArticleFullEntity)aVar4.get(cursor.getString(i9))));
        } finally {
            obj5.close();
            throw th;
        }
        cursor.close();
    }

    private void N(d.e.a<String, ArrayList<TaskEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        TaskEntity taskEntity;
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
                N(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `TaskEntity`.`taskId` AS `taskId`,`TaskEntity`.`text` AS `text`,`TaskEntity`.`locale` AS `locale`,`TaskEntity`.`updatedAt` AS `updatedAt`,`TaskEntity`.`locale_taskId` AS `locale_taskId`,_junction.`locale_lessonId` FROM `LessonWithTask` AS _junction INNER JOIN `TaskEntity` ON (_junction.`locale_taskId` = `TaskEntity`.`locale_taskId`) WHERE _junction.`locale_lessonId` IN (";
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
        Cursor cursor = c.c(this.d, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(5));
            try {
                x0Var = aVar.get(this.d.getString(5));
                int i6 = 2;
                int i8 = 4;
                taskEntity = new TaskEntity(string, string2, string3, cursor.getLong(3), str4, string4);
                x0Var.add(taskEntity);
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    private void O(d.e.a<String, ArrayList<e.a.a.a.b.d.g>> aVar) {
        d.e.a aVar2;
        int i = 0;
        int i2 = 15;
        int i3 = 8;
        int i4 = 12;
        int i5 = 13;
        int i6 = 14;
        int i7 = 15;
        int i8 = 16;
        String string2 = null;
        String string3 = null;
        int i9 = 15;
        Object obj;
        Object obj2;
        Object obj3;
        int i10;
        android.os.CancellationSignal cancellationSignal = null;
        Object obj4;
        Object obj8;
        boolean _null2;
        boolean _null3;
        boolean _null4;
        boolean _null5;
        e.a.a.a.b.d.g trickFullEntity;
        TrickEntity trickEntity;
        List list;
        List list2;
        List list3;
        List list4;
        String string13;
        String string14;
        String string12;
        String string11;
        String string10;
        String string7;
        Integer num2;
        Integer num;
        boolean z;
        long _long;
        String string6;
        String string5;
        String string;
        String string4;
        Object obj11;
        List stringList;
        List stringList2;
        final Object aVar4 = this;
        final Throwable obj12 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i12 = 999;
        i = 0;
        if (aVar.size() > i12) {
            aVar2 = new a(i12);
            while (i < aVar.size()) {
                aVar2.put((String)obj12.j(i), (ArrayList)obj12.n(i));
                i = i + 1;
                i = i + 1;
            }
            if (i > 0) {
                aVar4.O(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `TrickEntity`.`trickId` AS `trickId`,`TrickEntity`.`name` AS `name`,`TrickEntity`.`image` AS `image`,`TrickEntity`.`categoryName` AS `categoryName`,`TrickEntity`.`categoryId` AS `categoryId`,`TrickEntity`.`examInstructions` AS `examInstructions`,`TrickEntity`.`examTimeLimit` AS `examTimeLimit`,`TrickEntity`.`sortOrder` AS `sortOrder`,`TrickEntity`.`isExam` AS `isExam`,`TrickEntity`.`hasProgress` AS `hasProgress`,`TrickEntity`.`updatedAt` AS `updatedAt`,`TrickEntity`.`videoId` AS `videoId`,`TrickEntity`.`videoThumbnail` AS `videoThumbnail`,`TrickEntity`.`description` AS `description`,`TrickEntity`.`locale` AS `locale`,`TrickEntity`.`locale_trickId` AS `locale_trickId`,`TrickEntity`.`imageStepOrder` AS `imageStepOrder`,`TrickEntity`.`videoStepOder` AS `videoStepOder`,_junction.`locale_lessonId` FROM `LessonWithTrick` AS _junction INNER JOIN `TrickEntity` ON (_junction.`locale_trickId` = `TrickEntity`.`locale_trickId`) WHERE _junction.`locale_lessonId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i);
        Iterator it = keys.iterator();
        z = true;
        i10 = z;
        while (it.hasNext()) {
            Object item = it.next();
            i10 = i10 + 1;
        }
        cancellationSignal = null;
        Cursor cursor = c.c(aVar4.d, x0Var, z, cancellationSignal);
        try {
            d.e.a aVar5 = new a();
            d.e.a aVar7 = new a();
            d.e.a aVar8 = new a();
            d.e.a aVar9 = new a();
            i2 = 15;
            while (cursor.moveToNext()) {
                String string19 = cursor.getString(i2);
                if ((ArrayList)aVar5.get(string19) == null) {
                    aVar5.put(string19, new ArrayList());
                }
                String string20 = cursor.getString(i2);
                if ((ArrayList)aVar7.get(string20) == null) {
                    aVar7.put(string20, new ArrayList());
                }
                String string21 = cursor.getString(i2);
                if ((ArrayList)aVar8.get(string21) == null) {
                    aVar8.put(string21, new ArrayList());
                }
                String string9 = cursor.getString(i2);
                if ((ArrayList)aVar9.get(string9) == null) {
                    aVar9.put(string9, new ArrayList());
                }
            }
            int i11 = -1;
            cursor.moveToPosition(i11);
            aVar4.T(aVar5);
            aVar4.Q(aVar7);
            aVar4.R(aVar8);
            aVar4.S(aVar9);
            Object obj14 = obj12.get(cursor.getString(18));
            int i14 = 7;
            i2 = 6;
            int i23 = 5;
            int i35 = 4;
            int i36 = 3;
            int i37 = 2;
            if (cursor.isNull(i) && aVar4.d.isNull(z) && aVar4.d.isNull(i37) && aVar4.d.isNull(i36) && aVar4.d.isNull(i35) && aVar4.d.isNull(i23) && aVar4.d.isNull(i2) && aVar4.d.isNull(i14)) {
                if (cursor.isNull(8)) {
                    if (cursor.isNull(9)) {
                        if (cursor.isNull(10)) {
                            if (cursor.isNull(11)) {
                                if (cursor.isNull(12)) {
                                    if (cursor.isNull(13)) {
                                        if (cursor.isNull(14)) {
                                            if (cursor.isNull(15)) {
                                                if (cursor.isNull(16)) {
                                                    if (!cursor.isNull(17)) {
                                                        i = 0;
                                                        int i39 = cursor.isNull(i) ? 0 : string13;
                                                        int i40 = cursor.isNull(z) ? 0 : string14;
                                                        int i41 = cursor.isNull(i37) ? 0 : string12;
                                                        int i42 = cursor.isNull(i36) ? 0 : string11;
                                                        int i43 = cursor.isNull(i35) ? 0 : string10;
                                                        int i44 = cursor.isNull(i23) ? 0 : string7;
                                                        if (cursor.isNull(i2)) {
                                                            int i45 = 0;
                                                        } else {
                                                        }
                                                        if (cursor.isNull(i14)) {
                                                            i3 = 8;
                                                            int i46 = 0;
                                                        } else {
                                                            i3 = 8;
                                                        }
                                                        boolean r32 = cursor.getInt(i3) != 0 ? z : i;
                                                        boolean r33 = aVar4.d.getInt(9) != 0 ? z : i;
                                                        int i17 = 11;
                                                        if (aVar4.d.isNull(i17)) {
                                                            i4 = 12;
                                                            int i47 = 0;
                                                        } else {
                                                            i4 = 12;
                                                        }
                                                        if (cursor.isNull(i4)) {
                                                            i5 = 13;
                                                            int i48 = 0;
                                                        } else {
                                                            i5 = 13;
                                                        }
                                                        if (cursor.isNull(i5)) {
                                                            i6 = 14;
                                                            int i49 = 0;
                                                        } else {
                                                            i6 = 14;
                                                        }
                                                        if (cursor.isNull(i6)) {
                                                            i7 = 15;
                                                            int i50 = 0;
                                                        } else {
                                                            i7 = 15;
                                                        }
                                                        if (cursor.isNull(i7)) {
                                                            i8 = 16;
                                                            int i51 = 0;
                                                        } else {
                                                            i8 = 16;
                                                        }
                                                        if (cursor.isNull(i8)) {
                                                            int i20 = 0;
                                                        } else {
                                                            string2 = cursor.getString(i8);
                                                        }
                                                        int i18 = 17;
                                                        if (cursor.isNull(i18)) {
                                                            int i19 = 0;
                                                        } else {
                                                            string3 = cursor.getString(i18);
                                                        }
                                                        trickEntity = new TrickEntity(string13, string14, string12, string11, string10, string7, num2, num, z, z, aVar4.d.getLong(10), str4, string6, string5, string, string4, obj11, aVar4.h.toStringList(string2), aVar4.h.toStringList(string3));
                                                        i9 = 15;
                                                    } else {
                                                        i9 = 15;
                                                        i = 0;
                                                        int i38 = 0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((ArrayList)aVar5.get(cursor.getString(i9)) == null) {
                ArrayList arrayList3 = new ArrayList();
            }
            ArrayList arrayList2 = new ArrayList();
            if ((ArrayList)aVar8.get(cursor.getString(15)) == null) {
                ArrayList arrayList = new ArrayList();
            }
            ArrayList arrayList4 = new ArrayList();
            trickFullEntity = new TrickFullEntity(trickEntity, list, obj2, list3, obj4);
            obj14.add(trickFullEntity);
        } finally {
            obj13.close();
            throw th;
        }
        cursor.close();
    }

    private void P(d.e.a<String, ArrayList<e.a.a.a.b.d.g>> aVar) {
        d.e.a aVar2;
        int i = 0;
        int i2 = 15;
        int i3 = 8;
        int i4 = 12;
        int i5 = 13;
        int i6 = 14;
        int i7 = 15;
        int i8 = 16;
        String string2 = null;
        String string3 = null;
        int i9 = 15;
        Object obj;
        Object obj2;
        Object obj3;
        int i10;
        android.os.CancellationSignal cancellationSignal = null;
        Object obj4;
        Object obj8;
        boolean _null2;
        boolean _null3;
        boolean _null4;
        boolean _null5;
        e.a.a.a.b.d.g trickFullEntity;
        TrickEntity trickEntity;
        List list;
        List list2;
        List list3;
        List list4;
        String string13;
        String string14;
        String string12;
        String string11;
        String string10;
        String string7;
        Integer num2;
        Integer num;
        boolean z;
        long _long;
        String string6;
        String string5;
        String string;
        String string4;
        Object obj11;
        List stringList;
        List stringList2;
        final Object aVar4 = this;
        final Throwable obj12 = aVar;
        Set keys = aVar.keySet();
        if (keys.isEmpty()) {
            return;
        }
        int i12 = 999;
        i = 0;
        if (aVar.size() > i12) {
            aVar2 = new a(i12);
            while (i < aVar.size()) {
                aVar2.put((String)obj12.j(i), (ArrayList)obj12.n(i));
                i = i + 1;
                i = i + 1;
            }
            if (i > 0) {
                aVar4.P(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `TrickEntity`.`trickId` AS `trickId`,`TrickEntity`.`name` AS `name`,`TrickEntity`.`image` AS `image`,`TrickEntity`.`categoryName` AS `categoryName`,`TrickEntity`.`categoryId` AS `categoryId`,`TrickEntity`.`examInstructions` AS `examInstructions`,`TrickEntity`.`examTimeLimit` AS `examTimeLimit`,`TrickEntity`.`sortOrder` AS `sortOrder`,`TrickEntity`.`isExam` AS `isExam`,`TrickEntity`.`hasProgress` AS `hasProgress`,`TrickEntity`.`updatedAt` AS `updatedAt`,`TrickEntity`.`videoId` AS `videoId`,`TrickEntity`.`videoThumbnail` AS `videoThumbnail`,`TrickEntity`.`description` AS `description`,`TrickEntity`.`locale` AS `locale`,`TrickEntity`.`locale_trickId` AS `locale_trickId`,`TrickEntity`.`imageStepOrder` AS `imageStepOrder`,`TrickEntity`.`videoStepOder` AS `videoStepOder`,_junction.`locale_moduleId` FROM `ModuleWithExams` AS _junction INNER JOIN `TrickEntity` ON (_junction.`locale_trickId` = `TrickEntity`.`locale_trickId`) WHERE _junction.`locale_moduleId` IN (";
        int size3 = keys.size();
        f.a(sb, size3);
        String str3 = ")";
        str = str2 + str3;
        x0 x0Var = x0.e(str, size3 + i);
        Iterator it = keys.iterator();
        z = true;
        i10 = z;
        while (it.hasNext()) {
            Object item = it.next();
            i10 = i10 + 1;
        }
        cancellationSignal = null;
        Cursor cursor = c.c(aVar4.d, x0Var, z, cancellationSignal);
        try {
            d.e.a aVar5 = new a();
            d.e.a aVar7 = new a();
            d.e.a aVar8 = new a();
            d.e.a aVar9 = new a();
            i2 = 15;
            while (cursor.moveToNext()) {
                String string19 = cursor.getString(i2);
                if ((ArrayList)aVar5.get(string19) == null) {
                    aVar5.put(string19, new ArrayList());
                }
                String string20 = cursor.getString(i2);
                if ((ArrayList)aVar7.get(string20) == null) {
                    aVar7.put(string20, new ArrayList());
                }
                String string21 = cursor.getString(i2);
                if ((ArrayList)aVar8.get(string21) == null) {
                    aVar8.put(string21, new ArrayList());
                }
                String string9 = cursor.getString(i2);
                if ((ArrayList)aVar9.get(string9) == null) {
                    aVar9.put(string9, new ArrayList());
                }
            }
            int i11 = -1;
            cursor.moveToPosition(i11);
            aVar4.T(aVar5);
            aVar4.Q(aVar7);
            aVar4.R(aVar8);
            aVar4.S(aVar9);
            Object obj14 = obj12.get(cursor.getString(18));
            int i14 = 7;
            i2 = 6;
            int i23 = 5;
            int i35 = 4;
            int i36 = 3;
            int i37 = 2;
            if (cursor.isNull(i) && aVar4.d.isNull(z) && aVar4.d.isNull(i37) && aVar4.d.isNull(i36) && aVar4.d.isNull(i35) && aVar4.d.isNull(i23) && aVar4.d.isNull(i2) && aVar4.d.isNull(i14)) {
                if (cursor.isNull(8)) {
                    if (cursor.isNull(9)) {
                        if (cursor.isNull(10)) {
                            if (cursor.isNull(11)) {
                                if (cursor.isNull(12)) {
                                    if (cursor.isNull(13)) {
                                        if (cursor.isNull(14)) {
                                            if (cursor.isNull(15)) {
                                                if (cursor.isNull(16)) {
                                                    if (!cursor.isNull(17)) {
                                                        i = 0;
                                                        int i39 = cursor.isNull(i) ? 0 : string13;
                                                        int i40 = cursor.isNull(z) ? 0 : string14;
                                                        int i41 = cursor.isNull(i37) ? 0 : string12;
                                                        int i42 = cursor.isNull(i36) ? 0 : string11;
                                                        int i43 = cursor.isNull(i35) ? 0 : string10;
                                                        int i44 = cursor.isNull(i23) ? 0 : string7;
                                                        if (cursor.isNull(i2)) {
                                                            int i45 = 0;
                                                        } else {
                                                        }
                                                        if (cursor.isNull(i14)) {
                                                            i3 = 8;
                                                            int i46 = 0;
                                                        } else {
                                                            i3 = 8;
                                                        }
                                                        boolean r32 = cursor.getInt(i3) != 0 ? z : i;
                                                        boolean r33 = aVar4.d.getInt(9) != 0 ? z : i;
                                                        int i17 = 11;
                                                        if (aVar4.d.isNull(i17)) {
                                                            i4 = 12;
                                                            int i47 = 0;
                                                        } else {
                                                            i4 = 12;
                                                        }
                                                        if (cursor.isNull(i4)) {
                                                            i5 = 13;
                                                            int i48 = 0;
                                                        } else {
                                                            i5 = 13;
                                                        }
                                                        if (cursor.isNull(i5)) {
                                                            i6 = 14;
                                                            int i49 = 0;
                                                        } else {
                                                            i6 = 14;
                                                        }
                                                        if (cursor.isNull(i6)) {
                                                            i7 = 15;
                                                            int i50 = 0;
                                                        } else {
                                                            i7 = 15;
                                                        }
                                                        if (cursor.isNull(i7)) {
                                                            i8 = 16;
                                                            int i51 = 0;
                                                        } else {
                                                            i8 = 16;
                                                        }
                                                        if (cursor.isNull(i8)) {
                                                            int i20 = 0;
                                                        } else {
                                                            string2 = cursor.getString(i8);
                                                        }
                                                        int i18 = 17;
                                                        if (cursor.isNull(i18)) {
                                                            int i19 = 0;
                                                        } else {
                                                            string3 = cursor.getString(i18);
                                                        }
                                                        trickEntity = new TrickEntity(string13, string14, string12, string11, string10, string7, num2, num, z, z, aVar4.d.getLong(10), str4, string6, string5, string, string4, obj11, aVar4.h.toStringList(string2), aVar4.h.toStringList(string3));
                                                        i9 = 15;
                                                    } else {
                                                        i9 = 15;
                                                        i = 0;
                                                        int i38 = 0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((ArrayList)aVar5.get(cursor.getString(i9)) == null) {
                ArrayList arrayList3 = new ArrayList();
            }
            ArrayList arrayList2 = new ArrayList();
            if ((ArrayList)aVar8.get(cursor.getString(15)) == null) {
                ArrayList arrayList = new ArrayList();
            }
            ArrayList arrayList4 = new ArrayList();
            trickFullEntity = new TrickFullEntity(trickEntity, list, obj2, list3, obj4);
            obj14.add(trickFullEntity);
        } finally {
            obj13.close();
            throw th;
        }
        cursor.close();
    }

    private void Q(d.e.a<String, ArrayList<TrickStepEntity>> aVar) {
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
                Q(aVar2);
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
        Cursor cursor = c.c(this.d, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(6));
            try {
                x0Var = aVar.get(this.d.getString(6));
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

    private void R(d.e.a<String, ArrayList<TrickTagEntity>> aVar) {
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
                R(aVar2);
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
        Cursor cursor = c.c(this.d, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(5));
            try {
                x0Var = aVar.get(this.d.getString(5));
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

    private void S(d.e.a<String, ArrayList<TrickVariationEntity>> aVar) {
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
                aVar3.S(aVar2);
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
        Cursor cursor = c.c(aVar3.d, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = obj3.get(cursor.getString(8));
            try {
                x0Var = obj3.get(aVar3.d.getString(8));
                int i6 = 2;
                int i7 = 3;
                int i8 = 4;
                int i9 = 5;
                int i11 = 7;
                trickVariationEntity = new TrickVariationEntity(aVar3.h.toStringList(string), string2, string3, string4, string5, string6, cursor.getLong(6), str4, string7);
                x0Var.add(trickVariationEntity);
            } finally {
                obj4.close();
                throw th;
            }
        }
        cursor.close();
    }

    private void T(d.e.a<String, ArrayList<VideoStepEntity>> aVar) {
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
                T(aVar2);
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
        Cursor cursor = c.c(this.d, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(6));
            try {
                x0Var = aVar.get(this.d.getString(6));
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

    static /* synthetic */ e.a.a.a.b.a.a U(f0 f0Var) {
        return f0Var.h;
    }

    static /* synthetic */ u0 V(f0 f0Var) {
        return f0Var.d;
    }

    static /* synthetic */ h0 W(f0 f0Var) {
        return f0Var.n;
    }

    static /* synthetic */ g0 X(f0 f0Var) {
        return f0Var.o;
    }

    static /* synthetic */ g0 Y(f0 f0Var) {
        return f0Var.p;
    }

    static /* synthetic */ g0 Z(f0 f0Var) {
        return f0Var.q;
    }

    static /* synthetic */ g0 a0(f0 f0Var) {
        return f0Var.r;
    }

    static /* synthetic */ g0 b0(f0 f0Var) {
        return f0Var.s;
    }

    static /* synthetic */ g0 c0(f0 f0Var) {
        return f0Var.t;
    }

    static /* synthetic */ h0 d0(f0 f0Var) {
        return f0Var.e;
    }

    static /* synthetic */ void e0(f0 f0Var, d.e.a aVar) {
        f0Var.L(aVar);
    }

    static /* synthetic */ h0 f0(f0 f0Var) {
        return f0Var.f;
    }

    static /* synthetic */ h0 g0(f0 f0Var) {
        return f0Var.g;
    }

    static /* synthetic */ h0 h0(f0 f0Var) {
        return f0Var.i;
    }

    static /* synthetic */ h0 i0(f0 f0Var) {
        return f0Var.j;
    }

    static /* synthetic */ h0 j0(f0 f0Var) {
        return f0Var.k;
    }

    static /* synthetic */ h0 k0(f0 f0Var) {
        return f0Var.l;
    }

    static /* synthetic */ h0 l0(f0 f0Var) {
        return f0Var.m;
    }

    public static List<Class<?>> m0() {
        return Collections.emptyList();
    }

    @Override // e.a.a.a.b.b.e0
    public Object A(e.a.a.a.b.c.d[] dVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.o(this, dVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object B(ModuleEntity[] moduleEntityArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.l(this, moduleEntityArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object D(e.a.a.a.b.c.e[] eVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.q(this, eVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object E(e.a.a.a.b.c.f[] fVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.r(this, fVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object F(ProgramEntity[] programEntityArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.m(this, programEntityArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object H(h[] hVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.s(this, hVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object g(e.a.a.a.b.c.b[] bVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.u(this, bVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object h(e.a.a.a.b.c.c[] cVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.w(this, cVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object i(e.a.a.a.b.c.d[] dVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.v(this, dVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object j(e.a.a.a.b.c.e[] eVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.x(this, eVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object k(e.a.a.a.b.c.f[] fVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.y(this, fVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object l(h[] hVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.z(this, hVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object m(String str, kotlin.b0.d<? super List<e.a.a.a.b.d.e>> dVar) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ProgramEntity WHERE locale = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, true, c.a(), new app.dogo.android.persistencedb.room.dao.f0.c0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object n(kotlin.b0.d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.a0(this, x0.e("SELECT updatedAt FROM ProgramEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object o(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.b>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM LessonWithQuestion WHERE locale_lessonId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.f0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object p(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.c>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM LessonWithTask WHERE locale_lessonId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.g0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object q(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.d>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM LessonWithTrick WHERE locale_lessonId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.e0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object r(String str, String str2, kotlin.b0.d<? super List<e.a.a.a.b.d.e>> dVar) {
        int i = 2;
        x0 x0Var = x0.e("SELECT * FROM ProgramEntity WHERE locale = ? AND programId = ?", i);
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
        return CoroutinesRoom.a(this.d, true, c.a(), new app.dogo.android.persistencedb.room.dao.f0.d0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object t(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.e>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ModuleWithExams WHERE locale_moduleId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.h0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object u(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.f>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ModuleWithLessons WHERE locale_moduleId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.i0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object v(String str, kotlin.b0.d<? super List<h>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ProgramWithModules WHERE locale_programId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.d, false, c.a(), new app.dogo.android.persistencedb.room.dao.f0.j0(this, x0Var), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object w(LessonEntity[] lessonEntityArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.j(this, lessonEntityArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object y(e.a.a.a.b.c.b[] bVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.n(this, bVarArr), dVar);
    }

    @Override // e.a.a.a.b.b.e0
    public Object z(e.a.a.a.b.c.c[] cVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.d, true, new app.dogo.android.persistencedb.room.dao.f0.p(this, cVarArr), dVar);
    }
}
