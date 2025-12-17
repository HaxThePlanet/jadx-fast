package com.facebook.share.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class e extends com.facebook.share.b.h<com.facebook.share.b.e, com.facebook.share.b.e.b> {

    public static final Parcelable.Creator<com.facebook.share.b.e> CREATOR;

    static class a implements Parcelable.Creator<com.facebook.share.b.e> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.e a(Parcel parcel) {
            e eVar = new e(parcel);
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.e[] b(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    public static final class b extends com.facebook.share.b.h.a<com.facebook.share.b.e, com.facebook.share.b.e.b> {
        @Override // com.facebook.share.b.h$a
        public com.facebook.share.b.e d() {
            e eVar = new e(this, 0);
            return eVar;
        }

        @Override // com.facebook.share.b.h$a
        com.facebook.share.b.e.b e(Parcel parcel) {
            return f((e)parcel.readParcelable(e.class.getClassLoader()));
        }

        @Override // com.facebook.share.b.h$a
        public com.facebook.share.b.e.b f(com.facebook.share.b.e e) {
            if (e == null) {
                return this;
            }
            super.c(e);
            final com.facebook.share.b.e.b bVar = this;
            (e.b)bVar.g(e.e());
            return bVar;
        }

        @Override // com.facebook.share.b.h$a
        public com.facebook.share.b.e.b g(String string) {
            b("og:type", string);
            return this;
        }
    }
    static {
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    e(Parcel parcel) {
        super(parcel);
    }

    private e(com.facebook.share.b.e.b e$b) {
        super(b);
    }

    e(com.facebook.share.b.e.b e$b, com.facebook.share.b.e.a e$a2) {
        super(b);
    }

    @Override // com.facebook.share.b.h
    public String e() {
        return c("og:type");
    }
}
