package kotlin.i0.z.e.l0;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public interface d<M extends java.lang.reflect.Member>  {

    public static final class a {
        public static <M extends java.lang.reflect.Member> void a(kotlin.i0.z.e.l0.d<? extends M> d, Object[] object2Arr2) {
            n.f(object2Arr2, "args");
            if (f.a(d) != object2Arr2.length) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Callable expects ");
            stringBuilder.append(f.a(d));
            stringBuilder.append(" arguments, but ");
            stringBuilder.append(object2Arr2.length);
            stringBuilder.append(" were provided.");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }
    public abstract List<Type> a();

    public abstract M b();

    public abstract Object call(Object[] objectArr);

    public abstract Type getReturnType();
}
