package com.google.firebase.database.core;

/* loaded from: classes2.dex */
public final class Tag {

    private final long tagNumber;
    public Tag(long l) {
        super();
        this.tagNumber = l;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.database.core.Tag> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (Tag.class != object.getClass()) {
            } else {
                if (Long.compare(tagNumber, tagNumber2) != 0) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public long getTagNumber() {
        return this.tagNumber;
    }

    public int hashCode() {
        long tagNumber = this.tagNumber;
        return (int)i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tag{tagNumber=");
        stringBuilder.append(this.tagNumber);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
