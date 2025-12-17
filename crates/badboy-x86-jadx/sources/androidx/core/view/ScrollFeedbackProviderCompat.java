package androidx.core.view;

import android.os.Build.VERSION;
import android.view.ScrollFeedbackProvider;
import android.view.View;

/* loaded from: classes5.dex */
public class ScrollFeedbackProviderCompat {

    private final androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl mImpl;

    private interface ScrollFeedbackProviderImpl {
        public abstract void onScrollLimit(int i, int i2, int i3, boolean z4);

        public abstract void onScrollProgress(int i, int i2, int i3, int i4);

        public abstract void onSnapToItem(int i, int i2, int i3);
    }

    private static class ScrollFeedbackProviderApi35Impl implements androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl {

        private final ScrollFeedbackProvider mProvider;
        ScrollFeedbackProviderApi35Impl(View view) {
            super();
            this.mProvider = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat$ScrollFeedbackProviderImpl
        public void onScrollLimit(int inputDeviceId, int source, int axis, boolean isStart) {
            this.mProvider.onScrollLimit(inputDeviceId, source, axis, isStart);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat$ScrollFeedbackProviderImpl
        public void onScrollProgress(int inputDeviceId, int source, int axis, int deltaInPixels) {
            this.mProvider.onScrollProgress(inputDeviceId, source, axis, deltaInPixels);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat$ScrollFeedbackProviderImpl
        public void onSnapToItem(int inputDeviceId, int source, int axis) {
            this.mProvider.onSnapToItem(inputDeviceId, source, axis);
        }
    }

    private static class ScrollFeedbackProviderBaseImpl implements androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl {
        ScrollFeedbackProviderBaseImpl(androidx.core.view.ScrollFeedbackProviderCompat.1 x0) {
            super();
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat$ScrollFeedbackProviderImpl
        public void onScrollLimit(int inputDeviceId, int source, int axis, boolean isStart) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat$ScrollFeedbackProviderImpl
        public void onScrollProgress(int inputDeviceId, int source, int axis, int deltaInPixels) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat$ScrollFeedbackProviderImpl
        public void onSnapToItem(int inputDeviceId, int source, int axis) {
        }
    }
    private ScrollFeedbackProviderCompat(View view) {
        Object scrollFeedbackProviderApi35Impl;
        int i;
        super();
        if (Build.VERSION.SDK_INT >= 35) {
            scrollFeedbackProviderApi35Impl = new ScrollFeedbackProviderCompat.ScrollFeedbackProviderApi35Impl(view);
            this.mImpl = scrollFeedbackProviderApi35Impl;
        } else {
            scrollFeedbackProviderApi35Impl = new ScrollFeedbackProviderCompat.ScrollFeedbackProviderBaseImpl(0);
            this.mImpl = scrollFeedbackProviderApi35Impl;
        }
    }

    public static androidx.core.view.ScrollFeedbackProviderCompat createProvider(View view) {
        ScrollFeedbackProviderCompat scrollFeedbackProviderCompat = new ScrollFeedbackProviderCompat(view);
        return scrollFeedbackProviderCompat;
    }

    public void onScrollLimit(int inputDeviceId, int source, int axis, boolean isStart) {
        this.mImpl.onScrollLimit(inputDeviceId, source, axis, isStart);
    }

    public void onScrollProgress(int inputDeviceId, int source, int axis, int deltaInPixels) {
        this.mImpl.onScrollProgress(inputDeviceId, source, axis, deltaInPixels);
    }

    public void onSnapToItem(int inputDeviceId, int source, int axis) {
        this.mImpl.onSnapToItem(inputDeviceId, source, axis);
    }
}
