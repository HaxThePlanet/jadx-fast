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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0008\u0002\u0018\u0000 I2\u00020\u0001:\u0001IB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0008J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\n\u00108\u001a\u0004\u0018\u00010\u0008H\u0002J\u0008\u00109\u001a\u00020\u0008H\u0002J\u0006\u0010:\u001a\u00020;J\u0012\u0010<\u001a\u0004\u0018\u00010\u000f2\u0008\u0010=\u001a\u0004\u0018\u00010\u0008J\u001a\u0010>\u001a\u0004\u0018\u00010?2\u0008\u0010=\u001a\u0004\u0018\u00010\u00082\u0006\u0010@\u001a\u00020\u0008J\u0008\u0010A\u001a\u0004\u0018\u00010\u0008J\u000e\u0010B\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0008J\u0006\u0010C\u001a\u000202J\u000e\u0010D\u001a\u0002022\u0006\u00103\u001a\u00020\u0008J\u000e\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\u000fJ$\u0010E\u001a\u0002022\u0006\u0010G\u001a\u00020*2\u0006\u0010\t\u001a\u00020\u00082\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u000f0HR$\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00138F¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u000f0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R \u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100¨\u0006J", d2 = {"Lapp/dogo/com/dogo_android/temp/UserAndDogCache;", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "(Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/NotificationService;)V", "newId", "", "currentDogId", "getCurrentDogId", "()Ljava/lang/String;", "setCurrentDogId", "(Ljava/lang/String;)V", "currentDogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getCurrentDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "currentDogProfileLiveData", "Landroidx/lifecycle/MutableLiveData;", "getCurrentDogProfileLiveData", "()Landroidx/lifecycle/MutableLiveData;", "deviceData", "Lapp/dogo/com/dogo_android/temp/Device;", "getDeviceData", "()Lapp/dogo/com/dogo_android/temp/Device;", "dogs", "", "getDogs", "()Ljava/util/Map;", "setDogs", "(Ljava/util/Map;)V", "getNotificationService", "()Lapp/dogo/com/dogo_android/service/NotificationService;", "syncState", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "", "getSyncState", "()Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "setSyncState", "(Lapp/dogo/com/dogo_android/util/SimpleSessionCache;)V", "userData", "Lapp/dogo/com/dogo_android/temp/User;", "getUserData", "()Lapp/dogo/com/dogo_android/temp/User;", "setUserData", "(Lapp/dogo/com/dogo_android/temp/User;)V", "getUtilities", "()Lapp/dogo/com/dogo_android/service/Utilities;", "addParticipatingChallenge", "", "challengeId", "fillFromBundle", "bundle", "Landroid/os/Bundle;", "getCacheBundle", "getCountryCode", "getCountryCodeFromMobileData", "getDogCount", "", "getDogProfile", "dogId", "getDogProfileModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "userId", "getEmptyDogIdOrNull", "isSynced", "refreshCurrentDogProfile", "removeParticipatingChallenge", "updateLocalSessionCache", "dog", "user", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c {

    public static final app.dogo.com.dogo_android.v.c.a Companion;
    private static final long h;
    private final v2 a;
    private final o2 b;
    private z<Boolean> c;
    private app.dogo.com.dogo_android.v.b d;
    private Map<String, DogProfile> e;
    private String f;
    private final x<DogProfile> g;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/temp/UserAndDogCache$Companion;", "", "()V", "CACHE_BUNDLE_KEY", "", "CACHE_KEY", "CACHE_REFRESH_TIMEOUT", "", "getCACHE_REFRESH_TIMEOUT", "()J", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.Companion = aVar;
        c.h = TimeUnit.MINUTES.toMillis(30);
    }

    public c(v2 v2, o2 o22) {
        n.f(v2, "utilities");
        n.f(o22, "notificationService");
        super();
        this.a = v2;
        this.b = o22;
        z obj10 = new z(c.h, obj1);
        this.c = obj10;
        super("", 0, 0, 0, 14, 0);
        this.d = obj10;
        obj10 = new LinkedHashMap();
        this.e = obj10;
        this.f = "";
        obj10 = new x();
        this.g = obj10;
    }

    private final String d() {
        String str;
        App.a companion = App.Companion;
        if (!n.b(companion.n().v(), "null")) {
        } else {
            str = 0;
        }
        if (str == null) {
            str = e();
        }
        companion.l().D0(str);
        return str;
    }

    private final String e() {
        int networkCountryIso;
        int i;
        if (networkCountryIso instanceof TelephonyManager != null) {
        } else {
            networkCountryIso = 0;
        }
        String str2 = "(this as java.lang.String).toUpperCase()";
        if (networkCountryIso != 0) {
            networkCountryIso = networkCountryIso.getNetworkCountryIso();
            n.e(networkCountryIso, "countryCode");
            i = networkCountryIso.length() > 0 ? 1 : 0;
            if (i != 0) {
                String upperCase2 = networkCountryIso.toUpperCase();
                n.e(upperCase2, str2);
                return upperCase2;
            }
        }
        String country = Locale.getDefault().getCountry();
        n.e(country, "getDefault().country");
        String upperCase = country.toUpperCase();
        n.e(upperCase, str2);
        return upperCase;
    }

    public final void a(String string) {
        boolean contains;
        n.f(string, "challengeId");
        if (!this.d.b().contains(string)) {
            this.d.b().add(string);
        }
    }

    public final boolean b(Bundle bundle) {
        boolean empty;
        int i;
        String str;
        Object obj4;
        n.f(bundle, "bundle");
        i = 0;
        obj4 = bundle.getParcelable("user_cache_object");
        u((d)obj4.c(), obj4.a(), obj4.b());
        if (this.e.isEmpty() && obj4 != null && !this.e.isEmpty()) {
            obj4 = bundle.getParcelable("user_cache_object");
            if ((d)obj4 != null) {
                u((d)obj4.c(), obj4.a(), obj4.b());
                if (!this.e.isEmpty()) {
                    i = 1;
                }
            }
        }
        return i;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        d dVar = new d(o(), p.L0(m().values()), f());
        bundle.putParcelable("user_cache_object", dVar);
        return bundle;
    }

    public final String f() {
        return this.f;
    }

    public final DogProfile g() {
        Object obj;
        String str;
        if ((DogProfile)this.e.get(this.f) != null) {
        } else {
            s((DogProfile)p.W(this.e.values()).getId());
        }
        return obj;
    }

    public final x<DogProfile> h() {
        this.g.postValue(g());
        return this.g;
    }

    public final app.dogo.com.dogo_android.v.a i() {
        String str;
        App.a companion = App.Companion;
        if (companion.l().h() == null) {
            str = this.a.h();
        }
        companion.l().v0(str);
        String iD = TimeZone.getDefault().getID();
        n.e(iD, "getDefault().id");
        String str6 = companion.l().h();
        n.d(str6);
        super(d(), iD, companion.l().u(), str6, n2.a.a(companion.l().W()), this.b.a());
        return aVar2;
    }

    public final int j() {
        return this.e.values().size();
    }

    public final DogProfile k(String string) {
        Map map;
        int obj2;
        if (string == null) {
            obj2 = 0;
        } else {
            obj2 = this.e.get(string);
        }
        return obj2;
    }

    public final DogProfileModel l(String string, String string2) {
        int model;
        Map map;
        Object obj3;
        n.f(string2, "userId");
        model = 0;
        if (string == null) {
        } else {
            obj3 = this.e.get(string);
            if ((DogProfile)obj3 == null) {
            } else {
                model = (DogProfile)obj3.toModel(string2);
            }
        }
        return model;
    }

    public final Map<String, DogProfile> m() {
        return this.e;
    }

    public final String n() {
        Object next;
        int i;
        boolean z;
        Iterator iterator = p.L0(this.e.values()).iterator();
        for (Object next : iterator) {
        }
        next = i;
        if ((DogProfile)next == null) {
        } else {
            i = (DogProfile)next.getId();
        }
        return i;
    }

    public final app.dogo.com.dogo_android.v.b o() {
        return this.d;
    }

    public final boolean p(String string) {
        n.f(string, "userId");
        return n.b(this.c.a(string, this.a.g()), Boolean.TRUE);
    }

    public final void q() {
        h();
    }

    public final void r(String string) {
        boolean contains;
        n.f(string, "challengeId");
        if (this.d.b().contains(string)) {
            this.d.b().remove(string);
        }
    }

    public final void s(String string) {
        boolean z;
        int i;
        Object obj3;
        n.f(string, "newId");
        if (!n.b(this.f, string) && z2 ^= i != 0) {
            if (z2 ^= i != 0) {
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            this.f = string;
            h().postValue(this.e.get(string));
        }
    }

    public final void t(DogProfile dogProfile) {
        n.f(dogProfile, "dog");
        this.e.put(dogProfile.getId(), dogProfile);
        if (n.b(dogProfile.getId(), this.f) != null) {
            q();
        }
    }

    public final void u(app.dogo.com.dogo_android.v.b b, String string2, List<DogProfile> list3) {
        int next;
        String oVar;
        long l;
        n.f(b, "user");
        n.f(string2, "currentDogId");
        n.f(list3, "dogs");
        this.c.f(b.a(), this.a.g(), obj3);
        this.d = b;
        ArrayList obj6 = new ArrayList(p.r(list3, 10));
        final Iterator obj8 = list3.iterator();
        for (DogProfile next : obj8) {
            oVar = new o(next.getId(), next);
            obj6.add(oVar);
        }
        this.e = j0.y(j0.s(obj6));
        s(string2);
        if (obj6 ^= 1 != 0) {
            q();
        }
    }
}
