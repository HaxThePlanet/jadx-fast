package app.dogo.android.persistencedb.room.entity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.j0;

/* compiled from: CouponEntity.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 -2\u00020\u0001:\u0001-Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0014\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0016\u0008\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020\u000e2\u0008\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\u0006\u0010+\u001a\u00020\u000eJ\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0011R\u001f\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006.", d2 = {"Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "", "couponId", "", "discount", "", "offeringId", "offerDurationMs", "activationTimeMs", "style", "offerText", "", "discountText", "welcomeOffer", "", "(Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Z)V", "getActivationTimeMs", "()J", "getCouponId", "()Ljava/lang/String;", "getDiscount", "getDiscountText", "()Ljava/util/Map;", "getOfferDurationMs", "getOfferText", "getOfferingId", "getStyle", "getWelcomeOffer", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "isEmpty", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CouponEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final CouponEntity.Companion INSTANCE = new CouponEntity$Companion(0);
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
        private Companion() {
            super();
        }

        public final CouponEntity createEmptyObject() {
            CouponEntity couponEntity = new CouponEntity("", 0L, str2, "", 0L, str4, null, map, "", j0.h(), j0.h(), 0);
            return couponEntity;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public CouponEntity(String str, long j, String str2, long j2, long j3, String str3, Map<String, String> map, Map<String, String> map2, boolean z) {
        n.f(str, "couponId");
        n.f(str2, "offeringId");
        n.f(str3, "style");
        super();
        this.couponId = str;
        this.discount = j;
        this.offeringId = str2;
        this.offerDurationMs = j2;
        this.activationTimeMs = j3;
        this.style = str3;
        this.offerText = map;
        this.discountText = map2;
        this.welcomeOffer = z;
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

    public final boolean isEmpty() {
        return l.z(this.couponId);
    }


    public static /* synthetic */ CouponEntity copy$default(CouponEntity couponEntity, String str, long j, String str2, long j2, long j3, String str3, Map map, Map map2, boolean z, int i, Object object) {
        boolean welcomeOffer2;
        String str22;
        long j32;
        String j52;
        long j62;
        long map82;
        String z102;
        Map i112;
        Map object122;
        Object couponEntity2 = couponEntity;
        String r2 = i & 1 != 0 ? couponEntity2.couponId : str;
        long r3 = i & 2 != 0 ? couponEntity2.discount : j;
        String r5 = i & 4 != 0 ? couponEntity2.offeringId : str2;
        long r6 = i & 8 != 0 ? couponEntity2.offerDurationMs : j2;
        long r8 = i & 16 != 0 ? couponEntity2.activationTimeMs : j3;
        String r10 = i & 32 != 0 ? couponEntity2.style : str3;
        Map r11 = i & 64 != 0 ? couponEntity2.offerText : map;
        Map r12 = i & 128 != 0 ? couponEntity2.discountText : map2;
        boolean r1 = i & 256 != 0 ? couponEntity2.welcomeOffer : z;
        return couponEntity.copy(str22, j32, r16, j52, j62, r19, map82, r21, z102, i112, object122, (i & 256 != 0 ? couponEntity2.welcomeOffer : z));
    }

    /* operator */ public final String component1() {
        return this.couponId;
    }

    /* operator */ public final long component2() {
        return this.discount;
    }

    /* operator */ public final String component3() {
        return this.offeringId;
    }

    /* operator */ public final long component4() {
        return this.offerDurationMs;
    }

    /* operator */ public final long component5() {
        return this.activationTimeMs;
    }

    /* operator */ public final String component6() {
        return this.style;
    }

    /* operator */ public final Map<String, String> component7() {
        return this.offerText;
    }

    /* operator */ public final Map<String, String> component8() {
        return this.discountText;
    }

    /* operator */ public final boolean component9() {
        return this.welcomeOffer;
    }

    public final CouponEntity copy(String couponId, long discount, String offeringId, long offerDurationMs, long activationTimeMs, String style, Map<String, String> offerText, Map<String, String> discountText, boolean welcomeOffer) {
        n.f(couponId, "couponId");
        final Object offerDurationMs2 = offeringId;
        n.f(offerDurationMs2, "offeringId");
        final Object welcomeOffer2 = style;
        n.f(welcomeOffer2, "style");
        CouponEntity couponEntity = new CouponEntity(couponId, discount, str4, offerDurationMs2, offerDurationMs, str5, activationTimeMs, map, welcomeOffer2, offerText, discountText, welcomeOffer);
        return couponEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z8 = false;
        if (!(other instanceof CouponEntity)) {
            return false;
        }
        if (!n.b(this.couponId, other.couponId)) {
            return false;
        }
        if (this.discount != other.discount) {
            return false;
        }
        if (!n.b(this.offeringId, other.offeringId)) {
            return false;
        }
        if (this.offerDurationMs != other.offerDurationMs) {
            return false;
        }
        if (this.activationTimeMs != other.activationTimeMs) {
            return false;
        }
        if (!n.b(this.style, other.style)) {
            return false;
        }
        if (!n.b(this.offerText, other.offerText)) {
            return false;
        }
        if (!n.b(this.discountText, other.discountText)) {
            return false;
        }
        return this.welcomeOffer != other.welcomeOffer ? z8 : z;
    }

    public int hashCode() {
        int i;
        boolean welcomeOffer2 = true;
        i = 0;
        if (this.offerText == null) {
        } else {
            i = this.offerText.hashCode();
        }
        if (this.discountText != null) {
            i = this.discountText.hashCode();
        }
        if (this.welcomeOffer) {
            int i24 = 1;
        }
        return (this.couponId.hashCode() * 31) + Long.hashCode(this.discount) * 31 + this.offeringId.hashCode() * 31 + Long.hashCode(this.offerDurationMs) * 31 + Long.hashCode(this.activationTimeMs) * 31 + this.style.hashCode() * 31 + i * 31 + i * 31 + welcomeOffer2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CouponEntity(couponId=";
        String str3 = ", discount=";
        String str4 = ", offeringId=";
        String str5 = ", offerDurationMs=";
        String str6 = ", activationTimeMs=";
        String str7 = ", style=";
        String str8 = ", offerText=";
        String str9 = ", discountText=";
        String str10 = ", welcomeOffer=";
        str = str2 + this.couponId + str3 + this.discount + str4 + this.offeringId + str5 + this.offerDurationMs + str6 + this.activationTimeMs + str7 + this.style + str8 + this.offerText + str9 + this.discountText + str10 + this.welcomeOffer + 41;
        return str;
    }
}
