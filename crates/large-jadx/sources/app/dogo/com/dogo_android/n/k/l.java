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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "source", "", "isSpecialProgramArticle", "", "(Lapp/dogo/com/dogo_android/repository/domain/Article;Ljava/lang/String;Z)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "()Z", "getSource", "()Ljava/lang/String;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.n.k.l> CREATOR;
    private final Article a;
    private final String b;
    private final boolean c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.n.k.l> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.k.l a(Parcel parcel) {
            int obj4;
            n.f(parcel, "parcel");
            obj4 = parcel.readInt() != 0 ? 1 : 0;
            l lVar = new l((Article)Article.CREATOR.createFromParcel(parcel), parcel.readString(), obj4);
            return lVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.k.l[] b(int i) {
            return new l[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        l.a aVar = new l.a();
        l.CREATOR = aVar;
    }

    public l(Article article, String string2, boolean z3) {
        n.f(article, "article");
        n.f(string2, "source");
        super();
        this.a = article;
        this.b = string2;
        this.c = z3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final Article a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean b() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        k kVar = new k();
        return kVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        w0 w0Var = new w0();
        r2 r2Var = new r2();
        t1 t1Var = new t1();
        return j3.T0.b(w0Var, this.a.getArticleId(), r2Var, this.b, t1Var, Boolean.valueOf(this.c));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof l) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (this.c != object.c) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z;
        if (this.c) {
            z = 1;
        }
        return i4 += z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArticleDetailsScreen(article=");
        stringBuilder.append(this.a);
        stringBuilder.append(", source=");
        stringBuilder.append(this.b);
        stringBuilder.append(", isSpecialProgramArticle=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }
}
