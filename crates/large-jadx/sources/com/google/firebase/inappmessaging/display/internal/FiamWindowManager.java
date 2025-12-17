package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;

/* loaded from: classes2.dex */
public class FiamWindowManager {

    static final int DEFAULT_TYPE = 1003;
    private BindingWrapper bindingWrapper;
    private Point getDisplaySize(Activity activity) {
        Point point = new Point();
        Display obj4 = getWindowManager(activity).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            obj4.getRealSize(point);
        } else {
            obj4.getSize(point);
        }
        return point;
    }

    private Rect getInsetDimensions(Activity activity) {
        Rect rect = new Rect();
        Rect visibleFrame = getVisibleFrame(activity);
        Point obj5 = getDisplaySize(activity);
        rect.top = visibleFrame.top;
        rect.left = visibleFrame.left;
        rect.right = i -= right;
        rect.bottom = obj5 -= bottom;
        return rect;
    }

    private WindowManager.LayoutParams getLayoutParams(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Activity activity2) {
        Rect obj9;
        super(inAppMessageLayoutConfig.windowWidth().intValue(), inAppMessageLayoutConfig.windowHeight().intValue(), 1003, inAppMessageLayoutConfig.windowFlag().intValue(), -3);
        int i2 = 48;
        if (intValue &= i2 == i2) {
            layoutParams2.y = obj9.top;
        }
        layoutParams2.dimAmount = 1050253722;
        layoutParams2.gravity = inAppMessageLayoutConfig.viewWindowGravity().intValue();
        layoutParams2.windowAnimations = 0;
        return layoutParams2;
    }

    private com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener getSwipeListener(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, BindingWrapper bindingWrapper2, WindowManager windowManager3, WindowManager.LayoutParams windowManager$LayoutParams4) {
        FiamWindowManager.1 anon2 = new FiamWindowManager.1(this, bindingWrapper2);
        if (inAppMessageLayoutConfig.windowWidth().intValue() == -1) {
            SwipeDismissTouchListener obj9 = new SwipeDismissTouchListener(bindingWrapper2.getDialogView(), 0, anon2);
            return obj9;
        }
        super(this, bindingWrapper2.getDialogView(), 0, anon2, layoutParams4, windowManager3, bindingWrapper2);
        return obj9;
    }

    private Rect getVisibleFrame(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    private WindowManager getWindowManager(Activity activity) {
        return (WindowManager)activity.getSystemService("window");
    }

    public void destroy(Activity activity) {
        boolean fiamDisplayed;
        Activity obj2;
        if (isFiamDisplayed()) {
            getWindowManager(activity).removeViewImmediate(this.bindingWrapper.getRootView());
            this.bindingWrapper = 0;
        }
    }

    public boolean isFiamDisplayed() {
        BindingWrapper bindingWrapper = this.bindingWrapper;
        if (bindingWrapper == null) {
            return 0;
        }
        return bindingWrapper.getRootView().isShown();
    }

    public void show(BindingWrapper bindingWrapper, Activity activity2) {
        Object dialogView;
        boolean obj8;
        if (isFiamDisplayed()) {
            Logging.loge("Fiam already active. Cannot show new Fiam.");
        }
        if (activity2.isFinishing()) {
            Logging.loge("Activity is finishing or does not have valid window token. Cannot show FIAM.");
        }
        dialogView = bindingWrapper.getConfig();
        final WindowManager.LayoutParams layoutParams = getLayoutParams(dialogView, activity2);
        final WindowManager windowManager = getWindowManager(activity2);
        windowManager.addView(bindingWrapper.getRootView(), layoutParams);
        obj8 = getInsetDimensions(activity2);
        Logging.logdPair("Inset (top, bottom)", (float)top, (float)bottom);
        Logging.logdPair("Inset (left, right)", (float)left, (float)obj8);
        if (bindingWrapper.canSwipeToDismiss()) {
            bindingWrapper.getDialogView().setOnTouchListener(getSwipeListener(dialogView, bindingWrapper, windowManager, layoutParams));
        }
        this.bindingWrapper = bindingWrapper;
    }
}
