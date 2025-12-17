package androidx.emoji2.text.flatbuffer;

/* loaded from: classes5.dex */
interface ReadBuf {
    public abstract byte[] data();

    public abstract byte get(int i);

    public abstract boolean getBoolean(int i);

    public abstract double getDouble(int i);

    public abstract float getFloat(int i);

    public abstract int getInt(int i);

    public abstract long getLong(int i);

    public abstract short getShort(int i);

    public abstract String getString(int i, int i2);

    public abstract int limit();
}
