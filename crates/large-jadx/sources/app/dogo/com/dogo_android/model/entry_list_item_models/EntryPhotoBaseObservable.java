package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.databinding.h.a;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.a1;
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
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.o3;
import com.google.android.gms.tasks.e;
import com.google.firebase.Timestamp;
import i.b.j0.a;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.w;

/* compiled from: EntryPhotoBaseObservable.java */
/* loaded from: classes.dex */
public class EntryPhotoBaseObservable implements app.dogo.com.dogo_android.util.k0.c {

    private h2 authService;
    private i2 cloudFunctionsService;
    private a1 content;
    private String deviceLanguage;
    protected a disposable = new a();
    private k2 dynamicLinkService;
    private app.dogo.com.dogo_android.util.f entryLayoutHelper;
    private m2 firestoreService;
    private boolean isPremium;
    private ChallengeEntryModel model;
    private int pagePosition;
    private p2 preferenceService;
    private final androidx.databinding.j registry = new j();
    private Resources resources;
    private boolean spinnerVisible = false;
    private t2 storageService;
    private o3 tracker;
    private String userEntryId;
    private u2 userLocalCacheService;
    private v2 utilities;
    public EntryPhotoBaseObservable(m2 m2Var, h2 h2Var, o3 o3Var, q2 q2Var, u2 u2Var, v2 v2Var, Resources resources, a1 a1Var, t2 t2Var, k2 k2Var, p2 p2Var, i2 i2Var) {
        super();
        androidx.databinding.j jVar = new j();
        a aVar = new a();
        this.firestoreService = m2Var;
        this.authService = h2Var;
        this.tracker = o3Var;
        this.utilities = v2Var;
        this.userLocalCacheService = u2Var;
        this.resources = resources;
        this.storageService = t2Var;
        this.content = a1Var;
        this.dynamicLinkService = k2Var;
        this.preferenceService = p2Var;
        this.cloudFunctionsService = i2Var;
        this.deviceLanguage = p2Var.W();
        super(this, m2Var, q2Var, o3Var, h2Var);
        this.entryLayoutHelper = u2Var52;
    }

    private /* synthetic */ void a(String str, com.google.android.gms.tasks.j jVar) {
        if (jVar.isSuccessful()) {
            if (str.equals(this.model.getDocumentId())) {
                setSpinnerVisibility(false);
                boolean z = true;
                applyTranslateChanges((String)jVar.getResult(), z);
            }
        }
    }

    static /* synthetic */ String access$000(EntryPhotoBaseObservable entryPhotoBaseObservable) {
        return entryPhotoBaseObservable.userEntryId;
    }

    static /* synthetic */ String access$100(EntryPhotoBaseObservable entryPhotoBaseObservable) {
        return entryPhotoBaseObservable.getAppInstallationId();
    }

    private /* synthetic */ void c(String str, com.google.android.gms.tasks.j jVar) {
        if (str.equals(this.model.getDocumentId())) {
            Object result = jVar.getResult();
            if (result != null) {
                this.model.setEntryTranslations(getDeviceLanguage(), result);
                setSpinnerVisibility(false);
                boolean z = true;
                applyTranslateChanges(result, z);
            } else {
                this.cloudFunctionsService.m(getCaption(), this.model.getLocale(), this.preferenceService.W(), FirestorePath.entryTranslations.forEntryId(this.model.getDocumentId()).forLocale(getDeviceLanguage()).getPath()).addOnCompleteListener(new h(this, str));
            }
        }
    }

    private /* synthetic */ w e(ChallengeEntryModel challengeEntryModel, DogProfileModel dogProfileModel) {
        if (dogProfileModel != null) {
            if (challengeEntryModel.getDogId().equals(dogProfileModel.getId()) != null) {
                challengeEntryModel.setDogProfile(dogProfileModel);
                boolean equals = true;
                challengeEntryModel.setDogFetchFlag(equals);
                challengeEntryModel.setDogName(dogProfileModel.getName());
                updateEntryView();
            }
        }
        return null;
    }

    private String getAppInstallationId() {
        return this.preferenceService.h();
    }

    private e<String> getEntryTranslationListener(String str) {
        return new i(this, str);
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.registry.a(aVar);
    }

    public void applyTranslateChanges(String str, boolean z) {
        this.model.setTranslatedCaption(str);
        notifyChange(30);
        notifyChange(165);
        this.model.setTranslatePressed(z);
    }

    public boolean canUserComment() {
        boolean z = true;
        int r0 = this.userLocalCacheService.A().g().toModel(this.authService.v()).getName() != null ? 1 : 0;
        return (this.userLocalCacheService.A().g().toModel(this.authService.v()).getName() != null ? 1 : 0);
    }

    public String getCaption() {
        if (this.model.getTranslatedCaption() != null && this.model.isTranslatePressed()) {
            return this.model.getTranslatedCaption();
        }
        if (this.model != null && this.model.getComment() != null) {
            if (!this.model.getComment().isEmpty()) {
                return this.model.getComment();
            }
        }
        return null;
    }

