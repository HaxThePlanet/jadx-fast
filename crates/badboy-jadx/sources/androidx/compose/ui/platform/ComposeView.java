package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\r\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B%\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\r\u0010\u0015\u001a\u00020\u000cH\u0017¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u000c2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0002\u0008\r¢\u0006\u0002\u0010\u001aR!\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000b¢\u0006\u0002\u0008\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@RX\u0094\u000e¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u001b", d2 = {"Landroidx/compose/ui/platform/ComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "<set-?>", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "getAccessibilityClassName", "", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposeView extends androidx.compose.ui.platform.AbstractComposeView {

    public static final int $stable = 8;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    static {
        final int i = 8;
    }

    public ComposeView(Context context) {
        super(context, 0, 0, 6, 0);
    }

    public ComposeView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0, 4, 0);
    }

    public ComposeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int i = 0;
        this.content = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
    }

    public ComposeView(Context context, AttributeSet attributeSet2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(context, obj2, obj3);
    }

    protected static void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer $composer, int $changed) {
        int value;
        int traceInProgress;
        int $dirty;
        int i;
        int traceInProgress2;
        int str;
        traceInProgress = 420213850;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj5, "C(Content):ComposeView.android.kt#itgzvw");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(this) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:439)");
                }
                value = this.content.getValue();
                if ((Function2)value == null) {
                    obj5.startReplaceGroup(358373017);
                } else {
                    obj5.startReplaceGroup(150107752);
                    ComposerKt.sourceInformation(obj5, "440@18080L8");
                    (Function2)value.invoke(obj5, 0);
                }
                obj5.endReplaceGroup();
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
            traceInProgress2 = new ComposeView.Content.1(this, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public java.lang.CharSequence getAccessibilityClassName() {
        return (CharSequence)getClass().getName();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        this.shouldCreateCompositionOnAttachedToWindow = true;
        this.content.setValue(content);
        if (isAttachedToWindow()) {
            createComposition();
        }
    }
}
