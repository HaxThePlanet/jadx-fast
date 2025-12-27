package app.dogo.com.dogo_android.t.i0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.w0;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.u;

/* compiled from: ZendeskKnowledgeScreen.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0008\u0010\t\u001a\u00020\nH\u0014J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/settings/zendesk/ZendeskKnowledgeScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "articleId", "", "(J)V", "getArticleId", "()J", "component1", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final /* data */ class ZendeskKnowledgeScreen extends j {

    public static final Parcelable.Creator<b> CREATOR = new b$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final long articleId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<b> {
        public final b a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ZendeskKnowledgeScreen(parcel.readLong(), r2);
        }

        public final b[] b(int i) {
            return new b[i];
        }
    }
    public b(long j) {
        super();
        this.articleId = j;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final long component1() {
        return this.articleId;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() throws kotlin.n {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) new NotImplementedError("Zendesk Activity is used");
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.E.c(u.a(new EP_ArticleId(), Long.valueOf(this.articleId)));
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
        if (!(other instanceof ZendeskKnowledgeScreen)) {
            return false;
        }
        return this.articleId != other.articleId ? z3 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        return Long.hashCode(this.articleId);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ZendeskKnowledgeScreen(articleId=";
        str = str2 + this.articleId + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeLong(this.articleId);
    }
}
