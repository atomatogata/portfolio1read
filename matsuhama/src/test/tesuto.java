package test;

import java.util.ArrayList;
import java.util.List;

import dao.SnowDAO2;
import model.SnowBean;

public class tesuto {

	public static void main(String[] args) {
		List<SnowBean> list = new ArrayList<>();
		SnowDAO2 snowDAO2 = new SnowDAO2();
		list = snowDAO2.findAll();

		System.out.println(list.size());

	}

}
