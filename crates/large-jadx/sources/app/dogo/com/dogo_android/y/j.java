package app.dogo.com.dogo_android.y;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.m;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH$J\u0008\u0010\u0010\u001a\u00020\u0011H&J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroid/os/Parcelable;", "()V", "fragmentParentReturnTag", "", "getFragmentParentReturnTag", "()Ljava/lang/String;", "fragmentReturnTag", "getFragmentReturnTag", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "getTag", "newFragment", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class j implements Parcelable {

    public static final app.dogo.com.dogo_android.y.j.a Companion = null;
    public static final String SCREEN_KEY = "SCREEN_KEY";
    private final String fragmentParentReturnTag;
    private final String fragmentReturnTag;
    private final Integer statusBarColor;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/AppScreen$Companion;", "", "()V", "SCREEN_KEY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        j.a aVar = new j.a(0);
        j.Companion = aVar;
    }

    public j() {
        super();
        final String str = "";
        this.fragmentReturnTag = str;
        this.fragmentParentReturnTag = str;
    }

    @Override // android.os.Parcelable
    protected abstract Fragment createFragment();

    @Override // android.os.Parcelable
    public abstract i3 createTrackingParameters();

    @Override // android.os.Parcelable
    public String getFragmentParentReturnTag() {
        return this.fragmentParentReturnTag;
    }

    @Override // android.os.Parcelable
    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

    @Override // android.os.Parcelable
    public Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    @Override // android.os.Parcelable
    public String getTag() {
        return createTrackingParameters().a();
    }

    @Override // android.os.Parcelable
    public final Fragment newFragment() {
        Bundle arguments;
        final Fragment fragment = createFragment();
        if (fragment.getArguments() == null) {
            arguments = new Bundle();
        }
        arguments.putParcelable("SCREEN_KEY", this);
        w wVar = w.a;
        fragment.setArguments(arguments);
        return fragment;
    }
}
