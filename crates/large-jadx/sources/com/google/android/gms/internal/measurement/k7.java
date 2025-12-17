package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class k7<MessageType extends com.google.android.gms.internal.measurement.k7<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.j7<MessageType, BuilderType>>  implements com.google.android.gms.internal.measurement.y9 {

    protected int zzb = 0;
    public k7() {
        super();
        final int i = 0;
    }

    protected static <T> void h(Iterable<T> iterable, List<? super T> list2) {
        boolean z;
        int size3;
        int size4;
        int size2;
        int next;
        boolean next2;
        int size;
        Iterator obj6;
        Object obj7;
        d9.e(iterable);
        String str = " is null.";
        final String str2 = "Element at index ";
        final int i = 37;
        if (iterable instanceof h9) {
            size3 = list2;
            obj7 = list2.size();
            obj6 = (h9)iterable.zzh().iterator();
            while (obj6.hasNext()) {
                next = obj6.next();
                if (next == null) {
                    break;
                } else {
                }
                if (next instanceof x7) {
                } else {
                }
                (h9)size3.add((String)next);
                size3.r((x7)next);
            }
        } else {
            if (!iterable instanceof fa && list2 instanceof ArrayList != null && iterable instanceof Collection != null) {
                if (list2 instanceof ArrayList != null) {
                    if (iterable instanceof Collection != null) {
                        (ArrayList)list2.ensureCapacity(size5 += size);
                    }
                }
                size3 = list2.size();
                obj6 = iterable.iterator();
                while (obj6.hasNext()) {
                    next = obj6.next();
                    if (next == 0) {
                        break;
                    } else {
                    }
                    list2.add(next);
                }
            }
        }
        list2.addAll(iterable);
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final com.google.android.gms.internal.measurement.x7 d() {
        try {
            com.google.android.gms.internal.measurement.x7 x7Var = x7.a;
            byte[] bArr = new byte[b()];
            com.google.android.gms.internal.measurement.e8 e8Var = e8.c(bArr);
            a(e8Var);
            e8Var.d();
            w7 w7Var = new w7(bArr);
            return w7Var;
            Class string = getClass();
            string = string.getName();
            String str = String.valueOf(string);
            str = str.length();
            str += 72;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Serializing ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = " to a ByteString threw an IOException (should never happen).";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(string, th);
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y9
    int g() {
        throw 0;
    }

    @Override // com.google.android.gms.internal.measurement.y9
    void i(int i) {
        throw 0;
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final byte[] j() {
        try {
            byte[] bArr = new byte[b()];
            final com.google.android.gms.internal.measurement.e8 e8Var = e8.c(bArr);
            a(e8Var);
            e8Var.d();
            return bArr;
            Class string = getClass();
            string = string.getName();
            String str = String.valueOf(string);
            str = str.length();
            str += 72;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Serializing ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = " to a byte array threw an IOException (should never happen).";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(string, th);
            throw runtimeException;
        }
    }
}
