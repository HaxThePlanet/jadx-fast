package app.dogo.com.dogo_android.inappmessaging;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements DialogInterface.OnClickListener {

    public final /* synthetic */ i a;
    public /* synthetic */ e(i iVar) {
        super();
        this.a = iVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        InAppFeedbackFragmentDialog.O1(this.a, dialogInterface, i);
    }
}
