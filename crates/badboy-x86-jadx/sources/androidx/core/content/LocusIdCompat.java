package androidx.core.content;

import android.content.LocusId;
import androidx.core.util.Preconditions;

/* loaded from: classes5.dex */
public final class LocusIdCompat {

    private final String mId;
    private final LocusId mWrapped;

    private static class Api29Impl {
        static LocusId create(String id) {
            LocusId locusId = new LocusId(id);
            return locusId;
        }

        static String getId(LocusId obj) {
            return obj.getId();
        }
    }
    public LocusIdCompat(String id) {
        super();
        this.mId = (String)Preconditions.checkStringNotEmpty(id, "id cannot be empty");
        this.mWrapped = LocusIdCompat.Api29Impl.create(id);
    }

    private String getSanitizedId() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.mId.length()).append("_chars").toString();
    }

    public static androidx.core.content.LocusIdCompat toLocusIdCompat(LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        LocusIdCompat locusIdCompat = new LocusIdCompat((String)Preconditions.checkStringNotEmpty(LocusIdCompat.Api29Impl.getId(locusId), "id cannot be empty"));
        return locusIdCompat;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return 1;
        }
        int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (getClass() != obj.getClass()) {
            return i2;
        }
        Object obj2 = obj;
        if (this.mId == null) {
            if (obj2.mId == null) {
            } else {
                i = i2;
            }
            return i;
        }
        return this.mId.equals(obj2.mId);
    }

    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        int i;
        final int i2 = 31;
        if (this.mId == null) {
            i = 0;
        } else {
            i = this.mId.hashCode();
        }
        return i4 += i;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LocusIdCompat[").append(getSanitizedId()).append("]").toString();
    }
}
