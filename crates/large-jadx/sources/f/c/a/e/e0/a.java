package f.c.a.e.e0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.e.g;
import d.j.a.a;

/* loaded from: classes2.dex */
public class a extends a {

    public static final Parcelable.Creator<f.c.a.e.e0.a> CREATOR;
    public final g<String, Bundle> c;

    static class a implements Parcelable.ClassLoaderCreator<f.c.a.e.e0.a> {
        @Override // android.os.Parcelable$ClassLoaderCreator
        public f.c.a.e.e0.a a(Parcel parcel) {
            final int i = 0;
            a aVar = new a(parcel, i, i);
            return aVar;
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public f.c.a.e.e0.a b(Parcel parcel, java.lang.ClassLoader classLoader2) {
            a aVar = new a(parcel, classLoader2, 0);
            return aVar;
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public f.c.a.e.e0.a[] c(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public Object createFromParcel(Parcel parcel, java.lang.ClassLoader classLoader2) {
            return b(parcel, classLoader2);
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public Object[] newArray(int i) {
            return c(i);
        }
    }
    static {
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    private a(Parcel parcel, java.lang.ClassLoader classLoader2) {
        Parcelable.Creator cREATOR;
        String str;
        Bundle bundle;
        int obj6;
        super(parcel, classLoader2);
        final int obj7 = parcel.readInt();
        final String[] strArr = new String[obj7];
        parcel.readStringArray(strArr);
        final Bundle[] arr = new Bundle[obj7];
        parcel.readTypedArray(arr, Bundle.CREATOR);
        obj6 = new g(obj7);
        this.c = obj6;
        obj6 = 0;
        while (obj6 < obj7) {
            this.c.put(strArr[obj6], arr[obj6]);
            obj6++;
        }
    }

    a(Parcel parcel, java.lang.ClassLoader classLoader2, f.c.a.e.e0.a.a a$a3) {
        super(parcel, classLoader2);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        g obj1 = new g();
        this.c = obj1;
    }

    @Override // d.j.a.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtendableSavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" states=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override // d.j.a.a
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        Object obj;
        super.writeToParcel(parcel, i2);
        int obj7 = this.c.size();
        parcel.writeInt(obj7);
        final String[] strArr = new String[obj7];
        final Bundle[] arr = new Bundle[obj7];
        final int i3 = 0;
        i = i3;
        while (i < obj7) {
            strArr[i] = (String)this.c.j(i);
            arr[i] = (Bundle)this.c.n(i);
            i++;
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(arr, i3);
    }
}
