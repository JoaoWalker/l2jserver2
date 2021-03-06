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
package com.l2jserver.model.world.player.event;

import com.l2jserver.model.world.Player;
import com.l2jserver.util.geometry.Point3D;

/**
 * Event dispatched once an player has completed its teleportation to another
 * location
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class PlayerTeleportedEvent extends PlayerSpawnEvent {
	/**
	 * Creates a new instance
	 * 
	 * @param player
	 *            the teleported player
	 * @param point
	 *            the teleport point
	 */
	public PlayerTeleportedEvent(Player player, Point3D point) {
		super(player, point);
	}
}
