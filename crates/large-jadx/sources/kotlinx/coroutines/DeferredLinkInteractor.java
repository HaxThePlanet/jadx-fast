package app.dogo.com.dogo_android.s.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.dogo.com.dogo_android.util.r;
import com.facebook.applinks.a.b;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import kotlin.Metadata;
import kotlin.b0.i;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.q;

/* compiled from: DeferredLinkInteractor.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u000c\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DeferredLinkInteractor;", "", "firebaseDynamicLinks", "Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;", "installReferrerWrapper", "Lapp/dogo/com/dogo_android/util/InstallReferrerWrapper;", "appContext", "Landroid/content/Context;", "(Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;Lapp/dogo/com/dogo_android/util/InstallReferrerWrapper;Landroid/content/Context;)V", "fetchFacebookDeferredLink", "Landroid/net/Uri;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchInstallReferrer", "fetchPendingDynamicLink", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c2, reason: from kotlin metadata */
public final class DeferredLinkInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseDynamicLinks appContext;
    /* renamed from: b, reason: from kotlin metadata */
    private final r firebaseDynamicLinks;
    /* renamed from: c, reason: from kotlin metadata */
    private final Context installReferrerWrapper;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n", d2 = {"<anonymous>", "", "appLinkData", "Lcom/facebook/applinks/AppLinkData;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b implements a.b {

        final /* synthetic */ kotlin.b0.d<Uri> a;
        public final void a(com.facebook.applinks.a aVar) {
            Uri uri = null;
            if (aVar == null) {
                int i = 0;
            } else {
                uri = aVar.g();
            }
            Result.a(uri);
            this.a.resumeWith(uri);
        }

        b(kotlin.b0.d<? super Uri> dVar) {
            this.a = dVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d<TResult> implements e {

        final /* synthetic */ kotlin.b0.d<Uri> a;
        public final void onComplete(j<Uri> jVar) {
            boolean successful;
            Object result = null;
            Exception exception;
            if (jVar.isSuccessful()) {
                result = jVar.getResult();
            } else {
                if (jVar.getException() == null) {
                    exception = new Exception("failed to fetch install referrer link");
                }
                a.d(exception);
                int i = 0;
            }
            Result.a(result);
            this.a.resumeWith(result);
        }

        d(kotlin.b0.d<? super Uri> dVar) {
            this.a = dVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f<TResult> implements e {

        final /* synthetic */ kotlin.b0.d<Uri> a;
        public final void onComplete(j<PendingDynamicLinkData> jVar) {
            boolean successful;
            Exception exception;
            int i = 0;
            try {
                if (jVar.isSuccessful()) {
                } else {
                    if (jVar.getException() == null) {
                        exception = new Exception("failed to fetch pending link");
                    }
                    a.d(exception);
                }
            } catch (Exception unused) {
                Result.a(jVar2);
                this.a.resumeWith(jVar2);
                return;
            }
        }

        f(kotlin.b0.d<? super Uri> dVar) {
            this.a = dVar;
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DeferredLinkInteractor", f = "DeferredLinkInteractor.kt", l = 27, m = "fetchFacebookDeferredLink")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super c2.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c2.this.fetchPendingDynamicLink(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DeferredLinkInteractor", f = "DeferredLinkInteractor.kt", l = 63, m = "fetchInstallReferrer")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super c2.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c2.this.b(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DeferredLinkInteractor", f = "DeferredLinkInteractor.kt", l = 40, m = "fetchPendingDynamicLink")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super c2.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c2.this.c(null, this);
        }
    }
    public c2(FirebaseDynamicLinks firebaseDynamicLinks, r rVar, Context context) {
        n.f(firebaseDynamicLinks, "firebaseDynamicLinks");
        n.f(rVar, "installReferrerWrapper");
        n.f(context, "appContext");
        super();
        this.appContext = firebaseDynamicLinks;
        this.firebaseDynamicLinks = rVar;
        this.installReferrerWrapper = context;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public final Object fetchPendingDynamicLink(kotlin.b0.d<? super Uri> intent) {
        Object intent2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = intent instanceof kotlinx.coroutines.c2.a;
        if (intent instanceof kotlinx.coroutines.c2.a) {
            intent2 = intent;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                intent2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.c2.a aVar = new kotlinx.coroutines.c2.a(this, intent);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (intent2.label != 0) {
            if (intent2.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                try {
                    q.b(intent2.result);
                } catch (Exception e) {
                    a.d(e);
                    e = null;
                }
                return result2;
            }
        }
        q.b(intent2.result);
        try {
            intent2.L$0 = this;
            intent2.label = i3;
            i safeContinuation = new SafeContinuation(b.c(intent2));
            a.c(this.installReferrerWrapper, new kotlinx.coroutines.c2.b(safeContinuation));
            result2 = safeContinuation.b();
            if (result2 == b.d()) {
                h.c(intent2);
            }
            if (result2 == obj2) {
                return obj2;
            }
        } catch (Exception e) {
            a.d(e);
            e = null;
        }
    }

    public final Object b(kotlin.b0.d<? super Uri> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.c2.c;
        if (dVar instanceof kotlinx.coroutines.c2.c) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.c2.c cVar = new kotlinx.coroutines.c2.c(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                    e = null;
                }
                return result2;
            }
        }
        q.b(dVar2.result);
        try {
            dVar2.L$0 = this;
            dVar2.label = i3;
            i safeContinuation = new SafeContinuation(b.c(dVar2));
            this.firebaseDynamicLinks.startConnection().addOnCompleteListener(new kotlinx.coroutines.c2.d(safeContinuation));
            result2 = safeContinuation.b();
            if (result2 == b.d()) {
                h.c(dVar2);
            }
            if (result2 == obj2) {
                return obj2;
            }
        } catch (Exception e) {
            a.d(e);
            e = null;
        }
    }

    public final Object c(Intent intent, kotlin.b0.d<? super Uri> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object obj;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.c2.e;
        if (dVar instanceof kotlinx.coroutines.c2.e) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.c2.e eVar = new kotlinx.coroutines.c2.e(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                try {
                    q.b(dVar22.result);
                } catch (Exception e) {
                    a.d(e);
                    dVar = null;
                }
                return result2;
            }
        }
        q.b(dVar22.result);
        try {
            dVar22.L$0 = this;
            dVar22.L$1 = e;
            dVar22.label = i3;
            i safeContinuation = new SafeContinuation(b.c(dVar22));
            this.appContext.getDynamicLink(e).addOnCompleteListener(new kotlinx.coroutines.c2.f(safeContinuation));
            result2 = safeContinuation.b();
            if (result2 == b.d()) {
                h.c(dVar22);
            }
            if (result2 == obj2) {
                return obj2;
            }
        } catch (Exception e) {
            a.d(e);
            dVar = null;
        }
    }
}
