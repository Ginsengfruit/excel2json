package com.sinocr.dd.excel2json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONObject;

/**
 * no use
 *
 */
@Deprecated
public class Bean2JsonTest {

	@Test
	public void testBean2Json() {
		Mybean bean = new Mybean();
		bean.setId("001");
		bean.setName("银行卡");
		bean.setDate(new Date());

		ArrayList<String> cardNum = new ArrayList<String>();
		cardNum.add("农行");
		cardNum.add("工行");
		cardNum.add("建行");
		bean.setCardNum(cardNum);
		JSONObject jsonObject = JSONObject.fromObject(bean);
		System.out.println(jsonObject);
	}

	public class Mybean {
		private String id;
		private String name;
		private Date date;
		private List<String> cardNum;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public List<String> getCardNum() {
			return cardNum;
		}

		public void setCardNum(List<String> cardNum) {
			this.cardNum = cardNum;
		}
	}
}

