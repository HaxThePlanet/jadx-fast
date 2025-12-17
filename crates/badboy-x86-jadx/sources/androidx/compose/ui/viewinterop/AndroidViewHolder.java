package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0007\n\u0002\u0008\u001a\u0008\u0010\u0018\u0000 \u009a\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u009a\u0001B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0012\u0010\\\u001a\u00020\u001a2\u0008\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0008\u0010_\u001a\u00020`H\u0016J\u000e\u0010a\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`bJ\n\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0008\u0010e\u001a\u00020\nH\u0016J\u001e\u0010f\u001a\u0004\u0018\u00010g2\u0008\u0010*\u001a\u0004\u0018\u00010+2\u0008\u0010h\u001a\u0004\u0018\u00010iH\u0016J\u0006\u0010j\u001a\u000206J\u0008\u0010k\u001a\u00020\u001aH\u0016J \u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\nH\u0002J\u0008\u0010p\u001a\u000206H\u0014J\u0008\u0010q\u001a\u000206H\u0016J\u0018\u0010r\u001a\u0002062\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000eH\u0016J\u0008\u0010u\u001a\u000206H\u0014J0\u0010v\u001a\u0002062\u0006\u0010w\u001a\u00020\u001a2\u0006\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020\n2\u0006\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020\nH\u0014J\u0018\u0010|\u001a\u0002062\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0014J-\u0010\u007f\u001a\u00020\u001a2\u0006\u0010t\u001a\u00020\u000e2\u0008\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u001aH\u0016J%\u0010\u0084\u0001\u001a\u00020\u001a2\u0006\u0010t\u001a\u00020\u000e2\u0008\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0081\u0001H\u0016J5\u0010\u0085\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0083\u0001\u001a\u00020+2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0016J>\u0010\u0089\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u008a\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0016JG\u0010\u0089\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u008a\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0083\u0001\u001a\u00020+H\u0016J+\u0010\u008e\u0001\u001a\u0002062\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0016J\t\u0010\u0090\u0001\u001a\u000206H\u0016J\t\u0010\u0091\u0001\u001a\u000206H\u0016J+\u0010\u0092\u0001\u001a\u00020\u001a2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0016J\u001a\u0010\u0093\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u000e2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0094\u0001\u001a\u0002062\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0014J\u0007\u0010\u0096\u0001\u001a\u000206J\u0012\u0010\u0097\u0001\u001a\u0002062\u0007\u0010\u0098\u0001\u001a\u00020\u001aH\u0016J\t\u0010\u0099\u0001\u001a\u00020\u001aH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R(\u0010%\u001a\u0004\u0018\u00010$2\u0008\u0010\u0012\u001a\u0004\u0018\u00010$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010/\"\u0004\u00080\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000206\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u00108\"\u0004\u00089\u0010:R(\u0010;\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u000206\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u00108\"\u0004\u0008=\u0010:R(\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000206\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u00108\"\u0004\u0008@\u0010:R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010C\u001a\u0008\u0012\u0004\u0012\u0002060B2\u000c\u0010A\u001a\u0008\u0012\u0004\u0012\u0002060B@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010E\"\u0004\u0008F\u0010GR0\u0010H\u001a\u0008\u0012\u0004\u0012\u0002060B2\u000c\u0010A\u001a\u0008\u0012\u0004\u0012\u0002060B@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010E\"\u0004\u0008J\u0010GR\u0014\u0010K\u001a\u0008\u0012\u0004\u0012\u0002060BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u0008\u0012\u0004\u0012\u0002060BX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010N\u001a\u0004\u0018\u00010M2\u0008\u0010\u0012\u001a\u0004\u0018\u00010M@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010P\"\u0004\u0008Q\u0010RR\u0014\u0010S\u001a\u00020T8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008U\u0010VR0\u0010W\u001a\u0008\u0012\u0004\u0012\u0002060B2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002060B@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008X\u0010E\"\u0004\u0008Y\u0010GR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008Z\u0010[¨\u0006\u009b\u0001", d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/OwnerScope;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHash", "", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "view", "Landroid/view/View;", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;Landroidx/compose/ui/node/Owner;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "isDrawing", "isValidOwnerScope", "()Z", "lastHeightMeasureSpec", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onDensityChanged", "Lkotlin/Function1;", "", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "<set-?>", "Lkotlin/Function0;", "release", "getRelease", "()Lkotlin/jvm/functions/Function0;", "setRelease", "(Lkotlin/jvm/functions/Function0;)V", "reset", "getReset", "setReset", "runInvalidate", "runUpdate", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "update", "getUpdate", "setUpdate", "getView", "()Landroid/view/View;", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getAccessibilityClassName", "", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "invalidateOrDefer", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDeactivate", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onRelease", "onReuse", "onStartNestedScroll", "onStopNestedScroll", "onWindowVisibilityChanged", "visibility", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope {

    public static final int $stable = 8;
    public static final androidx.compose.ui.viewinterop.AndroidViewHolder.Companion Companion;
    private static final Function1<androidx.compose.ui.viewinterop.AndroidViewHolder, Unit> OnCommitAffectingUpdate = 8;
    private final int compositeKeyHash;
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private boolean isDrawing;
    private int lastHeightMeasureSpec = Integer.MIN_VALUE;
    private int lastWidthMeasureSpec = Integer.MIN_VALUE;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier = null;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private Function0<Unit> release = null;
    private Function0<Unit> reset = null;
    private final Function0<Unit> runInvalidate;
    private final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private Function0<Unit> update = null;
    private final View view;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder$Companion;", "", "()V", "OnCommitAffectingUpdate", "Lkotlin/Function1;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    public static void $r8$lambda$CDYlMSaQ0i2rQTpZsC6cOjKryZY(Function0 function0) {
        AndroidViewHolder.invalidateOrDefer$lambda$2(function0);
    }

    static {
        AndroidViewHolder.Companion companion = new AndroidViewHolder.Companion(0);
        AndroidViewHolder.Companion = companion;
        int i = 8;
        androidx.compose.ui.viewinterop.AndroidViewHolder.Companion.OnCommitAffectingUpdate.1 iNSTANCE = AndroidViewHolder.Companion.OnCommitAffectingUpdate.1.INSTANCE;
    }

    public AndroidViewHolder(Context context, CompositionContext parentContext, int compositeKeyHash, NestedScrollDispatcher dispatcher, View view, Owner owner) {
        CompositionContext context2;
        int i;
        Object obj;
        super(context);
        this.compositeKeyHash = compositeKeyHash;
        this.dispatcher = dispatcher;
        this.view = view;
        this.owner = owner;
        if (parentContext != null) {
            i = 0;
            WindowRecomposer_androidKt.setCompositionContext((View)this, parentContext);
        }
        int i2 = 0;
        setSaveFromParentEnabled(i2);
        addView(this.view);
        androidx.compose.ui.viewinterop.AndroidViewHolder.update.1 iNSTANCE = AndroidViewHolder.update.1.INSTANCE;
        androidx.compose.ui.viewinterop.AndroidViewHolder.reset.1 iNSTANCE2 = AndroidViewHolder.reset.1.INSTANCE;
        androidx.compose.ui.viewinterop.AndroidViewHolder.release.1 iNSTANCE3 = AndroidViewHolder.release.1.INSTANCE;
        androidx.compose.ui.Modifier.Companion companion2 = Modifier.Companion;
        int i7 = 2;
        int i8 = 0;
        this.density = DensityKt.Density$default(1065353216, 0, i7, i8);
        AndroidViewHolder.runUpdate.1 anon = new AndroidViewHolder.runUpdate.1(this);
        this.runUpdate = (Function0)anon;
        AndroidViewHolder.runInvalidate.1 anon2 = new AndroidViewHolder.runInvalidate.1(this);
        this.runInvalidate = (Function0)anon2;
        this.location = new int[i7];
        int i4 = Integer.MIN_VALUE;
        NestedScrollingParentHelper nestedScrollingParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        this.nestedScrollingParentHelper = nestedScrollingParentHelper;
        Object obj2 = this;
        int i6 = 0;
        LayoutNode layoutNode = new LayoutNode(i2, i2, 3, i8);
        layoutNode.setInteropViewFactoryHolder$ui_release(this);
        AndroidViewHolder.layoutNode.1.coreModifier.2 anon3 = new AndroidViewHolder.layoutNode.1.coreModifier.2(obj2, layoutNode, this);
        AndroidViewHolder.layoutNode.1.coreModifier.3 anon4 = new AndroidViewHolder.layoutNode.1.coreModifier.3(obj2, layoutNode);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll((Modifier)Modifier.Companion, (NestedScrollConnection)AndroidViewHolder_androidKt.access$getNoOpScrollConnection$p(), obj2.dispatcher), true, (Function1)AndroidViewHolder.layoutNode.1.coreModifier.1.INSTANCE), (AndroidViewHolder)obj2), (Function1)anon3), (Function1)anon4);
        layoutNode.setCompositeKeyHash(obj2.compositeKeyHash);
        layoutNode.setModifier(obj2.modifier.then(onGloballyPositioned));
        AndroidViewHolder.layoutNode.1.1 anon5 = new AndroidViewHolder.layoutNode.1.1(layoutNode, onGloballyPositioned);
        obj2.onModifierChanged = (Function1)anon5;
        layoutNode.setDensity(obj2.density);
        AndroidViewHolder.layoutNode.1.2 anon6 = new AndroidViewHolder.layoutNode.1.2(layoutNode);
        obj2.onDensityChanged = (Function1)anon6;
        AndroidViewHolder.layoutNode.1.3 anon7 = new AndroidViewHolder.layoutNode.1.3(obj2, layoutNode);
        layoutNode.setOnAttach$ui_release((Function1)anon7);
        AndroidViewHolder.layoutNode.1.4 anon8 = new AndroidViewHolder.layoutNode.1.4(obj2);
        layoutNode.setOnDetach$ui_release((Function1)anon8);
        AndroidViewHolder.layoutNode.1.5 anon9 = new AndroidViewHolder.layoutNode.1.5(obj2, layoutNode);
        layoutNode.setMeasurePolicy((MeasurePolicy)anon9);
        this.layoutNode = layoutNode;
    }

    public static final NestedScrollDispatcher access$getDispatcher$p(androidx.compose.ui.viewinterop.AndroidViewHolder $this) {
        return $this.dispatcher;
    }

    public static final boolean access$getHasUpdateBlock$p(androidx.compose.ui.viewinterop.AndroidViewHolder $this) {
        return $this.hasUpdateBlock;
    }

    public static final Function1 access$getOnCommitAffectingUpdate$cp() {
        return AndroidViewHolder.OnCommitAffectingUpdate;
    }

    public static final Owner access$getOwner$p(androidx.compose.ui.viewinterop.AndroidViewHolder $this) {
        return $this.owner;
    }

    public static final Function0 access$getRunUpdate$p(androidx.compose.ui.viewinterop.AndroidViewHolder $this) {
        return $this.runUpdate;
    }

    public static final OwnerSnapshotObserver access$getSnapshotObserver(androidx.compose.ui.viewinterop.AndroidViewHolder $this) {
        return $this.getSnapshotObserver();
    }

    public static final int access$obtainMeasureSpec(androidx.compose.ui.viewinterop.AndroidViewHolder $this, int min, int max, int preferred) {
        return $this.obtainMeasureSpec(min, max, preferred);
    }

    public static final void access$setDrawing$p(androidx.compose.ui.viewinterop.AndroidViewHolder $this, boolean <set-?>) {
        $this.isDrawing = <set-?>;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        String $i$a$CheckPreconditionAndroidViewHolder$snapshotObserver$1;
        final int i = 0;
        if (!isAttachedToWindow()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.owner.getSnapshotObserver();
    }

    private static final void invalidateOrDefer$lambda$2(Function0 $tmp0) {
        $tmp0.invoke();
    }

    private final int obtainMeasureSpec(int min, int max, int preferred) {
        int measureSpec;
        int coerceIn;
        int i;
        int i2 = 1073741824;
        if (preferred < 0) {
            if (min == max) {
                measureSpec = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(preferred, min, max), i2);
            } else {
                i = Integer.MAX_VALUE;
                if (preferred == -2 && max != i) {
                    if (max != i) {
                        measureSpec = View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
                    } else {
                        if (preferred == -1 && max != i) {
                            if (max != i) {
                                measureSpec = View.MeasureSpec.makeMeasureSpec(max, i2);
                            } else {
                                int i3 = 0;
                                measureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return measureSpec;
    }

    @Override // android.view.ViewGroup
    public boolean gatherTransparentRegion(Region region) {
        final int i = 1;
        if (region == null) {
            return i;
        }
        getLocationInWindow(this.location);
        int i4 = 0;
        region.op(this.location[i4], this.location[i], i2 + width, i3 + height, Region.Op.DIFFERENCE);
        return i;
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getAccessibilityClassName() {
        return (CharSequence)getClass().getName();
    }

    @Override // android.view.ViewGroup
    public final Density getDensity() {
        return this.density;
    }

    @Override // android.view.ViewGroup
    public final View getInteropView() {
        return this.view;
    }

    @Override // android.view.ViewGroup
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        int i;
        if (this.view.getLayoutParams() == null) {
            i = -1;
            layoutParams = new ViewGroup.LayoutParams(i, i);
        }
        return layoutParams;
    }

    @Override // android.view.ViewGroup
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @Override // android.view.ViewGroup
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final Function0<Unit> getRelease() {
        return this.release;
    }

    public final Function0<Unit> getReset() {
        return this.reset;
    }

    @Override // android.view.ViewGroup
    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    @Override // android.view.ViewGroup
    public final View getView() {
        return this.view;
    }

    @Override // android.view.ViewGroup
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        super.invalidateChildInParent(location, dirty);
        invalidateOrDefer();
        return null;
    }

    @Override // android.view.ViewGroup
    public final void invalidateOrDefer() {
        Object layoutNode;
        Function0 runInvalidate;
        androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        if (this.isDrawing) {
            externalSyntheticLambda0 = new AndroidViewHolder$$ExternalSyntheticLambda0(this.runInvalidate);
            this.view.postOnAnimation(externalSyntheticLambda0);
        } else {
            this.layoutNode.invalidateLayer$ui_release();
        }
    }

    @Override // android.view.ViewGroup
    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup
    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void onDescendantInvalidated(View child, View target) {
        super.onDescendantInvalidated(child, target);
        invalidateOrDefer();
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().clear$ui_release(this);
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int i3 = 0;
        this.view.layout(i3, i3, r - l, b - t);
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        }
        if (this.view.getVisibility() == 8) {
            int i = 0;
            setMeasuredDimension(i, i);
        }
        this.view.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = widthMeasureSpec;
        this.lastHeightMeasureSpec = heightMeasureSpec;
    }

    @Override // android.view.ViewGroup
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        final int i = 0;
        if (!isNestedScrollingEnabled()) {
            return i;
        }
        AndroidViewHolder.onNestedFling.1 anon = new AndroidViewHolder.onNestedFling.1(consumed, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(velocityX), AndroidViewHolder_androidKt.access$toComposeVelocity(velocityY)), obj7, 0);
        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
        return i;
    }

    @Override // android.view.ViewGroup
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        final int i = 0;
        if (!isNestedScrollingEnabled()) {
            return i;
        }
        final int i2 = 0;
        AndroidViewHolder.onNestedPreFling.1 anon = new AndroidViewHolder.onNestedPreFling.1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(velocityX), AndroidViewHolder_androidKt.access$toComposeVelocity(velocityY)), obj3, i2);
        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), i2, 0, (Function2)anon, 3, 0);
        return i;
    }

    @Override // android.view.ViewGroup
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        if (!isNestedScrollingEnabled()) {
        }
        float f2 = AndroidViewHolder_androidKt.access$toComposeOffset(dy);
        long l = OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(dx), f2);
        long dispatchPreScroll-OzD1aCk = this.dispatcher.dispatchPreScroll-OzD1aCk(l, f2);
        consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getX-impl(dispatchPreScroll-OzD1aCk));
        consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getY-impl(dispatchPreScroll-OzD1aCk));
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (!isNestedScrollingEnabled()) {
        }
        this.dispatcher.dispatchPostScroll-DzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(dxConsumed), AndroidViewHolder_androidKt.access$toComposeOffset(dyConsumed)), obj3, OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(dxUnconsumed), AndroidViewHolder_androidKt.access$toComposeOffset(dyUnconsumed)));
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (!isNestedScrollingEnabled()) {
        }
        final NestedScrollDispatcher dispatcher = this.dispatcher;
        long dispatchPostScroll-DzOQY0M = dispatcher.dispatchPostScroll-DzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(dxConsumed), AndroidViewHolder_androidKt.access$toComposeOffset(dyConsumed)), obj3, OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(dxUnconsumed), AndroidViewHolder_androidKt.access$toComposeOffset(dyUnconsumed)));
        consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getX-impl(dispatchPostScroll-DzOQY0M));
        consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getY-impl(dispatchPostScroll-DzOQY0M));
    }

    @Override // android.view.ViewGroup
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // android.view.ViewGroup
    public void onRelease() {
        this.release.invoke();
    }

    @Override // android.view.ViewGroup
    public void onReuse() {
        Object reset;
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        int i;
        int i2;
        if (axes & 2 == 0) {
            if (axes & 1 != 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public void onStopNestedScroll(View target, int type) {
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    @Override // android.view.ViewGroup
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    @Override // android.view.ViewGroup
    public final void remeasure() {
        int lastWidthMeasureSpec;
        int i = Integer.MIN_VALUE;
        if (this.lastWidthMeasureSpec != i && this.lastHeightMeasureSpec == i) {
            if (this.lastHeightMeasureSpec == i) {
            }
            measure(this.lastWidthMeasureSpec, this.lastHeightMeasureSpec);
        }
    }

    @Override // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Boolean valueOf;
        final Function1 onRequestDisallowInterceptTouchEvent = this.onRequestDisallowInterceptTouchEvent;
        if (onRequestDisallowInterceptTouchEvent != null) {
            onRequestDisallowInterceptTouchEvent.invoke(Boolean.valueOf(disallowIntercept));
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.view.ViewGroup
    public final void setDensity(Density value) {
        Object onDensityChanged;
        this.density = value;
        onDensityChanged = this.onDensityChanged;
        if (value != this.density && onDensityChanged != null) {
            this.density = value;
            onDensityChanged = this.onDensityChanged;
            if (onDensityChanged != null) {
                onDensityChanged.invoke(value);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void setLifecycleOwner(LifecycleOwner value) {
        Object lifecycleOwner;
        if (value != this.lifecycleOwner) {
            this.lifecycleOwner = value;
            ViewTreeLifecycleOwner.set((View)this, value);
        }
    }

    @Override // android.view.ViewGroup
    public final void setModifier(Modifier value) {
        Object onModifierChanged;
        this.modifier = value;
        onModifierChanged = this.onModifierChanged;
        if (value != this.modifier && onModifierChanged != null) {
            this.modifier = value;
            onModifierChanged = this.onModifierChanged;
            if (onModifierChanged != null) {
                onModifierChanged.invoke(value);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> <set-?>) {
        this.onDensityChanged = <set-?>;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> <set-?>) {
        this.onModifierChanged = <set-?>;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> <set-?>) {
        this.onRequestDisallowInterceptTouchEvent = <set-?>;
    }

    protected final void setRelease(Function0<Unit> <set-?>) {
        this.release = <set-?>;
    }

    protected final void setReset(Function0<Unit> <set-?>) {
        this.reset = <set-?>;
    }

    @Override // android.view.ViewGroup
    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner value) {
        Object savedStateRegistryOwner;
        if (value != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = value;
            ViewTreeSavedStateRegistryOwner.set((View)this, value);
        }
    }

    protected final void setUpdate(Function0<Unit> value) {
        this.update = value;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 1;
    }
}
