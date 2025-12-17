package androidx.versionedparcelable;

import _COROUTINE.ArtificialStackFrames;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
class VersionedParcelStream extends androidx.versionedparcelable.VersionedParcel {

    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16;
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private androidx.versionedparcelable.VersionedParcelStream.FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    private static class FieldBuffer {

        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;
        FieldBuffer(int fieldId, DataOutputStream target) {
            super();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.mOutput = byteArrayOutputStream;
            DataOutputStream dataOutputStream = new DataOutputStream(this.mOutput);
            this.mDataStream = dataOutputStream;
            this.mFieldId = fieldId;
            this.mTarget = target;
        }

        void flushField() throws IOException {
            int mTarget;
            int i;
            this.mDataStream.flush();
            int size = this.mOutput.size();
            mTarget = 65535;
            i = size >= mTarget ? mTarget : size;
            this.mTarget.writeInt(i2 |= i);
            if (size >= mTarget) {
                this.mTarget.writeInt(size);
            }
            this.mOutput.writeTo(this.mTarget);
        }
    }
    static {
        VersionedParcelStream.UTF_16 = Charset.forName("UTF-16");
    }

    public VersionedParcelStream(InputStream input, OutputStream output) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        super(input, output, arrayMap, arrayMap2, arrayMap3);
    }

    private VersionedParcelStream(InputStream input, OutputStream output, ArrayMap<String, Method> arrayMap3, ArrayMap<String, Method> arrayMap4, ArrayMap<String, Class> arrayMap5) {
        int dataOutputStream;
        DataInputStream dataInputStream;
        androidx.versionedparcelable.VersionedParcelStream.1 anon;
        super(arrayMap3, arrayMap4, arrayMap5);
        this.mCount = 0;
        int i2 = -1;
        this.mFieldId = i2;
        this.mFieldSize = i2;
        if (input != null) {
            anon = new VersionedParcelStream.1(this, input);
            dataInputStream = new DataInputStream(anon);
        } else {
            dataInputStream = dataOutputStream;
        }
        this.mMasterInput = dataInputStream;
        if (output != null) {
            dataOutputStream = new DataOutputStream(output);
        }
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = this.mMasterInput;
        this.mCurrentOutput = this.mMasterOutput;
    }

    private void readObject(int type, String key, Bundle b) {
        boolean booleanArray;
        switch (type) {
            case 0:
                b.putParcelable(key, 0);
                break;
            case 1:
                b.putBundle(key, readBundle());
                break;
            case 2:
                b.putBundle(key, readBundle());
                break;
            case 3:
                b.putString(key, readString());
                break;
            case 4:
                b.putStringArray(key, (String[])readArray(new String[0]));
                break;
            case 5:
                b.putBoolean(key, readBoolean());
                break;
            case 6:
                b.putBooleanArray(key, readBooleanArray());
                break;
            case 7:
                b.putDouble(key, readDouble());
                break;
            case 8:
                b.putDoubleArray(key, readDoubleArray());
                break;
            case 9:
                b.putInt(key, readInt());
                break;
            case 10:
                b.putIntArray(key, readIntArray());
                break;
            case 11:
                b.putLong(key, readLong());
                break;
            case 12:
                b.putLongArray(key, readLongArray());
                break;
            case 13:
                b.putFloat(key, readFloat());
                break;
            case 14:
                b.putFloatArray(key, readFloatArray());
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                RuntimeException runtimeException = new RuntimeException(stringBuilder.append("Unknown type ").append(type).toString());
                throw runtimeException;
        }
    }

    private void writeObject(Object o) {
        Object booleanValue;
        if (o == null) {
            writeInt(0);
        } else {
            if (o instanceof Bundle != null) {
                writeInt(1);
                writeBundle((Bundle)o);
            } else {
                if (o instanceof String != null) {
                    writeInt(3);
                    writeString((String)o);
                } else {
                    if (o instanceof String[]) {
                        writeInt(4);
                        writeArray((String[])(String[])o);
                    } else {
                        if (o instanceof Boolean) {
                            writeInt(5);
                            writeBoolean((Boolean)o.booleanValue());
                        } else {
                            if (o instanceof boolean[]) {
                                writeInt(6);
                                writeBooleanArray((boolean[])(boolean[])o);
                            } else {
                                if (o instanceof Double) {
                                    writeInt(7);
                                    writeDouble((Double)o.doubleValue());
                                } else {
                                    if (o instanceof double[]) {
                                        writeInt(8);
                                        writeDoubleArray((double[])(double[])o);
                                    } else {
                                        if (o instanceof Integer) {
                                            writeInt(9);
                                            writeInt((Integer)o.intValue());
                                        } else {
                                            if (o instanceof int[]) {
                                                writeInt(10);
                                                writeIntArray((int[])(int[])o);
                                            } else {
                                                if (o instanceof Long) {
                                                    writeInt(11);
                                                    writeLong((Long)o.longValue());
                                                } else {
                                                    if (o instanceof long[]) {
                                                        writeInt(12);
                                                        writeLongArray((long[])(long[])o);
                                                    } else {
                                                        if (o instanceof Float) {
                                                            writeInt(13);
                                                            writeFloat((Float)o.floatValue());
                                                        } else {
                                                            if (!o instanceof float[]) {
                                                            } else {
                                                                writeInt(14);
                                                                writeFloatArray((float[])(float[])o);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unsupported type ").append(o.getClass()).toString());
        throw illegalArgumentException;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int mFieldBuffer2;
        androidx.versionedparcelable.VersionedParcelStream.FieldBuffer mFieldBuffer;
        if (this.mFieldBuffer != null && mFieldBuffer3.mOutput.size() != 0) {
            if (mFieldBuffer3.mOutput.size() != 0) {
                this.mFieldBuffer.flushField();
            }
            this.mFieldBuffer = 0;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected androidx.versionedparcelable.VersionedParcel createSubParcel() {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
        return versionedParcelStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return 1;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int i;
        String string;
        int int;
        final int int2 = readInt();
        if (int2 < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        i = 0;
        while (i < int2) {
            readObject(readInt(), readString(), bundle);
            i++;
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        try {
            int int = this.mCurrentInput.readInt();
            if (int > 0) {
            }
            byte[] bArr = new byte[int];
            this.mCurrentInput.readFully(bArr);
            return bArr;
            return null;
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(len);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected java.lang.CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int fieldId) {
        int i2;
        Throwable int2;
        int mMasterInput;
        int i;
        int mFieldSize;
        int size;
        int int;
        i2 = 0;
        while (this.mFieldId == fieldId) {
            if (this.mCount < this.mFieldSize) {
            }
            this.mFieldSize = -1;
            int2 = this.mMasterInput.readInt();
            this.mCount = i2;
            int i5 = 65535;
            if (int2 & i5 == i5) {
            }
            this.mFieldId = i5 &= int;
            this.mFieldSize = size;
            i2 = 0;
            size = int;
            size = this.mCount;
            this.mMasterInput.skip((long)i6);
        }
        try {
            return 1;
            return i2;
            if (this.mCount < this.mFieldSize) {
            }
            size = this.mCount;
            this.mMasterInput.skip((long)i6);
            this.mFieldSize = -1;
            int2 = this.mMasterInput.readInt();
            this.mCount = i2;
            i5 = 65535;
            if (int2 & i5 == i5) {
            }
            size = int;
            this.mFieldId = i5 &= int;
            this.mFieldSize = size;
            return obj0;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    public <T extends Parcelable> T readParcelable() {
        return 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        try {
            int int = this.mCurrentInput.readInt();
            if (int > 0) {
            }
            byte[] bArr = new byte[int];
            this.mCurrentInput.readFully(bArr);
            String string = new String(bArr, VersionedParcelStream.UTF_16);
            return string;
            return null;
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(len);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int fieldId) {
        closeField();
        VersionedParcelStream.FieldBuffer fieldBuffer = new VersionedParcelStream.FieldBuffer(fieldId, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = mFieldBuffer.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean allowSerialization, boolean ignoreParcelables) {
        if (!allowSerialization) {
        } else {
            this.mIgnoreParcelables = ignoreParcelables;
        }
        RuntimeException runtimeException = new RuntimeException("Serialization of this object is not allowed");
        throw runtimeException;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean val) {
        try {
            this.mCurrentOutput.writeBoolean(val);
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle val) {
        Object mCurrentOutput;
        int iterator;
        int size;
        boolean next;
        Object obj;
        if (val != null) {
            mCurrentOutput = val.keySet();
            this.mCurrentOutput.writeInt(mCurrentOutput.size());
            iterator = mCurrentOutput.iterator();
            try {
                for (String size : iterator) {
                    writeString(size);
                    writeObject(val.get(size));
                }
                size = iterator.next();
                writeString((String)size);
                writeObject(val.get(size));
                this.mCurrentOutput.writeInt(-1);
                VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
                throw parcelException;
            }
        } else {
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] b) {
        DataOutputStream mCurrentOutput;
        int length;
        if (b != null) {
            this.mCurrentOutput.writeInt(b.length);
            this.mCurrentOutput.write(b);
        } else {
            try {
                this.mCurrentOutput.writeInt(-1);
                VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
                throw parcelException;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] b, int offset, int len) {
        DataOutputStream mCurrentOutput;
        int parcelException;
        if (b != null) {
            this.mCurrentOutput.writeInt(len);
            this.mCurrentOutput.write(b, offset, len);
        } else {
            try {
                this.mCurrentOutput.writeInt(-1);
                parcelException = new VersionedParcel.ParcelException(th);
                throw parcelException;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(java.lang.CharSequence charSequence) {
        if (!this.mIgnoreParcelables) {
        } else {
        }
        RuntimeException runtimeException = new RuntimeException("CharSequence cannot be written to an OutputStream");
        throw runtimeException;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double val) {
        try {
            this.mCurrentOutput.writeDouble(val);
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float val) {
        try {
            this.mCurrentOutput.writeFloat(val);
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int val) {
        try {
            this.mCurrentOutput.writeInt(val);
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long val) {
        try {
            this.mCurrentOutput.writeLong(val);
            VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
            throw parcelException;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable p) {
        if (!this.mIgnoreParcelables) {
        } else {
        }
        RuntimeException runtimeException = new RuntimeException("Parcelables cannot be written to an OutputStream");
        throw runtimeException;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String val) {
        byte[] mCurrentOutput;
        DataOutputStream mCurrentOutput2;
        int length;
        if (val != null) {
            mCurrentOutput = val.getBytes(VersionedParcelStream.UTF_16);
            this.mCurrentOutput.writeInt(mCurrentOutput.length);
            this.mCurrentOutput.write(mCurrentOutput);
        } else {
            try {
                this.mCurrentOutput.writeInt(-1);
                VersionedParcel.ParcelException parcelException = new VersionedParcel.ParcelException(th);
                throw parcelException;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder val) {
        if (!this.mIgnoreParcelables) {
        } else {
        }
        RuntimeException runtimeException = new RuntimeException("Binders cannot be written to an OutputStream");
        throw runtimeException;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface val) {
        if (!this.mIgnoreParcelables) {
        } else {
        }
        RuntimeException runtimeException = new RuntimeException("Binders cannot be written to an OutputStream");
        throw runtimeException;
    }
}
