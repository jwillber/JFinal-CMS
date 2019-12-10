package com.cms.entity;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("cms_ad", "id", Ad.class);
		arp.addMapping("cms_ad_position", "id", AdPosition.class);
		arp.addMapping("cms_admin", "id", Admin.class);
		arp.addMapping("cms_category", "id", Category.class);
		arp.addMapping("cms_content", "id", Content.class);
		arp.addMapping("cms_friend_link", "id", FriendLink.class);
	}
}
