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

    public static final Parcelable.Creator<b> CREATOR = new p<>();
    private String a;
    private DataHolder b;
    private ParcelFileDescriptor c;
    private long v;
    private byte[] w;
    private byte[] x;
    private File y;

    public b() {
        this(null, null, null, 0L, bArr, 0);
    }

    public b(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        super();
        this.a = str;
        this.b = dataHolder;
        this.c = parcelFileDescriptor;
        this.v = j;
        this.w = bArr;
    }

    private final FileOutputStream o2() {
        Throwable th;
        if (this.y == null) {
            return null;
        }
        try {
            File tempFile = File.createTempFile("xlb", ".tmp", this.y);
        } catch (Throwable th) {
        } catch (java.io.IOException unused) {
        }
        try {
            this.c = ParcelFileDescriptor.open(tempFile, 268435456);
        } catch (Throwable th) {
        } catch (java.io.IOException unused) {
        }
        if (this.y != null) {
            tempFile.delete();
        }
        return new FileOutputStream(tempFile);
    }

    private static void p2(Closeable closeable) {
        try {
            closeable.close();
        } catch (java.io.IOException unused) {
            return;
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
    public void writeToParcel(Parcel parcel, int i) {
        int i3;
        i = 1;
        if (this.c != null || this.x == null || fileOutputStream == null) {
            i = 0;
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
            try {
                dataOutputStream.writeInt(this.x.length);
                dataOutputStream.write(this.x);
            } catch (java.io.IOException unused) {
                b.p2(closeable);
            } finally {
                b.p2(closeable);
                throw parcel;
            }
            b.p2(dataOutputStream);
        }
        if (this.c != 0) {
            i3 = i | i;
        }
        p.a(this, parcel, i3);
        this.c = null;
    }
}
