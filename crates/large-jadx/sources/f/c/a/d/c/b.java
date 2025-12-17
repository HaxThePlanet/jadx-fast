package f.c.a.d.c;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class b extends a {

    public static final Parcelable.Creator<f.c.a.d.c.b> CREATOR;
    private String a;
    private DataHolder b;
    private ParcelFileDescriptor c;
    private long v;
    private byte[] w;
    private byte[] x;
    private File y;
    static {
        Class<f.c.a.d.c.b> obj = b.class;
        p pVar = new p();
        b.CREATOR = pVar;
    }

    public b() {
        super(0, 0, 0, 0, obj5, 0);
    }

    public b(String string, DataHolder dataHolder2, ParcelFileDescriptor parcelFileDescriptor3, long l4, byte[] b5Arr5) {
        super();
        this.a = string;
        this.b = dataHolder2;
        this.c = parcelFileDescriptor3;
        this.v = l4;
        this.w = obj6;
    }

    private final FileOutputStream o2() {
        Throwable th;
        Throwable th2;
        File file = this.y;
        if (file == null) {
            return null;
        }
        File tempFile = File.createTempFile("xlb", ".tmp", file);
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        this.c = ParcelFileDescriptor.open(tempFile, 268435456);
        if (tempFile != null) {
            tempFile.delete();
        }
        return fileOutputStream;
    }

    private static void p2(Closeable closeable) {
        try {
            closeable.close();
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public DataHolder j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public ParcelFileDescriptor k2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public long l2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String m2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public byte[] n2() {
        return this.w;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        Object parcelFileDescriptor;
        byte[] bArr;
        int obj5;
        final int i3 = 1;
        parcelFileDescriptor = o2();
        if (this.c == null && this.x != null && parcelFileDescriptor != null) {
            if (this.x != null) {
                parcelFileDescriptor = o2();
                if (parcelFileDescriptor != null) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(parcelFileDescriptor);
                    DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
                    dataOutputStream.writeInt(bArr2.length);
                    dataOutputStream.write(this.x);
                    b.p2(dataOutputStream);
                    i = i3;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        if (i == 0) {
        } else {
            i2 |= i3;
        }
        p.a(this, parcel, obj5);
        this.c = 0;
    }
}
