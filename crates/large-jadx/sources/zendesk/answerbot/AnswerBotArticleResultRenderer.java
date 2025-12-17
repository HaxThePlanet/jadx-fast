package zendesk.answerbot;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.cardview.widget.CardView;
import androidx.core.content.a;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.f;
import com.google.android.material.button.MaterialButton;
import zendesk.commonui.d;
import zendesk.messaging.components.Timer;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
class AnswerBotArticleResultRenderer {

    private final BottomSheetBehavior<CardView> bottomSheetBehavior;
    private final int defaultBtnTextColor;
    private final ColorStateList defaultBtnTint;
    private final MaterialButton negativeResolutionBtn;
    private final MaterialButton positiveResolutionBtn;
    private final int pressedBtnTextColor;
    private final ColorStateList pressedBtnTint;
    private final TextView questionLabel;
    private final ViewGroup resolutionButtonParent;
    private final Timer.Factory timerFactory;

    static class BottomSheetCallback extends BottomSheetBehavior.f {

        final BottomSheetBehavior<CardView> bottomSheetBehavior;
        final ViewGroup.MarginLayoutParams params;
        final ViewGroup webViewContainer;
        BottomSheetCallback(BottomSheetBehavior<CardView> bottomSheetBehavior, ViewGroup viewGroup2) {
            super();
            this.bottomSheetBehavior = bottomSheetBehavior;
            this.webViewContainer = viewGroup2;
            this.params = (ViewGroup.MarginLayoutParams)viewGroup2.getLayoutParams();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onStateChanged(View view, int i2) {
            int obj3;
            ViewGroup.MarginLayoutParams obj4;
            final int i = 0;
            if (i2 == 3) {
                this.bottomSheetBehavior.S(i);
                obj4.bottomMargin = view.getHeight();
            } else {
                obj3.bottomMargin = i;
            }
            this.webViewContainer.requestLayout();
        }
    }
    AnswerBotArticleResultRenderer(TextView textView, ViewGroup viewGroup2, MaterialButton materialButton3, MaterialButton materialButton4, View.OnClickListener view$OnClickListener5, View.OnClickListener view$OnClickListener6, BottomSheetBehavior<CardView> bottomSheetBehavior7, zendesk.answerbot.AnswerBotArticleResultRenderer.BottomSheetCallback answerBotArticleResultRenderer$BottomSheetCallback8, Timer.Factory timer$Factory9, ColorStateList colorStateList10, ColorStateList colorStateList11, int i12, int i13) {
        super();
        this.questionLabel = textView;
        this.resolutionButtonParent = viewGroup2;
        this.positiveResolutionBtn = materialButton3;
        this.negativeResolutionBtn = materialButton4;
        this.bottomSheetBehavior = bottomSheetBehavior7;
        this.timerFactory = factory9;
        this.defaultBtnTint = colorStateList10;
        this.pressedBtnTint = colorStateList11;
        this.defaultBtnTextColor = i12;
        this.pressedBtnTextColor = i13;
        bottomSheetBehavior7.M(bottomSheetCallback8);
        materialButton3.setOnClickListener(onClickListener5);
        materialButton4.setOnClickListener(onClickListener6);
    }

    static ColorStateList access$000(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.defaultBtnTint;
    }

    static MaterialButton access$100(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.positiveResolutionBtn;
    }

    static int access$200(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.defaultBtnTextColor;
    }

    static MaterialButton access$300(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.negativeResolutionBtn;
    }

    static TextView access$400(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.questionLabel;
    }

    static ViewGroup access$500(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.resolutionButtonParent;
    }

    static BottomSheetBehavior access$600(zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer) {
        return answerBotArticleResultRenderer.bottomSheetBehavior;
    }

    static zendesk.answerbot.AnswerBotArticleResultRenderer install(zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity, Timer.Factory timer$Factory2, View.OnClickListener view$OnClickListener3, View.OnClickListener view$OnClickListener4) {
        Object obj = answerBotArticleActivity;
        View viewById2 = obj.findViewById(R.id.zab_view_resolution);
        AnswerBotArticleResultRenderer.BottomSheetCallback bottomSheetCallback = new AnswerBotArticleResultRenderer.BottomSheetCallback(BottomSheetBehavior.y((CardView)viewById2), (ViewGroup)obj.findViewById(R.id.zui_container_web_view));
        android.content.Context context = viewById2.getContext();
        final int i = d.e(R.attr.colorPrimary, context, R.color.zui_color_primary);
        super((TextView)viewById2.findViewById(R.id.zab_label_question), (ViewGroup)viewById2.findViewById(R.id.button_parent), (MaterialButton)viewById2.findViewById(R.id.zab_btn_resolution_positive), (MaterialButton)viewById2.findViewById(R.id.zab_btn_resolution_negative), onClickListener3, onClickListener4, BottomSheetBehavior.y(viewById2), bottomSheetCallback, factory2, a.e(context, R.color.zui_color_white_100), ColorStateList.valueOf(i), i, a.d(context, R.color.zui_text_color_light_primary));
        return answerBotArticleResultRenderer;
    }

    void render(zendesk.answerbot.AnswerBotArticleResult answerBotArticleResult) {
        int pressedBtnTextColor;
        int i;
        MaterialButton obj5;
        pressedBtnTextColor = 5;
        if (answerBotArticleResult == null) {
            this.bottomSheetBehavior.Z(pressedBtnTextColor);
            this.questionLabel.setText(R.string.zab_view_article_help_question);
        }
        obj5 = AnswerBotArticleResultRenderer.3.$SwitchMap$zendesk$answerbot$AnswerBotArticleResult[answerBotArticleResult.ordinal()];
        final int i3 = 3;
        final int i4 = 300;
        if (obj5 != 1 && obj5 != 2) {
            i4 = 300;
            if (obj5 != 2) {
                if (obj5 != i3 && obj5 != 4) {
                    if (obj5 != 4) {
                        if (obj5 != pressedBtnTextColor) {
                        } else {
                            this.negativeResolutionBtn.setBackgroundTintList(this.pressedBtnTint);
                            this.negativeResolutionBtn.setTextColor(this.pressedBtnTextColor);
                        }
                    } else {
                        this.positiveResolutionBtn.setBackgroundTintList(this.pressedBtnTint);
                        this.positiveResolutionBtn.setTextColor(this.pressedBtnTextColor);
                    }
                } else {
                }
                AnswerBotArticleResultRenderer.2 anon2 = new AnswerBotArticleResultRenderer.2(this);
                this.timerFactory.create(anon2, i4).start();
            }
            this.negativeResolutionBtn.setBackgroundTintList(this.pressedBtnTint);
            this.negativeResolutionBtn.setTextColor(this.pressedBtnTextColor);
            AnswerBotArticleResultRenderer.1 anon = new AnswerBotArticleResultRenderer.1(this);
            this.timerFactory.create(anon, i4).start();
        }
        this.bottomSheetBehavior.Z(i3);
        this.questionLabel.setText(R.string.zab_view_article_help_question);
    }
}
