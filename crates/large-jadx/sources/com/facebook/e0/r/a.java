package com.facebook.e0.r;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.e0.g;
import com.facebook.e0.g.a;
import com.facebook.e0.r.g.a;
import com.facebook.e0.r.g.f;
import com.facebook.e0.v.b;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u000cH\u0007J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0001¢\u0006\u0002\u0008\u000fJ\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0008\u0013¨\u0006\u0016", d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener;", "", "()V", "getOnClickListener", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "getOnItemClickListener", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView;", "logEvent", "", "logEvent$facebook_core_release", "updateParameters", "parameters", "Landroid/os/Bundle;", "updateParameters$facebook_core_release", "AutoLoggingOnClickListener", "AutoLoggingOnItemClickListener", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    public static final com.facebook.e0.r.a a;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00050\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "Landroid/view/View$OnClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "existingOnClickListener", "Ljava/lang/ref/WeakReference;", "supportCodelessLogging", "", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "onClick", "", "view", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements View.OnClickListener {

        private a a;
        private WeakReference<View> b;
        private WeakReference<View> c;
        private View.OnClickListener v;
        private boolean w = true;
        public a(a a, View view2, View view3) {
            n.f(a, "mapping");
            n.f(view2, "rootView");
            n.f(view3, "hostView");
            super();
            this.a = a;
            WeakReference obj2 = new WeakReference(view3);
            this.b = obj2;
            obj2 = new WeakReference(view2);
            this.c = obj2;
            this.v = f.g(view3);
            obj2 = 1;
        }

        @Override // android.view.View$OnClickListener
        public final boolean a() {
            return this.w;
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            a aVar;
            if (a.d(this)) {
            }
            n.f(view, "view");
            View.OnClickListener list = this.v;
            if (list != null) {
                list.onClick(view);
            }
            Object obj3 = this.c.get();
            Object obj = this.b.get();
            if ((View)obj3 != null && (View)obj != null) {
                if ((View)obj != null) {
                    aVar = this.a;
                    if (aVar == null) {
                    } else {
                        try {
                            a.c(aVar, (View)obj3, (View)obj);
                            obj3 = new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.internal.EventBinding");
                            throw obj3;
                            a.b(view, this);
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u0007¢\u0006\u0002\u0010\u0008J.\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010¨\u0006\u0019", d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "Landroid/widget/AdapterView;", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/widget/AdapterView;)V", "existingOnItemClickListener", "Ljava/lang/ref/WeakReference;", "supportCodelessLogging", "", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "onItemClick", "", "parent", "view", "position", "", "id", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements AdapterView.OnItemClickListener {

        private a a;
        private WeakReference<AdapterView<?>> b;
        private WeakReference<View> c;
        private AdapterView.OnItemClickListener v;
        private boolean w = true;
        public b(a a, View view2, AdapterView<?> adapterView3) {
            n.f(a, "mapping");
            n.f(view2, "rootView");
            n.f(adapterView3, "hostView");
            super();
            this.a = a;
            WeakReference obj2 = new WeakReference(adapterView3);
            this.b = obj2;
            obj2 = new WeakReference(view2);
            this.c = obj2;
            this.v = adapterView3.getOnItemClickListener();
            obj2 = 1;
        }

        @Override // android.widget.AdapterView$OnItemClickListener
        public final boolean a() {
            return this.w;
        }

        public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
            AdapterView view;
            Object obj;
            int i;
            long l;
            a obj10;
            n.f(view2, "view");
            final AdapterView.OnItemClickListener list = this.v;
            if (list != null) {
                list.onItemClick(adapterView, view2, i3, l4);
            }
            Object obj8 = this.c.get();
            Object obj9 = this.b.get();
            if ((View)obj8 != null && (AdapterView)obj9 != null) {
                if ((AdapterView)obj9 != null) {
                    a.c(this.a, (View)obj8, (AdapterView)obj9);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        final String a;
        final Bundle b;
        c(String string, Bundle bundle2) {
            this.a = string;
            this.b = bundle2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            g.b.f(o.f()).f(this.a, this.b);
        }
    }
    static {
        a aVar = new a();
        a.a = aVar;
    }

    public static final com.facebook.e0.r.a.a a(a a, View view2, View view3) {
        if (a.d(a.class)) {
            return null;
        }
        n.f(a, "mapping");
        n.f(view2, "rootView");
        n.f(view3, "hostView");
        a.a aVar = new a.a(a, view2, view3);
        return aVar;
    }

    public static final com.facebook.e0.r.a.b b(a a, View view2, AdapterView<?> adapterView3) {
        if (a.d(a.class)) {
            return null;
        }
        n.f(a, "mapping");
        n.f(view2, "rootView");
        n.f(adapterView3, "hostView");
        a.b bVar = new a.b(a, view2, adapterView3);
        return bVar;
    }

    public static final void c(a a, View view2, View view3) {
        if (a.d(a.class)) {
        }
        n.f(a, "mapping");
        n.f(view2, "rootView");
        n.f(view3, "hostView");
        final Bundle obj3 = c.h.b(a, view2, view3);
        a.a.d(obj3);
        a.c obj5 = new a.c(a.b(), obj3);
        o.n().execute(obj5);
    }

    public final void d(Bundle bundle) {
        String string;
        String str = "_valueToSum";
        if (a.d(this)) {
        }
        n.f(bundle, "parameters");
        string = bundle.getString(str);
        if (string != null) {
            bundle.putDouble(str, b.g(string));
        }
        bundle.putString("_is_fb_codeless", "1");
    }
}
