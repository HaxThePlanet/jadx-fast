package d.j.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* compiled from: AbsSavedState.java */
/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    public static final Parcelable.Creator<a> CREATOR = new a$b<>();
    public static final a b = new a$a();
    private final Parcelable a;

    class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
            super();
        }

        public a a(Parcel parcel) {
            return b(parcel, null);
        }

        public a b(Parcel parcel, java.lang.ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            } else {
                return a.b;
            }
        }

        public a[] c(int i) {
            return new a[i];
        }
    }

    class a extends a {
        a() {
            super(null);
        }
    }

    /* synthetic */ a(a.a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }

    private a() {
        super();
        this.a = null;
    }

    protected a(Parcelable parcelable) {
        int i = 0;
        super();
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        } else {
            if (parcelable == a.b) {
                i = 0;
            }
            this.a = i;
            return;
        }
    }

    protected a(Parcel parcel, java.lang.ClassLoader classLoader) {
        Parcelable parcelable;
        super();
        if (parcel.readParcelable(classLoader) == null) {
            d.j.a.a aVar = a.b;
        }
        this.a = parcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
