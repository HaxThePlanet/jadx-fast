package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB!\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0005\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u0008J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "detailMessage", "", "innerThrowables", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "printStackTrace", "", "err", "Ljava/io/PrintStream;", "Ljava/io/PrintWriter;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AggregateException extends Exception {

    private static final long serialVersionUID = 1L;
    private final List<Throwable> innerThrowables;
    static {
    }

    @Override // java.lang.Exception
    public void printStackTrace(PrintStream printStream) {
        int i;
        Object next;
        String str2;
        String str;
        n.f(printStream, "err");
        super.printStackTrace(printStream);
        Iterator iterator = this.innerThrowables.iterator();
        i = -1;
        while (iterator.hasNext()) {
            next = iterator.next();
            str2 = "\n";
            printStream.append(str2);
            printStream.append("  Inner throwable #");
            printStream.append(String.valueOf(i++));
            printStream.append(": ");
            if ((Throwable)next != null) {
            }
            printStream.append(str2);
            (Throwable)next.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Exception
    public void printStackTrace(PrintWriter printWriter) {
        int i;
        Object next;
        String str2;
        String str;
        n.f(printWriter, "err");
        super.printStackTrace(printWriter);
        Iterator iterator = this.innerThrowables.iterator();
        i = -1;
        while (iterator.hasNext()) {
            next = iterator.next();
            str2 = "\n";
            printWriter.append(str2);
            printWriter.append("  Inner throwable #");
            printWriter.append(String.valueOf(i++));
            printWriter.append(": ");
            if ((Throwable)next != null) {
            }
            printWriter.append(str2);
            (Throwable)next.printStackTrace(printWriter);
        }
    }
}
