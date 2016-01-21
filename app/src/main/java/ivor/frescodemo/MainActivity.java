package ivor.frescodemo;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends Activity {

    private SimpleDraweeView mPic1SDV;
    private SimpleDraweeView mPic2SDV;
    private SimpleDraweeView mPic3SDV;
    private SimpleDraweeView mPic4SDV;
    private SimpleDraweeView mPic5SDV;
    private SimpleDraweeView mPic6SDV;
    private SimpleDraweeView mPic7SDV;
    private SimpleDraweeView mPic8SDV;
    private SimpleDraweeView mPic9SDV;

    private String mIcon = "http://g.hiphotos.baidu.com/image/pic/item/eac4b74543a9822681e4b42e8d82b9014a90eb96.jpg";
    private String mGif  = "http://img.sc115.com/uploads/shows/140830/20140830549.jpg";

    private Uri uri;
    private PicHolding picHolding;

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
        this.mPic5SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic5_sdv);
        this.mPic6SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic6_sdv);
        this.mPic7SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic7_sdv);
        this.mPic8SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic8_sdv);
        this.mPic9SDV = (SimpleDraweeView) findViewById(R.id.ivor_pic9_sdv);

        this.uri = Uri.parse(mIcon);
        this.picHolding = new PicHolding();

        // 普通图片处理
        this.mPic1SDV.setImageURI(uri);
        this.mPic2SDV.setImageURI(uri);
        this.mPic3SDV.setImageURI(uri);

        // 动态图片处理
        picHolding.gifHolding(mGif, mPic4SDV);
        picHolding.gifHolding(mGif, mPic5SDV);
        picHolding.gifHolding(mGif, mPic6SDV);

        // 网格图片处理
        picHolding.gridHolding(uri, Color.RED, mPic7SDV);
        picHolding.gridHolding(uri, Color.BLACK, mPic8SDV);
        picHolding.gridHolding(uri, Color.BLUE, mPic9SDV);
    }
}
