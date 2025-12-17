package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public final class MetadataList extends androidx.emoji2.text.flatbuffer.Table {

    public static final class Vector extends androidx.emoji2.text.flatbuffer.BaseVector {
        @Override // androidx.emoji2.text.flatbuffer.BaseVector
        public androidx.emoji2.text.flatbuffer.MetadataList.Vector __assign(int _vector, int _element_size, ByteBuffer _bb) {
            __reset(_vector, _element_size, _bb);
            return this;
        }

        @Override // androidx.emoji2.text.flatbuffer.BaseVector
        public androidx.emoji2.text.flatbuffer.MetadataList get(int j) {
            MetadataList metadataList = new MetadataList();
            return get(metadataList, j);
        }

        @Override // androidx.emoji2.text.flatbuffer.BaseVector
        public androidx.emoji2.text.flatbuffer.MetadataList get(androidx.emoji2.text.flatbuffer.MetadataList obj, int j) {
            return obj.__assign(MetadataList.access$000(__element(j), this.bb), this.bb);
        }
    }
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    static int access$000(int x0, ByteBuffer x1) {
        return MetadataList.__indirect(x0, x1);
    }

    public static void addList(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int listOffset) {
        builder.addOffset(1, listOffset, 0);
    }

    public static void addSourceSha(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int sourceShaOffset) {
        builder.addOffset(2, sourceShaOffset, 0);
    }

    public static void addVersion(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int version) {
        final int i = 0;
        builder.addInt(i, version, i);
    }

    public static int createListVector(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int[] data) {
        int i;
        int length;
        int i2 = 4;
        builder.startVector(i2, data.length, i2);
        length2--;
        while (i >= 0) {
            builder.addOffset(data[i]);
            i--;
        }
        return builder.endVector();
    }

    public static int createMetadataList(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int version, int listOffset, int sourceShaOffset) {
        builder.startTable(3);
        MetadataList.addSourceSha(builder, sourceShaOffset);
        MetadataList.addList(builder, listOffset);
        MetadataList.addVersion(builder, version);
        return MetadataList.endMetadataList(builder);
    }

    public static int endMetadataList(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder) {
        return builder.endTable();
    }

    public static void finishMetadataListBuffer(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int offset) {
        builder.finish(offset);
    }

    public static void finishSizePrefixedMetadataListBuffer(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int offset) {
        builder.finishSizePrefixed(offset);
    }

    public static androidx.emoji2.text.flatbuffer.MetadataList getRootAsMetadataList(ByteBuffer _bb) {
        MetadataList metadataList = new MetadataList();
        return MetadataList.getRootAsMetadataList(_bb, metadataList);
    }

    public static androidx.emoji2.text.flatbuffer.MetadataList getRootAsMetadataList(ByteBuffer _bb, androidx.emoji2.text.flatbuffer.MetadataList obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return obj.__assign(int += position2, _bb);
    }

    public static void startListVector(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int numElems) {
        final int i = 4;
        builder.startVector(i, numElems, i);
    }

    public static void startMetadataList(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder) {
        builder.startTable(3);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.MetadataList __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.MetadataItem list(int j) {
        MetadataItem metadataItem = new MetadataItem();
        return list(metadataItem, j);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.MetadataItem list(androidx.emoji2.text.flatbuffer.MetadataItem obj, int j) {
        androidx.emoji2.text.flatbuffer.MetadataItem metadataItem;
        ByteBuffer byteBuffer;
        int i2 = __offset(6);
        if (i2 != 0) {
            metadataItem = obj.__assign(__indirect(i3 += i6), this.bb);
        } else {
            metadataItem = 0;
        }
        return metadataItem;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public int listLength() {
        int i;
        int i3 = __offset(6);
        if (i3 != 0) {
            i = __vector_len(i3);
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.MetadataItem.Vector listVector() {
        MetadataItem.Vector vector = new MetadataItem.Vector();
        return listVector(vector);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.MetadataItem.Vector listVector(androidx.emoji2.text.flatbuffer.MetadataItem.Vector obj) {
        androidx.emoji2.text.flatbuffer.MetadataItem.Vector vector;
        int i;
        ByteBuffer byteBuffer;
        int i3 = __offset(6);
        if (i3 != 0) {
            vector = obj.__assign(__vector(i3), 4, this.bb);
        } else {
            vector = 0;
        }
        return vector;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public String sourceSha() {
        String str;
        int i2 = __offset(8);
        if (i2 != 0) {
            str = __string(bb_pos += i2);
        } else {
            str = 0;
        }
        return str;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public ByteBuffer sourceShaInByteBuffer(ByteBuffer _bb) {
        return __vector_in_bytebuffer(_bb, 8, 1);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public int version() {
        int int;
        int i;
        int i3 = __offset(4);
        if (i3 != 0) {
            int = this.bb.getInt(bb_pos += i3);
        } else {
            int = 0;
        }
        return int;
    }
}
