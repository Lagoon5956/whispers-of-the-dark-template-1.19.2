package net.lagoon.wod;

import net.fabricmc.api.ModInitializer;

import net.lagoon.wod.block.Modblocks;
import net.lagoon.wod.item.Moditems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhispersOfTheDark implements ModInitializer {
	public static final String MOD_ID = "whisp-d";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		Moditems.registerModItems();
		Modblocks.registerModblocks();
	}
}