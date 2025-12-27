package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.CouponEntity;
import app.dogo.android.persistencedb.room.entity.CouponEntity.Companion;
import i.b.a0;
import i.b.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* compiled from: CouponEntityDao.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005H'J\u000e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005H'J!\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00070\r\"\u00020\u0007H'¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "", "deleteAll", "", "getAllCoupons", "Lio/reactivex/Single;", "", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "getLastActivatedCoupon", "getLatestCoupons", "insert", "Lio/reactivex/Completable;", "task", "", "([Lapp/dogo/android/persistencedb/room/entity/CouponEntity;)Lio/reactivex/Completable;", "isCouponUsed", "", "couponId", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s, reason: from kotlin metadata */
public interface CouponEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static a0<CouponEntity> a(s sVar) {
            n.f(sVar, "this");
            a0 map = sVar.e().map(app.dogo.android.persistencedb.room.dao.b.a);
            n.e(map, "getLatestCoupons().map {\n            it.firstOrNull() ?: CouponEntity.createEmptyObject()\n        }");
            return map;
        }

        private static CouponEntity b(List list) {
            Object obj;
            n.f(list, "it");
            if ((CouponEntity)p.Z(list) == null) {
                CouponEntity emptyObject = CouponEntity.Companion.createEmptyObject();
            }
            return obj;
        }

        public static a0<Boolean> c(s sVar, String str) {
            n.f(sVar, "this");
            n.f(str, "couponId");
            a0 onErrorReturn = sVar.c().map(new app.dogo.android.persistencedb.room.dao.d(str)).onErrorReturn(app.dogo.android.persistencedb.room.dao.c.a);
            n.e(onErrorReturn, "getAllCoupons().map { usedCoupons ->\n            usedCoupons.any { couponId.equals(it.couponId, ignoreCase = true) }\n        }.onErrorReturn { false }");
            return onErrorReturn;
        }

        private static Boolean d(String str, List list) {
            boolean hasNext;
            boolean z = true;
            Iterator it;
            n.f(str, "$couponId");
            n.f(list, "usedCoupons");
            hasNext = list instanceof Collection;
            z = true;
            int r1 = 0;
            return Boolean.valueOf(0);
        }

        private static Boolean e(Throwable th) {
            n.f(th, "it");
            return Boolean.FALSE;
        }

        public static /* synthetic */ CouponEntity f(List list) {
            return app.dogo.android.persistencedb.room.dao.s.a.b(list);
        }

        public static /* synthetic */ Boolean g(Throwable th) {
            return app.dogo.android.persistencedb.room.dao.s.a.e(th);
        }

        public static /* synthetic */ Boolean h(String str, List list) {
            return app.dogo.android.persistencedb.room.dao.s.a.d(str, list);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    a0<Boolean> insert(String task);

    /* renamed from: b, reason: from kotlin metadata */
    a0<CouponEntity> deleteAll();

    a0<List<CouponEntity>> c();

    void d();

    a0<List<CouponEntity>> e();

    /* renamed from: f, reason: from kotlin metadata */
    b isCouponUsed(CouponEntity... couponId);
}
