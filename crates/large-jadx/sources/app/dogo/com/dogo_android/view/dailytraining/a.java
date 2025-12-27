package app.dogo.com.dogo_android.view.dailytraining;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ ClickerSoundMaterialButton a;
    public final /* synthetic */ Context b;
    public /* synthetic */ a(ClickerSoundMaterialButton clickerSoundMaterialButton, Context context) {
        super();
        this.a = clickerSoundMaterialButton;
        this.b = context;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ClickerSoundMaterialButton.m(this.a, this.b, view);
    }
}
