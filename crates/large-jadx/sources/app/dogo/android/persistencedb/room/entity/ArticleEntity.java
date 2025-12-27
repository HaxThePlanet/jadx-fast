package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ArticleEntity.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\u0082\u0001\u0010,\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0012R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 ¨\u00063", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;", "", "articleId", "", "title", "text", "readingTime", "", "sortOrder", "categoryId", "image", "locale", "updatedAt", "", "locale_articleId", "textHtml", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/String;", "getCategoryId", "getImage", "getLocale", "getLocale_articleId", "getReadingTime", "()I", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "getTextHtml", "getTitle", "getUpdatedAt", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ArticleEntity {

    private final String articleId;
    private final String categoryId;
    private final String image;
    private final String locale;
    private final String locale_articleId;
    private final int readingTime;
    private final Integer sortOrder;
    private final String text;
    private final String textHtml;
    private final String title;
    private final long updatedAt;
    public ArticleEntity(String str, String str2, String str3, int i, Integer integer, String str4, String str5, String str6, long j, String str7, String str8) {
        n.f(str, "articleId");
        n.f(str2, "title");
        n.f(str3, "text");
        n.f(str4, "categoryId");
        n.f(str6, "locale");
        n.f(str7, "locale_articleId");
        super();
        this.articleId = str;
        this.title = str2;
        this.text = str3;
        this.readingTime = i;
        this.sortOrder = integer;
        this.categoryId = str4;
        this.image = str5;
        this.locale = str6;
        this.updatedAt = j;
        this.locale_articleId = str7;
        this.textHtml = str8;
    }

    public final String getArticleId() {
        return this.articleId;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_articleId() {
        return this.locale_articleId;
    }

    public final int getReadingTime() {
        return this.readingTime;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextHtml() {
        return this.textHtml;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ ArticleEntity(String str, String str2, String str3, int i, Integer integer, String str4, String str5, String str6, long j, String str7, String str8, int i2, g gVar) {
        Integer integer52;
        String str112;
        int gVar132 = i2;
        i2 = gVar132 & 16;
        i2 = gVar132 & 16 != 0 ? i2 : integer;
        i = gVar132 & 512;
        if (gVar132 & 512 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str82 = str6;
            char c = '_';
            str4 = str;
            str112 = str82 + c + str4;
        } else {
            str4 = str;
            str82 = str6;
            str112 = str7;
        }
        this(str, str2, str3, i, integer52, str4, str5, str6, j, str9, str112, str8);
    }

    public static /* synthetic */ ArticleEntity copy$default(ArticleEntity articleEntity, String str, String str2, String str3, int i, Integer integer, String str4, String str5, String str6, long j, String str7, String str8, int i2, Object object) {
        String i132;
        String str22;
        String str32;
        String str42;
        int i52;
        Integer integer62;
        String str72;
        String str82;
        String str92;
        long j102;
        String str122;
        Object articleEntity2 = articleEntity;
        int object142 = i2;
        String r2 = object142 & 1 != 0 ? articleEntity2.articleId : str;
        String r3 = object142 & 2 != 0 ? articleEntity2.title : str2;
        String r4 = object142 & 4 != 0 ? articleEntity2.text : str3;
        int r5 = object142 & 8 != 0 ? articleEntity2.readingTime : i;
        Integer r6 = object142 & 16 != 0 ? articleEntity2.sortOrder : integer;
        String r7 = object142 & 32 != 0 ? articleEntity2.categoryId : str4;
        String r8 = object142 & 64 != 0 ? articleEntity2.image : str5;
        String r9 = object142 & 128 != 0 ? articleEntity2.locale : str6;
        long r10 = object142 & 256 != 0 ? articleEntity2.updatedAt : j;
        String r12 = object142 & 512 != 0 ? articleEntity2.locale_articleId : str7;
        String r1 = object142 & 1024 != 0 ? articleEntity2.textHtml : str8;
        return articleEntity.copy(str22, str32, str42, i52, integer62, str72, str82, str92, j102, r23, str122, (object142 & 1024 != 0 ? articleEntity2.textHtml : str8));
    }

    /* operator */ public final String component1() {
        return this.articleId;
    }

    /* operator */ public final String component10() {
        return this.locale_articleId;
    }

    /* operator */ public final String component11() {
        return this.textHtml;
    }

    /* operator */ public final String component2() {
        return this.title;
    }

    /* operator */ public final String component3() {
        return this.text;
    }

    /* operator */ public final int component4() {
        return this.readingTime;
    }

    /* operator */ public final Integer component5() {
        return this.sortOrder;
    }

    /* operator */ public final String component6() {
        return this.categoryId;
    }

    /* operator */ public final String component7() {
        return this.image;
    }

    /* operator */ public final String component8() {
        return this.locale;
    }

    /* operator */ public final long component9() {
        return this.updatedAt;
    }

    public final ArticleEntity copy(String articleId, String title, String text, int readingTime, Integer sortOrder, String categoryId, String image, String locale, long updatedAt, String locale_articleId, String textHtml) {
        n.f(articleId, "articleId");
        final Object title2 = title;
        n.f(title2, "title");
        final Object text2 = text;
        n.f(text2, "text");
        final Object categoryId2 = categoryId;
        n.f(categoryId2, "categoryId");
        final Object locale2 = locale;
        n.f(locale2, "locale");
        final Object textHtml2 = locale_articleId;
        n.f(textHtml2, "locale_articleId");
        ArticleEntity articleEntity = new ArticleEntity(articleId, title2, text2, readingTime, sortOrder, categoryId2, image, locale2, updatedAt, str7, textHtml2, textHtml);
        return articleEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z11 = false;
        if (!(other instanceof ArticleEntity)) {
            return false;
        }
        if (!n.b(this.articleId, other.articleId)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        if (this.readingTime != other.readingTime) {
            return false;
        }
        if (!n.b(this.sortOrder, other.sortOrder)) {
            return false;
        }
        if (!n.b(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.locale_articleId, other.locale_articleId)) {
            return false;
        }
        return !n.b(this.textHtml, other.textHtml) ? z11 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.sortOrder == null) {
        } else {
            i = this.sortOrder.hashCode();
        }
        if (this.image == null) {
        } else {
            i = this.image.hashCode();
        }
        if (this.textHtml != null) {
            i = this.textHtml.hashCode();
        }
        return (this.articleId.hashCode() * 31) + this.title.hashCode() * 31 + this.text.hashCode() * 31 + Integer.hashCode(this.readingTime) * 31 + i * 31 + this.categoryId.hashCode() * 31 + i * 31 + this.locale.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_articleId.hashCode() * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ArticleEntity(articleId=";
        String str3 = ", title=";
        String str4 = ", text=";
        String str5 = ", readingTime=";
        String str6 = ", sortOrder=";
        String str7 = ", categoryId=";
        String str8 = ", image=";
        String str9 = ", locale=";
        String str10 = ", updatedAt=";
        String str11 = ", locale_articleId=";
        String str12 = ", textHtml=";
        str = str2 + this.articleId + str3 + this.title + str4 + this.text + str5 + this.readingTime + str6 + this.sortOrder + str7 + this.categoryId + str8 + this.image + str9 + this.locale + str10 + this.updatedAt + str11 + this.locale_articleId + str12 + this.textHtml + 41;
        return str;
    }
}
