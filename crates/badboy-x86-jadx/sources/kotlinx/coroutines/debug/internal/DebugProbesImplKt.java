package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002", d2 = {"repr", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DebugProbesImplKt {
    public static final String access$repr(String $receiver) {
        return DebugProbesImplKt.repr($receiver);
    }

    private static final String repr(String $this$repr) {
        int i;
        char charAt;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i2 = 0;
        final int i3 = 34;
        sb.append(i3);
        i = 0;
        while (i < $this$repr.length()) {
            charAt = $this$repr.charAt(i);
            if (charAt == i3) {
            } else {
            }
            if (charAt == 92) {
            } else {
            }
            if (charAt == 8) {
            } else {
            }
            if (charAt == 10) {
            } else {
            }
            if (charAt == 13) {
            } else {
            }
            if (charAt == 9) {
            } else {
            }
            sb.append(charAt);
            i++;
            sb.append("\\t");
            sb.append("\\r");
            sb.append("\\n");
            sb.append("\\b");
            sb.append("\\\\");
            sb.append("\\\"");
        }
        sb.append(i3);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
