package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\u0008\u0004¢\u0006\u0004\u0008\u0002\u0010\u0003\u0082\u0001\u0004\u0008\t\n\u000b¨\u0006\u000c", d2 = {"Lkotlinx/serialization/descriptors/StructureKind;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "CLASS", "LIST", "MAP", "OBJECT", "Lkotlinx/serialization/descriptors/StructureKind$CLASS;", "Lkotlinx/serialization/descriptors/StructureKind$LIST;", "Lkotlinx/serialization/descriptors/StructureKind$MAP;", "Lkotlinx/serialization/descriptors/StructureKind$OBJECT;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class StructureKind extends kotlinx.serialization.descriptors.SerialKind {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/StructureKind$CLASS;", "Lkotlinx/serialization/descriptors/StructureKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CLASS extends kotlinx.serialization.descriptors.StructureKind {

        public static final kotlinx.serialization.descriptors.StructureKind.CLASS INSTANCE;
        static {
            StructureKind.CLASS obj = new StructureKind.CLASS();
            StructureKind.CLASS.INSTANCE = obj;
        }

        private CLASS() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/StructureKind$LIST;", "Lkotlinx/serialization/descriptors/StructureKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LIST extends kotlinx.serialization.descriptors.StructureKind {

        public static final kotlinx.serialization.descriptors.StructureKind.LIST INSTANCE;
        static {
            StructureKind.LIST list = new StructureKind.LIST();
            StructureKind.LIST.INSTANCE = list;
        }

        private LIST() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/StructureKind$MAP;", "Lkotlinx/serialization/descriptors/StructureKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MAP extends kotlinx.serialization.descriptors.StructureKind {

        public static final kotlinx.serialization.descriptors.StructureKind.MAP INSTANCE;
        static {
            StructureKind.MAP map = new StructureKind.MAP();
            StructureKind.MAP.INSTANCE = map;
        }

        private MAP() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/StructureKind$OBJECT;", "Lkotlinx/serialization/descriptors/StructureKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OBJECT extends kotlinx.serialization.descriptors.StructureKind {

        public static final kotlinx.serialization.descriptors.StructureKind.OBJECT INSTANCE;
        static {
            StructureKind.OBJECT object = new StructureKind.OBJECT();
            StructureKind.OBJECT.INSTANCE = object;
        }

        private OBJECT() {
            super(0);
        }
    }
    private StructureKind() {
        super(0);
    }

    public StructureKind(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }
}
