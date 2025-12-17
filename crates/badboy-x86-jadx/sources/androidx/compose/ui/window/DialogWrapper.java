package androidx.compose.ui.window;

import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R.id;
import androidx.compose.ui.R.style;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0008\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008&¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\u00020\u00052\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006-", d2 = {"Landroidx/compose/ui/window/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;)V", "defaultSoftInputMode", "", "dialogLayout", "Landroidx/compose/ui/window/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "cancel", "disposeComposition", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {

    private final View composeView;
    private final int defaultSoftInputMode;
    private final androidx.compose.ui.window.DialogLayout dialogLayout;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private androidx.compose.ui.window.DialogProperties properties;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            DialogWrapper.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public DialogWrapper(Function0<Unit> onDismissRequest, androidx.compose.ui.window.DialogProperties properties, View composeView, LayoutDirection layoutDirection, Density density, UUID dialogId) {
        int floatingDialogWindowTheme;
        int decorFitsSystemWindows;
        int i;
        if (Build.VERSION.SDK_INT < 31) {
            if (properties.getDecorFitsSystemWindows()) {
                floatingDialogWindowTheme = R.style.DialogWindowTheme;
            } else {
                floatingDialogWindowTheme = R.style.FloatingDialogWindowTheme;
            }
        } else {
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(composeView.getContext(), floatingDialogWindowTheme);
        int i8 = 0;
        super((Context)contextThemeWrapper, i8, 2, 0);
        this.onDismissRequest = onDismissRequest;
        this.properties = properties;
        this.composeView = composeView;
        int i4 = 0;
        this.maxSupportedElevation = Dp.constructor-impl((float)i2);
        Window window = getWindow();
        if (window == null) {
        } else {
            this.defaultSoftInputMode = softInputMode &= 240;
            window.requestFeature(1);
            window.setBackgroundDrawableResource(17170445);
            WindowCompat.setDecorFitsSystemWindows(window, this.properties.getDecorFitsSystemWindows());
            DialogLayout dialogLayout = new DialogLayout(getContext(), window);
            androidx.compose.ui.window.DialogLayout dialogLayout6 = dialogLayout;
            int i10 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            dialogLayout6.setTag(R.id.compose_view_saveable_id_tag, stringBuilder.append("Dialog:").append(dialogId).toString());
            dialogLayout6.setClipChildren(i8);
            int i12 = 0;
            dialogLayout6.setElevation(density.toPx-0680j_4(this.maxSupportedElevation));
            DialogWrapper.1.2 $this$lambda_u241_u24lambda_u240 = new DialogWrapper.1.2();
            dialogLayout6.setOutlineProvider((ViewOutlineProvider)$this$lambda_u241_u24lambda_u240);
            this.dialogLayout = dialogLayout;
            View decorView = window.getDecorView();
            if (decorView instanceof ViewGroup) {
                i = decorView;
            }
            if (i != 0) {
                DialogWrapper._init_$disableClipping(i);
            }
            setContentView((View)this.dialogLayout);
            ViewTreeLifecycleOwner.set((View)this.dialogLayout, ViewTreeLifecycleOwner.get(this.composeView));
            ViewTreeViewModelStoreOwner.set((View)this.dialogLayout, ViewTreeViewModelStoreOwner.get(this.composeView));
            ViewTreeSavedStateRegistryOwner.set((View)this.dialogLayout, ViewTreeSavedStateRegistryOwner.get(this.composeView));
            updateParameters(this.onDismissRequest, this.properties, layoutDirection);
            DialogWrapper.2 anon = new DialogWrapper.2(this);
            OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), (LifecycleOwner)this, false, (Function1)anon, 2, 0);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Dialog has no window".toString());
        throw illegalStateException;
    }

    private static final void _init_$disableClipping(ViewGroup $this$_init__u24disableClipping) {
        int i;
        int childAt;
        boolean z;
        $this$_init__u24disableClipping.setClipChildren(false);
        if ($this$_init__u24disableClipping instanceof DialogLayout) {
        }
        i = 0;
        while (i < $this$_init__u24disableClipping.getChildCount()) {
            if (childAt instanceof ViewGroup) {
            } else {
            }
            childAt = 0;
            if (childAt != 0) {
            }
            i++;
            DialogWrapper._init_$disableClipping(childAt);
        }
    }

    public static final Function0 access$getOnDismissRequest$p(androidx.compose.ui.window.DialogWrapper $this) {
        return $this.onDismissRequest;
    }

    public static final androidx.compose.ui.window.DialogProperties access$getProperties$p(androidx.compose.ui.window.DialogWrapper $this) {
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

    private final void setSecurePolicy(androidx.compose.ui.window.SecureFlagPolicy securePolicy) {
        int i;
        final Window window = getWindow();
        Intrinsics.checkNotNull(window);
        final int i2 = 8192;
        i = SecureFlagPolicy_androidKt.shouldApplySecureFlag(securePolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView)) ? i2 : -8193;
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
        boolean dismissOnClickOutside;
        final boolean onTouchEvent = super.onTouchEvent(event);
        if (onTouchEvent && this.properties.getDismissOnClickOutside()) {
            if (this.properties.getDismissOnClickOutside()) {
                this.onDismissRequest.invoke();
            }
        }
        return onTouchEvent;
    }

    public final void setContent(CompositionContext parentComposition, Function2<? super Composer, ? super Integer, Unit> children) {
        this.dialogLayout.setContent(parentComposition, children);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest, androidx.compose.ui.window.DialogProperties properties, LayoutDirection layoutDirection) {
        boolean usePlatformDefaultWidth;
        int sDK_INT;
        int i;
        int defaultSoftInputMode;
        this.onDismissRequest = onDismissRequest;
        this.properties = properties;
        setSecurePolicy(properties.getSecurePolicy());
        setLayoutDirection(layoutDirection);
        usePlatformDefaultWidth = getWindow();
        if (properties.getUsePlatformDefaultWidth() && !this.dialogLayout.getUsePlatformDefaultWidth() && usePlatformDefaultWidth != null) {
            if (!this.dialogLayout.getUsePlatformDefaultWidth()) {
                usePlatformDefaultWidth = getWindow();
                if (usePlatformDefaultWidth != null) {
                    i = -2;
                    usePlatformDefaultWidth.setLayout(i, i);
                }
            }
        }
        this.dialogLayout.setUsePlatformDefaultWidth(properties.getUsePlatformDefaultWidth());
        if (Build.VERSION.SDK_INT < 31) {
            if (properties.getDecorFitsSystemWindows()) {
                sDK_INT = getWindow();
                if (sDK_INT != null) {
                    sDK_INT.setSoftInputMode(this.defaultSoftInputMode);
                }
            } else {
                sDK_INT = getWindow();
                if (sDK_INT != null) {
                    sDK_INT.setSoftInputMode(16);
                }
            }
        }
    }
}
