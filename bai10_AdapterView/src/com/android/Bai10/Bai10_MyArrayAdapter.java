package com.android.Bai10;

import java.util.ArrayList;

import tranduythanh.com.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai10_MyArrayAdapter extends ArrayAdapter<Bai10_Model> {
	Activity context = null;
	ArrayList<Bai10_Model> myArray = null;
	int layoutId;

	/*
	 * Constructor này dùng để khởi tạo các giá trị từ MainActivity truyền vào
	 * context : là Activity từ Main layoutId: Là layout custom do ta tạo
	 * (my_item_layout.xml) arr : Danh sách truyền từ Main
	 */
	public Bai10_MyArrayAdapter(Activity context, int layoutId,
			ArrayList<Bai10_Model> arr) {
		super(context, layoutId, arr);
		this.context = context;
		this.layoutId = layoutId;
		this.myArray = arr;
	}

	/*
	 * hàm dùng để custom layout, ta phải override lại hàm này từ MainActivity
	 * truyền vào position : là vị trí của phần tử trong danh sách convertView:
	 * convertView, dùng nó để xử lý Item parent : Danh sách truyền từ Main
	 * View: trả về chính convertView
	 */
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = context.getLayoutInflater();
		convertView = inflater.inflate(layoutId, null);
		// chỉ là test thôi, bạn có thể bỏ If đi
		if (myArray.size() > 0 && position >= 0) {
			// dòng lệnh lấy TextView ra để hiển thị tên lên
			final TextView txtdisplay = (TextView) convertView
					.findViewById(R.id.txtitem);
			// lấy ra dong thứ position
			final Bai10_Model emp = myArray.get(position);
			// đưa thông tin lên TextView
			// emp.toString() sẽ trả Name
			txtdisplay.setText(emp.toString());

		}
		// Vì View là Object là dạng tham chiếu đối tượng, nên
		// mọi sự thay đổi của các object bên trong convertView
		// thì nó cũng biết sự thay đổi đó
		return convertView;// trả về View này, tức là trả luôn
							// về các thông số mới mà ta vừa thay đổi
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myArray.size();
	}
}
