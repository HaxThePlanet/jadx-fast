package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class AccessibilityNodeProviderCompat {

    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {

        final androidx.core.view.accessibility.AccessibilityNodeProviderCompat mCompat;
        AccessibilityNodeProviderApi19(androidx.core.view.accessibility.AccessibilityNodeProviderCompat compat) {
            super();
            this.mCompat = compat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(virtualViewId);
            if (accessibilityNodeInfo == null) {
                return null;
            }
            return accessibilityNodeInfo.unwrap();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
            int i;
            Object obj;
            AccessibilityNodeInfo unwrap;
            List accessibilityNodeInfosByText = this.mCompat.findAccessibilityNodeInfosByText(text, virtualViewId);
            if (accessibilityNodeInfosByText == null) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < accessibilityNodeInfosByText.size()) {
                arrayList.add((AccessibilityNodeInfoCompat)accessibilityNodeInfosByText.get(i).unwrap());
                i++;
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int focus) {
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat focus2 = this.mCompat.findFocus(focus);
            if (focus2 == null) {
                return null;
            }
            return focus2.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return this.mCompat.performAction(virtualViewId, action, arguments);
        }
    }

    static class AccessibilityNodeProviderApi26 extends androidx.core.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(androidx.core.view.accessibility.AccessibilityNodeProviderCompat compat) {
            super(compat);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(virtualViewId, AccessibilityNodeInfoCompat.wrap(info), extraDataKey, arguments);
        }
    }
    public AccessibilityNodeProviderCompat() {
        super();
        AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi26 accessibilityNodeProviderApi26 = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi26(this);
        this.mProvider = accessibilityNodeProviderApi26;
    }

    public AccessibilityNodeProviderCompat(Object provider) {
        super();
        this.mProvider = provider;
    }

    public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, androidx.core.view.accessibility.AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
        return null;
    }

    public List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
        return 0;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat findFocus(int focus) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        return 0;
    }
}
