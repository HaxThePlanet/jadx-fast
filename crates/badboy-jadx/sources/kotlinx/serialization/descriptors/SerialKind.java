package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0002\u0008\tB\t\u0008\u0004¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016\u0082\u0001\u0005\n\u000b\u000c\r\u000e¨\u0006\u000f", d2 = {"Lkotlinx/serialization/descriptors/SerialKind;", "", "<init>", "()V", "toString", "", "hashCode", "", "ENUM", "CONTEXTUAL", "Lkotlinx/serialization/descriptors/PolymorphicKind;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lkotlinx/serialization/descriptors/SerialKind$ENUM;", "Lkotlinx/serialization/descriptors/StructureKind;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class SerialKind {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @ExperimentalSerializationApi
    public static final class CONTEXTUAL extends kotlinx.serialization.descriptors.SerialKind {

        public static final kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL INSTANCE;
        static {
            SerialKind.CONTEXTUAL contextual = new SerialKind.CONTEXTUAL();
            SerialKind.CONTEXTUAL.INSTANCE = contextual;
        }

        private CONTEXTUAL() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/SerialKind$ENUM;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @ExperimentalSerializationApi
    public static final class ENUM extends kotlinx.serialization.descriptors.SerialKind {

        public static final kotlinx.serialization.descriptors.SerialKind.ENUM INSTANCE;
        static {
            SerialKind.ENUM obj = new SerialKind.ENUM();
            SerialKind.ENUM.INSTANCE = obj;
        }

        private ENUM() {
            super(0);
        }
    }
    public SerialKind(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        return simpleName;
    }
}
