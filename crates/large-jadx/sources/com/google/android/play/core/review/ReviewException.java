package com.google.android.play.core.review;

import com.google.android.play.core.review.c.a;
import com.google.android.play.core.tasks.zzj;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ReviewException extends zzj {

    private final int zza;
    public ReviewException(int i) {
        Object[] arr = new Object[2];
        super(String.format(Locale.getDefault(), "Review Error(%d): %s", Integer.valueOf(i), a.a(i)));
        this.zza = i;
    }
}
