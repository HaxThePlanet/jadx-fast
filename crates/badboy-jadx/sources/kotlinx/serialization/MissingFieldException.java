package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\n\u0008\u0007\u0018\u00002\u00020\u0001B)\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\u0008\u0008\u0010\tB\u001f\u0008\u0016\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\u0008\u0008\u0010\u000bB\u0019\u0008\u0016\u0012\u0006\u0010\u000c\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\u0008\u0008\u0010\rB\u0011\u0008\u0011\u0012\u0006\u0010\u000c\u001a\u00020\u0004¢\u0006\u0004\u0008\u0008\u0010\u000eR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0011", d2 = {"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "missingFields", "", "", "message", "cause", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Throwable;)V", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "missingField", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "getMissingFields", "()Ljava/util/List;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public final class MissingFieldException extends kotlinx.serialization.SerializationException {

    private final List<String> missingFields;
    public MissingFieldException(String missingField) {
        Intrinsics.checkNotNullParameter(missingField, "missingField");
        StringBuilder stringBuilder = new StringBuilder();
        super(CollectionsKt.listOf(missingField), stringBuilder.append("Field '").append(missingField).append("' is required, but it was missing").toString(), 0);
    }

    public MissingFieldException(String missingField, String serialName) {
        Intrinsics.checkNotNullParameter(missingField, "missingField");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        StringBuilder stringBuilder = new StringBuilder();
        super(CollectionsKt.listOf(missingField), stringBuilder.append("Field '").append(missingField).append("' is required for type with serial name '").append(serialName).append("', but it was missing").toString(), 0);
    }

    public MissingFieldException(List<String> missingFields, String serialName) {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(missingFields, "missingFields");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        if (missingFields.size() == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("Field '").append((String)missingFields.get(0)).append("' is required for type with serial name '").append(serialName).append("', but it was missing").toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            string = stringBuilder2.append("Fields ").append(missingFields).append(" are required for type with serial name '").append(serialName).append("', but they were missing").toString();
        }
        super(missingFields, string, 0);
    }

    public MissingFieldException(List<String> missingFields, String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(missingFields, "missingFields");
        super(message, cause);
        this.missingFields = missingFields;
    }

    public final List<String> getMissingFields() {
        return this.missingFields;
    }
}
