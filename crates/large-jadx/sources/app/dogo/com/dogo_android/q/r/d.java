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
import f.d.a.a;
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\u000c\u0012\n \u000c*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00150\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0017\u001a\u0010\u0012\u000c\u0012\n \u000c*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000eR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/profile/information/UserInformationViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "email", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "onSave", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnSave", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getResult", "userName", "getUserName", "userRecord", "Lapp/dogo/com/dogo_android/repository/domain/UserAuthRecord;", "isNameValid", "name", "saveUserInformation", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    private final h2 a;
    private final o3 b;
    private final j2 c;
    private final UserAuthRecord d;
    private final x<String> e;
    private final x<String> f;
    private final x<y<Boolean>> g;
    private final a<Boolean> h;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.q.r.d this$0;
        a(app.dogo.com.dogo_android.q.r.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.j().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.q.r.d this$0;
        b(app.dogo.com.dogo_android.q.r.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            final Boolean tRUE = Boolean.TRUE;
            y.c cVar = new y.c(tRUE);
            this.this$0.j().postValue(cVar);
            this.this$0.i().postValue(tRUE);
        }
    }
    public d(h2 h2, o3 o32, j2 j23) {
        String displayName;
        Object obj2;
        String obj4;
        n.f(h2, "authService");
        n.f(o32, "tracker");
        n.f(j23, "connectivityService");
        super();
        this.a = h2;
        this.b = o32;
        this.c = j23;
        obj2 = h2.A();
        this.d = obj2;
        if (obj2 == null) {
            displayName = obj4;
        } else {
        }
        x obj3 = new x(displayName);
        this.e = obj3;
        if (obj2 == null) {
        } else {
            obj2 = obj2.getEmail();
            if (obj2 == null) {
            } else {
                obj4 = obj2;
            }
        }
        obj3 = new x(obj4);
        this.f = obj3;
        obj2 = new x();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
    }

    private final boolean l(String string) {
        int i2;
        int i;
        java.lang.CharSequence obj3;
        if (z ^= i != 0 && string.length() <= 21) {
            if (string.length() <= 21) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final x<String> h() {
        return this.f;
    }

    public final a<Boolean> i() {
        return this.h;
    }

    public final x<y<Boolean>> j() {
        return this.g;
    }

    public final x<String> k() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        Object nameIsTooShort;
        boolean disposable;
        Object unknownHostException;
        app.dogo.com.dogo_android.q.r.d.b bVar;
        if ((String)this.e.getValue() == null) {
            nameIsTooShort = "";
        }
        unknownHostException = y.b.a;
        if (!n.b(this.g.getValue(), unknownHostException)) {
            if (!this.c.a()) {
                this.b.s("user_information");
                unknownHostException = new UnknownHostException();
                disposable = new y.a(unknownHostException);
                this.g.postValue(disposable);
            } else {
                if (l(nameIsTooShort)) {
                    this.g.postValue(unknownHostException);
                    b bVar4 = this.a.v0(nameIsTooShort).y(a.b()).q(a.b());
                    n.e(bVar4, "authService.updateDisplayName(name)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                    unknownHostException = new d.a(this);
                    bVar = new d.b(this);
                    getDisposable().b(a.d(bVar4, unknownHostException, bVar));
                } else {
                    if (l.z(nameIsTooShort)) {
                        nameIsTooShort = new DogExceptions.NameIsTooShort();
                    } else {
                        nameIsTooShort = new DogExceptions.NameIsTooLong();
                    }
                    unknownHostException = new y.a(nameIsTooShort);
                    this.g.postValue(unknownHostException);
                }
            }
        }
    }
}
