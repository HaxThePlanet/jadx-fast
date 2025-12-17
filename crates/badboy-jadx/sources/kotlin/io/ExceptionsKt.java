package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0006", d2 = {"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ExceptionsKt {
    public static final String access$constructMessage(File file, File other, String reason) {
        return ExceptionsKt.constructMessage(file, other, reason);
    }

    private static final String constructMessage(File file, File other, String reason) {
        String string;
        String str;
        StringBuilder stringBuilder = new StringBuilder(file.toString());
        if (other != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder.append(stringBuilder2.append(" -> ").append(other).toString());
        }
        if (reason != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder.append(stringBuilder3.append(": ").append(reason).toString());
        }
        String string2 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }
}
