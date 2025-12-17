package androidx.compose.runtime.reflect;

import _COROUTINE.ArtificialStackFrames;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u000c\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0008\u001a(\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u0002H\u000b2\u0006\u0010\u000c\u001a\u00020\u0001H\u0082\u0008¢\u0006\u0002\u0010\r\u001a\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u0008H\u0002\u001a7\u0010\u0010\u001a\u00020\u0007*\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0014\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00110\n\"\u0006\u0012\u0002\u0008\u00030\u0011¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0006\u0012\u0002\u0008\u00030\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "Ljava/lang/reflect/Method;", "dup", "", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "getDeclaredComposableMethod", "Ljava/lang/Class;", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "getDefaultValue", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposableMethodKt {

    private static final int BITS_PER_INT = 31;
    public static final Object access$getDefaultValue(Class $receiver) {
        return ComposableMethodKt.getDefaultValue($receiver);
    }

    public static final androidx.compose.runtime.reflect.ComposableMethod asComposableMethod(Method $this$asComposableMethod) {
        final androidx.compose.runtime.reflect.ComposableInfo composableInfo = ComposableMethodKt.getComposableInfo($this$asComposableMethod);
        if (composableInfo.isComposable()) {
            ComposableMethod composableMethod = new ComposableMethod($this$asComposableMethod, composableInfo);
            return composableMethod;
        }
        return null;
    }

    private static final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        return (int)ceil;
    }

    private static final int defaultParamCount(int realValueParams) {
        return (int)ceil;
    }

    private static final <T> T[] dup(T $this$dup, int count) {
        int nextInt;
        int i;
        int i2;
        final int i3 = 0;
        int i4 = 0;
        kotlin.ranges.IntRange until = RangesKt.until(i4, count);
        int i6 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
        final int i8 = 0;
        final Iterator iterator = until.iterator();
        while (iterator.hasNext()) {
            i = nextInt;
            i2 = 0;
            (Collection)arrayList.add($this$dup);
        }
        int i5 = 0;
        Intrinsics.reifiedOperationMarker(i4, "T?");
        return (Collection)(Collection)(List)arrayList.toArray(new Object[i4]);
    }

    private static final androidx.compose.runtime.reflect.ComposableInfo getComposableInfo(Method $this$getComposableInfo) {
        int i2;
        int i3;
        int index$iv;
        boolean it;
        int i4;
        Class<androidx.compose.runtime.Composer> obj;
        int i;
        int defaultParamCount;
        Class[] parameterTypes = $this$getComposableInfo.getParameterTypes();
        int i5 = 0;
        int i8 = -1;
        if (length += i8 >= 0) {
        } else {
            index$iv = i8;
        }
        i2 = 0;
        if (index$iv == i8) {
            ComposableInfo composableInfo = new ComposableInfo(i2, parameterTypes2.length, i2, i2);
            return composableInfo;
        }
        int i7 = 1;
        int changedParamCount = ComposableMethodKt.changedParamCount(index$iv, static ^= i7);
        i9 += changedParamCount;
        int length3 = parameterTypes3.length;
        i = length3 != i10 ? i7 : i2;
        if (i != 0) {
            defaultParamCount = ComposableMethodKt.defaultParamCount(index$iv);
        } else {
            defaultParamCount = i2;
        }
        if (i10 + defaultParamCount == length3) {
            i2 = i7;
        }
        ComposableInfo composableInfo2 = new ComposableInfo(i2, index$iv, changedParamCount, defaultParamCount);
        return composableInfo2;
    }

    public static final androidx.compose.runtime.reflect.ComposableMethod getDeclaredComposableMethod(Class<?> $this$getDeclaredComposableMethod, String methodName, Class<?>... args) throws java.lang.NoSuchMethodException {
        Method declaredMethod;
        int i;
        int i5;
        int $this$mapTo$iv$iv$iv;
        int i2;
        Throwable th;
        int defaultParamCount;
        int tYPE;
        int i3;
        kotlin.ranges.IntRange intRange;
        ArrayList arrayList2;
        int i4;
        Object[] array;
        ArrayList arrayList;
        int i6;
        int nextInt2;
        Iterator nextInt;
        boolean z2;
        boolean z;
        int i7;
        final Object obj = $this$getDeclaredComposableMethod;
        final String str = methodName;
        final Object obj2 = args;
        i5 = 0;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.addSpread(obj2);
        spreadBuilder.add(Composer.class);
        final int i10 = 0;
        kotlin.ranges.IntRange until = RangesKt.until(i5, ComposableMethodKt.changedParamCount(obj2.length, i5));
        int i12 = 0;
        arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
        final int i13 = 0;
        final Iterator iterator = until.iterator();
        while (iterator.hasNext()) {
            nextInt = nextInt2;
            z2 = 0;
            (Collection)arrayList2.add(Integer.TYPE);
        }
        int i11 = 0;
        spreadBuilder.addSpread((Collection)(List)arrayList2.toArray(new Class[i5]));
        declaredMethod = obj.getDeclaredMethod(str, (Class[])spreadBuilder.toArray(new Class[spreadBuilder.size()]));
        if (declaredMethod == null) {
        } else {
            androidx.compose.runtime.reflect.ComposableMethod composableMethod = ComposableMethodKt.asComposableMethod(declaredMethod);
            Intrinsics.checkNotNull(composableMethod);
            return composableMethod;
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchMethodException method = new NoSuchMethodException(stringBuilder.append(obj.getName()).append('.').append(str).toString());
        throw method;
    }

    private static final Object getDefaultValue(Class<?> $this$getDefaultValue) {
        int valueOf;
        String equals;
        String str;
        int i2;
        equals = $this$getDefaultValue.getName();
        if (equals != null) {
            i2 = 0;
            switch (equals) {
                case "double":
                    str = "double";
                    valueOf = Double.valueOf(0);
                    valueOf = 0;
                    break;
                case "int":
                    valueOf = Integer.valueOf(i2);
                    valueOf = 0;
                    break;
                case "byte":
                    valueOf = Byte.valueOf(i2);
                    valueOf = 0;
                    break;
                case "char":
                    valueOf = Character.valueOf(i2);
                    valueOf = 0;
                    break;
                case "long":
                    str = "long";
                    valueOf = Long.valueOf(0);
                    valueOf = 0;
                    break;
                case "boolean":
                    valueOf = Boolean.valueOf(i2);
                    valueOf = 0;
                    break;
                case "float":
                    valueOf = 0f;
                    valueOf = 0;
                    break;
                case "short":
                    valueOf = Short.valueOf(i2);
                    valueOf = 0;
                    break;
                default:
                    valueOf = 0;
            }
        } else {
        }
        return valueOf;
    }
}
