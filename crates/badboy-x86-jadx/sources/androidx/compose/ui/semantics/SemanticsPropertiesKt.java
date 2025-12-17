package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a!\u0010\u009d\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009f\u00010\u009e\u0001\"\u0005\u0008\u0000\u0010\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\u0019H\u0000\u001aD\u0010\u009d\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009f\u00010\u009e\u0001\"\u0005\u0008\u0000\u0010\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\u00192!\u0010¡\u0001\u001a\u001c\u0012\u0007\u0012\u0005\u0018\u0001H\u009f\u0001\u0012\u0005\u0012\u0003H\u009f\u0001\u0012\u0007\u0012\u0005\u0018\u0001H\u009f\u00010¢\u0001H\u0000\u001a4\u0010£\u0001\u001a\u0011\u0012\u000c\u0012\n\u0012\u0005\u0012\u0003H\u009f\u00010¤\u00010\u009e\u0001\"\u0010\u0008\u0000\u0010\u009f\u0001*\t\u0012\u0004\u0012\u0002050¥\u00012\u0007\u0010 \u0001\u001a\u00020\u0019H\u0082\u0008\u001a\u0017\u0010¦\u0001\u001a\u0003H\u009f\u0001\"\u0005\u0008\u0000\u0010\u009f\u0001H\u0002¢\u0006\u0003\u0010§\u0001\u001a+\u0010¨\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010­\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010®\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010¯\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a\u000c\u0010°\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a\u000c\u0010±\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a+\u0010²\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a\u0015\u0010³\u0001\u001a\u00030©\u0001*\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u0019\u001a+\u0010µ\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a,\u0010¶\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0011\u0010«\u0001\u001a\u000c\u0012\u0007\u0012\u0005\u0018\u00010\u0092\u00010¬\u0001\u001a9\u0010·\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u001e\u0010«\u0001\u001a\u0019\u0012\u000c\u0012\n\u0012\u0005\u0012\u00030º\u00010¹\u0001\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a\u000c\u0010»\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a#\u0010¼\u0001\u001a\u00030©\u0001*\u00020\u00032\u0015\u0010½\u0001\u001a\u0010\u0012\u0005\u0012\u00030¾\u0001\u0012\u0004\u0012\u00020\\0¸\u0001\u001a1\u0010¿\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a\u000e\u0010À\u0001\u001a\u00030©\u0001*\u00020\u0003H\u0007\u001a3\u0010Á\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001H\u0000\u001a+\u0010Â\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a@\u0010Ã\u0001\u001a\u00030©\u0001*\u00020\u00032\u0007\u0010Ä\u0001\u001a\u00020C2\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001ø\u0001\u0000¢\u0006\u0006\u0008Å\u0001\u0010Æ\u0001\u001a+\u0010Ç\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010È\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010É\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010Ê\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a+\u0010Ë\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a\u000c\u0010Ì\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a+\u0010Í\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a-\u0010Î\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001H\u0007\u001a\u000c\u0010Ï\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a+\u0010Ð\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u000205\u0018\u00010¬\u0001\u001a]\u0010Ñ\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192B\u0010«\u0001\u001a=\u0012\u0017\u0012\u00150\u0092\u0001¢\u0006\u000f\u0008Ò\u0001\u0012\n\u0008 \u0001\u0012\u0005\u0008\u0008(Ó\u0001\u0012\u0017\u0012\u00150\u0092\u0001¢\u0006\u000f\u0008Ò\u0001\u0012\n\u0008 \u0001\u0012\u0005\u0008\u0008(Ô\u0001\u0012\u0004\u0012\u000205\u0018\u00010¢\u0001\u001aN\u0010Õ\u0001\u001a\u00030©\u0001*\u00020\u00032:\u0010«\u0001\u001a5\u0008\u0001\u0012\u0017\u0012\u00150Ö\u0001¢\u0006\u000f\u0008Ò\u0001\u0012\n\u0008 \u0001\u0012\u0005\u0008\u0008(×\u0001\u0012\u000c\u0012\n\u0012\u0005\u0012\u00030Ö\u00010Ø\u0001\u0012\u0007\u0012\u0005\u0018\u00010¾\u00010¢\u0001¢\u0006\u0003\u0010Ù\u0001\u001a/\u0010Ú\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u0002050¸\u0001\u001a\u000c\u0010Û\u0001\u001a\u00030©\u0001*\u00020\u0003\u001a2\u0010Ü\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0017\u0010«\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001as\u0010Ý\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192X\u0010«\u0001\u001aS\u0012\u0016\u0012\u00140\\¢\u0006\u000f\u0008Ò\u0001\u0012\n\u0008 \u0001\u0012\u0005\u0008\u0008(ß\u0001\u0012\u0016\u0012\u00140\\¢\u0006\u000f\u0008Ò\u0001\u0012\n\u0008 \u0001\u0012\u0005\u0008\u0008(à\u0001\u0012\u0016\u0012\u001405¢\u0006\u000f\u0008Ò\u0001\u0012\n\u0008 \u0001\u0012\u0005\u0008\u0008(á\u0001\u0012\u0004\u0012\u000205\u0018\u00010Þ\u0001\u001a0\u0010\u007f\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a1\u0010\u008a\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\u001a1\u0010â\u0001\u001a\u00030©\u0001*\u00020\u00032\u000b\u0008\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u00192\u0016\u0010«\u0001\u001a\u0011\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010¸\u0001\"/\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t*\u0004\u0008\u0004\u0010\u0005\"/\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010*\u0004\u0008\u000c\u0010\u0005\"/\u0010\u0012\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017*\u0004\u0008\u0013\u0010\u0005\"(\u0010\u001a\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001e\"/\u0010 \u001a\u00020\u001f*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u001f8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%*\u0004\u0008!\u0010\u0005\";\u0010(\u001a\u0008\u0012\u0004\u0012\u00020'0&*\u00020\u00032\u000c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020'0&8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-*\u0004\u0008)\u0010\u0005\"/\u0010/\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104*\u0004\u00080\u0010\u0005\"/\u00106\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;*\u0004\u00087\u0010\u0005\"/\u0010=\u001a\u00020<*\u00020\u00032\u0006\u0010\u0000\u001a\u00020<8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008?\u0010@\"\u0004\u0008A\u0010B*\u0004\u0008>\u0010\u0005\"5\u0010D\u001a\u00020C*\u00020\u00032\u0006\u0010\u0000\u001a\u00020C8G@GX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\u0008E\u0010F\u001a\u0004\u0008H\u0010\u0015\"\u0004\u0008I\u0010\u0017*\u0004\u0008G\u0010\u0005\"5\u0010J\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\u0008K\u0010F\u001a\u0004\u0008J\u00109\"\u0004\u0008M\u0010;*\u0004\u0008L\u0010\u0005\"/\u0010N\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008N\u00109\"\u0004\u0008P\u0010;*\u0004\u0008O\u0010\u0005\"/\u0010Q\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008Q\u00109\"\u0004\u0008S\u0010;*\u0004\u0008R\u0010\u0005\"/\u0010T\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008T\u00109\"\u0004\u0008V\u0010;*\u0004\u0008U\u0010\u0005\"/\u0010X\u001a\u00020W*\u00020\u00032\u0006\u0010\u0000\u001a\u00020W8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008Z\u0010\u0015\"\u0004\u0008[\u0010\u0017*\u0004\u0008Y\u0010\u0005\"/\u0010]\u001a\u00020\\*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\\8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008_\u0010\u0015\"\u0004\u0008`\u0010\u0017*\u0004\u0008^\u0010\u0005\"/\u0010a\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008c\u0010\u001c\"\u0004\u0008d\u0010\u001e*\u0004\u0008b\u0010\u0005\"/\u0010f\u001a\u00020e*\u00020\u00032\u0006\u0010\u0000\u001a\u00020e8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008h\u0010i\"\u0004\u0008j\u0010k*\u0004\u0008g\u0010\u0005\"/\u0010m\u001a\u00020l*\u00020\u00032\u0006\u0010\u0000\u001a\u00020l8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008o\u0010\u0015\"\u0004\u0008p\u0010\u0017*\u0004\u0008n\u0010\u0005\"/\u0010q\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008s\u00109\"\u0004\u0008t\u0010;*\u0004\u0008r\u0010\u0005\"/\u0010u\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008w\u0010\u001c\"\u0004\u0008x\u0010\u001e*\u0004\u0008v\u0010\u0005\"/\u0010y\u001a\u00020\u0019*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\u0008{\u0010\u001c\"\u0004\u0008|\u0010\u001e*\u0004\u0008z\u0010\u0005\"(\u0010}\u001a\u00020.*\u00020\u00032\u0006\u0010\u0018\u001a\u00020.8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008~\u00102\"\u0004\u0008\u007f\u00104\"7\u0010\u0081\u0001\u001a\u00030\u0080\u0001*\u00020\u00032\u0007\u0010\u0000\u001a\u00030\u0080\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\u0008\u0083\u0001\u0010\u0084\u0001\"\u0006\u0008\u0085\u0001\u0010\u0086\u0001*\u0005\u0008\u0082\u0001\u0010\u0005\"3\u0010\u0087\u0001\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\u0008\u0089\u0001\u00102\"\u0005\u0008\u008a\u0001\u00104*\u0005\u0008\u0088\u0001\u0010\u0005\"7\u0010\u008c\u0001\u001a\u00030\u008b\u0001*\u00020\u00032\u0007\u0010\u0000\u001a\u00030\u008b\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\u0008\u008e\u0001\u0010\u008f\u0001\"\u0006\u0008\u0090\u0001\u0010\u0091\u0001*\u0005\u0008\u008d\u0001\u0010\u0005\"7\u0010\u0093\u0001\u001a\u00030\u0092\u0001*\u00020\u00032\u0007\u0010\u0000\u001a\u00030\u0092\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\u0008\u0095\u0001\u0010\u0096\u0001\"\u0006\u0008\u0097\u0001\u0010\u0098\u0001*\u0005\u0008\u0094\u0001\u0010\u0005\"3\u0010\u0099\u0001\u001a\u00020<*\u00020\u00032\u0006\u0010\u0000\u001a\u00020<8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\u0008\u009b\u0001\u0010@\"\u0005\u0008\u009c\u0001\u0010B*\u0005\u0008\u009a\u0001\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006ã\u0001", d2 = {"<set-?>", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getCollectionInfo$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo$delegate", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "Landroidx/compose/ui/autofill/ContentDataType;", "contentDataType", "getContentDataType$delegate", "getContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setContentDataType-NTL_tik", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "value", "", "contentDescription", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "Landroidx/compose/ui/autofill/ContentType;", "contentType", "getContentType$delegate", "getContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", "setContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentType;)V", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions$delegate", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "Landroidx/compose/ui/text/AnnotatedString;", "editableText", "getEditableText$delegate", "getEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "", "focused", "getFocused$delegate", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange$delegate", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getImeAction$delegate", "getImeAction", "setImeAction-4L7nppU", "isContainer", "isContainer$annotations", "isContainer$delegate", "setContainer", "isEditable", "isEditable$delegate", "setEditable", "isShowingTextSubstitution", "isShowingTextSubstitution$delegate", "setShowingTextSubstitution", "isTraversalGroup", "isTraversalGroup$delegate", "setTraversalGroup", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion$delegate", "getLiveRegion", "setLiveRegion-hR3wRGc", "", "maxTextLength", "getMaxTextLength$delegate", "getMaxTextLength", "setMaxTextLength", "paneTitle", "getPaneTitle$delegate", "getPaneTitle", "setPaneTitle", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo$delegate", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "Landroidx/compose/ui/semantics/Role;", "role", "getRole$delegate", "getRole", "setRole-kuIjeqM", "selected", "getSelected$delegate", "getSelected", "setSelected", "stateDescription", "getStateDescription$delegate", "getStateDescription", "setStateDescription", "testTag", "getTestTag$delegate", "getTestTag", "setTestTag", "text", "getText", "setText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange$delegate", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "textSubstitution", "getTextSubstitution$delegate", "getTextSubstitution", "setTextSubstitution", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState$delegate", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "", "traversalIndex", "getTraversalIndex$delegate", "getTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", "setTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;F)V", "verticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "AccessibilityKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "name", "mergePolicy", "Lkotlin/Function2;", "ActionPropertyKey", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function;", "throwSemanticsGetNotSupported", "()Ljava/lang/Object;", "clearTextSubstitution", "", "label", "action", "Lkotlin/Function0;", "collapse", "copyText", "cutText", "dialog", "disabled", "dismiss", "error", "description", "expand", "getScrollViewportLength", "getTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "heading", "indexForKey", "mapping", "", "insertTextAtCursor", "invisibleToUser", "onAutofillText", "onClick", "onImeAction", "imeActionType", "onImeAction-9UiTYpY", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onLongClick", "pageDown", "pageLeft", "pageRight", "pageUp", "password", "pasteText", "performImeAction", "popup", "requestFocus", "scrollBy", "Lkotlin/ParameterName;", "x", "y", "scrollByOffset", "Landroidx/compose/ui/geometry/Offset;", "offset", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function2;)V", "scrollToIndex", "selectableGroup", "setProgress", "setSelection", "Lkotlin/Function3;", "startIndex", "endIndex", "relativeToOriginalText", "showTextSubstitution", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsPropertiesKt {

    static final KProperty<Object>[] $$delegatedProperties;
    static {
        KProperty[] arr = new KProperty[26];
        Class<androidx.compose.ui.semantics.SemanticsPropertiesKt> obj = SemanticsPropertiesKt.class;
        final int i27 = 1;
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(obj, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", i27);
        MutablePropertyReference1Impl mutablePropertyReference1Impl2 = new MutablePropertyReference1Impl(obj, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", i27);
        arr[i27] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl2);
        MutablePropertyReference1Impl mutablePropertyReference1Impl3 = new MutablePropertyReference1Impl(obj, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", i27);
        arr[2] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl3);
        MutablePropertyReference1Impl mutablePropertyReference1Impl4 = new MutablePropertyReference1Impl(obj, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", i27);
        arr[3] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl4);
        MutablePropertyReference1Impl mutablePropertyReference1Impl5 = new MutablePropertyReference1Impl(obj, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i27);
        arr[4] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl5);
        MutablePropertyReference1Impl mutablePropertyReference1Impl6 = new MutablePropertyReference1Impl(obj, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i27);
        arr[5] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl6);
        MutablePropertyReference1Impl mutablePropertyReference1Impl7 = new MutablePropertyReference1Impl(obj, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i27);
        arr[6] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl7);
        MutablePropertyReference1Impl mutablePropertyReference1Impl8 = new MutablePropertyReference1Impl(obj, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", i27);
        arr[7] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl8);
        MutablePropertyReference1Impl mutablePropertyReference1Impl9 = new MutablePropertyReference1Impl(obj, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", i27);
        arr[8] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl9);
        MutablePropertyReference1Impl mutablePropertyReference1Impl10 = new MutablePropertyReference1Impl(obj, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", i27);
        arr[9] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl10);
        MutablePropertyReference1Impl mutablePropertyReference1Impl11 = new MutablePropertyReference1Impl(obj, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", i27);
        arr[10] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl11);
        MutablePropertyReference1Impl mutablePropertyReference1Impl12 = new MutablePropertyReference1Impl(obj, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", i27);
        arr[11] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl12);
        MutablePropertyReference1Impl mutablePropertyReference1Impl13 = new MutablePropertyReference1Impl(obj, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", i27);
        arr[12] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl13);
        MutablePropertyReference1Impl mutablePropertyReference1Impl14 = new MutablePropertyReference1Impl(obj, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", i27);
        arr[13] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl14);
        MutablePropertyReference1Impl mutablePropertyReference1Impl15 = new MutablePropertyReference1Impl(obj, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", i27);
        arr[14] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl15);
        MutablePropertyReference1Impl mutablePropertyReference1Impl16 = new MutablePropertyReference1Impl(obj, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i27);
        arr[15] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl16);
        MutablePropertyReference1Impl mutablePropertyReference1Impl17 = new MutablePropertyReference1Impl(obj, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", i27);
        arr[16] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl17);
        MutablePropertyReference1Impl mutablePropertyReference1Impl18 = new MutablePropertyReference1Impl(obj, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", i27);
        arr[17] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl18);
        MutablePropertyReference1Impl mutablePropertyReference1Impl19 = new MutablePropertyReference1Impl(obj, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", i27);
        arr[18] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl19);
        MutablePropertyReference1Impl mutablePropertyReference1Impl20 = new MutablePropertyReference1Impl(obj, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i27);
        arr[19] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl20);
        MutablePropertyReference1Impl mutablePropertyReference1Impl21 = new MutablePropertyReference1Impl(obj, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", i27);
        arr[20] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl21);
        MutablePropertyReference1Impl mutablePropertyReference1Impl22 = new MutablePropertyReference1Impl(obj, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", i27);
        arr[21] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl22);
        MutablePropertyReference1Impl mutablePropertyReference1Impl23 = new MutablePropertyReference1Impl(obj, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", i27);
        arr[22] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl23);
        MutablePropertyReference1Impl mutablePropertyReference1Impl24 = new MutablePropertyReference1Impl(obj, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i27);
        arr[23] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl24);
        MutablePropertyReference1Impl mutablePropertyReference1Impl25 = new MutablePropertyReference1Impl(obj, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", i27);
        arr[24] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl25);
        MutablePropertyReference1Impl mutablePropertyReference1Impl26 = new MutablePropertyReference1Impl(obj, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", i27);
        arr[25] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl26);
        SemanticsPropertiesKt.$$delegatedProperties = arr;
        SemanticsProperties.INSTANCE.getStateDescription();
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
        SemanticsProperties.INSTANCE.getPaneTitle();
        SemanticsProperties.INSTANCE.getLiveRegion();
        SemanticsProperties.INSTANCE.getFocused();
        SemanticsProperties.INSTANCE.getIsTraversalGroup();
        SemanticsProperties.INSTANCE.getIsTraversalGroup();
        SemanticsProperties.INSTANCE.getContentType$ui_release();
        SemanticsProperties.INSTANCE.getContentDataType$ui_release();
        SemanticsProperties.INSTANCE.getTraversalIndex();
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        SemanticsProperties.INSTANCE.getRole();
        SemanticsProperties.INSTANCE.getTestTag();
        SemanticsProperties.INSTANCE.getTextSubstitution();
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution();
        SemanticsProperties.INSTANCE.getEditableText();
        SemanticsProperties.INSTANCE.getTextSelectionRange();
        SemanticsProperties.INSTANCE.getImeAction();
        SemanticsProperties.INSTANCE.getSelected();
        SemanticsProperties.INSTANCE.getCollectionInfo();
        SemanticsProperties.INSTANCE.getCollectionItemInfo();
        SemanticsProperties.INSTANCE.getToggleableState();
        SemanticsProperties.INSTANCE.getIsEditable();
        SemanticsProperties.INSTANCE.getMaxTextLength();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final <T> androidx.compose.ui.semantics.SemanticsPropertyKey<T> AccessibilityKey(String name) {
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey(name, 1);
        return semanticsPropertyKey;
    }

    public static final <T> androidx.compose.ui.semantics.SemanticsPropertyKey<T> AccessibilityKey(String name, Function2<? super T, ? super T, ? extends T> mergePolicy) {
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey(name, 1, mergePolicy);
        return semanticsPropertyKey;
    }

    private static final <T extends kotlin.Function<? extends Boolean>> androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<T>> ActionPropertyKey(String name) {
        final int i = 0;
        return SemanticsPropertiesKt.AccessibilityKey(name, (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
    }

    public static final Object access$throwSemanticsGetNotSupported() {
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public static final void clearTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$clearTextSubstitution, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$clearTextSubstitution.set(SemanticsActions.INSTANCE.getClearTextSubstitution(), accessibilityAction);
    }

    public static void clearTextSubstitution$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.clearTextSubstitution(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void collapse(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$collapse, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$collapse.set(SemanticsActions.INSTANCE.getCollapse(), accessibilityAction);
    }

    public static void collapse$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void copyText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$copyText, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$copyText.set(SemanticsActions.INSTANCE.getCopyText(), accessibilityAction);
    }

    public static void copyText$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.copyText(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void cutText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$cutText, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$cutText.set(SemanticsActions.INSTANCE.getCutText(), accessibilityAction);
    }

    public static void cutText$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.cutText(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void dialog(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$dialog) {
        $this$dialog.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    public static final void disabled(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$disabled) {
        $this$disabled.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    public static final void dismiss(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$dismiss, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$dismiss.set(SemanticsActions.INSTANCE.getDismiss(), accessibilityAction);
    }

    public static void dismiss$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void error(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$error, String description) {
        $this$error.set(SemanticsProperties.INSTANCE.getError(), description);
    }

    public static final void expand(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$expand, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$expand.set(SemanticsActions.INSTANCE.getExpand(), accessibilityAction);
    }

    public static void expand$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.expand(semanticsPropertyReceiver, obj1, function03);
    }

    public static final androidx.compose.ui.semantics.CollectionInfo getCollectionInfo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$collectionInfo) {
        return (CollectionInfo)SemanticsProperties.INSTANCE.getCollectionInfo().getValue($this$collectionInfo, SemanticsPropertiesKt.$$delegatedProperties[20]);
    }

    private static Object getCollectionInfo$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getCollectionInfo();
    }

    public static final androidx.compose.ui.semantics.CollectionItemInfo getCollectionItemInfo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$collectionItemInfo) {
        return (CollectionItemInfo)SemanticsProperties.INSTANCE.getCollectionItemInfo().getValue($this$collectionItemInfo, SemanticsPropertiesKt.$$delegatedProperties[21]);
    }

    private static Object getCollectionItemInfo$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo();
    }

    public static final int getContentDataType(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$contentDataType) {
        return (ContentDataType)SemanticsProperties.INSTANCE.getContentDataType$ui_release().getValue($this$contentDataType, SemanticsPropertiesKt.$$delegatedProperties[8]).unbox-impl();
    }

    private static Object getContentDataType$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getContentDataType$ui_release();
    }

    public static final String getContentDescription(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$contentDescription) {
        return (String)SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public static final ContentType getContentType(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$contentType) {
        return (ContentType)SemanticsProperties.INSTANCE.getContentType$ui_release().getValue($this$contentType, SemanticsPropertiesKt.$$delegatedProperties[7]);
    }

    private static Object getContentType$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getContentType$ui_release();
    }

    public static final List<androidx.compose.ui.semantics.CustomAccessibilityAction> getCustomActions(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$customActions) {
        return (List)SemanticsActions.INSTANCE.getCustomActions().getValue($this$customActions, SemanticsPropertiesKt.$$delegatedProperties[25]);
    }

    private static Object getCustomActions$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final AnnotatedString getEditableText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$editableText) {
        return (AnnotatedString)SemanticsProperties.INSTANCE.getEditableText().getValue($this$editableText, SemanticsPropertiesKt.$$delegatedProperties[16]);
    }

    private static Object getEditableText$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getEditableText();
    }

    public static final boolean getFocused(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$focused) {
        return (Boolean)SemanticsProperties.INSTANCE.getFocused().getValue($this$focused, SemanticsPropertiesKt.$$delegatedProperties[4]).booleanValue();
    }

    private static Object getFocused$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getFocused();
    }

    public static final androidx.compose.ui.semantics.ScrollAxisRange getHorizontalScrollAxisRange(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$horizontalScrollAxisRange) {
        return (ScrollAxisRange)SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().getValue($this$horizontalScrollAxisRange, SemanticsPropertiesKt.$$delegatedProperties[10]);
    }

    private static Object getHorizontalScrollAxisRange$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static final int getImeAction(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$imeAction) {
        return (ImeAction)SemanticsProperties.INSTANCE.getImeAction().getValue($this$imeAction, SemanticsPropertiesKt.$$delegatedProperties[18]).unbox-impl();
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static void getImeAction$annotations(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    private static Object getImeAction$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getImeAction();
    }

    public static final int getLiveRegion(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$liveRegion) {
        return (LiveRegionMode)SemanticsProperties.INSTANCE.getLiveRegion().getValue($this$liveRegion, SemanticsPropertiesKt.$$delegatedProperties[3]).unbox-impl();
    }

    private static Object getLiveRegion$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getLiveRegion();
    }

    public static final int getMaxTextLength(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$maxTextLength) {
        return (Number)SemanticsProperties.INSTANCE.getMaxTextLength().getValue($this$maxTextLength, SemanticsPropertiesKt.$$delegatedProperties[24]).intValue();
    }

    private static Object getMaxTextLength$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getMaxTextLength();
    }

    public static final String getPaneTitle(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$paneTitle) {
        return (String)SemanticsProperties.INSTANCE.getPaneTitle().getValue($this$paneTitle, SemanticsPropertiesKt.$$delegatedProperties[2]);
    }

    private static Object getPaneTitle$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getPaneTitle();
    }

    public static final androidx.compose.ui.semantics.ProgressBarRangeInfo getProgressBarRangeInfo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$progressBarRangeInfo) {
        return (ProgressBarRangeInfo)SemanticsProperties.INSTANCE.getProgressBarRangeInfo().getValue($this$progressBarRangeInfo, SemanticsPropertiesKt.$$delegatedProperties[1]);
    }

    private static Object getProgressBarRangeInfo$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
    }

    public static final int getRole(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$role) {
        return (Role)SemanticsProperties.INSTANCE.getRole().getValue($this$role, SemanticsPropertiesKt.$$delegatedProperties[12]).unbox-impl();
    }

    private static Object getRole$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getRole();
    }

    public static final void getScrollViewportLength(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$getScrollViewportLength, String label, Function0<Float> action) {
        SemanticsPropertiesKt.getScrollViewportLength.1 anon = new SemanticsPropertiesKt.getScrollViewportLength.1(action);
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)anon);
        $this$getScrollViewportLength.set(SemanticsActions.INSTANCE.getGetScrollViewportLength(), accessibilityAction);
    }

    public static void getScrollViewportLength$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.getScrollViewportLength(semanticsPropertyReceiver, obj1, function03);
    }

    public static final boolean getSelected(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$selected) {
        return (Boolean)SemanticsProperties.INSTANCE.getSelected().getValue($this$selected, SemanticsPropertiesKt.$$delegatedProperties[19]).booleanValue();
    }

    private static Object getSelected$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getSelected();
    }

    public static final String getStateDescription(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$stateDescription) {
        return (String)SemanticsProperties.INSTANCE.getStateDescription().getValue($this$stateDescription, SemanticsPropertiesKt.$$delegatedProperties[0]);
    }

    private static Object getStateDescription$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getStateDescription();
    }

    public static final String getTestTag(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$testTag) {
        return (String)SemanticsProperties.INSTANCE.getTestTag().getValue($this$testTag, SemanticsPropertiesKt.$$delegatedProperties[13]);
    }

    private static Object getTestTag$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getTestTag();
    }

    public static final AnnotatedString getText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$text) {
        return (AnnotatedString)SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public static final void getTextLayoutResult(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$getTextLayoutResult, String label, Function1<? super List<TextLayoutResult>, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$getTextLayoutResult.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), accessibilityAction);
    }

    public static void getTextLayoutResult$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.getTextLayoutResult(semanticsPropertyReceiver, obj1, function13);
    }

    public static final long getTextSelectionRange(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$textSelectionRange) {
        return (TextRange)SemanticsProperties.INSTANCE.getTextSelectionRange().getValue($this$textSelectionRange, SemanticsPropertiesKt.$$delegatedProperties[17]).unbox-impl();
    }

    private static Object getTextSelectionRange$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange();
    }

    public static final AnnotatedString getTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$textSubstitution) {
        return (AnnotatedString)SemanticsProperties.INSTANCE.getTextSubstitution().getValue($this$textSubstitution, SemanticsPropertiesKt.$$delegatedProperties[14]);
    }

    private static Object getTextSubstitution$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getTextSubstitution();
    }

    public static final ToggleableState getToggleableState(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$toggleableState) {
        return (ToggleableState)SemanticsProperties.INSTANCE.getToggleableState().getValue($this$toggleableState, SemanticsPropertiesKt.$$delegatedProperties[22]);
    }

    private static Object getToggleableState$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getToggleableState();
    }

    public static final float getTraversalIndex(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$traversalIndex) {
        return (Number)SemanticsProperties.INSTANCE.getTraversalIndex().getValue($this$traversalIndex, SemanticsPropertiesKt.$$delegatedProperties[9]).floatValue();
    }

    private static Object getTraversalIndex$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getTraversalIndex();
    }

    public static final androidx.compose.ui.semantics.ScrollAxisRange getVerticalScrollAxisRange(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$verticalScrollAxisRange) {
        return (ScrollAxisRange)SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().getValue($this$verticalScrollAxisRange, SemanticsPropertiesKt.$$delegatedProperties[11]);
    }

    private static Object getVerticalScrollAxisRange$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
    }

    public static final void heading(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$heading) {
        $this$heading.set(SemanticsProperties.INSTANCE.getHeading(), Unit.INSTANCE);
    }

    public static final void indexForKey(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$indexForKey, Function1<Object, Integer> mapping) {
        $this$indexForKey.set(SemanticsProperties.INSTANCE.getIndexForKey(), mapping);
    }

    public static final void insertTextAtCursor(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$insertTextAtCursor, String label, Function1<? super AnnotatedString, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$insertTextAtCursor.set(SemanticsActions.INSTANCE.getInsertTextAtCursor(), accessibilityAction);
    }

    public static void insertTextAtCursor$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.insertTextAtCursor(semanticsPropertyReceiver, obj1, function13);
    }

    public static final void invisibleToUser(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$invisibleToUser) {
        $this$invisibleToUser.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), Unit.INSTANCE);
    }

    public static final boolean isContainer(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isContainer) {
        return (Boolean)SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue($this$isContainer, SemanticsPropertiesKt.$$delegatedProperties[5]).booleanValue();
    }

    @Deprecated(message = "Use `isTraversalGroup` instead.", replaceWith = @ReplaceWith(...))
    public static void isContainer$annotations(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    private static Object isContainer$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup();
    }

    public static final boolean isEditable(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isEditable) {
        return (Boolean)SemanticsProperties.INSTANCE.getIsEditable().getValue($this$isEditable, SemanticsPropertiesKt.$$delegatedProperties[23]).booleanValue();
    }

    private static Object isEditable$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getIsEditable();
    }

    public static final boolean isShowingTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isShowingTextSubstitution) {
        return (Boolean)SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().getValue($this$isShowingTextSubstitution, SemanticsPropertiesKt.$$delegatedProperties[15]).booleanValue();
    }

    private static Object isShowingTextSubstitution$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution();
    }

    public static final boolean isTraversalGroup(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isTraversalGroup) {
        return (Boolean)SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue($this$isTraversalGroup, SemanticsPropertiesKt.$$delegatedProperties[6]).booleanValue();
    }

    private static Object isTraversalGroup$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup();
    }

    public static final void onAutofillText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$onAutofillText, String label, Function1<? super AnnotatedString, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$onAutofillText.set(SemanticsActions.INSTANCE.getOnAutofillText$ui_release(), accessibilityAction);
    }

    public static void onAutofillText$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.onAutofillText(semanticsPropertyReceiver, obj1, function13);
    }

    public static final void onClick(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$onClick, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$onClick.set(SemanticsActions.INSTANCE.getOnClick(), accessibilityAction);
    }

    public static void onClick$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void onImeAction-9UiTYpY(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$onImeAction_u2d9UiTYpY, int imeActionType, String label, Function0<Boolean> action) {
        $this$onImeAction_u2d9UiTYpY.set(SemanticsProperties.INSTANCE.getImeAction(), ImeAction.box-impl(imeActionType));
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$onImeAction_u2d9UiTYpY.set(SemanticsActions.INSTANCE.getOnImeAction(), accessibilityAction);
    }

    public static void onImeAction-9UiTYpY$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, int i2, String string3, Function0 function04, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        SemanticsPropertiesKt.onImeAction-9UiTYpY(semanticsPropertyReceiver, i2, obj2, function04);
    }

    public static final void onLongClick(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$onLongClick, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$onLongClick.set(SemanticsActions.INSTANCE.getOnLongClick(), accessibilityAction);
    }

    public static void onLongClick$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void pageDown(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$pageDown, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$pageDown.set(SemanticsActions.INSTANCE.getPageDown(), accessibilityAction);
    }

    public static void pageDown$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.pageDown(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void pageLeft(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$pageLeft, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$pageLeft.set(SemanticsActions.INSTANCE.getPageLeft(), accessibilityAction);
    }

    public static void pageLeft$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.pageLeft(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void pageRight(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$pageRight, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$pageRight.set(SemanticsActions.INSTANCE.getPageRight(), accessibilityAction);
    }

    public static void pageRight$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.pageRight(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void pageUp(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$pageUp, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$pageUp.set(SemanticsActions.INSTANCE.getPageUp(), accessibilityAction);
    }

    public static void pageUp$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.pageUp(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void password(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$password) {
        $this$password.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void pasteText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$pasteText, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$pasteText.set(SemanticsActions.INSTANCE.getPasteText(), accessibilityAction);
    }

    public static void pasteText$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.pasteText(semanticsPropertyReceiver, obj1, function03);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `SemanticsPropertyReceiver.onImeAction` instead.", replaceWith = @ReplaceWith(...))
    public static final void performImeAction(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$performImeAction, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$performImeAction.set(SemanticsActions.INSTANCE.getOnImeAction(), accessibilityAction);
    }

    public static void performImeAction$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.performImeAction(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void popup(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$popup) {
        $this$popup.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void requestFocus(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$requestFocus, String label, Function0<Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$requestFocus.set(SemanticsActions.INSTANCE.getRequestFocus(), accessibilityAction);
    }

    public static void requestFocus$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function0 function03, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.requestFocus(semanticsPropertyReceiver, obj1, function03);
    }

    public static final void scrollBy(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$scrollBy, String label, Function2<? super Float, ? super Float, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$scrollBy.set(SemanticsActions.INSTANCE.getScrollBy(), accessibilityAction);
    }

    public static void scrollBy$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function2 function23, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.scrollBy(semanticsPropertyReceiver, obj1, function23);
    }

    public static final void scrollByOffset(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$scrollByOffset, Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> action) {
        $this$scrollByOffset.set(SemanticsActions.INSTANCE.getScrollByOffset(), action);
    }

    public static final void scrollToIndex(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$scrollToIndex, String label, Function1<? super Integer, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$scrollToIndex.set(SemanticsActions.INSTANCE.getScrollToIndex(), accessibilityAction);
    }

    public static void scrollToIndex$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.scrollToIndex(semanticsPropertyReceiver, obj1, function13);
    }

    public static final void selectableGroup(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$selectableGroup) {
        $this$selectableGroup.set(SemanticsProperties.INSTANCE.getSelectableGroup(), Unit.INSTANCE);
    }

    public static final void setCollectionInfo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$collectionInfo, androidx.compose.ui.semantics.CollectionInfo <set-?>) {
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue($this$collectionInfo, SemanticsPropertiesKt.$$delegatedProperties[20], <set-?>);
    }

    public static final void setCollectionItemInfo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$collectionItemInfo, androidx.compose.ui.semantics.CollectionItemInfo <set-?>) {
        SemanticsProperties.INSTANCE.getCollectionItemInfo().setValue($this$collectionItemInfo, SemanticsPropertiesKt.$$delegatedProperties[21], <set-?>);
    }

    public static final void setContainer(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isContainer, boolean <set-?>) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue($this$isContainer, SemanticsPropertiesKt.$$delegatedProperties[5], Boolean.valueOf(<set-?>));
    }

    public static final void setContentDataType-NTL_tik(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$contentDataType, int <set-?>) {
        SemanticsProperties.INSTANCE.getContentDataType$ui_release().setValue($this$contentDataType, SemanticsPropertiesKt.$$delegatedProperties[8], ContentDataType.box-impl(<set-?>));
    }

    public static final void setContentDescription(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$contentDescription, String value) {
        $this$contentDescription.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(value));
    }

    public static final void setContentType(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$contentType, ContentType <set-?>) {
        SemanticsProperties.INSTANCE.getContentType$ui_release().setValue($this$contentType, SemanticsPropertiesKt.$$delegatedProperties[7], <set-?>);
    }

    public static final void setCustomActions(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$customActions, List<androidx.compose.ui.semantics.CustomAccessibilityAction> <set-?>) {
        SemanticsActions.INSTANCE.getCustomActions().setValue($this$customActions, SemanticsPropertiesKt.$$delegatedProperties[25], <set-?>);
    }

    public static final void setEditable(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isEditable, boolean <set-?>) {
        SemanticsProperties.INSTANCE.getIsEditable().setValue($this$isEditable, SemanticsPropertiesKt.$$delegatedProperties[23], Boolean.valueOf(<set-?>));
    }

    public static final void setEditableText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$editableText, AnnotatedString <set-?>) {
        SemanticsProperties.INSTANCE.getEditableText().setValue($this$editableText, SemanticsPropertiesKt.$$delegatedProperties[16], <set-?>);
    }

    public static final void setFocused(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$focused, boolean <set-?>) {
        SemanticsProperties.INSTANCE.getFocused().setValue($this$focused, SemanticsPropertiesKt.$$delegatedProperties[4], Boolean.valueOf(<set-?>));
    }

    public static final void setHorizontalScrollAxisRange(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$horizontalScrollAxisRange, androidx.compose.ui.semantics.ScrollAxisRange <set-?>) {
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue($this$horizontalScrollAxisRange, SemanticsPropertiesKt.$$delegatedProperties[10], <set-?>);
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static final void setImeAction-4L7nppU(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$imeAction, int <set-?>) {
        SemanticsProperties.INSTANCE.getImeAction().setValue($this$imeAction, SemanticsPropertiesKt.$$delegatedProperties[18], ImeAction.box-impl(<set-?>));
    }

    public static final void setLiveRegion-hR3wRGc(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$liveRegion, int <set-?>) {
        SemanticsProperties.INSTANCE.getLiveRegion().setValue($this$liveRegion, SemanticsPropertiesKt.$$delegatedProperties[3], LiveRegionMode.box-impl(<set-?>));
    }

    public static final void setMaxTextLength(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$maxTextLength, int <set-?>) {
        SemanticsProperties.INSTANCE.getMaxTextLength().setValue($this$maxTextLength, SemanticsPropertiesKt.$$delegatedProperties[24], Integer.valueOf(<set-?>));
    }

    public static final void setPaneTitle(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$paneTitle, String <set-?>) {
        SemanticsProperties.INSTANCE.getPaneTitle().setValue($this$paneTitle, SemanticsPropertiesKt.$$delegatedProperties[2], <set-?>);
    }

    public static final void setProgress(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$setProgress, String label, Function1<? super Float, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$setProgress.set(SemanticsActions.INSTANCE.getSetProgress(), accessibilityAction);
    }

    public static void setProgress$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.setProgress(semanticsPropertyReceiver, obj1, function13);
    }

    public static final void setProgressBarRangeInfo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$progressBarRangeInfo, androidx.compose.ui.semantics.ProgressBarRangeInfo <set-?>) {
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue($this$progressBarRangeInfo, SemanticsPropertiesKt.$$delegatedProperties[1], <set-?>);
    }

    public static final void setRole-kuIjeqM(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$role, int <set-?>) {
        SemanticsProperties.INSTANCE.getRole().setValue($this$role, SemanticsPropertiesKt.$$delegatedProperties[12], Role.box-impl(<set-?>));
    }

    public static final void setSelected(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$selected, boolean <set-?>) {
        SemanticsProperties.INSTANCE.getSelected().setValue($this$selected, SemanticsPropertiesKt.$$delegatedProperties[19], Boolean.valueOf(<set-?>));
    }

    public static final void setSelection(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$setSelection, String label, Function3<? super Integer, ? super Integer, ? super Boolean, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$setSelection.set(SemanticsActions.INSTANCE.getSetSelection(), accessibilityAction);
    }

    public static void setSelection$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function3 function33, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.setSelection(semanticsPropertyReceiver, obj1, function33);
    }

    public static final void setShowingTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isShowingTextSubstitution, boolean <set-?>) {
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().setValue($this$isShowingTextSubstitution, SemanticsPropertiesKt.$$delegatedProperties[15], Boolean.valueOf(<set-?>));
    }

    public static final void setStateDescription(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$stateDescription, String <set-?>) {
        SemanticsProperties.INSTANCE.getStateDescription().setValue($this$stateDescription, SemanticsPropertiesKt.$$delegatedProperties[0], <set-?>);
    }

    public static final void setTestTag(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$testTag, String <set-?>) {
        SemanticsProperties.INSTANCE.getTestTag().setValue($this$testTag, SemanticsPropertiesKt.$$delegatedProperties[13], <set-?>);
    }

    public static final void setText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$text, AnnotatedString value) {
        $this$text.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(value));
    }

    public static final void setText(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$setText, String label, Function1<? super AnnotatedString, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$setText.set(SemanticsActions.INSTANCE.getSetText(), accessibilityAction);
    }

    public static void setText$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, obj1, function13);
    }

    public static final void setTextSelectionRange-FDrldGo(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$textSelectionRange, long <set-?>) {
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue($this$textSelectionRange, SemanticsPropertiesKt.$$delegatedProperties[17], TextRange.box-impl(<set-?>));
    }

    public static final void setTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$textSubstitution, AnnotatedString <set-?>) {
        SemanticsProperties.INSTANCE.getTextSubstitution().setValue($this$textSubstitution, SemanticsPropertiesKt.$$delegatedProperties[14], <set-?>);
    }

    public static final void setTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$setTextSubstitution, String label, Function1<? super AnnotatedString, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$setTextSubstitution.set(SemanticsActions.INSTANCE.getSetTextSubstitution(), accessibilityAction);
    }

    public static void setTextSubstitution$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.setTextSubstitution(semanticsPropertyReceiver, obj1, function13);
    }

    public static final void setToggleableState(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$toggleableState, ToggleableState <set-?>) {
        SemanticsProperties.INSTANCE.getToggleableState().setValue($this$toggleableState, SemanticsPropertiesKt.$$delegatedProperties[22], <set-?>);
    }

    public static final void setTraversalGroup(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$isTraversalGroup, boolean <set-?>) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue($this$isTraversalGroup, SemanticsPropertiesKt.$$delegatedProperties[6], Boolean.valueOf(<set-?>));
    }

    public static final void setTraversalIndex(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$traversalIndex, float <set-?>) {
        SemanticsProperties.INSTANCE.getTraversalIndex().setValue($this$traversalIndex, SemanticsPropertiesKt.$$delegatedProperties[9], Float.valueOf(<set-?>));
    }

    public static final void setVerticalScrollAxisRange(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$verticalScrollAxisRange, androidx.compose.ui.semantics.ScrollAxisRange <set-?>) {
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue($this$verticalScrollAxisRange, SemanticsPropertiesKt.$$delegatedProperties[11], <set-?>);
    }

    public static final void showTextSubstitution(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$showTextSubstitution, String label, Function1<? super Boolean, Boolean> action) {
        AccessibilityAction accessibilityAction = new AccessibilityAction(label, (Function)action);
        $this$showTextSubstitution.set(SemanticsActions.INSTANCE.getShowTextSubstitution(), accessibilityAction);
    }

    public static void showTextSubstitution$default(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver, String string2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        SemanticsPropertiesKt.showTextSubstitution(semanticsPropertyReceiver, obj1, function13);
    }

    private static final <T> T throwSemanticsGetNotSupported() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
        throw unsupportedOperationException;
    }
}
