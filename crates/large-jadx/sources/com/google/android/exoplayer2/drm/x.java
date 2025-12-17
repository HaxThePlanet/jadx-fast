package com.google.android.exoplayer2.drm;

import android.media.MediaDrm.MediaDrmStateException;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;

/* loaded from: classes2.dex */
public final class x {

    private static final class a {
        public static boolean a(Throwable throwable) {
            return throwable instanceof DeniedByServerException;
        }

        public static boolean b(Throwable throwable) {
            return throwable instanceof NotProvisionedException;
        }
    }

    private static final class b {
        public static boolean a(Throwable throwable) {
            return throwable instanceof MediaDrm.MediaDrmStateException;
        }

        public static int b(Throwable throwable) {
            return w0.b(p0.N((MediaDrm.MediaDrmStateException)throwable.getDiagnosticInfo()));
        }
    }

    private static final class c {
        public static boolean a(Throwable throwable) {
            return throwable instanceof MediaDrmResetException;
        }
    }
    public static int a(Exception exception, int i2) {
        int i3;
        int i4;
        int i;
        boolean z;
        i3 = p0.a;
        if (i3 >= 21 && x.b.a(exception)) {
            if (x.b.a(exception)) {
                return x.b.b(exception);
            }
        }
        final int i6 = 6006;
        if (i3 >= 23 && x.c.a(exception)) {
            if (x.c.a(exception)) {
                return i6;
            }
        }
        int i5 = 6002;
        final int i7 = 18;
        if (i3 >= i7 && x.a.b(exception)) {
            if (x.a.b(exception)) {
                return i5;
            }
        }
        if (i3 >= i7 && x.a.a(exception)) {
            if (x.a.a(exception)) {
                return 6007;
            }
        }
        if (exception instanceof UnsupportedDrmException != null) {
            return 6001;
        }
        if (exception instanceof DefaultDrmSessionManager.MissingSchemeDataException != null) {
            return 6003;
        }
        if (exception instanceof KeysExpiredException != null) {
            return 6008;
        }
        if (i2 == 1) {
            return i6;
        }
        if (i2 == 2) {
            return 6004;
        }
        if (i2 != 3) {
        } else {
            return i5;
        }
        IllegalArgumentException obj5 = new IllegalArgumentException();
        throw obj5;
    }
}
