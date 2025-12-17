package androidx.compose.foundation.layout;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat.Callback;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001e\u0010\"\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020 0$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001bH\u0016J\u0008\u0010+\u001a\u00020\u001eH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\r\"\u0004\u0008\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018¨\u0006,", d2 = {"Landroidx/compose/foundation/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeInsets", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "(Landroidx/compose/foundation/layout/WindowInsetsHolder;)V", "getComposeInsets", "()Landroidx/compose/foundation/layout/WindowInsetsHolder;", "prepared", "", "getPrepared", "()Z", "setPrepared", "(Z)V", "runningAnimation", "getRunningAnimation", "setRunningAnimation", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "getSavedInsets", "()Landroidx/core/view/WindowInsetsCompat;", "setSavedInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "onApplyWindowInsets", "view", "Landroid/view/View;", "insets", "onEnd", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onPrepare", "onProgress", "runningAnimations", "", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onViewAttachedToWindow", "onViewDetachedFromWindow", "v", "run", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {

    private final androidx.compose.foundation.layout.WindowInsetsHolder composeInsets;
    private boolean prepared;
    private boolean runningAnimation;
    private WindowInsetsCompat savedInsets;
    public InsetsListener(androidx.compose.foundation.layout.WindowInsetsHolder composeInsets) {
        super(consumes ^= 1);
        this.composeInsets = composeInsets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final androidx.compose.foundation.layout.WindowInsetsHolder getComposeInsets() {
        return this.composeInsets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final boolean getPrepared() {
        return this.prepared;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final boolean getRunningAnimation() {
        return this.runningAnimation;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final WindowInsetsCompat getSavedInsets() {
        return this.savedInsets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
        boolean runningAnimation;
        WindowInsetsCompat cONSUMED;
        int i;
        int i2;
        int i3;
        this.savedInsets = insets;
        this.composeInsets.updateImeAnimationTarget(insets);
        if (this.prepared) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post((Runnable)this);
            }
        } else {
            if (!this.runningAnimation) {
                this.composeInsets.updateImeAnimationSource(insets);
                WindowInsetsHolder.update$default(this.composeInsets, insets, 0, 2, 0);
            }
        }
        cONSUMED = this.composeInsets.getConsumes() ? WindowInsetsCompat.CONSUMED : insets;
        return cONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public void onEnd(WindowInsetsAnimationCompat animation) {
        int composeInsets;
        int i;
        final int i2 = 0;
        this.prepared = i2;
        this.runningAnimation = i2;
        final WindowInsetsCompat savedInsets = this.savedInsets;
        final int i3 = 0;
        if (Long.compare(durationMillis, i) != 0 && savedInsets != null) {
            if (savedInsets != null) {
                this.composeInsets.updateImeAnimationSource(savedInsets);
                this.composeInsets.updateImeAnimationTarget(savedInsets);
                WindowInsetsHolder.update$default(this.composeInsets, savedInsets, i2, 2, i3);
            }
        }
        this.savedInsets = i3;
        super.onEnd(animation);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public void onPrepare(WindowInsetsAnimationCompat animation) {
        final int i = 1;
        this.prepared = i;
        this.runningAnimation = i;
        super.onPrepare(animation);
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        WindowInsetsCompat cONSUMED;
        WindowInsetsHolder.update$default(this.composeInsets, insets, 0, 2, 0);
        cONSUMED = this.composeInsets.getConsumes() ? WindowInsetsCompat.CONSUMED : insets;
        return cONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        this.prepared = false;
        return super.onStart(animation, bounds);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public void onViewDetachedFromWindow(View v) {
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public void run() {
        boolean prepared;
        WindowInsetsCompat savedInsets;
        int i2;
        androidx.compose.foundation.layout.WindowInsetsHolder composeInsets;
        int i;
        int i3;
        prepared = 0;
        this.prepared = prepared;
        this.runningAnimation = prepared;
        savedInsets = this.savedInsets;
        if (this.prepared && savedInsets != null) {
            prepared = 0;
            this.prepared = prepared;
            this.runningAnimation = prepared;
            savedInsets = this.savedInsets;
            if (savedInsets != null) {
                i2 = 0;
                this.composeInsets.updateImeAnimationSource(savedInsets);
                i3 = 0;
                WindowInsetsHolder.update$default(this.composeInsets, savedInsets, prepared, 2, i3);
                this.savedInsets = i3;
            }
        }
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final void setPrepared(boolean <set-?>) {
        this.prepared = <set-?>;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final void setRunningAnimation(boolean <set-?>) {
        this.runningAnimation = <set-?>;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Callback
    public final void setSavedInsets(WindowInsetsCompat <set-?>) {
        this.savedInsets = <set-?>;
    }
}
