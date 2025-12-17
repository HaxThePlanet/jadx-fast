package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

/* loaded from: classes2.dex */
public final class h0 {
    private static long a(Map<String, String> map, String string2) {
        Object obj0;
        obj0 = map.get(string2);
        if (map != null && (String)obj0 != null) {
            obj0 = map.get(string2);
            if ((String)(String)obj0 != null) {
                try {
                    return Long.parseLong((String)(String)obj0);
                    return -9223372036854775807L;
                }
            }
        }
    }

    public static Pair<Long, Long> b(com.google.android.exoplayer2.drm.DrmSession drmSession) {
        Map obj4 = drmSession.f();
        if (obj4 == null) {
            return 0;
        }
        Pair pair = new Pair(Long.valueOf(h0.a(obj4, "LicenseDurationRemaining")), Long.valueOf(h0.a(obj4, "PlaybackDurationRemaining")));
        return pair;
    }
}
