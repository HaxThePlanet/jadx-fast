package androidx.compose.ui.focus;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0013\u001a\u00020\u0006H\u0002J\u0008\u0010\u0014\u001a\u00020\u0006H\u0002J\u0008\u0010\u0015\u001a\u00020\u0006H\u0002J4\u0010\u0016\u001a\u0002H\u0017\"\u0004\u0008\u0000\u0010\u00172\u0010\u0008\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00170\u0005H\u0086\u0008¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u0002H\u0017\"\u0004\u0008\u0000\u0010\u00172\u0010\u0008\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00170\u0005H\u0086\u0008¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u0004\u0018\u00010\u000c*\u00020\u000b2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000c8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012¨\u0006\u001c", d2 = {"Landroidx/compose/ui/focus/FocusTransactionManager;", "", "()V", "cancellationListener", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "", "ongoingTransaction", "", "states", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "uncommittedFocusState", "getUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusStateImpl;", "setUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusStateImpl;)V", "beginTransaction", "cancelTransaction", "commitTransaction", "withExistingTransaction", "T", "onCancelled", "block", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withNewTransaction", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusTransactionManager {

    public static final int $stable = 8;
    private final MutableVector<Function0<Unit>> cancellationListener;
    private boolean ongoingTransaction;
    private final MutableScatterMap<androidx.compose.ui.focus.FocusTargetNode, androidx.compose.ui.focus.FocusStateImpl> states;
    static {
        final int i = 8;
    }

    public FocusTransactionManager() {
        super();
        this.states = ScatterMapKt.mutableScatterMapOf();
        int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new Function0[16], 0);
        this.cancellationListener = mutableVector;
    }

    public static final void access$beginTransaction(androidx.compose.ui.focus.FocusTransactionManager $this) {
        $this.beginTransaction();
    }

    public static final void access$cancelTransaction(androidx.compose.ui.focus.FocusTransactionManager $this) {
        $this.cancelTransaction();
    }

    public static final void access$commitTransaction(androidx.compose.ui.focus.FocusTransactionManager $this) {
        $this.commitTransaction();
    }

    public static final MutableVector access$getCancellationListener$p(androidx.compose.ui.focus.FocusTransactionManager $this) {
        return $this.cancellationListener;
    }

    public static final boolean access$getOngoingTransaction$p(androidx.compose.ui.focus.FocusTransactionManager $this) {
        return $this.ongoingTransaction;
    }

    private final void beginTransaction() {
        this.ongoingTransaction = true;
    }

    private final void cancelTransaction() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        this.states.clear();
        this.ongoingTransaction = false;
        MutableVector cancellationListener = this.cancellationListener;
        final int i3 = 0;
        final int size = cancellationListener.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            (Function0)cancellationListener.getContent()[i$iv].invoke();
            while (i$iv++ >= size) {
                i = 0;
                (Function0)content[i$iv].invoke();
            }
        }
        this.cancellationListener.clear();
    }

    private final void commitTransaction() {
        int i$iv$iv;
        int cmp;
        int i;
        int j$iv$iv;
        long l;
        int i3;
        int i4;
        long slot$iv$iv;
        long l2;
        int i2;
        final Object obj = this;
        MutableScatterMap states = obj.states;
        final int i5 = 0;
        final int i6 = 0;
        final long[] metadata = map.metadata;
        length += -2;
        if (0 <= i7) {
        } else {
        }
        obj.states.clear();
        obj.ongoingTransaction = false;
        obj.cancellationListener.clear();
    }

    public static Object withExistingTransaction$default(androidx.compose.ui.focus.FocusTransactionManager $this, Function0 onCancelled, Function0 block, int i4, Object object5) {
        int i;
        MutableVector mutableVector;
        int i2;
        int obj4;
        int obj7;
        if (i4 &= 1 != 0) {
            obj4 = 0;
        }
        int obj6 = 0;
        if (obj4 != null) {
            i = 0;
            i2 = 0;
            FocusTransactionManager.access$getCancellationListener$p($this).add(obj4);
        }
        if (FocusTransactionManager.access$getOngoingTransaction$p($this)) {
            obj7 = block.invoke();
        } else {
            FocusTransactionManager.access$beginTransaction($this);
            obj7 = block.invoke();
            FocusTransactionManager.access$commitTransaction($this);
        }
        return obj7;
    }

    public static Object withNewTransaction$default(androidx.compose.ui.focus.FocusTransactionManager $this, Function0 onCancelled, Function0 block, int i4, Object object5) {
        int i;
        MutableVector mutableVector;
        int i2;
        int obj4;
        boolean obj7;
        if (i4 &= 1 != 0) {
            obj4 = 0;
        }
        int obj6 = 0;
        if (FocusTransactionManager.access$getOngoingTransaction$p($this)) {
            FocusTransactionManager.access$cancelTransaction($this);
        }
        FocusTransactionManager.access$beginTransaction($this);
        if (obj4 != null) {
            i = 0;
            i2 = 0;
            FocusTransactionManager.access$getCancellationListener$p($this).add(obj4);
        }
        FocusTransactionManager.access$commitTransaction($this);
        return block.invoke();
    }

    public final androidx.compose.ui.focus.FocusStateImpl getUncommittedFocusState(androidx.compose.ui.focus.FocusTargetNode $this$uncommittedFocusState) {
        return (FocusStateImpl)this.states.get($this$uncommittedFocusState);
    }

    public final void setUncommittedFocusState(androidx.compose.ui.focus.FocusTargetNode $this$uncommittedFocusState, androidx.compose.ui.focus.FocusStateImpl value) {
        final int i2 = 0;
        if (value == null) {
        } else {
            this.states.set($this$uncommittedFocusState, value);
        }
        int i = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("requires a non-null focus state");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public final <T> T withExistingTransaction(Function0<Unit> onCancelled, Function0<? extends T> block) {
        Object th;
        Object invoke;
        int i2;
        MutableVector mutableVector;
        int i;
        final int i3 = 0;
        if (onCancelled != null) {
            i2 = 0;
            i = 0;
            FocusTransactionManager.access$getCancellationListener$p(this).add(onCancelled);
        }
        if (FocusTransactionManager.access$getOngoingTransaction$p(this)) {
            invoke = block.invoke();
        } else {
            FocusTransactionManager.access$beginTransaction(this);
            invoke = block.invoke();
            FocusTransactionManager.access$commitTransaction(this);
        }
        return invoke;
    }

    public final <T> T withNewTransaction(Function0<Unit> onCancelled, Function0<? extends T> block) {
        boolean z;
        int i;
        MutableVector mutableVector;
        int i2;
        final int i3 = 0;
        if (FocusTransactionManager.access$getOngoingTransaction$p(this)) {
            FocusTransactionManager.access$cancelTransaction(this);
        }
        try {
            FocusTransactionManager.access$beginTransaction(this);
            if (onCancelled != null) {
            }
            i = 0;
            i2 = 0;
            FocusTransactionManager.access$getCancellationListener$p(this).add(onCancelled);
            FocusTransactionManager.access$commitTransaction(this);
            return block.invoke();
            FocusTransactionManager.access$commitTransaction(this);
            throw th;
        }
    }
}
