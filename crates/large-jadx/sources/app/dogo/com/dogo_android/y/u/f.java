package app.dogo.com.dogo_android.y.u;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w1;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fJ\u0016\u0010\u0018\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fJ\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u000f0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "hasUserUnlockedFirstExam", "", "lessonId", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "(ZLjava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "laterTrackButtonClick", "", "loadData", "showBecomePremium", "showContentUnlock", "subscribeTrackButtonClick", "tryTrackButtonClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends s {

    private final boolean a;
    private final String b;
    private final o3 c;
    private final d3 d;
    private final x<y<Boolean>> e;
    private final LiveData<y<Boolean>> f;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.y.u.f this$0;
        a(app.dogo.com.dogo_android.y.u.f f) {
            this.this$0 = f;
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
            f.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Boolean, w> {

        final app.dogo.com.dogo_android.y.u.f this$0;
        b(app.dogo.com.dogo_android.y.u.f f) {
            this.this$0 = f;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Boolean)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Boolean boolean) {
            y.c cVar = new y.c(boolean);
            f.h(this.this$0).postValue(cVar);
        }
    }
    public f(boolean z, String string2, o3 o33, p1 p14, d3 d35) {
        n.f(string2, "lessonId");
        n.f(o33, "tracker");
        n.f(p14, "userRepository");
        n.f(d35, "isDogPremiumInteractor");
        super();
        this.a = z;
        this.b = string2;
        this.c = o33;
        this.d = d35;
        x obj2 = new x();
        this.e = obj2;
        this.f = obj2;
    }

    public static final x h(app.dogo.com.dogo_android.y.u.f f) {
        return f.e;
    }

    public final LiveData<y<Boolean>> getResult() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        w1 w1Var = new w1();
        this.c.d(q0.n.c(w1Var, this.b));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        int i = 0;
        a0 subscribeOn = d3.b(this.d, i, 1, i).observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "isDogPremiumInteractor.isCurrentDogPremium()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        f.a aVar = new f.a(this);
        f.b bVar2 = new f.b(this);
        getDisposable().b(a.g(subscribeOn, aVar, bVar2));
    }

    public final boolean k(y<Boolean> y) {
        Object booleanValue;
        int i2;
        int i;
        int obj4;
        if (y instanceof y.c) {
            booleanValue = y;
        } else {
            booleanValue = 0;
        }
        i = 0;
        final int i3 = 1;
        if (booleanValue == null) {
            i2 = i;
        } else {
        }
        if (y == null) {
            obj4 = i;
        } else {
        }
        if (obj4 != null && i2 == 0 && this.a) {
            if (i2 == 0) {
                if (this.a) {
                    i = i3;
                }
            }
        }
        return i;
    }

    public final boolean l(y<Boolean> y) {
        int i;
        int obj3;
        if (y instanceof y.c) {
        } else {
            obj3 = 0;
        }
        final int i2 = 1;
        if (obj3 == null) {
            obj3 = i;
        } else {
        }
        if (obj3 == null) {
            if (!this.a) {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        this.c.d(q0.s.h());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        w1 w1Var = new w1();
        this.c.d(q0.m.c(w1Var, this.b));
    }
}
