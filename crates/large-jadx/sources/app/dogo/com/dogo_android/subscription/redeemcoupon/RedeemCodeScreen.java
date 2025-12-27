package app.dogo.com.dogo_android.subscription.redeemcoupon;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: RedeemCodeScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "subscriptionReturnKey", "", "(Ljava/lang/String;)V", "getSubscriptionReturnKey", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RedeemCodeScreen extends e {

    public static final Parcelable.Creator<RedeemCodeScreen> CREATOR = new RedeemCodeScreen$Creator<>();
    private final String subscriptionReturnKey;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RedeemCodeScreen> {
        @Override // android.os.Parcelable$Creator
        public final RedeemCodeScreen createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new RedeemCodeScreen(parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final RedeemCodeScreen[] newArray(int i) {
            return new RedeemCodeScreen[i];
        }
    }
    public RedeemCodeScreen(String str) {
        n.f(str, "subscriptionReturnKey");
        super();
        this.subscriptionReturnKey = str;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        return new RedeemCodeDialog();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.calendar.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String getSubscriptionReturnKey() {
        return this.subscriptionReturnKey;
    }


    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.subscriptionReturnKey);
    }
}
