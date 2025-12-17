package kotlin.jvm;

import android.app.Notification.Action;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\u0008\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\";\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u000e\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\t*\u0008\u0012\u0004\u0012\u0002H\u00080\t8Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\r\"-\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\u000c\u0012\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012\"&\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0014*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0016\u0010\u0010\u001a\u0004\u0008\u0017\u0010\u0012\"+\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0014*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0014*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0012\"+\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0014*\u0008\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006#", d2 = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class JvmClassMappingKt {
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T $this$annotationClass) {
        Intrinsics.checkNotNullParameter($this$annotationClass, "<this>");
        Class annotationType = $this$annotationClass.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "annotationType(...)");
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(annotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> $this$declaringJavaClass) {
        Intrinsics.checkNotNullParameter($this$declaringJavaClass, "<this>");
        Class declaringClass = $this$declaringJavaClass.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        return declaringClass;
    }

    public static void getDeclaringJavaClass$annotations(Enum enum) {
    }

    public static final <T> Class<T> getJavaClass(T $this$javaClass) {
        Intrinsics.checkNotNullParameter($this$javaClass, "<this>");
        int i = 0;
        final Class class = $this$javaClass.getClass();
        Intrinsics.checkNotNull(class, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return class;
    }

    public static final <T> Class<T> getJavaClass(KClass<T> $this$java) {
        Intrinsics.checkNotNullParameter($this$java, "<this>");
        Class jClass = (ClassBasedDeclarationContainer)$this$java.getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return jClass;
    }

    public static void getJavaClass$annotations(KClass kClass) {
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> $this$javaObjectType) {
        Class<Short> obj;
        String equals;
        String str;
        Intrinsics.checkNotNullParameter($this$javaObjectType, "<this>");
        Class jClass = (ClassBasedDeclarationContainer)$this$javaObjectType.getJClass();
        final String str3 = "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>";
        if (!jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, str3);
            return jClass;
        }
        equals = jClass.getName();
        if (equals != null) {
            switch (equals) {
                case "double":
                    obj = Double.class;
                    obj = jClass;
                    break;
                case "int":
                    obj = Integer.class;
                    obj = jClass;
                    break;
                case "byte":
                    obj = Byte.class;
                    obj = jClass;
                    break;
                case "char":
                    obj = Character.class;
                    obj = jClass;
                    break;
                case "long":
                    obj = Long.class;
                    obj = jClass;
                    break;
                case "void":
                    obj = Void.class;
                    obj = jClass;
                    break;
                case "boolean":
                    obj = Boolean.class;
                    obj = jClass;
                    break;
                case "float":
                    obj = Float.class;
                    obj = jClass;
                    break;
                case "short":
                    obj = Short.class;
                    obj = jClass;
                    break;
                default:
                    obj = jClass;
            }
        } else {
        }
        Intrinsics.checkNotNull(obj, str3);
        return obj;
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> $this$javaPrimitiveType) {
        long l;
        Class tYPE;
        String equals;
        String str;
        Intrinsics.checkNotNullParameter($this$javaPrimitiveType, "<this>");
        Class jClass = (ClassBasedDeclarationContainer)$this$javaPrimitiveType.getJClass();
        if (jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return jClass;
        }
        equals = jClass.getName();
        if (equals != null) {
            switch (equals) {
                case "java.lang.Integer":
                    tYPE = Integer.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Float":
                    tYPE = Float.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Short":
                    tYPE = Short.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Character":
                    tYPE = Character.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Boolean":
                    tYPE = Boolean.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Byte":
                    tYPE = Byte.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Long":
                    tYPE = Long.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Void":
                    tYPE = Void.TYPE;
                    tYPE = 0;
                    break;
                case "java.lang.Double":
                    tYPE = Double.TYPE;
                    tYPE = 0;
                    break;
                default:
                    tYPE = 0;
            }
        } else {
        }
        return tYPE;
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> $this$kotlin) {
        Intrinsics.checkNotNullParameter($this$kotlin, "<this>");
        return Reflection.getOrCreateKotlinClass($this$kotlin);
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> $this$javaClass) {
        Intrinsics.checkNotNullParameter($this$javaClass, "<this>");
        int i = 0;
        Class class = (Object)$this$javaClass.getClass();
        Intrinsics.checkNotNull(class, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return class;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(...))
    public static void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    public static final boolean isArrayOf(Object[] $this$isArrayOf) {
        Intrinsics.checkNotNullParameter($this$isArrayOf, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> obj = Object.class;
        Class<Object> obj2 = obj;
        Class class = $this$isArrayOf.getClass();
        final Class cls = class;
        return obj.isAssignableFrom(class.getComponentType());
    }
}