    public int getCommentCount() {
        int commentCount = 0;
        if (this.model != null) {
            commentCount = this.model.getCommentCount();
        } else {
            commentCount = 0;
        }
        return commentCount;
    }

    public String getCreationDate() {
        final int i = 0;
        if (this.model.getDate() != null) {
            return this.utilities.i(this.model.getDate().getSeconds() * 1000L, false);
        }
        return this.utilities.i(this.utilities.g(), false);
    }

    public String getCurrentDogId() {
        return this.userLocalCacheService.A().f();
    }

    public String getDeviceLanguage() {
        String language = Locale.forLanguageTag(this.deviceLanguage).getLanguage();
        this.deviceLanguage = language;
        return language;
    }

    public String getDogAvatar() {
        int i = 0;
        return "";
    }

    public int getDogCount() {
        return this.userLocalCacheService.A().j();
    }

    public String getDogName() {
        int i = 0;
        if (this.model == null) {
            i = 0;
        } else {
            String dogName = this.model.getDogName();
        }
        return i;
    }

    public String getEntryId() {
        String documentId = null;
        if (this.model != null) {
            documentId = this.model.getDocumentId();
        } else {
            int i = 0;
        }
        return documentId;
    }

    public String getImageIdAt(int i) {
        return this.model.getImageIdAt(i);
    }

    public String getImageUrl() {
        int i = 0;
        if (this.model == null) {
            i = 0;
        } else {
            String imageUrl = this.model.getImageUrl();
        }
        return i;
    }

    public boolean getLikeState() {
        int pagePosition;
        boolean userLiked;
        boolean z = false;
        boolean z2 = false;
        boolean equals;
        pagePosition = 0;
        if (this.model == null) {
            return false;
        }
        final int i = 1;
        if (this.model.getImages().isEmpty()) {
            if (!this.model.getAuthor().equals(this.authService.v())) {
                if (this.model.hasUserLiked()) {
                }
            }
            return z2;
        }
        if (getPagePosition() < 0) {
        } else {
            pagePosition = getPagePosition();
        }
        if (!this.model.getAuthor().equals(this.authService.v())) {
            if (this.model.getLikeStateForImageAt(pagePosition)) {
            }
        }
        return z;
    }

    public ChallengeEntryModel getModel() {
        return this.model;
    }

    public int getPagePosition() {
        int pagePosition2 = -1;
        int r0 = getPhotoCount() > 1 ? this.pagePosition : -1;
        return (getPhotoCount() > 1 ? this.pagePosition : -1);
    }

    public int getPhotoCount() {
        int imageCount = 0;
        if (this.model != null) {
            imageCount = this.model.getImageCount();
        } else {
            imageCount = 0;
        }
        return imageCount;
    }

    public String getTranslationButtonString() throws android.content.res.Resources.NotFoundException {
        if (this.model.isTranslatePressed()) {
            return this.resources.getString(2131886320);
        }
        return this.resources.getString(2131886326);
    }

    public Uri getUserDogAvatarUri() {
        String str = this.userLocalCacheService.A().f();
        if (!str.isEmpty()) {
            return this.storageService.h(str, "avatar.jpg");
        }
        return null;
    }

    public String getVoteCount() {
        String str;
        if (this.model == null) {
            str = "0";
        } else {
            str = String.valueOf(this.model.getVotes());
        }
        return str;
    }

    public void hideKeyboard(View view) {
        this.utilities.m(view);
    }

    public boolean isAdminBadgeVisible() {
        return this.model.isAuthorAdmin();
    }

    public boolean isAllowedToVote() {
        return !this.authService.v().equals(this.model.getAuthor());
    }

    public boolean isAmbassadorBadgeVisible() {
        return this.model.isAuthorAmbassador();
    }

    public boolean isCaptionExapanded() {
        return this.entryLayoutHelper.isExpandedCaption();
    }

    public boolean isCommentFieldFocused() {
        return this.entryLayoutHelper.isCommentFieldFocused();
    }

    public boolean isCurrentUserEntriesAuthor() {
        boolean z = false;
        String str;
        if (this.model != null) {
            int r0 = this.model.getAuthor().equals(this.authService.v()) ? 1 : 0;
        }
        return (this.model.getAuthor().equals(this.authService.v()) ? 1 : 0);
    }

    public boolean isFeatured() {
        boolean z = false;
        int pagePosition2;
        if (this.model != null) {
            int r0 = this.model.isFeatured(this.pagePosition) ? 1 : 0;
        }
        return (this.model.isFeatured(this.pagePosition) ? 1 : 0);
    }

    public boolean isModelTheSame(ChallengeEntryModel challengeEntryModel) {
        final boolean z = false;
        if (this.model == null) {
            return false;
        }
        if (challengeEntryModel == null) {
            return false;
        }
        return this.model.getDocumentId().equals(challengeEntryModel.getDocumentId());
    }

    public boolean isPremiumBadgeVisible() {
        return this.model.isAuthorPremium();
    }

    public boolean isSpinnerVisible() {
        return this.spinnerVisible;
    }

