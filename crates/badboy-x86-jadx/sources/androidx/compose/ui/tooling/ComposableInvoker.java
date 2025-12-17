package androidx.compose.ui.tooling;

import _COROUTINE.ArtificialStackFrames;
import androidx.compose.runtime.Composer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Deprecated(message = "Use androidx.compose.runtime.reflect.ComposableMethodInvoker instead")
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0006\u001a\u00020\u00072\u0010\u0010\u0008\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\n0\t2\u0010\u0010\u000b\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\n0\tH\u0002¢\u0006\u0002\u0010\u000cJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\t\"\u0006\u0008\u0000\u0010\u001b\u0018\u0001*\u0002H\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\u0008¢\u0006\u0002\u0010\u001dJ;\u0010\u001e\u001a\u00020\u001f*\u0008\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\n0\t\"\u0006\u0012\u0002\u0008\u00030\nH\u0002¢\u0006\u0002\u0010 J7\u0010!\u001a\u0004\u0018\u00010\u001f*\u0006\u0012\u0002\u0008\u00030\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\"\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\u0008\u00030\nH\u0002J=\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020\u001f2\u0008\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006(", d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", "", "()V", "BITS_PER_INT", "", "SLOTS_PER_INT", "areParameterTypesCompatible", "", "composableMethodTypes", "", "Ljava/lang/Class;", "previewParameterTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "invokeComposable", "", "className", "", "methodName", "composer", "Landroidx/compose/runtime/Composer;", "args", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "dup", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findCompatibleComposeMethod", "Ljava/lang/reflect/Method;", "([Ljava/lang/reflect/Method;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "findComposableMethod", "previewParamArgs", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposableInvoker {

    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;
    public static final androidx.compose.ui.tooling.ComposableInvoker INSTANCE = null;
    private static final int SLOTS_PER_INT = 10;
    static {
        ComposableInvoker composableInvoker = new ComposableInvoker();
        ComposableInvoker.INSTANCE = composableInvoker;
    }

    private final boolean areParameterTypesCompatible(Class<?>[] composableMethodTypes, Class<?>[] previewParameterTypes) {
        int $this$all$iv;
        boolean assignableFrom;
        int length;
        Iterator iterator;
        int i2;
        Object next;
        ArrayList booleanValue;
        int i8;
        int i;
        int i4;
        int length2;
        int i3;
        int i5;
        Object obj;
        int i6;
        Object obj2;
        int i7;
        if (i9.length == $this$all$iv.length) {
            int i10 = composableMethodTypes;
            int i11 = 0;
            booleanValue = new ArrayList(i10.length);
            i8 = i10;
            i = 0;
            i4 = 0;
            i3 = 0;
            while (i3 < i8.length) {
                obj2 = obj;
                i7 = 0;
                next = $this$all$iv[i4];
                if (!Intrinsics.areEqual(JvmClassMappingKt.getKotlinClass(obj2), JvmClassMappingKt.getKotlinClass(next))) {
                } else {
                }
                i5 = 1;
                (Collection)booleanValue.add(Boolean.valueOf(i5));
                i3++;
                $this$all$iv = previewParameterTypes;
                i4 = i6;
                if (obj2.isAssignableFrom(next)) {
                } else {
                }
                i5 = 0;
            }
            ArrayList list = booleanValue;
            length = 0;
            if (list instanceof Collection != null && (Collection)(Iterable)(List)list.isEmpty()) {
                if ((Collection)list.isEmpty()) {
                    $this$all$iv = 1;
                } else {
                    iterator = list.iterator();
                    for (Object next : iterator) {
                        i8 = 0;
                    }
                    $this$all$iv = 1;
                }
            } else {
            }
            i2 = $this$all$iv != 0 ? 1 : 0;
        } else {
        }
        return i2;
    }

    private final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        return (int)ceil;
    }

    private final int defaultParamCount(int realValueParams) {
        return (int)ceil;
    }

    private final <T> T[] dup(T $this$dup, int count) {
        int nextInt;
        int i2;
        int i;
        final int i3 = 0;
        int i4 = 0;
        kotlin.ranges.IntRange until = RangesKt.until(i4, count);
        int i6 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
        final int i8 = 0;
        final Iterator iterator = until.iterator();
        while (iterator.hasNext()) {
            i2 = nextInt;
            i = 0;
            (Collection)arrayList.add($this$dup);
        }
        int i5 = 0;
        Intrinsics.reifiedOperationMarker(i4, "T?");
        return (Collection)(Collection)(List)arrayList.toArray(new Object[i4]);
    }

    private final Method findCompatibleComposeMethod(Method[] $this$findCompatibleComposeMethod, String methodName, Class<?>... args) {
        int i2;
        int i3;
        int parameterTypesCompatible;
        Object obj2;
        Object obj;
        int i;
        String parameterTypes;
        String copyOf;
        int i4;
        Object[] objArr = $this$findCompatibleComposeMethod;
        int i5 = 0;
        final int i6 = 0;
        i2 = i6;
        while (i2 < objArr.length) {
            obj2 = objArr[i2];
            obj = obj2;
            i = 0;
            if (!Intrinsics.areEqual(methodName, obj.getName())) {
            } else {
            }
            if (ComposableInvoker.INSTANCE.areParameterTypesCompatible(obj.getParameterTypes(), (Class[])Arrays.copyOf(args, args.length))) {
            } else {
            }
            i3 = i6;
            i2++;
            i3 = 1;
            StringBuilder stringBuilder2 = new StringBuilder();
            if (StringsKt.startsWith$default(obj.getName(), stringBuilder2.append(methodName).append('-').toString(), i6, 2, 0) && ComposableInvoker.INSTANCE.areParameterTypesCompatible(obj.getParameterTypes(), (Class[])Arrays.copyOf(args, args.length))) {
            } else {
            }
        }
        if (parameterTypesCompatible == 0) {
        } else {
            return parameterTypesCompatible;
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException(stringBuilder.append(methodName).append(" not found").toString());
        throw noSuchMethodException;
    }

    private final Method findComposableMethod(Class<?> $this$findComposableMethod, String methodName, Object... previewParamArgs) {
        int changedParamCount;
        Throwable e;
        Method compatibleComposeMethod;
        int length;
        Object[] array;
        int i5;
        Class[] arr;
        Object obj;
        Object obj2;
        int i2;
        String str;
        int i;
        Object class;
        Object string;
        int i3;
        int nextInt;
        Object obj3;
        int i4;
        final Object obj4 = this;
        int i7 = 0;
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        Object[] objArr4 = objArr3;
        int i12 = 0;
        final int i14 = 0;
        i = i14;
        class = 0;
        while (i < objArr4.length) {
            nextInt = 0;
            obj3 = i3;
            i4 = 0;
            if (obj3 != null) {
            }
            if (class != null) {
            }
            i++;
            class = 0;
            obj3 = 0;
            (Collection)arrayList.add(class);
            class = obj3.getClass();
        }
        int i6 = 0;
        Object[] objArr2 = $i$f$toTypedArray;
        int obj5 = this;
        int i9 = 0;
        kotlin.ranges.IntRange until = RangesKt.until(i14, obj4.changedParamCount(objArr2.length, i14));
        int i13 = 0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
        int i16 = 0;
        Iterator iterator = until.iterator();
        while (iterator.hasNext()) {
            obj3 = nextInt;
            i4 = 0;
            (Collection)arrayList2.add(Integer.TYPE);
        }
        int i11 = 0;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.addSpread(objArr2);
        spreadBuilder.add(Composer.class);
        spreadBuilder.addSpread((Class[])(Collection)(List)arrayList2.toArray(new Class[i14]));
        compatibleComposeMethod = obj4.findCompatibleComposeMethod($this$findComposableMethod.getDeclaredMethods(), methodName, (Class[])spreadBuilder.toArray(new Class[spreadBuilder.size()]));
        return compatibleComposeMethod;
    }

    private final Object getDefaultValue(Class<?> $this$getDefaultValue) {
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

    private final Object invokeComposableMethod(Method $this$invokeComposableMethod, Object instance, Composer composer, Object... args) {
        Class cls;
        int i5;
        int it2;
        int iNSTANCE;
        int i8;
        int i10;
        int i9;
        boolean it;
        int i2;
        Class<Composer> obj;
        int i3;
        int defaultParamCount;
        int i4;
        int i6;
        int i;
        int i11;
        int i7;
        Class[] parameterTypes;
        cls = this;
        final Object obj2 = instance;
        Class[] parameterTypes2 = $this$invokeComposableMethod.getParameterTypes();
        it2 = 0;
        i8 = -1;
        if (length2 += i8 >= 0) {
        } else {
        }
        int i13 = i8;
        i9 = obj2 != null ? 1 : 0;
        int changedParamCount = cls.changedParamCount(i13, i9);
        int length3 = parameterTypes3.length;
        i3 = length3 != i15 += changedParamCount ? 1 : 0;
        if (i3 != 0) {
            defaultParamCount = cls.defaultParamCount(i13);
        } else {
            defaultParamCount = 0;
        }
        i4 = i18 += defaultParamCount == length3 ? 1 : 0;
        if (i4 == 0) {
        } else {
            int i20 = i8 + 1;
            final int i21 = i20 + changedParamCount;
            final Object[] arr = new Object[length3];
            i6 = 0;
            while (i6 < length3) {
                if (i6 >= 0 && i6 < i13) {
                } else {
                }
                i = 0;
                i7 = 0;
                if (i20 <= i6 && i6 < i21) {
                } else {
                }
                cls = i7;
                if (i21 <= i6 && i6 < length3) {
                } else {
                }
                i5 = i7;
                it2 = 2097151;
                arr[i6] = it2;
                i6++;
                cls = this;
                if (i6 < length3) {
                } else {
                }
                i5 = 1;
                it2 = Integer.valueOf(i7);
                if (i6 < i21) {
                } else {
                }
                cls = 1;
                it2 = composer;
                if (i6 >= 0 && i6 <= ArraysKt.getLastIndex(args)) {
                } else {
                }
                int i14 = i6;
                i11 = 0;
                i7 = 0;
                it2 = ComposableInvoker.INSTANCE.getDefaultValue($this$invokeComposableMethod.getParameterTypes()[i6]);
                if (i6 <= ArraysKt.getLastIndex(args)) {
                } else {
                }
                it2 = args[i6];
                i7 = 0;
                if (i6 < i13) {
                } else {
                }
                i = 1;
            }
            return $this$invokeComposableMethod.invoke(obj2, Arrays.copyOf(arr, arr.length));
        }
        Object obj4 = $this$invokeComposableMethod;
        int i12 = 0;
        IllegalStateException illegalStateException2 = new IllegalStateException("params don't add up to total params".toString());
        throw illegalStateException2;
    }

    public final void invokeComposable(String className, String methodName, Composer composer, Object... args) {
        Object copyOf2;
        Object[] copyOf;
        final Class forName = Class.forName(className);
        Method composableMethod = findComposableMethod(forName, methodName, Arrays.copyOf(args, args.length));
        if (composableMethod == null) {
        } else {
            composableMethod.setAccessible(true);
            if (Modifier.isStatic(composableMethod.getModifiers())) {
                invokeComposableMethod(composableMethod, 0, composer, Arrays.copyOf(args, args.length));
            } else {
                int i4 = 0;
                invokeComposableMethod(composableMethod, forName.getConstructor(new Class[i4]).newInstance(new Object[i4]), composer, Arrays.copyOf(args, args.length));
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException(stringBuilder.append("Composable ").append(className).append('.').append(methodName).append(" not found").toString());
                throw noSuchMethodException;
                StringBuilder sb = new StringBuilder();
                sb = sb.append("Failed to invoke Composable Method '");
                sb = sb.append(className);
                char string = sb.append(string);
                string = string.append(methodName);
                sb = 39;
                string = string.append(sb);
                string = string.toString();
                sb = 2;
                PreviewLogger.Companion.logWarning$ui_tooling_release$default(PreviewLogger.Companion, string, obj1, sb, obj1);
                throw composableClass;
            }
        }
    }
}
