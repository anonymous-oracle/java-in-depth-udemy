package thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import thrillio.managers.WebLinkManager;

//import org.junit.jupiter.api.Test;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		
//		Test 1 - Kid friendly eligible must return false for porn in url
		WebLink webLink = WebLinkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("for p*rn in url, isKidFriendlyEligible must return False", isKidFriendlyEligible);
		
//		Test 2 - Kid friendly eligible method must return true for porn not in url
		webLink = WebLinkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("for p*rn in url, isKidFriendlyEligible must return True", isKidFriendlyEligible);
		
		
//		Test 3 - for adult in hostname is kid friendly eligible method must return false
		webLink = WebLinkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/porn/taming-tiger--part-2.html",
				"http://www.adult.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("for p*rn in url, isKidFriendlyEligible must return True", isKidFriendlyEligible);
		
//      Test 4 - for adult not in hostname is kid friendly eligible method must return true
		
		webLink = WebLinkManager.getInstance().createWeblink(2000, "Taming Tiger Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("for p*rn in url, isKidFriendlyEligible must return True", isKidFriendlyEligible);
		
//		Test 5 - for adult in title only return true
		webLink = WebLinkManager.getInstance().createWeblink(2000, "Taming adult Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("for p*rn in url, isKidFriendlyEligible must return True", isKidFriendlyEligible);
	}

}
