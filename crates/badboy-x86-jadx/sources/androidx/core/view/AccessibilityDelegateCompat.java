package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R.id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class AccessibilityDelegateCompat {

    private static final View.AccessibilityDelegate DEFAULT_DELEGATE;
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {

        final androidx.core.view.AccessibilityDelegateCompat mCompat;
        AccessibilityDelegateAdapter(androidx.core.view.AccessibilityDelegateCompat compat) {
            super();
            this.mCompat = compat;
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(host, event);
        }

        @Override // android.view.View$AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
            Object provider;
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(host);
            if (accessibilityNodeProvider != null) {
                provider = accessibilityNodeProvider.getProvider();
            } else {
                provider = 0;
            }
            return provider;
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            this.mCompat.onInitializeAccessibilityEvent(host, event);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            int i;
            Object obj;
            final AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(info);
            wrap.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(host));
            wrap.setHeading(ViewCompat.isAccessibilityHeading(host));
            wrap.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(host));
            wrap.setStateDescription(ViewCompat.getStateDescription(host));
            this.mCompat.onInitializeAccessibilityNodeInfo(host, wrap);
            wrap.addSpansToExtras(info.getText(), host);
            List actionList = AccessibilityDelegateCompat.getActionList(host);
            i = 0;
            while (i < actionList.size()) {
                wrap.addAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat)actionList.get(i));
                i++;
            }
        }

        @Override // android.view.View$AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            this.mCompat.onPopulateAccessibilityEvent(host, event);
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            return this.mCompat.onRequestSendAccessibilityEvent(host, child, event);
        }

        @Override // android.view.View$AccessibilityDelegate
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            return this.mCompat.performAccessibilityAction(host, action, args);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEvent(View host, int eventType) {
            this.mCompat.sendAccessibilityEvent(host, eventType);
        }

        @Override // android.view.View$AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            this.mCompat.sendAccessibilityEventUnchecked(host, event);
        }
    }
    static {
        View.AccessibilityDelegate accessibilityDelegate = new View.AccessibilityDelegate();
        AccessibilityDelegateCompat.DEFAULT_DELEGATE = accessibilityDelegate;
    }

    public AccessibilityDelegateCompat() {
        super(AccessibilityDelegateCompat.DEFAULT_DELEGATE);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate originalDelegate) {
        super();
        this.mOriginalDelegate = originalDelegate;
        AccessibilityDelegateCompat.AccessibilityDelegateAdapter accessibilityDelegateAdapter = new AccessibilityDelegateCompat.AccessibilityDelegateAdapter(this);
        this.mBridge = accessibilityDelegateAdapter;
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        Object emptyList;
        Object tag = view.getTag(R.id.tag_accessibility_actions);
        if ((List)tag == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = tag;
        }
        return emptyList;
    }

    private boolean isSpanStillValid(ClickableSpan span, View view) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        ClickableSpan[] clickableSpans;
        int i;
        int length;
        if (span != null) {
            clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view.createAccessibilityNodeInfo().getText());
            i = 0;
            while (clickableSpans != null) {
                i++;
            }
        }
        return 0;
    }

    private boolean performClickableSpanAction(int clickableSpanId, View host) {
        Object obj;
        Object obj2;
        boolean spanStillValid;
        Object tag = host.getTag(R.id.tag_accessibility_clickable_spans);
        obj = (SparseArray)tag.get(clickableSpanId);
        obj2 = (WeakReference)obj.get();
        if (tag != null && obj != null && isSpanStillValid((ClickableSpan)obj2, host)) {
            obj = tag.get(clickableSpanId);
            if ((WeakReference)obj != null) {
                obj2 = (WeakReference)obj.get();
                if (isSpanStillValid((ClickableSpan)obj2, host)) {
                    obj2.onClick(host);
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(host, event);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(host);
        if (accessibilityNodeProvider != null) {
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            return accessibilityNodeProviderCompat;
        }
        return null;
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(host, info.unwrap());
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(host, event);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(host, child, event);
    }

    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        int success;
        int i;
        Object size;
        int i2;
        success = 0;
        final List actionList = AccessibilityDelegateCompat.getActionList(host);
        i = 0;
        while (i < actionList.size()) {
            size = actionList.get(i);
            if ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)size.getId() == action) {
                break;
            } else {
            }
            i++;
        }
        if (success == 0) {
            success = this.mOriginalDelegate.performAccessibilityAction(host, action, args);
        }
        if (success == 0 && action == R.id.accessibility_action_clickable_span && args != null) {
            if (action == R.id.accessibility_action_clickable_span) {
                if (args != null) {
                    success = performClickableSpanAction(args.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), host);
                }
            }
        }
        return success;
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        this.mOriginalDelegate.sendAccessibilityEvent(host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(host, event);
    }
}
