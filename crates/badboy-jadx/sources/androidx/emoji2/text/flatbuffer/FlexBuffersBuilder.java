package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class FlexBuffersBuilder {

    static final boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8;
    private final androidx.emoji2.text.flatbuffer.ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value> stack;
    private final HashMap<String, Integer> stringPool;

    private static class Value {

        static final boolean $assertionsDisabled;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;
        static {
            final Class<androidx.emoji2.text.flatbuffer.FlexBuffersBuilder> obj = FlexBuffersBuilder.class;
        }

        Value(int key, int type, int bitWidth, double dValue) {
            super();
            this.key = key;
            this.type = type;
            this.minBitWidth = bitWidth;
            this.dValue = dValue;
            this.iValue = Long.MIN_VALUE;
        }

        Value(int key, int type, int bitWidth, long iValue) {
            super();
            this.key = key;
            this.type = type;
            this.minBitWidth = bitWidth;
            this.iValue = iValue;
            this.dValue = 1;
        }

        static int access$100(int x0, int x1) {
            return FlexBuffersBuilder.Value.paddingBytes(x0, x1);
        }

        static int access$200(androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value x0, int x1, int x2) {
            return x0.elemWidth(x1, x2);
        }

        static byte access$300(androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value x0) {
            return x0.storedPackedType();
        }

        static byte access$400(androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value x0, int x1) {
            return x0.storedPackedType(x1);
        }

        static int access$500(int x0, int x1, long x2, int x3, int x4) {
            return FlexBuffersBuilder.Value.elemWidth(x0, x1, x2, x3, x4);
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value blob(int key, int position, int type, int bitWidth) {
            FlexBuffersBuilder.Value value = new FlexBuffersBuilder.Value(key, type, bitWidth, (long)position, obj5);
            return value;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value bool(int key, boolean b) {
            int i;
            i = b ? 1 : 0;
            FlexBuffersBuilder.Value value = new FlexBuffersBuilder.Value(key, 26, 0, i, obj5);
            return value;
        }

        private int elemWidth(int bufSize, int elemIndex) {
            return FlexBuffersBuilder.Value.elemWidth(this.type, this.minBitWidth, this.iValue, obj3, bufSize);
        }

        private static int elemWidth(int type, int minBitWidth, long iValue, int bufSize, int elemIndex) {
            int byteWidth;
            int i;
            int i2;
            int widthUInBits;
            long cmp;
            long l;
            if (FlexBuffers.isTypeInline(type)) {
                return minBitWidth;
            }
            byteWidth = 1;
            while (byteWidth <= 32) {
                widthUInBits = FlexBuffersBuilder.widthUInBits((long)i6);
                byteWidth *= 2;
            }
            AssertionError byteWidth2 = new AssertionError();
            throw byteWidth2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value float32(int key, float value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 3, 2, (double)value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value float64(int key, double value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 3, 3, value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value int16(int key, int value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 1, 1, (long)value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value int32(int key, int value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 1, 2, (long)value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value int64(int key, long value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 1, 3, value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value int8(int key, int value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 1, 0, (long)value, obj5);
            return value2;
        }

        private static byte packedType(int bitWidth, int type) {
            return (byte)i2;
        }

        private static int paddingBytes(int bufSize, int scalarSize) {
            return i2 &= i4;
        }

        private byte storedPackedType() {
            return storedPackedType(0);
        }

        private byte storedPackedType(int parentBitWidth) {
            return FlexBuffersBuilder.Value.packedType(storedWidth(parentBitWidth), this.type);
        }

        private int storedWidth(int parentBitWidth) {
            if (FlexBuffers.isTypeInline(this.type)) {
                return Math.max(this.minBitWidth, parentBitWidth);
            }
            return this.minBitWidth;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value uInt16(int key, int value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 2, 1, (long)value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value uInt32(int key, int value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 2, 2, (long)value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value uInt64(int key, long value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 2, 3, value, obj5);
            return value2;
        }

        static androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value uInt8(int key, int value) {
            FlexBuffersBuilder.Value value2 = new FlexBuffersBuilder.Value(key, 2, 0, (long)value, obj5);
            return value2;
        }
    }
    static {
    }

    public FlexBuffersBuilder() {
        super(256);
    }

    public FlexBuffersBuilder(int bufSize) {
        ArrayReadWriteBuf arrayReadWriteBuf = new ArrayReadWriteBuf(bufSize);
        super(arrayReadWriteBuf, 1);
    }

    public FlexBuffersBuilder(androidx.emoji2.text.flatbuffer.ReadWriteBuf bb, int flags) {
        super();
        ArrayList arrayList = new ArrayList();
        this.stack = arrayList;
        HashMap hashMap = new HashMap();
        this.keyPool = hashMap;
        HashMap hashMap2 = new HashMap();
        this.stringPool = hashMap2;
        this.finished = false;
        FlexBuffersBuilder.1 anon = new FlexBuffersBuilder.1(this);
        this.keyComparator = anon;
        this.bb = bb;
        this.flags = flags;
    }

    public FlexBuffersBuilder(ByteBuffer bb) {
        super(bb, 1);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer bb, int flags) {
        ArrayReadWriteBuf arrayReadWriteBuf = new ArrayReadWriteBuf(bb.array());
        super(arrayReadWriteBuf, flags);
    }

    static androidx.emoji2.text.flatbuffer.ReadWriteBuf access$000(androidx.emoji2.text.flatbuffer.FlexBuffersBuilder x0) {
        return x0.bb;
    }

    private int align(int alignment) {
        int i;
        int i2;
        int i3;
        i4 <<= alignment;
        i = FlexBuffersBuilder.Value.access$100(this.bb.writePosition(), i5);
        while (i != 0) {
            this.bb.put(0);
            i = i2;
        }
        return i5;
    }

    private androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value createKeyVector(int start, int length) {
        int i2;
        int i3;
        int i;
        int key2;
        int key;
        int bitWidth;
        int i4;
        int i6;
        long l;
        int position;
        int i5;
        final Object obj = this;
        final Object obj2 = length;
        int i7 = 0;
        i3 = start;
        bitWidth = i2;
        while (i3 < obj.stack.size()) {
            bitWidth = Math.max(bitWidth, FlexBuffersBuilder.Value.access$500(4, 0, (long)key3, obj13, obj.bb.writePosition()));
            i3++;
        }
        int align = obj.align(bitWidth);
        obj.writeInt((long)obj2, obj6);
        i = start;
        while (i < obj.stack.size()) {
            obj.writeOffset((long)key, i6);
            i++;
        }
        FlexBuffersBuilder.Value i9 = new FlexBuffersBuilder.Value(-1, FlexBuffers.toTypedVector(4, i7), bitWidth, (long)position2, i6);
        return i9;
    }

    private androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value createVector(int key, int start, int length, boolean typed, boolean fixed, androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value keys) {
        int bitWidth;
        int typedVectorElementType2;
        int typedVector;
        int i4;
        int prefixElems;
        int i2;
        int vectorType;
        int i3;
        int typedVectorElementType;
        int i5;
        int minBitWidth;
        int size;
        byte b;
        int i;
        int bitWidth2;
        int i6;
        final int i7 = length;
        final androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value builder = keys;
        if (fixed) {
            if (!typed) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        i4 = 0;
        if (builder != null) {
            bitWidth = Math.max(Math.max(i4, FlexBuffersBuilder.widthUInBits((long)i7)), FlexBuffersBuilder.Value.access$200(builder, this.bb.writePosition(), i4));
            prefixElems += 2;
        }
        vectorType = 4;
        i3 = start;
        bitWidth2 = bitWidth;
        while (i3 < this.stack.size()) {
            bitWidth2 = Math.max(bitWidth2, FlexBuffersBuilder.Value.access$200((FlexBuffersBuilder.Value)this.stack.get(i3), this.bb.writePosition(), i3 + prefixElems));
            i6 = start;
            i3++;
        }
        int i11 = start;
        if (fixed) {
            if (!FlexBuffers.isTypedVectorElementType(vectorType)) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        int align = align(bitWidth2);
        if (builder != null) {
            writeOffset(builder.iValue, typedVectorElementType);
            writeInt(i8 <<= minBitWidth, typedVectorElementType);
        }
        if (!fixed) {
            writeInt((long)i7, typedVectorElementType);
        }
        i5 = start;
        while (i5 < this.stack.size()) {
            writeAny((FlexBuffersBuilder.Value)this.stack.get(i5), align);
            i5++;
        }
        if (!typed) {
            i5 = start;
            while (i5 < this.stack.size()) {
                this.bb.put(FlexBuffersBuilder.Value.access$400((FlexBuffersBuilder.Value)this.stack.get(i5), bitWidth2));
                i5++;
            }
        }
        if (builder != null) {
            i = typedVector;
        } else {
            if (typed) {
                if (fixed) {
                    i4 = i7;
                }
                typedVector = FlexBuffers.toTypedVector(vectorType, i4);
            } else {
                typedVector = 10;
            }
            i = typedVector;
        }
        FlexBuffersBuilder.Value i9 = new FlexBuffersBuilder.Value(key, i, bitWidth2, (long)position2, obj12);
        return i9;
    }

    private int putKey(String key) {
        int pos;
        byte[] bytes;
        int keyPool;
        byte[] valueOf;
        Integer valueOf2;
        int length;
        if (key == null) {
            return -1;
        }
        pos = this.bb.writePosition();
        keyPool = 0;
        if (flags &= 1 != 0) {
            bytes = this.keyPool.get(key);
            if ((Integer)bytes == null) {
                valueOf = key.getBytes(StandardCharsets.UTF_8);
                this.bb.put(valueOf, keyPool, valueOf.length);
                this.bb.put(keyPool);
                this.keyPool.put(key, Integer.valueOf(pos));
            } else {
                pos = (Integer)bytes.intValue();
            }
        } else {
            bytes = key.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, keyPool, bytes.length);
            this.bb.put(keyPool);
            this.keyPool.put(key, Integer.valueOf(pos));
        }
        return pos;
    }

    private void putUInt(String key, long value) {
        androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value uInt8;
        final int key2 = putKey(key);
        final int widthUInBits = FlexBuffersBuilder.widthUInBits(value);
        if (widthUInBits == 0) {
            uInt8 = FlexBuffersBuilder.Value.uInt8(key2, (int)value);
        } else {
            if (widthUInBits == 1) {
                uInt8 = FlexBuffersBuilder.Value.uInt16(key2, (int)value);
            } else {
                if (widthUInBits == 2) {
                    uInt8 = FlexBuffersBuilder.Value.uInt32(key2, (int)value);
                } else {
                    uInt8 = FlexBuffersBuilder.Value.uInt64(key2, value);
                }
            }
        }
        this.stack.add(uInt8);
    }

    private void putUInt64(String key, long value) {
        this.stack.add(FlexBuffersBuilder.Value.uInt64(putKey(key), value));
    }

    static int widthUInBits(long len) {
        int i = -1;
        if (Long.compare(len, l) <= 0) {
            return 0;
        }
        if (Long.compare(len, l2) <= 0) {
            return 1;
        }
        if (Long.compare(len, intToUnsignedLong) <= 0) {
            return 2;
        }
        return 3;
    }

    private void writeAny(androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value val, int byteWidth) {
        long iValue;
        switch (type) {
            case 0:
                writeInt(val.iValue, obj1);
                break;
            case 1:
                writeDouble(val.dValue, obj1);
                break;
            default:
                writeOffset(val.iValue, obj1);
        }
    }

    private androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value writeBlob(int key, byte[] blob, int type, boolean trailing) {
        androidx.emoji2.text.flatbuffer.ReadWriteBuf readWriteBuf;
        int widthUInBits = FlexBuffersBuilder.widthUInBits((long)length);
        writeInt((long)length2, obj3);
        final int i = 0;
        this.bb.put(blob, i, blob.length);
        if (trailing) {
            this.bb.put(i);
        }
        return FlexBuffersBuilder.Value.blob(key, this.bb.writePosition(), type, widthUInBits);
    }

    private void writeDouble(double val, int byteWidth) {
        androidx.emoji2.text.flatbuffer.ReadWriteBuf readWriteBuf;
        float f;
        if (obj5 == 4) {
            this.bb.putFloat((float)val);
        } else {
            if (obj5 == 8) {
                this.bb.putDouble(val);
            }
        }
    }

    private void writeInt(long value, int byteWidth) {
        androidx.emoji2.text.flatbuffer.ReadWriteBuf readWriteBuf;
        int i;
        switch (obj5) {
            case 1:
                this.bb.put((byte)i2);
                break;
            case 2:
                this.bb.putShort((short)i3);
                break;
            case 4:
                this.bb.putInt((int)value);
                break;
            case 8:
                this.bb.putLong(value);
                break;
            default:
        }
    }

    private void writeOffset(long val, int byteWidth) {
        int cmp;
        int i2;
        int i;
        int i4 = (int)i3;
        if (obj9 != 8) {
            if (Long.compare(l2, i2) >= 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        writeInt((long)i4, obj2);
    }

    private androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value writeString(int key, String s) {
        return writeBlob(key, s.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String key, int start) {
        int stack;
        int i;
        Collections.sort(this.stack.subList(start, this.stack.size()), this.keyComparator);
        Object obj = this;
        int i3 = start;
        final androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value obj9 = obj.createVector(putKey(key), i3, size2 - start, false, false, createKeyVector(start, size -= start));
        while (obj.stack.size() > i3) {
            obj.stack.remove(size5--);
        }
        obj.stack.add(obj9);
        return (int)iValue;
    }

    public int endVector(String key, int start, boolean typed, boolean fixed) {
        boolean obj10;
        boolean obj11;
        Object obj = this;
        final int i = start;
        final androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value obj9 = obj.createVector(putKey(key), i, size - start, typed, fixed, 0);
        while (obj.stack.size() > i) {
            obj.stack.remove(obj11--);
        }
        obj.stack.add(obj9);
        return (int)obj10;
    }

    public ByteBuffer finish() {
        int i2 = 1;
        if (this.stack.size() != i2) {
        } else {
            final int i3 = 0;
            int align = align(FlexBuffersBuilder.Value.access$200((FlexBuffersBuilder.Value)this.stack.get(i3), this.bb.writePosition(), i3));
            writeAny((FlexBuffersBuilder.Value)this.stack.get(i3), align);
            this.bb.put(FlexBuffersBuilder.Value.access$300((FlexBuffersBuilder.Value)this.stack.get(i3)));
            this.bb.put((byte)align);
            this.finished = i2;
            return ByteBuffer.wrap(this.bb.data(), i3, this.bb.writePosition());
        }
        AssertionError byteWidth = new AssertionError();
        throw byteWidth;
    }

    public androidx.emoji2.text.flatbuffer.ReadWriteBuf getBuffer() {
        if (!this.finished) {
        } else {
            return this.bb;
        }
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public int putBlob(String key, byte[] val) {
        androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value blob = writeBlob(putKey(key), val, 25, false);
        this.stack.add(blob);
        return (int)iValue;
    }

    public int putBlob(byte[] value) {
        return putBlob(0, value);
    }

    public void putBoolean(String key, boolean val) {
        this.stack.add(FlexBuffersBuilder.Value.bool(putKey(key), val));
    }

    public void putBoolean(boolean val) {
        putBoolean(0, val);
    }

    public void putFloat(double value) {
        putFloat(0, value);
    }

    public void putFloat(float value) {
        putFloat(0, value);
    }

    public void putFloat(String key, double val) {
        this.stack.add(FlexBuffersBuilder.Value.float64(putKey(key), val));
    }

    public void putFloat(String key, float val) {
        this.stack.add(FlexBuffersBuilder.Value.float32(putKey(key), val));
    }

    public void putInt(int val) {
        putInt(0, val);
    }

    public void putInt(long value) {
        putInt(0, value);
    }

    public void putInt(String key, int val) {
        putInt(key, (long)val);
    }

    public void putInt(String key, long val) {
        int cmp;
        int cmp2;
        int cmp3;
        ArrayList stack;
        androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value int8;
        final int key2 = putKey(key);
        if (Long.compare(i, val) <= 0 && Long.compare(val, i6) <= 0) {
            if (Long.compare(val, i6) <= 0) {
                this.stack.add(FlexBuffersBuilder.Value.int8(key2, (int)val));
            } else {
                if (Long.compare(i2, val) <= 0 && Long.compare(val, i5) <= 0) {
                    if (Long.compare(val, i5) <= 0) {
                        this.stack.add(FlexBuffersBuilder.Value.int16(key2, (int)val));
                    } else {
                        if (Long.compare(i3, val) <= 0 && Long.compare(val, i4) <= 0) {
                            if (Long.compare(val, i4) <= 0) {
                                this.stack.add(FlexBuffersBuilder.Value.int32(key2, (int)val));
                            } else {
                                this.stack.add(FlexBuffersBuilder.Value.int64(key2, val));
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
    }

    public int putString(String value) {
        return putString(0, value);
    }

    public int putString(String key, String val) {
        final int key2 = putKey(key);
        Object obj = this.stringPool.get(val);
        if (flags &= 2 != 0 && (Integer)obj == null) {
            obj = this.stringPool.get(val);
            if ((Integer)(Integer)obj == null) {
                androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value string2 = writeString(key2, val);
                this.stringPool.put(val, Integer.valueOf((int)iValue3));
                this.stack.add(string2);
                return (int)iValue2;
            }
            this.stack.add(FlexBuffersBuilder.Value.blob(key2, (Integer)(Integer)obj.intValue(), 5, FlexBuffersBuilder.widthUInBits((long)length)));
            return obj.intValue();
        }
        androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.Value string = writeString(key2, val);
        this.stack.add(string);
        return (int)iValue;
    }

    public void putUInt(int value) {
        putUInt(0, (long)value);
    }

    public void putUInt(long value) {
        putUInt(0, value);
    }

    public void putUInt64(BigInteger value) {
        putUInt64(0, value.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }
}
