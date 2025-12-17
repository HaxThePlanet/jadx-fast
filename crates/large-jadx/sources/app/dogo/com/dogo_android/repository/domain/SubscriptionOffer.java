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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u000cR\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "Landroid/os/Parcelable;", "isFreeTrailAvailable", "", "coupon", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "list", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "(ZLapp/dogo/com/dogo_android/repository/domain/CouponDiscount;Ljava/util/List;)V", "getCoupon", "()Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "()Z", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionOffer implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SubscriptionOffer> CREATOR;
    private final app.dogo.com.dogo_android.repository.domain.CouponDiscount coupon;
    private final boolean isFreeTrailAvailable;
    private final List<DogoSkuDetails> list;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SubscriptionOffer> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SubscriptionOffer createFromParcel(Parcel parcel) {
            int i;
            int i2;
            Object fromParcel2;
            Object fromParcel;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : i2;
            if (parcel.readInt() == 0) {
                fromParcel2 = 0;
            } else {
                fromParcel2 = CouponDiscount.CREATOR.createFromParcel(parcel);
            }
            final int int3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int3);
            while (i2 != int3) {
                arrayList.add(DogoSkuDetails.CREATOR.createFromParcel(parcel));
                i2++;
            }
            SubscriptionOffer obj7 = new SubscriptionOffer(i, (CouponDiscount)fromParcel2, arrayList);
            return obj7;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SubscriptionOffer[] newArray(int i) {
            return new SubscriptionOffer[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SubscriptionOffer.Creator creator = new SubscriptionOffer.Creator();
        SubscriptionOffer.CREATOR = creator;
    }

    public SubscriptionOffer() {
        super(0, 0, 0, 7, 0);
    }

    public SubscriptionOffer(boolean z, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount2, List<DogoSkuDetails> list3) {
        n.f(list3, "list");
        super();
        this.isFreeTrailAvailable = z;
        this.coupon = couponDiscount2;
        this.list = list3;
    }

    public SubscriptionOffer(boolean z, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount2, List list3, int i4, g g5) {
        int obj1;
        int obj2;
        List obj3;
        obj1 = i4 & 1 != 0 ? 0 : obj1;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        if (i4 &= 4 != 0) {
            obj3 = p.g();
        }
        super(obj1, obj2, obj3);
    }

    public static app.dogo.com.dogo_android.repository.domain.SubscriptionOffer copy$default(app.dogo.com.dogo_android.repository.domain.SubscriptionOffer subscriptionOffer, boolean z2, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount3, List list4, int i5, Object object6) {
        boolean obj1;
        app.dogo.com.dogo_android.repository.domain.CouponDiscount obj2;
        List obj3;
        if (i5 & 1 != 0) {
            obj1 = subscriptionOffer.isFreeTrailAvailable;
        }
        if (i5 & 2 != 0) {
            obj2 = subscriptionOffer.coupon;
        }
        if (i5 &= 4 != 0) {
            obj3 = subscriptionOffer.list;
        }
        return subscriptionOffer.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final boolean component1() {
        return this.isFreeTrailAvailable;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.CouponDiscount component2() {
        return this.coupon;
    }

    public final List<DogoSkuDetails> component3() {
        return this.list;
    }

    public final app.dogo.com.dogo_android.repository.domain.SubscriptionOffer copy(boolean z, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount2, List<DogoSkuDetails> list3) {
        n.f(list3, "list");
        SubscriptionOffer subscriptionOffer = new SubscriptionOffer(z, couponDiscount2, list3);
        return subscriptionOffer;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SubscriptionOffer) {
            return i2;
        }
        if (this.isFreeTrailAvailable != object.isFreeTrailAvailable) {
            return i2;
        }
        if (!n.b(this.coupon, object.coupon)) {
            return i2;
        }
        if (!n.b(this.list, object.list)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.CouponDiscount getCoupon() {
        return this.coupon;
    }

    public final List<DogoSkuDetails> getList() {
        return this.list;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isFreeTrailAvailable;
        int i;
        if (this.isFreeTrailAvailable) {
            isFreeTrailAvailable = 1;
        }
        app.dogo.com.dogo_android.repository.domain.CouponDiscount coupon = this.coupon;
        if (coupon == null) {
            i = 0;
        } else {
            i = coupon.hashCode();
        }
        return i4 += i6;
    }

    @Override // android.os.Parcelable
    public final boolean isFreeTrailAvailable() {
        return this.isFreeTrailAvailable;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SubscriptionOffer(isFreeTrailAvailable=");
        stringBuilder.append(this.isFreeTrailAvailable);
        stringBuilder.append(", coupon=");
        stringBuilder.append(this.coupon);
        stringBuilder.append(", list=");
        stringBuilder.append(this.list);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int coupon;
        int i;
        int size;
        n.f(parcel, "out");
        parcel.writeInt(this.isFreeTrailAvailable);
        coupon = this.coupon;
        if (coupon == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            coupon.writeToParcel(parcel, i2);
        }
        List list = this.list;
        parcel.writeInt(list.size());
        Iterator iterator = list.iterator();
        for (DogoSkuDetails size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
