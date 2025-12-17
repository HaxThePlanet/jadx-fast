package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a+\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0008H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0084\u0001\u0010\n\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u0006\"\u0004\u0008\u0001\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u000c\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u0002H\u00060\r2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\u0014\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u0012\u001a0\u0010\u0013\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u0006\"\u0008\u0008\u0001\u0010\u000b*\u0002H\u0006*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052\u0006\u0010\u0014\u001a\u0002H\u0006H\u0087\u0008¢\u0006\u0002\u0010\u0015\u001a[\u0010\u0016\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u0006\"\u0008\u0008\u0001\u0010\u000b*\u0002H\u0006*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0018\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u0005H\u0087\u0008¢\u0006\u0002\u0010\u0019\u001a]\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u0006\"\u0004\u0008\u0001\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aP\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u0006\"\u0004\u0008\u0001\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0002\u0012\u0004\u0012\u00020\u001e0\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u001e0\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aa\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u0006\"\u0008\u0008\u0001\u0010\u000b*\u0002H\u0006*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aT\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u0006\"\u0008\u0008\u0001\u0010\u000b*\u0002H\u0006*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a@\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\r¢\u0006\u0002\u0008!H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\"\u001a\u00020\u001e*\u0006\u0012\u0002\u0008\u00030\u0005H\u0001¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006$", d2 = {"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ResultKt {
    public static final Object createFailure(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Result.Failure failure = new Result.Failure(exception);
        return failure;
    }

    private static final <R, T> R fold(Object $this$fold, Function1<? super T, ? extends R> onSuccess, Function1<? super Throwable, ? extends R> onFailure) {
        Object invoke;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$fold);
        if (exceptionOrNull-impl == null) {
            invoke = onSuccess.invoke($this$fold);
        } else {
            invoke = onFailure.invoke(exceptionOrNull-impl);
        }
        return invoke;
    }

    private static final <R, T extends R> R getOrDefault(Object $this$getOrDefault, R defaultValue) {
        if (Result.isFailure-impl($this$getOrDefault)) {
            return defaultValue;
        }
        return $this$getOrDefault;
    }

    private static final <R, T extends R> R getOrElse(Object $this$getOrElse, Function1<? super Throwable, ? extends R> onFailure) {
        Object invoke;
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$getOrElse);
        if (exceptionOrNull-impl == null) {
            invoke = $this$getOrElse;
        } else {
            invoke = onFailure.invoke(exceptionOrNull-impl);
        }
        return invoke;
    }

    private static final <T> T getOrThrow(Object $this$getOrThrow) {
        ResultKt.throwOnFailure($this$getOrThrow);
        return $this$getOrThrow;
    }

    private static final <R, T> Object map(Object $this$map, Function1<? super T, ? extends R> transform) {
        Object constructor-impl;
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (Result.isSuccess-impl($this$map)) {
            kotlin.Result.Companion companion = Result.Companion;
            constructor-impl = Result.constructor-impl(transform.invoke($this$map));
        } else {
            constructor-impl = Result.constructor-impl($this$map);
        }
        return constructor-impl;
    }

    private static final <R, T> Object mapCatching(Object $this$mapCatching, Function1<? super T, ? extends R> transform) {
        Object constructor-impl;
        kotlin.Result.Companion companion;
        Object invoke;
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (Result.isSuccess-impl($this$mapCatching)) {
            kotlin.Result.Companion companion2 = Result.Companion;
            companion = 0;
            constructor-impl = Result.constructor-impl(transform.invoke($this$mapCatching));
        } else {
            constructor-impl = Result.constructor-impl($this$mapCatching);
        }
        return constructor-impl;
    }

    private static final <T> Object onFailure(Object $this$onFailure, Function1<? super Throwable, kotlin.Unit> action) {
        int i;
        Intrinsics.checkNotNullParameter(action, "action");
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$onFailure);
        if (exceptionOrNull-impl != null) {
            i = 0;
            action.invoke(exceptionOrNull-impl);
        }
        return $this$onFailure;
    }

    private static final <T> Object onSuccess(Object $this$onSuccess, Function1<? super T, kotlin.Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Result.isSuccess-impl($this$onSuccess)) {
            action.invoke($this$onSuccess);
        }
        return $this$onSuccess;
    }

    private static final <R, T extends R> Object recover(Object $this$recover, Function1<? super Throwable, ? extends R> transform) {
        Object constructor-impl;
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$recover);
        if (exceptionOrNull-impl == null) {
            constructor-impl = $this$recover;
        } else {
            kotlin.Result.Companion companion = Result.Companion;
            constructor-impl = Result.constructor-impl(transform.invoke(exceptionOrNull-impl));
        }
        return constructor-impl;
    }

    private static final <R, T extends R> Object recoverCatching(Object $this$recoverCatching, Function1<? super Throwable, ? extends R> transform) {
        Object constructor-impl;
        kotlin.Result.Companion companion;
        Object invoke;
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$recoverCatching);
        if (exceptionOrNull-impl == null) {
            constructor-impl = $this$recoverCatching;
        } else {
            kotlin.Result.Companion companion2 = Result.Companion;
            Object obj = $this$recoverCatching;
            companion = 0;
            constructor-impl = Result.constructor-impl(transform.invoke(exceptionOrNull-impl));
        }
        return constructor-impl;
    }

    private static final <T, R> Object runCatching(T $this$runCatching, Function1<? super T, ? extends R> block) {
        Object constructor-impl;
        kotlin.Result.Companion constructor-impl2;
        Intrinsics.checkNotNullParameter(block, "block");
        kotlin.Result.Companion companion = Result.Companion;
        constructor-impl = Result.constructor-impl(block.invoke($this$runCatching));
        return constructor-impl;
    }

    private static final <R> Object runCatching(Function0<? extends R> block) {
        Object constructor-impl;
        kotlin.Result.Companion constructor-impl2;
        Intrinsics.checkNotNullParameter(block, "block");
        kotlin.Result.Companion companion = Result.Companion;
        constructor-impl = Result.constructor-impl(block.invoke());
        return constructor-impl;
    }

    public static final void throwOnFailure(Object $this$throwOnFailure) {
        if ($this$throwOnFailure instanceof Result.Failure) {
        } else {
        }
        throw obj.exception;
    }
}
