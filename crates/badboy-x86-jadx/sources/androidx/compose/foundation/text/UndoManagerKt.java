package androidx.compose.foundation.text;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"SNAPSHOTS_INTERVAL_MILLIS", "", "getSNAPSHOTS_INTERVAL_MILLIS", "()I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UndoManagerKt {

    private static final int SNAPSHOTS_INTERVAL_MILLIS = 5000;
    static {
        final int i = 5000;
    }

    public static final int getSNAPSHOTS_INTERVAL_MILLIS() {
        return UndoManagerKt.SNAPSHOTS_INTERVAL_MILLIS;
    }
}
