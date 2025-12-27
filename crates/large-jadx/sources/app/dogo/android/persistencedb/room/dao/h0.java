package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.c0;
import androidx.room.f1.b;
import androidx.room.f1.c;
import androidx.room.g0;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import d.e.g;
import d.s.a.k;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.b0.d;
import kotlin.w;

/* compiled from: QuestionEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class h0 implements g0 {

    private final u0 a;
    private final h0<QuestionEntity> b = new h0$h<>();
    private final e.a.a.a.b.a.a c = new a();
    private final h0<ArticleEntity> d = new h0$n<>();
    private final h0<ArticleTagEntity> e = new h0$q<>();
    private final h0<e.a.a.a.b.c.i> f = new h0$r<>();
    private final h0<e.a.a.a.b.c.a> g = new h0$s<>();
    private final g0<e.a.a.a.b.c.i> h = new h0$w<>();
    private final g0<e.a.a.a.b.c.a> i = new h0$a<>();

    class b implements Callable<w> {

        final /* synthetic */ QuestionEntity[] a;
        final /* synthetic */ h0 b;
        b(QuestionEntity[] questionEntityArr) {
            this.b = h0Var;
            this.a = questionEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var5 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class c implements Callable<w> {

        final /* synthetic */ ArticleEntity[] a;
        final /* synthetic */ h0 b;
        c(ArticleEntity[] articleEntityArr) {
            this.b = h0Var;
            this.a = articleEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.d.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var5 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class d implements Callable<w> {

        final /* synthetic */ ArticleTagEntity[] a;
        final /* synthetic */ h0 b;
        d(ArticleTagEntity[] articleTagEntityArr) {
            this.b = h0Var;
            this.a = articleTagEntityArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.e.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var5 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class e implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.i[] a;
        final /* synthetic */ h0 b;
        e(e.a.a.a.b.c.i[] iVarArr) {
            this.b = h0Var;
            this.a = iVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.f.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var5 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class f implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.a[] a;
        final /* synthetic */ h0 b;
        f(e.a.a.a.b.c.a[] aVarArr) {
            this.b = h0Var;
            this.a = aVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.g.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var5 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class g implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.i[] a;
        final /* synthetic */ h0 b;
        g(e.a.a.a.b.c.i[] iVarArr) {
            this.b = h0Var;
            this.a = iVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.h.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class i implements Callable<w> {

        final /* synthetic */ e.a.a.a.b.c.a[] a;
        final /* synthetic */ h0 b;
        i(e.a.a.a.b.c.a[] aVarArr) {
            this.b = h0Var;
            this.a = aVarArr;
            super();
        }

        public w a() {
            this.b.a.c();
            try {
                this.b.i.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.h0 h0Var4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return w.a;
        }
    }

    class j implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ h0 b;
        j(x0 x0Var) {
            this.b = h0Var;
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

    class k implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ h0 b;
        k(x0 x0Var) {
            this.b = h0Var;
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

    class l implements Callable<Long> {

        final /* synthetic */ x0 a;
        final /* synthetic */ h0 b;
        l(x0 x0Var) {
            this.b = h0Var;
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

    class m implements Callable<List<e.a.a.a.b.d.a>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ h0 b;
        m(x0 x0Var) {
            this.b = h0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.d.a> a() {
            int i;
            List list;
            int i2;
            android.os.CancellationSignal cancellationSignal = null;
            ArticleEntity articleEntity = null;
            String string2;
            String string3;
            String string4;
            int _int;
            Integer num;
            String string5;
            String string6;
            String string7;
            long _long;
            String string9;
            int i3;
            final Object obj4 = this;
            obj4.b.a.c();
            try {
                cancellationSignal = null;
                Cursor cursor = c.c(obj4.b.a, obj4.a, true, cancellationSignal);
            } catch (Throwable th) {
            }
            try {
                i = b.e(cursor, "articleId");
                i2 = b.e(cursor, "title");
                int i6 = b.e(cursor, "text");
                int i7 = b.e(cursor, "readingTime");
                int i8 = b.e(cursor, "sortOrder");
                int i9 = b.e(cursor, "categoryId");
                int i10 = b.e(cursor, "image");
                int i11 = b.e(cursor, "locale");
                int i12 = b.e(cursor, "updatedAt");
                int i13 = b.e(cursor, "locale_articleId");
                int i14 = b.e(cursor, "textHtml");
                final d.e.a aVar = new a();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(i13);
                    if ((ArrayList)aVar.get(string) == null) {
                        aVar.put(string, new ArrayList());
                    }
                }
                cursor.moveToPosition(-1);
                obj4.b.p(aVar);
                ArrayList arrayList3 = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    if (!cursor.isNull(i) || !(!obj4.a.isNull(i2) && !obj4.a.isNull(i6) && !obj4.a.isNull(i7) && !obj4.a.isNull(i8) && !obj4.a.isNull(i9) && !obj4.a.isNull(i10) && !obj4.a.isNull(i11) && !obj4.a.isNull(i12) && !obj4.a.isNull(i13) && obj4.a.isNull(i14))) {
                        int i16 = cursor.isNull(i) ? 0 : string2;
                        int i17 = cursor.isNull(i2) ? 0 : string3;
                        int i18 = cursor.isNull(i6) ? 0 : string4;
                        if (cursor.isNull(i8)) {
                            int i19 = 0;
                        } else {
                        }
                        int i20 = cursor.isNull(i9) ? 0 : string5;
                        int i21 = cursor.isNull(i10) ? 0 : string6;
                        int i22 = cursor.isNull(i11) ? 0 : string7;
                        int i23 = cursor.isNull(i13) ? 0 : string9;
                        i3 = cursor.isNull(i14) ? 0 : string8;
                        articleEntity = new ArticleEntity(string2, string3, string4, cursor.getInt(i7), num, string5, string6, string7, cursor.getLong(i12), str12, string9, i3);
                    }
                    if ((ArrayList)aVar.get(cursor.getString(i13)) == null) {
                        ArrayList arrayList = new ArrayList();
                    }
                    arrayList3.add(new ArticleFullEntity(articleEntity, list));
                }
                obj4.b.a.C();
            } catch (Throwable th) {
            }
            try {
                cursor.close();
            } catch (Throwable th) {
            }
            obj4.b.a.g();
            return arrayList3;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class o implements Callable<List<e.a.a.a.b.c.a>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ h0 b;
        o(x0 x0Var) {
            this.b = h0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.a> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_articleId");
                int i3 = b.e(cursor, "locale_tagId");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                if (cursor.isNull(i)) {
                } else {
                    string = cursor.getString(i);
                }
                if (cursor.isNull(i3)) {
                } else {
                    String string2 = cursor.getString(i3);
                }
                arrayList.add(new ArticleWithTags(string, obj));
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

    class p implements Callable<List<e.a.a.a.b.c.i>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ h0 b;
        p(x0 x0Var) {
            this.b = h0Var;
            this.a = x0Var;
            super();
        }

        public List<e.a.a.a.b.c.i> a() {
            String string;
            Object obj;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(this.b.a, this.a, false, cancellationSignal);
            try {
                int i = b.e(cursor, "locale_articleId");
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
                arrayList.add(new QuestionWithArticle(string, obj));
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

    class a extends g0<e.a.a.a.b.c.a> {
        a(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.a aVar) {
            int i = 1;
            if (aVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, aVar.component1());
            }
            int i2 = 2;
            if (aVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, aVar.b());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ArticleWithTags` WHERE `locale_articleId` = ? AND `locale_tagId` = ?";
        }
    }

    class h extends h0<QuestionEntity> {

        final /* synthetic */ h0 d;
        h(u0 u0Var) {
            this.d = h0Var;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, QuestionEntity questionEntity) {
            int i3 = 1;
            if (questionEntity.getQuestionId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, questionEntity.getQuestionId());
            }
            int i4 = 2;
            if (questionEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, questionEntity.getLocale());
            }
            int i5 = 3;
            if (questionEntity.getQuestion() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, questionEntity.getQuestion());
            }
            String stringList = this.d.c.fromStringList(questionEntity.getAnswers());
            int i6 = 4;
            if (stringList == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, stringList);
            }
            kVar.u0(5, (long)questionEntity.getCorrectAnswer());
            kVar.u0(6, questionEntity.getUpdatedAt());
            int i7 = 7;
            if (questionEntity.getLocale_questionId() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, questionEntity.getLocale_questionId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `QuestionEntity` (`questionId`,`locale`,`question`,`answers`,`correctAnswer`,`updatedAt`,`locale_questionId`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    class n extends h0<ArticleEntity> {
        n(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, ArticleEntity articleEntity) {
            long l;
            int i3 = 1;
            if (articleEntity.getArticleId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, articleEntity.getArticleId());
            }
            int i4 = 2;
            if (articleEntity.getTitle() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, articleEntity.getTitle());
            }
            int i5 = 3;
            if (articleEntity.getText() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, articleEntity.getText());
            }
            kVar.u0(4, (long)articleEntity.getReadingTime());
            int i6 = 5;
            if (articleEntity.getSortOrder() == null) {
                kVar.k1(i6);
            } else {
                l = (long)articleEntity.getSortOrder().intValue();
                kVar.u0(i6, l);
            }
            int i7 = 6;
            if (articleEntity.getCategoryId() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, articleEntity.getCategoryId());
            }
            int i8 = 7;
            if (articleEntity.getImage() == null) {
                kVar.k1(i8);
            } else {
                kVar.D(i8, articleEntity.getImage());
            }
            int i9 = 8;
            if (articleEntity.getLocale() == null) {
                kVar.k1(i9);
            } else {
                kVar.D(i9, articleEntity.getLocale());
            }
            kVar.u0(9, articleEntity.getUpdatedAt());
            int i10 = 10;
            if (articleEntity.getLocale_articleId() == null) {
                kVar.k1(i10);
            } else {
                kVar.D(i10, articleEntity.getLocale_articleId());
            }
            int i11 = 11;
            if (articleEntity.getTextHtml() == null) {
                kVar.k1(i11);
            } else {
                kVar.D(i11, articleEntity.getTextHtml());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ArticleEntity` (`articleId`,`title`,`text`,`readingTime`,`sortOrder`,`categoryId`,`image`,`locale`,`updatedAt`,`locale_articleId`,`textHtml`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class q extends h0<ArticleTagEntity> {
        q(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, ArticleTagEntity articleTagEntity) {
            kVar.u0(1, l);
            int i3 = 2;
            if (articleTagEntity.getTagId() == null) {
                kVar.k1(i3);
            } else {
                kVar.D(i3, articleTagEntity.getTagId());
            }
            int i4 = 3;
            if (articleTagEntity.getLocale() == null) {
                kVar.k1(i4);
            } else {
                kVar.D(i4, articleTagEntity.getLocale());
            }
            int i5 = 4;
            if (articleTagEntity.getName() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, articleTagEntity.getName());
            }
            kVar.u0(5, articleTagEntity.getUpdatedAt());
            int i6 = 6;
            if (articleTagEntity.getLocale_tagId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, articleTagEntity.getLocale_tagId());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ArticleTagEntity` (`hidden`,`tagId`,`locale`,`name`,`updatedAt`,`locale_tagId`) VALUES (?,?,?,?,?,?)";
        }
    }

    class r extends h0<e.a.a.a.b.c.i> {
        r(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.i iVar) {
            int i = 1;
            if (iVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, iVar.component1());
            }
            int i2 = 2;
            if (iVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, iVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `QuestionWithArticle` (`locale_articleId`,`locale_questionId`) VALUES (?,?)";
        }
    }

    class s extends h0<e.a.a.a.b.c.a> {
        s(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, e.a.a.a.b.c.a aVar) {
            int i = 1;
            if (aVar.component1() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, aVar.component1());
            }
            int i2 = 2;
            if (aVar.b() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, aVar.b());
            }
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ArticleWithTags` (`locale_articleId`,`locale_tagId`) VALUES (?,?)";
        }
    }

    class t extends g0<QuestionEntity> {
        t(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, QuestionEntity questionEntity) {
            final int i = 1;
            if (questionEntity.getLocale_questionId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, questionEntity.getLocale_questionId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `QuestionEntity` WHERE `locale_questionId` = ?";
        }
    }

    class u extends g0<ArticleEntity> {
        u(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, ArticleEntity articleEntity) {
            final int i = 1;
            if (articleEntity.getLocale_articleId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, articleEntity.getLocale_articleId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ArticleEntity` WHERE `locale_articleId` = ?";
        }
    }

    class v extends g0<ArticleTagEntity> {
        v(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, ArticleTagEntity articleTagEntity) {
            final int i = 1;
            if (articleTagEntity.getLocale_tagId() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, articleTagEntity.getLocale_tagId());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ArticleTagEntity` WHERE `locale_tagId` = ?";
        }
    }

    class w extends g0<e.a.a.a.b.c.i> {
        w(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.g0
        public void j(k kVar, e.a.a.a.b.c.i iVar) {
            int i = 1;
            if (iVar.b() == null) {
                kVar.k1(i);
            } else {
                kVar.D(i, iVar.b());
            }
            int i2 = 2;
            if (iVar.component1() == null) {
                kVar.k1(i2);
            } else {
                kVar.D(i2, iVar.component1());
            }
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `QuestionWithArticle` WHERE `locale_questionId` = ? AND `locale_articleId` = ?";
        }
    }
    public h0(u0 u0Var) {
        super();
        e.a.a.a.b.a.a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.h0.h hVar = new app.dogo.android.persistencedb.room.dao.h0.h(this, u0Var);
        e.a.a.a.b.b.h0.n nVar = new app.dogo.android.persistencedb.room.dao.h0.n(this, u0Var);
        e.a.a.a.b.b.h0.q qVar = new app.dogo.android.persistencedb.room.dao.h0.q(this, u0Var);
        e.a.a.a.b.b.h0.r rVar = new app.dogo.android.persistencedb.room.dao.h0.r(this, u0Var);
        e.a.a.a.b.b.h0.s sVar = new app.dogo.android.persistencedb.room.dao.h0.s(this, u0Var);
        e.a.a.a.b.b.h0.t tVar = new app.dogo.android.persistencedb.room.dao.h0.t(this, u0Var);
        e.a.a.a.b.b.h0.u uVar = new app.dogo.android.persistencedb.room.dao.h0.u(this, u0Var);
        e.a.a.a.b.b.h0.v vVar = new app.dogo.android.persistencedb.room.dao.h0.v(this, u0Var);
        e.a.a.a.b.b.h0.w wVar = new app.dogo.android.persistencedb.room.dao.h0.w(this, u0Var);
        e.a.a.a.b.b.h0.a aVar = new app.dogo.android.persistencedb.room.dao.h0.a(this, u0Var);
    }

    public static List<Class<?>> A() {
        return Collections.emptyList();
    }

    private void p(d.e.a<String, ArrayList<ArticleTagEntity>> aVar) {
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
                p(aVar2);
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
        Cursor cursor = c.c(this.a, x0Var, false, cancellationSignal);
        while (cursor.moveToNext()) {
            x0Var = aVar.get(cursor.getString(6));
            try {
                x0Var = aVar.get(this.a.getString(6));
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

    static /* synthetic */ e.a.a.a.b.a.a q(h0 h0Var) {
        return h0Var.c;
    }

    static /* synthetic */ u0 r(h0 h0Var) {
        return h0Var.a;
    }

    static /* synthetic */ g0 s(h0 h0Var) {
        return h0Var.h;
    }

    static /* synthetic */ g0 t(h0 h0Var) {
        return h0Var.i;
    }

    static /* synthetic */ void u(h0 h0Var, d.e.a aVar) {
        h0Var.p(aVar);
    }

    static /* synthetic */ h0 v(h0 h0Var) {
        return h0Var.b;
    }

    static /* synthetic */ h0 w(h0 h0Var) {
        return h0Var.d;
    }

    static /* synthetic */ h0 x(h0 h0Var) {
        return h0Var.e;
    }

    static /* synthetic */ h0 y(h0 h0Var) {
        return h0Var.f;
    }

    static /* synthetic */ h0 z(h0 h0Var) {
        return h0Var.g;
    }

    public Object a(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.h0.j(this, x0.e("SELECT updatedAt FROM QuestionEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public Object b(String str, d<? super List<e.a.a.a.b.c.a>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ArticleWithTags WHERE locale_articleId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.h0.o(this, x0Var), dVar);
    }

    public Object c(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.h0.k(this, x0.e("SELECT updatedAt FROM ArticleEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public Object d(e.a.a.a.b.c.a[] aVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.i(this, aVarArr), dVar);
    }

    public Object e(e.a.a.a.b.d.a aVar, d<? super w> dVar) {
        return app.dogo.android.persistencedb.room.dao.g0.a.c(this, aVar, dVar);
    }

    public Object f(e.a.a.a.b.c.i[] iVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.e(this, iVarArr), dVar);
    }

    public Object g(e.a.a.a.b.d.f fVar, d<? super w> dVar) {
        return app.dogo.android.persistencedb.room.dao.g0.a.d(this, fVar, dVar);
    }

    public Object h(d<? super Long> dVar) {
        final int i = 0;
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.h0.l(this, x0.e("SELECT updatedAt FROM ArticleTagEntity ORDER BY updatedAt DESC LIMIT 1", i)), dVar);
    }

    public a0<List<e.a.a.a.b.d.a>> i(String str) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ArticleEntity WHERE locale = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return y0.a(new app.dogo.android.persistencedb.room.dao.h0.m(this, x0Var));
    }

    public Object j(ArticleEntity[] articleEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.c(this, articleEntityArr), dVar);
    }

    public Object k(ArticleTagEntity[] articleTagEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.d(this, articleTagEntityArr), dVar);
    }

    public Object l(e.a.a.a.b.c.i[] iVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.g(this, iVarArr), dVar);
    }

    public Object m(e.a.a.a.b.c.a[] aVarArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.f(this, aVarArr), dVar);
    }

    public Object n(String str, d<? super List<e.a.a.a.b.c.i>> dVar) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM QuestionWithArticle WHERE locale_questionId = ?", i);
        if (str == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, str);
        }
        return CoroutinesRoom.a(this.a, false, c.a(), new app.dogo.android.persistencedb.room.dao.h0.p(this, x0Var), dVar);
    }

    public Object o(QuestionEntity[] questionEntityArr, d<? super w> dVar) {
        return CoroutinesRoom.b(this.a, true, new app.dogo.android.persistencedb.room.dao.h0.b(this, questionEntityArr), dVar);
    }
}
