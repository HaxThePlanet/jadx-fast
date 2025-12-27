package app.dogo.com.dogo_android.view.dailytraining;

import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.material.button.MaterialButton;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.a;
import com.skydoves.balloon.f;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.w;
import m.a.c.c.a.a;
import m.a.c.c.b;

/* compiled from: ClickerSoundMaterialButton.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0015H\u0014J\u0012\u0010\u0017\u001a\u00020\u00152\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/ClickerSoundMaterialButton;", "Lcom/google/android/material/button/MaterialButton;", "Lorg/koin/core/component/KoinComponent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioManager", "Landroid/media/AudioManager;", "balloon", "Lcom/skydoves/balloon/Balloon;", "compositeListener", "Lapp/dogo/com/dogo_android/view/dailytraining/CompositeListener;", "soundPlayerWithPreference", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "getSoundPlayerWithPreference", "()Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "soundPlayerWithPreference$delegate", "Lkotlin/Lazy;", "onAttachedToWindow", "", "onDetachedFromWindow", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "showMessage", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ClickerSoundMaterialButton extends MaterialButton implements m.a.c.c.a {

    /* renamed from: K, reason: from kotlin metadata */
    private final h audioManager;
    /* renamed from: L, reason: from kotlin metadata */
    private final k balloon = new k();
    /* renamed from: M, reason: from kotlin metadata */
    private final AudioManager compositeListener;
    private Balloon N;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/core/component/KoinComponentKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.util.j> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ m.a.c.c.a $this_inject;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.util.j invoke() {
            m.a.c.l.a aVar;
            if ($this_inject2 instanceof KoinScopeComponent) {
                aVar = $this_inject2.a();
            } else {
                aVar = $this_inject2.getKoin().d().b();
            }
            return aVar.c(c0.b(ClickerSoundPlayerWithPreference.class), this.$qualifier, this.$parameters);
        }

        public a(m.a.c.c.a aVar, m.a.c.j.a aVar2, kotlin.d0.c.a aVar3) {
            this.$this_inject = aVar;
            this.$qualifier = aVar2;
            this.$parameters = aVar3;
            super(0);
        }
    }
    public ClickerSoundMaterialButton(Context context, AttributeSet set) {
        n.f(context, "context");
        super(context, set);
        m.a.c.j.a aVar2 = null;
        this.audioManager = j.a(KoinPlatformTools.a.b(), new ClickerSoundMaterialButton.a(this, aVar2, aVar2));
        Object systemService = context.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.compositeListener = systemService;
        super.setOnClickListener(new CompositeListener());
        setOnClickListener(new a(this, context));
    }

    private final app.dogo.com.dogo_android.util.j getSoundPlayerWithPreference() {
        return (ClickerSoundPlayerWithPreference)this.audioManager.getValue();
    }

    private static final void m(ClickerSoundMaterialButton clickerSoundMaterialButton, Context context, View view) {
        n.f(clickerSoundMaterialButton, "this$0");
        n.f(context, "$context");
        clickerSoundMaterialButton.getSoundPlayerWithPreference().performClickerVibration(context);
        clickerSoundMaterialButton.setOnClickListener(context);
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final void setOnClickListener(Context l) {
        int i5 = 3;
        i = (this.compositeListener.getStreamVolume(i5) * 100) / this.compositeListener.getStreamMaxVolume(i5);
        int i2 = 20;
        if (this.compositeListener.getStreamVolume(i5) * 100 / this.compositeListener.getStreamMaxVolume(i5) < 20) {
            Balloon.a aVar = new Balloon.a(l);
            aVar.A(2131887572);
            aVar.h(1000L);
            aVar.i(2131100336);
            aVar.z(2131099706);
            int i12 = 0;
            Typeface typeface = Typeface.create("sans-serif-medium", i12);
            n.e(typeface, "create(\"sans-serif-medium\", Typeface.NORMAL)");
            aVar.C(typeface);
            aVar.B(15f);
            aVar.D(1f);
            i2 = 10;
            aVar.y(i2);
            aVar.c(a.TOP);
            aVar.e(c.ALIGN_BALLOON);
            int i3 = 2131231078;
            aVar.b(a.f(l, i3));
            aVar.k(12f);
            aVar.v(i2);
            int i14 = 12;
            aVar.x(i14);
            aVar.w(i14);
            aVar.f(32);
            aVar.g(24);
            int i17 = 44;
            aVar.s(i17);
            aVar.t(i17);
            aVar.j(f.OVERSHOOT);
            aVar.r(aVar.u0);
            Balloon balloon = aVar.a();
            this.N = balloon;
            if (balloon != null) {
                balloon.x0(this, i12, i12);
            }
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public m.a.c.a getKoin() {
        return org.koin.core.component.a.a.a(this);
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
        if (this.N != null) {
            this.N.J();
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setOnClickListener(View.OnClickListener list) {
        this.balloon.onClick(list);
    }


    public static /* synthetic */ void n(ClickerSoundMaterialButton clickerSoundMaterialButton, Context context, View view) {
        ClickerSoundMaterialButton.m(clickerSoundMaterialButton, context, view);
    }
}
