package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "SnackbarVisualsImpl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnackbarHostState {

    public static final int $stable;
    private final MutableState currentSnackbarData$delegate;
    private final Mutex mutex;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0013", d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "dismiss", "", "equals", "", "other", "", "hashCode", "", "performAction", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SnackbarDataImpl implements androidx.compose.material3.SnackbarData {

        private final CancellableContinuation<androidx.compose.material3.SnackbarResult> continuation;
        private final androidx.compose.material3.SnackbarVisuals visuals;
        public SnackbarDataImpl(androidx.compose.material3.SnackbarVisuals visuals, CancellableContinuation<? super androidx.compose.material3.SnackbarResult> continuation) {
            super();
            this.visuals = visuals;
            this.continuation = continuation;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            boolean continuation;
            Object constructor-impl;
            if (this.continuation.isActive()) {
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)this.continuation.resumeWith(Result.constructor-impl(SnackbarResult.Dismissed));
            }
        }

        @Override // androidx.compose.material3.SnackbarData
        public boolean equals(Object other) {
            Class class2;
            Class class;
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (other != null) {
                if (getClass() != other.getClass()) {
                } else {
                    Object obj = other;
                    if (!Intrinsics.areEqual(getVisuals(), (SnackbarHostState.SnackbarDataImpl)other.getVisuals())) {
                        return i2;
                    }
                    if (!Intrinsics.areEqual(this.continuation, obj3.continuation)) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        @Override // androidx.compose.material3.SnackbarData
        public androidx.compose.material3.SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        @Override // androidx.compose.material3.SnackbarData
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            boolean continuation;
            Object constructor-impl;
            if (this.continuation.isActive()) {
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)this.continuation.resumeWith(Result.constructor-impl(SnackbarResult.ActionPerformed));
            }
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0016", d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getMessage", "getWithDismissAction", "()Z", "equals", "other", "", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SnackbarVisualsImpl implements androidx.compose.material3.SnackbarVisuals {

        private final String actionLabel;
        private final androidx.compose.material3.SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;
        public SnackbarVisualsImpl(String message, String actionLabel, boolean withDismissAction, androidx.compose.material3.SnackbarDuration duration) {
            super();
            this.message = message;
            this.actionLabel = actionLabel;
            this.withDismissAction = withDismissAction;
            this.duration = duration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean equals(Object other) {
            Class class2;
            Class class;
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (other != null) {
                if (getClass() != other.getClass()) {
                } else {
                    androidx.compose.material3.SnackbarHostState.SnackbarVisualsImpl snackbarVisualsImpl = other;
                    if (!Intrinsics.areEqual(getMessage(), (SnackbarHostState.SnackbarVisualsImpl)other.getMessage())) {
                        return i2;
                    }
                    if (!Intrinsics.areEqual(getActionLabel(), (SnackbarHostState.SnackbarVisualsImpl)other.getActionLabel())) {
                        return i2;
                    }
                    if (getWithDismissAction() != (SnackbarHostState.SnackbarVisualsImpl)other.getWithDismissAction()) {
                        return i2;
                    }
                    if (getDuration() != (SnackbarHostState.SnackbarVisualsImpl)other.getDuration()) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public androidx.compose.material3.SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public int hashCode() {
            int i;
            String actionLabel = getActionLabel();
            if (actionLabel != null) {
                i = actionLabel.hashCode();
            } else {
                i = 0;
            }
            return result2 += i8;
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

    public static final void access$setCurrentSnackbarData(androidx.compose.material3.SnackbarHostState $this, androidx.compose.material3.SnackbarData <set-?>) {
        $this.setCurrentSnackbarData(<set-?>);
    }

    private final void setCurrentSnackbarData(androidx.compose.material3.SnackbarData <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentSnackbarData$delegate.setValue(<set-?>);
    }

    public static Object showSnackbar$default(androidx.compose.material3.SnackbarHostState snackbarHostState, String string2, String string3, boolean z4, androidx.compose.material3.SnackbarDuration snackbarDuration5, Continuation continuation6, int i7, Object object8) {
        int i;
        int i2;
        androidx.compose.material3.SnackbarDuration snackbarDuration;
        int obj8;
        int obj9;
        androidx.compose.material3.SnackbarDuration obj10;
        i = i7 & 2 != 0 ? obj8 : string3;
        i2 = i7 & 4 != 0 ? obj9 : z4;
        if (i7 & 8 != 0) {
            obj8 = i == 0 ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
            snackbarDuration = obj10;
        } else {
            snackbarDuration = snackbarDuration5;
        }
        return snackbarHostState.showSnackbar(string2, i, i2, snackbarDuration, continuation6);
    }

    public final androidx.compose.material3.SnackbarData getCurrentSnackbarData() {
        final int i = 0;
        final int i2 = 0;
        return (SnackbarData)(State)this.currentSnackbarData$delegate.getValue();
    }

    public final Object showSnackbar(androidx.compose.material3.SnackbarVisuals snackbarVisuals, Continuation<? super androidx.compose.material3.SnackbarResult> continuation2) {
        Object obj3;
        int i4;
        boolean anon4;
        Object $continuation;
        int i2;
        androidx.compose.material3.SnackbarHostState snackbarHostState;
        int $i$f$withLock2;
        int i7;
        Object $this$withLock_u24default$iv;
        int $this$withLock_u24default$iv2;
        Object owner$iv2;
        Object obj;
        Object l$2;
        Object cOROUTINE_SUSPENDED;
        int i3;
        Object owner$iv;
        int l$1;
        Object obj2;
        int $i$f$withLock;
        Object lock;
        androidx.compose.material3.SnackbarHostState.showSnackbar.2 anon2;
        int i;
        androidx.compose.material3.SnackbarHostState.showSnackbar.2 anon;
        int i6;
        CancellableContinuationImpl cancellableContinuationImpl;
        Object obj5;
        androidx.compose.material3.SnackbarHostState.showSnackbar.2 anon3;
        int i5;
        obj3 = continuation2;
        anon4 = obj3;
        i7 = Integer.MIN_VALUE;
        if (obj3 instanceof SnackbarHostState.showSnackbar.2 && label2 &= i7 != 0) {
            anon4 = obj3;
            i7 = Integer.MIN_VALUE;
            if (label2 &= i7 != 0) {
                anon4.label = label -= i7;
                snackbarHostState = this;
            } else {
                anon4 = new SnackbarHostState.showSnackbar.2(this, obj3);
            }
        } else {
        }
        Object result = anon4.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                Object obj4 = this;
                owner$iv2 = obj4.mutex;
                int i12 = 0;
                anon4.L$0 = obj4;
                anon4.L$1 = snackbarVisuals;
                anon4.L$2 = owner$iv2;
                anon4.label = i9;
                return cOROUTINE_SUSPENDED2;
                owner$iv = obj4;
                $i$f$withLock2 = i13;
                $i$f$withLock = i5;
                break;
            case 1:
                $i$f$withLock2 = 0;
                l$1 = anon4.L$1;
                ResultKt.throwOnFailure(result);
                $i$f$withLock = i8;
                owner$iv2 = l$22;
                owner$iv = i5;
                break;
            case 2:
                $i$f$withLock2 = 0;
                $this$withLock_u24default$iv2 = 0;
                i4 = 0;
                Object l$3 = anon4.L$3;
                l$2 = anon4.L$2;
                Object l$12 = anon4.L$1;
                owner$iv = anon4.L$0;
                ResultKt.throwOnFailure(result);
                anon3 = anon4;
                $continuation = result;
                $i$f$withLock = i3;
                owner$iv.setCurrentSnackbarData(0);
                l$2.unlock($i$f$withLock);
                return $continuation;
            default:
                androidx.compose.material3.SnackbarHostState.showSnackbar.2 anon5 = anon4;
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        anon2 = anon4;
        anon4.L$0 = owner$iv;
        anon4.L$1 = l$1;
        anon4.L$2 = owner$iv2;
        anon4.L$3 = anon2;
        anon4.label = 2;
        i6 = 0;
        cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon2), i9);
        cancellableContinuationImpl.initCancellability();
        i3 = 0;
        anon3 = anon4;
        SnackbarHostState.SnackbarDataImpl $continuation2 = new SnackbarHostState.SnackbarDataImpl(l$1, (CancellableContinuation)cancellableContinuationImpl);
        SnackbarHostState.access$setCurrentSnackbarData(owner$iv, (SnackbarData)$continuation2);
        $continuation = cancellableContinuationImpl.getResult();
        if ($continuation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)anon2);
        }
        if ($continuation == cOROUTINE_SUSPENDED2) {
            return cOROUTINE_SUSPENDED2;
        }
        l$2 = owner$iv2;
        $this$withLock_u24default$iv2 = lock;
        i4 = i;
    }

    public final Object showSnackbar(String message, String actionLabel, boolean withDismissAction, androidx.compose.material3.SnackbarDuration duration, Continuation<? super androidx.compose.material3.SnackbarResult> $completion) {
        SnackbarHostState.SnackbarVisualsImpl snackbarVisualsImpl = new SnackbarHostState.SnackbarVisualsImpl(message, actionLabel, withDismissAction, duration);
        return showSnackbar((SnackbarVisuals)snackbarVisualsImpl, $completion);
    }
}
