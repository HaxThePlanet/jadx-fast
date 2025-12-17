package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.v.c;
import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.a0;
import i.b.g0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0002J\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingDogIdInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "getDogIdOrAddNewDog", "Lio/reactivex/Single;", "", "getOnboardingDogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r2 {

    private final p1 a;
    private final h2 b;
    public r2(p1 p1, h2 h22) {
        n.f(p1, "userRepository");
        n.f(h22, "authService");
        super();
        this.a = p1;
        this.b = h22;
    }

    private final a0<String> a() {
        a0 just;
        Object next;
        String str;
        int i;
        boolean z;
        String str2;
        Iterator iterator = this.a.H().m().values().iterator();
        i = 0;
        for (Object next : iterator) {
            i = 0;
        }
        next = i;
        if ((DogProfile)next != null) {
            n.e(a0.just((DogProfile)next.getId()), "{\n            Single.just(userDog.id)\n        }");
        } else {
            n.e(p1.d(this.a, i, 1, i).map(p.a), "{\n            userRepository.addNewDog().map { it.id }\n        }");
        }
        return just;
    }

    private static final String b(DogProfile dogProfile) {
        n.f(dogProfile, "it");
        return dogProfile.getId();
    }

    private static final g0 d(app.dogo.com.dogo_android.s.a.r2 r2, Boolean boolean2) {
        int oVar;
        a0 obj1;
        Object obj2;
        n.f(r2, "this$0");
        n.f(boolean2, "cacheExists");
        if (boolean2.booleanValue()) {
            oVar = 0;
            obj1 = p1.d(r2.a, oVar, 1, oVar).map(n.a);
        } else {
            oVar = new o(r2);
            obj1 = r2.a.B0().flatMap(oVar);
        }
        return obj1;
    }

    private static final String e(DogProfile dogProfile) {
        n.f(dogProfile, "it");
        return dogProfile.getId();
    }

    private static final g0 f(app.dogo.com.dogo_android.s.a.r2 r2, UserApiModel userApiModel2) {
        n.f(r2, "this$0");
        n.f(userApiModel2, "it");
        return r2.a();
    }

    public static String g(DogProfile dogProfile) {
        return r2.e(dogProfile);
    }

    public static g0 h(app.dogo.com.dogo_android.s.a.r2 r2, UserApiModel userApiModel2) {
        return r2.f(r2, userApiModel2);
    }

    public static String i(DogProfile dogProfile) {
        return r2.b(dogProfile);
    }

    public static g0 j(app.dogo.com.dogo_android.s.a.r2 r2, Boolean boolean2) {
        return r2.d(r2, boolean2);
    }

    public final a0<String> c() {
        a0 flatMap;
        Object next;
        String str2;
        boolean z;
        String str;
        Iterator iterator = this.a.H().m().values().iterator();
        for (Object next : iterator) {
        }
        next = 0;
        if ((DogProfile)next != null) {
            n.e(a0.just((DogProfile)next.getId()), "{\n            Single.just(userDog.id)\n        }");
        } else {
            q qVar = new q(this);
            n.e(this.a.q().flatMap(qVar), "{\n            userRepository.doesCacheExists().flatMap { cacheExists ->\n                if (cacheExists) {\n                    userRepository.addNewDog().map { it.id }\n                } else {\n                    userRepository.updateUserCacheFromRemote().flatMap { getDogIdOrAddNewDog() }\n                }\n            }\n        }");
        }
        return flatMap;
    }
}
