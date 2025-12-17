package app.dogo.com.dogo_android.view.dailytraining;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton a;
    public final Context b;
    public a(app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton clickerSoundMaterialButton, Context context2) {
        super();
        this.a = clickerSoundMaterialButton;
        this.b = context2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ClickerSoundMaterialButton.n(this.a, this.b, view);
    }
}
