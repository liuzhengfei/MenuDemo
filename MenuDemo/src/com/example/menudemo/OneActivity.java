package com.example.menudemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class OneActivity extends Activity {
	private ListView lv;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.oneactivity);

		lv = (ListView) findViewById(R.id.lv);
		
		/* ����һ����̬���� */
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		/* �������д������ */
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("ItemImage", R.drawable.main_icon);// ����ͼƬ
			map.put("ItemText", "���ǵ�" + i + "��");
			listItem.add(map);
		}

		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,
				listItem,// ��Ҫ�󶨵�����
				R.layout.item,// ÿһ�еĲ���//��̬�����е�����Դ�ļ���Ӧ�����岼�ֵ�View��
				new String[] { "ItemImage", "ItemTitle", "ItemText" },
				new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });

		lv.setAdapter(mSimpleAdapter);// ΪListView��������
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				setTitle("�����˵�" + position + "��");// ���ñ�������ʾ�������

			}

		});
	}
}
