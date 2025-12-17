package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;
import androidx.core.R.id;

/* loaded from: classes5.dex */
public final class ViewGroupCompat {

    private static final WindowInsets CONSUMED = null;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    static boolean sCompatInsetsDispatchInstalled;

    static class Api21Impl {
        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void setTransitionGroup(ViewGroup viewGroup, boolean isTransitionGroup) {
            viewGroup.setTransitionGroup(isTransitionGroup);
        }
    }
    static {
        ViewGroupCompat.CONSUMED = WindowInsetsCompat.CONSUMED.toWindowInsets();
        ViewGroupCompat.sCompatInsetsDispatchInstalled = false;
    }

    static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
        Object obj2;
        Object obj;
        WindowInsets consumed;
        int childCount;
        int i;
        View childAt;
        WindowInsets windowInsets2;
        Object tag = view.getTag(R.id.tag_on_apply_window_listener);
        Object tag2 = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof View.OnApplyWindowInsetsListener != null) {
            obj2 = tag;
        } else {
            if (tag2 instanceof View.OnApplyWindowInsetsListener != null) {
                obj2 = tag2;
            } else {
                obj2 = 0;
            }
        }
        WindowInsets[] arr = new WindowInsets[1];
        ViewGroupCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewGroupCompat$$ExternalSyntheticLambda0(arr, obj2);
        view.setOnApplyWindowInsetsListener(externalSyntheticLambda0);
        view.dispatchApplyWindowInsets(windowInsets);
        Object tag3 = view.getTag(R.id.tag_compat_insets_dispatch);
        if (tag3 instanceof View.OnApplyWindowInsetsListener != null) {
            obj = tag3;
        } else {
            obj = obj2;
        }
        view.setOnApplyWindowInsetsListener(obj);
        int i3 = 0;
        if (arr[i3] != null && !arr[i3].isConsumed() && view instanceof ViewGroup) {
            if (!arr[i3].isConsumed()) {
                if (view instanceof ViewGroup) {
                    consumed = view;
                    i = 0;
                    while (i < (ViewGroup)consumed.getChildCount()) {
                        ViewGroupCompat.dispatchApplyWindowInsets(consumed.getChildAt(i), arr[i3]);
                        i++;
                    }
                }
            }
        }
        return arr[i3];
    }

    @ReplaceWith(expression = "group.getLayoutMode()")
    @Deprecated
    public static int getLayoutMode(ViewGroup group) {
        return group.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup group) {
        return ViewGroupCompat.Api21Impl.getNestedScrollAxes(group);
    }

    public static void installCompatInsetsDispatch(View root) {
        if (Build.VERSION.SDK_INT >= 30) {
        }
        ViewGroupCompat$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ViewGroupCompat$$ExternalSyntheticLambda1();
        root.setTag(R.id.tag_compat_insets_dispatch, externalSyntheticLambda1);
        root.setOnApplyWindowInsetsListener(externalSyntheticLambda1);
        ViewGroupCompat.sCompatInsetsDispatchInstalled = true;
    }

    public static boolean isTransitionGroup(ViewGroup group) {
        return ViewGroupCompat.Api21Impl.isTransitionGroup(group);
    }

    static WindowInsets lambda$dispatchApplyWindowInsets$1(WindowInsets[] outInsets, View.OnApplyWindowInsetsListener listener, View v, WindowInsets w) {
        WindowInsets onApplyWindowInsets;
        if (listener != null) {
            onApplyWindowInsets = listener.onApplyWindowInsets(v, w);
        } else {
            onApplyWindowInsets = v.onApplyWindowInsets(w);
        }
        outInsets[0] = onApplyWindowInsets;
        return ViewGroupCompat.CONSUMED;
    }

    static WindowInsets lambda$installCompatInsetsDispatch$0(View view, WindowInsets windowInsets) {
        ViewGroupCompat.dispatchApplyWindowInsets(view, windowInsets);
        return ViewGroupCompat.CONSUMED;
    }

    @ReplaceWith(expression = "group.onRequestSendAccessibilityEvent(child, event)")
    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
        return group.onRequestSendAccessibilityEvent(child, event);
    }

    @ReplaceWith(expression = "group.setLayoutMode(mode)")
    @Deprecated
    public static void setLayoutMode(ViewGroup group, int mode) {
        group.setLayoutMode(mode);
    }

    @ReplaceWith(expression = "group.setMotionEventSplittingEnabled(split)")
    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        group.setMotionEventSplittingEnabled(split);
    }

    public static void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        ViewGroupCompat.Api21Impl.setTransitionGroup(group, isTransitionGroup);
    }
}
