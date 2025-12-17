package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\u0008\u0004¢\u0006\u0004\u0008\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\u0008", d2 = {"Lkotlinx/serialization/descriptors/PolymorphicKind;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "SEALED", "OPEN", "Lkotlinx/serialization/descriptors/PolymorphicKind$OPEN;", "Lkotlinx/serialization/descriptors/PolymorphicKind$SEALED;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class PolymorphicKind extends kotlinx.serialization.descriptors.SerialKind {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PolymorphicKind$OPEN;", "Lkotlinx/serialization/descriptors/PolymorphicKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OPEN extends kotlinx.serialization.descriptors.PolymorphicKind {

        public static final kotlinx.serialization.descriptors.PolymorphicKind.OPEN INSTANCE;
        static {
            PolymorphicKind.OPEN open = new PolymorphicKind.OPEN();
            PolymorphicKind.OPEN.INSTANCE = open;
        }

        private OPEN() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PolymorphicKind$SEALED;", "Lkotlinx/serialization/descriptors/PolymorphicKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SEALED extends kotlinx.serialization.descriptors.PolymorphicKind {

        public static final kotlinx.serialization.descriptors.PolymorphicKind.SEALED INSTANCE;
        static {
            PolymorphicKind.SEALED sealed = new PolymorphicKind.SEALED();
            PolymorphicKind.SEALED.INSTANCE = sealed;
        }

        private SEALED() {
            super(0);
        }
    }
    private PolymorphicKind() {
        super(0);
    }

    public PolymorphicKind(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }
}
