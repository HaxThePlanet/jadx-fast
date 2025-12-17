package app.dogo.com.dogo_android.util.h0;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.e;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.Action;

/* loaded from: classes.dex */
public final class k0 implements DialogInterface.OnClickListener {

    public final FirebaseInAppMessagingDisplayCallbacks a;
    public final Action b;
    public final String c;
    public final String v;
    public final e w;
    public k0(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action2, String string3, String string4, e e5) {
        super();
        this.a = firebaseInAppMessagingDisplayCallbacks;
        this.b = action2;
        this.c = string3;
        this.v = string4;
        this.w = e5;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        g1.D(this.a, this.b, this.c, this.v, this.w, dialogInterface, i2);
    }
}
