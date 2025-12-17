package app.dogo.com.dogo_android.subscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.revenuecat.purchases.PackageType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 62\u00020\u0001:\u00016Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020\u00032\u0008\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u00020)HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0013¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "Landroid/os/Parcelable;", "canPurchase", "", "sku", "", "identifier", "type", "subscriptionPeriod", "Lcom/revenuecat/purchases/PackageType;", "price", "priceCurrencyCode", "title", "description", "originalJson", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanPurchase", "()Z", "getDescription", "()Ljava/lang/String;", "getIdentifier", "getOriginalJson", "getPrice", "getPriceCurrencyCode", "getSku", "getSubscriptionPeriod", "()Lcom/revenuecat/purchases/PackageType;", "getTitle", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "getPeriodInDays", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogoSkuDetails implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.subscription.DogoSkuDetails> CREATOR = null;
    public static final app.dogo.com.dogo_android.subscription.DogoSkuDetails.Companion Companion = null;
    private static final String REGEX = "^P((\\d)*Y)?((\\d)*M)?((\\d+)*W)?((\\d)*D)?";
    private final boolean canPurchase;
    private final String description;
    private final String identifier;
    private final String originalJson;
    private final String price;
    private final String priceCurrencyCode;
    private final String sku;
    private final PackageType subscriptionPeriod;
    private final String title;
    private final String type;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00042\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails$Companion;", "", "()V", "REGEX", "", "getPriceDescriptionV2", "dogoSku", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "context", "Landroid/content/Context;", "parsePeriodInDays", "", "period", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final String getPriceDescriptionV2(app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails, Context context2) {
            int i;
            String obj3;
            Object obj4;
            n.f(context2, "context");
            if (dogoSkuDetails == null) {
                return "";
            }
            int i2 = DogoSkuDetails.Companion.WhenMappings.$EnumSwitchMapping$0[dogoSkuDetails.getSubscriptionPeriod().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                obj3 = dogoSkuDetails.getSubscriptionPeriod().toString();
                            } else {
                                n.e(context2.getString(2131887372), "context.getString(R.string.subscription_12month)");
                            }
                        } else {
                            n.e(context2.getString(2131887377), "context.getString(R.string.subscription_6months)");
                        }
                    } else {
                        n.e(context2.getString(2131887376), "context.getString(R.string.subscription_3months)");
                    }
                } else {
                    n.e(context2.getString(2131887373), "context.getString(R.string.subscription_1month)");
                }
            } else {
                n.e(context2.getString(2131887374), "context.getString(R.string.subscription_1week)");
            }
            return obj3;
        }

        public final int parsePeriodInDays(String string) {
            int i;
            String group2;
            String group;
            String group4;
            String group3;
            int i2;
            n.f(string, "period");
            Pattern compile = Pattern.compile("^P((\\d)*Y)?((\\d)*M)?((\\d+)*W)?((\\d)*D)?");
            n.e(compile, "compile(REGEX)");
            final Matcher obj4 = compile.matcher(string);
            n.e(obj4, "pattern.matcher(period)");
            i = 0;
            while (obj4.find()) {
                if (obj4.group(1) != null) {
                }
                if (obj4.group(3) != null) {
                }
                i2 = 7;
                if (obj4.group(5) != null) {
                }
                if (obj4.group(i2) != null) {
                }
                String group7 = obj4.group(8);
                n.d(group7);
                i += group2;
                String group6 = obj4.group(6);
                n.d(group6);
                i += group3;
                String group8 = obj4.group(4);
                n.d(group8);
                i += group4;
                String group5 = obj4.group(2);
                n.d(group5);
                i += group;
            }
            return i;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.subscription.DogoSkuDetails> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.DogoSkuDetails createFromParcel(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            super(i, parcel.readString(), parcel.readString(), parcel.readString(), PackageType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return dogoSkuDetails;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.DogoSkuDetails[] newArray(int i) {
            return new DogoSkuDetails[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            iArr[PackageType.MONTHLY.ordinal()] = 1;
            iArr[PackageType.THREE_MONTH.ordinal()] = 2;
            iArr[PackageType.SIX_MONTH.ordinal()] = 3;
            iArr[PackageType.ANNUAL.ordinal()] = 4;
            iArr[PackageType.WEEKLY.ordinal()] = 5;
            iArr[PackageType.LIFETIME.ordinal()] = 6;
            DogoSkuDetails.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        DogoSkuDetails.Companion companion = new DogoSkuDetails.Companion(0);
        DogoSkuDetails.Companion = companion;
        DogoSkuDetails.Creator creator = new DogoSkuDetails.Creator();
        DogoSkuDetails.CREATOR = creator;
    }

    public DogoSkuDetails(boolean z, String string2, String string3, String string4, PackageType packageType5, String string6, String string7, String string8, String string9, String string10) {
        n.f(string2, "sku");
        n.f(string3, "identifier");
        n.f(packageType5, "subscriptionPeriod");
        super();
        this.canPurchase = z;
        this.sku = string2;
        this.identifier = string3;
        this.type = string4;
        this.subscriptionPeriod = packageType5;
        this.price = string6;
        this.priceCurrencyCode = string7;
        this.title = string8;
        this.description = string9;
        this.originalJson = string10;
    }

    public DogoSkuDetails(boolean z, String string2, String string3, String string4, PackageType packageType5, String string6, String string7, String string8, String string9, String string10, int i11, g g12) {
        String str2;
        PackageType uNKNOWN;
        String str;
        int i4;
        PackageType packageType;
        int i;
        int i6;
        int i3;
        int i2;
        int i5;
        int i7 = i11;
        str = i7 & 4 != 0 ? str2 : string3;
        int i15 = 0;
        i4 = i7 & 8 != 0 ? i15 : string4;
        packageType = i7 & 16 != 0 ? uNKNOWN : packageType5;
        i = i7 & 32 != 0 ? i15 : string6;
        i6 = i7 & 64 != 0 ? i15 : string7;
        i3 = i7 & 128 != 0 ? i15 : string8;
        i2 = i7 & 256 != 0 ? i15 : string9;
        i5 = i7 &= 512 != 0 ? i15 : string10;
        super(z, string2, str, i4, packageType, i, i6, i3, i2, i5);
    }

    public static app.dogo.com.dogo_android.subscription.DogoSkuDetails copy$default(app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails, boolean z2, String string3, String string4, String string5, PackageType packageType6, String string7, String string8, String string9, String string10, String string11, int i12, Object object13) {
        String originalJson;
        boolean canPurchase;
        String sku;
        String identifier;
        String type;
        PackageType subscriptionPeriod;
        String price;
        String priceCurrencyCode;
        String title;
        String description;
        Object obj = dogoSkuDetails;
        int i = i12;
        canPurchase = i & 1 != 0 ? obj.canPurchase : z2;
        sku = i & 2 != 0 ? obj.sku : string3;
        identifier = i & 4 != 0 ? obj.identifier : string4;
        type = i & 8 != 0 ? obj.type : string5;
        subscriptionPeriod = i & 16 != 0 ? obj.subscriptionPeriod : packageType6;
        price = i & 32 != 0 ? obj.price : string7;
        priceCurrencyCode = i & 64 != 0 ? obj.priceCurrencyCode : string8;
        title = i & 128 != 0 ? obj.title : string9;
        description = i & 256 != 0 ? obj.description : string10;
        originalJson = i &= 512 != 0 ? obj.originalJson : string11;
        return dogoSkuDetails.copy(canPurchase, sku, identifier, type, subscriptionPeriod, price, priceCurrencyCode, title, description, originalJson);
    }

    public static final String getPriceDescriptionV2(app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails, Context context2) {
        return DogoSkuDetails.Companion.getPriceDescriptionV2(dogoSkuDetails, context2);
    }

    @Override // android.os.Parcelable
    public final boolean component1() {
        return this.canPurchase;
    }

    @Override // android.os.Parcelable
    public final String component10() {
        return this.originalJson;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.sku;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final PackageType component5() {
        return this.subscriptionPeriod;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.price;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.priceCurrencyCode;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final String component9() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.subscription.DogoSkuDetails copy(boolean z, String string2, String string3, String string4, PackageType packageType5, String string6, String string7, String string8, String string9, String string10) {
        n.f(string2, "sku");
        n.f(string3, "identifier");
        final Object obj = packageType5;
        n.f(obj, "subscriptionPeriod");
        super(z, string2, string3, string4, obj, string6, string7, string8, string9, string10);
        return dogoSkuDetails;
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
        if (!object instanceof DogoSkuDetails) {
            return i2;
        }
        if (this.canPurchase != object.canPurchase) {
            return i2;
        }
        if (!n.b(this.sku, object.sku)) {
            return i2;
        }
        if (!n.b(this.identifier, object.identifier)) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (this.subscriptionPeriod != object.subscriptionPeriod) {
            return i2;
        }
        if (!n.b(this.price, object.price)) {
            return i2;
        }
        if (!n.b(this.priceCurrencyCode, object.priceCurrencyCode)) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.originalJson, object.originalJson)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean getCanPurchase() {
        return this.canPurchase;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final String getOriginalJson() {
        return this.originalJson;
    }

    @Override // android.os.Parcelable
    public final long getPeriodInDays() {
        int i;
        i = 30;
        switch (i3) {
            case 2:
                i = 90;
                break;
            case 3:
                i = 180;
                break;
            case 4:
                i = 365;
                break;
            case 5:
                i = 7;
                break;
            case 6:
                i = 9999;
                break;
            default:
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getPrice() {
        return this.price;
    }

    @Override // android.os.Parcelable
    public final String getPriceCurrencyCode() {
        return this.priceCurrencyCode;
    }

    @Override // android.os.Parcelable
    public final String getSku() {
        return this.sku;
    }

    @Override // android.os.Parcelable
    public final PackageType getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    @Override // android.os.Parcelable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final String getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean canPurchase;
        int i4;
        int i3;
        int i5;
        int i2;
        int i;
        int i6;
        if (this.canPurchase) {
            canPurchase = 1;
        }
        String type = this.type;
        i6 = 0;
        if (type == null) {
            i4 = i6;
        } else {
            i4 = type.hashCode();
        }
        String price = this.price;
        if (price == null) {
            i3 = i6;
        } else {
            i3 = price.hashCode();
        }
        String priceCurrencyCode = this.priceCurrencyCode;
        if (priceCurrencyCode == null) {
            i5 = i6;
        } else {
            i5 = priceCurrencyCode.hashCode();
        }
        String title = this.title;
        if (title == null) {
            i2 = i6;
        } else {
            i2 = title.hashCode();
        }
        String description = this.description;
        if (description == null) {
            i = i6;
        } else {
            i = description.hashCode();
        }
        String originalJson = this.originalJson;
        if (originalJson == null) {
        } else {
            i6 = originalJson.hashCode();
        }
        return i23 += i6;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogoSkuDetails(canPurchase=");
        stringBuilder.append(this.canPurchase);
        stringBuilder.append(", sku=");
        stringBuilder.append(this.sku);
        stringBuilder.append(", identifier=");
        stringBuilder.append(this.identifier);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", subscriptionPeriod=");
        stringBuilder.append(this.subscriptionPeriod);
        stringBuilder.append(", price=");
        stringBuilder.append(this.price);
        stringBuilder.append(", priceCurrencyCode=");
        stringBuilder.append(this.priceCurrencyCode);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", originalJson=");
        stringBuilder.append(this.originalJson);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(this.canPurchase);
        parcel.writeString(this.sku);
        parcel.writeString(this.identifier);
        parcel.writeString(this.type);
        parcel.writeString(this.subscriptionPeriod.name());
        parcel.writeString(this.price);
        parcel.writeString(this.priceCurrencyCode);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.originalJson);
    }
}
