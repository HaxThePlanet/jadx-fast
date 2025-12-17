package kotlinx.coroutines.d3;

import kotlin.Metadata;
import kotlinx.coroutines.r0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends kotlinx.coroutines.d3.i {

    public final Runnable c;
    public k(Runnable runnable, long l2, kotlinx.coroutines.d3.j j3) {
        super(l2, j3, obj4);
        this.c = runnable;
    }

    @Override // kotlinx.coroutines.d3.i
    public void run() {
        try {
            this.c.run();
            this.b.k();
            this.b.k();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.d3.i
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Task[");
        stringBuilder.append(r0.a(this.c));
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this.c));
        String str4 = ", ";
        stringBuilder.append(str4);
        stringBuilder.append(this.a);
        stringBuilder.append(str4);
        stringBuilder.append(this.b);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
