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

/* compiled from: DogoSkuDetails.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 62\u00020\u0001:\u00016Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020\u00032\u0008\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u00020)HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0013¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "Landroid/os/Parcelable;", "canPurchase", "", "sku", "", "identifier", "type", "subscriptionPeriod", "Lcom/revenuecat/purchases/PackageType;", "price", "priceCurrencyCode", "title", "description", "originalJson", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanPurchase", "()Z", "getDescription", "()Ljava/lang/String;", "getIdentifier", "getOriginalJson", "getPrice", "getPriceCurrencyCode", "getSku", "getSubscriptionPeriod", "()Lcom/revenuecat/purchases/PackageType;", "getTitle", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "getPeriodInDays", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogoSkuDetails implements Parcelable {

    public static final Parcelable.Creator<DogoSkuDetails> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogoSkuDetails.Companion INSTANCE = null;
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
        private Companion() {
            super();
        }

        public final String getPriceDescriptionV2(DogoSkuDetails dogoSku, Context context) {
            String string;
            n.f(context, "context");
            if (dogoSku == null) {
                return "";
            }
            int i2 = DogoSkuDetails.Companion.WhenMappings.$EnumSwitchMapping$0[dogoSku.getSubscriptionPeriod().ordinal()];
            int i = 1;
            if (i2 == 1) {
                str = "context.getString(R.string.subscription_1week)";
                n.e(context.getString(2131887374), str);
            } else {
                i = 2;
                if (i2 == 2) {
                    str = "context.getString(R.string.subscription_1month)";
                    n.e(context.getString(2131887373), str);
                } else {
                    i = 3;
                    if (i2 == 3) {
                        str = "context.getString(R.string.subscription_3months)";
                        n.e(context.getString(2131887376), str);
                    } else {
                        i = 4;
                        if (i2 == 4) {
                            str = "context.getString(R.string.subscription_6months)";
                            n.e(context.getString(2131887377), str);
                        } else {
                            i = 5;
                            if (i2 != 5) {
                                string = dogoSku.getSubscriptionPeriod().toString();
                            } else {
                                str = "context.getString(R.string.subscription_12month)";
                                n.e(context.getString(2131887372), str);
                            }
                        }
                    }
                }
            }
            return string;
        }

        public final int parsePeriodInDays(String period) {
            int i = 0;
            n.f(period, "period");
            Pattern pattern = Pattern.compile("^P((\\d)*Y)?((\\d)*M)?((\\d+)*W)?((\\d)*D)?");
            group = "compile(REGEX)";
            n.e(pattern, group);
            final Matcher matcher = pattern.matcher(period);
            n.e(matcher, "pattern.matcher(period)");
            i = 0;
            while (matcher.find()) {
                String group8 = matcher.group(4);
                n.d(group8);
                i = i + (Integer.parseInt(group8) * 30);
                int i2 = 7;
            }
            return i;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogoSkuDetails> {
        @Override // android.os.Parcelable$Creator
        public final DogoSkuDetails createFromParcel(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            r1 = new DogoSkuDetails((parcel.readInt() != 0 ? 1 : 0), parcel.readString(), parcel.readString(), parcel.readString(), PackageType.valueOf((parcel.readInt() != 0 ? 1 : 0)), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return dogoSkuDetails;
        }

        @Override // android.os.Parcelable$Creator
        public final DogoSkuDetails[] newArray(int i) {
            return new DogoSkuDetails[i];
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[PackageType.values().length];
            iArr[PackageType.MONTHLY.ordinal()] = 1;
            iArr[PackageType.THREE_MONTH.ordinal()] = 2;
            iArr[PackageType.SIX_MONTH.ordinal()] = 3;
            iArr[PackageType.ANNUAL.ordinal()] = 4;
            iArr[PackageType.WEEKLY.ordinal()] = 5;
            iArr[PackageType.LIFETIME.ordinal()] = 6;
            DogoSkuDetails.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public DogoSkuDetails(boolean z, String str, String str2, String str3, PackageType packageType, String str4, String str5, String str6, String str7, String str8) {
        n.f(str, "sku");
        n.f(str2, "identifier");
        n.f(packageType, "subscriptionPeriod");
        super();
        this.canPurchase = z;
        this.sku = str;
        this.identifier = str2;
        this.type = str3;
        this.subscriptionPeriod = packageType;
        this.price = str4;
        this.priceCurrencyCode = str5;
        this.title = str6;
        this.description = str7;
        this.originalJson = str8;
    }

    public final boolean getCanPurchase() {
        return this.canPurchase;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getOriginalJson() {
        return this.originalJson;
    }

    public final long getPeriodInDays() {
        int i = 30;
        i = 30;
        switch (DogoSkuDetails.WhenMappings.$EnumSwitchMapping$0[this.subscriptionPeriod.ordinal()]) {
            case 2: /* ordinal */
                i = 90;
                break;
            case 3: /* ordinal */
                i = 180;
                break;
            case 4: /* ordinal */
                i = 365;
                break;
            case 5: /* ordinal */
                i = 7;
                break;
            case 6: /* ordinal */
                i = 9999;
                break;
            default:
        }
        return i;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getPriceCurrencyCode() {
        return this.priceCurrencyCode;
    }

    public final String getSku() {
        return this.sku;
    }

    public final PackageType getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public /* synthetic */ DogoSkuDetails(boolean z, String str, String str2, String str3, PackageType packageType, String str4, String str5, String str6, String str7, String str8, int i, g gVar) {
        String str32;
        String str42;
        PackageType packageType52;
        String str62;
        String str72;
        String str82;
        String str92;
        String str102;
        int i112 = i;
        str32 = i112 & 4 != 0 ? str32 : str2;
        i = 0;
        int r6 = i112 & 8 != 0 ? i : str3;
        packageType52 = i112 & 16 != 0 ? packageType52 : packageType;
        int r8 = i112 & 32 != 0 ? i : str4;
        int r9 = i112 & 64 != 0 ? i : str5;
        int r10 = i112 & 128 != 0 ? i : str6;
        int r11 = i112 & 256 != 0 ? i : str7;
        int r12 = i112 & 512 != 0 ? i : str8;
        this(z, str, str32, str42, packageType52, str62, str72, str82, str92, (i112 & 512 != 0 ? i : str8));
    }

    static {
        DogoSkuDetails.INSTANCE = new DogoSkuDetails_Companion(null);
        DogoSkuDetails.CREATOR = new DogoSkuDetails.Creator();
    }

    public static /* synthetic */ DogoSkuDetails copy$default(DogoSkuDetails dogoSkuDetails, boolean z, String str, String str2, String str3, PackageType packageType, String str4, String str5, String str6, String str7, String str8, int i, Object object) {
        String str112;
        boolean z22;
        String str32;
        String str42;
        String str52;
        PackageType packageType62;
        String str72;
        String str82;
        String str92;
        String str102;
        Object dogoSkuDetails2 = dogoSkuDetails;
        int i122 = i;
        boolean r2 = i122 & 1 != 0 ? dogoSkuDetails2.canPurchase : z;
        String r3 = i122 & 2 != 0 ? dogoSkuDetails2.sku : str;
        String r4 = i122 & 4 != 0 ? dogoSkuDetails2.identifier : str2;
        String r5 = i122 & 8 != 0 ? dogoSkuDetails2.type : str3;
        PackageType r6 = i122 & 16 != 0 ? dogoSkuDetails2.subscriptionPeriod : packageType;
        String r7 = i122 & 32 != 0 ? dogoSkuDetails2.price : str4;
        String r8 = i122 & 64 != 0 ? dogoSkuDetails2.priceCurrencyCode : str5;
        String r9 = i122 & 128 != 0 ? dogoSkuDetails2.title : str6;
        String r10 = i122 & 256 != 0 ? dogoSkuDetails2.description : str7;
        String r1 = i122 & 512 != 0 ? dogoSkuDetails2.originalJson : str8;
        return dogoSkuDetails.copy(z22, str32, str42, str52, packageType62, str72, str82, str92, str102, (i122 & 512 != 0 ? dogoSkuDetails2.originalJson : str8));
    }

    public static final String getPriceDescriptionV2(DogoSkuDetails dogoSkuDetails, Context context) {
        return DogoSkuDetails.INSTANCE.getPriceDescriptionV2(dogoSkuDetails, context);
    }

    /* operator */ public final boolean component1() {
        return this.canPurchase;
    }

    /* operator */ public final String component10() {
        return this.originalJson;
    }

    /* operator */ public final String component2() {
        return this.sku;
    }

    /* operator */ public final String component3() {
        return this.identifier;
    }

    /* operator */ public final String component4() {
        return this.type;
    }

    /* operator */ public final PackageType component5() {
        return this.subscriptionPeriod;
    }

    /* operator */ public final String component6() {
        return this.price;
    }

    /* operator */ public final String component7() {
        return this.priceCurrencyCode;
    }

    /* operator */ public final String component8() {
        return this.title;
    }

    /* operator */ public final String component9() {
        return this.description;
    }

    public final DogoSkuDetails copy(boolean canPurchase, String sku, String identifier, String type, PackageType subscriptionPeriod, String price, String priceCurrencyCode, String title, String description, String originalJson) {
        n.f(sku, "sku");
        n.f(identifier, "identifier");
        final Object subscriptionPeriod2 = subscriptionPeriod;
        n.f(subscriptionPeriod2, "subscriptionPeriod");
        DogoSkuDetails dogoSkuDetails = new DogoSkuDetails(canPurchase, sku, identifier, type, subscriptionPeriod2, price, priceCurrencyCode, title, description, originalJson);
        return dogoSkuDetails;
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
        final boolean z10 = false;
        if (!(other instanceof DogoSkuDetails)) {
            return false;
        }
        if (this.canPurchase != other.canPurchase) {
            return false;
        }
        if (!n.b(this.sku, other.sku)) {
            return false;
        }
        if (!n.b(this.identifier, other.identifier)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        if (this.subscriptionPeriod != other.subscriptionPeriod) {
            return false;
        }
        if (!n.b(this.price, other.price)) {
            return false;
        }
        if (!n.b(this.priceCurrencyCode, other.priceCurrencyCode)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        return !n.b(this.originalJson, other.originalJson) ? z10 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean canPurchase2 = true;
        int i;
        if (this.canPurchase) {
            int i2 = 1;
        }
        i = 0;
        if (this.type == null) {
        } else {
            i = this.type.hashCode();
        }
        if (this.price == null) {
        } else {
            i = this.price.hashCode();
        }
        if (this.priceCurrencyCode == null) {
        } else {
            i = this.priceCurrencyCode.hashCode();
        }
        if (this.title == null) {
        } else {
            i = this.title.hashCode();
        }
        if (this.description == null) {
        } else {
            i = this.description.hashCode();
        }
        if (this.originalJson != null) {
            i = this.originalJson.hashCode();
        }
        return (canPurchase2 * 31) + this.sku.hashCode() * 31 + this.identifier.hashCode() * 31 + i * 31 + this.subscriptionPeriod.hashCode() * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogoSkuDetails(canPurchase=";
        String str3 = ", sku=";
        String str4 = ", identifier=";
        String str5 = ", type=";
        String str6 = ", subscriptionPeriod=";
        String str7 = ", price=";
        String str8 = ", priceCurrencyCode=";
        String str9 = ", title=";
        String str10 = ", description=";
        String str11 = ", originalJson=";
        str = str2 + this.canPurchase + str3 + this.sku + str4 + this.identifier + str5 + this.type + str6 + this.subscriptionPeriod + str7 + this.price + str8 + this.priceCurrencyCode + str9 + this.title + str10 + this.description + str11 + this.originalJson + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
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
