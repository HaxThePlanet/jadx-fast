package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
class VersionedParcelParcel extends androidx.versionedparcelable.VersionedParcel {

    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;
    VersionedParcelParcel(Parcel p) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        super(p, p.dataPosition(), p.dataSize(), "", arrayMap, arrayMap2, arrayMap3);
    }

    private VersionedParcelParcel(Parcel p, int offset, int end, String prefix, ArrayMap<String, Method> arrayMap5, ArrayMap<String, Method> arrayMap6, ArrayMap<String, Class> arrayMap7) {
        super(arrayMap5, arrayMap6, arrayMap7);
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.mPositionLookup = sparseIntArray;
        int i = -1;
        this.mCurrentField = i;
        this.mNextRead = 0;
        this.mFieldId = i;
        this.mParcel = p;
        this.mOffset = offset;
        this.mEnd = end;
        this.mNextRead = this.mOffset;
        this.mPrefix = prefix;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int mCurrentField;
        int dataPosition;
        int i;
        Parcel mParcel;
        if (this.mCurrentField >= 0) {
            mCurrentField = this.mPositionLookup.get(this.mCurrentField);
            dataPosition = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(mCurrentField);
            this.mParcel.writeInt(dataPosition - mCurrentField);
            this.mParcel.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected androidx.versionedparcelable.VersionedParcel createSubParcel() {
        int mNextRead;
        mNextRead = this.mNextRead == this.mOffset ? this.mEnd : this.mNextRead;
        StringBuilder stringBuilder = new StringBuilder();
        VersionedParcelParcel versionedParcelParcel = new VersionedParcelParcel(this.mParcel, this.mParcel.dataPosition(), mNextRead, stringBuilder.append(this.mPrefix).append("  ").toString(), this.mReadCache, this.mWriteCache, this.mParcelizerCache);
        return versionedParcelParcel;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        int i;
        i = this.mParcel.readInt() != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int int = this.mParcel.readInt();
        if (int < 0) {
            return null;
        }
        byte[] bArr = new byte[int];
        this.mParcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected java.lang.CharSequence readCharSequence() {
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int fieldId) {
        int int;
        int i2;
        int i3;
        int i;
        i = 0;
        while (this.mNextRead < this.mEnd) {
            this.mParcel.setDataPosition(this.mNextRead);
            this.mFieldId = this.mParcel.readInt();
            this.mNextRead = mNextRead3 += int;
            i = 0;
        }
        if (this.mFieldId == fieldId) {
        } else {
            i3 = i;
        }
        return i3;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mParcel.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mParcel.readLong();
    }

    public <T extends Parcelable> T readParcelable() {
        return this.mParcel.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int fieldId) {
        closeField();
        this.mCurrentField = fieldId;
        this.mPositionLookup.put(fieldId, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(fieldId);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean val) {
        this.mParcel.writeInt(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle val) {
        this.mParcel.writeBundle(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] b) {
        Parcel mParcel;
        int length;
        if (b != null) {
            this.mParcel.writeInt(b.length);
            this.mParcel.writeByteArray(b);
        } else {
            this.mParcel.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] b, int offset, int len) {
        Parcel mParcel;
        int length;
        if (b != null) {
            this.mParcel.writeInt(b.length);
            this.mParcel.writeByteArray(b, offset, len);
        } else {
            this.mParcel.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(java.lang.CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double val) {
        this.mParcel.writeDouble(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float val) {
        this.mParcel.writeFloat(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int val) {
        this.mParcel.writeInt(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long val) {
        this.mParcel.writeLong(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable p) {
        this.mParcel.writeParcelable(p, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String val) {
        this.mParcel.writeString(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder val) {
        this.mParcel.writeStrongBinder(val);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface val) {
        this.mParcel.writeStrongInterface(val);
    }
}
