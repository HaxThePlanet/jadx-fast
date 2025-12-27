package app.dogo.com.dogo_android.inappmessaging;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements DialogInterface.OnClickListener {

    public final /* synthetic */ i a;
    public /* synthetic */ b(i iVar) {
        super();
        this.a = iVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        InAppFeedbackFragmentDialog.P1(this.a, dialogInterface, i);
    }
}
