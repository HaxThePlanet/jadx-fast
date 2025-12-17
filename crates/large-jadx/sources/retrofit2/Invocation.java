package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class Invocation {

    private final List<?> arguments;
    private final Method method;
    Invocation(Method method, List<?> list2) {
        super();
        this.method = method;
        this.arguments = Collections.unmodifiableList(list2);
    }

    public static retrofit2.Invocation of(Method method, List<?> list2) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list2, "arguments == null");
        ArrayList arrayList = new ArrayList(list2);
        Invocation invocation = new Invocation(method, arrayList);
        return invocation;
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public Method method() {
        return this.method;
    }

    public String toString() {
        Object[] arr = new Object[3];
        return String.format("%s.%s() %s", this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments);
    }
}
