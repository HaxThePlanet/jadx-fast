package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001bH\u0016J#\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J*\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J\u001b\u0010)\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\"\u0010,\u001a\u00020$2\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.J\u0008\u0010/\u001a\u00020\u001bH\u0002J\u0012\u00100\u001a\u00020\u001b2\u0008\u00101\u001a\u0004\u0018\u00010\u0006H\u0002J\u0008\u00102\u001a\u00020\u001bH\u0002J\u001f\u00103\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\u00084R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\tR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00065", d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "resolvedDispatcher", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, androidx.compose.ui.input.nestedscroll.NestedScrollConnection {

    public static final int $stable = 8;
    private androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection;
    private androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;
    static {
        final int i = 8;
    }

    public NestedScrollNode(androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher dispatcher) {
        androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher nestedScrollDispatcher;
        super();
        this.connection = connection;
        if (dispatcher == null) {
            nestedScrollDispatcher = new NestedScrollDispatcher();
        } else {
            nestedScrollDispatcher = dispatcher;
        }
        this.resolvedDispatcher = nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public static final CoroutineScope access$getNestedCoroutineScope(androidx.compose.ui.input.nestedscroll.NestedScrollNode $this) {
        return $this.getNestedCoroutineScope();
    }

    private final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope parentNestedScrollNode$ui_release;
        parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if (parentNestedScrollNode$ui_release != null) {
            if (parentNestedScrollNode$ui_release.getNestedCoroutineScope() == null) {
                if (this.resolvedDispatcher.getScope$ui_release() == null) {
                } else {
                }
            }
            return parentNestedScrollNode$ui_release;
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        throw illegalStateException;
    }

    private final androidx.compose.ui.input.nestedscroll.NestedScrollConnection getParentConnection() {
        androidx.compose.ui.input.nestedscroll.NestedScrollNode parentNestedScrollNode$ui_release;
        if (isAttached()) {
            parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        } else {
            parentNestedScrollNode$ui_release = 0;
        }
        return parentNestedScrollNode$ui_release;
    }

    private final void resetDispatcherFields() {
        Object nestedScrollNode$ui_release;
        int i;
        if (this.resolvedDispatcher.getNestedScrollNode$ui_release() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(0);
        }
    }

    private final void updateDispatcher(androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher newDispatcher) {
        androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher nestedScrollDispatcher;
        resetDispatcherFields();
        if (newDispatcher == null) {
            nestedScrollDispatcher = new NestedScrollDispatcher();
            this.resolvedDispatcher = nestedScrollDispatcher;
        } else {
            if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
                this.resolvedDispatcher = newDispatcher;
            }
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        NestedScrollNode.updateDispatcherFields.1 anon = new NestedScrollNode.updateDispatcherFields.1(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release((Function0)anon);
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.input.nestedscroll.NestedScrollConnection getConnection() {
        return this.connection;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.input.nestedscroll.NestedScrollNode getParentNestedScrollNode$ui_release() {
        TraversableNode nearestAncestor;
        if (isAttached()) {
            nearestAncestor = TraversableNodeKt.findNearestAncestor((TraversableNode)this);
        } else {
            nearestAncestor = 0;
        }
        return nearestAncestor;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        resetDispatcherFields();
    }

    public Object onPostFling-RZ2iAVY(long l, long l2, Continuation<? super Velocity> continuation3) {
        boolean anon;
        int i4;
        int i2;
        Object l$0;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection _this;
        Object onPostFling-RZ2iAVY;
        long unbox-impl;
        int i3;
        int i;
        long l3;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection obj9;
        long obj10;
        long obj12;
        Object obj14;
        anon = obj14;
        i2 = Integer.MIN_VALUE;
        if (obj14 instanceof NestedScrollNode.onPostFling.1 && label &= i2 != 0) {
            anon = obj14;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj14 -= i2;
            } else {
                anon = new NestedScrollNode.onPostFling.1(this, obj14);
            }
        } else {
        }
        obj14 = anon;
        Object result = obj14.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (_this) {
            case 0:
                ResultKt.throwOnFailure(result);
                l$0 = this;
                obj14.L$0 = l$0;
                obj14.J$0 = l;
                obj14.J$1 = continuation3;
                obj14.label = 1;
                return cOROUTINE_SUSPENDED;
                obj12 = l;
                obj10 = l3;
                break;
            case 1:
                obj10 = obj14.J$1;
                obj12 = obj14.J$0;
                l$0 = obj14.L$0;
                ResultKt.throwOnFailure(result);
                onPostFling-RZ2iAVY = result;
                break;
            case 2:
                ResultKt.throwOnFailure(result);
                unbox-impl = obj10;
                obj10 = result;
                obj10 = (Velocity)obj10.unbox-impl();
                return Velocity.box-impl(Velocity.plus-AH228Gc(unbox-impl, i3));
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        unbox-impl = (Velocity)onPostFling-RZ2iAVY.unbox-impl();
        _this = l$0.getParentConnection();
        if (_this != null) {
            obj14.L$0 = 0;
            obj14.J$0 = unbox-impl;
            obj14.label = 2;
            if (_this.onPostFling-RZ2iAVY(Velocity.plus-AH228Gc(obj12, obj13), l2, Velocity.minus-AH228Gc(obj10, obj6)) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            }
        } else {
            i = obj10;
            obj10 = Velocity.Companion.getZero-9UxMQ8M();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        long onPostScroll-DzOQY0M;
        long plus-MK-Hz9U;
        long minus-MK-Hz9U;
        Object obj;
        int i;
        final long onPostScroll-DzOQY0M2 = this.connection.onPostScroll-DzOQY0M(consumed, obj2, source);
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            i = source;
            onPostScroll-DzOQY0M = parentConnection.onPostScroll-DzOQY0M(Offset.plus-MK-Hz9U(consumed, available), obj2, Offset.minus-MK-Hz9U(source, obj14));
        } else {
            i = source;
            onPostScroll-DzOQY0M = Offset.Companion.getZero-F1C5BW0();
        }
        return Offset.plus-MK-Hz9U(onPostScroll-DzOQY0M2, obj7);
    }

    public Object onPreFling-QWom1Mo(long l, Continuation<? super Velocity> continuation2) {
        boolean anon;
        int i4;
        int i2;
        Object label;
        Object onPreFling-QWom1Mo;
        long zero-9UxMQ8M;
        int i;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection;
        long minus-AH228Gc;
        int i3;
        long obj10;
        Object obj12;
        anon = obj12;
        i2 = Integer.MIN_VALUE;
        if (obj12 instanceof NestedScrollNode.onPreFling.1 && label2 &= i2 != 0) {
            anon = obj12;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj12 -= i2;
            } else {
                anon = new NestedScrollNode.onPreFling.1(this, obj12);
            }
        } else {
        }
        obj12 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                label = this;
                androidx.compose.ui.input.nestedscroll.NestedScrollConnection parentConnection = label.getParentConnection();
                anon.L$0 = label;
                anon.J$0 = l;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                zero-9UxMQ8M = Velocity.Companion.getZero-9UxMQ8M();
                anon.L$0 = 0;
                anon.J$0 = zero-9UxMQ8M;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                return Velocity.box-impl(Velocity.plus-AH228Gc(zero-9UxMQ8M, i));
            case 1:
                obj10 = anon.J$0;
                label = anon.L$0;
                ResultKt.throwOnFailure(obj12);
                onPreFling-QWom1Mo = obj12;
                break;
            case 2:
                ResultKt.throwOnFailure(obj12);
                zero-9UxMQ8M = obj10;
                obj10 = obj12;
                return Velocity.box-impl(Velocity.plus-AH228Gc(zero-9UxMQ8M, i));
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        zero-9UxMQ8M = (Velocity)onPreFling-QWom1Mo.unbox-impl();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public long onPreScroll-OzD1aCk(long available, int source) {
        long onPreScroll-OzD1aCk;
        androidx.compose.ui.input.nestedscroll.NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            onPreScroll-OzD1aCk = parentConnection.onPreScroll-OzD1aCk(available, source);
        } else {
            onPreScroll-OzD1aCk = Offset.Companion.getZero-F1C5BW0();
        }
        final long minus-MK-Hz9U = Offset.minus-MK-Hz9U(available, source);
        return Offset.plus-MK-Hz9U(onPreScroll-OzD1aCk, obj1);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setConnection(androidx.compose.ui.input.nestedscroll.NestedScrollConnection <set-?>) {
        this.connection = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void updateNode$ui_release(androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
