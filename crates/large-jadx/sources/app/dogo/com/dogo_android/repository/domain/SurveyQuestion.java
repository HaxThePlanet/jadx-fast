package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000cHÆ\u0003J\t\u0010!\u001a\u00020\u000cHÆ\u0003Ja\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000cHÆ\u0001J\t\u0010#\u001a\u00020\u000cHÖ\u0001J\u0013\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000cHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0016¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "Landroid/os/Parcelable;", "id", "", "answers", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswer;", "answer1Text", "answer2Text", "answer3Text", "name", "totalQuestions", "", "currentQuestionPosition", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAnswer1Text", "()Ljava/lang/String;", "getAnswer2Text", "getAnswer3Text", "getAnswers", "()Ljava/util/List;", "getCurrentQuestionPosition", "()I", "getId", "getName", "getTotalQuestions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SurveyQuestion implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SurveyQuestion> CREATOR;
    private final String answer1Text;
    private final String answer2Text;
    private final String answer3Text;
    private final List<app.dogo.com.dogo_android.repository.domain.SurveyAnswer> answers;
    private final int currentQuestionPosition;
    private final String id;
    private final String name;
    private final int totalQuestions;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SurveyQuestion> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SurveyQuestion createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(SurveyAnswer.CREATOR.createFromParcel(parcel));
                i++;
            }
            super(parcel.readString(), arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
            return obj11;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SurveyQuestion[] newArray(int i) {
            return new SurveyQuestion[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SurveyQuestion.Creator creator = new SurveyQuestion.Creator();
        SurveyQuestion.CREATOR = creator;
    }

    public SurveyQuestion(String string, List<app.dogo.com.dogo_android.repository.domain.SurveyAnswer> list2, String string3, String string4, String string5, String string6, int i7, int i8) {
        n.f(string, "id");
        n.f(list2, "answers");
        n.f(string3, "answer1Text");
        n.f(string4, "answer2Text");
        n.f(string6, "name");
        super();
        this.id = string;
        this.answers = list2;
        this.answer1Text = string3;
        this.answer2Text = string4;
        this.answer3Text = string5;
        this.name = string6;
        this.totalQuestions = i7;
        this.currentQuestionPosition = i8;
    }

    public static app.dogo.com.dogo_android.repository.domain.SurveyQuestion copy$default(app.dogo.com.dogo_android.repository.domain.SurveyQuestion surveyQuestion, String string2, List list3, String string4, String string5, String string6, String string7, int i8, int i9, int i10, Object object11) {
        int currentQuestionPosition;
        String str;
        List answers;
        String answer1Text;
        String answer2Text;
        String answer3Text;
        String name;
        int totalQuestions;
        Object obj = surveyQuestion;
        int i = i10;
        str = i & 1 != 0 ? obj.id : string2;
        answers = i & 2 != 0 ? obj.answers : list3;
        answer1Text = i & 4 != 0 ? obj.answer1Text : string4;
        answer2Text = i & 8 != 0 ? obj.answer2Text : string5;
        answer3Text = i & 16 != 0 ? obj.answer3Text : string6;
        name = i & 32 != 0 ? obj.name : string7;
        totalQuestions = i & 64 != 0 ? obj.totalQuestions : i8;
        currentQuestionPosition = i &= 128 != 0 ? obj.currentQuestionPosition : i9;
        return surveyQuestion.copy(str, answers, answer1Text, answer2Text, answer3Text, name, totalQuestions, currentQuestionPosition);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.SurveyAnswer> component2() {
        return this.answers;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.answer1Text;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.answer2Text;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.answer3Text;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final int component7() {
        return this.totalQuestions;
    }

    @Override // android.os.Parcelable
    public final int component8() {
        return this.currentQuestionPosition;
    }

    public final app.dogo.com.dogo_android.repository.domain.SurveyQuestion copy(String string, List<app.dogo.com.dogo_android.repository.domain.SurveyAnswer> list2, String string3, String string4, String string5, String string6, int i7, int i8) {
        n.f(string, "id");
        n.f(list2, "answers");
        n.f(string3, "answer1Text");
        n.f(string4, "answer2Text");
        final Object obj = string6;
        n.f(obj, "name");
        super(string, list2, string3, string4, string5, obj, i7, i8);
        return surveyQuestion;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SurveyQuestion) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.answers, object.answers)) {
            return i2;
        }
        if (!n.b(this.answer1Text, object.answer1Text)) {
            return i2;
        }
        if (!n.b(this.answer2Text, object.answer2Text)) {
            return i2;
        }
        if (!n.b(this.answer3Text, object.answer3Text)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (this.totalQuestions != object.totalQuestions) {
            return i2;
        }
        if (this.currentQuestionPosition != object.currentQuestionPosition) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getAnswer1Text() {
        return this.answer1Text;
    }

    @Override // android.os.Parcelable
    public final String getAnswer2Text() {
        return this.answer2Text;
    }

    @Override // android.os.Parcelable
    public final String getAnswer3Text() {
        return this.answer3Text;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.SurveyAnswer> getAnswers() {
        return this.answers;
    }

    @Override // android.os.Parcelable
    public final int getCurrentQuestionPosition() {
        return this.currentQuestionPosition;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final int getTotalQuestions() {
        return this.totalQuestions;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        String answer3Text = this.answer3Text;
        if (answer3Text == null) {
            i = 0;
        } else {
            i = answer3Text.hashCode();
        }
        return i15 += i22;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurveyQuestion(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", answer1Text=");
        stringBuilder.append(this.answer1Text);
        stringBuilder.append(", answer2Text=");
        stringBuilder.append(this.answer2Text);
        stringBuilder.append(", answer3Text=");
        stringBuilder.append(this.answer3Text);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", totalQuestions=");
        stringBuilder.append(this.totalQuestions);
        stringBuilder.append(", currentQuestionPosition=");
        stringBuilder.append(this.currentQuestionPosition);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        List answers = this.answers;
        parcel.writeInt(answers.size());
        Iterator iterator = answers.iterator();
        for (SurveyAnswer size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.answer1Text);
        parcel.writeString(this.answer2Text);
        parcel.writeString(this.answer3Text);
        parcel.writeString(this.name);
        parcel.writeInt(this.totalQuestions);
        parcel.writeInt(this.currentQuestionPosition);
    }
}
