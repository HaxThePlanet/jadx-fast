package app.dogo.com.dogo_android.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import app.dogo.com.dogo_android.model.ChallengeFilterItem;
import app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import n.a.a;

/* compiled from: PreferenceService.kt */
@Metadata(d1 = "\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0003\u0008\u009c\u0001\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008 \u0018\u0000 \u0089\u00022\u00020\u0001:\u0002\u0089\u0002B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u0008\u0010Ë\u0001\u001a\u00030Ì\u0001J\u0008\u0010Í\u0001\u001a\u00030Ì\u0001J\n\u0010Î\u0001\u001a\u00030Ì\u0001H\u0002J\n\u0010Ï\u0001\u001a\u00030Ì\u0001H\u0002J\u0008\u0010Ð\u0001\u001a\u00030Ì\u0001J\u0012\u0010Ñ\u0001\u001a\u00020/2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0017J\u0014\u0010Ó\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010Ô\u0001J7\u0010Õ\u0001\u001a\u0011\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0005\u0012\u00030×\u00010Ô\u00012\u0007\u0010Ø\u0001\u001a\u00020\u00172\u0016\u0010Ù\u0001\u001a\u0011\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0005\u0012\u00030×\u00010Ô\u0001J\u0007\u0010Ú\u0001\u001a\u00020\u001eJ\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u00108\u001a\u00020\u0017J\u000f\u0010Ü\u0001\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0017J\u000f\u0010Ý\u0001\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0017J\u000f\u0010Þ\u0001\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0017J\u0007\u0010ß\u0001\u001a\u00020\u001eJ\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u00108\u001a\u00020\u0017J\u000e\u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170â\u0001J\u000e\u0010ã\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170â\u0001J\u000e\u0010ä\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170â\u0001J\u0010\u0010Ä\u0001\u001a\u00020\u001e2\u0007\u0010\\\u001a\u00030å\u0001J\u0010\u0010Ç\u0001\u001a\u00020\u001e2\u0007\u0010\\\u001a\u00030å\u0001J\u0007\u0010æ\u0001\u001a\u00020\u001eJ\n\u0010ç\u0001\u001a\u00030Ì\u0001H\u0002J\u0014\u0010è\u0001\u001a\u00030Ì\u00012\n\u0010é\u0001\u001a\u0005\u0018\u00010ê\u0001J\n\u0010ë\u0001\u001a\u00030Ì\u0001H\u0002J\u0011\u0010ì\u0001\u001a\u00030Ì\u00012\u0007\u0010í\u0001\u001a\u00020\u0017J\u001a\u0010î\u0001\u001a\u00030Ì\u00012\u0007\u0010ï\u0001\u001a\u00020\u00172\u0007\u0010\u008e\u0001\u001a\u00020\u0001J\u0010\u0010ð\u0001\u001a\u00030Ì\u00012\u0006\u00108\u001a\u00020\u0017J\u0011\u0010ñ\u0001\u001a\u00030Ì\u00012\u0007\u0010ò\u0001\u001a\u00020\u0017J\u0013\u0010ó\u0001\u001a\u00030Ì\u00012\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u0017J/\u0010õ\u0001\u001a\u00030Ì\u00012\u001c\u0010ö\u0001\u001a\u0017\u0012\u0007\u0012\u0005\u0018\u00010Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010×\u0001\u0018\u00010Ô\u00012\u0007\u0010Ø\u0001\u001a\u00020\u0017J\u0010\u0010÷\u0001\u001a\u00030Ì\u00012\u0006\u0010\u001d\u001a\u00020\u001eJ\u0019\u0010ø\u0001\u001a\u00030Ì\u00012\u0006\u00108\u001a\u00020\u00172\u0007\u0010ù\u0001\u001a\u00020\u0017J\u0010\u0010ú\u0001\u001a\u00030Ì\u00012\u0006\u00108\u001a\u00020\u0017J\u0010\u0010û\u0001\u001a\u00030Ì\u00012\u0006\u00108\u001a\u00020\u0017J\u0010\u0010ü\u0001\u001a\u00030Ì\u00012\u0006\u00108\u001a\u00020\u0017J\u0008\u0010ý\u0001\u001a\u00030Ì\u0001J\u0010\u0010þ\u0001\u001a\u00030Ì\u00012\u0006\u0010m\u001a\u00020\u001eJ\u001a\u0010ÿ\u0001\u001a\u00030Ì\u00012\u0007\u0010\\\u001a\u00030å\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u001eJ\u001b\u0010\u0080\u0002\u001a\u00030Ì\u00012\u0006\u00108\u001a\u00020\u00172\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u0082\u0002\u001a\u00030Ì\u00012\u0007\u0010\\\u001a\u00030å\u00012\u0007\u0010Â\u0001\u001a\u00020\u001eJ\u001a\u0010\u0083\u0002\u001a\u00030Ì\u00012\u0007\u0010\\\u001a\u00030å\u00012\u0007\u0010\u0084\u0002\u001a\u00020\u001eJ\u0011\u0010\u0083\u0002\u001a\u00030Ì\u00012\u0007\u0010\u0084\u0002\u001a\u00020\u001eJ\u0008\u0010\u0085\u0002\u001a\u00030Ì\u0001J\t\u0010\u0086\u0002\u001a\u00020\u001eH\u0002J\u0014\u0010\u0087\u0002\u001a\u00030Ì\u00012\n\u0010é\u0001\u001a\u0005\u0018\u00010ê\u0001J\u0007\u0010\u0088\u0002\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R$\u0010$\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008%\u0010!\"\u0004\u0008&\u0010#R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008(\u0010!\"\u0004\u0008)\u0010#R$\u0010+\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008,\u0010!\"\u0004\u0008-\u0010#R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R(\u00105\u001a\u0004\u0018\u00010\u00172\u0008\u00105\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00086\u0010\u001a\"\u0004\u00087\u0010\u001cR(\u00109\u001a\u0004\u0018\u00010\u00172\u0008\u00108\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008:\u0010\u001a\"\u0004\u0008;\u0010\u001cR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008>\u0010!\"\u0004\u0008?\u0010#R$\u0010@\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008A\u0010!\"\u0004\u0008B\u0010#R(\u0010D\u001a\u0004\u0018\u00010\u00172\u0008\u0010C\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008E\u0010\u001a\"\u0004\u0008F\u0010\u001cR$\u0010G\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008H\u0010!\"\u0004\u0008I\u0010#R(\u0010K\u001a\u0004\u0018\u00010/2\u0008\u0010J\u001a\u0004\u0018\u00010/8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008L\u0010M\"\u0004\u0008N\u0010OR(\u0010Q\u001a\u0004\u0018\u00010\u00172\u0008\u0010P\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008R\u0010\u001a\"\u0004\u0008S\u0010\u001cR(\u0010U\u001a\u0004\u0018\u00010\u00172\u0008\u0010T\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008V\u0010\u001a\"\u0004\u0008W\u0010\u001cR$\u0010Y\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008Z\u0010!\"\u0004\u0008[\u0010#R(\u0010]\u001a\u0004\u0018\u00010\u00172\u0008\u0010\\\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008^\u0010\u001a\"\u0004\u0008_\u0010\u001cR(\u0010`\u001a\u0004\u0018\u00010\u00172\u0008\u0010\\\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008a\u0010\u001a\"\u0004\u0008b\u0010\u001cR(\u0010c\u001a\u0004\u0018\u00010\u00172\u0008\u0010X\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008d\u0010\u001a\"\u0004\u0008e\u0010\u001cR$\u0010g\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008h\u0010!\"\u0004\u0008i\u0010#R$\u0010j\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008k\u0010!\"\u0004\u0008l\u0010#R$\u0010n\u001a\u00020\u001e2\u0006\u0010m\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008o\u0010!\"\u0004\u0008p\u0010#R$\u0010r\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008r\u0010!\"\u0004\u0008s\u0010#R\u0011\u0010t\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\u0008t\u0010!R$\u0010u\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008u\u0010!\"\u0004\u0008v\u0010#R$\u0010x\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008x\u0010!\"\u0004\u0008y\u0010#R\u0013\u0010z\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\u0008{\u0010\u001aR$\u0010}\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008~\u0010\u0013\"\u0004\u0008\u007f\u0010\u0015R(\u0010\u0081\u0001\u001a\u00020/2\u0007\u0010\u0080\u0001\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0082\u0001\u00102\"\u0005\u0008\u0083\u0001\u00104R'\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0085\u0001\u0010\u0013\"\u0005\u0008\u0086\u0001\u0010\u0015R'\u0010\u0087\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0088\u0001\u0010\u0013\"\u0005\u0008\u0089\u0001\u0010\u0015R(\u0010\u008b\u0001\u001a\u00020/2\u0007\u0010\u008a\u0001\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u008c\u0001\u00102\"\u0005\u0008\u008d\u0001\u00104R(\u0010\u008f\u0001\u001a\u00020\u00172\u0007\u0010\u008e\u0001\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0090\u0001\u0010\u001a\"\u0005\u0008\u0091\u0001\u0010\u001cR'\u0010\u0092\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0093\u0001\u0010\u0013\"\u0005\u0008\u0094\u0001\u0010\u0015R'\u0010\u0095\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0096\u0001\u0010\u0013\"\u0005\u0008\u0097\u0001\u0010\u0015R'\u0010\u0098\u0001\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u0099\u0001\u0010!\"\u0005\u0008\u009a\u0001\u0010#R(\u0010\u009c\u0001\u001a\u00020\u001e2\u0007\u0010\u009b\u0001\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008\u009d\u0001\u0010!\"\u0005\u0008\u009e\u0001\u0010#R'\u0010\u009f\u0001\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008 \u0001\u0010!\"\u0005\u0008¡\u0001\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010£\u0001\u001a\u00020/2\u0007\u0010¢\u0001\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008¤\u0001\u00102\"\u0005\u0008¥\u0001\u00104R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010§\u0001\u001a\u00020/2\u0007\u0010¦\u0001\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008¨\u0001\u00102\"\u0005\u0008©\u0001\u00104R'\u0010ª\u0001\u001a\u00020\u001e2\u0006\u0010\\\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008«\u0001\u0010!\"\u0005\u0008¬\u0001\u0010#R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010®\u0001\u001a\u00020\u00172\u0007\u0010­\u0001\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008¯\u0001\u0010\u001a\"\u0005\u0008°\u0001\u0010\u001cR(\u0010±\u0001\u001a\u00020/2\u0007\u0010¦\u0001\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008²\u0001\u00102\"\u0005\u0008³\u0001\u00104R(\u0010µ\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008¶\u0001\u0010!\"\u0005\u0008·\u0001\u0010#R(\u0010¹\u0001\u001a\u00020/2\u0007\u0010¸\u0001\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008º\u0001\u00102\"\u0005\u0008»\u0001\u00104R'\u0010¼\u0001\u001a\u00020\u001e2\u0006\u0010m\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008½\u0001\u0010!\"\u0005\u0008¾\u0001\u0010#R'\u0010¿\u0001\u001a\u00020\u001e2\u0006\u0010m\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008À\u0001\u0010!\"\u0005\u0008Á\u0001\u0010#R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010Ã\u0001\u001a\u00020\u001e2\u0007\u0010Â\u0001\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008Ä\u0001\u0010!\"\u0005\u0008Å\u0001\u0010#R\u0013\u0010Æ\u0001\u001a\u00020\u001e8F¢\u0006\u0007\u001a\u0005\u0008Ç\u0001\u0010!R'\u0010È\u0001\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\u0008É\u0001\u0010!\"\u0005\u0008Ê\u0001\u0010#¨\u0006\u008a\u0002", d2 = {"Lapp/dogo/com/dogo_android/service/PreferenceService;", "", "pref", "Landroid/content/SharedPreferences;", "alarmsPref", "challengeFilterPref", "referrerPref", "trickPref", "programRef", "device", "reportedComments", "reportedEntries", "reportedDogsIds", "remoteConfigOverrides", "(Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;)V", "long", "", "appInstallTimeMs", "getAppInstallTimeMs", "()J", "setAppInstallTimeMs", "(J)V", "deviceId", "", "applicationInstallationId", "getApplicationInstallationId", "()Ljava/lang/String;", "setApplicationInstallationId", "(Ljava/lang/String;)V", "state", "", "authenticationShowedInDashboard", "getAuthenticationShowedInDashboard", "()Z", "setAuthenticationShowedInDashboard", "(Z)V", "calendarIntroductionCompleted", "getCalendarIntroductionCompleted", "setCalendarIntroductionCompleted", "clickerIntroductionCompleted", "getClickerIntroductionCompleted", "setClickerIntroductionCompleted", "rated", "clickerTrickRated", "getClickerTrickRated", "setClickerTrickRated", "trickCount", "", "completedTrickCount", "getCompletedTrickCount", "()I", "setCompletedTrickCount", "(I)V", "countryCode", "getCountryCode", "setCountryCode", "dogId", "currentProfileCreationDog", "getCurrentProfileCreationDog", "setCurrentProfileCreationDog", "seen", "examIntroductionSeenFlag", "getExamIntroductionSeenFlag", "setExamIntroductionSeenFlag", "examPermissionsExplained", "getExamPermissionsExplained", "setExamPermissionsExplained", "token", "fcmToken", "getFcmToken", "setFcmToken", "firstExamUnlockedScreenShowed", "getFirstExamUnlockedScreenShowed", "setFirstExamUnlockedScreenShowed", "build", "firstOpenBuild", "getFirstOpenBuild", "()Ljava/lang/Integer;", "setFirstOpenBuild", "(Ljava/lang/Integer;)V", "campaign", "firstOpenCampaign", "getFirstOpenCampaign", "setFirstOpenCampaign", "medium", "firstOpenMedium", "getFirstOpenMedium", "setFirstOpenMedium", "version", "firstOpenPropertiesSaved", "getFirstOpenPropertiesSaved", "setFirstOpenPropertiesSaved", "source", "firstOpenSource", "getFirstOpenSource", "setFirstOpenSource", "firstOpenTimeMs", "getFirstOpenTimeMs", "setFirstOpenTimeMs", "firstOpenVersion", "getFirstOpenVersion", "setFirstOpenVersion", "bool", "forcedDogCreation", "getForcedDogCreation", "setForcedDogCreation", "imageCropperPermissionsExplained", "getImageCropperPermissionsExplained", "setImageCropperPermissionsExplained", "followed", "instagramFollow", "getInstagramFollow", "setInstagramFollow", "isFirstTime", "isFirstTimeLaunch", "setFirstTimeLaunch", "isLessonExitAlertShown", "isProgramTutorialFinished", "setProgramTutorialFinished", "it", "isTimeMetricToolTipsVisible", "setTimeMetricToolTipsVisible", "lastAffiliate", "getLastAffiliate", "time", "lastInstagramInviteCallTime", "getLastInstagramInviteCallTime", "setLastInstagramInviteCallTime", "position", "lastProfileCreationPosition", "getLastProfileCreationPosition", "setLastProfileCreationPosition", "lastRateItPopUpCallTime", "getLastRateItPopUpCallTime", "setLastRateItPopUpCallTime", "lastShareItPopUpCallTime", "getLastShareItPopUpCallTime", "setLastShareItPopUpCallTime", "threshold", "lastShownReminderTrickCount", "getLastShownReminderTrickCount", "setLastShownReminderTrickCount", "value", "lastStreakAchievedDate", "getLastStreakAchievedDate", "setLastStreakAchievedDate", "lastTodaysWorkoutCompletedTimeMs", "getLastTodaysWorkoutCompletedTimeMs", "setLastTodaysWorkoutCompletedTimeMs", "lastTrainingReminderShownTimeMs", "getLastTrainingReminderShownTimeMs", "setLastTrainingReminderShownTimeMs", "oneLessonCompleted", "getOneLessonCompleted", "setOneLessonCompleted", "showState", "popUpShowedInLessonListFlag", "getPopUpShowedInLessonListFlag", "setPopUpShowedInLessonListFlag", "pottyCertificateUnlockedShowed", "getPottyCertificateUnlockedShowed", "setPottyCertificateUnlockedShowed", "soundId", "preferredClickerSoundId", "getPreferredClickerSoundId", "setPreferredClickerSoundId", "likedCount", "rateItPhotosLikedCount", "getRateItPhotosLikedCount", "setRateItPhotosLikedCount", "recommendedProgramSubscriptionShown", "getRecommendedProgramSubscriptionShown", "setRecommendedProgramSubscriptionShown", "locale", "selectedLocale", "getSelectedLocale", "setSelectedLocale", "shareItPhotosLikedCount", "getShareItPhotosLikedCount", "setShareItPhotosLikedCount", "shouldShowReminders", "shouldTryShowReminderScreenInDashboard", "getShouldTryShowReminderScreenInDashboard", "setShouldTryShowReminderScreenInDashboard", "closeCount", "subscriptionScreenCloseCount", "getSubscriptionScreenCloseCount", "setSubscriptionScreenCloseCount", "swipeAnimationSeen", "getSwipeAnimationSeen", "setSwipeAnimationSeen", "tiktokFollowShowed", "getTiktokFollowShowed", "setTiktokFollowShowed", "rateState", "userRateState", "getUserRateState", "setUserRateState", "userShareState", "getUserShareState", "workoutTutorialCompleted", "getWorkoutTutorialCompleted", "setWorkoutTutorialCompleted", "clearDebugOverrides", "", "clearSharedPrefForLogOut", "copyToDevicePreference", "deleteOldValuesFromPrefXml", "disableLessonExitAlert", "getAlarmCode", "alarmId", "getAllDebugOverrides", "", "getChallengeFilters", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem;", "challengeId", "defaultFilters", "getClosedResubscribeCard", "getDogAvatarUrlFor", "getDogHasBitingProblems", "getDogHasPottyProblems", "getDogWorkoutStreakSynced", "getLessonIntroductionFlag", "getRecommendedProgramFor", "getReportedCommentIds", "", "getReportedDogIds", "getReportedEntryIds", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "hasUsedContactUs", "migrateOldValuesBasedOnFirstTimeLaunchKey", "registerClickerSoundListener", "listener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "resetAllExceptDeviceAndReferrer", "saveCommentAsReported", "commentId", "saveDebugOverrideValue", "key", "saveDogAsReported", "saveEntryAsReported", "entryId", "saveLastAffiliate", "partner", "setChallengeFilters", "filterList", "setClosedResubscribeCard", "setDogAvatarUrlFor", "avatarUrl", "setDogHasBitingProblems", "setDogHasPottyProblems", "setDogWorkoutStreakSynced", "setHasUsedContactUs", "setLessonIntroductionCompletionFlag", "setPopUpShowedInLessonList", "setRecommendedProgramFor", "programId", "setUserRateSate", "setUserShareSate", "shareState", "setWasRedirectedToReminders", "shouldMigrateToDevicePreference", "unregisterClickerSoundListener", "wasRedirectedToReminders", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p2, reason: from kotlin metadata */
public final class PreferenceService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final p2.a INSTANCE = new p2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final SharedPreferences alarmsPref;
    private final SharedPreferences b;
    private final SharedPreferences c;
    private final SharedPreferences d;
    private final SharedPreferences e;
    /* renamed from: f, reason: from kotlin metadata */
    private final SharedPreferences challengeFilterPref;
    private final SharedPreferences g;
    private final SharedPreferences h;
    private final SharedPreferences i;
    private final SharedPreferences j;
    private final SharedPreferences k;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008I\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006M", d2 = {"Lapp/dogo/com/dogo_android/service/PreferenceService$Companion;", "", "()V", "ALARM_PREF", "", "APP_INSTALL_TIME_MS", "AUTHENTICATION_SCREEN_SHOWED_IN_DASHBOARD", "CALENDAR_INTRODUCTION_COMPLETED", "CHALLENGE_FILTER_PREF", "CLICKER_INTRODUCTION_COMPLETED", "CLICKER_SOUND_ID", "CLICKER_TRICK_RATED", "CLOSED_RESUBSCRIBE_CARD", "COMMENT_REPORT_PREF", "COMPLETED_TRICKS_COUNT", "CURRENT_DOG_IN_PROFILE_CREATION", "DEBUG_OVERRIDES_PREF", "DEVICE_PREFERENCE", "DOG_AVATAR_FOR", "DOG_REPORT_PREF", "ENTRY_REPORT_PREF", "EXAM_INTRODUCTION_SEEN_FLAG", "EXAM_PERMISSIONS_EXPLAINED", "FCM_TOKEN", "FILTER_FOR_CHALLENGE", "FIRST_EXAM_UNLOCKED_SCREEN_SHOWED", "FIRST_OPEN_BUILD", "FIRST_OPEN_CAMPAIGN", "FIRST_OPEN_MEDIUM", "FIRST_OPEN_PROPERTIES_SAVED", "FIRST_OPEN_SOURCE", "FIRST_OPEN_TIME_MS", "FIRST_OPEN_VERSION", "FORCED_DOG_CREATION", "HAS_USED_CONTACT_US", "HAS_USER_RATE", "HAS_USER_SHARED", "HAVE_BITING_PROBLEMS_FOR", "HAVE_POTTY_PROBLEMS_FOR", "IMAGE_CROPPER_PERMISSIONS_EXPLAINED", "INSTAGRAM_FOLLOW_FLAG", "IS_FILTER_FRESH_FOR_CHALLENGE", "IS_FIRST_TIME_LAUNCH", "IS_LESSON_EXIT_ALERT_SHOWN", "IS_METRIC_TOOLTIP_VISIBLE", "LAST_AFFILIATE", "LAST_INSTAGRAM_INVITE_POP_UP_TIME", "LAST_POSITION_IN_PROFILE_CREATION", "LAST_RATE_IT_POP_UP_TIME", "LAST_SHARE_IT_POP_UP_TIME", "LAST_SHOWN_REMINDER_TRICK_COUNT", "LAST_STREAK_ACHIEVED_DATE", "LAST_TODAYS_WORKOUT_COMPLETED_TIME_MS", "LAST_TRAINING_REMINDER_SHOWN_TIME_MS", "LESSON_INTODUCTION_FLAG", "ONE_LESSON_COMPLETED", "POP_UP_SHOWED_IN_LESSON_LIST_FLAG", "POTTY_CERTIFICATE_UNLOCKED_SHOWED", "PREF_NAME", "PROGRAM_PREF", "PROGRAM_TUTORIAL_FINISHED", "RATE_IT_PHOTOS_LIKED", "RECOMMENDED_PROGRAM_FOR_DOG", "RECOMMENDED_PROGRAM_SUBSCRIPTION_SHOWN", "REFERRER_DATA", "SHARE_IT_PHOTOS_LIKED", "SHOULD_SHOW_REMINDER_SCREEN", "STREAK_DATA_SYNCED_FOR", "SUBSCRIPTION_SCREEN_CLOSE_COUNT", "SWIPE_ANIMATION_SEEN_FLAG", "TIKTOK_FOLLOW_SHOW_FLAG", "TRICK_PREF", "UNIQUE_DEVICE_ID", "USER_COUNTRY_CODE", "USER_SELECTED_LOCALE", "WAS_REDIRECTED_TO_REMINDERS", "WORKOUT_TUTORIAL_COMPLETED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001¨\u0006\u0005", d2 = {"app/dogo/com/dogo_android/service/PreferenceService$getChallengeFilters$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends TypeToken<Map<ChallengeFilterItem.FilterTypes, ? extends ChallengeFilterItem>> {
        b() {
            super();
        }
    }
    public p2(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences sharedPreferences3, SharedPreferences sharedPreferences4, SharedPreferences sharedPreferences5, SharedPreferences sharedPreferences6, SharedPreferences sharedPreferences7, SharedPreferences sharedPreferences8, SharedPreferences sharedPreferences9, SharedPreferences sharedPreferences10, SharedPreferences sharedPreferences11) {
        n.f(sharedPreferences, "pref");
        n.f(sharedPreferences2, "alarmsPref");
        n.f(sharedPreferences3, "challengeFilterPref");
        n.f(sharedPreferences4, "referrerPref");
        n.f(sharedPreferences5, "trickPref");
        n.f(sharedPreferences6, "programRef");
        n.f(sharedPreferences7, "device");
        n.f(sharedPreferences8, "reportedComments");
        n.f(sharedPreferences9, "reportedEntries");
        n.f(sharedPreferences10, "reportedDogsIds");
        n.f(sharedPreferences11, "remoteConfigOverrides");
        super();
        this.alarmsPref = sharedPreferences;
        this.b = sharedPreferences2;
        this.c = sharedPreferences3;
        this.d = sharedPreferences4;
        this.e = sharedPreferences5;
        this.challengeFilterPref = sharedPreferences6;
        this.g = sharedPreferences7;
        this.h = sharedPreferences8;
        this.i = sharedPreferences9;
        this.j = sharedPreferences10;
        this.k = sharedPreferences11;
        m0();
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final boolean clearDebugOverrides() {
        return !this.g.contains("is_first_launch");
    }

    private final void c() {
        boolean z = false;
        final String str4 = "last_instagram_invite_pop_up_time";
        X0(this.alarmsPref.getBoolean("instagram_follow_flag", z));
        t1(this.alarmsPref.getBoolean("tiktok_follow_show_flag", z));
        Y0(this.alarmsPref.getLong(str4, 0L));
        T0(this.alarmsPref.getBoolean("is_first_launch", true));
        w1(this.alarmsPref.getBoolean("rated_app_V1", z));
    }

    private final void d() {
        this.alarmsPref.edit().remove("is_first_launch").remove("instagram_follow_flag").remove("last_instagram_invite_pop_up_time").remove("rated_app_V1").apply();
    }

    private final void m0() {
        if (clearDebugOverrides()) {
            c();
            d();
        }
    }

    private final void o0() {
        this.alarmsPref.edit().clear().apply();
        this.b.edit().clear().apply();
        this.c.edit().clear().apply();
        this.e.edit().clear().apply();
        this.challengeFilterPref.edit().clear().apply();
        T0(true);
    }

    public final String A() {
        return this.g.getString("first_open_source", null);
    }

    /* renamed from: A0, reason: from kotlin metadata */
    public final void getAlarmCode(boolean alarmId) {
        this.g.edit().putBoolean("clicker_trick_rated", alarmId).apply();
    }

    /* renamed from: A1, reason: from kotlin metadata */
    public final void getDogAvatarUrlFor(boolean dogId) {
        this.alarmsPref.edit().putBoolean("workout_tutorial_completed", dogId).apply();
    }

    public final String B() {
        return this.g.getString("first_open_time_ms", null);
    }

    /* renamed from: B0, reason: from kotlin metadata */
    public final void getDogHasBitingProblems(boolean dogId) {
        this.alarmsPref.edit().putBoolean("closed_resubscribe_card", dogId).apply();
    }

    public final String C() {
        return this.g.getString("first_open_version", null);
    }

    /* renamed from: C0, reason: from kotlin metadata */
    public final void getDogHasPottyProblems(int dogId) {
        this.alarmsPref.edit().putInt("completed_tricks_count", dogId).apply();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public final void getDogWorkoutStreakSynced(SharedPreferences.OnSharedPreferenceChangeListener dogId) {
        this.alarmsPref.unregisterOnSharedPreferenceChangeListener(dogId);
    }

    public final boolean D() {
        return this.alarmsPref.getBoolean("forced_dog_creation", false);
    }

    /* renamed from: D0, reason: from kotlin metadata */
    public final void getRecommendedProgramFor(String dogId) {
        this.alarmsPref.edit().putString("user_country_code", dogId).apply();
    }

    public final boolean D1() {
        return this.alarmsPref.getBoolean("was_redirected_to_reminders", false);
    }

    public final boolean E() {
        return this.alarmsPref.getBoolean("image_cropper_permissions_explained", false);
    }

    /* renamed from: E0, reason: from kotlin metadata */
    public final void getChallengeFilters(String challengeId, String defaultFilters) {
        n.f(challengeId, "dogId");
        n.f(defaultFilters, "avatarUrl");
        this.alarmsPref.edit().putString(n.o("dog_avatar_for_", challengeId), defaultFilters).apply();
    }

    public final boolean F() {
        return this.g.getBoolean("instagram_follow_flag", false);
    }

    /* renamed from: F0, reason: from kotlin metadata */
    public final void getUserRateState(String source) {
        n.f(source, "dogId");
        this.alarmsPref.edit().putBoolean(n.o("has_biting_problems_", source), true).apply();
    }

    public final String G() {
        return this.d.getString("last_affiliate", null);
    }

    /* renamed from: G0, reason: from kotlin metadata */
    public final void getUserShareState(String source) {
        n.f(source, "dogId");
        this.alarmsPref.edit().putBoolean(n.o("has_potty_problems_", source), true).apply();
    }

    public final long H() {
        return this.g.getLong("last_instagram_invite_pop_up_time", 0L);
    }

    /* renamed from: H0, reason: from kotlin metadata */
    public final void registerClickerSoundListener(String listener) {
        n.f(listener, "dogId");
        this.alarmsPref.edit().putBoolean(n.o("streak_data_synced_", listener), true).apply();
    }

    public final long I() {
        return this.alarmsPref.getLong("last_rate_it_pop_up_time", 0L);
    }

    /* renamed from: I0, reason: from kotlin metadata */
    public final void saveCommentAsReported(boolean commentId) {
        this.d.edit().putBoolean("exam_introduction_flag", commentId).apply();
    }

    public final long J() {
        return this.alarmsPref.getLong("last_share_it_pop_up_time", 0L);
    }

    /* renamed from: J0, reason: from kotlin metadata */
    public final void saveDogAsReported(boolean dogId) {
        this.alarmsPref.edit().putBoolean("exam_permissions_explained", dogId).apply();
    }

    public final int K() {
        return this.alarmsPref.getInt("last_shown_reminder_trick_count", 0);
    }

    /* renamed from: K0, reason: from kotlin metadata */
    public final void saveEntryAsReported(String entryId) {
        this.g.edit().putString("fcm_token", entryId).apply();
    }

    public final String L() {
        String string;
        string = "";
        string = this.alarmsPref.getString("last_streak_training_achieved_date", string);
        if (string != null) {
        }
        return string;
    }

    /* renamed from: L0, reason: from kotlin metadata */
    public final void saveLastAffiliate(boolean partner) {
        this.alarmsPref.edit().putBoolean("first_exam_unlocked_screen_showed", partner).apply();
    }

    public final long M() {
        return this.b.getLong("last_training_reminder_shown_time_ms", 0L);
    }

    /* renamed from: M0, reason: from kotlin metadata */
    public final void setClosedResubscribeCard(Integer state) {
        int value = -1;
        if (state == null) {
            value = -1;
        } else {
            value = state.intValue();
        }
        this.g.edit().putInt("first_open_build", value).apply();
    }

    public final boolean N() {
        return this.alarmsPref.getBoolean("lesson_introduction_flag", false);
    }

    /* renamed from: N0, reason: from kotlin metadata */
    public final void setDogHasBitingProblems(String dogId) {
        this.g.edit().putString("first_open_campaign", dogId).apply();
    }

    public final boolean O() {
        return this.alarmsPref.getBoolean("one_lesson_completed", false);
    }

    /* renamed from: O0, reason: from kotlin metadata */
    public final void setDogHasPottyProblems(String dogId) {
        this.g.edit().putString("first_open_medium", dogId).apply();
    }

    public final boolean P() {
        return this.d.getBoolean("pop_up_showed_in_lesson_list_flag", false);
    }

    /* renamed from: P0, reason: from kotlin metadata */
    public final void setDogWorkoutStreakSynced(boolean dogId) {
        this.g.edit().putBoolean("first_open_properties_saved", dogId).apply();
    }

    public final boolean Q() {
        return this.alarmsPref.getBoolean("potty_certificate_unlocked_confetti_showed", false);
    }

    /* renamed from: Q0, reason: from kotlin metadata */
    public final void setLessonIntroductionCompletionFlag(String followed) {
        this.g.edit().putString("first_open_source", followed).apply();
    }

    public final int R() {
        return this.alarmsPref.getInt("clicker_sound_id", 0);
    }

    /* renamed from: R0, reason: from kotlin metadata */
    public final void setUserShareSate(String shareState) {
        this.g.edit().putString("first_open_time_ms", shareState).apply();
    }

    public final int S() {
        return this.alarmsPref.getInt("rate_it_photos_liked", 0);
    }

    /* renamed from: S0, reason: from kotlin metadata */
    public final void unregisterClickerSoundListener(String listener) {
        this.g.edit().putString("first_open_version", listener).apply();
    }

    public final List<String> T() {
        return p.L0(this.h.getAll().keySet());
    }

    public final void T0(boolean z) {
        this.g.edit().putBoolean("is_first_launch", z).apply();
    }

    public final List<String> U() {
        return p.L0(this.j.getAll().keySet());
    }

    public final void U0(boolean z) {
        this.alarmsPref.edit().putBoolean("forced_dog_creation", z).apply();
    }

    public final List<String> V() {
        return p.L0(this.i.getAll().keySet());
    }

    public final void V0() {
        this.alarmsPref.edit().putBoolean("has_biting_problems_", true).apply();
    }

    public final String W() {
        String string = this.alarmsPref.getString("user_selected_locale", LocaleService.getLocale(null));
        n.d(string);
        n.e(string, "pref.getString(USER_SELECTED_LOCALE, LocaleService.getLocaleString(null))!!");
        return string;
    }

    public final void W0(boolean z) {
        this.alarmsPref.edit().putBoolean("image_cropper_permissions_explained", z).apply();
    }

    public final int X() {
        return this.alarmsPref.getInt("share_it_photos_liked", 0);
    }

    public final void X0(boolean z) {
        this.g.edit().putBoolean("instagram_follow_flag", z).apply();
    }

    public final boolean Y() {
        return this.b.getBoolean("current_dog_in_profile_creation", false);
    }

    public final void Y0(long j) {
        this.g.edit().putLong("last_instagram_invite_pop_up_time", j).apply();
    }

    public final int Z() {
        return this.alarmsPref.getInt("subscription_screen_close_count", 0);
    }

    public final void Z0(long j) {
        this.alarmsPref.edit().putLong("last_rate_it_pop_up_time", j).apply();
    }

    public final void a() {
        this.k.edit().clear().apply();
    }

    public final boolean a0() {
        return this.g.getBoolean("swipe_animation_flag", false);
    }

    public final void a1(long j) {
        this.alarmsPref.edit().putLong("last_share_it_pop_up_time", j).apply();
    }

    public final void b() {
        o0();
        T0(true);
    }

    public final boolean b0() {
        return this.g.getBoolean("tiktok_follow_show_flag", false);
    }

    public final void b1(int i) {
        this.alarmsPref.edit().putInt("last_shown_reminder_trick_count", i).apply();
    }

    public final boolean c0() {
        return this.g.getBoolean("rated_app_V1", false);
    }

    public final void c1(String str) {
        n.f(str, "value");
        this.alarmsPref.edit().putString("last_streak_training_achieved_date", str).apply();
    }

    public final boolean d0(q2.a aVar) {
        boolean _boolean = false;
        n.f(aVar, "source");
        _boolean = false;
        if (aVar != RateItService_RateSource.UNDEFINED) {
            str = "rated_app_V1_";
            _boolean = this.alarmsPref.getBoolean(n.o(str, aVar.getTag()), false);
        }
        return _boolean;
    }

    public final void d1(long j) {
        this.alarmsPref.edit().putLong("last_todays_workout_completed_time_ms", j).apply();
    }

    public final void e() {
        this.alarmsPref.edit().putBoolean("is_lesson_locked_tip_shown", false).apply();
    }

    public final boolean e0() {
        return this.alarmsPref.getBoolean("shared_app", false);
    }

    public final void e1(long j) {
        this.b.edit().putLong("last_training_reminder_shown_time_ms", j).apply();
    }

    public final Map<String, Object> f() {
        Map all = this.k.getAll();
        n.e(all, "remoteConfigOverrides.all");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.q(all);
    }

    public final boolean f0(q2.a aVar) {
        boolean _boolean = false;
        n.f(aVar, "source");
        _boolean = false;
        if (aVar != RateItService_RateSource.UNDEFINED) {
            str = "shared_app_";
            _boolean = this.alarmsPref.getBoolean(n.o(str, aVar.getTag()), false);
        }
        return _boolean;
    }

    public final void f1(boolean z) {
        this.alarmsPref.edit().putBoolean("lesson_introduction_flag", z).apply();
    }

    public final long g() {
        return this.alarmsPref.getLong("app_install_time_ms", 0L);
    }

    public final boolean g0() {
        return this.alarmsPref.getBoolean("workout_tutorial_completed", false);
    }

    public final void g1(boolean z) {
        this.alarmsPref.edit().putBoolean("one_lesson_completed", z).apply();
    }

    public final String h() {
        return this.alarmsPref.getString("app_device_id", null);
    }

    public final boolean h0() {
        return this.alarmsPref.getBoolean("has_biting_problems_", false);
    }

    /* renamed from: h1, reason: from kotlin metadata */
    public final void saveDebugOverrideValue(q2.a key, boolean value) {
        n.f(key, "source");
        if (key != RateItService_RateSource.UNDEFINED) {
            str = "pop_up_showed_in_lesson_list_flag_";
            this.alarmsPref.edit().putBoolean(n.o(str, key.getTag()), value).apply();
        }
    }

    public final boolean i() {
        return this.alarmsPref.getBoolean("authentication_screen_showed_in_dashboard", false);
    }

    public final boolean i0() {
        return this.g.getBoolean("is_first_launch", true);
    }

    public final void i1(boolean z) {
        this.alarmsPref.edit().putBoolean("pop_up_showed_in_lesson_list_flag", z).apply();
    }

    public final boolean j() {
        return this.alarmsPref.getBoolean("calendar_introduction_completed", false);
    }

    public final boolean j0() {
        return this.alarmsPref.getBoolean("is_lesson_locked_tip_shown", true);
    }

    public final void j1(boolean z) {
        this.alarmsPref.edit().putBoolean("potty_certificate_unlocked_confetti_showed", z).apply();
    }

    /* renamed from: k, reason: from kotlin metadata */
    public final Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> setChallengeFilters(String filterList, Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> challengeId) {
        Object filterList2;
        n.f(filterList, "challengeId");
        n.f(challengeId, "defaultFilters");
        if (!(this.c.getBoolean(n.o("is_filter_fresh_for_challenge_v2_", filterList), true))) {
            String str = null;
            filterList2 = new Gson().fromJson(this.c.getString(n.o("_filter_for_challenge_v2_", filterList), str), new PreferenceService_getChallengeFilters_type_1().getType());
            n.e(filterList2, "{\n            val gson = Gson()\n            val json = challengeFilterPref.getString(FILTER_FOR_CHALLENGE + challengeId, null)\n            val type = object : TypeToken<Map<ChallengeFilterItem.FilterTypes?, ChallengeFilterItem?>?>() {}.type\n            gson.fromJson(json, type)\n        }");
        }
        return filterList2;
    }

    public final boolean k0() {
        return this.challengeFilterPref.getBoolean("program_tutorial_finished", true);
    }

    public final void k1(int i) {
        this.alarmsPref.edit().putInt("clicker_sound_id", i).apply();
    }

    public final boolean l() {
        return this.alarmsPref.getBoolean("clicker_introduction_completed", false);
    }

    public final boolean l0() {
        return this.g.getBoolean("is_metric_tooltip_visible", true);
    }

    public final void l1(boolean z) {
        this.challengeFilterPref.edit().putBoolean("program_tutorial_finished", z).apply();
    }

    public final boolean m() {
        return this.g.getBoolean("clicker_trick_rated", false);
    }

    public final void m1(int i) {
        this.alarmsPref.edit().putInt("rate_it_photos_liked", i).apply();
    }

    public final boolean n() {
        return this.alarmsPref.getBoolean("closed_resubscribe_card", false);
    }

    public final void n0(SharedPreferences.OnSharedPreferenceChangeListener list) {
        this.alarmsPref.registerOnSharedPreferenceChangeListener(list);
    }

    /* renamed from: n1, reason: from kotlin metadata */
    public final void setDogAvatarUrlFor(String dogId, String avatarUrl) {
        n.f(dogId, "dogId");
        this.challengeFilterPref.edit().putString(n.o("recommended_program_for_", dogId), avatarUrl).apply();
    }

    public final int o() {
        return this.alarmsPref.getInt("completed_tricks_count", 0);
    }

    public final void o1(String str) {
        n.f(str, "locale");
        this.alarmsPref.edit().putString("user_selected_locale", str).apply();
    }

    public final String p() {
        return this.alarmsPref.getString("user_country_code", null);
    }

    public final void p0(String str) {
        n.f(str, "commentId");
        this.h.edit().putBoolean(str, true).apply();
    }

    public final void p1(int i) {
        this.alarmsPref.edit().putInt("share_it_photos_liked", i).apply();
    }

    public final String q(String str) {
        n.f(str, "dogId");
        return this.alarmsPref.getString(n.o("dog_avatar_for_", str), null);
    }

    /* renamed from: q0, reason: from kotlin metadata */
    public final void setPopUpShowedInLessonList(String source, Object showState) {
        n.f(source, "key");
        n.f(showState, "value");
        if (showState instanceof Boolean) {
            this.k.edit().putBoolean(source, showState.booleanValue()).apply();
        } else {
            if (showState instanceof Double) {
                f = (float)showState.doubleValue();
                this.k.edit().putFloat(source, f).apply();
            } else {
                if (showState instanceof Long) {
                    this.k.edit().putLong(source, showState.longValue()).apply();
                } else {
                    if (showState instanceof String) {
                        this.k.edit().putString(source, showState).apply();
                    } else {
                        a.a("Passed invalid type to debug overrides", new Object[0]);
                    }
                }
            }
        }
    }

    public final void q1(boolean z) {
        this.b.edit().putBoolean("current_dog_in_profile_creation", z).apply();
    }

    public final boolean r(String str) {
        n.f(str, "dogId");
        return this.alarmsPref.getBoolean(n.o("streak_data_synced_", str), false);
    }

    public final void r0(String str) {
        n.f(str, "dogId");
        this.j.edit().putBoolean(str, true).apply();
    }

    public final void r1(int i) {
        this.alarmsPref.edit().putInt("subscription_screen_close_count", i).apply();
    }

    public final boolean s() {
        return this.d.getBoolean("exam_introduction_flag", false);
    }

    public final void s0(String str) {
        n.f(str, "entryId");
        this.i.edit().putBoolean(str, true).apply();
    }

    public final void s1(boolean z) {
        this.g.edit().putBoolean("swipe_animation_flag", z).apply();
    }

    public final boolean t() {
        return this.alarmsPref.getBoolean("exam_permissions_explained", false);
    }

    public final void t0(String str) {
        this.d.edit().putString("last_affiliate", str).apply();
    }

    public final void t1(boolean z) {
        this.g.edit().putBoolean("tiktok_follow_show_flag", z).apply();
    }

    public final String u() {
        return this.g.getString("fcm_token", null);
    }

    public final void u0(long j) {
        this.alarmsPref.edit().putLong("app_install_time_ms", j).apply();
    }

    public final void u1(boolean z) {
        this.g.edit().putBoolean("is_metric_tooltip_visible", z).apply();
    }

    public final boolean v() {
        return this.alarmsPref.getBoolean("first_exam_unlocked_screen_showed", false);
    }

    public final void v0(String str) {
        this.alarmsPref.edit().putString("app_device_id", str).apply();
    }

    /* renamed from: v1, reason: from kotlin metadata */
    public final void setRecommendedProgramFor(q2.a dogId, boolean programId) {
        n.f(dogId, "source");
        if (dogId != RateItService_RateSource.UNDEFINED) {
            str = "rated_app_V1_";
            this.alarmsPref.edit().putBoolean(n.o(str, dogId.getTag()), programId).apply();
        }
    }

    public final Integer w() {
        int i = 0;
        final int i2 = -1;
        int _int = this.g.getInt("first_open_build", i2);
        if (_int == i2) {
            i = 0;
        } else {
            Integer num = Integer.valueOf(_int);
        }
        return i;
    }

    public final void w0(boolean z) {
        this.alarmsPref.edit().putBoolean("authentication_screen_showed_in_dashboard", z).apply();
    }

    public final void w1(boolean z) {
        this.g.edit().putBoolean("rated_app_V1", z).apply();
    }

    public final String x() {
        return this.g.getString("first_open_campaign", null);
    }

    public final void x0(boolean z) {
        this.alarmsPref.edit().putBoolean("calendar_introduction_completed", z).apply();
    }

    /* renamed from: x1, reason: from kotlin metadata */
    public final void setUserRateSate(q2.a source, boolean rateState) {
        n.f(source, "source");
        if (source != RateItService_RateSource.UNDEFINED) {
            str = "shared_app_";
            this.alarmsPref.edit().putBoolean(n.o(str, source.getTag()), rateState).apply();
        }
    }

    public final String y() {
        return this.g.getString("first_open_medium", null);
    }

    /* renamed from: y0, reason: from kotlin metadata */
    public final void setUserShareSate(Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> source, String shareState) {
        n.f(shareState, "challengeId");
        SharedPreferences.Editor edit = this.c.edit();
        edit.putString(n.o("_filter_for_challenge_v2_", shareState), new Gson().toJson(source));
        edit.putBoolean(n.o("is_filter_fresh_for_challenge_v2_", shareState), false);
        edit.apply();
    }

    public final void y1(boolean z) {
        this.alarmsPref.edit().putBoolean("shared_app", z).apply();
    }

    public final boolean z() {
        return this.g.getBoolean("first_open_properties_saved", false);
    }

    public final void z0(boolean z) {
        this.alarmsPref.edit().putBoolean("clicker_introduction_completed", z).apply();
    }

    public final void z1() {
        this.alarmsPref.edit().putBoolean("was_redirected_to_reminders", true).apply();
    }

}
