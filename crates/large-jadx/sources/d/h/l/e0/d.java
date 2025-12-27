package d.h.l.e0;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class d {

    private final Object a;

    static class a extends AccessibilityNodeProvider {

        final d a;
        a() {
            super();
            this.a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d.h.l.e0.c cVar = this.a.b(i);
            if (cVar == null) {
                return null;
            }
            return cVar.x0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List list = this.a.c(str, i);
            if (list == null) {
                return null;
            }
            final ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < list.size()) {
                arrayList.add((c)list.get(i).x0());
                i = i + 1;
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.f(i, i2, bundle);
        }
    }

    static class b extends d.a {
        b() {
            super(dVar);
        }

        @Override // d.h.l.e0.d$a
        public AccessibilityNodeInfo findFocus(int i) {
            d.h.l.e0.c cVar = this.a.d(i);
            if (cVar == null) {
                return null;
            }
            return cVar.x0();
        }
    }

    static class c extends d.b {
        c() {
            super(dVar);
        }

        @Override // d.h.l.e0.d$b
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.a(i, c.y0(accessibilityNodeInfo), str, bundle);
        }
    }
    public d() {
        super();
        int sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new d.c(this);
        } else {
            i = 19;
            if (Build.VERSION.SDK_INT >= 19) {
                this.a = new d.b(this);
            } else {
                i = 16;
                if (Build.VERSION.SDK_INT >= 16) {
                    this.a = new d.a(this);
                } else {
                    this.a = null;
                }
            }
        }
    }

    public Object e() {
        return this.a;
    }

    public d(Object object) {
        super();
        this.a = object;
    }

    public void a(int i, c cVar, String str, Bundle bundle) {
    }

    public c b(int i) {
        return null;
    }

    public List<c> c(String str, int i) {
        return null;
    }

    public c d(int i) {
        return null;
    }

    public boolean f(int i, int i2, Bundle bundle) {
        return false;
    }
}
