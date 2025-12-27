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

/* compiled from: SubscriptionBenefitsScreen.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000cJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010!\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0008\u0010\"\u001a\u00020#H\u0014J\u0008\u0010$\u001a\u00020%H\u0016J\t\u0010&\u001a\u00020\u0018HÖ\u0001J\u0013\u0010'\u001a\u00020\u00072\u0008\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0018HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "coupon", "initiatedByDogParentFlow", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLapp/dogo/com/dogo_android/repository/domain/ProfilePreview;Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;)V", "getCoupon", "()Ljava/lang/String;", "getFragmentReturnTag", "getInitiatedByDogParentFlow", "()Z", "getPreloadedOffer", "()Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SubscriptionBenefitsScreen extends j {

    public static final Parcelable.Creator<SubscriptionBenefitsScreen> CREATOR = new SubscriptionBenefitsScreen$Creator<>();
    private final String coupon;
    private final String fragmentReturnTag;
    private final boolean initiatedByDogParentFlow;
    private final SubscriptionOffer preloadedOffer;
    private final ProfilePreview profilePreview;
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionBenefitsScreen> {
        @Override // android.os.Parcelable$Creator
        public final SubscriptionBenefitsScreen createFromParcel(Parcel parcel) {
            int i = 0;
            Object fromParcel;
            int i2 = 0;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            i2 = 0;
            if (parcel.readInt() == 0) {
            } else {
                fromParcel = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0) {
                Object fromParcel2 = SubscriptionOffer.CREATOR.createFromParcel(parcel);
            }
            SubscriptionBenefitsScreen subscriptionBenefitsScreen = new SubscriptionBenefitsScreen(parcel.readString(), parcel.readString(), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0), (ProfilePreview)fromParcel, (SubscriptionOffer)i2);
            return subscriptionBenefitsScreen;
        }

        @Override // android.os.Parcelable$Creator
        public final SubscriptionBenefitsScreen[] newArray(int i) {
            return new SubscriptionBenefitsScreen[i];
        }
    }
    public /* synthetic */ SubscriptionBenefitsScreen(String str, String str2, String str3, boolean z, ProfilePreview profilePreview, SubscriptionOffer subscriptionOffer, int i, g gVar) {
        ProfilePreview profilePreview52;
        SubscriptionOffer subscriptionOffer62;
        String str32;
        str32 = i & 4 != 0 ? "" : str32;
        if (i & 8 != 0) {
            i = 0;
        }
        int z42 = 0;
        int r5 = i & 16 != 0 ? z42 : profilePreview;
        int r6 = i & 32 != 0 ? z42 : subscriptionOffer;
        this(str, str2, str32, i, profilePreview52, (i & 32 != 0 ? z42 : subscriptionOffer));
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new SubscriptionBenefitsFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.subscriptionScreen.c(u.a(new EP_ViewSource(), this.source));
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

    public SubscriptionBenefitsScreen(String str, String str2, String str3, boolean z, ProfilePreview profilePreview, SubscriptionOffer subscriptionOffer) {
        n.f(str, "source");
        n.f(str2, "fragmentReturnTag");
        n.f(str3, "coupon");
        super();
        this.source = str;
        this.fragmentReturnTag = str2;
        this.coupon = str3;
        this.initiatedByDogParentFlow = z;
        this.profilePreview = profilePreview;
        this.preloadedOffer = subscriptionOffer;
    }


    public static /* synthetic */ SubscriptionBenefitsScreen copy$default(SubscriptionBenefitsScreen subscriptionBenefitsScreen, String str, String str2, String str3, boolean z, ProfilePreview profilePreview, SubscriptionOffer subscriptionOffer, int i, Object object) {
        String str22;
        String object92;
        String str42;
        boolean z52;
        ProfilePreview profilePreview62;
        SubscriptionOffer subscriptionOffer72;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
            object92 = subscriptionBenefitsScreen.getFragmentReturnTag();
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        if (i & 32 != 0) {
        }
        return subscriptionBenefitsScreen.copy(str22, object92, str42, z52, profilePreview62, subscriptionOffer72);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final String component1() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final String component2() {
        return getFragmentReturnTag();
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final String component3() {
        return this.coupon;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final boolean component4() {
        return this.initiatedByDogParentFlow;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final ProfilePreview component5() {
        return this.profilePreview;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final SubscriptionOffer component6() {
        return this.preloadedOffer;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final SubscriptionBenefitsScreen copy(String source, String fragmentReturnTag, String coupon, boolean initiatedByDogParentFlow, ProfilePreview profilePreview, SubscriptionOffer preloadedOffer) {
        n.f(source, "source");
        n.f(fragmentReturnTag, "fragmentReturnTag");
        n.f(coupon, "coupon");
        SubscriptionBenefitsScreen subscriptionBenefitsScreen = new SubscriptionBenefitsScreen(source, fragmentReturnTag, coupon, initiatedByDogParentFlow, profilePreview, preloadedOffer);
        return subscriptionBenefitsScreen;
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
        final boolean z7 = false;
        if (!(other instanceof SubscriptionBenefitsScreen)) {
            return false;
        }
        if (!n.b(this.source, other.source)) {
            return false;
        }
        if (!n.b(getFragmentReturnTag(), other.getFragmentReturnTag())) {
            return false;
        }
        if (!n.b(this.coupon, other.coupon)) {
            return false;
        }
        if (this.initiatedByDogParentFlow != other.initiatedByDogParentFlow) {
            return false;
        }
        if (n.b(this.profilePreview, other.profilePreview) == null) {
            return false;
        }
        return !n.b(this.preloadedOffer, other.preloadedOffer) ? z7 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean initiatedByDogParentFlow2 = true;
        int i;
        if (this.initiatedByDogParentFlow) {
            int i15 = 1;
        }
        i = 0;
        if (this.profilePreview == null) {
        } else {
            i = this.profilePreview.hashCode();
        }
        if (this.preloadedOffer != null) {
            i = this.preloadedOffer.hashCode();
        }
        return (this.source.hashCode() * 31) + getFragmentReturnTag().hashCode() * 31 + this.coupon.hashCode() * 31 + initiatedByDogParentFlow2 * 31 + i * 31 + i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SubscriptionBenefitsScreen(source=";
        String str3 = ", fragmentReturnTag=";
        String fragmentReturnTag = getFragmentReturnTag();
        String str4 = ", coupon=";
        String str5 = ", initiatedByDogParentFlow=";
        String str6 = ", profilePreview=";
        String str7 = ", preloadedOffer=";
        str = str2 + this.source + str3 + fragmentReturnTag + str4 + this.coupon + str5 + this.initiatedByDogParentFlow + str6 + this.profilePreview + str7 + this.preloadedOffer + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.coupon);
        parcel.writeInt(this.initiatedByDogParentFlow);
        final int i = 0;
        final int i2 = 1;
        if (this.profilePreview == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            this.profilePreview.writeToParcel(parcel, flags);
        }
        if (this.preloadedOffer == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            this.preloadedOffer.writeToParcel(parcel, flags);
        }
    }
}
