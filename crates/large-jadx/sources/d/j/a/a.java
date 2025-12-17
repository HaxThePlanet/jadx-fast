package d.j.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    public static final Parcelable.Creator<d.j.a.a> CREATOR;
    public static final d.j.a.a b;
    private final Parcelable a;

    class b implements Parcelable.ClassLoaderCreator<d.j.a.a> {
        @Override // android.os.Parcelable$ClassLoaderCreator
        public d.j.a.a a(Parcel parcel) {
            return b(parcel, 0);
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public d.j.a.a b(Parcel parcel, java.lang.ClassLoader classLoader2) {
            if (parcel.readParcelable(classLoader2) != null) {
            } else {
                return a.b;
            }
            IllegalStateException obj1 = new IllegalStateException("superState must be null");
            throw obj1;
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public d.j.a.a[] c(int i) {
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

    class a extends d.j.a.a {
        a() {
            super(0);
        }
    }
    static {
        a.a aVar = new a.a();
        a.b = aVar;
        a.b bVar = new a.b();
        a.CREATOR = bVar;
    }

    private a() {
        super();
        this.a = 0;
    }

    protected a(Parcel parcel, java.lang.ClassLoader classLoader2) {
        Parcelable obj1;
        super();
        if (parcel.readParcelable(classLoader2) != null) {
        } else {
            obj1 = a.b;
        }
        this.a = obj1;
    }

    protected a(Parcelable parcelable) {
        int obj2;
        super();
        if (parcelable == null) {
        } else {
            if (parcelable != a.b) {
            } else {
                obj2 = 0;
            }
            this.a = obj2;
        }
        obj2 = new IllegalArgumentException("superState must not be null");
        throw obj2;
    }

    a(d.j.a.a.a a$a) {
        super();
    }

    @Override // android.os.Parcelable
    public final Parcelable a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
    }
}
