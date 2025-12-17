package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets.Type;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes5.dex */
public class WindowInsetsCompat {

    public static final androidx.core.view.WindowInsetsCompat CONSUMED = null;
    private static final String TAG = "WindowInsetsCompat";
    private final androidx.core.view.WindowInsetsCompat.Impl mImpl;

    static class Api21ReflectionHolder {

        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;
        static {
            Class forName;
            int i;
            Field sContentInsets;
            try {
                WindowInsetsCompat.Api21ReflectionHolder.sViewAttachInfoField = View.class.getDeclaredField("mAttachInfo");
                i = 1;
                WindowInsetsCompat.Api21ReflectionHolder.sViewAttachInfoField.setAccessible(i);
                forName = Class.forName("android.view.View$AttachInfo");
                WindowInsetsCompat.Api21ReflectionHolder.sStableInsets = forName.getDeclaredField("mStableInsets");
                WindowInsetsCompat.Api21ReflectionHolder.sStableInsets.setAccessible(i);
                WindowInsetsCompat.Api21ReflectionHolder.sContentInsets = forName.getDeclaredField("mContentInsets");
                WindowInsetsCompat.Api21ReflectionHolder.sContentInsets.setAccessible(i);
                WindowInsetsCompat.Api21ReflectionHolder.sReflectionSucceeded = i;
                StringBuilder string = new StringBuilder();
                String str3 = "Failed to get visible insets from AttachInfo ";
                string = string.append(str3);
                str3 = th.getMessage();
                string = string.append(str3);
                string = string.toString();
                str3 = "WindowInsetsCompat";
                Log.w(str3, string, th);
            }
        }

        public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(View v) {
            boolean sReflectionSucceeded;
            Object obj;
            Object string;
            Object str;
            final int i = 0;
            if (WindowInsetsCompat.Api21ReflectionHolder.sReflectionSucceeded) {
                if (!v.isAttachedToWindow()) {
                } else {
                    obj = WindowInsetsCompat.Api21ReflectionHolder.sViewAttachInfoField.get(v.getRootView());
                    string = WindowInsetsCompat.Api21ReflectionHolder.sStableInsets.get(obj);
                    str = WindowInsetsCompat.Api21ReflectionHolder.sContentInsets.get(obj);
                    if (obj != null && (Rect)string != null && (Rect)str != null) {
                        string = WindowInsetsCompat.Api21ReflectionHolder.sStableInsets.get(obj);
                        str = WindowInsetsCompat.Api21ReflectionHolder.sContentInsets.get(obj);
                        if ((Rect)(Rect)string != null) {
                            if ((Rect)(Rect)str != null) {
                                WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder();
                                androidx.core.view.WindowInsetsCompat build = builder.setStableInsets(Insets.of((Rect)(Rect)string)).setSystemWindowInsets(Insets.of((Rect)(Rect)str)).build();
                                build.setRootWindowInsets(build);
                                build.copyRootViewBounds(v.getRootView());
                                return build;
                            }
                        }
                    }
                }
                return i;
            }
            return i;
        }
    }

    public static final class Builder {

        private final androidx.core.view.WindowInsetsCompat.BuilderImpl mImpl;
        public Builder() {
            androidx.core.view.WindowInsetsCompat.BuilderImpl29 builder;
            int i;
            super();
            if (Build.VERSION.SDK_INT >= 34) {
                builder = new WindowInsetsCompat.BuilderImpl34();
                this.mImpl = builder;
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    builder = new WindowInsetsCompat.BuilderImpl30();
                    this.mImpl = builder;
                } else {
                    builder = new WindowInsetsCompat.BuilderImpl29();
                    this.mImpl = builder;
                }
            }
        }

