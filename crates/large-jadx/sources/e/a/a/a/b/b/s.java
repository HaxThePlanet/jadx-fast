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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005H'J\u000e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005H'J!\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00070\r\"\u00020\u0007H'¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013", d2 = {"Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "", "deleteAll", "", "getAllCoupons", "Lio/reactivex/Single;", "", "Lapp/dogo/android/persistencedb/room/entity/CouponEntity;", "getLastActivatedCoupon", "getLatestCoupons", "insert", "Lio/reactivex/Completable;", "task", "", "([Lapp/dogo/android/persistencedb/room/entity/CouponEntity;)Lio/reactivex/Completable;", "isCouponUsed", "", "couponId", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface s {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static a0<CouponEntity> a(e.a.a.a.b.b.s s) {
            n.f(s, "this");
            a0 obj1 = s.e().map(b.a);
            n.e(obj1, "getLatestCoupons().map {\n            it.firstOrNull() ?: CouponEntity.createEmptyObject()\n        }");
            return obj1;
        }

        private static CouponEntity b(List list) {
            Object obj1;
            n.f(list, "it");
            if ((CouponEntity)p.Z(list) == null) {
                obj1 = CouponEntity.Companion.createEmptyObject();
            }
            return obj1;
        }

        public static a0<Boolean> c(e.a.a.a.b.b.s s, String string2) {
            n.f(s, "this");
            n.f(string2, "couponId");
            d dVar = new d(string2);
            a0 obj1 = s.c().map(dVar).onErrorReturn(c.a);
            n.e(obj1, "getAllCoupons().map { usedCoupons ->\n            usedCoupons.any { couponId.equals(it.couponId, ignoreCase = true) }\n        }.onErrorReturn { false }");
            return obj1;
        }

        private static Boolean d(String string, List list2) {
            boolean empty;
            int i;
            Object obj4;
            n.f(string, "$couponId");
            n.f(list2, "usedCoupons");
            if (list2 instanceof Collection != null && list2.isEmpty()) {
                if (list2.isEmpty()) {
                    i = i2;
                } else {
                    obj4 = list2.iterator();
                    while (obj4.hasNext()) {
                        if (!l.x(string, (CouponEntity)obj4.next().getCouponId(), true)) {
                            break;
                        }
                    }
                }
            } else {
            }
            return Boolean.valueOf(i);
        }

        private static Boolean e(Throwable throwable) {
            n.f(throwable, "it");
            return Boolean.FALSE;
        }

        public static CouponEntity f(List list) {
            return s.a.b(list);
        }

        public static Boolean g(Throwable throwable) {
            return s.a.e(throwable);
        }

        public static Boolean h(String string, List list2) {
            return s.a.d(string, list2);
        }
    }
    public abstract a0<Boolean> a(String string);

    public abstract a0<CouponEntity> b();

    public abstract a0<List<CouponEntity>> c();

    public abstract void d();

    public abstract a0<List<CouponEntity>> e();

    public abstract b f(CouponEntity... couponEntityArr);
}
