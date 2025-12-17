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
import com.google.android.gms.tasks.j;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u008b\u0001\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u001a\u0010/\u001a\u0002002\u0008\u00101\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020)H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u001cH\u0017J\u0008\u00104\u001a\u00020\u001cH\u0016J\n\u00105\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c072\u0006\u00108\u001a\u00020\u001cH\u0002J\u0008\u00109\u001a\u00020\u001cH\u0017J\u0008\u0010:\u001a\u00020)H\u0017J\u0008\u0010;\u001a\u00020)H\u0017J\u0008\u0010<\u001a\u00020)H\u0017J\u0008\u0010=\u001a\u000200H\u0002J\u0008\u0010>\u001a\u000200H\u0016J\"\u0010?\u001a\u0002002\u0008\u0010@\u001a\u0004\u0018\u00010A2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010B\u001a\u00020)J\u0010\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u001eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u0011\u0010(\u001a\u00020)8G¢\u0006\u0006\u001a\u0004\u0008(\u0010*R\u001b\u0010+\u001a\u00020)8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008,\u0010-\u001a\u0004\u0008+\u0010*R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionObservable;", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryPhotoBaseObservable;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "resources", "Landroid/content/res/Resources;", "content", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/DynamicLinkService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;)V", "challengeId", "", "getChallengeId", "()Ljava/lang/String;", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeName", "getChallengeName", "deviceLanguage", "formattedComment", "Landroid/text/SpannableStringBuilder;", "getFormattedComment", "()Landroid/text/SpannableStringBuilder;", "isCaptionValid", "", "()Z", "isReportVisible", "isReportVisible$delegate", "Lkotlin/Lazy;", "spinnerVisible", "applyTranslateChanges", "", "caption", "state", "getCaption", "getDeviceLanguage", "getEntryId", "getEntryTranslationListener", "Lcom/google/android/gms/tasks/OnCompleteListener;", "entryId", "getTranslationButtonString", "isBorderVisible", "isSpinnerVisible", "isTranslateButtonVisible", "notifyModelChange", "onTranslateButtonPress", "setModel", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "isPremium", "setSpinnerVisibility", "visibilityState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends EntryPhotoBaseObservable {

    private String A;
    private final h B;
    private final m2 a;
    private final h2 b;
    private final Resources c;
    private final v2 v;
    private final p2 w;
    private final i2 x;
    private ChallengeModel y;
    private boolean z;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<Boolean> {

        final app.dogo.com.dogo_android.d.b.z.j this$0;
        a(app.dogo.com.dogo_android.d.b.z.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            ChallengeEntryModel authorAdmin;
            int i;
            authorAdmin = this.this$0.getModel();
            i = 0;
            if (authorAdmin == null) {
            } else {
                if (!authorAdmin.isAuthorAdmin()) {
                    i = 1;
                }
            }
            return i;
        }
    }
    static {
    }

    public j() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
    }

    public j(m2 m2, h2 h22, Resources resources3, a1 a14, o3 o35, q2 q26, u2 u27, v2 v28, t2 t29, k2 k210, p2 p211, i2 i212) {
        final Object obj6 = this;
        final Object obj7 = m2;
        final Object obj8 = h22;
        n.f(obj7, "firestoreService");
        n.f(obj8, "authService");
        n.f(resources3, "resources");
        n.f(v28, "utilities");
        n.f(p211, "preferenceService");
        n.f(i212, "cloudFunctionsService");
        super(m2, h22, o35, q26, u27, v28, resources3, a14, t29, k210, p211, i212);
        obj6.a = obj7;
        obj6.b = obj8;
        obj6.c = resources3;
        obj6.v = v28;
        obj6.w = p211;
        obj6.x = i212;
        j.a aVar = new j.a(obj6);
        obj6.B = j.b(aVar);
        obj6.A = p211.W();
    }

    public j(m2 m2, h2 h22, Resources resources3, a1 a14, o3 o35, q2 q26, u2 u27, v2 v28, t2 t29, k2 k210, p2 p211, i2 i212, int i13, g g14) {
        i2 i2Var;
        m2 m2Var;
        h2 h2Var;
        Resources resources;
        String str;
        a1 a1Var;
        o3 o3Var;
        q2 q2Var;
        u2 u2Var;
        v2 v2Var;
        t2 t2Var;
        k2 k2Var;
        p2 p2Var;
        int i = i13;
        if (i & 1 != 0) {
            m2Var = App.Companion.j();
        } else {
            m2Var = m2;
        }
        if (i & 2 != 0) {
            h2Var = App.Companion.c();
        } else {
            h2Var = h22;
        }
        if (i & 4 != 0) {
            n.e(App.Companion.b().getResources(), "appContext.resources");
        } else {
            resources = resources3;
        }
        if (i & 8 != 0) {
            a1Var = App.Companion.f();
        } else {
            a1Var = a14;
        }
        if (i & 16 != 0) {
            o3Var = App.Companion.r();
        } else {
            o3Var = o35;
        }
        if (i & 32 != 0) {
            q2Var = App.Companion.m();
        } else {
            q2Var = q26;
        }
        if (i & 64 != 0) {
            u2Var = App.Companion.h();
        } else {
            u2Var = u27;
        }
        if (i & 128 != 0) {
            v2Var = App.Companion.t();
        } else {
            v2Var = v28;
        }
        if (i & 256 != 0) {
            t2Var = App.Companion.p();
        } else {
            t2Var = t29;
        }
        if (i & 512 != 0) {
            k2Var = App.Companion.g();
        } else {
            k2Var = k210;
        }
        if (i & 1024 != 0) {
            p2Var = App.Companion.l();
        } else {
            p2Var = p211;
        }
        if (i &= 2048 != 0) {
            i2Var = App.Companion.d();
        } else {
            i2Var = i212;
        }
        super(m2Var, h2Var, resources, a1Var, o3Var, q2Var, u2Var, v2Var, t2Var, k2Var, p2Var, i2Var);
    }

    private final e<String> getEntryTranslationListener(String string) {
        d dVar = new d(string, this);
        return dVar;
    }

    private static final void h(String string, app.dogo.com.dogo_android.d.b.z.j j2, j j3) {
        boolean cVar;
        int locale;
        String deviceLanguage;
        boolean z;
        Object obj4;
        Object obj5;
        Object obj6;
        n.f(string, "$entryId");
        n.f(j2, "this$0");
        n.f(j3, "task");
        if (n.b(string, j2.getModel().getDocumentId())) {
            obj6 = j3.getResult();
            locale = 0;
            if ((String)obj6 != null) {
                j2.getModel().setEntryTranslations(j2.getDeviceLanguage(), (String)obj6);
                j2.setSpinnerVisibility(locale);
                j2.applyTranslateChanges(obj6, true);
            } else {
                deviceLanguage = j2.getCaption();
                if (deviceLanguage != null) {
                    if (l.z(deviceLanguage)) {
                    } else {
                        cVar = locale;
                    }
                }
                if (cVar == 0) {
                    cVar = new c(string, j2);
                    j2.x.m(deviceLanguage, j2.getModel().getLocale(), j2.w.W(), f.entryTranslations.forEntryId(j2.getModel().getDocumentId()).forLocale(j2.getDeviceLanguage()).getPath()).addOnCompleteListener(cVar);
                } else {
                    a.c("Caption text is null or blank, no translation needed", new Object[locale]);
                }
            }
        }
    }

    private static final void i(String string, app.dogo.com.dogo_android.d.b.z.j j2, j j3) {
        boolean documentId;
        Object obj1;
        Object obj3;
        n.f(string, "$entryId");
        n.f(j2, "this$0");
        n.f(j3, "task1");
        if (j3.isSuccessful() && n.b(string, j2.getModel().getDocumentId())) {
            if (n.b(string, j2.getModel().getDocumentId())) {
                j2.setSpinnerVisibility(false);
                j2.applyTranslateChanges((String)j3.getResult(), true);
            }
        }
    }

    public static void m(String string, app.dogo.com.dogo_android.d.b.z.j j2, j j3) {
        j.i(string, j2, j3);
    }

    public static void n(String string, app.dogo.com.dogo_android.d.b.z.j j2, j j3) {
        j.h(string, j2, j3);
    }

    private final void o() {
        notifyChangeAll();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void applyTranslateChanges(String string, boolean z2) {
        getModel().setTranslatedCaption(string);
        notifyChange(30);
        notifyChange(73);
        notifyChange(165);
        getModel().setTranslatePressed(z2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final String g() {
        String str;
        ChallengeModel challengeModel = this.y;
        if (challengeModel == null) {
            return "";
        }
        n.d(challengeModel);
        String name = challengeModel.getName();
        if (name == null) {
        } else {
            str = name;
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getCaption() {
        String translatedCaption;
        int translatedCaption2;
        int i;
        if (getModel().getTranslatedCaption() != null && getModel().isTranslatePressed()) {
            if (getModel().isTranslatePressed()) {
                translatedCaption2 = getModel().getTranslatedCaption();
            } else {
                translatedCaption2 = getModel().getComment();
                if (translatedCaption2 != null) {
                    i = translatedCaption2.length() > 0 ? 1 : 0;
                    if (i != 0) {
                    } else {
                        translatedCaption2 = 0;
                    }
                } else {
                }
            }
        } else {
        }
        return translatedCaption2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getDeviceLanguage() {
        String language = Locale.forLanguageTag(this.A).getLanguage();
        n.e(language, "it");
        this.A = language;
        n.e(language, "forLanguageTag(deviceLanguage).language.also { deviceLanguage = it }");
        return language;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getEntryId() {
        String documentId;
        if (getModel() != null) {
            documentId = getModel().getDocumentId();
        } else {
            documentId = 0;
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public String getTranslationButtonString() {
        String string;
        String str;
        if (getModel().isTranslatePressed()) {
            n.e(this.c.getString(2131886320), "{\n            resources.getString(R.string.challenge_show_original)\n        }");
        } else {
            n.e(this.c.getString(2131886326), "{\n            resources.getString(R.string.challenge_translate)\n        }");
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
        String caption;
        int i;
        boolean z;
        String locale;
        caption = getCaption();
        if (!n.b(n2.d(this.w.W()), getModel().getLocale()) && caption != null && !n.b(getModel().getAuthor(), this.b.v()) && !this.v.n(caption)) {
            if (caption != null) {
                if (!n.b(getModel().getAuthor(), this.b.v())) {
                    i = !this.v.n(caption) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final SpannableStringBuilder j() {
        String dogName;
        int length;
        String str;
        SpannableStringBuilder spannableStringBuilder;
        StyleSpan styleSpan;
        int i;
        int i2;
        if (getModel() != null) {
            if (getModel().getDogName() == null) {
                n.e(this.c.getString(2131886675), "resources.getString(R.string.general_anonymous)");
            }
            String str2 = n.o(dogName, "  ");
            spannableStringBuilder = new SpannableStringBuilder(n.o(str2, getCaption()));
            styleSpan = new StyleSpan(1);
            spannableStringBuilder.setSpan(styleSpan, 0, str2.length(), 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder("");
        }
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean k() {
        String comment;
        int i;
        comment = getModel().getComment();
        final int i2 = 0;
        if (getModel() != null && comment != null) {
            if (comment != null) {
                comment = comment.length() > 0 ? i : i2;
                if (comment != 0) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final boolean l() {
        return (Boolean)this.B.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void onTranslateButtonPress() {
        Object entryTranslationListener;
        j translatePressed;
        m2 deviceLanguage2;
        boolean key;
        String deviceLanguage;
        deviceLanguage2 = 0;
        if (!getModel().isTranslatePressed()) {
            translatePressed = 1;
            setSpinnerVisibility(translatePressed);
            if (getModel().getEntryTranslations().containsKey(getDeviceLanguage())) {
                setSpinnerVisibility(deviceLanguage2);
                applyTranslateChanges((String)getModel().getEntryTranslations().get(getDeviceLanguage()), translatePressed);
            } else {
                this.a.w(f.entryTranslations.forEntryId(getModel().getDocumentId()).forLocale(getDeviceLanguage())).addOnCompleteListener(getEntryTranslationListener(getModel().getDocumentId()));
            }
        } else {
            applyTranslateChanges(getCaption(), deviceLanguage2);
        }
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public final void p(ChallengeEntryModel challengeEntryModel, ChallengeModel challengeModel2, boolean z3) {
        super.setModel(challengeEntryModel, z3);
        this.y = challengeModel2;
        o();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable
    public void setSpinnerVisibility(boolean z) {
        this.z = z;
        notifyChange(147);
    }
}
