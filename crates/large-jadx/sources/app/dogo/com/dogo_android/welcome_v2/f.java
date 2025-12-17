package app.dogo.com.dogo_android.welcome_v2;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class f implements y {

    public final app.dogo.com.dogo_android.welcome_v2.OnboardingActivity a;
    public f(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity) {
        super();
        this.a = onboardingActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        OnboardingActivity.m(this.a, (y)object);
    }
}
