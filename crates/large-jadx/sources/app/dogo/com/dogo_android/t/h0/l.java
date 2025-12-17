package app.dogo.com.dogo_android.t.h0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.n2.a;
import app.dogo.com.dogo_android.service.n2.a.a;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import com.facebook.o;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.a;
import com.google.android.play.core.splitinstall.b;
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.c.a;
import com.google.android.play.core.splitinstall.d;
import com.google.android.play.core.tasks.d;
import f.c.a.f.a.c.a;
import i.b.b;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;
import zendesk.support.Support;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010%\u001a\u00020&J\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0016J\u0006\u0010(\u001a\u00020\u0007J\u0011\u0010)\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012J\u0006\u00100\u001a\u00020&R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "autoStartInstall", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "splitInstallManager", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(ZLapp/dogo/com/dogo_android/service/PreferenceService;Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lkotlinx/coroutines/CoroutineDispatcher;)V", "currentLanguage", "", "getCurrentLanguage", "()Ljava/lang/String;", "languageNameList", "", "getLanguageNameList", "()Ljava/util/List;", "languageSelectionNotifier", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectionCommandItem;", "getLanguageSelectionNotifier", "()Landroidx/lifecycle/MutableLiveData;", "listener", "Lcom/google/android/play/core/listener/StateUpdatedListener;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "selectedLanguageCode", "sessionId", "", "detachListener", "", "getLanguageList", "getSplitInstallManager", "installLanguage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLanguageRemoteAndLocal", "locale", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelection", "languageName", "setupSelectedLanguage", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends s {

    private final p2 a;
    private final a b;
    private final j2 c;
    private final p1 d;
    private final o3 e;
    private final h0 f;
    private final List<String> g;
    private final x<y<app.dogo.com.dogo_android.t.h0.n>> h;
    private int i;
    private String j;
    private a<d> k;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel", f = "LanguageSelectViewModel.kt", l = 92, m = "installLanguage")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.t.h0.l this$0;
        b(app.dogo.com.dogo_android.t.h0.l l, d<? super app.dogo.com.dogo_android.t.h0.l.b> d2) {
            this.this$0 = l;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return l.m(this.this$0, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel$1", f = "LanguageSelectViewModel.kt", l = 46, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.t.h0.l this$0;
        a(app.dogo.com.dogo_android.t.h0.l l, d<? super app.dogo.com.dogo_android.t.h0.l.a> d2) {
            this.this$0 = l;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.a obj2 = new l.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj4;
            Object obj = b.d();
            final int label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.label = i;
            if (l.m(this.this$0, this) == obj) {
                return obj;
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel$saveLanguageRemoteAndLocal$2", f = "LanguageSelectViewModel.kt", l = {}, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        final String $locale;
        int label;
        final app.dogo.com.dogo_android.t.h0.l this$0;
        c(app.dogo.com.dogo_android.t.h0.l l, String string2, d<? super app.dogo.com.dogo_android.t.h0.l.c> d3) {
            this.this$0 = l;
            this.$locale = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.c obj3 = new l.c(this.this$0, this.$locale, d2);
            return obj3;
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
                l.i(this.this$0).o1(this.$locale);
                Support.INSTANCE.setHelpCenterLocaleOverride(Locale.forLanguageTag(n2.d(this.$locale)));
                l.l(this.this$0).z0().e();
                return w.a;
            }
            IllegalStateException obj2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj2;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel$setupSelectedLanguage$1", f = "LanguageSelectViewModel.kt", l = {144, 147}, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.t.h0.l this$0;
        d(app.dogo.com.dogo_android.t.h0.l l, d<? super app.dogo.com.dogo_android.t.h0.l.d> d2) {
            this.this$0 = l;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.d obj2 = new l.d(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object cVar;
            int connectException;
            String i;
            String str;
            Object obj6;
            cVar = b.d();
            connectException = this.label;
            i = 2;
            final int i2 = 1;
            if (connectException != null) {
                if (connectException != i2) {
                    if (connectException != i) {
                    } else {
                        q.b(object);
                    }
                    obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj6;
                }
                q.b(object);
                connectException = new m(l.i(this.this$0).W());
                cVar = new y.c(connectException);
                this.this$0.s().setValue(cVar);
            } else {
                q.b(object);
                connectException = y.b.a;
                if (!n.b(this.this$0.s().getValue(), connectException)) {
                    if (n.b(l.i(this.this$0).W(), l.j(this.this$0))) {
                        i = 0;
                        connectException = new g(i, i2, i);
                        cVar = new y.c(connectException);
                        this.this$0.s().postValue(cVar);
                    } else {
                        if (!l.h(this.this$0).a()) {
                            l.k(this.this$0).s("settings");
                            connectException = new ConnectException();
                            cVar = new y.a(connectException);
                            this.this$0.s().postValue(cVar);
                        } else {
                            this.this$0.s().setValue(connectException);
                            obj6 = l.j(this.this$0);
                            a aVar2 = b.a(o.f());
                            n.e(aVar2, "create(getApplicationContext())");
                            Set set = aVar2.e();
                            n.e(set, "splitInstallManager.installedLanguages");
                            if (!set.contains(obj6)) {
                                this.label = i;
                                if (l.m(this.this$0, this) == cVar) {
                                    try {
                                        return cVar;
                                        this.label = i2;
                                        if (l.n(this.this$0, obj6, this) == cVar) {
                                        }
                                        return cVar;
                                    }
                                }
                            } else {
                            }
                        }
                    }
                }
            }
            return w.a;
        }
    }
    public l(boolean z, p2 p22, a a3, j2 j24, p1 p15, o3 o36, h0 h07) {
        m0 m0Var;
        int i2;
        int i;
        app.dogo.com.dogo_android.t.h0.l.a aVar;
        int i3;
        int i4;
        int obj8;
        n.f(p22, "preferenceService");
        n.f(a3, "splitInstallManager");
        n.f(j24, "connectivityService");
        n.f(p15, "userRepository");
        n.f(o36, "tracker");
        n.f(h07, "dispatchers");
        super();
        this.a = p22;
        this.b = a3;
        this.c = j24;
        this.d = p15;
        this.e = o36;
        this.f = h07;
        if (z != 0) {
            aVar = new l.a(this, 0);
            k.d(f0.a(this), 0, 0, aVar, 3, 0);
        }
        this.g = q();
        obj8 = new x();
        this.h = obj8;
        this.j = p22.W();
        obj8 = new e(this);
        this.k = obj8;
    }

    public l(boolean z, p2 p22, a a3, j2 j24, p1 p15, o3 o36, h0 h07, int i8, g g9) {
        h0 i;
        h0 h0Var;
        if (i8 & 64 != 0) {
            h0Var = i;
        } else {
            h0Var = h07;
        }
        super(z, p22, a3, j24, p15, o36, h0Var);
    }

    private static final void A(app.dogo.com.dogo_android.t.h0.l l, d d2) {
        int cVar;
        int hVar;
        Object obj2;
        Object obj3;
        n.f(l, "this$0");
        n.f(d2, "state");
        if (d2.h() == l.i) {
            if (d2.i() == 6) {
                cVar = new Exception();
                obj3 = new y.a(cVar);
                l.s().setValue(obj3);
            } else {
                if (d2.i() == 7) {
                    cVar = new m("");
                    obj3 = new y.c(cVar);
                    l.s().setValue(obj3);
                } else {
                    if (d2.i() == 3) {
                        hVar = new m(l.a.W());
                        cVar = new y.c(hVar);
                        l.s().setValue(cVar);
                    } else {
                        if (d2.i() == 5) {
                            hVar = new m(l.a.W());
                            cVar = new y.c(hVar);
                            l.s().setValue(cVar);
                        } else {
                            if (d2.i() == 0) {
                                hVar = new Exception();
                                y.a aVar = new y.a(hVar);
                                l.s().setValue(aVar);
                                obj2 = new Object[1];
                                a.c("Language select UNKNOWN Error Met - %s", Integer.valueOf(d2.c()));
                            } else {
                                if (d2.i() == 8) {
                                    hVar = new h(d2);
                                    cVar = new y.c(hVar);
                                    l.s().setValue(cVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final Object B(String string, d<? super w> d2) {
        l.c cVar = new l.c(this, string, 0);
        Object obj4 = k.e(this.f, cVar, d2);
        if (obj4 == b.d()) {
            return obj4;
        }
        return w.a;
    }

    public static final j2 h(app.dogo.com.dogo_android.t.h0.l l) {
        return l.c;
    }

    public static final p2 i(app.dogo.com.dogo_android.t.h0.l l) {
        return l.a;
    }

    public static final String j(app.dogo.com.dogo_android.t.h0.l l) {
        return l.j;
    }

    public static final o3 k(app.dogo.com.dogo_android.t.h0.l l) {
        return l.e;
    }

    public static final p1 l(app.dogo.com.dogo_android.t.h0.l l) {
        return l.d;
    }

    public static final Object m(app.dogo.com.dogo_android.t.h0.l l, d d2) {
        return l.u(d2);
    }

    public static final Object n(app.dogo.com.dogo_android.t.h0.l l, String string2, d d3) {
        return l.B(string2, d3);
    }

    private final Object u(d<? super w> d) {
        boolean bVar;
        Object l$0;
        int label;
        int i;
        int i2;
        Object obj5;
        bVar = d;
        label = bVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof l.b && label & i != 0) {
            bVar = d;
            label = bVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                bVar.label = label -= i;
            } else {
                bVar = new l.b(this, d);
            }
        } else {
        }
        obj5 = bVar.result;
        Object obj = b.d();
        int label2 = bVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                l$0 = bVar.L$0;
                q.b(obj5);
                obj5 = c.c();
                obj5.a(Locale.forLanguageTag(l$0.a.W()));
                obj5 = obj5.b();
                n.e(obj5, "newBuilder()\n            .addLanguage(Locale.forLanguageTag(preferenceService.selectedLocale))\n            .build()");
                l$0.b.d((e)l$0.k);
                obj5 = l$0.b.b(obj5);
                d dVar = new d(l$0);
                obj5.d(dVar);
                f fVar = new f(l$0);
                obj5.b(fVar);
                return w.a;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj5);
        bVar.L$0 = this;
        bVar.label = i3;
        if (B(this.j, bVar) == obj) {
            return obj;
        }
        l$0 = this;
    }

    private static final void v(app.dogo.com.dogo_android.t.h0.l l, Integer integer2) {
        n.f(l, "this$0");
        n.e(integer2, "result");
        l.i = integer2.intValue();
    }

    private static final void w(app.dogo.com.dogo_android.t.h0.l l, Exception exception2) {
        y.a aVar;
        Object connectException;
        x obj3;
        n.f(l, "this$0");
        a.d(exception2);
        Objects.requireNonNull(exception2, "null cannot be cast to non-null type com.google.android.play.core.splitinstall.SplitInstallException");
        if ((SplitInstallException)exception2.a() == -6) {
            connectException = new ConnectException();
            aVar = new y.a(connectException);
            l.s().setValue(aVar);
        } else {
            connectException = new Exception();
            aVar = new y.a(connectException);
            l.s().setValue(aVar);
        }
        Exception exception = new Exception();
        obj3 = new y.a(exception);
        l.s().setValue(obj3);
    }

    public static void x(app.dogo.com.dogo_android.t.h0.l l, Integer integer2) {
        l.v(l, integer2);
    }

    public static void y(app.dogo.com.dogo_android.t.h0.l l, d d2) {
        l.A(l, d2);
    }

    public static void z(app.dogo.com.dogo_android.t.h0.l l, Exception exception2) {
        l.w(l, exception2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C(String string) {
        int i;
        int localeTag;
        n2.a aVar;
        boolean z;
        Object obj7;
        n.f(string, "languageName");
        n2.a[] values = n2.a.values();
        i = 0;
        while (i < values.length) {
            i++;
        }
        aVar = localeTag;
        if (aVar == null) {
        } else {
            localeTag = aVar.getLocaleTag();
        }
        if (localeTag == 0) {
            localeTag = n2.a.ENGLISH.getLocaleTag();
        }
        this.j = localeTag;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D() {
        final int i = 0;
        l.d dVar = new l.d(this, i);
        k.d(f0.a(this), i, 0, dVar, 3, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.b.c((e)this.k);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String p() {
        int localeFullTag;
        n2.a aVar = n2.a.Companion.a(this.a.W());
        if (aVar == null) {
            localeFullTag = 0;
        } else {
            localeFullTag = aVar.getLocaleFullTag();
        }
        if (localeFullTag == 0) {
            localeFullTag = n2.a.ENGLISH.getLocaleFullTag();
        }
        return localeFullTag;
    }

    public final List<String> q() {
        int i;
        String localeFullTag;
        n2.a[] values = n2.a.values();
        ArrayList arrayList = new ArrayList(values.length);
        i = 0;
        while (i < values.length) {
            arrayList.add(values[i].getLocaleFullTag());
            i++;
        }
        return p.t0(p.b(p()), p.C0(p.q0(arrayList, p())));
    }

    public final List<String> r() {
        return this.g;
    }

    public final x<y<app.dogo.com.dogo_android.t.h0.n>> s() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a t() {
        return this.b;
    }
}
