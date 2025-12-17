package com.facebook.internal.g0;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 5, 1})
public final class c {

    public static final int[] a;
    public static final int[] b;
    static {
        int[] iArr = new int[values.length];
        c.a = iArr;
        com.facebook.internal.g0.b.c analysis = b.c.Analysis;
        final int i = 1;
        iArr[analysis.ordinal()] = i;
        com.facebook.internal.g0.b.c anrReport = b.c.AnrReport;
        final int i2 = 2;
        iArr[anrReport.ordinal()] = i2;
        com.facebook.internal.g0.b.c crashReport = b.c.CrashReport;
        final int i3 = 3;
        iArr[crashReport.ordinal()] = i3;
        com.facebook.internal.g0.b.c crashShield = b.c.CrashShield;
        final int i4 = 4;
        iArr[crashShield.ordinal()] = i4;
        com.facebook.internal.g0.b.c threadCheck = b.c.ThreadCheck;
        final int i5 = 5;
        iArr[threadCheck.ordinal()] = i5;
        int[] iArr2 = new int[values2.length];
        c.b = iArr2;
        iArr2[analysis.ordinal()] = i;
        iArr2[anrReport.ordinal()] = i2;
        iArr2[crashReport.ordinal()] = i3;
        iArr2[crashShield.ordinal()] = i4;
        iArr2[threadCheck.ordinal()] = i5;
    }
}
