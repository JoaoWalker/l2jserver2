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
package com.l2jserver.service.database.jdbc.derby;

import com.google.inject.Inject;
import com.l2jserver.model.dao.CharacterFriendDAO;
import com.l2jserver.model.id.object.provider.CharacterIDProvider;
import com.l2jserver.model.id.provider.FriendIDProvider;
import com.l2jserver.service.database.DatabaseService;
import com.l2jserver.service.database.jdbc.JDBCCharacterFriendDAO;

/**
 * {@link CharacterFriendDAO} implementation for MySQL5
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class DerbyCharacterFriendDAO extends JDBCCharacterFriendDAO implements
		CharacterFriendDAO {
	/**
	 * @param database
	 *            the database service
	 * @param idProvider
	 *            the frind id provider
	 * @param charIdProvider
	 *            the character id provider
	 */
	@Inject
	public DerbyCharacterFriendDAO(DatabaseService database,
			FriendIDProvider idProvider, CharacterIDProvider charIdProvider) {
		super(database, idProvider, charIdProvider);
	}
}