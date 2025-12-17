package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\u0082\u0001\u0010,\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0012R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 ¨\u00063", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;", "", "articleId", "", "title", "text", "readingTime", "", "sortOrder", "categoryId", "image", "locale", "updatedAt", "", "locale_articleId", "textHtml", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/String;", "getCategoryId", "getImage", "getLocale", "getLocale_articleId", "getReadingTime", "()I", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "getTextHtml", "getTitle", "getUpdatedAt", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ArticleEntity {

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
    public ArticleEntity(String string, String string2, String string3, int i4, Integer integer5, String string6, String string7, String string8, long l9, String string10, String string11) {
        n.f(string, "articleId");
        n.f(string2, "title");
        n.f(string3, "text");
        n.f(string6, "categoryId");
        n.f(string8, "locale");
        n.f(string11, "locale_articleId");
        super();
        this.articleId = string;
        this.title = string2;
        this.text = string3;
        this.readingTime = i4;
        this.sortOrder = integer5;
        this.categoryId = string6;
        this.image = string7;
        this.locale = string8;
        this.updatedAt = l9;
        this.locale_articleId = string11;
        this.textHtml = obj13;
    }

    public ArticleEntity(String string, String string2, String string3, int i4, Integer integer5, String string6, String string7, String string8, long l9, String string10, String string11, int i12, g g13) {
        int string4;
        int i3;
        String str;
        int i;
        String str3;
        int i2;
        String str2;
        int i5 = g13;
        i2 = i5 & 16 != 0 ? i3 : integer5;
        if (i5 &= 512 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string8);
            stringBuilder.append('_');
            stringBuilder.append(string);
            str2 = string4;
        } else {
            str3 = string;
            str = string8;
            str2 = string11;
        }
        super(string, string2, string3, i4, i2, string6, string7, string8, l9, obj12, str2, i12);
    }

    public static app.dogo.android.persistencedb.room.entity.ArticleEntity copy$default(app.dogo.android.persistencedb.room.entity.ArticleEntity articleEntity, String string2, String string3, String string4, int i5, Integer integer6, String string7, String string8, String string9, long l10, String string11, String string12, int i13, Object object14) {
        String textHtml;
        String articleId;
        String title;
        String text;
        int readingTime;
        Integer sortOrder;
        String categoryId;
        String image;
        String locale;
        long updatedAt;
        String locale_articleId;
        Object obj = articleEntity;
        int i = object14;
        articleId = i & 1 != 0 ? obj.articleId : string2;
        title = i & 2 != 0 ? obj.title : string3;
        text = i & 4 != 0 ? obj.text : string4;
        readingTime = i & 8 != 0 ? obj.readingTime : i5;
        sortOrder = i & 16 != 0 ? obj.sortOrder : integer6;
        categoryId = i & 32 != 0 ? obj.categoryId : string7;
        image = i & 64 != 0 ? obj.image : string8;
        locale = i & 128 != 0 ? obj.locale : string9;
        updatedAt = i & 256 != 0 ? obj.updatedAt : l10;
        locale_articleId = i & 512 != 0 ? obj.locale_articleId : string12;
        textHtml = i &= 1024 != 0 ? obj.textHtml : i13;
        return articleEntity.copy(articleId, title, text, readingTime, sortOrder, categoryId, image, locale, updatedAt, string11, locale_articleId);
    }

    public final String component1() {
        return this.articleId;
    }

    public final String component10() {
        return this.locale_articleId;
    }

    public final String component11() {
        return this.textHtml;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.text;
    }

    public final int component4() {
        return this.readingTime;
    }

    public final Integer component5() {
        return this.sortOrder;
    }

    public final String component6() {
        return this.categoryId;
    }

    public final String component7() {
        return this.image;
    }

    public final String component8() {
        return this.locale;
    }

    public final long component9() {
        return this.updatedAt;
    }

    public final app.dogo.android.persistencedb.room.entity.ArticleEntity copy(String string, String string2, String string3, int i4, Integer integer5, String string6, String string7, String string8, long l9, String string10, String string11) {
        n.f(string, "articleId");
        final Object obj = string2;
        n.f(obj, "title");
        final Object obj2 = string3;
        n.f(obj2, "text");
        final Object obj3 = string6;
        n.f(obj3, "categoryId");
        final Object obj4 = string8;
        n.f(obj4, "locale");
        final Object obj5 = string11;
        n.f(obj5, "locale_articleId");
        super(string, obj, obj2, i4, integer5, obj3, string7, obj4, l9, obj11, obj5, obj26);
        return articleEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ArticleEntity) {
            return i2;
        }
        if (!n.b(this.articleId, object.articleId)) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (this.readingTime != object.readingTime) {
            return i2;
        }
        if (!n.b(this.sortOrder, object.sortOrder)) {
            return i2;
        }
        if (!n.b(this.categoryId, object.categoryId)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_articleId, object.locale_articleId)) {
            return i2;
        }
        if (!n.b(this.textHtml, object.textHtml)) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        int i;
        int i2;
        int i3;
        Integer sortOrder = this.sortOrder;
        i3 = 0;
        if (sortOrder == null) {
            i = i3;
        } else {
            i = sortOrder.hashCode();
        }
        String image = this.image;
        if (image == null) {
            i2 = i3;
        } else {
            i2 = image.hashCode();
        }
        String textHtml = this.textHtml;
        if (textHtml == null) {
        } else {
            i3 = textHtml.hashCode();
        }
        return i23 += i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArticleEntity(articleId=");
        stringBuilder.append(this.articleId);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", readingTime=");
        stringBuilder.append(this.readingTime);
        stringBuilder.append(", sortOrder=");
        stringBuilder.append(this.sortOrder);
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_articleId=");
        stringBuilder.append(this.locale_articleId);
        stringBuilder.append(", textHtml=");
        stringBuilder.append(this.textHtml);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
