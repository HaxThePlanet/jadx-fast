package app.dogo.com.dogo_android.s.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.dogo.com.dogo_android.util.r;
import com.facebook.applinks.a;
import com.facebook.applinks.a.b;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.i;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.q;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u000c\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DeferredLinkInteractor;", "", "firebaseDynamicLinks", "Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;", "installReferrerWrapper", "Lapp/dogo/com/dogo_android/util/InstallReferrerWrapper;", "appContext", "Landroid/content/Context;", "(Lcom/google/firebase/dynamiclinks/FirebaseDynamicLinks;Lapp/dogo/com/dogo_android/util/InstallReferrerWrapper;Landroid/content/Context;)V", "fetchFacebookDeferredLink", "Landroid/net/Uri;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchInstallReferrer", "fetchPendingDynamicLink", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c2 {

    private final FirebaseDynamicLinks a;
    private final r b;
    private final Context c;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n", d2 = {"<anonymous>", "", "appLinkData", "Lcom/facebook/applinks/AppLinkData;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b implements a.b {

        final d<Uri> a;
        b(d<? super Uri> d) {
            this.a = d;
            super();
        }

        @Override // com.facebook.applinks.a$b
        public final void a(a a) {
            int obj3;
            if (a == null) {
                obj3 = 0;
            } else {
                obj3 = a.g();
            }
            final kotlin.p.a aVar = p.a;
            p.a(obj3);
            this.a.resumeWith(obj3);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d implements e {

        final d<Uri> a;
        d(d<? super Uri> d) {
            this.a = d;
            super();
        }

        public final void onComplete(j<Uri> j) {
            boolean successful;
            Object obj3;
            if (j.isSuccessful()) {
                obj3 = j.getResult();
            } else {
                if (j.getException() == null) {
                    obj3 = new Exception("failed to fetch install referrer link");
                }
                a.d(obj3);
                obj3 = 0;
            }
            final kotlin.p.a aVar = p.a;
            p.a(obj3);
            this.a.resumeWith(obj3);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f implements e {

        final d<Uri> a;
        f(d<? super Uri> d) {
            this.a = d;
            super();
        }

        public final void onComplete(j<PendingDynamicLinkData> j) {
            Uri i;
            boolean successful;
            Object obj3;
            i = 0;
            if (j.isSuccessful()) {
                try {
                    i = obj3;
                    if (j.getException() == null) {
                    }
                    obj3 = new Exception("failed to fetch pending link");
                    a.d(obj3);
                    kotlin.p.a aVar = p.a;
                    p.a(i);
                    this.a.resumeWith(i);
                }
            } else {
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DeferredLinkInteractor", f = "DeferredLinkInteractor.kt", l = 27, m = "fetchFacebookDeferredLink")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.c2 this$0;
        a(app.dogo.com.dogo_android.s.a.c2 c2, d<? super app.dogo.com.dogo_android.s.a.c2.a> d2) {
            this.this$0 = c2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DeferredLinkInteractor", f = "DeferredLinkInteractor.kt", l = 63, m = "fetchInstallReferrer")
    static final class c extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.c2 this$0;
        c(app.dogo.com.dogo_android.s.a.c2 c2, d<? super app.dogo.com.dogo_android.s.a.c2.c> d2) {
            this.this$0 = c2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DeferredLinkInteractor", f = "DeferredLinkInteractor.kt", l = 40, m = "fetchPendingDynamicLink")
    static final class e extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.c2 this$0;
        e(app.dogo.com.dogo_android.s.a.c2 c2, d<? super app.dogo.com.dogo_android.s.a.c2.e> d2) {
            this.this$0 = c2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.c(0, this);
        }
    }
    public c2(FirebaseDynamicLinks firebaseDynamicLinks, r r2, Context context3) {
        n.f(firebaseDynamicLinks, "firebaseDynamicLinks");
        n.f(r2, "installReferrerWrapper");
        n.f(context3, "appContext");
        super();
        this.a = firebaseDynamicLinks;
        this.b = r2;
        this.c = context3;
    }

    public final Object a(d<? super Uri> d) {
        boolean aVar;
        int label;
        int i;
        int label2;
        int i2;
        int bVar;
        Object obj5;
        aVar = d;
        label = aVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof c2.a && label & i != 0) {
            aVar = d;
            label = aVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                aVar.label = label -= i;
            } else {
                aVar = new c2.a(this, d);
            }
        } else {
        }
        obj5 = aVar.result;
        Object obj = b.d();
        label2 = aVar.label;
        bVar = 1;
        if (label2 != 0) {
            if (label2 != bVar) {
            } else {
                aVar = aVar.L$0;
                q.b(obj5);
                return obj5;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj5);
        aVar.L$0 = this;
        aVar.label = bVar;
        obj5 = new i(b.c(aVar));
        bVar = new c2.b(obj5);
        a.c(this.c, bVar);
        obj5 = obj5.b();
        if (obj5 == b.d()) {
            h.c(aVar);
        }
        if (obj5 == obj) {
            return obj;
        }
    }

    public final Object b(d<? super Uri> d) {
        boolean cVar;
        int label;
        int i2;
        int label2;
        int i;
        int dVar;
        Object obj5;
        cVar = d;
        label = cVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof c2.c && label & i2 != 0) {
            cVar = d;
            label = cVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                cVar.label = label -= i2;
            } else {
                cVar = new c2.c(this, d);
            }
        } else {
        }
        obj5 = cVar.result;
        Object obj = b.d();
        label2 = cVar.label;
        dVar = 1;
        if (label2 != 0) {
            if (label2 != dVar) {
            } else {
                cVar = cVar.L$0;
                q.b(obj5);
                return obj5;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj5);
        cVar.L$0 = this;
        cVar.label = dVar;
        obj5 = new i(b.c(cVar));
        dVar = new c2.d(obj5);
        this.b.g().addOnCompleteListener(dVar);
        obj5 = obj5.b();
        if (obj5 == b.d()) {
            h.c(cVar);
        }
        if (obj5 == obj) {
            return obj;
        }
    }

    public final Object c(Intent intent, d<? super Uri> d2) {
        boolean eVar;
        int label;
        int i;
        int fVar;
        int i2;
        Object obj5;
        Object obj6;
        eVar = d2;
        label = eVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof c2.e && label & i != 0) {
            eVar = d2;
            label = eVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                eVar.label = label -= i;
            } else {
                eVar = new c2.e(this, d2);
            }
        } else {
        }
        obj6 = eVar.result;
        Object obj = b.d();
        fVar = eVar.label;
        int i3 = 1;
        if (fVar != 0) {
            if (fVar != i3) {
            } else {
                obj5 = eVar.L$1;
                obj5 = eVar.L$0;
                q.b(obj6);
                return obj6;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        eVar.L$0 = this;
        eVar.L$1 = intent;
        eVar.label = i3;
        obj6 = new i(b.c(eVar));
        fVar = new c2.f(obj6);
        this.a.getDynamicLink(intent).addOnCompleteListener(fVar);
        obj6 = obj6.b();
        if (obj6 == b.d()) {
            h.c(eVar);
        }
        if (obj6 == obj) {
            return obj;
        }
    }
}
