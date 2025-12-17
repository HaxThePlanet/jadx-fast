package com.google.common.collect;

import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class b1<E>  implements Iterator<E> {
    @Deprecated
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
