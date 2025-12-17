package org.koin.core.error;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Lorg/koin/core/error/InstanceCreationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "parent", "(Ljava/lang/String;Ljava/lang/Exception;)V", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InstanceCreationException extends Exception {
    public InstanceCreationException(String string, Exception exception2) {
        n.f(string, "msg");
        n.f(exception2, "parent");
        super(string, exception2);
    }
}
