package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008'\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0014J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0014¨\u0006\u0010", d2 = {"Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/internal/TaggedEncoder;", "", "<init>", "()V", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "nested", "nestedName", "elementName", "descriptor", "composeName", "parentName", "childName", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
public abstract class NamedValueEncoder extends kotlinx.serialization.internal.TaggedEncoder<String> {
    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected String composeName(String parentName, String childName) {
        int i;
        Object string;
        int i2;
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        i = (CharSequence)parentName.length() == 0 ? 1 : 0;
        if (i != 0) {
            string = childName;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append(parentName).append('.').append(childName).toString();
        }
        return string;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected String elementName(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return descriptor.getElementName(index);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public Object getTag(SerialDescriptor $this$getTag, int index) {
        return getTag($this$getTag, index);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected final String getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return nested(elementName($this$getTag, index));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected final String nested(String nestedName) {
        Object currentTagOrNull;
        Intrinsics.checkNotNullParameter(nestedName, "nestedName");
        if ((String)getCurrentTagOrNull() == null) {
            currentTagOrNull = "";
        }
        return composeName(currentTagOrNull, nestedName);
    }
}
