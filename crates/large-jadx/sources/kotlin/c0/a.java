package kotlin.c0;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.g0.b;
import kotlin.g0.c;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013", d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public class a {

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private static final class a {

        public static final Method a = null;
        static {
            int length;
            int i2;
            int str;
            String str2;
            Method method;
            int i;
            boolean z;
            String str3;
            Class<Throwable> obj = Throwable.class;
            final Method[] methods = obj.getMethods();
            n.e(methods, "throwableMethods");
            i2 = 0;
            str = i2;
            str2 = "it";
            while (str < methods.length) {
                method = methods[str];
                n.e(method, str2);
                Class[] parameterTypes = method.getParameterTypes();
                n.e(parameterTypes, "it.parameterTypes");
                if (n.b(method.getName(), "addSuppressed") && n.b((Class)i.O(parameterTypes), obj)) {
                } else {
                }
                i = i2;
                if (i != 0) {
                    break;
                }
                str++;
                str2 = "it";
                parameterTypes = method.getParameterTypes();
                n.e(parameterTypes, "it.parameterTypes");
                if (n.b((Class)i.O(parameterTypes), obj)) {
                } else {
                }
                i = 1;
            }
            int i3 = 0;
            while (i2 < methods.length) {
                Method method2 = methods[i2];
                n.e(method2, str2);
                if (n.b(method2.getName(), "getSuppressed") != 0) {
                    break;
                } else {
                }
                i2++;
            }
        }
    }
    public void a(Throwable throwable, Throwable throwable2) {
        Object[] arr;
        int i;
        n.f(throwable, "cause");
        n.f(throwable2, "exception");
        Method method = a.a.a;
        if (method != null) {
            arr = new Object[1];
            method.invoke(throwable, throwable2);
        }
    }

    public c b() {
        b bVar = new b();
        return bVar;
    }
}
