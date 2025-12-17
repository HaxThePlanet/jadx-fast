package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u000c\u0010\u0007\u001a\u00020\u0008*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u000c\u0010\u0011\u001a\u00020\u000b*\u00020\u000cH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextInputServiceAndroid_androidKt {

    private static final String DEBUG_CLASS = "TextInputServiceAndroid";
    public static void $r8$lambda$nEtFUEU03rhWZ7PGABg9OjqaO2E(Runnable runnable, long l2) {
        TextInputServiceAndroid_androidKt.asExecutor$lambda$2$lambda$1(runnable, l2);
    }

    public static void $r8$lambda$qQ8zHHsFvyXcidaMIrvwPglQwQQ(Choreographer choreographer, Runnable runnable2) {
        TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable2);
    }

    public static final void access$updateWithEmojiCompat(EditorInfo $receiver) {
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat($receiver);
    }

    public static final Executor asExecutor(Choreographer $this$asExecutor) {
        TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1($this$asExecutor);
        return externalSyntheticLambda1;
    }

    private static final void asExecutor$lambda$2(Choreographer $this_asExecutor, Runnable runnable) {
        TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(runnable);
        $this_asExecutor.postFrameCallback(externalSyntheticLambda0);
    }

    private static final void asExecutor$lambda$2$lambda$1(Runnable $runnable, long it) {
        $runnable.run();
    }

    private static final boolean hasFlag(int bits, int flag) {
        int i;
        i = bits & flag == flag ? 1 : 0;
        return i;
    }

    public static final void update(EditorInfo $this$update, androidx.compose.ui.text.input.ImeOptions imeOptions, androidx.compose.ui.text.input.TextFieldValue textFieldValue) {
        boolean imeAction-eUduSuo;
        Object platformImeOptions;
        int keyboardType-PjHm6EE;
        boolean singleLine;
        int equals-impl0;
        boolean autoCorrect;
        boolean done-eUduSuo;
        boolean sentences-IUNYP9k;
        int i;
        imeAction-eUduSuo = imeOptions.getImeAction-eUduSuo();
        final int i6 = 3;
        final int i7 = 2;
        i = 6;
        final int i8 = 1;
        if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getDefault-eUduSuo())) {
            if (imeOptions.getSingleLine()) {
            } else {
                i = 0;
            }
            $this$update.imeOptions = i;
            platformImeOptions = imeOptions.getPlatformImeOptions();
            platformImeOptions = platformImeOptions.getPrivateImeOptions();
            if (platformImeOptions != null && platformImeOptions != null) {
                platformImeOptions = platformImeOptions.getPrivateImeOptions();
                if (platformImeOptions != null) {
                    done-eUduSuo = 0;
                    $this$update.privateImeOptions = platformImeOptions;
                }
            }
            keyboardType-PjHm6EE = imeOptions.getKeyboardType-PjHm6EE();
            if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getText-PjHm6EE())) {
                $this$update.inputType = i8;
                $this$update.inputType = inputType2 |= i4;
                if (!imeOptions.getSingleLine() && TextInputServiceAndroid_androidKt.hasFlag($this$update.inputType, i8) && ImeAction.equals-impl0(imeOptions.getImeAction-eUduSuo(), ImeAction.Companion.getDefault-eUduSuo())) {
                    if (TextInputServiceAndroid_androidKt.hasFlag($this$update.inputType, i8)) {
                        $this$update.inputType = inputType2 |= i4;
                        if (ImeAction.equals-impl0(imeOptions.getImeAction-eUduSuo(), ImeAction.Companion.getDefault-eUduSuo())) {
                            $this$update.imeOptions = imeOptions3 |= sentences-IUNYP9k;
                        }
                    }
                }
                if (TextInputServiceAndroid_androidKt.hasFlag($this$update.inputType, i8)) {
                    int capitalization-IUNYP9k = imeOptions.getCapitalization-IUNYP9k();
                    if (KeyboardCapitalization.equals-impl0(capitalization-IUNYP9k, KeyboardCapitalization.Companion.getCharacters-IUNYP9k())) {
                        $this$update.inputType = inputType4 |= 4096;
                    } else {
                        if (KeyboardCapitalization.equals-impl0(capitalization-IUNYP9k, KeyboardCapitalization.Companion.getWords-IUNYP9k())) {
                            $this$update.inputType = inputType7 |= 8192;
                        } else {
                            if (KeyboardCapitalization.equals-impl0(capitalization-IUNYP9k, KeyboardCapitalization.Companion.getSentences-IUNYP9k())) {
                                $this$update.inputType = inputType6 |= 16384;
                            }
                        }
                    }
                    if (imeOptions.getAutoCorrect()) {
                        $this$update.inputType = inputType5 |= sentences-IUNYP9k;
                    }
                }
                $this$update.initialSelStart = TextRange.getStart-impl(textFieldValue.getSelection-d9O1mEE());
                $this$update.initialSelEnd = TextRange.getEnd-impl(textFieldValue.getSelection-d9O1mEE());
                EditorInfoCompat.setInitialSurroundingText($this$update, (CharSequence)textFieldValue.getText());
                $this$update.imeOptions = imeOptions4 |= i5;
            } else {
                if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getAscii-PjHm6EE())) {
                    $this$update.inputType = i8;
                    $this$update.imeOptions = imeOptions2 |= sentences-IUNYP9k;
                } else {
                    if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getNumber-PjHm6EE())) {
                        $this$update.inputType = i7;
                    } else {
                        if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getPhone-PjHm6EE())) {
                            $this$update.inputType = i6;
                        } else {
                            if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getUri-PjHm6EE())) {
                                $this$update.inputType = 17;
                            } else {
                                if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getEmail-PjHm6EE())) {
                                    $this$update.inputType = 33;
                                } else {
                                    if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getPassword-PjHm6EE())) {
                                        $this$update.inputType = 129;
                                    } else {
                                        if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
                                            $this$update.inputType = 18;
                                        } else {
                                            if (!KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getDecimal-PjHm6EE())) {
                                            } else {
                                                $this$update.inputType = 8194;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Invalid Keyboard Type".toString());
            throw illegalStateException;
        } else {
            if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getNone-eUduSuo())) {
                i = i8;
            } else {
                if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getGo-eUduSuo())) {
                    i = i7;
                } else {
                    if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getNext-eUduSuo())) {
                        i = 5;
                    } else {
                        if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getPrevious-eUduSuo())) {
                            i = 7;
                        } else {
                            if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getSearch-eUduSuo())) {
                                i = i6;
                            } else {
                                if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getSend-eUduSuo())) {
                                    i = 4;
                                } else {
                                    if (!ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getDone-eUduSuo())) {
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("invalid ImeAction".toString());
        throw illegalStateException2;
    }

    private static final void updateWithEmojiCompat(EditorInfo $this$updateWithEmojiCompat) {
        if (!EmojiCompat.isConfigured()) {
        }
        EmojiCompat.get().updateEditorInfo($this$updateWithEmojiCompat);
    }
}
