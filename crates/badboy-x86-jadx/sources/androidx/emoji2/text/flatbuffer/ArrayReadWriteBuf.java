package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* loaded from: classes5.dex */
public class ArrayReadWriteBuf implements androidx.emoji2.text.flatbuffer.ReadWriteBuf {

    private byte[] buffer;
    private int writePos;
    public ArrayReadWriteBuf() {
        super(10);
    }

    public ArrayReadWriteBuf(int initialCapacity) {
        super(new byte[initialCapacity]);
    }

    public ArrayReadWriteBuf(byte[] buffer) {
        super();
        this.buffer = buffer;
        this.writePos = 0;
    }

    public ArrayReadWriteBuf(byte[] buffer, int startPos) {
        super();
        this.buffer = buffer;
        this.writePos = startPos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public byte get(int index) {
        return this.buffer[index];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean getBoolean(int index) {
        int i;
        i = this.buffer[index] != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public double getDouble(int index) {
        return Double.longBitsToDouble(getLong(index));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public float getFloat(int index) {
        return Float.intBitsToFloat(getInt(index));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int getInt(int index) {
        return i3 |= i10;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public long getLong(int index) {
        int i8 = index + 1;
        int i16 = 255;
        int i = i8 + 1;
        int i13 = i + 1;
        int i11 = i13 + 1;
        int i14 = i11 + 1;
        int i12 = i14 + 1;
        return i6 |= i19;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public short getShort(int index) {
        return (short)i2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public String getString(int start, int size) {
        return Utf8Safe.decodeUtf8Array(this.buffer, start, size);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte value) {
        set(this.writePos, value);
        this.writePos = writePos2++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] value, int start, int length) {
        set(this.writePos, value, start, length);
        this.writePos = writePos2 += length;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean value) {
        setBoolean(this.writePos, value);
        this.writePos = writePos2++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double value) {
        setDouble(this.writePos, value);
        this.writePos = writePos2 += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float value) {
        setFloat(this.writePos, value);
        this.writePos = writePos2 += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int value) {
        setInt(this.writePos, value);
        this.writePos = writePos2 += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long value) {
        setLong(this.writePos, value);
        this.writePos = writePos2 += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short value) {
        setShort(this.writePos, value);
        this.writePos = writePos2 += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int capacity) {
        final int i = 1;
        if (buffer.length > capacity) {
            return i;
        }
        int length2 = buffer2.length;
        this.buffer = Arrays.copyOf(this.buffer, i2 += length2);
        return i;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int index, byte value) {
        requestCapacity(index + 1);
        this.buffer[index] = value;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int index, byte[] toCopy, int start, int length) {
        requestCapacity(i += index);
        System.arraycopy(toCopy, start, this.buffer, index, length);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int index, boolean value) {
        set(index, value);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int index, double value) {
        requestCapacity(index + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(value);
        int i2 = (int)doubleToRawLongBits;
        int i9 = index + 1;
        this.buffer[index] = (byte)i14;
        int i4 = i9 + 1;
        this.buffer[i9] = (byte)i16;
        int i10 = i4 + 1;
        this.buffer[i4] = (byte)i18;
        int i5 = i10 + 1;
        this.buffer[i10] = (byte)i20;
        int obj7 = (int)i11;
        int i12 = i5 + 1;
        this.buffer[i5] = (byte)i21;
        int i6 = i12 + 1;
        this.buffer[i12] = (byte)i23;
        this.buffer[i6] = (byte)i25;
        this.buffer[i6 + 1] = (byte)i8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int index, float value) {
        requestCapacity(index + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(value);
        int i5 = index + 1;
        this.buffer[index] = (byte)i7;
        int i2 = i5 + 1;
        this.buffer[i5] = (byte)i9;
        this.buffer[i2] = (byte)i11;
        this.buffer[i2 + 1] = (byte)i4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int index, int value) {
        requestCapacity(index + 4);
        int i5 = index + 1;
        this.buffer[index] = (byte)i7;
        int i2 = i5 + 1;
        this.buffer[i5] = (byte)i9;
        this.buffer[i2] = (byte)i11;
        this.buffer[i2 + 1] = (byte)i4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int index, long value) {
        requestCapacity(index + 8);
        int i2 = (int)value;
        int i9 = index + 1;
        this.buffer[index] = (byte)i14;
        int i4 = i9 + 1;
        this.buffer[i9] = (byte)i16;
        int i10 = i4 + 1;
        this.buffer[i4] = (byte)i18;
        int i5 = i10 + 1;
        this.buffer[i10] = (byte)i20;
        int obj5 = (int)i11;
        int i12 = i5 + 1;
        this.buffer[i5] = (byte)i21;
        int i6 = i12 + 1;
        this.buffer[i12] = (byte)i23;
        this.buffer[i6] = (byte)i25;
        this.buffer[i6 + 1] = (byte)i8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int index, short value) {
        requestCapacity(index + 2);
        this.buffer[index] = (byte)i5;
        this.buffer[index + 1] = (byte)i3;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }
}
