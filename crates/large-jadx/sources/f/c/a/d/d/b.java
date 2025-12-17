package f.c.a.d.d;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.f;

/* loaded from: classes2.dex */
final class b extends AsyncTask<Void, Void, Integer> {

    final Context a;
    final f.c.a.d.d.a.a b;
    b(Context context, f.c.a.d.d.a.a a$a2) {
        this.a = context;
        this.b = a2;
        super();
    }

    @Override // android.os.AsyncTask
    protected final Object doInBackground(Object[] objectArr) {
        int obj1;
        a.a(this.a);
        obj1 = 0;
        return Integer.valueOf(obj1);
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Object object) {
        if ((Integer)object.intValue() == 0) {
            this.b.onProviderInstalled();
        }
        this.b.onProviderInstallFailed(object.intValue(), a.c().b(this.a, object.intValue(), "pi"));
    }
}
