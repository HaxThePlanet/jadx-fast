package kotlinx.serialization.c;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.serialization.KSerializer;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u0017\u0010\u0003\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004H&¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0007", d2 = {"Lkotlinx/serialization/internal/GeneratedSerializer;", "T", "Lkotlinx/serialization/KSerializer;", "childSerializers", "", "()[Lkotlinx/serialization/KSerializer;", "typeParametersSerializers", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface b<T>  extends KSerializer<T> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static <T> KSerializer<?>[] a(kotlinx.serialization.c.b<T> b) {
            n.f(b, "this");
            return m.a;
        }
    }
    public abstract KSerializer<?>[] childSerializers();

    public abstract KSerializer<?>[] typeParametersSerializers();
}
