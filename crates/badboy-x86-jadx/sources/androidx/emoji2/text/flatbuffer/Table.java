package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes5.dex */
public class Table {

    protected ByteBuffer bb;
    protected int bb_pos;
    androidx.emoji2.text.flatbuffer.Utf8 utf8;
    private int vtable_size;
    private int vtable_start;
    public Table() {
        super();
        this.utf8 = Utf8.getDefault();
    }

    protected static boolean __has_identifier(ByteBuffer bb, String ident) {
        int i;
        char charAt;
        char c;
        int i3 = 4;
        if (ident.length() != i3) {
        } else {
            i = 0;
            while (i < i3) {
                i++;
            }
            return 1;
        }
        AssertionError assertionError = new AssertionError("FlatBuffers: file identifier must be length 4");
        throw assertionError;
    }

    protected static int __indirect(int offset, ByteBuffer bb) {
        return int += offset;
    }

    protected static int __offset(int vtable_offset, int offset, ByteBuffer bb) {
        capacity -= offset;
        return short += i;
    }

    protected static String __string(int offset, ByteBuffer bb, androidx.emoji2.text.flatbuffer.Utf8 utf8) {
        offset += int;
        return utf8.decodeUtf8(bb, obj2 + 4, bb.getInt(obj2));
    }

    protected static androidx.emoji2.text.flatbuffer.Table __union(androidx.emoji2.text.flatbuffer.Table t, int offset, ByteBuffer bb) {
        t.__reset(Table.__indirect(offset, bb), bb);
        return t;
    }

    protected static int compareStrings(int offset_1, int offset_2, ByteBuffer bb) {
        int i;
        byte b2;
        byte b;
        offset_1 += int;
        offset_2 += int2;
        int int3 = bb.getInt(obj8);
        final int int4 = bb.getInt(obj9);
        final int i2 = obj8 + 4;
        final int i3 = obj9 + 4;
        i = 0;
        while (i < Math.min(int3, int4)) {
            i++;
        }
        return int3 - int4;
    }

    protected static int compareStrings(int offset_1, byte[] key, ByteBuffer bb) {
        int i;
        byte b;
        byte b2;
        offset_1 += int;
        int int2 = bb.getInt(obj7);
        final int length = key.length;
        final int i2 = obj7 + 4;
        i = 0;
        while (i < Math.min(int2, length)) {
            i++;
        }
        return int2 - length;
    }

    protected int __indirect(int offset) {
        return int += offset;
    }

    protected int __offset(int vtable_offset) {
        short short;
        int i;
        if (vtable_offset < this.vtable_size) {
            short = this.bb.getShort(vtable_start += vtable_offset);
        } else {
            short = 0;
        }
        return short;
    }

    public void __reset() {
        __reset(0, 0);
    }

    protected void __reset(int _i, ByteBuffer _bb) {
        short short;
        int vtable_start;
        int bb_pos;
        this.bb = _bb;
        if (this.bb != null) {
            this.bb_pos = _i;
            this.vtable_start = bb_pos2 -= int;
            this.vtable_size = this.bb.getShort(this.vtable_start);
        } else {
            short = 0;
            this.bb_pos = short;
            this.vtable_start = short;
            this.vtable_size = short;
        }
    }

    protected String __string(int offset) {
        return Table.__string(offset, this.bb, this.utf8);
    }

    protected androidx.emoji2.text.flatbuffer.Table __union(androidx.emoji2.text.flatbuffer.Table t, int offset) {
        return Table.__union(t, offset, this.bb);
    }

    protected int __vector(int offset) {
        offset += bb_pos;
        return i += 4;
    }

    protected ByteBuffer __vector_as_bytebuffer(int vector_offset, int elem_size) {
        final int i = __offset(vector_offset);
        if (i == 0) {
            return null;
        }
        ByteBuffer order = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int i3 = __vector(i);
        order.position(i3);
        order.limit(i5 += i3);
        return order;
    }

    protected ByteBuffer __vector_in_bytebuffer(ByteBuffer bb, int vector_offset, int elem_size) {
        final int i = __offset(vector_offset);
        if (i == 0) {
            return null;
        }
        int i3 = __vector(i);
        bb.rewind();
        bb.limit(i5 += i3);
        bb.position(i3);
        return bb;
    }

    protected int __vector_len(int offset) {
        offset += bb_pos;
        return this.bb.getInt(obj2 += int);
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    protected int keysCompare(Integer o1, Integer o2, ByteBuffer bb) {
        return 0;
    }

    protected void sortTables(int[] offsets, ByteBuffer bb) {
        int i;
        int i2;
        Integer valueOf;
        int intValue;
        Integer[] arr = new Integer[offsets.length];
        i = 0;
        for (int i4 : offsets) {
            arr[i] = Integer.valueOf(i4);
        }
        Table.1 i3 = new Table.1(this, bb);
        Arrays.sort(arr, i3);
        i2 = 0;
        while (i2 < offsets.length) {
            offsets[i2] = arr[i2].intValue();
            i2++;
        }
    }
}
