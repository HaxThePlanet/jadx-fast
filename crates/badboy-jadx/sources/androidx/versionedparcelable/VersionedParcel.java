package androidx.versionedparcelable;

import android.app.Notification.Action;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes5.dex */
public abstract class VersionedParcel {

    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable source) {
            super(source);
        }
    }
    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super();
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int code, String msg) {
        switch (code) {
            case -9:
                return (Exception)readParcelable();
            case -8:
                StringBuilder stringBuilder = new StringBuilder();
                RuntimeException runtimeException = new RuntimeException(stringBuilder.append("Unknown exception code: ").append(code).append(" msg ").append(msg).toString());
                return runtimeException;
            case -7:
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(msg);
                return unsupportedOperationException;
            case -6:
                NetworkOnMainThreadException networkOnMainThreadException = new NetworkOnMainThreadException();
                return networkOnMainThreadException;
            case -5:
                IllegalStateException illegalStateException = new IllegalStateException(msg);
                return illegalStateException;
            case -4:
                NullPointerException nullPointerException = new NullPointerException(msg);
                return nullPointerException;
            case -3:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(msg);
                return illegalArgumentException;
            case -2:
                BadParcelableException badParcelableException = new BadParcelableException(msg);
                return badParcelableException;
            default:
                SecurityException securityException = new SecurityException(msg);
                return securityException;
        }
    }

    private Class findParcelClass(Class<? extends androidx.versionedparcelable.VersionedParcelable> class) throws java.lang.ClassNotFoundException {
        Object ret;
        String name;
        String format;
        ArrayMap mParcelizerCache;
        String name2;
        if ((Class)this.mParcelizerCache.get(class.getName()) == null) {
            this.mParcelizerCache.put(class.getName(), Class.forName(String.format("%s.%sParcelizer", /* result */), false, class.getClassLoader()));
        }
        return ret;
    }

    private Method getReadMethod(String parcelCls) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        Object m;
        long currentTimeMillis;
        ArrayMap mReadCache;
        Class forName;
        Class[] arr;
        int i;
        if ((Method)this.mReadCache.get(parcelCls) == null) {
            currentTimeMillis = System.currentTimeMillis();
            Class<androidx.versionedparcelable.VersionedParcel> obj = VersionedParcel.class;
            int i2 = 1;
            arr = new Class[i2];
            arr[0] = obj;
            this.mReadCache.put(parcelCls, Class.forName(parcelCls, i2, obj.getClassLoader()).getDeclaredMethod("read", arr));
        }
        return m;
    }

    protected static Throwable getRootCause(Throwable t) {
        Throwable cause;
        Throwable obj1;
        while (obj1.getCause() != null) {
            obj1 = obj1.getCause();
        }
        return obj1;
    }

    private <T> int getType(T t) {
        if (t instanceof String != null) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof VersionedParcelable) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (!t instanceof Float) {
        } else {
            return 8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(t.getClass().getName()).append(" cannot be VersionedParcelled").toString());
        throw illegalArgumentException;
    }

    private Method getWriteMethod(Class baseCls) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        Object m;
        Object parcelClass;
        long currentTimeMillis;
        ArrayMap mWriteCache;
        String name;
        Class<androidx.versionedparcelable.VersionedParcel> obj;
        if ((Method)this.mWriteCache.get(baseCls.getName()) == null) {
            currentTimeMillis = System.currentTimeMillis();
            Class[] arr = new Class[2];
            this.mWriteCache.put(baseCls.getName(), findParcelClass(baseCls).getDeclaredMethod("write", baseCls, VersionedParcel.class));
        }
        return m;
    }

    private <T, S extends Collection<T>> S readCollection(S s) {
        int n;
        int versionedParcelable;
        int int;
        n = readInt();
        versionedParcelable = 0;
        if (n < 0) {
            return versionedParcelable;
        }
        if (n != 0 && n < 0) {
            if (n < 0) {
                return versionedParcelable;
            }
            switch (int) {
                case 1:
                    s.add(readVersionedParcelable());
                    n--;
                    break;
                case 2:
                    s.add(readParcelable());
                    n--;
                    break;
                case 3:
                    s.add(readSerializable());
                    n--;
                    break;
                case 4:
                    s.add(readString());
                    n--;
                    break;
                case 5:
                    s.add(readStrongBinder());
                    n--;
                    break;
                default:
            }
        }
        return s;
    }

    private Exception readException(int code, String msg) {
        return createException(code, msg);
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection) {
        int type;
        Iterator iterator;
        boolean next;
        Object floatValue;
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    iterator = collection.iterator();
                    writeVersionedParcelable((VersionedParcelable)iterator.next());
                    break;
                case 2:
                    iterator = collection.iterator();
                    writeParcelable((Parcelable)iterator.next());
                    break;
                case 3:
                    iterator = collection.iterator();
                    writeSerializable((Serializable)iterator.next());
                    break;
                case 4:
                    iterator = collection.iterator();
                    writeString((String)iterator.next());
                    break;
                case 5:
                    iterator = collection.iterator();
                    writeStrongBinder((IBinder)iterator.next());
                    break;
                case 6:
                    break;
                case 7:
                    iterator = collection.iterator();
                    writeInt((Integer)iterator.next().intValue());
                    break;
                default:
                    iterator = collection.iterator();
                    writeFloat((Float)iterator.next().floatValue());
            }
        }
    }

    private <T> void writeCollection(Collection<T> collection, int fieldId) {
        setOutputField(fieldId);
        writeCollection(collection);
    }

    private void writeSerializable(Serializable s) {
        if (s == null) {
            writeString(0);
        }
        writeString(s.getClass().getName());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
        writeByteArray(byteArrayOutputStream.toByteArray());
    }

    private void writeVersionedParcelableCreator(androidx.versionedparcelable.VersionedParcelable p) {
        int i = 0;
        writeString(findParcelClass(p.getClass()).getName());
    }

    protected abstract void closeField();

    protected abstract androidx.versionedparcelable.VersionedParcel createSubParcel();

    public boolean isStream() {
        return 0;
    }

    protected <T> T[] readArray(T[] tArr) {
        int n2;
        int versionedParcelable;
        int int;
        n2 = readInt();
        versionedParcelable = 0;
        if (n2 < 0) {
            return versionedParcelable;
        }
        ArrayList arrayList = new ArrayList(n2);
        if (n2 != 0 && n2 < 0) {
            if (n2 < 0) {
                return versionedParcelable;
            }
            switch (int) {
                case 1:
                    arrayList.add(readVersionedParcelable());
                    n2--;
                    break;
                case 2:
                    arrayList.add(readParcelable());
                    n2--;
                    break;
                case 3:
                    arrayList.add(readSerializable());
                    n2--;
                    break;
                case 4:
                    arrayList.add(readString());
                    n2--;
                    break;
                case 5:
                    arrayList.add(readStrongBinder());
                    n2--;
                    break;
                default:
            }
        }
        return arrayList.toArray(tArr);
    }

    public <T> T[] readArray(T[] tArr, int fieldId) {
        if (!readField(fieldId)) {
            return tArr;
        }
        return readArray(tArr);
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readBoolean();
    }

    protected boolean[] readBooleanArray() {
        int i;
        int i2;
        final int int = readInt();
        if (int < 0) {
            return null;
        }
        boolean[] zArr = new boolean[int];
        i = 0;
        while (i < int) {
            if (readInt() != 0) {
            } else {
            }
            i2 = 0;
            zArr[i] = i2;
            i++;
            i2 = 1;
        }
        return zArr;
    }

    public boolean[] readBooleanArray(boolean[] def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readBooleanArray();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readBundle();
    }

    public byte readByte(byte def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return (byte)i;
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readByteArray();
    }

    public char[] readCharArray(char[] def, int fieldId) {
        int i;
        char c;
        if (!readField(fieldId)) {
            return def;
        }
        int int = readInt();
        if (int < 0) {
            return null;
        }
        char[] cArr = new char[int];
        i = 0;
        while (i < int) {
            cArr[i] = (char)int2;
            i++;
        }
        return cArr;
    }

    protected abstract java.lang.CharSequence readCharSequence();

    public java.lang.CharSequence readCharSequence(java.lang.CharSequence def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readCharSequence();
    }

    protected abstract double readDouble();

    public double readDouble(double def, int fieldId) {
        if (!readField(obj5)) {
            return def;
        }
        return readDouble();
    }

    protected double[] readDoubleArray() {
        int i;
        double double;
        final int int = readInt();
        if (int < 0) {
            return null;
        }
        double[] dArr = new double[int];
        i = 0;
        while (i < int) {
            dArr[i] = readDouble();
            i++;
        }
        return dArr;
    }

    public double[] readDoubleArray(double[] def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readDoubleArray();
    }

    public Exception readException(Exception def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        int exceptionCode = readExceptionCode();
        if (exceptionCode != 0) {
            return readException(exceptionCode, readString());
        }
        return def;
    }

    protected abstract boolean readField(int i);

    protected abstract float readFloat();

    public float readFloat(float def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readFloat();
    }

    protected float[] readFloatArray() {
        int i;
        float float;
        final int int = readInt();
        if (int < 0) {
            return null;
        }
        float[] fArr = new float[int];
        i = 0;
        while (i < int) {
            fArr[i] = readFloat();
            i++;
        }
        return fArr;
    }

    public float[] readFloatArray(float[] def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readFloatArray();
    }

    protected <T extends androidx.versionedparcelable.VersionedParcelable> T readFromParcel(String parcelCls, androidx.versionedparcelable.VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable)getReadMethod(parcelCls).invoke(0, /* result */);
            String str = "VersionedParcel encountered ClassNotFoundException";
            RuntimeException runtimeException = new RuntimeException(str, e);
            throw runtimeException;
            str = "VersionedParcel encountered NoSuchMethodException";
            runtimeException = new RuntimeException(str, e);
            throw runtimeException;
            runtimeException = e.getCause();
            runtimeException = runtimeException instanceof RuntimeException;
            if (runtimeException != null) {
            }
            runtimeException = e.getCause();
            throw (RuntimeException)runtimeException;
            str = "VersionedParcel encountered InvocationTargetException";
            runtimeException = new RuntimeException(str, e);
            throw runtimeException;
            str = "VersionedParcel encountered IllegalAccessException";
            runtimeException = new RuntimeException(str, e);
            throw runtimeException;
        }
    }

    protected abstract int readInt();

    public int readInt(int def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readInt();
    }

    protected int[] readIntArray() {
        int i;
        int int;
        final int int2 = readInt();
        if (int2 < 0) {
            return null;
        }
        int[] iArr = new int[int2];
        i = 0;
        while (i < int2) {
            iArr[i] = readInt();
            i++;
        }
        return iArr;
    }

    public int[] readIntArray(int[] def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readIntArray();
    }

    public <T> List<T> readList(List<T> list, int fieldId) {
        if (!readField(fieldId)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        return (List)readCollection(arrayList);
    }

    protected abstract long readLong();

    public long readLong(long def, int fieldId) {
        if (!readField(obj5)) {
            return def;
        }
        return readLong();
    }

    protected long[] readLongArray() {
        int i;
        long long;
        final int int = readInt();
        if (int < 0) {
            return null;
        }
        long[] lArr = new long[int];
        i = 0;
        while (i < int) {
            lArr[i] = readLong();
            i++;
        }
        return lArr;
    }

    public long[] readLongArray(long[] def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readLongArray();
    }

    public <K, V> Map<K, V> readMap(Map<K, V> map, int fieldId) {
        int i;
        Object obj2;
        Object obj;
        if (!readField(fieldId)) {
            return map;
        }
        int int = readInt();
        if (int < 0) {
            return 0;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (int == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        i = 0;
        while (i < int) {
            arrayMap.put(arrayList.get(i), arrayList2.get(i));
            i++;
        }
        return arrayMap;
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t, int fieldId) {
        if (!readField(fieldId)) {
            return t;
        }
        return readParcelable();
    }

    protected Serializable readSerializable() {
        String str = ")";
        if (readString() == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readByteArray());
        VersionedParcel.1 anon = new VersionedParcel.1(this, byteArrayInputStream);
        return (Serializable)anon.readObject();
    }

    public <T> Set<T> readSet(Set<T> set, int fieldId) {
        if (!readField(fieldId)) {
            return set;
        }
        ArraySet arraySet = new ArraySet();
        return (Set)readCollection(arraySet);
    }

    public Size readSize(Size def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        if (readBoolean()) {
            Size size = new Size(readInt(), readInt());
            return size;
        }
        return null;
    }

    public SizeF readSizeF(SizeF def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        if (readBoolean()) {
            SizeF sizeF = new SizeF(readFloat(), readFloat());
            return sizeF;
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray def, int fieldId) {
        int i;
        int int;
        boolean boolean;
        if (!readField(fieldId)) {
            return def;
        }
        int int2 = readInt();
        if (int2 < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(int2);
        i = 0;
        while (i < int2) {
            sparseBooleanArray.put(readInt(), readBoolean());
            i++;
        }
        return sparseBooleanArray;
    }

    protected abstract String readString();

    public String readString(String def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readString();
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder def, int fieldId) {
        if (!readField(fieldId)) {
            return def;
        }
        return readStrongBinder();
    }

    protected <T extends androidx.versionedparcelable.VersionedParcelable> T readVersionedParcelable() {
        final String string = readString();
        if (string == null) {
            return 0;
        }
        return readFromParcel(string, createSubParcel());
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> T readVersionedParcelable(T t, int fieldId) {
        if (!readField(fieldId)) {
            return t;
        }
        return readVersionedParcelable();
    }

    protected abstract void setOutputField(int i);

    public void setSerializationFlags(boolean allowSerialization, boolean ignoreParcelables) {
    }

    protected <T> void writeArray(T[] tArr) {
        int i;
        int type;
        Object obj;
        if (tArr == null) {
            writeInt(-1);
        }
        int length = tArr.length;
        i = 0;
        writeInt(length);
        if (length > 0) {
            type = getType(tArr[0]);
            writeInt(type);
            switch (type) {
                case 1:
                    writeVersionedParcelable((VersionedParcelable)tArr[i]);
                    i++;
                    break;
                case 2:
                    writeParcelable((Parcelable)tArr[i]);
                    i++;
                    break;
                case 3:
                    writeSerializable((Serializable)tArr[i]);
                    i++;
                    break;
                case 4:
                    writeString((String)tArr[i]);
                    i++;
                    break;
                case 5:
                    writeStrongBinder((IBinder)tArr[i]);
                    i++;
                    break;
                default:
            }
        }
    }

    public <T> void writeArray(T[] tArr, int fieldId) {
        setOutputField(fieldId);
        writeArray(tArr);
    }

    protected abstract void writeBoolean(boolean z);

    public void writeBoolean(boolean val, int fieldId) {
        setOutputField(fieldId);
        writeBoolean(val);
    }

    protected void writeBooleanArray(boolean[] val) {
        int length;
        int i;
        boolean z;
        if (val != null) {
            length = val.length;
            writeInt(length);
            i = 0;
            while (i < length) {
                writeInt(val[i]);
                i++;
            }
        } else {
            writeInt(-1);
        }
    }

    public void writeBooleanArray(boolean[] val, int fieldId) {
        setOutputField(fieldId);
        writeBooleanArray(val);
    }

    protected abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle val, int fieldId) {
        setOutputField(fieldId);
        writeBundle(val);
    }

    public void writeByte(byte val, int fieldId) {
        setOutputField(fieldId);
        writeInt(val);
    }

    protected abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] b, int fieldId) {
        setOutputField(fieldId);
        writeByteArray(b);
    }

    protected abstract void writeByteArray(byte[] bArr, int i2, int i3);

    public void writeByteArray(byte[] b, int offset, int len, int fieldId) {
        setOutputField(fieldId);
        writeByteArray(b, offset, len);
    }

    public void writeCharArray(char[] val, int fieldId) {
        int length;
        int i;
        char c;
        setOutputField(fieldId);
        if (val != null) {
            length = val.length;
            writeInt(length);
            i = 0;
            while (i < length) {
                writeInt(val[i]);
                i++;
            }
        } else {
            writeInt(-1);
        }
    }

    protected abstract void writeCharSequence(java.lang.CharSequence charSequence);

    public void writeCharSequence(java.lang.CharSequence val, int fieldId) {
        setOutputField(fieldId);
        writeCharSequence(val);
    }

    protected abstract void writeDouble(double d);

    public void writeDouble(double val, int fieldId) {
        setOutputField(obj3);
        writeDouble(val);
    }

    protected void writeDoubleArray(double[] val) {
        int length;
        int i;
        long l;
        if (val != null) {
            length = val.length;
            writeInt(length);
            i = 0;
            while (i < length) {
                writeDouble(val[i]);
                i++;
            }
        } else {
            writeInt(-1);
        }
    }

    public void writeDoubleArray(double[] val, int fieldId) {
        setOutputField(fieldId);
        writeDoubleArray(val);
    }

    public void writeException(Exception e, int fieldId) {
        int code;
        boolean classLoader;
        Object message;
        java.lang.ClassLoader classLoader2;
        setOutputField(fieldId);
        if (e == null) {
            writeNoException();
        }
        code = 0;
        if (e instanceof Parcelable && e.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            if (e.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
                code = -9;
            } else {
                if (e instanceof SecurityException != null) {
                    code = -1;
                } else {
                    if (e instanceof BadParcelableException != null) {
                        code = -2;
                    } else {
                        if (e instanceof IllegalArgumentException != null) {
                            code = -3;
                        } else {
                            if (e instanceof NullPointerException != null) {
                                code = -4;
                            } else {
                                if (e instanceof IllegalStateException != null) {
                                    code = -5;
                                } else {
                                    if (e instanceof NetworkOnMainThreadException != null) {
                                        code = -6;
                                    } else {
                                        if (e instanceof UnsupportedOperationException != null) {
                                            code = -7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
        }
        writeInt(code);
        if (code == 0 && e instanceof RuntimeException != null) {
            if (e instanceof RuntimeException != null) {
                throw (RuntimeException)e;
            }
            RuntimeException runtimeException = new RuntimeException(e);
            throw runtimeException;
        }
        if (/* condition */) {
            writeParcelable((Parcelable)e);
        } else {
        }
    }

    protected abstract void writeFloat(float f);

    public void writeFloat(float val, int fieldId) {
        setOutputField(fieldId);
        writeFloat(val);
    }

    protected void writeFloatArray(float[] val) {
        int length;
        int i;
        int i2;
        if (val != null) {
            length = val.length;
            writeInt(length);
            i = 0;
            while (i < length) {
                writeFloat(val[i]);
                i++;
            }
        } else {
            writeInt(-1);
        }
    }

    public void writeFloatArray(float[] val, int fieldId) {
        setOutputField(fieldId);
        writeFloatArray(val);
    }

    protected abstract void writeInt(int i);

    public void writeInt(int val, int fieldId) {
        setOutputField(fieldId);
        writeInt(val);
    }

    protected void writeIntArray(int[] val) {
        int length;
        int i;
        int i2;
        if (val != null) {
            length = val.length;
            writeInt(length);
            i = 0;
            while (i < length) {
                writeInt(val[i]);
                i++;
            }
        } else {
            writeInt(-1);
        }
    }

    public void writeIntArray(int[] val, int fieldId) {
        setOutputField(fieldId);
        writeIntArray(val);
    }

    public <T> void writeList(List<T> list, int fieldId) {
        writeCollection(list, fieldId);
    }

    protected abstract void writeLong(long l);

    public void writeLong(long val, int fieldId) {
        setOutputField(obj3);
        writeLong(val);
    }

    protected void writeLongArray(long[] val) {
        int length;
        int i;
        long l;
        if (val != null) {
            length = val.length;
            writeInt(length);
            i = 0;
            while (i < length) {
                writeLong(val[i]);
                i++;
            }
        } else {
            writeInt(-1);
        }
    }

    public void writeLongArray(long[] val, int fieldId) {
        setOutputField(fieldId);
        writeLongArray(val);
    }

    public <K, V> void writeMap(Map<K, V> map, int fieldId) {
        Object next;
        Object value;
        setOutputField(fieldId);
        if (map == null) {
            writeInt(-1);
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = map.entrySet().iterator();
        for (Map.Entry next : iterator) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    protected void writeNoException() {
        writeInt(0);
    }

    protected abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable p, int fieldId) {
        setOutputField(fieldId);
        writeParcelable(p);
    }

    public void writeSerializable(Serializable s, int fieldId) {
        setOutputField(fieldId);
        writeSerializable(s);
    }

    public <T> void writeSet(Set<T> set, int fieldId) {
        writeCollection(set, fieldId);
    }

    public void writeSize(Size val, int fieldId) {
        int height;
        setOutputField(fieldId);
        height = val != null ? 1 : 0;
        writeBoolean(height);
        if (val != null) {
            writeInt(val.getWidth());
            writeInt(val.getHeight());
        }
    }

    public void writeSizeF(SizeF val, int fieldId) {
        int height;
        setOutputField(fieldId);
        height = val != null ? 1 : 0;
        writeBoolean(height);
        if (val != null) {
            writeFloat(val.getWidth());
            writeFloat(val.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray val, int fieldId) {
        int i;
        boolean valueAt;
        setOutputField(fieldId);
        if (val == null) {
            writeInt(-1);
        }
        int size = val.size();
        writeInt(size);
        i = 0;
        while (i < size) {
            writeInt(val.keyAt(i));
            writeBoolean(val.valueAt(i));
            i++;
        }
    }

    protected abstract void writeString(String string);

    public void writeString(String val, int fieldId) {
        setOutputField(fieldId);
        writeString(val);
    }

    protected abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder val, int fieldId) {
        setOutputField(fieldId);
        writeStrongBinder(val);
    }

    protected abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface val, int fieldId) {
        setOutputField(fieldId);
        writeStrongInterface(val);
    }

    protected <T extends androidx.versionedparcelable.VersionedParcelable> void writeToParcel(T t, androidx.versionedparcelable.VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t.getClass()).invoke(0, /* result */);
            String str = "VersionedParcel encountered ClassNotFoundException";
            RuntimeException runtimeException = new RuntimeException(str, e);
            throw runtimeException;
            str = "VersionedParcel encountered NoSuchMethodException";
            runtimeException = new RuntimeException(str, e);
            throw runtimeException;
            runtimeException = e.getCause();
            runtimeException = runtimeException instanceof RuntimeException;
            if (runtimeException != null) {
            }
            runtimeException = e.getCause();
            throw (RuntimeException)runtimeException;
            str = "VersionedParcel encountered InvocationTargetException";
            runtimeException = new RuntimeException(str, e);
            throw runtimeException;
            str = "VersionedParcel encountered IllegalAccessException";
            runtimeException = new RuntimeException(str, e);
            throw runtimeException;
        }
    }

    protected void writeVersionedParcelable(androidx.versionedparcelable.VersionedParcelable p) {
        if (p == null) {
            writeString(0);
        }
        writeVersionedParcelableCreator(p);
        androidx.versionedparcelable.VersionedParcel subParcel = createSubParcel();
        writeToParcel(p, subParcel);
        subParcel.closeField();
    }

    public void writeVersionedParcelable(androidx.versionedparcelable.VersionedParcelable p, int fieldId) {
        setOutputField(fieldId);
        writeVersionedParcelable(p);
    }
}
