package androidx.emoji2.text.flatbuffer;

/* loaded from: classes5.dex */
interface ReadWriteBuf extends androidx.emoji2.text.flatbuffer.ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract int limit();

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void put(byte b);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void put(byte[] bArr, int i2, int i3);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void putBoolean(boolean z);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void putDouble(double d);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void putFloat(float f);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void putInt(int i);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void putLong(long l);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void putShort(short s);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract boolean requestCapacity(int i);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void set(int i, byte b2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void set(int i, byte[] b2Arr2, int i3, int i4);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void setBoolean(int i, boolean z2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void setDouble(int i, double d2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void setFloat(int i, float f2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void setInt(int i, int i2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void setLong(int i, long l2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract void setShort(int i, short s2);

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public abstract int writePosition();
}
