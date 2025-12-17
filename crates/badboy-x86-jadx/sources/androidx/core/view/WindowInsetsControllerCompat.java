package androidx.core.view;

import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowInsetsController.OnControllableInsetsChangedListener;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes5.dex */
public final class WindowInsetsControllerCompat {

    public static final int BEHAVIOR_DEFAULT = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final androidx.core.view.WindowInsetsControllerCompat.Impl mImpl;

    private static class Impl {

        static final int KEY_BEHAVIOR = 356039078;
        void addOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
        }

        void controlWindowInsetsAnimation(int types, long durationMillis, Interpolator interpolator, CancellationSignal cancellationSignal, androidx.core.view.WindowInsetsAnimationControlListenerCompat listener) {
        }

        int getSystemBarsBehavior() {
            return 1;
        }

        void hide(int types) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return 0;
        }

        public boolean isAppearanceLightStatusBars() {
            return 0;
        }

        void removeOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
        }

        public void setAppearanceLightNavigationBars(boolean isLight) {
        }

        public void setAppearanceLightStatusBars(boolean isLight) {
        }

        void setSystemBarsBehavior(int behavior) {
        }

        void show(int types) {
        }
    }

    private static class Impl20 extends androidx.core.view.WindowInsetsControllerCompat.Impl {

        private final androidx.core.view.SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected final Window mWindow;
        Impl20(Window window, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super();
            this.mWindow = window;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        private void hideForType(int type) {
            Object mSoftwareKeyboardControllerCompat;
            switch (type) {
                case 1:
                    setSystemUiFlag(4);
                case 2:
                    setSystemUiFlag(2);
                case 8:
                    this.mSoftwareKeyboardControllerCompat.hide();
                    break;
                default:
            }
        }

        private void showForType(int type) {
            Object mSoftwareKeyboardControllerCompat;
            switch (type) {
                case 1:
                    unsetSystemUiFlag(4);
                    unsetWindowFlag(1024);
                case 2:
                    unsetSystemUiFlag(2);
                case 8:
                    this.mSoftwareKeyboardControllerCompat.show();
                    break;
                default:
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void addOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void controlWindowInsetsAnimation(int types, long durationMillis, Interpolator interpolator, CancellationSignal cancellationSignal, androidx.core.view.WindowInsetsAnimationControlListenerCompat listener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        int getSystemBarsBehavior() {
            int intValue;
            Object tag = this.mWindow.getDecorView().getTag(356039078);
            if (tag != null) {
                intValue = (Integer)tag.intValue();
            } else {
                intValue = 1;
            }
            return intValue;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void hide(int typeMask) {
            int i2;
            int i;
            i2 = 1;
            while (i2 <= 512) {
                if (typeMask & i2 == 0) {
                } else {
                }
                hideForType(i2);
                i2 <<= 1;
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void removeOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void setSystemBarsBehavior(int behavior) {
            int i;
            this.mWindow.getDecorView().setTag(356039078, Integer.valueOf(behavior));
            i = 2048;
            int i4 = 4096;
            switch (behavior) {
                case 0:
                    unsetSystemUiFlag(6144);
                    break;
                case 1:
                    unsetSystemUiFlag(i4);
                    setSystemUiFlag(i);
                    break;
                case 2:
                    unsetSystemUiFlag(i);
                    setSystemUiFlag(i4);
                    break;
                default:
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        protected void setSystemUiFlag(int systemUiFlag) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(systemUiVisibility |= systemUiFlag);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        protected void setWindowFlag(int windowFlag) {
            this.mWindow.addFlags(windowFlag);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void show(int typeMask) {
            int i;
            int i2;
            i = 1;
            while (i <= 512) {
                if (typeMask & i == 0) {
                } else {
                }
                showForType(i);
                i <<= 1;
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        protected void unsetSystemUiFlag(int systemUiFlag) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(systemUiVisibility &= i2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        protected void unsetWindowFlag(int windowFlag) {
            this.mWindow.clearFlags(windowFlag);
        }
    }

    private static class Impl23 extends androidx.core.view.WindowInsetsControllerCompat.Impl20 {
        Impl23(Window window, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl20
        public boolean isAppearanceLightStatusBars() {
            int i;
            i = systemUiVisibility &= 8192 != 0 ? 1 : 0;
            return i;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl20
        public void setAppearanceLightStatusBars(boolean isLight) {
            int i;
            final int i2 = 8192;
            if (isLight) {
                unsetWindowFlag(67108864);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(i2);
            } else {
                unsetSystemUiFlag(i2);
            }
        }
    }

    private static class Impl26 extends androidx.core.view.WindowInsetsControllerCompat.Impl23 {
        Impl26(Window window, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl23
        public boolean isAppearanceLightNavigationBars() {
            int i;
            i = systemUiVisibility &= 16 != 0 ? 1 : 0;
            return i;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl23
        public void setAppearanceLightNavigationBars(boolean isLight) {
            int i;
            final int i2 = 16;
            if (isLight) {
                unsetWindowFlag(134217728);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(i2);
            } else {
                unsetSystemUiFlag(i2);
            }
        }
    }

    private static class Impl30 extends androidx.core.view.WindowInsetsControllerCompat.Impl {

        final androidx.core.view.WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final androidx.core.view.SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;
        Impl30(Window window, androidx.core.view.WindowInsetsControllerCompat compatController, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window.getInsetsController(), compatController, softwareKeyboardControllerCompat);
            this.mWindow = window;
        }

        Impl30(WindowInsetsController insetsController, androidx.core.view.WindowInsetsControllerCompat compatController, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super();
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
            this.mListeners = simpleArrayMap;
            this.mInsetsController = insetsController;
            this.mCompatController = compatController;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void addOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
            if (this.mListeners.containsKey(listener)) {
            }
            WindowInsetsControllerCompat.Impl30$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new WindowInsetsControllerCompat.Impl30$$ExternalSyntheticLambda0(this, listener);
            this.mListeners.put(listener, externalSyntheticLambda0);
            this.mInsetsController.addOnControllableInsetsChangedListener(externalSyntheticLambda0);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void controlWindowInsetsAnimation(int types, long durationMillis, Interpolator interpolator, CancellationSignal cancellationSignal, androidx.core.view.WindowInsetsAnimationControlListenerCompat listener) {
            WindowInsetsControllerCompat.Impl30.1 anon = new WindowInsetsControllerCompat.Impl30.1(this, obj14);
            this.mInsetsController.controlWindowInsetsAnimation(types, durationMillis, obj4, cancellationSignal, listener);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        int getSystemBarsBehavior() {
            int intValue;
            if (this.mWindow != null) {
                Object tag = this.mWindow.getDecorView().getTag(356039078);
                if (tag != null) {
                    intValue = (Integer)tag.intValue();
                } else {
                    intValue = 1;
                }
                return intValue;
            }
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void hide(int types) {
            int mSoftwareKeyboardControllerCompat;
            if (types & 8 != 0) {
                this.mSoftwareKeyboardControllerCompat.hide();
            }
            this.mInsetsController.hide(types & -9);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        public boolean isAppearanceLightNavigationBars() {
            int i;
            i = 0;
            this.mInsetsController.setSystemBarsAppearance(i, i);
            if (systemBarsAppearance &= 16 != 0) {
                i = 1;
            }
            return i;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        public boolean isAppearanceLightStatusBars() {
            int i;
            i = 0;
            this.mInsetsController.setSystemBarsAppearance(i, i);
            if (systemBarsAppearance &= 8 != 0) {
                i = 1;
            }
            return i;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener, WindowInsetsController controller, int typeMask) {
            Object mInsetsController;
            if (this.mInsetsController == controller) {
                listener.onControllableInsetsChanged(this.mCompatController, typeMask);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void removeOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
            WindowInsetsController mInsetsController;
            Object remove = this.mListeners.remove(listener);
            if ((WindowInsetsController.OnControllableInsetsChangedListener)remove != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)remove);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        public void setAppearanceLightNavigationBars(boolean isLight) {
            WindowInsetsController mInsetsController;
            int i;
            final int i2 = 16;
            if (isLight) {
                if (this.mWindow != null) {
                    setSystemUiFlag(i2);
                }
                this.mInsetsController.setSystemBarsAppearance(i2, i2);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(i2);
                }
                this.mInsetsController.setSystemBarsAppearance(0, i2);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        public void setAppearanceLightStatusBars(boolean isLight) {
            WindowInsetsController mInsetsController;
            Window mWindow;
            int i = 8192;
            final int i2 = 8;
            if (isLight) {
                if (this.mWindow != null) {
                    setSystemUiFlag(i);
                }
                this.mInsetsController.setSystemBarsAppearance(i2, i2);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(i);
                }
                this.mInsetsController.setSystemBarsAppearance(0, i2);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void setSystemBarsBehavior(int behavior) {
            int mInsetsController;
            int i;
            Integer valueOf;
            if (this.mWindow != null) {
                this.mWindow.getDecorView().setTag(356039078, Integer.valueOf(behavior));
                mInsetsController = 2048;
                i = 4096;
                switch (behavior) {
                    case 0:
                        unsetSystemUiFlag(6144);
                        break;
                    case 1:
                        unsetSystemUiFlag(i);
                        setSystemUiFlag(mInsetsController);
                        break;
                    case 2:
                        unsetSystemUiFlag(mInsetsController);
                        setSystemUiFlag(i);
                        break;
                    default:
                }
            } else {
                this.mInsetsController.setSystemBarsBehavior(behavior);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        protected void setSystemUiFlag(int systemUiFlag) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(systemUiVisibility |= systemUiFlag);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        void show(int types) {
            int mSoftwareKeyboardControllerCompat;
            if (types & 8 != 0) {
                this.mSoftwareKeyboardControllerCompat.show();
            }
            this.mInsetsController.show(types & -9);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
        protected void unsetSystemUiFlag(int systemUiFlag) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(systemUiVisibility &= i2);
        }
    }

    private static class Impl31 extends androidx.core.view.WindowInsetsControllerCompat.Impl30 {
        Impl31(Window window, androidx.core.view.WindowInsetsControllerCompat compatController, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, compatController, softwareKeyboardControllerCompat);
        }

        Impl31(WindowInsetsController insetsController, androidx.core.view.WindowInsetsControllerCompat compatController, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(insetsController, compatController, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl30
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl30
        void setSystemBarsBehavior(int behavior) {
            this.mInsetsController.setSystemBarsBehavior(behavior);
        }
    }

    private static class Impl35 extends androidx.core.view.WindowInsetsControllerCompat.Impl31 {
        Impl35(Window window, androidx.core.view.WindowInsetsControllerCompat compatController, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, compatController, softwareKeyboardControllerCompat);
        }

        Impl35(WindowInsetsController insetsController, androidx.core.view.WindowInsetsControllerCompat compatController, androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(insetsController, compatController, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl31
        public boolean isAppearanceLightNavigationBars() {
            int i;
            i = systemBarsAppearance &= 16 != 0 ? 1 : 0;
            return i;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat$Impl31
        public boolean isAppearanceLightStatusBars() {
            int i;
            i = systemBarsAppearance &= 8 != 0 ? 1 : 0;
            return i;
        }
    }

    public interface OnControllableInsetsChangedListener {
        public abstract void onControllableInsetsChanged(androidx.core.view.WindowInsetsControllerCompat windowInsetsControllerCompat, int i2);
    }
    public WindowInsetsControllerCompat(Window window, View view) {
        androidx.core.view.WindowInsetsControllerCompat.Impl impl;
        int i;
        super();
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        if (Build.VERSION.SDK_INT >= 35) {
            impl = new WindowInsetsControllerCompat.Impl35(window, this, softwareKeyboardControllerCompat);
            this.mImpl = impl;
        } else {
            if (Build.VERSION.SDK_INT >= 30) {
                impl = new WindowInsetsControllerCompat.Impl30(window, this, softwareKeyboardControllerCompat);
                this.mImpl = impl;
            } else {
                impl = new WindowInsetsControllerCompat.Impl26(window, softwareKeyboardControllerCompat);
                this.mImpl = impl;
            }
        }
    }

    @Deprecated
    private WindowInsetsControllerCompat(WindowInsetsController insetsController) {
        androidx.core.view.WindowInsetsControllerCompat.Impl30 impl30;
        androidx.core.view.SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
        super();
        if (Build.VERSION.SDK_INT >= 35) {
            softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(insetsController);
            impl30 = new WindowInsetsControllerCompat.Impl35(insetsController, this, softwareKeyboardControllerCompat);
            this.mImpl = impl30;
        } else {
            softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(insetsController);
            impl30 = new WindowInsetsControllerCompat.Impl30(insetsController, this, softwareKeyboardControllerCompat);
            this.mImpl = impl30;
        }
    }

    @Deprecated
    public static androidx.core.view.WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController insetsController) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(insetsController);
        return windowInsetsControllerCompat;
    }

    public void addOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
        this.mImpl.addOnControllableInsetsChangedListener(listener);
    }

    public void controlWindowInsetsAnimation(int types, long durationMillis, Interpolator interpolator, CancellationSignal cancellationSignal, androidx.core.view.WindowInsetsAnimationControlListenerCompat listener) {
        this.mImpl.controlWindowInsetsAnimation(types, durationMillis, obj3, cancellationSignal, listener);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int types) {
        this.mImpl.hide(types);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener listener) {
        this.mImpl.removeOnControllableInsetsChangedListener(listener);
    }

    public void setAppearanceLightNavigationBars(boolean isLight) {
        this.mImpl.setAppearanceLightNavigationBars(isLight);
    }

    public void setAppearanceLightStatusBars(boolean isLight) {
        this.mImpl.setAppearanceLightStatusBars(isLight);
    }

    public void setSystemBarsBehavior(int behavior) {
        this.mImpl.setSystemBarsBehavior(behavior);
    }

    public void show(int types) {
        this.mImpl.show(types);
    }
}
