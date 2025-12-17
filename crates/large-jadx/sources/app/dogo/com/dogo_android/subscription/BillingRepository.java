package app.dogo.com.dogo_android.subscription;

import app.dogo.android.persistencedb.room.entity.CouponEntity;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.com.dogo_android.model.CouponModel;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount.Companion;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.AlreadyUsed;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.DoesNotExists;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.w.d1;
import app.dogo.com.dogo_android.w.g2;
import app.dogo.com.dogo_android.w.o;
import app.dogo.com.dogo_android.w.o0;
import app.dogo.com.dogo_android.w.o1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p1;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.t0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.y2;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.revenuecat.purchases.PurchaserInfo;
import e.a.a.a.b.b.a0;
import e.a.a.a.b.b.s;
import i.b.a0;
import i.b.b;
import i.b.g0;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020(J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0018\u0010/\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0014\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u001c\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0017J\u0014\u00104\u001a\u0008\u0012\u0004\u0012\u0002050\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dateUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogoPremiumStatusDao", "Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "firebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "couponEntityDao", "Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;Lcom/google/firebase/database/FirebaseDatabase;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;)V", "fetchAndSaveDiscount", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "couponId", "", "fetchCoupon", "Lapp/dogo/com/dogo_android/model/CouponModel;", "fetchCouponCodeForPromo", "promoCode", "getDiscount", "handlePurchase", "", "viewSource", "dogoSkuDetails", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "purchase", "Lcom/android/billingclient/api/Purchase;", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;", "handlePurchaseInRoom", "expirationTimestamp", "", "handleRestorePurchase", "expirationTimeStamp", "saveSpecialOfferCoupon", "Lio/reactivex/Completable;", "coupon", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "trackPurchaseCompleted", "validateAndSaveDiscount", "validateAndSaveDiscountPromoCode", "linkType", "partner", "validateDiscount", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BillingRepository {

    private final h2 authService;
    private final s couponEntityDao;
    private final v2 dateUtils;
    private final a0 dogoPremiumStatusDao;
    private final FirebaseDatabase firebaseDatabase;
    private final p2 preferenceService;
    private final r2 remoteConfigService;
    private final o3 tracker;
    public BillingRepository(o3 o3, v2 v22, a0 a03, FirebaseDatabase firebaseDatabase4, h2 h25, p2 p26, r2 r27, s s8) {
        n.f(o3, "tracker");
        n.f(v22, "dateUtils");
        n.f(a03, "dogoPremiumStatusDao");
        n.f(firebaseDatabase4, "firebaseDatabase");
        n.f(h25, "authService");
        n.f(p26, "preferenceService");
        n.f(r27, "remoteConfigService");
        n.f(s8, "couponEntityDao");
        super();
        this.tracker = o3;
        this.dateUtils = v22;
        this.dogoPremiumStatusDao = a03;
        this.firebaseDatabase = firebaseDatabase4;
        this.authService = h25;
        this.preferenceService = p26;
        this.remoteConfigService = r27;
        this.couponEntityDao = s8;
    }

    public static CouponDiscount a(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, CouponEntity couponEntity2) {
        return BillingRepository.getDiscount$lambda-0(billingRepository, couponEntity2);
    }

    public static g0 b(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, String string2) {
        return BillingRepository.validateAndSaveDiscountPromoCode$lambda-1(billingRepository, string2);
    }

    public static g0 c(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, CouponModel couponModel2) {
        return BillingRepository.fetchAndSaveDiscount$lambda-4(billingRepository, couponModel2);
    }

    public static String d(DataSnapshot dataSnapshot) {
        return BillingRepository.fetchCouponCodeForPromo$lambda-5(dataSnapshot);
    }

    public static g0 e(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, String string2, Boolean boolean3) {
        return BillingRepository.validateAndSaveDiscount$lambda-2(billingRepository, string2, boolean3);
    }

    public static CouponDiscount f(CouponEntity couponEntity) {
        return BillingRepository.fetchAndSaveDiscount$lambda-4$lambda-3(couponEntity);
    }

    private final a0<CouponDiscount> fetchAndSaveDiscount(String string) {
        c cVar = new c(this);
        a0 obj2 = fetchCoupon(string).flatMap(cVar);
        n.e(obj2, "fetchCoupon(couponId).flatMap {\n            val entity = it.toEntity(dateUtils.currentTimeInMillis)\n            if (entity != null) {\n                couponEntityDao.insert(entity).toSingle { entity.toItem() }\n            } else {\n                throw CouponExceptions.DoesNotExists()\n            }\n        }");
        return obj2;
    }

    private static final g0 fetchAndSaveDiscount$lambda-4(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, CouponModel couponModel2) {
        n.f(billingRepository, "this$0");
        n.f(couponModel2, "it");
        final CouponEntity obj3 = m1.k(couponModel2, billingRepository.dateUtils.g());
        if (obj3 == null) {
        } else {
            CouponEntity[] arr = new CouponEntity[1];
            f fVar = new f(obj3);
            return billingRepository.couponEntityDao.f(obj3).B(fVar);
        }
        CouponExceptions.DoesNotExists obj2 = new CouponExceptions.DoesNotExists();
        throw obj2;
    }

    private static final CouponDiscount fetchAndSaveDiscount$lambda-4$lambda-3(CouponEntity couponEntity) {
        return m1.o(couponEntity);
    }

    private final a0<CouponModel> fetchCoupon(String string) {
        DatabaseReference child = this.firebaseDatabase.getReference().child(n.o("coupons/", string));
        n.e(child, "firebaseDatabase.reference.child(\"coupons/$couponId\")");
        g gVar = new g(string);
        final a0 obj3 = j1.O0(child).map(gVar);
        n.e(obj3, "firebaseDatabase.reference.child(\"coupons/$couponId\").toSingle().map { couponData ->\n            val item = couponData.getValue(CouponModel::class.java)?.apply { this.couponId = couponId }\n            item ?: CouponModel()\n        }");
        return obj3;
    }

    private static final CouponModel fetchCoupon$lambda-8(String string, DataSnapshot dataSnapshot2) {
        Class<CouponModel> obj;
        int i2;
        int i;
        int i3;
        int i6;
        int i4;
        int i5;
        int obj8;
        n.f(string, "$couponId");
        n.f(dataSnapshot2, "couponData");
        obj8 = dataSnapshot2.getValue(CouponModel.class);
        if ((CouponModel)obj8 == null) {
            obj8 = 0;
        } else {
            (CouponModel)obj8.setCouponId(string);
        }
        if (obj8 == null) {
            super(0, 0, 0, 0, 15, 0);
        }
        return obj8;
    }

    private final a0<String> fetchCouponCodeForPromo(String string) {
        DatabaseReference obj3 = this.firebaseDatabase.getReference().child(n.o("couponLink/", string));
        n.e(obj3, "firebaseDatabase.reference.child(\"couponLink/$promoCode\")");
        obj3 = j1.O0(obj3).map(d.a);
        n.e(obj3, "firebaseDatabase.reference.child(\"couponLink/$promoCode\").toSingle().map { promoData ->\n            val couponCode = (promoData.child(\"couponCode\").value as? String)\n            couponCode ?: \"\"\n        }");
        return obj3;
    }

    private static final String fetchCouponCodeForPromo$lambda-5(DataSnapshot dataSnapshot) {
        Object obj1;
        n.f(dataSnapshot, "promoData");
        if (obj1 instanceof String != null) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = "";
        }
        return obj1;
    }

    public static CouponModel g(String string, DataSnapshot dataSnapshot2) {
        return BillingRepository.fetchCoupon$lambda-8(string, dataSnapshot2);
    }

    private static final CouponDiscount getDiscount$lambda-0(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, CouponEntity couponEntity2) {
        long longValue;
        int obj4;
        CouponDiscount obj5;
        n.f(billingRepository, "this$0");
        n.f(couponEntity2, "it");
        obj4 = m1.o(couponEntity2).getEndTimeMs();
        if (obj4 == null) {
            longValue = 0;
        } else {
            longValue = obj4.longValue();
        }
        obj4 = Long.compare(l, longValue) < 0 ? 1 : 0;
        if (obj4 != null) {
        } else {
            obj5 = CouponDiscount.Companion.createEmptyObject();
        }
        return obj5;
    }

    public static Boolean h(Boolean boolean) {
        return BillingRepository.validateDiscount$lambda-6(boolean);
    }

    private final void handlePurchaseInRoom(long l) {
        String str;
        if (this.dateUtils.e(l) == null) {
            str = "";
        }
        super(this.authService.v(), "user", l, obj4, str, this.dateUtils.g(), obj7);
        this.dogoPremiumStatusDao.b(dogoPremiumStatusEntity2).e();
    }

    private final void trackPurchaseCompleted(String string, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2) {
        int i;
        String str;
        String originalJson = dogoSkuDetails2.getOriginalJson();
        n.d(originalJson);
        SkuDetails skuDetails = new SkuDetails(originalJson);
        final int i3 = 1;
        i = j1.n0(skuDetails) > 0 ? i3 : 0;
        String str4 = skuDetails.m();
        n.e(str4, "skuDetails.priceCurrencyCode");
        t0 t0Var = new t0();
        if (this.preferenceService.G() == null) {
            str = "";
        }
        o oVar = new o(t0Var, str);
        r2 r2Var = new r2();
        o oVar2 = new o(r2Var, string);
        g2 obj12 = new g2();
        o oVar3 = new o(obj12, skuDetails.n());
        obj12 = new p1();
        o oVar4 = new o(obj12, Double.valueOf(o.a.a(d3 *= d, obj6)));
        obj12 = new o1();
        o oVar5 = new o(obj12, "USD");
        this.tracker.e(o0.b.c(oVar, oVar2, oVar3, oVar4, oVar5), i3);
    }

    private static final g0 validateAndSaveDiscount$lambda-2(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, String string2, Boolean boolean3) {
        n.f(billingRepository, "this$0");
        n.f(string2, "$couponId");
        n.f(boolean3, "isCouponValid");
        if (!boolean3.booleanValue()) {
        } else {
            d1 d1Var = new d1();
            billingRepository.tracker.d(o0.e.c(d1Var, string2));
            return billingRepository.fetchAndSaveDiscount(string2);
        }
        CouponExceptions.AlreadyUsed obj2 = new CouponExceptions.AlreadyUsed();
        throw obj2;
    }

    private static final g0 validateAndSaveDiscountPromoCode$lambda-1(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, String string2) {
        n.f(billingRepository, "this$0");
        n.f(string2, "couponId");
        if (z ^= 1 == 0) {
        } else {
            return billingRepository.validateAndSaveDiscount(string2);
        }
        CouponExceptions.DoesNotExists obj1 = new CouponExceptions.DoesNotExists();
        throw obj1;
    }

    private static final Boolean validateDiscount$lambda-6(Boolean boolean) {
        n.f(boolean, "it");
        return Boolean.valueOf(obj1 ^= 1);
    }

    public final a0<CouponDiscount> getDiscount() {
        a aVar = new a(this);
        a0 a0Var2 = this.couponEntityDao.b().map(aVar);
        n.e(a0Var2, "couponEntityDao.getLastActivatedCoupon().map {\n            val item = it.toItem()\n            val isDiscountStillValid = dateUtils.currentTimeInMillis < item.endTimeMs ?: 0\n            if (isDiscountStillValid) item else CouponDiscount.createEmptyObject()\n        }");
        return a0Var2;
    }

    public final void handlePurchase(String string, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2, Purchase purchase3, PurchaserInfo purchaserInfo4) {
        int obj2;
        n.f(string, "viewSource");
        n.f(dogoSkuDetails2, "dogoSkuDetails");
        n.f(purchase3, "purchase");
        n.f(purchaserInfo4, "purchaserInfo");
        trackPurchaseCompleted(string, dogoSkuDetails2);
        final String obj3 = dogoSkuDetails2.getSku();
        obj2 = purchaserInfo4.getAllExpirationDatesByProduct().get(obj3);
        if ((Date)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = (Date)obj2.getTime();
        }
        handlePurchaseInRoom(obj2);
    }

    public final void handleRestorePurchase(long l) {
        handlePurchaseInRoom(l);
    }

    public final b saveSpecialOfferCoupon(SpecialOfferCoupon specialOfferCoupon) {
        n.f(specialOfferCoupon, "coupon");
        CouponEntity[] arr = new CouponEntity[1];
        return this.couponEntityDao.f(specialOfferCoupon.toEntity(this.dateUtils.g()));
    }

    public final a0<CouponDiscount> validateAndSaveDiscount(String string) {
        n.f(string, "couponId");
        e eVar = new e(this, string);
        final a0 obj3 = validateDiscount(string).flatMap(eVar);
        n.e(obj3, "validateDiscount(couponId).flatMap { isCouponValid ->\n            if (isCouponValid) {\n                tracker.logEvent(E.Subscription.CouponActivated.withParameters(EP.Code(), couponId))\n                fetchAndSaveDiscount(couponId)\n            } else {\n                throw CouponExceptions.AlreadyUsed()\n            }\n        }");
        return obj3;
    }

    public final a0<CouponDiscount> validateAndSaveDiscountPromoCode(String string, String string2) {
        n.f(string, "linkType");
        n.f(string2, "partner");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append('_');
        stringBuilder.append(string2);
        b obj3 = new b(this);
        a0 obj2 = fetchCouponCodeForPromo(stringBuilder.toString()).flatMap(obj3);
        n.e(obj2, "fetchCouponCodeForPromo(\"${linkType}_$partner\").flatMap { couponId ->\n            if (couponId.isNotBlank()) {\n                validateAndSaveDiscount(couponId)\n            } else {\n                throw CouponExceptions.DoesNotExists()\n            }\n        }");
        return obj2;
    }

    public final a0<Boolean> validateDiscount(String string) {
        n.f(string, "couponId");
        a0 obj2 = this.couponEntityDao.a(string).map(h.a);
        n.e(obj2, "couponEntityDao.isCouponUsed(couponId).map { !it }");
        return obj2;
    }
}
