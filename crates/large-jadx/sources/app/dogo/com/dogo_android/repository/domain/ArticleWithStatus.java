package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\t¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "Landroid/os/Parcelable;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "isRead", "", "(Lapp/dogo/com/dogo_android/repository/domain/Article;Z)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ArticleWithStatus implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> CREATOR;
    private final app.dogo.com.dogo_android.repository.domain.Article article;
    private final boolean isRead;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ArticleWithStatus createFromParcel(Parcel parcel) {
            int obj3;
            n.f(parcel, "parcel");
            obj3 = parcel.readInt() != 0 ? 1 : 0;
            ArticleWithStatus articleWithStatus = new ArticleWithStatus((Article)Article.CREATOR.createFromParcel(parcel), obj3);
            return articleWithStatus;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ArticleWithStatus[] newArray(int i) {
            return new ArticleWithStatus[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ArticleWithStatus.Creator creator = new ArticleWithStatus.Creator();
        ArticleWithStatus.CREATOR = creator;
    }

    public ArticleWithStatus(app.dogo.com.dogo_android.repository.domain.Article article, boolean z2) {
        n.f(article, "article");
        super();
        this.article = article;
        this.isRead = z2;
    }

    public static app.dogo.com.dogo_android.repository.domain.ArticleWithStatus copy$default(app.dogo.com.dogo_android.repository.domain.ArticleWithStatus articleWithStatus, app.dogo.com.dogo_android.repository.domain.Article article2, boolean z3, int i4, Object object5) {
        app.dogo.com.dogo_android.repository.domain.Article obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = articleWithStatus.article;
        }
        if (i4 &= 2 != 0) {
            obj2 = articleWithStatus.isRead;
        }
        return articleWithStatus.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.Article component1() {
        return this.article;
    }

    @Override // android.os.Parcelable
    public final boolean component2() {
        return this.isRead;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ArticleWithStatus copy(app.dogo.com.dogo_android.repository.domain.Article article, boolean z2) {
        n.f(article, "article");
        ArticleWithStatus articleWithStatus = new ArticleWithStatus(article, z2);
        return articleWithStatus;
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
        if (!object instanceof ArticleWithStatus) {
            return i2;
        }
        if (!n.b(this.article, object.article)) {
            return i2;
        }
        if (this.isRead != object.isRead) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.Article getArticle() {
        return this.article;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isRead;
        if (this.isRead) {
            isRead = 1;
        }
        return i2 += isRead;
    }

    @Override // android.os.Parcelable
    public final boolean isRead() {
        return this.isRead;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArticleWithStatus(article=");
        stringBuilder.append(this.article);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.isRead);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.article.writeToParcel(parcel, i2);
        parcel.writeInt(this.isRead);
    }
}
