package androidx.compose.ui.window;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010#\u001a\u00020\nH\u0017¢\u0006\u0002\u0010$J5\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008+J\u001d\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008/J&\u0010\u000f\u001a\u00020\n2\u0006\u00100\u001a\u0002012\u0011\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u00102RA\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000b2\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0008\u001a\u00020\u0019@RX\u0094\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001c\"\u0004\u0008\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u00063", d2 = {"Landroidx/compose/ui/window/DialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "(Landroid/content/Context;Landroid/view/Window;)V", "<set-?>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "displayHeight", "", "getDisplayHeight", "()I", "displayWidth", "getDisplayWidth", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "usePlatformDefaultWidth", "getUsePlatformDefaultWidth", "setUsePlatformDefaultWidth", "(Z)V", "getWindow", "()Landroid/view/Window;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DialogLayout extends AbstractComposeView implements androidx.compose.ui.window.DialogWindowProvider {

    private final MutableState content$delegate;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private boolean usePlatformDefaultWidth;
    private final Window window;
    public DialogLayout(Context context, Window window) {
        final int i = 0;
        final Object obj = this;
        super(context, i, 0, 6, 0);
        obj.window = window;
        obj.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons.AndroidDialog_androidKt.INSTANCE.getLambda-1$ui_release(), i, 2, i);
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        final int i = 0;
        final int i2 = 0;
        return (Function2)(State)this.content$delegate.getValue();
    }

    private final int getDisplayHeight() {
        final int i2 = 0;
        return Math.round(f *= density);
    }

    private final int getDisplayWidth() {
        final int i2 = 0;
        return Math.round(f *= density);
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.content$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i;
        int valueOf;
        boolean traceInProgress;
        int str;
        traceInProgress2 = 1735448596;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj5, "C(Content)281@11015L9:AndroidDialog.android.kt#2oxthz");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(this) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:280)");
                }
                getContent().invoke(obj5, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj5.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj5.endRestartGroup();
        if (endRestartGroup != null) {
            valueOf = new DialogLayout.Content.4(this, $changed);
            endRestartGroup.updateScope((Function2)valueOf);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public Window getWindow() {
        return this.window;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        boolean usePlatformDefaultWidth;
        Window window;
        int measuredWidth;
        int measuredHeight;
        super.internalOnLayout$ui_release(changed, left, top, right, bottom);
        final int i = bottom;
        final int obj10 = right;
        final int obj9 = top;
        final int obj8 = left;
        final boolean obj7 = changed;
        usePlatformDefaultWidth = getChildAt(0);
        if (!obj6.usePlatformDefaultWidth && usePlatformDefaultWidth == null) {
            usePlatformDefaultWidth = getChildAt(0);
            if (usePlatformDefaultWidth == null) {
            }
            getWindow().setLayout(usePlatformDefaultWidth.getMeasuredWidth(), usePlatformDefaultWidth.getMeasuredHeight());
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        boolean usePlatformDefaultWidth;
        int measureSpec;
        int displayHeight;
        if (this.usePlatformDefaultWidth) {
            super.internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
        } else {
            int i = Integer.MIN_VALUE;
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), i), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), i));
        }
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void setUsePlatformDefaultWidth(boolean <set-?>) {
        this.usePlatformDefaultWidth = <set-?>;
    }
}
