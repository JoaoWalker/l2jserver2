/*
 * This file is part of l2jserver2 <l2jserver2.com>.
 *
 * l2jserver2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * l2jserver2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with l2jserver2.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.game.net.packet.client;

import org.jboss.netty.buffer.ChannelBuffer;

import com.google.inject.Inject;
import com.l2jserver.model.id.object.ItemID;
import com.l2jserver.model.id.object.provider.ItemIDProvider;
import com.l2jserver.model.world.Item;
import com.l2jserver.service.game.character.CharacterInventoryItemDoesNotExistException;
import com.l2jserver.service.game.item.ItemService;
import com.l2jserver.service.game.item.NonStackableItemsServiceException;
import com.l2jserver.service.game.item.NotEnoughItemsServiceException;
import com.l2jserver.service.network.model.Lineage2Client;
import com.l2jserver.service.network.model.SystemMessage;
import com.l2jserver.service.network.model.packet.AbstractClientPacket;

/**
 * This packet drops items on the ground.
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class CM_ITEM_DESTROY extends AbstractClientPacket {
	/**
	 * The packet OPCODE
	 */
	public static final int OPCODE = 0x60;

	/**
	 * The {@link ItemService}
	 */
	private final ItemService itemService;
	/**
	 * The {@link ItemID} provider
	 */
	private final ItemIDProvider itemIdProvider;

	/**
	 * The item ID
	 */
	private int objectId;
	/**
	 * The number of items to be dropped
	 */
	private long count;

	/**
	 * @param itemService
	 *            the item service
	 * @param itemIdProvider
	 *            the item id provider
	 */
	@Inject
	public CM_ITEM_DESTROY(ItemService itemService,
			ItemIDProvider itemIdProvider) {
		this.itemService = itemService;
		this.itemIdProvider = itemIdProvider;
	}

	@Override
	public void read(Lineage2Client conn, ChannelBuffer buffer) {
		objectId = buffer.readInt();
		count = buffer.readLong();
	}

	@Override
	public void process(final Lineage2Client conn) {
		final ItemID id = itemIdProvider.resolveID(objectId);
		final Item item = id.getObject();

		if (item == null) {
			conn.sendActionFailed();
			return;
		}
		if (!conn.getCharacterID().equals(item.getOwnerID())) {
			conn.sendActionFailed();
			return;
		}

		try {
			if (itemService.destroy(item, count)) {
				conn.removeInventoryItems(item);
			} else {
				conn.updateInventoryItems(item);
			}
		} catch (NotEnoughItemsServiceException
				| NonStackableItemsServiceException
				| CharacterInventoryItemDoesNotExistException e) {
			conn.sendSystemMessage(SystemMessage.CANNOT_DISCARD_THIS_ITEM);
		}
	}
}
