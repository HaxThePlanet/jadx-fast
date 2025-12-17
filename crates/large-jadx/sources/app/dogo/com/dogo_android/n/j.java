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
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0006\u0010*\u001a\u00020+J\u0008\u0010,\u001a\u00020+H\u0014J\u0006\u0010-\u001a\u00020+J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020+J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u00020+J\u000e\u00105\u001a\u00020+2\u0006\u00103\u001a\u000200J\u0006\u00106\u001a\u00020+J\u0006\u00107\u001a\u00020+J\u000e\u00108\u001a\u00020+2\u0006\u00109\u001a\u000200J\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020+J\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u00020+R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u001d\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010%R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010%R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "getLibraryArticleListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "getLibraryProgramListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryProgramListInteractor;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "firestoreService", "Lcom/google/firebase/firestore/FirebaseFirestore;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryProgramListInteractor;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Library;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "rateUsPopUp", "Landroidx/lifecycle/LiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUp", "()Landroidx/lifecycle/LiveData;", "results", "getResults", "sharePopUp", "getSharePopUp", "loadList", "", "onCleared", "retry", "trackArticleTapped", "articleId", "", "trackArticlesShortcutTapped", "trackComingSoonProgramOpened", "programId", "trackGamesShortcutTapped", "trackProgramTapped", "trackShowAllArticlesTapped", "trackShowAllProgramsTapped", "trackShowAllTricksTapped", "categoryId", "trackSkillsShortcutTapped", "trackSubscriptionSuggestionTapped", "trackTrickTapped", "trickId", "trackTricksShortcutTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends s {

    private final q2 a;
    private final o2 b;
    private final o3 c;
    private final d3 d;
    private final n3 e;
    private final p2 f;
    private final k1 g;
    private final j2 h;
    private final FirebaseFirestore i;
    private final p1 j;
    private final h0 k;
    private final x<y<Library>> l;
    private final LiveData<y<Library>> m;
    private final LiveData<q2.a> n;
    private final LiveData<q2.a> o;
    private final CoroutineExceptionHandler p;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.n.j a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.n.j j2) {
            this.a = j2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            j.o(this.a).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.LibraryViewModel$loadList$1", f = "LibraryViewModel.kt", l = {62, 66, 67, 68, 69, 70, 73, 74}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final app.dogo.com.dogo_android.n.j this$0;
        a(app.dogo.com.dogo_android.n.j j, d<? super app.dogo.com.dogo_android.n.j.a> d2) {
            this.this$0 = j;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (j.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            j.a obj2 = new j.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int i$12;
            x xVar;
            Object l$02;
            Object l$1;
            Object obj;
            Object l$3;
            int i$1;
            int i$02;
            int i3;
            y cVar;
            Object obj7;
            int i2;
            int unknownHostException;
            Object obj16;
            Object l$03;
            Object l$22;
            int i$0;
            Object library;
            String str2;
            Object obj12;
            Object l$13;
            String str;
            Object obj3;
            Object l$0;
            int l$2;
            Object obj17;
            int l$12;
            Object l$04;
            Object obj11;
            Object o2Var;
            int i;
            Boolean bool2;
            Boolean bool;
            Object obj13;
            Object obj14;
            Object obj9;
            Object obj2;
            Object obj6;
            Object obj15;
            Object obj10;
            Object obj4;
            Object obj5;
            Object obj8;
            final Object obj18 = this;
            Object obj19 = b.d();
            unknownHostException = 0;
            final int i5 = 1;
            switch (label) {
                case 0:
                    q.b(object);
                    j.o(obj18.this$0).postValue(y.b.a);
                    j.m(obj18.this$0).s("library");
                    unknownHostException = new UnknownHostException();
                    cVar = new y.a(unknownHostException);
                    j.o(obj18.this$0).postValue(cVar);
                    obj18.label = i5;
                    return obj19;
                    return w.a;
                case 1:
                    q.b(object);
                    obj7 = object;
                    break;
                case 2:
                    q.b(object);
                    l$02 = object;
                    obj18.L$0 = (LibrarySection)l$02;
                    obj18.label = 3;
                    return obj19;
                    obj18.L$0 = l$02;
                    obj18.L$1 = (LibrarySection)obj16;
                    obj18.label = 4;
                    return obj19;
                    l$03 = l$02;
                    l$1 = obj4;
                    obj18.L$0 = l$03;
                    obj18.L$1 = l$1;
                    obj18.L$2 = (LibrarySection)obj12;
                    obj18.label = 5;
                    return obj19;
                    l$13 = l$1;
                    obj = l$03;
                    l$22 = obj5;
                    obj18.L$0 = obj;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = (LibrarySection)obj3;
                    obj18.label = 6;
                    return obj19;
                    l$0 = obj;
                    l$3 = obj4;
                    int i10 = 0;
                    booleanValue ^= i5;
                    booleanValue2 ^= i5;
                    obj18.L$0 = l$0;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = l$3;
                    obj18.L$4 = (LibrarySection)obj17;
                    obj18.I$0 = i9;
                    obj18.I$1 = i11;
                    obj18.label = 7;
                    return obj19;
                    str = l$3;
                    i$1 = i11;
                    obj11 = obj4;
                    l$2 = l$22;
                    i$0 = i9;
                    l$12 = l$13;
                    str2 = obj8;
                    obj18.L$0 = obj11;
                    obj18.L$1 = l$12;
                    obj18.L$2 = l$2;
                    obj18.L$3 = str;
                    obj18.L$4 = str2;
                    obj18.L$5 = (List)l$04;
                    obj18.I$0 = i$0;
                    obj18.I$1 = i$1;
                    obj18.label = 8;
                    return obj19;
                    i$12 = i$1;
                    i$02 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj15 = l$04;
                    obj13 = obj11;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                case 3:
                    l$02 = obj18.L$0;
                    q.b(object);
                    obj16 = object;
                    obj18.L$0 = l$02;
                    obj18.L$1 = (LibrarySection)obj16;
                    obj18.label = 4;
                    return obj19;
                    l$03 = l$02;
                    l$1 = obj4;
                    obj18.L$0 = l$03;
                    obj18.L$1 = l$1;
                    obj18.L$2 = (LibrarySection)obj12;
                    obj18.label = 5;
                    return obj19;
                    l$13 = l$1;
                    obj = l$03;
                    l$22 = obj5;
                    obj18.L$0 = obj;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = (LibrarySection)obj3;
                    obj18.label = 6;
                    return obj19;
                    l$0 = obj;
                    l$3 = obj4;
                    i10 = 0;
                    booleanValue ^= i5;
                    booleanValue2 ^= i5;
                    obj18.L$0 = l$0;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = l$3;
                    obj18.L$4 = (LibrarySection)obj17;
                    obj18.I$0 = i9;
                    obj18.I$1 = i11;
                    obj18.label = 7;
                    return obj19;
                    str = l$3;
                    i$1 = i11;
                    obj11 = obj4;
                    l$2 = l$22;
                    i$0 = i9;
                    l$12 = l$13;
                    str2 = obj8;
                    obj18.L$0 = obj11;
                    obj18.L$1 = l$12;
                    obj18.L$2 = l$2;
                    obj18.L$3 = str;
                    obj18.L$4 = str2;
                    obj18.L$5 = (List)l$04;
                    obj18.I$0 = i$0;
                    obj18.I$1 = i$1;
                    obj18.label = 8;
                    return obj19;
                    i$12 = i$1;
                    i$02 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj15 = l$04;
                    obj13 = obj11;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                case 4:
                    l$1 = obj18.L$1;
                    l$03 = obj18.L$0;
                    q.b(object);
                    obj12 = object;
                    obj18.L$0 = l$03;
                    obj18.L$1 = l$1;
                    obj18.L$2 = (LibrarySection)obj12;
                    obj18.label = 5;
                    return obj19;
                    l$13 = l$1;
                    obj = l$03;
                    l$22 = obj5;
                    obj18.L$0 = obj;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = (LibrarySection)obj3;
                    obj18.label = 6;
                    return obj19;
                    l$0 = obj;
                    l$3 = obj4;
                    i10 = 0;
                    booleanValue ^= i5;
                    booleanValue2 ^= i5;
                    obj18.L$0 = l$0;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = l$3;
                    obj18.L$4 = (LibrarySection)obj17;
                    obj18.I$0 = i9;
                    obj18.I$1 = i11;
                    obj18.label = 7;
                    return obj19;
                    str = l$3;
                    i$1 = i11;
                    obj11 = obj4;
                    l$2 = l$22;
                    i$0 = i9;
                    l$12 = l$13;
                    str2 = obj8;
                    obj18.L$0 = obj11;
                    obj18.L$1 = l$12;
                    obj18.L$2 = l$2;
                    obj18.L$3 = str;
                    obj18.L$4 = str2;
                    obj18.L$5 = (List)l$04;
                    obj18.I$0 = i$0;
                    obj18.I$1 = i$1;
                    obj18.label = 8;
                    return obj19;
                    i$12 = i$1;
                    i$02 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj15 = l$04;
                    obj13 = obj11;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                case 5:
                    q.b(object);
                    obj3 = object;
                    l$22 = l$23;
                    obj = l$05;
                    l$13 = obj5;
                    obj18.L$0 = obj;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = (LibrarySection)obj3;
                    obj18.label = 6;
                    return obj19;
                    l$0 = obj;
                    l$3 = obj4;
                    i10 = 0;
                    booleanValue ^= i5;
                    booleanValue2 ^= i5;
                    obj18.L$0 = l$0;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = l$3;
                    obj18.L$4 = (LibrarySection)obj17;
                    obj18.I$0 = i9;
                    obj18.I$1 = i11;
                    obj18.label = 7;
                    return obj19;
                    str = l$3;
                    i$1 = i11;
                    obj11 = obj4;
                    l$2 = l$22;
                    i$0 = i9;
                    l$12 = l$13;
                    str2 = obj8;
                    obj18.L$0 = obj11;
                    obj18.L$1 = l$12;
                    obj18.L$2 = l$2;
                    obj18.L$3 = str;
                    obj18.L$4 = str2;
                    obj18.L$5 = (List)l$04;
                    obj18.I$0 = i$0;
                    obj18.I$1 = i$1;
                    obj18.label = 8;
                    return obj19;
                    i$12 = i$1;
                    i$02 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj15 = l$04;
                    obj13 = obj11;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                case 6:
                    l$3 = obj18.L$3;
                    l$22 = obj18.L$2;
                    l$13 = obj18.L$1;
                    l$0 = obj18.L$0;
                    q.b(object);
                    obj17 = object;
                    i10 = 0;
                    booleanValue ^= i5;
                    booleanValue2 ^= i5;
                    obj18.L$0 = l$0;
                    obj18.L$1 = l$13;
                    obj18.L$2 = l$22;
                    obj18.L$3 = l$3;
                    obj18.L$4 = (LibrarySection)obj17;
                    obj18.I$0 = i9;
                    obj18.I$1 = i11;
                    obj18.label = 7;
                    return obj19;
                    str = l$3;
                    i$1 = i11;
                    obj11 = obj4;
                    l$2 = l$22;
                    i$0 = i9;
                    l$12 = l$13;
                    str2 = obj8;
                    obj18.L$0 = obj11;
                    obj18.L$1 = l$12;
                    obj18.L$2 = l$2;
                    obj18.L$3 = str;
                    obj18.L$4 = str2;
                    obj18.L$5 = (List)l$04;
                    obj18.I$0 = i$0;
                    obj18.I$1 = i$1;
                    obj18.label = 8;
                    return obj19;
                    i$12 = i$1;
                    i$02 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj15 = l$04;
                    obj13 = obj11;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                case 7:
                    i$1 = obj18.I$1;
                    i$0 = obj18.I$0;
                    str2 = obj18.L$4;
                    str = obj18.L$3;
                    l$2 = obj18.L$2;
                    l$12 = obj18.L$1;
                    q.b(object);
                    obj11 = l$06;
                    l$04 = object;
                    obj18.L$0 = obj11;
                    obj18.L$1 = l$12;
                    obj18.L$2 = l$2;
                    obj18.L$3 = str;
                    obj18.L$4 = str2;
                    obj18.L$5 = (List)l$04;
                    obj18.I$0 = i$0;
                    obj18.I$1 = i$1;
                    obj18.label = 8;
                    return obj19;
                    i$12 = i$1;
                    i$02 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj15 = l$04;
                    obj13 = obj11;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                case 8:
                    i$12 = obj18.I$1;
                    i$02 = obj18.I$0;
                    q.b(object);
                    o2Var = object;
                    obj15 = i$0;
                    obj6 = str2;
                    obj2 = str;
                    obj9 = l$2;
                    obj14 = l$12;
                    obj13 = l$04;
                    i3 = i5;
                    i3 = unknownHostException;
                    unknownHostException = i5;
                    super(b.a(i3), b.a(unknownHostException), obj13, obj14, obj9, obj2, obj6, obj15, (List)o2Var);
                    cVar = new y.c(library);
                    j.o(obj18.this$0).postValue(cVar);
                    return w.a;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
            }
            i2 = (String)obj7.length() == 0 ? i5 : unknownHostException;
            if (i2 != 0) {
            } else {
                obj18.label = 2;
                if (j.k(obj18.this$0).f("id_tricks", obj18) == obj19) {
                    return obj19;
                }
            }
            InvalidParameterException invalidParameterException = new InvalidParameterException("Dog id is Empty");
            throw invalidParameterException;
        }
    }
    public j(q2 q2, o2 o22, o3 o33, d3 d34, n3 n35, p2 p26, k1 k17, j2 j28, FirebaseFirestore firebaseFirestore9, p1 p110, h0 h011) {
        n.f(q2, "getLibraryTrickListInteractor");
        n.f(o22, "getLibraryArticleListInteractor");
        n.f(o33, "tracker");
        n.f(d34, "isDogPremiumInteractor");
        n.f(n35, "subscribeInteractor");
        n.f(p26, "getLibraryProgramListInteractor");
        n.f(k17, "rateRepository");
        n.f(j28, "connectivityService");
        n.f(firebaseFirestore9, "firestoreService");
        n.f(p110, "userRepository");
        n.f(h011, "dispatcher");
        super();
        this.a = q2;
        this.b = o22;
        this.c = o33;
        this.d = d34;
        this.e = n35;
        this.f = p26;
        this.g = k17;
        this.h = j28;
        this.i = firebaseFirestore9;
        this.j = p110;
        this.k = h011;
        x obj2 = new x();
        this.l = obj2;
        this.m = obj2;
        this.n = k17.a();
        this.o = k17.b();
        j.b obj3 = new j.b(CoroutineExceptionHandler.r, this);
        this.p = obj3;
    }

    public j(q2 q2, o2 o22, o3 o33, d3 d34, n3 n35, p2 p26, k1 k17, j2 j28, FirebaseFirestore firebaseFirestore9, p1 p110, h0 h011, int i12, g g13) {
        h0 i;
        h0 h0Var;
        if (i2 &= 1024 != 0) {
            h0Var = i;
        } else {
            h0Var = h011;
        }
        super(q2, o22, o33, d34, n35, p26, k17, j28, firebaseFirestore9, p110, h0Var);
    }

    public static final j2 h(app.dogo.com.dogo_android.n.j j) {
        return j.h;
    }

    public static final o2 i(app.dogo.com.dogo_android.n.j j) {
        return j.b;
    }

    public static final p2 j(app.dogo.com.dogo_android.n.j j) {
        return j.f;
    }

    public static final q2 k(app.dogo.com.dogo_android.n.j j) {
        return j.a;
    }

    public static final n3 l(app.dogo.com.dogo_android.n.j j) {
        return j.e;
    }

    public static final o3 m(app.dogo.com.dogo_android.n.j j) {
        return j.c;
    }

    public static final p1 n(app.dogo.com.dogo_android.n.j j) {
        return j.j;
    }

    public static final x o(app.dogo.com.dogo_android.n.j j) {
        return j.l;
    }

    public static final d3 p(app.dogo.com.dogo_android.n.j j) {
        return j.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        this.c.c(d0.c);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(String string) {
        n.f(string, "categoryId");
        b1 b1Var = new b1();
        this.c.d(d0.a.c(b1Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.c.c(d0.h);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D() {
        this.c.c(d0.j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void E(String string) {
        n.f(string, "trickId");
        n2 n2Var = new n2();
        this.c.d(d0.d.c(n2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F() {
        this.c.c(d0.f);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.i.enableNetwork();
    }

    public final LiveData<q2.a> q() {
        return this.n;
    }

    public final LiveData<y<Library>> r() {
        return this.m;
    }

    public final LiveData<q2.a> s() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        int i = 0;
        j.a aVar = new j.a(this, i);
        k.d(f0.a(this), this.k.plus(this.p), i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String string) {
        n.f(string, "articleId");
        w0 w0Var = new w0();
        this.c.d(d0.e.c(w0Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        this.c.c(d0.i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(String string) {
        n.f(string, "programId");
        e2 e2Var = new e2();
        this.c.d(q0.p.c(e2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.c.c(d0.g);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String string) {
        n.f(string, "programId");
        e2 e2Var = new e2();
        this.c.d(d0.k.c(e2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.c.c(d0.b);
    }
}
