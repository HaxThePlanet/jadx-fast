package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ArticleWithStatus.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\t¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "Landroid/os/Parcelable;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "isRead", "", "(Lapp/dogo/com/dogo_android/repository/domain/Article;Z)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ArticleWithStatus implements Parcelable {

    public static final Parcelable.Creator<ArticleWithStatus> CREATOR = new ArticleWithStatus$Creator<>();
    private final Article article;
    private final boolean isRead;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ArticleWithStatus> {
        @Override // android.os.Parcelable$Creator
        public final ArticleWithStatus createFromParcel(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            ArticleWithStatus articleWithStatus = new ArticleWithStatus((Article)Article.CREATOR.createFromParcel(parcel), (parcel.readInt() != 0 ? 1 : 0));
            return articleWithStatus;
        }

        @Override // android.os.Parcelable$Creator
        public final ArticleWithStatus[] newArray(int i) {
            return new ArticleWithStatus[i];
        }
    }
    public ArticleWithStatus(Article article, boolean z) {
        n.f(article, "article");
        super();
        this.article = article;
        this.isRead = z;
    }

    public final Article getArticle() {
        return this.article;
    }

    public final boolean isRead() {
        return this.isRead;
    }


    public static /* synthetic */ ArticleWithStatus copy$default(ArticleWithStatus articleWithStatus, Article article, boolean z, int i, Object object) {
        app.dogo.com.dogo_android.repository.domain.Article article22;
        boolean isRead2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return articleWithStatus.copy(article22, isRead2);
    }

    /* operator */ public final Article component1() {
        return this.article;
    }

    /* operator */ public final boolean component2() {
        return this.isRead;
    }

    public final ArticleWithStatus copy(Article article, boolean isRead) {
        n.f(article, "article");
        return new ArticleWithStatus(article, isRead);
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
        final boolean z4 = false;
        if (!(other instanceof ArticleWithStatus)) {
            return false;
        }
        if (!n.b(this.article, other.article)) {
            return false;
        }
        return this.isRead != other.isRead ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isRead2 = true;
        if (this.isRead) {
            int i4 = 1;
        }
        return (this.article.hashCode() * 31) + isRead2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ArticleWithStatus(article=";
        String str3 = ", isRead=";
        str = str2 + this.article + str3 + this.isRead + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.article.writeToParcel(parcel, flags);
        parcel.writeInt(this.isRead);
    }
}
