package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes5.dex */
public final class TypefaceEmojiSpan extends androidx.emoji2.text.EmojiSpan {

    private static Paint sDebugPaint;
    private TextPaint mWorkingPaint;
    public TypefaceEmojiSpan(androidx.emoji2.text.TypefaceEmojiRasterizer metadata) {
        super(metadata);
    }

    private TextPaint applyCharacterSpanStyles(java.lang.CharSequence text, int start, int end, Paint paint) {
        TextPaint wp;
        int textPaint;
        int pos;
        int i;
        int i2 = 0;
        Object[] spans = (Spanned)text.getSpans(start, end, CharacterStyle.class);
        if (text instanceof Spanned && spans.length != 0) {
            spans = (Spanned)text.getSpans(start, end, CharacterStyle.class);
            if (spans.length != 0) {
                if (spans.length == 1 && (CharacterStyle[])(CharacterStyle[])spans[0] == this) {
                    if (spans[0] == this) {
                    } else {
                        if (this.mWorkingPaint == null) {
                            textPaint = new TextPaint();
                            this.mWorkingPaint = textPaint;
                        }
                        wp.set(paint);
                        pos = 0;
                        for (Object i : obj2) {
                            i.updateDrawState(wp);
                        }
                    }
                } else {
                }
                return wp;
            }
            if (paint instanceof TextPaint) {
                return (TextPaint)paint;
            }
            return i2;
        }
        if (paint instanceof TextPaint) {
            return (TextPaint)paint;
        }
        return i2;
    }

    private static Paint getDebugPaint() {
        Paint sDebugPaint;
        Paint.Style fILL;
        if (TypefaceEmojiSpan.sDebugPaint == null) {
            TextPaint textPaint = new TextPaint();
            TypefaceEmojiSpan.sDebugPaint = textPaint;
            TypefaceEmojiSpan.sDebugPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            TypefaceEmojiSpan.sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return TypefaceEmojiSpan.sDebugPaint;
    }

    @Override // androidx.emoji2.text.EmojiSpan
    public void draw(Canvas canvas, java.lang.CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        int bgColor;
        boolean emojiSpanIndicatorEnabled;
        Canvas canvas2;
        int i;
        TextPaint characterSpanStyles;
        int i3;
        int i2;
        float debugPaint;
        Object obj;
        TextPaint textPaint;
        final Object obj3 = top;
        final Object obj4 = bottom;
        final Paint paint2 = paint;
        characterSpanStyles = applyCharacterSpanStyles(text, start, end, paint2);
        if (characterSpanStyles != null && characterSpanStyles.bgColor != 0) {
            if (characterSpanStyles.bgColor != 0) {
                this.drawBackground(canvas, characterSpanStyles, x, x + f, (float)obj3, (float)obj4);
                textPaint = characterSpanStyles;
            } else {
                textPaint = characterSpanStyles;
            }
        } else {
        }
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(x, (float)obj3, x + f2, (float)obj4, TypefaceEmojiSpan.getDebugPaint());
        } else {
            i = x;
        }
        obj = textPaint != null ? textPaint : paint2;
        getTypefaceRasterizer().draw(canvas, x, (float)obj2, obj);
    }

    @Override // androidx.emoji2.text.EmojiSpan
    void drawBackground(Canvas c, TextPaint textPaint, float leftX, float rightX, float top, float bottom) {
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        final Object obj10 = textPaint;
        c.drawRect(leftX, top, rightX, bottom, obj10);
        obj10.setStyle(textPaint.getStyle());
        obj10.setColor(textPaint.getColor());
    }
}
