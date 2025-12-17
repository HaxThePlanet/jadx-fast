package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public final class MetadataItem extends androidx.emoji2.text.flatbuffer.Table {

    public static final class Vector extends androidx.emoji2.text.flatbuffer.BaseVector {
        @Override // androidx.emoji2.text.flatbuffer.BaseVector
        public androidx.emoji2.text.flatbuffer.MetadataItem.Vector __assign(int _vector, int _element_size, ByteBuffer _bb) {
            __reset(_vector, _element_size, _bb);
            return this;
        }

        @Override // androidx.emoji2.text.flatbuffer.BaseVector
        public androidx.emoji2.text.flatbuffer.MetadataItem get(int j) {
            MetadataItem metadataItem = new MetadataItem();
            return get(metadataItem, j);
        }

        @Override // androidx.emoji2.text.flatbuffer.BaseVector
        public androidx.emoji2.text.flatbuffer.MetadataItem get(androidx.emoji2.text.flatbuffer.MetadataItem obj, int j) {
            return obj.__assign(MetadataItem.access$000(__element(j), this.bb), this.bb);
        }
    }
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    static int access$000(int x0, ByteBuffer x1) {
        return MetadataItem.__indirect(x0, x1);
    }

    public static void addCodepoints(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int codepointsOffset) {
        builder.addOffset(6, codepointsOffset, 0);
    }

    public static void addCompatAdded(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, short compatAdded) {
        builder.addShort(3, compatAdded, 0);
    }

    public static void addEmojiStyle(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, boolean emojiStyle) {
        builder.addBoolean(1, emojiStyle, false);
    }

    public static void addHeight(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, short height) {
        builder.addShort(5, height, 0);
    }

    public static void addId(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int id) {
        final int i = 0;
        builder.addInt(i, id, i);
    }

    public static void addSdkAdded(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, short sdkAdded) {
        builder.addShort(2, sdkAdded, 0);
    }

    public static void addWidth(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, short width) {
        builder.addShort(4, width, 0);
    }

    public static int createCodepointsVector(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int[] data) {
        int i;
        int length;
        int i2 = 4;
        builder.startVector(i2, data.length, i2);
        length2--;
        while (i >= 0) {
            builder.addInt(data[i]);
            i--;
        }
        return builder.endVector();
    }

    public static int createMetadataItem(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int id, boolean emojiStyle, short sdkAdded, short compatAdded, short width, short height, int codepointsOffset) {
        builder.startTable(7);
        MetadataItem.addCodepoints(builder, codepointsOffset);
        MetadataItem.addId(builder, id);
        MetadataItem.addHeight(builder, height);
        MetadataItem.addWidth(builder, width);
        MetadataItem.addCompatAdded(builder, compatAdded);
        MetadataItem.addSdkAdded(builder, sdkAdded);
        MetadataItem.addEmojiStyle(builder, emojiStyle);
        return MetadataItem.endMetadataItem(builder);
    }

    public static int endMetadataItem(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder) {
        return builder.endTable();
    }

    public static androidx.emoji2.text.flatbuffer.MetadataItem getRootAsMetadataItem(ByteBuffer _bb) {
        MetadataItem metadataItem = new MetadataItem();
        return MetadataItem.getRootAsMetadataItem(_bb, metadataItem);
    }

    public static androidx.emoji2.text.flatbuffer.MetadataItem getRootAsMetadataItem(ByteBuffer _bb, androidx.emoji2.text.flatbuffer.MetadataItem obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return obj.__assign(int += position2, _bb);
    }

    public static void startCodepointsVector(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder, int numElems) {
        final int i = 4;
        builder.startVector(i, numElems, i);
    }

    public static void startMetadataItem(androidx.emoji2.text.flatbuffer.FlatBufferBuilder builder) {
        builder.startTable(7);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.MetadataItem __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public int codepoints(int j) {
        int int;
        int i;
        int i2;
        int i4 = __offset(16);
        if (i4 != 0) {
            int = this.bb.getInt(i5 += i2);
        } else {
            int = 0;
        }
        return int;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public ByteBuffer codepointsInByteBuffer(ByteBuffer _bb) {
        return __vector_in_bytebuffer(_bb, 16, 4);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public int codepointsLength() {
        int i;
        int i3 = __offset(16);
        if (i3 != 0) {
            i = __vector_len(i3);
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.IntVector codepointsVector() {
        IntVector intVector = new IntVector();
        return codepointsVector(intVector);
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public androidx.emoji2.text.flatbuffer.IntVector codepointsVector(androidx.emoji2.text.flatbuffer.IntVector obj) {
        androidx.emoji2.text.flatbuffer.IntVector intVector;
        ByteBuffer byteBuffer;
        int i2 = __offset(16);
        if (i2 != 0) {
            intVector = obj.__assign(__vector(i2), this.bb);
        } else {
            intVector = 0;
        }
        return intVector;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public short compatAdded() {
        short short;
        int i;
        int i3 = __offset(10);
        if (i3 != 0) {
            short = this.bb.getShort(bb_pos += i3);
        } else {
            short = 0;
        }
        return short;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public boolean emojiStyle() {
        int i2;
        byte b;
        int i;
        int i4 = __offset(6);
        i2 = 0;
        if (i4 != 0 && this.bb.get(bb_pos += i4) != 0) {
            if (this.bb.get(bb_pos += i4) != 0) {
                i2 = 1;
            }
        }
        return i2;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public short height() {
        short short;
        int i;
        int i3 = __offset(14);
        if (i3 != 0) {
            short = this.bb.getShort(bb_pos += i3);
        } else {
            short = 0;
        }
        return short;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public int id() {
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

    @Override // androidx.emoji2.text.flatbuffer.Table
    public short sdkAdded() {
        short short;
        int i;
        int i3 = __offset(8);
        if (i3 != 0) {
            short = this.bb.getShort(bb_pos += i3);
        } else {
            short = 0;
        }
        return short;
    }

    @Override // androidx.emoji2.text.flatbuffer.Table
    public short width() {
        short short;
        int i;
        int i3 = __offset(12);
        if (i3 != 0) {
            short = this.bb.getShort(bb_pos += i3);
        } else {
            short = 0;
        }
        return short;
    }
}
