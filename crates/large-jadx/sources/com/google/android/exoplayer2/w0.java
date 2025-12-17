package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioManager;
import java.util.UUID;

/* loaded from: classes.dex */
public final class w0 {

    public static final UUID a;
    public static final UUID b;
    public static final UUID c;
    public static final UUID d;
    public static final UUID e;
    static {
        int i = 0;
        UUID uuid = new UUID(i, obj2, i, obj2);
        w0.a = uuid;
        UUID uuid2 = new UUID(1186680826959645954L, obj2, -5988876978535335093L, obj4);
        w0.b = uuid2;
        UUID uuid3 = new UUID(-2129748144642739255L, obj2, 8654423357094679310L, obj4);
        w0.c = uuid3;
        UUID uuid4 = new UUID(-1301668207276963122L, obj2, -6645017420763422227L, obj4);
        w0.d = uuid4;
        UUID uuid5 = new UUID(-7348484286925749626L, obj2, -6083546864340672619L, obj4);
        w0.e = uuid5;
    }

    public static int a(Context context) {
        int obj1;
        obj1 = context.getSystemService("audio");
        if ((AudioManager)obj1 == null) {
            obj1 = -1;
        } else {
            obj1 = (AudioManager)obj1.generateAudioSessionId();
        }
        return obj1;
    }

    public static int b(int i) {
        int i2;
        if (i != 2 && i != 4 && i != 10 && i != 7 && i != 8) {
            if (i != 4) {
                if (i != 10) {
                    if (i != 7) {
                        if (i != 8) {
                            switch (i) {
                                case 15:
                                    return 6003;
                                case 16:
                                    return 6005;
                                case 17:
                                    return 6004;
                                default:
                                    return 6002;
                            }
                            return 6006;
                        }
                    }
                }
            }
        }
    }

    public static String c(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                        } else {
                            return "YES";
                        }
                        IllegalStateException obj1 = new IllegalStateException();
                        throw obj1;
                    }
                    return "NO_EXCEEDS_CAPABILITIES";
                }
                return "NO_UNSUPPORTED_DRM";
            }
            return "NO_UNSUPPORTED_TYPE";
        }
        return "NO";
    }

    public static long d(long l) {
        int cmp;
        long obj2;
        if (Long.compare(l, l2) != 0) {
            if (Long.compare(l, l3) == 0) {
            } else {
                l *= cmp;
            }
        }
        return obj2;
    }

    public static long e(long l) {
        int cmp;
        long obj2;
        if (Long.compare(l, l2) != 0) {
            if (Long.compare(l, l3) == 0) {
            } else {
                l /= cmp;
            }
        }
        return obj2;
    }
}
