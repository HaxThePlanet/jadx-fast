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
import d.h.c;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    private static final View.AccessibilityDelegate c;
    private final View.AccessibilityDelegate a;
    private final View.AccessibilityDelegate b;

    static final class a extends View.AccessibilityDelegate {

        final d.h.l.a a;
        a(d.h.l.a a) {
            super();
            this.a = a;
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent2) {
            return this.a.a(view, accessibilityEvent2);
        }

        @Override // android.view.View$AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            Object obj2;
            obj2 = this.a.b(view);
            if (obj2 != null) {
                obj2 = obj2.e();
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent2) {
            this.a.f(view, accessibilityEvent2);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
            d.h.l.a aVar;
            int obj4;
            final c cVar = c.y0(accessibilityNodeInfo2);
            cVar.p0(u.U(view));
            cVar.h0(u.P(view));
            cVar.l0(u.p(view));
            cVar.t0(u.I(view));
            this.a.g(view, cVar);
            cVar.e(accessibilityNodeInfo2.getText(), view);
            final List obj3 = a.c(view);
            obj4 = 0;
            while (obj4 < obj3.size()) {
                cVar.b((c.a)obj3.get(obj4));
                obj4++;
            }
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent2) {
            this.a.h(view, accessibilityEvent2);
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent3) {
            return this.a.i(viewGroup, view2, accessibilityEvent3);
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle3) {
            return this.a.j(view, i2, bundle3);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.a.l(view, i2);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent2) {
            this.a.m(view, accessibilityEvent2);
        }
    }
    static {
        View.AccessibilityDelegate accessibilityDelegate = new View.AccessibilityDelegate();
        a.c = accessibilityDelegate;
    }

    public a() {
        super(a.c);
    }

    public a(View.AccessibilityDelegate view$AccessibilityDelegate) {
        super();
        this.a = accessibilityDelegate;
        a.a obj1 = new a.a(this);
        this.b = obj1;
    }

    static List<c.a> c(View view) {
        Object obj1;
        if ((List)view.getTag(c.H) == null) {
            obj1 = Collections.emptyList();
        }
        return obj1;
    }

    private boolean e(ClickableSpan clickableSpan, View view2) {
        int i;
        int length;
        ClickableSpan[] obj5;
        final int i2 = 0;
        if (clickableSpan != null) {
            obj5 = c.p(view2.createAccessibilityNodeInfo().getText());
            i = i2;
            while (obj5 != null) {
                i++;
            }
        }
        return i2;
    }

    private boolean k(int i, View view2) {
        Object tag;
        int obj2;
        tag = view2.getTag(c.I);
        obj2 = (SparseArray)tag.get(i);
        obj2 = (WeakReference)obj2.get();
        if (tag != null && obj2 != null && e((ClickableSpan)obj2, view2)) {
            obj2 = tag.get(i);
            if ((WeakReference)obj2 != null) {
                obj2 = (WeakReference)obj2.get();
                if (e((ClickableSpan)obj2, view2)) {
                    obj2.onClick(view2);
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent2) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent2);
    }

    public d b(View view) {
        int sDK_INT;
        Object obj3;
        obj3 = this.a.getAccessibilityNodeProvider(view);
        if (Build.VERSION.SDK_INT >= 16 && obj3 != null) {
            obj3 = this.a.getAccessibilityNodeProvider(view);
            if (obj3 != null) {
                d dVar = new d(obj3);
                return dVar;
            }
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent2) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent2);
    }

    public void g(View view, c c2) {
        this.a.onInitializeAccessibilityNodeInfo(view, c2.x0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent2) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent2);
    }

    public boolean i(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent3) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent3);
    }

    public boolean j(View view, int i2, Bundle bundle3) {
        List sDK_INT;
        int accessibilityAction;
        int i3;
        Object size;
        int i;
        int obj7;
        sDK_INT = a.c(view);
        i3 = accessibilityAction;
        while (i3 < sDK_INT.size()) {
            size = sDK_INT.get(i3);
            if ((c.a)size.b() == i2) {
                break;
            } else {
            }
            i3++;
        }
        if (accessibilityAction == 0 && Build.VERSION.SDK_INT >= 16) {
            if (Build.VERSION.SDK_INT >= 16) {
                accessibilityAction = this.a.performAccessibilityAction(view, i2, bundle3);
            }
        }
        if (accessibilityAction == 0 && i2 == c.a) {
            if (i2 == c.a) {
                accessibilityAction = k(bundle3.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
            }
        }
        return accessibilityAction;
    }

    public void l(View view, int i2) {
        this.a.sendAccessibilityEvent(view, i2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent2) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent2);
    }
}
