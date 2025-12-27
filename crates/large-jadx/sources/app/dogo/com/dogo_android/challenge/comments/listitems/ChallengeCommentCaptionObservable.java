package app.dogo.com.dogo_android.d.b.z;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.w.o3;
import com.google.android.gms.tasks.e;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.k0.l;

/* compiled from: ChallengeCommentCaptionObservable.kt */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u008b\u0001\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u001a\u0010/\u001a\u0002002\u0008\u00101\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020)H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u001cH\u0017J\u0008\u00104\u001a\u00020\u001cH\u0016J\n\u00105\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c072\u0006\u00108\u001a\u00020\u001cH\u0002J\u0008\u00109\u001a\u00020\u001cH\u0017J\u0008\u0010:\u001a\u00020)H\u0017J\u0008\u0010;\u001a\u00020)H\u0017J\u0008\u0010<\u001a\u00020)H\u0017J\u0008\u0010=\u001a\u000200H\u0002J\u0008\u0010>\u001a\u000200H\u0016J\"\u0010?\u001a\u0002002\u0008\u0010@\u001a\u0004\u0018\u00010A2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010B\u001a\u00020)J\u0010\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u001eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u0011\u0010(\u001a\u00020)8G¢\u0006\u0006\u001a\u0004\u0008(\u0010*R\u001b\u0010+\u001a\u00020)8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008,\u0010-\u001a\u0004\u0008+\u0010*R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionObservable;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryPhotoBaseObservable;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "resources", "Landroid/content/res/Resources;", "content", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/DynamicLinkService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;)V", "challengeId", "", "getChallengeId", "()Ljava/lang/String;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeName", "getChallengeName", "deviceLanguage", "formattedComment", "Landroid/text/SpannableStringBuilder;", "getFormattedComment", "()Landroid/text/SpannableStringBuilder;", "isCaptionValid", "", "()Z", "isReportVisible", "isReportVisible$delegate", "Lkotlin/Lazy;", "spinnerVisible", "applyTranslateChanges", "", "caption", "state", "getCaption", "getDeviceLanguage", "getEntryId", "getEntryTranslationListener", "Lcom/google/android/gms/tasks/OnCompleteListener;", "entryId", "getTranslationButtonString", "isBorderVisible", "isSpinnerVisible", "isTranslateButtonVisible", "notifyModelChange", "onTranslateButtonPress", "setModel", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "isPremium", "setSpinnerVisibility", "visibilityState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class ChallengeCommentCaptionObservable extends EntryPhotoBaseObservable {

    /* renamed from: A, reason: from kotlin metadata */
    private String authService;
    private final h B;
    /* renamed from: a, reason: from kotlin metadata */
    private final m2 challengeModel;
    private final h2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final Resources cloudFunctionsService;
    /* renamed from: v, reason: from kotlin metadata */
    private final v2 deviceLanguage;
    /* renamed from: w, reason: from kotlin metadata */
    private final p2 firestoreService;
    private final i2 x;
    private ChallengeModel y;
    private boolean z;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<Boolean> {
        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            boolean z = false;
            ChallengeEntryModel model = j.this.getModel();
            int i = 0;
            if (model != null) {
                if (!model.isAuthorAdmin()) {
                    int i2 = 1;
                }
            }
            return z;
        }

        a() {
            super(0);
        }
    }
    public /* synthetic */ j(m2 m2Var, h2 h2Var, Resources resources, a1 a1Var, o3 o3Var, q2 q2Var, u2 u2Var, v2 v2Var, t2 t2Var, k2 k2Var, p2 p2Var, i2 i2Var, int i, g gVar) {
        i2 i2Var122;
        m2 m2Var2;
        h2 h2Var22;
        Resources resources32;
        a1 a1Var42;
        o3 o3Var52;
        q2 q2Var62;
        u2 u2Var72;
        v2 v2Var82;
        t2 t2Var92;
        k2 k2Var102;
        p2 p2Var112;
        int i132 = i;
        if (i132 & 1 != 0) {
            m2Var2 = App.INSTANCE.j();
        } else {
            m2Var2 = m2Var;
        }
        if (i132 & 2 != 0) {
            h2Var22 = App.INSTANCE.c();
        } else {
            h2Var22 = h2Var;
        }
        if (i132 & 4 != 0) {
            str = "appContext.resources";
            n.e(App.INSTANCE.b().getResources(), str);
        } else {
            resources32 = resources;
        }
        if (i132 & 8 != 0) {
            a1Var42 = App.INSTANCE.f();
        } else {
            a1Var42 = a1Var;
        }
        if (i132 & 16 != 0) {
            o3Var52 = App.INSTANCE.r();
        } else {
            o3Var52 = o3Var;
        }
        if (i132 & 32 != 0) {
            q2Var62 = App.INSTANCE.m();
        } else {
            q2Var62 = q2Var;
        }
        if (i132 & 64 != 0) {
            u2Var72 = App.INSTANCE.h();
        } else {
            u2Var72 = u2Var;
        }
        if (i132 & 128 != 0) {
            v2Var82 = App.INSTANCE.t();
        } else {
            v2Var82 = v2Var;
        }
        if (i132 & 256 != 0) {
            t2Var92 = App.INSTANCE.p();
        } else {
            t2Var92 = t2Var;
        }
        if (i132 & 512 != 0) {
            k2Var102 = App.INSTANCE.g();
        } else {
            k2Var102 = k2Var;
        }
        if (i132 & 1024 != 0) {
            p2Var112 = App.INSTANCE.l();
        } else {
            p2Var112 = p2Var;
        }
        if (i132 & 2048 != 0) {
            i2Var122 = App.INSTANCE.d();
        } else {
            i2Var122 = i2Var;
        }
        this(m2Var2, h2Var22, resources32, a1Var42, o3Var52, q2Var62, u2Var72, v2Var82, t2Var92, k2Var102, p2Var112, i2Var122);
    }

    private final e<String> getEntryTranslationListener(String entryId) {
        return new app.dogo.com.dogo_android.challenge.comments.listitems.d(entryId, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    private static final void setModel(String model, j challengeModel, com.google.android.gms.tasks.j isPremium) {
        boolean z = true;
        boolean z2;
        n.f(model, "$entryId");
        n.f(challengeModel, "this$0");
        n.f(isPremium, "task");
        if (n.b(model, challengeModel.getModel().getDocumentId())) {
            Object result = isPremium.getResult();
            z = true;
            z = false;
            if (result != null) {
                challengeModel.getModel().setEntryTranslations(challengeModel.getDeviceLanguage(), result);
                challengeModel.setSpinnerVisibility(z);
                challengeModel.applyTranslateChanges(result, true);
            } else {
                String deviceLanguage = challengeModel.getCaption();
                if (deviceLanguage != null) {
                    if (!(l.z(deviceLanguage))) {
                    }
                }
                if (!z) {
                    challengeModel.x.m(deviceLanguage, challengeModel.getModel().getLocale(), challengeModel.firestoreService.W(), FirestorePath.entryTranslations.forEntryId(challengeModel.getModel().getDocumentId()).forLocale(challengeModel.getDeviceLanguage()).getPath()).addOnCompleteListener(new app.dogo.com.dogo_android.challenge.comments.listitems.c(model, challengeModel));
                } else {
                    str = "Caption text is null or blank, no translation needed";
                    a.c(str, new Object[z]);
                }
            }
        }
    }

    private static final void i(String str, j jVar, com.google.android.gms.tasks.j jVar2) {
        n.f(str, "$entryId");
        n.f(jVar, "this$0");
        n.f(jVar2, "task1");
        if (jVar2.isSuccessful()) {
            if (n.b(str, jVar.getModel().getDocumentId())) {
                jVar.setSpinnerVisibility(false);
                boolean z2 = true;
                jVar.applyTranslateChanges((String)jVar2.getResult(), z2);
            }
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final void getCaption() {
        notifyChangeAll();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void applyTranslateChanges(String caption, boolean state) {
        getModel().setTranslatedCaption(caption);
        notifyChange(30);
        notifyChange(73);
        notifyChange(165);
        getModel().setTranslatePressed(state);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String g() {
        String name;
        name = "";
        if (this.y == null) {
            return "";
        }
        n.d(this.y);
        name = this.y.getName();
        if (name != null) {
        }
        return name;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getCaption() {
        int i = 0;
        int i2;
        if (getModel().getTranslatedCaption() != null) {
            if (getModel().isTranslatePressed()) {
                String translatedCaption2 = getModel().getTranslatedCaption();
            } else {
                String comment = getModel().getComment();
                if (comment != null) {
                    int r1 = comment.length() > 0 ? 1 : 0;
                    if (i2 == 0) {
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getDeviceLanguage() {
        String language = Locale.forLanguageTag(this.authService).getLanguage();
        n.e(language, "it");
        this.authService = language;
        n.e(language, "forLanguageTag(deviceLanguage).language.also { deviceLanguage = it }");
        return language;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getEntryId() {
        String documentId = null;
        if (getModel() != null) {
            documentId = getModel().getDocumentId();
        } else {
            int i = 0;
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getTranslationButtonString() throws android.content.res.Resources.NotFoundException {
        String string;
        if (getModel().isTranslatePressed()) {
            str = "{\n            resources.getString(R.string.challenge_show_original)\n        }";
            n.e(this.cloudFunctionsService.getString(2131886320), str);
        } else {
            str = "{\n            resources.getString(R.string.challenge_translate)\n        }";
            n.e(this.cloudFunctionsService.getString(2131886326), str);
        }
        return string;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isBorderVisible() {
        return isCurrentUserEntriesAuthor();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isSpinnerVisible() {
        return this.z;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public boolean isTranslateButtonVisible() {
        boolean z2 = true;
        boolean z;
        String locale;
        String caption = getCaption();
        if (!n.b(LocaleService.getLocale(this.firestoreService.W()), getModel().getLocale()) && caption != null) {
            if (!n.b(getModel().getAuthor(), this.b.v())) {
                int r0 = !this.deviceLanguage.isPackageInstalled(caption) ? 1 : 0;
            }
        }
        return (!this.deviceLanguage.isPackageInstalled(caption) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final SpannableStringBuilder j() throws android.content.res.Resources.NotFoundException {
        String dogName;
        SpannableStringBuilder spannableStringBuilder;
        if (getModel() != null) {
            if (getModel().getDogName() == null) {
                str = "resources.getString(R.string.general_anonymous)";
                n.e(this.cloudFunctionsService.getString(2131886675), str);
            }
            String str2 = n.o(dogName, "  ");
            int i = 0;
            int i2 = 33;
            new SpannableStringBuilder(n.o(str2, getCaption())).setSpan(new StyleSpan(1), i, str2.length(), i2);
        } else {
            spannableStringBuilder = new SpannableStringBuilder("");
        }
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean k() {
        String comment;
        int i;
        boolean z = true;
        comment = getModel().getComment();
        i = 0;
        if (getModel() != null && comment != null) {
            int r0 = comment.length() > 0 ? 1 : i;
            if (i == 0) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean l() {
        return (Boolean)this.B.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onTranslateButtonPress() {
        boolean z2 = false;
        if (getModel().isTranslatePressed()) {
            applyTranslateChanges(getCaption(), z2);
        } else {
            boolean z = true;
            setSpinnerVisibility(z);
            if (getModel().getEntryTranslations().containsKey(getDeviceLanguage())) {
                setSpinnerVisibility(z2);
                applyTranslateChanges((String)getModel().getEntryTranslations().get(getDeviceLanguage()), z);
            } else {
                this.challengeModel.w(FirestorePath.entryTranslations.forEntryId(getModel().getDocumentId()).forLocale(getDeviceLanguage())).addOnCompleteListener(getEntryTranslationListener(getModel().getDocumentId()));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final void p(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel, boolean z) {
        super.setModel(challengeEntryModel, z);
        this.y = challengeModel;
        getCaption();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setSpinnerVisibility(boolean visibilityState) {
        this.z = visibilityState;
        notifyChange(147);
    }

    public j(m2 m2Var, h2 h2Var, Resources resources, a1 a1Var, o3 o3Var, q2 q2Var, u2 u2Var, v2 v2Var, t2 t2Var, k2 k2Var, p2 p2Var, i2 i2Var) {
        final Object m2Var4 = this;
        final Object m2Var2 = m2Var;
        final Object h2Var22 = h2Var;
        n.f(m2Var2, "firestoreService");
        n.f(h2Var22, "authService");
        n.f(resources, "resources");
        n.f(v2Var, "utilities");
        n.f(p2Var, "preferenceService");
        n.f(i2Var, "cloudFunctionsService");
        super(m2Var, h2Var, o3Var, q2Var, u2Var, v2Var, resources, a1Var, t2Var, k2Var, p2Var, i2Var);
        m2Var4.challengeModel = m2Var2;
        m2Var4.b = h2Var22;
        m2Var4.cloudFunctionsService = resources;
        m2Var4.deviceLanguage = v2Var;
        m2Var4.firestoreService = p2Var;
        m2Var4.x = i2Var;
        m2Var4.B = j.b(new app.dogo.com.dogo_android.challenge.comments.listitems.j.a(m2Var4));
        m2Var4.authService = p2Var.W();
    }


    public j() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ void m(String str, j jVar, com.google.android.gms.tasks.j jVar2) {
        ChallengeCommentCaptionObservable.i(str, jVar, jVar2);
    }

    public static /* synthetic */ void n(String str, j jVar, com.google.android.gms.tasks.j jVar2) {
        ChallengeCommentCaptionObservable.setModel(str, jVar, jVar2);
    }
}
