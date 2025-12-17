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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008(\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0092\u0001\u00101\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r2\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\t\u00103\u001a\u00020\nHÖ\u0001J\u0013\u00104\u001a\u00020\r2\u0008\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007J\t\u00108\u001a\u00020\nHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0018R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008\u001f\u0010\u001aR\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0015R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0015¨\u0006?", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Article;", "Landroid/os/Parcelable;", "title", "", "articleId", "text", "tags", "", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "readingTime", "", "image", "seen", "", "category", "sortOrder", "isRead", "readTimeMs", "textHtml", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/String;", "getCategory", "getImage", "()Z", "getReadTimeMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReadingTime", "()I", "getSeen", "getSortOrder", "getTags", "()Ljava/util/List;", "getText", "getTextHtml", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;)Lapp/dogo/com/dogo_android/repository/domain/Article;", "describeContents", "equals", "other", "", "getDisplayTags", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Article implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.Article> CREATOR;
    private final String articleId;
    private final String category;
    private final String image;
    private final boolean isRead;
    private final Integer readTimeMs;
    private final int readingTime;
    private final boolean seen;
    private final Integer sortOrder;
    private final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> tags;
    private final String text;
    private final String textHtml;
    private final String title;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.Article> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.Article createFromParcel(Parcel parcel) {
            int i3;
            Integer valueOf;
            int i2;
            Object fromParcel;
            int valueOf2;
            int i;
            Integer num;
            Object obj = parcel;
            n.f(obj, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            int i4 = 0;
            i2 = i4;
            while (i2 != int) {
                arrayList.add(LibraryTag.CREATOR.createFromParcel(obj));
                i2++;
            }
            int i5 = 1;
            i3 = parcel.readInt() != 0 ? i5 : i4;
            int i7 = 0;
            if (parcel.readInt() == 0) {
                valueOf2 = i7;
            } else {
                valueOf2 = Integer.valueOf(parcel.readInt());
            }
            i = parcel.readInt() != 0 ? i5 : i4;
            if (parcel.readInt() == 0) {
                num = i7;
            } else {
                num = valueOf;
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), arrayList, parcel.readInt(), parcel.readString(), i3, parcel.readString(), valueOf2, i, num, parcel.readString());
            return article2;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.Article[] newArray(int i) {
            return new Article[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        Article.Creator creator = new Article.Creator();
        Article.CREATOR = creator;
    }

    public Article() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
    }

    public Article(String string, String string2, String string3, List<app.dogo.com.dogo_android.repository.domain.LibraryTag> list4, int i5, String string6, boolean z7, String string8, Integer integer9, boolean z10, Integer integer11, String string12) {
        n.f(string, "title");
        n.f(string2, "articleId");
        n.f(string3, "text");
        n.f(list4, "tags");
        n.f(string6, "image");
        n.f(string8, "category");
        super();
        this.title = string;
        this.articleId = string2;
        this.text = string3;
        this.tags = list4;
        this.readingTime = i5;
        this.image = string6;
        this.seen = z7;
        this.category = string8;
        this.sortOrder = integer9;
        this.isRead = z10;
        this.readTimeMs = integer11;
        this.textHtml = string12;
    }

    public Article(String string, String string2, String string3, List list4, int i5, String string6, boolean z7, String string8, Integer integer9, boolean z10, Integer integer11, String string12, int i13, g g14) {
        String str6;
        String str5;
        String str3;
        String str;
        List list;
        int i;
        int i4;
        String str2;
        int i2;
        String str4;
        int i3;
        int i6;
        int i7 = i13;
        str5 = "";
        str6 = i7 & 1 != 0 ? str5 : string;
        str3 = i7 & 2 != 0 ? str5 : string2;
        str = i7 & 4 != 0 ? str5 : string3;
        if (i7 & 8 != 0) {
            list = p.g();
        } else {
            list = list4;
        }
        i4 = 0;
        i = i7 & 16 != 0 ? i4 : i5;
        str2 = i7 & 32 != 0 ? str5 : string6;
        i2 = i7 & 64 != 0 ? i4 : z7;
        str4 = i7 & 128 != 0 ? str5 : string8;
        i3 = i7 & 256 != 0 ? i6 : integer9;
        if (i7 & 512 != 0) {
        } else {
            i4 = z10;
        }
        if (i7 & 1024 != 0) {
        } else {
            i6 = integer11;
        }
        if (i7 &= 2048 != 0) {
        } else {
            str5 = string12;
        }
        super(str6, str3, str, list, i, str2, i2, str4, i3, i4, i6, str5);
    }

    public static app.dogo.com.dogo_android.repository.domain.Article copy$default(app.dogo.com.dogo_android.repository.domain.Article article, String string2, String string3, String string4, List list5, int i6, String string7, boolean z8, String string9, Integer integer10, boolean z11, Integer integer12, String string13, int i14, Object object15) {
        String textHtml;
        String title;
        String articleId;
        String text;
        List tags;
        int readingTime;
        String image;
        boolean seen;
        String category;
        Integer sortOrder;
        boolean isRead;
        Integer readTimeMs;
        Object obj = article;
        int i = i14;
        title = i & 1 != 0 ? obj.title : string2;
        articleId = i & 2 != 0 ? obj.articleId : string3;
        text = i & 4 != 0 ? obj.text : string4;
        tags = i & 8 != 0 ? obj.tags : list5;
        readingTime = i & 16 != 0 ? obj.readingTime : i6;
        image = i & 32 != 0 ? obj.image : string7;
        seen = i & 64 != 0 ? obj.seen : z8;
        category = i & 128 != 0 ? obj.category : string9;
        sortOrder = i & 256 != 0 ? obj.sortOrder : integer10;
        isRead = i & 512 != 0 ? obj.isRead : z11;
        readTimeMs = i & 1024 != 0 ? obj.readTimeMs : integer12;
        textHtml = i &= 2048 != 0 ? obj.textHtml : string13;
        return article.copy(title, articleId, text, tags, readingTime, image, seen, category, sortOrder, isRead, readTimeMs, textHtml);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final boolean component10() {
        return this.isRead;
    }

    @Override // android.os.Parcelable
    public final Integer component11() {
        return this.readTimeMs;
    }

    @Override // android.os.Parcelable
    public final String component12() {
        return this.textHtml;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.articleId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.text;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> component4() {
        return this.tags;
    }

    @Override // android.os.Parcelable
    public final int component5() {
        return this.readingTime;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.image;
    }

    @Override // android.os.Parcelable
    public final boolean component7() {
        return this.seen;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.category;
    }

    @Override // android.os.Parcelable
    public final Integer component9() {
        return this.sortOrder;
    }

    public final app.dogo.com.dogo_android.repository.domain.Article copy(String string, String string2, String string3, List<app.dogo.com.dogo_android.repository.domain.LibraryTag> list4, int i5, String string6, boolean z7, String string8, Integer integer9, boolean z10, Integer integer11, String string12) {
        n.f(string, "title");
        final Object obj = string2;
        n.f(obj, "articleId");
        final Object obj2 = string3;
        n.f(obj2, "text");
        final Object obj3 = list4;
        n.f(obj3, "tags");
        final Object obj4 = string6;
        n.f(obj4, "image");
        final Object obj5 = string8;
        n.f(obj5, "category");
        super(string, obj, obj2, obj3, i5, obj4, z7, obj5, integer9, z10, integer11, string12);
        return article;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Article) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.articleId, object.articleId)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (!n.b(this.tags, object.tags)) {
            return i2;
        }
        if (this.readingTime != object.readingTime) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (this.seen != object.seen) {
            return i2;
        }
        if (!n.b(this.category, object.category)) {
            return i2;
        }
        if (!n.b(this.sortOrder, object.sortOrder)) {
            return i2;
        }
        if (this.isRead != object.isRead) {
            return i2;
        }
        if (!n.b(this.readTimeMs, object.readTimeMs)) {
            return i2;
        }
        if (!n.b(this.textHtml, object.textHtml)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getArticleId() {
        return this.articleId;
    }

    @Override // android.os.Parcelable
    public final String getCategory() {
        return this.category;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> getDisplayTags() {
        Object next;
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.tags.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (hidden ^= 1 != 0) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final String getImage() {
        return this.image;
    }

    @Override // android.os.Parcelable
    public final Integer getReadTimeMs() {
        return this.readTimeMs;
    }

    @Override // android.os.Parcelable
    public final int getReadingTime() {
        return this.readingTime;
    }

    @Override // android.os.Parcelable
    public final boolean getSeen() {
        return this.seen;
    }

    @Override // android.os.Parcelable
    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> getTags() {
        return this.tags;
    }

    @Override // android.os.Parcelable
    public final String getText() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final String getTextHtml() {
        return this.textHtml;
    }

    @Override // android.os.Parcelable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean seen;
        int i4;
        int i2;
        int i3;
        int i;
        if (this.seen) {
            seen = i3;
        }
        Integer sortOrder = this.sortOrder;
        i = 0;
        if (sortOrder == null) {
            i4 = i;
        } else {
            i4 = sortOrder.hashCode();
        }
        boolean isRead = this.isRead;
        if (isRead) {
        } else {
            i3 = isRead;
        }
        Integer readTimeMs = this.readTimeMs;
        if (readTimeMs == null) {
            i2 = i;
        } else {
            i2 = readTimeMs.hashCode();
        }
        String textHtml = this.textHtml;
        if (textHtml == null) {
        } else {
            i = textHtml.hashCode();
        }
        return i26 += i;
    }

    @Override // android.os.Parcelable
    public final boolean isRead() {
        return this.isRead;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Article(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", articleId=");
        stringBuilder.append(this.articleId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.tags);
        stringBuilder.append(", readingTime=");
        stringBuilder.append(this.readingTime);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", seen=");
        stringBuilder.append(this.seen);
        stringBuilder.append(", category=");
        stringBuilder.append(this.category);
        stringBuilder.append(", sortOrder=");
        stringBuilder.append(this.sortOrder);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.isRead);
        stringBuilder.append(", readTimeMs=");
        stringBuilder.append(this.readTimeMs);
        stringBuilder.append(", textHtml=");
        stringBuilder.append(this.textHtml);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.articleId);
        parcel.writeString(this.text);
        List tags = this.tags;
        parcel.writeInt(tags.size());
        Iterator iterator = tags.iterator();
        for (LibraryTag size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.readingTime);
        parcel.writeString(this.image);
        parcel.writeInt(this.seen);
        parcel.writeString(this.category);
        obj4 = this.sortOrder;
        int i = 0;
        int i3 = 1;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.intValue());
        }
        parcel.writeInt(this.isRead);
        obj4 = this.readTimeMs;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.intValue());
        }
        parcel.writeString(this.textHtml);
    }
}
