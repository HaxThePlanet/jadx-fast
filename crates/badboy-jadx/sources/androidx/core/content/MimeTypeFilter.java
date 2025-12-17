package androidx.core.content;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class MimeTypeFilter {
    public static String matches(String mimeType, String[] filters) {
        int i;
        Object obj;
        String[] split;
        boolean mimeTypeAgainstFilter;
        final int i2 = 0;
        if (mimeType == null) {
            return i2;
        }
        final String str = "/";
        i = 0;
        while (i < filters.length) {
            obj = filters[i];
            i++;
        }
        return i2;
    }

    public static String matches(String[] mimeTypes, String filter) {
        int i;
        Object obj;
        String[] split;
        boolean mimeTypeAgainstFilter;
        final int i2 = 0;
        if (mimeTypes == null) {
            return i2;
        }
        final String str = "/";
        i = 0;
        while (i < mimeTypes.length) {
            obj = mimeTypes[i];
            i++;
        }
        return i2;
    }

    public static boolean matches(String mimeType, String filter) {
        if (mimeType == null) {
            return 0;
        }
        String str = "/";
        return MimeTypeFilter.mimeTypeAgainstFilter(mimeType.split(str), filter.split(str));
    }

    public static String[] matchesMany(String[] mimeTypes, String filter) {
        int i;
        Object obj;
        String[] split;
        boolean mimeTypeAgainstFilter;
        if (mimeTypes == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        final String str = "/";
        while (i < mimeTypes.length) {
            obj = mimeTypes[i];
            if (MimeTypeFilter.mimeTypeAgainstFilter(obj.split(str), filter.split(str))) {
            }
            i++;
            arrayList.add(obj);
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(String[] mimeTypeParts, String[] filterParts) {
        boolean equals;
        boolean equals2;
        boolean empty2;
        Object str;
        boolean empty;
        Object obj;
        int i2 = 2;
        if (filterParts.length != i2) {
        } else {
            int i = 0;
            if (filterParts[i].isEmpty()) {
            } else {
                empty2 = 1;
                if (filterParts[empty2].isEmpty()) {
                } else {
                    if (mimeTypeParts.length != i2) {
                        return i;
                    }
                    str = "*";
                    if (!str.equals(filterParts[i]) && !filterParts[i].equals(mimeTypeParts[i])) {
                        if (!filterParts[i].equals(mimeTypeParts[i])) {
                            return i;
                        }
                    }
                    if (!str.equals(filterParts[empty2]) && !filterParts[empty2].equals(mimeTypeParts[empty2])) {
                        if (!filterParts[empty2].equals(mimeTypeParts[empty2])) {
                            return i;
                        }
                    }
                    return empty2;
                }
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
            throw illegalArgumentException2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        throw illegalArgumentException;
    }
}
