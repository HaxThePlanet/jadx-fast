package kotlin.d0;

import java.lang.annotation.Annotation;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.d;
import kotlin.d0.d.n;
import kotlin.i0.d;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\u0008\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"-\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b\"&\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000e\";\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\r*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000f\u0010\t\u001a\u0004\u0008\u0010\u0010\u000b\"+\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\r*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\u0008\u0008\u0000\u0010\u0002*\u00020\r*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u000b\"+\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\r*\u0008\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006\u001c", d2 = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class a {
    public static final <T extends Annotation> d<? extends T> a(T t) {
        n.f(t, "$this$annotationClass");
        Class obj1 = t.annotationType();
        n.e(obj1, "(this as java.lang.annot…otation).annotationType()");
        obj1 = a.e(obj1);
        Objects.requireNonNull(obj1, "null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return obj1;
    }

    public static final <T> Class<T> b(d<T> d) {
        n.f(d, "$this$java");
        final Class obj1 = (d)d.d();
        Objects.requireNonNull(obj1, "null cannot be cast to non-null type java.lang.Class<T>");
        return obj1;
    }

    public static final <T> Class<T> c(d<T> d) {
        String equals;
        String str;
        Class obj3;
        n.f(d, "$this$javaObjectType");
        obj3 = (d)d.d();
        final String str3 = "null cannot be cast to non-null type java.lang.Class<T>";
        if (!obj3.isPrimitive()) {
            Objects.requireNonNull(obj3, str3);
            return obj3;
        }
        equals = obj3.getName();
        if (equals == null) {
        } else {
            switch (equals) {
                case "double":
                    obj3 = Double.class;
                    break;
                case "int":
                    obj3 = Integer.class;
                    break;
                case "byte":
                    obj3 = Byte.class;
                    break;
                case "char":
                    obj3 = Character.class;
                    break;
                case "long":
                    obj3 = Long.class;
                    break;
                case "void":
                    obj3 = Void.class;
                    break;
                case "boolean":
                    obj3 = Boolean.class;
                    break;
                case "float":
                    obj3 = Float.class;
                    break;
                case "short":
                    obj3 = Short.class;
                    break;
                default:
            }
        }
        Objects.requireNonNull(obj3, str3);
        return obj3;
    }

    public static final <T> Class<T> d(d<T> d) {
        String primitive;
        Class obj1;
        n.f(d, "$this$javaPrimitiveType");
        obj1 = (d)d.d();
        if (obj1.isPrimitive()) {
            Objects.requireNonNull(obj1, "null cannot be cast to non-null type java.lang.Class<T>");
            return obj1;
        }
        obj1 = obj1.getName();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            switch (obj1) {
                case "java.lang.Integer":
                    obj1 = Integer.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Float":
                    obj1 = Float.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Short":
                    obj1 = Short.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Character":
                    obj1 = Character.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Boolean":
                    obj1 = Boolean.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Byte":
                    obj1 = Byte.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Long":
                    obj1 = Long.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Void":
                    obj1 = Void.TYPE;
                    obj1 = 0;
                    break;
                case "java.lang.Double":
                    obj1 = Double.TYPE;
                    obj1 = 0;
                    break;
                default:
                    obj1 = 0;
            }
        }
        return obj1;
    }

    public static final <T> d<T> e(Class<T> class) {
        n.f(class, "$this$kotlin");
        return c0.b(class);
    }
}
