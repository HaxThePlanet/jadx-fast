package app.dogo.com.dogo_android.v;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: UserAndDogCache.kt */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0008\u0002\u0018\u0000 I2\u00020\u0001:\u0001IB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0008J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\n\u00108\u001a\u0004\u0018\u00010\u0008H\u0002J\u0008\u00109\u001a\u00020\u0008H\u0002J\u0006\u0010:\u001a\u00020;J\u0012\u0010<\u001a\u0004\u0018\u00010\u000f2\u0008\u0010=\u001a\u0004\u0018\u00010\u0008J\u001a\u0010>\u001a\u0004\u0018\u00010?2\u0008\u0010=\u001a\u0004\u0018\u00010\u00082\u0006\u0010@\u001a\u00020\u0008J\u0008\u0010A\u001a\u0004\u0018\u00010\u0008J\u000e\u0010B\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0008J\u0006\u0010C\u001a\u000202J\u000e\u0010D\u001a\u0002022\u0006\u00103\u001a\u00020\u0008J\u000e\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\u000fJ$\u0010E\u001a\u0002022\u0006\u0010G\u001a\u00020*2\u0006\u0010\t\u001a\u00020\u00082\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u000f0HR$\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00138F¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u000f0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R \u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100¨\u0006J", d2 = {"Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "(Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/NotificationService;)V", "newId", "", "currentDogId", "getCurrentDogId", "()Ljava/lang/String;", "setCurrentDogId", "(Ljava/lang/String;)V", "currentDogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getCurrentDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "currentDogProfileLiveData", "Landroidx/lifecycle/MutableLiveData;", "getCurrentDogProfileLiveData", "()Landroidx/lifecycle/MutableLiveData;", "deviceData", "Lapp/dogo/com/dogo_android/temp/Device;", "getDeviceData", "()Lapp/dogo/com/dogo_android/temp/Device;", "dogs", "", "getDogs", "()Ljava/util/Map;", "setDogs", "(Ljava/util/Map;)V", "getNotificationService", "()Lapp/dogo/com/dogo_android/service/NotificationService;", "syncState", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "", "getSyncState", "()Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "setSyncState", "(Lapp/dogo/com/dogo_android/util/SimpleSessionCache;)V", "userData", "Lapp/dogo/com/dogo_android/temp/User;", "getUserData", "()Lapp/dogo/com/dogo_android/temp/User;", "setUserData", "(Lapp/dogo/com/dogo_android/temp/User;)V", "getUtilities", "()Lapp/dogo/com/dogo_android/service/Utilities;", "addParticipatingChallenge", "", "challengeId", "fillFromBundle", "bundle", "Landroid/os/Bundle;", "getCacheBundle", "getCountryCode", "getCountryCodeFromMobileData", "getDogCount", "", "getDogProfile", "dogId", "getDogProfileModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "userId", "getEmptyDogIdOrNull", "isSynced", "refreshCurrentDogProfile", "removeParticipatingChallenge", "updateLocalSessionCache", "dog", "user", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class UserAndDogCache {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final c.a INSTANCE = new c$a(0);
    private static final long h = 0L;
    private final v2 a;
    private final o2 b;
    private z<Boolean> c = new z<>();
    private b d;
    /* renamed from: e, reason: from kotlin metadata */
    private Map<String, DogProfile> dogs = new LinkedHashMap<>();
    private String f = "";
    private final x<DogProfile> g = new x<>();

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/temp/UserAndDogCache$Companion;", "", "()V", "CACHE_BUNDLE_KEY", "", "CACHE_KEY", "CACHE_REFRESH_TIMEOUT", "", "getCACHE_REFRESH_TIMEOUT", "()J", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    static {
        UserAndDogCache.h = TimeUnit.MINUTES.toMillis(30L);
    }

    public c(v2 v2Var, o2 o2Var) {
        n.f(v2Var, "utilities");
        n.f(o2Var, "notificationService");
        super();
        this.a = v2Var;
        this.b = o2Var;
        z simpleSessionCache = new SimpleSessionCache(UserAndDogCache.h, r1);
        super("", null, null, null, 14, null);
        this.d = v2Var2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        x xVar = new x();
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final String getCacheBundle() {
        String str = null;
        App.a iNSTANCE2 = App.INSTANCE;
        if (n.b(iNSTANCE2.n().v(), "null")) {
            int i = 0;
        }
        if (str == null) {
            str = e();
        }
        App.INSTANCE.l().D0(str);
        return str;
    }

    private final String e() {
        int i = 0;
        int i2 = 0;
        TelephonyManager r0 = App.INSTANCE.b().getSystemService("phone") instanceof TelephonyManager ? (TelephonyManager)App.INSTANCE.b().getSystemService("phone") : 0;
        String str4 = "(this as java.lang.String).toUpperCase()";
        if (App.INSTANCE != null) {
            String networkCountryIso = i.getNetworkCountryIso();
            n.e(networkCountryIso, "countryCode");
            int r2 = networkCountryIso.length() > 0 ? 1 : 0;
            if (i2 != 0) {
                String str2 = networkCountryIso.toUpperCase();
                n.e(str2, str4);
                return str2;
            }
        }
        String country = Locale.getDefault().getCountry();
        n.e(country, "getDefault().country");
        String str = country.toUpperCase();
        n.e(str, str4);
        return str;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final void addParticipatingChallenge(String challengeId) {
        n.f(challengeId, "challengeId");
        if (!this.d.b().contains(challengeId)) {
            this.d.b().add(challengeId);
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean fillFromBundle(Bundle bundle) {
        boolean z = false;
        n.f(bundle, "bundle");
        int i = 0;
        if (this.dogs.isEmpty()) {
            android.os.Parcelable parcelable = bundle.getParcelable("user_cache_object");
            if (parcelable != null) {
                updateLocalSessionCache(parcelable.c(), parcelable.a(), parcelable.b());
                if (!this.dogs.isEmpty()) {
                    int i2 = 1;
                }
            }
        }
        return z;
    }

    public final Bundle c() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("user_cache_object", new UserCacheBundleItem(o(), p.L0(m().values()), f()));
        return bundle;
    }

    public final String f() {
        return this.f;
    }

    public final DogProfile g() {
        Object value;
        if ((DogProfile)this.dogs.get(this.f) == null) {
            updateLocalSessionCache((DogProfile)p.W(this.dogs.values()).getId());
        }
        return value;
    }

    public final x<DogProfile> h() {
        this.g.postValue(g());
        return this.g;
    }

    public final a i() {
        String str;
        App.a iNSTANCE2 = App.INSTANCE;
        if (iNSTANCE2.l().h() == null) {
            str = this.a.h();
        }
        iNSTANCE2.l().v0(str);
        String iD = TimeZone.getDefault().getID();
        n.e(iD, "getDefault().id");
        String str5 = App.INSTANCE.l().h();
        n.d(str5);
        Device device = new Device(getCacheBundle(), iD, App.INSTANCE.l().u(), str5, LocaleService.a.a(App.INSTANCE.l().W()), this.b.a());
        return device;
    }

    public final int j() {
        return this.dogs.values().size();
    }

    /* renamed from: k, reason: from kotlin metadata */
    public final DogProfile getDogProfile(String dogId) {
        int i = 0;
        if (dogId == null) {
            i = 0;
        } else {
            Object value = this.dogs.get(dogId);
        }
        return i;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final DogProfileModel getDogProfileModel(String dogId, String userId) {
        int i = 0;
        n.f(userId, "userId");
        i = 0;
        if (dogId != null) {
            Object value = this.dogs.get(dogId);
            if (value != null) {
                DogProfileModel model = value.toModel(userId);
            }
        }
        return i;
    }

    public final Map<String, DogProfile> m() {
        return this.dogs;
    }

    public final String n() {
        Object item;
        String str = null;
        boolean z;
        Iterator it = p.L0(this.dogs.values()).iterator();
        while (it.hasNext()) {
            if (l.z((DogProfile)item.getName()) != null) {
                break;
            }
        }
        if (item != null) {
            str = item.getId();
        }
        return str;
    }

    public final b o() {
        return this.d;
    }

    /* renamed from: p, reason: from kotlin metadata */
    public final boolean isSynced(String userId) {
        n.f(userId, "userId");
        return n.b(this.c.a(userId, this.a.g()), Boolean.TRUE);
    }

    public final void q() {
        h();
    }

    /* renamed from: r, reason: from kotlin metadata */
    public final void removeParticipatingChallenge(String challengeId) {
        n.f(challengeId, "challengeId");
        if (this.d.b().contains(challengeId)) {
            this.d.b().remove(challengeId);
        }
    }

    /* renamed from: s, reason: from kotlin metadata */
    public final void updateLocalSessionCache(String dog) {
        boolean z;
        int i = 0;
        n.f(dog, "newId");
        i = 1;
        if (!n.b(this.f, dog)) {
            if (l.z(dog) ^ 1 == 0) {
                i = 0;
            }
        }
        if (i != 0) {
            this.f = dog;
            h().postValue(this.dogs.get(dog));
        }
    }

    public final void t(DogProfile dogProfile) {
        n.f(dogProfile, "dog");
        this.dogs.put(dogProfile.getId(), dogProfile);
        if (n.b(dogProfile.getId(), this.f) != null) {
            q();
        }
    }

    /* renamed from: u, reason: from kotlin metadata */
    public final void updateLocalSessionCache(b user, String currentDogId, List<DogProfile> dogs) {
        n.f(user, "user");
        n.f(currentDogId, "currentDogId");
        n.f(dogs, "dogs");
        this.c.f(user.component1(), this.a.g(), Boolean.TRUE);
        this.d = user;
        ArrayList arrayList = new ArrayList(p.r(dogs, 10));
        final Iterator it = dogs.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new Pair(item.getId(), item));
        }
        this.dogs = j0.y(j0.s(arrayList));
        updateLocalSessionCache(currentDogId);
        if (!l.z(currentDogId) != 0) {
            q();
        }
    }
}
