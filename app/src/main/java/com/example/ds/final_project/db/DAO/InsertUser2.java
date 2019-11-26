package com.example.ds.final_project.db.DAO;
<<<<<<< HEAD:app/src/main/java/com/example/ds/final_project/db/DAO/InsertUser2.java
=======

>>>>>>> b317f109561d4b6399168eb57e2551c10288e2cd:app/src/main/java/com/example/ds/final_project/db/DAO/InsertUser2.java

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

public class InsertUser2 extends AsyncTask<String, Void, String> {
    String LoadData;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub

        String uid = (String)params[0];
        String name = (String)params[1];
        String address = (String)params[2];
        String phoneNum = (String)params[3];

        try {
            HttpParams httpParameters = new BasicHttpParams();
            HttpProtocolParams.setVersion(httpParameters, HttpVersion.HTTP_1_1);

            HttpClient client = new DefaultHttpClient(httpParameters);

            HttpConnectionParams.setConnectionTimeout(httpParameters, 7000);
            HttpConnectionParams.setSoTimeout(httpParameters, 7000);
            HttpConnectionParams.setTcpNoDelay(httpParameters, true);

            // 주소 : aws서버
            String postURL = "http://52.78.143.125:8080/showme6/InsertUser";
            // 로컬서버
//            String postURL = "http://10.0.2.2:8080/showme/InsertUser";

            HttpPost post = new HttpPost(postURL);
            //서버에 보낼 파라미터
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            //파라미터 추가하기
            postParameters.add(new BasicNameValuePair("uid", uid));
            postParameters.add(new BasicNameValuePair("name", name));
            postParameters.add(new BasicNameValuePair("address", address));
            postParameters.add(new BasicNameValuePair("phoneNum", phoneNum));


            //파라미터 보내기
            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(postParameters, HTTP.UTF_8);
            post.setEntity(ent);

            long startTime = System.currentTimeMillis();

            HttpResponse responsePOST = client.execute(post);

            long elapsedTime = System.currentTimeMillis() - startTime;
            Log.v("debugging", elapsedTime + " ");


            HttpEntity resEntity = responsePOST.getEntity();
            if (resEntity != null) {
                LoadData = EntityUtils.toString(resEntity, HTTP.UTF_8);
                System.out.println(LoadData);
            }
            if(responsePOST.getStatusLine().getStatusCode()==200){
                System.out.println("오류없음");
            }
            else{
                System.out.println("오류");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
    }
}


