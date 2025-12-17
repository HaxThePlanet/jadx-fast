package com.revenuecat.purchases.parceler;

import android.os.Parcel;
import k.a.a.a;
import k.a.a.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Lcom/revenuecat/purchases/parceler/JSONObjectParceler;", "Lk/a/a/a;", "Lorg/json/JSONObject;", "Landroid/os/Parcel;", "parcel", "create", "(Landroid/os/Parcel;)Lorg/json/JSONObject;", "", "flags", "Lkotlin/w;", "write", "(Lorg/json/JSONObject;Landroid/os/Parcel;I)V", "<init>", "()V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class JSONObjectParceler implements a<JSONObject> {

    public static final com.revenuecat.purchases.parceler.JSONObjectParceler INSTANCE;
    static {
        JSONObjectParceler jSONObjectParceler = new JSONObjectParceler();
        JSONObjectParceler.INSTANCE = jSONObjectParceler;
    }

    @Override // k.a.a.a
    public Object create(Parcel parcel) {
        return create(parcel);
    }

    @Override // k.a.a.a
    public JSONObject create(Parcel parcel) {
        n.f(parcel, "parcel");
        JSONObject jSONObject = new JSONObject(parcel.readString());
        return jSONObject;
    }

    @Override // k.a.a.a
    public Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // k.a.a.a
    public JSONObject[] newArray(int i) {
        a.a.a(this, i);
        throw 0;
    }

    @Override // k.a.a.a
    public void write(Object object, Parcel parcel2, int i3) {
        write((JSONObject)object, parcel2, i3);
    }

    @Override // k.a.a.a
    public void write(JSONObject jSONObject, Parcel parcel2, int i3) {
        n.f(jSONObject, "$this$write");
        n.f(parcel2, "parcel");
        parcel2.writeString(jSONObject.toString());
    }
}
