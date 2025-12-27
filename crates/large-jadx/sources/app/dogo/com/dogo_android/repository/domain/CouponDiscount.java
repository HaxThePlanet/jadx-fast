package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* compiled from: CouponDiscount.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 62\u00020\u0001:\u00016Bu\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\tHÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J~\u0010$\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020'HÖ\u0001J\u0013\u0010(\u001a\u00020\t2\u0008\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\u0015\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0002\u0010-J\t\u0010.\u001a\u00020'HÖ\u0001J\u0006\u0010/\u001a\u00020\tJ\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020'HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001d\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008\u0013\u0010\u0014R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "Landroid/os/Parcelable;", "discount", "", "offeringId", "startTimeMs", "", "endTimeMs", "welcomeOffer", "", "offerText", "", "discountText", "style", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/String;", "getDiscountText", "()Ljava/util/Map;", "getEndTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOfferText", "getOfferingId", "getStartTimeMs", "getStyle", "getWelcomeOffer", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/util/Map;Ljava/util/Map;Ljava/lang/String;)Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "describeContents", "", "equals", "other", "", "getNotificationTimeMs", "currentTimeMs", "(J)Ljava/lang/Long;", "hashCode", "isEmpty", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CouponDiscount implements Parcelable {

    public static final Parcelable.Creator<CouponDiscount> CREATOR = new CouponDiscount$Creator<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final CouponDiscount.Companion INSTANCE = new CouponDiscount$Companion(0);
    private final String discount;
    private final Map<String, String> discountText;
    private final Long endTimeMs;
    private final Map<String, String> offerText;
    private final String offeringId;
    private final Long startTimeMs;
    private final String style;
    private final boolean welcomeOffer;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount$Companion;", "", "()V", "createEmptyObject", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final CouponDiscount createEmptyObject() {
            CouponDiscount couponDiscount = new CouponDiscount(null, null, null, null, false, null, null, null, 255, null);
            return couponDiscount;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CouponDiscount> {
        @Override // android.os.Parcelable$Creator
        public final CouponDiscount createFromParcel(Parcel parcel) {
            int i = 0;
            Long num2;
            Long num;
            boolean z;
            String string;
            String string2;
            n.f(parcel, "parcel");
            long l = 0L;
            if (parcel.readInt() == 0) {
                int i2 = l;
            } else {
            }
            if (parcel.readInt() == 0) {
                int i3 = l;
            } else {
            }
            i = 0;
            int _int3 = parcel.readInt() != 0 ? _int3 : i;
            int _int4 = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int4);
            while (i != _int4) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
                i = i + 1;
            }
            int _int5 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(_int5);
            string = parcel.readString();
            while (i != _int5) {
                linkedHashMap2.put(string, parcel.readString());
                i = i + 1;
                string = parcel.readString();
            }
            CouponDiscount parcel2 = new CouponDiscount(parcel.readString(), parcel.readString(), num2, num, z, linkedHashMap, linkedHashMap2, string);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final CouponDiscount[] newArray(int i) {
            return new CouponDiscount[i];
        }
    }
    public CouponDiscount(String str, String str2, Long long, Long long2, boolean z, Map<String, String> map, Map<String, String> map2, String str3) {
        n.f(map, "offerText");
        n.f(map2, "discountText");
        n.f(str3, "style");
        super();
        this.discount = str;
        this.offeringId = str2;
        this.startTimeMs = long;
        this.endTimeMs = long2;
        this.welcomeOffer = z;
        this.offerText = map;
        this.discountText = map2;
        this.style = str3;
    }

    public final String getDiscount() {
        return this.discount;
    }

    public final Map<String, String> getDiscountText() {
        return this.discountText;
    }

    public final Long getEndTimeMs() {
        return this.endTimeMs;
    }

    public final Long getNotificationTimeMs(long currentTimeMs) {
        int cmp;
        int i = 0;
        long millis;
        int i2;
        long millis2;
        final Object currentTimeMs2 = this;
        i = 0;
        return i;
    }

    public final Map<String, String> getOfferText() {
        return this.offerText;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final Long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final String getStyle() {
        return this.style;
    }

    public final boolean getWelcomeOffer() {
        return this.welcomeOffer;
    }

    public final boolean isEmpty() {
        boolean z = true;
        int r0 = this.offeringId == null ? 1 : 0;
        return (this.offeringId == null ? 1 : 0);
    }

    public /* synthetic */ CouponDiscount(String str, String str2, Long long, Long long2, boolean z, Map map, Map map2, String str3, int i, g gVar) {
        String str82;
        int str32;
        int z52 = 0;
        Map map62;
        Map map72;
        int i92 = i;
        str32 = 0;
        int r1 = i92 & 1 != 0 ? str32 : str;
        int r3 = i92 & 2 != 0 ? str32 : str2;
        int r4 = i92 & 4 != 0 ? str32 : long;
        if (i92 & 8 == 0) {
            str32 = long2;
        }
        int r5 = i92 & 16 != 0 ? 0 : z;
        if (i92 & 32 != 0) {
            map62 = j0.h();
        } else {
            map62 = map;
        }
        if (i92 & 64 != 0) {
            map72 = j0.h();
        } else {
            map72 = map2;
        }
        String r0 = i92 & 128 != 0 ? "" : str3;
        this(str32, str32, str32, str32, z52, map62, map72, (i92 & 128 != 0 ? "" : str3));
    }


    public CouponDiscount() {
        this(null, null, null, null, false, null, null, null, 255, null);
    }

    public static /* synthetic */ CouponDiscount copy$default(CouponDiscount couponDiscount, String str, String str2, Long long, Long long2, boolean z, Map map, Map map2, String str3, int i, Object object) {
        String str92;
        String str22;
        String str32;
        Long long42;
        Long long52;
        boolean z62;
        Map map72;
        Map map82;
        Object couponDiscount2 = couponDiscount;
        int i102 = i;
        String r2 = i102 & 1 != 0 ? couponDiscount2.discount : str;
        String r3 = i102 & 2 != 0 ? couponDiscount2.offeringId : str2;
        Long r4 = i102 & 4 != 0 ? couponDiscount2.startTimeMs : long;
        Long r5 = i102 & 8 != 0 ? couponDiscount2.endTimeMs : long2;
        boolean r6 = i102 & 16 != 0 ? couponDiscount2.welcomeOffer : z;
        Map r7 = i102 & 32 != 0 ? couponDiscount2.offerText : map;
        Map r8 = i102 & 64 != 0 ? couponDiscount2.discountText : map2;
        String r1 = i102 & 128 != 0 ? couponDiscount2.style : str3;
        return couponDiscount.copy(str22, str32, long42, long52, z62, map72, map82, (i102 & 128 != 0 ? couponDiscount2.style : str3));
    }

    /* operator */ public final String component1() {
        return this.discount;
    }

    /* operator */ public final String component2() {
        return this.offeringId;
    }

    /* operator */ public final Long component3() {
        return this.startTimeMs;
    }

    /* operator */ public final Long component4() {
        return this.endTimeMs;
    }

    /* operator */ public final boolean component5() {
        return this.welcomeOffer;
    }

    /* operator */ public final Map<String, String> component6() {
        return this.offerText;
    }

    /* operator */ public final Map<String, String> component7() {
        return this.discountText;
    }

    /* operator */ public final String component8() {
        return this.style;
    }

    public final CouponDiscount copy(String discount, String offeringId, Long startTimeMs, Long endTimeMs, boolean welcomeOffer, Map<String, String> offerText, Map<String, String> discountText, String style) {
        final Object offerText2 = offerText;
        n.f(offerText2, "offerText");
        final Object discountText2 = discountText;
        n.f(discountText2, "discountText");
        final Object style2 = style;
        n.f(style2, "style");
        CouponDiscount couponDiscount = new CouponDiscount(discount, offeringId, startTimeMs, endTimeMs, welcomeOffer, offerText2, discountText2, style2);
        return couponDiscount;
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
        final boolean z9 = false;
        if (!(other instanceof CouponDiscount)) {
            return false;
        }
        if (!n.b(this.discount, other.discount)) {
            return false;
        }
        if (!n.b(this.offeringId, other.offeringId)) {
            return false;
        }
        if (!n.b(this.startTimeMs, other.startTimeMs)) {
            return false;
        }
        if (!n.b(this.endTimeMs, other.endTimeMs)) {
            return false;
        }
        if (this.welcomeOffer != other.welcomeOffer) {
            return false;
        }
        if (!n.b(this.offerText, other.offerText)) {
            return false;
        }
        if (!n.b(this.discountText, other.discountText)) {
            return false;
        }
        return !n.b(this.style, other.style) ? z9 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean welcomeOffer2 = true;
        i = 0;
        if (this.discount == null) {
        } else {
            i = this.discount.hashCode();
        }
        if (this.offeringId == null) {
        } else {
            i = this.offeringId.hashCode();
        }
        if (this.startTimeMs == null) {
        } else {
            i = this.startTimeMs.hashCode();
        }
        if (this.endTimeMs != null) {
            i = this.endTimeMs.hashCode();
        }
        if (this.welcomeOffer) {
            int i19 = 1;
        }
        return (i * 31) + i * 31 + i * 31 + i * 31 + welcomeOffer2 * 31 + this.offerText.hashCode() * 31 + this.discountText.hashCode() * 31 + this.style.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CouponDiscount(discount=";
        String str3 = ", offeringId=";
        String str4 = ", startTimeMs=";
        String str5 = ", endTimeMs=";
        String str6 = ", welcomeOffer=";
        String str7 = ", offerText=";
        String str8 = ", discountText=";
        String str9 = ", style=";
        str = str2 + this.discount + str3 + this.offeringId + str4 + this.startTimeMs + str5 + this.endTimeMs + str6 + this.welcomeOffer + str7 + this.offerText + str8 + this.discountText + str9 + this.style + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int i = 1;
        n.f(parcel, "out");
        parcel.writeString(this.discount);
        parcel.writeString(this.offeringId);
        int i2 = 0;
        i = 1;
        if (this.startTimeMs == null) {
            parcel.writeInt(i2);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(this.startTimeMs.longValue());
        }
        if (this.endTimeMs == null) {
            parcel.writeInt(i2);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(this.endTimeMs.longValue());
        }
        parcel.writeInt(this.welcomeOffer);
        parcel.writeInt(this.offerText.size());
        Iterator it = this.offerText.entrySet().iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            parcel.writeString((String)item2.getKey());
            parcel.writeString((String)item2.getValue());
        }
        parcel.writeInt(this.discountText.size());
        Iterator it2 = this.discountText.entrySet().iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            parcel.writeString((String)item.getKey());
            parcel.writeString((String)item.getValue());
        }
        parcel.writeString(this.style);
    }
}
