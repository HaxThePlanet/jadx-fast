package d.h.l.e0;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    private final Object a;

    static class a extends AccessibilityNodeProvider {

        final d.h.l.e0.d a;
        a(d.h.l.e0.d d) {
            super();
            this.a = d;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d.h.l.e0.c obj2 = this.a.b(i);
            if (obj2 == null) {
                return null;
            }
            return obj2.x0();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String string, int i2) {
            int i;
            AccessibilityNodeInfo accessibilityNodeInfo;
            List obj4 = this.a.c(string, i2);
            if (obj4 == null) {
                return 0;
            }
            ArrayList obj5 = new ArrayList();
            i = 0;
            while (i < obj4.size()) {
                obj5.add((c)obj4.get(i).x0());
                i++;
            }
            return obj5;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle3) {
            return this.a.f(i, i2, bundle3);
        }
    }

    static class b extends d.h.l.e0.d.a {
        b(d.h.l.e0.d d) {
            super(d);
        }

        @Override // d.h.l.e0.d$a
        public AccessibilityNodeInfo findFocus(int i) {
            d.h.l.e0.c obj2 = this.a.d(i);
            if (obj2 == null) {
                return null;
            }
            return obj2.x0();
        }
    }

    static class c extends d.h.l.e0.d.b {
        c(d.h.l.e0.d d) {
            super(d);
        }

        @Override // d.h.l.e0.d$b
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo2, String string3, Bundle bundle4) {
            this.a.a(i, c.y0(accessibilityNodeInfo2), string3, bundle4);
        }
    }
    public d() {
        d.h.l.e0.d.b bVar;
        int i;
        super();
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 26) {
            bVar = new d.c(this);
            this.a = bVar;
        } else {
            if (sDK_INT >= 19) {
                bVar = new d.b(this);
                this.a = bVar;
            } else {
                if (sDK_INT >= 16) {
                    bVar = new d.a(this);
                    this.a = bVar;
                } else {
                    this.a = 0;
                }
            }
        }
    }

    public d(Object object) {
        super();
        this.a = object;
    }

    public void a(int i, d.h.l.e0.c c2, String string3, Bundle bundle4) {
    }

    public d.h.l.e0.c b(int i) {
        return null;
    }

    public List<d.h.l.e0.c> c(String string, int i2) {
        return 0;
    }

    public d.h.l.e0.c d(int i) {
        return null;
    }

    public Object e() {
        return this.a;
    }

    public boolean f(int i, int i2, Bundle bundle3) {
        return 0;
    }
}
