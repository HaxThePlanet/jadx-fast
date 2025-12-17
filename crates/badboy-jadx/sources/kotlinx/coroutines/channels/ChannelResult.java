package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0003\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 %*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003$%&B\u0016\u0008\u0001\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\t2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\u0008\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\u0008\u0019\u0010\u0005J\r\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\u0008\u001b\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\u0008\"\u0010#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000b\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006'", d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getHolder$annotations", "()V", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "isSuccess", "isSuccess-impl", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "getOrThrow", "getOrThrow-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Closed", "Companion", "Failed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ChannelResult<T>  {

    public static final kotlinx.coroutines.channels.ChannelResult.Companion Companion;
    private static final kotlinx.coroutines.channels.ChannelResult.Failed failed;
    private final Object holder;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Closed extends kotlinx.coroutines.channels.ChannelResult.Failed {

        public final Throwable cause;
        public Closed(Throwable cause) {
            super();
            this.cause = cause;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult$Failed
        public boolean equals(Object other) {
            boolean equal;
            int i;
            Throwable cause;
            if (other instanceof ChannelResult.Closed && Intrinsics.areEqual(this.cause, obj.cause)) {
                i = Intrinsics.areEqual(this.cause, obj.cause) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult$Failed
        public int hashCode() {
            int i;
            Throwable cause = this.cause;
            if (cause != null) {
                i = cause.hashCode();
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult$Failed
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Closed(").append(this.cause).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\n\u0008\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0001\u0010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ$\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0001\u0010\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ,\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0001\u0010\u00072\u0006\u0010\u0010\u001a\u0002H\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008\u0019¨\u0006\u0013", d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "()V", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "closed", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "success", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <E> Object closed-JP2dKIU(Throwable cause) {
            ChannelResult.Closed closed = new ChannelResult.Closed(cause);
            return ChannelResult.constructor-impl(closed);
        }

        public final <E> Object failure-PtdJZtk() {
            return ChannelResult.constructor-impl(ChannelResult.access$getFailed$cp());
        }

        public final <E> Object success-JP2dKIU(E value) {
            return ChannelResult.constructor-impl(value);
        }
    }
    static {
        ChannelResult.Companion companion = new ChannelResult.Companion(0);
        ChannelResult.Companion = companion;
        ChannelResult.Failed failed = new ChannelResult.Failed();
        ChannelResult.failed = failed;
    }

    private ChannelResult(Object holder) {
        super();
        this.holder = holder;
    }

    public static final kotlinx.coroutines.channels.ChannelResult.Failed access$getFailed$cp() {
        return ChannelResult.failed;
    }

    public static final kotlinx.coroutines.channels.ChannelResult box-impl(Object object) {
        ChannelResult channelResult = new ChannelResult(object);
        return channelResult;
    }

    public static <T> Object constructor-impl(Object object) {
        return object;
    }

    public static boolean equals-impl(Object object, Object object2) {
        final int i2 = 0;
        if (object2 instanceof ChannelResult == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(object, (ChannelResult)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static final Throwable exceptionOrNull-impl(Object arg0) {
        Object obj;
        int cause;
        if (arg0 instanceof ChannelResult.Closed) {
            obj = arg0;
        } else {
            obj = cause;
        }
        if (obj != null) {
            cause = obj.cause;
        }
        return cause;
    }

    public static void getHolder$annotations() {
    }

    public static final T getOrNull-impl(Object arg0) {
        Object obj;
        obj = !arg0 instanceof ChannelResult.Failed ? arg0 : 0;
        return obj;
    }

    public static final T getOrThrow-impl(Object arg0) {
        boolean cause;
        if (!arg0 instanceof ChannelResult.Failed) {
            return arg0;
        }
        if (!arg0 instanceof ChannelResult.Closed) {
        } else {
            if (obj.cause != null) {
                throw obj2.cause;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Trying to call 'getOrThrow' on a failed channel result: ").append(arg0).toString().toString());
        throw illegalStateException;
    }

    public static int hashCode-impl(Object object) {
        int i;
        if (object == null) {
            i = 0;
        } else {
            i = object.hashCode();
        }
        return i;
    }

    public static final boolean isClosed-impl(Object arg0) {
        return arg0 instanceof ChannelResult.Closed;
    }

    public static final boolean isFailure-impl(Object arg0) {
        return arg0 instanceof ChannelResult.Failed;
    }

    public static final boolean isSuccess-impl(Object arg0) {
        return z ^= 1;
    }

    public static String toString-impl(Object arg0) {
        String string;
        int i;
        if (arg0 instanceof ChannelResult.Closed) {
            string = (ChannelResult.Closed)arg0.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("Value(").append(arg0).append(')').toString();
        }
        return string;
    }

    public boolean equals(Object object) {
        return ChannelResult.equals-impl(this.holder, object);
    }

    public int hashCode() {
        return ChannelResult.hashCode-impl(this.holder);
    }

    public String toString() {
        return ChannelResult.toString-impl(this.holder);
    }

    public final Object unbox-impl() {
        return this.holder;
    }
}
