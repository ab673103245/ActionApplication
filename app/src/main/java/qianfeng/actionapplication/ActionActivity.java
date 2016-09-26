package qianfeng.actionapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class ActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
    }

    public void onClick(View view) {

        //处理Action
        Intent intent = new Intent("MusicPlay"); // 隐式指定Activity，这个intent跳转是根据指定的Action的名称来跳转,
                                                    // 如果是多个的话，那就在安卓手机选项那里显示让你选择
        intent.addCategory("MusicPlay1"); // 应用程序的配置清单文件中，可以有多个category
        startActivity(intent);
    }

    public void call(View view) {  // 打电话
        // setData(Uri uri);  可以用 Uri.parse("参数"); 这个方法来指定协议，来调用哪个面板
        // 一开始Action要指定，指定什么？隐式启动，并且关键字为 ACTION_VIEW
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:15989178459"));
        startActivity(intent);
    }

    public void sendMsgTo(View view) {  // 发短信
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("smsto:18565559900"));
        startActivity(intent);
    }

    public void mailTo(View view) { // 发邮件
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailTo:673103245@qq.com"));
        startActivity(intent);
    }

    public void searchMusic(View view) {  // 寻找本机的音乐文件
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"白鸽.mp3")));
        //
        //intent.setData(Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"隐形的翅膀.mp3")));
      //  intent.setData(Uri.fromFile("/storage/emulated/0/download/白鸽.mp3"));
        intent.setData(Uri.parse("")); // 有一个关键字是打开 音乐的协议的，再用  music///:/storage/emulated/0/download/白鸽.mp3
        startActivity(intent);
    }

    public void openWeb(View view) {// 打开网页
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void geo(View view) { // 使用地图
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:34.26667,108.95000"));
        startActivity(intent);
    }

    public void listener(View view) {  // setDataAndType
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"隐形的翅膀.mp3")),"audio/mp3");
        startActivity(intent);
       
    }
}
