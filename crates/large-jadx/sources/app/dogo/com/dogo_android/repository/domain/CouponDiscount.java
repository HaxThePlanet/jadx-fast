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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 62\u00020\u0001:\u00016Bu\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\tHÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J~\u0010$\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0014\u0008\u0002\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020'HÖ\u0001J\u0013\u0010(\u001a\u00020\t2\u0008\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\u0015\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0002\u0010-J\t\u0010.\u001a\u00020'HÖ\u0001J\u0006\u0010/\u001a\u00020\tJ\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020'HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001d\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008\u0013\u0010\u0014R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "Landroid/os/Parcelable;", "discount", "", "offeringId", "startTimeMs", "", "endTimeMs", "welcomeOffer", "", "offerText", "", "discountText", "style", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/String;", "getDiscountText", "()Ljava/util/Map;", "getEndTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOfferText", "getOfferingId", "getStartTimeMs", "getStyle", "getWelcomeOffer", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/util/Map;Ljava/util/Map;Ljava/lang/String;)Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "describeContents", "", "equals", "other", "", "getNotificationTimeMs", "currentTimeMs", "(J)Ljava/lang/Long;", "hashCode", "isEmpty", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CouponDiscount implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CouponDiscount> CREATOR;
    public static final app.dogo.com.dogo_android.repository.domain.CouponDiscount.Companion Companion;
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
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.repository.domain.CouponDiscount createEmptyObject() {
            super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
            return couponDiscount2;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CouponDiscount> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CouponDiscount createFromParcel(Parcel parcel) {
            int valueOf2;
            int valueOf;
            int int;
            int i4;
            int i5;
            int i;
            int i2;
            int i3;
            String string;
            String string2;
            n.f(parcel, "parcel");
            int i6 = 0;
            if (parcel.readInt() == 0) {
                i5 = i6;
            } else {
                i5 = valueOf2;
            }
            if (parcel.readInt() == 0) {
                i = i6;
            } else {
                i = valueOf;
            }
            i4 = 0;
            i2 = parcel.readInt() != 0 ? int : i4;
            int int2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int2);
            i3 = i4;
            while (i3 != int2) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
                i3++;
            }
            int int3 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(int3);
            string = parcel.readString();
            while (i4 != int3) {
                linkedHashMap2.put(string, parcel.readString());
                i4++;
                string = parcel.readString();
            }
            super(parcel.readString(), parcel.readString(), i5, i, i2, linkedHashMap, linkedHashMap2, string);
            return obj12;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CouponDiscount[] newArray(int i) {
            return new CouponDiscount[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        CouponDiscount.Companion companion = new CouponDiscount.Companion(0);
        CouponDiscount.Companion = companion;
        CouponDiscount.Creator creator = new CouponDiscount.Creator();
        CouponDiscount.CREATOR = creator;
    }

    public CouponDiscount() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
    }

    public CouponDiscount(String string, String string2, Long long3, Long long4, boolean z5, Map<String, String> map6, Map<String, String> map7, String string8) {
        n.f(map6, "offerText");
        n.f(map7, "discountText");
        n.f(string8, "style");
        super();
        this.discount = string;
        this.offeringId = string2;
        this.startTimeMs = long3;
        this.endTimeMs = long4;
        this.welcomeOffer = z5;
        this.offerText = map6;
        this.discountText = map7;
        this.style = string8;
    }

    public CouponDiscount(String string, String string2, Long long3, Long long4, boolean z5, Map map6, Map map7, String string8, int i9, g g10) {
        String str;
        int i;
        int i3;
        int i2;
        int i4;
        int i5;
        Map map2;
        Map map;
        int i6 = i9;
        i3 = 0;
        i = i6 & 1 != 0 ? i3 : string;
        i2 = i6 & 2 != 0 ? i3 : string2;
        i4 = i6 & 4 != 0 ? i3 : long3;
        if (i6 & 8 != 0) {
        } else {
            i3 = long4;
        }
        i5 = i6 & 16 != 0 ? 0 : z5;
        if (i6 & 32 != 0) {
            map2 = j0.h();
        } else {
            map2 = map6;
        }
        if (i6 & 64 != 0) {
            map = j0.h();
        } else {
            map = map7;
        }
        str = i6 &= 128 != 0 ? "" : string8;
        super(i, i2, i4, i3, i5, map2, map, str);
    }

    public static app.dogo.com.dogo_android.repository.domain.CouponDiscount copy$default(app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount, String string2, String string3, Long long4, Long long5, boolean z6, Map map7, Map map8, String string9, int i10, Object object11) {
        String style;
        String discount;
        String offeringId;
        Long startTimeMs;
        Long endTimeMs;
        boolean welcomeOffer;
        Map offerText;
        Map discountText;
        Object obj = couponDiscount;
        int i = i10;
        discount = i & 1 != 0 ? obj.discount : string2;
        offeringId = i & 2 != 0 ? obj.offeringId : string3;
        startTimeMs = i & 4 != 0 ? obj.startTimeMs : long4;
        endTimeMs = i & 8 != 0 ? obj.endTimeMs : long5;
        welcomeOffer = i & 16 != 0 ? obj.welcomeOffer : z6;
        offerText = i & 32 != 0 ? obj.offerText : map7;
        discountText = i & 64 != 0 ? obj.discountText : map8;
        style = i &= 128 != 0 ? obj.style : string9;
        return couponDiscount.copy(discount, offeringId, startTimeMs, endTimeMs, welcomeOffer, offerText, discountText, style);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.discount;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.offeringId;
    }

    @Override // android.os.Parcelable
    public final Long component3() {
        return this.startTimeMs;
    }

    @Override // android.os.Parcelable
    public final Long component4() {
        return this.endTimeMs;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.welcomeOffer;
    }

    public final Map<String, String> component6() {
        return this.offerText;
    }

    public final Map<String, String> component7() {
        return this.discountText;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.style;
    }

    public final app.dogo.com.dogo_android.repository.domain.CouponDiscount copy(String string, String string2, Long long3, Long long4, boolean z5, Map<String, String> map6, Map<String, String> map7, String string8) {
        final Object obj = map6;
        n.f(obj, "offerText");
        final Object obj2 = map7;
        n.f(obj2, "discountText");
        final Object obj3 = string8;
        n.f(obj3, "style");
        super(string, string2, long3, long4, z5, obj, obj2, obj3);
        return couponDiscount;
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
        if (!object instanceof CouponDiscount) {
            return i2;
        }
        if (!n.b(this.discount, object.discount)) {
            return i2;
        }
        if (!n.b(this.offeringId, object.offeringId)) {
            return i2;
        }
        if (!n.b(this.startTimeMs, object.startTimeMs)) {
            return i2;
        }
        if (!n.b(this.endTimeMs, object.endTimeMs)) {
            return i2;
        }
        if (this.welcomeOffer != object.welcomeOffer) {
            return i2;
        }
        if (!n.b(this.offerText, object.offerText)) {
            return i2;
        }
        if (!n.b(this.discountText, object.discountText)) {
            return i2;
        }
        if (!n.b(this.style, object.style)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDiscount() {
        return this.discount;
    }

    public final Map<String, String> getDiscountText() {
        return this.discountText;
    }

    @Override // android.os.Parcelable
    public final Long getEndTimeMs() {
        return this.endTimeMs;
    }

    @Override // android.os.Parcelable
    public final Long getNotificationTimeMs(long l) {
        int startTimeMs;
        int valueOf;
        int i5;
        int i4;
        int i6;
        long millis;
        int i3;
        TimeUnit mINUTES;
        int i7;
        int cmp;
        int i8;
        int i;
        int i2;
        long millis2;
        final Object obj = this;
        valueOf = 0;
        if (obj.startTimeMs != null) {
            startTimeMs = obj.endTimeMs;
            if (startTimeMs == null) {
            } else {
                longValue -= longValue2;
                longValue3 += i10;
                TimeUnit hOURS = TimeUnit.HOURS;
                int i11 = 1;
                longValue4 -= millis3;
                mINUTES = TimeUnit.MINUTES;
                i7 = 10;
                longValue5 -= millis4;
                i = 1;
                i2 = 0;
                if (Long.compare(l, i4) < 0 && Long.compare(i5, millis2) > 0) {
                    i8 = Long.compare(i5, millis2) > 0 ? i : i2;
                } else {
                }
                millis2 = Long.compare(l, i6) < 0 ? i : i2;
                if (Long.compare(i5, millis) < 0 && Long.compare(i5, millis) > 0 && Long.compare(l, i3) < 0) {
                    if (Long.compare(i5, millis) > 0) {
                        if (Long.compare(l, i3) < 0) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
                if (i8 != 0) {
                    valueOf = Long.valueOf(i4);
                } else {
                    if (millis2 != 0) {
                        valueOf = Long.valueOf(i6);
                    } else {
                        if (i != 0) {
                            valueOf = Long.valueOf(i3);
                        }
                    }
                }
            }
        }
        return valueOf;
    }

    public final Map<String, String> getOfferText() {
        return this.offerText;
    }

    @Override // android.os.Parcelable
    public final String getOfferingId() {
        return this.offeringId;
    }

    @Override // android.os.Parcelable
    public final Long getStartTimeMs() {
        return this.startTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getStyle() {
        return this.style;
    }

    @Override // android.os.Parcelable
    public final boolean getWelcomeOffer() {
        return this.welcomeOffer;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i3;
        int i;
        boolean welcomeOffer;
        int i4;
        int i2;
        String discount = this.discount;
        i = 0;
        if (discount == null) {
            i3 = i;
        } else {
            i3 = discount.hashCode();
        }
        String offeringId = this.offeringId;
        if (offeringId == null) {
            i4 = i;
        } else {
            i4 = offeringId.hashCode();
        }
        Long startTimeMs = this.startTimeMs;
        if (startTimeMs == null) {
            i2 = i;
        } else {
            i2 = startTimeMs.hashCode();
        }
        Long endTimeMs = this.endTimeMs;
        if (endTimeMs == null) {
        } else {
            i = endTimeMs.hashCode();
        }
        if (this.welcomeOffer) {
            welcomeOffer = 1;
        }
        return i17 += i21;
    }

    @Override // android.os.Parcelable
    public final boolean isEmpty() {
        int i;
        i = this.offeringId == null ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CouponDiscount(discount=");
        stringBuilder.append(this.discount);
        stringBuilder.append(", offeringId=");
        stringBuilder.append(this.offeringId);
        stringBuilder.append(", startTimeMs=");
        stringBuilder.append(this.startTimeMs);
        stringBuilder.append(", endTimeMs=");
        stringBuilder.append(this.endTimeMs);
        stringBuilder.append(", welcomeOffer=");
        stringBuilder.append(this.welcomeOffer);
        stringBuilder.append(", offerText=");
        stringBuilder.append(this.offerText);
        stringBuilder.append(", discountText=");
        stringBuilder.append(this.discountText);
        stringBuilder.append(", style=");
        stringBuilder.append(this.style);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        long longValue;
        int value2;
        int value;
        int key;
        long longValue2;
        n.f(parcel, "out");
        parcel.writeString(this.discount);
        parcel.writeString(this.offeringId);
        Long obj6 = this.startTimeMs;
        longValue = 0;
        key = 1;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(key);
            parcel.writeLong(obj6.longValue());
        }
        obj6 = this.endTimeMs;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(key);
            parcel.writeLong(obj6.longValue());
        }
        parcel.writeInt(this.welcomeOffer);
        obj6 = this.offerText;
        parcel.writeInt(obj6.size());
        obj6 = obj6.entrySet().iterator();
        for (Map.Entry next4 : obj6) {
            parcel.writeString((String)next4.getKey());
            parcel.writeString((String)next4.getValue());
        }
        obj6 = this.discountText;
        parcel.writeInt(obj6.size());
        obj6 = obj6.entrySet().iterator();
        for (Map.Entry next3 : obj6) {
            parcel.writeString((String)next3.getKey());
            parcel.writeString((String)next3.getValue());
        }
        parcel.writeString(this.style);
    }
}
