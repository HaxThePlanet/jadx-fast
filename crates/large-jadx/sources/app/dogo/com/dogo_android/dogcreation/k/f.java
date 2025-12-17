package app.dogo.com.dogo_android.dogcreation.k;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.k.d.a;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import f.d.a.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u001a0\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/gender/DogCreationGenderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "initialGender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/enums/DogGender;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "pickerPosition", "Landroidx/lifecycle/MutableLiveData;", "", "getPickerPosition", "()Landroidx/lifecycle/MutableLiveData;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "isUserSignedIn", "saveDogGender", "", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends s {

    private final g2 a;
    private final o3 b;
    private final j2 c;
    private final x<y<Boolean>> d;
    private final a<Boolean> e;
    private final x<Integer> f;
    private final CoroutineExceptionHandler g;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.dogcreation.k.f a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.dogcreation.k.f f2) {
            this.a = f2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.m().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.gender.DogCreationGenderViewModel$saveDogGender$1", f = "DogCreationGenderViewModel.kt", l = 41, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final String $dogId;
        int label;
        final app.dogo.com.dogo_android.dogcreation.k.f this$0;
        a(app.dogo.com.dogo_android.dogcreation.k.f f, String string2, d<? super app.dogo.com.dogo_android.dogcreation.k.f.a> d3) {
            this.this$0 = f;
            this.$dogId = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.a obj3 = new f.a(this.this$0, this.$dogId, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            int unknownHostException;
            d dVar;
            int intValue;
            Object value;
            String str;
            Object obj7;
            aVar = b.d();
            unknownHostException = this.label;
            final int i = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i));
                    this.this$0.m().postValue(cVar);
                    this.this$0.k().postValue(b.a(i));
                    return w.a;
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            q.b(object);
            if (!obj7 instanceof y.b) {
                this.this$0.m().postValue(y.b.a);
                if (!f.h(this.this$0).a()) {
                    f.j(this.this$0).s("dog_creation_gender");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.m().postValue(aVar);
                } else {
                    if ((Integer)this.this$0.l().getValue() == null) {
                        value = b.c(i);
                    }
                    n.e(value, "pickerPosition.value ?: 0 + 1");
                    this.label = i;
                    if (f.i(this.this$0).i(this.$dogId, d.Companion.b(value.intValue()), this) == aVar) {
                        return aVar;
                    }
                }
            }
        }
    }
    public f(d d, g2 g22, h2 h23, o3 o34, j2 j25) {
        int obj2;
        n.f(g22, "dogUpdateInteractor");
        n.f(h23, "authService");
        n.f(o34, "tracker");
        n.f(j25, "connectivityService");
        super();
        this.a = g22;
        this.b = o34;
        this.c = j25;
        x obj3 = new x();
        this.d = obj3;
        obj3 = new a();
        this.e = obj3;
        int obj4 = 0;
        if (d == null) {
            obj2 = obj4;
        } else {
            obj2 = d.ordinal();
        }
        obj3 = new x(Integer.valueOf(g.b(obj2--, obj4)));
        this.f = obj3;
        obj3 = new f.b(CoroutineExceptionHandler.r, this);
        this.g = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.dogcreation.k.f f) {
        return f.c;
    }

    public static final g2 i(app.dogo.com.dogo_android.dogcreation.k.f f) {
        return f.a;
    }

    public static final o3 j(app.dogo.com.dogo_android.dogcreation.k.f f) {
        return f.b;
    }

    public final a<Boolean> k() {
        return this.e;
    }

    public final x<Integer> l() {
        return this.f;
    }

    public final x<y<Boolean>> m() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String string) {
        n.f(string, "dogId");
        f.a aVar = new f.a(this, string, 0);
        k.d(f0.a(this), this.g, 0, aVar, 2, 0);
    }
}
