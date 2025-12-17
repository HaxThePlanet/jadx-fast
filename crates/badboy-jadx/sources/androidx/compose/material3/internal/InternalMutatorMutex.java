package androidx.compose.material3.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.Mutex.DefaultImpls;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\t\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u001c\u0010\r\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u0010JU\u0010\u0011\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\u0012\"\u0004\u0008\u0001\u0010\n2\u0006\u0010\u0013\u001a\u0002H\u00122\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2'\u0010\r\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\u0008\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/material3/internal/InternalMutatorMutex;", "", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "Landroidx/compose/material3/internal/InternalAtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", "T", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutate", "", "Lkotlin/Function0;", "", "tryMutateOrCancel", "mutator", "Mutator", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InternalMutatorMutex {

    public static final int $stable;
    private final AtomicReference<androidx.compose.material3.internal.InternalMutatorMutex.Mutator> currentMutator;
    private final Mutex mutex;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0010", d2 = {"Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "canInterrupt", "", "other", "cancel", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Mutator {

        private final Job job;
        private final MutatePriority priority;
        public Mutator(MutatePriority priority, Job job) {
            super();
            this.priority = priority;
            this.job = job;
        }

        public final boolean canInterrupt(androidx.compose.material3.internal.InternalMutatorMutex.Mutator other) {
            int i;
            i = this.priority.compareTo((Enum)other.priority) >= 0 ? 1 : 0;
            return i;
        }

        public final void cancel() {
            final int i = 0;
            Job.DefaultImpls.cancel$default(this.job, i, 1, i);
        }

        public final Job getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }
    }
    static {
    }

    public InternalMutatorMutex() {
        super();
        final int i2 = 0;
        AtomicReference atomicReference = new AtomicReference(i2);
        this.currentMutator = atomicReference;
        this.mutex = MutexKt.Mutex$default(false, 1, i2);
    }

    public static final AtomicReference access$getCurrentMutator$p(androidx.compose.material3.internal.InternalMutatorMutex $this) {
        return $this.currentMutator;
    }

    public static final Mutex access$getMutex$p(androidx.compose.material3.internal.InternalMutatorMutex $this) {
        return $this.mutex;
    }

    public static final void access$tryMutateOrCancel(androidx.compose.material3.internal.InternalMutatorMutex $this, androidx.compose.material3.internal.InternalMutatorMutex.Mutator mutator) {
        $this.tryMutateOrCancel(mutator);
    }

    public static Object mutate$default(androidx.compose.material3.internal.InternalMutatorMutex internalMutatorMutex, MutatePriority mutatePriority2, Function1 function13, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (i5 &= 1 != 0) {
            obj1 = MutatePriority.Default;
        }
        return internalMutatorMutex.mutate(obj1, function13, continuation4);
    }

    public static Object mutateWith$default(androidx.compose.material3.internal.InternalMutatorMutex internalMutatorMutex, Object object2, MutatePriority mutatePriority3, Function2 function24, Continuation continuation5, int i6, Object object7) {
        MutatePriority obj2;
        if (i6 &= 2 != 0) {
            obj2 = MutatePriority.Default;
        }
        return internalMutatorMutex.mutateWith(object2, obj2, function24, continuation5);
    }

    private final void tryMutateOrCancel(androidx.compose.material3.internal.InternalMutatorMutex.Mutator mutator) {
        Object obj;
        boolean interrupt;
        obj = this.currentMutator.get();
        while ((InternalMutatorMutex.Mutator)obj != null) {
            obj = this.currentMutator.get();
        }
        CancellationException cancellationException = new CancellationException("Current mutation had a higher priority");
        throw cancellationException;
    }

    public final <R> Object mutate(MutatePriority priority, Function1<? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        InternalMutatorMutex.mutate.2 anon = new InternalMutatorMutex.mutate.2(priority, this, block, 0);
        return CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
    }

    public final <T, R> Object mutateWith(T receiver, MutatePriority priority, Function2<? super T, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        InternalMutatorMutex.mutateWith.2 anon = new InternalMutatorMutex.mutateWith.2(priority, this, block, receiver, 0);
        return CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
    }

    public final boolean tryMutate(Function0<Unit> block) {
        Object mutex;
        final int i = 0;
        final int i2 = 1;
        boolean tryLock$default = Mutex.DefaultImpls.tryLock$default(this.mutex, i, i2, i);
        if (tryLock$default) {
            block.invoke();
            Mutex.DefaultImpls.unlock$default(this.mutex, i, i2, i);
        }
        return tryLock$default;
    }
}
