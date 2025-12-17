package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class sp extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.sp> CREATOR;
    public final int a;
    private List<String> b;
    static {
        tp tpVar = new tp();
        sp.CREATOR = tpVar;
    }

    public sp() {
        super(0);
    }

    sp(int i, List<String> list2) {
        String str;
        int obj2;
        super();
        this.a = i;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                obj2 = 0;
                while (obj2 < list2.size()) {
                    list2.set(obj2, n.a((String)list2.get(obj2)));
                    obj2++;
                }
                this.b = Collections.unmodifiableList(list2);
            }
        }
        this.b = Collections.emptyList();
    }

    public sp(List<String> list) {
        ArrayList arrayList;
        super();
        this.a = 1;
        arrayList = new ArrayList();
        this.b = arrayList;
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                this.b.addAll(list);
            }
        }
    }

    public static com.google.android.gms.internal.firebase-auth-api.sp j2(com.google.android.gms.internal.firebase-auth-api.sp sp) {
        sp spVar = new sp(sp.b);
        return spVar;
    }

    public final List<String> k2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.q(parcel, 2, this.b, false);
        b.b(parcel, b.a(parcel));
    }
}
