package app.dogo.com.dogo_android.dogcreation;

import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.v.a;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: DogCreationSharedViewModel.kt */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001BG\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020\u0005J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010.\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "skipWelcomeChallenge", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "(Ljava/lang/String;ZLapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;)V", "dogBreedData", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "getDogBreedData", "()Landroidx/lifecycle/MutableLiveData;", "dogCreationProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getDogCreationProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "loginReturnScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "getLoginReturnScreen", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "setLoginReturnScreen", "(Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;)V", "fillCacheFromBundle", "", "bundle", "Landroid/os/Bundle;", "getAvatarUri", "Landroid/net/Uri;", "getCacheBundle", "isDogCreationForced", "isSizeCorrect", "isUserReminderSet", "isUserSignedIn", "isWelcomeChallengeAvailable", "updateDogCreationProfileId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class DogCreationSharedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private String authService;
    private final boolean b;
    private final p1 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 dogId;
    private final t2 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final h2 preferenceService;
    /* renamed from: g, reason: from kotlin metadata */
    private final p2 reminderRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final l1 remoteConfigService;
    /* renamed from: i, reason: from kotlin metadata */
    private final x<DogBreed> skipWelcomeChallenge = new x<>(0);
    /* renamed from: j, reason: from kotlin metadata */
    private j storageService;
    public g(String str, boolean z, p1 p1Var, r2 r2Var, t2 t2Var, h2 h2Var, p2 p2Var, l1 l1Var) {
        n.f(p1Var, "userRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(t2Var, "storageService");
        n.f(h2Var, "authService");
        n.f(p2Var, "preferenceService");
        n.f(l1Var, "reminderRepository");
        super();
        this.authService = str;
        this.b = z;
        this.c = p1Var;
        this.dogId = r2Var;
        this.e = t2Var;
        this.preferenceService = h2Var;
        this.reminderRepository = p2Var;
        this.remoteConfigService = l1Var;
        final x xVar = new x(null);
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final boolean fillCacheFromBundle(String bundle) {
        boolean z = false;
        Uri uri = this.e.h(bundle, "avatar.jpg");
        int i2 = 0;
        if (uri == null) {
            return false;
        }
        int[] iArr = this.e.e(uri);
        final int i = 1;
        final int i4 = 800;
        if (iArr[i2] >= i4) {
            if (iArr[i] >= i4) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final void getAvatarUri(Bundle dogId) {
        n.f(dogId, "bundle");
        this.c.s(dogId);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final Uri isSizeCorrect(String dogId) {
        n.f(dogId, "dogId");
        return this.e.h(dogId, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.preferenceService.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: j, reason: from kotlin metadata */
    public final Bundle getCacheBundle() {
        return this.c.t();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<DogBreed> k() {
        return this.skipWelcomeChallenge;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogProfile l() {
        return this.c.H().getDogProfile(this.authService);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final j m() {
        return this.storageService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean n() {
        return this.reminderRepository.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.remoteConfigService.o(this.preferenceService.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        DogProfile dogProfile;
        boolean participatingInChallenge;
        boolean z3 = false;
        String str;
        dogProfile = l();
        if (!this.b && dogProfile != null) {
            if (!this.c.isParticipatingInChallenge(SpecialChallenges.WELCOME_CHALLENGE.getId())) {
                if (fillCacheFromBundle(dogProfile.getId()) != null) {
                    if (l.z(dogProfile.getName()) ^ 1 != null) {
                        if (this.dogId.e0(this.c.H().i().e())) {
                            int i3 = 0;
                        }
                    }
                }
            }
        }
        return z3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: r, reason: from kotlin metadata */
    public final void updateDogCreationProfileId(j dogId) {
        this.storageService = dogId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String str) {
        n.f(str, "dogId");
        this.authService = str;
    }
}
