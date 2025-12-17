package app.dogo.com.dogo_android.subscription.benefits;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
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
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000cJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010!\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0008\u0010\"\u001a\u00020#H\u0014J\u0008\u0010$\u001a\u00020%H\u0016J\t\u0010&\u001a\u00020\u0018HÖ\u0001J\u0013\u0010'\u001a\u00020\u00072\u0008\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0018HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "coupon", "initiatedByDogParentFlow", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLapp/dogo/com/dogo_android/repository/domain/ProfilePreview;Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;)V", "getCoupon", "()Ljava/lang/String;", "getFragmentReturnTag", "getInitiatedByDogParentFlow", "()Z", "getPreloadedOffer", "()Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionBenefitsScreen extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen> CREATOR;
    private final String coupon;
    private final String fragmentReturnTag;
    private final boolean initiatedByDogParentFlow;
    private final SubscriptionOffer preloadedOffer;
    private final ProfilePreview profilePreview;
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            int cREATOR;
            int fromParcel2;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                fromParcel = fromParcel2;
            } else {
                fromParcel = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() == 0) {
            } else {
                fromParcel2 = SubscriptionOffer.CREATOR.createFromParcel(parcel);
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), i, (ProfilePreview)fromParcel, (SubscriptionOffer)fromParcel2);
            return subscriptionBenefitsScreen;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen[] newArray(int i) {
            return new SubscriptionBenefitsScreen[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SubscriptionBenefitsScreen.Creator creator = new SubscriptionBenefitsScreen.Creator();
        SubscriptionBenefitsScreen.CREATOR = creator;
    }

    public SubscriptionBenefitsScreen(String string, String string2, String string3, boolean z4, ProfilePreview profilePreview5, SubscriptionOffer subscriptionOffer6) {
        n.f(string, "source");
        n.f(string2, "fragmentReturnTag");
        n.f(string3, "coupon");
        super();
        this.source = string;
        this.fragmentReturnTag = string2;
        this.coupon = string3;
        this.initiatedByDogParentFlow = z4;
        this.profilePreview = profilePreview5;
        this.preloadedOffer = subscriptionOffer6;
    }

    public SubscriptionBenefitsScreen(String string, String string2, String string3, boolean z4, ProfilePreview profilePreview5, SubscriptionOffer subscriptionOffer6, int i7, g g8) {
        int i;
        int i2;
        String obj10;
        int obj11;
        obj10 = i7 & 4 != 0 ? "" : obj10;
        obj11 = i7 & 8 != 0 ? 0 : obj11;
        obj11 = 0;
        i = i7 & 16 != 0 ? obj11 : profilePreview5;
        i2 = i7 & 32 != 0 ? obj11 : subscriptionOffer6;
        super(string, string2, obj10, obj11, i, i2);
    }

    public static app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen copy$default(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen subscriptionBenefitsScreen, String string2, String string3, String string4, boolean z5, ProfilePreview profilePreview6, SubscriptionOffer subscriptionOffer7, int i8, Object object9) {
        String obj5;
        String obj6;
        String obj7;
        boolean obj8;
        ProfilePreview obj9;
        SubscriptionOffer obj10;
        if (i8 & 1 != 0) {
            obj5 = subscriptionBenefitsScreen.source;
        }
        if (i8 & 2 != 0) {
            obj6 = subscriptionBenefitsScreen.getFragmentReturnTag();
        }
        if (i8 & 4 != 0) {
            obj7 = subscriptionBenefitsScreen.coupon;
        }
        if (i8 & 8 != 0) {
            obj8 = subscriptionBenefitsScreen.initiatedByDogParentFlow;
        }
        if (i8 & 16 != 0) {
            obj9 = subscriptionBenefitsScreen.profilePreview;
        }
        if (i8 & 32 != 0) {
            obj10 = subscriptionBenefitsScreen.preloadedOffer;
        }
        return subscriptionBenefitsScreen.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String component1() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String component2() {
        return getFragmentReturnTag();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String component3() {
        return this.coupon;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean component4() {
        return this.initiatedByDogParentFlow;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview component5() {
        return this.profilePreview;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final SubscriptionOffer component6() {
        return this.preloadedOffer;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen copy(String string, String string2, String string3, boolean z4, ProfilePreview profilePreview5, SubscriptionOffer subscriptionOffer6) {
        n.f(string, "source");
        n.f(string2, "fragmentReturnTag");
        n.f(string3, "coupon");
        super(string, string2, string3, z4, profilePreview5, subscriptionOffer6);
        return subscriptionBenefitsScreen;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        SubscriptionBenefitsFragment subscriptionBenefitsFragment = new SubscriptionBenefitsFragment();
        return subscriptionBenefitsFragment;
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
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SubscriptionBenefitsScreen) {
            return i2;
        }
        if (!n.b(this.source, object.source)) {
            return i2;
        }
        if (!n.b(getFragmentReturnTag(), (SubscriptionBenefitsScreen)object.getFragmentReturnTag())) {
            return i2;
        }
        if (!n.b(this.coupon, object.coupon)) {
            return i2;
        }
        if (this.initiatedByDogParentFlow != object.initiatedByDogParentFlow) {
            return i2;
        }
        if (n.b(this.profilePreview, object.profilePreview) == null) {
            return i2;
        }
        if (!n.b(this.preloadedOffer, object.preloadedOffer)) {
            return i2;
        }
        return i;
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
    public final boolean getInitiatedByDogParentFlow() {
        return this.initiatedByDogParentFlow;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final SubscriptionOffer getPreloadedOffer() {
        return this.preloadedOffer;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview getProfilePreview() {
        return this.profilePreview;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String getSource() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean initiatedByDogParentFlow;
        int i;
        int i2;
        if (this.initiatedByDogParentFlow) {
            initiatedByDogParentFlow = 1;
        }
        ProfilePreview profilePreview = this.profilePreview;
        if (profilePreview == null) {
            i = i2;
        } else {
            i = profilePreview.hashCode();
        }
        SubscriptionOffer preloadedOffer = this.preloadedOffer;
        if (preloadedOffer == null) {
        } else {
            i2 = preloadedOffer.hashCode();
        }
        return i12 += i2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SubscriptionBenefitsScreen(source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", fragmentReturnTag=");
        stringBuilder.append(getFragmentReturnTag());
        stringBuilder.append(", coupon=");
        stringBuilder.append(this.coupon);
        stringBuilder.append(", initiatedByDogParentFlow=");
        stringBuilder.append(this.initiatedByDogParentFlow);
        stringBuilder.append(", profilePreview=");
        stringBuilder.append(this.profilePreview);
        stringBuilder.append(", preloadedOffer=");
        stringBuilder.append(this.preloadedOffer);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.coupon);
        parcel.writeInt(this.initiatedByDogParentFlow);
        ProfilePreview profilePreview = this.profilePreview;
        final int i = 0;
        final int i3 = 1;
        if (profilePreview == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            profilePreview.writeToParcel(parcel, i2);
        }
        SubscriptionOffer preloadedOffer = this.preloadedOffer;
        if (preloadedOffer == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            preloadedOffer.writeToParcel(parcel, i2);
        }
    }
}
