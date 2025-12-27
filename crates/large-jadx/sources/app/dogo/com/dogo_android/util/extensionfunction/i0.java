package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.e;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.Action;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i0 implements DialogInterface.OnClickListener {

    public final /* synthetic */ FirebaseInAppMessagingDisplayCallbacks a;
    public final /* synthetic */ Action b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String v;
    public final /* synthetic */ e w;
    public /* synthetic */ i0(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action, String str, String str2, e eVar) {
        super();
        this.a = firebaseInAppMessagingDisplayCallbacks;
        this.b = action;
        this.c = str;
        this.v = str2;
        this.w = eVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.s(this.a, this.b, this.c, this.v, this.w, dialogInterface, i);
    }
}
