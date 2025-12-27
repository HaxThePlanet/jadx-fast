package f.c.a.e.e0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.e.g;
import d.j.a.a;

/* compiled from: ExtendableSavedState.java */
/* loaded from: classes2.dex */
public class a extends a {

    public static final Parcelable.Creator<a> CREATOR = new a$a<>();
    public final g<String, Bundle> c;

    static class a implements Parcelable.ClassLoaderCreator<a> {
        a() {
            super();
        }

        public a a(Parcel parcel) {
            final java.lang.ClassLoader classLoader = null;
            return new a(parcel, classLoader, classLoader);
        }

        public a b(Parcel parcel, java.lang.ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        public a[] c(int i) {
            return new a[i];
        }
    }

    /* synthetic */ a(Parcel parcel, java.lang.ClassLoader classLoader, a.a aVar) {
        this(parcel, classLoader);
    }

    @Override // d.j.a.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExtendableSavedState{";
        String str3 = Integer.toHexString(System.identityHashCode(this));
        String str4 = " states=";
        String str5 = "}";
        str = str2 + str3 + str4 + this.c + str5;
        return str;
    }

    @Override // d.j.a.a
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.c.size();
        parcel.writeInt(size);
        final String[] strArr = new String[size];
        final Bundle[] arr = new Bundle[size];
        i = 0;
        while (i < this.c) {
            strArr[i] = (String)this.c.j(i);
            arr[i] = (Bundle)this.c.n(i);
            i = i + 1;
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(arr, i);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.c = new g();
    }

    private a(Parcel parcel, java.lang.ClassLoader classLoader) {
        int i = 0;
        super(parcel, classLoader);
        final int _int = parcel.readInt();
        final String[] strArr = new String[_int];
        parcel.readStringArray(strArr);
        final Bundle[] arr = new Bundle[_int];
        parcel.readTypedArray(arr, Bundle.CREATOR);
        this.c = new g(_int);
        i = 0;
        while (i < _int) {
            this.c.put(strArr[i], arr[i]);
            i = i + 1;
        }
    }
}
