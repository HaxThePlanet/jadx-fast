package androidx.compose.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.R.id;
import androidx.compose.ui.R.string;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B=\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\r\u0010P\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010QJ\u0008\u0010R\u001a\u00020)H\u0002J\u0006\u0010S\u001a\u00020\u0006J\u0010\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020VH\u0016J\u0008\u0010W\u001a\u00020\u0006H\u0016J\u0012\u0010X\u001a\u00020\u00132\u0008\u0010U\u001a\u0004\u0018\u00010YH\u0016J&\u0010\u001d\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0010\\J\u0010\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_H\u0016J\u0006\u0010`\u001a\u00020\u0006J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010^\u001a\u000201H\u0002J&\u0010b\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010^\u001a\u000201J\u0006\u0010c\u001a\u00020\u0006J\u000c\u0010d\u001a\u00020$*\u00020CH\u0002R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0008\u00198B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001f\u0010 \u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\"\u0010!\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00130\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u00020&X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010*\u001a\u0004\u0018\u00010$2\u0008\u0010\u0018\u001a\u0004\u0018\u00010$8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008/\u0010 \u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00082\u00103\"\u0004\u00084\u00105R5\u00107\u001a\u0004\u0018\u0001062\u0008\u0010\u0018\u001a\u0004\u0018\u0001068F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008<\u0010 \u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R\u001a\u0010=\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010?\"\u0004\u0008@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013@RX\u0094\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010\u0015R\u0014\u0010F\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008G\u0010HR\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u000e\u0010M\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006e", d2 = {"Landroidx/compose/material/internal/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onDismissRequest", "Lkotlin/Function0;", "", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;)V", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "dismissOnOutsideClick", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/IntRect;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "params", "Landroid/view/WindowManager$LayoutParams;", "parentBounds", "getParentBounds", "()Landroidx/compose/ui/unit/IntRect;", "setParentBounds", "(Landroidx/compose/ui/unit/IntRect;)V", "parentBounds$delegate", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "tmpWindowVisibleFrame", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createLayoutParams", "dismiss", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onGlobalLayout", "onTouchEvent", "Landroid/view/MotionEvent;", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "layoutDirection", "", "show", "superSetLayoutDirection", "updateParameters", "updatePosition", "toIntBounds", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {

    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final Function2<Offset, IntRect, Boolean> dismissOnOutsideClick;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private final MutableState parentBounds$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private String testTag;
    private final Rect tmpWindowVisibleFrame;
    private final WindowManager windowManager;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            PopupLayout.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public PopupLayout(Function0<Unit> onDismissRequest, String testTag, View composeView, Density density, PopupPositionProvider initialPositionProvider, UUID popupId) {
        final Object obj = this;
        super(composeView.getContext(), 0, 0, 6, 0);
        obj.onDismissRequest = onDismissRequest;
        obj.testTag = testTag;
        obj.composeView = composeView;
        Object systemService = obj.composeView.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        obj.windowManager = (WindowManager)systemService;
        obj.params = createLayoutParams();
        obj.positionProvider = initialPositionProvider;
        obj.parentLayoutDirection = LayoutDirection.Ltr;
        int i = 0;
        int i3 = 2;
        obj.parentBounds$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i3, i);
        obj.popupContentSize$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i3, i);
        PopupLayout.canCalculatePosition.2 anon = new PopupLayout.canCalculatePosition.2(this);
        obj.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf((Function0)anon);
        int i9 = 0;
        obj.maxSupportedElevation = Dp.constructor-impl((float)i5);
        Rect rect = new Rect();
        obj.previousWindowVisibleFrame = rect;
        Rect rect2 = new Rect();
        obj.tmpWindowVisibleFrame = rect2;
        obj.dismissOnOutsideClick = (Function2)PopupLayout.dismissOnOutsideClick.1.INSTANCE;
        setId(16908290);
        ViewTreeLifecycleOwner.set((View)obj, ViewTreeLifecycleOwner.get(obj.composeView));
        ViewTreeViewModelStoreOwner.set((View)obj, ViewTreeViewModelStoreOwner.get(obj.composeView));
        ViewTreeSavedStateRegistryOwner.set((View)obj, ViewTreeSavedStateRegistryOwner.get(obj.composeView));
        obj.composeView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)obj);
        StringBuilder stringBuilder = new StringBuilder();
        setTag(R.id.compose_view_saveable_id_tag, stringBuilder.append("Popup:").append(popupId).toString());
        setClipChildren(false);
        int i10 = 0;
        setElevation(density.toPx-0680j_4(obj.maxSupportedElevation));
        PopupLayout.2 $this$_init__u24lambda_u240 = new PopupLayout.2();
        setOutlineProvider((ViewOutlineProvider)$this$_init__u24lambda_u240);
        obj.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons.ExposedDropdownMenuPopup_androidKt.INSTANCE.getLambda-1$material_release(), i, i3, i);
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        final WindowManager.LayoutParams layoutParams2 = layoutParams;
        final int i = 0;
        layoutParams2.gravity = 8388659;
        layoutParams2.flags = 393248;
        layoutParams2.softInputMode = 1;
        layoutParams2.type = 1000;
        layoutParams2.token = this.composeView.getApplicationWindowToken();
        int i6 = -2;
        layoutParams2.width = i6;
        layoutParams2.height = i6;
        layoutParams2.format = -3;
        layoutParams2.setTitle((CharSequence)this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return layoutParams;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        final int i = 0;
        final int i2 = 0;
        return (Function2)(State)this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.content$delegate.setValue(<set-?>);
    }

    private final void superSetLayoutDirection(LayoutDirection layoutDirection) {
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
        super.setLayoutDirection(i);
    }

    private final IntRect toIntBounds(Rect $this$toIntBounds) {
        IntRect intRect = new IntRect($this$toIntBounds.left, $this$toIntBounds.top, $this$toIntBounds.right, $this$toIntBounds.bottom);
        return intRect;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i;
        int valueOf;
        boolean traceInProgress2;
        int str;
        traceInProgress = -864350873;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj5, "C(Content)302@11866L9:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(this) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.internal.PopupLayout.Content (ExposedDropdownMenuPopup.android.kt:301)");
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
            valueOf = new PopupLayout.Content.4(this, $changed);
            endRestartGroup.updateScope((Function2)valueOf);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void dismiss() {
        ViewTreeLifecycleOwner.set((View)this, 0);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        this.windowManager.removeViewImmediate((View)this);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean dispatchKeyEvent(KeyEvent event) {
        int repeatCount;
        int keyDispatcherState;
        int i;
        boolean tracking;
        if (event.getKeyCode() == 4 && getKeyDispatcherState() == null) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(event);
            }
            i = 1;
            KeyEvent.DispatcherState keyDispatcherState3 = getKeyDispatcherState();
            if (event.getAction() == 0 && event.getRepeatCount() == 0 && keyDispatcherState3 != null) {
                if (event.getRepeatCount() == 0) {
                    keyDispatcherState3 = getKeyDispatcherState();
                    if (keyDispatcherState3 != null) {
                        keyDispatcherState3.startTracking(event, this);
                    }
                    return i;
                }
            }
            keyDispatcherState = getKeyDispatcherState();
            Function0 onDismissRequest = this.onDismissRequest;
            if (event.getAction() == i && keyDispatcherState != null && keyDispatcherState.isTracking(event) && !event.isCanceled() && onDismissRequest != null) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    if (keyDispatcherState.isTracking(event)) {
                        if (!event.isCanceled()) {
                            onDismissRequest = this.onDismissRequest;
                            if (onDismissRequest != null) {
                                onDismissRequest.invoke();
                            }
                            return i;
                        }
                    }
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getCanCalculatePosition() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)this.canCalculatePosition$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final IntRect getParentBounds() {
        final int i = 0;
        final int i2 = 0;
        return (IntRect)(State)this.parentBounds$delegate.getValue();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final IntSize getPopupContentSize-bOM6tXw() {
        final int i = 0;
        final int i2 = 0;
        return (IntSize)(State)this.popupContentSize$delegate.getValue();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public AbstractComposeView getSubCompositionView() {
        return (AbstractComposeView)this;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final String getTestTag() {
        return this.testTag;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void onGlobalLayout() {
        this.composeView.getWindowVisibleDisplayFrame(this.tmpWindowVisibleFrame);
        if (!Intrinsics.areEqual(this.tmpWindowVisibleFrame, this.previousWindowVisibleFrame)) {
            updatePosition();
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean onTouchEvent(MotionEvent event) {
        int parentBounds;
        int booleanValue;
        int box-impl;
        int i;
        Function2 dismissOnOutsideClick;
        int rawY;
        int i2;
        long l;
        if (event == null) {
            return super.onTouchEvent(event);
        }
        booleanValue = 0;
        if (event.getAction() == 0) {
            if (Float.compare(f, booleanValue) >= 0 && Float.compare(f2, i) < 0 && Float.compare(f3, booleanValue) >= 0 && Float.compare(f4, i) < 0) {
                if (Float.compare(f2, i) < 0) {
                    if (Float.compare(f3, booleanValue) >= 0) {
                        if (Float.compare(f4, i) < 0) {
                            if (event.getAction() == 4) {
                                parentBounds = getParentBounds();
                                i = 1;
                                if (parentBounds != null) {
                                    i2 = 0;
                                    rawY = Float.compare(rawX2, booleanValue) == 0 ? i : i2;
                                    if (rawY == 0) {
                                        booleanValue = Float.compare(rawY, booleanValue) == 0 ? i : i2;
                                        if (booleanValue == 0) {
                                            box-impl = Offset.box-impl(OffsetKt.Offset(event.getRawX(), event.getRawY()));
                                        } else {
                                            box-impl = 0;
                                        }
                                    } else {
                                    }
                                    if ((Boolean)this.dismissOnOutsideClick.invoke(box-impl, parentBounds).booleanValue()) {
                                        i2 = i;
                                    }
                                } else {
                                }
                                Function0 onDismissRequest = this.onDismissRequest;
                                if (i2 != 0 && onDismissRequest != null) {
                                    onDismissRequest = this.onDismissRequest;
                                    if (onDismissRequest != null) {
                                        onDismissRequest.invoke();
                                    }
                                    return i;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return super.onTouchEvent(event);
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void setLayoutDirection(int layoutDirection) {
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void setParentBounds(IntRect <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.parentBounds$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void setParentLayoutDirection(LayoutDirection <set-?>) {
        this.parentLayoutDirection = <set-?>;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void setPopupContentSize-fhxjrPA(IntSize <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.popupContentSize$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void setPositionProvider(PopupPositionProvider <set-?>) {
        this.positionProvider = <set-?>;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void setTestTag(String <set-?>) {
        this.testTag = <set-?>;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void show() {
        this.windowManager.addView((View)this, (ViewGroup.LayoutParams)this.params);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest, String testTag, LayoutDirection layoutDirection) {
        this.onDismissRequest = onDismissRequest;
        this.testTag = testTag;
        superSetLayoutDirection(layoutDirection);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void updatePosition() {
        IntRect parentBounds = getParentBounds();
        if (parentBounds == null) {
        }
        IntSize popupContentSize-bOM6tXw = getPopupContentSize-bOM6tXw();
        if (popupContentSize-bOM6tXw != null) {
            Rect previousWindowVisibleFrame = this.previousWindowVisibleFrame;
            int i = 0;
            this.composeView.getWindowVisibleDisplayFrame(previousWindowVisibleFrame);
            IntRect intBounds = toIntBounds(previousWindowVisibleFrame);
            final int width = intBounds.getWidth();
            PopupPositionProvider positionProvider = this.positionProvider;
            long position-llwVHH4 = positionProvider.calculatePosition-llwVHH4(parentBounds, IntSizeKt.IntSize(width, intBounds.getHeight()), width, this.parentLayoutDirection);
            params.x = IntOffset.getX-impl(position-llwVHH4);
            params2.y = IntOffset.getY-impl(position-llwVHH4);
            this.windowManager.updateViewLayout((View)this, (ViewGroup.LayoutParams)this.params);
        }
    }
}
