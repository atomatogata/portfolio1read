package test;

import java.util.ArrayList;
import java.util.List;

import dao.SnowDAO2;
import model.SnowBean;

public class SnowDAOTest {

	public static void main(String[] args) {

		List<SnowBean> list = new ArrayList<>();
		SnowDAO2 snowDAO = new SnowDAO2();
		list = snowDAO.findAll();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getText());
		}

	}

}
