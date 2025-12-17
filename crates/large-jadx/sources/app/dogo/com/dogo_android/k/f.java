package app.dogo.com.dogo_android.k;

import android.app.ActivityManager.ProcessErrorStateInfo;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008E\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\u0008#j\u0002\u0008$j\u0002\u0008%j\u0002\u0008&j\u0002\u0008'j\u0002\u0008(j\u0002\u0008)j\u0002\u0008*j\u0002\u0008+j\u0002\u0008,j\u0002\u0008-j\u0002\u0008.j\u0002\u0008/j\u0002\u00080j\u0002\u00081j\u0002\u00082j\u0002\u00083j\u0002\u00084j\u0002\u00085j\u0002\u00086j\u0002\u00087j\u0002\u00088j\u0002\u00089j\u0002\u0008:j\u0002\u0008;j\u0002\u0008<j\u0002\u0008=j\u0002\u0008>j\u0002\u0008?j\u0002\u0008@j\u0002\u0008Aj\u0002\u0008Bj\u0002\u0008Cj\u0002\u0008Dj\u0002\u0008Ej\u0002\u0008Fj\u0002\u0008Gj\u0002\u0008H¨\u0006I", d2 = {"Lapp/dogo/com/dogo_android/enums/FirestorePath;", "", "(Ljava/lang/String;I)V", "challengeId", "", "commentId", "dogId", "entryId", "examId", "locale", "path", "getPath", "()Ljava/lang/String;", "photoId", "getPhotoId", "trickId", "userId", "forChallengeId", "id", "forCommentId", "forDogId", "forEntryId", "forExamId", "forLocale", "forPhotoId", "forTrickId", "forUserId", "getChallengeId", "getCommentId", "getDogId", "getEntryId", "getExamId", "getLocale", "getTrickId", "getUserId", "admins", "ambassadors", "allChallenges", "challenge", "allEntries", "entry", "entryTranslations", "userVotesForChallengeEntries", "entryVotes", "entryVoteFromUser", "user", "commentVoteFromUser", "commentVoteFromUserExtended", "userEntryLikes", "allGroupChallengeChat", "entryFans", "entryReport", "challengeProfileReport", "latestEntries_24", "latestEntries_168", "entryFeatured", "entryView", "userViewsForChallengeEntries", "comments", "comment", "commentLikes", "commentReports", "commentTranslations", "groupChallengeChatMessage", "allDogExams", "dogExam", "dog", "allLocalisedChallenges", "localisedChallenges", "dogExamHistory", "dogExamHistorySingle", "likeDocs", "likedPhotoDocs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum f {

    admins,
    ambassadors,
    allChallenges,
    challenge,
    allEntries,
    entry,
    entryTranslations,
    userVotesForChallengeEntries,
    entryVotes,
    entryVoteFromUser,
    user,
    commentVoteFromUser,
    commentVoteFromUserExtended,
    userEntryLikes,
    allGroupChallengeChat,
    entryFans,
    entryReport,
    challengeProfileReport,
    latestEntries_24,
    latestEntries_168,
    entryFeatured,
    entryView,
    userViewsForChallengeEntries,
    comments,
    comment,
    commentLikes,
    commentReports,
    commentTranslations,
    groupChallengeChatMessage,
    allDogExams,
    dogExam,
    dog,
    allLocalisedChallenges,
    localisedChallenges,
    dogExamHistory,
    dogExamHistorySingle,
    likeDocs,
    likedPhotoDocs;

    private String challengeId;
    private String commentId;
    private String dogId;
    private String entryId;
    private String examId;
    private String locale;
    private String trickId;
    private String userId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[f.admins.ordinal()] = 1;
            iArr[f.ambassadors.ordinal()] = 2;
            iArr[f.challenge.ordinal()] = 3;
            iArr[f.allEntries.ordinal()] = 4;
            iArr[f.allChallenges.ordinal()] = 5;
            iArr[f.entry.ordinal()] = 6;
            iArr[f.entryTranslations.ordinal()] = 7;
            iArr[f.userVotesForChallengeEntries.ordinal()] = 8;
            iArr[f.entryVotes.ordinal()] = 9;
            iArr[f.entryVoteFromUser.ordinal()] = 10;
            iArr[f.entryReport.ordinal()] = 11;
            iArr[f.user.ordinal()] = 12;
            iArr[f.userEntryLikes.ordinal()] = 13;
            iArr[f.likeDocs.ordinal()] = 14;
            iArr[f.likedPhotoDocs.ordinal()] = 15;
            iArr[f.allGroupChallengeChat.ordinal()] = 16;
            iArr[f.groupChallengeChatMessage.ordinal()] = 17;
            iArr[f.commentVoteFromUser.ordinal()] = 18;
            iArr[f.commentVoteFromUserExtended.ordinal()] = 19;
            iArr[f.entryFans.ordinal()] = 20;
            iArr[f.entryView.ordinal()] = 21;
            iArr[f.latestEntries_24.ordinal()] = 22;
            iArr[f.latestEntries_168.ordinal()] = 23;
            iArr[f.userViewsForChallengeEntries.ordinal()] = 24;
            iArr[f.comment.ordinal()] = 25;
            iArr[f.commentLikes.ordinal()] = 26;
            iArr[f.commentReports.ordinal()] = 27;
            iArr[f.comments.ordinal()] = 28;
            iArr[f.commentTranslations.ordinal()] = 29;
            iArr[f.localisedChallenges.ordinal()] = 30;
            iArr[f.allLocalisedChallenges.ordinal()] = 31;
            iArr[f.allDogExams.ordinal()] = 32;
            iArr[f.dogExam.ordinal()] = 33;
            iArr[f.dogExamHistorySingle.ordinal()] = 34;
            iArr[f.dogExamHistory.ordinal()] = 35;
            iArr[f.dog.ordinal()] = 36;
            iArr[f.challengeProfileReport.ordinal()] = 37;
            f.a.a = iArr;
        }
    }
    private static final app.dogo.com.dogo_android.k.f[] $values() {
        app.dogo.com.dogo_android.k.f[] arr = new f[38];
        return arr;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forChallengeId(String string) {
        n.f(string, "id");
        this.challengeId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forCommentId(String string) {
        n.f(string, "id");
        this.commentId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forDogId(String string) {
        n.f(string, "dogId");
        this.dogId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forEntryId(String string) {
        n.f(string, "id");
        this.entryId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forExamId(String string) {
        n.f(string, "examId");
        this.examId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forLocale(String string) {
        n.f(string, "locale");
        this.locale = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forPhotoId(String string) {
        n.f(string, "id");
        this.trickId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forTrickId(String string) {
        n.f(string, "id");
        this.trickId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final app.dogo.com.dogo_android.k.f forUserId(String string) {
        n.f(string, "id");
        this.userId = string;
        return this;
    }

    @Override // java.lang.Enum
    public final String getChallengeId() {
        if (n.b(this.challengeId, "")) {
        } else {
            return this.challengeId;
        }
        RuntimeException runtimeException = new RuntimeException("No challengeId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getCommentId() {
        if (n.b(this.commentId, "")) {
        } else {
            return this.commentId;
        }
        RuntimeException runtimeException = new RuntimeException("No commentId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getDogId() {
        if (n.b(this.dogId, "")) {
        } else {
            return this.dogId;
        }
        RuntimeException runtimeException = new RuntimeException("No dogId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getEntryId() {
        if (n.b(this.entryId, "")) {
        } else {
            return this.entryId;
        }
        RuntimeException runtimeException = new RuntimeException("No entryId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getExamId() {
        if (n.b(this.examId, "")) {
        } else {
            return this.examId;
        }
        RuntimeException runtimeException = new RuntimeException("No examId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getLocale() {
        if (n.b(this.locale, "")) {
        } else {
            return this.locale;
        }
        RuntimeException runtimeException = new RuntimeException("No locale to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getPath() {
        int i3;
        int i2;
        int cmp;
        String str13 = "/challengeLocales/";
        String str23 = "challenges/";
        final String str24 = "/notifications/";
        final String str25 = "/userLikes/";
        final String str26 = "/reports/";
        final String str27 = "/voters/";
        final String str28 = "/voters";
        final String str29 = "/likedEntries/";
        final String str30 = "/translations/";
        final String str31 = "/exams/";
        final String str32 = "/comments/";
        final String str33 = "/dogs/";
        final String str34 = "/users/";
        final String str35 = "/entries/";
        switch (i4) {
            case 1:
                return "/admins/";
            case 2:
                return "/ambassadors/";
            case 3:
                return n.o("/challenges/", getChallengeId());
            case 4:
                return "/entries";
            case 5:
                return "challenges";
            case 6:
                return n.o(str35, getEntryId());
            case 7:
                StringBuilder stringBuilder24 = new StringBuilder();
                stringBuilder24.append(str35);
                stringBuilder24.append(getEntryId());
                stringBuilder24.append(str30);
                stringBuilder24.append(getLocale());
                return stringBuilder24.toString();
            case 8:
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(str34);
                stringBuilder6.append(getUserId());
                stringBuilder6.append(str29);
                stringBuilder6.append(getChallengeId());
                return stringBuilder6.toString();
            case 9:
                StringBuilder stringBuilder14 = new StringBuilder();
                stringBuilder14.append(str35);
                stringBuilder14.append(getEntryId());
                stringBuilder14.append(str28);
                return stringBuilder14.toString();
            case 10:
                StringBuilder stringBuilder22 = new StringBuilder();
                stringBuilder22.append(str35);
                stringBuilder22.append(getEntryId());
                stringBuilder22.append(str27);
                stringBuilder22.append(getUserId());
                return stringBuilder22.toString();
            case 11:
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str35);
                stringBuilder4.append(getEntryId());
                stringBuilder4.append(str26);
                stringBuilder4.append(getUserId());
                return stringBuilder4.toString();
            case 12:
                return n.o(str34, getUserId());
            case 13:
                StringBuilder stringBuilder20 = new StringBuilder();
                stringBuilder20.append(str34);
                stringBuilder20.append(getUserId());
                stringBuilder20.append(str29);
                return stringBuilder20.toString();
            case 14:
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str34);
                stringBuilder2.append(getUserId());
                stringBuilder2.append(str25);
                return stringBuilder2.toString();
            case 15:
                StringBuilder stringBuilder11 = new StringBuilder();
                stringBuilder11.append(str34);
                stringBuilder11.append(getUserId());
                stringBuilder11.append(str25);
                stringBuilder11.append(getPhotoId());
                return stringBuilder11.toString();
            case 16:
                StringBuilder stringBuilder18 = new StringBuilder();
                stringBuilder18.append(str34);
                stringBuilder18.append(getUserId());
                stringBuilder18.append(str24);
                return stringBuilder18.toString();
            case 17:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str34);
                stringBuilder.append(getUserId());
                stringBuilder.append(str24);
                stringBuilder.append(getEntryId());
                return stringBuilder.toString();
            case 18:
                StringBuilder stringBuilder10 = new StringBuilder();
                stringBuilder10.append(str34);
                stringBuilder10.append(getUserId());
                stringBuilder10.append("/likedComments/");
                stringBuilder10.append(getEntryId());
                return stringBuilder10.toString();
            case 19:
                StringBuilder stringBuilder17 = new StringBuilder();
                stringBuilder17.append(str34);
                stringBuilder17.append(getUserId());
                stringBuilder17.append("/likedCommentsExtended/");
                stringBuilder17.append(getCommentId());
                return stringBuilder17.toString();
            case 20:
                StringBuilder stringBuilder26 = new StringBuilder();
                stringBuilder26.append(str35);
                stringBuilder26.append(this.entryId);
                stringBuilder26.append(str28);
                return stringBuilder26.toString();
            case 21:
                StringBuilder stringBuilder9 = new StringBuilder();
                stringBuilder9.append(str35);
                stringBuilder9.append(getEntryId());
                stringBuilder9.append("/views/");
                stringBuilder9.append(getUserId());
                return stringBuilder9.toString();
            case 22:
                return "/cache/entries/latestEntries_24";
            case 23:
                return "/cache/entries/latestEntries_168";
            case 24:
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(str34);
                stringBuilder8.append(getUserId());
                stringBuilder8.append("/viewed/");
                stringBuilder8.append(getChallengeId());
                return stringBuilder8.toString();
            case 25:
                StringBuilder stringBuilder16 = new StringBuilder();
                stringBuilder16.append(str35);
                stringBuilder16.append(getEntryId());
                stringBuilder16.append(str32);
                stringBuilder16.append(getCommentId());
                return stringBuilder16.toString();
            case 26:
                StringBuilder stringBuilder25 = new StringBuilder();
                stringBuilder25.append(str35);
                stringBuilder25.append(getEntryId());
                stringBuilder25.append(str32);
                stringBuilder25.append(getCommentId());
                stringBuilder25.append(str27);
                stringBuilder25.append(getUserId());
                return stringBuilder25.toString();
            case 27:
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append(str35);
                stringBuilder7.append(getEntryId());
                stringBuilder7.append(str32);
                stringBuilder7.append(getCommentId());
                stringBuilder7.append(str26);
                stringBuilder7.append(getUserId());
                return stringBuilder7.toString();
            case 28:
                StringBuilder stringBuilder15 = new StringBuilder();
                stringBuilder15.append(str35);
                stringBuilder15.append(getEntryId());
                stringBuilder15.append("/comments");
                return stringBuilder15.toString();
            case 29:
                StringBuilder stringBuilder23 = new StringBuilder();
                stringBuilder23.append(str35);
                stringBuilder23.append(getEntryId());
                stringBuilder23.append(str32);
                stringBuilder23.append(getCommentId());
                stringBuilder23.append(str30);
                stringBuilder23.append(getLocale());
                return stringBuilder23.toString();
            case 30:
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(str23);
                stringBuilder5.append(getChallengeId());
                stringBuilder5.append(str13);
                stringBuilder5.append(getLocale());
                return stringBuilder5.toString();
            case 31:
                StringBuilder stringBuilder13 = new StringBuilder();
                stringBuilder13.append(str23);
                stringBuilder13.append(getChallengeId());
                stringBuilder13.append(str13);
                return stringBuilder13.toString();
            case 32:
                StringBuilder stringBuilder21 = new StringBuilder();
                stringBuilder21.append(str33);
                stringBuilder21.append(getDogId());
                stringBuilder21.append("/exams");
                return stringBuilder21.toString();
            case 33:
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str33);
                stringBuilder3.append(getDogId());
                stringBuilder3.append(str31);
                stringBuilder3.append(getTrickId());
                return stringBuilder3.toString();
            case 34:
                StringBuilder stringBuilder12 = new StringBuilder();
                stringBuilder12.append(str33);
                stringBuilder12.append(getDogId());
                stringBuilder12.append(str31);
                stringBuilder12.append(getTrickId());
                stringBuilder12.append("/history/");
                stringBuilder12.append(getExamId());
                return stringBuilder12.toString();
            case 35:
                StringBuilder stringBuilder19 = new StringBuilder();
                stringBuilder19.append(str33);
                stringBuilder19.append(getDogId());
                stringBuilder19.append(str31);
                stringBuilder19.append(getTrickId());
                stringBuilder19.append("/history");
                return stringBuilder19.toString();
            case 36:
                return n.o(str33, getDogId());
            case 37:
                return "/challengeProfileReports";
            default:
                return "";
        }
    }

    @Override // java.lang.Enum
    public final String getPhotoId() {
        if (n.b(this.trickId, "")) {
        } else {
            return this.trickId;
        }
        RuntimeException runtimeException = new RuntimeException("No photoId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getTrickId() {
        if (n.b(this.trickId, "")) {
        } else {
            return this.trickId;
        }
        RuntimeException runtimeException = new RuntimeException("No trickId to give");
        throw runtimeException;
    }

    @Override // java.lang.Enum
    public final String getUserId() {
        if (n.b(this.userId, "")) {
        } else {
            return this.userId;
        }
        RuntimeException runtimeException = new RuntimeException("No userId to give");
        throw runtimeException;
    }
}
