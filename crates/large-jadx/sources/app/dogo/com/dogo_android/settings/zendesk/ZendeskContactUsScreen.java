package app.dogo.com.dogo_android.t.i0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.a1;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.y.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.u;
import kotlin.y.p;

/* compiled from: ZendeskContactUsScreen.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0008\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0008\u0010\t\u001a\u00020\nH\u0014J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014J\t\u0010\u0015\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/settings/zendesk/ZendeskContactUsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "campaign", "", "(Ljava/lang/String;)V", "getCampaign", "()Ljava/lang/String;", "component1", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "getCustomTags", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final /* data */ class ZendeskContactUsScreen extends j {

    public static final Parcelable.Creator<a> CREATOR = new a$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String campaign;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<a> {
        public final a a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ZendeskContactUsScreen(parcel.readString());
        }

        public final a[] b(int i) {
            return new a[i];
        }
    }
    public a(String str) {
        super();
        this.campaign = str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final List<String> component1() {
        if (this.campaign != null) {
            return p.b(this.campaign);
        }
        return p.g();
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() throws kotlin.n {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) new NotImplementedError("Zendesk Activity is used");
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.G.c(u.a(new EP_CampaignName(), this.campaign));
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
        if (!(other instanceof ZendeskContactUsScreen)) {
            return false;
        }
        return !n.b(this.campaign, other.campaign) ? z3 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i = 0;
        if (this.campaign == null) {
            i = 0;
        } else {
            i = this.campaign.hashCode();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ZendeskContactUsScreen(campaign=";
        str = str2 + this.campaign + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.campaign);
    }
}
