package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00062\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\nH\u0002\u001a.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a!\u0010\r\u001a\u0004\u0018\u0001H\u0008\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0008H\u0000¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\n2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0012\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\u0008\u0002\u0010\u0014\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0015", d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExceptionsConstructorKt {

    private static final kotlinx.coroutines.internal.CtorCache ctorCache = -1;
    private static final int throwableFields;
    static {
        kotlinx.coroutines.internal.CtorCache iNSTANCE;
        ExceptionsConstructorKt.throwableFields = ExceptionsConstructorKt.fieldsCountOrDefault(Throwable.class, -1);
        if (FastServiceLoaderKt.getANDROID_DETECTED()) {
            iNSTANCE = WeakMapCtorCache.INSTANCE;
        } else {
            iNSTANCE = ClassValueCtorCache.INSTANCE;
        }
    }

    public static final Function1 access$createConstructor(Class clz) {
        return ExceptionsConstructorKt.createConstructor(clz);
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> clz) {
        int first;
        int i4;
        boolean equal;
        Pair pair;
        boolean p0;
        Constructor[] next;
        int p02;
        int length2;
        int second;
        int valueOf;
        Constructor constructor;
        Constructor constructor2;
        int i3;
        Class[] parameterTypes;
        Class length;
        int i;
        int i2;
        int i5;
        final kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1 iNSTANCE = ExceptionsConstructorKt.createConstructor.nullResult.1.INSTANCE;
        i4 = 0;
        final Class cls3 = clz;
        if (ExceptionsConstructorKt.throwableFields != ExceptionsConstructorKt.fieldsCountOrDefault(cls3, i4)) {
            return (Function1)iNSTANCE;
        }
        Constructor[] constructors = cls3.getConstructors();
        int i6 = 0;
        ArrayList arrayList = new ArrayList(constructors.length);
        next = constructors;
        p02 = 0;
        second = i4;
        valueOf = 0;
        while (second < next.length) {
            constructor2 = constructor;
            i3 = 0;
            parameterTypes = constructor2.getParameterTypes();
            i = 1;
            i2 = -1;
            i5 = i4;
            pair = TuplesKt.to(valueOf, Integer.valueOf(i2));
            (Collection)arrayList.add(pair);
            second++;
            i4 = i5;
            valueOf = 0;
            i5 = i4;
            if (Intrinsics.areEqual(parameterTypes[i4], String.class) && Intrinsics.areEqual(parameterTypes[i], Throwable.class)) {
            } else {
            }
            pair = TuplesKt.to(valueOf, Integer.valueOf(i2));
            if (Intrinsics.areEqual(parameterTypes[i], Throwable.class)) {
            } else {
            }
            ExceptionsConstructorKt.createConstructor.1.1 anon = new ExceptionsConstructorKt.createConstructor.1.1(constructor2);
            pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1)anon), 3);
            Class cls2 = parameterTypes[i4];
            if (Intrinsics.areEqual(cls2, String.class)) {
            } else {
            }
            if (Intrinsics.areEqual(cls2, Throwable.class)) {
            } else {
            }
            pair = TuplesKt.to(valueOf, Integer.valueOf(i2));
            ExceptionsConstructorKt.createConstructor.1.3 anon3 = new ExceptionsConstructorKt.createConstructor.1.3(constructor2);
            pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1)anon3), Integer.valueOf(i));
            ExceptionsConstructorKt.createConstructor.1.2 anon4 = new ExceptionsConstructorKt.createConstructor.1.2(constructor2);
            pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1)anon4), 2);
            ExceptionsConstructorKt.createConstructor.1.4 anon2 = new ExceptionsConstructorKt.createConstructor.1.4(constructor2);
            pair = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1)anon2), Integer.valueOf(i4));
        }
        first = 0;
        Iterator iterator = (Iterable)(List)arrayList.iterator();
        if (!iterator.hasNext()) {
        } else {
            if (!iterator.hasNext()) {
            } else {
                next = 0;
                p0 = (Number)(Pair)iterator.next().getSecond().intValue();
                Object next2 = iterator.next();
                length2 = 0;
                p02 = (Number)(Pair)next2.getSecond().intValue();
                do {
                    next2 = iterator.next();
                    length2 = 0;
                    p02 = (Number)(Pair)next2.getSecond().intValue();
                    if (iterator.hasNext() != 0) {
                    }
                    p0 = p02;
                    valueOf = length2;
                } while (p0 < p02);
            }
        }
        if ((Pair)valueOf != 0) {
            if ((Function1)(Pair)valueOf.getFirst() == null) {
                first = iNSTANCE;
            }
        } else {
        }
        return first;
    }

    private static final int fieldsCount(Class<?> $this$fieldsCount, int accumulator) {
        int i2;
        Class superclass;
        int count$iv;
        int length;
        int i3;
        Field field2;
        Field field;
        int i;
        boolean static;
        Class obj9;
        int obj10;
        while (/* condition */) {
            while (i3 < length) {
                i = 0;
                if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
                }
                i3++;
                count$iv++;
            }
            i2 = obj10 + count$iv;
            superclass = obj9.getSuperclass();
            if (superclass != null) {
            }
            obj9 = superclass;
            obj10 = i2;
            Field[] declaredFields = obj9.getDeclaredFields();
            int i4 = 0;
            count$iv = 0;
            i3 = 0;
            i = 0;
            if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
            }
            i3++;
            count$iv++;
        }
        return i2;
    }

    static int fieldsCount$default(Class class, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return ExceptionsConstructorKt.fieldsCount(class, obj1);
    }

    private static final int fieldsCountOrDefault(Class<?> $this$fieldsCountOrDefault, int defaultValue) {
        Object constructor-impl;
        int i;
        kotlin.reflect.KClass kotlinClass = JvmClassMappingKt.getKotlinClass($this$fieldsCountOrDefault);
        kotlin.Result.Companion companion2 = Result.Companion;
        i = 0;
        constructor-impl = Result.constructor-impl(Integer.valueOf(ExceptionsConstructorKt.fieldsCount$default($this$fieldsCountOrDefault, 0, 1, 0)));
        if (Result.isFailure-impl(constructor-impl)) {
            constructor-impl = valueOf2;
        }
        try {
            return (Number)constructor-impl.intValue();
        }
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> block) {
        ExceptionsConstructorKt.safeCtor.1 anon = new ExceptionsConstructorKt.safeCtor.1(block);
        return (Function1)anon;
    }

    public static final <E extends Throwable> E tryCopyException(E exception) {
        Object constructor-impl;
        Throwable copy;
        if (exception instanceof CopyableThrowable) {
            kotlin.Result.Companion companion = Result.Companion;
            int i = 0;
            constructor-impl = Result.constructor-impl((CopyableThrowable)exception.createCopy());
            if (Result.isFailure-impl(constructor-impl)) {
                try {
                    constructor-impl = 0;
                    return (Throwable)constructor-impl;
                    return (Throwable)ExceptionsConstructorKt.ctorCache.get(exception.getClass()).invoke(exception);
                }
            }
        }
    }
}
