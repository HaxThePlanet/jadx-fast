package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.UnknownClassException;

/* compiled from: LegacyServices.java */
@Deprecated
/* loaded from: classes3.dex */
public final class LegacyServices {
    public static <T> T loadFirst(Class<T> cls) throws UnknownClassException {
        try {
        } catch (io.jsonwebtoken.impl.lang.UnavailableImplementationException unavailableImplementation) {
            throw new UnknownClassException(unavailableImplementation.getMessage(), unavailableImplementation);
        }
        return Services.loadFirst(cls);
    }
}
