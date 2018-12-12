/**
 * 
 */
package com.hungit.util;

import com.github.slugify.Slugify;

/**
 * @author Kashiwagi
 *
 */
public final class SlugUtil {

	public static String slugStr(String slug) {

		Slugify slugify = new Slugify();

		return slugify.slugify(slug);

	}
}
