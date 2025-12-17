package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0008\u0010\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008B\u001b\u0008\u0000\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000c¨\u0006\r", d2 = {"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "fieldName", "", "(Ljava/lang/String;)V", "fieldNames", "", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "message", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MissingFieldException extends kotlinx.serialization.SerializationException {
    public MissingFieldException(String string, Throwable throwable2) {
        super(string, throwable2);
    }

    public MissingFieldException(List<String> list, String string2) {
        StringBuilder stringBuilder;
        int str;
        String obj3;
        n.f(list, "fieldNames");
        n.f(string2, "serialName");
        if (list.size() == 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Field '");
            stringBuilder.append((String)list.get(0));
            stringBuilder.append("' is required for type with serial name '");
            stringBuilder.append(string2);
            obj3 = "', but it was missing";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Fields ");
            stringBuilder.append(list);
            stringBuilder.append(" are required for type with serial name '");
            stringBuilder.append(string2);
            obj3 = "', but they were missing";
        }
        stringBuilder.append(obj3);
        super(stringBuilder.toString(), 0);
    }
}
