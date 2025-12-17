package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.databinding.c;
import androidx.databinding.h.a;
import androidx.databinding.j;
import app.dogo.com.dogo_android.k.f;
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
import app.dogo.com.dogo_android.util.f;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.k0.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.Timestamp;
import i.b.j0.a;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.w;

/* loaded from: classes.dex */
public class EntryPhotoBaseObservable implements c {

    private h2 authService;
    private i2 cloudFunctionsService;
    private a1 content;
    private String deviceLanguage;
    protected a disposable;
    private k2 dynamicLinkService;
    private f entryLayoutHelper;
    private m2 firestoreService;
    private boolean isPremium;
    private ChallengeEntryModel model;
    private int pagePosition;
    private p2 preferenceService;
    private final j registry;
    private Resources resources;
    private boolean spinnerVisible = false;
    private t2 storageService;
    private o3 tracker;
    private String userEntryId;
    private u2 userLocalCacheService;
    private v2 utilities;
    public EntryPhotoBaseObservable(m2 m2, h2 h22, o3 o33, q2 q24, u2 u25, v2 v26, Resources resources7, a1 a18, t2 t29, k2 k210, p2 p211, i2 i212) {
        super();
        j jVar = new j();
        this.registry = jVar;
        int i = 0;
        a aVar = new a();
        this.disposable = aVar;
        this.firestoreService = m2;
        this.authService = h22;
        this.tracker = o33;
        this.utilities = v26;
        this.userLocalCacheService = u25;
        this.resources = resources7;
        this.storageService = t29;
        this.content = a18;
        this.dynamicLinkService = k210;
        this.preferenceService = p211;
        this.cloudFunctionsService = i212;
        this.deviceLanguage = p211.W();
        super(this, m2, q24, o33, h22);
        this.entryLayoutHelper = obj6;
    }

    private void a(String string, j j2) {
        boolean documentId;
        boolean obj2;
        int obj3;
        if (j2.isSuccessful() && string.equals(this.model.getDocumentId())) {
            if (string.equals(this.model.getDocumentId())) {
                setSpinnerVisibility(false);
                applyTranslateChanges((String)j2.getResult(), true);
            }
        }
    }

    static String access$000(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable) {
        return entryPhotoBaseObservable.userEntryId;
    }

    static String access$100(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable) {
        return entryPhotoBaseObservable.getAppInstallationId();
    }

    private void c(String string, j j2) {
        boolean deviceLanguage;
        String caption;
        String locale;
        String str;
        String obj5;
        Object obj6;
        if (string.equals(this.model.getDocumentId())) {
            obj6 = j2.getResult();
            if ((String)obj6 != null) {
                this.model.setEntryTranslations(getDeviceLanguage(), (String)obj6);
                setSpinnerVisibility(false);
                applyTranslateChanges(obj6, true);
            } else {
                deviceLanguage = new h(this, string);
                this.cloudFunctionsService.m(getCaption(), this.model.getLocale(), this.preferenceService.W(), f.entryTranslations.forEntryId(this.model.getDocumentId()).forLocale(getDeviceLanguage()).getPath()).addOnCompleteListener(deviceLanguage);
            }
        }
    }

    private w e(ChallengeEntryModel challengeEntryModel, DogProfileModel dogProfileModel2) {
        boolean equals;
        String str;
        Object obj4;
        if (dogProfileModel2 != null && challengeEntryModel.getDogId().equals(dogProfileModel2.getId()) != null) {
            if (challengeEntryModel.getDogId().equals(dogProfileModel2.getId()) != null) {
                challengeEntryModel.setDogProfile(dogProfileModel2);
                challengeEntryModel.setDogFetchFlag(true);
                challengeEntryModel.setDogName(dogProfileModel2.getName());
                updateEntryView();
            }
        }
        return null;
    }

    private String getAppInstallationId() {
        return this.preferenceService.h();
    }

