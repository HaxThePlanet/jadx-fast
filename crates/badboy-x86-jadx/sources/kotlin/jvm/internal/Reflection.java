package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* loaded from: classes5.dex */
public class Reflection {

    private static final KClass[] EMPTY_K_CLASS_ARRAY = null;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
    private static final kotlin.jvm.internal.ReflectionFactory factory;
    static {
        Class forName;
        Object reflectionFactory;
        Object instance;
        try {
            instance = Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
            int i2 = 0;
            i2 = 0;
            i2 = 0;
            i2 = 0;
            if (instance != null) {
            } else {
            }
            reflectionFactory = instance;
            reflectionFactory = new ReflectionFactory();
            Reflection.factory = reflectionFactory;
            Reflection.EMPTY_K_CLASS_ARRAY = new KClass[0];
        }
    }

    public static KClass createKotlinClass(Class javaClass) {
        return Reflection.factory.createKotlinClass(javaClass);
    }

    public static KClass createKotlinClass(Class javaClass, String internalName) {
        return Reflection.factory.createKotlinClass(javaClass, internalName);
    }

    public static KFunction function(kotlin.jvm.internal.FunctionReference f) {
        return Reflection.factory.function(f);
    }

    public static KClass getOrCreateKotlinClass(Class javaClass) {
        return Reflection.factory.getOrCreateKotlinClass(javaClass);
    }

    public static KClass getOrCreateKotlinClass(Class javaClass, String internalName) {
        return Reflection.factory.getOrCreateKotlinClass(javaClass, internalName);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] javaClasses) {
        int i;
        KClass orCreateKotlinClass;
        final int length = javaClasses.length;
        if (length == 0) {
            return Reflection.EMPTY_K_CLASS_ARRAY;
        }
        KClass[] arr = new KClass[length];
        i = 0;
        while (i < length) {
            arr[i] = Reflection.getOrCreateKotlinClass(javaClasses[i]);
            i++;
        }
        return arr;
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class javaClass) {
        return Reflection.factory.getOrCreateKotlinPackage(javaClass, "");
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class javaClass, String moduleName) {
        return Reflection.factory.getOrCreateKotlinPackage(javaClass, moduleName);
    }

    public static KType mutableCollectionType(KType type) {
        return Reflection.factory.mutableCollectionType(type);
    }

    public static KMutableProperty0 mutableProperty0(kotlin.jvm.internal.MutablePropertyReference0 p) {
        return Reflection.factory.mutableProperty0(p);
    }

    public static KMutableProperty1 mutableProperty1(kotlin.jvm.internal.MutablePropertyReference1 p) {
        return Reflection.factory.mutableProperty1(p);
    }

    public static KMutableProperty2 mutableProperty2(kotlin.jvm.internal.MutablePropertyReference2 p) {
        return Reflection.factory.mutableProperty2(p);
    }

    public static KType nothingType(KType type) {
        return Reflection.factory.nothingType(type);
    }

    public static KType nullableTypeOf(Class klass) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), Collections.emptyList(), true);
    }

    public static KType nullableTypeOf(Class klass, KTypeProjection arg1) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), Collections.singletonList(arg1), true);
    }

    public static KType nullableTypeOf(Class klass, KTypeProjection arg1, KTypeProjection arg2) {
        KTypeProjection[] arr = new KTypeProjection[2];
        int i3 = 1;
        arr[i3] = arg2;
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), Arrays.asList(arr), i3);
    }

    public static KType nullableTypeOf(Class klass, KTypeProjection... arguments) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), ArraysKt.toList(arguments), true);
    }

    public static KType nullableTypeOf(KClassifier classifier) {
        return Reflection.factory.typeOf(classifier, Collections.emptyList(), true);
    }

    public static KType platformType(KType lowerBound, KType upperBound) {
        return Reflection.factory.platformType(lowerBound, upperBound);
    }

    public static KProperty0 property0(kotlin.jvm.internal.PropertyReference0 p) {
        return Reflection.factory.property0(p);
    }

    public static KProperty1 property1(kotlin.jvm.internal.PropertyReference1 p) {
        return Reflection.factory.property1(p);
    }

    public static KProperty2 property2(kotlin.jvm.internal.PropertyReference2 p) {
        return Reflection.factory.property2(p);
    }

    public static String renderLambdaToString(kotlin.jvm.internal.FunctionBase lambda) {
        return Reflection.factory.renderLambdaToString(lambda);
    }

    public static String renderLambdaToString(kotlin.jvm.internal.Lambda lambda) {
        return Reflection.factory.renderLambdaToString(lambda);
    }

    public static void setUpperBounds(KTypeParameter typeParameter, KType bound) {
        Reflection.factory.setUpperBounds(typeParameter, Collections.singletonList(bound));
    }

    public static void setUpperBounds(KTypeParameter typeParameter, KType... bounds) {
        Reflection.factory.setUpperBounds(typeParameter, ArraysKt.toList(bounds));
    }

    public static KType typeOf(Class klass) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), Collections.emptyList(), false);
    }

    public static KType typeOf(Class klass, KTypeProjection arg1) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), Collections.singletonList(arg1), false);
    }

    public static KType typeOf(Class klass, KTypeProjection arg1, KTypeProjection arg2) {
        KTypeProjection[] arr = new KTypeProjection[2];
        final int i2 = 0;
        arr[i2] = arg1;
        arr[1] = arg2;
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), Arrays.asList(arr), i2);
    }

    public static KType typeOf(Class klass, KTypeProjection... arguments) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(klass), ArraysKt.toList(arguments), false);
    }

    public static KType typeOf(KClassifier classifier) {
        return Reflection.factory.typeOf(classifier, Collections.emptyList(), false);
    }

    public static KTypeParameter typeParameter(Object container, String name, KVariance variance, boolean isReified) {
        return Reflection.factory.typeParameter(container, name, variance, isReified);
    }
}
