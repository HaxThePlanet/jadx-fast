package app.dogo.com.dogo_android.n;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.Library;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.a.o2;
import app.dogo.com.dogo_android.s.a.p2;
import app.dogo.com.dogo_android.s.a.q2;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.b1;
import app.dogo.com.dogo_android.w.d0;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w0;
import com.google.firebase.firestore.FirebaseFirestore;
import i.b.a0;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: LibraryViewModel.kt */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0006\u0010*\u001a\u00020+J\u0008\u0010,\u001a\u00020+H\u0014J\u0006\u0010-\u001a\u00020+J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020+J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u00020+J\u000e\u00105\u001a\u00020+2\u0006\u00103\u001a\u000200J\u0006\u00106\u001a\u00020+J\u0006\u00107\u001a\u00020+J\u000e\u00108\u001a\u00020+2\u0006\u00109\u001a\u000200J\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020+J\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u00020+R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u001d\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010%R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010%R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "getLibraryArticleListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "getLibraryProgramListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryProgramListInteractor;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "firestoreService", "Lcom/google/firebase/firestore/FirebaseFirestore;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryProgramListInteractor;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Library;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "rateUsPopUp", "Landroidx/lifecycle/LiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUp", "()Landroidx/lifecycle/LiveData;", "results", "getResults", "sharePopUp", "getSharePopUp", "loadList", "", "onCleared", "retry", "trackArticleTapped", "articleId", "", "trackArticlesShortcutTapped", "trackComingSoonProgramOpened", "programId", "trackGamesShortcutTapped", "trackProgramTapped", "trackShowAllArticlesTapped", "trackShowAllProgramsTapped", "trackShowAllTricksTapped", "categoryId", "trackSkillsShortcutTapped", "trackSubscriptionSuggestionTapped", "trackTrickTapped", "trickId", "trackTricksShortcutTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class LibraryViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final q2 connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final o2 dispatcher;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 firestoreService;
    /* renamed from: d, reason: from kotlin metadata */
    private final d3 getLibraryArticleListInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final n3 getLibraryProgramListInteractor;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 getLibraryTrickListInteractor;
    private final k1 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final j2 isDogPremiumInteractor;
    /* renamed from: i, reason: from kotlin metadata */
    private final FirebaseFirestore rateRepository;
    private final p1 j;
    private final h0 k;
    private final x<y<Library>> l;
    /* renamed from: m, reason: from kotlin metadata */
    private final LiveData<y<Library>> subscribeInteractor;
    /* renamed from: n, reason: from kotlin metadata */
    private final LiveData<q2.a> tracker;
    /* renamed from: o, reason: from kotlin metadata */
    private final LiveData<q2.a> userRepository;
    private final CoroutineExceptionHandler p;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final /* synthetic */ j a;
        public b(CoroutineExceptionHandler.a exc, j jVar) {
            this.a = jVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.l.postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.LibraryViewModel$loadList$1", f = "LibraryViewModel.kt", l = {62, 66, 67, 68, 69, 70, 73, 74}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) throws InvalidParameterException {
            int i;
            Object object2;
            int i2;
            boolean z2;
            int i3;
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection;
            app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection2;
            app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection3;
            app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection4;
            app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection5;
            java.util.List list;
            final Object object3 = this;
            Object obj2 = b.d();
            i3 = 0;
            i3 = 1;
            switch (object3.label) {
                case 0:
                    q.b(object);
                    LibraryViewModel.o(object3.this$0).postValue(LoadResult_Loading.a);
                    LibraryViewModel.m(object3.this$0).setTrainingReminderUserProperties("library");
                    LibraryViewModel.o(object3.this$0).postValue(new LoadResult_Error(new UnknownHostException()));
                    object3.label = i3;
                    return obj2;
                case 1:
                    q.b(object);
                    object2 = object;
                    break;
                case 2:
                    q.b(object);
                    object2 = object;
                    object3.L$0 = (LibrarySection)(ibrarySection)object2;
                    object3.label = 3;
                    str2 = "id_games";
                    return obj2;
                case 3:
                    q.b(object);
                    object2 = object;
                    object3.L$0 = object2;
                    object3.L$1 = object2;
                    object3.label = 4;
                    str3 = "id_skills";
                    return obj2;
                case 4:
                    q.b(object);
                    object2 = object;
                    object3.L$0 = object2;
                    object3.L$1 = object2;
                    object3.L$2 = object2;
                    int i4 = 5;
                    object3.label = 5;
                    return obj2;
                case 5:
                    q.b(object);
                    object2 = object;
                    object3.L$0 = object2;
                    object3.L$1 = object2;
                    object3.L$2 = object2;
                    object3.L$3 = object2;
                    int i5 = 6;
                    object3.label = 6;
                    return obj2;
                case 6:
                    q.b(object);
                    object2 = object;
                    String str7 = null;
                    i2 = (IsDogPremiumInteractor.b(LibraryViewModel.p(object3.this$0), str7, i3, str7).blockingGet().booleanValue()) ^ i3;
                    i = LibraryViewModel.trackTrickTapped(object3.this$0).q().blockingGet().booleanValue() ^ i3;
                    object3.L$0 = object2;
                    object3.L$1 = object2;
                    object3.L$2 = object2;
                    object3.L$3 = object2;
                    object3.L$4 = object2;
                    object3.I$0 = i2;
                    object3.I$1 = i;
                    int i6 = 7;
                    object3.label = 7;
                    return obj2;
                case 7:
                    q.b(object);
                    object2 = object;
                    object3.L$0 = object2;
                    object3.L$1 = object2;
                    object3.L$2 = object2;
                    object3.L$3 = object2;
                    object3.L$4 = object2;
                    object3.L$5 = object2;
                    object3.I$0 = i2;
                    object3.I$1 = i;
                    int i7 = 8;
                    object3.label = 8;
                    return obj2;
                case 8:
                    q.b(object);
                    object2 = object;
                    Library library = new Library(b.a(object3.this$0), b.a(z), librarySection, librarySection2, librarySection3, librarySection4, librarySection5, list, (List)object2);
                    LibraryViewModel.o(object3.this$0).postValue(new LoadResult_Success(library));
                    return w.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int r2 = i3;
            if (object3.this$0 != 0) {
                throw new InvalidParameterException("Dog id is Empty");
            } else {
                object3.label = 2;
                str = "id_tricks";
                if (object3.this$0.connectivityService.f(str, object3) == object3.this$0) {
                    return obj2;
                }
            }
        }

        a(d<? super j.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.j.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.j.a(j.this, dVar);
        }
    }
    public /* synthetic */ j(q2 q2Var, o2 o2Var, o3 o3Var, d3 d3Var, n3 n3Var, p2 p2Var, k1 k1Var, j2 j2Var, FirebaseFirestore firebaseFirestore, p1 p1Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var112;
        h0Var112 = i & 1024 != 0 ? h0Var112 : h0Var;
        this(q2Var, o2Var, o3Var, d3Var, n3Var, p2Var, k1Var, j2Var, firebaseFirestore, p1Var, h0Var112);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 trackArticleTapped(j articleId) {
        return articleId.isDogPremiumInteractor;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ o2 trackComingSoonProgramOpened(j programId) {
        return programId.dispatcher;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ p2 trackProgramTapped(j programId) {
        return programId.getLibraryTrickListInteractor;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ q2 trackShowAllTricksTapped(j categoryId) {
        return categoryId.connectivityService;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ n3 trackTrickTapped(j trickId) {
        return trickId.getLibraryProgramListInteractor;
    }

    public static final /* synthetic */ o3 m(j jVar) {
        return jVar.firestoreService;
    }

    public static final /* synthetic */ p1 n(j jVar) {
        return jVar.j;
    }

    public static final /* synthetic */ x o(j jVar) {
        return jVar.l;
    }

    public static final /* synthetic */ d3 p(j jVar) {
        return jVar.getLibraryArticleListInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: A, reason: from kotlin metadata */
    public final void loadList() {
        this.firestoreService.logEvent(E_Library.c);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(String str) {
        n.f(str, "categoryId");
        this.firestoreService.logEvent(E_Library.a.c(new EP_CategoryId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.firestoreService.logEvent(E_Library.h);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D() {
        this.firestoreService.logEvent(E_Library.j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void E(String str) {
        n.f(str, "trickId");
        this.firestoreService.logEvent(E_Library.d.c(new EP_TrickId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F() {
        this.firestoreService.logEvent(E_Library.f);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.rateRepository.enableNetwork();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<q2.a> q() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Library>> r() {
        return this.subscribeInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<q2.a> s() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.k.plus(this.p), dVar, new kotlinx.coroutines.j.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String str) {
        n.f(str, "articleId");
        this.firestoreService.logEvent(E_Library.e.c(new EP_ArticleId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        this.firestoreService.logEvent(E_Library.i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(String str) {
        n.f(str, "programId");
        this.firestoreService.logEvent(E_TrainingProgram.p.c(new EP_ProgramId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.firestoreService.logEvent(E_Library.g);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String str) {
        n.f(str, "programId");
        this.firestoreService.logEvent(E_Library.k.c(new EP_ProgramId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.firestoreService.logEvent(E_Library.b);
    }

    public j(q2 q2Var, o2 o2Var, o3 o3Var, d3 d3Var, n3 n3Var, p2 p2Var, k1 k1Var, j2 j2Var, FirebaseFirestore firebaseFirestore, p1 p1Var, h0 h0Var) {
        n.f(q2Var, "getLibraryTrickListInteractor");
        n.f(o2Var, "getLibraryArticleListInteractor");
        n.f(o3Var, "tracker");
        n.f(d3Var, "isDogPremiumInteractor");
        n.f(n3Var, "subscribeInteractor");
        n.f(p2Var, "getLibraryProgramListInteractor");
        n.f(k1Var, "rateRepository");
        n.f(j2Var, "connectivityService");
        n.f(firebaseFirestore, "firestoreService");
        n.f(p1Var, "userRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.connectivityService = q2Var;
        this.dispatcher = o2Var;
        this.firestoreService = o3Var;
        this.getLibraryArticleListInteractor = d3Var;
        this.getLibraryProgramListInteractor = n3Var;
        this.getLibraryTrickListInteractor = p2Var;
        this.g = k1Var;
        this.isDogPremiumInteractor = j2Var;
        this.rateRepository = firebaseFirestore;
        this.j = p1Var;
        this.k = h0Var;
        x xVar = new x();
        this.l = xVar;
        this.subscribeInteractor = xVar;
        this.tracker = k1Var.a();
        this.userRepository = k1Var.b();
        this.p = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }
}
