package datastruture.jaydenxiao.com.datastruture.seven;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import datastruture.jaydenxiao.com.datastruture.R;

import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.endCol;
import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.endRow;
import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.map;
import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.result;
import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.startCol;
import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.startRow;
import static datastruture.jaydenxiao.com.datastruture.seven.MapUtils.touchFlag;

public class MainActivity extends AppCompatActivity {

    ShowMapView showMapView;

    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        handler = new Handler(Looper.getMainLooper());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMapView = (ShowMapView) findViewById(R.id.show);
    }

    public void cal(View view) {
        MapInfo info = new MapInfo(map, map[0].length, map.length, new Node(startCol, startRow), new Node(endCol, endRow));
        Log.i("jett", "start=" + startRow + " " + startCol);
        Log.i("jett", "end=" + endRow + " " + endCol);
        new Astar().start(info);
        new MoveThread(showMapView).start();

    }

    public void reset(View view) {
        MapUtils.path = null;
        MapUtils.result.clear();
        touchFlag = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
        showMapView.invalidate();

    }

    class MoveThread extends Thread {
        ShowMapView showMapView;

        public MoveThread(ShowMapView showMapView) {
            this.showMapView = showMapView;
        }

        @Override
        public void run() {
            while (result.size() > 0) {
                Log.i("jett", result.size() + "");
                Node node = result.pop();
                map[node.coord.y][node.coord.x] = 2;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        showMapView.invalidate();
                    }
                });

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map[node.coord.y][node.coord.x] = 0;

            }
            MapUtils.touchFlag = 0;
        }
    }

}