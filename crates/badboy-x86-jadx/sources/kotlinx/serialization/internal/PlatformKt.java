package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0008¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0008\u001a\u001c\u0010\u0008\u001a\u00020\u0006\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\nH\u0000\u001a$\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\nH\u0000\u001aK\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u0002\"\u0008\u0008\u0000\u0010\u0001*\u00020\t\"\n\u0008\u0001\u0010\u000e*\u0004\u0018\u0001H\u0001*\u0012\u0012\u0004\u0012\u0002H\u000e0\u000fj\u0008\u0012\u0004\u0012\u0002H\u000e`\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\nH\u0000¢\u0006\u0002\u0010\u0012\u001a\u0010\u0010\u0013\u001a\u00020\u0014*\u0006\u0012\u0002\u0008\u00030\nH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u0014*\u0006\u0012\u0002\u0008\u00030\u0016H\u0000\u001aM\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\n2\"\u0010\u0018\u001a\u0012\u0012\u000e\u0008\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000c0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000cH\u0000¢\u0006\u0002\u0010\u0019\u001aM\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\u0008\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000c0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000cH\u0000¢\u0006\u0002\u0010\u001a\u001aM\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\u0008\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000c0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000cH\u0002¢\u0006\u0002\u0010\u001a\u001a\u001e\u0010\u001c\u001a\u0004\u0018\u00010\t\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a\u001c\u0010\u001d\u001a\u00020\u0006\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a\u001c\u0010\u001e\u001a\u00020\u0006\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001aO\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t2\n\u0010 \u001a\u0006\u0012\u0002\u0008\u00030\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\u0008\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000c0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000cH\u0002¢\u0006\u0002\u0010\u001a\u001aK\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t2\u0006\u0010\"\u001a\u00020\t2\"\u0010\u0018\u001a\u0012\u0012\u000e\u0008\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000c0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000cH\u0002¢\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\u0008\u00030\u00162\u0006\u0010%\u001a\u00020&H\u0002\u001a\"\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a$\u0010(\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u000c\"\u0008\u0008\u0000\u0010\u0001*\u00020\t*\u0008\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a\u0016\u0010)\u001a\u00020\u00062\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\t0\nH\u0000\u001a\u001c\u0010+\u001a\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\n\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000c0,H\u0000\u001a\u0017\u0010-\u001a\u00020.2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020.00H\u0082\u0008¨\u00061", d2 = {"getChecked", "T", "", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "", "isInterface", "", "Lkotlin/reflect/KClass;", "compiledSerializerImpl", "Lkotlinx/serialization/KSerializer;", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "platformSpecificSerializerNotRegistered", "", "serializerNotRegistered", "Ljava/lang/Class;", "constructSerializerForGivenTypeArgs", "args", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "findInNamedCompanion", "findNamedCompanionByAnnotation", "isNotAnnotated", "isPolymorphicSerializer", "invokeSerializerOnDefaultCompanion", "jClass", "invokeSerializerOnCompanion", "companion", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "companionOrNull", "companionName", "", "createEnumSerializer", "findObjectSerializer", "isReferenceArray", "rootClass", "initBuiltins", "", "loadSafe", "", "block", "Lkotlin/Function0;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlatformKt {
    private static final Object companionOrNull(Class<?> $this$companionOrNull, String companionName) {
        Field declaredField;
        declaredField = $this$companionOrNull.getDeclaredField(companionName);
        declaredField.setAccessible(true);
        try {
            return declaredField.get(0);
        }
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> $this$compiledSerializerImpl) {
        Intrinsics.checkNotNullParameter($this$compiledSerializerImpl, "<this>");
        return PlatformKt.constructSerializerForGivenTypeArgs($this$compiledSerializerImpl, new KSerializer[0]);
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(Class<T> $this$constructSerializerForGivenTypeArgs, KSerializer<Object>... args) {
        boolean notAnnotated;
        int polymorphicSerializer;
        KClass kotlinClass;
        Intrinsics.checkNotNullParameter($this$constructSerializerForGivenTypeArgs, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        if ($this$constructSerializerForGivenTypeArgs.isEnum() && PlatformKt.isNotAnnotated($this$constructSerializerForGivenTypeArgs)) {
            if (PlatformKt.isNotAnnotated($this$constructSerializerForGivenTypeArgs)) {
                return PlatformKt.createEnumSerializer($this$constructSerializerForGivenTypeArgs);
            }
        }
        KSerializer serializerOnDefaultCompanion = PlatformKt.invokeSerializerOnDefaultCompanion($this$constructSerializerForGivenTypeArgs, (KSerializer[])Arrays.copyOf(args, args.length));
        if (serializerOnDefaultCompanion != null) {
            return serializerOnDefaultCompanion;
        }
        KSerializer objectSerializer = PlatformKt.findObjectSerializer($this$constructSerializerForGivenTypeArgs);
        if (objectSerializer != null) {
            int i = 0;
            return objectSerializer;
        }
        KSerializer inNamedCompanion = PlatformKt.findInNamedCompanion($this$constructSerializerForGivenTypeArgs, (KSerializer[])Arrays.copyOf(args, args.length));
        if (inNamedCompanion != null) {
            return inNamedCompanion;
        }
        if (PlatformKt.isPolymorphicSerializer($this$constructSerializerForGivenTypeArgs)) {
            polymorphicSerializer = new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass($this$constructSerializerForGivenTypeArgs));
        } else {
            polymorphicSerializer = 0;
        }
        return polymorphicSerializer;
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(KClass<T> $this$constructSerializerForGivenTypeArgs, KSerializer<Object>... args) {
        Intrinsics.checkNotNullParameter($this$constructSerializerForGivenTypeArgs, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        return PlatformKt.constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass($this$constructSerializerForGivenTypeArgs), (KSerializer[])Arrays.copyOf(args, args.length));
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> $this$createEnumSerializer) {
        final Object[] enumConstants = $this$createEnumSerializer.getEnumConstants();
        final String canonicalName = $this$createEnumSerializer.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
        Intrinsics.checkNotNull(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        EnumSerializer enumSerializer = new EnumSerializer(canonicalName, (Enum[])enumConstants);
        return (KSerializer)enumSerializer;
    }

    private static final <T> KSerializer<T> findInNamedCompanion(Class<T> $this$findInNamedCompanion, KSerializer<Object>... args) {
        KSerializer serializerOnCompanion;
        int i;
        Object obj;
        Class[] declaredClasses;
        int single$iv;
        int found$iv;
        int i3;
        Class cls2;
        Class cls;
        int i2;
        boolean equal;
        String str;
        final Object namedCompanionByAnnotation = PlatformKt.findNamedCompanionByAnnotation($this$findInNamedCompanion);
        serializerOnCompanion = PlatformKt.invokeSerializerOnCompanion(namedCompanionByAnnotation, (KSerializer[])Arrays.copyOf(args, args.length));
        if (namedCompanionByAnnotation != null && serializerOnCompanion != null) {
            serializerOnCompanion = PlatformKt.invokeSerializerOnCompanion(namedCompanionByAnnotation, (KSerializer[])Arrays.copyOf(args, args.length));
            if (serializerOnCompanion != null) {
                int i4 = 0;
                return serializerOnCompanion;
            }
        }
        i = 0;
        declaredClasses = $this$findInNamedCompanion.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        int i5 = 0;
        single$iv = 0;
        found$iv = 0;
        i3 = 0;
        while (i3 < declaredClasses.length) {
            cls2 = (Object[])declaredClasses[i3];
            i2 = 0;
            i3++;
            single$iv = cls2;
            found$iv = 1;
        }
        if (found$iv == 0) {
            single$iv = i;
        } else {
        }
        declaredClasses = (Class)single$iv.getField("INSTANCE");
        if (single$iv != 0 && declaredClasses != null) {
            declaredClasses = single$iv.getField("INSTANCE");
            if (declaredClasses != null) {
                obj = declaredClasses.get(i);
            } else {
                obj = i;
            }
        } else {
        }
        if (obj instanceof KSerializer) {
            i = obj;
        }
        return i;
    }

    private static final <T> Object findNamedCompanionByAnnotation(Class<T> $this$findNamedCompanionByAnnotation) {
        int i3;
        int i;
        Class cls;
        Class cls2;
        int i4;
        int i2;
        Class[] declaredClasses = $this$findNamedCompanionByAnnotation.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        int i5 = 0;
        final int i6 = 0;
        i3 = i6;
        i = 0;
        while (i3 < declaredClasses.length) {
            i4 = 0;
            if ((Class)(Object[])declaredClasses[i3].getAnnotation(NamedCompanion.class) != null) {
            } else {
            }
            i2 = i6;
            i3++;
            i = 0;
            i2 = 1;
        }
        cls = i;
        if ((Class)cls == null) {
            return i;
        }
        String simpleName = (Class)cls.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return PlatformKt.companionOrNull($this$findNamedCompanionByAnnotation, simpleName);
    }

    private static final <T> KSerializer<T> findObjectSerializer(Class<T> $this$findObjectSerializer) {
        int i3;
        String it;
        int i8;
        int equal;
        int i5;
        int i;
        boolean startsWith$default;
        int single$iv;
        int i4;
        int found$iv;
        int single$iv2;
        int i9;
        int found$iv2;
        Field field;
        int it2;
        int i6;
        int i2;
        boolean static;
        Object obj;
        int i7;
        Class<KSerializer> name;
        it = $this$findObjectSerializer.getCanonicalName();
        i5 = 0;
        int i10 = 0;
        if (it != null) {
            i = 0;
            i4 = 2;
            if (!StringsKt.startsWith$default(it, "java.", i10, i4, i5)) {
                if (StringsKt.startsWith$default(it, "kotlin.", i10, i4, i5)) {
                    it = 1;
                } else {
                    it = i10;
                }
            } else {
            }
            i3 = it == 0 ? 1 : i10;
        } else {
        }
        if (i3 == 0) {
            return i5;
        }
        Field[] declaredFields = $this$findObjectSerializer.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        int i11 = 0;
        single$iv = 0;
        found$iv = 0;
        i9 = i10;
        while (i9 < declaredFields.length) {
            field = (Object[])declaredFields[i9];
            Field field2 = field;
            i2 = 0;
            if (Intrinsics.areEqual((Field)field2.getName(), "INSTANCE")) {
            } else {
            }
            obj = $this$findObjectSerializer;
            it2 = i10;
            i9++;
            single$iv = field;
            found$iv = 1;
            if (Intrinsics.areEqual(field2.getType(), $this$findObjectSerializer) && Modifier.isStatic(field2.getModifiers())) {
            } else {
            }
            if (Modifier.isStatic(field2.getModifiers())) {
            } else {
            }
            it2 = 1;
        }
        obj = $this$findObjectSerializer;
        if (found$iv == 0) {
            single$iv = i5;
        } else {
        }
        if ((Field)single$iv == 0) {
            return i5;
        }
        Method[] methods = obj.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
        int i12 = 0;
        single$iv2 = 0;
        found$iv2 = 0;
        i6 = i10;
        while (i6 < methods.length) {
            i2 = (Object[])methods[i6];
            static = i2;
            i7 = 0;
            if (Intrinsics.areEqual((Method)static.getName(), "serializer")) {
            } else {
            }
            i8 = i10;
            i6++;
            found$iv2 = single$iv3;
            single$iv2 = i8;
            Class[] parameterTypes = static.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            if (parameterTypes.length == 0) {
            } else {
            }
            equal = i10;
            if (equal != 0 && Intrinsics.areEqual(static.getReturnType(), KSerializer.class)) {
            } else {
            }
            if (Intrinsics.areEqual(static.getReturnType(), KSerializer.class)) {
            } else {
            }
            i8 = 1;
            equal = 1;
        }
        if (found$iv2 == 0) {
            single$iv2 = i5;
        } else {
        }
        if ((Method)single$iv2 == 0) {
            return i5;
        }
        Object invoke = (Method)single$iv2.invoke((Field)single$iv.get(i5), new Object[i10]);
        if (invoke instanceof KSerializer) {
            i5 = invoke;
        }
        return i5;
    }

    public static final <T> T getChecked(T[] $this$getChecked, int index) {
        Intrinsics.checkNotNullParameter($this$getChecked, "<this>");
        int i = 0;
        return $this$getChecked[index];
    }

    public static final boolean getChecked(boolean[] $this$getChecked, int index) {
        Intrinsics.checkNotNullParameter($this$getChecked, "<this>");
        int i = 0;
        return $this$getChecked[index];
    }

    public static final Map<KClass<?>, KSerializer<?>> initBuiltins() {
        int i;
        int i6;
        int i4;
        int i2;
        int i5;
        int i3;
        Map mapBuilder = MapsKt.createMapBuilder();
        final Map map = mapBuilder;
        final int i7 = 0;
        map.put(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(Character.TYPE), BuiltinSerializersKt.serializer(CharCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(char[].class), BuiltinSerializersKt.CharArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(Double.TYPE), BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(double[].class), BuiltinSerializersKt.DoubleArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(Float.TYPE), BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(float[].class), BuiltinSerializersKt.FloatArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(Long.TYPE), BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(long[].class), BuiltinSerializersKt.LongArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(ULong.class), BuiltinSerializersKt.serializer(ULong.Companion));
        map.put(Reflection.getOrCreateKotlinClass(Integer.TYPE), BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(int[].class), BuiltinSerializersKt.IntArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(UInt.class), BuiltinSerializersKt.serializer(UInt.Companion));
        map.put(Reflection.getOrCreateKotlinClass(Short.TYPE), BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(short[].class), BuiltinSerializersKt.ShortArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(UShort.class), BuiltinSerializersKt.serializer(UShort.Companion));
        map.put(Reflection.getOrCreateKotlinClass(Byte.TYPE), BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(byte[].class), BuiltinSerializersKt.ByteArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(UByte.class), BuiltinSerializersKt.serializer(UByte.Companion));
        map.put(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer());
        map.put(Reflection.getOrCreateKotlinClass(Unit.class), BuiltinSerializersKt.serializer(Unit.INSTANCE));
        map.put(Reflection.getOrCreateKotlinClass(Void.class), BuiltinSerializersKt.NothingSerializer());
        int i8 = 0;
        i = 0;
        map.put(Reflection.getOrCreateKotlinClass(Duration.class), BuiltinSerializersKt.serializer(Duration.Companion));
        Map $i$f$loadSafe = map;
        int i10 = 0;
        int i11 = 0;
        i4 = 0;
        $i$f$loadSafe.put(Reflection.getOrCreateKotlinClass(ULongArray.class), BuiltinSerializersKt.ULongArraySerializer());
        int $i$f$loadSafe2 = 0;
        i2 = 0;
        $i$f$loadSafe.put(Reflection.getOrCreateKotlinClass(UIntArray.class), BuiltinSerializersKt.UIntArraySerializer());
        int $i$f$loadSafe3 = 0;
        i5 = 0;
        $i$f$loadSafe.put(Reflection.getOrCreateKotlinClass(UShortArray.class), BuiltinSerializersKt.UShortArraySerializer());
        int $i$f$loadSafe4 = 0;
        i3 = 0;
        $i$f$loadSafe.put(Reflection.getOrCreateKotlinClass(UByteArray.class), BuiltinSerializersKt.UByteArraySerializer());
        int i9 = 0;
        i6 = 0;
        map.put(Reflection.getOrCreateKotlinClass(Uuid.class), BuiltinSerializersKt.serializer(Uuid.Companion));
        return MapsKt.build(mapBuilder);
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Object companion, KSerializer<Object>... args) {
        int i3;
        int i;
        Class[] arr;
        InvocationTargetException invocationTargetException;
        int i2;
        Class[] message;
        Class<KSerializer> obj;
        i3 = 0;
        i2 = 0;
        if (args.length == 0) {
            i = 1;
        } else {
            try {
                i = i2;
                if (i != 0) {
                } else {
                }
                arr = new Class[i2];
                int length2 = args.length;
                message = new Class[length2];
                while (i2 < length2) {
                    message[i2] = KSerializer.class;
                    i2++;
                }
                message[i2] = KSerializer.class;
                i2++;
                arr = message;
                Object invoke = companion.getClass().getDeclaredMethod("serializer", (Class[])Arrays.copyOf(arr, arr.length)).invoke(companion, Arrays.copyOf(args, args.length));
                if (invoke instanceof KSerializer) {
                }
                i3 = invoke;
                Throwable th2 = th.getCause();
                if (th2 == null) {
                } else {
                }
                message = th2.getMessage();
                if (message != null) {
                } else {
                }
                message = th.getMessage();
                invocationTargetException = new InvocationTargetException(th2, message);
                throw invocationTargetException;
                throw th;
                return i3;
            }
        }
    }

    private static final <T> KSerializer<T> invokeSerializerOnDefaultCompanion(Class<?> jClass, KSerializer<Object>... args) {
        Object companionOrNull = PlatformKt.companionOrNull(jClass, "Companion");
        if (companionOrNull == null) {
            return 0;
        }
        return PlatformKt.invokeSerializerOnCompanion(companionOrNull, (KSerializer[])Arrays.copyOf(args, args.length));
    }

    public static final <T> boolean isInterface(KClass<T> $this$isInterface) {
        Intrinsics.checkNotNullParameter($this$isInterface, "<this>");
        return JvmClassMappingKt.getJavaClass($this$isInterface).isInterface();
    }

    private static final <T> boolean isNotAnnotated(Class<T> $this$isNotAnnotated) {
        java.lang.annotation.Annotation annotation;
        int i;
        if ($this$isNotAnnotated.getAnnotation(Serializable.class) == null && $this$isNotAnnotated.getAnnotation(Polymorphic.class) == null) {
            i = $this$isNotAnnotated.getAnnotation(Polymorphic.class) == null ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final <T> boolean isPolymorphicSerializer(Class<T> $this$isPolymorphicSerializer) {
        boolean equal;
        KClass orCreateKotlinClass;
        int i = 1;
        if ($this$isPolymorphicSerializer.getAnnotation(Polymorphic.class) != null) {
            return i;
        }
        java.lang.annotation.Annotation annotation2 = $this$isPolymorphicSerializer.getAnnotation(Serializable.class);
        if (annotation2 != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass((Serializable)annotation2.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(annotation2.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
                return i;
            }
        }
        return 0;
    }

    public static final boolean isReferenceArray(KClass<Object> rootClass) {
        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
        return JvmClassMappingKt.getJavaClass(rootClass).isArray();
    }

    private static final void loadSafe(Function0<Unit> block) {
        Throwable th;
        final int i = 0;
        block.invoke();
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> $this$platformSpecificSerializerNotRegistered) {
        Intrinsics.checkNotNullParameter($this$platformSpecificSerializerNotRegistered, "<this>");
        Platform_commonKt.serializerNotRegistered($this$platformSpecificSerializerNotRegistered);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final Void serializerNotRegistered(Class<?> $this$serializerNotRegistered) {
        Intrinsics.checkNotNullParameter($this$serializerNotRegistered, "<this>");
        SerializationException serializationException = new SerializationException(Platform_commonKt.notRegisteredMessage(JvmClassMappingKt.getKotlinClass($this$serializerNotRegistered)));
        throw serializationException;
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> $this$toNativeArrayImpl, KClass<T> eClass) {
        Intrinsics.checkNotNullParameter($this$toNativeArrayImpl, "<this>");
        Intrinsics.checkNotNullParameter(eClass, "eClass");
        Object instance = Array.newInstance(JvmClassMappingKt.getJavaClass(eClass), $this$toNativeArrayImpl.size());
        Intrinsics.checkNotNull(instance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = $this$toNativeArrayImpl.toArray((Object[])instance);
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return array;
    }
}
