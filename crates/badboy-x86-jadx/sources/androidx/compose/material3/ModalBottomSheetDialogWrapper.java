package androidx.compose.material3;

import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R.id;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0008\u0010\"\u001a\u00020\u0005H\u0016J\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J&\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008+¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u000200H\u0002J$\u00101\u001a\u00020\u00052\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u00020\u001cX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001dR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00062", d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "darkThemeEnabled", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Z)V", "dialogLayout", "Landroidx/compose/material3/ModalBottomSheetDialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "cancel", "disposeComposition", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ModalBottomSheetDialogWrapper extends ComponentDialog implements ViewRootForInspector {

    private final View composeView;
    private final androidx.compose.material3.ModalBottomSheetDialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private androidx.compose.material3.ModalBottomSheetProperties properties;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            ModalBottomSheetDialogWrapper.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public ModalBottomSheetDialogWrapper(Function0<Unit> onDismissRequest, androidx.compose.material3.ModalBottomSheetProperties properties, View composeView, LayoutDirection layoutDirection, Density density, UUID dialogId, Animatable<Float, AnimationVector1D> predictiveBackProgress, CoroutineScope scope, boolean darkThemeEnabled) {
        final Object obj = this;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(composeView.getContext(), R.style.EdgeToEdgeFloatingDialogWindowTheme);
        int i3 = 0;
        super((Context)contextThemeWrapper, i3, 2, 0);
        obj.onDismissRequest = onDismissRequest;
        obj.properties = properties;
        obj.composeView = composeView;
        int i8 = 0;
        obj.maxSupportedElevation = Dp.constructor-impl((float)i4);
        Window window = obj.getWindow();
        if (window == null) {
        } else {
            final Window window2 = window;
            window2.requestFeature(1);
            window2.setBackgroundDrawableResource(17170445);
            WindowCompat.setDecorFitsSystemWindows(window2, i3);
            ModalBottomSheetDialogLayout modalBottomSheetDialogLayout2 = new ModalBottomSheetDialogLayout(obj.getContext(), window2, obj.properties.getShouldDismissOnBackPress(), obj.onDismissRequest, predictiveBackProgress, scope);
            androidx.compose.material3.ModalBottomSheetDialogLayout modalBottomSheetDialogLayout = modalBottomSheetDialogLayout2;
            int i9 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            modalBottomSheetDialogLayout.setTag(R.id.compose_view_saveable_id_tag, stringBuilder.append("Dialog:").append(dialogId).toString());
            modalBottomSheetDialogLayout.setClipChildren(i3);
            int i12 = 0;
            modalBottomSheetDialogLayout.setElevation(density.toPx-0680j_4(obj.maxSupportedElevation));
            ModalBottomSheetDialogWrapper.1.2 anon = new ModalBottomSheetDialogWrapper.1.2();
            modalBottomSheetDialogLayout.setOutlineProvider((ViewOutlineProvider)anon);
            obj.dialogLayout = modalBottomSheetDialogLayout2;
            obj.setContentView((View)obj.dialogLayout);
            ViewTreeLifecycleOwner.set((View)obj.dialogLayout, ViewTreeLifecycleOwner.get(obj.composeView));
            ViewTreeViewModelStoreOwner.set((View)obj.dialogLayout, ViewTreeViewModelStoreOwner.get(obj.composeView));
            ViewTreeSavedStateRegistryOwner.set((View)obj.dialogLayout, ViewTreeSavedStateRegistryOwner.get(obj.composeView));
            obj.updateParameters(obj.onDismissRequest, obj.properties, layoutDirection);
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window2, window2.getDecorView());
            int i7 = 0;
            insetsController.setAppearanceLightStatusBars(darkThemeEnabled ^ 1);
            insetsController.setAppearanceLightNavigationBars(darkThemeEnabled ^ 1);
            ModalBottomSheetDialogWrapper.3 anon2 = new ModalBottomSheetDialogWrapper.3(obj);
            OnBackPressedDispatcherKt.addCallback$default(obj.getOnBackPressedDispatcher(), (LifecycleOwner)obj, false, (Function1)anon2, 2, 0);
        }
        LayoutDirection layoutDirection3 = layoutDirection;
        Object obj4 = dialogId;
        IllegalStateException illegalStateException = new IllegalStateException("Dialog has no window".toString());
        throw illegalStateException;
    }

    public static final Function0 access$getOnDismissRequest$p(androidx.compose.material3.ModalBottomSheetDialogWrapper $this) {
        return $this.onDismissRequest;
    }

    public static final androidx.compose.material3.ModalBottomSheetProperties access$getProperties$p(androidx.compose.material3.ModalBottomSheetDialogWrapper $this) {
        return $this.properties;
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        int i;
        switch (i2) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        this.dialogLayout.setLayoutDirection(i);
    }

    private final void setSecurePolicy(SecureFlagPolicy securePolicy) {
        int i;
        final Window window = getWindow();
        Intrinsics.checkNotNull(window);
        final int i2 = 8192;
        i = ModalBottomSheet_androidKt.access$shouldApplySecureFlag(securePolicy, ModalBottomSheet_androidKt.isFlagSecureEnabled(this.composeView)) ? i2 : -8193;
        window.setFlags(i, i2);
    }

    @Override // androidx.activity.ComponentDialog
    public void cancel() {
    }

    @Override // androidx.activity.ComponentDialog
    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    @Override // androidx.activity.ComponentDialog
    public AbstractComposeView getSubCompositionView() {
        return (AbstractComposeView)this.dialogLayout;
    }

    @Override // androidx.activity.ComponentDialog
    public boolean onTouchEvent(MotionEvent event) {
        Function0 onDismissRequest;
        final boolean onTouchEvent = super.onTouchEvent(event);
        if (onTouchEvent) {
            this.onDismissRequest.invoke();
        }
        return onTouchEvent;
    }

    public final void setContent(CompositionContext parentComposition, Function2<? super Composer, ? super Integer, Unit> children) {
        this.dialogLayout.setContent(parentComposition, children);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest, androidx.compose.material3.ModalBottomSheetProperties properties, LayoutDirection layoutDirection) {
        int i2;
        int i;
        this.onDismissRequest = onDismissRequest;
        this.properties = properties;
        setSecurePolicy(properties.getSecurePolicy());
        setLayoutDirection(layoutDirection);
        Window window = getWindow();
        if (window != null) {
            i2 = -1;
            window.setLayout(i2, i2);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            i2 = Build.VERSION.SDK_INT >= 30 ? 48 : 16;
            window2.setSoftInputMode(i2);
        }
    }
}
