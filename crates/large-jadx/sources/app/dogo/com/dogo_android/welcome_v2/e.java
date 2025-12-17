package app.dogo.com.dogo_android.welcome_v2;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class e implements y {

    public final app.dogo.com.dogo_android.welcome_v2.OnboardingActivity a;
    public e(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity) {
        super();
        this.a = onboardingActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        OnboardingActivity.l(this.a, (y)object);
    }
}
