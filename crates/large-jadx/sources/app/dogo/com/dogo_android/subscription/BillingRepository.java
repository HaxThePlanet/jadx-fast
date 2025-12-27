package app.dogo.com.dogo_android.subscription;

import app.dogo.android.persistencedb.room.entity.CouponEntity;
import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.com.dogo_android.model.CouponModel;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount.Companion;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.AlreadyUsed;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.DoesNotExists;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.w.d1;
import app.dogo.com.dogo_android.w.g2;
import app.dogo.com.dogo_android.w.o0;
import app.dogo.com.dogo_android.w.o1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p1;
import app.dogo.com.dogo_android.w.t0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.y2;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.revenuecat.purchases.PurchaserInfo;
import e.a.a.a.b.b.s;
import i.b.b;
import i.b.g0;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: BillingRepository.kt */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020(J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0018\u0010/\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0014\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u001c\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0017J\u0014\u00104\u001a\u0008\u0012\u0004\u0012\u0002050\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dateUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogoPremiumStatusDao", "Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;", "firebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "couponEntityDao", "Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/android/persistencedb/room/dao/DogoPremiumStatusDao;Lcom/google/firebase/database/FirebaseDatabase;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;)V", "fetchAndSaveDiscount", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "couponId", "", "fetchCoupon", "Lapp/dogo/com/dogo_android/model/CouponModel;", "fetchCouponCodeForPromo", "promoCode", "getDiscount", "handlePurchase", "", "viewSource", "dogoSkuDetails", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "purchase", "Lcom/android/billingclient/api/Purchase;", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;", "handlePurchaseInRoom", "expirationTimestamp", "", "handleRestorePurchase", "expirationTimeStamp", "saveSpecialOfferCoupon", "Lio/reactivex/Completable;", "coupon", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "trackPurchaseCompleted", "validateAndSaveDiscount", "validateAndSaveDiscountPromoCode", "linkType", "partner", "validateDiscount", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BillingRepository {

    private final h2 authService;
    private final s couponEntityDao;
    private final v2 dateUtils;
    private final e.a.a.a.b.b.a0 dogoPremiumStatusDao;
    private final FirebaseDatabase firebaseDatabase;
    private final p2 preferenceService;
    private final app.dogo.com.dogo_android.service.r2 remoteConfigService;
    private final o3 tracker;
    public BillingRepository(o3 o3Var, v2 v2Var, e.a.a.a.b.b.a0 a0Var, FirebaseDatabase firebaseDatabase, h2 h2Var, p2 p2Var, app.dogo.com.dogo_android.service.r2 r2Var, s sVar) {
        n.f(o3Var, "tracker");
        n.f(v2Var, "dateUtils");
        n.f(a0Var, "dogoPremiumStatusDao");
        n.f(firebaseDatabase, "firebaseDatabase");
        n.f(h2Var, "authService");
        n.f(p2Var, "preferenceService");
        n.f(r2Var, "remoteConfigService");
        n.f(sVar, "couponEntityDao");
        super();
        this.tracker = o3Var;
        this.dateUtils = v2Var;
        this.dogoPremiumStatusDao = a0Var;
        this.firebaseDatabase = firebaseDatabase;
        this.authService = h2Var;
        this.preferenceService = p2Var;
        this.remoteConfigService = r2Var;
        this.couponEntityDao = sVar;
    }

    private final i.b.a0<CouponDiscount> fetchAndSaveDiscount(String str) {
        i.b.a0 flatMapped = fetchCoupon(str).flatMap(new c(this));
        n.e(flatMapped, "fetchCoupon(couponId).flatMap {\n            val entity = it.toEntity(dateUtils.currentTimeInMillis)\n            if (entity != null) {\n                couponEntityDao.insert(entity).toSingle { entity.toItem() }\n            } else {\n                throw CouponExceptions.DoesNotExists()\n            }\n        }");
        return flatMapped;
    }

    private static final g0 fetchAndSaveDiscount$lambda_4(BillingRepository billingRepository, CouponModel couponModel) throws CouponExceptions.DoesNotExists {
        n.f(billingRepository, "this$0");
        n.f(couponModel, "it");
        final CouponEntity couponEntity = app.dogo.com.dogo_android.util.extensionfunction.m1.k(couponModel, billingRepository.dateUtils.g());
        if (couponEntity == null) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new CouponExceptions_DoesNotExists();
        } else {
            CouponEntity[] arr = new CouponEntity[1];
            return billingRepository.couponEntityDao.isCouponUsed(couponEntity).B(new f(couponEntity));
        }
    }

    private static final CouponDiscount fetchAndSaveDiscount$lambda_4$lambda_3(CouponEntity couponEntity) {
        return app.dogo.com.dogo_android.util.extensionfunction.m1.o(couponEntity);
    }

    private final i.b.a0<CouponModel> fetchCoupon(String str) {
        DatabaseReference child = this.firebaseDatabase.getReference().child(n.o("coupons/", str));
        n.e(child, "firebaseDatabase.reference.child(\"coupons/$couponId\")");
        final i.b.a0 map = app.dogo.com.dogo_android.util.extensionfunction.j1.O0(child).map(new g(str));
        n.e(map, "firebaseDatabase.reference.child(\"coupons/$couponId\").toSingle().map { couponData ->\n            val item = couponData.getValue(CouponModel::class.java)?.apply { this.couponId = couponId }\n            item ?: CouponModel()\n        }");
        return map;
    }

    private static final CouponModel fetchCoupon$lambda_8(String str, DataSnapshot dataSnapshot) {
        int i2 = 0;
        n.f(str, "$couponId");
        n.f(dataSnapshot, "couponData");
        dataSnapshot22 = CouponModel.class;
        Object value = dataSnapshot.getValue(dataSnapshot22);
        if (value == null) {
            i2 = 0;
        } else {
            value.setCouponId(str);
        }
        if (i2 == 0) {
            Long l = null;
            Long l2 = null;
            String str2 = null;
            String str3 = null;
            int i = 15;
            kotlin.d0.d.g gVar = null;
            CouponModel dataSnapshot22 = new CouponModel(l, l2, str2, str3, i, gVar);
        }
        return i2;
    }

    private final i.b.a0<String> fetchCouponCodeForPromo(String promoCode) {
        DatabaseReference child = this.firebaseDatabase.getReference().child(n.o("couponLink/", promoCode));
        n.e(child, "firebaseDatabase.reference.child(\"couponLink/$promoCode\")");
        i.b.a0 map = app.dogo.com.dogo_android.util.extensionfunction.j1.O0(child).map(d.a);
        n.e(map, "firebaseDatabase.reference.child(\"couponLink/$promoCode\").toSingle().map { promoData ->\n            val couponCode = (promoData.child(\"couponCode\").value as? String)\n            couponCode ?: \"\"\n        }");
        return map;
    }

    private static final String fetchCouponCodeForPromo$lambda_5(DataSnapshot dataSnapshot) {
        Object value = null;
        n.f(dataSnapshot, "promoData");
        dataSnapshot = dataSnapshot.child("couponCode").getValue() instanceof String ? (String)dataSnapshot.child("couponCode").getValue() : 0;
        if (value == null) {
            String str3 = "";
        }
        return value;
    }

    private static final CouponDiscount getDiscount$lambda_0(BillingRepository billingRepository, CouponEntity couponEntity) {
        long value = 0;
        int i = 0;
        CouponDiscount emptyObject;
        n.f(billingRepository, "this$0");
        n.f(couponEntity, "it");
        long l = billingRepository.dateUtils.g();
        Long endTimeMs = app.dogo.com.dogo_android.util.extensionfunction.m1.o(couponEntity).getEndTimeMs();
        if (endTimeMs == null) {
            int i2 = 0;
        } else {
            value = endTimeMs.longValue();
        }
        billingRepository = l < value ? 1 : 0;
        if (billingRepository.dateUtils == 0) {
            emptyObject = CouponDiscount.INSTANCE.createEmptyObject();
        }
        return emptyObject;
    }

    private final void handlePurchaseInRoom(long j) {
        String str;
        if (this.dateUtils.e(j) == null) {
            str = "";
        }
        DogoPremiumStatusEntity dogoPremiumStatusEntity = new DogoPremiumStatusEntity(this.authService.v(), "user", j, str4, str, this.dateUtils.g(), obj);
        this.dogoPremiumStatusDao.getPremiumStateForUser(dogoPremiumStatusEntity).e();
    }

    private final void trackPurchaseCompleted(String str, DogoSkuDetails dogoSkuDetails) {
        boolean z = false;
        String str2;
        String originalJson = dogoSkuDetails.getOriginalJson();
        n.d(originalJson);
        SkuDetails skuDetails = new SkuDetails(originalJson);
        final boolean z2 = true;
        boolean r1 = app.dogo.com.dogo_android.util.extensionfunction.j1.n0(skuDetails) > 0 ? z2 : 0;
        r1 = skuDetails.m();
        n.e(r1, "skuDetails.priceCurrencyCode");
        if (this.preferenceService.G() == null) {
            str2 = "";
        }
        Pair pair = new Pair(new EP_AffiliateSource(), str2);
        this.tracker.logEvent(E_Subscription.b.withParameters(pair, new Pair(new EP_ViewSource(), str), new Pair(new EP_SkuId(), skuDetails.n()), new Pair(new EP_FireAnalyticsValue(), Double.valueOf(CurrencyConverter.currencyTable.convertToUsd(app.dogo.com.dogo_android.util.extensionfunction.j1.cachedFirstContentFetch(skuDetails) * this.remoteConfigService.g(dogoSkuDetails.getSubscriptionPeriod(), (app.dogo.com.dogo_android.util.extensionfunction.j1.n0(skuDetails) > 0 ? z2 : 0)), str7, r1))), new Pair(new EP_FireAnalyticsCurrency(), "USD")), z2);
    }

    private static final g0 validateAndSaveDiscount$lambda_2(BillingRepository billingRepository, String str, Boolean boolean) throws CouponExceptions.AlreadyUsed {
        n.f(billingRepository, "this$0");
        n.f(str, "$couponId");
        n.f(boolean, "isCouponValid");
        if (!boolean.booleanValue()) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new CouponExceptions_AlreadyUsed();
        } else {
            billingRepository.tracker.logEvent(E_Subscription.e.c(new EP_Code(), str));
            return billingRepository.fetchAndSaveDiscount(str);
        }
    }

    private static final g0 validateAndSaveDiscountPromoCode$lambda_1(BillingRepository billingRepository, String str) throws CouponExceptions.DoesNotExists {
        n.f(billingRepository, "this$0");
        n.f(str, "couponId");
        if (!l.z(str) == 0) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new CouponExceptions_DoesNotExists();
        } else {
            return billingRepository.validateAndSaveDiscount(str);
        }
    }

    private static final Boolean validateDiscount$lambda_6(Boolean boolean) {
        n.f(boolean, "it");
        return Boolean.valueOf(!boolean.booleanValue());
    }

    public final i.b.a0<CouponDiscount> getDiscount() {
        i.b.a0 map = this.couponEntityDao.deleteAll().map(new a(this));
        n.e(map, "couponEntityDao.getLastActivatedCoupon().map {\n            val item = it.toItem()\n            val isDiscountStillValid = dateUtils.currentTimeInMillis < item.endTimeMs ?: 0\n            if (isDiscountStillValid) item else CouponDiscount.createEmptyObject()\n        }");
        return map;
    }

    public final void handlePurchase(String viewSource, DogoSkuDetails dogoSkuDetails, Purchase purchase, PurchaserInfo purchaserInfo) {
        int i = 0;
        n.f(viewSource, "viewSource");
        n.f(dogoSkuDetails, "dogoSkuDetails");
        n.f(purchase, "purchase");
        n.f(purchaserInfo, "purchaserInfo");
        trackPurchaseCompleted(viewSource, dogoSkuDetails);
        final String sku = dogoSkuDetails.getSku();
        Object value = purchaserInfo.getAllExpirationDatesByProduct().get(sku);
        if (value == null) {
            i = 0;
        } else {
            long time = value.getTime();
        }
        handlePurchaseInRoom(i);
    }

    public final void handleRestorePurchase(long expirationTimeStamp) {
        handlePurchaseInRoom(expirationTimeStamp);
    }

    public final b saveSpecialOfferCoupon(SpecialOfferCoupon coupon) {
        n.f(coupon, "coupon");
        CouponEntity[] arr = new CouponEntity[1];
        return this.couponEntityDao.isCouponUsed(coupon.toEntity(this.dateUtils.g()));
    }

    public final i.b.a0<CouponDiscount> validateAndSaveDiscount(String couponId) {
        n.f(couponId, "couponId");
        final i.b.a0 flatMapped = validateDiscount(couponId).flatMap(new e(this, couponId));
        n.e(flatMapped, "validateDiscount(couponId).flatMap { isCouponValid ->\n            if (isCouponValid) {\n                tracker.logEvent(E.Subscription.CouponActivated.withParameters(EP.Code(), couponId))\n                fetchAndSaveDiscount(couponId)\n            } else {\n                throw CouponExceptions.AlreadyUsed()\n            }\n        }");
        return flatMapped;
    }

    public final i.b.a0<CouponDiscount> validateAndSaveDiscountPromoCode(String str, String str2) {
        n.f(str, "linkType");
        n.f(str2, "partner");
        StringBuilder stringBuilder = new StringBuilder();
        str5 = str + 95 + str2;
        i.b.a0 flatMapped = fetchCouponCodeForPromo(str5).flatMap(new b(this));
        n.e(flatMapped, "fetchCouponCodeForPromo(\"${linkType}_$partner\").flatMap { couponId ->\n            if (couponId.isNotBlank()) {\n                validateAndSaveDiscount(couponId)\n            } else {\n                throw CouponExceptions.DoesNotExists()\n            }\n        }");
        return flatMapped;
    }

    public final i.b.a0<Boolean> validateDiscount(String couponId) {
        n.f(couponId, "couponId");
        i.b.a0 map = this.couponEntityDao.insert(couponId).map(h.a);
        n.e(map, "couponEntityDao.isCouponUsed(couponId).map { !it }");
        return map;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static /* synthetic */ CouponDiscount trackPurchaseCompleted(BillingRepository viewSource, CouponEntity dogoSkuDetails) {
        return BillingRepository.getDiscount$lambda_0(viewSource, dogoSkuDetails);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static /* synthetic */ g0 validateAndSaveDiscountPromoCode(BillingRepository linkType, String partner) {
        return BillingRepository.validateAndSaveDiscountPromoCode$lambda_1(linkType, partner);
    }

    public static /* synthetic */ g0 c(BillingRepository billingRepository, CouponModel couponModel) {
        return BillingRepository.fetchAndSaveDiscount$lambda_4(billingRepository, couponModel);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static /* synthetic */ String fetchAndSaveDiscount(DataSnapshot couponId) {
        return BillingRepository.fetchCouponCodeForPromo$lambda_5(couponId);
    }

    public static /* synthetic */ g0 e(BillingRepository billingRepository, String str, Boolean boolean) {
        return BillingRepository.validateAndSaveDiscount$lambda_2(billingRepository, str, boolean);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static /* synthetic */ CouponDiscount fetchCoupon(CouponEntity couponId) {
        return BillingRepository.fetchAndSaveDiscount$lambda_4$lambda_3(couponId);
    }

    public static /* synthetic */ CouponModel g(String str, DataSnapshot dataSnapshot) {
        return BillingRepository.fetchCoupon$lambda_8(str, dataSnapshot);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static /* synthetic */ Boolean handlePurchaseInRoom(Boolean expirationTimestamp) {
        return BillingRepository.validateDiscount$lambda_6(expirationTimestamp);
    }
}
