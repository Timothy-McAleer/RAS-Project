package timothymcaleer.videotest;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button clk;
    VideoView videov;
    MediaController mediaC;
    int time0 = 0;
    int time1 = 4000;
    int time2 = 13000;
    int time3 = 18000;
    int time4 = 22000;
    int time5 = 29000;
    int time6 = 33000;

    int startTime = time3;
    int endTime = time4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clk = (Button) findViewById(R.id.button);
        videov = (VideoView) findViewById(R.id.videoView);
        mediaC = new MediaController(this);

    }

    public void videoplay(View v) {
        String videopath = "android.resource://timothymcaleer.videotest/" + R.raw.walkdog_all;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.seekTo(startTime);//6 seconds...
        videov.start();

        videov.postDelayed(new Runnable() {

            @Override
            public void run() {
                videov.pause();

            }
        }, (endTime - startTime));

    }
}
