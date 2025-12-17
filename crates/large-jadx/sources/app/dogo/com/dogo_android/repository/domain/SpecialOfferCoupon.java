package app.dogo.com.dogo_android.repository.domain;

import app.dogo.android.persistencedb.room.entity.CouponEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.c.e;
import kotlinx.serialization.c.j;
import kotlinx.serialization.c.o;
import kotlinx.serialization.c.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.b;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 :2\u00020\u0001:\u00029:B{\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B]\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0008HÆ\u0003J\t\u0010\"\u001a\u00020\u0008HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0003Jq\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00062\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0014\u0008\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\u0008\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0008J\t\u00101\u001a\u00020\u0006HÖ\u0001J!\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001aR\u001d\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0016¨\u0006;", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "", "seen1", "", "discount", "offeringId", "", "startTimeMs", "", "endTimeMs", "offerCode", "style", "text", "", "discountText", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getDiscount", "()I", "getDiscountText", "()Ljava/util/Map;", "getEndTimeMs", "()J", "getOfferCode", "()Ljava/lang/String;", "getOfferingId", "getStartTimeMs", "getStyle", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toCouponDiscount", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "currentTime", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SpecialOfferCoupon {

    public static final app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon.Companion Companion;
    private final int discount;
    private final Map<String, String> discountText;
    private final long endTimeMs;
    private final String offerCode;
    private final String offeringId;
    private final long startTimeMs;
    private final String style;
    private final Map<String, String> text;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final KSerializer<app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon> serializer() {
            return SpecialOfferCoupon$$serializer.INSTANCE;
        }
    }
    static {
        SpecialOfferCoupon.Companion companion = new SpecialOfferCoupon.Companion(0);
        SpecialOfferCoupon.Companion = companion;
    }

    public SpecialOfferCoupon(int i, int i2, String string3, long l4, long l5, String string6, String string7, Map map8, Map map9, o o10) {
        final int i3 = 255;
        if (i3 != i & 255) {
        } else {
            super();
            this.discount = i2;
            this.offeringId = string3;
            this.startTimeMs = l4;
            this.endTimeMs = string6;
            this.offerCode = map8;
            this.style = map9;
            this.text = o10;
            this.discountText = obj12;
        }
        j.a(i, i3, SpecialOfferCoupon$$serializer.INSTANCE.getDescriptor());
        throw 0;
    }

    public SpecialOfferCoupon(int i, String string2, long l3, long l4, String string5, String string6, Map<String, String> map7, Map<String, String> map8) {
        n.f(string2, "offeringId");
        n.f(map7, "offerCode");
        n.f(map8, "style");
        n.f(obj10, "text");
        n.f(obj11, "discountText");
        super();
        this.discount = i;
        this.offeringId = string2;
        this.startTimeMs = l3;
        this.endTimeMs = string5;
        this.offerCode = map7;
        this.style = map8;
        this.text = obj10;
        this.discountText = obj11;
    }

    public static app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon copy$default(app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon specialOfferCoupon, int i2, String string3, long l4, long l5, String string6, String string7, Map map8, Map map9, int i10, Object object11) {
        Map discountText;
        int discount;
        String offeringId;
        long startTimeMs;
        long endTimeMs;
        String offerCode;
        String style;
        Map text;
        Object obj = specialOfferCoupon;
        int i = obj22;
        discount = i & 1 != 0 ? obj.discount : i2;
        offeringId = i & 2 != 0 ? obj.offeringId : string3;
        startTimeMs = i & 4 != 0 ? obj.startTimeMs : l4;
        endTimeMs = i & 8 != 0 ? obj.endTimeMs : string6;
        offerCode = i & 16 != 0 ? obj.offerCode : map8;
        style = i & 32 != 0 ? obj.style : map9;
        text = i & 64 != 0 ? obj.text : i10;
        discountText = i &= 128 != 0 ? obj.discountText : object11;
        return specialOfferCoupon.copy(discount, offeringId, startTimeMs, l5, endTimeMs, string7, offerCode, style);
    }

    public static final void write$Self(app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon specialOfferCoupon, b b2, SerialDescriptor serialDescriptor3) {
        n.f(specialOfferCoupon, "self");
        n.f(b2, "output");
        n.f(serialDescriptor3, "serialDesc");
        b2.b(serialDescriptor3, 0, specialOfferCoupon.discount);
        int i2 = 1;
        b2.c(serialDescriptor3, i2, specialOfferCoupon.offeringId);
        b2.e(serialDescriptor3, 2, specialOfferCoupon.startTimeMs);
        b2.e(serialDescriptor3, 3, specialOfferCoupon.endTimeMs);
        b2.c(serialDescriptor3, 4, specialOfferCoupon.offerCode);
        b2.c(serialDescriptor3, 5, specialOfferCoupon.style);
        p pVar = p.a;
        e eVar = new e(pVar, pVar);
        b2.d(serialDescriptor3, 6, eVar, specialOfferCoupon.text);
        e eVar2 = new e(pVar, pVar);
        b2.d(serialDescriptor3, 7, eVar2, specialOfferCoupon.discountText);
    }

    public final int component1() {
        return this.discount;
    }

    public final String component2() {
        return this.offeringId;
    }

    public final long component3() {
        return this.startTimeMs;
    }

    public final long component4() {
        return this.endTimeMs;
    }

    public final String component5() {
        return this.offerCode;
    }

    public final String component6() {
        return this.style;
    }

    public final Map<String, String> component7() {
        return this.text;
    }

    public final Map<String, String> component8() {
        return this.discountText;
    }

    public final app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon copy(int i, String string2, long l3, long l4, String string5, String string6, Map<String, String> map7, Map<String, String> map8) {
        n.f(string2, "offeringId");
        final Object obj = map7;
        n.f(obj, "offerCode");
        final Object obj2 = map8;
        n.f(obj2, "style");
        final Object obj3 = obj21;
        n.f(obj3, "text");
        final Object obj4 = obj22;
        n.f(obj4, "discountText");
        super(i, string2, l3, obj5, string5, obj7, obj, obj2, obj3, obj4);
        return specialOfferCoupon;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SpecialOfferCoupon) {
            return i2;
        }
        if (this.discount != object.discount) {
            return i2;
        }
        if (!n.b(this.offeringId, object.offeringId)) {
            return i2;
        }
        if (Long.compare(startTimeMs, startTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(endTimeMs, endTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.offerCode, object.offerCode)) {
            return i2;
        }
        if (!n.b(this.style, object.style)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (!n.b(this.discountText, object.discountText)) {
            return i2;
        }
        return i;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final Map<String, String> getDiscountText() {
        return this.discountText;
    }

    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    public final String getOfferCode() {
        return this.offerCode;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final String getStyle() {
        return this.style;
    }

    public final Map<String, String> getText() {
        return this.text;
    }

    public int hashCode() {
        return i14 += i22;
    }

    public final app.dogo.com.dogo_android.repository.domain.CouponDiscount toCouponDiscount() {
        super(String.valueOf(this.discount), this.offeringId, Long.valueOf(this.startTimeMs), Long.valueOf(this.endTimeMs), 0, this.text, this.discountText, this.style, 16, 0);
        return couponDiscount2;
    }

    public final CouponEntity toEntity(long l) {
        final Object obj = this;
        super(obj.offerCode, (long)discount, obj4, obj.offeringId, endTimeMs -= l, obj7, l, obj9, obj.style, obj.text, obj.discountText, 0);
        return couponEntity2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpecialOfferCoupon(discount=");
        stringBuilder.append(this.discount);
        stringBuilder.append(", offeringId=");
        stringBuilder.append(this.offeringId);
        stringBuilder.append(", startTimeMs=");
        stringBuilder.append(this.startTimeMs);
        stringBuilder.append(", endTimeMs=");
        stringBuilder.append(this.endTimeMs);
        stringBuilder.append(", offerCode=");
        stringBuilder.append(this.offerCode);
        stringBuilder.append(", style=");
        stringBuilder.append(this.style);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", discountText=");
        stringBuilder.append(this.discountText);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
