package app.dogo.com.dogo_android.profile.invitation;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class a implements y {

    public final app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity a;
    public a(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
        super();
        this.a = dogInviteAcceptanceActivity;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        DogInviteAcceptanceActivity.o(this.a, (Boolean)object);
    }
}
