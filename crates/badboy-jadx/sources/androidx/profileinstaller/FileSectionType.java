package androidx.profileinstaller;

/* loaded from: classes5.dex */
enum FileSectionType {

    DEX_FILES(false, /* unknown */),
    EXTRA_DESCRIPTORS(false, /* unknown */),
    CLASSES(false, /* unknown */),
    METHODS(false, /* unknown */),
    AGGREGATION_COUNT(false, /* unknown */);

    private final long mValue;
    private static androidx.profileinstaller.FileSectionType[] $values() {
        return /* result */;
    }

    static androidx.profileinstaller.FileSectionType fromValue(long value) {
        int i;
        int cmp;
        final androidx.profileinstaller.FileSectionType[] values = FileSectionType.values();
        i = 0;
        for (Object fileSectionType : obj0) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException i2 = new IllegalArgumentException(stringBuilder.append("Unsupported FileSection Type ").append(value).toString());
        throw i2;
    }

    @Override // java.lang.Enum
    public long getValue() {
        return this.mValue;
    }
}
