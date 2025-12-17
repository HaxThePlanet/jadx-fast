package app.dogo.com.dogo_android.u.n;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.s.a.g3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.h0;
import app.dogo.com.dogo_android.w.j2;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r;
import app.dogo.com.dogo_android.w.s0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w0;
import f.d.a.a;
import i.b.b;
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
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0006\u0010&\u001a\u00020#J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u001fH\u0002J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\u0006\u00103\u001a\u00020#J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020-J\u0006\u00106\u001a\u00020#J\u0016\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u0017R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramOverviewInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "timeUtilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramOverviewInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "certificateUnlockedTrigger", "Lcom/hadilq/liveevent/LiveEvent;", "", "getCertificateUnlockedTrigger", "()Lcom/hadilq/liveevent/LiveEvent;", "resultExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "enrollToProgramEnrollment", "", "isFirstTimeUnlockedCertificate", "programViewItem", "loadData", "postProgramItem", "item", "retry", "setPottyCertificateUnlockedShowed", "trackArticleTapped", "articleId", "", "trackCalendarCardTapped", "streakCount", "", "trackCertificateTapped", "trackLogActivityClicked", "trackNewReminderTapped", "trackPottyTrackerCardTapped", "action", "unEnrollFromProgramEnrollment", "updateReminderState", "reminderId", "newState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends s {

    private final g3 a;
    private final p1 b;
    private final o3 c;
    private final l1 d;
    private final j2 e;
    private final v2 f;
    private final p2 g;
    private final j1 h;
    private final h2 i;
    private final a<Boolean> j;
    private final x<y<SpecialProgramOverviewItem>> k;
    private final CoroutineExceptionHandler l;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.u.n.n a;
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.u.n.n n2) {
            this.a = n2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.s().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$enrollToProgramEnrollment$1", f = "PottyProgramOverviewViewModel.kt", l = {72, 74, 75}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.n.n this$0;
        a(app.dogo.com.dogo_android.u.n.n n, d<? super app.dogo.com.dogo_android.u.n.n.a> d2) {
            this.this$0 = n;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.a obj2 = new n.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int i2;
            Object obj;
            String str;
            long l;
            int i;
            Object obj2;
            int i4;
            int i3;
            Object obj13;
            Object obj3 = b.d();
            label = this.label;
            final int i5 = 3;
            final int i6 = 2;
            i2 = 1;
            if (label != 0) {
                if (label != i2) {
                    if (label != i6) {
                        if (label != i5) {
                        } else {
                            q.b(object);
                            n.p(this.this$0, (SpecialProgramOverviewItem)obj13);
                            return w.a;
                        }
                        obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj13;
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    this.label = i6;
                    if (j1.H(n.k(this.this$0), (String)obj13, "id_potty_program", b.d(n.m(this.this$0).g()), 0, this, 8, 0) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(object);
                this.this$0.s().setValue(y.b.a);
                this.label = i2;
                if (n.o(this.this$0).u(this) == obj3) {
                    return obj3;
                }
            }
            this.label = i5;
            if (n.j(this.this$0).h(this) == obj3) {
                return obj3;
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$loadData$1", f = "PottyProgramOverviewViewModel.kt", l = 54, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.n.n this$0;
        b(app.dogo.com.dogo_android.u.n.n n, d<? super app.dogo.com.dogo_android.u.n.n.b> d2) {
            this.this$0 = n;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.b obj2 = new n.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            int unknownHostException;
            Object obj4;
            Object obj = b.d();
            unknownHostException = this.label;
            final int i = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i) {
                } else {
                    q.b(object);
                    n.p(this.this$0, (SpecialProgramOverviewItem)obj4);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.this$0.s().postValue(y.b.a);
            if (!n.i(this.this$0).a()) {
                n.n(this.this$0).s("potty_overview");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.s().postValue(aVar);
            } else {
                this.label = i;
                if (n.j(this.this$0).h(this) == obj) {
                    return obj;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$unEnrollFromProgramEnrollment$1", f = "PottyProgramOverviewViewModel.kt", l = {85, 87, 88}, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.n.n this$0;
        d(app.dogo.com.dogo_android.u.n.n n, d<? super app.dogo.com.dogo_android.u.n.n.d> d2) {
            this.this$0 = n;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.d obj2 = new n.d(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int i3;
            Object obj;
            String str;
            long l;
            Long num;
            Object obj2;
            int i2;
            int i;
            Object obj13;
            Object obj3 = b.d();
            label = this.label;
            final int i4 = 3;
            final int i5 = 2;
            i3 = 1;
            if (label != 0) {
                if (label != i3) {
                    if (label != i5) {
                        if (label != i4) {
                        } else {
                            q.b(object);
                            n.p(this.this$0, (SpecialProgramOverviewItem)obj13);
                            return w.a;
                        }
                        obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj13;
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    this.label = i5;
                    if (j1.H(n.k(this.this$0), (String)obj13, "id_potty_program", 0, b.d(n.m(this.this$0).g()), this, 4, 0) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(object);
                this.this$0.s().setValue(y.b.a);
                this.label = i3;
                if (n.o(this.this$0).u(this) == obj3) {
                    return obj3;
                }
            }
            this.label = i4;
            if (n.j(this.this$0).h(this) == obj3) {
                return obj3;
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$updateReminderState$1", f = "PottyProgramOverviewViewModel.kt", l = {}, m = "invokeSuspend")
    static final class e extends k implements p<m0, d<? super w>, Object> {

        final boolean $newState;
        final String $reminderId;
        int label;
        final app.dogo.com.dogo_android.u.n.n this$0;
        e(app.dogo.com.dogo_android.u.n.n n, String string2, boolean z3, d<? super app.dogo.com.dogo_android.u.n.n.e> d4) {
            this.this$0 = n;
            this.$reminderId = string2;
            this.$newState = z3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n.e)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.e obj4 = new n.e(this.this$0, this.$reminderId, this.$newState, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                n.l(this.this$0).U(n.h(this.this$0).v(), this.$reminderId, this.$newState).e();
                return w.a;
            }
            IllegalStateException obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
    }
    public n(g3 g3, p1 p12, o3 o33, l1 l14, j2 j25, v2 v26, p2 p27, j1 j18, h2 h29) {
        n.f(g3, "interactor");
        n.f(p12, "userRepository");
        n.f(o33, "tracker");
        n.f(l14, "reminderRepository");
        n.f(j25, "connectivityService");
        n.f(v26, "timeUtilities");
        n.f(p27, "preferenceService");
        n.f(j18, "programRepository");
        n.f(h29, "authService");
        super();
        this.a = g3;
        this.b = p12;
        this.c = o33;
        this.d = l14;
        this.e = j25;
        this.f = v26;
        this.g = p27;
        this.h = j18;
        this.i = h29;
        a obj2 = new a();
        this.j = obj2;
        obj2 = new x();
        this.k = obj2;
        n.c obj3 = new n.c(CoroutineExceptionHandler.r, this);
        this.l = obj3;
    }

    public static final h2 h(app.dogo.com.dogo_android.u.n.n n) {
        return n.i;
    }

    public static final j2 i(app.dogo.com.dogo_android.u.n.n n) {
        return n.e;
    }

    public static final g3 j(app.dogo.com.dogo_android.u.n.n n) {
        return n.a;
    }

    public static final j1 k(app.dogo.com.dogo_android.u.n.n n) {
        return n.h;
    }

    public static final l1 l(app.dogo.com.dogo_android.u.n.n n) {
        return n.d;
    }

    public static final v2 m(app.dogo.com.dogo_android.u.n.n n) {
        return n.f;
    }

    public static final o3 n(app.dogo.com.dogo_android.u.n.n n) {
        return n.c;
    }

    public static final p1 o(app.dogo.com.dogo_android.u.n.n n) {
        return n.b;
    }

    public static final void p(app.dogo.com.dogo_android.u.n.n n, SpecialProgramOverviewItem specialProgramOverviewItem2) {
        n.v(specialProgramOverviewItem2);
    }

    private final boolean t(SpecialProgramOverviewItem specialProgramOverviewItem) {
        boolean obj1;
        if (specialProgramOverviewItem.getProgramProgress().hasReachedPottyGoal() && !this.g.Q()) {
            obj1 = !this.g.Q() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private final void v(SpecialProgramOverviewItem specialProgramOverviewItem) {
        y.c cVar = new y.c(specialProgramOverviewItem);
        this.k.setValue(cVar);
        this.j.postValue(Boolean.valueOf(t(specialProgramOverviewItem)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        o2 o2Var = new o2();
        this.c.d(r.b.d(u.a(o2Var, "potty")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(String string) {
        n.f(string, "action");
        s0 s0Var = new s0();
        this.c.d(h0.e.d(u.a(s0Var, string)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        boolean z;
        m0 m0Var;
        CoroutineExceptionHandler exc;
        int i3;
        app.dogo.com.dogo_android.u.n.n.d dVar;
        int i;
        int i2;
        if (!value instanceof y.b) {
            dVar = new n.d(this, 0);
            k.d(f0.a(this), this.l, 0, dVar, 2, 0);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D(String string, boolean z2) {
        n.f(string, "reminderId");
        n.e eVar = new n.e(this, string, z2, 0);
        k.d(f0.a(this), c1.b().plus(this.l), 0, eVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        boolean z;
        m0 m0Var;
        CoroutineExceptionHandler exc;
        int i;
        app.dogo.com.dogo_android.u.n.n.a aVar;
        int i3;
        int i2;
        if (!value instanceof y.b) {
            aVar = new n.a(this, 0);
            k.d(f0.a(this), this.l, 0, aVar, 2, 0);
        }
    }

    public final a<Boolean> r() {
        return this.j;
    }

    public final x<y<SpecialProgramOverviewItem>> s() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        final int i = 0;
        n.b bVar = new n.b(this, i);
        k.d(f0.a(this), this.l, i, bVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.g.j1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x(String string) {
        n.f(string, "articleId");
        w0 w0Var = new w0();
        this.c.d(h0.c.d(u.a(w0Var, string)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(int i) {
        j2 j2Var = new j2();
        this.c.d(r.c.d(u.a(j2Var, Integer.valueOf(i))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.c.c(h0.d);
    }
}
