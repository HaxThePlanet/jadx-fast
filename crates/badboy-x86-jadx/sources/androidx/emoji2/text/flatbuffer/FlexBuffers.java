package androidx.emoji2.text.flatbuffer;

import _COROUTINE.ArtificialStackFrames;
import android.app.Notification.Action;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public class FlexBuffers {

    static final boolean $assertionsDisabled = false;
    private static final androidx.emoji2.text.flatbuffer.ReadBuf EMPTY_BB = null;
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    private static abstract class Object {

        androidx.emoji2.text.flatbuffer.ReadBuf bb;
        int byteWidth;
        int end;
        Object(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
            super();
            this.bb = buff;
            this.end = end;
            this.byteWidth = byteWidth;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            return toString(stringBuilder).toString();
        }

        public abstract StringBuilder toString(StringBuilder stringBuilder);
    }

    private static abstract class Sized extends androidx.emoji2.text.flatbuffer.FlexBuffers.Object {

        protected final int size;
        Sized(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
            super(buff, end, byteWidth);
            this.size = FlexBuffers.access$100(this.bb, end - byteWidth, byteWidth);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Object
        public int size() {
            return this.size;
        }
    }

    public static class Blob extends androidx.emoji2.text.flatbuffer.FlexBuffers.Sized {

        static final boolean $assertionsDisabled;
        static final androidx.emoji2.text.flatbuffer.FlexBuffers.Blob EMPTY;
        static {
            Class<androidx.emoji2.text.flatbuffer.FlexBuffers> obj = FlexBuffers.class;
            final int i = 1;
            FlexBuffers.Blob blob = new FlexBuffers.Blob(FlexBuffers.access$000(), i, i);
            FlexBuffers.Blob.EMPTY = blob;
        }

        Blob(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
            super(buff, end, byteWidth);
        }

        public static androidx.emoji2.text.flatbuffer.FlexBuffers.Blob empty() {
            return FlexBuffers.Blob.EMPTY;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.bb.data());
            wrap.position(this.end);
            wrap.limit(end2 += size);
            return wrap.asReadOnlyBuffer().slice();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public byte get(int pos) {
            int size;
            if (pos < 0) {
            } else {
                if (pos > size()) {
                } else {
                    return this.bb.get(end += pos);
                }
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public byte[] getBytes() {
            int i;
            byte b;
            int i2;
            final int size = size();
            final byte[] bArr = new byte[size];
            i = 0;
            while (i < size) {
                bArr[i] = this.bb.get(end += i);
                i++;
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public String toString() {
            return this.bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public StringBuilder toString(StringBuilder sb) {
            int i = 34;
            sb.append(i);
            sb.append(this.bb.getString(this.end, size()));
            return sb.append(i);
        }
    }

    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String msg) {
            super(msg);
        }
    }

    public static class Key extends androidx.emoji2.text.flatbuffer.FlexBuffers.Object {

        private static final androidx.emoji2.text.flatbuffer.FlexBuffers.Key EMPTY;
        static {
            final int i = 0;
            FlexBuffers.Key key = new FlexBuffers.Key(FlexBuffers.access$000(), i, i);
            FlexBuffers.Key.EMPTY = key;
        }

        Key(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
            super(buff, end, byteWidth);
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffers.Key access$700() {
            return FlexBuffers.Key.EMPTY;
        }

        public static androidx.emoji2.text.flatbuffer.FlexBuffers.Key empty() {
            return FlexBuffers.Key.EMPTY;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Object
        int compareTo(byte[] other) {
            int ia;
            int io;
            byte b;
            byte b2;
            int length;
            ia = this.end;
            io = 0;
            b = this.bb.get(ia);
            b2 = other[io];
            while (b == 0) {
                ia++;
                b = this.bb.get(ia);
                b2 = other[io];
            }
            return b - b2;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Object
        public boolean equals(Object obj) {
            int byteWidth2;
            int i;
            int byteWidth;
            if (!obj instanceof FlexBuffers.Key) {
                return 0;
            }
            if (obj2.end == this.end && obj3.byteWidth == this.byteWidth) {
                if (obj3.byteWidth == this.byteWidth) {
                    i = 1;
                }
            }
            return i;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Object
        public int hashCode() {
            return end ^= byteWidth;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Object
        public String toString() {
            int i;
            byte b;
            i = this.end;
            while (this.bb.get(i) == 0) {
                i++;
            }
            return this.bb.getString(this.end, i - end);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Object
        public StringBuilder toString(StringBuilder sb) {
            return sb.append(toString());
        }
    }

    public static class KeyVector {

        private final androidx.emoji2.text.flatbuffer.FlexBuffers.TypedVector vec;
        KeyVector(androidx.emoji2.text.flatbuffer.FlexBuffers.TypedVector vec) {
            super();
            this.vec = vec;
        }

        public androidx.emoji2.text.flatbuffer.FlexBuffers.Key get(int pos) {
            if (pos >= size()) {
                return FlexBuffers.Key.access$700();
            }
            FlexBuffers.Key key = new FlexBuffers.Key(vec3.bb, FlexBuffers.access$200(vec4.bb, end += i2, vec5.byteWidth), 1);
            return key;
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            int i;
            int str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            i = 0;
            while (i < this.vec.size()) {
                this.vec.get(i).toString(stringBuilder);
                if (i != size2--) {
                }
                i++;
                stringBuilder.append(", ");
            }
            return stringBuilder.append("]").toString();
        }
    }

    public static class Vector extends androidx.emoji2.text.flatbuffer.FlexBuffers.Sized {

        private static final androidx.emoji2.text.flatbuffer.FlexBuffers.Vector EMPTY_VECTOR;
        static {
            final int i = 1;
            FlexBuffers.Vector vector = new FlexBuffers.Vector(FlexBuffers.access$000(), i, i);
            FlexBuffers.Vector.EMPTY_VECTOR = vector;
        }

        Vector(androidx.emoji2.text.flatbuffer.ReadBuf bb, int end, int byteWidth) {
            super(bb, end, byteWidth);
        }

        public static androidx.emoji2.text.flatbuffer.FlexBuffers.Vector empty() {
            return FlexBuffers.Vector.EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public androidx.emoji2.text.flatbuffer.FlexBuffers.Reference get(int index) {
            long l = (long)size;
            if (Long.compare(l2, l) >= 0) {
                return FlexBuffers.Reference.access$600();
            }
            FlexBuffers.Reference reference = new FlexBuffers.Reference(this.bb, end2 += i5, this.byteWidth, FlexBuffers.Unsigned.byteToUnsignedInt(this.bb.get((int)i2)));
            return reference;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public boolean isEmpty() {
            int i;
            i = this == FlexBuffers.Vector.EMPTY_VECTOR ? 1 : 0;
            return i;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Sized
        public StringBuilder toString(StringBuilder sb) {
            int i;
            int str;
            sb.append("[ ");
            int size = size();
            i = 0;
            while (i < size) {
                get(i).toString(sb);
                if (i != size + -1) {
                }
                i++;
                sb.append(", ");
            }
            sb.append(" ]");
            return sb;
        }
    }

    public static class Map extends androidx.emoji2.text.flatbuffer.FlexBuffers.Vector {

        private static final androidx.emoji2.text.flatbuffer.FlexBuffers.Map EMPTY_MAP;
        static {
            final int i = 1;
            FlexBuffers.Map map = new FlexBuffers.Map(FlexBuffers.access$000(), i, i);
            FlexBuffers.Map.EMPTY_MAP = map;
        }

        Map(androidx.emoji2.text.flatbuffer.ReadBuf bb, int end, int byteWidth) {
            super(bb, end, byteWidth);
        }

        private int binarySearch(androidx.emoji2.text.flatbuffer.FlexBuffers.KeyVector keys, byte[] searchedKey) {
            int low;
            int high;
            int i;
            androidx.emoji2.text.flatbuffer.FlexBuffers.Key buf;
            int compareTo;
            low = 0;
            size--;
            while (low <= high) {
                i2 >>>= 1;
                compareTo = keys.get(i).compareTo(searchedKey);
                high = i + -1;
                low = i + 1;
            }
            return -mid;
        }

        public static androidx.emoji2.text.flatbuffer.FlexBuffers.Map empty() {
            return FlexBuffers.Map.EMPTY_MAP;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public androidx.emoji2.text.flatbuffer.FlexBuffers.Reference get(String key) {
            return get(key.getBytes(StandardCharsets.UTF_8));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public androidx.emoji2.text.flatbuffer.FlexBuffers.Reference get(byte[] key) {
            final androidx.emoji2.text.flatbuffer.FlexBuffers.KeyVector keys = keys();
            final int binarySearch = binarySearch(keys, key);
            if (binarySearch >= 0 && binarySearch < keys.size()) {
                if (binarySearch < keys.size()) {
                    return get(binarySearch);
                }
            }
            return FlexBuffers.Reference.access$600();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public androidx.emoji2.text.flatbuffer.FlexBuffers.KeyVector keys() {
            final int i = 3;
            end -= i3;
            FlexBuffers.TypedVector typedVector = new FlexBuffers.TypedVector(this.bb, FlexBuffers.access$200(this.bb, i2, this.byteWidth), FlexBuffers.access$100(this.bb, byteWidth3 += i2, this.byteWidth), 4);
            FlexBuffers.KeyVector keyVector = new FlexBuffers.KeyVector(typedVector);
            return keyVector;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public StringBuilder toString(StringBuilder builder) {
            int i;
            int str2;
            String str;
            builder.append("{ ");
            final int size = size();
            i = 0;
            while (i < size) {
                builder.append('"').append(keys().get(i).toString()).append("\" : ");
                builder.append(values().get(i).toString());
                if (i != size + -1) {
                }
                i++;
                builder.append(", ");
            }
            builder.append(" }");
            return builder;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public androidx.emoji2.text.flatbuffer.FlexBuffers.Vector values() {
            FlexBuffers.Vector vector = new FlexBuffers.Vector(this.bb, this.end, this.byteWidth);
            return vector;
        }
    }

    public static class Reference {

        private static final androidx.emoji2.text.flatbuffer.FlexBuffers.Reference NULL_REFERENCE;
        private androidx.emoji2.text.flatbuffer.ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;
        static {
            final int i = 0;
            FlexBuffers.Reference reference = new FlexBuffers.Reference(FlexBuffers.access$000(), i, 1, i);
            FlexBuffers.Reference.NULL_REFERENCE = reference;
        }

        Reference(androidx.emoji2.text.flatbuffer.ReadBuf bb, int end, int parentWidth, int packedType) {
            super(bb, end, parentWidth, i2 << i, packedType >> 2);
        }

        Reference(androidx.emoji2.text.flatbuffer.ReadBuf bb, int end, int parentWidth, int byteWidth, int type) {
            super();
            this.bb = bb;
            this.end = end;
            this.parentWidth = parentWidth;
            this.byteWidth = byteWidth;
            this.type = type;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffers.Reference access$600() {
            return FlexBuffers.Reference.NULL_REFERENCE;
        }

        public androidx.emoji2.text.flatbuffer.FlexBuffers.Blob asBlob() {
            boolean string;
            if (!isBlob() && isString()) {
                if (isString()) {
                }
                return FlexBuffers.Blob.empty();
            }
            FlexBuffers.Blob blob = new FlexBuffers.Blob(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
            return blob;
        }

        public boolean asBoolean() {
            int i;
            i = 1;
            final int i2 = 0;
            if (isBoolean()) {
                if (this.bb.get(this.end) != 0) {
                } else {
                    i = i2;
                }
                return i;
            }
            if (Long.compare(uInt, i3) != 0) {
            } else {
                i = i2;
            }
            return i;
        }

        public double asFloat() {
            if (this.type == 3) {
                return FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
            }
            int i4 = 0;
            switch (type2) {
                case 0:
                    return i4;
                case 1:
                    return (double)i2;
                case 2:
                    return (double)l2;
                case 5:
                    return Double.parseDouble(asString());
                case 6:
                    return (double)i;
                case 7:
                    return (double)l;
                case 8:
                    return FlexBuffers.access$400(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 10:
                    return (double)size;
                default:
                    return i4;
            }
        }

        public int asInt() {
            if (this.type == 1) {
                return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
            }
            int i9 = 0;
            switch (type2) {
                case 0:
                    return i9;
                case 2:
                    return (int)l2;
                case 3:
                    return (int)d;
                case 5:
                    return Integer.parseInt(asString());
                case 6:
                    return FlexBuffers.access$100(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return (int)l;
                case 8:
                    return (int)d2;
                case 10:
                    return asVector().size();
                case 26:
                    return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
                default:
                    return i9;
            }
        }

        public androidx.emoji2.text.flatbuffer.FlexBuffers.Key asKey() {
            if (isKey()) {
                FlexBuffers.Key key2 = new FlexBuffers.Key(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                return key2;
            }
            return FlexBuffers.Key.empty();
        }

        public long asLong() {
            if (this.type == 1) {
                return FlexBuffers.access$500(this.bb, this.end, this.parentWidth);
            }
            int i3 = 0;
            switch (type2) {
                case 0:
                    return i3;
                case 2:
                    return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
                case 3:
                    return (long)d;
                case 5:
                    return Long.parseLong(asString());
                case 6:
                    return FlexBuffers.access$500(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return FlexBuffers.access$300(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.parentWidth);
                case 8:
                    return (long)d2;
                case 10:
                    return (long)size;
                case 26:
                    return (long)i;
                default:
                    return i3;
            }
        }

        public androidx.emoji2.text.flatbuffer.FlexBuffers.Map asMap() {
            if (isMap()) {
                FlexBuffers.Map map2 = new FlexBuffers.Map(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                return map2;
            }
            return FlexBuffers.Map.empty();
        }

        public String asString() {
            int i;
            int byteWidth;
            if (isString()) {
                int i3 = FlexBuffers.access$200(this.bb, this.end, this.parentWidth);
                return this.bb.getString(i3, (int)l);
            }
            if (isKey()) {
                int i2 = FlexBuffers.access$200(this.bb, this.end, this.byteWidth);
                i = i2;
                while (this.bb.get(i) == 0) {
                    i++;
                }
                return this.bb.getString(i2, i - i2);
            }
            return "";
        }

        public long asUInt() {
            if (this.type == 2) {
                return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
            }
            int i3 = 0;
            switch (type2) {
                case 0:
                    return i3;
                case 1:
                    return FlexBuffers.access$500(this.bb, this.end, this.parentWidth);
                case 3:
                    return (long)d;
                case 5:
                    return Long.parseLong(asString());
                case 6:
                    return FlexBuffers.access$500(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 7:
                    return FlexBuffers.access$300(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                case 8:
                    return (long)d2;
                case 10:
                    return (long)size;
                case 26:
                    return (long)i;
                default:
                    return i3;
            }
        }

        public androidx.emoji2.text.flatbuffer.FlexBuffers.Vector asVector() {
            if (isVector()) {
                FlexBuffers.Vector vector2 = new FlexBuffers.Vector(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth);
                return vector2;
            }
            if (this.type == 15) {
                FlexBuffers.TypedVector typedVector = new FlexBuffers.TypedVector(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth, 4);
                return typedVector;
            }
            if (FlexBuffers.isTypedVector(this.type)) {
                FlexBuffers.TypedVector typedVector3 = new FlexBuffers.TypedVector(this.bb, FlexBuffers.access$200(this.bb, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
                return typedVector3;
            }
            return FlexBuffers.Vector.empty();
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            int i;
            i = this.type == 25 ? 1 : 0;
            return i;
        }

        public boolean isBoolean() {
            int i;
            i = this.type == 26 ? 1 : 0;
            return i;
        }

        public boolean isFloat() {
            int i;
            int type;
            int i2;
            if (this.type != 3) {
                if (this.type == 8) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public boolean isInt() {
            int type;
            int i;
            int i2;
            if (this.type != 1) {
                if (this.type == 6) {
                } else {
                    i = 0;
                }
            }
            return i;
        }

        public boolean isIntOrUInt() {
            int i;
            boolean uInt;
            if (!isInt()) {
                if (isUInt()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public boolean isKey() {
            int i;
            i = this.type == 4 ? 1 : 0;
            return i;
        }

        public boolean isMap() {
            int i;
            i = this.type == 9 ? 1 : 0;
            return i;
        }

        public boolean isNull() {
            int i;
            i = this.type == 0 ? 1 : 0;
            return i;
        }

        public boolean isNumeric() {
            int i;
            boolean intOrUInt;
            if (!isIntOrUInt()) {
                if (isFloat()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public boolean isString() {
            int i;
            i = this.type == 5 ? 1 : 0;
            return i;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i;
            int type;
            int i2;
            if (this.type != 2) {
                if (this.type == 7) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public boolean isVector() {
            int i2;
            int type;
            int i;
            if (this.type != 10) {
                if (this.type == 9) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            } else {
            }
            return i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            return toString(stringBuilder).toString();
        }

        StringBuilder toString(StringBuilder sb) {
            int i = 34;
            switch (type) {
                case 0:
                    return sb.append("null");
                case 1:
                    return sb.append(asLong());
                case 2:
                    return sb.append(asUInt());
                case 3:
                    return sb.append(asFloat());
                case 4:
                    return asKey().toString(sb.append(i)).append(i);
                case 5:
                    return sb.append(i).append(asString()).append(i);
                case 6:
                    return asMap().toString(sb);
                case 7:
                    return asVector().toString(sb);
                case 8:
                    return sb.append(asVector());
                case 9:
                    StringBuilder stringBuilder = new StringBuilder();
                    FlexBuffers.FlexBufferException flexBufferException = new FlexBuffers.FlexBufferException(stringBuilder.append("not_implemented:").append(this.type).toString());
                    throw flexBufferException;
                case 10:
                    return asBlob().toString(sb);
                case 11:
                    return sb.append(asBoolean());
                default:
                    return sb;
            }
        }
    }

    public static class TypedVector extends androidx.emoji2.text.flatbuffer.FlexBuffers.Vector {

        private static final androidx.emoji2.text.flatbuffer.FlexBuffers.TypedVector EMPTY_VECTOR;
        private final int elemType;
        static {
            final int i = 1;
            FlexBuffers.TypedVector typedVector = new FlexBuffers.TypedVector(FlexBuffers.access$000(), i, i, i);
            FlexBuffers.TypedVector.EMPTY_VECTOR = typedVector;
        }

        TypedVector(androidx.emoji2.text.flatbuffer.ReadBuf bb, int end, int byteWidth, int elemType) {
            super(bb, end, byteWidth);
            this.elemType = elemType;
        }

        public static androidx.emoji2.text.flatbuffer.FlexBuffers.TypedVector empty() {
            return FlexBuffers.TypedVector.EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public androidx.emoji2.text.flatbuffer.FlexBuffers.Reference get(int pos) {
            if (pos >= size()) {
                return FlexBuffers.Reference.access$600();
            }
            FlexBuffers.Reference reference = new FlexBuffers.Reference(this.bb, end + i, this.byteWidth, 1, this.elemType);
            return reference;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public int getElemType() {
            return this.elemType;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers$Vector
        public boolean isEmptyVector() {
            int i;
            i = this == FlexBuffers.TypedVector.EMPTY_VECTOR ? 1 : 0;
            return i;
        }
    }

    static class Unsigned {
        static int byteToUnsignedInt(byte x) {
            return x & 255;
        }

        static long intToUnsignedLong(int x) {
            return l &= l2;
        }

        static int shortToUnsignedInt(short x) {
            return i &= x;
        }
    }
    static {
        final int i = 1;
        final byte[] bArr = new byte[i];
        final int i2 = 0;
        bArr[i2] = i2;
        ArrayReadWriteBuf arrayReadWriteBuf = new ArrayReadWriteBuf(bArr, i);
        FlexBuffers.EMPTY_BB = arrayReadWriteBuf;
    }

    static androidx.emoji2.text.flatbuffer.ReadBuf access$000() {
        return FlexBuffers.EMPTY_BB;
    }

    static int access$100(androidx.emoji2.text.flatbuffer.ReadBuf x0, int x1, int x2) {
        return FlexBuffers.readInt(x0, x1, x2);
    }

    static int access$200(androidx.emoji2.text.flatbuffer.ReadBuf x0, int x1, int x2) {
        return FlexBuffers.indirect(x0, x1, x2);
    }

    static long access$300(androidx.emoji2.text.flatbuffer.ReadBuf x0, int x1, int x2) {
        return FlexBuffers.readUInt(x0, x1, x2);
    }

    static double access$400(androidx.emoji2.text.flatbuffer.ReadBuf x0, int x1, int x2) {
        return FlexBuffers.readDouble(x0, x1, x2);
    }

    static long access$500(androidx.emoji2.text.flatbuffer.ReadBuf x0, int x1, int x2) {
        return FlexBuffers.readLong(x0, x1, x2);
    }

    public static androidx.emoji2.text.flatbuffer.FlexBuffers.Reference getRoot(androidx.emoji2.text.flatbuffer.ReadBuf buffer) {
        limit--;
        final byte b = buffer.get(end);
        end--;
        FlexBuffers.Reference reference = new FlexBuffers.Reference(buffer, end2 -= b, b, FlexBuffers.Unsigned.byteToUnsignedInt(buffer.get(end2)));
        return reference;
    }

    @Deprecated
    public static androidx.emoji2.text.flatbuffer.FlexBuffers.Reference getRoot(ByteBuffer buffer) {
        Object byteBufferReadWriteBuf;
        byte[] array;
        int limit;
        if (buffer.hasArray()) {
            byteBufferReadWriteBuf = new ArrayReadWriteBuf(buffer.array(), buffer.limit());
        } else {
            byteBufferReadWriteBuf = new ByteBufferReadWriteBuf(buffer);
        }
        return FlexBuffers.getRoot(byteBufferReadWriteBuf);
    }

    private static int indirect(androidx.emoji2.text.flatbuffer.ReadBuf bb, int offset, int byteWidth) {
        return (int)i;
    }

    static boolean isTypeInline(int type) {
        int i2;
        int i;
        if (type > 3) {
            if (type == 26) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    static boolean isTypedVector(int type) {
        int i2;
        int i;
        if (type >= 11) {
            if (type > 15) {
                i = type == 36 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    static boolean isTypedVectorElementType(int type) {
        int i;
        int i2;
        if (type >= 1) {
            if (type > 4) {
                if (type == 26) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static double readDouble(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
        switch (byteWidth) {
            case 4:
                return (double)float;
            case 8:
                return buff.getDouble(end);
            default:
                return -4616189618054758400L;
        }
    }

    private static int readInt(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
        return (int)long;
    }

    private static long readLong(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
        switch (byteWidth) {
            case 1:
                return (long)b;
            case 2:
                return (long)short;
            case 4:
                return (long)int;
            case 8:
                return buff.getLong(end);
            default:
                return -1;
        }
    }

    private static long readUInt(androidx.emoji2.text.flatbuffer.ReadBuf buff, int end, int byteWidth) {
        switch (byteWidth) {
            case 1:
                return (long)byteToUnsignedInt;
            case 2:
                return (long)shortToUnsignedInt;
            case 4:
                return FlexBuffers.Unsigned.intToUnsignedLong(buff.getInt(end));
            case 8:
                return buff.getLong(end);
            default:
                return -1;
        }
    }

    static int toTypedVector(int type, int fixedLength) {
        if (!FlexBuffers.isTypedVectorElementType(type)) {
        } else {
            switch (fixedLength) {
                case 0:
                    return i4 += 11;
                case 1:
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                case 2:
                    return i6 += 16;
                case 3:
                    return i8 += 19;
                default:
                    return i2 += 22;
            }
        }
        AssertionError assertionError2 = new AssertionError();
        throw assertionError2;
    }

    static int toTypedVectorElementType(int original_type) {
        return i++;
    }
}
