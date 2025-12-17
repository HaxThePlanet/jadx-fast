package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class CompositeException extends RuntimeException {

    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    static final class a extends RuntimeException {

        private static final long serialVersionUID = 3875212506787802066L;
        @Override // java.lang.RuntimeException
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class b {
        abstract void a(Object object);
    }

    static final class c extends io.reactivex.exceptions.CompositeException.b {

        private final PrintStream a;
        c(PrintStream printStream) {
            super();
            this.a = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException$b
        void a(Object object) {
            this.a.println(object);
        }
    }

    static final class d extends io.reactivex.exceptions.CompositeException.b {

        private final PrintWriter a;
        d(PrintWriter printWriter) {
            super();
            this.a = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException$b
        void a(Object object) {
            this.a.println(object);
        }
    }
    public CompositeException(Iterable<? extends Throwable> iterable) {
        boolean next;
        Object nullPointerException;
        String str;
        Object obj5;
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            obj5 = iterable.iterator();
            while (obj5.hasNext()) {
                nullPointerException = obj5.next();
                if (nullPointerException instanceof CompositeException != null) {
                } else {
                }
                if ((Throwable)nullPointerException != null) {
                } else {
                }
                nullPointerException = new NullPointerException("Throwable was null!");
                linkedHashSet.add(nullPointerException);
                linkedHashSet.add((Throwable)nullPointerException);
                linkedHashSet.addAll((CompositeException)nullPointerException.b());
            }
        } else {
            obj5 = new NullPointerException("errors was null");
            linkedHashSet.add(obj5);
        }
        if (linkedHashSet.isEmpty()) {
        } else {
            arrayList.addAll(linkedHashSet);
            obj5 = Collections.unmodifiableList(arrayList);
            this.exceptions = obj5;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj5.size());
            stringBuilder.append(" exceptions occurred. ");
            this.message = stringBuilder.toString();
        }
        obj5 = new IllegalArgumentException("errors is empty");
        throw obj5;
    }

    public CompositeException(Throwable... throwableArr) {
        String str;
        List obj2;
        if (throwableArr == null) {
            obj2 = new NullPointerException("exceptions was null");
            obj2 = Collections.singletonList(obj2);
        } else {
            obj2 = Arrays.asList(throwableArr);
        }
        super(obj2);
    }

    private void a(StringBuilder stringBuilder, Throwable throwable2, String string3) {
        int i;
        java.lang.StackTraceElement stack;
        String str;
        Object obj7;
        Object obj8;
        stringBuilder.append(string3);
        stringBuilder.append(throwable2);
        obj8 = 10;
        stringBuilder.append(obj8);
        final java.lang.StackTraceElement[] stackTrace = throwable2.getStackTrace();
        i = 0;
        while (i < stackTrace.length) {
            stringBuilder.append("\t\tat ");
            stringBuilder.append(stackTrace[i]);
            stringBuilder.append(obj8);
            i++;
        }
        if (throwable2.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            a(stringBuilder, throwable2.getCause(), "");
        }
    }

    private List<Throwable> c(Throwable throwable) {
        Throwable cause;
        Throwable obj3;
        ArrayList arrayList = new ArrayList();
        cause = throwable.getCause();
        if (cause != null && cause == throwable) {
            if (cause == throwable) {
            }
        }
        return arrayList;
    }

    private void e(io.reactivex.exceptions.CompositeException.b compositeException$b) {
        int i;
        int next;
        java.lang.StackTraceElement str2;
        String str;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        int i3 = 10;
        stringBuilder.append(i3);
        java.lang.StackTraceElement[] stackTrace = getStackTrace();
        next = 0;
        while (next < stackTrace.length) {
            stringBuilder.append("\tat ");
            stringBuilder.append(stackTrace[next]);
            stringBuilder.append(i3);
            next++;
        }
        Iterator iterator = this.exceptions.iterator();
        int i4 = 1;
        i = i4;
        for (Throwable next : iterator) {
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(i);
            stringBuilder.append(" :\n");
            a(stringBuilder, next, "\t");
            i += i4;
        }
        b.a(stringBuilder.toString());
    }

    public List<Throwable> b() {
        return this.exceptions;
    }

    @Override // java.lang.RuntimeException
    Throwable d(Throwable throwable) {
        Throwable cause;
        Throwable obj2;
        cause = throwable.getCause();
        if (cause != null && throwable == cause) {
            if (throwable == cause) {
            }
            return cause;
        }
        return throwable;
    }

    @Override // java.lang.RuntimeException
    public Throwable getCause() {
        Throwable aVar;
        HashSet hashSet;
        Iterator iterator;
        io.reactivex.exceptions.CompositeException.a exc;
        Object runtimeException;
        Iterator contains;
        boolean next;
        boolean contains2;
        synchronized (this) {
            try {
                aVar = new CompositeException.a();
                hashSet = new HashSet();
                iterator = this.exceptions.iterator();
                exc = aVar;
                while (iterator.hasNext()) {
                    runtimeException = iterator.next();
                    if (hashSet.contains((Throwable)runtimeException)) {
                    } else {
                    }
                    hashSet.add(runtimeException);
                    contains = c(runtimeException).iterator();
                    while (contains.hasNext()) {
                        next = contains.next();
                        if (hashSet.contains((Throwable)next)) {
                        } else {
                        }
                        hashSet.add(next);
                        runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                    }
                    exc.initCause(runtimeException);
                    exc = d(exc);
                    next = contains.next();
                    if (hashSet.contains((Throwable)next)) {
                    } else {
                    }
                    hashSet.add(next);
                    runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                }
                runtimeException = iterator.next();
                if (hashSet.contains((Throwable)runtimeException)) {
                } else {
                }
                hashSet.add(runtimeException);
                contains = c(runtimeException).iterator();
                while (contains.hasNext()) {
                    next = contains.next();
                    if (hashSet.contains((Throwable)next)) {
                    } else {
                    }
                    hashSet.add(next);
                    runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                }
                next = contains.next();
                if (hashSet.contains((Throwable)next)) {
                } else {
                }
                runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                hashSet.add(next);
                exc.initCause(runtimeException);
                exc = d(exc);
                this.cause = aVar;
                return this.cause;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.lang.RuntimeException
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace(PrintStream printStream) {
        CompositeException.c cVar = new CompositeException.c(printStream);
        e(cVar);
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace(PrintWriter printWriter) {
        CompositeException.d dVar = new CompositeException.d(printWriter);
        e(dVar);
    }
}
