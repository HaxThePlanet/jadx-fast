package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;

/* loaded from: classes5.dex */
public final class WindowInsetsAnimationControllerCompat {

    private final androidx.core.view.WindowInsetsAnimationControllerCompat.Impl mImpl;

    private static class Impl {
        void finish(boolean shown) {
        }

        public float getCurrentAlpha() {
            return 0;
        }

        public float getCurrentFraction() {
            return 0;
        }

        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        boolean isCancelled() {
            return 1;
        }

        boolean isFinished() {
            return 0;
        }

        public void setInsetsAndAlpha(Insets insets, float alpha, float fraction) {
        }
    }

    private static class Impl30 extends androidx.core.view.WindowInsetsAnimationControllerCompat.Impl {

        private final WindowInsetsAnimationController mController;
        Impl30(WindowInsetsAnimationController controller) {
            super();
            this.mController = controller;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        void finish(boolean shown) {
            this.mController.finish(shown);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public int getTypes() {
            return this.mController.getTypes();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        boolean isCancelled() {
            return this.mController.isCancelled();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        boolean isFinished() {
            return this.mController.isFinished();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
        public void setInsetsAndAlpha(Insets insets, float alpha, float fraction) {
            int platformInsets;
            if (insets == null) {
                platformInsets = 0;
            } else {
                platformInsets = insets.toPlatformInsets();
            }
            this.mController.setInsetsAndAlpha(platformInsets, alpha, fraction);
        }
    }
    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController controller) {
        super();
        WindowInsetsAnimationControllerCompat.Impl30 impl30 = new WindowInsetsAnimationControllerCompat.Impl30(controller);
        this.mImpl = impl30;
    }

    public void finish(boolean shown) {
        this.mImpl.finish(shown);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        boolean cancelled;
        int i;
        if (!isFinished() && !isCancelled()) {
            i = !isCancelled() ? 1 : 0;
        } else {
        }
        return i;
    }

    public void setInsetsAndAlpha(Insets insets, float alpha, float fraction) {
        this.mImpl.setInsetsAndAlpha(insets, alpha, fraction);
    }
}
