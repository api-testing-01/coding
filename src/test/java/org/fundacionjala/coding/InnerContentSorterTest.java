package org.fundacionjala.coding;

import org.junit.Assert;
import org.junit.Test;

public class InnerContentSorterTest {

	@Test
	public void testSortInnerContent() {
		InnerContentSorter sorter = new InnerContentSorter();
		String sortedPhrase = sorter.sortInnerContent("sort the inner content in descending order");
		Assert.assertTrue(sortedPhrase.equals("srot the inner ctonnet in dsnnieedcg oredr"));
	}
}
