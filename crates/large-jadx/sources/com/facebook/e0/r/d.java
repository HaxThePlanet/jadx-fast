package com.facebook.e0.r;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.e0.r.g.a;
import com.facebook.e0.r.g.f;
import com.facebook.internal.g0.i.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0007¨\u0006\u000b", d2 = {"Lcom/facebook/appevents/codeless/RCTCodelessLoggingEventListener;", "", "()V", "getOnTouchListener", "Lcom/facebook/appevents/codeless/RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "AutoLoggingOnTouchListener", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0014", d2 = {"Lcom/facebook/appevents/codeless/RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener;", "Landroid/view/View$OnTouchListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "existingOnTouchListener", "Ljava/lang/ref/WeakReference;", "supportCodelessLogging", "", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "onTouch", "view", "motionEvent", "Landroid/view/MotionEvent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements View.OnTouchListener {

        private final a a;
        private final WeakReference<View> b;
        private final WeakReference<View> c;
        private final View.OnTouchListener v;
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
            this.v = f.h(view3);
            obj2 = 1;
        }

        @Override // android.view.View$OnTouchListener
        public final boolean a() {
            return this.w;
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            int i;
            int action;
            Object obj5;
            n.f(view, "view");
            n.f(motionEvent2, "motionEvent");
            Object obj = this.c.get();
            Object obj2 = this.b.get();
            if ((View)obj != null && (View)obj2 != null && motionEvent2.getAction() == 1) {
                if ((View)obj2 != null) {
                    if (motionEvent2.getAction() == 1) {
                        a.c(this.a, (View)obj, (View)obj2);
                    }
                }
            }
            View.OnTouchListener list = this.v;
            if (list != null && list.onTouch(view, motionEvent2)) {
                if (list.onTouch(view, motionEvent2)) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
    }
    static {
    }

    public static final com.facebook.e0.r.d.a a(a a, View view2, View view3) {
        if (a.d(d.class)) {
            return null;
        }
        n.f(a, "mapping");
        n.f(view2, "rootView");
        n.f(view3, "hostView");
        d.a aVar = new d.a(a, view2, view3);
        return aVar;
    }
}
