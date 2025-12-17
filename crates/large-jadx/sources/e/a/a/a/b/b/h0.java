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
import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import d.e.a;
import d.e.g;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import e.a.a.a.b.c.a;
import e.a.a.a.b.c.i;
import e.a.a.a.b.d.a;
import e.a.a.a.b.d.f;
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
public final class h0 implements e.a.a.a.b.b.g0 {

    private final u0 a;
    private final h0<QuestionEntity> b;
    private final a c;
    private final h0<ArticleEntity> d;
    private final h0<ArticleTagEntity> e;
    private final h0<i> f;
    private final h0<a> g;
    private final g0<i> h;
    private final g0<a> i;

    class b implements Callable<w> {

        final QuestionEntity[] a;
        final e.a.a.a.b.b.h0 b;
        b(e.a.a.a.b.b.h0 h0, QuestionEntity[] questionEntity2Arr2) {
            this.b = h0;
            this.a = questionEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.v(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class c implements Callable<w> {

        final ArticleEntity[] a;
        final e.a.a.a.b.b.h0 b;
        c(e.a.a.a.b.b.h0 h0, ArticleEntity[] articleEntity2Arr2) {
            this.b = h0;
            this.a = articleEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.w(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<w> {

        final ArticleTagEntity[] a;
        final e.a.a.a.b.b.h0 b;
        d(e.a.a.a.b.b.h0 h0, ArticleTagEntity[] articleTagEntity2Arr2) {
            this.b = h0;
            this.a = articleTagEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.x(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<w> {

        final i[] a;
        final e.a.a.a.b.b.h0 b;
        e(e.a.a.a.b.b.h0 h0, i[] i2Arr2) {
            this.b = h0;
            this.a = i2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.y(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class f implements Callable<w> {

        final a[] a;
        final e.a.a.a.b.b.h0 b;
        f(e.a.a.a.b.b.h0 h0, a[] a2Arr2) {
            this.b = h0;
            this.a = a2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.z(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class g implements Callable<w> {

        final i[] a;
        final e.a.a.a.b.b.h0 b;
        g(e.a.a.a.b.b.h0 h0, i[] i2Arr2) {
            this.b = h0;
            this.a = i2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.s(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class i implements Callable<w> {

        final a[] a;
        final e.a.a.a.b.b.h0 b;
        i(e.a.a.a.b.b.h0 h0, a[] a2Arr2) {
            this.b = h0;
            this.a = a2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public w a() {
            h0.r(this.b).c();
            h0.t(this.b).i(this.a);
            h0.r(this.b).C();
            h0.r(this.b).g();
            return w.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class j implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.h0 b;
        j(e.a.a.a.b.b.h0 h0, x0 x02) {
            this.b = h0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(h0.r(this.b), this.a, i, 0);
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

    class k implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.h0 b;
        k(e.a.a.a.b.b.h0 h0, x0 x02) {
            this.b = h0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(h0.r(this.b), this.a, i, 0);
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

    class l implements Callable<Long> {

        final x0 a;
        final e.a.a.a.b.b.h0 b;
        l(e.a.a.a.b.b.h0 h0, x0 x02) {
            this.b = h0;
            this.a = x02;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Long a() {
            boolean moveToFirst;
            int valueOf;
            final int i = 0;
            Cursor cursor = c.c(h0.r(this.b), this.a, i, 0);
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

    class m implements Callable<List<a>> {

        final x0 a;
        final e.a.a.a.b.b.h0 b;
        m(e.a.a.a.b.b.h0 h0, x0 x02) {
            this.b = h0;
            this.a = x02;
            super();
        }

        public List<a> a() {
            int i4;
            Object arrayList;
            int i3;
            int arrayList2;
            String string7;
            int articleEntity;
            boolean null;
            String string8;
            String string9;
            String string2;
            Integer valueOf;
            String string3;
            String string6;
            String string4;
            String string;
            String string5;
            Object obj;
            int i;
            int i2;
            String str7;
            String str2;
            int int;
            Integer num;
            String str3;
            String str6;
            String str;
            long long;
            String str5;
            String str4;
            final Object obj2 = this;
            h0.r(obj2.b).c();
            Cursor cursor = c.c(h0.r(obj2.b), obj2.a, true, 0);
            i4 = b.e(cursor, "articleId");
            i3 = b.e(cursor, "title");
            int i7 = b.e(cursor, "text");
            int i8 = b.e(cursor, "readingTime");
            int i9 = b.e(cursor, "sortOrder");
            int i10 = b.e(cursor, "categoryId");
            int i11 = b.e(cursor, "image");
            int i12 = b.e(cursor, "locale");
            int i13 = b.e(cursor, "updatedAt");
            int i14 = b.e(cursor, "locale_articleId");
            int i15 = b.e(cursor, "textHtml");
            a aVar2 = new a();
            while (cursor.moveToNext()) {
                string7 = cursor.getString(i14);
                if ((ArrayList)aVar2.get(string7) == null) {
                }
                arrayList2 = 0;
                arrayList2 = new ArrayList();
                aVar2.put(string7, arrayList2);
            }
            cursor.moveToPosition(-1);
            h0.u(obj2.b, aVar2);
            ArrayList arrayList3 = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i4) && cursor.isNull(i3) && cursor.isNull(i7) && cursor.isNull(i8) && cursor.isNull(i9) && cursor.isNull(i10) && cursor.isNull(i11) && cursor.isNull(i12) && cursor.isNull(i13) && cursor.isNull(i14)) {
                } else {
                }
                if (cursor.isNull(i4)) {
                } else {
                }
                i2 = string8;
                if (cursor.isNull(i3)) {
                } else {
                }
                str7 = string9;
                if (cursor.isNull(i7)) {
                } else {
                }
                str2 = string2;
                if (cursor.isNull(i9)) {
                } else {
                }
                num = valueOf;
                if (cursor.isNull(i10)) {
                } else {
                }
                str3 = string3;
                if (cursor.isNull(i11)) {
                } else {
                }
                str6 = string6;
                if (cursor.isNull(i12)) {
                } else {
                }
                str = string4;
                if (cursor.isNull(i14)) {
                } else {
                }
                str5 = string;
                if (cursor.isNull(i15)) {
                } else {
                }
                str4 = string5;
                super(i2, str7, str2, cursor.getInt(i8), num, str3, str6, str, cursor.getLong(i13), obj27, str5, str4);
                i = i4;
                if ((ArrayList)aVar2.get(cursor.getString(i14)) == null) {
                }
                a aVar = new a(articleEntity, arrayList);
                arrayList3.add(aVar);
                i4 = i;
                i3 = i2;
                arrayList = new ArrayList();
                str4 = 0;
                str5 = 0;
                str = 0;
                str6 = 0;
                str3 = 0;
                num = 0;
                str2 = 0;
                str7 = 0;
                i2 = 0;
                if (cursor.isNull(i3)) {
                } else {
                }
                if (cursor.isNull(i7)) {
                } else {
                }
                if (cursor.isNull(i8)) {
                } else {
                }
                if (cursor.isNull(i9)) {
                } else {
                }
                if (cursor.isNull(i10)) {
                } else {
                }
                if (cursor.isNull(i11)) {
                } else {
                }
                if (cursor.isNull(i12)) {
                } else {
                }
                if (cursor.isNull(i13)) {
                } else {
                }
                if (cursor.isNull(i14)) {
                } else {
                }
                if (!cursor.isNull(i15)) {
                } else {
                }
                i = i4;
                articleEntity = 0;
            }
            h0.r(obj2.b).C();
            cursor.close();
            h0.r(obj2.b).g();
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

    class o implements Callable<List<a>> {

        final x0 a;
        final e.a.a.a.b.b.h0 b;
        o(e.a.a.a.b.b.h0 h0, x0 x02) {
            this.b = h0;
            this.a = x02;
            super();
        }

        public List<a> a() {
            int string2;
            String string;
            a aVar;
            final int i4 = 0;
            Cursor cursor = c.c(h0.r(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_articleId");
            int i3 = b.e(cursor, "locale_tagId");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i)) {
                } else {
                }
                string2 = cursor.getString(i);
                if (cursor.isNull(i3)) {
                } else {
                }
                string = cursor.getString(i3);
                aVar = new a(string2, string);
                arrayList.add(aVar);
                string = i4;
                string2 = i4;
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

    class p implements Callable<List<i>> {

        final x0 a;
        final e.a.a.a.b.b.h0 b;
        p(e.a.a.a.b.b.h0 h0, x0 x02) {
            this.b = h0;
            this.a = x02;
            super();
        }

        public List<i> a() {
            int string;
            String string2;
            i iVar;
            final int i4 = 0;
            Cursor cursor = c.c(h0.r(this.b), this.a, false, i4);
            int i = b.e(cursor, "locale_articleId");
            int i3 = b.e(cursor, "locale_questionId");
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
                iVar = new i(string, string2);
                arrayList.add(iVar);
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

    class a extends g0<a> {
        a(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ArticleWithTags` WHERE `locale_articleId` = ? AND `locale_tagId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (a)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, a a2) {
            String str;
            String obj4;
            int i = 1;
            if (a2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, a2.a());
            }
            int i2 = 2;
            if (a2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, a2.b());
            }
        }
    }

    class h extends h0<QuestionEntity> {

        final e.a.a.a.b.b.h0 d;
        h(e.a.a.a.b.b.h0 h0, u0 u02) {
            this.d = h0;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `QuestionEntity` (`questionId`,`locale`,`question`,`answers`,`correctAnswer`,`updatedAt`,`locale_questionId`) VALUES (?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (QuestionEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, QuestionEntity questionEntity2) {
            String questionId;
            String locale;
            String question;
            String obj5;
            int i3 = 1;
            if (questionEntity2.getQuestionId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, questionEntity2.getQuestionId());
            }
            int i4 = 2;
            if (questionEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, questionEntity2.getLocale());
            }
            int i5 = 3;
            if (questionEntity2.getQuestion() == null) {
                k.k1(i5);
            } else {
                k.D(i5, questionEntity2.getQuestion());
            }
            String str = h0.q(this.d).d(questionEntity2.getAnswers());
            int i6 = 4;
            if (str == null) {
                k.k1(i6);
            } else {
                k.D(i6, str);
            }
            k.u0(5, (long)correctAnswer);
            k.u0(6, questionEntity2.getUpdatedAt());
            int i7 = 7;
            if (questionEntity2.getLocale_questionId() == null) {
                k.k1(i7);
            } else {
                k.D(i7, questionEntity2.getLocale_questionId());
            }
        }
    }

    class n extends h0<ArticleEntity> {
        n(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ArticleEntity` (`articleId`,`title`,`text`,`readingTime`,`sortOrder`,`categoryId`,`image`,`locale`,`updatedAt`,`locale_articleId`,`textHtml`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (ArticleEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, ArticleEntity articleEntity2) {
            String articleId;
            String title;
            String text;
            int sortOrder;
            String categoryId;
            String image;
            String locale;
            String locale_articleId;
            long l;
            String obj6;
            int i3 = 1;
            if (articleEntity2.getArticleId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, articleEntity2.getArticleId());
            }
            int i4 = 2;
            if (articleEntity2.getTitle() == null) {
                k.k1(i4);
            } else {
                k.D(i4, articleEntity2.getTitle());
            }
            int i5 = 3;
            if (articleEntity2.getText() == null) {
                k.k1(i5);
            } else {
                k.D(i5, articleEntity2.getText());
            }
            k.u0(4, (long)readingTime);
            int i6 = 5;
            if (articleEntity2.getSortOrder() == null) {
                k.k1(i6);
            } else {
                k.u0(i6, (long)sortOrder);
            }
            int i7 = 6;
            if (articleEntity2.getCategoryId() == null) {
                k.k1(i7);
            } else {
                k.D(i7, articleEntity2.getCategoryId());
            }
            int i8 = 7;
            if (articleEntity2.getImage() == null) {
                k.k1(i8);
            } else {
                k.D(i8, articleEntity2.getImage());
            }
            int i9 = 8;
            if (articleEntity2.getLocale() == null) {
                k.k1(i9);
            } else {
                k.D(i9, articleEntity2.getLocale());
            }
            k.u0(9, articleEntity2.getUpdatedAt());
            int i10 = 10;
            if (articleEntity2.getLocale_articleId() == null) {
                k.k1(i10);
            } else {
                k.D(i10, articleEntity2.getLocale_articleId());
            }
            int i11 = 11;
            if (articleEntity2.getTextHtml() == null) {
                k.k1(i11);
            } else {
                k.D(i11, articleEntity2.getTextHtml());
            }
        }
    }

    class q extends h0<ArticleTagEntity> {
        q(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ArticleTagEntity` (`hidden`,`tagId`,`locale`,`name`,`updatedAt`,`locale_tagId`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (ArticleTagEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, ArticleTagEntity articleTagEntity2) {
            String tagId;
            String locale;
            String name;
            String obj6;
            final long l = (long)hidden;
            k.u0(1, l);
            int i3 = 2;
            if (articleTagEntity2.getTagId() == null) {
                k.k1(i3);
            } else {
                k.D(i3, articleTagEntity2.getTagId());
            }
            int i4 = 3;
            if (articleTagEntity2.getLocale() == null) {
                k.k1(i4);
            } else {
                k.D(i4, articleTagEntity2.getLocale());
            }
            int i5 = 4;
            if (articleTagEntity2.getName() == null) {
                k.k1(i5);
            } else {
                k.D(i5, articleTagEntity2.getName());
            }
            k.u0(5, articleTagEntity2.getUpdatedAt());
            int i6 = 6;
            if (articleTagEntity2.getLocale_tagId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, articleTagEntity2.getLocale_tagId());
            }
        }
    }

    class r extends h0<i> {
        r(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `QuestionWithArticle` (`locale_articleId`,`locale_questionId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (i)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, i i2) {
            String str;
            String obj4;
            int i = 1;
            if (i2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, i2.a());
            }
            int i3 = 2;
            if (i2.b() == null) {
                k.k1(i3);
            } else {
                k.D(i3, i2.b());
            }
        }
    }

    class s extends h0<a> {
        s(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `ArticleWithTags` (`locale_articleId`,`locale_tagId`) VALUES (?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (a)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, a a2) {
            String str;
            String obj4;
            int i = 1;
            if (a2.a() == null) {
                k.k1(i);
            } else {
                k.D(i, a2.a());
            }
            int i2 = 2;
            if (a2.b() == null) {
                k.k1(i2);
            } else {
                k.D(i2, a2.b());
            }
        }
    }

    class t extends g0<QuestionEntity> {
        t(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `QuestionEntity` WHERE `locale_questionId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (QuestionEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, QuestionEntity questionEntity2) {
            String obj4;
            final int i = 1;
            if (questionEntity2.getLocale_questionId() == null) {
                k.k1(i);
            } else {
                k.D(i, questionEntity2.getLocale_questionId());
            }
        }
    }

    class u extends g0<ArticleEntity> {
        u(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ArticleEntity` WHERE `locale_articleId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (ArticleEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, ArticleEntity articleEntity2) {
            String obj4;
            final int i = 1;
            if (articleEntity2.getLocale_articleId() == null) {
                k.k1(i);
            } else {
                k.D(i, articleEntity2.getLocale_articleId());
            }
        }
    }

    class v extends g0<ArticleTagEntity> {
        v(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `ArticleTagEntity` WHERE `locale_tagId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (ArticleTagEntity)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, ArticleTagEntity articleTagEntity2) {
            String obj4;
            final int i = 1;
            if (articleTagEntity2.getLocale_tagId() == null) {
                k.k1(i);
            } else {
                k.D(i, articleTagEntity2.getLocale_tagId());
            }
        }
    }

    class w extends g0<i> {
        w(e.a.a.a.b.b.h0 h0, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.g0
        public String d() {
            return "DELETE FROM `QuestionWithArticle` WHERE `locale_questionId` = ? AND `locale_articleId` = ?";
        }

        @Override // androidx.room.g0
        public void g(k k, Object object2) {
            j(k, (i)object2);
        }

        @Override // androidx.room.g0
        public void j(k k, i i2) {
            String str;
            String obj4;
            int i = 1;
            if (i2.b() == null) {
                k.k1(i);
            } else {
                k.D(i, i2.b());
            }
            int i3 = 2;
            if (i2.a() == null) {
                k.k1(i3);
            } else {
                k.D(i3, i2.a());
            }
        }
    }
    public h0(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        h0.h hVar = new h0.h(this, u0);
        this.b = hVar;
        h0.n nVar = new h0.n(this, u0);
        this.d = nVar;
        h0.q qVar = new h0.q(this, u0);
        this.e = qVar;
        h0.r rVar = new h0.r(this, u0);
        this.f = rVar;
        h0.s sVar = new h0.s(this, u0);
        this.g = sVar;
        h0.t tVar = new h0.t(this, u0);
        h0.u uVar = new h0.u(this, u0);
        h0.v vVar = new h0.v(this, u0);
        h0.w wVar = new h0.w(this, u0);
        this.h = wVar;
        h0.a aVar2 = new h0.a(this, u0);
        this.i = aVar2;
    }

    public static List<Class<?>> A() {
        return Collections.emptyList();
    }

    private void p(a<String, ArrayList<ArticleTagEntity>> a) {
        a aVar;
        x0 x0Var;
        int i;
        int i3;
        int i2;
        Object next;
        boolean articleTagEntity;
        String string4;
        String string;
        String string3;
        String string2;
        Object obj2;
        Object obj;
        String str4;
        String str2;
        String str3;
        long long;
        String str;
        Set keySet = a.keySet();
        if (keySet.isEmpty()) {
        }
        int i5 = 999;
        final int i8 = 0;
        if (a.size() > i5) {
            aVar = new a(i5);
            i2 = i;
            while (i < a.size()) {
                aVar.put((String)a.j(i), (ArrayList)a.n(i));
                i++;
                if (i2++ == i5) {
                }
                p(aVar);
                aVar = new a(i5);
                i2 = i8;
            }
            if (i2 > 0) {
                p(aVar);
            }
        }
        StringBuilder sb = f.b();
        sb.append("SELECT `ArticleTagEntity`.`hidden` AS `hidden`,`ArticleTagEntity`.`tagId` AS `tagId`,`ArticleTagEntity`.`locale` AS `locale`,`ArticleTagEntity`.`name` AS `name`,`ArticleTagEntity`.`updatedAt` AS `updatedAt`,`ArticleTagEntity`.`locale_tagId` AS `locale_tagId`,_junction.`locale_articleId` FROM `ArticleWithTags` AS _junction INNER JOIN `ArticleTagEntity` ON (_junction.`locale_tagId` = `ArticleTagEntity`.`locale_tagId`) WHERE _junction.`locale_articleId` IN (");
        int size3 = keySet.size();
        f.a(sb, size3);
        sb.append(")");
        x0Var = x0.e(sb.toString(), size3 += i8);
        Iterator iterator = keySet.iterator();
        int i7 = 1;
        i3 = i7;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next == null) {
            } else {
            }
            x0Var.D(i3, (String)next);
            i3++;
            x0Var.k1(i3);
        }
        int i9 = 0;
        Cursor cursor = c.c(this.a, x0Var, i8, i9);
        while (cursor.moveToNext()) {
            x0Var = a.get(cursor.getString(6));
            if ((ArrayList)x0Var != null) {
            }
            if (cursor.getInt(i8) != 0) {
            } else {
            }
            obj = i8;
            if (cursor.isNull(i7)) {
            } else {
            }
            str4 = string4;
            string = 2;
            if (cursor.isNull(string)) {
            } else {
            }
            str2 = string;
            string3 = 3;
            if (cursor.isNull(string3)) {
            } else {
            }
            str3 = string3;
            string2 = 5;
            if (cursor.isNull(string2)) {
            } else {
            }
            str = string2;
            super(obj, str4, str2, str3, cursor.getLong(4), obj12, str);
            (ArrayList)x0Var.add(articleTagEntity);
            str = i9;
            str3 = i9;
            str2 = i9;
            str4 = i9;
            obj = i7;
        }
        cursor.close();
    }

    static a q(e.a.a.a.b.b.h0 h0) {
        return h0.c;
    }

    static u0 r(e.a.a.a.b.b.h0 h0) {
        return h0.a;
    }

    static g0 s(e.a.a.a.b.b.h0 h0) {
        return h0.h;
    }

    static g0 t(e.a.a.a.b.b.h0 h0) {
        return h0.i;
    }

    static void u(e.a.a.a.b.b.h0 h0, a a2) {
        h0.p(a2);
    }

    static h0 v(e.a.a.a.b.b.h0 h0) {
        return h0.b;
    }

    static h0 w(e.a.a.a.b.b.h0 h0) {
        return h0.d;
    }

    static h0 x(e.a.a.a.b.b.h0 h0) {
        return h0.e;
    }

    static h0 y(e.a.a.a.b.b.h0 h0) {
        return h0.f;
    }

    static h0 z(e.a.a.a.b.b.h0 h0) {
        return h0.g;
    }

    public Object a(d<? super Long> d) {
        final int i = 0;
        h0.j jVar = new h0.j(this, x0.e("SELECT updatedAt FROM QuestionEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), jVar, d);
    }

    public Object b(String string, d<? super List<a>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ArticleWithTags WHERE locale_articleId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        h0.o oVar = new h0.o(this, x0Var);
        return c0.a(this.a, false, c.a(), oVar, d2);
    }

    public Object c(d<? super Long> d) {
        final int i = 0;
        h0.k kVar = new h0.k(this, x0.e("SELECT updatedAt FROM ArticleEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), kVar, d);
    }

    public Object d(a[] aArr, d<? super w> d2) {
        h0.i iVar = new h0.i(this, aArr);
        return c0.b(this.a, true, iVar, d2);
    }

    public Object e(a a, d<? super w> d2) {
        return g0.a.c(this, a, d2);
    }

    public Object f(i[] iArr, d<? super w> d2) {
        h0.e eVar = new h0.e(this, iArr);
        return c0.b(this.a, true, eVar, d2);
    }

    public Object g(f f, d<? super w> d2) {
        return g0.a.d(this, f, d2);
    }

    public Object h(d<? super Long> d) {
        final int i = 0;
        h0.l lVar = new h0.l(this, x0.e("SELECT updatedAt FROM ArticleTagEntity ORDER BY updatedAt DESC LIMIT 1", i));
        return c0.a(this.a, i, c.a(), lVar, d);
    }

    public a0<List<a>> i(String string) {
        final int i = 1;
        x0 x0Var = x0.e("SELECT * FROM ArticleEntity WHERE locale = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        h0.m obj3 = new h0.m(this, x0Var);
        return y0.a(obj3);
    }

    public Object j(ArticleEntity[] articleEntityArr, d<? super w> d2) {
        h0.c cVar = new h0.c(this, articleEntityArr);
        return c0.b(this.a, true, cVar, d2);
    }

    public Object k(ArticleTagEntity[] articleTagEntityArr, d<? super w> d2) {
        h0.d dVar = new h0.d(this, articleTagEntityArr);
        return c0.b(this.a, true, dVar, d2);
    }

    public Object l(i[] iArr, d<? super w> d2) {
        h0.g gVar = new h0.g(this, iArr);
        return c0.b(this.a, true, gVar, d2);
    }

    public Object m(a[] aArr, d<? super w> d2) {
        h0.f fVar = new h0.f(this, aArr);
        return c0.b(this.a, true, fVar, d2);
    }

    public Object n(String string, d<? super List<i>> d2) {
        int i = 1;
        x0 x0Var = x0.e("SELECT * FROM QuestionWithArticle WHERE locale_questionId = ?", i);
        if (string == null) {
            x0Var.k1(i);
        } else {
            x0Var.D(i, string);
        }
        h0.p pVar = new h0.p(this, x0Var);
        return c0.a(this.a, false, c.a(), pVar, d2);
    }

    public Object o(QuestionEntity[] questionEntityArr, d<? super w> d2) {
        h0.b bVar = new h0.b(this, questionEntityArr);
        return c0.b(this.a, true, bVar, d2);
    }
}
