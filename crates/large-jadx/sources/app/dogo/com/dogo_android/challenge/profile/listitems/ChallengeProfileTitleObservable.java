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

/* compiled from: ChallengeProfileTitleObservable.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0016\u001a\u00020\u0007H\u0007J\u0008\u0010\u0017\u001a\u00020\u0018H\u0007J\u0008\u0010\u0019\u001a\u00020\u0018H\u0007J\u0008\u0010\u001a\u001a\u00020\u0018H\u0007J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J,\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u00078G¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00078G¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/listitems/ChallengeProfileTitleObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "badgeList", "", "", "dogAvatar", "getDogAvatar", "()Ljava/lang/String;", "dogName", "getDogName", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "participantCount", "", "participationString", "Landroid/text/SpannableStringBuilder;", "getParticipationString", "()Landroid/text/SpannableStringBuilder;", "totalVoteCount", "getTotalVoteCount", "isAdminBadgeVisible", "", "isAmbassadorBadgeVisible", "isPremiumBadgeVisible", "notifyModelChange", "", "setModel", "model", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class ChallengeProfileTitleObservable extends o {

    /* renamed from: a, reason: from kotlin metadata */
    private final Resources badgeList;
    private LiteDogProfile b;
    private int c;
    /* renamed from: v, reason: from kotlin metadata */
    private int dogProfile;
    /* renamed from: w, reason: from kotlin metadata */
    private List<String> participantCount;
    public /* synthetic */ h(Resources resources, int i, g gVar) {
        Resources resources2;
        i = i & 1;
        if (i & 1 != 0) {
            n.e(App.INSTANCE.b().getResources(), "App.appContext.resources");
        }
        this(resources2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: a, reason: from kotlin metadata */
    public final SpannableStringBuilder getTotalVoteCount() throws android.content.res.Resources.NotFoundException {
        String string = this.badgeList.getString(2131886331);
        n.e(string, "resources.getString(R.string.challenges_number_of_dog_entries_title)");
        final boolean z = false;
        final Object obj2 = null;
        int i2 = l.e0(string, "%s", 0, z, 6, obj2);
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(l.G(string, "%s", String.valueOf(this.c), z, 4, obj2));
        spannableStringBuilder.setSpan(new StyleSpan(1), i2, String.valueOf(this.c).length() + i2, 33);
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String b() {
        return String.valueOf(this.dogProfile);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: c, reason: from kotlin metadata */
    public final void setModel(LiteDogProfile model, int participantCount, int totalVoteCount, List<String> badgeList) {
        n.f(model, "model");
        n.f(badgeList, "badgeList");
        this.b = model;
        this.c = participantCount;
        this.dogProfile = totalVoteCount;
        this.participantCount = badgeList;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getDogAvatar() {
        if (this.b == null) {
            n.w("dogProfile");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.b.getAvatar();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getDogName() {
        if (this.b == null) {
            n.w("dogProfile");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.b.getName();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isAdminBadgeVisible() {
        Object item = null;
        boolean contains;
        Set set;
        Iterator it = this.participantCount.iterator();
        while (it.hasNext()) {
            if (ChallengeRepository.INSTANCE.a().contains((String)item)) {
                break;
            }
        }
        int i = 0;
        return n.b(item, "admin");
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isAmbassadorBadgeVisible() {
        Object item = null;
        boolean contains;
        Set set;
        Iterator it = this.participantCount.iterator();
        while (it.hasNext()) {
            if (ChallengeRepository.INSTANCE.a().contains((String)item)) {
                break;
            }
        }
        int i = 0;
        return n.b(item, "ambassador");
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isPremiumBadgeVisible() {
        Object item = null;
        boolean contains;
        Set set;
        Iterator it = this.participantCount.iterator();
        while (it.hasNext()) {
            if (ChallengeRepository.INSTANCE.a().contains((String)item)) {
                break;
            }
        }
        int i = 0;
        return n.b(item, "premium");
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void notifyModelChange() {
        notifyChangeAll();
    }

    public h(Resources resources) {
        n.f(resources, "resources");
        super();
        this.badgeList = resources;
        this.participantCount = new ArrayList();
    }

    public h() {
        final Resources resources = null;
        this(resources, 1, resources);
    }
}
