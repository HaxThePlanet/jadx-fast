package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: Article.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008(\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0092\u0001\u00101\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r2\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\t\u00103\u001a\u00020\nHÖ\u0001J\u0013\u00104\u001a\u00020\r2\u0008\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007J\t\u00108\u001a\u00020\nHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0018R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u001f\u0010\u001aR\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0015R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0015¨\u0006?", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Article;", "Landroid/os/Parcelable;", "title", "", "articleId", "text", "tags", "", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "readingTime", "", "image", "seen", "", "category", "sortOrder", "isRead", "readTimeMs", "textHtml", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/String;", "getCategory", "getImage", "()Z", "getReadTimeMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReadingTime", "()I", "getSeen", "getSortOrder", "getTags", "()Ljava/util/List;", "getText", "getTextHtml", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;)Lapp/dogo/com/dogo_android/repository/domain/Article;", "describeContents", "equals", "other", "", "getDisplayTags", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Article implements Parcelable {

    public static final Parcelable.Creator<Article> CREATOR = new Article$Creator<>();
    private final String articleId;
    private final String category;
    private final String image;
    private final boolean isRead;
    private final Integer readTimeMs;
    private final int readingTime;
    private final boolean seen;
    private final Integer sortOrder;
    private final List<LibraryTag> tags;
    private final String text;
    private final String textHtml;
    private final String title;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Article> {
        @Override // android.os.Parcelable$Creator
        public final Article createFromParcel(Parcel parcel) {
            int i;
            Integer num2;
            Integer num;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(LibraryTag.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            i = 1;
            int r1 = i;
            int i2 = 0;
            if (parcel.readInt() == 0) {
            } else {
                num2 = Integer.valueOf(parcel.readInt());
            }
            int r13 = i;
            if (parcel.readInt() == 0) {
            } else {
            }
            Article article = new Article(parcel.readString(), parcel.readString(), parcel.readString(), arrayList, parcel.readInt(), parcel.readString(), i, parcel.readString(), num2, i, num, string);
            return article;
        }

        @Override // android.os.Parcelable$Creator
        public final Article[] newArray(int i) {
            return new Article[i];
        }
    }
    public Article(String str, String str2, String str3, List<LibraryTag> list, int i, String str4, boolean z, String str5, Integer integer, boolean z2, Integer integer2, String str6) {
        n.f(str, "title");
        n.f(str2, "articleId");
        n.f(str3, "text");
        n.f(list, "tags");
        n.f(str4, "image");
        n.f(str5, "category");
        super();
        this.title = str;
        this.articleId = str2;
        this.text = str3;
        this.tags = list;
        this.readingTime = i;
        this.image = str4;
        this.seen = z;
        this.category = str5;
        this.sortOrder = integer;
        this.isRead = z2;
        this.readTimeMs = integer2;
        this.textHtml = str6;
    }

    public final String getArticleId() {
        return this.articleId;
    }

    public final String getCategory() {
        return this.category;
    }

    public final List<LibraryTag> getDisplayTags() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.tags.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            i = !(LibraryTag)item.getHidden();
        }
        return arrayList;
    }

    public final String getImage() {
        return this.image;
    }

    public final Integer getReadTimeMs() {
        return this.readTimeMs;
    }

    public final int getReadingTime() {
        return this.readingTime;
    }

    public final boolean getSeen() {
        return this.seen;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final List<LibraryTag> getTags() {
        return this.tags;
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

    public final boolean isRead() {
        return this.isRead;
    }

    public /* synthetic */ Article(String str, String str2, String str3, List list, int i, String str4, boolean z, String str5, Integer integer, boolean z2, Integer integer2, String str6, int i2, g gVar) {
        List list42;
        int i52;
        int integer92;
        int i132 = i2;
        str4 = "";
        String r1 = i132 & 1 != 0 ? str4 : str;
        String r3 = i132 & 2 != 0 ? str4 : str2;
        String r4 = i132 & 4 != 0 ? str4 : str3;
        if (i132 & 8 != 0) {
            list42 = p.g();
        } else {
            list42 = list;
        }
        i52 = 0;
        int r6 = i132 & 16 != 0 ? i52 : i;
        String r8 = str4;
        int r9 = i132 & 64 != 0 ? i52 : z;
        String r10 = i132 & 128 != 0 ? str4 : str5;
        integer92 = 0;
        int r11 = i132 & 256 != 0 ? 0 : integer;
        if (i132 & 512 == 0) {
            i52 = z2;
        }
        if (i132 & 1024 == 0) {
            integer92 = integer2;
        }
        if (i132 & 2048 == 0) {
            str4 = str6;
        }
        this(str4, str4, str4, list42, i52, str4, i52, str4, integer92, i52, integer92, str4);
    }


    public Article() {
        this(null, null, null, null, 0, null, false, null, null, false, null, null, 4095, null);
    }

    public static /* synthetic */ Article copy$default(Article article, String str, String str2, String str3, List list, int i, String str4, boolean z, String str5, Integer integer, boolean z2, Integer integer2, String str6, int i2, Object object) {
        String str132;
        String str22;
        String str32;
        String str42;
        List list52;
        int i62;
        String str72;
        boolean z82;
        String str92;
        Integer integer102;
        boolean z112;
        Integer integer122;
        Object article2 = article;
        int i142 = i2;
        String r2 = i142 & 1 != 0 ? article2.title : str;
        String r3 = i142 & 2 != 0 ? article2.articleId : str2;
        String r4 = i142 & 4 != 0 ? article2.text : str3;
        List r5 = i142 & 8 != 0 ? article2.tags : list;
        int r6 = i142 & 16 != 0 ? article2.readingTime : i;
        String r7 = i142 & 32 != 0 ? article2.image : str4;
        boolean r8 = i142 & 64 != 0 ? article2.seen : z;
        String r9 = i142 & 128 != 0 ? article2.category : str5;
        Integer r10 = i142 & 256 != 0 ? article2.sortOrder : integer;
        boolean r11 = i142 & 512 != 0 ? article2.isRead : z2;
        Integer r12 = i142 & 1024 != 0 ? article2.readTimeMs : integer2;
        String r1 = i142 & 2048 != 0 ? article2.textHtml : str6;
        return article.copy(str22, str32, str42, list52, i62, str72, z82, str92, integer102, z112, integer122, (i142 & 2048 != 0 ? article2.textHtml : str6));
    }

    /* operator */ public final String component1() {
        return this.title;
    }

    /* operator */ public final boolean component10() {
        return this.isRead;
    }

    /* operator */ public final Integer component11() {
        return this.readTimeMs;
    }

    /* operator */ public final String component12() {
        return this.textHtml;
    }

    /* operator */ public final String component2() {
        return this.articleId;
    }

    /* operator */ public final String component3() {
        return this.text;
    }

    /* operator */ public final List<LibraryTag> component4() {
        return this.tags;
    }

    /* operator */ public final int component5() {
        return this.readingTime;
    }

    /* operator */ public final String component6() {
        return this.image;
    }

    /* operator */ public final boolean component7() {
        return this.seen;
    }

    /* operator */ public final String component8() {
        return this.category;
    }

    /* operator */ public final Integer component9() {
        return this.sortOrder;
    }

    public final Article copy(String title, String articleId, String text, List<LibraryTag> tags, int readingTime, String image, boolean seen, String category, Integer sortOrder, boolean isRead, Integer readTimeMs, String textHtml) {
        n.f(title, "title");
        final Object articleId2 = articleId;
        n.f(articleId2, "articleId");
        final Object text2 = text;
        n.f(text2, "text");
        final Object tags2 = tags;
        n.f(tags2, "tags");
        final Object image2 = image;
        n.f(image2, "image");
        final Object category2 = category;
        n.f(category2, "category");
        Article article = new Article(title, articleId2, text2, tags2, readingTime, image2, seen, category2, sortOrder, isRead, readTimeMs, textHtml);
        return article;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z11 = false;
        if (!(other instanceof Article)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.articleId, other.articleId)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        if (!n.b(this.tags, other.tags)) {
            return false;
        }
        if (this.readingTime != other.readingTime) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (this.seen != other.seen) {
            return false;
        }
        if (!n.b(this.category, other.category)) {
            return false;
        }
        if (!n.b(this.sortOrder, other.sortOrder)) {
            return false;
        }
        if (this.isRead != other.isRead) {
            return false;
        }
        if (!n.b(this.readTimeMs, other.readTimeMs)) {
            return false;
        }
        return !n.b(this.textHtml, other.textHtml) ? z11 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean seen2;
        int i2;
        int i = 1;
        i = 1;
        if (this.seen) {
        }
        i2 = 0;
        if (this.sortOrder == null) {
        } else {
            i2 = this.sortOrder.hashCode();
        }
        if (!(this.isRead)) {
        }
        if (this.readTimeMs == null) {
        } else {
            i2 = this.readTimeMs.hashCode();
        }
        if (this.textHtml != null) {
            i2 = this.textHtml.hashCode();
        }
        return (this.title.hashCode() * 31) + this.articleId.hashCode() * 31 + this.text.hashCode() * 31 + this.tags.hashCode() * 31 + Integer.hashCode(this.readingTime) * 31 + this.image.hashCode() * 31 + seen2 * 31 + this.category.hashCode() * 31 + i2 * 31 + i * 31 + i2 * 31 + i2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Article(title=";
        String str3 = ", articleId=";
        String str4 = ", text=";
        String str5 = ", tags=";
        String str6 = ", readingTime=";
        String str7 = ", image=";
        String str8 = ", seen=";
        String str9 = ", category=";
        String str10 = ", sortOrder=";
        String str11 = ", isRead=";
        String str12 = ", readTimeMs=";
        String str13 = ", textHtml=";
        str = str2 + this.title + str3 + this.articleId + str4 + this.text + str5 + this.tags + str6 + this.readingTime + str7 + this.image + str8 + this.seen + str9 + this.category + str10 + this.sortOrder + str11 + this.isRead + str12 + this.readTimeMs + str13 + this.textHtml + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.articleId);
        parcel.writeString(this.text);
        parcel.writeInt(this.tags.size());
        Iterator it = this.tags.iterator();
        while (it.hasNext()) {
            (LibraryTag)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.readingTime);
        parcel.writeString(this.image);
        parcel.writeInt(this.seen);
        parcel.writeString(this.category);
        int i = 0;
        int i2 = 1;
        if (this.sortOrder == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.sortOrder.intValue());
        }
        parcel.writeInt(this.isRead);
        if (this.readTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.readTimeMs.intValue());
        }
        parcel.writeString(this.textHtml);
    }
}
