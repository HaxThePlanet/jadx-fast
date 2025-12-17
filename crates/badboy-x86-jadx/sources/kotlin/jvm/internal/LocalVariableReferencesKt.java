package kotlin.jvm.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002", d2 = {"notSupportedError", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocalVariableReferencesKt {
    public static final Void access$notSupportedError() {
        return LocalVariableReferencesKt.notSupportedError();
    }

    private static final Void notSupportedError() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not supported for local property reference.");
        throw unsupportedOperationException;
    }
}
