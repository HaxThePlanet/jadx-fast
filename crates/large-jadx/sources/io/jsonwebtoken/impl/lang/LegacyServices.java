package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.UnknownClassException;

/* loaded from: classes3.dex */
@Deprecated
public final class LegacyServices {
    public static <T> T loadFirst(Class<T> class) {
        try {
            return Services.loadFirst(class);
            UnknownClassException unknownClassException = new UnknownClassException(class.getMessage(), class);
            throw unknownClassException;
        }
    }
}
