package androidx.compose.material3;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002-.BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\r\u0010$\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010%J\u0008\u0010&\u001a\u00020\u000bH\u0002J\u0008\u0010'\u001a\u00020\u000bH\u0002J\u0008\u0010(\u001a\u00020\u000bH\u0014J\u0008\u0010)\u001a\u00020\u000bH\u0014J&\u0010\u001a\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0010,R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000RA\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0008\u00162\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0008\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u0008@RX\u0094\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u0006/", d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "shouldDismissOnBackPress", "", "onDismissRequest", "Lkotlin/Function0;", "", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Landroid/view/Window;ZLkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;)V", "backCallback", "", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "getShouldDismissOnBackPress", "getWindow", "()Landroid/view/Window;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "onAttachedToWindow", "onDetachedFromWindow", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Api33Impl", "Api34Impl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ModalBottomSheetDialogLayout extends AbstractComposeView implements DialogWindowProvider {

    private Object backCallback;
    private final MutableState content$delegate;
    private final Function0<Unit> onDismissRequest;
    private final Animatable<Float, AnimationVector1D> predictiveBackProgress;
    private final CoroutineScope scope;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final boolean shouldDismissOnBackPress;
    private final Window window;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u000c\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r", d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout$Api33Impl;", "", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api33Impl {

        public static final androidx.compose.material3.ModalBottomSheetDialogLayout.Api33Impl INSTANCE;
        public static void $r8$lambda$J7jBSJk1SbYX5oOGgmqmloYqatw(Function0 function0) {
            ModalBottomSheetDialogLayout.Api33Impl.createBackCallback$lambda$0(function0);
        }

        static {
            ModalBottomSheetDialogLayout.Api33Impl api33Impl = new ModalBottomSheetDialogLayout.Api33Impl();
            ModalBottomSheetDialogLayout.Api33Impl.INSTANCE = api33Impl;
        }

        @JvmStatic
        public static final OnBackInvokedCallback createBackCallback(Function0<Unit> onDismissRequest) {
            ModalBottomSheetDialogLayout.Api33Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ModalBottomSheetDialogLayout.Api33Impl$$ExternalSyntheticLambda0(onDismissRequest);
            return externalSyntheticLambda0;
        }

        private static final void createBackCallback$lambda$0(Function0 $tmp0) {
            $tmp0.invoke();
        }

        @JvmStatic
        public static final void maybeRegisterBackCallback(View view, Object backCallback) {
            boolean onBackInvokedDispatcher;
            Object obj;
            int i;
            onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (backCallback instanceof OnBackInvokedCallback != null && onBackInvokedDispatcher != null) {
                onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
                if (onBackInvokedDispatcher != null) {
                    onBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback)backCallback);
                }
            }
        }

        @JvmStatic
        public static final void maybeUnregisterBackCallback(View view, Object backCallback) {
            boolean onBackInvokedDispatcher;
            Object obj;
            onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (backCallback instanceof OnBackInvokedCallback != null && onBackInvokedDispatcher != null) {
                onBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
                if (onBackInvokedDispatcher != null) {
                    onBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback)backCallback);
                }
            }
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000c\u001a\u00020\rH\u0007¨\u0006\u000e", d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout$Api34Impl;", "", "()V", "createBackCallback", "Landroid/window/OnBackAnimationCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api34Impl {

        public static final androidx.compose.material3.ModalBottomSheetDialogLayout.Api34Impl INSTANCE;
        static {
            ModalBottomSheetDialogLayout.Api34Impl api34Impl = new ModalBottomSheetDialogLayout.Api34Impl();
            ModalBottomSheetDialogLayout.Api34Impl.INSTANCE = api34Impl;
        }

        @JvmStatic
        public static final OnBackAnimationCallback createBackCallback(Function0<Unit> onDismissRequest, Animatable<Float, AnimationVector1D> predictiveBackProgress, CoroutineScope scope) {
            ModalBottomSheetDialogLayout.Api34Impl.createBackCallback.1 anon = new ModalBottomSheetDialogLayout.Api34Impl.createBackCallback.1(scope, predictiveBackProgress, onDismissRequest);
            return (OnBackAnimationCallback)anon;
        }
    }
    public ModalBottomSheetDialogLayout(Context context, Window window, boolean shouldDismissOnBackPress, Function0<Unit> onDismissRequest, Animatable<Float, AnimationVector1D> predictiveBackProgress, CoroutineScope scope) {
        final int i = 0;
        final Object obj = this;
        super(context, i, 0, 6, 0);
        obj.window = window;
        obj.shouldDismissOnBackPress = shouldDismissOnBackPress;
        obj.onDismissRequest = onDismissRequest;
        obj.predictiveBackProgress = predictiveBackProgress;
        obj.scope = scope;
        obj.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons.ModalBottomSheet_androidKt.INSTANCE.getLambda-2$material3_release(), i, 2, i);
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        final int i = 0;
        final int i2 = 0;
        return (Function2)(State)this.content$delegate.getValue();
    }

    private final void maybeRegisterBackCallback() {
        boolean shouldDismissOnBackPress;
        Object backCallback;
        int predictiveBackProgress;
        CoroutineScope scope;
        if (this.shouldDismissOnBackPress) {
            if (Build.VERSION.SDK_INT < 33) {
            } else {
                if (this.backCallback == null) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        backCallback = ModalBottomSheetDialogLayout.Api34Impl.createBackCallback(this.onDismissRequest, this.predictiveBackProgress, this.scope);
                    } else {
                        backCallback = ModalBottomSheetDialogLayout.Api33Impl.createBackCallback(this.onDismissRequest);
                    }
                    this.backCallback = backCallback;
                }
            }
            ModalBottomSheetDialogLayout.Api33Impl.maybeRegisterBackCallback((View)this, this.backCallback);
        }
    }

    private final void maybeUnregisterBackCallback() {
        int sDK_INT;
        int backCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            ModalBottomSheetDialogLayout.Api33Impl.maybeUnregisterBackCallback((View)this, this.backCallback);
        }
        this.backCallback = 0;
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
        traceInProgress2 = 576708319;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj5, "C(Content)353@14383L9:ModalBottomSheet.android.kt#uh7d8r");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(this) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.ModalBottomSheetDialogLayout.Content (ModalBottomSheet.android.kt:352)");
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
            valueOf = new ModalBottomSheetDialogLayout.Content.4(this, $changed);
            endRestartGroup.updateScope((Function2)valueOf);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public Window getWindow() {
        return this.window;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeRegisterBackCallback();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeUnregisterBackCallback();
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }
}
