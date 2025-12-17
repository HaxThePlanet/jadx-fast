package androidx.core.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowInsets.Type;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class SoftwareKeyboardControllerCompat {

    private final androidx.core.view.SoftwareKeyboardControllerCompat.Impl mImpl;

    private static class Impl {
        void hide() {
        }

        void show() {
        }
    }

    private static class Impl20 extends androidx.core.view.SoftwareKeyboardControllerCompat.Impl {

        private final View mView;
        Impl20(View view) {
            super();
            this.mView = view;
        }

        static void lambda$show$0(View finalView) {
            (InputMethodManager)finalView.getContext().getSystemService("input_method").showSoftInput(finalView, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat$Impl
        void hide() {
            Object systemService;
            android.os.IBinder windowToken;
            int i;
            if (this.mView != null) {
                (InputMethodManager)this.mView.getContext().getSystemService("input_method").hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat$Impl
        void show() {
            View view;
            View onCheckIsTextEditor;
            int externalSyntheticLambda0;
            view = this.mView;
            if (view == null) {
            }
            if (!view.isInEditMode()) {
                if (view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
            } else {
            }
            if (view == null) {
                view = this.mView.getRootView().findViewById(16908290);
            }
            if (view != null && view.hasWindowFocus()) {
                if (view.hasWindowFocus()) {
                    onCheckIsTextEditor = view;
                    externalSyntheticLambda0 = new SoftwareKeyboardControllerCompat.Impl20$$ExternalSyntheticLambda0(onCheckIsTextEditor);
                    onCheckIsTextEditor.post(externalSyntheticLambda0);
                }
            }
        }
    }

    private static class Impl30 extends androidx.core.view.SoftwareKeyboardControllerCompat.Impl20 {

        private View mView;
        private WindowInsetsController mWindowInsetsController;
        Impl30(View view) {
            super(view);
            this.mView = view;
        }

        Impl30(WindowInsetsController windowInsetsController) {
            super(0);
            this.mWindowInsetsController = windowInsetsController;
        }

        static void lambda$hide$0(AtomicBoolean isImeInsetsControllable, WindowInsetsController windowInsetsController, int typeMask) {
            int i;
            i = typeMask & 8 != 0 ? 1 : 0;
            isImeInsetsControllable.set(i);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat$Impl20
        void hide() {
            int insetsController;
            Object mWindowInsetsController;
            int i;
            androidx.core.view.SoftwareKeyboardControllerCompat.Impl30$$ExternalSyntheticLambda0 externalSyntheticLambda0;
            boolean systemService;
            android.os.IBinder windowToken;
            insetsController = 0;
            if (this.mWindowInsetsController != null) {
                insetsController = this.mWindowInsetsController;
            } else {
                if (this.mView != null) {
                    insetsController = this.mView.getWindowInsetsController();
                }
            }
            if (insetsController != 0) {
                int i2 = 0;
                mWindowInsetsController = new AtomicBoolean(i2);
                externalSyntheticLambda0 = new SoftwareKeyboardControllerCompat.Impl30$$ExternalSyntheticLambda0(mWindowInsetsController);
                insetsController.addOnControllableInsetsChangedListener(externalSyntheticLambda0);
                if (!mWindowInsetsController.get() && this.mView != null) {
                    if (this.mView != null) {
                        (InputMethodManager)this.mView.getContext().getSystemService("input_method").hideSoftInputFromWindow(this.mView.getWindowToken(), i2);
                    }
                }
                insetsController.removeOnControllableInsetsChangedListener(externalSyntheticLambda0);
                insetsController.hide(WindowInsets.Type.ime());
            } else {
                super.hide();
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat$Impl20
        void show() {
            View systemService;
            int imm;
            int str;
            Object mWindowInsetsController;
            if (this.mView != null && Build.VERSION.SDK_INT < 33) {
                if (Build.VERSION.SDK_INT < 33) {
                    (InputMethodManager)this.mView.getContext().getSystemService("input_method").isActive();
                }
            }
            imm = 0;
            if (this.mWindowInsetsController != null) {
                imm = this.mWindowInsetsController;
            } else {
                if (this.mView != null) {
                    imm = this.mView.getWindowInsetsController();
                }
            }
            if (imm != 0) {
                imm.show(WindowInsets.Type.ime());
            }
            super.show();
        }
    }
    public SoftwareKeyboardControllerCompat(View view) {
        androidx.core.view.SoftwareKeyboardControllerCompat.Impl20 impl20;
        super();
        if (Build.VERSION.SDK_INT >= 30) {
            impl20 = new SoftwareKeyboardControllerCompat.Impl30(view);
            this.mImpl = impl20;
        } else {
            impl20 = new SoftwareKeyboardControllerCompat.Impl20(view);
            this.mImpl = impl20;
        }
    }

    @Deprecated
    SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        super();
        SoftwareKeyboardControllerCompat.Impl30 impl30 = new SoftwareKeyboardControllerCompat.Impl30(windowInsetsController);
        this.mImpl = impl30;
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }
}
