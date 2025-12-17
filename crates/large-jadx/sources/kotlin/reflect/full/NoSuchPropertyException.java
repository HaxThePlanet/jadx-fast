package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0010\u0008\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"Lkotlin/reflect/full/NoSuchPropertyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "<init>", "(Ljava/lang/Exception;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class NoSuchPropertyException extends Exception {
    public NoSuchPropertyException() {
        final int i = 0;
        super(i, 1, i);
    }

    public NoSuchPropertyException(Exception exception) {
        super(exception);
    }

    public NoSuchPropertyException(Exception exception, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }
}
