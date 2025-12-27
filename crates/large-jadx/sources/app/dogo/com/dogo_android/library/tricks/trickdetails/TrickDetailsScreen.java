package app.dogo.com.dogo_android.n.m.u;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.u;

/* compiled from: TrickDetailsScreen.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0008\u0010\u001a\u001a\u00020\u0005H\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0018\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\n¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "fragmentReturnTag", "", "fragmentParentReturnTag", "source", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getFragmentReturnTag", "pauseTimeSec", "", "getPauseTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "getTag", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public class TrickDetailsScreen extends j {

    public static final Parcelable.Creator<m> CREATOR = new m$a<>();
    private final app.dogo.com.dogo_android.n.m.n a;
    /* renamed from: b, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private final String c;
    private final String v;
    private final Long w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<m> {
        public final m a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new TrickDetailsScreen((TrickDetailsPlan)parcel.readParcelable(TrickDetailsScreen.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final m[] b(int i) {
            return new m[i];
        }
    }
    public m(app.dogo.com.dogo_android.n.m.n nVar, String str, String str2, String str3) {
        n.f(nVar, "session");
        n.f(str, "fragmentReturnTag");
        n.f(str2, "fragmentParentReturnTag");
        n.f(str3, "source");
        super();
        this.a = nVar;
        this.fragmentReturnTag = str;
        this.c = str2;
        this.v = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public Long createFragment() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public app.dogo.com.dogo_android.n.m.n b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new TrickDetailsFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        String str = null;
        TrickItem trickItem = b().a();
        if (trickItem == null) {
            int i = 0;
        } else {
            str = trickItem.getId();
        }
        return S.setReminders.withParameters(u.a(new EP_TrickId(), str), u.a(new EP_ViewSource(), getSource()));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getSource() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getTag() {
        return S.inAppFeedback.a();
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.a, flags);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
    }
}
