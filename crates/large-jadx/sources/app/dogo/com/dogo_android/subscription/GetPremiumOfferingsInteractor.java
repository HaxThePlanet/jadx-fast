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

/* compiled from: GetPremiumOfferingsInteractor.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cJ&\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cH\u0002J&\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/subscription/GetPremiumOfferingsInteractor;", "", "purchases", "Lcom/revenuecat/purchases/Purchases;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "getPurchases", "()Lcom/revenuecat/purchases/Purchases;", "getRemoteConfigService", "()Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "centerYealySubscriptionIf3Elements", "", "Lcom/revenuecat/purchases/Package;", "list", "getOffers", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "discount", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "isFreeTrailAvailable", "", "orderByPricePerDay", "getSpecialOffers", "offerings", "Lcom/revenuecat/purchases/Offerings;", "offeringId", "", "mapToDogoSkuDetails", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "orderAndMapOfferings", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GetPremiumOfferingsInteractor {

    private final Purchases purchases;
    private final r2 remoteConfigService;
    public GetPremiumOfferingsInteractor(Purchases purchases, r2 r2Var) {
        n.f(purchases, "purchases");
        n.f(r2Var, "remoteConfigService");
        super();
        this.purchases = purchases;
        this.remoteConfigService = r2Var;
    }

    public static final /* synthetic */ List access$getSpecialOffers(GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, Offerings offerings, String str) {
        return getPremiumOfferingsInteractor.getSpecialOffers(offerings, str);
    }

    public static final /* synthetic */ List access$orderAndMapOfferings(GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, List list, boolean z) {
        return getPremiumOfferingsInteractor.orderAndMapOfferings(list, z);
    }

    private static final void getOffers$lambda_0(GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, CouponDiscount couponDiscount, boolean z, boolean z2, c0 c0Var) {
        n.f(getPremiumOfferingsInteractor, "this$0");
        n.f(c0Var, "emitter");
        GetPremiumOfferingsInteractor.getOffers.AnonymousClass1.AnonymousClass2 anonymousClass2 = new GetPremiumOfferingsInteractor.getOffers.AnonymousClass1.AnonymousClass2(couponDiscount, getPremiumOfferingsInteractor, c0Var, z, z2);
        ListenerConversionsKt.getOfferingsWith(getPremiumOfferingsInteractor.getPurchases(), new GetPremiumOfferingsInteractor.getOffers.AnonymousClass1.AnonymousClass1(c0Var), anonymousClass2);
    }

    private final List<Package> getSpecialOffers(Offerings offerings, String offeringId) {
        List availablePackages = null;
        Offering offering = offerings.get(offeringId);
        if (offering == null) {
            int i = 0;
        } else {
            availablePackages = offering.getAvailablePackages();
        }
        return centerYealySubscriptionIf3Elements(availablePackages);
    }

    private final List<DogoSkuDetails> mapToDogoSkuDetails(List<Package> list) {
        int i = 0;
        app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails;
        boolean z = true;
        String str;
        String identifier;
        String str2;
        PackageType packageType;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ArrayList arrayList;
        if (list == null || list.isEmpty()) {
            i = 1;
        }
        if (i != 0) {
            List list2 = p.g();
        } else {
            arrayList = new ArrayList(p.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                z = true;
                str = item.getProduct().n();
                n.e(str, "it.product.sku");
                dogoSkuDetails = new DogoSkuDetails(z, str, item.getIdentifier(), item.getProduct().q(), item.getPackageType(), item.getProduct().k(), item.getProduct().m(), item.getProduct().p(), item.getProduct().a(), item.getProduct().h());
                arrayList.add(dogoSkuDetails);
            }
        }
        return arrayList;
    }

    private final List<DogoSkuDetails> orderAndMapOfferings(List<Package> list, boolean orderByPricePerDay) {
        List mapToDogoSkuDetails;
        if (orderByPricePerDay) {
            mapToDogoSkuDetails = p.D0(mapToDogoSkuDetails(list), new GetPremiumOfferingsInteractor.orderAndMapOfferings$$inlined.sortedBy.AnonymousClass1());
        }
        return mapToDogoSkuDetails;
    }

    public final List<Package> centerYealySubscriptionIf3Elements(List<Package> list) {
        int i2;
        PackageType aNNUAL2;
        List list2;
        int i = 3;
        i2 = 1;
        i2 = 0;
        int r3 = i2;
        if (i2 != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int r5 = i2;
                if (i2 != 0) {
                    break;
                }
            }
            i2 = -1;
            i2 = 2;
            if (i2 == 0) {
                Package[] arr2 = new Package[i];
                list2 = p.j(new Package[] { (Package)list.get(i2), (Package)list.get(i2), (Package)list.get(i2) });
            } else {
                if (i2 == i2) {
                    Package[] arr = new Package[i];
                    list2 = p.j(new Package[] { (Package)list.get(i2), (Package)list.get(i2), (Package)list.get(i2) });
                }
            }
        }
        return list2;
    }

    public final a0<SubscriptionOffer> getOffers(CouponDiscount discount, boolean isFreeTrailAvailable, boolean orderByPricePerDay) {
        final a0 a0Var = a0.create(new i(this, discount, isFreeTrailAvailable, orderByPricePerDay));
        n.e(a0Var, "create { emitter ->\n            purchases.getOfferingsWith({ error ->\n                Timber.e(Exception(\"Purchase error code: ${error.code} - message : ${error.message} - extras: ${error.underlyingErrorMessage}\"))\n                emitter.tryOnError(PurchaseException(error.code))\n            }) { offerings ->\n                if (discount?.offeringId != null && offerings[discount.offeringId] != null) {\n                    val orderedOffering = getSpecialOffers(offerings, discount.offeringId)\n                    emitter.onSuccess(SubscriptionOffer(isFreeTrailAvailable, discount, orderAndMapOfferings(orderedOffering, orderByPricePerDay)))\n                } else if (remoteConfigService.dogoOfferId.isNotEmpty() && offerings[remoteConfigService.dogoOfferId] != null) {\n                    val orderedOffering = getSpecialOffers(offerings, remoteConfigService.dogoOfferId)\n                    emitter.onSuccess(SubscriptionOffer(isFreeTrailAvailable, discount, orderAndMapOfferings(orderedOffering, orderByPricePerDay)))\n                } else {\n                    val list = offerings.current?.availablePackages\n                    val orderedOffering = centerYealySubscriptionIf3Elements(list)\n                    emitter.onSuccess(SubscriptionOffer(isFreeTrailAvailable, null, orderAndMapOfferings(orderedOffering, orderByPricePerDay)))\n                }\n            }\n        }");
        return a0Var;
    }

    public final Purchases getPurchases() {
        return this.purchases;
    }

    public final r2 getRemoteConfigService() {
        return this.remoteConfigService;
    }

    public static /* synthetic */ void a(GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, CouponDiscount couponDiscount, boolean z, boolean z2, c0 c0Var) {
        GetPremiumOfferingsInteractor.getOffers$lambda_0(getPremiumOfferingsInteractor, couponDiscount, z, z2, c0Var);
    }
}
