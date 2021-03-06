package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.WebViewFragment;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    FragmentManager fm = getSupportFragmentManager();
    Temp temp=new Temp();
    Weather weather=new Weather();
    Wind wind=new Wind();
    static String w, tem, W;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Fragment, weather).commitAllowingStateLoss();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fm.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.firs: {
                        transaction.replace(R.id.Fragment, weather).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.second: {
                        transaction.replace(R.id.Fragment, temp).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.third: {
                        transaction.replace(R.id.Fragment, wind).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {


                try {

                    Document doc;
                    URL url = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1117055500");
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = null;
                    documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    doc = documentBuilder.parse(new InputSource(url.openStream()));
                    doc.getDocumentElement().normalize();

                    System.out.println("== log ==");
                    System.out.println(doc.getElementsByTagName("data").item(0).getChildNodes().item(15).getChildNodes().item(0).getNodeValue());

                    w = doc.getElementsByTagName("data").item(0).getChildNodes().item(15).getChildNodes().item(0).getNodeValue();
                    tem = doc.getElementsByTagName("data").item(0).getChildNodes().item(5).getChildNodes().item(0).getNodeValue();
                    W = doc.getElementsByTagName("data").item(0).getChildNodes().item(29).getChildNodes().item(0).getNodeValue();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

//                            TextView weather = findViewById(R.id.w);
//                            weather.setText(w);
//                            TextView tem = findViewById(R.id.t);
//                            tem.setText("12");
//                            TextView wind = findViewById(R.id.W);
//                            wind.setText(W);
                        }
                    });
                } catch (ParserConfigurationException | IOException | SAXException e) {
                    e.printStackTrace();
                }

            }
        });

        t.start();

    }
}






