package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptor.DefaultImpls;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.MAP;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001B!\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0016\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0013\u0010\u001f\u001a\u00020\u001a2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\u0008\u0010\"\u001a\u00020\u0012H\u0016J\u0008\u0010#\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0001\u0002$%¨\u0006&", d2 = {"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getSerialName", "()Ljava/lang/String;", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getValueDescriptor", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", "", "getElementAnnotations", "", "", "getElementDescriptor", "equals", "other", "", "hashCode", "toString", "Lkotlinx/serialization/internal/HashMapClassDesc;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MapLikeDescriptor implements SerialDescriptor {

    private final int elementsCount;
    private final SerialDescriptor keyDescriptor;
    private final String serialName;
    private final SerialDescriptor valueDescriptor;
    private MapLikeDescriptor(String serialName, SerialDescriptor keyDescriptor, SerialDescriptor valueDescriptor) {
        super();
        this.serialName = serialName;
        this.keyDescriptor = keyDescriptor;
        this.valueDescriptor = valueDescriptor;
        this.elementsCount = 2;
    }

    public MapLikeDescriptor(String string, SerialDescriptor serialDescriptor2, SerialDescriptor serialDescriptor3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(string, serialDescriptor2, serialDescriptor3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof MapLikeDescriptor) {
            return i2;
        }
        if (!Intrinsics.areEqual(getSerialName(), (MapLikeDescriptor)other.getSerialName())) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.keyDescriptor, obj2.keyDescriptor)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.valueDescriptor, obj3.valueDescriptor)) {
            return i2;
        }
        return i;
    }

    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.getAnnotations(this);
    }

    public List<Annotation> getElementAnnotations(int index) {
        int i;
        i = index >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return CollectionsKt.emptyList();
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Illegal index ").append(index).append(", ").append(getSerialName()).append(" expects only non-negative indices").toString().toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        int i;
        SerialDescriptor valueDescriptor;
        i = index >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            switch (i4) {
                case 0:
                    valueDescriptor = this.keyDescriptor;
                    break;
                case 1:
                    valueDescriptor = this.valueDescriptor;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unreached".toString());
                    throw illegalStateException;
            }
            return valueDescriptor;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Illegal index ").append(index).append(", ").append(getSerialName()).append(" expects only non-negative indices").toString().toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt.toIntOrNull(name);
        if (intOrNull == null) {
        } else {
            return intOrNull.intValue();
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(name).append(" is not a valid map index").toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int index) {
        return String.valueOf(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getKeyDescriptor() {
        return this.keyDescriptor;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return (SerialKind)StructureKind.MAP.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getValueDescriptor() {
        return this.valueDescriptor;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return result += i6;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        int i;
        int i2 = 0;
        i = index >= 0 ? 1 : i2;
        if (i == 0) {
        } else {
            return i2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Illegal index ").append(index).append(", ").append(getSerialName()).append(" expects only non-negative indices").toString().toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getSerialName()).append('(').append(this.keyDescriptor).append(", ").append(this.valueDescriptor).append(')').toString();
    }
}
