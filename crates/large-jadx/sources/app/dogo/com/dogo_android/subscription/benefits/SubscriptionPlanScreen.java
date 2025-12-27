package app.dogo.com.dogo_android.subscription.benefits;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;

/* compiled from: SubscriptionPlanScreen.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "showResubscribeLayout", "", "coupon", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCoupon", "()Ljava/lang/String;", "getFragmentReturnTag", "getShowResubscribeLayout", "()Z", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionPlanScreen extends j {

    public static final Parcelable.Creator<SubscriptionPlanScreen> CREATOR = new SubscriptionPlanScreen$Creator<>();
    private final String coupon;
    private final String fragmentReturnTag;
    private final boolean showResubscribeLayout;
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionPlanScreen> {
        @Override // android.os.Parcelable$Creator
        public final SubscriptionPlanScreen createFromParcel(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            int r3 = parcel.readInt() != 0 ? 1 : 0;
            SubscriptionPlanScreen subscriptionPlanScreen = new SubscriptionPlanScreen(parcel.readString(), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0), parcel.readString());
            return subscriptionPlanScreen;
        }

        @Override // android.os.Parcelable$Creator
        public final SubscriptionPlanScreen[] newArray(int i) {
            return new SubscriptionPlanScreen[i];
        }
    }
    public SubscriptionPlanScreen(String str, String str2, boolean z, String str3) {
        n.f(str, "source");
        n.f(str2, "fragmentReturnTag");
        n.f(str3, "coupon");
        super();
        this.source = str;
        this.fragmentReturnTag = str2;
        this.showResubscribeLayout = z;
        this.coupon = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new SubscriptionPlanFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.subscriptionScreen.withParameters(u.a(new EP_ViewSource(), this.source));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String getCoupon() {
        return this.coupon;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean getShowResubscribeLayout() {
        return this.showResubscribeLayout;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String getSource() {
        return this.source;
    }

    public /* synthetic */ SubscriptionPlanScreen(String str, String str2, boolean z, String str3, int i, g gVar) {
        str3 = i & 8 != 0 ? "" : str3;
        this(str, str2, z, str3);
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeInt(this.showResubscribeLayout);
        parcel.writeString(this.coupon);
    }
}
