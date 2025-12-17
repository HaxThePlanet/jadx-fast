package app.dogo.com.dogo_android.profile.invitation;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class d implements y {

    public final app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity a;
    public d(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
        super();
        this.a = dogInviteAcceptanceActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        DogInviteAcceptanceActivity.r(this.a, (y)object);
    }
}
