package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.ReplaceWith;
import androidx.collection.SimpleArrayMap;
import androidx.core.R.id;
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import androidx.core.viewtree.ViewTree;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public class ViewCompat {

    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    @Deprecated
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    @Deprecated
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    @Deprecated
    public static final int LAYOUT_DIRECTION_LTR = 0;
    @Deprecated
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    private static final androidx.core.view.OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = null;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static final androidx.core.view.ViewCompat.AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static boolean sTempDetachBound;
    private static java.lang.ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static boolean sTryHiddenViewTransformMatrixToGlobal;
    private static WeakHashMap<View, androidx.core.view.ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    static abstract class AccessibilityViewProperty {

        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;
        AccessibilityViewProperty(int tagKey, Class<T> class2, int frameworkMinimumSdk) {
            super(tagKey, class2, 0, frameworkMinimumSdk);
        }

        AccessibilityViewProperty(int tagKey, Class<T> class2, int contentChangeType, int frameworkMinimumSdk) {
            super();
            this.mTagKey = tagKey;
            this.mType = class2;
            this.mContentChangeType = contentChangeType;
            this.mFrameworkMinimumSdk = frameworkMinimumSdk;
        }

        private boolean frameworkAvailable() {
            int i;
            i = Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk ? 1 : 0;
            return i;
        }

        boolean booleanNullToFalseEquals(Boolean a, Boolean b) {
            int i3;
            boolean booleanValue2;
            int i;
            boolean booleanValue;
            int i2;
            i3 = 1;
            final int i4 = 0;
            if (a != null && a.booleanValue()) {
                i = a.booleanValue() ? i3 : i4;
            } else {
            }
            if (b != null && b.booleanValue()) {
                i2 = b.booleanValue() ? i3 : i4;
            } else {
            }
            if (i == i2) {
            } else {
                i3 = i4;
            }
            return i3;
        }

        abstract T frameworkGet(View view);

        abstract void frameworkSet(View view, T t2);

        T get(View view) {
            if (frameworkAvailable()) {
                return frameworkGet(view);
            }
            Object tag = view.getTag(this.mTagKey);
            if (this.mType.isInstance(tag)) {
                return tag;
            }
            return 0;
        }

        void set(View view, T t2) {
            boolean frameworkAvailable;
            if (frameworkAvailable()) {
                frameworkSet(view, t2);
            } else {
                if (shouldUpdate(get(view), t2)) {
                    ViewCompat.ensureAccessibilityDelegateCompat(view);
                    view.setTag(this.mTagKey, t2);
                    ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
                }
            }
        }

        boolean shouldUpdate(T t, T t2) {
            return equals ^= 1;
        }
    }

    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        private final WeakHashMap<View, Boolean> mPanesToVisible;
        AccessibilityPaneVisibilityManager() {
            super();
            WeakHashMap weakHashMap = new WeakHashMap();
            this.mPanesToVisible = weakHashMap;
        }

        private void checkPaneVisibility(Map.Entry<View, Boolean> map$Entry) {
            boolean windowVisibility;
            int i2;
            int i;
            Boolean valueOf;
            final Object key = entry.getKey();
            if ((View)key.isShown() && key.getWindowVisibility() == 0) {
                i2 = key.getWindowVisibility() == 0 ? 1 : 0;
            } else {
            }
            if ((Boolean)entry.getValue().booleanValue() != i2) {
                i = i2 != 0 ? 16 : 32;
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(key, i);
                entry.setValue(Boolean.valueOf(i2));
            }
        }

        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        void addAccessibilityPane(View pane) {
            boolean windowVisibility;
            int i;
            if (pane.isShown() && pane.getWindowVisibility() == 0) {
                i = pane.getWindowVisibility() == 0 ? 1 : 0;
            } else {
            }
            this.mPanesToVisible.put(pane, Boolean.valueOf(i));
            pane.addOnAttachStateChangeListener(this);
            if (pane.isAttachedToWindow()) {
                registerForLayoutCallback(pane);
            }
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onViewAttachedToWindow(View view) {
            registerForLayoutCallback(view);
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        void removeAccessibilityPane(View pane) {
            this.mPanesToVisible.remove(pane);
            pane.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(pane);
        }
    }

    static class Api20Impl {
        static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets insets) {
            WindowInsets dispatchApplyWindowInsets;
            if (ViewGroupCompat.sCompatInsetsDispatchInstalled) {
                dispatchApplyWindowInsets = ViewGroupCompat.dispatchApplyWindowInsets(view, insets);
            } else {
                dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(insets);
            }
            return dispatchApplyWindowInsets;
        }

        static WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
            return view.onApplyWindowInsets(insets);
        }

        static void requestApplyInsets(View view) {
            view.requestApplyInsets();
        }
    }

    private static class Api21Impl {
        static void callCompatInsetAnimationCallback(WindowInsets insets, View v) {
            Object tag = v.getTag(R.id.tag_window_insets_animation_callback);
            if ((View.OnApplyWindowInsetsListener)tag != null) {
                (View.OnApplyWindowInsetsListener)tag.onApplyWindowInsets(v, insets);
            }
        }

        static androidx.core.view.WindowInsetsCompat computeSystemWindowInsets(View v, androidx.core.view.WindowInsetsCompat insets, Rect outLocalInsets) {
            final WindowInsets windowInsets = insets.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(v.computeSystemWindowInsets(windowInsets, outLocalInsets), v);
            }
            outLocalInsets.setEmpty();
            return insets;
        }

        static boolean dispatchNestedFling(View view, float velocityX, float velocityY, boolean consumed) {
            return view.dispatchNestedFling(velocityX, velocityY, consumed);
        }

        static boolean dispatchNestedPreFling(View view, float velocityX, float velocityY) {
            return view.dispatchNestedPreFling(velocityX, velocityY);
        }

        static boolean dispatchNestedPreScroll(View view, int dx, int dy, int[] consumed, int[] offsetInWindow) {
            return view.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
        }

        static boolean dispatchNestedScroll(View view, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
            return view.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
        }

        static ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        static float getElevation(View view) {
            return view.getElevation();
        }

        public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(View v) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(v);
        }

        static String getTransitionName(View view) {
            return view.getTransitionName();
        }

        static float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        static float getZ(View view) {
            return view.getZ();
        }

        static boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void setBackgroundTintList(View view, ColorStateList tint) {
            view.setBackgroundTintList(tint);
        }

        static void setBackgroundTintMode(View view, PorterDuff.Mode tintMode) {
            view.setBackgroundTintMode(tintMode);
        }

        static void setElevation(View view, float elevation) {
            view.setElevation(elevation);
        }

        static void setNestedScrollingEnabled(View view, boolean enabled) {
            view.setNestedScrollingEnabled(enabled);
        }

        static void setOnApplyWindowInsetsListener(View v, androidx.core.view.OnApplyWindowInsetsListener listener) {
            int anon;
            int tag_on_apply_window_listener;
            Object tag;
            if (listener != null) {
                anon = new ViewCompat.Api21Impl.1(v, listener);
            } else {
                anon = 0;
            }
            if (Build.VERSION.SDK_INT < 30) {
                v.setTag(R.id.tag_on_apply_window_listener, anon);
            }
            if (v.getTag(R.id.tag_compat_insets_dispatch) != null) {
            }
            if (anon != 0) {
                v.setOnApplyWindowInsetsListener(anon);
            } else {
                v.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)v.getTag(R.id.tag_window_insets_animation_callback));
            }
        }

        static void setTransitionName(View view, String transitionName) {
            view.setTransitionName(transitionName);
        }

        static void setTranslationZ(View view, float translationZ) {
            view.setTranslationZ(translationZ);
        }

        static void setZ(View view, float z) {
            view.setZ(z);
        }

        static boolean startNestedScroll(View view, int axes) {
            return view.startNestedScroll(axes);
        }

        static void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }
    }

    private static class Api23Impl {
        public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(View v) {
            final WindowInsets rootWindowInsets = v.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
            windowInsetsCompat.copyRootViewBounds(v.getRootView());
            return windowInsetsCompat;
        }

        static int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        static void setScrollIndicators(View view, int indicators) {
            view.setScrollIndicators(indicators);
        }

        static void setScrollIndicators(View view, int indicators, int mask) {
            view.setScrollIndicators(indicators, mask);
        }
    }

    static class Api24Impl {
        static void cancelDragAndDrop(View view) {
            view.cancelDragAndDrop();
        }

        static void dispatchFinishTemporaryDetach(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void dispatchStartTemporaryDetach(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void setPointerIcon(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean startDragAndDrop(View view, ClipData data, View.DragShadowBuilder shadowBuilder, Object myLocalState, int flags) {
            return view.startDragAndDrop(data, shadowBuilder, myLocalState, flags);
        }

        static void updateDragShadow(View view, View.DragShadowBuilder shadowBuilder) {
            view.updateDragShadow(shadowBuilder);
        }
    }

    static class Api26Impl {
        static void addKeyboardNavigationClusters(View view, Collection<View> collection2, int direction) {
            view.addKeyboardNavigationClusters(collection2, direction);
        }

        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }

        static int getImportantForAutofill(View view) {
            return view.getImportantForAutofill();
        }

        static int getNextClusterForwardId(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean hasExplicitFocusable(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean isFocusedByDefault(View view) {
            return view.isFocusedByDefault();
        }

        static boolean isImportantForAutofill(View view) {
            return view.isImportantForAutofill();
        }

        static boolean isKeyboardNavigationCluster(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View keyboardNavigationClusterSearch(View view, View currentCluster, int direction) {
            return view.keyboardNavigationClusterSearch(currentCluster, direction);
        }

        static boolean restoreDefaultFocus(View view) {
            return view.restoreDefaultFocus();
        }

        static void setAutofillHints(View view, String... autofillHints) {
            view.setAutofillHints(autofillHints);
        }

        static void setFocusedByDefault(View view, boolean isFocusedByDefault) {
            view.setFocusedByDefault(isFocusedByDefault);
        }

        static void setImportantForAutofill(View view, int mode) {
            view.setImportantForAutofill(mode);
        }

        static void setKeyboardNavigationCluster(View view, boolean isCluster) {
            view.setKeyboardNavigationCluster(isCluster);
        }

        static void setNextClusterForwardId(View view, int nextClusterForwardId) {
            view.setNextClusterForwardId(nextClusterForwardId);
        }

        static void setTooltipText(View view, java.lang.CharSequence tooltipText) {
            view.setTooltipText(tooltipText);
        }
    }

    static class Api28Impl {
        static void addOnUnhandledKeyEventListener(View v, androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat listener) {
            Object viewListeners;
            int tag_unhandled_key_listeners;
            if ((SimpleArrayMap)v.getTag(R.id.tag_unhandled_key_listeners) == null) {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                v.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(listener);
            ViewCompat.Api28Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewCompat.Api28Impl$$ExternalSyntheticLambda0(listener);
            viewListeners.put(listener, externalSyntheticLambda0);
            v.addOnUnhandledKeyEventListener(externalSyntheticLambda0);
        }

        static java.lang.CharSequence getAccessibilityPaneTitle(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean isAccessibilityHeading(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean isScreenReaderFocusable(View view) {
            return view.isScreenReaderFocusable();
        }

        static void removeOnUnhandledKeyEventListener(View v, androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat listener) {
            Object tag = v.getTag(R.id.tag_unhandled_key_listeners);
            if ((SimpleArrayMap)tag == null) {
            }
            final Object obj = (SimpleArrayMap)tag.get(listener);
            if ((View.OnUnhandledKeyEventListener)obj != null) {
                v.removeOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)obj);
            }
        }

        static <T> T requireViewById(View view, int id) {
            return view.requireViewById(id);
        }

        static void setAccessibilityHeading(View view, boolean isHeading) {
            view.setAccessibilityHeading(isHeading);
        }

        static void setAccessibilityPaneTitle(View view, java.lang.CharSequence accessibilityPaneTitle) {
            view.setAccessibilityPaneTitle(accessibilityPaneTitle);
        }

        public static void setAutofillId(View view, AutofillIdCompat id) {
            int autofillId;
            if (id == null) {
                autofillId = 0;
            } else {
                autofillId = id.toAutofillId();
            }
            view.setAutofillId(autofillId);
        }

        static void setScreenReaderFocusable(View view, boolean screenReaderFocusable) {
            view.setScreenReaderFocusable(screenReaderFocusable);
        }
    }

    private static class Api29Impl {
        static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> getSystemGestureExclusionRects(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void saveAttributeDataForStyleable(View view, Context context, int[] styleable, AttributeSet attrs, TypedArray t, int defStyleAttr, int defStyleRes) {
            view.saveAttributeDataForStyleable(context, styleable, attrs, t, defStyleAttr, defStyleRes);
        }

        static void setContentCaptureSession(View view, ContentCaptureSessionCompat contentCaptureSession) {
            int contentCaptureSession2;
            if (contentCaptureSession == null) {
                contentCaptureSession2 = 0;
            } else {
                contentCaptureSession2 = contentCaptureSession.toContentCaptureSession();
            }
            view.setContentCaptureSession(contentCaptureSession2);
        }

        static void setSystemGestureExclusionRects(View view, List<Rect> list2) {
            view.setSystemGestureExclusionRects(list2);
        }

        static void transformMatrixToGlobal(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }
    }

    private static class Api30Impl {
        static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets insets) {
            return view.dispatchApplyWindowInsets(insets);
        }

        static int getImportantForContentCapture(View view) {
            return view.getImportantForContentCapture();
        }

        static java.lang.CharSequence getStateDescription(View view) {
            return view.getStateDescription();
        }

        public static androidx.core.view.WindowInsetsControllerCompat getWindowInsetsController(View view) {
            androidx.core.view.WindowInsetsControllerCompat windowInsetsControllerCompat;
            final android.view.WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsControllerCompat = WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
            } else {
                windowInsetsControllerCompat = 0;
            }
            return windowInsetsControllerCompat;
        }

        static boolean isImportantForContentCapture(View view) {
            return view.isImportantForContentCapture();
        }

        static void setImportantForContentCapture(View view, int mode) {
            view.setImportantForContentCapture(mode);
        }

        static void setStateDescription(View view, java.lang.CharSequence stateDescription) {
            view.setStateDescription(stateDescription);
        }
    }

    private static final class Api31Impl {
        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static androidx.core.view.ContentInfoCompat performReceiveContent(View view, androidx.core.view.ContentInfoCompat payload) {
            final ContentInfo contentInfo = payload.toContentInfo();
            final ContentInfo receiveContent = view.performReceiveContent(contentInfo);
            if (receiveContent == null) {
                return null;
            }
            if (receiveContent == contentInfo) {
                return payload;
            }
            return ContentInfoCompat.toContentInfoCompat(receiveContent);
        }

        public static void setOnReceiveContentListener(View view, String[] mimeTypes, androidx.core.view.OnReceiveContentListener listener) {
            int onReceiveContentListenerAdapter;
            if (listener == null) {
                view.setOnReceiveContentListener(mimeTypes, 0);
            } else {
                onReceiveContentListenerAdapter = new ViewCompat.OnReceiveContentListenerAdapter(listener);
                view.setOnReceiveContentListener(mimeTypes, onReceiveContentListenerAdapter);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    private static final class OnReceiveContentListenerAdapter implements OnReceiveContentListener {

        private final androidx.core.view.OnReceiveContentListener mJetpackListener;
        OnReceiveContentListenerAdapter(androidx.core.view.OnReceiveContentListener jetpackListener) {
            super();
            this.mJetpackListener = jetpackListener;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo platPayload) {
            final androidx.core.view.ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(platPayload);
            androidx.core.view.ContentInfoCompat onReceiveContent = this.mJetpackListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            if (onReceiveContent == contentInfoCompat) {
                return platPayload;
            }
            return onReceiveContent.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        public abstract boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {

        private static final ArrayList<WeakReference<View>> sViewsWithListeners;
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        static {
            ArrayList arrayList = new ArrayList();
            ViewCompat.UnhandledKeyEventManager.sViewsWithListeners = arrayList;
        }

        UnhandledKeyEventManager() {
            super();
            final int i = 0;
        }

        static androidx.core.view.ViewCompat.UnhandledKeyEventManager at(View root) {
            Object manager;
            int tag_unhandled_key_event_manager;
            if ((ViewCompat.UnhandledKeyEventManager)root.getTag(R.id.tag_unhandled_key_event_manager) == null) {
                ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager = new ViewCompat.UnhandledKeyEventManager();
                root.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager);
            }
            return manager;
        }

        private View dispatchInOrder(View view, KeyEvent event) {
            boolean z;
            WeakHashMap mViewsContainingListeners;
            int i;
            View childAt;
            View dispatchInOrder;
            final int i2 = 0;
            if (this.mViewsContainingListeners != null) {
                if (!this.mViewsContainingListeners.containsKey(view)) {
                } else {
                    if (view instanceof ViewGroup) {
                        z = view;
                        childCount--;
                        while (i >= 0) {
                            dispatchInOrder = dispatchInOrder(z.getChildAt(i), event);
                            i--;
                        }
                    }
                    if (onUnhandledKeyEvent(view, event)) {
                        return view;
                    }
                }
                return i2;
            }
            return i2;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            SparseArray mCapturedKeys;
            if (this.mCapturedKeys == null) {
                mCapturedKeys = new SparseArray();
                this.mCapturedKeys = mCapturedKeys;
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(View v, KeyEvent event) {
            int i;
            int i2;
            boolean onUnhandledKeyEvent;
            Object tag = v.getTag(R.id.tag_unhandled_key_listeners);
            if ((ArrayList)tag != null) {
                i2 = 1;
                size -= i2;
                while (i >= 0) {
                    i--;
                }
            }
            return 0;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap mViewsContainingListeners2;
            WeakHashMap mViewsContainingListeners;
            int i;
            Object obj2;
            Object obj;
            ArrayList nxt;
            boolean z;
            Boolean tRUE2;
            ViewParent view;
            Boolean tRUE;
            if (this.mViewsContainingListeners != null) {
                this.mViewsContainingListeners.clear();
            }
            if (ViewCompat.UnhandledKeyEventManager.sViewsWithListeners.isEmpty()) {
            }
            ArrayList sViewsWithListeners2 = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
            synchronized (sViewsWithListeners2) {
                mViewsContainingListeners = new WeakHashMap();
                this.mViewsContainingListeners = mViewsContainingListeners;
                size--;
                while (i >= 0) {
                    obj = (WeakReference)ViewCompat.UnhandledKeyEventManager.sViewsWithListeners.get(i).get();
                    if ((View)obj == null) {
                    } else {
                    }
                    this.mViewsContainingListeners.put((View)obj, Boolean.TRUE);
                    nxt = obj.getParent();
                    while (nxt instanceof View != null) {
                        this.mViewsContainingListeners.put((View)nxt, Boolean.TRUE);
                        nxt = tRUE2;
                    }
                    i--;
                    this.mViewsContainingListeners.put((View)nxt, Boolean.TRUE);
                    nxt = tRUE2;
                    ViewCompat.UnhandledKeyEventManager.sViewsWithListeners.remove(i);
                }
            }
        }

        static void registerListeningView(View v) {
            Object next;
            Object obj;
            final ArrayList sViewsWithListeners = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
            Iterator iterator = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners.iterator();
            synchronized (sViewsWithListeners) {
                for (WeakReference next : iterator) {
                }
                WeakReference weakReference = new WeakReference(v);
                ViewCompat.UnhandledKeyEventManager.sViewsWithListeners.add(weakReference);
            }
        }

        static void unregisterListeningView(View v) {
            int i;
            Object obj;
            final ArrayList sViewsWithListeners = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
            i = 0;
            synchronized (sViewsWithListeners) {
                while (i < ViewCompat.UnhandledKeyEventManager.sViewsWithListeners.size()) {
                    i++;
                }
            }
        }

        boolean dispatch(View root, KeyEvent event) {
            int keyCode;
            int i;
            boolean capturedKeys;
            WeakReference weakReference;
            if (event.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            View dispatchInOrder = dispatchInOrder(root, event);
            keyCode = event.getKeyCode();
            if (event.getAction() == 0 && dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                keyCode = event.getKeyCode();
                if (dispatchInOrder != null) {
                    if (!KeyEvent.isModifierKey(keyCode)) {
                        weakReference = new WeakReference(dispatchInOrder);
                        getCapturedKeys().put(keyCode, weakReference);
                    }
                }
            }
            i = dispatchInOrder != null ? 1 : 0;
            return i;
        }

        boolean preDispatch(KeyEvent event) {
            Object mLastDispatchedPreViewKeyEvent;
            int currentReceiver;
            int attachedToWindow;
            Object valueAt;
            int i = 0;
            if (this.mLastDispatchedPreViewKeyEvent != null && this.mLastDispatchedPreViewKeyEvent.get() == event) {
                if (this.mLastDispatchedPreViewKeyEvent.get() == event) {
                    return i;
                }
            }
            WeakReference weakReference = new WeakReference(event);
            this.mLastDispatchedPreViewKeyEvent = weakReference;
            currentReceiver = 0;
            final SparseArray capturedKeys = getCapturedKeys();
            final int i2 = 1;
            attachedToWindow = capturedKeys.indexOfKey(event.getKeyCode());
            if (event.getAction() == i2 && attachedToWindow >= 0) {
                attachedToWindow = capturedKeys.indexOfKey(event.getKeyCode());
                if (attachedToWindow >= 0) {
                    currentReceiver = valueAt;
                    capturedKeys.removeAt(attachedToWindow);
                }
            }
            if (currentReceiver == 0) {
                currentReceiver = attachedToWindow;
            }
            Object obj = currentReceiver.get();
            if (currentReceiver != 0 && obj != null && (View)obj.isAttachedToWindow()) {
                obj = currentReceiver.get();
                if ((View)obj != null) {
                    if ((View)obj.isAttachedToWindow()) {
                        onUnhandledKeyEvent(obj, event);
                    }
                }
                return i2;
            }
            return i;
        }
    }
    static {
        ViewCompat.sViewPropertyAnimatorMap = 0;
        ViewCompat.sAccessibilityDelegateCheckFailed = false;
        ViewCompat.sTryHiddenViewTransformMatrixToGlobal = true;
        ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS = /* result */;
        ViewCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewCompat$$ExternalSyntheticLambda0();
        ViewCompat.NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = externalSyntheticLambda0;
        ViewCompat.AccessibilityPaneVisibilityManager accessibilityPaneVisibilityManager = new ViewCompat.AccessibilityPaneVisibilityManager();
        ViewCompat.sAccessibilityPaneVisibilityManager = accessibilityPaneVisibilityManager;
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        ViewCompat.4 anon = new ViewCompat.4(R.id.tag_accessibility_heading, Boolean.class, 28);
        return anon;
    }

    public static int addAccessibilityAction(View view, java.lang.CharSequence label, AccessibilityViewCommand command) {
        int accessibilityActionCompat;
        final int availableActionIdFromResources = ViewCompat.getAvailableActionIdFromResources(view, label);
        if (availableActionIdFromResources != -1) {
            accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, label, command);
            ViewCompat.addAccessibilityAction(view, accessibilityActionCompat);
        }
        return availableActionIdFromResources;
    }

    private static void addAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat action) {
        ViewCompat.ensureAccessibilityDelegateCompat(view);
        ViewCompat.removeActionWithId(action.getId(), view);
        ViewCompat.getActionList(view).add(action);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection2, int direction) {
        ViewCompat.Api26Impl.addKeyboardNavigationClusters(view, collection2, direction);
    }

    public static void addOnUnhandledKeyEventListener(View view, androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat listener) {
        ViewCompat.Api28Impl.addOnUnhandledKeyEventListener(view, listener);
    }

    public static void addOverlayView(ViewGroup overlayHost, View overlay) {
        overlayHost.getOverlay().add(overlay);
        ViewTree.setViewTreeDisjointParent((View)overlay.getParent(), overlayHost);
    }

    @Deprecated
    public static androidx.core.view.ViewPropertyAnimatorCompat animate(View view) {
        WeakHashMap sViewPropertyAnimatorMap2;
        Object vpa;
        WeakHashMap sViewPropertyAnimatorMap;
        if (ViewCompat.sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap2 = new WeakHashMap();
            ViewCompat.sViewPropertyAnimatorMap = sViewPropertyAnimatorMap2;
        }
        if ((ViewPropertyAnimatorCompat)ViewCompat.sViewPropertyAnimatorMap.get(view) == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(view);
            ViewCompat.sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat);
        }
        return vpa;
    }

    private static void bindTempDetach() {
        Method declaredMethod;
        String str;
        Class[] arr;
        try {
            int i = 0;
            ViewCompat.sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[i]);
            ViewCompat.sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[i]);
            Log.e("ViewCompat", "Couldn't find method", th);
            ViewCompat.sTempDetachBound = true;
        }
    }

    @ReplaceWith(expression = "view.canScrollHorizontally(direction)")
    @Deprecated
    public static boolean canScrollHorizontally(View view, int direction) {
        return view.canScrollHorizontally(direction);
    }

    @ReplaceWith(expression = "view.canScrollVertically(direction)")
    @Deprecated
    public static boolean canScrollVertically(View view, int direction) {
        return view.canScrollVertically(direction);
    }

    public static void cancelDragAndDrop(View v) {
        ViewCompat.Api24Impl.cancelDragAndDrop(v);
    }

    @Deprecated
    public static int combineMeasuredStates(int curState, int newState) {
        return View.combineMeasuredStates(curState, newState);
    }

    private static void compatOffsetLeftAndRight(View view, int offset) {
        int visibility;
        boolean z;
        view.offsetLeftAndRight(offset);
        ViewCompat.tickleInvalidationFlag(view);
        visibility = view.getParent();
        if (view.getVisibility() == 0 && visibility instanceof View != null) {
            ViewCompat.tickleInvalidationFlag(view);
            visibility = view.getParent();
            if (visibility instanceof View != null) {
                ViewCompat.tickleInvalidationFlag((View)visibility);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int offset) {
        int visibility;
        boolean z;
        view.offsetTopAndBottom(offset);
        ViewCompat.tickleInvalidationFlag(view);
        visibility = view.getParent();
        if (view.getVisibility() == 0 && visibility instanceof View != null) {
            ViewCompat.tickleInvalidationFlag(view);
            visibility = view.getParent();
            if (visibility instanceof View != null) {
                ViewCompat.tickleInvalidationFlag((View)visibility);
            }
        }
    }

    public static androidx.core.view.WindowInsetsCompat computeSystemWindowInsets(View view, androidx.core.view.WindowInsetsCompat insets, Rect outLocalInsets) {
        return ViewCompat.Api21Impl.computeSystemWindowInsets(view, insets, outLocalInsets);
    }

    public static androidx.core.view.WindowInsetsCompat dispatchApplyWindowInsets(View view, androidx.core.view.WindowInsetsCompat insets) {
        WindowInsets dispatchApplyWindowInsets;
        boolean equals;
        final WindowInsets windowInsets = insets.toWindowInsets();
        if (windowInsets != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                dispatchApplyWindowInsets = ViewCompat.Api30Impl.dispatchApplyWindowInsets(view, windowInsets);
            } else {
                dispatchApplyWindowInsets = ViewCompat.Api20Impl.dispatchApplyWindowInsets(view, windowInsets);
            }
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(dispatchApplyWindowInsets, view);
            }
        }
        return insets;
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        ViewCompat.Api24Impl.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(View view, float velocityX, float velocityY, boolean consumed) {
        return ViewCompat.Api21Impl.dispatchNestedFling(view, velocityX, velocityY, consumed);
    }

    public static boolean dispatchNestedPreFling(View view, float velocityX, float velocityY) {
        return ViewCompat.Api21Impl.dispatchNestedPreFling(view, velocityX, velocityY);
    }

    public static boolean dispatchNestedPreScroll(View view, int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return ViewCompat.Api21Impl.dispatchNestedPreScroll(view, dx, dy, consumed, offsetInWindow);
    }

    public static boolean dispatchNestedPreScroll(View view, int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        if (view instanceof NestedScrollingChild2) {
            return (NestedScrollingChild2)view.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
        }
        if (type == null) {
            return ViewCompat.dispatchNestedPreScroll(view, dx, dy, consumed, offsetInWindow);
        }
        return 0;
    }

    public static void dispatchNestedScroll(View view, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        Object obj;
        int i3;
        int i5;
        int i4;
        int i;
        int[] iArr2;
        int i2;
        int[] iArr;
        if (view instanceof NestedScrollingChild3) {
            (NestedScrollingChild3)view.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
        } else {
            ViewCompat.dispatchNestedScroll(view, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
        }
    }

    public static boolean dispatchNestedScroll(View view, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return ViewCompat.Api21Impl.dispatchNestedScroll(view, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public static boolean dispatchNestedScroll(View view, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        if (view instanceof NestedScrollingChild2) {
            int i2 = dxConsumed;
            int i4 = dyConsumed;
            int i6 = dxUnconsumed;
            int i8 = dyUnconsumed;
            final int[] iArr2 = offsetInWindow;
            int i = i2;
            int dxConsumed3 = i4;
            int dyConsumed2 = i6;
            int dxUnconsumed2 = i8;
            int[] dyUnconsumed2 = iArr2;
            return (NestedScrollingChild2)view.dispatchNestedScroll(i2, i4, i6, i8, iArr2, type);
        }
        if (type == null) {
            return ViewCompat.dispatchNestedScroll(view, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
        }
        Object view2 = view;
        return 0;
    }

    public static void dispatchStartTemporaryDetach(View view) {
        ViewCompat.Api24Impl.dispatchStartTemporaryDetach(view);
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View root, KeyEvent evt) {
        return 0;
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View root, KeyEvent evt) {
        return 0;
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        ViewCompat.ensureAccessibilityDelegateCompat(view);
    }

    static void ensureAccessibilityDelegateCompat(View v) {
        androidx.core.view.AccessibilityDelegateCompat delegateCompat;
        androidx.core.view.AccessibilityDelegateCompat accessibilityDelegateCompat;
        if (ViewCompat.getAccessibilityDelegate(v) == null) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            delegateCompat = accessibilityDelegateCompat;
        }
        ViewCompat.setAccessibilityDelegate(v, delegateCompat);
    }

    static void fallbackTransformMatrixToGlobal(View view, Matrix matrix) {
        boolean z;
        float f;
        float f2;
        final ViewParent parent = view.getParent();
        if (parent instanceof View != null) {
            z = parent;
            ViewCompat.fallbackTransformMatrixToGlobal((View)z, matrix);
            matrix.preTranslate((float)i, (float)i2);
        }
        matrix.preTranslate((float)left, (float)top);
        matrix.preConcat(view.getMatrix());
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    public static androidx.core.view.AccessibilityDelegateCompat getAccessibilityDelegate(View view) {
        final View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter != null) {
            return view2.mCompat;
        }
        AccessibilityDelegateCompat accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
        return accessibilityDelegateCompat;
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View v) {
        return ViewCompat.Api29Impl.getAccessibilityDelegate(v);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View v) {
        Field sAccessibilityDelegateField;
        String str;
        final int i = 0;
        if (ViewCompat.sAccessibilityDelegateCheckFailed) {
            return i;
        }
        if (ViewCompat.sAccessibilityDelegateField == null) {
            ViewCompat.sAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
            ViewCompat.sAccessibilityDelegateField.setAccessible(true);
        }
        Object obj2 = ViewCompat.sAccessibilityDelegateField.get(v);
        if (obj2 instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate)obj2;
        }
        return i;
    }

    @ReplaceWith(expression = "view.getAccessibilityLiveRegion()")
    @Deprecated
    public static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        final android.view.accessibility.AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            return accessibilityNodeProviderCompat;
        }
        return null;
    }

    public static java.lang.CharSequence getAccessibilityPaneTitle(View view) {
        return (CharSequence)ViewCompat.paneTitleProperty().get(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        Object actions;
        int tag_accessibility_actions;
        if ((ArrayList)view.getTag(R.id.tag_accessibility_actions) == null) {
            ArrayList arrayList = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList);
        }
        return actions;
    }

    @ReplaceWith(expression = "view.getAlpha()")
    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    public static AutofillIdCompat getAutofillId(View v) {
        return AutofillIdCompat.toAutofillIdCompat(ViewCompat.Api26Impl.getAutofillId(v));
    }

    private static int getAvailableActionIdFromResources(View view, java.lang.CharSequence label) {
        int result;
        int i2;
        int i;
        boolean equals;
        int size2;
        int length;
        int idAvailable;
        int j;
        int size;
        result = -1;
        final List actionList = ViewCompat.getActionList(view);
        i2 = 0;
        while (i2 < actionList.size()) {
            i2++;
        }
        i = 0;
        for (int size2 : obj3) {
            if (result == -1) {
            }
            idAvailable = 1;
            j = 0;
            while (j < actionList.size()) {
                if ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)actionList.get(j).getId() != size2) {
                } else {
                }
                size = 0;
                idAvailable &= size;
                j++;
                size = 1;
            }
            if (idAvailable != 0) {
            }
            result = size2;
            if ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)actionList.get(j).getId() != size2) {
            } else {
            }
            size = 0;
            idAvailable &= size;
            j++;
            size = 1;
        }
        return result;
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return ViewCompat.Api21Impl.getBackgroundTintList(view);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return ViewCompat.Api21Impl.getBackgroundTintMode(view);
    }

    @ReplaceWith(expression = "view.getClipBounds()")
    @Deprecated
    public static Rect getClipBounds(View view) {
        return view.getClipBounds();
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View v) {
        final ContentCaptureSession contentCaptureSession = ViewCompat.Api29Impl.getContentCaptureSession(v);
        if (contentCaptureSession == null) {
            return null;
        }
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(contentCaptureSession, v);
    }

    @ReplaceWith(expression = "view.getDisplay()")
    @Deprecated
    public static Display getDisplay(View view) {
        return view.getDisplay();
    }

    public static float getElevation(View view) {
        return ViewCompat.Api21Impl.getElevation(view);
    }

    private static Rect getEmptyTempRect() {
        java.lang.ThreadLocal sThreadLocalRect2;
        Object rect;
        java.lang.ThreadLocal sThreadLocalRect;
        if (ViewCompat.sThreadLocalRect == null) {
            sThreadLocalRect2 = new ThreadLocal();
            ViewCompat.sThreadLocalRect = sThreadLocalRect2;
        }
        if ((Rect)ViewCompat.sThreadLocalRect.get() == null) {
            Rect rect2 = new Rect();
            ViewCompat.sThreadLocalRect.set(rect2);
        }
        rect.setEmpty();
        return rect;
    }

    private static androidx.core.view.OnReceiveContentViewBehavior getFallback(View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior)view;
        }
        return ViewCompat.NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @ReplaceWith(expression = "view.getFitsSystemWindows()")
    @Deprecated
    public static boolean getFitsSystemWindows(View view) {
        return view.getFitsSystemWindows();
    }

    @ReplaceWith(expression = "view.getImportantForAccessibility()")
    @Deprecated
    public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    public static int getImportantForAutofill(View v) {
        return ViewCompat.Api26Impl.getImportantForAutofill(v);
    }

    public static int getImportantForContentCapture(View v) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ViewCompat.Api30Impl.getImportantForContentCapture(v);
        }
        return 0;
    }

    @ReplaceWith(expression = "view.getLabelFor()")
    @Deprecated
    public static int getLabelFor(View view) {
        return view.getLabelFor();
    }

    @ReplaceWith(expression = "view.getLayerType()")
    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @ReplaceWith(expression = "view.getLayoutDirection()")
    @Deprecated
    public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    @ReplaceWith(expression = "view.getMatrix()")
    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @ReplaceWith(expression = "view.getMeasuredHeightAndState()")
    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @ReplaceWith(expression = "view.getMeasuredState()")
    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @ReplaceWith(expression = "view.getMeasuredWidthAndState()")
    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @ReplaceWith(expression = "view.getMinimumHeight()")
    @Deprecated
    public static int getMinimumHeight(View view) {
        return view.getMinimumHeight();
    }

    @ReplaceWith(expression = "view.getMinimumWidth()")
    @Deprecated
    public static int getMinimumWidth(View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(View view) {
        return ViewCompat.Api26Impl.getNextClusterForwardId(view);
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return ViewCompat.Api31Impl.getReceiveContentMimeTypes(view);
        }
        return (String[])view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @ReplaceWith(expression = "view.getOverScrollMode()")
    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @ReplaceWith(expression = "view.getPaddingEnd()")
    @Deprecated
    public static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    @ReplaceWith(expression = "view.getPaddingStart()")
    @Deprecated
    public static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    @ReplaceWith(expression = "view.getParentForAccessibility()")
    @Deprecated
    public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

    @ReplaceWith(expression = "view.getPivotX()")
    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @ReplaceWith(expression = "view.getPivotY()")
    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(View view) {
        return ViewCompat.Api23Impl.getRootWindowInsets(view);
    }

    @ReplaceWith(expression = "view.getRotation()")
    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @ReplaceWith(expression = "view.getRotationX()")
    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @ReplaceWith(expression = "view.getRotationY()")
    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @ReplaceWith(expression = "view.getScaleX()")
    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @ReplaceWith(expression = "view.getScaleY()")
    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        return ViewCompat.Api23Impl.getScrollIndicators(view);
    }

    public static java.lang.CharSequence getStateDescription(View view) {
        return (CharSequence)ViewCompat.stateDescriptionProperty().get(view);
    }

    public static List<Rect> getSystemGestureExclusionRects(View view) {
        return ViewCompat.Api29Impl.getSystemGestureExclusionRects(view);
    }

    public static String getTransitionName(View view) {
        return ViewCompat.Api21Impl.getTransitionName(view);
    }

    @ReplaceWith(expression = "view.getTranslationX()")
    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @ReplaceWith(expression = "view.getTranslationY()")
    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        return ViewCompat.Api21Impl.getTranslationZ(view);
    }

    @Deprecated
    public static androidx.core.view.WindowInsetsControllerCompat getWindowInsetsController(View view) {
        Context context;
        int window;
        int insetsController;
        if (Build.VERSION.SDK_INT >= 30) {
            return ViewCompat.Api30Impl.getWindowInsetsController(view);
        }
        context = view.getContext();
        while (context instanceof ContextWrapper) {
            context = (ContextWrapper)context.getBaseContext();
        }
        return null;
    }

    @ReplaceWith(expression = "view.getWindowSystemUiVisibility()")
    @Deprecated
    public static int getWindowSystemUiVisibility(View view) {
        return view.getWindowSystemUiVisibility();
    }

    @ReplaceWith(expression = "view.getX()")
    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @ReplaceWith(expression = "view.getY()")
    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        return ViewCompat.Api21Impl.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        int i;
        i = ViewCompat.getAccessibilityDelegateInternal(view) != null ? 1 : 0;
        return i;
    }

    public static boolean hasExplicitFocusable(View view) {
        return ViewCompat.Api26Impl.hasExplicitFocusable(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return ViewCompat.Api21Impl.hasNestedScrollingParent(view);
    }

    public static boolean hasNestedScrollingParent(View view, int type) {
        Object obj;
        if (view instanceof NestedScrollingChild2) {
            (NestedScrollingChild2)view.hasNestedScrollingParent(type);
        } else {
            if (type == null) {
                return ViewCompat.hasNestedScrollingParent(view);
            }
        }
        return 0;
    }

    @ReplaceWith(expression = "view.hasOnClickListeners()")
    @Deprecated
    public static boolean hasOnClickListeners(View view) {
        return view.hasOnClickListeners();
    }

    @ReplaceWith(expression = "view.hasOverlappingRendering()")
    @Deprecated
    public static boolean hasOverlappingRendering(View view) {
        return view.hasOverlappingRendering();
    }

    @ReplaceWith(expression = "view.hasTransientState()")
    @Deprecated
    public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View view) {
        boolean booleanValue;
        int i;
        Object obj = ViewCompat.accessibilityHeadingProperty().get(view);
        if (obj != null && (Boolean)obj.booleanValue()) {
            i = obj.booleanValue() ? 1 : 0;
        } else {
        }
        return i;
    }

    @ReplaceWith(expression = "view.isAttachedToWindow()")
    @Deprecated
    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(View view) {
        return ViewCompat.Api26Impl.isFocusedByDefault(view);
    }

    public static boolean isImportantForAccessibility(View view) {
        return ViewCompat.Api21Impl.isImportantForAccessibility(view);
    }

    public static boolean isImportantForAutofill(View v) {
        return ViewCompat.Api26Impl.isImportantForAutofill(v);
    }

    public static boolean isImportantForContentCapture(View v) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ViewCompat.Api30Impl.isImportantForContentCapture(v);
        }
        return 0;
    }

    @ReplaceWith(expression = "view.isInLayout()")
    @Deprecated
    public static boolean isInLayout(View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        return ViewCompat.Api26Impl.isKeyboardNavigationCluster(view);
    }

    @ReplaceWith(expression = "view.isLaidOut()")
    @Deprecated
    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    @ReplaceWith(expression = "view.isLayoutDirectionResolved()")
    @Deprecated
    public static boolean isLayoutDirectionResolved(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return ViewCompat.Api21Impl.isNestedScrollingEnabled(view);
    }

    @ReplaceWith(expression = "view.isOpaque()")
    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    @ReplaceWith(expression = "view.isPaddingRelative()")
    @Deprecated
    public static boolean isPaddingRelative(View view) {
        return view.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View view) {
        boolean booleanValue;
        int i;
        Object obj = ViewCompat.screenReaderFocusableProperty().get(view);
        if (obj != null && (Boolean)obj.booleanValue()) {
            i = obj.booleanValue() ? 1 : 0;
        } else {
        }
        return i;
    }

    @ReplaceWith(expression = "view.jumpDrawablesToCurrentState()")
    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View currentCluster, int direction) {
        return ViewCompat.Api26Impl.keyboardNavigationClusterSearch(view, currentCluster, direction);
    }

    static androidx.core.view.ContentInfoCompat lambda$static$0(androidx.core.view.ContentInfoCompat payload) {
        return payload;
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int changeType) {
        java.lang.CharSequence accessibilityPaneTitle;
        int i;
        Object obtain;
        int text;
        Object accessibilityPaneTitle2;
        ViewParent str;
        Object systemService = view.getContext().getSystemService("accessibility");
        if (!(AccessibilityManager)systemService.isEnabled()) {
        }
        if (ViewCompat.getAccessibilityPaneTitle(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            if (view.isShown()) {
                i = view.getWindowVisibility() == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        text = 32;
        if (view.getAccessibilityLiveRegion() == 0) {
            if (i != 0) {
                obtain = AccessibilityEvent.obtain();
                if (i != 0) {
                } else {
                    text = 2048;
                }
                obtain.setEventType(text);
                obtain.setContentChangeTypes(changeType);
                if (i != 0) {
                    obtain.getText().add(ViewCompat.getAccessibilityPaneTitle(view));
                    ViewCompat.setImportantForAccessibilityIfNeeded(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else {
                if (changeType == text) {
                    obtain = AccessibilityEvent.obtain();
                    view.onInitializeAccessibilityEvent(obtain);
                    obtain.setEventType(text);
                    obtain.setContentChangeTypes(changeType);
                    obtain.setSource(view);
                    view.onPopulateAccessibilityEvent(obtain);
                    obtain.getText().add(ViewCompat.getAccessibilityPaneTitle(view));
                    systemService.sendAccessibilityEvent(obtain);
                } else {
                    if (view.getParent() != null) {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, changeType);
                    } else {
                    }
                }
            }
        } else {
        }
    }

    public static void offsetLeftAndRight(View view, int offset) {
        view.offsetLeftAndRight(offset);
    }

    public static void offsetTopAndBottom(View view, int offset) {
        view.offsetTopAndBottom(offset);
    }

    public static androidx.core.view.WindowInsetsCompat onApplyWindowInsets(View view, androidx.core.view.WindowInsetsCompat insets) {
        WindowInsets onApplyWindowInsets;
        boolean equals;
        final WindowInsets windowInsets = insets.toWindowInsets();
        onApplyWindowInsets = ViewCompat.Api20Impl.onApplyWindowInsets(view, windowInsets);
        if (windowInsets != null && !onApplyWindowInsets.equals(windowInsets)) {
            onApplyWindowInsets = ViewCompat.Api20Impl.onApplyWindowInsets(view, windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets, view);
            }
        }
        return insets;
    }

    @ReplaceWith(expression = "v.onInitializeAccessibilityEvent(event)")
    @Deprecated
    public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        v.onInitializeAccessibilityEvent(event);
    }

    @ReplaceWith(expression = "v.onInitializeAccessibilityNodeInfo(info.unwrap())")
    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        v.onInitializeAccessibilityNodeInfo(info.unwrap());
    }

    @ReplaceWith(expression = "v.onPopulateAccessibilityEvent(event)")
    @Deprecated
    public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        v.onPopulateAccessibilityEvent(event);
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.CharSequence> paneTitleProperty() {
        ViewCompat.2 anon = new ViewCompat.2(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
        return anon;
    }

    @ReplaceWith(expression = "view.performAccessibilityAction(action, arguments)")
    @Deprecated
    public static boolean performAccessibilityAction(View view, int action, Bundle arguments) {
        return view.performAccessibilityAction(action, arguments);
    }

    public static boolean performHapticFeedback(View view, int feedbackConstant) {
        final int obj2 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(feedbackConstant);
        if (obj2 == -1) {
            return 0;
        }
        return view.performHapticFeedback(obj2);
    }

    public static boolean performHapticFeedback(View view, int feedbackConstant, int flags) {
        final int obj2 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(feedbackConstant);
        if (obj2 == -1) {
            return 0;
        }
        return view.performHapticFeedback(obj2, flags);
    }

    public static androidx.core.view.ContentInfoCompat performReceiveContent(View view, androidx.core.view.ContentInfoCompat payload) {
        boolean loggable;
        String str;
        androidx.core.view.ContentInfoCompat onReceiveContent;
        String str2 = "ViewCompat";
        if (Log.isLoggable(str2, 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.d(str2, stringBuilder.append("performReceiveContent: ").append(payload).append(", view=").append(view.getClass().getSimpleName()).append("[").append(view.getId()).append("]").toString());
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return ViewCompat.Api31Impl.performReceiveContent(view, payload);
        }
        Object tag = view.getTag(R.id.tag_on_receive_content_listener);
        if ((OnReceiveContentListener)tag != null) {
            androidx.core.view.ContentInfoCompat onReceiveContent3 = (OnReceiveContentListener)tag.onReceiveContent(view, payload);
            if (onReceiveContent3 == null) {
                onReceiveContent = 0;
            } else {
                onReceiveContent = ViewCompat.getFallback(view).onReceiveContent(onReceiveContent3);
            }
            return onReceiveContent;
        }
        return ViewCompat.getFallback(view).onReceiveContent(payload);
    }

    @ReplaceWith(expression = "view.postInvalidateOnAnimation()")
    @Deprecated
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    @ReplaceWith(expression = "view.postInvalidateOnAnimation(left, top, right, bottom)")
    @Deprecated
    public static void postInvalidateOnAnimation(View view, int left, int top, int right, int bottom) {
        view.postInvalidateOnAnimation(left, top, right, bottom);
    }

    @ReplaceWith(expression = "view.postOnAnimation(action)")
    @Deprecated
    public static void postOnAnimation(View view, Runnable action) {
        view.postOnAnimation(action);
    }

    @ReplaceWith(expression = "view.postOnAnimationDelayed(action, delayMillis)")
    @Deprecated
    public static void postOnAnimationDelayed(View view, Runnable action, long delayMillis) {
        view.postOnAnimationDelayed(action, delayMillis);
    }

    public static void removeAccessibilityAction(View view, int actionId) {
        ViewCompat.removeActionWithId(actionId, view);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int actionId, View view) {
        int i;
        int size;
        final List actionList = ViewCompat.getActionList(view);
        i = 0;
        while (i < actionList.size()) {
            if ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)actionList.get(i).getId() == actionId) {
                break;
            } else {
            }
            i++;
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat listener) {
        ViewCompat.Api28Impl.removeOnUnhandledKeyEventListener(view, listener);
    }

    public static void replaceAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat replacedAction, java.lang.CharSequence label, AccessibilityViewCommand command) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat replacementAction;
        if (command == null && label == null) {
            if (label == null) {
                ViewCompat.removeAccessibilityAction(view, replacedAction.getId());
            } else {
                ViewCompat.addAccessibilityAction(view, replacedAction.createReplacementAction(label, command));
            }
        } else {
        }
    }

    public static void requestApplyInsets(View view) {
        ViewCompat.Api20Impl.requestApplyInsets(view);
    }

    public static <T extends View> T requireViewById(View view, int id) {
        return (View)ViewCompat.Api28Impl.requireViewById(view, id);
    }

    @Deprecated
    public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        return View.resolveSizeAndState(size, measureSpec, childMeasuredState);
    }

    public static boolean restoreDefaultFocus(View view) {
        return ViewCompat.Api26Impl.restoreDefaultFocus(view);
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] styleable, AttributeSet attrs, TypedArray t, int defStyleAttr, int defStyleRes) {
        ViewCompat.Api29Impl.saveAttributeDataForStyleable(view, context, styleable, attrs, t, defStyleAttr, defStyleRes);
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        ViewCompat.1 anon = new ViewCompat.1(R.id.tag_screen_reader_focusable, Boolean.class, 28);
        return anon;
    }

    public static void setAccessibilityDelegate(View v, androidx.core.view.AccessibilityDelegateCompat delegate) {
        boolean accessibilityDelegateCompat;
        View.AccessibilityDelegate bridge;
        androidx.core.view.AccessibilityDelegateCompat obj2;
        if (delegate == null && accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter != null) {
            if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter != null) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
                obj2 = accessibilityDelegateCompat;
            }
        }
        ViewCompat.setImportantForAccessibilityIfNeeded(v);
        if (obj2 == null) {
            bridge = 0;
        } else {
            bridge = obj2.getBridge();
        }
        v.setAccessibilityDelegate(bridge);
    }

    public static void setAccessibilityHeading(View view, boolean isHeading) {
        ViewCompat.accessibilityHeadingProperty().set(view, Boolean.valueOf(isHeading));
    }

    @ReplaceWith(expression = "view.setAccessibilityLiveRegion(mode)")
    @Deprecated
    public static void setAccessibilityLiveRegion(View view, int mode) {
        view.setAccessibilityLiveRegion(mode);
    }

    public static void setAccessibilityPaneTitle(View view, java.lang.CharSequence accessibilityPaneTitle) {
        androidx.core.view.ViewCompat.AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
        ViewCompat.paneTitleProperty().set(view, accessibilityPaneTitle);
        if (accessibilityPaneTitle != null) {
            ViewCompat.sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            ViewCompat.sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @ReplaceWith(expression = "view.setActivated(activated)")
    @Deprecated
    public static void setActivated(View view, boolean activated) {
        view.setActivated(activated);
    }

    @ReplaceWith(expression = "view.setAlpha(value)")
    @Deprecated
    public static void setAlpha(View view, float value) {
        view.setAlpha(value);
    }

    public static void setAutofillHints(View view, String... autofillHints) {
        ViewCompat.Api26Impl.setAutofillHints(view, autofillHints);
    }

    public static void setAutofillId(View v, AutofillIdCompat id) {
        ViewCompat.Api28Impl.setAutofillId(v, id);
    }

    @ReplaceWith(expression = "view.setBackground(background)")
    @Deprecated
    public static void setBackground(View view, Drawable background) {
        view.setBackground(background);
    }

    public static void setBackgroundTintList(View view, ColorStateList tintList) {
        ViewCompat.Api21Impl.setBackgroundTintList(view, tintList);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        ViewCompat.Api21Impl.setBackgroundTintMode(view, mode);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean enabled) {
        Method sChildrenDrawingOrderMethod;
        Method sChildrenDrawingOrderMethod2;
        Method declaredMethod;
        Object e;
        String str;
        Class[] arr;
        Class tYPE;
        int i;
        final String str2 = "Unable to invoke childrenDrawingOrderEnabled";
        final String str3 = "ViewCompat";
        if (ViewCompat.sChildrenDrawingOrderMethod == null) {
            sChildrenDrawingOrderMethod = 1;
            arr = new Class[sChildrenDrawingOrderMethod];
            arr[0] = Boolean.TYPE;
            ViewCompat.sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arr);
            ViewCompat.sChildrenDrawingOrderMethod.setAccessible(sChildrenDrawingOrderMethod);
        }
        ViewCompat.sChildrenDrawingOrderMethod.invoke(viewGroup, /* result */);
        try {
        } catch (java.lang.IllegalAccessException illegalAccess) {
        } catch (java.lang.IllegalArgumentException iae1) {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget2) {
        }
    }

    @ReplaceWith(expression = "view.setClipBounds(clipBounds)")
    @Deprecated
    public static void setClipBounds(View view, Rect clipBounds) {
        view.setClipBounds(clipBounds);
    }

    public static void setContentCaptureSession(View v, ContentCaptureSessionCompat contentCaptureSession) {
        ViewCompat.Api29Impl.setContentCaptureSession(v, contentCaptureSession);
    }

    public static void setElevation(View view, float elevation) {
        ViewCompat.Api21Impl.setElevation(view, elevation);
    }

    @ReplaceWith(expression = "view.setFitsSystemWindows(fitSystemWindows)")
    @Deprecated
    public static void setFitsSystemWindows(View view, boolean fitSystemWindows) {
        view.setFitsSystemWindows(fitSystemWindows);
    }

    public static void setFocusedByDefault(View view, boolean isFocusedByDefault) {
        ViewCompat.Api26Impl.setFocusedByDefault(view, isFocusedByDefault);
    }

    @ReplaceWith(expression = "view.setHasTransientState(hasTransientState)")
    @Deprecated
    public static void setHasTransientState(View view, boolean hasTransientState) {
        view.setHasTransientState(hasTransientState);
    }

    @ReplaceWith(expression = "view.setImportantForAccessibility(mode)")
    @Deprecated
    public static void setImportantForAccessibility(View view, int mode) {
        view.setImportantForAccessibility(mode);
    }

    private static void setImportantForAccessibilityIfNeeded(View view) {
        int importantForAccessibility;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void setImportantForAutofill(View v, int mode) {
        ViewCompat.Api26Impl.setImportantForAutofill(v, mode);
    }

    public static void setImportantForContentCapture(View v, int mode) {
        if (Build.VERSION.SDK_INT >= 30) {
            ViewCompat.Api30Impl.setImportantForContentCapture(v, mode);
        }
    }

    public static void setKeyboardNavigationCluster(View view, boolean isCluster) {
        ViewCompat.Api26Impl.setKeyboardNavigationCluster(view, isCluster);
    }

    @ReplaceWith(expression = "view.setLabelFor(labeledId)")
    @Deprecated
    public static void setLabelFor(View view, int labeledId) {
        view.setLabelFor(labeledId);
    }

    @ReplaceWith(expression = "view.setLayerPaint(paint)")
    @Deprecated
    public static void setLayerPaint(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @ReplaceWith(expression = "view.setLayerType(layerType, paint)")
    @Deprecated
    public static void setLayerType(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    @ReplaceWith(expression = "view.setLayoutDirection(layoutDirection)")
    @Deprecated
    public static void setLayoutDirection(View view, int layoutDirection) {
        view.setLayoutDirection(layoutDirection);
    }

    public static void setNestedScrollingEnabled(View view, boolean enabled) {
        ViewCompat.Api21Impl.setNestedScrollingEnabled(view, enabled);
    }

    public static void setNextClusterForwardId(View view, int nextClusterForwardId) {
        ViewCompat.Api26Impl.setNextClusterForwardId(view, nextClusterForwardId);
    }

    public static void setOnApplyWindowInsetsListener(View view, androidx.core.view.OnApplyWindowInsetsListener listener) {
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, listener);
    }

    public static void setOnReceiveContentListener(View view, String[] mimeTypes, androidx.core.view.OnReceiveContentListener listener) {
        int sDK_INT;
        String[] strArr;
        int hasLeadingWildcard;
        String string2;
        String string;
        boolean startsWith;
        int obj6;
        if (Build.VERSION.SDK_INT >= 31) {
            ViewCompat.Api31Impl.setOnReceiveContentListener(view, mimeTypes, listener);
        }
        if (mimeTypes != null) {
            if (mimeTypes.length == 0) {
                strArr = 0;
            } else {
                strArr = mimeTypes;
            }
        } else {
        }
        if (listener != null) {
            hasLeadingWildcard = strArr != null ? 1 : obj6;
            Preconditions.checkArgument(hasLeadingWildcard, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            hasLeadingWildcard = 0;
            while (obj6 < strArr.length) {
                if (strArr[obj6].startsWith("*")) {
                    break;
                } else {
                }
                obj6++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            Preconditions.checkArgument(hasLeadingWildcard ^ 1, stringBuilder.append("A MIME type set here must not start with *: ").append(Arrays.toString(strArr)).toString());
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, listener);
    }

    @ReplaceWith(expression = "view.setOverScrollMode(overScrollMode)")
    @Deprecated
    public static void setOverScrollMode(View view, int overScrollMode) {
        view.setOverScrollMode(overScrollMode);
    }

    @ReplaceWith(expression = "view.setPaddingRelative(start, top, end, bottom)")
    @Deprecated
    public static void setPaddingRelative(View view, int start, int top, int end, int bottom) {
        view.setPaddingRelative(start, top, end, bottom);
    }

    @ReplaceWith(expression = "view.setPivotX(value)")
    @Deprecated
    public static void setPivotX(View view, float value) {
        view.setPivotX(value);
    }

    @ReplaceWith(expression = "view.setPivotY(value)")
    @Deprecated
    public static void setPivotY(View view, float value) {
        view.setPivotY(value);
    }

    public static void setPointerIcon(View view, androidx.core.view.PointerIconCompat pointerIcon) {
        Object pointerIcon2;
        if (pointerIcon != null) {
            pointerIcon2 = pointerIcon.getPointerIcon();
        } else {
            pointerIcon2 = 0;
        }
        ViewCompat.Api24Impl.setPointerIcon(view, (PointerIcon)pointerIcon2);
    }

    @ReplaceWith(expression = "view.setRotation(value)")
    @Deprecated
    public static void setRotation(View view, float value) {
        view.setRotation(value);
    }

    @ReplaceWith(expression = "view.setRotationX(value)")
    @Deprecated
    public static void setRotationX(View view, float value) {
        view.setRotationX(value);
    }

    @ReplaceWith(expression = "view.setRotationY(value)")
    @Deprecated
    public static void setRotationY(View view, float value) {
        view.setRotationY(value);
    }

    @ReplaceWith(expression = "view.setSaveFromParentEnabled(enabled)")
    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean enabled) {
        view.setSaveFromParentEnabled(enabled);
    }

    @ReplaceWith(expression = "view.setScaleX(value)")
    @Deprecated
    public static void setScaleX(View view, float value) {
        view.setScaleX(value);
    }

    @ReplaceWith(expression = "view.setScaleY(value)")
    @Deprecated
    public static void setScaleY(View view, float value) {
        view.setScaleY(value);
    }

    public static void setScreenReaderFocusable(View view, boolean screenReaderFocusable) {
        ViewCompat.screenReaderFocusableProperty().set(view, Boolean.valueOf(screenReaderFocusable));
    }

    public static void setScrollIndicators(View view, int indicators) {
        ViewCompat.Api23Impl.setScrollIndicators(view, indicators);
    }

    public static void setScrollIndicators(View view, int indicators, int mask) {
        ViewCompat.Api23Impl.setScrollIndicators(view, indicators, mask);
    }

    public static void setStateDescription(View view, java.lang.CharSequence stateDescription) {
        ViewCompat.stateDescriptionProperty().set(view, stateDescription);
    }

    public static void setSystemGestureExclusionRects(View view, List<Rect> list2) {
        ViewCompat.Api29Impl.setSystemGestureExclusionRects(view, list2);
    }

    public static void setTooltipText(View view, java.lang.CharSequence tooltipText) {
        ViewCompat.Api26Impl.setTooltipText(view, tooltipText);
    }

    public static void setTransitionName(View view, String transitionName) {
        ViewCompat.Api21Impl.setTransitionName(view, transitionName);
    }

    @ReplaceWith(expression = "view.setTranslationX(value)")
    @Deprecated
    public static void setTranslationX(View view, float value) {
        view.setTranslationX(value);
    }

    @ReplaceWith(expression = "view.setTranslationY(value)")
    @Deprecated
    public static void setTranslationY(View view, float value) {
        view.setTranslationY(value);
    }

    public static void setTranslationZ(View view, float translationZ) {
        ViewCompat.Api21Impl.setTranslationZ(view, translationZ);
    }

    public static void setWindowInsetsAnimationCallback(View view, androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback(view, callback);
    }

    @ReplaceWith(expression = "view.setX(value)")
    @Deprecated
    public static void setX(View view, float value) {
        view.setX(value);
    }

    @ReplaceWith(expression = "view.setY(value)")
    @Deprecated
    public static void setY(View view, float value) {
        view.setY(value);
    }

    public static void setZ(View view, float z) {
        ViewCompat.Api21Impl.setZ(view, z);
    }

    public static boolean startDragAndDrop(View v, ClipData data, View.DragShadowBuilder shadowBuilder, Object myLocalState, int flags) {
        return ViewCompat.Api24Impl.startDragAndDrop(v, data, shadowBuilder, myLocalState, flags);
    }

    public static boolean startNestedScroll(View view, int axes) {
        return ViewCompat.Api21Impl.startNestedScroll(view, axes);
    }

    public static boolean startNestedScroll(View view, int axes, int type) {
        if (view instanceof NestedScrollingChild2) {
            return (NestedScrollingChild2)view.startNestedScroll(axes, type);
        }
        if (type == null) {
            return ViewCompat.startNestedScroll(view, axes);
        }
        return 0;
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.CharSequence> stateDescriptionProperty() {
        ViewCompat.3 anon = new ViewCompat.3(R.id.tag_state_description, CharSequence.class, 64, 30);
        return anon;
    }

    public static void stopNestedScroll(View view) {
        ViewCompat.Api21Impl.stopNestedScroll(view);
    }

    public static void stopNestedScroll(View view, int type) {
        Object obj;
        if (view instanceof NestedScrollingChild2) {
            (NestedScrollingChild2)view.stopNestedScroll(type);
        } else {
            if (type == null) {
                ViewCompat.stopNestedScroll(view);
            }
        }
    }

    private static void tickleInvalidationFlag(View view) {
        final float translationY = view.getTranslationY();
        view.setTranslationY(i += translationY);
        view.setTranslationY(translationY);
    }

    public static void transformMatrixToGlobal(View view, Matrix matrix) {
        ViewCompat.Api29Impl.transformMatrixToGlobal(view, matrix);
    }

    public static void updateDragShadow(View v, View.DragShadowBuilder shadowBuilder) {
        ViewCompat.Api24Impl.updateDragShadow(v, shadowBuilder);
    }
}
