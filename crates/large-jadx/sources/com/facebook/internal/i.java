package com.facebook.internal;

import com.facebook.n.a;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 5, 1})
public final class i {

    public static final int[] a;
    static {
        int[] iArr = new int[values.length];
        i.a = iArr;
        iArr[n.a.OTHER.ordinal()] = 1;
        iArr[n.a.LOGIN_RECOVERABLE.ordinal()] = 2;
        iArr[n.a.TRANSIENT.ordinal()] = 3;
    }
}
