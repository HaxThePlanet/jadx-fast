package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.s.b.n1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.v.c;
import i.b.a0;
import i.b.g0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0008\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProfilePreviewInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "getDogProfileInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetDogProfileInteractor;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "trainingTimeRepository", "Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/interactor/GetDogProfileInteractor;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;)V", "getCurrentDogProfilePreview", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "isFullScreen", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getProfilePreview", "dogId", "", "isDogLast", "isParticipateVisible", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "isSizeCorrect", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t2 {

    private final p1 a;
    private final h2 b;
    private final app.dogo.com.dogo_android.s.a.m2 c;
    private final app.dogo.com.dogo_android.s.a.n3 d;
    private final t2 e;
    private final r2 f;
    private final p2 g;
    private final n1 h;
    public t2(p1 p1, h2 h22, app.dogo.com.dogo_android.s.a.m2 m23, app.dogo.com.dogo_android.s.a.n3 n34, t2 t25, r2 r26, p2 p27, n1 n18) {
        n.f(p1, "userRepository");
        n.f(h22, "authService");
        n.f(m23, "getDogProfileInteractor");
        n.f(n34, "subscribeInteractor");
        n.f(t25, "storageService");
        n.f(r26, "remoteConfigService");
        n.f(p27, "sharedPreferenceService");
        n.f(n18, "trainingTimeRepository");
        super();
        this.a = p1;
        this.b = h22;
        this.c = m23;
        this.d = n34;
        this.e = t25;
        this.f = r26;
        this.g = p27;
        this.h = n18;
    }

    private static final g0 b(app.dogo.com.dogo_android.s.a.t2 t2, String string2, m0 m03, boolean z4, Boolean boolean5) {
        n.f(t2, "this$0");
        n.f(string2, "$dogId");
        n.f(m03, "$scope");
        n.f(boolean5, "premium");
        u uVar = new u(t2, m03, boolean5, z4);
        return t2.c.d(string2).flatMap(uVar);
    }

    private static final g0 c(app.dogo.com.dogo_android.s.a.t2 t2, m0 m02, Boolean boolean3, boolean z4, DogProfile dogProfile5) {
        n.f(t2, "this$0");
        n.f(m02, "$scope");
        n.f(boolean3, "$premium");
        n.f(dogProfile5, "dogProfile");
        t tVar = new t(t2, dogProfile5, boolean3, z4);
        return t2.h.c(m02).map(tVar);
    }

    private static final ProfilePreview d(app.dogo.com.dogo_android.s.a.t2 t2, DogProfile dogProfile2, Boolean boolean3, boolean z4, TrainingStreakEntity trainingStreakEntity5) {
        int i;
        int i2;
        String str;
        Object obj = t2;
        n.f(t2, "this$0");
        Object obj3 = dogProfile2;
        n.f(dogProfile2, "$dogProfile");
        Object obj2 = boolean3;
        n.f(boolean3, "$premium");
        n.f(trainingStreakEntity5, "timeMetrics");
        if (z ^= i2 != 0 && n.b(dogProfile2.getCreatorId(), obj.b.v()) != null) {
            if (n.b(dogProfile2.getCreatorId(), obj.b.v()) != null) {
            } else {
                i2 = i;
            }
        } else {
        }
        super(dogProfile2, boolean3.booleanValue(), i2, t2.e(), t2.f(dogProfile2), z4, trainingStreakEntity5.getCurrentStreak(), trainingStreakEntity5.getLongestStreak(), trainingStreakEntity5.getTotalTrainingTimeSec(), obj12);
        return profilePreview;
    }

    private final boolean e() {
        int i;
        if (this.a.H().m().size() <= 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private final boolean f(DogProfile dogProfile) {
        boolean z;
        int i;
        int obj3;
        if (!this.a.K(o.WELCOME_CHALLENGE.getId()) && g(dogProfile.getId()) != null && obj3 ^= i != 0 && !this.f.e0(this.g.W())) {
            if (g(dogProfile.getId()) != null) {
                if (obj3 ^= i != 0) {
                    if (!this.f.e0(this.g.W())) {
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean g(String string) {
        int i;
        int[] obj5;
        obj5 = this.e.h(string, "avatar.jpg");
        i = 0;
        if (obj5 == null) {
            return i;
        }
        obj5 = this.e.e(obj5);
        final int i3 = 1;
        final int i4 = 800;
        if (obj5[i] >= i4 && obj5[i3] >= i4) {
            if (obj5[i3] >= i4) {
                i = i3;
            }
        }
        return i;
    }

    public static ProfilePreview h(app.dogo.com.dogo_android.s.a.t2 t2, DogProfile dogProfile2, Boolean boolean3, boolean z4, TrainingStreakEntity trainingStreakEntity5) {
        return t2.d(t2, dogProfile2, boolean3, z4, trainingStreakEntity5);
    }

    public static g0 i(app.dogo.com.dogo_android.s.a.t2 t2, m0 m02, Boolean boolean3, boolean z4, DogProfile dogProfile5) {
        return t2.c(t2, m02, boolean3, z4, dogProfile5);
    }

    public static g0 j(app.dogo.com.dogo_android.s.a.t2 t2, String string2, m0 m03, boolean z4, Boolean boolean5) {
        return t2.b(t2, string2, m03, z4, boolean5);
    }

    public final a0<ProfilePreview> a(String string, boolean z2, m0 m03) {
        n.f(string, "dogId");
        n.f(m03, "scope");
        v vVar = new v(this, string, m03, z2);
        final a0 obj3 = this.d.q().flatMap(vVar);
        n.e(obj3, "subscribeInteractor.revenueCatSubscribed().flatMap { premium ->\n            getDogProfileInteractor.getDogProfile(dogId).flatMap { dogProfile ->\n                trainingTimeRepository.getTimeTrainedSingle(scope).map { timeMetrics ->\n                    ProfilePreview(\n                        dogProfile = dogProfile,\n                        userPremium = premium,\n                        isLastDog = isDogLast(),\n                        isUserDogsCreator = authService.currentUserId.isNotBlank() && dogProfile.creatorId == authService.currentUserId,\n                        isParticipateBannerVisible = isParticipateVisible(dogProfile),\n                        fullScreen = isFullScreen,\n                        currentStreak = timeMetrics.currentStreak,\n                        longestStreak = timeMetrics.longestStreak,\n                        timeTrained = timeMetrics.totalTrainingTimeSec\n                    )\n                }\n            }\n        }");
        return obj3;
    }
}
