package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.r;
import d.e.a;
import d.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {

    private final a<c<?>, b> zaa;
    public AvailabilityException(a<c<?>, b> a) {
        super();
        this.zaa = a;
    }

    @Override // java.lang.Exception
    public String getMessage() {
        String str;
        int i;
        String string;
        String valueOf;
        int i2;
        int length;
        StringBuilder stringBuilder;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.zaa.keySet().iterator();
        int i3 = 1;
        i = i3;
        for (c next2 : iterator) {
            Object obj = this.zaa.get(next2);
            r.j((b)obj);
            i &= i4;
            String str3 = next2.b();
            valueOf = String.valueOf(obj);
            stringBuilder = new StringBuilder(i5 += length);
            stringBuilder.append(str3);
            stringBuilder.append(": ");
            stringBuilder.append(valueOf);
            arrayList.add(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (i != 0) {
            stringBuilder2.append("None of the queried APIs are available. ");
        } else {
            stringBuilder2.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder2.append(TextUtils.join("; ", arrayList));
        return stringBuilder2.toString();
    }
}
