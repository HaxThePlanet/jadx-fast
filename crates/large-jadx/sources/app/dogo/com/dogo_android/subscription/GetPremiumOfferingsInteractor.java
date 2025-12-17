package app.dogo.com.dogo_android.subscription;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.service.r2;
import com.android.billingclient.api.SkuDetails;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.Purchases;
import i.b.a0;
import i.b.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cJ&\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cH\u0002J&\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/subscription/GetPremiumOfferingsInteractor;", "", "purchases", "Lcom/revenuecat/purchases/Purchases;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "getPurchases", "()Lcom/revenuecat/purchases/Purchases;", "getRemoteConfigService", "()Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "centerYealySubscriptionIf3Elements", "", "Lcom/revenuecat/purchases/Package;", "list", "getOffers", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "discount", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "isFreeTrailAvailable", "", "orderByPricePerDay", "getSpecialOffers", "offerings", "Lcom/revenuecat/purchases/Offerings;", "offeringId", "", "mapToDogoSkuDetails", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "orderAndMapOfferings", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetPremiumOfferingsInteractor {

    private final Purchases purchases;
    private final r2 remoteConfigService;
    public GetPremiumOfferingsInteractor(Purchases purchases, r2 r22) {
        n.f(purchases, "purchases");
        n.f(r22, "remoteConfigService");
        super();
        this.purchases = purchases;
        this.remoteConfigService = r22;
    }

    public static void a(app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, CouponDiscount couponDiscount2, boolean z3, boolean z4, c0 c05) {
        GetPremiumOfferingsInteractor.getOffers$lambda-0(getPremiumOfferingsInteractor, couponDiscount2, z3, z4, c05);
    }

    public static final List access$getSpecialOffers(app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, Offerings offerings2, String string3) {
        return getPremiumOfferingsInteractor.getSpecialOffers(offerings2, string3);
    }

    public static final List access$orderAndMapOfferings(app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, List list2, boolean z3) {
        return getPremiumOfferingsInteractor.orderAndMapOfferings(list2, z3);
    }

    private static final void getOffers$lambda-0(app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, CouponDiscount couponDiscount2, boolean z3, boolean z4, c0 c05) {
        n.f(getPremiumOfferingsInteractor, "this$0");
        n.f(c05, "emitter");
        GetPremiumOfferingsInteractor.getOffers.1.1 anon = new GetPremiumOfferingsInteractor.getOffers.1.1(c05);
        super(couponDiscount2, getPremiumOfferingsInteractor, c05, z3, z4);
        ListenerConversionsKt.getOfferingsWith(getPremiumOfferingsInteractor.getPurchases(), anon, anon3);
    }

    private final List<Package> getSpecialOffers(Offerings offerings, String string2) {
        int obj1;
        obj1 = offerings.get(string2);
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.getAvailablePackages();
        }
        return centerYealySubscriptionIf3Elements(obj1);
    }

    private final List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> mapToDogoSkuDetails(List<Package> list) {
        int arrayList;
        boolean empty;
        int product;
        boolean next;
        app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails;
        int i;
        String str2;
        String identifier;
        String str7;
        PackageType packageType;
        String str4;
        String str;
        String str3;
        String str5;
        String str6;
        app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2;
        Object obj15;
        if (list != null) {
            if (list.isEmpty()) {
                arrayList = 1;
            } else {
                arrayList = 0;
            }
        } else {
        }
        if (arrayList != null) {
            obj15 = p.g();
        } else {
            arrayList = new ArrayList(p.r(list, 10));
            obj15 = list.iterator();
            for (Package next2 : obj15) {
                str2 = next2.getProduct().n();
                n.e(str2, "it.product.sku");
                super(1, str2, next2.getIdentifier(), next2.getProduct().q(), next2.getPackageType(), next2.getProduct().k(), next2.getProduct().m(), next2.getProduct().p(), next2.getProduct().a(), next2.getProduct().h());
                arrayList.add(dogoSkuDetails2);
            }
            obj15 = arrayList;
        }
        return obj15;
    }

    private final List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> orderAndMapOfferings(List<Package> list, boolean z2) {
        List obj1;
        app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor.orderAndMapOfferings$$inlined.sortedBy.1 obj2;
        if (z2 != null) {
            obj2 = new GetPremiumOfferingsInteractor.orderAndMapOfferings$$inlined.sortedBy.1();
            obj1 = p.D0(mapToDogoSkuDetails(list), obj2);
        }
        return obj1;
    }

    public final List<Package> centerYealySubscriptionIf3Elements(List<Package> list) {
        int arr;
        int i2;
        int size;
        int i3;
        int i;
        int next;
        PackageType aNNUAL;
        List obj8;
        arr = 3;
        final int i4 = 1;
        i2 = 0;
        if (list == null) {
            i3 = i2;
        } else {
        }
        if (i3 != 0) {
            Iterator iterator = list.iterator();
            i = i2;
            while (iterator.hasNext()) {
                if ((Package)iterator.next().getPackageType() == PackageType.ANNUAL) {
                } else {
                }
                next = i2;
                i++;
                next = i4;
            }
            i = -1;
            i3 = 2;
            if (i != 0) {
                if (i != i3) {
                } else {
                    arr = new Package[arr];
                    arr[i2] = (Package)list.get(i2);
                    arr[i4] = (Package)list.get(i3);
                    arr[i3] = (Package)list.get(i4);
                    obj8 = p.j(arr);
                }
            } else {
                arr = new Package[arr];
                arr[i2] = (Package)list.get(i4);
                arr[i4] = (Package)list.get(i2);
                arr[i3] = (Package)list.get(i3);
                obj8 = p.j(arr);
            }
        }
        return obj8;
    }

    public final a0<SubscriptionOffer> getOffers(CouponDiscount couponDiscount, boolean z2, boolean z3) {
        i iVar = new i(this, couponDiscount, z2, z3);
        final a0 obj2 = a0.create(iVar);
        n.e(obj2, "create { emitter ->\n            purchases.getOfferingsWith({ error ->\n                Timber.e(Exception(\"Purchase error code: ${error.code} - message : ${error.message} - extras: ${error.underlyingErrorMessage}\"))\n                emitter.tryOnError(PurchaseException(error.code))\n            }) { offerings ->\n                if (discount?.offeringId != null && offerings[discount.offeringId] != null) {\n                    val orderedOffering = getSpecialOffers(offerings, discount.offeringId)\n                    emitter.onSuccess(SubscriptionOffer(isFreeTrailAvailable, discount, orderAndMapOfferings(orderedOffering, orderByPricePerDay)))\n                } else if (remoteConfigService.dogoOfferId.isNotEmpty() && offerings[remoteConfigService.dogoOfferId] != null) {\n                    val orderedOffering = getSpecialOffers(offerings, remoteConfigService.dogoOfferId)\n                    emitter.onSuccess(SubscriptionOffer(isFreeTrailAvailable, discount, orderAndMapOfferings(orderedOffering, orderByPricePerDay)))\n                } else {\n                    val list = offerings.current?.availablePackages\n                    val orderedOffering = centerYealySubscriptionIf3Elements(list)\n                    emitter.onSuccess(SubscriptionOffer(isFreeTrailAvailable, null, orderAndMapOfferings(orderedOffering, orderByPricePerDay)))\n                }\n            }\n        }");
        return obj2;
    }

    public final Purchases getPurchases() {
        return this.purchases;
    }

    public final r2 getRemoteConfigService() {
        return this.remoteConfigService;
    }
}
