package app.dogo.android.persistencedb.room.entity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 -2\u00020\u0001:\u0001-Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0014\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0016\u0008\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020\u000e2\u0008\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\u0006\u0010+\u001a\u00020\u000eJ\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0011R\u001f\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006.", d2 = {"Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "", "couponId", "", "discount", "", "offeringId", "offerDurationMs", "activationTimeMs", "style", "offerText", "", "discountText", "welcomeOffer", "", "(Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Z)V", "getActivationTimeMs", "()J", "getCouponId", "()Ljava/lang/String;", "getDiscount", "getDiscountText", "()Ljava/util/Map;", "getOfferDurationMs", "getOfferText", "getOfferingId", "getStyle", "getWelcomeOffer", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "isEmpty", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CouponEntity {

    public static final app.dogo.android.persistencedb.room.entity.CouponEntity.Companion Companion;
    private final long activationTimeMs;
    private final String couponId;
    private final long discount;
    private final Map<String, String> discountText;
    private final long offerDurationMs;
    private final Map<String, String> offerText;
    private final String offeringId;
    private final String style;
    private final boolean welcomeOffer;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/android/persistencedb/room/entity/CouponEntity$Companion;", "", "()V", "createEmptyObject", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.android.persistencedb.room.entity.CouponEntity createEmptyObject() {
            super("", 0, obj3, "", 0, obj6, 0, obj8, "", j0.h(), j0.h(), 0);
            return couponEntity2;
        }
    }
    static {
        CouponEntity.Companion companion = new CouponEntity.Companion(0);
        CouponEntity.Companion = companion;
    }

    public CouponEntity(String string, long l2, String string3, long l4, long l5, String string6, Map<String, String> map7, Map<String, String> map8, boolean z9) {
        n.f(string, "couponId");
        n.f(l4, "offeringId");
        n.f(z9, "style");
        super();
        this.couponId = string;
        this.discount = l2;
        this.offeringId = l4;
        this.offerDurationMs = l5;
        this.activationTimeMs = map7;
        this.style = z9;
        this.offerText = obj11;
        this.discountText = obj12;
        this.welcomeOffer = obj13;
    }

    public static app.dogo.android.persistencedb.room.entity.CouponEntity copy$default(app.dogo.android.persistencedb.room.entity.CouponEntity couponEntity, String string2, long l3, String string4, long l5, long l6, String string7, Map map8, Map map9, boolean z10, int i11, Object object12) {
        boolean welcomeOffer;
        String couponId;
        long discount;
        String offeringId;
        long offerDurationMs;
        long activationTimeMs;
        String style;
        Map offerText;
        Map discountText;
        Object obj = couponEntity;
        int i = obj26;
        couponId = i & 1 != 0 ? obj.couponId : string2;
        discount = i & 2 != 0 ? obj.discount : l3;
        offeringId = i & 4 != 0 ? obj.offeringId : l5;
        offerDurationMs = i & 8 != 0 ? obj.offerDurationMs : l6;
        activationTimeMs = i & 16 != 0 ? obj.activationTimeMs : map8;
        style = i & 32 != 0 ? obj.style : z10;
        offerText = i & 64 != 0 ? obj.offerText : i11;
        discountText = i & 128 != 0 ? obj.discountText : object12;
        welcomeOffer = i &= 256 != 0 ? obj.welcomeOffer : obj25;
        return couponEntity.copy(couponId, discount, string4, offeringId, offerDurationMs, string7, activationTimeMs, map9, style);
    }

    public final String component1() {
        return this.couponId;
    }

    public final long component2() {
        return this.discount;
    }

    public final String component3() {
        return this.offeringId;
    }

    public final long component4() {
        return this.offerDurationMs;
    }

    public final long component5() {
        return this.activationTimeMs;
    }

    public final String component6() {
        return this.style;
    }

    public final Map<String, String> component7() {
        return this.offerText;
    }

    public final Map<String, String> component8() {
        return this.discountText;
    }

    public final boolean component9() {
        return this.welcomeOffer;
    }

    public final app.dogo.android.persistencedb.room.entity.CouponEntity copy(String string, long l2, String string3, long l4, long l5, String string6, Map<String, String> map7, Map<String, String> map8, boolean z9) {
        n.f(string, "couponId");
        final Object obj = l4;
        n.f(obj, "offeringId");
        final Object obj2 = z9;
        n.f(obj2, "style");
        super(string, l2, obj4, obj, l5, obj7, map7, obj9, obj2, obj24, obj25, obj26);
        return couponEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CouponEntity) {
            return i2;
        }
        if (!n.b(this.couponId, object.couponId)) {
            return i2;
        }
        if (Long.compare(discount, discount2) != 0) {
            return i2;
        }
        if (!n.b(this.offeringId, object.offeringId)) {
            return i2;
        }
        if (Long.compare(offerDurationMs, offerDurationMs2) != 0) {
            return i2;
        }
        if (Long.compare(activationTimeMs, activationTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.style, object.style)) {
            return i2;
        }
        if (!n.b(this.offerText, object.offerText)) {
            return i2;
        }
        if (!n.b(this.discountText, object.discountText)) {
            return i2;
        }
        if (this.welcomeOffer != object.welcomeOffer) {
            return i2;
        }
        return i;
    }

    public final long getActivationTimeMs() {
        return this.activationTimeMs;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final long getDiscount() {
        return this.discount;
    }

    public final Map<String, String> getDiscountText() {
        return this.discountText;
    }

    public final long getOfferDurationMs() {
        return this.offerDurationMs;
    }

    public final Map<String, String> getOfferText() {
        return this.offerText;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final String getStyle() {
        return this.style;
    }

    public final boolean getWelcomeOffer() {
        return this.welcomeOffer;
    }

    public int hashCode() {
        int i2;
        boolean welcomeOffer;
        int i;
        Map offerText = this.offerText;
        if (offerText == null) {
            i2 = i;
        } else {
            i2 = offerText.hashCode();
        }
        Map discountText = this.discountText;
        if (discountText == null) {
        } else {
            i = discountText.hashCode();
        }
        if (this.welcomeOffer) {
            welcomeOffer = 1;
        }
        return i18 += welcomeOffer;
    }

    public final boolean isEmpty() {
        return l.z(this.couponId);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CouponEntity(couponId=");
        stringBuilder.append(this.couponId);
        stringBuilder.append(", discount=");
        stringBuilder.append(this.discount);
        stringBuilder.append(", offeringId=");
        stringBuilder.append(this.offeringId);
        stringBuilder.append(", offerDurationMs=");
        stringBuilder.append(this.offerDurationMs);
        stringBuilder.append(", activationTimeMs=");
        stringBuilder.append(this.activationTimeMs);
        stringBuilder.append(", style=");
        stringBuilder.append(this.style);
        stringBuilder.append(", offerText=");
        stringBuilder.append(this.offerText);
        stringBuilder.append(", discountText=");
        stringBuilder.append(this.discountText);
        stringBuilder.append(", welcomeOffer=");
        stringBuilder.append(this.welcomeOffer);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