    private e<String> getEntryTranslationListener(String string) {
        i iVar = new i(this, string);
        return iVar;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void addOnPropertyChangedCallback(h.a h$a) {
        this.registry.a(a);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void applyTranslateChanges(String string, boolean z2) {
        this.model.setTranslatedCaption(string);
        notifyChange(30);
        notifyChange(165);
        this.model.setTranslatePressed(z2);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void b(String string, j j2) {
        a(string, j2);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean canUserComment() {
        int i;
        i = this.userLocalCacheService.A().g().toModel(this.authService.v()).getName() != null ? 1 : 0;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void d(String string, j j2) {
        c(string, j2);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public w f(ChallengeEntryModel challengeEntryModel, DogProfileModel dogProfileModel2) {
        return e(challengeEntryModel, dogProfileModel2);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getCaption() {
        String translatedCaption;
        ChallengeEntryModel comment;
        if (this.model.getTranslatedCaption() != null && this.model.isTranslatePressed()) {
            if (this.model.isTranslatePressed()) {
                return this.model.getTranslatedCaption();
            }
        }
        comment = this.model;
        if (comment != null && comment.getComment() != null && !this.model.getComment().isEmpty()) {
            if (comment.getComment() != null) {
                if (!this.model.getComment().isEmpty()) {
                    return this.model.getComment();
                }
            }
        }
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public int getCommentCount() {
        int commentCount;
        ChallengeEntryModel model = this.model;
        if (model != null) {
            commentCount = model.getCommentCount();
        } else {
            commentCount = 0;
        }
        return commentCount;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getCreationDate() {
        final int i = 0;
        if (this.model.getDate() != null) {
            return this.utilities.i(seconds *= i3, obj3);
        }
        v2 utilities2 = this.utilities;
        return utilities2.i(utilities2.g(), obj3);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getCurrentDogId() {
        return this.userLocalCacheService.A().f();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getDeviceLanguage() {
        String language = Locale.forLanguageTag(this.deviceLanguage).getLanguage();
        this.deviceLanguage = language;
        return language;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getDogAvatar() {
        ChallengeEntryModel dogFetch;
        int avatar;
        Resources resources;
        dogFetch = this.model;
        if (dogFetch != null) {
            if (!dogFetch.isDogFetch()) {
            } else {
                if (this.model.getDogProfile() != null) {
                    avatar = this.model.getDogProfile().getAvatar(this.resources);
                } else {
                    avatar = 0;
                }
            }
            return avatar;
        }
        return "";
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public int getDogCount() {
        return this.userLocalCacheService.A().j();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getDogName() {
        int dogName;
        ChallengeEntryModel model = this.model;
        if (model == null) {
            dogName = 0;
        } else {
            dogName = model.getDogName();
        }
        return dogName;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getEntryId() {
        String documentId;
        ChallengeEntryModel model = this.model;
        if (model != null) {
            documentId = model.getDocumentId();
        } else {
            documentId = 0;
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getImageIdAt(int i) {
        return this.model.getImageIdAt(i);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getImageUrl() {
        int imageUrl;
        ChallengeEntryModel model = this.model;
        if (model == null) {
            imageUrl = 0;
        } else {
            imageUrl = model.getImageUrl();
        }
        return imageUrl;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean getLikeState() {
        int likeStateForImageAt;
        boolean userLiked;
        int i;
        ChallengeEntryModel equals;
        ChallengeEntryModel model = this.model;
        i = 0;
        if (model == null) {
            return i;
        }
        final int i2 = 1;
        if (model.getImages().isEmpty()) {
            if (!this.model.getAuthor().equals(this.authService.v())) {
                if (this.model.hasUserLiked()) {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        if (getPagePosition() < 0) {
            likeStateForImageAt = i;
        } else {
            likeStateForImageAt = getPagePosition();
        }
        if (!this.model.getAuthor().equals(this.authService.v())) {
            if (this.model.getLikeStateForImageAt(likeStateForImageAt)) {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public ChallengeEntryModel getModel() {
        return this.model;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public int getPagePosition() {
        int pagePosition;
        pagePosition = getPhotoCount() > 1 ? this.pagePosition : -1;
        return pagePosition;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public int getPhotoCount() {
        int imageCount;
        ChallengeEntryModel model = this.model;
        if (model != null) {
            imageCount = model.getImageCount();
        } else {
            imageCount = 0;
        }
        return imageCount;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getTranslationButtonString() {
        if (this.model.isTranslatePressed()) {
            return this.resources.getString(2131886320);
        }
        return this.resources.getString(2131886326);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public Uri getUserDogAvatarUri() {
        String str = this.userLocalCacheService.A().f();
        if (!str.isEmpty()) {
            return this.storageService.h(str, "avatar.jpg");
        }
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public String getVoteCount() {
        String valueOf;
        ChallengeEntryModel model = this.model;
        if (model == null) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(model.getVotes());
        }
        return valueOf;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void hideKeyboard(View view) {
        this.utilities.m(view);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isAdminBadgeVisible() {
        return this.model.isAuthorAdmin();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isAllowedToVote() {
        return equals ^= 1;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isAmbassadorBadgeVisible() {
        return this.model.isAuthorAmbassador();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isBorderVisible() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isCaptionExapanded() {
        return this.entryLayoutHelper.isExpandedCaption();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isCommentFieldFocused() {
        return this.entryLayoutHelper.isCommentFieldFocused();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isCurrentUserEntriesAuthor() {
        ChallengeEntryModel equals;
        int i;
        String str;
        equals = this.model;
        if (equals != null && equals.getAuthor().equals(this.authService.v())) {
            i = equals.getAuthor().equals(this.authService.v()) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isFeatured() {
        ChallengeEntryModel featured;
        int i;
        int pagePosition;
        featured = this.model;
        if (featured != null && featured.isFeatured(this.pagePosition)) {
            i = featured.isFeatured(this.pagePosition) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isModelTheSame(ChallengeEntryModel challengeEntryModel) {
        ChallengeEntryModel model = this.model;
        final int i = 0;
        if (model == null) {
            return i;
        }
        if (challengeEntryModel == null) {
            return i;
        }
        return model.getDocumentId().equals(challengeEntryModel.getDocumentId());
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isPremiumBadgeVisible() {
        return this.model.isAuthorPremium();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isShareButtonVisible() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isSpinnerVisible() {
        return this.spinnerVisible;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isTranslateButtonVisible() {
        boolean caption;
        int i;
        String caption2;
        if (!n2.d(this.preferenceService.W()).equals(this.model.getLocale()) && getCaption() != null && !this.model.getAuthor().equals(this.authService.v()) && !this.utilities.n(getCaption())) {
            if (getCaption() != null) {
                if (!this.model.getAuthor().equals(this.authService.v())) {
                    i = !this.utilities.n(getCaption()) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isUserAdmin() {
        return this.authService.C();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isUserPremium() {
        return this.isPremium;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean isWinner() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void notifyChange(int i) {
        this.registry.m(this, i);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void notifyChangeAll() {
        this.registry.d(this, 0, 0);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void onCaptionClick() {
        this.entryLayoutHelper.setExpandedCaptionFlag(true);
        notifyChange(31);
        notifyChange(30);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean onDeleteRequest(int i) {
        return this.entryLayoutHelper.onDeleteRequest(this.firestoreService, this.tracker, this.model, this.authService.v(), i);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void onEntryAvatarClick(a0 a0) {
        a0.g0(this.model.parseLiteDogProfile(), this.model.getBadges());
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean onSendClick(String string, ChallengeComment challengeComment2, a0 a03) {
        return this.entryLayoutHelper.uploadComment(this.firestoreService, this.model, string, challengeComment2, this.authService.v(), this.userLocalCacheService.A().g().toModel(this.authService.v()), a03, this.isPremium);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void onShareClicked(a0 a0) {
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void onTranslateButtonPress() {
        Object entryTranslationListener;
        j translatePressed;
        m2 firestoreService;
        boolean key;
        String deviceLanguage;
        firestoreService = 0;
        if (!this.model.isTranslatePressed()) {
            translatePressed = 1;
            setSpinnerVisibility(translatePressed);
            if (this.model.getEntryTranslations().containsKey(getDeviceLanguage())) {
                setSpinnerVisibility(firestoreService);
                applyTranslateChanges((String)this.model.getEntryTranslations().get(getDeviceLanguage()), translatePressed);
            } else {
                this.firestoreService.w(f.entryTranslations.forEntryId(this.model.getDocumentId()).forLocale(getDeviceLanguage())).addOnCompleteListener(getEntryTranslationListener(this.model.getDocumentId()));
            }
        } else {
            applyTranslateChanges(getCaption(), firestoreService);
        }
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void removeOnPropertyChangedCallback(h.a h$a) {
        this.registry.j(a);
        this.disposable.d();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setCommentFieldFocused(boolean z) {
        this.entryLayoutHelper.setCommentFieldFocused(z);
        notifyChange(45);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setModel(ChallengeEntryModel challengeEntryModel, boolean z2) {
        boolean userLocalCacheService;
        a disposable;
        String dogId;
        app.dogo.com.dogo_android.model.entry_list_item_models.j jVar;
        this.model = challengeEntryModel;
        final int i = 0;
        this.spinnerVisible = i;
        if (!challengeEntryModel.isDogFetch()) {
            jVar = new j(this, challengeEntryModel);
            j1.p(this, this.userLocalCacheService, this.disposable, challengeEntryModel.getDogId(), jVar);
        }
        this.pagePosition = i;
        this.entryLayoutHelper.setExpandedCaptionFlag(i);
        this.isPremium = z2;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setPagePosition(int i) {
        this.pagePosition = i;
        notifyChange(123);
        notifyChange(121);
        notifyChange(69);
        notifyChange(101);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setParentTag(q q) {
        this.entryLayoutHelper.setSourceTag(q.getTag());
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setParentTag(String string) {
        this.entryLayoutHelper.setSourceTag(string);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setSpinnerVisibility(boolean z) {
        this.spinnerVisible = z;
        notifyChange(147);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void setUserEntryId(String string) {
        this.userEntryId = string;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void showEntryFans(a0 a0) {
        a0.o0(this.model.getDocumentId(), this.model.getChallengeId());
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean showReportDeleteButton() {
        int i;
        boolean currentUserEntriesAuthor;
        if (!isCurrentUserEntriesAuthor()) {
            if (isAdminBadgeVisible()) {
                if (!isUserAdmin()) {
                    if (!isAdminBadgeVisible()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public boolean simpleLike(long l, int i2) {
        final ChallengeEntryModel model = this.model;
        return this.entryLayoutHelper.onSimpleLikeClick(l, i2, model);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void toggleFeatured(int i) {
        this.entryLayoutHelper.toggleFeaturedLogic(this.authService, this.firestoreService, this.model, i);
        notifyChange(69);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void toggleLike(long l, int i2) {
        final ChallengeEntryModel model = this.model;
        this.entryLayoutHelper.onToggleLikeClick(l, i2, model);
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void updateEntryView() {
        notifyChangeAll();
    }

    @Override // app.dogo.com.dogo_android.util.k0.c
    public void updateVoteView() {
        notifyChange(101);
        notifyChange(184);
    }
}
