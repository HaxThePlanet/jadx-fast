package androidx.compose.ui;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008g\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J5\u0010\u0008\u001a\u0002H\t\"\u0004\u0008\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\u000cH&¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0002H\t\"\u0004\u0008\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\u000cH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0014À\u0006\u0003", d2 = {"Landroidx/compose/ui/Modifier;", "", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "Companion", "Element", "Node", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Modifier {

    public static final androidx.compose.ui.Modifier.Companion Companion;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J5\u0010\u0007\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u00082\u0006\u0010\t\u001a\u0002H\u00082\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00080\u000bH\u0016¢\u0006\u0002\u0010\u000cJ5\u0010\r\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u00082\u0006\u0010\t\u001a\u0002H\u00082\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\u00080\u000bH\u0016¢\u0006\u0002\u0010\u000cø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "all", "", "predicate", "Lkotlin/Function1;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Element extends androidx.compose.ui.Modifier {
        public static boolean access$all$jd(androidx.compose.ui.Modifier.Element $this, Function1 predicate) {
            return super.all(predicate);
        }

        public static boolean access$any$jd(androidx.compose.ui.Modifier.Element $this, Function1 predicate) {
            return super.any(predicate);
        }

        public static Object access$foldIn$jd(androidx.compose.ui.Modifier.Element $this, Object initial, Function2 operation) {
            return super.foldIn(initial, operation);
        }

        public static Object access$foldOut$jd(androidx.compose.ui.Modifier.Element $this, Object initial, Function2 operation) {
            return super.foldOut(initial, operation);
        }

        public static androidx.compose.ui.Modifier access$then$jd(androidx.compose.ui.Modifier.Element $this, androidx.compose.ui.Modifier other) {
            return super.then(other);
        }

        public boolean all(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> predicate) {
            return (Boolean)predicate.invoke(this).booleanValue();
        }

        public boolean any(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> predicate) {
            return (Boolean)predicate.invoke(this).booleanValue();
        }

        public <R> R foldIn(R initial, Function2<? super R, ? super androidx.compose.ui.Modifier.Element, ? extends R> operation) {
            return operation.invoke(initial, this);
        }

        public <R> R foldOut(R initial, Function2<? super androidx.compose.ui.Modifier.Element, ? super R, ? extends R> operation) {
            return operation.invoke(this, initial);
        }
    }

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u00106\u001a\u00020\u00182\n\u00107\u001a\u0006\u0012\u0002\u0008\u000308H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\r\u0010;\u001a\u00020<H\u0010¢\u0006\u0002\u0008=J\r\u0010>\u001a\u00020<H\u0010¢\u0006\u0002\u0008?J\u0008\u0010@\u001a\u00020<H\u0016J\u0008\u0010A\u001a\u00020<H\u0016J\u0008\u0010B\u001a\u00020<H\u0016J\r\u0010C\u001a\u00020<H\u0010¢\u0006\u0002\u0008DJ\r\u0010E\u001a\u00020<H\u0010¢\u0006\u0002\u0008FJ\r\u0010G\u001a\u00020<H\u0010¢\u0006\u0002\u0008HJ\u0015\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\u0000H\u0010¢\u0006\u0002\u0008KJ\u0016\u0010L\u001a\u00020<2\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u00020<0NH\u0007J\u0017\u0010O\u001a\u00020<2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0002\u0008PR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006\"\u0004\u0008 \u0010\u0008R$\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000@BX\u0086\u000e¢\u0006\u000e\n\u0000\u0012\u0004\u0008\"\u0010\u0002\u001a\u0004\u0008#\u0010\u000bR\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010\u000b\"\u0004\u0008.\u0010\rR\u0010\u0010/\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u00081\u0010\u0002\u001a\u0004\u00082\u0010\u001aR\u001a\u00103\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u0010\u001a\"\u0004\u00085\u0010\u001c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006Q", d2 = {"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "()V", "aggregateChildKindSet", "", "getAggregateChildKindSet$ui_release", "()I", "setAggregateChildKindSet$ui_release", "(I)V", "child", "getChild$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setChild$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "<set-?>", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "getCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "insertedNodeAwaitingAttachForInvalidation", "", "getInsertedNodeAwaitingAttachForInvalidation$ui_release", "()Z", "setInsertedNodeAwaitingAttachForInvalidation$ui_release", "(Z)V", "isAttached", "kindSet", "getKindSet$ui_release", "setKindSet$ui_release", "node", "getNode$annotations", "getNode", "onAttachRunExpected", "onDetachRunExpected", "ownerScope", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "getOwnerScope$ui_release", "()Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "setOwnerScope$ui_release", "(Landroidx/compose/ui/node/ObserverNodeOwnerScope;)V", "parent", "getParent$ui_release", "setParent$ui_release", "scope", "shouldAutoInvalidate", "getShouldAutoInvalidate$annotations", "getShouldAutoInvalidate", "updatedNodeAwaitingAttachForInvalidation", "getUpdatedNodeAwaitingAttachForInvalidation$ui_release", "setUpdatedNodeAwaitingAttachForInvalidation$ui_release", "isKind", "kind", "Landroidx/compose/ui/node/NodeKind;", "isKind-H91voCI$ui_release", "(I)Z", "markAsAttached", "", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "onAttach", "onDetach", "onReset", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "sideEffect", "effect", "Lkotlin/Function0;", "updateCoordinator", "updateCoordinator$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Node implements DelegatableNode {

        public static final int $stable = 8;
        private int aggregateChildKindSet = -1;
        private androidx.compose.ui.Modifier.Node child;
        private NodeCoordinator coordinator;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private androidx.compose.ui.Modifier.Node node;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private androidx.compose.ui.Modifier.Node parent;
        private CoroutineScope scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;
        static {
            final int i = 8;
        }

        public Node() {
            super();
            this.node = this;
            final int i = -1;
        }

        public static void getNode$annotations() {
        }

        public static void getShouldAutoInvalidate$annotations() {
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final androidx.compose.ui.Modifier.Node getChild$ui_release() {
            return this.child;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final CoroutineScope getCoroutineScope() {
            CoroutineScope scope;
            CoroutineScope coroutineScope;
            int i;
            if (this.scope == null) {
                i = 0;
                this.scope = CoroutineScopeKt.CoroutineScope(DelegatableNodeKt.requireOwner((DelegatableNode)this).getCoroutineContext().plus((CoroutineContext)JobKt.Job((Job)DelegatableNodeKt.requireOwner((DelegatableNode)this).getCoroutineContext().get((CoroutineContext.Key)Job.Key))));
            }
            return scope;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final androidx.compose.ui.Modifier.Node getNode() {
            return this.node;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final ObserverNodeOwnerScope getOwnerScope$ui_release() {
            return this.ownerScope;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final androidx.compose.ui.Modifier.Node getParent$ui_release() {
            return this.parent;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public boolean getShouldAutoInvalidate() {
            return 1;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final boolean isAttached() {
            return this.isAttached;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final boolean isKind-H91voCI$ui_release(int kind) {
            int i;
            final int i2 = 0;
            i = kindSet$ui_release &= kind != 0 ? 1 : 0;
            return i;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void markAsAttached$ui_release() {
            int i;
            String $i$a$CheckPreconditionModifier$Node$markAsAttached$2;
            final int i3 = 1;
            int i4 = 0;
            if (isAttached ^= i3 == 0) {
                int i7 = 0;
                InlineClassHelperKt.throwIllegalStateException("node attached multiple times");
            }
            i = this.coordinator != null ? i3 : 0;
            int i5 = 0;
            if (i == 0) {
                int i6 = 0;
                InlineClassHelperKt.throwIllegalStateException("attach invoked on a node without a coordinator");
            }
            this.isAttached = i3;
            this.onAttachRunExpected = i3;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void markAsDetached$ui_release() {
            int i;
            String $i$a$CheckPreconditionModifier$Node$markAsDetached$2;
            int i4 = 0;
            if (!this.isAttached) {
                int i8 = 0;
                InlineClassHelperKt.throwIllegalStateException("Cannot detach a node that is not attached");
            }
            int i5 = 0;
            if (value$iv ^= 1 == 0) {
                int i6 = 0;
                InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() before markAsDetached()");
            }
            i = 0;
            if (value$iv2 ^= 1 == 0) {
                int i7 = 0;
                InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.isAttached = false;
            CoroutineScope scope = this.scope;
            if (scope != null) {
                i = 0;
                ModifierNodeDetachedCancellationException modifierNodeDetachedCancellationException = new ModifierNodeDetachedCancellationException();
                CoroutineScopeKt.cancel(scope, (CancellationException)modifierNodeDetachedCancellationException);
                this.scope = 0;
            }
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void onAttach() {
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void onDetach() {
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void onReset() {
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void reset$ui_release() {
            String $i$a$CheckPreconditionModifier$Node$reset$1;
            final int i = 0;
            if (!this.isAttached) {
                int i2 = 0;
                InlineClassHelperKt.throwIllegalStateException("reset() called on an unattached node");
            }
            onReset();
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void runAttachLifecycle$ui_release() {
            String $i$a$CheckPreconditionModifier$Node$runAttachLifecycle$1;
            int i2 = 0;
            if (!this.isAttached) {
                int i4 = 0;
                InlineClassHelperKt.throwIllegalStateException("Must run markAsAttached() prior to runAttachLifecycle");
            }
            int i3 = 0;
            if (!this.onAttachRunExpected) {
                int i5 = 0;
                InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void runDetachLifecycle$ui_release() {
            int i;
            String $i$a$CheckPreconditionModifier$Node$runDetachLifecycle$1;
            String $i$a$CheckPreconditionModifier$Node$runDetachLifecycle$3;
            int i2 = 0;
            if (!this.isAttached) {
                int i6 = 0;
                InlineClassHelperKt.throwIllegalStateException("node detached multiple times");
            }
            int i3 = 0;
            i = this.coordinator != null ? 1 : i3;
            int i4 = 0;
            if (i == 0) {
                int i8 = 0;
                InlineClassHelperKt.throwIllegalStateException("detach invoked on a node without a coordinator");
            }
            int i5 = 0;
            if (!this.onDetachRunExpected) {
                int i7 = 0;
                InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.onDetachRunExpected = i3;
            onDetach();
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setAggregateChildKindSet$ui_release(int <set-?>) {
            this.aggregateChildKindSet = <set-?>;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void setAsDelegateTo$ui_release(androidx.compose.ui.Modifier.Node owner) {
            this.node = owner;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setChild$ui_release(androidx.compose.ui.Modifier.Node <set-?>) {
            this.child = <set-?>;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean <set-?>) {
            this.insertedNodeAwaitingAttachForInvalidation = <set-?>;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setKindSet$ui_release(int <set-?>) {
            this.kindSet = <set-?>;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setOwnerScope$ui_release(ObserverNodeOwnerScope <set-?>) {
            this.ownerScope = <set-?>;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setParent$ui_release(androidx.compose.ui.Modifier.Node <set-?>) {
            this.parent = <set-?>;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean <set-?>) {
            this.updatedNodeAwaitingAttachForInvalidation = <set-?>;
        }

        public final void sideEffect(Function0<Unit> effect) {
            DelegatableNodeKt.requireOwner((DelegatableNode)this).registerOnEndApplyChangesListener(effect);
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public void updateCoordinator$ui_release(NodeCoordinator coordinator) {
            this.coordinator = coordinator;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u001c\u0010\u0008\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J5\u0010\t\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\u000c\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\u000c\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0096\u0004J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014", d2 = {"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "()V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements androidx.compose.ui.Modifier {

        static final androidx.compose.ui.Modifier.Companion $$INSTANCE;
        static {
            Modifier.Companion companion = new Modifier.Companion();
            Modifier.Companion.$$INSTANCE = companion;
        }

        public boolean all(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> predicate) {
            return 1;
        }

        public boolean any(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> predicate) {
            return 0;
        }

        public <R> R foldIn(R initial, Function2<? super R, ? super androidx.compose.ui.Modifier.Element, ? extends R> operation) {
            return initial;
        }

        public <R> R foldOut(R initial, Function2<? super androidx.compose.ui.Modifier.Element, ? super R, ? extends R> operation) {
            return initial;
        }

        @Override // androidx.compose.ui.Modifier
        public androidx.compose.ui.Modifier then(androidx.compose.ui.Modifier other) {
            return other;
        }

        @Override // androidx.compose.ui.Modifier
        public String toString() {
            return "Modifier";
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static androidx.compose.ui.Modifier then(androidx.compose.ui.Modifier $this, androidx.compose.ui.Modifier other) {
            return Modifier.access$then$jd($this, other);
        }
    }
    static {
        Modifier.Companion = Modifier.Companion.$$INSTANCE;
    }

    public static androidx.compose.ui.Modifier access$then$jd(androidx.compose.ui.Modifier $this, androidx.compose.ui.Modifier other) {
        return super.then(other);
    }

    public abstract boolean all(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> function1);

    public abstract boolean any(Function1<? super androidx.compose.ui.Modifier.Element, Boolean> function1);

    public abstract <R> R foldIn(R r, Function2<? super R, ? super androidx.compose.ui.Modifier.Element, ? extends R> function22);

    public abstract <R> R foldOut(R r, Function2<? super androidx.compose.ui.Modifier.Element, ? super R, ? extends R> function22);

    public androidx.compose.ui.Modifier then(androidx.compose.ui.Modifier other) {
        androidx.compose.ui.Modifier combinedModifier;
        if (other == Modifier.Companion) {
            combinedModifier = this;
        } else {
            combinedModifier = new CombinedModifier(this, other);
        }
        return combinedModifier;
    }
}
