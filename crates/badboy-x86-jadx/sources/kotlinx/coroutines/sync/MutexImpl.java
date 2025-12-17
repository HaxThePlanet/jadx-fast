package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002+,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u001b\u0010 \u001a\u00020\u00192\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00192\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001e\u0010#\u001a\u0004\u0018\u00010\n2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0008\u0010$\u001a\u0004\u0018\u00010\nH\u0014J\u001e\u0010%\u001a\u00020\u00192\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0014J\u0008\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u00042\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010)\u001a\u00020\u001f2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010*\u001a\u00020\u00192\u0008\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R(\u0010\u0008\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\t8VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\r\u0010\u000eRk\u0010\u000f\u001a_\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0010j\u0002`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001cX\u0082\u0004\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006-", d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "(Z)V", "isLocked", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSelectCancellationUnlockConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "owner", "Lkotlinx/atomicfu/AtomicRef;", "holdsLock", "holdsLockImpl", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "onLockProcessResult", "result", "onLockRegFunction", "toString", "", "tryLock", "tryLockImpl", "unlock", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MutexImpl extends kotlinx.coroutines.sync.SemaphoreImpl implements kotlinx.coroutines.sync.Mutex {

    private static final AtomicReferenceFieldUpdater owner$FU;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onSelectCancellationUnlockConstructor;
    @Volatile
    private volatile Object owner;

    @Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\u0012\u001a\u00020\u000e2\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0097\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u0097\u0001J2\u0010\u0018\u001a\u00020\u00022'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00020\u001aj\u0002`\u001dH\u0096\u0001J\u001d\u0010\u0018\u001a\u00020\u00022\n\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001f2\u0006\u0010 \u001a\u00020!H\u0096\u0001J:\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u00022\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00020(H\u0096\u0001ø\u0001\u0000¢\u0006\u0002\u0010)J$\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00022\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010\u0007H\u0097\u0001¢\u0006\u0002\u0010,JF\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00022\u0008\u0010+\u001a\u0004\u0018\u00010\u00072#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u00020\u0014H\u0097\u0001J\u001a\u00100\u001a\u00020\u0002*\u0002012\u0006\u0010#\u001a\u00020\u0002H\u0097\u0001¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\u0002*\u0002012\u0006\u0010/\u001a\u00020\u0014H\u0097\u0001R\u0016\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "token", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "resume", "value", "onCancellation", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "tryResume", "idempotent", "(Lkotlin/Unit;Ljava/lang/Object;)Ljava/lang/Object;", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {

        public final CancellableContinuationImpl<Unit> cont;
        public final Object owner;
        final kotlinx.coroutines.sync.MutexImpl this$0;
        public CancellableContinuationWithOwner(kotlinx.coroutines.sync.MutexImpl this$0, CancellableContinuationImpl cont, Object owner) {
            this.this$0 = this$0;
            super();
            this.cont = cont;
            this.owner = owner;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(Throwable throwable) {
            return this.cont.cancel(throwable);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void completeResume(Object object) {
            this.cont.completeResume(object);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void initCancellability() {
            this.cont.initCancellability();
        }

        public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
            this.cont.invokeOnCancellation(function1);
        }

        public void invokeOnCancellation(Segment<?> segment, int i2) {
            this.cont.invokeOnCancellation(segment, i2);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCancelled() {
            return this.cont.isCancelled();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resume(Object value, Function1 onCancellation) {
            resume((Unit)value, onCancellation);
        }

        public void resume(Unit value, Function1<? super Throwable, Unit> onCancellation) {
            kotlinx.coroutines.sync.MutexImpl this$0;
            boolean aSSERTIONS_ENABLED;
            kotlinx.coroutines.internal.Symbol symbol;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                this$0 = MutexImpl.access$getOwner$FU$p().get(this.this$0) == MutexKt.access$getNO_OWNER$p() ? 1 : 0;
                if (this$0 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            MutexImpl.access$getOwner$FU$p().set(this.this$0, this.owner);
            MutexImpl.CancellableContinuationWithOwner.resume.2 anon = new MutexImpl.CancellableContinuationWithOwner.resume.2(this.this$0, this);
            this.cont.resume(value, (Function1)anon);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatched(CoroutineDispatcher $this$resumeUndispatched, Object value) {
            resumeUndispatched($this$resumeUndispatched, (Unit)value);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit2) {
            this.cont.resumeUndispatched(coroutineDispatcher, unit2);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable throwable2) {
            this.cont.resumeUndispatchedWithException(coroutineDispatcher, throwable2);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeWith(Object object) {
            this.cont.resumeWith(object);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResume(Object value, Object idempotent) {
            return tryResume((Unit)value, idempotent);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResume(Object value, Object idempotent, Function1 onCancellation) {
            return tryResume((Unit)value, idempotent, onCancellation);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResume(Unit unit, Object object2) {
            return this.cont.tryResume(unit, object2);
        }

        public Object tryResume(Unit value, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
            int this$03;
            boolean aSSERTIONS_ENABLED;
            Object anon;
            Object this$0;
            int this$02;
            int owner;
            kotlinx.coroutines.internal.Symbol symbol2;
            kotlinx.coroutines.sync.MutexImpl aSSERTIONS_ENABLED2;
            kotlinx.coroutines.internal.Symbol symbol;
            owner = 0;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                this$03 = MutexImpl.access$getOwner$FU$p().get(this.this$0) == MutexKt.access$getNO_OWNER$p() ? this$02 : owner;
                if (this$03 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            anon = new MutexImpl.CancellableContinuationWithOwner.tryResume.token.1(this.this$0, this);
            Object tryResume = this.cont.tryResume(value, idempotent, (Function1)anon);
            if (tryResume != null && DebugKt.getASSERTIONS_ENABLED()) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED2 = 0;
                    if (MutexImpl.access$getOwner$FU$p().get(this.this$0) == MutexKt.access$getNO_OWNER$p()) {
                    } else {
                        this$02 = owner;
                    }
                    if (this$02 == 0) {
                    } else {
                    }
                    AssertionError assertionError2 = new AssertionError();
                    throw assertionError2;
                }
                MutexImpl.access$getOwner$FU$p().set(this.this$0, this.owner);
            }
            return tryResume;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResumeWithException(Throwable throwable) {
            return this.cont.tryResumeWithException(throwable);
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u001d\u0010\u000f\u001a\u00020\u000c2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0012\u0010\u0014\u001a\u00020\u000c2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016R\u0012\u0010\u0007\u001a\u00020\u0008X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "select", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposeOnCompletion", "", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "selectInRegistrationPhase", "internalResult", "trySelect", "", "clauseObject", "result", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SelectInstanceWithOwner implements SelectInstanceInternal<Q> {

        public final Object owner;
        public final SelectInstanceInternal<Q> select;
        final kotlinx.coroutines.sync.MutexImpl this$0;
        public SelectInstanceWithOwner(kotlinx.coroutines.sync.MutexImpl this$0, SelectInstanceInternal select, Object owner) {
            this.this$0 = this$0;
            super();
            this.select = select;
            this.owner = owner;
        }

        @Override // kotlinx.coroutines.selects.SelectInstanceInternal
        public void disposeOnCompletion(DisposableHandle disposableHandle) {
            this.select.disposeOnCompletion(disposableHandle);
        }

        @Override // kotlinx.coroutines.selects.SelectInstanceInternal
        public CoroutineContext getContext() {
            return this.select.getContext();
        }

        public void invokeOnCancellation(Segment<?> segment, int i2) {
            this.select.invokeOnCancellation(segment, i2);
        }

        @Override // kotlinx.coroutines.selects.SelectInstanceInternal
        public void selectInRegistrationPhase(Object internalResult) {
            kotlinx.coroutines.sync.MutexImpl this$0;
            boolean aSSERTIONS_ENABLED;
            kotlinx.coroutines.internal.Symbol symbol;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                this$0 = MutexImpl.access$getOwner$FU$p().get(this.this$0) == MutexKt.access$getNO_OWNER$p() ? 1 : 0;
                if (this$0 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            MutexImpl.access$getOwner$FU$p().set(this.this$0, this.owner);
            this.select.selectInRegistrationPhase(internalResult);
        }

        @Override // kotlinx.coroutines.selects.SelectInstanceInternal
        public boolean trySelect(Object clauseObject, Object result) {
            kotlinx.coroutines.sync.MutexImpl this$0;
            boolean aSSERTIONS_ENABLED;
            kotlinx.coroutines.internal.Symbol symbol;
            AtomicReferenceFieldUpdater field;
            Object owner;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                this$0 = MutexImpl.access$getOwner$FU$p().get(this.this$0) == MutexKt.access$getNO_OWNER$p() ? 1 : 0;
                if (this$0 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            boolean trySelect = this.select.trySelect(clauseObject, result);
            final int i = 0;
            if (trySelect) {
                MutexImpl.access$getOwner$FU$p().set(this.this$0, this.owner);
            }
            return trySelect;
        }
    }
    static {
        MutexImpl.owner$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    }

    public MutexImpl(boolean locked) {
        int i;
        super(1, locked);
        if (locked != 0) {
            i = 0;
        } else {
            i = MutexKt.access$getNO_OWNER$p();
        }
        this.owner = i;
        MutexImpl.onSelectCancellationUnlockConstructor.1 anon = new MutexImpl.onSelectCancellationUnlockConstructor.1(this);
        this.onSelectCancellationUnlockConstructor = (Function3)anon;
    }

    public static final AtomicReferenceFieldUpdater access$getOwner$FU$p() {
        return MutexImpl.owner$FU;
    }

    public static final Object access$lockSuspend(kotlinx.coroutines.sync.MutexImpl $this, Object owner, Continuation $completion) {
        return $this.lockSuspend(owner, $completion);
    }

    public static void getOnLock$annotations() {
    }

    private final int holdsLockImpl(Object owner) {
        Object obj;
        kotlinx.coroutines.internal.Symbol symbol;
        int i;
        while (!isLocked()) {
            obj = MutexImpl.owner$FU.get(this);
        }
        return 0;
    }

    static Object lock$suspendImpl(kotlinx.coroutines.sync.MutexImpl $this, Object owner, Continuation<? super Unit> $completion) {
        if ($this.tryLock(owner)) {
            return Unit.INSTANCE;
        }
        Object lockSuspend = $this.lockSuspend(owner, $completion);
        if (lockSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return lockSuspend;
        }
        return Unit.INSTANCE;
    }

    private final Object lockSuspend(Object owner, Continuation<? super Unit> $completion) {
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted($completion));
        final int i3 = 0;
        MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner = new MutexImpl.CancellableContinuationWithOwner(this, orCreateCancellableContinuation, owner);
        acquire((CancellableContinuation)cancellableContinuationWithOwner);
        Object uCont$iv = orCreateCancellableContinuation.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    private final int tryLockImpl(Object owner) {
        int holdsLockImpl;
        boolean aSSERTIONS_ENABLED;
        int i;
        Object obj;
        kotlinx.coroutines.internal.Symbol symbol;
        i = 1;
        while (tryAcquire()) {
            i = 1;
        }
        final int i3 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (MutexImpl.owner$FU.get(this) == MutexKt.access$getNO_OWNER$p()) {
            } else {
                i = i3;
            }
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        MutexImpl.owner$FU.set(this, owner);
        return i3;
    }

    public SelectClause2<Object, kotlinx.coroutines.sync.Mutex> getOnLock() {
        kotlinx.coroutines.sync.MutexImpl.onLock.1 iNSTANCE = MutexImpl.onLock.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        int i = 3;
        kotlinx.coroutines.sync.MutexImpl.onLock.2 iNSTANCE2 = MutexImpl.onLock.2.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        SelectClause2Impl selectClause2Impl = new SelectClause2Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, i), (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE2, i), this.onSelectCancellationUnlockConstructor);
        return (SelectClause2)selectClause2Impl;
    }

    @Override // kotlinx.coroutines.sync.SemaphoreImpl
    public boolean holdsLock(Object owner) {
        int i;
        if (holdsLockImpl(owner) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlinx.coroutines.sync.SemaphoreImpl
    public boolean isLocked() {
        int i;
        i = getAvailablePermits() == 0 ? 1 : 0;
        return i;
    }

    public Object lock(Object object, Continuation<? super Unit> continuation2) {
        return MutexImpl.lock$suspendImpl(this, object, continuation2);
    }

    @Override // kotlinx.coroutines.sync.SemaphoreImpl
    protected Object onLockProcessResult(Object owner, Object result) {
        if (Intrinsics.areEqual(result, MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p())) {
        } else {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("This mutex is already locked by the specified owner: ").append(owner).toString().toString());
        throw illegalStateException;
    }

    protected void onLockRegFunction(SelectInstance<?> select, Object owner) {
        boolean holdsLock;
        Object selectInstanceWithOwner;
        Object obj;
        if (owner != null && holdsLock(owner)) {
            if (holdsLock(owner)) {
                select.selectInRegistrationPhase(MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p());
            } else {
                Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
                selectInstanceWithOwner = new MutexImpl.SelectInstanceWithOwner(this, (SelectInstanceInternal)select, owner);
                onAcquireRegFunction((SelectInstance)selectInstanceWithOwner, owner);
            }
        } else {
        }
    }

    @Override // kotlinx.coroutines.sync.SemaphoreImpl
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Mutex@").append(DebugStringsKt.getHexAddress(this)).append("[isLocked=").append(isLocked()).append(",owner=").append(MutexImpl.owner$FU.get(this)).append(']').toString();
    }

    @Override // kotlinx.coroutines.sync.SemaphoreImpl
    public boolean tryLock(Object owner) {
        int i;
        switch (tryLockImpl) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 0;
                break;
            case 2:
                StringBuilder stringBuilder = new StringBuilder();
                IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder.append("This mutex is already locked by the specified owner: ").append(owner).toString().toString());
                throw illegalStateException2;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("unexpected".toString());
                throw illegalStateException;
        }
        return i;
    }

    @Override // kotlinx.coroutines.sync.SemaphoreImpl
    public void unlock(Object owner) {
        Object obj;
        kotlinx.coroutines.internal.Symbol symbol2;
        int i;
        kotlinx.coroutines.internal.Symbol symbol;
        while (isLocked()) {
            obj = MutexImpl.owner$FU.get(this);
            if (obj != owner) {
            } else {
            }
            i = 1;
            if (owner == null) {
            } else {
            }
            i = 0;
        }
        int curOwner = 0;
        IllegalStateException $i$a$CheckMutexImpl$unlock$1 = new IllegalStateException("This mutex is not locked".toString());
        throw $i$a$CheckMutexImpl$unlock$1;
    }
}