        public Builder(androidx.core.view.WindowInsetsCompat insets) {
            androidx.core.view.WindowInsetsCompat.BuilderImpl29 builder;
            int i;
            super();
            if (Build.VERSION.SDK_INT >= 34) {
                builder = new WindowInsetsCompat.BuilderImpl34(insets);
                this.mImpl = builder;
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    builder = new WindowInsetsCompat.BuilderImpl30(insets);
                    this.mImpl = builder;
                } else {
                    builder = new WindowInsetsCompat.BuilderImpl29(insets);
                    this.mImpl = builder;
                }
            }
        }

        public androidx.core.view.WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        public androidx.core.view.WindowInsetsCompat.Builder setDisplayCutout(androidx.core.view.DisplayCutoutCompat displayCutout) {
            this.mImpl.setDisplayCutout(displayCutout);
            return this;
        }

        public androidx.core.view.WindowInsetsCompat.Builder setInsets(int typeMask, Insets insets) {
            this.mImpl.setInsets(typeMask, insets);
            return this;
        }

        public androidx.core.view.WindowInsetsCompat.Builder setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(typeMask, insets);
            return this;
        }

        @Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setMandatorySystemGestureInsets(Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setStableInsets(Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setSystemGestureInsets(Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setSystemWindowInsets(Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setTappableElementInsets(Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        public androidx.core.view.WindowInsetsCompat.Builder setVisible(int typeMask, boolean visible) {
            this.mImpl.setVisible(typeMask, visible);
            return this;
        }
    }

    private static class BuilderImpl {

        private final androidx.core.view.WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;
        BuilderImpl() {
            final int i = 0;
            final int i2 = i;
            WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(i);
            super(windowInsetsCompat);
        }

        BuilderImpl(androidx.core.view.WindowInsetsCompat insets) {
            super();
            this.mInsets = insets;
        }

        protected final void applyInsetTypes() {
            Insets[] statusBars;
            Insets i;
            Insets navigationBars;
            Insets[] mInsetsTypeMask;
            int mInsets;
            int indexOf2;
            int indexOf;
            int i2 = 1;
            mInsets = 2;
            if (this.mInsetsTypeMask != null && this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(mInsets)] == null) {
                i2 = 1;
                mInsets = 2;
                if (this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(mInsets)] == null) {
                    navigationBars = this.mInsets.getInsets(mInsets);
                }
                if (this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(i2)] == null) {
                    statusBars = this.mInsets.getInsets(i2);
                }
                setSystemWindowInsets(Insets.max(statusBars, navigationBars));
                Insets insets2 = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(16)];
                if (insets2 != null) {
                    setSystemGestureInsets(insets2);
                }
                Insets i3 = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(32)];
                if (i3 != null) {
                    setMandatorySystemGestureInsets(i3);
                }
                i = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(64)];
                if (i != null) {
                    setTappableElementInsets(i);
                }
            }
        }

        androidx.core.view.WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        void setDisplayCutout(androidx.core.view.DisplayCutoutCompat displayCutout) {
        }

        void setInsets(int typeMask, Insets insets) {
            Insets[] mInsetsTypeMask2;
            int i;
            Insets[] mInsetsTypeMask;
            int indexOf;
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[10];
            }
            i = 1;
            while (i <= 512) {
                if (typeMask & i == 0) {
                } else {
                }
                this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf(i)] = insets;
                i <<= 1;
            }
        }

        void setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            if (typeMask == 8) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Ignoring visibility inset not available for IME");
            throw illegalArgumentException;
        }

        void setMandatorySystemGestureInsets(Insets insets) {
        }

        void setStableInsets(Insets insets) {
        }

        void setSystemGestureInsets(Insets insets) {
        }

        void setSystemWindowInsets(Insets insets) {
        }

        void setTappableElementInsets(Insets insets) {
        }

        void setVisible(int typeMask, boolean visible) {
        }
    }

    private static class BuilderImpl20 extends androidx.core.view.WindowInsetsCompat.BuilderImpl {

        private static Constructor<WindowInsets> sConstructor;
        private static boolean sConstructorFetched;
        private static Field sConsumedField;
        private static boolean sConsumedFieldFetched;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;
        static {
            final int i = 0;
            WindowInsetsCompat.BuilderImpl20.sConsumedFieldFetched = i;
            WindowInsetsCompat.BuilderImpl20.sConstructorFetched = i;
        }

        BuilderImpl20() {
            super();
            this.mPlatformInsets = WindowInsetsCompat.BuilderImpl20.createWindowInsetsInstance();
        }

        BuilderImpl20(androidx.core.view.WindowInsetsCompat insets) {
            super(insets);
            this.mPlatformInsets = insets.toWindowInsets();
        }

        private static WindowInsets createWindowInsetsInstance() {
            Field sConsumedFieldFetched;
            Object sConsumedField;
            Constructor e;
            Constructor sConstructor;
            int i2;
            String str2;
            String str;
            Class<Rect> obj;
            int i;
            i2 = 1;
            final String str4 = "WindowInsetsCompat";
            if (!WindowInsetsCompat.BuilderImpl20.sConsumedFieldFetched) {
                WindowInsetsCompat.BuilderImpl20.sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                WindowInsetsCompat.BuilderImpl20.sConsumedFieldFetched = i2;
            }
            int i3 = 0;
            sConsumedField = WindowInsetsCompat.BuilderImpl20.sConsumedField.get(i3);
            if (WindowInsetsCompat.BuilderImpl20.sConsumedField != null && (WindowInsets)sConsumedField != null) {
                sConsumedField = WindowInsetsCompat.BuilderImpl20.sConsumedField.get(i3);
                if ((WindowInsets)(WindowInsets)sConsumedField != null) {
                    WindowInsets windowInsets = new WindowInsets((WindowInsets)(WindowInsets)sConsumedField);
                    return windowInsets;
                }
                try {
                    str = "Could not get value from WindowInsets.CONSUMED field";
                    Log.i(obj2, str, th);
                    if (!WindowInsetsCompat.BuilderImpl20.sConstructorFetched) {
                    }
                    str = new Class[i2];
                    str[0] = Rect.class;
                    WindowInsetsCompat.BuilderImpl20.sConstructor = WindowInsets.class.getConstructor(str);
                    str = "Could not retrieve WindowInsets(Rect) constructor";
                    Log.i(obj2, str, th);
                    WindowInsetsCompat.BuilderImpl20.sConstructorFetched = i2;
                    if (WindowInsetsCompat.BuilderImpl20.sConstructor != null) {
                    }
                    Rect rect = new Rect();
                    return (WindowInsets)WindowInsetsCompat.BuilderImpl20.sConstructor.newInstance(/* result */);
                    Log.i(obj2, "Could not invoke WindowInsets(Rect) constructor", th);
                    return i3;
                } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        androidx.core.view.WindowInsetsCompat build() {
            applyInsetTypes();
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setSystemWindowInsets(Insets insets) {
            WindowInsets replaceSystemWindowInsets;
            int left;
            int top;
            int right;
            int bottom;
            if (this.mPlatformInsets != null) {
                this.mPlatformInsets = this.mPlatformInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }
    }

    private static class BuilderImpl29 extends androidx.core.view.WindowInsetsCompat.BuilderImpl {

        final WindowInsets.Builder mPlatBuilder;
        BuilderImpl29() {
            super();
            WindowInsets.Builder builder = new WindowInsets.Builder();
            this.mPlatBuilder = builder;
        }

        BuilderImpl29(androidx.core.view.WindowInsetsCompat insets) {
            WindowInsets.Builder builder;
            super(insets);
            final WindowInsets windowInsets = insets.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.mPlatBuilder = builder;
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        androidx.core.view.WindowInsetsCompat build() {
            applyInsetTypes();
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setDisplayCutout(androidx.core.view.DisplayCutoutCompat displayCutout) {
            android.view.DisplayCutout unwrap;
            if (displayCutout != null) {
                unwrap = displayCutout.unwrap();
            } else {
                unwrap = 0;
            }
            this.mPlatBuilder.setDisplayCutout(unwrap);
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setMandatorySystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setStableInsets(Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setSystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setSystemWindowInsets(Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
        void setTappableElementInsets(Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }
    }

    private static class BuilderImpl30 extends androidx.core.view.WindowInsetsCompat.BuilderImpl29 {
        BuilderImpl30(androidx.core.view.WindowInsetsCompat insets) {
            super(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl29
        void setInsets(int typeMask, Insets insets) {
            this.mPlatBuilder.setInsets(WindowInsetsCompat.TypeImpl30.toPlatformType(typeMask), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl29
        void setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl30.toPlatformType(typeMask), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl29
        void setVisible(int typeMask, boolean visible) {
            this.mPlatBuilder.setVisible(WindowInsetsCompat.TypeImpl30.toPlatformType(typeMask), visible);
        }
    }

    private static class BuilderImpl34 extends androidx.core.view.WindowInsetsCompat.BuilderImpl30 {
        BuilderImpl34(androidx.core.view.WindowInsetsCompat insets) {
            super(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl30
        void setInsets(int typeMask, Insets insets) {
            this.mPlatBuilder.setInsets(WindowInsetsCompat.TypeImpl34.toPlatformType(typeMask), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl30
        void setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl34.toPlatformType(typeMask), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl30
        void setVisible(int typeMask, boolean visible) {
            this.mPlatBuilder.setVisible(WindowInsetsCompat.TypeImpl34.toPlatformType(typeMask), visible);
        }
    }

    private static class Impl {

        static final androidx.core.view.WindowInsetsCompat CONSUMED;
        final androidx.core.view.WindowInsetsCompat mHost;
        static {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder();
            WindowInsetsCompat.Impl.CONSUMED = builder.build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        Impl(androidx.core.view.WindowInsetsCompat host) {
            super();
            this.mHost = host;
        }

        androidx.core.view.WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        androidx.core.view.WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        androidx.core.view.WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        void copyRootViewBounds(View rootView) {
        }

        void copyWindowDataInto(androidx.core.view.WindowInsetsCompat other) {
        }

        public boolean equals(Object o) {
            int i;
            boolean consumed;
            boolean systemWindowInsets;
            if (this == o) {
                return 1;
            }
            final int i2 = 0;
            if (!o instanceof WindowInsetsCompat.Impl) {
                return i2;
            }
            Object obj = o;
            if (isRound() == (WindowInsetsCompat.Impl)obj.isRound() && isConsumed() == obj.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), obj.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), obj.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), obj.getDisplayCutout())) {
                if (isConsumed() == obj.isConsumed()) {
                    if (ObjectsCompat.equals(getSystemWindowInsets(), obj.getSystemWindowInsets())) {
                        if (ObjectsCompat.equals(getStableInsets(), obj.getStableInsets())) {
                            if (ObjectsCompat.equals(getDisplayCutout(), obj.getDisplayCutout())) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        androidx.core.view.DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        Insets getInsets(int typeMask) {
            return Insets.NONE;
        }

        Insets getInsetsIgnoringVisibility(int typeMask) {
            if (typeMask & 8 != 0) {
            } else {
                return Insets.NONE;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to query the maximum insets for IME");
            throw illegalArgumentException;
        }

        Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        Insets getStableInsets() {
            return Insets.NONE;
        }

        Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(/* result */);
        }

        androidx.core.view.WindowInsetsCompat inset(int left, int top, int right, int bottom) {
            return WindowInsetsCompat.Impl.CONSUMED;
        }

        boolean isConsumed() {
            return 0;
        }

        boolean isRound() {
            return 0;
        }

        boolean isVisible(int typeMask) {
            return 1;
        }

        public void setOverriddenInsets(Insets[] insetsTypeMask) {
        }

        void setRootViewData(Insets visibleInsets) {
        }

        void setRootWindowInsets(androidx.core.view.WindowInsetsCompat rootWindowInsets) {
        }

        public void setStableInsets(Insets stableInsets) {
        }

        void setSystemUiVisibility(int systemUiVisibility) {
        }
    }

    private static class Impl20 extends androidx.core.view.WindowInsetsCompat.Impl {

        private static final int SYSTEM_BAR_VISIBILITY_MASK = 6;
        private static Class<?> sAttachInfoClass;
        private static Field sAttachInfoField;
        private static Method sGetViewRootImplMethod;
        private static Field sVisibleInsetsField;
        private static boolean sVisibleRectReflectionFetched;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private androidx.core.view.WindowInsetsCompat mRootWindowInsets;
        int mSystemUiVisibility;
        private Insets mSystemWindowInsets;
        static {
            WindowInsetsCompat.Impl20.sVisibleRectReflectionFetched = false;
        }

        Impl20(androidx.core.view.WindowInsetsCompat host, WindowInsets insets) {
            super(host);
            this.mSystemWindowInsets = 0;
            this.mPlatformInsets = insets;
        }

        Impl20(androidx.core.view.WindowInsetsCompat host, androidx.core.view.WindowInsetsCompat.Impl20 other) {
            WindowInsets windowInsets = new WindowInsets(other.mPlatformInsets);
            super(host, windowInsets);
        }

        private Insets getInsets(int typeMask, boolean ignoreVisibility) {
            Insets result;
            int i;
            int insetsForType;
            result = Insets.NONE;
            i = 1;
            while (i <= 512) {
                if (typeMask & i == 0) {
                } else {
                }
                result = Insets.max(result, getInsetsForType(i, ignoreVisibility));
                i <<= 1;
            }
            return result;
        }

        private Insets getRootStableInsets() {
            if (this.mRootWindowInsets != null) {
                return this.mRootWindowInsets.getStableInsets();
            }
            return Insets.NONE;
        }

        private Insets getVisibleInsets(View rootView) {
            Object sGetViewRootImplMethod;
            int i;
            if (Build.VERSION.SDK_INT >= 30) {
            } else {
                if (!WindowInsetsCompat.Impl20.sVisibleRectReflectionFetched) {
                    WindowInsetsCompat.Impl20.loadReflectionField();
                }
                i = 0;
                if (WindowInsetsCompat.Impl20.sGetViewRootImplMethod != null && WindowInsetsCompat.Impl20.sAttachInfoClass != null) {
                    if (WindowInsetsCompat.Impl20.sAttachInfoClass != null) {
                        if (WindowInsetsCompat.Impl20.sVisibleInsetsField == null) {
                        } else {
                            Object invoke = WindowInsetsCompat.Impl20.sGetViewRootImplMethod.invoke(rootView, new Object[0]);
                            if (invoke == null) {
                                NullPointerException nullPointerException = new NullPointerException();
                                Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", nullPointerException);
                                return i;
                            }
                            Object obj2 = WindowInsetsCompat.Impl20.sVisibleInsetsField.get(WindowInsetsCompat.Impl20.sAttachInfoField.get(invoke));
                            if ((Rect)obj2 != null) {
                                i = Insets.of((Rect)obj2);
                            }
                        }
                        return i;
                    }
                }
                return i;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            throw unsupportedOperationException;
        }

        private static void loadReflectionField() {
            Class forName;
            Field sAttachInfoField;
            Class[] arr;
            final int i = 1;
            WindowInsetsCompat.Impl20.sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            WindowInsetsCompat.Impl20.sAttachInfoClass = Class.forName("android.view.View$AttachInfo");
            WindowInsetsCompat.Impl20.sVisibleInsetsField = WindowInsetsCompat.Impl20.sAttachInfoClass.getDeclaredField("mVisibleInsets");
            WindowInsetsCompat.Impl20.sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            WindowInsetsCompat.Impl20.sVisibleInsetsField.setAccessible(i);
            WindowInsetsCompat.Impl20.sAttachInfoField.setAccessible(i);
            WindowInsetsCompat.Impl20.sVisibleRectReflectionFetched = i;
        }

        static boolean systemBarVisibilityEquals(int vis1, int vis2) {
            int i;
            i = vis1 & 6 == vis2 & 6 ? 1 : 0;
            return i;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        void copyRootViewBounds(View rootView) {
            Insets visibleInsets;
            if (getVisibleInsets(rootView) == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        void copyWindowDataInto(androidx.core.view.WindowInsetsCompat other) {
            other.setRootWindowInsets(this.mRootWindowInsets);
            other.setRootViewData(this.mRootViewVisibleInsets);
            other.setSystemUiVisibility(this.mSystemUiVisibility);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        public boolean equals(Object o) {
            int i;
            boolean systemBarVisibilityEquals;
            Insets mRootViewVisibleInsets;
            if (!super.equals(o)) {
                return 0;
            }
            Object obj = o;
            if (Objects.equals(this.mRootViewVisibleInsets, obj.mRootViewVisibleInsets) && WindowInsetsCompat.Impl20.systemBarVisibilityEquals(this.mSystemUiVisibility, obj.mSystemUiVisibility)) {
                if (WindowInsetsCompat.Impl20.systemBarVisibilityEquals(this.mSystemUiVisibility, obj.mSystemUiVisibility)) {
                    i = 1;
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        public Insets getInsets(int typeMask) {
            return getInsets(typeMask, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        protected Insets getInsetsForType(int type, boolean ignoreVisibility) {
            androidx.core.view.DisplayCutoutCompat displayCutout;
            Insets stableInsets;
            int mOverriddenInsets;
            int bottom;
            Insets mRootViewVisibleInsets;
            int bottom2;
            int nONE;
            stableInsets = 0;
            int i2 = 0;
            switch (type) {
                case 1:
                    return Insets.of(i2, Math.max(rootStableInsets.top, systemWindowInsets4.top), i2, i2);
                    return Insets.NONE;
                    return Insets.of(i2, systemWindowInsets.top, i2, i2);
                case 2:
                    Insets rootStableInsets2 = getRootStableInsets();
                    Insets stableInsets2 = getStableInsets();
                    return Insets.of(Math.max(rootStableInsets2.left, stableInsets2.left), i2, Math.max(rootStableInsets2.right, stableInsets2.right), Math.max(rootStableInsets2.bottom, stableInsets2.bottom));
                    return Insets.NONE;
                    Insets systemWindowInsets3 = getSystemWindowInsets();
                    stableInsets = this.mRootWindowInsets.getStableInsets();
                    bottom = Math.min(systemWindowInsets3.bottom, stableInsets.bottom);
                    return Insets.of(systemWindowInsets3.left, i2, systemWindowInsets3.right, bottom);
                case 8:
                    stableInsets = this.mOverriddenInsets[WindowInsetsCompat.Type.indexOf(8)];
                    return stableInsets;
                    Insets systemWindowInsets2 = getSystemWindowInsets();
                    Insets rootStableInsets3 = getRootStableInsets();
                    return Insets.of(i2, i2, i2, systemWindowInsets2.bottom);
                    return Insets.of(i2, i2, i2, mRootViewVisibleInsets4.bottom);
                    return Insets.NONE;
                case 16:
                    return getSystemGestureInsets();
                case 32:
                    return getMandatorySystemGestureInsets();
                case 64:
                    return getTappableElementInsets();
                case 128:
                    displayCutout = this.mRootWindowInsets.getDisplayCutout();
                    displayCutout = getDisplayCutout();
                    return Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                    return Insets.NONE;
                default:
                    return Insets.NONE;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        public Insets getInsetsIgnoringVisibility(int typeMask) {
            return getInsets(typeMask, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        final Insets getSystemWindowInsets() {
            Insets mSystemWindowInsets;
            int systemWindowInsetTop;
            int systemWindowInsetRight;
            int systemWindowInsetBottom;
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        androidx.core.view.WindowInsetsCompat inset(int left, int top, int right, int bottom) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), left, top, right, bottom));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), left, top, right, bottom));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        protected boolean isTypeVisible(int type) {
            int i2 = 1;
            int i4 = 0;
            switch (type) {
                case 1:
                    return i2 ^= equals;
                case 2:
                    return i4;
                default:
                    return i2;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        boolean isVisible(int typeMask) {
            int i;
            int typeVisible;
            i = 1;
            while (i <= 512) {
                i <<= 1;
            }
            return 1;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        public void setOverriddenInsets(Insets[] insetsTypeMask) {
            this.mOverriddenInsets = insetsTypeMask;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        void setRootViewData(Insets visibleInsets) {
            this.mRootViewVisibleInsets = visibleInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        void setRootWindowInsets(androidx.core.view.WindowInsetsCompat rootWindowInsets) {
            this.mRootWindowInsets = rootWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl
        void setSystemUiVisibility(int systemUiVisibility) {
            this.mSystemUiVisibility = systemUiVisibility;
        }
    }

    private static class Impl21 extends androidx.core.view.WindowInsetsCompat.Impl20 {

        private Insets mStableInsets;
        Impl21(androidx.core.view.WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
            this.mStableInsets = 0;
        }

        Impl21(androidx.core.view.WindowInsetsCompat host, androidx.core.view.WindowInsetsCompat.Impl21 other) {
            super(host, other);
            this.mStableInsets = 0;
            this.mStableInsets = other.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl20
        androidx.core.view.WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl20
        androidx.core.view.WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl20
        final Insets getStableInsets() {
            Insets mStableInsets;
            int stableInsetTop;
            int stableInsetRight;
            int stableInsetBottom;
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl20
        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl20
        public void setStableInsets(Insets stableInsets) {
            this.mStableInsets = stableInsets;
        }
    }

    private static class Impl28 extends androidx.core.view.WindowInsetsCompat.Impl21 {
        Impl28(androidx.core.view.WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl28(androidx.core.view.WindowInsetsCompat host, androidx.core.view.WindowInsetsCompat.Impl28 other) {
            super(host, other);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl21
        androidx.core.view.WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl21
        public boolean equals(Object o) {
            int i;
            boolean systemBarVisibilityEquals;
            int mRootViewVisibleInsets;
            if (this == o) {
                return 1;
            }
            final int i2 = 0;
            if (!o instanceof WindowInsetsCompat.Impl28) {
                return i2;
            }
            Object obj = o;
            if (Objects.equals(this.mPlatformInsets, obj.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, obj.mRootViewVisibleInsets) && WindowInsetsCompat.Impl28.systemBarVisibilityEquals(this.mSystemUiVisibility, obj.mSystemUiVisibility)) {
                if (Objects.equals(this.mRootViewVisibleInsets, obj.mRootViewVisibleInsets)) {
                    if (WindowInsetsCompat.Impl28.systemBarVisibilityEquals(this.mSystemUiVisibility, obj.mSystemUiVisibility)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl21
        androidx.core.view.DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl21
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    private static class Impl29 extends androidx.core.view.WindowInsetsCompat.Impl28 {

        private Insets mMandatorySystemGestureInsets = null;
        private Insets mSystemGestureInsets = null;
        private Insets mTappableElementInsets = null;
        Impl29(androidx.core.view.WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
            final int i = 0;
        }

        Impl29(androidx.core.view.WindowInsetsCompat host, androidx.core.view.WindowInsetsCompat.Impl29 other) {
            super(host, other);
            final int i = 0;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl28
        Insets getMandatorySystemGestureInsets() {
            Insets mMandatorySystemGestureInsets;
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl28
        Insets getSystemGestureInsets() {
            Insets mSystemGestureInsets;
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl28
        Insets getTappableElementInsets() {
            Insets mTappableElementInsets;
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl28
        androidx.core.view.WindowInsetsCompat inset(int left, int top, int right, int bottom) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(left, top, right, bottom));
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl28
        public void setStableInsets(Insets stableInsets) {
        }
    }

    private static class Impl30 extends androidx.core.view.WindowInsetsCompat.Impl29 {

        static final androidx.core.view.WindowInsetsCompat CONSUMED;
        static {
            WindowInsetsCompat.Impl30.CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        Impl30(androidx.core.view.WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl30(androidx.core.view.WindowInsetsCompat host, androidx.core.view.WindowInsetsCompat.Impl30 other) {
            super(host, other);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl29
        final void copyRootViewBounds(View rootView) {
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl29
        public Insets getInsets(int typeMask) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(WindowInsetsCompat.TypeImpl30.toPlatformType(typeMask)));
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl29
        public Insets getInsetsIgnoringVisibility(int typeMask) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl30.toPlatformType(typeMask)));
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl29
        public boolean isVisible(int typeMask) {
            return this.mPlatformInsets.isVisible(WindowInsetsCompat.TypeImpl30.toPlatformType(typeMask));
        }
    }

    private static class Impl34 extends androidx.core.view.WindowInsetsCompat.Impl30 {

        static final androidx.core.view.WindowInsetsCompat CONSUMED;
        static {
            WindowInsetsCompat.Impl34.CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        Impl34(androidx.core.view.WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl34(androidx.core.view.WindowInsetsCompat host, androidx.core.view.WindowInsetsCompat.Impl34 other) {
            super(host, other);
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl30
        public Insets getInsets(int typeMask) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(WindowInsetsCompat.TypeImpl34.toPlatformType(typeMask)));
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl30
        public Insets getInsetsIgnoringVisibility(int typeMask) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl34.toPlatformType(typeMask)));
        }

        @Override // androidx.core.view.WindowInsetsCompat$Impl30
        public boolean isVisible(int typeMask) {
            return this.mPlatformInsets.isVisible(WindowInsetsCompat.TypeImpl34.toPlatformType(typeMask));
        }
    }

    public static final class Side {

        public static final int BOTTOM = 8;
        public static final int LEFT = 1;
        public static final int RIGHT = 4;
        public static final int TOP = 2;
        public static int all() {
            return 15;
        }
    }

    public static final class Type {

        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 512;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 10;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int SYSTEM_OVERLAYS = 512;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;
        static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        static int indexOf(int type) {
            switch (type) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 4:
                    return 2;
                case 8:
                    return 3;
                case 16:
                    return 4;
                case 32:
                    return 5;
                case 64:
                    return 6;
                case 128:
                    return 7;
                case 256:
                    return 8;
                case 512:
                    return 9;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("type needs to be >= FIRST and <= LAST, type=").append(type).toString());
                    throw illegalArgumentException;
            }
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 519;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int systemOverlays() {
            return 512;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    private static final class TypeImpl30 {
        static int toPlatformType(int typeMask) {
            int result;
            int i;
            int mandatorySystemGestures;
            result = 0;
            i = 1;
            while (i <= 512) {
                if (typeMask & i != 0) {
                }
                i <<= 1;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
            }
            return result;
        }
    }

    private static final class TypeImpl34 {
        static int toPlatformType(int typeMask) {
            int result;
            int i;
            int mandatorySystemGestures;
            result = 0;
            i = 1;
            while (i <= 512) {
                if (typeMask & i != 0) {
                }
                i <<= 1;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
                result |= mandatorySystemGestures;
            }
            return result;
        }
    }
    static {
        androidx.core.view.WindowInsetsCompat cONSUMED;
        int i;
        if (Build.VERSION.SDK_INT >= 34) {
            WindowInsetsCompat.CONSUMED = WindowInsetsCompat.Impl34.CONSUMED;
        } else {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowInsetsCompat.CONSUMED = WindowInsetsCompat.Impl30.CONSUMED;
            } else {
                WindowInsetsCompat.CONSUMED = WindowInsetsCompat.Impl.CONSUMED;
            }
        }
    }

    private WindowInsetsCompat(WindowInsets insets) {
        androidx.core.view.WindowInsetsCompat.Impl29 impl29;
        int i;
        super();
        if (Build.VERSION.SDK_INT >= 34) {
            impl29 = new WindowInsetsCompat.Impl34(this, insets);
            this.mImpl = impl29;
        } else {
            if (Build.VERSION.SDK_INT >= 30) {
                impl29 = new WindowInsetsCompat.Impl30(this, insets);
                this.mImpl = impl29;
            } else {
                impl29 = new WindowInsetsCompat.Impl29(this, insets);
                this.mImpl = impl29;
            }
        }
    }

    public WindowInsetsCompat(androidx.core.view.WindowInsetsCompat src) {
        androidx.core.view.WindowInsetsCompat.Impl mImpl;
        int sDK_INT;
        int sDK_INT2;
        androidx.core.view.WindowInsetsCompat.Impl impl;
        androidx.core.view.WindowInsetsCompat.Impl i;
        super();
        if (src != null) {
            mImpl = src.mImpl;
            if (Build.VERSION.SDK_INT >= 34 && mImpl instanceof WindowInsetsCompat.Impl34) {
                if (mImpl instanceof WindowInsetsCompat.Impl34) {
                    impl = new WindowInsetsCompat.Impl34(this, (WindowInsetsCompat.Impl34)mImpl);
                    this.mImpl = impl;
                } else {
                    if (Build.VERSION.SDK_INT >= 30 && mImpl instanceof WindowInsetsCompat.Impl30) {
                        if (mImpl instanceof WindowInsetsCompat.Impl30) {
                            impl = new WindowInsetsCompat.Impl30(this, (WindowInsetsCompat.Impl30)mImpl);
                            this.mImpl = impl;
                        } else {
                            if (mImpl instanceof WindowInsetsCompat.Impl29) {
                                impl = new WindowInsetsCompat.Impl29(this, (WindowInsetsCompat.Impl29)mImpl);
                                this.mImpl = impl;
                            } else {
                                if (mImpl instanceof WindowInsetsCompat.Impl28) {
                                    impl = new WindowInsetsCompat.Impl28(this, (WindowInsetsCompat.Impl28)mImpl);
                                    this.mImpl = impl;
                                } else {
                                    if (mImpl instanceof WindowInsetsCompat.Impl21) {
                                        impl = new WindowInsetsCompat.Impl21(this, (WindowInsetsCompat.Impl21)mImpl);
                                        this.mImpl = impl;
                                    } else {
                                        if (mImpl instanceof WindowInsetsCompat.Impl20) {
                                            impl = new WindowInsetsCompat.Impl20(this, (WindowInsetsCompat.Impl20)mImpl);
                                            this.mImpl = impl;
                                        } else {
                                            impl = new WindowInsetsCompat.Impl(this);
                                            this.mImpl = impl;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            mImpl.copyWindowDataInto(this);
        } else {
            mImpl = new WindowInsetsCompat.Impl(this);
            this.mImpl = mImpl;
        }
    }

    static Insets insetInsets(Insets insets, int left, int top, int right, int bottom) {
        int i3 = 0;
        int i2 = Math.max(i3, left2 -= left);
        int i6 = Math.max(i3, top2 -= top);
        int i8 = Math.max(i3, right2 -= right);
        int i4 = Math.max(i3, bottom2 -= bottom);
        if (i2 == left && i6 == top && i8 == right && i4 == bottom) {
            if (i6 == top) {
                if (i8 == right) {
                    if (i4 == bottom) {
                        return insets;
                    }
                }
            }
        }
        return Insets.of(i2, i6, i8, i4);
    }

    public static androidx.core.view.WindowInsetsCompat toWindowInsetsCompat(WindowInsets insets) {
        return WindowInsetsCompat.toWindowInsetsCompat(insets, 0);
    }

    public static androidx.core.view.WindowInsetsCompat toWindowInsetsCompat(WindowInsets insets, View view) {
        Object windowSystemUiVisibility;
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets)Preconditions.checkNotNull(insets));
        if (view != null && view.isAttachedToWindow()) {
            if (view.isAttachedToWindow()) {
                windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
                windowInsetsCompat.copyRootViewBounds(view.getRootView());
                windowInsetsCompat.setSystemUiVisibility(view.getWindowSystemUiVisibility());
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public androidx.core.view.WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @Deprecated
    public androidx.core.view.WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @Deprecated
    public androidx.core.view.WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    void copyRootViewBounds(View rootView) {
        this.mImpl.copyRootViewBounds(rootView);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return 1;
        }
        if (!o instanceof WindowInsetsCompat) {
            return 0;
        }
        return ObjectsCompat.equals(this.mImpl, obj.mImpl);
    }

    public androidx.core.view.DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    public Insets getInsets(int typeMask) {
        return this.mImpl.getInsets(typeMask);
    }

    public Insets getInsetsIgnoringVisibility(int typeMask) {
        return this.mImpl.getInsetsIgnoringVisibility(typeMask);
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return stableInsets.bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return stableInsets.left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return stableInsets.right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return stableInsets.top;
    }

    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return systemWindowInsets.bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return systemWindowInsets.left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return systemWindowInsets.right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return systemWindowInsets.top;
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        boolean displayCutout;
        int i;
        Insets nONE;
        if (getInsets(WindowInsetsCompat.Type.all()).equals(Insets.NONE) && getInsetsIgnoringVisibility(i3 ^= i5).equals(Insets.NONE)) {
            if (getInsetsIgnoringVisibility(i3 ^= i5).equals(Insets.NONE)) {
                if (getDisplayCutout() != null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return equals ^= 1;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return equals ^= 1;
    }

    public int hashCode() {
        int i;
        if (this.mImpl == null) {
            i = 0;
        } else {
            i = this.mImpl.hashCode();
        }
        return i;
    }

    public androidx.core.view.WindowInsetsCompat inset(int left, int top, int right, int bottom) {
        return this.mImpl.inset(left, top, right, bottom);
    }

    public androidx.core.view.WindowInsetsCompat inset(Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int typeMask) {
        return this.mImpl.isVisible(typeMask);
    }

    @Deprecated
    public androidx.core.view.WindowInsetsCompat replaceSystemWindowInsets(int left, int top, int right, int bottom) {
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(this);
        return builder.setSystemWindowInsets(Insets.of(left, top, right, bottom)).build();
    }

    @Deprecated
    public androidx.core.view.WindowInsetsCompat replaceSystemWindowInsets(Rect systemWindowInsets) {
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(this);
        return builder.setSystemWindowInsets(Insets.of(systemWindowInsets)).build();
    }

    void setOverriddenInsets(Insets[] insetsTypeMask) {
        this.mImpl.setOverriddenInsets(insetsTypeMask);
    }

    void setRootViewData(Insets visibleInsets) {
        this.mImpl.setRootViewData(visibleInsets);
    }

    void setRootWindowInsets(androidx.core.view.WindowInsetsCompat rootWindowInsets) {
        this.mImpl.setRootWindowInsets(rootWindowInsets);
    }

    void setStableInsets(Insets stableInsets) {
        this.mImpl.setStableInsets(stableInsets);
    }

    void setSystemUiVisibility(int systemUiVisibility) {
        this.mImpl.setSystemUiVisibility(systemUiVisibility);
    }

    public WindowInsets toWindowInsets() {
        WindowInsets mPlatformInsets;
        if (mImpl instanceof WindowInsetsCompat.Impl20) {
            mPlatformInsets = mImpl2.mPlatformInsets;
        } else {
            mPlatformInsets = 0;
        }
        return mPlatformInsets;
    }
}
