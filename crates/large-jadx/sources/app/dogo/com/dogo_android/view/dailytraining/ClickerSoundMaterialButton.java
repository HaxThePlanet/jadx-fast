package app.dogo.com.dogo_android.view.dailytraining;

import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.core.content.a;
import app.dogo.com.dogo_android.util.j;
import com.google.android.material.button.MaterialButton;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.a;
import com.skydoves.balloon.a;
import com.skydoves.balloon.c;
import com.skydoves.balloon.f;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.w;
import m.a.c.a;
import m.a.c.c.a;
import m.a.c.c.a.a;
import m.a.c.c.b;
import m.a.c.j.a;
import m.a.c.k.c;
import m.a.c.l.a;
import m.a.f.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0015H\u0014J\u0012\u0010\u0017\u001a\u00020\u00152\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/ClickerSoundMaterialButton;", "Lcom/google/android/material/button/MaterialButton;", "Lorg/koin/core/component/KoinComponent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioManager", "Landroid/media/AudioManager;", "balloon", "Lcom/skydoves/balloon/Balloon;", "compositeListener", "Lapp/dogo/com/dogo_android/view/dailytraining/CompositeListener;", "soundPlayerWithPreference", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "getSoundPlayerWithPreference", "()Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "soundPlayerWithPreference$delegate", "Lkotlin/Lazy;", "onAttachedToWindow", "", "onDetachedFromWindow", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "showMessage", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClickerSoundMaterialButton extends MaterialButton implements a {

    private final h K;
    private final app.dogo.com.dogo_android.view.dailytraining.k L;
    private final AudioManager M;
    private Balloon N;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/core/component/KoinComponentKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<j> {

        final a $parameters;
        final a $qualifier;
        final a $this_inject;
        public a(a a, a a2, a a3) {
            this.$this_inject = a;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final j invoke() {
            a aVar;
            a $this_inject = this.$this_inject;
            if ($this_inject instanceof b) {
                aVar = (b)$this_inject.a();
            } else {
                aVar = $this_inject.getKoin().d().b();
            }
            return aVar.c(c0.b(j.class), this.$qualifier, this.$parameters);
        }
    }
    static {
    }

    public ClickerSoundMaterialButton(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        super(context, attributeSet2);
        int i = 0;
        ClickerSoundMaterialButton.a aVar = new ClickerSoundMaterialButton.a(this, i, i);
        this.K = j.a(a.a.b(), aVar);
        k obj4 = new k();
        this.L = obj4;
        Object systemService = context.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.M = (AudioManager)systemService;
        super.setOnClickListener(obj4);
        obj4 = new a(this, context);
        setOnClickListener(obj4);
    }

    private final j getSoundPlayerWithPreference() {
        return (j)this.K.getValue();
    }

    private static final void m(app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton clickerSoundMaterialButton, Context context2, View view3) {
        n.f(clickerSoundMaterialButton, "this$0");
        n.f(context2, "$context");
        clickerSoundMaterialButton.getSoundPlayerWithPreference().c(context2);
        clickerSoundMaterialButton.o(context2);
    }

    public static void n(app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton clickerSoundMaterialButton, Context context2, View view3) {
        ClickerSoundMaterialButton.m(clickerSoundMaterialButton, context2, view3);
    }

    private final void o(Context context) {
        int aVar;
        int i2;
        AudioManager audioManager;
        int i;
        Object obj5;
        int i4 = 3;
        audioManager = this.M;
        if (i3 /= streamMaxVolume < 20) {
            aVar = new Balloon.a(context);
            aVar.A(2131887572);
            aVar.h(1000);
            aVar.i(2131100336);
            aVar.z(2131099706);
            audioManager = 0;
            Typeface create = Typeface.create("sans-serif-medium", audioManager);
            n.e(create, "create(\"sans-serif-medium\", Typeface.NORMAL)");
            aVar.C(create);
            aVar.B(1097859072);
            aVar.D(1065353216);
            i2 = 10;
            aVar.y(i2);
            aVar.c(a.TOP);
            aVar.e(c.ALIGN_BALLOON);
            aVar.b(a.f(context, 2131231078));
            aVar.k(1094713344);
            aVar.v(i2);
            obj5 = 12;
            aVar.x(obj5);
            aVar.w(obj5);
            aVar.f(32);
            aVar.g(24);
            obj5 = 44;
            aVar.s(obj5);
            aVar.t(obj5);
            aVar.j(f.OVERSHOOT);
            aVar.r(aVar.u0);
            obj5 = w.a;
            obj5 = aVar.a();
            this.N = obj5;
            if (obj5 == null) {
            } else {
                obj5.x0(this, audioManager, audioManager);
            }
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public a getKoin() {
        return a.a.a(this);
    }

    @Override // com.google.android.material.button.MaterialButton
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getSoundPlayerWithPreference().a();
    }

    @Override // com.google.android.material.button.MaterialButton
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSoundPlayerWithPreference().f();
        Balloon balloon = this.N;
        if (balloon == null) {
        } else {
            balloon.J();
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setOnClickListener(View.OnClickListener view$OnClickListener) {
        this.L.a(onClickListener);
    }
}
