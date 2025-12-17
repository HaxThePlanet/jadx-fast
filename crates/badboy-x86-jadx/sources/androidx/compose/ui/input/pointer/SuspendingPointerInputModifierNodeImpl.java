package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001PB\\\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012'\u0010\n\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0010\u000fJ=\u0010:\u001a\u0002H;\"\u0004\u0008\u0000\u0010;2'\u0010<\u001a#\u0008\u0001\u0012\u0004\u0012\u00020=\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H;0\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\u0008\u000eH\u0096@¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020BH\u0002J-\u0010C\u001a\u00020\r2\u0006\u0010A\u001a\u00020B2\u001a\u0010<\u001a\u0016\u0012\u000c\u0012\n\u0012\u0002\u0008\u00030\u001dR\u00020\u0000\u0012\u0004\u0012\u00020\r0DH\u0082\u0008J\u0008\u0010E\u001a\u00020\rH\u0016J\u0008\u0010F\u001a\u00020\rH\u0016J\u0008\u0010G\u001a\u00020\rH\u0016J*\u0010H\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\u0008J\u0010KJ\u0008\u0010L\u001a\u00020\rH\u0016J\u0008\u0010M\u001a\u00020\rH\u0016J`\u0010N\u001a\u00020\r2\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0008\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2'\u0010\n\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\u0008\u000eH\u0000¢\u0006\u0004\u0008O\u0010\u000fR1\u0010\u0010\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\u0008\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u0013X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u00030\u001dR\u00020\u00000\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0014\u0010\"\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010\u001aR\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0008\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\u000c\u0012\n\u0012\u0002\u0008\u00030\u001dR\u00020\u00000\u001cX\u0082\u0004¢\u0006\u0002\n\u0000Rf\u0010\n\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\u0008\u000e2'\u0010-\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0002\u0008\u000e8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008.\u0010/\"\u0004\u00080\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00085\u0010!R\u0014\u00106\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00088\u00109\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "key1", "", "key2", "keys", "", "pointerInputHandler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "_pointerInputHandler", "Lkotlin/jvm/functions/Function2;", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "[Ljava/lang/Object;", "lastPointerEvent", "pointerHandlers", "value", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "pointerInputJob", "Lkotlinx/coroutines/Job;", "size", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancelPointerInput", "onDensityChange", "onDetach", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onViewConfigurationChange", "resetPointerInputHandler", "update", "update$ui_release", "PointerEventHandlerCoroutine", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode, androidx.compose.ui.input.pointer.PointerInputScope, Density {

    public static final int $stable;
    private Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> _pointerInputHandler;
    private long boundsSize;
    private androidx.compose.ui.input.pointer.PointerEvent currentEvent;
    private final MutableVector<androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private Object key1;
    private Object key2;
    private Object[] keys;
    private androidx.compose.ui.input.pointer.PointerEvent lastPointerEvent;
    private final MutableVector<androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<?>> pointerHandlers;
    private Job pointerInputJob;

    @Metadata(d1 = "\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0082\u0004\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0008H\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0008\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0008J\u001b\u0010-\u001a\u00020(2\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0002\u00100JE\u00101\u001a\u0002H2\"\u0004\u0008\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\u00088H\u0096@¢\u0006\u0002\u00109JG\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\u0008\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\u00088H\u0096@¢\u0006\u0002\u00109J\u0017\u0010;\u001a\u00020<*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u0017\u0010;\u001a\u00020<*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\u0017\u0010C\u001a\u00020=*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u001a\u0010C\u001a\u00020=*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GJ\u001a\u0010C\u001a\u00020=*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008F\u0010HJ\u0017\u0010I\u001a\u00020J*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u0017\u0010M\u001a\u00020\u0012*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008N\u0010GJ\u0017\u0010M\u001a\u00020\u0012*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008O\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020\u0016*\u00020JH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008T\u0010LJ\u0017\u0010U\u001a\u00020@*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008V\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008X\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Z", d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", "event", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class PointerEventHandlerCoroutine implements androidx.compose.ui.input.pointer.AwaitPointerEventScope, Density, Continuation<R> {

        private final androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl $$delegate_0;
        private androidx.compose.ui.input.pointer.PointerEventPass awaitPass;
        private final Continuation<R> completion;
        private final CoroutineContext context;
        private CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> pointerAwaiter;
        final androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl this$0;
        public PointerEventHandlerCoroutine(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl this$0, Continuation completion) {
            this.this$0 = this$0;
            super();
            this.completion = completion;
            this.$$delegate_0 = this.this$0;
            this.awaitPass = PointerEventPass.Main;
            this.context = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }

        public static final CancellableContinuation access$getPointerAwaiter$p(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine $this) {
            return $this.pointerAwaiter;
        }

        public static final void access$setAwaitPass$p(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine $this, androidx.compose.ui.input.pointer.PointerEventPass <set-?>) {
            $this.awaitPass = <set-?>;
        }

        public static final void access$setPointerAwaiter$p(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine $this, CancellableContinuation <set-?>) {
            $this.pointerAwaiter = <set-?>;
        }

        public Object awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass pass, Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> $completion) {
            final int i = 0;
            int i2 = 0;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellableContinuationImpl.initCancellability();
            int i4 = 0;
            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.access$setAwaitPass$p(this, pass);
            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.access$setPointerAwaiter$p(this, (CancellableContinuation)cancellableContinuationImpl);
            Object uCont$iv = cancellableContinuationImpl.getResult();
            if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return uCont$iv;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public final void cancel(Throwable cause) {
            CancellableContinuation pointerAwaiter = this.pointerAwaiter;
            if (pointerAwaiter != null) {
                pointerAwaiter.cancel(cause);
            }
            this.pointerAwaiter = 0;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public androidx.compose.ui.input.pointer.PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.access$getCurrentEvent$p(this.this$0);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long getExtendedTouchPadding-NH-jbRc() {
            return this.this$0.getExtendedTouchPadding-NH-jbRc();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long getSize-YbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.access$getBoundsSize$p(this.this$0);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public final void offerPointerEvent(androidx.compose.ui.input.pointer.PointerEvent event, androidx.compose.ui.input.pointer.PointerEventPass pass) {
            Object pointerAwaiter;
            int i;
            CancellableContinuation cancellableContinuation;
            Object constructor-impl;
            pointerAwaiter = this.pointerAwaiter;
            if (pass == this.awaitPass && pointerAwaiter != null) {
                pointerAwaiter = this.pointerAwaiter;
                if (pointerAwaiter != null) {
                    i = 0;
                    this.pointerAwaiter = 0;
                    kotlin.Result.Companion companion = Result.Companion;
                    (Continuation)pointerAwaiter.resumeWith(Result.constructor-impl(event));
                }
            }
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public void resumeWith(Object result) {
            MutableVector mutableVector = SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this.this$0);
            final int i = 0;
            final int i2 = 0;
            final int i3 = 0;
            SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this.this$0).remove(this);
            Unit iNSTANCE = Unit.INSTANCE;
            this.completion.resumeWith(result);
            return;
            synchronized (mutableVector) {
                mutableVector = SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this.this$0);
                i = 0;
                i2 = 0;
                i3 = 0;
                SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this.this$0).remove(this);
                iNSTANCE = Unit.INSTANCE;
                this.completion.resumeWith(result);
            }
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public int roundToPx--R2X_6o(long l) {
            return this.$$delegate_0.roundToPx--R2X_6o(l);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public int roundToPx-0680j_4(float f) {
            return this.$$delegate_0.roundToPx-0680j_4(f);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float toDp-GaN1DYA(long l) {
            return this.$$delegate_0.toDp-GaN1DYA(l);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float toDp-u2uoSUM(float f) {
            return this.$$delegate_0.toDp-u2uoSUM(f);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float toDp-u2uoSUM(int i) {
            return this.$$delegate_0.toDp-u2uoSUM(i);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long toDpSize-k-rfVVM(long l) {
            return this.$$delegate_0.toDpSize-k-rfVVM(l);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float toPx--R2X_6o(long l) {
            return this.$$delegate_0.toPx--R2X_6o(l);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public float toPx-0680j_4(float f) {
            return this.$$delegate_0.toPx-0680j_4(f);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long toSize-XkaWNTQ(long l) {
            return this.$$delegate_0.toSize-XkaWNTQ(l);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long toSp-0xMU5do(float f) {
            return this.$$delegate_0.toSp-0xMU5do(f);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long toSp-kPz2Gy4(float f) {
            return this.$$delegate_0.toSp-kPz2Gy4(f);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long toSp-kPz2Gy4(int i) {
            return this.$$delegate_0.toSp-kPz2Gy4(i);
        }

        public <T> Object withTimeout(long l, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function22, Continuation<? super T> continuation3) {
            boolean anon;
            int i6;
            int i4;
            int label;
            Object launch$default;
            int pointerAwaiter;
            Object coroutineScope;
            int i;
            int i5;
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout.job.1 time;
            int i2;
            int i3;
            Object obj11;
            Object obj14;
            anon = obj14;
            i4 = Integer.MIN_VALUE;
            if (obj14 instanceof SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout.1 && label2 &= i4 != 0) {
                anon = obj14;
                i4 = Integer.MIN_VALUE;
                if (label2 &= i4 != 0) {
                    anon.label = obj14 -= i4;
                } else {
                    anon = new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout.1(this, obj14);
                }
            } else {
            }
            obj14 = anon;
            Object result = obj14.result;
            Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (label) {
                case 0:
                    ResultKt.throwOnFailure(result);
                    label = this;
                    pointerAwaiter = label.pointerAwaiter;
                    kotlin.Result.Companion companion = Result.Companion;
                    PointerEventTimeoutCancellationException pointerEventTimeoutCancellationException = new PointerEventTimeoutCancellationException(l, function22);
                    (Continuation)pointerAwaiter.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)pointerEventTimeoutCancellationException)));
                    i = 0;
                    SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout.job.1 anon2 = new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout.job.1(l, function22, label, i);
                    obj14.L$0 = BuildersKt.launch$default(label.this$0.getCoroutineScope(), i, 0, (Function2)anon2, 3, 0);
                    obj14.label = 1;
                    return cOROUTINE_SUSPENDED;
                case 1:
                    ResultKt.throwOnFailure(result);
                    launch$default = obj11;
                    obj11 = result;
                    break;
                default:
                    obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj11;
            }
            launch$default.cancel((CancellationException)CancelTimeoutCancellationException.INSTANCE);
            return obj11;
        }

        public <T> Object withTimeoutOrNull(long l, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function22, Continuation<? super T> continuation3) {
            boolean anon;
            int i;
            int i2;
            int label;
            Object timeout;
            Object obj8;
            anon = obj8;
            i2 = Integer.MIN_VALUE;
            if (obj8 instanceof SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeoutOrNull.1 && label2 &= i2 != 0) {
                anon = obj8;
                i2 = Integer.MIN_VALUE;
                if (label2 &= i2 != 0) {
                    anon.label = obj8 -= i2;
                } else {
                    anon = new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeoutOrNull.1(this, obj8);
                }
            } else {
            }
            obj8 = anon.result;
            Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (label) {
                case 0:
                    ResultKt.throwOnFailure(obj8);
                    anon.label = 1;
                    return cOROUTINE_SUSPENDED;
                case 1:
                    ResultKt.throwOnFailure(obj8);
                    timeout = obj8;
                    break;
                default:
                    IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj5;
            }
            return timeout;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[PointerEventPass.Initial.ordinal()] = 1;
            iArr[PointerEventPass.Final.ordinal()] = 2;
            iArr[PointerEventPass.Main.ordinal()] = 3;
            SuspendingPointerInputModifierNodeImpl.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
    }

    public SuspendingPointerInputModifierNodeImpl(Object key1, Object key2, Object[] keys, Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler) {
        super();
        this.key1 = key1;
        this.key2 = key2;
        this.keys = keys;
        this._pointerInputHandler = pointerInputHandler;
        this.currentEvent = SuspendingPointerInputFilterKt.access$getEmptyPointerEvent$p();
        int i = 0;
        int i5 = 0;
        final int i7 = 0;
        MutableVector mutableVector = new MutableVector(new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine[16], i7);
        this.pointerHandlers = mutableVector;
        int i2 = 0;
        int i6 = 0;
        MutableVector mutableVector2 = new MutableVector(new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine[16], i7);
        this.dispatchingPointerHandlers = mutableVector2;
        this.boundsSize = IntSize.Companion.getZero-YbymL2g();
    }

    public SuspendingPointerInputModifierNodeImpl(Object object, Object object2, Object[] object3Arr3, Function2 function24, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 &= 4 != 0 ? i : obj4;
        super(obj2, obj3, obj4, function24);
    }

    public static final long access$getBoundsSize$p(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl $this) {
        return $this.boundsSize;
    }

    public static final androidx.compose.ui.input.pointer.PointerEvent access$getCurrentEvent$p(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl $this) {
        return $this.currentEvent;
    }

    public static final MutableVector access$getPointerHandlers$p(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl $this) {
        return $this.pointerHandlers;
    }

    private final void dispatchPointerEvent(androidx.compose.ui.input.pointer.PointerEvent pointerEvent, androidx.compose.ui.input.pointer.PointerEventPass pass) {
        MutableVector this_$iv$iv;
        int ordinal;
        int size;
        MutableVector i$iv$iv;
        MutableVector pointerHandlers;
        int i;
        int size2;
        final Object obj = this;
        final int i2 = 0;
        MutableVector pointerHandlers2 = obj.pointerHandlers;
        int i3 = 0;
        size = 0;
        i$iv$iv = obj.dispatchingPointerHandlers;
        i = 0;
        i$iv$iv.addAll(i$iv$iv.getSize(), obj.pointerHandlers);
        synchronized (pointerHandlers2) {
            obj = this;
            i2 = 0;
            pointerHandlers2 = obj.pointerHandlers;
            i3 = 0;
            size = 0;
            i$iv$iv = obj.dispatchingPointerHandlers;
            i = 0;
            i$iv$iv.addAll(i$iv$iv.getSize(), obj.pointerHandlers);
        }
        this_$iv$iv = obj.dispatchingPointerHandlers;
        ordinal = 0;
        size = this_$iv$iv.getSize();
        if (size > 0) {
            try {
                i$iv$iv = 0;
                size2 = 0;
                (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine)this_$iv$iv.getContent()[i$iv$iv].offerPointerEvent(pointerEvent, pass);
                while (i$iv$iv++ >= size) {
                    size2 = 0;
                    (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine)pointerHandlers[i$iv$iv].offerPointerEvent(pointerEvent, pass);
                }
                obj.dispatchingPointerHandlers.clear();
                this_$iv.dispatchingPointerHandlers.clear();
                throw th;
                throw th2;
                Object $i$f$forEachCurrentPointerHandler = this_$iv;
                Object this_$iv = new byte[this_$iv];
                this_$iv = new byte[this_$iv];
                this_$iv = this_$iv;
            } catch (Throwable th) {
            }
        }
    }

    private final void forEachCurrentPointerHandler(androidx.compose.ui.input.pointer.PointerEventPass pass, Function1<? super androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<?>, Unit> block) {
        MutableVector this_$iv;
        int ordinal;
        int size;
        MutableVector i$iv;
        MutableVector pointerHandlers;
        int i;
        final int i2 = 0;
        MutableVector pointerHandlers2 = this.pointerHandlers;
        int i3 = 0;
        size = 0;
        i$iv = this.dispatchingPointerHandlers;
        i = 0;
        i$iv.addAll(i$iv.getSize(), this.pointerHandlers);
        synchronized (pointerHandlers2) {
            i2 = 0;
            pointerHandlers2 = this.pointerHandlers;
            i3 = 0;
            size = 0;
            i$iv = this.dispatchingPointerHandlers;
            i = 0;
            i$iv.addAll(i$iv.getSize(), this.pointerHandlers);
        }
        try {
            this_$iv = this.dispatchingPointerHandlers;
            ordinal = 0;
            size = this_$iv.getSize();
            if (size > 0) {
            }
            i$iv = 0;
            block.invoke(this_$iv.getContent()[i$iv]);
            while (i$iv++ >= size) {
                block.invoke(pointerHandlers[i$iv]);
            }
            this.dispatchingPointerHandlers.clear();
            this.dispatchingPointerHandlers.clear();
            throw lock$iv;
            throw th;
            Throwable lock$iv = $i$f$forEachCurrentPointerHandler;
            Throwable $i$f$forEachCurrentPointerHandler = $i$f$forEachCurrentPointerHandler;
        } catch (Throwable th) {
        }
    }

    public <R> Object awaitPointerEventScope(Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        final int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i4 = 0;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine(this, (Continuation)(CancellableContinuation)cancellableContinuationImpl2);
        MutableVector mutableVector = SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this);
        final int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this).add(pointerEventHandlerCoroutine);
        kotlin.Result.Companion companion = Result.Companion;
        ContinuationKt.createCoroutine(block, pointerEventHandlerCoroutine, (Continuation)pointerEventHandlerCoroutine).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        Unit iNSTANCE = Unit.INSTANCE;
        SuspendingPointerInputModifierNodeImpl.awaitPointerEventScope.2.2 lock$iv = new SuspendingPointerInputModifierNodeImpl.awaitPointerEventScope.2.2(pointerEventHandlerCoroutine);
        cancellableContinuationImpl2.invokeOnCancellation((Function1)lock$iv);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        synchronized (mutableVector) {
            i = 0;
            i2 = 0;
            cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellableContinuationImpl.initCancellability();
            cancellableContinuationImpl2 = cancellableContinuationImpl;
            i4 = 0;
            pointerEventHandlerCoroutine = new SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine(this, (Continuation)(CancellableContinuation)cancellableContinuationImpl2);
            mutableVector = SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this);
            i5 = 0;
            i6 = 0;
            i7 = 0;
            SuspendingPointerInputModifierNodeImpl.access$getPointerHandlers$p(this).add(pointerEventHandlerCoroutine);
            companion = Result.Companion;
            ContinuationKt.createCoroutine(block, pointerEventHandlerCoroutine, (Continuation)pointerEventHandlerCoroutine).resumeWith(Result.constructor-impl(Unit.INSTANCE));
            iNSTANCE = Unit.INSTANCE;
            lock$iv = new SuspendingPointerInputModifierNodeImpl.awaitPointerEventScope.2.2(pointerEventHandlerCoroutine);
            cancellableContinuationImpl2.invokeOnCancellation((Function1)lock$iv);
            uCont$iv = cancellableContinuationImpl.getResult();
        }
        DebugProbesKt.probeCoroutineSuspended($completion);
        return uCont$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getDensity().getDensity();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public long getExtendedTouchPadding-NH-jbRc() {
        long size-XkaWNTQ = toSize-XkaWNTQ(getViewConfiguration().getMinimumTouchTargetSize-MYxV2XQ());
        final long size-YbymL2g = getSize-YbymL2g();
        int i3 = 0;
        int i5 = 1073741824;
        return SizeKt.Size(f /= i5, f3 /= i5);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    public Function2<androidx.compose.ui.input.pointer.PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        return this._pointerInputHandler;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public long getSize-YbymL2g() {
        return this.boundsSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getViewConfiguration();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onCancelPointerInput() {
        int index$iv$iv;
        int i;
        int index$iv$iv2;
        Object obj3;
        Object obj;
        int i5;
        Object obj2;
        int i8;
        boolean pressed2;
        androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange;
        long id-J3iCeTQ;
        long uptimeMillis;
        long position-F1C5BW0;
        int i2;
        float pressure;
        long uptimeMillis2;
        long position-F1C5BW02;
        boolean pressed3;
        boolean pressed;
        int i4;
        int i6;
        int i7;
        int i3;
        final Object obj4 = this;
        final androidx.compose.ui.input.pointer.PointerEvent lastPointerEvent = obj4.lastPointerEvent;
        if (lastPointerEvent == null) {
        }
        int i9 = 0;
        List list = changes;
        int i12 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i5 = 0;
            i8 = 0;
            index$iv$iv++;
        }
        i = 1;
        if (i != 0) {
        }
        List changes2 = lastPointerEvent.getChanges();
        int i10 = 0;
        ArrayList arrayList = new ArrayList(changes2.size());
        List list2 = changes2;
        int i13 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < list2.size()) {
            obj2 = null;
            int i14 = i5;
            int i15 = 0;
            pointerInputChange = new PointerInputChange((PointerInputChange)i14.getId-J3iCeTQ(), obj16, i14.getUptimeMillis(), obj18, i14.getPosition-F1C5BW0(), obj20, 0, i14.getPressure(), i14.getUptimeMillis(), obj24, i14.getPosition-F1C5BW0(), obj26, i14.getPressed(), i14.getPressed(), 0, 0, obj31, 1536, 0);
            i8 = 0;
            (Collection)arrayList.add(pointerInputChange);
            index$iv$iv2++;
        }
        PointerEvent pointerEvent = new PointerEvent((List)arrayList);
        obj4.currentEvent = pointerEvent;
        obj4.dispatchPointerEvent(pointerEvent, PointerEventPass.Initial);
        obj4.dispatchPointerEvent(pointerEvent, PointerEventPass.Main);
        obj4.dispatchPointerEvent(pointerEvent, PointerEventPass.Final);
        obj4.lastPointerEvent = 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPointerEvent-H0pRuoY(androidx.compose.ui.input.pointer.PointerEvent pointerEvent, androidx.compose.ui.input.pointer.PointerEventPass pass, long bounds) {
        androidx.compose.ui.input.pointer.PointerEvent pointerEvent2;
        Job pointerInputJob;
        int i3;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i4;
        CoroutineStart uNDISPATCHED;
        androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.onPointerEvent.1 anon;
        int i;
        int i2;
        int index$iv$iv;
        int i6;
        Object obj;
        Object obj2;
        int i5;
        boolean it;
        int i7;
        final Object obj3 = this;
        obj3.boundsSize = bounds;
        if (pass == PointerEventPass.Initial) {
            obj3.currentEvent = pointerEvent;
        } else {
            pointerEvent2 = pointerEvent;
        }
        if (obj3.pointerInputJob == null) {
            SuspendingPointerInputModifierNodeImpl.onPointerEvent.1 anon2 = new SuspendingPointerInputModifierNodeImpl.onPointerEvent.1(obj3, 0);
            obj3.pointerInputJob = BuildersKt.launch$default(obj3.getCoroutineScope(), 0, CoroutineStart.UNDISPATCHED, (Function2)anon2, 1, 0);
        }
        dispatchPointerEvent(pointerEvent, pass);
        int i8 = 0;
        int i9 = 0;
        List list = changes;
        int i10 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i5 = 0;
            i7 = 0;
            index$iv$iv++;
        }
        i6 = 1;
        if (i6 == 0) {
            i3 = pointerEvent2;
        }
        obj3.lastPointerEvent = i3;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void resetPointerInputHandler() {
        int i;
        final Job pointerInputJob = this.pointerInputJob;
        if (pointerInputJob != null) {
            PointerInputResetException pointerInputResetException = new PointerInputResetException();
            pointerInputJob.cancel((CancellationException)pointerInputResetException);
            this.pointerInputJob = 0;
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void setInterceptOutOfBoundsChildEvents(boolean <set-?>) {
        this.interceptOutOfBoundsChildEvents = <set-?>;
    }

    public void setPointerInputHandler(Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> value) {
        resetPointerInputHandler();
        this._pointerInputHandler = value;
    }

    public final void update$ui_release(Object key1, Object key2, Object[] keys, Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler) {
        int needsReset;
        Object[] equals;
        needsReset = 0;
        if (!Intrinsics.areEqual(this.key1, key1)) {
            needsReset = 1;
        }
        this.key1 = key1;
        if (!Intrinsics.areEqual(this.key2, key2)) {
            needsReset = 1;
        }
        this.key2 = key2;
        if (this.keys != null && keys == null) {
            if (keys == null) {
                needsReset = 1;
            }
        }
        if (this.keys == null && keys != null) {
            if (keys != null) {
                needsReset = 1;
            }
        }
        if (this.keys != null && keys != null && !Arrays.equals(keys, this.keys)) {
            if (keys != null) {
                if (!Arrays.equals(keys, this.keys)) {
                    needsReset = 1;
                }
            }
        }
        this.keys = keys;
        if (needsReset != null) {
            resetPointerInputHandler();
        }
        this._pointerInputHandler = pointerInputHandler;
    }
}
