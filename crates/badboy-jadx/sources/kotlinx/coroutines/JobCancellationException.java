package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u0008\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0007H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\u0008\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JobCancellationException extends CancellationException implements kotlinx.coroutines.CopyableThrowable<kotlinx.coroutines.JobCancellationException> {

    public final transient kotlinx.coroutines.Job job;
    public JobCancellationException(String message, Throwable cause, kotlinx.coroutines.Job job) {
        super(message);
        this.job = job;
        if (cause != null) {
            initCause(cause);
        }
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable createCopy() {
        return (Throwable)createCopy();
    }

    @Override // java.util.concurrent.CancellationException
    public kotlinx.coroutines.JobCancellationException createCopy() {
        if (DebugKt.getDEBUG()) {
            final String message = getMessage();
            Intrinsics.checkNotNull(message);
            JobCancellationException jobCancellationException = new JobCancellationException(message, (Throwable)this, this.job);
            return jobCancellationException;
        }
        return null;
    }

    @Override // java.util.concurrent.CancellationException
    public boolean equals(Object other) {
        boolean equal;
        int i;
        Object message;
        if (other != this) {
            if (other instanceof JobCancellationException != null && Intrinsics.areEqual((JobCancellationException)other.getMessage(), getMessage()) && Intrinsics.areEqual(obj2.job, this.job) && Intrinsics.areEqual((JobCancellationException)other.getCause(), getCause())) {
                if (Intrinsics.areEqual((JobCancellationException)other.getMessage(), getMessage())) {
                    if (Intrinsics.areEqual(obj2.job, this.job)) {
                        if (Intrinsics.areEqual((JobCancellationException)other.getCause(), getCause())) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable fillInStackTrace() {
        if (DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }
        int i = 0;
        setStackTrace(new StackTraceElement[0]);
        return (Throwable)this;
    }

    @Override // java.util.concurrent.CancellationException
    public int hashCode() {
        int i;
        String message = getMessage();
        Intrinsics.checkNotNull(message);
        Throwable cause = getCause();
        if (cause != null) {
            i = cause.hashCode();
        } else {
            i = 0;
        }
        return i5 += i;
    }

    @Override // java.util.concurrent.CancellationException
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(super.toString()).append("; job=").append(this.job).toString();
    }
}
