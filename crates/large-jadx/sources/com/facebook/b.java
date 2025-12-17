package com.facebook;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 5, 1})
public final class b {

    public static final int[] a;
    static {
        int[] iArr = new int[values.length];
        b.a = iArr;
        iArr[f.FACEBOOK_APPLICATION_WEB.ordinal()] = 1;
        iArr[f.CHROME_CUSTOM_TAB.ordinal()] = 2;
        iArr[f.WEB_VIEW.ordinal()] = 3;
    }
}
