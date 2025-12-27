package app.dogo.com.dogo_android.n.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ArticleListScreen.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0008\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0008\u0010\t\u001a\u00020\nH\u0014J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "articleTag", "", "(Ljava/lang/String;)V", "getArticleTag", "()Ljava/lang/String;", "component1", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final /* data */ class ArticleListScreen extends j {

    public static final Parcelable.Creator<p> CREATOR = new p$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String articleTag;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<p> {
        public final p a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ArticleListScreen(parcel.readString());
        }

        public final p[] b(int i) {
            return new p[i];
        }
    }
    public p(String str) {
        super();
        this.articleTag = str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.articleTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ArticleListFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.dogCreationName.withoutParameters();
    }

    public /* synthetic */ p(String str, int i, g gVar) {
        String str2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(str2);
    }


    public p() {
        final String str = null;
        this(str, 1, str);
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
        final boolean z3 = false;
        if (!(other instanceof ArticleListScreen)) {
            return false;
        }
        return !n.b(this.articleTag, other.articleTag) ? z3 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i = 0;
        if (this.articleTag == null) {
            i = 0;
        } else {
            i = this.articleTag.hashCode();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ArticleListScreen(articleTag=";
        str = str2 + this.articleTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.articleTag);
    }
}
