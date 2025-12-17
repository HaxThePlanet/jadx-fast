package androidx.compose.material;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000b\u001a\u00020\u0007J\u0008\u0010\u000c\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0008\u0010\u0010\u001a\u00020\u0007H\u0002J\u0008\u0010\u0011\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/compose/material/OnGlobalLayoutListener;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "view", "Landroid/view/View;", "onGlobalLayoutCallback", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "isListeningToGlobalLayout", "", "dispose", "onGlobalLayout", "onViewAttachedToWindow", "p0", "onViewDetachedFromWindow", "registerOnGlobalLayoutListener", "unregisterOnGlobalLayoutListener", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OnGlobalLayoutListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

    private boolean isListeningToGlobalLayout;
    private final Function0<Unit> onGlobalLayoutCallback;
    private final View view;
    public OnGlobalLayoutListener(View view, Function0<Unit> onGlobalLayoutCallback) {
        super();
        this.view = view;
        this.onGlobalLayoutCallback = onGlobalLayoutCallback;
        this.view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        registerOnGlobalLayoutListener();
    }

    private final void registerOnGlobalLayoutListener() {
        boolean isListeningToGlobalLayout;
        if (!this.isListeningToGlobalLayout && !this.view.isAttachedToWindow()) {
            if (!this.view.isAttachedToWindow()) {
            }
            this.view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            this.isListeningToGlobalLayout = true;
        }
    }

    private final void unregisterOnGlobalLayoutListener() {
        if (!this.isListeningToGlobalLayout) {
        }
        this.view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        this.isListeningToGlobalLayout = false;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public final void dispose() {
        unregisterOnGlobalLayoutListener();
        this.view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onGlobalLayout() {
        this.onGlobalLayoutCallback.invoke();
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View p0) {
        registerOnGlobalLayoutListener();
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View p0) {
        unregisterOnGlobalLayoutListener();
    }
}
