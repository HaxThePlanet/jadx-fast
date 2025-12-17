package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes5.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
    private final int mClickableSpanActionId;
    private final androidx.core.view.accessibility.AccessibilityNodeInfoCompat mNodeInfoCompat;
    private final int mOriginalClickableSpanId;
    public AccessibilityClickableSpanCompat(int originalClickableSpanId, androidx.core.view.accessibility.AccessibilityNodeInfoCompat nodeInfoCompat, int clickableSpanActionId) {
        super();
        this.mOriginalClickableSpanId = originalClickableSpanId;
        this.mNodeInfoCompat = nodeInfoCompat;
        this.mClickableSpanActionId = clickableSpanActionId;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View unused) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.mOriginalClickableSpanId);
        this.mNodeInfoCompat.performAction(this.mClickableSpanActionId, bundle);
    }
}
