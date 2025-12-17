package kotlin.jvm.internal;

import java.util.List;
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
public class ReflectionFactory {

    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";
    public KClass createKotlinClass(Class javaClass) {
        ClassReference classReference = new ClassReference(javaClass);
        return classReference;
    }

    public KClass createKotlinClass(Class javaClass, String internalName) {
        ClassReference classReference = new ClassReference(javaClass);
        return classReference;
    }

    public KFunction function(kotlin.jvm.internal.FunctionReference f) {
        return f;
    }

    public KClass getOrCreateKotlinClass(Class javaClass) {
        ClassReference classReference = new ClassReference(javaClass);
        return classReference;
    }

    public KClass getOrCreateKotlinClass(Class javaClass, String internalName) {
        ClassReference classReference = new ClassReference(javaClass);
        return classReference;
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class javaClass, String moduleName) {
        PackageReference packageReference = new PackageReference(javaClass, moduleName);
        return packageReference;
    }

    public KType mutableCollectionType(KType type) {
        final kotlin.jvm.internal.TypeReference typeReference = type;
        TypeReference typeReference2 = new TypeReference(type.getClassifier(), type.getArguments(), (TypeReference)typeReference.getPlatformTypeUpperBound$kotlin_stdlib(), flags$kotlin_stdlib |= 2);
        return typeReference2;
    }

    public KMutableProperty0 mutableProperty0(kotlin.jvm.internal.MutablePropertyReference0 p) {
        return p;
    }

    public KMutableProperty1 mutableProperty1(kotlin.jvm.internal.MutablePropertyReference1 p) {
        return p;
    }

    public KMutableProperty2 mutableProperty2(kotlin.jvm.internal.MutablePropertyReference2 p) {
        return p;
    }

    public KType nothingType(KType type) {
        final kotlin.jvm.internal.TypeReference typeReference = type;
        TypeReference typeReference2 = new TypeReference(type.getClassifier(), type.getArguments(), (TypeReference)typeReference.getPlatformTypeUpperBound$kotlin_stdlib(), flags$kotlin_stdlib |= 4);
        return typeReference2;
    }

    public KType platformType(KType lowerBound, KType upperBound) {
        TypeReference typeReference = new TypeReference(lowerBound.getClassifier(), lowerBound.getArguments(), upperBound, (TypeReference)lowerBound.getFlags$kotlin_stdlib());
        return typeReference;
    }

    public KProperty0 property0(kotlin.jvm.internal.PropertyReference0 p) {
        return p;
    }

    public KProperty1 property1(kotlin.jvm.internal.PropertyReference1 p) {
        return p;
    }

    public KProperty2 property2(kotlin.jvm.internal.PropertyReference2 p) {
        return p;
    }

    public String renderLambdaToString(kotlin.jvm.internal.FunctionBase lambda) {
        String substring;
        String string = lambda.getClass().getGenericInterfaces()[0].toString();
        String str = "kotlin.jvm.functions.";
        if (string.startsWith(str)) {
            substring = string.substring(str.length());
        } else {
            substring = string;
        }
        return substring;
    }

    public String renderLambdaToString(kotlin.jvm.internal.Lambda lambda) {
        return renderLambdaToString(lambda);
    }

    public void setUpperBounds(KTypeParameter typeParameter, List<KType> list2) {
        (TypeParameterReference)typeParameter.setUpperBounds(list2);
    }

    public KType typeOf(KClassifier klass, List<KTypeProjection> list2, boolean isMarkedNullable) {
        TypeReference typeReference = new TypeReference(klass, list2, isMarkedNullable);
        return typeReference;
    }

    public KTypeParameter typeParameter(Object container, String name, KVariance variance, boolean isReified) {
        TypeParameterReference typeParameterReference = new TypeParameterReference(container, name, variance, isReified);
        return typeParameterReference;
    }
}
