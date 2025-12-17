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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001BG\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020\u0005J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010.\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "skipWelcomeChallenge", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "(Ljava/lang/String;ZLapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;)V", "dogBreedData", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "getDogBreedData", "()Landroidx/lifecycle/MutableLiveData;", "dogCreationProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getDogCreationProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "loginReturnScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "getLoginReturnScreen", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "setLoginReturnScreen", "(Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;)V", "fillCacheFromBundle", "", "bundle", "Landroid/os/Bundle;", "getAvatarUri", "Landroid/net/Uri;", "getCacheBundle", "isDogCreationForced", "isSizeCorrect", "isUserReminderSet", "isUserSignedIn", "isWelcomeChallengeAvailable", "updateDogCreationProfileId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends s {

    private String a;
    private final boolean b;
    private final p1 c;
    private final r2 d;
    private final t2 e;
    private final h2 f;
    private final p2 g;
    private final l1 h;
    private final x<DogBreed> i;
    private j j;
    public g(String string, boolean z2, p1 p13, r2 r24, t2 t25, h2 h26, p2 p27, l1 l18) {
        n.f(p13, "userRepository");
        n.f(r24, "remoteConfigService");
        n.f(t25, "storageService");
        n.f(h26, "authService");
        n.f(p27, "preferenceService");
        n.f(l18, "reminderRepository");
        super();
        this.a = string;
        this.b = z2;
        this.c = p13;
        this.d = r24;
        this.e = t25;
        this.f = h26;
        this.g = p27;
        this.h = l18;
        x obj2 = new x(0);
        this.i = obj2;
    }

    private final boolean o(String string) {
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

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h(Bundle bundle) {
        n.f(bundle, "bundle");
        this.c.s(bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri i(String string) {
        n.f(string, "dogId");
        return this.e.h(string, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.f.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Bundle j() {
        return this.c.t();
    }

    public final x<DogBreed> k() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogProfile l() {
        return this.c.H().k(this.a);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final j m() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean n() {
        return this.g.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.h.o(this.f.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        DogProfile dogProfile;
        boolean z;
        int i;
        String str;
        dogProfile = l();
        if (!this.b && dogProfile != null && !this.c.K(o.WELCOME_CHALLENGE.getId()) && o(dogProfile.getId()) != null && z2 ^= i != 0 && !this.d.e0(this.c.H().i().e())) {
            if (dogProfile != null) {
                if (!this.c.K(o.WELCOME_CHALLENGE.getId())) {
                    if (o(dogProfile.getId()) != null) {
                        if (z2 ^= i != 0) {
                            if (!this.d.e0(this.c.H().i().e())) {
                            } else {
                                i = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r(j j) {
        this.j = j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String string) {
        n.f(string, "dogId");
        this.a = string;
    }
}
