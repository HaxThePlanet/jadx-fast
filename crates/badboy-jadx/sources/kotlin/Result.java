package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0087@\u0018\u0000 \"*\u0006\u0008\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\"#B\u0013\u0008\u0001\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\t2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0087\u0008¢\u0006\u0004\u0008\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\u0008 \u0010!R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u000f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0005¨\u0006$", d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "getValue$annotations", "()V", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class Result<T>  implements Serializable {

    public static final kotlin.Result.Companion Companion;
    private final Object value;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0008¢\u0006\u0002\u0010\u0008J\"\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\u0087\u0008¢\u0006\u0002\u0010\u000b¨\u0006\u000c", d2 = {"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final <T> Object failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return Result.constructor-impl(ResultKt.createFailure(exception));
        }

        private final <T> Object success(T value) {
            return Result.constructor-impl(value);
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Failure implements Serializable {

        public final Throwable exception;
        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            super();
            this.exception = exception;
        }

        @Override // java.io.Serializable
        public boolean equals(Object other) {
            boolean equal;
            int i;
            Throwable exception;
            if (other instanceof Result.Failure && Intrinsics.areEqual(this.exception, obj.exception)) {
                i = Intrinsics.areEqual(this.exception, obj.exception) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // java.io.Serializable
        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // java.io.Serializable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Failure(").append(this.exception).append(')').toString();
        }
    }
    static {
        Result.Companion companion = new Result.Companion(0);
        Result.Companion = companion;
    }

    private Result(Object value) {
        super();
        this.value = value;
    }

    public static final kotlin.Result box-impl(Object object) {
        Result result = new Result(object);
        return result;
    }

    public static <T> Object constructor-impl(Object object) {
        return object;
    }

    public static boolean equals-impl(Object object, Object object2) {
        final int i2 = 0;
        if (object2 instanceof Result == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(object, (Result)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static final Throwable exceptionOrNull-impl(Object arg0) {
        Throwable exception;
        if (arg0 instanceof Result.Failure) {
            exception = obj.exception;
        } else {
            exception = 0;
        }
        return exception;
    }

    private static final T getOrNull-impl(Object arg0) {
        int i;
        i = Result.isFailure-impl(arg0) ? 0 : arg0;
        return i;
    }

    public static void getValue$annotations() {
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

    public static final boolean isFailure-impl(Object arg0) {
        return arg0 instanceof Result.Failure;
    }

    public static final boolean isSuccess-impl(Object arg0) {
        return z ^= 1;
    }

    public static String toString-impl(Object arg0) {
        String string;
        int i;
        if (arg0 instanceof Result.Failure) {
            string = arg0.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("Success(").append(arg0).append(')').toString();
        }
        return string;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        return Result.equals-impl(this.value, object);
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return Result.hashCode-impl(this.value);
    }

    @Override // java.io.Serializable
    public String toString() {
        return Result.toString-impl(this.value);
    }

    @Override // java.io.Serializable
    public final Object unbox-impl() {
        return this.value;
    }
}
