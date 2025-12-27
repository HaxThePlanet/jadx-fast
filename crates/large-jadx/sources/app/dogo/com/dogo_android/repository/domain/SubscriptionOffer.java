package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: SubscriptionOffer.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u000cR\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "Landroid/os/Parcelable;", "isFreeTrailAvailable", "", "coupon", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "list", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "(ZLapp/dogo/com/dogo_android/repository/domain/CouponDiscount;Ljava/util/List;)V", "getCoupon", "()Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "()Z", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SubscriptionOffer implements Parcelable {

    public static final Parcelable.Creator<SubscriptionOffer> CREATOR = new SubscriptionOffer$Creator<>();
    private final CouponDiscount coupon;
    private final boolean isFreeTrailAvailable;
    private final List<DogoSkuDetails> list;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionOffer> {
        @Override // android.os.Parcelable$Creator
        public final SubscriptionOffer createFromParcel(Parcel parcel) {
            boolean z = true;
            int i = 0;
            app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount = null;
            n.f(parcel, "parcel");
            i = 0;
            int r0 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                Object fromParcel2 = CouponDiscount.CREATOR.createFromParcel(parcel);
            }
            final int _int3 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int3);
            while (i != _int3) {
                arrayList.add(DogoSkuDetails.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new SubscriptionOffer(z, (CouponDiscount)couponDiscount, arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final SubscriptionOffer[] newArray(int i) {
            return new SubscriptionOffer[i];
        }
    }
    public SubscriptionOffer(boolean z, CouponDiscount couponDiscount, List<DogoSkuDetails> list) {
        n.f(list, "list");
        super();
        this.isFreeTrailAvailable = z;
        this.coupon = couponDiscount;
        this.list = list;
    }

    public final CouponDiscount getCoupon() {
        return this.coupon;
    }

    public final List<DogoSkuDetails> getList() {
        return this.list;
    }

    public final boolean isFreeTrailAvailable() {
        return this.isFreeTrailAvailable;
    }

    public /* synthetic */ SubscriptionOffer(boolean z, CouponDiscount couponDiscount, List list, int i, g gVar) {
        boolean z2 = false;
        i = i & 1 != 0 ? 0 : i;
        int i2 = i & 2 != 0 ? 0 : i2;
        if (i & 4 != 0) {
            list = p.g();
        }
        this(z2, couponDiscount, list);
    }


    public SubscriptionOffer() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ SubscriptionOffer copy$default(SubscriptionOffer subscriptionOffer, boolean z, CouponDiscount couponDiscount, List list, int i, Object object) {
        boolean isFreeTrailAvailable2;
        app.dogo.com.dogo_android.repository.domain.CouponDiscount coupon2;
        List list2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return subscriptionOffer.copy(isFreeTrailAvailable2, coupon2, list2);
    }

    /* operator */ public final boolean component1() {
        return this.isFreeTrailAvailable;
    }

    /* operator */ public final CouponDiscount component2() {
        return this.coupon;
    }

    /* operator */ public final List<DogoSkuDetails> component3() {
        return this.list;
    }

    public final SubscriptionOffer copy(boolean isFreeTrailAvailable, CouponDiscount coupon, List<DogoSkuDetails> list) {
        n.f(list, "list");
        return new SubscriptionOffer(isFreeTrailAvailable, coupon, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof SubscriptionOffer)) {
            return false;
        }
        if (this.isFreeTrailAvailable != other.isFreeTrailAvailable) {
            return false;
        }
        if (!n.b(this.coupon, other.coupon)) {
            return false;
        }
        return !n.b(this.list, other.list) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isFreeTrailAvailable2 = true;
        int i = 0;
        if (this.isFreeTrailAvailable) {
            int i2 = 1;
        }
        if (this.coupon == null) {
            i = 0;
        } else {
            i = this.coupon.hashCode();
        }
        return (isFreeTrailAvailable2 * 31) + i * 31 + this.list.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SubscriptionOffer(isFreeTrailAvailable=";
        String str3 = ", coupon=";
        String str4 = ", list=";
        str = str2 + this.isFreeTrailAvailable + str3 + this.coupon + str4 + this.list + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.isFreeTrailAvailable);
        if (this.coupon == null) {
            int i = 0;
            parcel.writeInt(i);
        } else {
            int i2 = 1;
            parcel.writeInt(i2);
            this.coupon.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.list.size());
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            (DogoSkuDetails)it.next().writeToParcel(parcel, flags);
        }
    }
}
