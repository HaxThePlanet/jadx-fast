package app.dogo.com.dogo_android.n.m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.w.b1;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickListScreen.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0008\u0010\u000e\u001a\u00020\u000fH\u0014J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "selectedTag", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;Ljava/lang/String;)V", "getCategory", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "getSelectedTag", "()Ljava/lang/String;", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public final /* data */ class TrickListScreen extends j {

    public static final Parcelable.Creator<q> CREATOR = new q$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final TrickItem.TrickCategory category;
    /* renamed from: b, reason: from kotlin metadata */
    private final String selectedTag;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<q> {
        public final q a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new TrickListScreen((TrickItem_TrickCategory)TrickItem_TrickCategory.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        public final q[] b(int i) {
            return new q[i];
        }
    }
    public q(TrickItem.TrickCategory trickCategory, String str) {
        n.f(trickCategory, "category");
        super();
        this.category = trickCategory;
        this.selectedTag = str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final TrickItem.TrickCategory component1() {
        return this.category;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.selectedTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new TrickListFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.dogEditName.b(new EP_CategoryId(), this.category.getId());
    }

    public /* synthetic */ q(TrickItem.TrickCategory trickCategory, String str, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(trickCategory, str);
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
        final boolean z4 = false;
        if (!(other instanceof TrickListScreen)) {
            return false;
        }
        if (!n.b(this.category, other.category)) {
            return false;
        }
        return !n.b(this.selectedTag, other.selectedTag) ? z4 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i = 0;
        if (this.selectedTag == null) {
            i = 0;
        } else {
            i = this.selectedTag.hashCode();
        }
        return (this.category.hashCode() * 31) + i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickListScreen(category=";
        String str3 = ", selectedTag=";
        str = str2 + this.category + str3 + this.selectedTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.category.writeToParcel(parcel, flags);
        parcel.writeString(this.selectedTag);
    }
}
