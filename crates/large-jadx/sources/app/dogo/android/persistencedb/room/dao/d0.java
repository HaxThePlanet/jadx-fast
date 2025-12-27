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
import d.s.a.i;
import d.s.a.k;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.w;

/* compiled from: OnboardingSurveyEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class d0 implements c0 {

    private final u0 a;
    private final h0<OnboardingQuestionEntity> b = new d0$d<>();
    private final e.a.a.a.b.a.a c = new a();
    private final h0<OnboardingAnswerEntity> d = new d0$e<>();
    private final h0<e.a.a.a.b.c.g> e = new d0$f<>();
    private final g0<e.a.a.a.b.c.g> f = new d0$g<>();

    class a implements Callable<List<e.a.a.a.b.d.d>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ d0 b;
        a(x0 x0Var) {
            this.b = d0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.d.d> a() {
            Object obj5;
            String string5;
            List list;
            e.a.a.a.b.d.d onboardingQuestionFullEntity;
            String string2;
            String string3;
            long _long;
            Object obj2;
            List list2;
            String string6;
            final Object obj4 = this;
            obj4.b.a.c();
            try {
                final android.os.CancellationSignal cancellationSignal = null;
                Cursor cursor = c.c(obj4.b.a, obj4.a, true, cancellationSignal);
            } catch (Throwable th) {
            }
            try {
                int i = b.e(cursor, "questionId");
                int i3 = b.e(cursor, "text");
                int i4 = b.e(cursor, "updatedAt");
                int i5 = b.e(cursor, "locale");
                int i6 = b.e(cursor, "childOrderList");
                int i7 = b.e(cursor, "locale_questionId");
                final d.e.a aVar = new a();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(i7);
                    if ((ArrayList)aVar.get(string) == null) {
                        aVar.put(string, new ArrayList());
                    }
                }
                cursor.moveToPosition(-1);
                obj4.b.i(aVar);
                ArrayList arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    if (!cursor.isNull(i) || !(!obj4.a.isNull(i3) && !obj4.a.isNull(i4) && !obj4.a.isNull(i5) && !obj4.a.isNull(i6) && obj4.a.isNull(i7))) {
                        cancellationSignal = cursor.isNull(i) ? cancellationSignal : string2;
                        cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string3;
                        cancellationSignal = cursor.isNull(i5) ? cancellationSignal : string4;
                        if (cursor.isNull(i6)) {
                        } else {
                            string5 = cursor.getString(i6);
                        }
                        cancellationSignal = cursor.isNull(i7) ? cancellationSignal : string6;
                        OnboardingQuestionEntity onboardingQuestionEntity = new OnboardingQuestionEntity(string2, string3, cursor.getLong(i4), str7, obj2, obj4.b.c.j(string5), string6);
                    }
                    if ((ArrayList)aVar.get(cursor.getString(i7)) == null) {
                        ArrayList arrayList3 = new ArrayList();
                    }
                    arrayList.add(new OnboardingQuestionFullEntity(obj5, list));
                }
                obj4.b.a.C();
            } catch (Throwable th) {
            }
            try {
                cursor.close();
            } catch (Throwable th) {
            }
            obj4.b.a.g();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class b implements Callable<List<e.a.a.a.b.c.g>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ d0 b;
        b(x0 x0Var) {
            this.b = d0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.g> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_questionId");
                int i3 = b.e(cursor, "locale_answerId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new OnboardingQuestionWithAnswer(string, obj));
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

    class c implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ d0 b;
        c(x0 x0Var) {
            this.b = d0Var;
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

    class h implements Callable<w> {

        final /* synthetic */ OnboardingQuestionEntity[] a;
        final /* synthetic */ d0 b;
        h(OnboardingQuestionEntity[] onboardingQuestionEntityArr) {
            this.b = d0Var;
            this.a = onboardingQuestionEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.d0 d0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class i implements Callable<w> {

        final /* synthetic */ OnboardingAnswerEntity[] a;
        final /* synthetic */ d0 b;
        i(OnboardingAnswerEntity[] onboardingAnswerEntityArr) {
            this.b = d0Var;
            this.a = onboardingAnswerEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.d.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.d0 d0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class j implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.g[] a;
        final /* synthetic */ d0 b;
        j(e.a.a.a.b.c.g[] gVarArr) {
            this.b = d0Var;
            this.a = gVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.e.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.d0 d0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class k implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.g[] a;
        final /* synthetic */ d0 b;
        k(e.a.a.a.b.c.g[] gVarArr) {
            this.b = d0Var;
            this.a = gVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.f.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.d0 d0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class d extends h0<OnboardingQuestionEntity> {

        final /* synthetic */ d0 d;
        d(u0 u0Var) {
            this.d = d0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, OnboardingQuestionEntity onboardingQuestionEntity) {
            int i2 = 1;
            if (onboardingQuestionEntity.getQuestionId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, onboardingQuestionEntity.getQuestionId());
            }
            int i3 = 2;
            if (onboardingQuestionEntity.getText() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, onboardingQuestionEntity.getText());
            }
            kVar.u0(3, onboardingQuestionEntity.getUpdatedAt());
            int i4 = 4;
            if (onboardingQuestionEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, onboardingQuestionEntity.getLocale());
            }
            String str = this.d.c.d(onboardingQuestionEntity.getChildOrderList());
            int i5 = 5;
            if (str == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, str);
            }
            int i6 = 6;
            if (onboardingQuestionEntity.getLocale_questionId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, onboardingQuestionEntity.getLocale_questionId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `OnboardingQuestionEntity` (`questionId`,`text`,`updatedAt`,`locale`,`childOrderList`,`locale_questionId`) VALUES (?,?,?,?,?,?)";
        }
    }

    class e extends h0<OnboardingAnswerEntity> {
        e(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, OnboardingAnswerEntity onboardingAnswerEntity) {
            int i2 = 1;
            if (onboardingAnswerEntity.getAnswerId() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, onboardingAnswerEntity.getAnswerId());
            }
            int i3 = 2;
            if (onboardingAnswerEntity.getText() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, onboardingAnswerEntity.getText());
            }
            kVar.u0(3, onboardingAnswerEntity.getUpdatedAt());
            int i4 = 4;
            if (onboardingAnswerEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, onboardingAnswerEntity.getLocale());
            }
            int i5 = 5;
            if (onboardingAnswerEntity.getLocale_answerId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, onboardingAnswerEntity.getLocale_answerId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `OnboardingAnswerEntity` (`answerId`,`text`,`updatedAt`,`locale`,`locale_answerId`) VALUES (?,?,?,?,?)";
        }
    }

    class f extends h0<e.a.a.a.b.c.g> {
        f(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.g gVar) {
            int i = 1;
            if (gVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, gVar.b());
            }
            int i2 = 2;
            if (gVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, gVar.component1());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `OnboardingQuestionWithAnswer` (`locale_questionId`,`locale_answerId`) VALUES (?,?)";
        }
    }

    class g extends g0<e.a.a.a.b.c.g> {
        g(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.g gVar) {
            int i = 1;
            if (gVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, gVar.b());
            }
            int i2 = 2;
            if (gVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, gVar.component1());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `OnboardingQuestionWithAnswer` WHERE `locale_questionId` = ? AND `locale_answerId` = ?";
        }
    }
    public d0(u0 u0Var) {
        super();
        e.a.a.a.b.a.a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.d0.d dVar = new app.dogo.android.persistencedb.room.dao.d0.d(this, u0Var);
        e.a.a.a.b.b.d0.e eVar = new app.dogo.android.persistencedb.room.dao.d0.e(this, u0Var);
        e.a.a.a.b.b.d0.f fVar = new app.dogo.android.persistencedb.room.dao.d0.f(this, u0Var);
        e.a.a.a.b.b.d0.g gVar = new app.dogo.android.persistencedb.room.dao.d0.g(this, u0Var);
    }

    private void i(d.e.a<String, ArrayList<OnboardingAnswerEntity>> aVar) {
        d.e.a aVar2;
        int i2;
        int i;
        boolean hasNext;
        OnboardingAnswerEntity onboardingAnswerEntity;
        String string;
        String string2;
        long _long;
        String string3;
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
                i(aVar2);
            }
            return;
        }
        StringBuilder sb = f.b();
        String str2 = "SELECT `OnboardingAnswerEntity`.`answerId` AS `answerId`,`OnboardingAnswerEntity`.`text` AS `text`,`OnboardingAnswerEntity`.`updatedAt` AS `updatedAt`,`OnboardingAnswerEntity`.`locale` AS `locale`,`OnboardingAnswerEntity`.`locale_answerId` AS `locale_answerId`,_junction.`locale_questionId` FROM `OnboardingQuestionWithAnswer` AS _junction INNER JOIN `OnboardingAnswerEntity` ON (_junction.`locale_answerId` = `OnboardingAnswerEntity`.`locale_answerId`) WHERE _junction.`locale_questionId` IN (";
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
                int i7 = 3;
                int i8 = 4;
                onboardingAnswerEntity = new OnboardingAnswerEntity(string, string2, cursor.getLong(2), str4, string3, string4);
                x0Var.add(onboardingAnswerEntity);
            } finally {
                obj3.close();
                throw aVar;
            }
        }
        cursor.close();
    }

    static /* synthetic */ e.a.a.a.b.a.a j(d0 d0Var) {
        return d0Var.c;
    }

    static /* synthetic */ u0 k(d0 d0Var) {
        return d0Var.a;
    }

    static /* synthetic */ h0 l(d0 d0Var) {
        return d0Var.b;
    }

    static /* synthetic */ h0 m(d0 d0Var) {
        return d0Var.d;
    }

    static /* synthetic */ h0 n(d0 d0Var) {
        return d0Var.e;
    }

    static /* synthetic */ g0 o(d0 d0Var) {
        return d0Var.f;
    }

    static /* synthetic */ void p(d0 d0Var, d.e.a aVar) {
        d0Var.i(aVar);
    }

    public static List<Class<?>> q() {
        return Collections.emptyList();
    }

    public Object a(kotlin.b0.d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.d0.c(this, x0.e("SELECT updatedAt FROM OnboardingQuestionEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public Object b(e.a.a.a.b.d.d dVar, kotlin.b0.d<? super w> dVar2) {
        return app.dogo.android.persistencedb.room.dao.c0.a.b(this, dVar, dVar2);
    }

    public Object c(e.a.a.a.b.c.g[] gVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.d0.k(this, gVarArr), dVar);
    }

    public Object d(OnboardingQuestionEntity[] onboardingQuestionEntityArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.d0.h(this, onboardingQuestionEntityArr), dVar);
    }

    public a0<List<e.a.a.a.b.d.d>> e(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM OnboardingQuestionEntity WHERE locale = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.d0.a(this, x0Var));
    }

    public Object f(OnboardingAnswerEntity[] onboardingAnswerEntityArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.d0.i(this, onboardingAnswerEntityArr), dVar);
    }

    public Object g(String str, kotlin.b0.d<? super List<e.a.a.a.b.c.g>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM OnboardingQuestionWithAnswer WHERE locale_questionId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.d0.b(this, x0Var), dVar);
    }

    public Object h(e.a.a.a.b.c.g[] gVarArr, kotlin.b0.d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.d0.j(this, gVarArr), dVar);
    }
}
