package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u0008\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0007H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\u0008\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JobCancellationException extends CancellationException implements kotlinx.coroutines.f0<kotlinx.coroutines.JobCancellationException> {

    public final kotlinx.coroutines.y1 job;
    public JobCancellationException(String string, Throwable throwable2, kotlinx.coroutines.y1 y13) {
        super(string);
        this.job = y13;
        if (throwable2 != null) {
            initCause(throwable2);
        }
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable a() {
        return b();
    }

    @Override // java.util.concurrent.CancellationException
    public kotlinx.coroutines.JobCancellationException b() {
        if (q0.c()) {
            final String message = getMessage();
            n.d(message);
            JobCancellationException jobCancellationException = new JobCancellationException(message, this, this.job);
            return jobCancellationException;
        }
        return null;
    }

    @Override // java.util.concurrent.CancellationException
    public boolean equals(Object object) {
        Throwable cause;
        Object message;
        Object obj3;
        if (object != this) {
            if (object instanceof JobCancellationException != null && n.b((JobCancellationException)object.getMessage(), getMessage()) && n.b(object.job, this.job) && n.b(object.getCause(), getCause())) {
                if (n.b((JobCancellationException)object.getMessage(), getMessage())) {
                    if (n.b(object.job, this.job)) {
                        if (n.b(object.getCause(), getCause())) {
                            obj3 = 1;
                        } else {
                            obj3 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable fillInStackTrace() {
        if (q0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.util.concurrent.CancellationException
    public int hashCode() {
        int i;
        String message = getMessage();
        n.d(message);
        Throwable cause = getCause();
        if (cause == null) {
            i = 0;
        } else {
            i = cause.hashCode();
        }
        return i5 += i;
    }

    @Override // java.util.concurrent.CancellationException
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("; job=");
        stringBuilder.append(this.job);
        return stringBuilder.toString();
    }
}
