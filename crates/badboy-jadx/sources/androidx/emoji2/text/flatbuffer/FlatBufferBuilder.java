package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class FlatBufferBuilder {

    static final boolean $assertionsDisabled;
    ByteBuffer bb;
    androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final androidx.emoji2.text.flatbuffer.Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    static class ByteBufferBackedInputStream extends InputStream {

        ByteBuffer buf;
        public ByteBufferBackedInputStream(ByteBuffer buf) {
            super();
            this.buf = buf;
        }

        public int read() throws IOException {
            try {
                return b &= 255;
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i);

        public void releaseByteBuffer(ByteBuffer bb) {
        }
    }

    public static final class HeapByteBufferFactory extends androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory {

        public static final androidx.emoji2.text.flatbuffer.FlatBufferBuilder.HeapByteBufferFactory INSTANCE;
        static {
            FlatBufferBuilder.HeapByteBufferFactory heapByteBufferFactory = new FlatBufferBuilder.HeapByteBufferFactory();
            FlatBufferBuilder.HeapByteBufferFactory.INSTANCE = heapByteBufferFactory;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder$ByteBufferFactory
        public ByteBuffer newByteBuffer(int capacity) {
            return ByteBuffer.allocate(capacity).order(ByteOrder.LITTLE_ENDIAN);
        }
    }
    static {
    }

    public FlatBufferBuilder() {
        super(1024);
    }

    public FlatBufferBuilder(int initial_size) {
        super(initial_size, FlatBufferBuilder.HeapByteBufferFactory.INSTANCE, 0, Utf8.getDefault());
    }

    public FlatBufferBuilder(int initial_size, androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory bb_factory) {
        super(initial_size, bb_factory, 0, Utf8.getDefault());
    }

    public FlatBufferBuilder(int initial_size, androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory bb_factory, ByteBuffer existing_bb, androidx.emoji2.text.flatbuffer.Utf8 utf8) {
        ByteBuffer byteBuffer;
        ByteOrder lITTLE_ENDIAN;
        int obj3;
        super();
        this.minalign = 1;
        this.vtable = 0;
        int i3 = 0;
        this.vtable_in_use = i3;
        this.nested = i3;
        this.finished = i3;
        this.vtables = new int[16];
        this.num_vtables = i3;
        this.vector_num_elems = i3;
        this.force_defaults = i3;
        obj3 = initial_size <= 0 ? 1 : obj3;
        this.bb_factory = bb_factory;
        if (existing_bb != null) {
            this.bb = existing_bb;
            this.bb.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = bb_factory.newByteBuffer(obj3);
        }
        this.utf8 = utf8;
        this.space = this.bb.capacity();
    }

    public FlatBufferBuilder(ByteBuffer existing_bb) {
        FlatBufferBuilder.HeapByteBufferFactory heapByteBufferFactory = new FlatBufferBuilder.HeapByteBufferFactory();
        super(existing_bb, heapByteBufferFactory);
    }

    public FlatBufferBuilder(ByteBuffer existing_bb, androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory bb_factory) {
        super(existing_bb.capacity(), bb_factory, existing_bb, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    static ByteBuffer growByteBuffer(ByteBuffer bb, androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory bb_factory) {
        int i;
        final int capacity = bb.capacity();
        if (i2 &= capacity != 0) {
        } else {
            i = capacity == 0 ? 1 : capacity << 1;
            bb.position(0);
            ByteBuffer byteBuffer = bb_factory.newByteBuffer(i);
            byteBuffer.position(new_buf_size2 - capacity);
            byteBuffer.put(bb);
            return byteBuffer;
        }
        AssertionError new_buf_size = new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        throw new_buf_size;
    }

    public static boolean isFieldPresent(androidx.emoji2.text.flatbuffer.Table table, int offset) {
        int i;
        i = table.__offset(offset) != 0 ? 1 : 0;
        return i;
    }

    public void Nested(int obj) {
        if (obj != offset()) {
        } else {
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: struct must be serialized inline.");
        throw assertionError;
    }

    public void addBoolean(int o, boolean x, boolean d) {
        if (!this.force_defaults) {
            if (x != d) {
                addBoolean(x);
                slot(o);
            }
        } else {
        }
    }

    public void addBoolean(boolean x) {
        prep(1, 0);
        putBoolean(x);
    }

    public void addByte(byte x) {
        prep(1, 0);
        putByte(x);
    }

    public void addByte(int o, byte x, int d) {
        if (!this.force_defaults) {
            if (x != d) {
                addByte(x);
                slot(o);
            }
        } else {
        }
    }

    public void addDouble(double x) {
        prep(8, 0);
        putDouble(x);
    }

    public void addDouble(int o, double x, double d) {
        int force_defaults;
        if (!this.force_defaults) {
            if (Double.compare(x, obj5) != 0) {
                addDouble(x);
                slot(o);
            }
        } else {
        }
    }

    public void addFloat(float x) {
        prep(4, 0);
        putFloat(x);
    }

    public void addFloat(int o, float x, double d) {
        int force_defaults;
        if (!this.force_defaults) {
            if (Double.compare(d2, d) != 0) {
                addFloat(x);
                slot(o);
            }
        } else {
        }
    }

    public void addInt(int x) {
        prep(4, 0);
        putInt(x);
    }

    public void addInt(int o, int x, int d) {
        if (!this.force_defaults) {
            if (x != d) {
                addInt(x);
                slot(o);
            }
        } else {
        }
    }

    public void addLong(int o, long x, long d) {
        int force_defaults;
        if (!this.force_defaults) {
            if (Long.compare(x, obj5) != 0) {
                addLong(x);
                slot(o);
            }
        } else {
        }
    }

    public void addLong(long x) {
        prep(8, 0);
        putLong(x);
    }

    public void addOffset(int off) {
        final int i4 = 4;
        prep(i4, 0);
        if (off > offset()) {
        } else {
            putInt(i2 += i4);
        }
        AssertionError off2 = new AssertionError();
        throw off2;
    }

    public void addOffset(int o, int x, int d) {
        if (!this.force_defaults) {
            if (x != d) {
                addOffset(x);
                slot(o);
            }
        } else {
        }
    }

    public void addShort(int o, short x, int d) {
        if (!this.force_defaults) {
            if (x != d) {
                addShort(x);
                slot(o);
            }
        } else {
        }
    }

    public void addShort(short x) {
        prep(2, 0);
        putShort(x);
    }

    public void addStruct(int voffset, int x, int d) {
        if (x != d) {
            Nested(x);
            slot(voffset);
        }
    }

    public void clear() {
        int[] vtable;
        int i;
        int i2;
        this.space = this.bb.capacity();
        this.bb.clear();
        int i3 = 1;
        this.minalign = i3;
        i = 0;
        while (this.vtable_in_use > 0) {
            vtable_in_use2 -= i3;
            this.vtable_in_use = i2;
            this.vtable[i2] = i;
            i = 0;
        }
        this.vtable_in_use = i;
        this.nested = i;
        this.finished = i;
        this.object_start = i;
        this.num_vtables = i;
        this.vector_num_elems = i;
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        final int remaining = byteBuffer.remaining();
        int i = 1;
        startVector(i, remaining, i);
        space -= remaining;
        this.space = i2;
        this.bb.position(i2);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public int createByteVector(byte[] arr) {
        final int length = arr.length;
        int i = 1;
        startVector(i, length, i);
        space -= length;
        this.space = i2;
        this.bb.position(i2);
        this.bb.put(arr);
        return endVector();
    }

    public int createByteVector(byte[] arr, int offset, int length) {
        int i = 1;
        startVector(i, length, i);
        space -= length;
        this.space = i2;
        this.bb.position(i2);
        this.bb.put(arr, offset, length);
        return endVector();
    }

    public <T extends androidx.emoji2.text.flatbuffer.Table> int createSortedVectorOfTables(T t, int[] offsets) {
        t.sortTables(offsets, this.bb);
        return createVectorOfTables(offsets);
    }

    public int createString(java.lang.CharSequence s) {
        int encodedLength = this.utf8.encodedLength(s);
        addByte(0);
        int i2 = 1;
        startVector(i2, encodedLength, i2);
        space -= encodedLength;
        this.space = i3;
        this.bb.position(i3);
        this.utf8.encodeUtf8(s, this.bb);
        return endVector();
    }

    public int createString(ByteBuffer s) {
        final int remaining = s.remaining();
        addByte(0);
        int i2 = 1;
        startVector(i2, remaining, i2);
        space -= remaining;
        this.space = i3;
        this.bb.position(i3);
        this.bb.put(s);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int elem_size, int num_elems, int alignment) {
        final int i = elem_size * num_elems;
        startVector(elem_size, num_elems, alignment);
        space -= i;
        this.space = i2;
        this.bb.position(i2);
        ByteBuffer order = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i);
        return order;
    }

    public int createVectorOfTables(int[] offsets) {
        int i;
        int length;
        notNested();
        int i2 = 4;
        startVector(i2, offsets.length, i2);
        length2--;
        while (i >= 0) {
            addOffset(offsets[i]);
            i--;
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public int endTable() {
        int[] vtable;
        int i6;
        int i5;
        int i;
        short s;
        int i2;
        int existing_vtable;
        int num_vtables;
        int num_vtables2;
        ByteBuffer byteBuffer;
        int space;
        int length;
        int space2;
        short short;
        int i3;
        short j;
        short short2;
        short short3;
        int i4;
        if (this.vtable == null) {
        } else {
            if (!this.nested) {
            } else {
                int i7 = 0;
                addInt(i7);
                int offset = offset();
                vtable_in_use--;
                while (i6 >= 0) {
                    if (this.vtable[i6] == 0) {
                    }
                    i6--;
                }
                while (i6 >= 0) {
                    if (this.vtable[i6] != 0) {
                    } else {
                    }
                    i2 = i7;
                    addShort((short)i2);
                    i6--;
                    i2 = offset - i11;
                }
                int i9 = 2;
                addShort((short)i12);
                addShort((short)i14);
                existing_vtable = 0;
                i5 = 0;
                while (i5 < this.num_vtables) {
                    capacity2 -= i16;
                    space = this.space;
                    short = this.bb.getShort(num_vtables);
                    if (short == this.bb.getShort(space)) {
                    } else {
                    }
                    i5++;
                    j = 2;
                    while (j < short) {
                        j += 2;
                    }
                    j += 2;
                }
                if (existing_vtable != 0) {
                    this.space = capacity -= offset;
                    this.bb.putInt(this.space, existing_vtable - offset);
                } else {
                    if (this.num_vtables == vtables3.length) {
                        this.vtables = Arrays.copyOf(this.vtables, num_vtables3 *= 2);
                    }
                    int num_vtables4 = this.num_vtables;
                    this.num_vtables = num_vtables4 + 1;
                    this.vtables[num_vtables4] = offset();
                    this.bb.putInt(capacity3 -= offset, offset3 -= offset);
                }
                this.nested = i7;
                return offset;
            }
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: endTable called without startTable");
        throw assertionError;
    }

    public int endVector() {
        if (!this.nested) {
        } else {
            this.nested = false;
            putInt(this.vector_num_elems);
            return offset();
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: endVector called without startVector");
        throw assertionError;
    }

    public void finish(int root_table) {
        finish(root_table, false);
    }

    public void finish(int root_table, String file_identifier) {
        finish(root_table, file_identifier, false);
    }

    protected void finish(int root_table, String file_identifier, boolean size_prefix) {
        int i2;
        int i;
        int i3;
        i = 4;
        i3 = size_prefix ? i : 0;
        prep(this.minalign, i3 += 8);
        if (file_identifier.length() != i) {
        } else {
            i2 = 3;
            while (i2 >= 0) {
                addByte((byte)charAt);
                i2--;
            }
            finish(root_table, size_prefix);
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: file identifier must be length 4");
        throw assertionError;
    }

    protected void finish(int root_table, boolean size_prefix) {
        int minalign;
        int space;
        int i;
        space = 4;
        i = size_prefix ? space : 0;
        prep(this.minalign, i += space);
        addOffset(root_table);
        if (size_prefix) {
            addInt(capacity -= space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int root_table) {
        finish(root_table, true);
    }

    public void finishSizePrefixed(int root_table, String file_identifier) {
        finish(root_table, file_identifier, true);
    }

    public void finished() {
        if (!this.finished) {
        } else {
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        throw assertionError;
    }

    public androidx.emoji2.text.flatbuffer.FlatBufferBuilder forceDefaults(boolean forceDefaults) {
        this.force_defaults = forceDefaults;
        return this;
    }

    public androidx.emoji2.text.flatbuffer.FlatBufferBuilder init(ByteBuffer existing_bb, androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory bb_factory) {
        this.bb_factory = bb_factory;
        this.bb = existing_bb;
        this.bb.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        int i2 = 0;
        this.vtable_in_use = i2;
        this.nested = i2;
        this.finished = i2;
        this.object_start = i2;
        this.num_vtables = i2;
        this.vector_num_elems = i2;
        return this;
    }

    public void notNested() {
        if (this.nested) {
        } else {
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: object serialization must not be nested.");
        throw assertionError;
    }

    public int offset() {
        return capacity -= space;
    }

    public void pad(int byte_size) {
        int i3;
        ByteBuffer byteBuffer;
        int i;
        int i2;
        i3 = 0;
        while (i3 < byte_size) {
            space--;
            this.space = i;
            this.bb.put(i, 0);
            i3++;
        }
    }

    public void prep(int size, int additional_bytes) {
        int capacity;
        ByteBuffer byteBuffer;
        int i2;
        Object bb_factory;
        int i;
        if (size > this.minalign) {
            this.minalign = size;
        }
        i6 &= capacity;
        while (this.space < i8 += additional_bytes) {
            byteBuffer = this.bb;
            this.bb = FlatBufferBuilder.growByteBuffer(byteBuffer, this.bb_factory);
            if (byteBuffer != this.bb) {
            }
            this.space = space3 += i;
            this.bb_factory.releaseByteBuffer(byteBuffer);
        }
        pad(i7);
    }

    public void putBoolean(boolean x) {
        space--;
        this.space = i;
        this.bb.put(i, (byte)x);
    }

    public void putByte(byte x) {
        space--;
        this.space = i;
        this.bb.put(i, x);
    }

    public void putDouble(double x) {
        space += -8;
        this.space = i;
        this.bb.putDouble(i, x);
    }

    public void putFloat(float x) {
        space += -4;
        this.space = i;
        this.bb.putFloat(i, x);
    }

    public void putInt(int x) {
        space += -4;
        this.space = i;
        this.bb.putInt(i, x);
    }

    public void putLong(long x) {
        space += -8;
        this.space = i;
        this.bb.putLong(i, x);
    }

    public void putShort(short x) {
        space += -2;
        this.space = i;
        this.bb.putShort(i, x);
    }

    public void required(int table, int field) {
        int i;
        capacity -= table;
        i = this.bb.getShort(i3 + field) != 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        AssertionError assertionError = new AssertionError(stringBuilder.append("FlatBuffers: field ").append(field).append(" must be set").toString());
        throw assertionError;
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, capacity -= space2);
    }

    public byte[] sizedByteArray(int start, int length) {
        finished();
        final byte[] bArr = new byte[length];
        this.bb.position(start);
        this.bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.bb.duplicate();
        duplicate.position(this.space);
        duplicate.limit(this.bb.capacity());
        FlatBufferBuilder.ByteBufferBackedInputStream byteBufferBackedInputStream = new FlatBufferBuilder.ByteBufferBackedInputStream(duplicate);
        return byteBufferBackedInputStream;
    }

    public void slot(int voffset) {
        this.vtable[voffset] = offset();
    }

    public void startTable(int numfields) {
        int iArr;
        notNested();
        if (this.vtable != null) {
            if (vtable2.length < numfields) {
                this.vtable = new int[numfields];
            }
        } else {
        }
        this.vtable_in_use = numfields;
        final int i2 = 0;
        Arrays.fill(this.vtable, i2, this.vtable_in_use, i2);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int elem_size, int num_elems, int alignment) {
        notNested();
        this.vector_num_elems = num_elems;
        prep(4, elem_size * num_elems);
        prep(alignment, elem_size * num_elems);
        this.nested = true;
    }
}
