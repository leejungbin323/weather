package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.firs:{
                        break;
                    }
                    case R.id.second:{
                        break;
                    }
                    case R.id.third:{
                        break;
                    }
                }
                return false;
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

                    final String w = doc.getElementsByTagName("data").item(0).getChildNodes().item(15).getChildNodes().item(0).getNodeValue();
                    final String t = doc.getElementsByTagName("data").item(0).getChildNodes().item(5).getChildNodes().item(0).getNodeValue();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            TextView weather = findViewById(R.id.weather);
                            weather.setText(w);
                            TextView temp = findViewById(R.id.tem);
                            temp.setText(t);
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