package androidx.profileinstaller;

/* loaded from: classes5.dex */
class WritableFileSection {

    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final androidx.profileinstaller.FileSectionType mType;
    WritableFileSection(androidx.profileinstaller.FileSectionType type, int expectedInflateSize, byte[] contents, boolean needsCompression) {
        super();
        this.mType = type;
        this.mExpectedInflateSize = expectedInflateSize;
        this.mContents = contents;
        this.mNeedsCompression = needsCompression;
    }
}
