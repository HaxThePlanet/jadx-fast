package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001'B\t\u0008\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004B1\u0008\u0002\u0012&\u0010\u0005\u001a\"\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007`\u0008¢\u0006\u0004\u0008\u0003\u0010\tJ\u001a\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J]\u0010\u001a\u001a\u0002H\u001b\"\u0004\u0008\u0001\u0010\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000\u001d21\u0010\u001f\u001a-\u0008\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008(#\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u001b0$\u0012\u0006\u0012\u0004\u0018\u00010\u00020 H\u0086@¢\u0006\u0004\u0008%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR.\u0010\u0005\u001a\"\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0005\u0092\u0001\"\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00070\u0006j\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0007`\u0008¨\u0006(", d2 = {"Landroidx/compose/ui/SessionMutex;", "T", "", "constructor-impl", "()Ljava/util/concurrent/atomic/AtomicReference;", "currentSessionHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/SessionMutex$Session;", "Landroidx/compose/ui/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "currentSession", "getCurrentSession-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)I", "toString", "", "toString-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/String;", "withSessionCancellingPrevious", "R", "sessionInitializer", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "session", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "Lkotlin/coroutines/Continuation;", "withSessionCancellingPrevious-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Session", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class SessionMutex<T>  {

    private final AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> currentSessionHolder;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\n¨\u0006\u000c", d2 = {"Landroidx/compose/ui/SessionMutex$Session;", "T", "", "job", "Lkotlinx/coroutines/Job;", "value", "(Lkotlinx/coroutines/Job;Ljava/lang/Object;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Session {

        private final Job job;
        private final T value;
        public Session(Job job, T value) {
            super();
            this.job = job;
            this.value = value;
        }

        public final Job getJob() {
            return this.job;
        }

        public final T getValue() {
            return this.value;
        }
    }
    private SessionMutex(AtomicReference currentSessionHolder) {
        super();
        this.currentSessionHolder = currentSessionHolder;
    }

    public static final androidx.compose.ui.SessionMutex box-impl(AtomicReference atomicReference) {
        SessionMutex sessionMutex = new SessionMutex(atomicReference);
        return sessionMutex;
    }

    public static <T> AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> constructor-impl() {
        AtomicReference atomicReference = new AtomicReference(0);
        return SessionMutex.constructor-impl(atomicReference);
    }

    private static <T> AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> constructor-impl(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> atomicReference) {
        return atomicReference;
    }

    public static boolean equals-impl(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> atomicReference, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof SessionMutex) {
            return i2;
        }
        if (!Intrinsics.areEqual(atomicReference, (SessionMutex)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> atomicReference, AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> atomicReference2) {
        return Intrinsics.areEqual(atomicReference, atomicReference2);
    }

    public static final T getCurrentSession-impl(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> arg0) {
        Object value;
        Object obj = arg0.get();
        if ((SessionMutex.Session)obj != null) {
            value = (SessionMutex.Session)obj.getValue();
        } else {
            value = 0;
        }
        return value;
    }

    public static int hashCode-impl(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> atomicReference) {
        return atomicReference.hashCode();
    }

    public static String toString-impl(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> atomicReference) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SessionMutex(currentSessionHolder=").append(atomicReference).append(')').toString();
    }

    public static final <R> Object withSessionCancellingPrevious-impl(AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> arg0, Function1<? super CoroutineScope, ? extends T> sessionInitializer, Function2<? super T, ? super Continuation<? super R>, ? extends Object> session, Continuation<? super R> $completion) {
        SessionMutex.withSessionCancellingPrevious.2 anon = new SessionMutex.withSessionCancellingPrevious.2(sessionInitializer, arg0, session, 0);
        return CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
    }

    public boolean equals(Object object) {
        return SessionMutex.equals-impl(this.currentSessionHolder, object);
    }

    public int hashCode() {
        return SessionMutex.hashCode-impl(this.currentSessionHolder);
    }

    public String toString() {
        return SessionMutex.toString-impl(this.currentSessionHolder);
    }

    public final AtomicReference unbox-impl() {
        return this.currentSessionHolder;
    }
}
