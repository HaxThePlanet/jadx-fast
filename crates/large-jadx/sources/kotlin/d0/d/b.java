package kotlin.d0.d;

import java.util.Iterator;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u001a%\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class b {
    public static final <T> Iterator<T> a(T[] tArr) {
        n.f(tArr, "array");
        a aVar = new a(tArr);
        return aVar;
    }
}
