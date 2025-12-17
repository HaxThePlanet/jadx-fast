package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;

/* loaded from: classes3.dex */
final class n {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.n a;
    static {
        n nVar = new n();
        n.a = nVar;
    }

    public final String a(Constructor<?> constructor) {
        int i;
        String str2;
        String str;
        n.f(constructor, "constructor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        Class[] obj6 = constructor.getParameterTypes();
        n.e(obj6, "constructor.parameterTypes");
        i = 0;
        while (i < obj6.length) {
            Class cls = obj6[i];
            i++;
            n.e(cls, "parameterType");
            stringBuilder.append(b.c(cls));
        }
        stringBuilder.append(")V");
        obj6 = stringBuilder.toString();
        n.e(obj6, "sb.toString()");
        return obj6;
    }

    public final String b(Field field) {
        n.f(field, "field");
        Class obj2 = field.getType();
        n.e(obj2, "field.type");
        return b.c(obj2);
    }

    public final String c(Method method) {
        int i;
        String str2;
        String str;
        n.f(method, "method");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        Class[] parameterTypes = method.getParameterTypes();
        n.e(parameterTypes, "method.parameterTypes");
        i = 0;
        while (i < parameterTypes.length) {
            Class cls = parameterTypes[i];
            i++;
            n.e(cls, "parameterType");
            stringBuilder.append(b.c(cls));
        }
        stringBuilder.append(")");
        Class obj7 = method.getReturnType();
        n.e(obj7, "method.returnType");
        stringBuilder.append(b.c(obj7));
        obj7 = stringBuilder.toString();
        n.e(obj7, "sb.toString()");
        return obj7;
    }
}
