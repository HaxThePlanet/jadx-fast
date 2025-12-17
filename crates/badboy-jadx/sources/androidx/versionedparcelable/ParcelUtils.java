package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ParcelUtils {

    private static final String INNER_BUNDLE_KEY = "a";
    public static <T extends androidx.versionedparcelable.VersionedParcelable> T fromInputStream(InputStream input) {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(input, 0);
        return versionedParcelStream.readVersionedParcelable();
    }

    public static <T extends androidx.versionedparcelable.VersionedParcelable> T fromParcelable(Parcelable p) {
        if (!p instanceof ParcelImpl) {
        } else {
            return (ParcelImpl)p.getVersionedParcel();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid parcel");
        throw illegalArgumentException;
    }

    public static <T extends androidx.versionedparcelable.VersionedParcelable> T getVersionedParcelable(Bundle bundle, String key) {
        final Parcelable parcelable2 = bundle.getParcelable(key);
        if ((Bundle)parcelable2 == null) {
            try {
                return 0;
                (Bundle)parcelable2.setClassLoader(ParcelUtils.class.getClassLoader());
                return ParcelUtils.fromParcelable(parcelable2.getParcelable("a"));
                return obj0;
            }
        }
    }

    public static <T extends androidx.versionedparcelable.VersionedParcelable> List<T> getVersionedParcelableList(Bundle bundle, String key) {
        Object next;
        androidx.versionedparcelable.VersionedParcelable parcelable;
        ArrayList arrayList = new ArrayList();
        final Parcelable parcelable2 = bundle.getParcelable(key);
        (Bundle)parcelable2.setClassLoader(ParcelUtils.class.getClassLoader());
        final Iterator iterator = parcelable2.getParcelableArrayList("a").iterator();
        for (Parcelable next : iterator) {
            arrayList.add(ParcelUtils.fromParcelable(next));
        }
        return arrayList;
    }

    public static void putVersionedParcelable(Bundle b, String key, androidx.versionedparcelable.VersionedParcelable obj) {
        if (obj == null) {
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("a", ParcelUtils.toParcelable(obj));
        b.putParcelable(key, bundle);
    }

    public static void putVersionedParcelableList(Bundle b, String key, List<? extends androidx.versionedparcelable.VersionedParcelable> list3) {
        Object next;
        Parcelable parcelable;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list3.iterator();
        for (VersionedParcelable next : iterator) {
            arrayList.add(ParcelUtils.toParcelable(next));
        }
        bundle.putParcelableArrayList("a", arrayList);
        b.putParcelable(key, bundle);
    }

    public static void toOutputStream(androidx.versionedparcelable.VersionedParcelable obj, OutputStream output) {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(0, output);
        versionedParcelStream.writeVersionedParcelable(obj);
        versionedParcelStream.closeField();
    }

    public static Parcelable toParcelable(androidx.versionedparcelable.VersionedParcelable obj) {
        ParcelImpl parcelImpl = new ParcelImpl(obj);
        return parcelImpl;
    }
}