    public boolean isTranslateButtonVisible() {
        boolean z = true;
        String caption;
        if (!LocaleService.d(this.preferenceService.W()).equals(this.model.getLocale()) && this.getCaption() != null) {
            if (!this.model.getAuthor().equals(this.authService.v())) {
                int r0 = !this.utilities.n(getCaption()) ? 1 : 0;
            }
        }
        return (!this.utilities.n(getCaption()) ? 1 : 0);
    }

    public boolean isUserAdmin() {
        return this.authService.C();
    }

    public boolean isUserPremium() {
        return this.isPremium;
    }

    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    public void notifyChangeAll() {
        this.registry.d(this, 0, null);
    }

    public void onCaptionClick() {
        this.entryLayoutHelper.setExpandedCaptionFlag(true);
        notifyChange(31);
        notifyChange(30);
    }

    public boolean onDeleteRequest(int i) {
        return this.entryLayoutHelper.onDeleteRequest(this.firestoreService, this.tracker, this.model, this.authService.v(), i);
    }

    public void onEntryAvatarClick(a0 a0Var) {
        a0Var.g0(this.model.parseLiteDogProfile(), this.model.getBadges());
    }

    public boolean onSendClick(String str, ChallengeComment challengeComment, a0 a0Var) {
        return this.entryLayoutHelper.uploadComment(this.firestoreService, this.model, str, challengeComment, this.authService.v(), this.userLocalCacheService.A().g().toModel(this.authService.v()), a0Var, this.isPremium);
    }

    public void onTranslateButtonPress() {
        boolean z2 = false;
        if (this.model.isTranslatePressed()) {
            applyTranslateChanges(getCaption(), z2);
        } else {
            boolean z = true;
            setSpinnerVisibility(z);
            if (this.model.getEntryTranslations().containsKey(getDeviceLanguage())) {
                setSpinnerVisibility(z2);
                applyTranslateChanges((String)this.model.getEntryTranslations().get(getDeviceLanguage()), z);
            } else {
                this.firestoreService.w(FirestorePath.entryTranslations.forEntryId(this.model.getDocumentId()).forLocale(getDeviceLanguage())).addOnCompleteListener(getEntryTranslationListener(this.model.getDocumentId()));
            }
        }
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.registry.j(aVar);
        this.disposable.d();
    }

    public void setCommentFieldFocused(boolean z) {
        this.entryLayoutHelper.setCommentFieldFocused(z);
        notifyChange(45);
    }

    public void setModel(ChallengeEntryModel challengeEntryModel, boolean z) {
        this.model = challengeEntryModel;
        z = false;
        this.spinnerVisible = z;
        if (!challengeEntryModel.isDogFetch()) {
            app.dogo.com.dogo_android.util.extensionfunction.j1.p(this, this.userLocalCacheService, this.disposable, challengeEntryModel.getDogId(), new j(this, challengeEntryModel));
        }
        this.pagePosition = z;
        this.entryLayoutHelper.setExpandedCaptionFlag(z);
        this.isPremium = z;
    }

    public void setPagePosition(int i) {
        this.pagePosition = i;
        notifyChange(123);
        notifyChange(121);
        notifyChange(69);
        notifyChange(101);
    }

    public void setParentTag(String str) {
        this.entryLayoutHelper.setSourceTag(str);
    }

    public void setSpinnerVisibility(boolean z) {
        this.spinnerVisible = z;
        notifyChange(147);
    }

    public void setUserEntryId(String str) {
        this.userEntryId = str;
    }

    public void showEntryFans(a0 a0Var) {
        a0Var.o0(this.model.getDocumentId(), this.model.getChallengeId());
    }

    public boolean showReportDeleteButton() {
        boolean z = true;
        if (isCurrentUserEntriesAuthor() || this.isAdminBadgeVisible()) {
            int i = 1;
        }
        return z;
    }

    public boolean simpleLike(long j, int i) {
        return this.entryLayoutHelper.onSimpleLikeClick(j, this.model, this.model.getImageIdAt(i));
    }

    public void toggleFeatured(int i) {
        this.entryLayoutHelper.toggleFeaturedLogic(this.authService, this.firestoreService, this.model, i);
        notifyChange(69);
    }

    public void toggleLike(long j, int i) {
        this.entryLayoutHelper.onToggleLikeClick(j, this.model, this.model.getImageIdAt(i));
    }

    public void updateEntryView() {
        notifyChangeAll();
    }

    public void updateVoteView() {
        notifyChange(101);
        notifyChange(184);
    }

    public void setParentTag(q qVar) {
        this.entryLayoutHelper.setSourceTag(qVar.getTag());
    }

    public /* synthetic */ void b(String str, com.google.android.gms.tasks.j jVar) {
        a(str, jVar);
    }

    public /* synthetic */ void d(String str, com.google.android.gms.tasks.j jVar) {
        c(str, jVar);
    }

    public /* synthetic */ w f(ChallengeEntryModel challengeEntryModel, DogProfileModel dogProfileModel) {
        return e(challengeEntryModel, dogProfileModel);
    }

    public boolean isBorderVisible() {
        return false;
    }

    public boolean isShareButtonVisible() {
        return false;
    }

    public boolean isWinner() {
        return false;
    }

    public void onShareClicked(a0 a0Var) {
    }
}
