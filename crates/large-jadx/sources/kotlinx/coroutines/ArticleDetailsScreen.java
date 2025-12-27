package app.dogo.com.dogo_android.n.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.n3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.t1;
import app.dogo.com.dogo_android.w.w0;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ArticleDetailsScreen.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "source", "", "isSpecialProgramArticle", "", "(Lapp/dogo/com/dogo_android/repository/domain/Article;Ljava/lang/String;Z)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "()Z", "getSource", "()Ljava/lang/String;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final /* data */ class ArticleDetailsScreen extends j {

    public static final Parcelable.Creator<l> CREATOR = new l$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final Article article;
    private final String b;
    private final boolean c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<l> {
        public final l a(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            ArticleDetailsScreen articleDetailsScreen = new ArticleDetailsScreen((Article)Article.CREATOR.createFromParcel(parcel), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return articleDetailsScreen;
        }

        public final l[] b(int i) {
            return new l[i];
        }
    }
    public l(Article article, String str, boolean z) {
        n.f(article, "article");
        n.f(str, "source");
        super();
        this.article = article;
        this.b = str;
        this.c = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final Article component1() {
        return this.article;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean b() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ArticleDetailsFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.dogEditBirthday.b(new EP_ArticleId(), this.article.getArticleId(), new EP_ViewSource(), this.b, new EP_IsPottyArticle(), Boolean.valueOf(this.c));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof ArticleDetailsScreen)) {
            return false;
        }
        if (!n.b(this.article, other.article)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        return this.c != other.c ? z6 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z = true;
        if (this.c) {
            int i7 = 1;
        }
        return (this.article.hashCode() * 31) + this.b.hashCode() * 31 + z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ArticleDetailsScreen(article=";
        String str3 = ", source=";
        String str5 = ", isSpecialProgramArticle=";
        str = str2 + this.article + str3 + this.b + str5 + this.c + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.article.writeToParcel(parcel, flags);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }
}
