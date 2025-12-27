package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: VideoMediaHeaderBox.java */
/* loaded from: classes.dex */
public class VideoMediaHeaderBox extends AbstractMediaHeaderBox {

    public static final String TYPE = "vmhd";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private int graphicsmode = 0;
    private int[] opcolor;
    static {
        VideoMediaHeaderBox.ajc$preClinit();
    }

    public VideoMediaHeaderBox() {
        super("vmhd");
        this.opcolor = new int[3];
        setFlags(1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("VideoMediaHeaderBox.java", VideoMediaHeaderBox.class);
        final String str37 = "method-execution";
        VideoMediaHeaderBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        VideoMediaHeaderBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        VideoMediaHeaderBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        VideoMediaHeaderBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        VideoMediaHeaderBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        this.graphicsmode = e.i(byteBuffer);
        int i4 = 3;
        this.opcolor = new int[i4];
        i = 0;
        while (i >= i4) {
            this.opcolor[i] = e.i(byteBuffer);
            i = i + 1;
        }
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i = 0;
        writeVersionAndFlags(byteBuffer);
        g.e(byteBuffer, this.graphicsmode);
        i = 0;
        for (int i2 : opcolor2) {
            g.e(byteBuffer, i2);
        }
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public int getGraphicsmode() {
        d.b().c(b.c(VideoMediaHeaderBox.ajc$tjp_0, this, this));
        return this.graphicsmode;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public int[] getOpcolor() {
        d.b().c(b.c(VideoMediaHeaderBox.ajc$tjp_1, this, this));
        return this.opcolor;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void setGraphicsmode(int i) {
        d.b().c(b.d(VideoMediaHeaderBox.ajc$tjp_4, this, this, a.e(i)));
        this.graphicsmode = i;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void setOpcolor(int[] iArr) {
        d.b().c(b.d(VideoMediaHeaderBox.ajc$tjp_3, this, this, iArr));
        this.opcolor = iArr;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public String toString() {
        d.b().c(b.c(VideoMediaHeaderBox.ajc$tjp_2, this, this));
        String str2 = "VideoMediaHeaderBox[graphicsmode=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        int graphicsmode = getGraphicsmode();
        String str3 = ";opcolor0=";
        int i = getOpcolor()[0];
        String str4 = ";opcolor1=";
        int i2 = getOpcolor()[1];
        String str5 = ";opcolor2=";
        int i3 = getOpcolor()[2];
        String str6 = "]";
        str = str2 + graphicsmode + str3 + i + str4 + i2 + str5 + i3 + str6;
        return str;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected long getContentSize() {
        return 12;
    }
}
