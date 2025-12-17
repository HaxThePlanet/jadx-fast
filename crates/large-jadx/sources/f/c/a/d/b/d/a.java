package f.c.a.d.b.d;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public class a implements IInterface {

    private final IBinder a;
    protected a(IBinder iBinder, String string2) {
        super();
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
