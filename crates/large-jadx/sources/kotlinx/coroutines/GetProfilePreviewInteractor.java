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

/* compiled from: GetProfilePreviewInteractor.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0008\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProfilePreviewInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "getDogProfileInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetDogProfileInteractor;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "trainingTimeRepository", "Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/interactor/GetDogProfileInteractor;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;)V", "getCurrentDogProfilePreview", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "isFullScreen", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getProfilePreview", "dogId", "", "isDogLast", "isParticipateVisible", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "isSizeCorrect", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t2, reason: from kotlin metadata */
public final class GetProfilePreviewInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final h2 getDogProfileInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final m2 remoteConfigService;
    /* renamed from: d, reason: from kotlin metadata */
    private final n3 sharedPreferenceService;
    /* renamed from: e, reason: from kotlin metadata */
    private final t2 storageService;
    /* renamed from: f, reason: from kotlin metadata */
    private final r2 subscribeInteractor;
    /* renamed from: g, reason: from kotlin metadata */
    private final p2 trainingTimeRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final n1 userRepository;
    public t2(p1 p1Var, h2 h2Var, m2 m2Var, n3 n3Var, t2 t2Var, r2 r2Var, p2 p2Var, n1 n1Var) {
        n.f(p1Var, "userRepository");
        n.f(h2Var, "authService");
        n.f(m2Var, "getDogProfileInteractor");
        n.f(n3Var, "subscribeInteractor");
        n.f(t2Var, "storageService");
        n.f(r2Var, "remoteConfigService");
        n.f(p2Var, "sharedPreferenceService");
        n.f(n1Var, "trainingTimeRepository");
        super();
        this.authService = p1Var;
        this.getDogProfileInteractor = h2Var;
        this.remoteConfigService = m2Var;
        this.sharedPreferenceService = n3Var;
        this.storageService = t2Var;
        this.subscribeInteractor = r2Var;
        this.trainingTimeRepository = p2Var;
        this.userRepository = n1Var;
    }

    private static final g0 b(t2 t2Var, String str, m0 m0Var, boolean z, Boolean boolean) {
        n.f(t2Var, "this$0");
        n.f(str, "$dogId");
        n.f(m0Var, "$scope");
        n.f(boolean, "premium");
        return t2Var.remoteConfigService.d(str).flatMap(new kotlinx.coroutines.u(t2Var, m0Var, boolean, z));
    }

    private static final g0 c(t2 t2Var, m0 m0Var, Boolean boolean, boolean z, DogProfile dogProfile) {
        n.f(t2Var, "this$0");
        n.f(m0Var, "$scope");
        n.f(boolean, "$premium");
        n.f(dogProfile, "dogProfile");
        return t2Var.userRepository.c(m0Var).map(new kotlinx.coroutines.t(t2Var, dogProfile, boolean, z));
    }

    private static final ProfilePreview d(t2 t2Var, DogProfile dogProfile, Boolean boolean, boolean z, TrainingStreakEntity trainingStreakEntity) {
        boolean z3 = true;
        String str;
        Object t2Var2 = t2Var;
        n.f(t2Var, "this$0");
        n.f(dogProfile, "$dogProfile");
        n.f(boolean, "$premium");
        n.f(trainingStreakEntity, "timeMetrics");
        i = l.z(t2Var2.getDogProfileInteractor.v()) ^ 1;
        if (l.z(t2Var2.getDogProfileInteractor.v()) ^ 1 != null) {
            if (n.b(dogProfile.getCreatorId(), t2Var2.getDogProfileInteractor.v()) == null) {
                int i2 = 0;
            }
        }
        ProfilePreview profilePreview = new ProfilePreview(dogProfile, boolean.booleanValue(), z3, t2Var.isDogLast(), t2Var.isParticipateVisible(dogProfile), z, trainingStreakEntity.getCurrentStreak(), trainingStreakEntity.getLongestStreak(), trainingStreakEntity.getTotalTrainingTimeSec(), obj);
        return profilePreview;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean isDogLast() {
        boolean z = true;
        if (this.authService.H().m().size() > 1) {
            int i2 = 0;
        }
        return z;
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean isParticipateVisible(DogProfile dogProfile) {
        boolean sizeCorrect;
        boolean z2 = true;
        int i;
        if (!this.authService.K(SpecialChallenges.WELCOME_CHALLENGE.getId())) {
            if (isSizeCorrect(dogProfile.getId()) != null) {
                i = l.z(dogProfile.getName()) ^ 1;
                if (l.z(dogProfile.getName()) ^ i2 != null) {
                    if (this.subscribeInteractor.e0(this.trainingTimeRepository.W())) {
                        int i3 = 0;
                    }
                }
            }
        }
        return z2;
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final boolean isSizeCorrect(String dogId) {
        boolean z = false;
        android.net.Uri uri = this.storageService.h(dogId, "avatar.jpg");
        int i2 = 0;
        if (uri == null) {
            return false;
        }
        int[] iArr = this.storageService.e(uri);
        final int i = 1;
        final int i4 = 800;
        if (iArr[i2] >= i4) {
            if (iArr[i] >= i4) {
            }
        }
        return z;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<ProfilePreview> getProfilePreview(String dogId, boolean isFullScreen, m0 scope) {
        n.f(dogId, "dogId");
        n.f(scope, "scope");
        final a0 flatMapped = this.sharedPreferenceService.q().flatMap(new kotlinx.coroutines.v(this, dogId, scope, isFullScreen));
        n.e(flatMapped, "subscribeInteractor.revenueCatSubscribed().flatMap { premium ->\n            getDogProfileInteractor.getDogProfile(dogId).flatMap { dogProfile ->\n                trainingTimeRepository.getTimeTrainedSingle(scope).map { timeMetrics ->\n                    ProfilePreview(\n                        dogProfile = dogProfile,\n                        userPremium = premium,\n                        isLastDog = isDogLast(),\n                        isUserDogsCreator = authService.currentUserId.isNotBlank() && dogProfile.creatorId == authService.currentUserId,\n                        isParticipateBannerVisible = isParticipateVisible(dogProfile),\n                        fullScreen = isFullScreen,\n                        currentStreak = timeMetrics.currentStreak,\n                        longestStreak = timeMetrics.longestStreak,\n                        timeTrained = timeMetrics.totalTrainingTimeSec\n                    )\n                }\n            }\n        }");
        return flatMapped;
    }

    public static /* synthetic */ ProfilePreview h(t2 t2Var, DogProfile dogProfile, Boolean boolean, boolean z, TrainingStreakEntity trainingStreakEntity) {
        return GetProfilePreviewInteractor.d(t2Var, dogProfile, boolean, z, trainingStreakEntity);
    }

    public static /* synthetic */ g0 i(t2 t2Var, m0 m0Var, Boolean boolean, boolean z, DogProfile dogProfile) {
        return GetProfilePreviewInteractor.c(t2Var, m0Var, boolean, z, dogProfile);
    }

    public static /* synthetic */ g0 j(t2 t2Var, String str, m0 m0Var, boolean z, Boolean boolean) {
        return GetProfilePreviewInteractor.b(t2Var, str, m0Var, z, boolean);
    }
}
