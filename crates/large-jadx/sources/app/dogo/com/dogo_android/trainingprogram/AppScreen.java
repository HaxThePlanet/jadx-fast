package app.dogo.com.dogo_android.y;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.m;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.w;

/* compiled from: AppScreen.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH$J\u0008\u0010\u0010\u001a\u00020\u0011H&J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroid/os/Parcelable;", "()V", "fragmentParentReturnTag", "", "getFragmentParentReturnTag", "()Ljava/lang/String;", "fragmentReturnTag", "getFragmentReturnTag", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "getTag", "newFragment", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public abstract class AppScreen implements Parcelable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final j.a INSTANCE = null;
    public static final String SCREEN_KEY = "SCREEN_KEY";
    private final String fragmentParentReturnTag = "";
    private final String fragmentReturnTag = "";
    private final Integer statusBarColor;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/AppScreen$Companion;", "", "()V", "SCREEN_KEY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public j() {
        super();
    }

    public String getFragmentParentReturnTag() {
        return this.fragmentParentReturnTag;
    }

    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

    public Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    public String getTag() {
        return createTrackingParameters().a();
    }

    public final Fragment newFragment() {
        Bundle arguments;
        final Fragment fragment = createFragment();
        if (fragment.getArguments() == null) {
            arguments = new Bundle();
        }
        arguments.putParcelable("SCREEN_KEY", this);
        fragment.setArguments(arguments);
        return fragment;
    }

    static {
        AppScreen.INSTANCE = new AppScreen_Companion(null);
    }

    protected abstract Fragment createFragment();

    public abstract i3 createTrackingParameters();
}
