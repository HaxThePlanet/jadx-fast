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

/* compiled from: SpecialOfferCoupon.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 :2\u00020\u0001:\u00029:B{\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B]\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0008HÆ\u0003J\t\u0010\"\u001a\u00020\u0008HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0003Jq\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00062\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0014\u0008\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\u0008\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0008J\t\u00101\u001a\u00020\u0006HÖ\u0001J!\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001aR\u001d\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0016¨\u0006;", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "", "seen1", "", "discount", "offeringId", "", "startTimeMs", "", "endTimeMs", "offerCode", "style", "text", "", "discountText", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getDiscount", "()I", "getDiscountText", "()Ljava/util/Map;", "getEndTimeMs", "()J", "getOfferCode", "()Ljava/lang/String;", "getOfferingId", "getStartTimeMs", "getStyle", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toCouponDiscount", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "currentTime", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SpecialOfferCoupon {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final SpecialOfferCoupon.Companion INSTANCE = new SpecialOfferCoupon$Companion(0);
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
        private Companion() {
            super();
        }

        public final KSerializer<SpecialOfferCoupon> serializer() {
            return _serializer.INSTANCE;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public /* synthetic */ SpecialOfferCoupon(int i, int i2, String str, long j, long j2, String str2, String str3, Map map, Map map2, o oVar) {
        final int i3 = 255;
        if (i3 != i & 255) {
            kotlinx.serialization.internal.j.a(i, i3, _serializer.INSTANCE.getDescriptor());
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            super();
            this.discount = i2;
            this.offeringId = str;
            this.startTimeMs = j;
            this.endTimeMs = j2;
            this.offerCode = str2;
            this.style = str3;
            this.text = map;
            this.discountText = map2;
            return;
        }
    }

    public static final void write$Self(SpecialOfferCoupon self, b output, SerialDescriptor serialDesc) {
        n.f(self, "self");
        n.f(output, "output");
        n.f(serialDesc, "serialDesc");
        output.b(serialDesc, 0, self.discount);
        int i2 = 1;
        output.c(serialDesc, i2, self.offeringId);
        output.e(serialDesc, 2, self.startTimeMs);
        output.e(serialDesc, 3, self.endTimeMs);
        output.c(serialDesc, 4, self.offerCode);
        output.c(serialDesc, 5, self.style);
        p pVar = StringSerializer.a;
        output.d(serialDesc, 6, new LinkedHashMapSerializer(pVar, pVar), self.text);
        output.d(serialDesc, 7, new LinkedHashMapSerializer(pVar, pVar), self.discountText);
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

    public final CouponDiscount toCouponDiscount() {
        CouponDiscount couponDiscount = new CouponDiscount(String.valueOf(this.discount), this.offeringId, num, Long.valueOf(this.endTimeMs), false, this.text, this.discountText, this.style, 16, null);
        return couponDiscount;
    }

    public final CouponEntity toEntity(long currentTime) {
        final Object currentTime2 = this;
        CouponEntity couponEntity = new CouponEntity(currentTime2.offerCode, (long)currentTime2.discount, str, currentTime2.offeringId, currentTime2.endTimeMs - currentTime, str2, currentTime, map2, currentTime2.style, currentTime2.text, currentTime2.discountText, 0);
        return couponEntity;
    }

    public SpecialOfferCoupon(int i, String str, long j, long j2, String str2, String str3, Map<String, String> map, Map<String, String> map2) {
        n.f(str, "offeringId");
        n.f(str2, "offerCode");
        n.f(str3, "style");
        n.f(map, "text");
        n.f(map2, "discountText");
        super();
        this.discount = i;
        this.offeringId = str;
        this.startTimeMs = j;
        this.endTimeMs = j2;
        this.offerCode = str2;
        this.style = str3;
        this.text = map;
        this.discountText = map2;
    }


    public static /* synthetic */ SpecialOfferCoupon copy$default(SpecialOfferCoupon specialOfferCoupon, int i, String str, long j, long j2, String str2, String str3, Map map, Map map2, int i2, Object object) {
        Map object112;
        int i22;
        String str32;
        long j42;
        long str62;
        String map82;
        String map92;
        Map i102;
        Object specialOfferCoupon2 = specialOfferCoupon;
        i = i2;
        int r2 = i & 1 != 0 ? specialOfferCoupon2.discount : i;
        String r3 = i & 2 != 0 ? specialOfferCoupon2.offeringId : str;
        long r4 = i & 4 != 0 ? specialOfferCoupon2.startTimeMs : j;
        long r6 = i & 8 != 0 ? specialOfferCoupon2.endTimeMs : j2;
        String r8 = i & 16 != 0 ? specialOfferCoupon2.offerCode : str2;
        String r9 = i & 32 != 0 ? specialOfferCoupon2.style : str3;
        Map r10 = i & 64 != 0 ? specialOfferCoupon2.text : map;
        Map r1 = i & 128 != 0 ? specialOfferCoupon2.discountText : map2;
        return specialOfferCoupon.copy(i22, str32, j42, r15, str62, r17, map82, map92, i102, (i & 128 != 0 ? specialOfferCoupon2.discountText : map2));
    }

    /* operator */ public final int component1() {
        return this.discount;
    }

    /* operator */ public final String component2() {
        return this.offeringId;
    }

    /* operator */ public final long component3() {
        return this.startTimeMs;
    }

    /* operator */ public final long component4() {
        return this.endTimeMs;
    }

    /* operator */ public final String component5() {
        return this.offerCode;
    }

    /* operator */ public final String component6() {
        return this.style;
    }

    /* operator */ public final Map<String, String> component7() {
        return this.text;
    }

    /* operator */ public final Map<String, String> component8() {
        return this.discountText;
    }

    public final SpecialOfferCoupon copy(int discount, String offeringId, long startTimeMs, long endTimeMs, String offerCode, String style, Map<String, String> text, Map<String, String> discountText) {
        n.f(offeringId, "offeringId");
        final Object text2 = offerCode;
        n.f(text2, "offerCode");
        final Object discountText2 = style;
        n.f(discountText2, "style");
        final Object obj = text;
        n.f(obj, "text");
        final Object obj2 = discountText;
        n.f(obj2, "discountText");
        SpecialOfferCoupon specialOfferCoupon = new SpecialOfferCoupon(discount, offeringId, startTimeMs, l, endTimeMs, str6, text2, discountText2, obj, obj2);
        return specialOfferCoupon;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof SpecialOfferCoupon)) {
            return false;
        }
        if (this.discount != other.discount) {
            return false;
        }
        if (!n.b(this.offeringId, other.offeringId)) {
            return false;
        }
        if (this.startTimeMs != other.startTimeMs) {
            return false;
        }
        if (this.endTimeMs != other.endTimeMs) {
            return false;
        }
        if (!n.b(this.offerCode, other.offerCode)) {
            return false;
        }
        if (!n.b(this.style, other.style)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        return !n.b(this.discountText, other.discountText) ? z7 : z;
    }

    public int hashCode() {
        return (Integer.hashCode(this.discount) * 31) + this.offeringId.hashCode() * 31 + Long.hashCode(this.startTimeMs) * 31 + Long.hashCode(this.endTimeMs) * 31 + this.offerCode.hashCode() * 31 + this.style.hashCode() * 31 + this.text.hashCode() * 31 + this.discountText.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SpecialOfferCoupon(discount=";
        String str3 = ", offeringId=";
        String str4 = ", startTimeMs=";
        String str5 = ", endTimeMs=";
        String str6 = ", offerCode=";
        String str7 = ", style=";
        String str8 = ", text=";
        String str9 = ", discountText=";
        str = str2 + this.discount + str3 + this.offeringId + str4 + this.startTimeMs + str5 + this.endTimeMs + str6 + this.offerCode + str7 + this.style + str8 + this.text + str9 + this.discountText + 41;
        return str;
    }
}
