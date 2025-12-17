package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends com.google.android.exoplayer2.PlaybackException {

    final boolean isRecoverable;
    public final x mediaPeriodId;
    public final com.google.android.exoplayer2.i1 rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final int type;
    static {
        final com.google.android.exoplayer2.c cVar = c.a;
    }

    private ExoPlaybackException(int i, Throwable throwable2, int i3) {
        super(i, throwable2, 0, i3, 0, -1, 0, 4, 0);
    }

    private ExoPlaybackException(int i, Throwable throwable2, String string3, int i4, String string5, int i6, com.google.android.exoplayer2.i1 i17, int i8, boolean z9) {
        super(ExoPlaybackException.f(i, string3, string5, i6, i17, i8), throwable2, i4, i, string5, i6, i17, i8, 0, SystemClock.elapsedRealtime(), obj12, z9);
    }

    private ExoPlaybackException(String string, Throwable throwable2, int i3, int i4, String string5, int i6, com.google.android.exoplayer2.i1 i17, int i8, x x9, long l10, boolean z11) {
        int i2;
        int i;
        final Object obj2 = this;
        final int i11 = i4;
        final boolean z = obj21;
        super(string, throwable2, i3, l10, obj5);
        int i9 = 1;
        if (z) {
            if (i11 == i9) {
                i = i9;
            } else {
                i = i2;
            }
        } else {
        }
        g.a(i);
        if (throwable2 == null) {
            i2 = i11 == 3 ? i9 : i2;
        } else {
        }
        g.a(i2);
        obj2.type = i11;
        obj2.rendererName = string5;
        obj2.rendererIndex = i6;
        obj2.rendererFormat = i17;
        obj2.rendererFormatSupport = i8;
        obj2.mediaPeriodId = x9;
        obj2.isRecoverable = z;
    }

    public static com.google.android.exoplayer2.ExoPlaybackException b(Throwable throwable, String string2, int i3, com.google.android.exoplayer2.i1 i14, int i5, boolean z6, int i7) {
        int i2;
        int i;
        i = i14 == null ? i2 : i5;
        super(1, throwable, 0, i7, string2, i3, i14, i, z6);
        return exoPlaybackException;
    }

    public static com.google.android.exoplayer2.ExoPlaybackException c(IOException iOException, int i2) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i2);
        return exoPlaybackException;
    }

    @Deprecated
    public static com.google.android.exoplayer2.ExoPlaybackException d(RuntimeException runtimeException) {
        return ExoPlaybackException.e(runtimeException, 1000);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException e(RuntimeException runtimeException, int i2) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(2, runtimeException, i2);
        return exoPlaybackException;
    }

    private static String f(int i, String string2, String string3, int i4, com.google.android.exoplayer2.i1 i15, int i6) {
        int stringBuilder;
        String obj1;
        Object obj3;
        int obj4;
        Object obj5;
        int obj6;
        if (i != 0) {
            if (i != 1) {
                obj1 = i != 3 ? "Unexpected runtime error" : "Remote error";
            } else {
                obj1 = String.valueOf(i15);
                obj5 = w0.c(i6);
                stringBuilder = new StringBuilder(obj6 += length2);
                stringBuilder.append(string3);
                stringBuilder.append(" error, index=");
                stringBuilder.append(i4);
                stringBuilder.append(", format=");
                stringBuilder.append(obj1);
                stringBuilder.append(", format_supported=");
                stringBuilder.append(obj5);
                obj1 = stringBuilder.toString();
            }
        } else {
            obj1 = "Source error";
        }
        if (!TextUtils.isEmpty(string2)) {
            obj1 = String.valueOf(obj1);
            obj4 = new StringBuilder(obj3 += obj4);
            obj4.append(obj1);
            obj4.append(": ");
            obj4.append(string2);
            obj1 = obj4.toString();
        }
        return obj1;
    }

    @Override // com.google.android.exoplayer2.PlaybackException
    com.google.android.exoplayer2.ExoPlaybackException a(x x) {
        String message = getMessage();
        p0.i(message);
        super((String)message, getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, x, this.timestampMs, obj11, this.isRecoverable);
        return exoPlaybackException;
    }
}
