package androidx.compose.ui.window;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.R.id;
import androidx.compose.ui.R.string;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0001\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\u0002\u0087\u0001BO\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\r\u0010a\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010bJ\u0008\u0010c\u001a\u000202H\u0002J\u0006\u0010d\u001a\u00020\u0005J\u0010\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020gH\u0016J5\u0010h\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020'2\u0006\u0010l\u001a\u00020'2\u0006\u0010m\u001a\u00020'H\u0010¢\u0006\u0002\u0008nJ\u001d\u0010o\u001a\u00020\u00052\u0006\u0010p\u001a\u00020'2\u0006\u0010q\u001a\u00020'H\u0010¢\u0006\u0002\u0008rJ\u0008\u0010s\u001a\u00020\u0005H\u0002J\u0008\u0010t\u001a\u00020\u0005H\u0002J\u0008\u0010u\u001a\u00020\u0005H\u0014J\u0008\u0010v\u001a\u00020\u0005H\u0014J\u0012\u0010w\u001a\u00020\u00182\u0008\u0010f\u001a\u0004\u0018\u00010xH\u0016J\u0006\u0010y\u001a\u00020\u0005J&\u0010\"\u001a\u00020\u00052\u0006\u0010z\u001a\u00020{2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008\u001e¢\u0006\u0002\u0010|J\u0010\u0010}\u001a\u00020\u00052\u0006\u0010~\u001a\u00020'H\u0016J\u0006\u0010\u007f\u001a\u00020\u0005J\u0011\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010~\u001a\u00020AH\u0002J/\u0010\u0081\u0001\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010~\u001a\u00020AJ\u000f\u0010\u0082\u0001\u001a\u00020\u0005H\u0001¢\u0006\u0003\u0008\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u0010:\u001a\u000209J\u0011\u0010\u0085\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0007\u0010\u0086\u0001\u001a\u00020\u0005R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008\u001e2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008\u001e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008$\u0010%\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010)R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008+\u0010)R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u00020/X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00100R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0002028\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00083\u00104\u001a\u0004\u00085\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010:\u001a\u0004\u0018\u0001092\u0008\u0010\u001d\u001a\u0004\u0018\u0001098B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008?\u0010%\u001a\u0004\u0008;\u0010<\"\u0004\u0008=\u0010>R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER5\u0010G\u001a\u0004\u0018\u00010F2\u0008\u0010\u001d\u001a\u0004\u0018\u00010F8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008L\u0010%\u001a\u0004\u0008H\u0010I\"\u0004\u0008J\u0010KR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010O\"\u0004\u0008P\u0010QR\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010T\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018@RX\u0094\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008U\u0010\u001aR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008Y\u0010ZR\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008[\u0010\\\"\u0004\u0008]\u0010^R\u000e\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0088\u0001", d2 = {"Landroidx/compose/ui/window/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/PopupProperties;", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "popupLayoutHelper", "Landroidx/compose/ui/window/PopupLayoutHelper;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;Landroidx/compose/ui/window/PopupLayoutHelper;)V", "backCallback", "", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "displayHeight", "", "getDisplayHeight", "()I", "displayWidth", "getDisplayWidth", "locationOnScreen", "", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "params", "Landroid/view/WindowManager$LayoutParams;", "getParams$ui_release$annotations", "()V", "getParams$ui_release", "()Landroid/view/WindowManager$LayoutParams;", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setParentLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "parentLayoutCoordinates$delegate", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createLayoutParams", "dismiss", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "Landroid/view/MotionEvent;", "pollForLocationOnScreenChange", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "layoutDirection", "show", "superSetLayoutDirection", "updateParameters", "updateParentBounds", "updateParentBounds$ui_release", "updateParentLayoutCoordinates", "updatePopupProperties", "updatePosition", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PopupLayout extends AbstractComposeView implements ViewRootForInspector {

    public static final int $stable = 8;
    private static final androidx.compose.ui.window.PopupLayout.Companion Companion;
    private static final Function1<androidx.compose.ui.window.PopupLayout, Unit> onCommitAffectingPopupPosition = 8;
    private Object backCallback;
    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final int[] locationOnScreen;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private IntRect parentBounds;
    private final MutableState parentLayoutCoordinates$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private final androidx.compose.ui.window.PopupLayoutHelper popupLayoutHelper;
    private androidx.compose.ui.window.PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private androidx.compose.ui.window.PopupProperties properties;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final SnapshotStateObserver snapshotStateObserver;
    private String testTag;
    private final WindowManager windowManager;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/ui/window/PopupLayout$Companion;", "", "()V", "onCommitAffectingPopupPosition", "Lkotlin/Function1;", "Landroidx/compose/ui/window/PopupLayout;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            PopupLayout.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        PopupLayout.Companion companion = new PopupLayout.Companion(0);
        PopupLayout.Companion = companion;
        int i = 8;
        androidx.compose.ui.window.PopupLayout.Companion.onCommitAffectingPopupPosition.1 iNSTANCE = PopupLayout.Companion.onCommitAffectingPopupPosition.1.INSTANCE;
    }

    public PopupLayout(Function0<Unit> onDismissRequest, androidx.compose.ui.window.PopupProperties properties, String testTag, View composeView, Density density, androidx.compose.ui.window.PopupPositionProvider initialPositionProvider, UUID popupId, androidx.compose.ui.window.PopupLayoutHelper popupLayoutHelper) {
        final Object obj = this;
        super(composeView.getContext(), 0, 0, 6, 0);
        obj.onDismissRequest = onDismissRequest;
        obj.properties = properties;
        obj.testTag = testTag;
        obj.composeView = composeView;
        obj.popupLayoutHelper = popupLayoutHelper;
        Object systemService = obj.composeView.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        obj.windowManager = (WindowManager)systemService;
        obj.params = createLayoutParams();
        obj.positionProvider = initialPositionProvider;
        obj.parentLayoutDirection = LayoutDirection.Ltr;
        int i = 0;
        int i3 = 2;
        obj.popupContentSize$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i3, i);
        obj.parentLayoutCoordinates$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i3, i);
        PopupLayout.canCalculatePosition.2 anon = new PopupLayout.canCalculatePosition.2(this);
        obj.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf((Function0)anon);
        int i9 = 0;
        obj.maxSupportedElevation = Dp.constructor-impl((float)i5);
        Rect rect = new Rect();
        obj.previousWindowVisibleFrame = rect;
        PopupLayout.snapshotStateObserver.1 anon2 = new PopupLayout.snapshotStateObserver.1(this);
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver((Function1)anon2);
        obj.snapshotStateObserver = snapshotStateObserver;
        setId(16908290);
        ViewTreeLifecycleOwner.set((View)obj, ViewTreeLifecycleOwner.get(obj.composeView));
        ViewTreeViewModelStoreOwner.set((View)obj, ViewTreeViewModelStoreOwner.get(obj.composeView));
        ViewTreeSavedStateRegistryOwner.set((View)obj, ViewTreeSavedStateRegistryOwner.get(obj.composeView));
        StringBuilder stringBuilder = new StringBuilder();
        setTag(R.id.compose_view_saveable_id_tag, stringBuilder.append("Popup:").append(popupId).toString());
        setClipChildren(false);
        int i10 = 0;
        setElevation(density.toPx-0680j_4(obj.maxSupportedElevation));
        PopupLayout.2 $this$_init__u24lambda_u240 = new PopupLayout.2();
        setOutlineProvider((ViewOutlineProvider)$this$_init__u24lambda_u240);
        obj.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons.AndroidPopup_androidKt.INSTANCE.getLambda-1$ui_release(), i, i3, i);
        obj.locationOnScreen = new int[i3];
    }

    public PopupLayout(Function0 function0, androidx.compose.ui.window.PopupProperties popupProperties2, String string3, View view4, Density density5, androidx.compose.ui.window.PopupPositionProvider popupPositionProvider6, UUID uUID7, androidx.compose.ui.window.PopupLayoutHelper popupLayoutHelper8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        androidx.compose.ui.window.PopupLayoutHelperImpl29 i;
        androidx.compose.ui.window.PopupLayoutHelperImpl29 popupLayoutHelperImpl29;
        if (i2 &= 128 != 0) {
            i = new PopupLayoutHelperImpl29();
            popupLayoutHelperImpl29 = i;
        } else {
            popupLayoutHelperImpl29 = popupLayoutHelper8;
        }
        super(function0, popupProperties2, string3, view4, density5, popupPositionProvider6, uUID7, popupLayoutHelperImpl29);
    }

    public static final LayoutCoordinates access$getParentLayoutCoordinates(androidx.compose.ui.window.PopupLayout $this) {
        return $this.getParentLayoutCoordinates();
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        final WindowManager.LayoutParams layoutParams2 = layoutParams;
        final int i = 0;
        layoutParams2.gravity = 8388659;
        layoutParams2.flags = AndroidPopup_androidKt.access$flagsWithSecureFlagInherited(this.properties, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        layoutParams2.type = 1002;
        layoutParams2.token = this.composeView.getApplicationWindowToken();
        int i5 = -2;
        layoutParams2.width = i5;
        layoutParams2.height = i5;
        layoutParams2.format = -3;
        layoutParams2.setTitle((CharSequence)this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return layoutParams;
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

    public static void getParams$ui_release$annotations() {
    }

    private final LayoutCoordinates getParentLayoutCoordinates() {
        final int i = 0;
        final int i2 = 0;
        return (LayoutCoordinates)(State)this.parentLayoutCoordinates$delegate.getValue();
    }

    private final void maybeRegisterBackCallback() {
        Object backCallback;
        boolean dismissOnBackPress;
        int i;
        if (this.properties.getDismissOnBackPress()) {
            if (Build.VERSION.SDK_INT < 33) {
            } else {
                if (this.backCallback == null) {
                    this.backCallback = Api33Impl.createBackCallback(this.onDismissRequest);
                }
            }
            Api33Impl.maybeRegisterBackCallback((View)this, this.backCallback);
        }
    }

    private final void maybeUnregisterBackCallback() {
        int sDK_INT;
        int backCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback((View)this, this.backCallback);
        }
        this.backCallback = 0;
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.content$delegate.setValue(<set-?>);
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.parentLayoutCoordinates$delegate.setValue(<set-?>);
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

    private final void updatePopupProperties(androidx.compose.ui.window.PopupProperties properties) {
        boolean usePlatformDefaultWidth;
        int i;
        if (Intrinsics.areEqual(this.properties, properties)) {
        }
        if (properties.getUsePlatformDefaultWidth() && !this.properties.getUsePlatformDefaultWidth()) {
            if (!this.properties.getUsePlatformDefaultWidth()) {
                i = -2;
                params.width = i;
                usePlatformDefaultWidth.height = i;
            }
        }
        this.properties = properties;
        params2.flags = AndroidPopup_androidKt.access$flagsWithSecureFlagInherited(properties, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        this.popupLayoutHelper.updateViewLayout(this.windowManager, (View)this, (ViewGroup.LayoutParams)this.params);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i;
        int valueOf;
        boolean traceInProgress2;
        int str;
        traceInProgress = -857613600;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj5, "C(Content)573@23861L9:AndroidPopup.android.kt#2oxthz");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(this) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:572)");
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
        this.windowManager.removeViewImmediate((View)this);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean dispatchKeyEvent(KeyEvent event) {
        int repeatCount;
        int dismissOnBackPress;
        int i;
        boolean tracking;
        if (event.getKeyCode() == 4 && this.properties.getDismissOnBackPress() && getKeyDispatcherState() == null) {
            if (this.properties.getDismissOnBackPress()) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(event);
                }
                i = 1;
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (event.getAction() == 0 && event.getRepeatCount() == 0 && keyDispatcherState2 != null) {
                    if (event.getRepeatCount() == 0) {
                        keyDispatcherState2 = getKeyDispatcherState();
                        if (keyDispatcherState2 != null) {
                            keyDispatcherState2.startTracking(event, this);
                        }
                        return i;
                    }
                }
                dismissOnBackPress = getKeyDispatcherState();
                Function0 onDismissRequest = this.onDismissRequest;
                if (event.getAction() == i && dismissOnBackPress != null && dismissOnBackPress.isTracking(event) && !event.isCanceled() && onDismissRequest != null) {
                    dismissOnBackPress = getKeyDispatcherState();
                    if (dismissOnBackPress != null) {
                        if (dismissOnBackPress.isTracking(event)) {
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
    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.params;
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
    public final androidx.compose.ui.window.PopupPositionProvider getPositionProvider() {
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
    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        boolean usePlatformDefaultWidth;
        androidx.compose.ui.window.PopupLayoutHelper popupLayoutHelper;
        WindowManager windowManager;
        Object obj;
        WindowManager.LayoutParams params;
        super.internalOnLayout$ui_release(changed, left, top, right, bottom);
        final int i = bottom;
        final int obj11 = right;
        final int obj10 = top;
        final int obj9 = left;
        final boolean obj8 = changed;
        final Object obj7 = this;
        usePlatformDefaultWidth = getChildAt(0);
        if (!obj7.properties.getUsePlatformDefaultWidth() && usePlatformDefaultWidth == null) {
            usePlatformDefaultWidth = getChildAt(0);
            if (usePlatformDefaultWidth == null) {
            }
            params2.width = usePlatformDefaultWidth.getMeasuredWidth();
            params3.height = usePlatformDefaultWidth.getMeasuredHeight();
            obj7.popupLayoutHelper.updateViewLayout(obj7.windowManager, (View)obj7, (ViewGroup.LayoutParams)obj7.params);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        boolean usePlatformDefaultWidth;
        int measureSpec;
        int displayHeight;
        if (this.properties.getUsePlatformDefaultWidth()) {
            super.internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
        } else {
            int i = Integer.MIN_VALUE;
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), i), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), i));
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.start();
        maybeRegisterBackCallback();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
        maybeUnregisterBackCallback();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean onTouchEvent(MotionEvent event) {
        int i;
        int action2;
        int action;
        float f;
        float f2;
        if (!this.properties.getDismissOnClickOutside()) {
            return super.onTouchEvent(event);
        }
        int i2 = 1;
        if (event != null && event.getAction() == 0) {
            action2 = event.getAction() == 0 ? i2 : i;
        } else {
        }
        if (action2 != 0) {
            f = 0;
            if (Float.compare(f3, f) >= 0 && Float.compare(f4, f2) < 0 && Float.compare(f5, f) >= 0) {
                if (Float.compare(f4, f2) < 0) {
                    if (Float.compare(f5, f) >= 0) {
                        Function0 onDismissRequest2 = this.onDismissRequest;
                        if (Float.compare(f6, f) >= 0 && onDismissRequest2 != null) {
                            onDismissRequest2 = this.onDismissRequest;
                            if (onDismissRequest2 != null) {
                                onDismissRequest2.invoke();
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i2;
        }
        if (event != null && event.getAction() == 4) {
            if (event.getAction() == 4) {
                i = i2;
            }
        }
        Function0 onDismissRequest = this.onDismissRequest;
        if (i != 0 && onDismissRequest != null) {
            onDismissRequest = this.onDismissRequest;
            if (onDismissRequest != null) {
                onDismissRequest.invoke();
            }
            return i2;
        }
        return super.onTouchEvent(event);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void pollForLocationOnScreenChange() {
        int i;
        int[] locationOnScreen = this.locationOnScreen;
        int i3 = 0;
        final int i5 = 1;
        this.composeView.getLocationOnScreen(this.locationOnScreen);
        if (locationOnScreen[i3] == this.locationOnScreen[i3]) {
            if (locationOnScreen[i5] != this.locationOnScreen[i5]) {
                updateParentBounds$ui_release();
            }
        } else {
        }
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
    public final void setPositionProvider(androidx.compose.ui.window.PopupPositionProvider <set-?>) {
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

    public final void updateParameters(Function0<Unit> onDismissRequest, androidx.compose.ui.window.PopupProperties properties, String testTag, LayoutDirection layoutDirection) {
        this.onDismissRequest = onDismissRequest;
        this.testTag = testTag;
        updatePopupProperties(properties);
        superSetLayoutDirection(layoutDirection);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void updateParentBounds$ui_release() {
        LayoutCoordinates parentLayoutCoordinates;
        boolean it;
        int i;
        parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (parentLayoutCoordinates.isAttached()) {
            } else {
                parentLayoutCoordinates = 0;
            }
            if (parentLayoutCoordinates == 0) {
            } else {
                final long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
                int i2 = 0;
                int i3 = 0;
                int $this$fastRoundToInt$iv2 = Math.round(Offset.getY-impl(positionInWindow));
                IntRect intRect = IntRectKt.IntRect-VbeCjmY(IntOffsetKt.IntOffset(Math.round(Offset.getX-impl(positionInWindow)), $this$fastRoundToInt$iv2), $this$fastRoundToInt$iv2);
                if (!Intrinsics.areEqual(intRect, this.parentBounds)) {
                    this.parentBounds = intRect;
                    updatePosition();
                }
            }
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void updateParentLayoutCoordinates(LayoutCoordinates parentLayoutCoordinates) {
        setParentLayoutCoordinates(parentLayoutCoordinates);
        updateParentBounds$ui_release();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void updatePosition() {
        boolean excludeFromSystemGesture;
        int y-impl;
        long width-impl;
        long height-impl;
        IntRect parentBounds = this.parentBounds;
        if (parentBounds == null) {
        }
        IntSize popupContentSize-bOM6tXw = getPopupContentSize-bOM6tXw();
        Rect previousWindowVisibleFrame = this.previousWindowVisibleFrame;
        int i = 0;
        this.popupLayoutHelper.getWindowVisibleDisplayFrame(this.composeView, previousWindowVisibleFrame);
        IntRect intRect = AndroidPopup_androidKt.access$toIntBounds(previousWindowVisibleFrame);
        long l = IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight());
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = IntOffset.Companion.getZero-nOcc-ac();
        Object obj = this;
        PopupLayout.updatePosition.1 anon = new PopupLayout.updatePosition.1(longRef, obj, parentBounds, l, obj6, popupContentSize-bOM6tXw.unbox-impl(), obj8);
        this.snapshotStateObserver.observeReads(this, PopupLayout.onCommitAffectingPopupPosition, (Function0)anon);
        params.x = IntOffset.getX-impl(longRef.element);
        params2.y = IntOffset.getY-impl(longRef.element);
        if (popupContentSize-bOM6tXw != null && obj.properties.getExcludeFromSystemGesture()) {
            previousWindowVisibleFrame = this.previousWindowVisibleFrame;
            i = 0;
            this.popupLayoutHelper.getWindowVisibleDisplayFrame(this.composeView, previousWindowVisibleFrame);
            intRect = AndroidPopup_androidKt.access$toIntBounds(previousWindowVisibleFrame);
            l = IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight());
            longRef = new Ref.LongRef();
            longRef.element = IntOffset.Companion.getZero-nOcc-ac();
            obj = this;
            anon = new PopupLayout.updatePosition.1(longRef, obj, intRect2, l, obj6, popupContentSize-bOM6tXw.unbox-impl(), obj8);
            this.snapshotStateObserver.observeReads(this, PopupLayout.onCommitAffectingPopupPosition, (Function0)anon);
            params.x = IntOffset.getX-impl(longRef.element);
            params2.y = IntOffset.getY-impl(longRef.element);
            if (obj.properties.getExcludeFromSystemGesture()) {
                obj.popupLayoutHelper.setGestureExclusionRects((View)obj, IntSize.getWidth-impl(l), IntSize.getHeight-impl(l));
            }
            obj.popupLayoutHelper.updateViewLayout(obj.windowManager, (View)obj, (ViewGroup.LayoutParams)obj.params);
        }
        Object obj2 = this;
    }
}
