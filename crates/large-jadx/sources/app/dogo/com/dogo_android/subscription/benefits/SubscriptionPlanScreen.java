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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "showResubscribeLayout", "", "coupon", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCoupon", "()Ljava/lang/String;", "getFragmentReturnTag", "getShowResubscribeLayout", "()Z", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionPlanScreen extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen> CREATOR;
    private final String coupon;
    private final String fragmentReturnTag;
    private final boolean showResubscribeLayout;
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen createFromParcel(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            SubscriptionPlanScreen subscriptionPlanScreen = new SubscriptionPlanScreen(parcel.readString(), parcel.readString(), i, parcel.readString());
            return subscriptionPlanScreen;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen[] newArray(int i) {
            return new SubscriptionPlanScreen[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SubscriptionPlanScreen.Creator creator = new SubscriptionPlanScreen.Creator();
        SubscriptionPlanScreen.CREATOR = creator;
    }

    public SubscriptionPlanScreen(String string, String string2, boolean z3, String string4) {
        n.f(string, "source");
        n.f(string2, "fragmentReturnTag");
        n.f(string4, "coupon");
        super();
        this.source = string;
        this.fragmentReturnTag = string2;
        this.showResubscribeLayout = z3;
        this.coupon = string4;
    }

    public SubscriptionPlanScreen(String string, String string2, boolean z3, String string4, int i5, g g6) {
        String obj4;
        obj4 = i5 &= 8 != 0 ? "" : obj4;
        super(string, string2, z3, obj4);
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        SubscriptionPlanFragment subscriptionPlanFragment = new SubscriptionPlanFragment();
        return subscriptionPlanFragment;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.w0.c(u.a(r2Var, this.source));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
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

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeInt(this.showResubscribeLayout);
        parcel.writeString(this.coupon);
    }
}
