package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnackbarHostState {

    public static final int $stable;
    private final MutableState currentSnackbarData$delegate;
    private final Mutex mutex;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0010\nJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000c¨\u0006\u0013", d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "getMessage", "dismiss", "", "performAction", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SnackbarDataImpl implements androidx.compose.material.SnackbarData {

        private final String actionLabel;
        private final CancellableContinuation<androidx.compose.material.SnackbarResult> continuation;
        private final androidx.compose.material.SnackbarDuration duration;
        private final String message;
        public SnackbarDataImpl(String message, String actionLabel, androidx.compose.material.SnackbarDuration duration, CancellableContinuation<? super androidx.compose.material.SnackbarResult> continuation) {
            super();
            this.message = message;
            this.actionLabel = actionLabel;
            this.duration = duration;
            this.continuation = continuation;
        }

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            boolean continuation;
            Object constructor-impl;
            if (this.continuation.isActive()) {
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)this.continuation.resumeWith(Result.constructor-impl(SnackbarResult.Dismissed));
            }
        }

        @Override // androidx.compose.material.SnackbarData
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material.SnackbarData
        public androidx.compose.material.SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material.SnackbarData
        public void performAction() {
            boolean continuation;
            Object constructor-impl;
            if (this.continuation.isActive()) {
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)this.continuation.resumeWith(Result.constructor-impl(SnackbarResult.ActionPerformed));
            }
        }
    }
    static {
    }

    public SnackbarHostState() {
        super();
        final int i4 = 0;
        this.mutex = MutexKt.Mutex$default(false, 1, i4);
        this.currentSnackbarData$delegate = SnapshotStateKt.mutableStateOf$default(i4, i4, 2, i4);
    }

    public static final void access$setCurrentSnackbarData(androidx.compose.material.SnackbarHostState $this, androidx.compose.material.SnackbarData <set-?>) {
        $this.setCurrentSnackbarData(<set-?>);
    }

    private final void setCurrentSnackbarData(androidx.compose.material.SnackbarData <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentSnackbarData$delegate.setValue(<set-?>);
    }

    public static Object showSnackbar$default(androidx.compose.material.SnackbarHostState snackbarHostState, String string2, String string3, androidx.compose.material.SnackbarDuration snackbarDuration4, Continuation continuation5, int i6, Object object7) {
        int obj2;
        androidx.compose.material.SnackbarDuration obj3;
        if (i6 & 2 != 0) {
            obj2 = 0;
        }
        if (i6 &= 4 != 0) {
            obj3 = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(string2, obj2, obj3, continuation5);
    }

    public final androidx.compose.material.SnackbarData getCurrentSnackbarData() {
        final int i = 0;
        final int i2 = 0;
        return (SnackbarData)(State)this.currentSnackbarData$delegate.getValue();
    }

    public final Object showSnackbar(String string, String string2, androidx.compose.material.SnackbarDuration snackbarDuration3, Continuation<? super androidx.compose.material.SnackbarResult> continuation4) {
        Object obj3;
        int i;
        boolean anon4;
        Object $continuation;
        int i3;
        androidx.compose.material.SnackbarHostState snackbarHostState;
        int i4;
        int _this;
        Object cOROUTINE_SUSPENDED;
        int i6;
        Object $this$withLock_u24default$iv;
        int $this$withLock_u24default$iv2;
        Object owner$iv;
        Object obj;
        Object l$4;
        int cancellableContinuationImpl;
        Object owner$iv2;
        int l$3;
        Object obj2;
        int actionLabel;
        Object message;
        Object $i$f$withLock;
        Object lock;
        androidx.compose.material.SnackbarHostState.showSnackbar.1 anon;
        int i7;
        androidx.compose.material.SnackbarHostState.showSnackbar.1 anon2;
        int i5;
        Object obj7;
        androidx.compose.material.SnackbarHostState.showSnackbar.1 anon3;
        int i2;
        int obj19;
        obj3 = continuation4;
        anon4 = obj3;
        i6 = Integer.MIN_VALUE;
        if (obj3 instanceof SnackbarHostState.showSnackbar.1 && label2 &= i6 != 0) {
            anon4 = obj3;
            i6 = Integer.MIN_VALUE;
            if (label2 &= i6 != 0) {
                anon4.label = label -= i6;
                snackbarHostState = this;
            } else {
                anon4 = new SnackbarHostState.showSnackbar.1(this, obj3);
            }
        } else {
        }
        Object result = anon4.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                Object obj4 = this;
                Object obj5 = string2;
                Object obj6 = string;
                owner$iv = obj4.mutex;
                int i13 = 0;
                anon4.L$0 = obj4;
                anon4.L$1 = obj6;
                anon4.L$2 = obj5;
                anon4.L$3 = snackbarDuration3;
                anon4.L$4 = owner$iv;
                anon4.label = 1;
                return cOROUTINE_SUSPENDED2;
                owner$iv2 = obj4;
                _this = i14;
                $i$f$withLock = obj6;
                message = obj5;
                actionLabel = i2;
                break;
            case 1:
                _this = 0;
                l$3 = anon4.L$3;
                ResultKt.throwOnFailure(result);
                actionLabel = i8;
                owner$iv = l$42;
                owner$iv2 = l$0;
                $i$f$withLock = l$12;
                message = i2;
                break;
            case 2:
                i4 = 0;
                $this$withLock_u24default$iv2 = 0;
                i = 0;
                Object l$5 = anon4.L$5;
                l$4 = anon4.L$4;
                Object l$32 = anon4.L$3;
                Object l$2 = anon4.L$2;
                Object l$1 = anon4.L$1;
                owner$iv2 = anon4.L$0;
                ResultKt.throwOnFailure(result);
                anon3 = anon4;
                $continuation = result;
                actionLabel = cancellableContinuationImpl;
                owner$iv2.setCurrentSnackbarData(0);
                l$4.unlock(actionLabel);
                return $continuation;
            default:
                androidx.compose.material.SnackbarHostState.showSnackbar.1 anon5 = anon4;
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        anon = anon4;
        anon4.L$0 = owner$iv2;
        anon4.L$1 = $i$f$withLock;
        anon4.L$2 = message;
        anon4.L$3 = l$3;
        anon4.L$4 = owner$iv;
        anon4.L$5 = anon;
        anon4.label = 2;
        i5 = 0;
        anon3 = anon4;
        cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon), 1);
        cancellableContinuationImpl.initCancellability();
        int i10 = 0;
        SnackbarHostState.SnackbarDataImpl $i$f$withLock2 = new SnackbarHostState.SnackbarDataImpl($i$f$withLock, message, l$3, (CancellableContinuation)cancellableContinuationImpl);
        SnackbarHostState.access$setCurrentSnackbarData(owner$iv2, (SnackbarData)$i$f$withLock2);
        $continuation = cancellableContinuationImpl.getResult();
        if ($continuation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
        }
        if ($continuation == cOROUTINE_SUSPENDED2) {
            return cOROUTINE_SUSPENDED2;
        }
        i4 = obj19;
        l$4 = owner$iv;
        $this$withLock_u24default$iv2 = lock;
        i = i7;
    }
}
