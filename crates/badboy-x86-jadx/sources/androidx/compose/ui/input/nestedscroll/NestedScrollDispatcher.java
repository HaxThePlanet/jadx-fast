package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J(\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&J\u001b\u0010'\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J \u0010*\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u000c\"\u0004\u0008\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006-", d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "()V", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scope", "getScope$ui_release", "setScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "dispatchPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreScroll", "dispatchPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NestedScrollDispatcher {

    public static final int $stable = 8;
    private Function0<? extends CoroutineScope> calculateNestedScrollScope;
    private androidx.compose.ui.input.nestedscroll.NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;
    static {
        final int i = 8;
    }

    public NestedScrollDispatcher() {
        super();
        NestedScrollDispatcher.calculateNestedScrollScope.1 anon = new NestedScrollDispatcher.calculateNestedScrollScope.1(this);
        this.calculateNestedScrollScope = (Function0)anon;
    }

    public final Object dispatchPostFling-RZ2iAVY(long l, long l2, Continuation<? super Velocity> continuation3) {
        boolean anon;
        int i3;
        int i2;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection _this;
        int i;
        Object obj4;
        Object obj5;
        Object obj9;
        anon = obj9;
        i2 = Integer.MIN_VALUE;
        if (obj9 instanceof NestedScrollDispatcher.dispatchPostFling.1 && label &= i2 != 0) {
            anon = obj9;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj9 -= i2;
            } else {
                anon = new NestedScrollDispatcher.dispatchPostFling.1(this, obj9);
            }
        } else {
        }
        obj9 = anon;
        Object result = obj9.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (_this) {
            case 0:
                ResultKt.throwOnFailure(result);
                _this = this.getParent$ui_release();
                obj9.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = Velocity.Companion.getZero-9UxMQ8M();
                return Velocity.box-impl(obj5);
            case 1:
                ResultKt.throwOnFailure(result);
                obj5 = result;
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        obj5 = (Velocity)obj5.unbox-impl();
    }

    public final long dispatchPostScroll-DzOQY0M(long consumed, long available, int source) {
        long consumed2;
        int i;
        Object obj;
        long obj7;
        final androidx.compose.ui.input.nestedscroll.NestedScrollConnection parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            obj7 = parent$ui_release.onPostScroll-DzOQY0M(consumed, obj2, source);
        } else {
            consumed2 = consumed;
            i = source;
            obj = obj11;
            obj7 = Offset.Companion.getZero-F1C5BW0();
        }
        return obj7;
    }

    public final Object dispatchPreFling-QWom1Mo(long l, Continuation<? super Velocity> continuation2) {
        boolean anon;
        int i3;
        int i;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection _this;
        int i2;
        Object obj5;
        Object obj7;
        anon = obj7;
        i = Integer.MIN_VALUE;
        if (obj7 instanceof NestedScrollDispatcher.dispatchPreFling.1 && label &= i != 0) {
            anon = obj7;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj7 -= i;
            } else {
                anon = new NestedScrollDispatcher.dispatchPreFling.1(this, obj7);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (_this) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                _this = this.getParent$ui_release();
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = Velocity.Companion.getZero-9UxMQ8M();
                return Velocity.box-impl(obj5);
            case 1:
                ResultKt.throwOnFailure(obj7);
                obj5 = obj7;
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        obj5 = (Velocity)obj5.unbox-impl();
    }

    public final long dispatchPreScroll-OzD1aCk(long available, int source) {
        long onPreScroll-OzD1aCk;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            onPreScroll-OzD1aCk = parent$ui_release.onPreScroll-OzD1aCk(available, source);
        } else {
            onPreScroll-OzD1aCk = Offset.Companion.getZero-F1C5BW0();
        }
        return onPreScroll-OzD1aCk;
    }

    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    public final CoroutineScope getCoroutineScope() {
        Object invoke = this.calculateNestedScrollScope.invoke();
        if ((CoroutineScope)invoke == null) {
        } else {
            return (CoroutineScope)invoke;
        }
        IllegalStateException illegalStateException = new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        throw illegalStateException;
    }

    public final androidx.compose.ui.input.nestedscroll.NestedScrollNode getNestedScrollNode$ui_release() {
        return this.nestedScrollNode;
    }

    public final androidx.compose.ui.input.nestedscroll.NestedScrollConnection getParent$ui_release() {
        androidx.compose.ui.input.nestedscroll.NestedScrollNode parentNestedScrollNode$ui_release;
        androidx.compose.ui.input.nestedscroll.NestedScrollNode nestedScrollNode = this.nestedScrollNode;
        if (nestedScrollNode != null) {
            parentNestedScrollNode$ui_release = nestedScrollNode.getParentNestedScrollNode$ui_release();
        } else {
            parentNestedScrollNode$ui_release = 0;
        }
        return (NestedScrollConnection)parentNestedScrollNode$ui_release;
    }

    public final CoroutineScope getScope$ui_release() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui_release(Function0<? extends CoroutineScope> <set-?>) {
        this.calculateNestedScrollScope = <set-?>;
    }

    public final void setNestedScrollNode$ui_release(androidx.compose.ui.input.nestedscroll.NestedScrollNode <set-?>) {
        this.nestedScrollNode = <set-?>;
    }

    public final void setScope$ui_release(CoroutineScope <set-?>) {
        this.scope = <set-?>;
    }
}
