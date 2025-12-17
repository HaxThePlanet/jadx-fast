package com.revenuecat.purchases.parceler;

import android.os.Parcel;
import android.os.ParcelFormatException;
import com.android.billingclient.api.SkuDetails;
import k.a.a.a;
import k.a.a.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Lcom/revenuecat/purchases/parceler/SkuDetailsParceler;", "Lk/a/a/a;", "Lcom/android/billingclient/api/SkuDetails;", "Landroid/os/Parcel;", "parcel", "create", "(Landroid/os/Parcel;)Lcom/android/billingclient/api/SkuDetails;", "", "flags", "Lkotlin/w;", "write", "(Lcom/android/billingclient/api/SkuDetails;Landroid/os/Parcel;I)V", "<init>", "()V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class SkuDetailsParceler implements a<SkuDetails> {

    public static final com.revenuecat.purchases.parceler.SkuDetailsParceler INSTANCE;
    static {
        SkuDetailsParceler skuDetailsParceler = new SkuDetailsParceler();
        SkuDetailsParceler.INSTANCE = skuDetailsParceler;
    }

    @Override // k.a.a.a
    public SkuDetails create(Parcel parcel) {
        n.f(parcel, "parcel");
        String obj2 = parcel.readString();
        if (obj2 == null) {
        } else {
            SkuDetails skuDetails = new SkuDetails(obj2);
            return skuDetails;
        }
        obj2 = new ParcelFormatException("SkuDetails parcel is a null string");
        throw obj2;
    }

    @Override // k.a.a.a
    public Object create(Parcel parcel) {
        return create(parcel);
    }

    @Override // k.a.a.a
    public SkuDetails[] newArray(int i) {
        a.a.a(this, i);
        throw 0;
    }

    @Override // k.a.a.a
    public Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // k.a.a.a
    public void write(SkuDetails skuDetails, Parcel parcel2, int i3) {
        n.f(skuDetails, "$this$write");
        n.f(parcel2, "parcel");
        parcel2.writeString(skuDetails.h());
    }

    @Override // k.a.a.a
    public void write(Object object, Parcel parcel2, int i3) {
        write((SkuDetails)object, parcel2, i3);
    }
}
