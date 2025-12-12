package com.thatgamerblue.runelite.plugins.rsnhider;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rsnhider")
public interface RsnHiderConfig extends Config
{
	@ConfigItem(
		name = "Hide in widgets (Lag warning)",
		keyName = "hideWidgets",
		description = "Hides your RSN everywhere. Might lag your game."
	)
	default boolean hideWidgets()
	{
		return false;
	}

	@ConfigItem(
		name = "Custom RSN",
		keyName = "customRsn",
		description = "Use a specific RSN instead of a random one. Leave empty to use a random name."
	)
	default String customRsn()
	{
		return "";
	}
}
