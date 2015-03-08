package com.android.Bai10;

import java.util.ArrayList;

import tranduythanh.com.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

public class Bai10_MainActivity extends Activity {

	ArrayList<Bai10_Model> arr = new ArrayList<Bai10_Model>();
	Bai10_MyArrayAdapter adapter = null;
	ListView lv = null;
	Button btnNhap;
	ImageButton btnRemoveAll;
	EditText editTen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bai10_activity_main);

		btnNhap = (Button) findViewById(R.id.btnNhap);
		btnRemoveAll = (ImageButton) findViewById(R.id.btndelete);
		editTen = (EditText) findViewById(R.id.editTen);

		lv = (ListView) findViewById(R.id.lvnhanvien);
		arr = new ArrayList<Bai10_Model>();
		// Khởi tạo đối tượng adapter và gán Data source
		adapter = new Bai10_MyArrayAdapter(this, R.layout.bai10_my_item_layout,// lấy
																				// custom
				// layout
				arr/* thiết lập data source */);
		lv.setAdapter(adapter);// gán Adapter vào Lisview

		btnNhap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				xulyNhap();
			}
		});
		btnRemoveAll.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				xulyXoa();
			}
		});
	}

	// gọi hàm xử lý nhập thông tin nhân viên

	public void xulyNhap() {
		String ten = editTen.getText() + "";
		// Tạo một employee
		Bai10_Model emp = new Bai10_Model();
		emp.setName(ten);
		// Đưa vào danh sách
		arr.add(emp);
		// gọi hàm cập nhật giao diện
		adapter.notifyDataSetChanged();
		// Sau khi update thì xóa trắng dữ liệu và cho editma focus
		editTen.setText("");
	}

	// hàm xử lý xóa
	public void xulyXoa() {

		// thì xóa đúng vị trí đó ra khỏi arrEmployee
		// for(int i=lvNhanvien.getChildCount()-1;i>=0;i--)
		for (int i = lv.getChildCount() - 1; i >= 0; i--) {

			arr.remove(i);
		}

		// Sau khi xóa xong thì gọi update giao diện
		adapter.notifyDataSetChanged();
	}
}
