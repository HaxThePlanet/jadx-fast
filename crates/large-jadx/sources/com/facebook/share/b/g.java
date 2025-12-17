package com.facebook.share.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0008\tB\u000f\u0008\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u0011\u0008\u0010\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\n", d2 = {"Lcom/facebook/share/model/ShareOpenGraphObject;", "Lcom/facebook/share/model/ShareOpenGraphValueContainer;", "Lcom/facebook/share/model/ShareOpenGraphObject$Builder;", "builder", "(Lcom/facebook/share/model/ShareOpenGraphObject$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class g extends com.facebook.share.b.h<com.facebook.share.b.g, Object> {

    public static final Parcelable.Creator<com.facebook.share.b.g> CREATOR;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/share/model/ShareOpenGraphObject$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareOpenGraphObject;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/share/model/ShareOpenGraphObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.share.b.g> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.g a(Parcel parcel) {
            n.f(parcel, "parcel");
            g gVar = new g(parcel);
            return gVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.g[] b(int i) {
            return new g[i];
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
    static {
        g.a aVar = new g.a();
        g.CREATOR = aVar;
    }

    public g(Parcel parcel) {
        super(parcel);
    }
}
