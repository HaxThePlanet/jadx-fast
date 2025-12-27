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
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.c.a;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;
import zendesk.support.Support;

/* compiled from: LanguageSelectViewModel.kt */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010%\u001a\u00020&J\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0016J\u0006\u0010(\u001a\u00020\u0007J\u0011\u0010)\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012J\u0006\u00100\u001a\u00020&R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "autoStartInstall", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "splitInstallManager", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(ZLapp/dogo/com/dogo_android/service/PreferenceService;Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lkotlinx/coroutines/CoroutineDispatcher;)V", "currentLanguage", "", "getCurrentLanguage", "()Ljava/lang/String;", "languageNameList", "", "getLanguageNameList", "()Ljava/util/List;", "languageSelectionNotifier", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectionCommandItem;", "getLanguageSelectionNotifier", "()Landroidx/lifecycle/MutableLiveData;", "listener", "Lcom/google/android/play/core/listener/StateUpdatedListener;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "selectedLanguageCode", "sessionId", "", "detachListener", "", "getLanguageList", "getSplitInstallManager", "installLanguage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLanguageRemoteAndLocal", "locale", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelection", "languageName", "setupSelectedLanguage", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class LanguageSelectViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final p2 connectivityService;
    private final com.google.android.play.core.splitinstall.a b;
    /* renamed from: c, reason: from kotlin metadata */
    private final j2 dispatchers;
    private final p1 d;
    private final o3 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final h0 listener;
    /* renamed from: g, reason: from kotlin metadata */
    private final List<String> preferenceService;
    /* renamed from: h, reason: from kotlin metadata */
    private final x<y<n>> selectedLanguageCode;
    /* renamed from: i, reason: from kotlin metadata */
    private int sessionId;
    /* renamed from: j, reason: from kotlin metadata */
    private String splitInstallManager;
    /* renamed from: k, reason: from kotlin metadata */
    private f.c.a.f.a.c.a<com.google.android.play.core.splitinstall.d> tracker;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel", f = "LanguageSelectViewModel.kt", l = 92, m = "installLanguage")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super l.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return l.this.u(this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel$1", f = "LanguageSelectViewModel.kt", l = 46, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return w.a;
                }
            }
            q.b(object);
            this.label = i;
            if (l.this.u(this) == obj2) {
                return obj2;
            }
        }

        a(kotlin.b0.d<? super l.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.settings.language.l.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.settings.language.l.a(l.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel$saveLanguageRemoteAndLocal$2", f = "LanguageSelectViewModel.kt", l = {}, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ String $locale;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                l.this.connectivityService.o1(this.$locale);
                Support.INSTANCE.setHelpCenterLocaleOverride(Locale.forLanguageTag(LocaleService.d(this.$locale)));
                l.this.d.z0().e();
                return w.a;
            }
        }

        c(String str, kotlin.b0.d<? super l.c> dVar) {
            this.$locale = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.settings.language.l.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.settings.language.l.c(l.this, this.$locale, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.settings.language.LanguageSelectViewModel$setupSelectedLanguage$1", f = "LanguageSelectViewModel.kt", l = {144, 147}, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String str;
            Object obj = b.d();
            int i = 2;
            final int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    if (this.label != i) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(object);
                        } catch (Exception e) {
                        }
                    }
                }
                try {
                    q.b(e);
                } catch (Exception e) {
                }
                l.this.s().setValue(new LoadResult_Success(new LanguageSelectedCommandItem(l.this.connectivityService.W())));
            } else {
                q.b(e);
                bVar = LoadResult_Loading.a;
                if (!n.b(l.this.s().getValue(), bVar)) {
                    if (n.b(l.this.connectivityService.W(), l.this.splitInstallManager)) {
                        String str4 = null;
                        l.this.s().postValue(new LoadResult_Success(new DismissDialogCommaItem(str4, i2, str4)));
                    } else {
                        if (!l.this.dispatchers.a()) {
                            l.this.e.s("settings");
                            l.this.s().postValue(new LoadResult_Error(new ConnectException()));
                        } else {
                            try {
                                l.this.s().setValue(LoadResult_Loading.a);
                                String str8 = l.this.splitInstallManager;
                                com.google.android.play.core.splitinstall.a aVar = b.a(FacebookSdk.f());
                                n.e(aVar, "create(getApplicationContext())");
                                Set set = aVar.e();
                                str = "splitInstallManager.installedLanguages";
                                n.e(set, str);
                                this.label = i;
                                return obj;
                            } catch (Exception e) {
                            }
                            y.a loadResult_Error = new LoadResult_Error(e);
                        }
                    }
                }
            }
            return w.a;
        }

        d(kotlin.b0.d<? super l.d> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.settings.language.l.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.settings.language.l.d(l.this, dVar);
        }
    }
    public /* synthetic */ l(boolean z, p2 p2Var, com.google.android.play.core.splitinstall.a aVar, j2 j2Var, p1 p1Var, o3 o3Var, h0 h0Var, int i, g gVar) {
        h0 h0Var72;
        h0Var72 = i & 64 != 0 ? h0Var72 : h0Var;
        this(z, p2Var, aVar, j2Var, p1Var, o3Var, h0Var72);
    }

    private static final void A(l lVar, com.google.android.play.core.splitinstall.d dVar) {
        n.f(lVar, "this$0");
        n.f(dVar, "state");
        if (dVar.h() == lVar.sessionId) {
            int sessionId2 = 6;
            if (dVar.i() == 6) {
                lVar.s().setValue(new LoadResult_Error(new Exception()));
            } else {
                if (dVar.i() == 7) {
                    lVar.s().setValue(new LoadResult_Success(new LanguageSelectedCommandItem("")));
                } else {
                    if (dVar.i() == 3) {
                        lVar.s().setValue(new LoadResult_Success(new LanguageSelectedCommandItem(lVar.connectivityService.W())));
                    } else {
                        if (dVar.i() == 5) {
                            lVar.s().setValue(new LoadResult_Success(new LanguageSelectedCommandItem(lVar.connectivityService.W())));
                        } else {
                            if (dVar.i() == 0) {
                                lVar.s().setValue(new LoadResult_Error(new Exception()));
                                Object[] arr = new Object[1];
                                int i = 0;
                                arr[i] = Integer.valueOf(dVar.c());
                                str = "Language select UNKNOWN Error Met - %s";
                                a.c(str, arr);
                            } else {
                                sessionId2 = 8;
                                if (dVar.i() == 8) {
                                    lVar.s().setValue(new LoadResult_Success(new LanguageConfirmCommandItem(dVar)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final Object B(String str, kotlin.b0.d<? super w> dVar) {
        Object obj = kotlinx.coroutines.internal.k.e(this.listener, new app.dogo.com.dogo_android.settings.language.l.c(this, str, null), dVar);
        if (obj == b.d()) {
            return obj;
        }
        return w.a;
    }

    /* renamed from: h, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ j2 saveLanguageRemoteAndLocal(l locale) {
        return locale.dispatchers;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ p2 saveSelection(l languageName) {
        return languageName.connectivityService;
    }

    public static final /* synthetic */ String j(l lVar) {
        return lVar.splitInstallManager;
    }

    public static final /* synthetic */ o3 k(l lVar) {
        return lVar.e;
    }

    public static final /* synthetic */ p1 l(l lVar) {
        return lVar.d;
    }

    public static final /* synthetic */ Object m(l lVar, kotlin.b0.d dVar) {
        return lVar.u(dVar);
    }

    public static final /* synthetic */ Object n(l lVar, String str, kotlin.b0.d dVar) {
        return lVar.B(str, dVar);
    }

    private final Object u(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        app.dogo.com.dogo_android.t.h0.l lVar;
        int label2;
        int i = -2147483648;
        int i2;
        z = dVar instanceof app.dogo.com.dogo_android.settings.language.l.b;
        if (dVar instanceof app.dogo.com.dogo_android.settings.language.l.b) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.t.h0.l.b bVar = new app.dogo.com.dogo_android.settings.language.l.b(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar2.result);
                c.a aVar3 = c.c();
                aVar3.a(Locale.forLanguageTag(lVar.connectivityService.W()));
                c cVar = aVar3.b();
                n.e(cVar, "newBuilder()\n            .addLanguage(Locale.forLanguageTag(preferenceService.selectedLocale))\n            .build()");
                lVar.b.d((e)lVar.tracker);
                com.google.android.play.core.tasks.d dVar4 = lVar.b.b(cVar);
                dVar4.d(new app.dogo.com.dogo_android.settings.language.d(lVar));
                dVar4.b(new app.dogo.com.dogo_android.settings.language.f(lVar));
                return w.a;
            }
        }
        q.b(dVar2.result);
        dVar2.L$0 = this;
        dVar2.label = i3;
        if (B(this.splitInstallManager, dVar2) == obj) {
            return obj;
        }
        lVar = this;
    }

    private static final void v(l lVar, Integer integer) {
        n.f(lVar, "this$0");
        n.e(integer, "result");
        lVar.sessionId = integer.intValue();
    }

    private static final void w(l lVar, Exception exc) {
        n.f(lVar, "this$0");
        a.d(exc);
        Objects.requireNonNull(exc, "null cannot be cast to non-null type com.google.android.play.core.splitinstall.SplitInstallException");
        if (exc.a() == -6) {
            lVar.s().setValue(new LoadResult_Error(new ConnectException()));
        } else {
            lVar.s().setValue(new LoadResult_Error(new Exception()));
        }
        lVar.s().setValue(new LoadResult_Error(new Exception()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C(String str) {
        int i = 0;
        int i2 = 0;
        n2.a aVar;
        boolean z;
        n.f(str, "languageName");
        n2.a[] values = LocaleService_SupportedLocales.values();
        i = 0;
        i2 = 0;
        for (n2.a aVar : values) {
            if (n.b(aVar.getLocaleFullTag(), str)) {
                break;
            }
        }
        if (aVar != null) {
            String localeTag2 = aVar.getLocaleTag();
        }
        if (i2 == 0) {
            String localeTag = LocaleService_SupportedLocales.ENGLISH.getLocaleTag();
        }
        this.splitInstallManager = i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: D, reason: from kotlin metadata */
    /* suspend */ public final void detachListener() {
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), dVar, null, new app.dogo.com.dogo_android.settings.language.l.d(this, dVar), 3, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.b.c((e)this.tracker);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String p() {
        int i = 0;
        n2.a aVar = LocaleService_SupportedLocales.Companion.a(this.connectivityService.W());
        if (aVar == null) {
            i = 0;
        } else {
            String localeFullTag2 = aVar.getLocaleFullTag();
        }
        if (LocaleService_SupportedLocales.Companion == 0) {
            String localeFullTag = LocaleService_SupportedLocales.ENGLISH.getLocaleFullTag();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<String> q() {
        int i = 0;
        n2.a[] values = LocaleService_SupportedLocales.values();
        ArrayList arrayList = new ArrayList(values.length);
        i = 0;
        for (n2.a aVar : values) {
            arrayList.add(aVar.getLocaleFullTag());
        }
        return p.t0(p.b(p()), p.C0(p.q0(arrayList, p())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<String> r() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<n>> s() {
        return this.selectedLanguageCode;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final com.google.android.play.core.splitinstall.a t() {
        return this.b;
    }

    public l(boolean z, p2 p2Var, com.google.android.play.core.splitinstall.a aVar, j2 j2Var, p1 p1Var, o3 o3Var, h0 h0Var) {
        n.f(p2Var, "preferenceService");
        n.f(aVar, "splitInstallManager");
        n.f(j2Var, "connectivityService");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(h0Var, "dispatchers");
        super();
        this.connectivityService = p2Var;
        this.b = aVar;
        this.dispatchers = j2Var;
        this.d = p1Var;
        this.e = o3Var;
        this.listener = h0Var;
        if (z) {
            kotlin.b0.g gVar = null;
            kotlinx.coroutines.o0 o0Var = null;
            kotlin.b0.d dVar = null;
            int i = 3;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), gVar, o0Var, new app.dogo.com.dogo_android.settings.language.l.a(this, dVar), i, obj);
        }
        this.preferenceService = q();
        this.selectedLanguageCode = new x();
        this.splitInstallManager = p2Var.W();
        this.tracker = new app.dogo.com.dogo_android.settings.language.e(this);
    }

    public static /* synthetic */ void x(l lVar, Integer integer) {
        LanguageSelectViewModel.v(lVar, integer);
    }

    public static /* synthetic */ void y(l lVar, com.google.android.play.core.splitinstall.d dVar) {
        LanguageSelectViewModel.A(lVar, dVar);
    }

    public static /* synthetic */ void z(l lVar, Exception exc) {
        LanguageSelectViewModel.w(lVar, exc);
    }
}
