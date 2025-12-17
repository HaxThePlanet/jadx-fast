package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class Ref {

    public static final class BooleanRef implements Serializable {

        public boolean element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ByteRef implements Serializable {

        public byte element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class CharRef implements Serializable {

        public char element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class DoubleRef implements Serializable {

        public double element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class FloatRef implements Serializable {

        public float element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class IntRef implements Serializable {

        public int element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class LongRef implements Serializable {

        public long element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ObjectRef implements Serializable {

        public T element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class ShortRef implements Serializable {

        public short element;
        @Override // java.io.Serializable
        public String toString() {
            return String.valueOf(this.element);
        }
    }
}
