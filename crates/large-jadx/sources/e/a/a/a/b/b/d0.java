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
import app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity;
import app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity;
import d.e.a;
import d.e.g;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import e.a.a.a.b.c.g;
import e.a.a.a.b.d.d;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* loaded from: classes.dex */
public final class d0 implements e.a.a.a.b.b.c0 {

    private final u0 a;
    private final h0<OnboardingQuestionEntity> b;
    private final a c;
    private final h0<OnboardingAnswerEntity> d;
    private final h0<g> e;
    private final g0<g> f;

    class a implements Callable<List<d>> {

        final x0 a;
        final e.a.a.a.b.b.d0 b;
        a(e.a.a.a.b.b.d0 d0, x0 x02) {
            this.b = d0;
            this.a = x02;
            super();
        }

        public List<d> a() {
            String string6;
            Object arrayList;
            int onboardingQuestionEntity;
            boolean null;
            boolean string3;
            boolean string;
            String string4;
            String string5;
            String string2;
            Object arrayList2;
            int dVar;
            int i;
            long long;
            String str;
            List list;
            String str2;
            final Object obj = this;
            d0.k(obj.b).c();
            final int i5 = 0;
            Cursor cursor = c.c(d0.k(obj.b), obj.a, true, i5);
            int i2 = b.e(cursor, "questionId");
            int i4 = b.e(cursor, "text");
            int i6 = b.e(cursor, "updatedAt");
            int i7 = b.e(cursor, "locale");
            int i8 = b.e(cursor, "childOrderList");
            int i9 = b.e(cursor, "locale_questionId");
            a aVar = new a();
            while (cursor.moveToNext()) {
                string6 = cursor.getString(i9);
                if ((ArrayList)aVar.get(string6) == null) {
                }
                arrayList = new ArrayList();
                aVar.put(string6, arrayList);
            }
            cursor.moveToPosition(-1);
            d0.p(obj.b, aVar);
            ArrayList arrayList3 = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i2) && cursor.isNull(i4) && cursor.isNull(i6) && cursor.isNull(i7) && cursor.isNull(i8)) {
                } else {
                }
                if (cursor.isNull(i2)) {
                } else {
                }
                dVar = string3;
                if (cursor.isNull(i4)) {
                } else {
                }
                i = string;
                if (cursor.isNull(i7)) {
                } else {
                }
                str = string4;
                if (cursor.isNull(i8)) {
                } else {
                }
                string5 = cursor.getString(i8);
                if (cursor.isNull(i9)) {
                } else {
                }
                str2 = string2;
                super(dVar, i, cursor.getLong(i6), obj16, str, d0.j(obj.b).j(string5), str2);
                if ((ArrayList)aVar.get(cursor.getString(i9)) == null) {
                }
                dVar = new d(onboardingQuestionEntity, arrayList2);
                arrayList3.add(dVar);
                arrayList2 = new ArrayList();
                str2 = i5;
                string5 = i5;
                str = i5;
                i = i5;
                dVar = i5;
                if (cursor.isNull(i4)) {
                } else {
                }
                if (cursor.isNull(i6)) {
                } else {
                }
                if (cursor.isNull(i7)) {
                } else {
                }
                if (cursor.isNull(i8)) {
                } else {
                }
                if (!cursor.isNull(i9)) {
                } else {
                }
                onboardingQuestionEntity = i5;
            }
            d0.k(obj.b).C();
            cursor.close();
            d0.k(obj.b).g();
            return arrayList3;
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

    class b implements Callable<List<g>> {

        final x0 a;
        final e.a.a.a.b.b.d0 b;
        b(e.a.a.a.b.b.d0 d0, x0 x02) {
            this.b = d0;
            this.a = x02;
            super();
        }

        public List<g> a() {
            int string;
            String string2;
            g gVar;
            final int i4 = 0;
            Cursor cursor = c.c(d0.k(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_questionId");
            int i3 = b.e(cursor, "locale_answerId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i)) {
                } else {
                }
                string = cursor.getString(i);
                if (cursor.isNull(i3)) {
                } else {
                }
                string2 = cursor.getString(i3);
                gVar = new g(string, string2);
                arrayList.add(gVar);
                string2 = i4;
                string = i4;
            }
            cursor.close();
            this.a.j();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.d0 b;
        c(e.a.a.a.b.b.d0 d0, x0 x02) {
            this.b = d0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(d0.k(this.b), this.a, i, 0);
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

    class h implements Callable<w> {

        final OnboardingQuestionEntity[] a;
        final e.a.a.a.b.b.d0 b;
        h(e.a.a.a.b.b.d0 d0, OnboardingQuestionEntity[] onboardingQuestionEntity2Arr2) {
            this.b = d0;
            this.a = onboardingQuestionEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            d0.k(this.b).c();
            d0.l(this.b).i(this.a);
            d0.k(this.b).C();
            d0.k(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class i implements Callable<w> {

        final OnboardingAnswerEntity[] a;
        final e.a.a.a.b.b.d0 b;
        i(e.a.a.a.b.b.d0 d0, OnboardingAnswerEntity[] onboardingAnswerEntity2Arr2) {
            this.b = d0;
            this.a = onboardingAnswerEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            d0.k(this.b).c();
            d0.m(this.b).i(this.a);
            d0.k(this.b).C();
            d0.k(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class j implements Callable<w> {

        final g[] a;
        final e.a.a.a.b.b.d0 b;
        j(e.a.a.a.b.b.d0 d0, g[] g2Arr2) {
            this.b = d0;
            this.a = g2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            d0.k(this.b).c();
            d0.n(this.b).i(this.a);
            d0.k(this.b).C();
            d0.k(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class k implements Callable<w> {

        final g[] a;
        final e.a.a.a.b.b.d0 b;
        k(e.a.a.a.b.b.d0 d0, g[] g2Arr2) {
            this.b = d0;
            this.a = g2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            d0.k(this.b).c();
            d0.o(this.b).i(this.a);
            d0.k(this.b).C();
            d0.k(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d extends h0<OnboardingQuestionEntity> {

        final e.a.a.a.b.b.d0 d;
        d(e.a.a.a.b.b.d0 d0, u0 u02) {
            this.d = d0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `OnboardingQuestionEntity` (`questionId`,`text`,`updatedAt`,`locale`,`childOrderList`,`locale_questionId`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (OnboardingQuestionEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, OnboardingQuestionEntity onboardingQuestionEntity2) {
            String questionId;
            String text;
            String locale;
            String obj5;
            int i2 = 1;
            if (onboardingQuestionEntity2.getQuestionId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, onboardingQuestionEntity2.getQuestionId());
            }
            int i3 = 2;
            if (onboardingQuestionEntity2.getText() == null) {
                k.k1(i3);
            } else {
                k.D(i3, onboardingQuestionEntity2.getText());
            }
            k.u0(3, onboardingQuestionEntity2.getUpdatedAt());
            int i4 = 4;
            if (onboardingQuestionEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, onboardingQuestionEntity2.getLocale());
            }
            String str = d0.j(this.d).d(onboardingQuestionEntity2.getChildOrderList());
            int i5 = 5;
            if (str == null) {
                k.k1(i5);
            } else {
                k.D(i5, str);
            }
            int i6 = 6;
            if (onboardingQuestionEntity2.getLocale_questionId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, onboardingQuestionEntity2.getLocale_questionId());
            }
        }
    }

    class e extends h0<OnboardingAnswerEntity> {
        e(e.a.a.a.b.b.d0 d0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `OnboardingAnswerEntity` (`answerId`,`text`,`updatedAt`,`locale`,`locale_answerId`) VALUES (?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (OnboardingAnswerEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, OnboardingAnswerEntity onboardingAnswerEntity2) {
            String answerId;
            String text;
            String locale;
            String obj5;
            int i2 = 1;
            if (onboardingAnswerEntity2.getAnswerId() == null) {
                k.k1(i2);
            } else {
                k.D(i2, onboardingAnswerEntity2.getAnswerId());
            }
            int i3 = 2;
            if (onboardingAnswerEntity2.getText() == null) {
                k.k1(i3);
            } else {
                k.D(i3, onboardingAnswerEntity2.getText());
            }
            k.u0(3, onboardingAnswerEntity2.getUpdatedAt());
            int i4 = 4;
            if (onboardingAnswerEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, onboardingAnswerEntity2.getLocale());
            }
            int i5 = 5;
            if (onboardingAnswerEntity2.getLocale_answerId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, onboardingAnswerEntity2.getLocale_answerId());
            }
        }
    }

    class f extends h0<g> {
        f(e.a.a.a.b.b.d0 d0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `OnboardingQuestionWithAnswer` (`locale_questionId`,`locale_answerId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (g)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, g g2) {
            String str;
            String obj4;
            int i = 1;
            if (g2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, g2.b());
            }
            int i2 = 2;
            if (g2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, g2.a());
            }
        }
    }

    class g extends g0<g> {
        g(e.a.a.a.b.b.d0 d0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `OnboardingQuestionWithAnswer` WHERE `locale_questionId` = ? AND `locale_answerId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (g)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, g g2) {
            String str;
            String obj4;
            int i = 1;
            if (g2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, g2.b());
            }
            int i2 = 2;
            if (g2.a() == null) {
                k.k1(i2);
            } else {
                k.D(i2, g2.a());
            }
        }
    }
    public d0(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        d0.d dVar = new d0.d(this, u0);
        this.b = dVar;
        d0.e eVar = new d0.e(this, u0);
        this.d = eVar;
        d0.f fVar = new d0.f(this, u0);
        this.e = fVar;
        d0.g gVar = new d0.g(this, u0);
        this.f = gVar;
    }

    private void i(a<String, ArrayList<OnboardingAnswerEntity>> a) {
        a aVar;
        x0 x0Var;
        int i2;
        int i;
        int i3;
        Object next;
        boolean onboardingAnswerEntity;
        String string3;
        String string;
        String string2;
        String string4;
        Object obj2;
        Object obj;
        String str;
        long long;
        String str2;
        String str3;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i3 = i2;
            while (i2 < a.size()) {
                aVar.put((String)a.j(i2), (ArrayList)a.n(i2));
                i2++;
                if (i3++ == i5) {
                }
                i(aVar);
                aVar = new a(i5);
                i3 = i8;
            }
            if (i3 > 0) {
                i(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `OnboardingAnswerEntity`.`answerId` AS `answerId`,`OnboardingAnswerEntity`.`text` AS `text`,`OnboardingAnswerEntity`.`updatedAt` AS `updatedAt`,`OnboardingAnswerEntity`.`locale` AS `locale`,`OnboardingAnswerEntity`.`locale_answerId` AS `locale_answerId`,_junction.`locale_questionId` FROM `OnboardingQuestionWithAnswer` AS _junction INNER JOIN `OnboardingAnswerEntity` ON (_junction.`locale_answerId` = `OnboardingAnswerEntity`.`locale_answerId`) WHERE _junction.`locale_questionId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i, (String)next);
            i++;
            x0Var.k1(i);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.a, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(5));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.isNull(i8)) {
            } else {
            }
            obj = string3;
            if (cursor.isNull(i7)) {
            } else {
            }
            str = string;
            string2 = 3;
            if (cursor.isNull(string2)) {
            } else {
            }
            str2 = string2;
            string4 = 4;
            if (cursor.isNull(string4)) {
            } else {
            }
            str3 = string4;
            super(obj, str, cursor.getLong(2), obj10, str2, str3);
            (ArrayList)x0Var.add(onboardingAnswerEntity);
            str3 = i9;
            str2 = i9;
            str = i9;
            obj = i9;
        }
        cursor.close();
    }

    static a j(e.a.a.a.b.b.d0 d0) {
        return d0.c;
    }

    static u0 k(e.a.a.a.b.b.d0 d0) {
        return d0.a;
    }

    static h0 l(e.a.a.a.b.b.d0 d0) {
        return d0.b;
    }

    static h0 m(e.a.a.a.b.b.d0 d0) {
        return d0.d;
    }

    static h0 n(e.a.a.a.b.b.d0 d0) {
        return d0.e;
    }

    static g0 o(e.a.a.a.b.b.d0 d0) {
        return d0.f;
    }

    static void p(e.a.a.a.b.b.d0 d0, a a2) {
        d0.i(a2);
    }

    public static List<Class<?>> q() {
        return Collections.emptyList();
    }

    public Object a(d<? super Long> d) {
        final int i = 0;
        d0.c cVar = new d0.c(this, x0.e("SELECT updatedAt FROM OnboardingQuestionEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), cVar, d);
    }

    public Object b(d d, d<? super w> d2) {
        return c0.a.b(this, d, d2);
    }

    public Object c(g[] gArr, d<? super w> d2) {
        d0.k kVar = new d0.k(this, gArr);
        return c0.b(this.a, true, kVar, d2);
    }

    public Object d(OnboardingQuestionEntity[] onboardingQuestionEntityArr, d<? super w> d2) {
        d0.h hVar = new d0.h(this, onboardingQuestionEntityArr);
        return c0.b(this.a, true, hVar, d2);
    }

    public a0<List<d>> e(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM OnboardingQuestionEntity WHERE locale = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        d0.a obj3 = new d0.a(this, x0Var);
        return y0.a(obj3);
    }

    public Object f(OnboardingAnswerEntity[] onboardingAnswerEntityArr, d<? super w> d2) {
        d0.i iVar = new d0.i(this, onboardingAnswerEntityArr);
        return c0.b(this.a, true, iVar, d2);
    }

    public Object g(String string, d<? super List<g>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM OnboardingQuestionWithAnswer WHERE locale_questionId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        d0.b bVar = new d0.b(this, x0Var);
        return c0.a(this.a, false, c.a(), bVar, d2);
    }

    public Object h(g[] gArr, d<? super w> d2) {
        d0.j jVar = new d0.j(this, gArr);
        return c0.b(this.a, true, jVar, d2);
    }
}
