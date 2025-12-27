package app.dogo.com.dogo_android.q.r;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.exceptions.DogExceptions.NameIsTooLong;
import app.dogo.com.dogo_android.util.exceptions.DogExceptions.NameIsTooShort;
import app.dogo.com.dogo_android.w.o3;
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: UserInformationViewModel.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\u000c\u0012\n \u000c*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00150\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0017\u001a\u0010\u0012\u000c\u0012\n \u000c*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000eR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/profile/information/UserInformationViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "email", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "onSave", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnSave", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getResult", "userName", "getUserName", "userRecord", "Lapp/dogo/com/dogo_android/repository/domain/UserAuthRecord;", "isNameValid", "name", "saveUserInformation", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class UserInformationViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final h2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 connectivityService;
    private final j2 c;
    private final UserAuthRecord d;
    private final x<String> e = new x<>();
    /* renamed from: f, reason: from kotlin metadata */
    private final x<String> tracker = new x<>();
    private final x<y<Boolean>> g = new x<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> userRecord = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            d.this.j().postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            final Boolean tRUE2 = Boolean.TRUE;
            d.this.j().postValue(new LoadResult_Success(tRUE2));
            d.this.i().postValue(tRUE2);
        }

        b() {
            super(0);
        }
    }
    public d(h2 h2Var, o3 o3Var, j2 j2Var) {
        String j2Var32;
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        j2Var32 = "connectivityService";
        n.f(j2Var, j2Var32);
        super();
        this.authService = h2Var;
        this.connectivityService = o3Var;
        this.c = j2Var;
        UserAuthRecord userAuthRecord = h2Var.A();
        this.d = userAuthRecord;
        j2Var32 = "";
        String r0 = userAuthRecord == null ? "" : j2Var32;
        x xVar2 = new x((userAuthRecord == null ? "" : j2Var32));
        if (userAuthRecord != null) {
            j2Var32 = userAuthRecord.getEmail();
            if (j2Var32 != null) {
            }
        }
        x xVar3 = new x(j2Var32);
        x xVar = new x();
        f.d.a.a aVar = new a();
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final boolean isNameValid(String name) {
        int i = 21;
        boolean z2 = false;
        int length;
        i = l.z(name) ^ 1;
        if (l.z(name) ^ 1 != 0) {
            i = 21;
            if (name.length() > 21) {
                int i3 = 0;
            }
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final x<String> saveUserInformation() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> i() {
        return this.userRecord;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> j() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> k() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        String str;
        DogExceptions.NameIsTooLong dogExceptions_NameIsTooLong;
        if ((String)this.e.getValue() == null) {
            str = "";
        }
        bVar = LoadResult_Loading.a;
        if (!n.b(this.g.getValue(), bVar)) {
            if (!this.c.a()) {
                this.connectivityService.setTrainingReminderUserProperties("user_information");
                this.g.postValue(new LoadResult_Error(new UnknownHostException()));
            } else {
                if (isNameValid(str)) {
                    this.g.postValue(LoadResult_Loading.a);
                    b bVar5 = this.authService.v0(str).y(a.b()).q(a.b());
                    n.e(bVar5, "authService.updateDisplayName(name)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                    getDisposable().b(a.d(bVar5, new app.dogo.com.dogo_android.profile.information.d.a(this), new app.dogo.com.dogo_android.profile.information.d.b(this)));
                } else {
                    DogExceptions_NameIsTooShort r0 = l.z(str) ? new DogExceptions_NameIsTooShort() : new DogExceptions_NameIsTooLong();
                    this.g.postValue(new LoadResult_Error(dogExceptions_NameIsTooLong));
                }
            }
        }
    }
}
