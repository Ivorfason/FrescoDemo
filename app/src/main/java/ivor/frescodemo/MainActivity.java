package ivor.frescodemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends Activity {

    private SimpleDraweeView mPic1SDV;
    private SimpleDraweeView mPic2SDV;
    private SimpleDraweeView mPic3SDV;
    private SimpleDraweeView mPic4SDV;

    private String mIcon = "http://g.hiphotos.baidu.com/image/pic/item/eac4b74543a9822681e4b42e8d82b9014a90eb96.jpg";
    private String mGif= "http://imgsrc.baidu.com/forum/w%3D580/sign=792e812c564e9258a63486e6ac82d1d1/b912c8fcc3cec3fd8c0ece3dd688d43f87942741.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        this.mPic1SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic1_sdv);
        this.mPic2SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic2_sdv);
        this.mPic3SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic3_sdv);
        this.mPic4SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic4_sdv);

        Uri uri = Uri.parse(mIcon);
        this.mPic1SDV.setImageURI(uri);
        this.mPic2SDV.setImageURI(uri);
        this.mPic3SDV.setImageURI(uri);

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(mGif)
                .setAutoPlayAnimations(true)
                .build();
        this.mPic4SDV.setController(controller);
    }
}
