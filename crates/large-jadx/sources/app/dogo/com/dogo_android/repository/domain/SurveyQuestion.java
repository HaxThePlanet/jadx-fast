package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SurveyQuestion.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000cHÆ\u0003J\t\u0010!\u001a\u00020\u000cHÆ\u0003Ja\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000cHÆ\u0001J\t\u0010#\u001a\u00020\u000cHÖ\u0001J\u0013\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000cHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0016¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "Landroid/os/Parcelable;", "id", "", "answers", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswer;", "answer1Text", "answer2Text", "answer3Text", "name", "totalQuestions", "", "currentQuestionPosition", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAnswer1Text", "()Ljava/lang/String;", "getAnswer2Text", "getAnswer3Text", "getAnswers", "()Ljava/util/List;", "getCurrentQuestionPosition", "()I", "getId", "getName", "getTotalQuestions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SurveyQuestion implements Parcelable {

    public static final Parcelable.Creator<SurveyQuestion> CREATOR = new SurveyQuestion$Creator<>();
    private final String answer1Text;
    private final String answer2Text;
    private final String answer3Text;
    private final List<SurveyAnswer> answers;
    private final int currentQuestionPosition;
    private final String id;
    private final String name;
    private final int totalQuestions;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyQuestion> {
        @Override // android.os.Parcelable$Creator
        public final SurveyQuestion createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(SurveyAnswer.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            SurveyQuestion parcel2 = new SurveyQuestion(parcel.readString(), arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final SurveyQuestion[] newArray(int i) {
            return new SurveyQuestion[i];
        }
    }
    public SurveyQuestion(String str, List<SurveyAnswer> list, String str2, String str3, String str4, String str5, int i, int i2) {
        n.f(str, "id");
        n.f(list, "answers");
        n.f(str2, "answer1Text");
        n.f(str3, "answer2Text");
        n.f(str5, "name");
        super();
        this.id = str;
        this.answers = list;
        this.answer1Text = str2;
        this.answer2Text = str3;
        this.answer3Text = str4;
        this.name = str5;
        this.totalQuestions = i;
        this.currentQuestionPosition = i2;
    }

    public final String getAnswer1Text() {
        return this.answer1Text;
    }

    public final String getAnswer2Text() {
        return this.answer2Text;
    }

    public final String getAnswer3Text() {
        return this.answer3Text;
    }

    public final List<SurveyAnswer> getAnswers() {
        return this.answers;
    }

    public final int getCurrentQuestionPosition() {
        return this.currentQuestionPosition;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTotalQuestions() {
        return this.totalQuestions;
    }


    public static /* synthetic */ SurveyQuestion copy$default(SurveyQuestion surveyQuestion, String str, List list, String str2, String str3, String str4, String str5, int i, int i2, int i3, Object object) {
        int i92;
        String str22;
        List list32;
        String str42;
        String str52;
        String str62;
        String str72;
        int i82;
        Object surveyQuestion2 = surveyQuestion;
        int i102 = i3;
        String r2 = i102 & 1 != 0 ? surveyQuestion2.id : str;
        List r3 = i102 & 2 != 0 ? surveyQuestion2.answers : list;
        String r4 = i102 & 4 != 0 ? surveyQuestion2.answer1Text : str2;
        String r5 = i102 & 8 != 0 ? surveyQuestion2.answer2Text : str3;
        String r6 = i102 & 16 != 0 ? surveyQuestion2.answer3Text : str4;
        String r7 = i102 & 32 != 0 ? surveyQuestion2.name : str5;
        int r8 = i102 & 64 != 0 ? surveyQuestion2.totalQuestions : i;
        int r1 = i102 & 128 != 0 ? surveyQuestion2.currentQuestionPosition : i2;
        return surveyQuestion.copy(str22, list32, str42, str52, str62, str72, i82, (i102 & 128 != 0 ? surveyQuestion2.currentQuestionPosition : i2));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final List<SurveyAnswer> component2() {
        return this.answers;
    }

    /* operator */ public final String component3() {
        return this.answer1Text;
    }

    /* operator */ public final String component4() {
        return this.answer2Text;
    }

    /* operator */ public final String component5() {
        return this.answer3Text;
    }

    /* operator */ public final String component6() {
        return this.name;
    }

    /* operator */ public final int component7() {
        return this.totalQuestions;
    }

    /* operator */ public final int component8() {
        return this.currentQuestionPosition;
    }

    public final SurveyQuestion copy(String id, List<SurveyAnswer> answers, String answer1Text, String answer2Text, String answer3Text, String name, int totalQuestions, int currentQuestionPosition) {
        n.f(id, "id");
        n.f(answers, "answers");
        n.f(answer1Text, "answer1Text");
        n.f(answer2Text, "answer2Text");
        final Object name2 = name;
        n.f(name2, "name");
        SurveyQuestion surveyQuestion = new SurveyQuestion(id, answers, answer1Text, answer2Text, answer3Text, name2, totalQuestions, currentQuestionPosition);
        return surveyQuestion;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z9 = false;
        if (!(other instanceof SurveyQuestion)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.answers, other.answers)) {
            return false;
        }
        if (!n.b(this.answer1Text, other.answer1Text)) {
            return false;
        }
        if (!n.b(this.answer2Text, other.answer2Text)) {
            return false;
        }
        if (!n.b(this.answer3Text, other.answer3Text)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (this.totalQuestions != other.totalQuestions) {
            return false;
        }
        return this.currentQuestionPosition != other.currentQuestionPosition ? z9 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.answer3Text == null) {
            i = 0;
        } else {
            i = this.answer3Text.hashCode();
        }
        return (this.id.hashCode() * 31) + this.answers.hashCode() * 31 + this.answer1Text.hashCode() * 31 + this.answer2Text.hashCode() * 31 + i * 31 + this.name.hashCode() * 31 + Integer.hashCode(this.totalQuestions) * 31 + Integer.hashCode(this.currentQuestionPosition);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SurveyQuestion(id=";
        String str3 = ", answers=";
        String str4 = ", answer1Text=";
        String str5 = ", answer2Text=";
        String str6 = ", answer3Text=";
        String str7 = ", name=";
        String str8 = ", totalQuestions=";
        String str9 = ", currentQuestionPosition=";
        str = str2 + this.id + str3 + this.answers + str4 + this.answer1Text + str5 + this.answer2Text + str6 + this.answer3Text + str7 + this.name + str8 + this.totalQuestions + str9 + this.currentQuestionPosition + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeInt(this.answers.size());
        Iterator it = this.answers.iterator();
        while (it.hasNext()) {
            (SurveyAnswer)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.answer1Text);
        parcel.writeString(this.answer2Text);
        parcel.writeString(this.answer3Text);
        parcel.writeString(this.name);
        parcel.writeInt(this.totalQuestions);
        parcel.writeInt(this.currentQuestionPosition);
    }
}
