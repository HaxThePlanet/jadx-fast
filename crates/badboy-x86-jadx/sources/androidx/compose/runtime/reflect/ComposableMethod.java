package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0008H\u0016J:\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001d\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\u000c\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001b\u0010\u000b\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\r0\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001f", d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "parameterCount", "", "getParameterCount", "()I", "parameterTypes", "", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "parameters", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "asMethod", "equals", "", "other", "hashCode", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposableMethod {

    public static final int $stable = 8;
    private final androidx.compose.runtime.reflect.ComposableInfo composableInfo;
    private final Method method;
    static {
        final int i = 8;
    }

    public ComposableMethod(Method method, androidx.compose.runtime.reflect.ComposableInfo composableInfo) {
        super();
        this.method = method;
        this.composableInfo = composableInfo;
    }

    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(Object other) {
        boolean equal;
        Method method;
        if (other instanceof ComposableMethod) {
            equal = Intrinsics.areEqual(this.method, obj.method);
        } else {
            equal = 0;
        }
        return equal;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Class<?>[] getParameterTypes() {
        return (Class[])ArraysKt.copyOfRange(this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Parameter[] getParameters() {
        return (Parameter[])ArraysKt.copyOfRange(this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public final Object invoke(Composer composer, Object instance, Object... args) {
        Object[] objArr;
        int it2;
        int component4;
        Object defaultParams;
        int i4;
        int it;
        int lastIndex;
        int i7;
        int i8;
        int i9;
        int i6;
        int i5;
        int i;
        int i10;
        int accumulator$iv;
        Iterator iterator;
        boolean next;
        int next2;
        Iterator iterator2;
        boolean intValue;
        int i3;
        int i2;
        int defaultParams2;
        int i11;
        final Object obj = this;
        objArr = args;
        androidx.compose.runtime.reflect.ComposableInfo composableInfo = obj.composableInfo;
        final int component2 = composableInfo.component2();
        int length = parameterTypes.length;
        final int i13 = component2 + 1;
        final int i14 = i13 + component3;
        final Integer[] arr2 = new Integer[composableInfo.component4()];
        it = 0;
        Integer valueOf3 = Integer.valueOf(it);
        i9 = it;
        while (i9 < component4) {
            i5 = i9 * 31;
            kotlin.ranges.IntRange until = RangesKt.until(i5, Math.min(i5 + 31, component2));
            int i22 = 0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
            next2 = 0;
            iterator2 = until.iterator();
            while (iterator2.hasNext()) {
                i2 = 0;
                int i12 = i3;
                if (i12 < objArr.length) {
                } else {
                }
                it2 = 1;
                (Collection)arrayList.add(Integer.valueOf(it2));
                objArr = args;
                component4 = defaultParams2;
                if (args[i12] == null) {
                } else {
                }
                it2 = 0;
            }
            i6 = 0;
            i10 = 0;
            accumulator$iv = i15;
            iterator = (Iterable)(List)arrayList.iterator();
            while (iterator.hasNext()) {
                if (i10 < 0) {
                }
                i2 = 0;
                accumulator$iv = i21;
                i10 = iterator2;
                CollectionsKt.throwIndexOverflow();
            }
            arr2[i9] = Integer.valueOf(accumulator$iv);
            i9++;
            objArr = args;
            component4 = defaultParams2;
            it = 0;
            if (i10 < 0) {
            }
            i2 = 0;
            accumulator$iv = i21;
            i10 = iterator2;
            CollectionsKt.throwIndexOverflow();
            i2 = 0;
            i12 = i3;
            if (i12 < objArr.length) {
            } else {
            }
            it2 = 1;
            arrayList.add(Integer.valueOf(it2));
            objArr = args;
            component4 = defaultParams2;
            if (args[i12] == null) {
            } else {
            }
            it2 = 0;
        }
        int defaultParams3 = component4;
        Object[] arr = new Object[length];
        i4 = 0;
        while (i4 < length) {
            if (i4 >= 0 && i4 < component2) {
            } else {
            }
            lastIndex = 0;
            if (i13 + 1 <= i4 && i4 < i14) {
            } else {
            }
            i7 = 0;
            if (i14 <= i4 && i4 < length) {
            } else {
            }
            i8 = 0;
            it = arr2[i4 - i14];
            arr[i4] = it;
            i4++;
            if (i4 < length) {
            } else {
            }
            i8 = 1;
            it = valueOf3;
            if (i4 < i14) {
            } else {
            }
            i7 = 1;
            it = valueOf3;
            it = composer;
            if (i4 >= 0 && i4 <= ArraysKt.getLastIndex(args)) {
            } else {
            }
            int i18 = i4;
            i9 = 0;
            it = ComposableMethodKt.access$getDefaultValue(obj.method.getParameterTypes()[i4]);
            if (i4 <= ArraysKt.getLastIndex(args)) {
            } else {
            }
            it = args[i4];
            if (i4 < component2) {
            } else {
            }
            lastIndex = 1;
        }
        return obj.method.invoke(instance, Arrays.copyOf(arr, arr.length));
    }
}
