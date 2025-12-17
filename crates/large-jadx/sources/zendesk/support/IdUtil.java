package zendesk.support;

import java.util.UUID;

/* loaded from: classes3.dex */
public class IdUtil {
    private static UUID generateUniqueId() {
        return UUID.randomUUID();
    }

    public static long newLongId() {
        return mostSignificantBits &= l;
    }

    public static String newStringId() {
        return IdUtil.generateUniqueId().toString();
    }
}
