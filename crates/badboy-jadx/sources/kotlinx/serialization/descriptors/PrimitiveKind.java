package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\u0008\t\n\u000b\u000cB\t\u0008\u0004¢\u0006\u0004\u0008\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "BOOLEAN", "BYTE", "CHAR", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "STRING", "Lkotlinx/serialization/descriptors/PrimitiveKind$BOOLEAN;", "Lkotlinx/serialization/descriptors/PrimitiveKind$BYTE;", "Lkotlinx/serialization/descriptors/PrimitiveKind$CHAR;", "Lkotlinx/serialization/descriptors/PrimitiveKind$DOUBLE;", "Lkotlinx/serialization/descriptors/PrimitiveKind$FLOAT;", "Lkotlinx/serialization/descriptors/PrimitiveKind$INT;", "Lkotlinx/serialization/descriptors/PrimitiveKind$LONG;", "Lkotlinx/serialization/descriptors/PrimitiveKind$SHORT;", "Lkotlinx/serialization/descriptors/PrimitiveKind$STRING;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PrimitiveKind extends kotlinx.serialization.descriptors.SerialKind {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$BOOLEAN;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BOOLEAN extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.BOOLEAN INSTANCE;
        static {
            PrimitiveKind.BOOLEAN obj = new PrimitiveKind.BOOLEAN();
            PrimitiveKind.BOOLEAN.INSTANCE = obj;
        }

        private BOOLEAN() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$BYTE;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BYTE extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.BYTE INSTANCE;
        static {
            PrimitiveKind.BYTE obj = new PrimitiveKind.BYTE();
            PrimitiveKind.BYTE.INSTANCE = obj;
        }

        private BYTE() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$CHAR;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CHAR extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.CHAR INSTANCE;
        static {
            PrimitiveKind.CHAR obj = new PrimitiveKind.CHAR();
            PrimitiveKind.CHAR.INSTANCE = obj;
        }

        private CHAR() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$DOUBLE;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DOUBLE extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.DOUBLE INSTANCE;
        static {
            PrimitiveKind.DOUBLE obj = new PrimitiveKind.DOUBLE();
            PrimitiveKind.DOUBLE.INSTANCE = obj;
        }

        private DOUBLE() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$FLOAT;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FLOAT extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.FLOAT INSTANCE;
        static {
            PrimitiveKind.FLOAT obj = new PrimitiveKind.FLOAT();
            PrimitiveKind.FLOAT.INSTANCE = obj;
        }

        private FLOAT() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$INT;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class INT extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.INT INSTANCE;
        static {
            PrimitiveKind.INT obj = new PrimitiveKind.INT();
            PrimitiveKind.INT.INSTANCE = obj;
        }

        private INT() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$LONG;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LONG extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.LONG INSTANCE;
        static {
            PrimitiveKind.LONG obj = new PrimitiveKind.LONG();
            PrimitiveKind.LONG.INSTANCE = obj;
        }

        private LONG() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$SHORT;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SHORT extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.SHORT INSTANCE;
        static {
            PrimitiveKind.SHORT obj = new PrimitiveKind.SHORT();
            PrimitiveKind.SHORT.INSTANCE = obj;
        }

        private SHORT() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/serialization/descriptors/PrimitiveKind$STRING;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class STRING extends kotlinx.serialization.descriptors.PrimitiveKind {

        public static final kotlinx.serialization.descriptors.PrimitiveKind.STRING INSTANCE;
        static {
            PrimitiveKind.STRING string = new PrimitiveKind.STRING();
            PrimitiveKind.STRING.INSTANCE = string;
        }

        private STRING() {
            super(0);
        }
    }
    private PrimitiveKind() {
        super(0);
    }

    public PrimitiveKind(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }
}
