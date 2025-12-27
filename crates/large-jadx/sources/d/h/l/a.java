package d.h.l;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import d.h.l.e0.c.a;
import d.h.l.e0.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a {

    private static final View.AccessibilityDelegate c = new View$AccessibilityDelegate();
    private final View.AccessibilityDelegate a;
    private final View.AccessibilityDelegate b;

    static final class a extends View.AccessibilityDelegate {

        final a a;
        a() {
            super();
            this.a = aVar;
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View$AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            Object obj = null;
            d dVar = this.a.b(view);
            obj = dVar != null ? (AccessibilityNodeProvider)obj : 0;
            return obj;
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            int i = 0;
            final d.h.l.e0.c cVar = c.y0(accessibilityNodeInfo);
            cVar.p0(u.U(view));
            cVar.h0(u.P(view));
            cVar.l0(u.p(view));
            cVar.t0(u.I(view));
            this.a.g(view, cVar);
            cVar.e(accessibilityNodeInfo.getText(), view);
            final List list = a.c(view);
            i = 0;
            while (i < list.size()) {
                cVar.b((c.a)list.get(i));
                i = i + 1;
            }
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.h(view, accessibilityEvent);
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.j(view, i, bundle);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.l(view, i);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(a.c);
    }

    static List<c.a> c(View view) {
        Object tag;
        if ((List)view.getTag(c.H) == null) {
            List emptyList = Collections.emptyList();
        }
        return tag;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        int i;
        boolean equals;
        i = 0;
        if (clickableSpan != null) {
            ClickableSpan[] objArr = c.p(view.createAccessibilityNodeInfo().getText());
            while (objArr != null) {
                if (clickableSpan.equals(objArr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i, View view) {
        Object tag = view.getTag(c.I);
        if (tag != null) {
            Object obj = tag.get(i);
            if (obj != null) {
                obj = obj.get();
                if (e(obj, view)) {
                    obj.onClick(view);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public d b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new d(accessibilityNodeProvider);
            }
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, d.h.l.e0.c cVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, cVar.x0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i, Bundle bundle) {
        List list;
        boolean z;
        int i3;
        list = a.c(view);
        i = 0;
        while (i < list.size()) {
            Object item = list.get(i);
            if (item.b() == i) {
                break;
            }
        }
        if (i == 0 && Build.VERSION.SDK_INT >= 16) {
            boolean accessibilityAction = this.a.performAccessibilityAction(view, i, bundle);
        }
        if (i == 0 && i == c.a) {
            z = k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
        }
        return z;
    }

    public void l(View view, int i) {
        this.a.sendAccessibilityEvent(view, i);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        super();
        this.a = accessibilityDelegate;
        this.b = new a.a(this);
    }
}
