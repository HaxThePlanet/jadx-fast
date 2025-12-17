package app.dogo.com.dogo_android.t.g0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.m1;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqDetailsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "(Lapp/dogo/com/dogo_android/repository/domain/Article;)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.t.g0.f> CREATOR;
    private final Article a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.t.g0.f> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.t.g0.f a(Parcel parcel) {
            n.f(parcel, "parcel");
            f fVar = new f((Article)Article.CREATOR.createFromParcel(parcel));
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.t.g0.f[] b(int i) {
            return new f[i];
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
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    public f(Article article) {
        n.f(article, "article");
        super();
        this.a = article;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final Article a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        e eVar = new e();
        return eVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        m1 m1Var = new m1();
        return j3.D.b(m1Var, this.a.getArticleId());
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
    }
}
