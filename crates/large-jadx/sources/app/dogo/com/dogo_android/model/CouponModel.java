package app.dogo.com.dogo_android.model;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B5\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\n¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/model/CouponModel;", "", "discount", "", "offerDurationMs", "offeringId", "", "couponId", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getCouponId", "()Ljava/lang/String;", "setCouponId", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOfferDurationMs", "getOfferingId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/com/dogo_android/model/CouponModel;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CouponModel {

    private String couponId;
    private final Long discount;
    private final Long offerDurationMs;
    private final String offeringId;
    public CouponModel() {
        super(0, 0, 0, 0, 15, 0);
    }

    public CouponModel(Long long, Long long2, String string3, String string4) {
        super();
        this.discount = long;
        this.offerDurationMs = long2;
        this.offeringId = string3;
        this.couponId = string4;
    }

    public CouponModel(Long long, Long long2, String string3, String string4, int i5, g g6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public static app.dogo.com.dogo_android.model.CouponModel copy$default(app.dogo.com.dogo_android.model.CouponModel couponModel, Long long2, Long long3, String string4, String string5, int i6, Object object7) {
        Long obj1;
        Long obj2;
        String obj3;
        String obj4;
        if (i6 & 1 != 0) {
            obj1 = couponModel.discount;
        }
        if (i6 & 2 != 0) {
            obj2 = couponModel.offerDurationMs;
        }
        if (i6 & 4 != 0) {
            obj3 = couponModel.offeringId;
        }
        if (i6 &= 8 != 0) {
            obj4 = couponModel.couponId;
        }
        return couponModel.copy(obj1, obj2, obj3, obj4);
    }

    public final Long component1() {
        return this.discount;
    }

    public final Long component2() {
        return this.offerDurationMs;
    }

    public final String component3() {
        return this.offeringId;
    }

    public final String component4() {
        return this.couponId;
    }

    public final app.dogo.com.dogo_android.model.CouponModel copy(Long long, Long long2, String string3, String string4) {
        CouponModel couponModel = new CouponModel(long, long2, string3, string4);
        return couponModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CouponModel) {
            return i2;
        }
        if (!n.b(this.discount, object.discount)) {
            return i2;
        }
        if (!n.b(this.offerDurationMs, object.offerDurationMs)) {
            return i2;
        }
        if (!n.b(this.offeringId, object.offeringId)) {
            return i2;
        }
        if (!n.b(this.couponId, object.couponId)) {
            return i2;
        }
        return i;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final Long getDiscount() {
        return this.discount;
    }

    public final Long getOfferDurationMs() {
        return this.offerDurationMs;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public int hashCode() {
        int i3;
        int i4;
        int i;
        int i2;
        Long discount = this.discount;
        i4 = 0;
        if (discount == null) {
            i3 = i4;
        } else {
            i3 = discount.hashCode();
        }
        Long offerDurationMs = this.offerDurationMs;
        if (offerDurationMs == null) {
            i = i4;
        } else {
            i = offerDurationMs.hashCode();
        }
        String offeringId = this.offeringId;
        if (offeringId == null) {
            i2 = i4;
        } else {
            i2 = offeringId.hashCode();
        }
        String couponId = this.couponId;
        if (couponId == null) {
        } else {
            i4 = couponId.hashCode();
        }
        return i9 += i4;
    }

    public final void setCouponId(String string) {
        this.couponId = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CouponModel(discount=");
        stringBuilder.append(this.discount);
        stringBuilder.append(", offerDurationMs=");
        stringBuilder.append(this.offerDurationMs);
        stringBuilder.append(", offeringId=");
        stringBuilder.append(this.offeringId);
        stringBuilder.append(", couponId=");
        stringBuilder.append(this.couponId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
