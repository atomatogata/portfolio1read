package test;

import java.util.ArrayList;
import java.util.List;

import dao.SnowDAO2;
import model.SnowBean;

public class SnowDAOTest {

	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		List<SnowBean> list = new ArrayList<>();
		SnowDAO2 snowDAO = new SnowDAO2();
		list = snowDAO.findAll();

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getText());
		}
	}

	public static void test2() {

		SnowDAO2 snowDAO2 = new SnowDAO2();
		snowDAO2.insert("korede", "OK");

	}

}
