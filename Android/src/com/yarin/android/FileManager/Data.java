package com.yarin.android.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class Data extends Activity{
	TextView text;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		text=(TextView) findViewById(R.id.textview);
		Intent intent=getIntent();
		//Bundle bundle=intent.getBundleExtra("path");
		String fileName=intent.getStringExtra("name");
		try  
        {  
            //����ֻ�������SD��������Ӧ�ó�����з���SD��Ȩ��  
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))  
            {  
                //��ȡSD����Ӧ�Ĵ洢Ŀ¼  
                File sdCardDir = Environment.getExternalStorageDirectory();  
                //��ȡָ���ļ���Ӧ��������  
                FileInputStream fis = new FileInputStream(sdCardDir.getCanonicalPath()+"/" + fileName);  
                //��ָ����������װ��BufferedReader  
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));  
                StringBuilder sb = new StringBuilder("");  
                String line = null;  
                while((line = br.readLine()) != null)  
                {  
                    sb.append(line);
                   
            		text.setText(line);
                    
                }  
                
            }  
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
		
	}
}
