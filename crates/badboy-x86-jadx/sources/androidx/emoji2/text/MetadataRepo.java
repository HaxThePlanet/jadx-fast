package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MetadataRepo {

    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final androidx.emoji2.text.MetadataRepo.Node mRootNode;
    private final Typeface mTypeface;

    static class Node {

        private final SparseArray<androidx.emoji2.text.MetadataRepo.Node> mChildren;
        private androidx.emoji2.text.TypefaceEmojiRasterizer mData;
        private Node() {
            super(1);
        }

        Node(int defaultChildrenSize) {
            super();
            SparseArray sparseArray = new SparseArray(defaultChildrenSize);
            this.mChildren = sparseArray;
        }

        androidx.emoji2.text.MetadataRepo.Node get(int key) {
            int i;
            if (this.mChildren == null) {
                i = 0;
            } else {
                i = this.mChildren.get(key);
            }
            return i;
        }

        final androidx.emoji2.text.TypefaceEmojiRasterizer getData() {
            return this.mData;
        }

        void put(androidx.emoji2.text.TypefaceEmojiRasterizer data, int start, int end) {
            androidx.emoji2.text.MetadataRepo.Node node;
            SparseArray mChildren;
            int codepointAt;
            if (get(data.getCodepointAt(start)) == null) {
                MetadataRepo.Node node2 = new MetadataRepo.Node();
                this.mChildren.put(data.getCodepointAt(start), node2);
            }
            if (end > start) {
                node.put(data, start + 1, end);
            } else {
                node.mData = data;
            }
        }
    }
    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        super();
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        MetadataRepo.Node node = new MetadataRepo.Node(1024);
        this.mRootNode = node;
        this.mEmojiCharArray = new char[listLength *= 2];
        constructIndex(this.mMetadataList);
    }

    private void constructIndex(MetadataList metadataList) {
        int i3;
        androidx.emoji2.text.TypefaceEmojiRasterizer typefaceEmojiRasterizer;
        int i;
        char[] mEmojiCharArray;
        int i2;
        i3 = 0;
        while (i3 < metadataList.listLength()) {
            typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i3);
            Character.toChars(typefaceEmojiRasterizer.getId(), this.mEmojiCharArray, i3 * 2);
            put(typefaceEmojiRasterizer);
            i3++;
        }
    }

    public static androidx.emoji2.text.MetadataRepo create(AssetManager assetManager, String assetPath) throws IOException {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(Typeface.createFromAsset(assetManager, assetPath), MetadataListReader.read(assetManager, assetPath));
            TraceCompat.endSection();
            return metadataRepo;
            TraceCompat.endSection();
            throw typeface;
        }
    }

    public static androidx.emoji2.text.MetadataRepo create(Typeface typeface) {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataList metadataList = new MetadataList();
            MetadataRepo metadataRepo = new MetadataRepo(typeface, metadataList);
            TraceCompat.endSection();
            return metadataRepo;
            TraceCompat.endSection();
            throw th;
        }
    }

    public static androidx.emoji2.text.MetadataRepo create(Typeface typeface, InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(typeface, MetadataListReader.read(inputStream));
            TraceCompat.endSection();
            return metadataRepo;
            TraceCompat.endSection();
            throw th;
        }
    }

    public static androidx.emoji2.text.MetadataRepo create(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(typeface, MetadataListReader.read(byteBuffer));
            TraceCompat.endSection();
            return metadataRepo;
            TraceCompat.endSection();
            throw th;
        }
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    androidx.emoji2.text.MetadataRepo.Node getRootNode() {
        return this.mRootNode;
    }

    Typeface getTypeface() {
        return this.mTypeface;
    }

    void put(androidx.emoji2.text.TypefaceEmojiRasterizer data) {
        int i;
        Preconditions.checkNotNull(data, "emoji metadata cannot be null");
        final int i2 = 1;
        final int i3 = 0;
        i = data.getCodepointsLength() > 0 ? i2 : i3;
        Preconditions.checkArgument(i, "invalid metadata codepoint length");
        this.mRootNode.put(data, i3, codepointsLength2 -= i2);
    }
}
