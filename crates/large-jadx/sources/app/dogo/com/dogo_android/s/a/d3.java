package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity;
import app.dogo.com.dogo_android.s.b.e1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.externalmodel.model.responses.UserApiModel;
import app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel;
import i.b.a0;
import i.b.g0;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0016\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "debugRepository", "Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/DebugRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "isCurrentDogPremium", "Lio/reactivex/Single;", "", "dogId", "", "isDogPremiumOnErrorReturnFalse", "updateDogPremiumUserProperty", "", "isDogPremium", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d3 {

    public static final app.dogo.com.dogo_android.s.a.d3.a Companion;
    private static final long f;
    private final v2 a;
    private final p1 b;
    private final e1 c;
    private final app.dogo.com.dogo_android.s.a.n3 d;
    private final o3 e;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor$Companion;", "", "()V", "PREMIUM_CACHE_LIFETIME", "", "getPREMIUM_CACHE_LIFETIME", "()J", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        d3.a aVar = new d3.a(0);
        d3.Companion = aVar;
        d3.f = TimeUnit.HOURS.toMillis(1);
    }

    public d3(v2 v2, p1 p12, e1 e13, app.dogo.com.dogo_android.s.a.n3 n34, o3 o35) {
        n.f(v2, "timeUtils");
        n.f(p12, "userRepository");
        n.f(e13, "debugRepository");
        n.f(n34, "subscribeInteractor");
        n.f(o35, "tracker");
        super();
        this.a = v2;
        this.b = p12;
        this.c = e13;
        this.d = n34;
        this.e = o35;
    }

    public static a0 b(app.dogo.com.dogo_android.s.a.d3 d3, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = "";
        }
        return d3.a(obj1);
    }

    private static final g0 c(app.dogo.com.dogo_android.s.a.d3 d3, String string2) {
        n.f(d3, "this$0");
        n.f(string2, "currentDogId");
        return d3.e(string2);
    }

    private static final Boolean d(app.dogo.com.dogo_android.s.a.d3 d3, Boolean boolean2) {
        n.f(d3, "this$0");
        n.f(boolean2, "it");
        d3.p(boolean2.booleanValue());
        return boolean2;
    }

    private final a0<Boolean> e(String string) {
        b0 b0Var = new b0(this, string, this.a.g(), obj1);
        a0 obj5 = this.d.q().flatMap(b0Var).onErrorReturn(d0.a);
        n.e(obj5, "subscribeInteractor.revenueCatSubscribed().flatMap { isSubscribed ->\n            if (isSubscribed) {\n                Single.just(true)\n            } else {\n                userRepository.getPremiumStateForDog(dogId).flatMap { dogPremium ->\n                    val dogHasActivePremium = dogPremium.isActive(currentTime)\n                    if (dogHasActivePremium) {\n                        Single.just(dogHasActivePremium)\n                    } else {\n                        if (dogPremium.isCacheValid(currentTime, PREMIUM_CACHE_LIFETIME)) {\n                            Single.just(false)\n                        } else {\n                            userRepository.updateUserCacheFromRemote().map {\n                                val newDogPremium = it.dogs[dogId]?.isPremium(currentTime)\n                                newDogPremium == true\n                            }\n                        }\n                    }\n                }\n            }\n        }.onErrorReturn {\n            Timber.e(it)\n            false\n        }");
        return obj5;
    }

    private static final g0 f(app.dogo.com.dogo_android.s.a.d3 d3, String string2, long l3, Boolean boolean4) {
        Object g0Var;
        a0 obj1;
        boolean obj5;
        n.f(d3, "this$0");
        n.f(string2, "$dogId");
        n.f(obj5, "isSubscribed");
        if (obj5.booleanValue()) {
            obj1 = a0.just(Boolean.TRUE);
        } else {
            g0Var = new g0(l3, boolean4, d3, string2);
            obj1 = d3.b.D(string2).flatMap(g0Var);
        }
        return obj1;
    }

    private static final g0 g(long l, app.dogo.com.dogo_android.s.a.d3 d32, String string3, DogoPremiumStatusEntity dogoPremiumStatusEntity4) {
        boolean z;
        Object obj;
        long l2;
        int i;
        int i2;
        int i3;
        a0 obj9;
        Object obj11;
        Object obj13;
        n.f(string3, "this$0");
        n.f(dogoPremiumStatusEntity4, "$dogId");
        n.f(obj13, "dogPremium");
        final int i4 = 0;
        final int i5 = 2;
        final DogoPremiumStatusEntity dogoPremiumStatusEntity = l;
        z = m1.b(obj13, dogoPremiumStatusEntity, obj3, i4, obj5);
        if (z) {
            obj9 = a0.just(Boolean.valueOf(z));
        } else {
            if (m1.d(obj13, l, dogoPremiumStatusEntity, d3.f, i4, 0)) {
                obj9 = a0.just(Boolean.FALSE);
            } else {
                obj13 = new c0(dogoPremiumStatusEntity4, l, d32);
                obj9 = string3.b.B0().map(obj13);
            }
        }
        return obj9;
    }

    private static final Boolean h(String string, long l2, UserApiModel userApiModel3) {
        int obj1;
        n.f(string, "$dogId");
        n.f(obj4, "it");
        obj1 = obj4.getDogs().get(string);
        if ((UserApiModel.DogApiModel)obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = Boolean.valueOf((UserApiModel.DogApiModel)obj1.isPremium(l2));
        }
        return Boolean.valueOf(n.b(obj1, Boolean.TRUE));
    }

    private static final Boolean i(Throwable throwable) {
        n.f(throwable, "it");
        a.d(throwable);
        return Boolean.FALSE;
    }

    public static g0 j(app.dogo.com.dogo_android.s.a.d3 d3, String string2, long l3, Boolean boolean4) {
        return d3.f(d3, string2, l3, boolean4);
    }

    public static Boolean k(String string, long l2, UserApiModel userApiModel3) {
        return d3.h(string, l2, userApiModel3);
    }

    public static Boolean l(Throwable throwable) {
        return d3.i(throwable);
    }

    public static g0 m(app.dogo.com.dogo_android.s.a.d3 d3, String string2) {
        return d3.c(d3, string2);
    }

    public static Boolean n(app.dogo.com.dogo_android.s.a.d3 d3, Boolean boolean2) {
        d3.d(d3, boolean2);
        return boolean2;
    }

    public static g0 o(long l, app.dogo.com.dogo_android.s.a.d3 d32, String string3, DogoPremiumStatusEntity dogoPremiumStatusEntity4) {
        return d3.g(l, d32, string3, dogoPremiumStatusEntity4);
    }

    private final void p(boolean z) {
        String obj3;
        obj3 = z ? "premium_dog" : 0;
        this.e.q(q3.CurrentDogEntitlements, obj3);
    }

    public final a0<Boolean> a(String string) {
        boolean e0Var;
        a0 obj2;
        n.f(string, "dogId");
        if (this.c.a()) {
            obj2 = a0.just(Boolean.TRUE);
        } else {
            if (l.z(string)) {
                e0Var = new e0(this);
                obj2 = this.b.v().flatMap(e0Var);
            } else {
                obj2 = e(string);
            }
        }
        f0 f0Var = new f0(this);
        obj2 = obj2.map(f0Var);
        n.e(obj2, "if (debugRepository.forceUserDogPremium) {\n            Single.just(true)\n        } else {\n            if (dogId.isBlank()) {\n                userRepository.getCurrentDogIdSingle().flatMap { currentDogId -> isDogPremiumOnErrorReturnFalse(currentDogId) }\n            } else {\n                isDogPremiumOnErrorReturnFalse(dogId)\n            }\n        }.map {\n            updateDogPremiumUserProperty(it)\n            it\n        }");
        return obj2;
    }
}
