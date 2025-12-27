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

/* compiled from: GetOnboardingDogIdInteractor.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0002J\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingDogIdInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "getDogIdOrAddNewDog", "Lio/reactivex/Single;", "", "getOnboardingDogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r2, reason: from kotlin metadata */
public final class GetOnboardingDogIdInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final h2 userRepository;
    public r2(p1 p1Var, h2 h2Var) {
        n.f(p1Var, "userRepository");
        n.f(h2Var, "authService");
        super();
        this.authService = p1Var;
        this.userRepository = h2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final a0<String> getDogIdOrAddNewDog() {
        a0 just;
        Object item;
        boolean z;
        String str3;
        Iterator it = this.authService.H().m().values().iterator();
        String str2 = null;
        while (it.hasNext()) {
            if (n.b((DogProfile)item.getCreatorId(), this.userRepository.v()) != null) {
                break;
            }
            str2 = null;
        }
        int i2 = str2;
        if (item != null) {
            str = "{\n            Single.just(userDog.id)\n        }";
            n.e(a0.just(item.getId()), str);
        } else {
            str = "{\n            userRepository.addNewDog().map { it.id }\n        }";
            n.e(UserRepository.d(this.authService, str2, 1, str2).map(kotlinx.coroutines.p.a), str);
        }
        return just;
    }

    private static final String b(DogProfile dogProfile) {
        n.f(dogProfile, "it");
        return dogProfile.getId();
    }

    private static final g0 d(r2 r2Var, Boolean boolean) {
        a0 flatMapped;
        n.f(r2Var, "this$0");
        n.f(boolean, "cacheExists");
        if (boolean.booleanValue()) {
            String str = null;
            flatMapped = UserRepository.d(r2Var.authService, str, 1, str).map(kotlinx.coroutines.n.a);
        } else {
            flatMapped = r2Var.authService.B0().flatMap(new kotlinx.coroutines.o(r2Var));
        }
        return flatMapped;
    }

    private static final String e(DogProfile dogProfile) {
        n.f(dogProfile, "it");
        return dogProfile.getId();
    }

    private static final g0 f(r2 r2Var, UserApiModel userApiModel) {
        n.f(r2Var, "this$0");
        n.f(userApiModel, "it");
        return r2Var.getDogIdOrAddNewDog();
    }

    public final a0<String> c() {
        a0 flatMapped;
        Object item = null;
        boolean z;
        String str2;
        Iterator it = this.authService.H().m().values().iterator();
        while (it.hasNext()) {
            if (n.b((DogProfile)item.getCreatorId(), this.userRepository.v()) != null) {
                break;
            }
        }
        int i = 0;
        if (item != null) {
            str = "{\n            Single.just(userDog.id)\n        }";
            n.e(a0.just(item.getId()), str);
        } else {
            str = "{\n            userRepository.doesCacheExists().flatMap { cacheExists ->\n                if (cacheExists) {\n                    userRepository.addNewDog().map { it.id }\n                } else {\n                    userRepository.updateUserCacheFromRemote().flatMap { getDogIdOrAddNewDog() }\n                }\n            }\n        }";
            n.e(this.authService.q().flatMap(new kotlinx.coroutines.q(this)), str);
        }
        return flatMapped;
    }

    public static /* synthetic */ String g(DogProfile dogProfile) {
        return GetOnboardingDogIdInteractor.e(dogProfile);
    }

    public static /* synthetic */ g0 h(r2 r2Var, UserApiModel userApiModel) {
        return GetOnboardingDogIdInteractor.f(r2Var, userApiModel);
    }

    public static /* synthetic */ String i(DogProfile dogProfile) {
        return GetOnboardingDogIdInteractor.b(dogProfile);
    }

    public static /* synthetic */ g0 j(r2 r2Var, Boolean boolean) {
        return GetOnboardingDogIdInteractor.d(r2Var, boolean);
    }
}
