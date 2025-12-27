package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import androidx.appcompat.app.c;
import androidx.fragment.app.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c0 implements DialogInterface.OnShowListener {

    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c c;
    public /* synthetic */ c0(e eVar, String str, c cVar) {
        super();
        this.a = eVar;
        this.b = str;
        this.c = cVar;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.t(this.a, this.b, this.c, dialogInterface);
    }
}
