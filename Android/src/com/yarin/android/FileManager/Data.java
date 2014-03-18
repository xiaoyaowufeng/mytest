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
            //如果手机插入了SD卡，而且应用程序具有访问SD的权限  
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))  
            {  
                //获取SD卡对应的存储目录  
                File sdCardDir = Environment.getExternalStorageDirectory();  
                //获取指定文件对应的输入流  
                FileInputStream fis = new FileInputStream(sdCardDir.getCanonicalPath()+"/" + fileName);  
                //将指定输入流包装成BufferedReader  
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
