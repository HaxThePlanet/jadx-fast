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

/* compiled from: IsDogPremiumInteractor.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0016\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "debugRepository", "Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/DebugRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "isCurrentDogPremium", "Lio/reactivex/Single;", "", "dogId", "", "isDogPremiumOnErrorReturnFalse", "updateDogPremiumUserProperty", "", "isDogPremium", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d3, reason: from kotlin metadata */
public final class IsDogPremiumInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final d3.a INSTANCE = new d3$a(0);
    private static final long f = 0L;
    /* renamed from: a, reason: from kotlin metadata */
    private final v2 debugRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 subscribeInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final e1 timeUtils;
    /* renamed from: d, reason: from kotlin metadata */
    private final n3 tracker;
    /* renamed from: e, reason: from kotlin metadata */
    private final o3 userRepository;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor$Companion;", "", "()V", "PREMIUM_CACHE_LIFETIME", "", "getPREMIUM_CACHE_LIFETIME", "()J", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    static {
        IsDogPremiumInteractor.f = TimeUnit.HOURS.toMillis(1L);
    }

    public d3(v2 v2Var, p1 p1Var, e1 e1Var, n3 n3Var, o3 o3Var) {
        n.f(v2Var, "timeUtils");
        n.f(p1Var, "userRepository");
        n.f(e1Var, "debugRepository");
        n.f(n3Var, "subscribeInteractor");
        n.f(o3Var, "tracker");
        super();
        this.debugRepository = v2Var;
        this.subscribeInteractor = p1Var;
        this.timeUtils = e1Var;
        this.tracker = n3Var;
        this.userRepository = o3Var;
    }

    public static /* synthetic */ a0 b(d3 d3Var, String str, int i, Object object) {
        if (i & 1 != 0) {
            str = "";
        }
        return d3Var.a(str);
    }

    private static final g0 c(d3 d3Var, String str) {
        n.f(d3Var, "this$0");
        n.f(str, "currentDogId");
        return d3Var.isCurrentDogPremium(str);
    }

    private static final Boolean d(d3 d3Var, Boolean boolean) {
        n.f(d3Var, "this$0");
        n.f(boolean, "it");
        d3Var.p(boolean.booleanValue());
        return boolean;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final a0<Boolean> isCurrentDogPremium(String dogId) {
        a0 onErrorReturn = this.tracker.q().flatMap(new kotlinx.coroutines.b0(this, dogId, this.debugRepository.g(), r1)).onErrorReturn(kotlinx.coroutines.d0.a);
        n.e(onErrorReturn, "subscribeInteractor.revenueCatSubscribed().flatMap { isSubscribed ->\n            if (isSubscribed) {\n                Single.just(true)\n            } else {\n                userRepository.getPremiumStateForDog(dogId).flatMap { dogPremium ->\n                    val dogHasActivePremium = dogPremium.isActive(currentTime)\n                    if (dogHasActivePremium) {\n                        Single.just(dogHasActivePremium)\n                    } else {\n                        if (dogPremium.isCacheValid(currentTime, PREMIUM_CACHE_LIFETIME)) {\n                            Single.just(false)\n                        } else {\n                            userRepository.updateUserCacheFromRemote().map {\n                                val newDogPremium = it.dogs[dogId]?.isPremium(currentTime)\n                                newDogPremium == true\n                            }\n                        }\n                    }\n                }\n            }\n        }.onErrorReturn {\n            Timber.e(it)\n            false\n        }");
        return onErrorReturn;
    }

    private static final g0 f(d3 d3Var, String str, long j, Boolean boolean) {
        a0 flatMapped;
        n.f(d3Var, "this$0");
        n.f(str, "$dogId");
        str = "isSubscribed";
        n.f(boolean, str);
        if (boolean.booleanValue()) {
            flatMapped = a0.just(Boolean.TRUE);
        } else {
            flatMapped = d3Var.subscribeInteractor.D(str).flatMap(new kotlinx.coroutines.g0(j, r4, d3Var, str));
        }
        return flatMapped;
    }

    private static final g0 g(long j, d3 d3Var, String str, DogoPremiumStatusEntity dogoPremiumStatusEntity) {
        a0 just;
        n.f(d3Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogoPremiumStatusEntity, "dogPremium");
        final long l3 = 0L;
        final Object obj2 = 2;
        int i2 = 0;
        final DogoPremiumStatusEntity j3 = j;
        boolean z = app.dogo.com.dogo_android.util.extensionfunction.m1.b(dogoPremiumStatusEntity, j3, l3, obj2, i2);
        if (z) {
            just = a0.just(Boolean.valueOf(z));
        } else {
            int i = 0;
            i2 = 4;
            int i3 = 0;
            if (app.dogo.com.dogo_android.util.extensionfunction.m1.d(dogoPremiumStatusEntity, j, IsDogPremiumInteractor.f, i, i2, i3)) {
                just = a0.just(Boolean.FALSE);
            } else {
                just = d3Var.subscribeInteractor.B0().map(new kotlinx.coroutines.c0(str, j, r10));
            }
        }
        return just;
    }

    private static final Boolean h(String str, long j, UserApiModel userApiModel) {
        Boolean str2 = null;
        n.f(str, "$dogId");
        n.f(userApiModel, "it");
        Object value = userApiModel.getDogs().get(str);
        if (value == null) {
            int i = 0;
        } else {
            str2 = Boolean.valueOf(value.isPremium(j));
        }
        return Boolean.valueOf(n.b(str2, Boolean.TRUE));
    }

    /* renamed from: i, reason: from kotlin metadata */
    private static final Boolean isDogPremiumOnErrorReturnFalse(Throwable dogId) {
        n.f(dogId, "it");
        a.d(dogId);
        return Boolean.FALSE;
    }

    private final void p(boolean z) {
        String str = null;
        z = z ? "premium_dog" : 0;
        this.userRepository.setUserProperty(UserProperty.CurrentDogEntitlements, (z ? "premium_dog" : 0));
    }

    public final a0<Boolean> a(String str) {
        a0 currentDogPremium;
        n.f(str, "dogId");
        if (this.timeUtils.a()) {
            currentDogPremium = a0.just(Boolean.TRUE);
        } else {
            if (l.z(str)) {
                currentDogPremium = this.subscribeInteractor.v().flatMap(new kotlinx.coroutines.e0(this));
            } else {
                currentDogPremium = isCurrentDogPremium(str);
            }
        }
        a0 map = currentDogPremium.map(new kotlinx.coroutines.f0(this));
        n.e(map, "if (debugRepository.forceUserDogPremium) {\n            Single.just(true)\n        } else {\n            if (dogId.isBlank()) {\n                userRepository.getCurrentDogIdSingle().flatMap { currentDogId -> isDogPremiumOnErrorReturnFalse(currentDogId) }\n            } else {\n                isDogPremiumOnErrorReturnFalse(dogId)\n            }\n        }.map {\n            updateDogPremiumUserProperty(it)\n            it\n        }");
        return map;
    }

    public static /* synthetic */ g0 j(d3 d3Var, String str, long j, Boolean boolean) {
        return IsDogPremiumInteractor.f(d3Var, str, j, boolean);
    }

    public static /* synthetic */ Boolean k(String str, long j, UserApiModel userApiModel) {
        return IsDogPremiumInteractor.h(str, j, userApiModel);
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static /* synthetic */ Boolean updateDogPremiumUserProperty(Throwable isDogPremium) {
        return IsDogPremiumInteractor.isDogPremiumOnErrorReturnFalse(isDogPremium);
    }

    public static /* synthetic */ g0 m(d3 d3Var, String str) {
        return IsDogPremiumInteractor.c(d3Var, str);
    }

    public static /* synthetic */ Boolean n(d3 d3Var, Boolean boolean) {
        IsDogPremiumInteractor.d(d3Var, boolean);
        return boolean;
    }

    public static /* synthetic */ g0 o(long j, d3 d3Var, String str, DogoPremiumStatusEntity dogoPremiumStatusEntity) {
        return IsDogPremiumInteractor.g(j, d3Var, str, dogoPremiumStatusEntity);
    }
}
