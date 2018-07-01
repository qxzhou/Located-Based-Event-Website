package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {
	

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");

//		Item one = new ItemBuilder().setItemId("one").setLatitude(33.33).setRating(5).setCategories(category).setLongitude(33.33).build();
//		Item two = new ItemBuilder().setItemId("two").setLatitude(33.33).setRating(5).setCategories(category).setLongitude(33.33).build();
		
		List<Item> listItem = new ArrayList<Item>();
		
		Item.ItemBuilder builder = new Item.ItemBuilder();
		builder.setItemId("one");
		builder.setRating(5);
		builder.setCategories(category);
		Item one = builder.build();
		
		builder.setItemId("two");
		builder.setRating(5);
		builder.setCategories(category);
		Item two = builder.build();
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());

		listItem.add(one);
		listItem.add(two);

		
		
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
}

