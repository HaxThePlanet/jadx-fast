package app.dogo.com.dogo_android.d.d.r;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.s.b.b1;
import app.dogo.com.dogo_android.s.b.b1.a;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0016\u001a\u00020\u0007H\u0007J\u0008\u0010\u0017\u001a\u00020\u0018H\u0007J\u0008\u0010\u0019\u001a\u00020\u0018H\u0007J\u0008\u0010\u001a\u001a\u00020\u0018H\u0007J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J,\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u00078G¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00078G¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "badgeList", "", "", "dogAvatar", "getDogAvatar", "()Ljava/lang/String;", "dogName", "getDogName", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "participantCount", "", "participationString", "Landroid/text/SpannableStringBuilder;", "getParticipationString", "()Landroid/text/SpannableStringBuilder;", "totalVoteCount", "getTotalVoteCount", "isAdminBadgeVisible", "", "isAmbassadorBadgeVisible", "isPremiumBadgeVisible", "notifyModelChange", "", "setModel", "model", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends o {

    private final Resources a;
    private LiteDogProfile b;
    private int c;
    private int v;
    private List<String> w;
    public h() {
        final int i = 0;
        super(i, 1, i);
    }

    public h(Resources resources) {
        n.f(resources, "resources");
        super();
        this.a = resources;
        ArrayList obj2 = new ArrayList();
        this.w = obj2;
    }

    public h(Resources resources, int i2, g g3) {
        Resources obj1;
        int obj2;
        if (i2 &= 1 != 0) {
            n.e(App.Companion.b().getResources(), "App.appContext.resources");
        }
        super(obj1);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final SpannableStringBuilder a() {
        String string = this.a.getString(2131886331);
        n.e(string, "resources.getString(R.string.challenges_number_of_dog_entries_title)");
        final int i8 = 0;
        final int i11 = 0;
        int i2 = l.e0(string, "%s", 0, i8, 6, i11);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(l.G(string, "%s", String.valueOf(this.c), i8, 4, i11));
        StyleSpan styleSpan = new StyleSpan(1);
        spannableStringBuilder.setSpan(styleSpan, i2, length + i2, 33);
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String b() {
        return String.valueOf(this.v);
    }

    public final void c(LiteDogProfile liteDogProfile, int i2, int i3, List<String> list4) {
        n.f(liteDogProfile, "model");
        n.f(list4, "badgeList");
        this.b = liteDogProfile;
        this.c = i2;
        this.v = i3;
        this.w = list4;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getDogAvatar() {
        LiteDogProfile liteDogProfile = this.b;
        if (liteDogProfile == null) {
        } else {
            return liteDogProfile.getAvatar();
        }
        n.w("dogProfile");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getDogName() {
        LiteDogProfile liteDogProfile = this.b;
        if (liteDogProfile == null) {
        } else {
            return liteDogProfile.getName();
        }
        n.w("dogProfile");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isAdminBadgeVisible() {
        Object next;
        boolean contains;
        Set set;
        Iterator iterator = this.w.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        return n.b(next, "admin");
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isAmbassadorBadgeVisible() {
        Object next;
        boolean contains;
        Set set;
        Iterator iterator = this.w.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        return n.b(next, "ambassador");
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isPremiumBadgeVisible() {
        Object next;
        boolean contains;
        Set set;
        Iterator iterator = this.w.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        return n.b(next, "premium");
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void notifyModelChange() {
        notifyChangeAll();
    }
}
